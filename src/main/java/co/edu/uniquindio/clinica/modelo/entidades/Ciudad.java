package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ciudad implements Serializable{

    @OneToMany(mappedBy="ciudad")
    private List<Usuario> usuarios;

    @Id
    private Integer codigo;

    @Getter
    private String nombre;


}
