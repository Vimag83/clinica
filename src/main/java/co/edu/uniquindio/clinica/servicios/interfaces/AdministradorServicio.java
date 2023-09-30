package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.ItemMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.admin.*;
import co.edu.uniquindio.clinica.modelo.enums.EstadoPQRS;


import java.util.List;

public interface AdministradorServicio {

    String crearMedico(RegistroMedicoDTO medico) throws Exception;

    String actualizarMedico(int codigo, RegistroMedicoDTO medico) throws Exception;

    String eliminarMedico(int codigo) throws Exception;
    List <ItemMedicoDTO> listarMedicos() throws Exception;

    DetalleMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<ItemPQRSDTO> listarPQRS() throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;


    DetallePQRSDTO verDetallePQRS(int codigo) throws Exception;

    List<ItemCitaDTO> listarCitas() throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

    void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception;

}
