package una.ac.cr.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.proyecto.entity.*;
import una.ac.cr.proyecto.service.Service;

import java.util.List;

@RestController
@RequestMapping("/historial-cursos")
public class HistorialController {

    @Autowired
    private Service historialService;

    @GetMapping("/listar")
    public ResponseEntity<List<HistorialCurso>> listarHistorialCursos() {
        return ResponseEntity.ok(historialService.listarHistorialCursos());
    }

    @PostMapping("/insertar")
    public ResponseEntity<Void> insertarHistorialCurso(@RequestBody HistorialCurso historialCurso) {
        historialService.insertarHistorialCurso(
                historialCurso.getClienteCedula().getId(),
                historialCurso.getInstructorCedula().getId(),
                historialCurso.getCurso().getId(),
                historialCurso.getGimnasio().getId(),
                historialCurso.getFecha(),
                historialCurso.getHoras()
        );
        return ResponseEntity.ok().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarHistorialCurso(@PathVariable Long id, @RequestBody HistorialCurso historialCurso) {
        historialService.actualizarHistorialCurso(
                id,
                historialCurso.getClienteCedula().getId(),
                historialCurso.getInstructorCedula().getId(),
                historialCurso.getCurso().getId(),
                historialCurso.getGimnasio().getId(),
                historialCurso.getFecha(),
                historialCurso.getHoras()
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarHistorialCurso(@PathVariable Long id) {
        historialService.eliminarHistorialCurso(id);
        return ResponseEntity.ok().build();
    }
}
