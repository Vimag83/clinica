package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.EmailDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class EmailServicioImpl  implements EmailServicio {

    @Value("${spring.mail.username}")
    private String correoRemitente;

    private final JavaMailSender javaMailSender;

    @Override
    public String enviarCorreo( EmailDTO emailDTO) throws Exception {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(emailDTO.para());
        mensaje.setSubject(emailDTO.asunto());
        mensaje.setText(emailDTO.mensaje());
        mensaje.setFrom(correoRemitente);

        javaMailSender.send(mensaje);

        return "Correo enviado exitosamente a " + emailDTO.para();
    }
}


