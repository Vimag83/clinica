package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.CuentaDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Cuenta;

import java.util.List;

public interface CuentaServicio {

    int crearCuenta(CuentaDTO cuentaDTO)throws Exception;
    void eliminarCuenta(int codigo, String correo)throws Exception;

    //listar todas la cuentas
    List<CuentaDTO>listarCuentas() throws Exception;
}
