package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.DetallePQRSDTO;
import co.edu.uniquindio.clinica.dto.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.clinica.dto.InfoPQRSDTO;
import co.edu.uniquindio.clinica.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.modelo.entidades.Cita;
import co.edu.uniquindio.clinica.modelo.entidades.Cuenta;
import co.edu.uniquindio.clinica.modelo.entidades.Mensaje;
import co.edu.uniquindio.clinica.modelo.entidades.Pqrs;
import co.edu.uniquindio.clinica.repositorios.CitaRepo;
import co.edu.uniquindio.clinica.repositorios.CuentaRepo;
import co.edu.uniquindio.clinica.repositorios.MensajeRepo;
import co.edu.uniquindio.clinica.repositorios.PQRSRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.PQRServicios;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PQRServicioImpl implements PQRServicios {

    private final CitaRepo citaRepo;
    private final PQRSRepo pqrsRepo;
    private final CuentaRepo cuentaRepo;
    private final MensajeRepo mensajeRepo;

    @Override
    public int crearPQR(InfoPQRSDTO infoPQRSDTO) throws Exception {

        Optional<Cita> optional = citaRepo.findById(infoPQRSDTO.codigoCita());
        Pqrs pqrs = new Pqrs();
        pqrs.setCita(optional.get());
        pqrs.setMotivo(infoPQRSDTO.motivo());
        pqrs.setFechaCreacion(infoPQRSDTO.fechaCreacion());
        pqrs.setEstado(EstadoPQRS.ABIERTA);

        Pqrs pqrsNew = pqrsRepo.save(pqrs);
        return pqrsNew.getCodigoPqrs();
    }

    @Override
    public int cambiarEstadoPQRS(int codigoPQRS, String estadoPQRS) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(codigoPQRS);
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+codigoPQRS+"no esta asociado a ningun PQRS"));
        }
        Pqrs pqrs = opcional.get();
        pqrs.setEstado(EstadoPQRS.valueOf(estadoPQRS));
        pqrsRepo.save(pqrs);
        return pqrs.getCodigoPqrs();
    }

    @Override
    public int responderPQRSAdmin(RegistroRespuestaDTO registroRespuestaDTO, int codigo) throws Exception {

        Optional<Pqrs> opcional = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+registroRespuestaDTO.codigoPQRS()+"no esta asociado a ningun PQRS"));
        }

        Optional<Cuenta> opcionalCuenta = cuentaRepo.findById(registroRespuestaDTO.codigoCuenta());
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+registroRespuestaDTO.codigoCuenta()+"no esta asociado a ningun PQRS"));
        }
        Mensaje mensajePQRS = new Mensaje();
        mensajePQRS.setCodigo(registroRespuestaDTO.codigoCuenta());
        mensajePQRS.setPqrs(opcional.get());
        mensajePQRS.setFechaCreacion(LocalDateTime.now());
        mensajePQRS.setMensaje(registroRespuestaDTO.mensaje());
        return mensajeRepo.save(mensajePQRS).getCodigo();
    }

    @Override
    public int responderPQRSPaciente(RegistroRespuestaDTO registroRespuestaDTO, int codigo) throws Exception {
        //obtener el PQRS
        Optional<Pqrs> opcional = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+registroRespuestaDTO.codigoPQRS()+"no esta asociado a ningun PQRS"));
        }
        //obtener LA CUENTA
        Optional<Cuenta> opcionalCuenta = cuentaRepo.findById(registroRespuestaDTO.codigoCuenta());
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+registroRespuestaDTO.codigoCuenta()+"no esta asociado a ningun PQRS"));
        }
        Mensaje mensajePQRS = new Mensaje();
        mensajePQRS.setCodigo(registroRespuestaDTO.codigoCuenta());
        mensajePQRS.setPqrs(opcional.get());
        mensajePQRS.setFechaCreacion(LocalDateTime.now());
        mensajePQRS.setMensaje(registroRespuestaDTO.mensaje());
        return mensajeRepo.save(mensajePQRS).getCodigo();
    }

    @Override
    public List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {
        List<Pqrs>listaPqrs = pqrsRepo.findAll();
        List <ItemPQRSDTO> respuesta = new ArrayList<>();

        for (Pqrs p : listaPqrs){
            respuesta.add(new ItemPQRSDTO(
                    p.getCodigoPqrs(),
                    p.getEstado(),
                    p.getMotivo(),
                    p.getFechaCreacion(),
                    p.getCita().getPaciente().getNombre()

                    ));
        }
        return respuesta;
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(codigo);
        if (opcional.isEmpty()){
            throw new Exception(("El codigo"+codigo+"no esta asociado a ningun PQRS"));
        }
        Pqrs pqrs = opcional.get();

        return new DetallePQRSDTO(
                pqrs.getCodigoPqrs(),
                pqrs.getEstado(),
                pqrs.getMotivo(),
                pqrs.getCita().getPaciente().getNombre(),
                pqrs.getCita().getMedico().getNombre(),
                pqrs.getCita().getMedico().getEspecialidad(),
                pqrs.getFechaCreacion(),
                new ArrayList<>());
    }
}
