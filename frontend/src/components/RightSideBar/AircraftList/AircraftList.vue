<template>
  <div id="content">
    <div id="tab-label">
      <q-icon class="q-mr-sm" size="md" name="settings"> </q-icon>
      <label>Aircraft Feed</label>
      <q-btn flat icon="close" size="lg" @click="close" />
    </div>
    <div id="tab-content">
      <div class="row">
        <q-card class="map-card bg-primary text-white" flat square>
          <div class="row">
            <div class="col">
              <FeedCard
                v-for="(aircraft, index) in planeStore.state.planes"
                :key="index"
                v-bind="aircraft"
              />
            </div>
          </div>
        </q-card>
      </div>
    </div>
    <br />
    <br />
  </div>
</template>

<script>
import FeedCard from "./FeedCard.vue";
import planeStore from "src/planeStore";
import { ref } from "vue";
export default {
  components: {
    FeedCard,
  },
  setup(props, { emit }) {
    const mapStyles = [];
    const close = () => {
      emit("closeTest");
    };

    return {
      planeStore,
      close,
    };
  },
};
</script>

<style lang="scss" scoped>
.tabs {
  background-color: $primary;
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
  overflow-y: auto;
}

.map-card {
  width: 100%;
}
</style>
