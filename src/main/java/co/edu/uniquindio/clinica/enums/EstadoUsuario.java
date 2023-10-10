package co.edu.uniquindio.clinica.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;



public enum EstadoUsuario {
        ACTIVO,
        INACTIVO


}
