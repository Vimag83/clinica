package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @Column(name = "cedula", unique = true)
    private String cedula;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;

    private LocalDate fechaNacimiento;
    private String alergias;
}