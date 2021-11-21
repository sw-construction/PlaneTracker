import { reactive } from "vue";
const state = reactive({
  aircraft: null,
  planes: null,
  showAircraftPanel: false,
  selectedAircraft: [],
});

export default {
  state,
};
