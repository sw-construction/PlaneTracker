import Select from "ol/interaction/Select";
import { click } from "ol/events/condition";
import { map } from "boot/ol";
import planeStore from "src/planeStore"
import { getPlaneFromPlanes } from "../service/planeService";

let select = null;
let selectedAC = null;

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
    if (selectedAC) {
      //   selectedAC.setTrailVisible(false);
      //   selectedAC = null;
    }
    let hex = e.selected[0]?.hex;

    if (hex) {
      // TODO: add handlers to open panel
      let aircraft = getPlaneFromPlanes(hex);
      planeStore.state.aircraft = aircraft;
      console.log(aircraft)
      planeStore.state.showAircraftPanel = true;
    }
    else {
      planeStore.state.showAircraftPanel = false;
    }
  });
};
