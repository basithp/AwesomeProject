
export const white = '#FFFFFF'
export const black = '#111'
export const blue = '#07c'

export const colors = {
  white,
  black,
  blue
}

const darken = (n) => `rgba(0, 0, 0, ${n})`

export const shade = [
  darken(0),
  darken(1 / 8),
  darken(1 / 4),
  darken(3 / 8),
  darken(1 / 2),
  darken(5 / 8),
  darken(3 / 4),
  darken(7 / 8),
  darken(1)
]

export const cardStyle = {
  backgroundColor: colors.white,
  borderRadius: 3,
  boxShadow: `0 0 4px ${shade[1]}`
}
