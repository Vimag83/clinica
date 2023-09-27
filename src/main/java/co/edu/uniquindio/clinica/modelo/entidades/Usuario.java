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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends Cuenta implements Serializable {

    private String cedula;
    private String nombre;
    private String urlFoto;
    private String telefono;

    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "usuario")
    private List<Paciente> pacientes;
}



