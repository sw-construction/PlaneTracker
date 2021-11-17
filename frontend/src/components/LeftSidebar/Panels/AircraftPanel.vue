<template>
  <div class="aicraft-panel">
    <q-card flat class="aircraft-card">
      <q-item class="aircraft-header">
        <q-item-section>
          <q-item-label>ICAO</q-item-label>
        </q-item-section>
        <q-card-actions>
          <q-btn flat round color="accent" icon="close" />
        </q-card-actions>
      </q-item>
      <img src="https://cdn.quasar.dev/img/parallax2.jpg" />

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
              <div class="col data-data">
                <div class="text-h6">Aircraft Type</div>
                <div class="text-subtitle2">asdasda</div>
              </div>
              <q-separator class="divider" size="4px" />
              <div class="col data-data">
                <div class="text-h6">Aircraft Type</div>
                <div class="text-subtitle2">asdasda</div>
              </div>
            </div>
          </div>
          <div class="row data-row">
            <div class="col icon-col">
              <q-icon size="32px" class="las la-plane" />
            </div>
            <div class="col">
              <div class="col data-data">
                <div class="text-h6">Aircraft Type</div>
                <div class="text-subtitle2">asdasda</div>
              </div>
              <q-separator class="divider" size="4px" />
              <div class="col data-data">
                <div class="text-h6">Aircraft Type</div>
                <div class="text-subtitle2">asdasda</div>
              </div>
              <q-separator class="divider" size="4px" />
              <div class="row">
                <div class="col data-data">
                  <div class="text-h6">Lat</div>
                  <div class="text-subtitle2">321</div>
                </div>
                <div class="col data-data">
                  <div class="text-h6">Lon</div>
                  <div class="text-subtitle2">2</div>
                </div>
              </div>
            </div>
          </div>
          <div class="row data-row">
            <div class="col icon-col">
              <q-icon size="32px" class="las la-plane" />
            </div>
            <div class="col">
              <div class="col data-data">
                <div class="text-h6">Aircraft Type</div>
                <div class="text-subtitle2">asdasda</div>
              </div>
              <q-separator class="divider" size="4px" />
              <div class="col data-data">
                <div class="text-h6">Aircraft Type</div>
                <div class="text-subtitle2">asdasda</div>
              </div>
            </div>
          </div>
        </q-item-section>
      </q-item>
    </q-card>
  </div>
</template>
<script>
export default {
  props: {
    aircraft: Object,
  },
  setup(props) {},
};
</script>
<style lang="scss">
.aircraft-panel {
  position: fixed;
  background-color: $secondary;
  height: 100vh;
  overflow-y: scroll;
}
.aircraft-card {
  color: white;
  background-color: $secondary;
  width: 100%;
  max-width: 360px;

  .data-data {
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
.icon-col {
  background-color: $primary;
  margin-right: 4px;
  padding: 2px;
  flex: auto;
}
.divider {
  background-color: #403D3D;
}
</style>
