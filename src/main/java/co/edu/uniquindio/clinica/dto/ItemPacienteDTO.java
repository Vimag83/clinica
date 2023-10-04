package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;

public record ItemPacienteDTO(

        int codigo,
        String cedula,
        String nombre,

        Ciudad ciudad
) {
}
