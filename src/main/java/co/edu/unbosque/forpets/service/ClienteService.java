package co.edu.unbosque.forpets.service;


import co.edu.unbosque.forpets.repositories.ClienteRepository;
import co.edu.unbosque.forpets.repositories.models.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    //Obtener citas
    public ArrayList<ClienteModel> obtenerCliente(){
        return (ArrayList<ClienteModel>)clienteRepository.findAll();
    }

    public ClienteModel obtenerClienteCC(String cedula){
        return clienteRepository.clientePorCedula(cedula);
    }

    public String agregarCliente(ClienteModel cliente) {

        //falta verificaciones con las dependencias (laves foraneas)
        clienteRepository.save(cliente);
        return "funcionario creado correctamente";

        //falta terminar metodo
    }

    //borrar cliente
    public String borrarCliente(ClienteModel cliente1, String cc) {
        Long ccAux = Long.parseLong(cc);
        ClienteModel cliente = clienteRepository.findById(ccAux)
                .orElseThrow(() -> new IllegalStateException("no existe este cliente"));

        cliente.setEstado("inactivo");
        clienteRepository.save(cliente);
        return "datos de la cita actualizados";
    }

    //actualizar cita

    public String actualizarCliente(ClienteModel cliente1, String cc) {
        Long ccAux = Long.parseLong(cc);
        ClienteModel cliente = clienteRepository.findById(ccAux)
                .orElseThrow(() -> new IllegalStateException("no existe este cliente"));

        cliente.setNombre(cliente1.getNombre());
        cliente.setContraseña(cliente1.getContraseña());
        cliente.setEmail(cliente1.getEmail());
        cliente.setDireccion(cliente1.getDireccion());
        clienteRepository.save(cliente);
        return "datos de la cita actualizados";
    }
}
