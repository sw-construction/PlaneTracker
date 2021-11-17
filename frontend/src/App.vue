<template>
  <router-view />
</template>
<script>
import { defineComponent } from "vue";

// runs the code in baseMaps.js
import baseMap from "./layers/baseMaps";
// runs the code in tracks.js
import tracks from "./layers/tracks";

export default defineComponent({
  name: "App",
});
</script>
