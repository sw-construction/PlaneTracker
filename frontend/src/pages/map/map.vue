<template>
  <div ref="olmap" id="map">
    <RightSidebar />
    <HoverInfo
      v-if="showHoverInfo"
      :aircraft="hoverAircraft"
      :posStyle="posStyle"
    />
  </div>
</template>

<script>
import ol, { map } from "../../boot/ol";
import { ref, onMounted, onUnmounted } from "vue";
import RightSidebar from "../../components/RightSidebar/Rightsidebar.vue";
import { fetchPlanes, getPlaneFromPlanes } from "../../service/planeService";
import HoverInfo from "../../components/Hover/HoverInfo.vue";
import planeStore from "src/planeStore";
import "ol/ol.css";

export default {
  components: {
    RightSidebar,
    HoverInfo,
  },
  setup() {
    let olmap = ref(null);
    let aircraftInterval = null;
    let showHoverInfo = ref(false);
    let hoverAircraft = ref(null);
    let posStyle = ref(null);
    let topValue = ref(null);
    let leftValue = ref(null);

    const createMap = () => {
      map.setTarget(olmap.value);
    };

    const startFetch = () => {
      aircraftInterval = setInterval(() => {
        fetchPlanes();
      }, 1000);
    };

    // TODO: move this function  to selectHandler
    // TODO: and make @hoverAircraft, @showHoverInfo @posStyle part of planeStore global vars
    const initHoverOnAircraft = () => {
      map.on("pointermove", (evt) => {
        if (evt.dragging) {
          return;
        }
        let hex = evt.map.forEachFeatureAtPixel(evt.pixel, function (feature) {
          return feature.hex;
        });

        if (hex) {
          map.getTargetElement().style.cursor = hex ? "pointer" : "";
          let aircraft = getPlaneFromPlanes(hex);
          if (aircraft) {
            hoverAircraft.value = aircraft;
            let markerCoords = aircraft.feature.getGeometry().getCoordinates();
            let markerPosition = map.getPixelFromCoordinate(markerCoords);
            if (!markerPosition) return;

            let mapSize = map.getSize();
            if (markerPosition[0] + 200 < mapSize[0])
              leftValue.value = markerPosition[0] + 20;
            else leftValue.value = markerPosition[0] - 200;

            if (markerPosition[1] + 250 < mapSize[1])
              topValue.value = markerPosition[1] + 50;
            else topValue.value = markerPosition[1] - 250;
            posStyle.value = { top: topValue.value, left: leftValue.value };
            showHoverInfo.value = true;
          }
        } else {
          map.getTargetElement().style.cursor = "";
          showHoverInfo.value = false;
        }
      });
    };

    onMounted(() => {
      createMap();
      startFetch();
      initHoverOnAircraft();
    });

    return {
      olmap,
      showHoverInfo,
      hoverAircraft,
      posStyle,
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
