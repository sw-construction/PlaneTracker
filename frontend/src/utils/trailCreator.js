import * as olProj from "ol/proj";
import LineString from "ol/geom/LineString";
import MultiLineString from "ol/geom/MultiLineString";
import Feature from "ol/Feature";
import Style from "ol/style/Style";
import Stroke from "ol/style/Stroke";
import { planeSource, trailSource } from "src/boot/ol";

// export const createTrail = (positions) => {
//   let lineStrings = [];
//   for (let i = 0; i < positions.length; i++) {
//     // let alt = positions[i].alt
//     if (positions[i + 1]) {
//       let lon = positions[i].lon;
//       let lat = positions[i].lat;
//       let nextLon = positions[i + 1].lon;
//       let nextLat = positions[i + 1].lat;
//       let initPos = olProj.transform([lon, lat], "EPSG:4326", "EPSG:3857");
//       let nextPos = olProj.transform(
//         [nextLon, nextLat],
//         "EPSG:4326",
//         "EPSG:3857"
//       );

//       let trailPoint = new Feature({
//         geometry: new LineString([initPos, nextPos]),
//       });
//       trailSource.addFeature(trailPoint);

//       //   lineStrings.push(trailPoint);
//     }
//   }
//   //   let trailPositions = new Feature({
//   //     geometry: new MultiLineString([lineStrings]),
//   //   });
//   //   console.log(trailPositions.getCoordinates());

//   //   var featureStyle = new Style({
//   //     stroke: new Stroke({
//   //       color: "rgb(255, 255, 255)",
//   //       width: 10,
//   //     }),
//   //   });

//   //   trailPositions.setStyle(featureStyle);

//   return trailPositions;
// };

export const createTrail = (positions) => {
  let lineStrings = [];
  for (let i = 0; i < positions.length; i++) {
    let alt = positions[i].alt;
    let lon = positions[i].lon;
    let lat = positions[i].lat;

    let pos = olProj.transform([lon, lat], "EPSG:4326", "EPSG:3857");
    lineStrings.push(pos);
    pos["alt"] = alt;

    //   lineStrings.push(trailPoint);
  }

  let trailPositions = new Feature({
    geometry: new LineString(lineStrings),
  });

  return trailPositions;
};
