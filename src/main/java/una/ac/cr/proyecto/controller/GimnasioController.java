package una.ac.cr.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.proyecto.entity.Gimnasio;
import una.ac.cr.proyecto.service.Service;

@RestController
@RequestMapping("/api/gimnasios")
public class GimnasioController {

    @Autowired
    private Service gimnasioService;

    @PostMapping("/insertar")
    public ResponseEntity<Void> insertarGimnasio(
            @RequestBody Gimnasio gimnasio) {

        gimnasioService.insertarGimnasio(
                gimnasio.getNombre(),
                gimnasio.getDireccion(),
                gimnasio.getHorario(),
                gimnasio.getTelefono(),
                gimnasio.getCorreo()
        );
        return ResponseEntity.ok().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizarGimnasio(
            @PathVariable Long id,
            @RequestBody Gimnasio gimnasio) {

        gimnasioService.actualizarGimnasio(
                id,
                gimnasio.getNombre(),
                gimnasio.getDireccion(),
                gimnasio.getHorario(),
                gimnasio.getTelefono(),
                gimnasio.getCorreo()
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarGimnasio(@PathVariable Long id) {
        gimnasioService.eliminarGimnasio(id);
        return ResponseEntity.ok().build();
    }

}