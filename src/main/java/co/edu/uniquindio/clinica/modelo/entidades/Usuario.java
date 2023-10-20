package co.edu.uniquindio.clinica.modelo.entidades;


import co.edu.uniquindio.clinica.enums.EstadoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @Column(name = "documento_identificacion", nullable = false, unique = true)
    private String cedula;

    @Column (name = "nombre", nullable = false)
    private String nombre;

    private String urlFoto;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @NotNull
    private EstadoUsuario estadoUsuario;

    @ManyToOne
    private Ciudad ciudad;

}
