package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.dto.EmailDTO;
import co.edu.uniquindio.clinica.servicios.impl.EmailServicioImpl;
import org.hibernate.mapping.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailServicioController {
    @Autowired
    EmailServicioImpl emailServicio;

    @PostMapping("/enviar")
    public ResponseEntity<HttpStatus> enviarCorreo(@RequestBody EmailDTO emailDTO) throws Exception {

        try {
            emailServicio.enviarCorreo(emailDTO);
        }
        catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
