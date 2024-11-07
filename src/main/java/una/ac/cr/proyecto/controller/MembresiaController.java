package una.ac.cr.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.proyecto.entity.*;
import una.ac.cr.proyecto.service.Service;
public class MembresiaController {


    @Autowired
    private Service membresiaService;

    @PostMapping("/insertar")
    public ResponseEntity<Void> insertarMembresia(@RequestBody Membresia membresia) {
        membresiaService.insertarMembresia(
                membresia.getCliente().getId(),
                membresia.getEstado(),
                membresia.getFecha()
        );
        return ResponseEntity.ok().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarMembresia(@PathVariable Long id, @RequestBody Membresia membresia) {
        membresiaService.actualizarMembresia(
                id,
                membresia.getCliente().getId(),
                membresia.getEstado(),
                membresia.getFecha()
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarMembresia(@PathVariable Long id) {
        membresiaService.eliminarMembresia(id);
        return ResponseEntity.ok().build();
    }
}