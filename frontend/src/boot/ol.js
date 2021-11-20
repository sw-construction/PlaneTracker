import { boot } from "quasar/wrappers";
import Map from "ol/Map";
import View from "ol/View";
import VectorSource from "ol/source/Vector";
import * as olProj from "ol/proj";

// Be careful when using SSR for cross-request state pollution
// due to creating a Singleton instance here;
// If any client changes this (global) instance, it might be a
// good idea to move this instance creation inside of the
// "export default () => {}" function below (which runs individually
// for each client)

const map = new Map({
  view: new View({
    projection: "EPSG:3857",
    center: olProj.transform([-106.485, 31.7619], "EPSG:4326", "EPSG:3857"),
    zoom: 11,
    layers: [],
  }),
});

const planeSource = new VectorSource();
const trailSource = new VectorSource();

export default boot(({ app }) => {
  // for use inside Vue files (Options API) through this.$axios and this.$api

  app.config.globalProperties.$map = map;
  // ^ ^ ^ this will allow you to use this.$axios (for Vue Options API form)
  //       so you won't necessarily have to import axios in each vue file

  // ^ ^ ^ this will allow you to use this.$api (for Vue Options API form)
  //       so you can easily perform requests against your app's API
});

export { map, planeSource, trailSource };
