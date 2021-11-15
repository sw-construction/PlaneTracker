<template>
  <div class="main">
    <Map />
  </div>
</template>

<script>
import Map from "./map.vue";

export default {
  components: { Map },

  setup() {},
};
</script>

<style lang="scss">
.main {
  width: 100%;
  height: calc(100% - 60px);
  overflow: hidden;
  padding-bottom: 0;
  position: relative;
  flex: 1 0 auto;
}
</style>
