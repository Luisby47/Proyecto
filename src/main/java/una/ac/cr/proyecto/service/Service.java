package una.ac.cr.proyecto.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import una.ac.cr.proyecto.entity.*;
import una.ac.cr.proyecto.repository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MaquinaRepository maquinaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private RutinaRepository rutinaRepository;

    @Autowired
    private HistorialRepository historialRepository;

    @Autowired
    private MembresiaRepository membresiaRepository;


    /* --------------------------------------- Gimnasio Repository ---------------------------------------*/

    public Gimnasio obtenerGimnasio() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ObtenerGimnasio", Gimnasio.class);
        query.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);

        query.execute();
        return (Gimnasio) query.getSingleResult();
    }

    public void insertarGimnasio(String nombre, String direccion, String horario, Long telefono, String correo) {
        gimnasioRepository.insertarGimnasio(nombre, direccion, horario, telefono, correo);
    }

    public void actualizarGimnasio(Long idGimnasio, String nombre, String direccion, String horario, Long telefono, String correo) {
        gimnasioRepository.actualizarGimnasio(idGimnasio, nombre, direccion, horario, telefono, correo);
    }

    public void eliminarGimnasio(Long idGimnasio) {
        gimnasioRepository.eliminarGimnasio(idGimnasio);
    }


    /* --------------------------------------- Usuario Repository ---------------------------------------*/

    public Usuario validarUsuario(Long cedula, String contrasena) {
        Usuario usuario = obtenerUsuarioPorCedula(cedula);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return usuario;  // Devuelve el usuario si las credenciales coinciden
        }
        return null;  // Retorna null si no hay coincidencia
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> listarClientes() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ListarClientes", Usuario.class);
        query.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);

        query.execute();
        return (List<Usuario>) query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> listarUsuarios() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ListarUsuarios", Usuario.class);
        query.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);

        query.execute();
        return (List<Usuario>) query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> listarInstructores() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ListarInstructores", Usuario.class);
        query.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);

        query.execute();
        return (List<Usuario>) query.getResultList();


    }

    @SuppressWarnings("unchecked")
    public Usuario obtenerUsuarioPorCedula(Long cedula) {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ObtenerUsuarioPorCedula", Usuario.class);
        query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, void.class, ParameterMode.REF_CURSOR); // cursor_usuario (salida)


        query.setParameter(1, cedula);
        query.execute();

        List<Usuario> usuarios = (List<Usuario>) query.getResultList();
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios.getFirst();

    }

    public Usuario obtenerUsuarioPorId(Long idUsuario) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ObtenerUsuarioPorId", Usuario.class);
        query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);


        query.setParameter(1, idUsuario);
        query.execute();
        return (Usuario) query.getSingleResult();
    }

    public void insertarUsuario(Long cedula, String nombre, String apellido1, String apellido2, String contrasena,
                                String correo, Long telCel, Long telHabitacion, String direccion, Long gimnasioId,
                                String rol, LocalDate fechaInscripcion, LocalDate fechaContratacion) {
        usuarioRepository.insertarUsuario(cedula, nombre, apellido1, apellido2, contrasena, correo, telCel,
                telHabitacion, direccion, gimnasioId, rol, fechaInscripcion, fechaContratacion);
    }

    public void actualizarUsuario(Long idUsuario, Long cedula, String nombre, String apellido1, String apellido2,
                                  String contrasena, String correo, Long telCel, Long telHabitacion, String direccion,
                                  Long gimnasioId, String rol, LocalDate fechaInscripcion, LocalDate fechaContratacion) {
        usuarioRepository.actualizarUsuario(idUsuario, cedula, nombre, apellido1, apellido2, contrasena, correo,
                telCel, telHabitacion, direccion, gimnasioId, rol, fechaInscripcion, fechaContratacion);
    }

    public void eliminarUsuario(Long idUsuario) {
        usuarioRepository.eliminarUsuario(idUsuario);
    }


    /* --------------------------------------- Maquina Repository ---------------------------------------*/

    @SuppressWarnings("unchecked")
    public List<Maquina> listarMaquinas() {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ListarMaquinas", Maquina.class);
        query.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);

        query.execute();
        return (List<Maquina>) query.getResultList();
    }

    public void insertarMaquina(String descripcion, String estado, Long gimnasioId) {
        maquinaRepository.insertarMaquina(descripcion, estado, gimnasioId);
    }

    public void actualizarMaquina(Long idMaquina, String descripcion, String estado, Long gimnasioId) {
        maquinaRepository.actualizarMaquina(idMaquina, descripcion, estado, gimnasioId);
    }

    public void eliminarMaquina(Long idMaquina) {
        maquinaRepository.eliminarMaquina(idMaquina);
    }


    /* --------------------------------------- Curso Repository ---------------------------------------*/

    @SuppressWarnings("unchecked")
    public List<Curso> listarCursos() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ListarCursos", Curso.class);
        query.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);

        query.execute();
        return (List<Curso>) query.getResultList();
    }

    public void insertarCurso(String descripcion) {
        cursoRepository.insertarCurso(descripcion);
    }

    public void actualizarCurso(Long idCurso, String descripcion) {
        cursoRepository.actualizarCurso(idCurso, descripcion);
    }

    public void eliminarCurso(Long idCurso) {
        cursoRepository.eliminarCurso(idCurso);
    }

    /* --------------------------------------- Rutina Repository ---------------------------------------*/
    @SuppressWarnings("unchecked")
    public List<Rutina> listarRutinas() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ListarRutinas", Rutina.class);
        query.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);

        query.execute();
        return (List<Rutina>) query.getResultList();
    }

    public void insertarRutina(Long clienteCedula, Long instructorCedula, Long maquina, LocalDate fecha, Long horas) {
        rutinaRepository.insertarRutina(clienteCedula, instructorCedula, maquina, fecha, horas);
    }

    public void actualizarRutina(Long idRutina, Long clienteCedula, Long instructorCedula, Long maquina, LocalDate fecha, Long horas) {
        rutinaRepository.actualizarRutina(idRutina, clienteCedula, instructorCedula, maquina, fecha, horas);
    }

    public void eliminarRutina(Long idRutina) {
        rutinaRepository.eliminarRutina(idRutina);
    }

    /* --------------------------------------- Historial Repository ---------------------------------------*/

    @SuppressWarnings("unchecked")
    public List<HistorialCurso> listarHistorialCursos() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ListarHistorialCursos", HistorialCurso.class);
        query.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);

        query.execute();
        return (List<HistorialCurso>) query.getResultList();
    }

    public void insertarHistorialCurso(Long clienteCedula, Long instructorCedula, Long curso, Long gimnasioId, LocalDate fecha, Long horas) {
        historialRepository.insertarHistorialCurso(clienteCedula, instructorCedula, curso, gimnasioId, fecha, horas);
    }

    public void actualizarHistorialCurso(Long idHistorial, Long clienteCedula, Long instructorCedula, Long curso, Long gimnasioId, LocalDate fecha, Long horas) {
        historialRepository.actualizarHistorialCurso(idHistorial, clienteCedula, instructorCedula, curso, gimnasioId, fecha, horas);
    }

    public void eliminarHistorialCurso(Long idHistorial) {
        historialRepository.eliminarHistorialCurso(idHistorial);
    }

    /* --------------------------------------- Membresia Repository ---------------------------------------*/


    public Membresia obtenerMembresiaPorId(Long idMembresia) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ObtenerMembresiaPorId", Membresia.class);
        query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, void.class, ParameterMode.REF_CURSOR);

        query.setParameter(1, idMembresia);
        query.execute();
        return (Membresia) query.getSingleResult();
    }

    public Membresia obtenerMembresiaPorClienteId(Long clienteId) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ObtenerMembresiaPorClienteId", Membresia.class);
        query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, void.class, ParameterMode.REF_CURSOR);

        query.setParameter(1, clienteId);
        query.execute();
        return (Membresia) query.getSingleResult();
    }


    public void insertarMembresia(Long clienteId, String estado, LocalDate fecha) {
        membresiaRepository.insertarMembresia(clienteId, estado, fecha);
    }

    public void actualizarMembresia(Long idMembresia, Long clienteId, String estado, LocalDate fecha) {
        membresiaRepository.actualizarMembresia(idMembresia, clienteId, estado, fecha);
    }

    public void eliminarMembresia(Long idMembresia) {
        membresiaRepository.eliminarMembresia(idMembresia);
    }


}
