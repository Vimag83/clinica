package co.edu.uniquindio.clinica.dto.admin;

public record ItemMedicoDTO(

        Integer codigo, String nombre,
        String cedula,
        String urlFoto,
        co.edu.uniquindio.clinica.modelo.entidades.Especialidad especialidad) {
}
