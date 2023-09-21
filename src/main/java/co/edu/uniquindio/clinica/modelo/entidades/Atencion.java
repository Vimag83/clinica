package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter@Getter
public class Atencion extends Cita implements Serializable {
    private String diagnostico, tratamiento, notasMedicas;
    //Este creo que debe ser de uno a uno con la cita, preguntar al profe

    @OneToMany(mappedBy = "atencion")
    private List<OrdenMedica> ordenesMedicas;
}
