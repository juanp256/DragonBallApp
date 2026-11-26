<p align="center">
  <img src="docs/logo_esfera_dragon.png" width="150" alt="Logo de la app">
</p>

# DragonBallApp

Esta es una app para Android que hice en Java. Muestra una lista de personajes de Dragon Ball usando un RecyclerView y, al tocar uno, abre una pantalla con su información

## Cómo la hice
- Saqué los datos de la API https://dragonball-api.com
- Usé Volley para conectarme a la API y Glide para mostrar las imágenes de los personajes.
- Armé la lista con un RecyclerView y un adaptador propio (PersonajeAdapter).
- Pasé los datos a la pantalla de detalle con Intent y putExtra.
- Le di un diseño con colores azul y naranja tambien le agregue un logo de esfera del dragón con Image Asset y un fondo para la pantalla de inicio.
