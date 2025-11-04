// Lista de capítulos disponibles
const capitulos = [
  {
    id: "capitulo0",
    titulo: "PRÓLOGO: Lo que deseo",
    partes: 1
  },
  {
    id: "capitulo1",
    titulo: "CAPÍTULO 1: Un cambio de aires",
    partes: 3
  },
  {
    id: "capitulo2",
    titulo: "CAPÍTULO 2: El encuentro",
    partes: 3
  }
];

const listaPestanas = document.getElementById("lista-pestañas");
const contenedorPartes = document.getElementById("contenedor-partes");

let capituloActual = location.hash ? location.hash.replace("#", "") : capitulos[0].id;
let parteActual = 0;

const selector = document.createElement("select");
selector.setAttribute("aria-label", "Seleccionar capítulo");
selector.id = "selector-capitulos";

capitulos.forEach((cap, index) => {
  const option = document.createElement("option");
  option.value = cap.id;
  option.textContent = cap.titulo;
  if (cap.id === capituloActual) option.selected = true;
  selector.appendChild(option);
});

selector.addEventListener("change", () => {
  capituloActual = selector.value;
  parteActual = 0;
  location.hash = capituloActual;
  cargarCapitulo();
});

listaPestanas.appendChild(selector);

function cargarCapitulo() {
  const capitulo = capitulos.find(c => c.id === capituloActual);
  listaPestanas.innerHTML = "";
  listaPestanas.appendChild(selector);

  for (let i = 0; i < capitulo.partes; i++) {
    const boton = document.createElement("button");
    boton.setAttribute("role", "tab");
    boton.setAttribute("aria-selected", i === parteActual);
    boton.setAttribute("aria-controls", `parte${i}`);
    boton.textContent = `Parte ${i + 1}`;
    boton.addEventListener("click", () => {
      parteActual = i;
      cargarContenidoParte(capitulo.id, parteActual);
      cargarCapitulo();
    });
    listaPestanas.appendChild(boton);
  }

  cargarContenidoParte(capitulo.id, parteActual);
}

function cargarContenidoParte(capituloId, parteIndex) {
  const xhr = new XMLHttpRequest();
  xhr.open("GET", `capitulos/${capituloId}-parte${parteIndex + 1}.txt`, true);
  xhr.onload = function () {
    if (xhr.status === 200) {
      const capitulo = capitulos.find(c => c.id === capituloId);
      contenedorPartes.innerHTML = "";

      const titulo = document.createElement("h2");
      titulo.textContent = capitulo.titulo;
      contenedorPartes.appendChild(titulo);

      const indicador = document.createElement("p");
      indicador.textContent = `Parte ${parteIndex + 1} de ${capitulo.partes}`;
      contenedorPartes.appendChild(indicador);

      const contenido = document.createElement("div");
      contenido.setAttribute("id", `parte${parteIndex}`);
      contenido.setAttribute("role", "tabpanel");
      contenido.innerHTML = `<p>${xhr.responseText.replace(/\n/g, "<br>")}</p>`;
      contenedorPartes.appendChild(contenido);
    } else {
      contenedorPartes.innerHTML = "<p>Error al cargar el contenido.</p>";
    }
  };
  xhr.send();
}

cargarCapitulo();
