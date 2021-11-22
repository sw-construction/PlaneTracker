import { reactive } from "vue";
const state = reactive({
  aircraft: null,
  planes: null,
  showAircraftPanel: false,
  selectedAircraft: [],
  baseMaps: [],
  overlayerLayers: [],
  tracks: [],
});

export default {
  state,
};
