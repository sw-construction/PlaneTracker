<template>
  <div id="content">
    <div id="tab-label">
      <q-icon class="q-mr-sm" size="md" name="settings"> </q-icon>
      <label>Aircraft Table</label>
      <q-btn flat icon="close" size="lg" @click="close" />
    </div>
    <div id="tab-content">
            <q-table
                            title="Aircrafts"
                            :data="planes"
                            :columns="columns"
                            row-key="name"
                            hide-bottom
                            dark
                    >
                    </q-table>
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
    return {
      close,
    };
  },
  data () {
    return {
      columns: [
        { name: 'airline', required: true, label: 'Airline', align: 'center', field: row => planes.hex, sortable: false },
        { name: 'fn', required: true, label: 'FN', align: 'left', field: row => row.aircraftInfo.callsign, sortable: false },
        { name: 'reg', required: true, label: 'Reg', align: 'left', field: row => row.aircraftInfo.registration, sortable: false },
        { name: 'type', required: true, label: 'Type', align: 'left', field: row => row.aircraftInfo.type, sortable: false },
        { name: 'speed', required: true, label: 'Speed', align: 'left', field: row => row.flight.ground_speed, sortable: false },
        { name: 'alt', required: true, label: 'Alt', align: 'left', field: row => row.flight.geometric_alt, sortable: false },
      ],
    }
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
