import { planeSource } from "src/boot/ol";
import { api } from "boot/axios";
import { ref } from "vue";
import Aircraft from "../model/aircraft";
import planeStore from "../planeStore";
// reactive array
let planes = ref([]);

// this method requests all planes from the backend
// using axios
export const fetchPlanes = async () => {
  await api
    .get("/aircrafts")
    .then((response) => {
      processData(response.data);
    })
    .catch((err) => {
      console.log(err);
      // display an error on map
      // failed to fetch data
      console.log("failed to fetch data");
    });
};

const removeOldPlanes = (aircraftList) => {
  for (let i = 0; i < planes.value.length; i++) {
    if (!aircraftList.includes(planes.value[i].hex)) {
      planeSource.removeFeature(planes.value[i].feature);

      const index = planes.value.indexOf(planes.value[i], 0);
      if (index > -1) {
        planes.value.splice(index, 1);
      }
    }
  }
};

const processData = async (aircrafts) => {
  for (let i = 0; i < aircrafts.length; i++) {
    let hex = aircrafts[i].hex;

    let aircraft = getPlaneFromPlanes(hex);

    if (!aircraft) {
      let ac = aircrafts[i];
      aircraft = Object.assign(new Aircraft(), ac);
      aircraft.createFeature();
      // aircraft.getAircraftPhoto();
      // aircraft.getAircraftReg();
      await aircraft.createTrail();

      planes.value.push(aircraft);
    }

    if (aircraft) {
      aircraft.updateAircraft(aircrafts[i]);
      // we will update trail here
      aircraft.updateTrail();

      // updates it position
      aircraft.updateFeature();
    }
  }
  let aircraftHex = [];
  for (let i = 0; i < aircrafts.length; i++) {
    aircraftHex.push(aircrafts[i].hex);
  }

  removeOldPlanes(aircraftHex);
  planeStore.state.planes = planes.value;
};

export const getPlaneFromPlanes = (hex) => {
  return planes.value.find((plane) => plane && plane.hex == hex);
};
