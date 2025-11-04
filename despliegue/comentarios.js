document.addEventListener("DOMContentLoaded", () => {
  const tabla = document.querySelector("#tabla-comentarios tbody");
  const filtro = document.getElementById("filtro");

  filtro.addEventListener("change", () => cargarComentarios(filtro.value));
  document.getElementById("tipo").addEventListener("change", mostrarCampoCapitulo);

  cargarComentarios("todos");
});

function mostrarCampoCapitulo() {
  const tipo = document.getElementById("tipo").value;
  const campo = document.getElementById("capitulo");
  const label = document.getElementById("capitulo-label");
  if (tipo === "capitulo") {
    campo.style.display = "inline-block";
    label.style.display = "inline-block";
  } else {
    campo.style.display = "none";
    label.style.display = "none";
  }
}

function cargarComentarios(filtro) {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function () {
    const xml = xhttp.responseXML;
    const comentarios = xml.getElementsByTagName("comentario");
    const tabla = document.querySelector("#tabla-comentarios tbody");
    tabla.innerHTML = "";

    for (let i = 0; i < comentarios.length; i++) {
      const tipo = comentarios[i].getElementsByTagName("tipo")[0].textContent;
      if (filtro !== "todos" && filtro !== tipo) continue;

      const nombre = comentarios[i].getElementsByTagName("nombre")[0].textContent;
      const capitulo = comentarios[i].getElementsByTagName("capitulo")[0].textContent;
      const texto = comentarios[i].getElementsByTagName("texto")[0].textContent;

      const fila = `<tr>
                      <td>${nombre}</td>
                      <td>${tipo}</td>
                      <td>${capitulo || "-"}</td>
                      <td>${texto}</td>
                    </tr>`;
      tabla.innerHTML += fila;
    }
  };
  xhttp.open("GET", "comentarios.xml");
  xhttp.send();
}