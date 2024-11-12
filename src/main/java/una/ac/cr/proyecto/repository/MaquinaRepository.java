package una.ac.cr.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import una.ac.cr.proyecto.entity.Maquina;

import java.util.List;

@Repository
public interface MaquinaRepository  extends JpaRepository<Maquina, Long> {


    @Procedure(name = "insertar_maquina")
    void insertarMaquina(
            @Param("p_descripcion") String descripcion,
            @Param("p_estado") String estado,
            @Param("p_gimnasio_id") Long gimnasioId
    );

    @Procedure(name = "actualizar_maquina")
    void actualizarMaquina(
            @Param("p_id_maquina") Long idMaquina,
            @Param("p_descripcion") String descripcion,
            @Param("p_estado") String estado,
            @Param("p_gimnasio_id") Long gimnasioId
    );

    @Procedure(name = "eliminar_maquina")
    void eliminarMaquina(@Param("p_id_maquina") Long idMaquina);

}
