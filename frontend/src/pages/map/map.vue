<template>
  <div ref="olmap" id="map">
    <LeftSidebar/>
  </div>
</template>

<script>
import { map } from "../../boot/ol";
import { ref, onMounted, onUnmounted } from "vue";
import OSM from "ol/source/OSM";
import "ol/ol.css";
import LeftSidebar from "../../components/LeftSidebar/LeftSidebar.vue"

import TileLayer from "ol/layer/Tile";
export default {
  components: {
    LeftSidebar,
  },
  setup() {
    let olmap = ref(null);

    const createMap = () => {
      console.log(olmap);
      map.setTarget(olmap.value);
      let osm = new TileLayer({
        source: new OSM(),
      });
      map.addLayer(osm);
    };

    onMounted(() => {
      createMap();
    });

    return {
      olmap,
    };
  },
};
</script>

<style lang="scss">
#map {
  width: 100%;
  height: 100%;
  position: fixed;
  background-color: black;
}
</style>
