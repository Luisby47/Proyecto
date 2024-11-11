package una.ac.cr.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import una.ac.cr.proyecto.entity.HistorialCurso;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface HistorialRepository extends JpaRepository<HistorialCurso, Long> {
    @Procedure(name = "ListarHistorialCursos")
    List<HistorialCurso> listarHistorialCursos();

    @Procedure(name = "insertar_historial_curso")
    void insertarHistorialCurso(
            @Param("p_cliente_cedula") Long clienteCedula,
            @Param("p_instructor_cedula") Long instructorCedula,
            @Param("p_curso") Long curso,
            @Param("p_gimnasio_id") Long gimnasioId,
            @Param("p_fecha") LocalDate fecha,
            @Param("p_horas") Long horas
    );

    @Procedure(name = "actualizar_historial_curso")
    void actualizarHistorialCurso(
            @Param("p_id_historial") Long idHistorial,
            @Param("p_cliente_cedula") Long clienteCedula,
            @Param("p_instructor_cedula") Long instructorCedula,
            @Param("p_curso") Long curso,
            @Param("p_gimnasio_id") Long gimnasioId,
            @Param("p_fecha") LocalDate fecha,
            @Param("p_horas") Long horas
    );

    @Procedure(name = "eliminar_historial_curso")
    void eliminarHistorialCurso(@Param("p_id_historial") Long idHistorial);
}
