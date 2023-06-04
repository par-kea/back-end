package co.edu.unbosque.forpets.service;


import co.edu.unbosque.forpets.repositories.FuncionarioRepository;
import co.edu.unbosque.forpets.repositories.ParqueaderoResposity;
import co.edu.unbosque.forpets.repositories.models.ClienteModel;
import co.edu.unbosque.forpets.repositories.models.ParqueaderoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ParqueaderoService {

    @Autowired
    ParqueaderoResposity parqueaderoResposity;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    ParqueaderoResposity adminRepository;

    //Obtener citas
    public ArrayList<ParqueaderoModel> obtenerParqueadero(){
        return (ArrayList<ParqueaderoModel>)parqueaderoResposity.findAll();
    }

    public ParqueaderoModel obtenerParqueaderoID(String id_parqueadero){
        return parqueaderoResposity.idParqueadero(id_parqueadero);
    }

    public String agregarParqueadero(ParqueaderoModel parqueadero) {
        System.out.println(adminRepository.existsById(parqueadero.getCc_admin().getCc()));

         if(!funcionarioRepository.existsById(parqueadero.getCc_funcionario().getCc_funcionario())){
            System.out.println("no exite funcionario");
            return "no exite funcionario";
        }
         if(adminRepository.existsById(parqueadero.getCc_admin().getCc())){
            System.out.println("no exite admin");
            return "no exite admin";
        }
         System.out.println("no hizo verificacion");
        parqueaderoResposity.save(parqueadero);
        return "creado correctamente";

        //falta terminar metodo
    }


    //borrar parqueadero


    public String borrarParqueadero(ParqueaderoModel parqueadero1,long id_parqueadero) {
        ParqueaderoModel parqueadero = parqueaderoResposity.findById(id_parqueadero)
                .orElseThrow(() -> new IllegalStateException("no existe parqueadero"));
        parqueadero.setEstado("inactivo");
        parqueaderoResposity.save(parqueadero);
        return "datos de la cita actualizados";
    }

    //actualizar cita

    public String actualizarParqueadero(ParqueaderoModel parqueadero1,long id_parqueadero) {
        ParqueaderoModel parqueadero = parqueaderoResposity.findById(id_parqueadero)
                .orElseThrow(() -> new IllegalStateException("no existe parqueadero"));
        parqueadero.setCiudad(parqueadero1.getCiudad());
        parqueadero.setDireccion(parqueadero1.getDireccion());
        parqueadero.setEspaciosOcupados(parqueadero1.getEspaciosOcupados());
        parqueadero.setFidelizacion(parqueadero1.getFidelizacion());
        parqueadero.setHorasAtencion(parqueadero1.getHorasAtencion());
        parqueadero.setTipoTecho(parqueadero1.getTipoTecho());
        parqueadero.setEspaciosTotales(parqueadero1.getEspaciosTotales());
        parqueadero.setPrecioMinuto(parqueadero1.getPrecioMinuto());
        parqueaderoResposity.save(parqueadero);
        return "datos de la cita actualizados";
    }
}
