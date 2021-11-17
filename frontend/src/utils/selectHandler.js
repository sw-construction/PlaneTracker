import { map } from "boot/ol";
let select = null;

let selectedAC = null;

export const addSelectClick = () => {
  select = selectClick;
  map.addInteraction(select);
  select.on("select", async function (e) {
    // this is for something else
    if (selectedAC) {
      //   selectedAC.setTrailVisible(false);
      //   selectedAC = null;
    }
    let hex = e.selected[0]?.hex;

    if (hex) {
      // TODO: add handlers to open panel
    }
  });
};
