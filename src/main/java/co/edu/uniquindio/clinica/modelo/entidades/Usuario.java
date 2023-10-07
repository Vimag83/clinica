package co.edu.uniquindio.clinica.modelo.entidades;


import co.edu.uniquindio.clinica.enums.EstadoUsuario;
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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends Cuenta implements Serializable{

    @ManyToOne
    private Ciudad ciudad;

    @Column(name = "documento_identificación", nullable = false, unique = true)
    private String cedula;

    @Column (name = "nombre", nullable = false)
    private String nombre;

    private String urlFoto;
    private String telefono;
    private EstadoUsuario estadoUsuario;

}
