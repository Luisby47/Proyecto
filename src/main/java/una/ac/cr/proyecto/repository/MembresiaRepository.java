package una.ac.cr.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import una.ac.cr.proyecto.entity.Membresia;

import java.time.LocalDate;

@Repository
public interface MembresiaRepository  extends JpaRepository<Membresia, Long> {
    @Procedure(name = "ObtenerMembresiaPorCliente")
    Membresia obtenerMembresiaPorCliente(@Param("id_cliente") Long idCliente);

    @Procedure(name = "ObtenerMembresia")
    Membresia obtenerMembresia(@Param("id_membresia") Long idMembresia);

    @Procedure(name = "insertar_membresia")
    void insertarMembresia(
            @Param("p_cliente_id") Long clienteId,
            @Param("p_estado") String estado,
            @Param("p_fecha") LocalDate fecha
    );

    @Procedure(name = "actualizar_membresia")
    void actualizarMembresia(
            @Param("p_id_membresia") Long idMembresia,
            @Param("p_cliente_id") Long clienteId,
            @Param("p_estado") String estado,
            @Param("p_fecha") LocalDate fecha
    );

    @Procedure(name = "eliminar_membresia")
    void eliminarMembresia(@Param("p_id_membresia") Long idMembresia);
}
