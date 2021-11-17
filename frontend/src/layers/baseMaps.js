import { map } from "boot/ol";

import OSM from "ol/source/OSM";
import TileLayer from "ol/layer/Tile";

let osm = new TileLayer({
  type: "base",
  title: "Street Map",
  visible: true,
  source: new OSM(),
});

map.addLayer(osm);
