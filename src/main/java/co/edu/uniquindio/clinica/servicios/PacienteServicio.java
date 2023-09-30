package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.dto.paciente.*;

import java.util.List;

public interface PacienteServicio {

    int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception;

    int editarPerfil(int codigoPaciente, RegistroPacienteDTO registroPacienteDTO) throws  Exception;

    int eliminarCuenta(int codigoPaciente) throws  Exception;
    DetallePacienteDTO verDetallePaciente(int codigo) throws  Exception;

    void enviarLinkRecuperacion(String email) throws Exception;

    void cambiarPassword(NuevoPasswordDTO nuevoPasswordDTO) throws Exception;

    int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception;

    int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception;

    List <ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;

    DetallePQRSDTO verDetallePQRS(int codigo) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws  Exception;

    List <ItemCitaDTO> listarCitasPaciente(int codigoPaciente)throws Exception;

    void filtrarCitas(FiltroBusquedaDTO filtroBusquedaDTO) throws Exception;

    DetalleAtencionMedicaDTO verDetalleCita(int codigoCita) throws Exception;

}
