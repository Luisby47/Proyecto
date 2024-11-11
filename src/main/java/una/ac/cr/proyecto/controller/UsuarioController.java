package una.ac.cr.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.proyecto.entity.Gimnasio;
import una.ac.cr.proyecto.entity.Usuario;
import una.ac.cr.proyecto.service.Service;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private Service usuarioService;
    @Autowired
    private Service service;


    // Login
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
        Usuario usuarioLogin = usuarioService.obtenerUsuarioPorCedula(usuario.getCedula());
        if (usuarioLogin != null && usuarioLogin.getContrasena().equals(usuario.getContrasena())) {
            return ResponseEntity.ok(usuarioLogin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }


    @GetMapping("/listarClientes")
    public ResponseEntity<Iterable<Usuario>> listarClientes() {
        return ResponseEntity.ok(usuarioService.listarClientes());
    }


    @GetMapping("/listarInstructores")
    public ResponseEntity<Iterable<Usuario>> listarInstructores() {
        return ResponseEntity.ok(usuarioService.listarInstructores());
    }

    @PostMapping("/insertar")
    public ResponseEntity<Void> insertarUsuario(@RequestBody Usuario usuario) {

        Gimnasio gimnasio = usuarioService.obtenerGimnasio();
        usuarioService.insertarUsuario(usuario.getCedula(), usuario.getNombre(), usuario.getApellido1(),
                usuario.getApellido2(), usuario.getContrasena(), usuario.getCorreo(),
                usuario.getTelCel(), usuario.getTelHabitacion(), usuario.getDireccion(),
                gimnasio.getId(), usuario.getRolId(), usuario.getFechaInscripcion(),
                usuario.getFechaContratacion());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuarioService.actualizarUsuario(id, usuario.getCedula(), usuario.getNombre(), usuario.getApellido1(),
                usuario.getApellido2(), usuario.getContrasena(), usuario.getCorreo(),
                usuario.getTelCel(), usuario.getTelHabitacion(), usuario.getDireccion(),
                usuario.getGimnasio().getId(), usuario.getRolId(), usuario.getFechaInscripcion(),
                usuario.getFechaContratacion());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok().build();
    }
}
