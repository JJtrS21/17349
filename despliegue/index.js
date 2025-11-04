document.addEventListener("DOMContentLoaded", () => {
  const capitulos = [
    {
      titulo: "CAPÍTULO 2: El encuentro",
      descripcion: "Despues de la noche mas loca de su vida Mendel se despierta en un lugar desconocido.",
      enlace: "capitulos.html#capitulo2"
    },
    {
      titulo: "CAPÍTULO 1: Un cambio de aires",
      descripcion: "Descubre a Mendel, su vida y como esta se transformó de forma inesperada.",
      enlace: "capitulos.html#capitulo1"
    },
    {
      titulo: "PRÓLOGO: Lo que deseo",
      descripcion: "La conclucion de una historia epica, el final del camino del heroe, o tal vez...",
      enlace: "capitulos.html#capitulo0"
    }
  ];

  const contenedor = document.getElementById("contenedor-capitulos");

  capitulos.forEach(cap => {
    const tarjeta = document.createElement("article");
    tarjeta.classList.add("tarjeta-capitulo");

    tarjeta.innerHTML = `
      <h3>${cap.titulo}</h3>
      <p>${cap.descripcion}</p>
      <a href="${cap.enlace}">Leer más <span class="sr-only">sobre ${cap.titulo}</span></a>
    `;

    contenedor.appendChild(tarjeta);
  });
});