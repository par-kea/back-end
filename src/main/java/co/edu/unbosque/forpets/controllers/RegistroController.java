package co.edu.unbosque.forpets.controllers;


import co.edu.unbosque.forpets.repositories.models.ClienteModel;
import co.edu.unbosque.forpets.repositories.models.FuncionarioModel;
import co.edu.unbosque.forpets.repositories.models.RegistroModel;
import co.edu.unbosque.forpets.service.ClienteService;
import co.edu.unbosque.forpets.service.FuncionarioService;
import co.edu.unbosque.forpets.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/registro")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class RegistroController {
    @Autowired
    RegistroService registroService;
    @Autowired
    ClienteService clienteService;
    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping()
    public ArrayList<RegistroModel> obtenerRegistro(){
        return registroService.obtenerRegistro();
    }

    @PostMapping(value="/{cc_cliente}/{cc_funcionario}")
    public String guardarRegistro(@RequestBody RegistroModel registro , @PathVariable (value = "cc_cliente")String cc_cliente,
                                  @PathVariable (value = "cc_funcionario")String cc_funcionario) {
        ClienteModel cliente = clienteService.obtenerClienteCC(cc_cliente);
        FuncionarioModel funcionario = funcionarioService.obtenerfuncionarioCC(cc_funcionario);

        registro.setCc_cliente(cliente);
        registro.setCc_funcionario(funcionario);
        return this.registroService.agregarRegistro(registro);

    }

    @PutMapping(path = "delete/{id}")
    public String eliminarRegistro(@RequestBody RegistroModel registro,@PathVariable("id") Long idRegistro){
        return registroService.borrarRegistro(registro,idRegistro);

    }

    @PutMapping(path = "{id}")
    public String actualizarRegistro(@RequestBody RegistroModel registro,@PathVariable("id") Long idRegistro){
        return registroService.actualizarRegistro(registro,idRegistro);

    }

}
