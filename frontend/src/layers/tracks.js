const { default: VectorLayer } = require("ol/layer/Vector");
import { planeSource } from "boot/ol";
import { map } from "boot/ol";

// This layers holds the source for the aircrafts.
let planeLayer = new VectorLayer({
  source: planeSource,
  declutter: false,
  zIndex: 200,
  renderBuffer: 20,
});

map.addLayer(planeLayer);
