package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.enums.Especialidad;

public record ItemMedicoDTO(

        Integer codigo,
        String nombre,
        String cedula,
        String urlFoto,
       Especialidad especialidad) {
}
