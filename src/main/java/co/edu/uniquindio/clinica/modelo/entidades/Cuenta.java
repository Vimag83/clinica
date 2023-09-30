package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cuenta implements Serializable{

    @OneToMany(mappedBy = "cuenta")
    private List<Mensaje> mensajes;

    @Getter
    @Id
    private Integer codigo;
    private String correo;
    private String password;

}
