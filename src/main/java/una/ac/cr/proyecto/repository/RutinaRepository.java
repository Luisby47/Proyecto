package una.ac.cr.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import una.ac.cr.proyecto.entity.Rutina;

import java.time.LocalDate;
import java.util.Date;

@Repository
public interface RutinaRepository extends JpaRepository<Rutina, Long> {
    @Procedure(name = "insertar_rutina")
    void insertarRutina(
            @Param("p_cliente_cedula") Long clienteCedula,
            @Param("p_instructor_cedula") Long instructorCedula,
            @Param("p_maquina") Long maquina,
            @Param("p_fecha") LocalDate fecha,
            @Param("p_horas") Long horas
    );

    @Procedure(name = "actualizar_rutina")
    void actualizarRutina(
            @Param("p_id_rutina") Long idRutina,
            @Param("p_cliente_cedula") Long clienteCedula,
            @Param("p_instructor_cedula") Long instructorCedula,
            @Param("p_maquina") Long maquina,
            @Param("p_fecha") LocalDate fecha,
            @Param("p_horas") Long horas
    );

    @Procedure(name = "eliminar_rutina")
    void eliminarRutina(@Param("p_id_rutina") Long idRutina);
}
