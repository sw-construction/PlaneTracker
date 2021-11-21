<template>
  <div
    class="hover-info-panel"
    id="smallInfoBox"
    :style="{ top: posStyle.top + 'px', left: posStyle.left + 'px' }"
  >
    <q-card class="hover-info-card bg-primary">
      <q-card-section>
        <div class="">
          <div class="text-h6">
            {{ aircraft.aircraftInfo.callsign }}
          </div>
          <div>
            {{ aircraft.aircraftInfo.icao }}
          </div>
          <q-separator color="accent" />
          <div v-if="aircraft.aircraftData" class="text-subtitle1">
            Reg:
            <label> {{ aircraft.aircraftData.registrationNumber }} </label>
          </div>
          <div v-else class="text-subtitle1">
            Reg:
            <label> N/A </label>
          </div>
          <div class="text-subtitle1">
            Altitude:
            <label> {{ aircraft.position.alt }} </label>
          </div>
          <div class="text-subtitle1">
            Speed:
            <label> {{ aircraft.flight.ground_speed }} knt (s) </label>
          </div>
          <div class="text-subtitle1">
            Source:
            <label> {{ aircraft.aircraftInfo.type }} </label>
          </div>
          <div class="text-subtitle1">
            lastSeen:
            <label> {{ aircraft.lastSeen }} </label>
          </div>
        </div>
      </q-card-section>
    </q-card>
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
