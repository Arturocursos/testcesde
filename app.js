// Simulación de base de datos con arreglos
let cursos = [];
let docentes = [];

// Agregar curso
document.getElementById("cursoForm")?.addEventListener("submit", function(event) {
    event.preventDefault();
    const nuevoCurso = {
        nombre: document.getElementById("nombre").value,
        descripcion: document.getElementById("descripcion").value,
        duracion: document.getElementById("duracion").value,
        precio: document.getElementById("precio").value,
        fecha: document.getElementById("fecha").value,
        docente: document.getElementById("docente").value
    };
    cursos.push(nuevoCurso);
    alert("Curso agregado exitosamente!");
    this.reset();
});

// Agregar docente
document.getElementById("docenteForm")?.addEventListener("submit", function(event) {
    event.preventDefault();
    const nuevoDocente = {
        nombre: document.getElementById("nombreDocente").value,
        documento: document.getElementById("documento").value,
        correo: document.getElementById("correo").value
    };
    docentes.push(nuevoDocente);
    alert("Docente agregado exitosamente!");
    this.reset();
});

// Mostrar cursos
function mostrarCursos() {
    const tbody = document.getElementById("cursosTable").querySelector("tbody");
    tbody.innerHTML = "";
    cursos.forEach((curso, index) => {
        const row = `<tr>
            <td>${curso.nombre}</td>
            <td>${curso.descripcion}</td>
            <td>${curso.duracion} semanas</td>
            <td>$${curso.precio}</td>
            <td>${new Date(curso.fecha).toLocaleString()}</td>
            <td>${curso.docente}</td>
            <td><button onclick="eliminarCurso(${index})">Eliminar</button></td>
        </tr>`;
        tbody.innerHTML += row;
    });
}

// Eliminar curso
function eliminarCurso(index) {
    cursos.splice(index, 1);
    mostrarCursos();
}

// Mostrar docentes
function mostrarDocentes() {
    const tbody = document.getElementById("docentesTable").querySelector("tbody");
    tbody.innerHTML = "";
    docentes.forEach((docente, index) => {
        const row = `<tr>
            <td>${docente.nombre}</td>
            <td>${docente.documento}</td>
            <td>${docente.correo}</td>
            <td><button onclick="eliminarDocente(${index})">Eliminar</button></td>
        </tr>`;
        tbody.innerHTML += row;
    });
}

// Eliminar docente
function eliminarDocente(index) {
    docentes.splice(index, 1);
    mostrarDocentes();
}

// Llamar a las funciones para mostrar los datos al cargar la página
window.onload = function() {
    mostrarCursos();
    mostrarDocentes();
};
