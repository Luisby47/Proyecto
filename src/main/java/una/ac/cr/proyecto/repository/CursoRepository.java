package una.ac.cr.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import una.ac.cr.proyecto.entity.Curso;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    @Procedure(name = "ListarCursos")
    List<Curso> listarCursos();

    @Procedure(name = "insertar_curso")
    void insertarCurso(@Param("p_descripcion") String descripcion);

    @Procedure(name = "actualizar_curso")
    void actualizarCurso(
            @Param("p_id_curso") Long idCurso,
            @Param("p_descripcion") String descripcion
    );

    @Procedure(name = "eliminar_curso")
    void eliminarCurso(@Param("p_id_curso") Long idCurso);
}
