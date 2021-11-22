import { createFeature, createIcon } from "../utils/featureCreator";
import { createTrail } from "../utils/trailCreator";
import { planeSource, trailSource } from "src/boot/ol";

import axios, { api } from "src/boot/axios";

import Point from "ol/geom/Point";
import * as olProj from "ol/proj";

export default class Aircraft {
  constructor(hex, lastSeen, position, flight, aircraftInfo) {
    this.hex = hex;
    this.lastSeen = lastSeen;
    this.position = position;
    this.flight = flight;
    this.aircraftInfo = aircraftInfo;
  }
  selected = null;
  feature = null;
  trail = null;
  photo = {
    photo_url: require("../assets/plane_image_holder.jpg"),
  };

  aircraftData = null;

  createFeature() {
    this.feature = createFeature(this);
    planeSource.addFeature(this.feature);
  }

  async createTrail() {
    await api
      .get("/aircrafts/aircraft/trail", {
        params: {
          icao: this.hex,
        },
      })
      .then((response) => {
        this.trail = createTrail(response.data);

        trailSource.addFeature(this.trail);
      });
  }

  updateFeature() {
    let style = createIcon(
      this.aircraftInfo.category,
      this.aircraftInfo.type,
      this.flight.track,
      this.position.alt
    );

    this.feature.setStyle(style);

    this.feature.setGeometry(
      new Point(olProj.fromLonLat([this.position.lon, this.position.lat]))
    );
  }

  updateTrail() {
    let nextCoord = olProj.fromLonLat([this.position.lon, this.position.lat]);
    if (this.trail) {
      this.trail.getGeometry().appendCoordinate(nextCoord);
    }
  }

  toggleTrail() {
    if (this.trail) {
      if (this.selected) {
        console.log("dsa");
        this.trail.visible = true;
      } else {
        this.trail.visible = false;
      }
    }
  }

  async getAircraftPhoto() {
    await api
      .get("/aircrafts/aircraft/photo", {
        params: {
          icao: this.hex,
        },
      })
      .then((response) => {
        let photo = response.data;
        if (
          photo.photo_url != undefined &&
          photo.photo_url != "No Photos found" &&
          photo.photo_url != "error"
        ) {
          this.photo = photo;
        } else {
          this.photo = {
            photo_url: require("../assets/plane_image_holder.jpg"),
          };
        }
      });
  }

  async getAircraftReg() {
    await api
      .get("/aircrafts/aircraft/reg", {
        params: {
          icao: this.hex,
        },
      })
      .then((response) => {
        let aircraftData = response.data;
        if (aircraftData.registrationNumber) {
          this.aircraftData = aircraftData;
        } else {
          this.aircraftData = null;
        }
      });
  }

  updateAircraft(aircraft) {
    this.hex = aircraft.hex;
    this.lastSeen = aircraft.lastSeen;
    this.position = aircraft.position;
    this.flight = aircraft.flight;
    this.aircraftInfo = aircraft.aircraftInfo;
  }

  //   removeOldFeauture()
}
