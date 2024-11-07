package una.ac.cr.proyecto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Maquinas")
public class Maquina {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MAQUINA", nullable = false)
    private Long id;

    @Size(max = 50)
    @Column(name = "DESCRIPCION", length = 50)
    private String descripcion;

    @Size(max = 15)
    @Column(name = "ESTADO", length = 15)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "GIMNASIO_ID")
    private Gimnasio gimnasio;

}
