<template>
  <div class="leftsidebar-container">
    <div class="left-sidebar">
      <AircraftPanel
        v-if="planeStore.state.showAircraftPanel"
        :aircraft="planeStore.state.aircraft"
      />
    </div>
  </div>
</template>

<script>
import { inject, ref, onMounted, computed } from "vue";
import AircraftPanel from "./Panels/AircraftPanel.vue";
import planeStore from "src/planeStore";

export default {
  components: {
    AircraftPanel,
  },
  setup() {
    return {
      planeStore,
    };
  },
};
</script>
<style lang="scss">
.left-sidebar {
  position: absolute;
  z-index: 2;
  overflow: auto;
  height: 100%;
}
</style>
