package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.enums.DiaLibre;
import co.edu.uniquindio.clinica.enums.Especialidad;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Medico extends Usuario implements Serializable {

    private Especialidad especialidad;

    @OneToMany(mappedBy = "medico")
    private List<Horario> horarios;

    @Column(name = "descanso")
    private DiaLibre diaLibre;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;


}
