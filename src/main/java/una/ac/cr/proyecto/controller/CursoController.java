package una.ac.cr.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.proyecto.entity.*;
import una.ac.cr.proyecto.service.Service;

import java.util.List;


@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private Service cursoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Curso>> listarCursos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @PostMapping("/insertar")
    public ResponseEntity<Void> insertarCurso(@RequestBody Curso curso) {
        cursoService.insertarCurso(curso.getDescripcion());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarCurso(@PathVariable Long id, @RequestBody  Curso curso) {
        cursoService.actualizarCurso(id, curso.getDescripcion());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return ResponseEntity.ok().build();
    }
}
