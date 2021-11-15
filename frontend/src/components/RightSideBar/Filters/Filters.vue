<template>
  <div id="content">
    <div id="tab-label">
      <q-icon class="q-mr-sm" size="md" name="settings"> </q-icon>
      <label>Filter Aircrafts</label>
      <q-btn flat icon="close" size="lg" @click="close" />
    </div>
    <div id="tab-content">
      <div class="row">
        <q-card class="map-card bg-secondary text-white" flat square>
          <q-card-section>
            <div class="row">ADD YOUR STUFF HERE</div>
          </q-card-section>
        </q-card>
      </div>
    </div>
    <br />
    <br />
  </div>
</template>

<script>
export default {
  components: {},
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
  background-color: $secondary;
}

.map-card {
  width: 100%;
}
</style>
