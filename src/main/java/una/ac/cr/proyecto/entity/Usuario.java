package una.ac.cr.proyecto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Usuario")
public class Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "CEDULA", nullable = false)
    private Long cedula;

    @Size(max = 50)
    @Column(name = "NOMBRE", length = 50)
    private String nombre;

    @Size(max = 30)
    @Column(name = "APELLIDO1", length = 30)
    private String apellido1;

    @Size(max = 30)
    @Column(name = "APELLIDO2", length = 30)
    private String apellido2;

    @Size(max = 30)
    @Column(name = "\"CONTRASEÑA\"", length = 30)
    private String contrasena;

    @Size(max = 50)
    @NotNull
    @Column(name = "CORREO", nullable = false, length = 50)
    private String correo;

    @Column(name = "TEL_CEL")
    private Long telCel;

    @Column(name = "TEL_HABITACION")
    private Long telHabitacion;

    @Size(max = 100)
    @Column(name = "DIRECCION", length = 100)
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "GIMNASIO_ID")
    private Gimnasio gimnasio;

    @Column(name = "ROL_ID")
    private Long rolId;

    @Column(name = "FECHA_INSCRIPCION")
    private LocalDate fechaInscripcion;

    @Column(name = "FECHA_CONTRATACION")
    private LocalDate fechaContratacion;

}
