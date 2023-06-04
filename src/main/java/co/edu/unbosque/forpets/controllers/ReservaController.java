package co.edu.unbosque.forpets.controllers;


import co.edu.unbosque.forpets.repositories.models.*;
import co.edu.unbosque.forpets.service.ClienteService;
import co.edu.unbosque.forpets.service.ParqueaderoService;
import co.edu.unbosque.forpets.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/reserva")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @Autowired
    ParqueaderoService parqueaderoService;

    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<ReservaModel> obtenerReserva(){
        return reservaService.obtenerReserva();
    }

    @PostMapping(value="/{id_parqueadero}/{cc_cliente}")
    public String guardarReserva(@RequestBody ReservaModel reserva , @PathVariable (value = "id_parqueadero")String id_parqueadero,
                                 @PathVariable (value = "cc_cliente")String cc_cliente) {

        ParqueaderoModel parqueadero = parqueaderoService.obtenerParqueaderoID(id_parqueadero);
        ClienteModel cliente = clienteService.obtenerClienteCC(cc_cliente);

        reserva.setId_Parqueadero(parqueadero);
        reserva.setCc_cliente(cliente);

        return this.reservaService.agregarReserve(reserva);
    }


    @PutMapping(path = "delete/{id}")
    public String eliminarReserva(@RequestBody ReservaModel reserva,@PathVariable("id") Long idReserva){
        return reservaService.borrarReserva(reserva,idReserva);

    }


    @PutMapping(path = "{id}")
    public String actualizarReserva(@RequestBody ReservaModel reserva,@PathVariable("id") Long idReserva){
        return reservaService.actualizarReserva(reserva,idReserva);

    }

}
