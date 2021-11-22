const { default: VectorLayer } = require("ol/layer/Vector");
import { planeSource, trailSource } from "boot/ol";
import { map } from "boot/ol";
import Point from "ol/geom/Point";
import Stroke from "ol/style/Stroke";
import Style from "ol/style/Style";
import planeStore from "src/planeStore";

// This layers holds the source for the aircrafts.
let planeLayer = new VectorLayer({
  source: planeSource,
  declutter: false,
  zIndex: 200,
  renderBuffer: 20,
  title: "Plane Track",
  image_url: require("../assets/mlat_tracks.jpg"),
});

let planeTrails = new VectorLayer({
  source: trailSource,
  declutter: false,
  visible: false,
  zIndex: 200,
  renderBuffer: 20,
  title: "Plane Trails",
  image_url: require("../assets/mlat_tracks.jpg"),
});

map.addLayer(planeLayer);
map.addLayer(planeTrails);

planeStore.state.tracks.push(planeLayer);
planeStore.state.tracks.push(planeTrails);
