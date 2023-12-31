package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.modelo.entidades.Atencion;

import java.util.List;

public interface PacienteServicio {

    int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception;

    int editarPerfil(DetallePacienteDTO pacienteDTO) throws  Exception;

    void eliminarCuenta(int codigo) throws  Exception;
    DetallePacienteDTO verDetallePaciente(int codigo) throws  Exception;

    List<ItemPacienteDTO> listarTodos();


    void enviarLinkRecuperacion(String email) throws Exception;

    void cambiarPassword(NuevoPasswordDTO nuevoPasswordDTO) throws Exception;

    int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception;

    int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception;

    List <ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;

    DetallePQRSDTO verDetallePQRS(int codigo) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws  Exception;

    List <ItemCitaAdminDTO> listarCitasPaciente(int codigoPaciente)throws Exception;

    void filtrarCitas(FiltroBusquedaDTO filtroBusquedaDTO) throws Exception;

    List<DetalleAtencionMedicaDTO> verDetalleCita(int codigoCita) throws Exception;

}
