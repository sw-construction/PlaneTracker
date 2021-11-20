const { default: VectorLayer } = require("ol/layer/Vector");
import { planeSource, trailSource } from "boot/ol";
import { map } from "boot/ol";
import Point from "ol/geom/Point";
import Stroke from "ol/style/Stroke";
import Style from "ol/style/Style";

// This layers holds the source for the aircrafts.
let planeLayer = new VectorLayer({
  source: planeSource,
  declutter: false,
  zIndex: 200,
  renderBuffer: 20,
});

let planeTrails = new VectorLayer({
  source: trailSource,
  declutter: false,
  zIndex: 200,
  renderBuffer: 20,
});

map.addLayer(planeLayer);
map.addLayer(planeTrails);
