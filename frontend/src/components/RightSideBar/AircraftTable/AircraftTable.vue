<template>
  <div id="content">
    <div id="tab-label">
      <q-icon class="q-mr-sm" size="md" name="settings"> </q-icon>
      <label>Aircraft Table</label>
      <q-btn flat icon="close" size="lg" @click="close" />
    </div>
    <div id="tab-content ">
      <q-table
        square
        class="my-sticky-header-table aircraft-table"
        title="Aircrafts"
        :rows="planeStore.state.planes"
        :columns="columns"
        row-key="hex"
        selection="single"
        v-model:selected="selected"
        virtual-scroll
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
import { ref } from "vue";
export default {
  components: {},
  setup(props, { emit }) {
    const onAircraftSelect = () => {};
    let selected = ref([]);
    const close = () => {
      emit("closeTest");
    };
    const columns = [
      {
        name: "fn",
        required: true,
        label: "Flight Name",
        align: "left",
        field: (row) => row.aircraftInfo.callsign,
        sortable: false,
      },
      {
        name: "icao",
        required: true,
        label: "ICAO",
        align: "left",
        field: (row) => row.aircraftInfo.icao,
        sortable: false,
      },
      {
        name: "type",
        required: true,
        label: "Type",
        align: "left",
        field: (row) => row.aircraftInfo.type,
        sortable: false,
      },
      {
        name: "speed",
        required: true,
        label: "Speed",
        align: "left",
        field: (row) => row.flight.ground_speed,
        sortable: false,
      },
      {
        name: "alt",
        required: true,
        label: "Alt",
        align: "left",
        field: (row) => row.flight.geometric_alt,
        sortable: false,
      },
    ];
    return {
      columns,
      planeStore,
      close,
      selected,
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

#tab-label {
  background-color: $primary;
  color: white;
}
#tab-content {
  height: 100%;
  background-color: $primary;
}

.map-card {
  width: 100%;
}
</style>

<style lang="sass">


.my-sticky-header-table
  height:  100%


  background-color: $primary

  tbody tr
    &:hover
      background-color: $accent

  thead tr th
    position: sticky
    z-index: 1
  thead tr:first-child th
    top: 0

  &.q-table--loading thead tr:last-child th
    top: 48px
</style>
