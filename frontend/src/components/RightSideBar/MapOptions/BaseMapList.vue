<template>
  <div class="q-pa-sm" id="basemap-selector">
    <div class="basemap-list">
      <ul>
        <li
          v-for="(baseMap, index) in planeStore.state.baseMaps"
          :key="index"
          @click="toggleBaseMap(baseMap)"
          :class="{ active: baseMap.get('title') == selectedBaseMap }"
        >
          <div id="basemap-thumbnail-container">
            <q-img
              id="basemap-thumbnail"
              src="https://cdn.quasar.dev/img/parallax2.jpg"
            >
            </q-img>
            <label for="">{{ baseMap.get("title") }}</label>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { map } from "src/boot/ol";
import { onMounted, ref } from "vue";

import planeStore from "src/planeStore";
export default {
  setup() {
    let selectedBaseMap = ref("Street Map");
    const toggleBaseMap = (baseMap) => {
      map
        .getLayers()
        .getArray()
        .forEach((baseLayer) => {
          console.log(baseLayer);
        });
      // console.log("das");
      // map
      //   .getLayers()
      //   .getArray()
      //   .forEach((map) => {
      //     console.log(map.get("title"));
      //     console.log(baseMap.get("title"));
      //     if (baseMap.get("title") === map.get("title")) {
      //       map.setVisible(true);
      //       selectedBaseMap.value = baseMap.get("title");
      //     } else {
      //       map.visible = false;
      //     }
      //   });
    };
    onMounted(() => {
      // console.log(map.getLayers());
      console.log(planeStore.state.baseMaps[0]);
    });

    return {
      planeStore,
      toggleBaseMap,
      selectedBaseMap,
    };
  },
};
</script>

<style lang="scss" scoped>
#basemap-selector {
  width: 100%;
  height: 100%;
}

.basemap-list > ul > li:not([disabled]) {
  cursor: pointer;
}

.basemap-list > ul {
  display: flex;
  flex-wrap: wrap;
  margin-bottom: -10px;
  margin-right: -15px;
  width: 100%;
  padding: 0px;
}

.basemap-list > ul > li {
  display: flex;
  flex-direction: column;
  flex: 0 0 50%;
  max-width: 50%;
  margin-bottom: 10px;
  padding-right: 15px;
}

.active > #basemap-thumbnail-container > #basemap-thumbnail {
  // box-shadow: rgb(160 218 48) 0px 0px 0px 4px inset;
  border-style: solid;
  border-color: $accent;
}
</style>
