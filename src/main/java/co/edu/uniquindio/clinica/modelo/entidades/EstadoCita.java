package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;

public enum EstadoCita {
    PENDIENTE("Pendiente"),
    CONFIRMADA("Confirmada"),
    CANCELADA_PACIENTE("Cancelada por el paciente"),
    CANCELADA_MEDICO("Cancelada por el médico"),
    EN_CURSO("En curso"),
    COMPLETADA("Completada");

    private String nombre;

    EstadoCita(String nombre) {
        this.nombre = nombre;
    }

}
