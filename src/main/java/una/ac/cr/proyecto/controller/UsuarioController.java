package una.ac.cr.proyecto.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.proyecto.entity.Gimnasio;
import una.ac.cr.proyecto.entity.Usuario;
import una.ac.cr.proyecto.service.Service;

@Controller("Usuario")
public class UsuarioController {

    @Autowired
    private Service usuarioService;

    // Inicio
    @GetMapping("/")
    public String inicio(Model model) {
        Gimnasio gimnasio = usuarioService.obtenerGimnasio();
        model.addAttribute("gimnasio", gimnasio);
        return "/inicio";
    }

    // Mostrar formulario de login
    @GetMapping("/login")
    public String show(Model model) {

        model.addAttribute("usuario", new Usuario());

        return "/Login/login";

    }

    // Cerrar sesión
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // Invalida la sesión
        return "redirect:/";
    }

    // Login
    @PostMapping("/login")
    public String login(@RequestParam("cedula") Long cedula,
                        @RequestParam("contrasena") String contrasena,
                        Model model,
                        HttpSession session) {
        Usuario usuarioLogin = usuarioService.validarUsuario(cedula, contrasena);

        if (usuarioLogin != null) {
            session.setAttribute("usuario", usuarioLogin);
            return "redirect:/";  // Redirige a la página de usuarios después de un login exitoso
        } else {
            model.addAttribute("error", true);
            return "redirect:/login";  // Redirige al formulario de login con un mensaje de error
        }
    }

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "/Contactos/contactos";  // La vista HTML a renderizar
    }


    @GetMapping("/listarClientes")
    public ResponseEntity<Iterable<Usuario>> listarClientes() {
        return ResponseEntity.ok(usuarioService.listarClientes());
    }


        @GetMapping("/listarInstructores")
    public ResponseEntity<Iterable<Usuario>> listarInstructores() {
        return ResponseEntity.ok(usuarioService.listarInstructores());
    }

    // Formulario de Inserción de Usuario
    @GetMapping("/nuevo")
    public String mostrarFormularioInsertar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/insertar";
    }

    @PostMapping("/insertar")
    public String insertarUsuario(@ModelAttribute Usuario usuario) {
        Gimnasio gimnasio = usuarioService.obtenerGimnasio();
        usuarioService.insertarUsuario(usuario.getCedula(), usuario.getNombre(), usuario.getApellido1(),
                usuario.getApellido2(), usuario.getContrasena(), usuario.getCorreo(),
                usuario.getTelCel(), usuario.getTelHabitacion(), usuario.getDireccion(),
                gimnasio.getId(), usuario.getRol(), usuario.getFechaInscripcion(),
                usuario.getFechaContratacion());
        return "redirect:/usuarios/listar";
    }


    // Formulario de Actualización de Usuario
    @GetMapping("/editar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        model.addAttribute("usuario", usuario);
        return "usuarios/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarUsuario(@PathVariable Long id, @ModelAttribute Usuario usuario) {
        usuarioService.actualizarUsuario(id, usuario.getCedula(), usuario.getNombre(), usuario.getApellido1(),
                usuario.getApellido2(), usuario.getContrasena(), usuario.getCorreo(),
                usuario.getTelCel(), usuario.getTelHabitacion(), usuario.getDireccion(),
                usuario.getGimnasio().getId(), usuario.getRol(), usuario.getFechaInscripcion(),
                usuario.getFechaContratacion());
        return "redirect:/usuarios/listar";
    }

    // Eliminar Usuario
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios/listar";
    }
}
