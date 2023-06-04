package co.edu.unbosque.forpets.service;


import co.edu.unbosque.forpets.repositories.ClienteRepository;
import co.edu.unbosque.forpets.repositories.TelefonoRepository;
import co.edu.unbosque.forpets.repositories.models.TelefonoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TelefonoService {

    @Autowired
    TelefonoRepository telefonoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<TelefonoModel> obtenerTelefono(){return (ArrayList<TelefonoModel>)telefonoRepository.findAll();}

    public String agregarTelefono(TelefonoModel telefono) {

        if(!clienteRepository.existsById(telefono.getCc_cliente().getCc_cliente())){
            System.out.println("no exite cliente");
            return "no exite cliente";
        }
        telefonoRepository.save(telefono);
        return "creado correctamente";

    }

    //borrar telefono

    public String borrarTelefono(TelefonoModel telefono1,long id_telefono) {
        TelefonoModel telefono = telefonoRepository.findById(id_telefono)
                .orElseThrow(() -> new IllegalStateException("no existe esta telefono"));

        telefono.setEstado("inactivo");
        telefonoRepository.save(telefono);
        return "datos del telefono actualizados";
    }

    //actualizar Telefono

    public String actualizarTelefono(TelefonoModel telefono1,long id_telefono) {
        TelefonoModel telefono = telefonoRepository.findById(id_telefono)
                .orElseThrow(() -> new IllegalStateException("no existe esta telefono"));

        telefono.setNum_Telefono(telefono1.getNum_Telefono());
        telefonoRepository.save(telefono);
        return "datos del telefono actualizados";
    }

}
