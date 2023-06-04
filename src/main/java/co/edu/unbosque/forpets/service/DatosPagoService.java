package co.edu.unbosque.forpets.service;


import co.edu.unbosque.forpets.repositories.ClienteRepository;
import co.edu.unbosque.forpets.repositories.DatosPagoRepository;
import co.edu.unbosque.forpets.repositories.models.DatosPagoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DatosPagoService {

    @Autowired
    DatosPagoRepository datosPagoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<DatosPagoModel> obtenerDatosPago(){return (ArrayList<DatosPagoModel>)datosPagoRepository.findAll();}

    public String agregarDatosPago(DatosPagoModel datosPago) {

        if(!clienteRepository.existsById(datosPago.getCc_cliente().getCc_cliente())){
            System.out.println("no exite cliente");
            return "no exite cliente";
        }
        datosPagoRepository.save(datosPago);
        return "creado correctamente";

        //falta terminar metodo
    }


    //borrar datosPago
    public String borrarDatosPago(DatosPagoModel datosPago1,long id_datosPago) {
        DatosPagoModel datosPago = datosPagoRepository.findById(id_datosPago)
                .orElseThrow(() -> new IllegalStateException("no existe  datos de pago"));

        datosPago.setEstado("inactivo");
        datosPagoRepository.save(datosPago);
        return "datos de pago actualizados";
    }
    //actualizar cita
    public String actualizarDatosPago(DatosPagoModel datosPago1,long id_datosPago) {
        DatosPagoModel datosPago = datosPagoRepository.findById(id_datosPago)
                .orElseThrow(() -> new IllegalStateException("no existe  datos de pago"));

        datosPago.setCvv_tarjeta(datosPago1.getCvv_tarjeta());
        datosPago.setNumero_tarjeta(datosPago1.getNumero_tarjeta());
        datosPago.setFechaExpe_tarjeta(datosPago1.getFechaExpe_tarjeta());
        datosPagoRepository.save(datosPago);
        return "datos de pago actualizados";
    }
}
