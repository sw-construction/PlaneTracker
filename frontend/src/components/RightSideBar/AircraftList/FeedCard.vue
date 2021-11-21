<template>
  <q-card
    clickable
    v-ripple
    @click="selectAircraft(hex)"
    class="feed-card cursor-pointer q-hoverable"
  >
    <q-img :src="photo.photo_url">
      <div class="text-subtitle2 absolute-top text-center">
        {{ hex }}
      </div>
    </q-img>
  </q-card>
</template>

<script>
import planeStore from "src/planeStore";
import { aircraftSelection } from "src/utils/selectHandler";
export default {
  props: {
    hex: String,
    photo: Object,
  },
  setup() {
    const selectAircraft = (hex) => {
      // const plane = {hex:hex}
      console.log(hex);
      aircraftSelection(hex, true);
    };

    return {
      selectAircraft,
    };
  },
};
</script>

<style lang="scss" scoped>
.feed-card {
  width: 400px;
}
</style>
