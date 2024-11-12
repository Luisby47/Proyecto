package una.ac.cr.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.proyecto.entity.Maquina;
import una.ac.cr.proyecto.entity.Rutina;
import una.ac.cr.proyecto.service.Service;

@RestController
@RequestMapping("/rutinas")
public class RutinaController {

    @Autowired
    private Service rutinaService;

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Rutina>> listarRutinas() {
        return ResponseEntity.ok(rutinaService.listarRutinas());
    }

    @PostMapping("/insertar")
    public ResponseEntity<Void> insertarRutina(@RequestBody Rutina rutina) {
        rutinaService.insertarRutina(
                rutina.getClienteCedula().getId(),
                rutina.getInstructorCedula().getId(),
                rutina.getMaquina().getId(),
                rutina.getFecha(),
                rutina.getHoras()
        );
        return ResponseEntity.ok().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarRutina(@PathVariable Long id, @RequestBody Rutina rutina) {
        rutinaService.actualizarRutina(
                id,
                rutina.getClienteCedula().getId(),
                rutina.getInstructorCedula().getId(),
                rutina.getMaquina().getId(),
                rutina.getFecha(),
                rutina.getHoras()
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarRutina(@PathVariable Long id) {
        rutinaService.eliminarRutina(id);
        return ResponseEntity.ok().build();
    }
}
