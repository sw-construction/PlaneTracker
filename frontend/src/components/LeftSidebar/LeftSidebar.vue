<template>
  <div class="leftsidebar-container">
    <div class="left-sidebar">
      <AircraftPanel/>
    </div>
  </div>
</template>

<script>
import { inject, ref, onMounted, computed } from "vue";
import AircraftPanel from "./Panels/AircraftPanel.vue";
import { useStore } from "vuex";

export default {
   components: {
     AircraftPanel,
   },
  setup() {

    return {
    };
  },
};
</script>
<style lang="scss">
.left-sidebar {
  position: absolute;
  z-index: 2;
}
</style>
