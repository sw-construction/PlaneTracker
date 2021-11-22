import Select from "ol/interaction/Select";
import { click } from "ol/events/condition";
import { map } from "boot/ol";
import planeStore from "src/planeStore";
import { getPlaneFromPlanes } from "../service/planeService";
import * as olProj from "ol/proj";
let select = null;
let previousAircraft = null;

// map click select
const selectClick = new Select({
  condition: click,
  style: false,
});

export const addSelectClick = () => {
  select = selectClick;
  map.addInteraction(select);
  select.on("select", async function (e) {
    // this is for something else

    let hex = e.selected[0]?.hex;
    aircraftSelection(hex, false);
  });
};

export const aircraftSelection = (hex, fromTable) => {
  console.log(hex);
  if (hex) {
    // TODO: add handlers to open panel
    let aircraft = getPlaneFromPlanes(hex);
    // if (previousAircraft) {
    //   previousAircraft.toggleTrail();
    // } else {
    //   previousAircraft = aircraft;
    // }

    // aircraft.toggleTrail();
    planeStore.state.aircraft = aircraft;
    planeStore.state.selectedAircraft[0] = aircraft;
    console.log(aircraft);
    planeStore.state.showAircraftPanel = true;

    if (fromTable) {
      centerToMap([aircraft.position.lon, aircraft.position.lat]);
    }
  } else {
    planeStore.state.showAircraftPanel = false;
    planeStore.state.aircraft = null;
    // previousAircraft.toggleTrail();
    planeStore.state.selectedAircraft = [];
  }
};

const centerToMap = (coords) => {
  map.getView().setCenter(olProj.transform(coords, "EPSG:4326", "EPSG:3857"));
  map.getView().setZoom(15);
};
