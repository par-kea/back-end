package co.edu.unbosque.forpets.controllers;


import co.edu.unbosque.forpets.repositories.models.AdminModel;
import co.edu.unbosque.forpets.repositories.models.ClienteModel;
import co.edu.unbosque.forpets.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping()
    public ArrayList<AdminModel> obtenerAdmin(){
        return adminService.obtenerAdmin();
    }

    @GetMapping(path = "{cc}")
    public AdminModel obtenerAdminCC(@PathVariable("cc") String cc){
        return adminService.obtenerAdminCC(cc);
    }

    @PostMapping(consumes="application/json")
    public String guardarAdmin(@RequestBody AdminModel admin) {
        return this.adminService.agregarAdmin(admin);
    }

    @PutMapping(path = "/delete/{cc}")
    public String eliminarAdmin(@RequestBody AdminModel admin, @PathVariable (value = "cc")String cc){
        System.out.println(cc+"asdfasdf");
        return adminService.borrarAdmin(admin,cc);
    }

    @PutMapping(path = "{cc}")
    public String actualizarAdmin(@RequestBody AdminModel admin, @PathVariable (value = "cc")String cc){
        return adminService.actualizarAdmin(admin,cc);
    }

}
