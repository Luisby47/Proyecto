package una.ac.cr.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.proyecto.entity.Maquina;
import una.ac.cr.proyecto.service.Service;

@RestController
@RequestMapping("/api/maquinas")
public class MaquinaController {

    @Autowired
    private Service maquinaService;

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Maquina>> listarMaquinas() {
        return ResponseEntity.ok(maquinaService.listarMaquinas());
    }

    @PostMapping("/insertar")
    public ResponseEntity<Void> insertarMaquina(@RequestBody Maquina maquina) {
        maquinaService.insertarMaquina(maquina.getDescripcion(), maquina.getEstado(), maquina.getId());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarMaquina(@PathVariable Long id, @RequestBody Maquina maquina) {
        maquinaService.actualizarMaquina(id, maquina.getDescripcion(), maquina.getEstado(), maquina.getId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarMaquina(@PathVariable Long id) {
        maquinaService.eliminarMaquina(id);
        return ResponseEntity.ok().build();
    }
}

