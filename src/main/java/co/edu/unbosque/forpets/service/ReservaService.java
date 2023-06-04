package co.edu.unbosque.forpets.service;


import co.edu.unbosque.forpets.repositories.ClienteRepository;
import co.edu.unbosque.forpets.repositories.ParqueaderoResposity;
import co.edu.unbosque.forpets.repositories.ReservaRepository;
import co.edu.unbosque.forpets.repositories.models.ReservaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReservaService {

    @Autowired
    ReservaRepository reservaRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ParqueaderoResposity parqueaderoResposity;
    //Obtener citas
    public ArrayList<ReservaModel> obtenerReserva(){
        return (ArrayList<ReservaModel>)reservaRepository.findAll();
    }

    public String agregarReserve(ReservaModel reserva) {

        if(!clienteRepository.existsById(reserva.getCc_cliente().getCc_cliente())){
            System.out.println("no exite cliente");
            return "no exite cliente";
        } if(!parqueaderoResposity.existsById(reserva.getId_Parqueadero().getId_Parqueadero())){
            System.out.println("no exite cliente");
            return "no exite cliente";
        }
        reservaRepository.save(reserva);
        return "creado correctamente";

        //falta terminar metodo
    }

    //borrar cita


    //borrar registro
    public String borrarReserva(ReservaModel reserva1,long id_reserva) {
        ReservaModel reserva = reservaRepository.findById(id_reserva)
                .orElseThrow(() -> new IllegalStateException("no existe esta cita"));
        reserva.setEstado("inactivo");
        reservaRepository.save(reserva);
        return "datos de la cita actualizados";
    }
    //actualizar cita

    public String actualizarReserva(ReservaModel reserva1,long id_reserva) {
        ReservaModel reserva = reservaRepository.findById(id_reserva)
                .orElseThrow(() -> new IllegalStateException("no existe esta cita"));
        reserva.setFecha_reserva(reserva1.getFecha_reserva());
        reserva.setFechaHora_ingreso(reserva1.getFechaHora_ingreso());
        reserva.setFechaHora_salida(reserva1.getFechaHora_salida());
        reserva.setCosto(reserva1.getCosto());
        reservaRepository.save(reserva);
        return "datos de la cita actualizados";
    }
}
