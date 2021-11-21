<template>
  <div>
    <div class="aicraft-panel">
      <q-card square class="gt-xs aircraft-card">
        <q-item class="aircraft-header">
          <q-item-section>
            <q-item-label class="text-h6" v-if="aircraft.hex">{{
              aircraft.hex
            }}</q-item-label>
            <q-item-label class="text-h6" v-else>N/A</q-item-label>
          </q-item-section>
          <q-card-actions>
            <q-btn flat round color="accent" icon="close" @click="close" />
          </q-card-actions>
        </q-item>
        <q-img width="360px" height="240px" :src="aircraft.photo.photo_url" />

        <q-item class="q-px-none q-pb-none">
          <q-item-section>
            <q-item-label class="text-center q-pb-xs">
              Aircraft Information
            </q-item-label>
            <div class="row data-row">
              <div class="col icon-col">
                <q-icon size="32px" class="las la-plane" />
              </div>
              <div class="col">
                <div class="col data-col">
                  <div class="text-h6">Aircraft Type</div>
                  <q-item-label
                    class="text-subtitle2"
                    v-if="aircraft.aircraftInfo.type"
                    >{{ aircraft.aircraftInfo.type }}</q-item-label
                  >
                  <q-item-label class="text-subtitle2" v-else>N/A</q-item-label>
                </div>
                <q-separator class="divider" size="4px" />
                <div class="col data-col">
                  <div class="text-h6">Registration</div>
                  <q-item-label
                    class="text-subtitle2"
                    v-if="aircraft.aircraftInfo.registration"
                    >{{ aircraft.aircraftInfo.registration }}</q-item-label
                  >
                  <q-item-label class="text-subtitle2" v-else>N/A</q-item-label>
                </div>
              </div>
            </div>
            <div class="row data-row">
              <div class="col icon-col">
                <q-icon size="32px" class="las la-plane-departure" />
              </div>
              <div class="col">
                <div class="col data-col">
                  <div class="text-h6">Altitude</div>
                  <q-item-label
                    class="text-subtitle2"
                    v-if="aircraft.position.alt"
                    >{{ aircraft.position.alt }} ft</q-item-label
                  >
                  <q-item-label class="text-subtitle2" v-else>N/A</q-item-label>
                </div>
                <q-separator class="divider" size="4px" />
                <div class="col data-col">
                  <div class="text-h6">Vertical Speed</div>
                  <q-item-label
                    class="text-subtitle2"
                    v-if="aircraft.flight.ground_speed"
                    >{{ aircraft.flight.ground_speed }}</q-item-label
                  >
                  <q-item-label class="text-subtitle2" v-else>N/A</q-item-label>
                </div>
                <q-separator class="divider" size="4px" />
                <div class="row">
                  <div class="col data-col">
                    <div class="text-h6">Lat</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.position.lat"
                      >{{ aircraft.position.lat }}</q-item-label
                    >
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                  <div class="col data-col">
                    <div class="text-h6">Lon</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.position.lon"
                      >{{ aircraft.position.lon }}</q-item-label
                    >
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                </div>
              </div>
            </div>
            <div class="row data-row">
              <div class="col icon-col">
                <q-icon size="32px" class="las la-tachometer-alt" />
              </div>
              <div class="col">
                <div class="col data-col">
                  <div class="text-h6">Airspeed</div>
                  <q-item-label
                    class="text-subtitle2"
                    v-if="aircraft.flight.ground_speed"
                    >{{ aircraft.flight.ground_speed }}</q-item-label
                  >
                  <q-item-label class="text-subtitle2" v-else>N/A</q-item-label>
                </div>
                <q-separator class="divider" size="4px" />
                <div class="col data-col">
                  <div class="text-h6">Groundspeed</div>
                  <q-item-label
                    class="text-subtitle2"
                    v-if="aircraft.flight.ground_speed"
                    >{{ aircraft.flight.ground_speed }}</q-item-label
                  >
                  <q-item-label class="text-subtitle2" v-else>N/A</q-item-label>
                </div>
              </div>
            </div>
          </q-item-section>
        </q-item>

        <!-- -------------------------------------------------- -->

        <q-item class="q-px-none q-pb-none">
          <q-item-section>
            <q-item-label class="text-center q-pb-xs">
              More Information
            </q-item-label>
            <div class="row data-row">
              <div class="col icon-col">
                <q-icon size="32px" class="las la-plane" />
              </div>
              <div class="col">
                <div class="row">
                  <div class="col data-col">
                    <div class="text-h6">Barometric Rate</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.flight.barometric_rate"
                      >{{ aircraft.flight.barometric_rate }}</q-item-label
                    >
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                  <div class="col data-col">
                    <div class="text-h6">Heading</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.flight.heading"
                      >{{ aircraft.flight.heading }} °
                    </q-item-label>
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                </div>
                <q-separator class="divider" size="4px" />
                <div class="row">
                  <div class="col data-col">
                    <div class="text-h6">Squawk</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.flight.squawk"
                      >{{ aircraft.flight.squawk }}</q-item-label
                    >
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                  <div class="col data-col">
                    <div class="text-h6">RSSI</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.flight.rssi"
                      >{{ aircraft.flight.rssi }}</q-item-label
                    >
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                </div>
                <!-- ----------------------- -->
                <q-separator class="divider" size="4px" />
                <div class="row">
                  <div class="col data-col">
                    <div class="text-h6">Navigation QNH</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.flight.nav_qnh"
                      >{{ aircraft.flight.nav_qnh }}</q-item-label
                    >
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                  <div class="col data-col">
                    <div class="text-h6">MLAT</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.flight.mlat"
                      >{{ aircraft.flight.mlat }}</q-item-label
                    >
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                </div>
                <q-separator class="divider" size="4px" />
                <!-- ----------------------- -->
                <div class="row">
                  <div class="col data-col">
                    <div class="text-h6">Barometric Altitude</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.flight.barometric_alt"
                      >{{ aircraft.flight.barometric_alt }} ft</q-item-label
                    >
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                  <div class="col data-col">
                    <div class="text-h6">Geomertric Altitude</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.flight.geometric_alt"
                      >{{ aircraft.flight.geometric_alt }} ft</q-item-label
                    >
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                </div>

                <!----------------------------------  -->
                <q-separator class="divider" size="4px" />

                <div class="row">
                  <div class="col data-col">
                    <div class="text-h6">NIC</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.flight.nic"
                      >{{ aircraft.flight.nic }}</q-item-label
                    >
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                  <div class="col data-col">
                    <div class="text-h6">RC</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.flight.rc"
                      >{{ aircraft.flight.rc }}</q-item-label
                    >
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                </div>
                <!-- -------------------- -->
                <q-separator class="divider" size="4px" />

                <div class="row">
                  <div class="col data-col">
                    <div class="text-h6">Flight</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.aircraftInfo.callsign"
                      >{{ aircraft.aircraftInfo.callsign }}
                    </q-item-label>
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                  <div class="col data-col">
                    <div class="text-h6">Category</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.aircraftInfo.category"
                      >{{ aircraft.aircraftInfo.category }} ft</q-item-label
                    >
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                </div>
                <!-- --------------------------- -->
                <q-separator class="divider" size="4px" />

                <div class="row">
                  <div class="col data-col">
                    <div class="text-h6">Last Seen</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.lastSeen"
                      >{{ aircraft.lastSeen }} Second ago
                    </q-item-label>
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                  <div class="col data-col">
                    <div class="text-h6">Navigation Modes</div>
                    <q-item-label
                      class="text-subtitle2"
                      v-if="aircraft.flight.modes"
                      >{{ aircraft.flight.modes }}
                    </q-item-label>
                    <q-item-label class="text-subtitle2" v-else
                      >N/A</q-item-label
                    >
                  </div>
                </div>
                <!-- ---------------- -->
              </div>
            </div>
          </q-item-section>
        </q-item>
      </q-card>
    </div>
    <div class="xs m-mav-panel">
      <q-card class="xs m-mav-panel-card" flat>
        <div class="m-mav-image">
          <q-img :src="aircraft.urlPhotoDirect" />
        </div>
        <div class="row q-pl-sm"></div>
        <div class="m-mav-subtitle">
          <div class="mav-">
            <div class="row">
              <div class="col-12 content-center">
                <div
                  class="text-bold text-subtitle1 m-section-bar"
                  style="text-align: center"
                >
                  Short Information
                </div>
              </div>
            </div>
          </div>
        </div>

        <q-card-section class="q-pl-none q-pr-none">
          <div class="row m-data-row content-center">
            <div class="col-5 m-data-col">
              <div class="q-body-2">ICAO</div>
              <div v-if="aircraft.hex" class="text-caption">
                {{ aircraft.hex }}
              </div>
              <div v-else class="q-body-2">N/A</div>
            </div>

            <div class="col-5 m-data-col">
              <div class="q-body-2">Registration</div>
              <div
                v-if="aircraft.aircraftInfo.registration"
                class="text-caption"
              >
                {{ aircraft.aircraftInfo.registration }}
              </div>
              <div v-else class="text-caption">N/A</div>
            </div>

            <div class="col-5 m-data-col">
              <div class="q-body-2">Aircraft Type</div>
              <div v-if="aircraft.aircraftInfo.type" class="text-caption">
                {{ aircraft.aircraftInfo.type }}
              </div>
              <div v-else class="text-caption">N/A</div>
            </div>

            <div class="col-5 m-data-col">
              <div class="q-body-2">Heading</div>
              <div v-if="aircraft.flight.heading" class="text-caption">
                {{ aircraft.flight.heading }}
              </div>
              <div v-if="aircraft.flight.track" class="text-caption">
                {{ aircraft.flight.track }}
              </div>
              <div v-else class="text-caption">N/A</div>
            </div>

            <div class="col-5 m-data-col">
              <div class="q-body-2">Longitude</div>
              <div v-if="aircraft.position.lon" class="text-caption">
                {{ aircraft.position.lon }}
              </div>
              <div v-else class="text-caption">N/A</div>
            </div>

            <div class="col-5 m-data-col">
              <div class="q-body-2">Latitude</div>
              <div v-if="aircraft.position.lat" class="text-caption">
                {{ aircraft.position.lat }}
              </div>
              <div v-else class="text-caption">N/A</div>
            </div>
          </div>
        </q-card-section>

        <!-- Needed to see hidden values -->
        <q-card-section>
          <div></div>
        </q-card-section>
      </q-card>
    </div>
  </div>
</template>
<script>
import planeStore from "src/planeStore";
import { inject, ref, onMounted, computed } from "vue";
export default {
  props: {
    aircraft: Object,
  },

  setup(props) {
    const close = () => {
      planeStore.state.showAircraftPanel = false;
      console.log(props.aircraft);
    };

    return {
      close,
    };
  },
};
</script>
<style lang="scss">
.aircraft-panel {
  position: fixed;
  background-color: #1e1e2f;
  height: 100vh;
  overflow-y: scroll;
}
.aircraft-card {
  color: white;
  background-color: #1e1e2f;
  width: 100%;
  max-width: 360px;

  .icon-col {
    background-color: $primary;
    margin-right: 4px;
    padding: 2px;
    flex: auto;
  }

  .data-col {
    color: white;
    background-color: $primary;
    padding-left: 4px;
  }
  .data-row {
    margin-bottom: 4px;
  }
  .aircraft-header {
    color: white;
    background-color: $primary;
  }
}

.divider {
  background-color: #403d3d;
}
</style>
<style lang="scss" scoped>
.m-section-bar {
  background-color: #1e1e2f;
  width: 100%;
}
.m-mav-panel {
  position: fixed;
  background-color: $primary;
  // height: 100vh;
  width: 100%;
  position: fixed;
  bottom: 0;
  // overflow-y: scroll;
}

.m-mav-image {
  bottom: 53%;
  width: 100%;
  height: 100px;
  overflow: hidden;
  max-height: 150px;
  max-width: 73px;
  position: absolute;
}
.m-mav-subtitle {
  width: 100%;
}

.m-mav-panel-card {
  background-color: $primary;
  color: white;
  left: 0%;
  top: 0%;
  position: relative;
  // width: 100%;
  // height: 20%;
  // max-height: 100px;
  // max-width: 300px;

  .m-icon-side {
    position: absolute;
  }
  .m-data-row {
    .m-data-col {
      padding-left: 5%;
      width: 30%;
      color: white;
    }
  }
}
</style>
