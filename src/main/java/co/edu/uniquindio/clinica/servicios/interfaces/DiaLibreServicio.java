package co.edu.uniquindio.clinica.servicios.interfaces;



import java.util.Date;
import java.util.List;

public interface DiaLibreServicio {

    List<Date> obtenerDiasLibres();


    void agregarDiaLibre(Date fecha);


    void eliminarDiaLibre(Date fecha);


    boolean esDiaLibre(Date fecha);


    int obtenerNumeroDiasLibres();
}

