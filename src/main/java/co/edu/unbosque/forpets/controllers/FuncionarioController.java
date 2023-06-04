package co.edu.unbosque.forpets.controllers;


import co.edu.unbosque.forpets.repositories.models.FuncionarioModel;
import co.edu.unbosque.forpets.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/funcionario")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping()
    public ArrayList<FuncionarioModel> obtenerFuncionario(){
        return funcionarioService.obtenerFuncionario();
    }

    @PostMapping(consumes="application/json")
    public String guardarParqueadero(@RequestBody FuncionarioModel funcionario) {
        return this.funcionarioService.agregarFuncionario(funcionario);
    }

    @PutMapping(path = "delete/{cc}")
    public String eliminarFuncionario(@RequestBody FuncionarioModel fucnionario, @PathVariable (value = "cc")String cc){
        return funcionarioService.borrarFuncionario(fucnionario,cc);

    }

    @PutMapping(path = "{cc}")
    public String actualizarFuncionario(@RequestBody FuncionarioModel fucnionario, @PathVariable (value = "cc")String cc){
        return funcionarioService.actualizarFuncionario(fucnionario,cc);

    }
}
