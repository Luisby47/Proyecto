package una.ac.cr.proyecto.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "HISTORIAL_CURSO")
public class HistorialCurso {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_HISTORIAL", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURSO")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GIMNASIO_ID")
    private Gimnasio gimnasio;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "CLIENTE_CEDULA")
    private Usuario clienteCedula;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "INSTRUCTOR_CEDULA")
    private Usuario instructorCedula;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "HORAS")
    private Long horas;

}