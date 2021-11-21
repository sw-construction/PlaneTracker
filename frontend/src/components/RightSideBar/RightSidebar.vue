<template>
  <div id="right-sidebar-container">
    <div ref="rightSidebar" class="right-sidebar right-sidebar-buttons">
      <div id="buttons">
        <div class="sidebar-buttons sidebar-flex">
          <button
            ref="mapOptions"
            class="sidebar-button"
            @click="openMapOptions"
          >
            <div id="icon-container">
              <q-icon name="settings" size="md"> </q-icon>
            </div>
            <div id="label-container">
              <label> Map Options</label>
            </div>
          </button>
          <button
            ref="aircraftList"
            class="sidebar-button"
            @click="openAircraftList"
          >
            <div id="icon-container">
              <q-icon name="print" size="md"> </q-icon>
            </div>
            <div id="label-container">
              <label> Aircraft List</label>
            </div>
          </button>
          <button
            ref="aircraftTable"
            class="sidebar-button"
            @click="openAircraftTable"
          >
            <div id="icon-container">
              <q-icon name="print" size="md"> </q-icon>
            </div>
            <div id="label-container">
              <label> Aircraft Table</label>
            </div>
          </button>
          <button
            ref="AircraftFilter"
            class="sidebar-button"
            @click="openAircraftFilter"
          >
            <div id="icon-container">
              <q-icon name="print" size="md"> </q-icon>
            </div>
            <div id="label-container">
              <label> Filters</label>
            </div>
          </button>
        </div>
      </div>
      <component :is="currentPanel" @closeTest="closeSideBar"> </component>
    </div>
  </div>
</template>

<script>
import { onMounted, ref, inject } from "vue";
import MapOptions from "./MapOptions/MapOptions.vue";
import AircraftListPanel from "./AircraftList/AircraftList.vue";
import AircraftTablePanel from "./AircraftTable/AircraftTable.vue";
import Filter from "./Filters/Filters.vue";
export default {
  components: {
    MapOptions,
    AircraftListPanel,
    AircraftTablePanel,
    Filter,
  },
  setup() {
    let currentPanel = ref(MapOptions);
    let mapOptions = ref(null);
    let aircraftList = ref(null);
    let aircraftTable = ref(null);
    let AircraftFilter = ref(null);
    let rightSidebar = ref(null);

    const openMapOptions = () => {
      currentPanel.value = MapOptions;
      mapOptions.value.classList.add("selected");
      aircraftList.value.classList.remove("selected");
      aircraftTable.value.classList.remove("selected");
      AircraftFilter.value.classList.remove("selected");
      openSideBar();
    };
    const openAircraftList = () => {
      currentPanel.value = AircraftListPanel;
      aircraftList.value.classList.add("selected");
      mapOptions.value.classList.remove("selected");
      aircraftTable.value.classList.remove("selected");
      AircraftFilter.value.classList.remove("selected");
      openSideBar();
    };
    const openAircraftTable = () => {
      currentPanel.value = AircraftTablePanel;
      aircraftTable.value.classList.add("selected");
      mapOptions.value.classList.remove("selected");
      aircraftList.value.classList.remove("selected");
      AircraftFilter.value.classList.remove("selected");

      openSideBar();
    };
    const openAircraftFilter = () => {
      currentPanel.value = Filter;
      AircraftFilter.value.classList.add("selected");
      aircraftTable.value.classList.remove("selected");
      mapOptions.value.classList.remove("selected");
      aircraftList.value.classList.remove("selected");

      openSideBar();
    };

    const openSideBar = () => {
      rightSidebar.value.classList.add("open");
    };

    const closeSideBar = () => {
      mapOptions.value.classList.remove("selected");
      aircraftList.value.classList.remove("selected");
      aircraftTable.value.classList.remove("selected");
      rightSidebar.value.classList.remove("open");
    };

    return {
      openMapOptions,
      rightSidebar,
      mapOptions,
      currentPanel,
      closeSideBar,

      aircraftList,
      openAircraftList,

      openAircraftTable,
      aircraftTable,

      openAircraftFilter,
      AircraftFilter,
    };
  },
};
</script>

<style lang="scss" scoped>
#right-sidebar-container {
  width: 2283px;
}
.right-sidebar {
  position: absolute;
  z-index: 2;
  right: 0px;
  top: 0px;
  bottom: 0px;
  pointer-events: none;
  transition: transform 350ms cubic-bezier(0.4, 0, 0.2, 1) 0s;
  transform: translate3d(calc(100% - 0.5px), 0px, 0px);
}

.right-sidebar.open {
  transform: translate3d(0px, 0px, 0px);
}

.right-sidebar > #buttons {
  pointer-events: none;
  position: absolute;
  top: 0px;
  right: 100%;
  bottom: 0px;
}

@media (min-width: 376px) {
  .right-sidebar > #buttons > .sidebar-buttons {
    top: 100px;
  }
}

.right-sidebar > #buttons > .sidebar-buttons {
  top: 48px;
  right: 0px;
  pointer-events: all;
}
.right-sidebar > #buttons > * {
  position: absolute;
}

.sidebar-flex {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}

@media (min-width: 376px) {
  .sidebar-button {
    min-width: 55px;
  }
}

.sidebar-button {
  background-color: $primary;
  border-bottom-color: $accent;
  border-top-color: $accent;
  display: flex;
  color: white;
  -webkit-box-align: center;
  align-items: center;
  -webkit-box-pack: center;
  justify-content: center;
  height: 50px;
  min-width: 50px;
  padding: 0px 15px;
  cursor: pointer;
}

.sidebar-button > #icon-container {
  position: relative;
  display: flex;
  -webkit-box-align: center;
  align-items: center;
  -webkit-box-pack: center;
  justify-content: center;
}

.sidebar-button > #label-container {
  font-family: KelsonBold, "Arial Black", sans-serif;
  text-transform: uppercase;
  color: whitesmoke;
  font-size: 0.8em;
  max-width: 0px;
  transition: max-width 350ms cubic-bezier(0.4, 0, 0.2, 1) 0s;
  overflow: hidden;
  white-space: nowrap;
}

@media (min-width: 1025px) {
  .sidebar-button:hover > #label-container {
    max-width: 200px;
  }
}

.sidebar-button > #label-container > label {
  padding-left: 10px;
  padding-right: 1px;
  cursor: pointer;
}

.sidebar-button.selected {
  background-color: $accent;
  color: white;
}

@media (min-width: 1025px) {
  .right-sidebar > #content {
    width: auto;
    max-width: none;
  }
}

@media (min-width: 376px) {
  .right-sidebar > #content {
    width: calc(100vw - 55px);
    max-width: 400px;
  }
}

.right-sidebar > #content {
  display: flex;
  flex-direction: column;
  height: 100%;
  background-color: $accent;
  color: white;
  overflow: hidden;
}

.right-sidebar > * {
  pointer-events: all;
}

.right-sidebar > #content > #tab-label {
  display: flex;
  -webkit-box-align: center;
  align-items: center;
  padding: 0px 20px;
  height: 60px;

  border-bottom: 1px solid rgb(195, 197, 197);
}

.right-sidebar > #content > #tab-content {
  flex: 1 1 0%;
  overflow: auto;
}
// .right-sidebar-buttons {
//   position: absolute;
//   z-index: 2;
//   top: 0px;
//   right: 0px;
//   display: flex;
//   flex-direction: column;
// }

// .right-sidebar-buttons > #buttons > * {
//   top: 100px;
//   position: absolute;
//   z-index: 5;
//   right: 0px;
// }
// @media (min-width: 376px) {
//   .sidebar-button {
//     min-width: 55px;
//     padding: 20px;
//   }
// }

// .sidebutton {
//   display: flex;
//   -webkit-box-align: center;
//   align-items: center;
//   -webkit-box-pack: center;
//   justify-content: center;
//   height: 50px;
//   padding: 0px 15px;
//   cursor: pointer;
// }

// .sidebutton > #icon-container {
//   position: relative;
//   display: flex;
//   -webkit-box-align: center;
//   align-items: center;
//   -webkit-box-pack: center;
//   justify-content: center;
// }

// .sidebutton > #label-container {
//   font-family: KelsonBold, "Arial Black", sans-serif;
//   text-transform: uppercase;
//   color: whitesmoke;
//   font-size: 0.8em;
//   max-width: 0px;
//   transition: max-width 350ms cubic-bezier(0.4, 0, 0.2, 1) 0s;
//   overflow: hidden;
//   white-space: nowrap;
// }

// @media (min-width: 1025px) {
//   .sidebutton:hover > #label-container {
//     max-width: 200px;
//   }
// }

// .sidebutton > #label-container > label {
//   padding-left: 10px;
//   padding-right: 1px;
//   cursor: pointer;
// }
// #map-options span {
//   font-family: KelsonBold, "Arial Black", sans-serif;
//   font-size: 0.8em;
//   text-transform: uppercase;

//   max-width: 0;
//   -webkit-transition: max-width 1s;
//   transition: max-width 1s;
//   display: inline-block;
//   vertical-align: top;
//   white-space: nowrap;
//   overflow: hidden;
// }

// #map-options:hover span {
//   max-width: 7rem;
// }

// #map-playback span {
//   max-width: 0;
//   -webkit-transition: max-width 1s;
//   transition: max-width 1s;
//   display: inline-block;
//   vertical-align: top;
//   white-space: nowrap;
//   overflow: hidden;
// }

// #map-playback:hover span {
//   max-width: 7rem;
// }
// #buttons {
//   display: flex;
//   flex-direction: column;
//   align-items: flex-end;
// }
// .sidebar {
//   position: absolute;
//   top: 0px;
//   bottom: 0px;
//   right: 0px;
//   pointer-events: none;
//   // transition: transform 350ms cubic-bezier(0.4, 0, 0.2, 1) 0s;
//   // transform: translate3d(calc(100% - 0.5px), 0px, 0px);
//   z-index: 2;
//   filter: drop-shadow(rgba(0, 0, 0, 0.15) 0px 7px 6px);
//   height: 100%;
// }

// #buttons {
//   margin: auto;
// }

// // .side > #buttons {
// //   pointer-events: none;
// //   position: absolute;
// //   right: 100%;
// //   top: 0px;
// //   bottom: 0px;
// // }

// // .side > #buttons > .sidebar-buttons {
// //   top: 100px;
// //   right: 0px;
// // }

// .buttons {
//   margin: auto;
//   display: flex;
//   flex-direction: column;
//   align-items: flex-end;
// }

// // .btn {
// //   background-color: rgb(59, 68, 66);
// //   display: flex;
// //   -webkit-box-align: center;
// //   align-items: center;
// //   -webkit-box-pack: center;
// //   justify-content: center;
// //   height: 50px;
// //   min-width: 50px;
// //   padding: 0px 15px;
// //   cursor: pointer;
// // }
</style>
