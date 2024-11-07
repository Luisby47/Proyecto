package una.ac.cr.proyecto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Gimnasio")
public class Gimnasio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_GIMNASIO", nullable = false)
    private Long id;

    @Size(max = 50)
    @Column(name = "NOMBRE", length = 50)
    private String nombre;

    @Size(max = 100)
    @Column(name = "DIRECCION", length = 100)
    private String direccion;

    @Size(max = 50)
    @Column(name = "HORARIO", length = 50)
    private String horario;

    @Column(name = "TELEFONO")
    private Long telefono;

    @Size(max = 50)
    @NotNull
    @Column(name = "CORREO", nullable = false, length = 50)
    private String correo;


}
