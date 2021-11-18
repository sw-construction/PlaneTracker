<template>
  <div class="main">
    <Map />
  </div>
</template>

<script>
import Map from "./map.vue";
import { useQuasar, QSpinnerFacebook } from "quasar";
import { onMounted, onBeforeUnmount } from "vue";

export default {
  components: { Map },

  setup() {
    const $q = useQuasar();
    let timer;

    const showLoading = () => {
      $q.loading.show({
        spinner: QSpinnerFacebook,
        spinnerColor: "accent",
        spinnerSize: 140,
        backgroundColor: "black",
        message: "Getting everythinhg ready. Hang on...",
        messageColor: "white",
        customClass: "bg-primary",
      });
      timer = setTimeout(() => {
        $q.loading.hide();
        timer = void 0;
      }, 9000);
    };

    onBeforeUnmount(() => {
      if (timer !== void 0) {
        clearTimeout(timer);
        $q.loading.hide();
      }
    });

    onMounted(() => {
      showLoading();
    });
  },
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
