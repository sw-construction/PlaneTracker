import planeStore from "src/planeStore";

<template>
  <div id="content">
    <div id="tab-label">
      <q-icon class="q-mr-sm" size="md" name="settings"> </q-icon>
      <label>Aircraft Table</label>
      <q-btn flat icon="close" size="lg" @click="close" />
    </div>
    <div id="tab-content">
    <q-table
            class="my-sticky-header-table"
                      title="Aircrafts"
                      :rows="planeStore.state.planes"
                      :columns="columns"
                      row-key="icao"
                      virtual-scroll
                      v-model:pagination="pagination"
                      :rows-per-page-options="[0]"
                      dark
                      dense
          />
    </div>
    <br />
    <br />
  </div>
</template>

<script>
import planeStore from "src/planeStore";
export default {
  components: {},
  setup(props, { emit }) {
    const mapStyles = [];
    const close = () => {
      emit("closeTest");
    };
    const columns = [
                            { name: 'fn', required: true, label: 'Flight Name', align: 'left', field: row => row.aircraftInfo.callsign, sortable: false },
                            { name: 'icao', required: true, label: 'ICAO', align: 'left', field: row => row.aircraftInfo.icao, sortable: false },
                            { name: 'type', required: true, label: 'Type', align: 'left', field: row => row.aircraftInfo.type, sortable: false },
                            { name: 'speed', required: true, label: 'Speed', align: 'left', field: row => row.flight.ground_speed, sortable: false },
                            { name: 'alt', required: true, label: 'Alt', align: 'left', field: row => row.flight.geometric_alt, sortable: false },
                          ];
    return {
      columns,
      planeStore,
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

<style lang="sass">
.my-sticky-header-table
  height: 870px

  .q-table__top,
  .q-table__bottom,
  thead tr:first-child th
    background-color: #000

  thead tr th
    position: sticky
    z-index: 1
  thead tr:first-child th
    top: 0

  &.q-table--loading thead tr:last-child th
    top: 48px
</style>
