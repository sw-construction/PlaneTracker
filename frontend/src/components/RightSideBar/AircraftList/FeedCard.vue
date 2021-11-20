<template>
  <q-card class="feed-card">
    <q-img :src="photo.photo_url">
      <div class="text-subtitle2 absolute-top text-center">
        {{ hex }}
      </div>
    </q-img>
  </q-card>
</template>

<script>
export default {
  props: {
    hex: String,
    photo: Object,
  },
  setup() {},
};
</script>

<style lang="scss" scoped>
.feed-card {
  width: 400px;
}
</style>
