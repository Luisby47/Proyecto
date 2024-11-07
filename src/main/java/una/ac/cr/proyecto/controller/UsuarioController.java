package una.ac.cr.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.proyecto.entity.Usuario;
import una.ac.cr.proyecto.service.Service;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private Service usuarioService;

    @PostMapping("/insertar")
    public ResponseEntity<Void> insertarUsuario(@RequestBody Usuario usuario) {
        usuarioService.insertarUsuario(usuario.getCedula(), usuario.getNombre(), usuario.getApellido1(),
                usuario.getApellido2(), usuario.getContrasena(), usuario.getCorreo(),
                usuario.getTelCel(), usuario.getTelHabitacion(), usuario.getDireccion(),
                usuario.getGimnasio().getId(), usuario.getRolId(), usuario.getFechaInscripcion(),
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
