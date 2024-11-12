package una.ac.cr.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.proyecto.entity.Gimnasio;
import una.ac.cr.proyecto.service.Service;

@Controller
@RequestMapping("/gimnasios")
public class GimnasioController {

    @Autowired
    private Service gimnasioService;

    @GetMapping("/show")
    public String show(Model model) {
        Gimnasio gimnasio = gimnasioService.obtenerGimnasio();
        model.addAttribute("gimnasio", gimnasio);
        return "gimnasios/show";
    }

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