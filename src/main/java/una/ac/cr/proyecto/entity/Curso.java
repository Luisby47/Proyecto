package una.ac.cr.proyecto.entity;

import jakarta.persistence.*;
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
@Table(name = "Cursos")
public class Curso {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CURSO", nullable = false)
    private Long id;

    @Size(max = 50)
    @Column(name = "DESCRIPCION", length = 50)
    private String descripcion;


}
