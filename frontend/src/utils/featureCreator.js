import {
  getIcon,
  createIconURI,
  calcColorFromAltitude,
  shapes,
} from "../utils/icons";
import * as olProj from "ol/proj";
import Point from "ol/geom/Point";

import { degreesToRadians } from "src/utils/conversions";
import Style from "ol/style/Style";
import Icon from "ol/style/Icon";
import Feature from "ol/Feature";

export const createFeature = (aircraft) => {
  let icon = createIcon(
    aircraft.aircraftInfo.category,
    aircraft.aircraftInfo.type,
    aircraft.flight.track,
    aircraft.position.alt
  );
  let feature = new Feature(
    new Point(olProj.fromLonLat([aircraft.position.lon, aircraft.position.lat]))
  );
  feature.setStyle(icon);
  feature.hex = aircraft.hex;
  feature.visible = true;
  return feature;
};

// this creates the icon by looking for keys in icons shapes
export const createIcon = (category, type, track, alt) => {
  let planeShape = getIcon(category, type);
  const globalScale = 1;
  const scaleFactor = 1.18 * Math.pow(1.3, globalScale) * globalScale;
  const baseScale = planeShape[1] * 0.96;
  const scale = scaleFactor * baseScale;
  const shape = planeShape[0];
  const strokeWidth = 0.4;
  planeShape = shapes[shape];

  let fillColor = calcColorFromAltitude(alt);
  let strokeColor = "#000";
  let planeIconURI = createIconURI(
    planeShape,
    fillColor,
    strokeColor,
    strokeWidth
  );

  const style = new Style({
    image: new Icon({
      imgSize: [planeShape.w, planeShape.h],
      src: planeIconURI,
      scale: scale * 1.5,
      rotation: degreesToRadians(track),
    }),
  });

  return style;
};
