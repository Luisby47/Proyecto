package una.ac.cr.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import una.ac.cr.proyecto.entity.Usuario;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    @Procedure(name = "ListarClientes")
    List<Usuario> listarClientes();

    @Procedure(name = "ListarUsuarios")
    List<Usuario> listarUsuarios();

    @Procedure(name = "ListarInstructores")
    List<Usuario> listarInstructores();

    @Procedure(name = "ObtenerUsuarioPorCedula")
    Usuario obtenerUsuarioPorCedula(@Param("cedula") Long cedula);

    @Procedure(name = "ObtenerUsuarioPorId")
    Usuario obtenerUsuarioPorId(@Param("id_usuario") Long idUsuario);

    @Procedure(name = "insertar_usuario")
    void insertarUsuario(
            @Param("p_cedula") Long cedula,
            @Param("p_nombre") String nombre,
            @Param("p_apellido1") String apellido1,
            @Param("p_apellido2") String apellido2,
            @Param("p_contraseña") String contrasena,
            @Param("p_correo") String correo,
            @Param("p_tel_cel") Long telCel,
            @Param("p_tel_habitacion") Long telHabitacion,
            @Param("p_direccion") String direccion,
            @Param("p_gimnasio_id") Long gimnasioId,
            @Param("p_rol_id") Long rolId,
            @Param("p_fecha_inscripcion") LocalDate fechaInscripcion,
            @Param("p_fecha_contratacion") LocalDate fechaContratacion
    );

    @Procedure(name = "actualizar_usuario")
    void actualizarUsuario(
            @Param("p_id_usuario") Long idUsuario,
            @Param("p_cedula") Long cedula,
            @Param("p_nombre") String nombre,
            @Param("p_apellido1") String apellido1,
            @Param("p_apellido2") String apellido2,
            @Param("p_contraseña") String contrasena,
            @Param("p_correo") String correo,
            @Param("p_tel_cel") Long telCel,
            @Param("p_tel_habitacion") Long telHabitacion,
            @Param("p_direccion") String direccion,
            @Param("p_gimnasio_id") Long gimnasioId,
            @Param("p_rol_id") Long rolId,
            @Param("p_fecha_inscripcion") LocalDate fechaInscripcion,
            @Param("p_fecha_contratacion") LocalDate fechaContratacion
    );

    @Procedure(name = "eliminar_usuario")
    void eliminarUsuario(@Param("p_id_usuario") Long idUsuario);
}
