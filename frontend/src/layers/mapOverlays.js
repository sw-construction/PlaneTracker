import { map, layers } from "boot/ol";

import OSM from "ol/source/OSM";

import TileLayer from "ol/layer/Tile";
import XYZ from "ol/source/XYZ";
import TileJson from "ol/source/TileJSON";
import planeStore from "src/planeStore";

let openAIP = new TileLayer({
  source: new XYZ({
    url: "https://map.adsbexchange.com/mapproxy/tiles/1.0.0/openaip/ul_grid/{z}/{x}/{y}.png",
    attributions: "openAIP.net",
  }),
  title: "OPEN AIP",
  image_url: require("../assets/open_aip.jpg"),
  visible: false,
  type: "overlay",
});

map.addLayer(openAIP);
planeStore.state.overlays.push(openAIP);

let nexradar = new TileLayer({
  visible: false,
  image_url: require("../assets/weather.jpg"),
  type: "overlay",
  title: "NEXRAD Weather",
});

const refreshNextRad = () => {
  let now = new Date().getTime();
  nexradar.setSource(
    new XYZ({
      url:
        "https://mesonet{1-3}.agron.iastate.edu/cache/tile.py/1.0.0/nexrad-n0q-900913/{z}/{x}/{y}.png?_=" +
        now,
    })
  );
  setInterval(() => {
    let now = new Date().getTime();
    nexradar.setSource(
      new XYZ({
        url:
          "https://mesonet{1-3}.agron.iastate.edu/cache/tile.py/1.0.0/nexrad-n0q-900913/{z}/{x}/{y}.png?_=" +
          now,
      })
    );
  }, 2 * 60 * 1000);
};

refreshNextRad();

map.addLayer(nexradar);
planeStore.state.overlays.push(nexradar);
