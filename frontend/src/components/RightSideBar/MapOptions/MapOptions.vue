<template>
  <div id="content">
    <div id="tab-label">
      <q-icon class="q-mr-sm" size="md" name="settings"> </q-icon>
      <label>Map Options</label>
      <q-btn flat icon="close" size="lg" @click="close" />
    </div>
    <div id="tab-content">
      <div class="row">
        <q-card class="map-card bg-primary text-white" flat square>
          <q-card-section>
            <div class="row">
              <div class="text-h6">Base Maps</div>
              <!-- <MapList /> -->
            </div>
          </q-card-section>
        </q-card>

        <q-card class="map-card bg-primary text-white" flat square>
          <q-card-section>
            <div class="row">
              <div class="text-h6">Map Overlays</div>
              <!-- <MapOverlayList /> -->
            </div>
          </q-card-section>
        </q-card>
        <q-card class="map-card bg-primary text-white" flat square>
          <q-card-section>
            <div class="row">
              <div class="text-h6">Aircraft Settings</div>
              <!-- <AircraftSettings /> -->
            </div>
          </q-card-section>
        </q-card>
      </div>
    </div>
    <br />
    <br />
  </div>
</template>

<script>
// import MapList from "./MapOptions/MapList.vue";
// import MapOverlayList from "./MapOptions/MapOverlayList.vue";
// import AircraftSettings from "./MapOptions/AircraftSettings.vue";
export default {
  components: {
    // MapList,
    // MapOverlayList,
    // AircraftSettings,
  },
  setup(props, { emit }) {
    const mapStyles = [];
    const close = () => {
      emit("closeTest");
    };

    return {
      close,
    };
  },
};
</script>

<style lang="scss" scoped>
.tabs {
  background-color: aqua;
}

#content > #tab-label > label {
  flex: 1 1 0%;
  font-family: KelsonBold, "Arial Black", sans-serif;
  text-transform: uppercase;
  white-space: nowrap;
}

#tab-content {
  height: 100%;
  background-color: $primary;
}

.map-card {
  width: 100%;
}
</style>
