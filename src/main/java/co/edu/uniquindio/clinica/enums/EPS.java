package co.edu.uniquindio.clinica.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;

public enum EPS {
    EPS_SURA("EPS Sura"),
    EPS_SANITAS("EPS Sanitas"),
    EPS_FAMISANAR("EPS Famisanar"),
    EPS_ALIANSALUD("EPS Aliansalud"),
    EPS_COOMEVA("EPS Coomeva"),
    EPS_SALUD_TOTAL("EPS Salud Total"),
    EPS_COMPENSAR("EPS Compensar"),
    EPS_NUEVA_EPS("EPS Nueva EPS"),
    EPS_CRUZ_BLANCA("EPS Cruz Blanca"),
    EPS_SOS("EPS Servicio Occidental de Salud (SOS)");

    private String nombre;

    EPS(String nombre) {
        this.nombre = nombre;
    }
}
