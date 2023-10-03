package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
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



}
