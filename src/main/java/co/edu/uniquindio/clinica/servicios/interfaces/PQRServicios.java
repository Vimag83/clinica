package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.DetallePQRSDTO;
import co.edu.uniquindio.clinica.dto.InfoPQRSDTO;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;

import java.util.List;

public interface PQRServicios {

    //ya la hizo victor
    public int crearPQR(InfoPQRSDTO infoPQRSDTO) throws Exception;

    public int cambiarEstadoPQRS(int codigoPQRS, String estadoPQRS) throws Exception;

    public int responderPQRSAdmin(RegistroRespuestaDTO registroRespuestaDTO, int codigo) throws Exception;

    public int responderPQRSPaciente(RegistroRespuestaDTO registroRespuestaDTO, int codigo) throws Exception;

    public List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;

    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception;
}
