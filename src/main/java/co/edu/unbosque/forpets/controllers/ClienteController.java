package co.edu.unbosque.forpets.controllers;


import co.edu.unbosque.forpets.repositories.models.ClienteModel;
import co.edu.unbosque.forpets.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<ClienteModel> obtenerCliente(){
        return clienteService.obtenerCliente();
    }

    @GetMapping(path = "{cc}")
    public ClienteModel obtenerCleinte(@PathVariable("cc") String cc){
        return clienteService.obtenerClienteCC(cc);
    }

    @PostMapping(consumes="application/json")
    public String guardarCliente(@RequestBody ClienteModel cliente) {
        return this.clienteService.agregarCliente(cliente);
    }

    @PutMapping(path = "delete/{cc}")
    public String eliminarCliente(@RequestBody ClienteModel cliente, @PathVariable (value = "cc")String cc){
        return clienteService.borrarCliente(cliente,cc);
    }

    @PutMapping(path = "{cc}")
    public String actualizarCliente(@RequestBody ClienteModel cliente, @PathVariable (value = "cc")String cc){
        return clienteService.actualizarCliente(cliente,cc);
    }
}
