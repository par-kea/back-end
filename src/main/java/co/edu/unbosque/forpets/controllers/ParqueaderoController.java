package co.edu.unbosque.forpets.controllers;

import co.edu.unbosque.forpets.repositories.models.*;
import co.edu.unbosque.forpets.service.AdminService;
import co.edu.unbosque.forpets.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.forpets.service.ParqueaderoService;

import java.util.ArrayList;

@RestController
@RequestMapping("/parqueadero")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ParqueaderoController {

    @Autowired
    ParqueaderoService parqueaderoService;

    @Autowired
    AdminService adminService;

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping()
    public ArrayList<ParqueaderoModel> obtenerParqueadero(){
        return parqueaderoService.obtenerParqueadero();
    }

    @PostMapping(value="/{cc_admin}/{cc_funcionario}")
    public String guardarParqueadero(@RequestBody ParqueaderoModel parqueadero , @PathVariable (value = "cc_admin")String cc_admin,
                                     @PathVariable (value = "cc_funcionario")String cc_funcionario) {



        AdminModel admin = adminService.obtenerAdminCC(cc_admin);
        FuncionarioModel funcionario = funcionarioService.obtenerfuncionarioCC(cc_funcionario);

        parqueadero.setCc_admin(admin);
        parqueadero.setCc_funcionario(funcionario);
        return this.parqueaderoService.agregarParqueadero(parqueadero);
    }

    @PutMapping(path = "delete/{id}")
    public String eliminarParqueadero(@RequestBody ParqueaderoModel parqueadero,@PathVariable("id") Long idParqueadero){
        return parqueaderoService.borrarParqueadero(parqueadero,idParqueadero);
    }
    @PutMapping(path = "{id}")
    public String actualizarParqueadero(@RequestBody ParqueaderoModel parqueadero,@PathVariable("id") Long idParqueadero){
        return parqueaderoService.actualizarParqueadero(parqueadero,idParqueadero);
    }
}
