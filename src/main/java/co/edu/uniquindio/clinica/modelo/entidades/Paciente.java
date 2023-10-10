package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.enums.EPS;
import co.edu.uniquindio.clinica.enums.TipoSangre;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter@Setter
@NoArgsConstructor
public class Paciente extends Usuario implements Serializable {

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;

    @Column(name = "fecha de nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(length = 100)
    private String alergias;

    @Column(nullable = false)
    private EPS eps;

    @Column(nullable = false)
    private TipoSangre tipoSangre;
}
