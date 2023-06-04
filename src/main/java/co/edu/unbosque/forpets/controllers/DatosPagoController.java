package co.edu.unbosque.forpets.controllers;



import co.edu.unbosque.forpets.repositories.models.ClienteModel;
import co.edu.unbosque.forpets.repositories.models.DatosPagoModel;
import co.edu.unbosque.forpets.repositories.models.TelefonoModel;
import co.edu.unbosque.forpets.service.ClienteService;
import co.edu.unbosque.forpets.service.DatosPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/datosPago")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class DatosPagoController {

    @Autowired
    DatosPagoService datosPagoServiceService;

    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<DatosPagoModel> obtenerDatosPago(){
        return datosPagoServiceService.obtenerDatosPago();
    }

    @PostMapping(value="/{cc_cliente}")
    public String guardarDatosPago(@RequestBody DatosPagoModel datoPago , @PathVariable (value = "cc_cliente")String cc_cliente) {
        ClienteModel cliente = clienteService.obtenerClienteCC(cc_cliente);
        datoPago.setCc_cliente(cliente);
        return this.datosPagoServiceService.agregarDatosPago(datoPago);
    }
    @PutMapping(path = "delete/{id_datospago}")
    public String eliminarDatosPago(@RequestBody DatosPagoModel datosPago,@PathVariable (value = "id_datospago")Long id_datospago){
        return datosPagoServiceService.borrarDatosPago(datosPago,id_datospago);
    }

    @PutMapping(path = "{id_datospago}")
    public String actualizarDatosPago(@RequestBody DatosPagoModel datosPago,@PathVariable (value = "id_datospago")Long id_datospago){
        return datosPagoServiceService.actualizarDatosPago(datosPago,id_datospago);
    }
}
