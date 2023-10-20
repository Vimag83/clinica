package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.enums.DiaLibre;
import co.edu.uniquindio.clinica.enums.Especialidad;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico extends Usuario implements Serializable {

    @NotNull private Especialidad especialidad;

    @Column(name = "descanso")
    private DiaLibre diaLibre;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    @OneToMany(mappedBy = "medico")
    private List<Horario> horarios;
    //le quite el extends a horario y le coloque codigo al horario para dejar el mapeo.
}
