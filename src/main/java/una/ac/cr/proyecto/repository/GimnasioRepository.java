package una.ac.cr.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import una.ac.cr.proyecto.entity.Gimnasio;

@Repository
public interface GimnasioRepository extends JpaRepository<Gimnasio, Long> {


    @Procedure(name = "insertar_gimnasio")
    void insertarGimnasio(
            @Param("p_nombre") String nombre,
            @Param("p_direccion") String direccion,
            @Param("p_horario") String horario,
            @Param("p_telefono") Long telefono,
            @Param("p_correo") String correo
    );

    @Procedure(name = "actualizar_gimnasio")
    void actualizarGimnasio(
            @Param("p_id_gimnasio") Long idGimnasio,
            @Param("p_nombre") String nombre,
            @Param("p_direccion") String direccion,
            @Param("p_horario") String horario,
            @Param("p_telefono") Long telefono,
            @Param("p_correo") String correo
    );

    @Procedure(name = "eliminar_gimnasio")
    void eliminarGimnasio(@Param("p_id_gimnasio") Long idGimnasio);
}
