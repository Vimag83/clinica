package co.edu.uniquindio.clinica.servicios.interfaces;


import co.edu.uniquindio.clinica.dto.EmailDTO;
public interface EmailServicio {

    //edison
    String enviarCorreo(EmailDTO emailDTO) throws Exception;
}
