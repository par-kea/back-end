package co.edu.unbosque.forpets.service;


import co.edu.unbosque.forpets.repositories.ClienteRepository;
import co.edu.unbosque.forpets.repositories.FuncionarioRepository;
import co.edu.unbosque.forpets.repositories.RegistroRepository;
import co.edu.unbosque.forpets.repositories.models.RegistroModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RegistroService {

    @Autowired
    RegistroRepository registroRepository;

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    FuncionarioRepository funcionarioRepository;

    //Obtener citas
    public ArrayList<RegistroModel> obtenerRegistro(){
        return (ArrayList<RegistroModel>)registroRepository.findAll();
    }

    public String agregarRegistro(RegistroModel registro) {

        if(!clienteRepository.existsById(registro.getCc_cliente().getCc_cliente())){
            System.out.println("no exite cliente");
            return "no exite cliente";
        }if(!funcionarioRepository.existsById(registro.getCc_funcionario().getCc_funcionario())){
            System.out.println("no exite funcionario");
            return "no exite funcionario";
        }
        registroRepository.save(registro);
        return "creado correctamente";

        //falta terminar metodo
    }

    //borrar registro
    public String borrarRegistro(RegistroModel registro1,long id_registro) {
        RegistroModel registro = registroRepository.findById(id_registro)
                .orElseThrow(() -> new IllegalStateException("no existe esta cita"));
        registro.setEstado("inactivo");
        registroRepository.save(registro);
        return "datos de la cita actualizados";
    }
    //actualizar registro

    public String actualizarRegistro(RegistroModel registro1,long id_registro) {
        RegistroModel registro = registroRepository.findById(id_registro)
                .orElseThrow(() -> new IllegalStateException("no existe esta cita"));
        registro.setFecha(registro1.getFecha());
        registro.setIp(registro1.getIp());
        registroRepository.save(registro);
        return "datos de la cita actualizados";
    }

}
