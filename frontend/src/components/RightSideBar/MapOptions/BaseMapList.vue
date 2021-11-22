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
              width="156px"
              height="104px"
              :src="baseMap.get('image_url')"
            >
            </q-img>
            <label class="text-subtitle2">{{ baseMap.get("title") }}</label>
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
          if (baseLayer.get("title") == baseMap.get("title")) {
            baseLayer.setVisible(true);
            selectedBaseMap.value = baseMap.get("title");
          } else {
            baseLayer.setVisible(false);
          }
        });
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
ul {
  list-style: none;
  margin: 0;
}

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

#basemap-thumbnail {
  width: 120px;
  height: 120px;
}

.active > #basemap-thumbnail-container > #basemap-thumbnail {
  // box-shadow: rgb(160 218 48) 0px 0px 0px 4px inset;
  border-style: solid;
  border-color: $accent;
}
</style>
