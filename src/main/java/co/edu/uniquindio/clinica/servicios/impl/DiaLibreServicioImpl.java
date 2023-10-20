package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.servicios.interfaces.DiaLibreServicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiaLibreServicioImpl implements DiaLibreServicio {

    private List<Date> diasLibres;

    public DiaLibreServicioImpl() {
        this.diasLibres = new ArrayList<>();
    }

    @Override
    public List<Date> obtenerDiasLibres() {
        return diasLibres;
    }

    @Override
    public void agregarDiaLibre(Date fecha) {
        diasLibres.add(fecha);
    }

    @Override
    public void eliminarDiaLibre(Date fecha) {
        diasLibres.remove(fecha);
    }

    @Override
    public boolean esDiaLibre(Date fecha) {
        return diasLibres.contains(fecha);
    }

    @Override
    public int obtenerNumeroDiasLibres() {
        return diasLibres.size();
    }
}

