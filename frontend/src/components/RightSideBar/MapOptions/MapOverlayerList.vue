<template>
  <div class="q-pa-sm" id="basemap-selector">
    <div class="basemap-list">
      <ul>
        <li
          v-for="(overlay, index) in planeStore.state.overlays"
          :key="index"
          @click="toggleOverlay(overlay)"
          :class="{ active: selectedOverlays.includes(overlay.get('title')) }"
        >
          <div id="basemap-thumbnail-container">
            <q-img
              id="basemap-thumbnail"
              width="156px"
              height="104px"
              :src="overlay.get('image_url')"
            >
            </q-img>
            <label class="text-subtitle2">{{ overlay.get("title") }}</label>
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
    let selectedOverlays = ref([]);
    const toggleOverlay = (overlay) => {
      map
        .getLayers()
        .getArray()
        .forEach((overlayLayer) => {
          if (overlayLayer.get("title") == overlay.get("title")) {
            if (selectedOverlays.value.includes(overlayLayer.get("title"))) {
              let index = selectedOverlays.value.indexOf(
                overlayLayer.get("title")
              );
              selectedOverlays.value.splice(index, 1);
              overlayLayer.setVisible(false);
            } else {
              overlayLayer.setVisible(true);

              selectedOverlays.value.push(overlayLayer.get("title"));
            }
          }
        });
    };
    onMounted(() => {
      // console.log(map.getLayers());
      console.log(planeStore.state.baseMaps[0]);
    });

    return {
      planeStore,
      toggleOverlay,
      selectedOverlays,
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
