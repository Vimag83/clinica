package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.CuentaDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Cuenta;
import co.edu.uniquindio.clinica.repositorios.CuentaRepo;
import co.edu.uniquindio.clinica.repositorios.PacienteRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.CuentaServicio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CuentaServicioImpl implements CuentaServicio {

    @Autowired
    private final PacienteRepo pacienteRepo;
    @Autowired private final CuentaRepo cuentaRepo;
    private boolean estaRepetidoCorreo(String correo) {
        return pacienteRepo.findByCedula(correo) != null;
    }


    @Override
    public int crearCuenta(CuentaDTO cuentaDTO) throws Exception {
        Cuenta cuenta = new Cuenta();
        if(estaRepetidoCorreo(cuentaDTO.correo())){
            throw new Exception("La cuenta asociada a ese correo ya existe");
        }
        cuenta.setCorreo(cuentaDTO.correo());
        cuenta.setPassword(cuentaDTO.password());
        Cuenta cuentaCreada = cuentaRepo.save(cuenta);
        return cuentaCreada.getCodigo();
    }

    @Override
    public void eliminarCuenta(int codigo, String correo) throws Exception {
        Optional<Cuenta>cuentaBuscada = cuentaRepo.findById(codigo);
        if (cuentaBuscada.isEmpty()){
            throw new Exception("la cuenta no existe" + correo);
        }

    }

    @Override
    public List<CuentaDTO> listarCuentas() throws Exception {

        List<Cuenta> cuentas = cuentaRepo.findAll();
        if (cuentas.isEmpty()){
            throw new Exception("No hay cuentas");
        }
        List<CuentaDTO> respuesta = new ArrayList<>();
        for (Cuenta cuenta: cuentas){
            respuesta.add(new CuentaDTO(
                    cuenta.getCodigo(),
                    cuenta.getCorreo(),
                    cuenta.getPassword()
            ));
        }
        return respuesta;
    }
}
