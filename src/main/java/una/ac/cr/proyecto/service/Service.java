package una.ac.cr.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import una.ac.cr.proyecto.repository.*;

import java.time.LocalDate;

@org.springframework.stereotype.Service
public class Service {


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


    public void insertarUsuario(Long cedula, String nombre, String apellido1, String apellido2, String contrasena,
                                String correo, Long telCel, Long telHabitacion, String direccion, Long gimnasioId,
                                Long rolId, LocalDate fechaInscripcion, LocalDate fechaContratacion) {
        usuarioRepository.insertarUsuario(cedula, nombre, apellido1, apellido2, contrasena, correo, telCel,
                telHabitacion, direccion, gimnasioId, rolId, fechaInscripcion, fechaContratacion);
    }

    public void actualizarUsuario(Long idUsuario, Long cedula, String nombre, String apellido1, String apellido2,
                                  String contrasena, String correo, Long telCel, Long telHabitacion, String direccion,
                                  Long gimnasioId, Long rolId, LocalDate fechaInscripcion, LocalDate fechaContratacion) {
        usuarioRepository.actualizarUsuario(idUsuario, cedula, nombre, apellido1, apellido2, contrasena, correo,
                telCel, telHabitacion, direccion, gimnasioId, rolId, fechaInscripcion, fechaContratacion);
    }

    public void eliminarUsuario(Long idUsuario) {
        usuarioRepository.eliminarUsuario(idUsuario);
    }


    /* --------------------------------------- Maquina Repository ---------------------------------------*/


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
