package co.edu.unbosque.forpets.service;


import co.edu.unbosque.forpets.repositories.ClienteRepository;
import co.edu.unbosque.forpets.repositories.VehiculoRepository;
import co.edu.unbosque.forpets.repositories.models.VehiculoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;
    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<VehiculoModel> obtenerVehiculo(){return (ArrayList<VehiculoModel>)vehiculoRepository.findAll();}

    public String agregarVehiculo(VehiculoModel   vehiculo) {

        if(!clienteRepository.existsById(vehiculo.getCc_cliente().getCc_cliente())){
            System.out.println("no exite cliente");
            return "no exite cliente";
        }
        vehiculoRepository.save(vehiculo);
        return "creado correctamente";
    }

    //borrar vehiculo

    public String borrarVehiculo(VehiculoModel vehiculo1,long id_vehiculo) {
        VehiculoModel vehiculo = vehiculoRepository.findById(id_vehiculo)
                .orElseThrow(() -> new IllegalStateException("no existe esta vehiculo"));

        vehiculo.setEstado("inactivo");
        vehiculoRepository.save(vehiculo);
        return "datos del vehiculo actualizados";
    }
    //actualizar cita

    public String actualizarVehiuclo(VehiculoModel vehiculo1,long id_vehiculo) {
        VehiculoModel vehiculo = vehiculoRepository.findById(id_vehiculo)
                .orElseThrow(() -> new IllegalStateException("no existe esta vehiculo"));

        vehiculo.setPlaca(vehiculo1.getPlaca());
        vehiculoRepository.save(vehiculo);
        return "datos del vehiculo actualizados";
    }


}
