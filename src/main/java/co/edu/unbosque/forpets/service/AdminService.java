package co.edu.unbosque.forpets.service;


import co.edu.unbosque.forpets.repositories.AdminRepository;
import co.edu.unbosque.forpets.repositories.models.AdminModel;
import co.edu.unbosque.forpets.repositories.models.FuncionarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    //Obtener citas
    public ArrayList<AdminModel> obtenerAdmin(){
        return (ArrayList<AdminModel>)adminRepository.findAll();
    }

    public AdminModel obtenerAdminCC(String cedula){
        System.out.println("Admin:1111"+ cedula);
        return adminRepository.adminPorCedula(cedula);
    }

    public String agregarAdmin(AdminModel admin) {
        //falta verificaciones con las dependencias (laves foraneas)
        adminRepository.save(admin);
        return "admin creado correctamente";

    }

    //borrar admin
    public String borrarAdmin(AdminModel admin1 ,String cc) {
        Long ccAux = Long.parseLong(cc);
        AdminModel admin = adminRepository.findById(ccAux)
                .orElseThrow(() -> new IllegalStateException("no existe este admin"));

        admin.setEstado("inactivo");
        adminRepository.save(admin);
        return "datos del admin actualizados";
    }
    //actualizar admin

    public String actualizarAdmin(AdminModel admin1 ,String cc) {
        Long ccAux = Long.parseLong(cc);
        AdminModel admin = adminRepository.findById(ccAux)
                .orElseThrow(() -> new IllegalStateException("no existe este admin"));

        admin.setNombre(admin1.getNombre());
        admin.setContraseña(admin1.getContraseña());
        adminRepository.save(admin);
        return "datos del admin actualizados";
    }
}
