import { shapes, CategoryIcons, TypeDesignatorIcons } from '.'

export const getIcon = (category, type) => {
  if (type in TypeDesignatorIcons) {
    let shape = TypeDesignatorIcons[type][0]
    let scaling = TypeDesignatorIcons[type][1]
    return [shape, scaling]
  }
  if (category in CategoryIcons) {
    return CategoryIcons[category]
  }

  return ['unknown', 1]
}

export const createIconURI = (shape, fillColor, strokeColor, strokeWidth) => {
  strokeWidth *= shape.strokeScale ? shape.strokeScale : 1

  if (!shape.path) {
    let svg = shape.svg
      .replace('fillColor', fillColor)
      .replace('strokeColor', strokeColor)
      .replace('strokeWidth', strokeWidth)
    return 'data:image/svg+xml;base64,' + btoa(svg)
  }

  let svg =
    '<svg version="1.1" xmlns="http://www.w3.org/2000/svg" viewBox="' +
    shape.viewBox +
    '" ' +
    (shape.noAspect ? 'preserveAspectRatio="none" ' : '') +
    'width="' +
    shape.w +
    '" height="' +
    shape.h +
    '">' +
    '<g' +
    (shape.transform ? ' transform="' + shape.transform + '"' : '') +
    '>'

  let path = shape.path
  if (!Array.isArray(path)) path = [path]
  for (let i = 0; i < path.length; i++) {
    svg +=
      '<path paint-order="stroke" fill="' +
      fillColor +
      '" stroke="' +
      strokeColor +
      '" stroke-width="' +
      2 * strokeWidth +
      '" ' +
      'd="' +
      path[i] +
      '" style="shape-rendering: \'auto\'"' +
      '/>'
  }

  let accentWidth =
    0.6 * (shape.accentMult ? shape.accentMult * strokeWidth : strokeWidth)
  let accent = shape.accent
  if (!Array.isArray(accent)) accent = [accent]
  for (let i = 0; i < accent.length; i++) {
    svg +=
      '<path fill="none" stroke="' +
      strokeColor +
      '" stroke-width="' +
      accentWidth +
      '" ' +
      'd="' +
      accent[i] +
      '"/>'
  }

  svg += '</g></svg>'

  return 'data:image/svg+xml;base64,' + btoa(svg)
}

export const rgbToHex = (r, g, b) => {
  r = r * 2.55
  g = g * 2.55
  b = b * 2.55
  return '#' + ((1 << 24) + (r << 16) + (g << 8) + b).toString(16).slice(1)
}

export const calcColorFromAltitude = (altitude) => {
  if (altitude === 0) return rgbToHex(100, 100, 100)

  if (altitude > 0 && altitude <= 1000) return rgbToHex(100, 50, 0)

  if (altitude > 1000 && altitude <= 5000) return rgbToHex(100, 100, 0)

  if (altitude > 5000 && altitude <= 10000) return rgbToHex(0, 100, 0)

  if (altitude > 10000 && altitude <= 20000) return rgbToHex(0, 75, 100)

  if (altitude > 20000 && altitude <= 30000) return rgbToHex(0, 50, 100)

  if (altitude > 30000 && altitude <= 40000) return rgbToHex(50, 0, 100)

  if (altitude > 40000 && altitude <= 1000000) return rgbToHex(100, 0, 0)

  if (altitude > 1000000) return rgbToHex(100, 100, 100)

  return rgbToHex(0, 0, 0)
}
