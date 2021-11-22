import { map, layers } from "boot/ol";

import OSM from "ol/source/OSM";

import TileLayer from "ol/layer/Tile";
import XYZ from "ol/source/XYZ";
import TileJson from "ol/source/TileJSON";
import planeStore from "src/planeStore";

let osm = new TileLayer({
  type: "base",
  title: "Street Map",
  visible: true,
  source: new OSM(),
  image_url: require("../assets/osm.jpg"),
});

map.addLayer(osm);
planeStore.state.baseMaps.push(osm);

let maps = [
  {
    name: "Light with labels",
    url: "https://{a-d}.basemaps.cartocdn.com/rastertiles/light_all/{z}/{x}/{y}.png",
    image_url:
      "https://carto.com/help/images/building-maps/basemaps/positron_labels.png",
  },
  {
    name: "Light without labels",
    url: "https://{a-d}.basemaps.cartocdn.com/rastertiles/light_nolabels/{z}/{x}/{y}.png",
    image_url:
      "https://carto.com/help/images/building-maps/basemaps/positron_no_labels.png",
  },
  {
    name: "Dark Matter with labels",
    url: "https://{a-d}.basemaps.cartocdn.com/rastertiles/dark_all/{z}/{x}/{y}.png",
    image_url:
      "https://carto.com/help/images/building-maps/basemaps/dark_labels.png",
  },
  {
    name: "Dark Matter without labels",
    url: "https://{a-d}.basemaps.cartocdn.com/rastertiles/dark_nolabels/{z}/{x}/{y}.png",
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
    source: new OSM({
      url: maps[rmap].url,
    }),
  });
  map.addLayer(bmap);
  planeStore.state.baseMaps.push(bmap);
}

const SatelliteLabel = new TileLayer({
  title: "Satellite with Labels",
  type: "base",
  visible: false,
  source: new TileJson({
    url: "https://api.maptiler.com/maps/hybrid/tiles.json?key=7jdfGblaxPQLT6Hj73IV",
    tileSize: 512,
    crossOrigin: "anonymous",
    maxZoom: 19,
  }),
  name: "Satellite with Labels",
  image_url: require("../assets/satellite_with_label.jpg"),
});

map.addLayer(SatelliteLabel);
planeStore.state.baseMaps.push(SatelliteLabel);

const Satellite = new TileLayer({
  title: "Satellite no Labels",
  type: "base",
  visible: false,
  source: new XYZ({
    url: "https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}",
    maxZoom: 19,
  }),
  name: "Satellite No Labels",
  image_url: require("../assets/satellite_no_label.jpg"),
});

map.addLayer(Satellite);
planeStore.state.baseMaps.push(Satellite);

// layers.concat(planeStore.state.baseMaps);
