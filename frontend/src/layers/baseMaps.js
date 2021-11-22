import { map, layers } from "boot/ol";

import OSM from "ol/source/OSM";
import TileLayer from "ol/layer/Tile";
import XYZ from "ol/source/XYZ";
import planeStore from "src/planeStore";

let osm = new TileLayer({
  type: "base",
  title: "Street Map",
  visible: true,
  source: new OSM(),
});

let maps = [
  {
    name: "Light with labels",
    url: "https://{s}.basemaps.cartocdn.com/rastertiles/light_all/{z}/{x}/{y}.png",
    image_url:
      "https://carto.com/help/images/building-maps/basemaps/positron_labels.png",
  },
  {
    name: "Light without labels",
    url: "https://{s}.basemaps.cartocdn.com/rastertiles/light_nolabels/{z}/{x}/{y}.png",
    image_url:
      "https://carto.com/help/images/building-maps/basemaps/positron_no_labels.png",
  },
  {
    name: "Dark Matter with labels",
    url: "https://{s}.basemaps.cartocdn.com/rastertiles/dark_all/{z}/{x}/{y}.png",
    image_url:
      "https://carto.com/help/images/building-maps/basemaps/dark_labels.png",
  },
  {
    name: "Dark Matter without labels",
    url: "https://{s}.basemaps.cartocdn.com/rastertiles/dark_nolabels/{z}/{x}/{y}.png",
    image_url:
      "https://carto.com/help/images/building-maps/basemaps/dark_no_labels.png",
  },
];

for (let rmap in maps) {
  let bmap = new TileLayer({
    type: "base",
    image_url: maps[rmap].image_url,
    title: maps[rmap].name,
    visible: false,
    source: new XYZ({
      url: maps[rmap].url,
    }),
  });
  map.addLayer(bmap);
  planeStore.state.baseMaps.push(bmap);
}
map.addLayer(osm);

planeStore.state.baseMaps.push(osm);

// layers.concat(planeStore.state.baseMaps);
