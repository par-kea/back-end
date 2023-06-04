package co.edu.unbosque.forpets.controllers;

import co.edu.unbosque.forpets.repositories.models.ClienteModel;
import co.edu.unbosque.forpets.repositories.models.VehiculoModel;
import co.edu.unbosque.forpets.service.ClienteService;
import co.edu.unbosque.forpets.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/vehiculo")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class VehiculoController {

    @Autowired
    VehiculoService vehiculoService;

    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<VehiculoModel> obtenerVehiculo(){
        return vehiculoService.obtenerVehiculo();
    }

    @PostMapping(value="/{cc_cliente}")
    public String guardarVehiculo(@RequestBody VehiculoModel vehiculo , @PathVariable (value = "cc_cliente")String cc_cliente) {
        ClienteModel cliente = clienteService.obtenerClienteCC(cc_cliente);
        vehiculo.setCc_cliente(cliente);
        return this.vehiculoService.agregarVehiculo(vehiculo);
    }
    @PutMapping(path = "delete/{id_vehiculo}")
    public String eliminarVehiculo(@RequestBody VehiculoModel vehiculo,@PathVariable (value = "id_vehiculo")Long id_vehiculo){
        return vehiculoService.borrarVehiculo(vehiculo,id_vehiculo);

    }

    @PutMapping(path = "{id_vehiculo}")
    public String actualizarVehiculo(@RequestBody VehiculoModel vehiculo,@PathVariable (value = "id_vehiculo")Long id_vehiculo){
        return vehiculoService.actualizarVehiuclo(vehiculo,id_vehiculo);

    }
}
