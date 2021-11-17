import { createFeature, createIcon } from "../utils/featureCreator";
import { planeSource } from "src/boot/ol";
import { api } from "src/boot/axios";

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

  feature = null;

  createFeature() {
    this.feature = createFeature(this);
    planeSource.addFeature(this.feature);
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

  updateAircraft(aircraft) {
    this.hex = aircraft.hex;
    this.lastSeen = aircraft.lastSeen;
    this.position = aircraft.position;
    this.flight = aircraft.flight;
    this.aircraftInfo = aircraft.aircraftInfo;
  }

  //   removeOldFeauture()
}
