package co.edu.unbosque.forpets.controllers;



import co.edu.unbosque.forpets.repositories.models.ClienteModel;
import co.edu.unbosque.forpets.repositories.models.TelefonoModel;
import co.edu.unbosque.forpets.service.ClienteService;
import co.edu.unbosque.forpets.service.TelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/telefono")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class TelefonoController {

    @Autowired
    TelefonoService telefonoService;

    @Autowired
    ClienteService clienteService;


    @GetMapping()
    public ArrayList<TelefonoModel> obtenerTelefono(){
        return telefonoService.obtenerTelefono();
    }

    @PostMapping(value="/{cc_cliente}")
    public String guardarTelefono(@RequestBody TelefonoModel telefono , @PathVariable (value = "cc_cliente")String cc_cliente) {

        ClienteModel cliente = clienteService.obtenerClienteCC(cc_cliente);
        telefono.setCc_cliente(cliente);
        return this.telefonoService.agregarTelefono(telefono);
    }

    @PutMapping(path = "delete/{id_telefono}")
    public String eliminarTelefono(@RequestBody TelefonoModel telefono,@PathVariable (value = "id_telefono")long id_telefono){
        return telefonoService.borrarTelefono(telefono,id_telefono);
    }

    @PutMapping(path = "{id_telefono}")
    public String actualizarTelefono(@RequestBody TelefonoModel telefono,@PathVariable (value = "id_telefono")long id_telefono){
        return telefonoService.actualizarTelefono(telefono,id_telefono);
    }
}


