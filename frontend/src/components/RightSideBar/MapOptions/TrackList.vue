<template>
  <div class="q-pa-sm" id="basemap-selector">
    <div class="basemap-list">
      <ul>
        <li
          v-for="(track, index) in planeStore.state.tracks"
          :key="index"
          @click="toggleTrack(track)"
          :class="{ active: selectedTracks.includes(track.get('title')) }"
        >
          <div id="basemap-thumbnail-container">
            <q-img
              id="basemap-thumbnail"
              width="156px"
              height="104px"
              :src="track.get('image_url')"
            >
            </q-img>
            <label class="text-subtitle2">{{ track.get("title") }}</label>
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
    let selectedTracks = ref([]);
    const toggleTrack = (track) => {
      map
        .getLayers()
        .getArray()
        .forEach((trackLayer) => {
          if (trackLayer.get("title") == track.get("title")) {
            if (selectedTracks.value.includes(trackLayer.get("title"))) {
              let index = selectedTracks.value.indexOf(trackLayer.get("title"));
              selectedTracks.value.splice(index, 1);
              trackLayer.setVisible(false);
            } else {
              trackLayer.setVisible(true);

              selectedTracks.value.push(trackLayer.get("title"));
            }
          }
        });
    };
    onMounted(() => {
      // console.log(map.getLayers());
      selectedTracks.value.push(planeStore.state.tracks[0].get("title"));
    });

    return {
      planeStore,
      toggleTrack,
      selectedTracks,
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
