<template>
  <div
    class="hover-info-panel"
    id="smallInfoBox"
    :style="{ top: posStyle.top + 'px', left: posStyle.left + 'px' }"
  >
    <v-card class="hover-info-card bg-primary">
      <v-card-section>
        <div class="q-pa-sm">
          <div class="text-h6">
            {{ aircraft.aircraftInfo.callsign }}
          </div>
          <div>
            {{ aircraft.aircraftInfo.icao }}
          </div>
          <q-separator color="accent" />
          <div class="text-subtitle1">
            Reg:
            <label> N/A </label>
          </div>
          <div class="text-subtitle1">
            Altitude:
            <label> N/A </label>
          </div>
          <div class="text-subtitle1">
            Speed:
            <label> N/A </label>
          </div>
          <div class="text-subtitle1">
            Source:
            <label> N/A </label>
          </div>
          <div class="text-subtitle1">
            lastSeen:
            <label> {{ aircraft.lastSeen }} </label>
          </div>
        </div>
      </v-card-section>
    </v-card>
  </div>
</template>

<script>
export default {
  props: {
    aircraft: Object,
    posStyle: Object,
  },
  setup() {
    return {};
  },
};
</script>

<style lang="scss" scoped>
.hover-info-card {
  width: 300px;
  background-color: $primary;
}
.hover-info-panel {
  position: absolute;
  z-index: 5;
}

#smallInfoBox {
  position: absolute;
  z-index: 5;
  cursor: pointer;
  border-radius: 0rem;
  padding: 0%;
  background-color: $primary;
  width: 10rem;
  color: #efeff4;
}
</style>
