// URL base de la API de Spring Boot
const apiUrl = 'http://localhost:8080/api/usuarios';

// Función para manejar el login
async function loginUsuario(event) {
    event.preventDefault(); // Evita el envío del formulario

    const cedula = document.getElementById('loginCedula').value;
    const contrasena = document.getElementById('loginPassword').value;

    try {
        const response = await axios.post(`${apiUrl}/login`, {
            cedula: cedula,
            contrasena: contrasena
        });

        // Si el login es exitoso, muestra los datos o redirige al usuario
        alert('Login exitoso');
        console.log('Usuario autenticado:', response.data);

        // Puedes redirigir al usuario a otra página después del login
        // window.location.href = '/pagina-principal.html';
    } catch (error) {
        alert('Error en el login. Verifica tus credenciales.');
        console.error('Error en el login:', error.response ? error.response.data : error.message);
    }
}

// Función para manejar el registro
async function registrarUsuario(event) {
    event.preventDefault(); // Evita el envío del formulario

    const cedula = document.getElementById('registerCedula').value;
    const nombre = document.getElementById('registerNombre').value;
    const contrasena = document.getElementById('registerPassword').value;
    const correo = document.getElementById('registerCorreo').value;

    try {
        const response = await axios.post(`${apiUrl}/insertar`, {
            cedula: cedula,
            nombre: nombre,
            contrasena: contrasena,
            correo: correo
            // Incluye otros datos necesarios de registro según tu API
        });

        alert('Registro exitoso');
        console.log('Usuario registrado:', response.data);

        // Opcionalmente, redirige al usuario al login después de registrarse
        // window.location.href = '/login.html';
    } catch (error) {
        alert('Error en el registro.');
        console.error('Error en el registro:', error.response ? error.response.data : error.message);
    }
}

// Asigna los eventos de submit a los formularios
document.getElementById('loginForm').addEventListener('submit', loginUsuario);
document.getElementById('registerForm').addEventListener('submit', registrarUsuario);
