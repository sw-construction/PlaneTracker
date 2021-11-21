import { reactive } from "vue";
const state = reactive({
  aircraft: null,
  planes: null,
  showAircraftPanel: false,
});

export default {
  state,
};
