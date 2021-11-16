<template>
  <div class="aicraft-panel">
    <q-card flat class="aircraft-card">
      <q-item class="aircraft-item">
        <q-item-section>
          <q-item-label>ICAO</q-item-label>
        </q-item-section>
        <q-card-actions>
          <q-btn flat round color="accent" icon="close" />
        </q-card-actions>
      </q-item>
      <img src="https://cdn.quasar.dev/img/parallax2.jpg" />
      <q-item class="">
        <q-item-section>
          <q-item-label class="text-center">Aircraft Information</q-item-label>
          <div class="row">
            <div class="col aircraft-item">
              <q-icon size="16px" class="las la-plane" />
            </div>
            <div class="col aircraft-item">.col</div>
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
}
.aircraft-item {
  color: white;
  background-color: $primary;

  .icon-col {
    padding: 1px;
    margin: 1px;
  }
}
</style>
