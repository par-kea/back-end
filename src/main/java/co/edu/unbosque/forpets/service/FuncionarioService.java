package co.edu.unbosque.forpets.service;



import co.edu.unbosque.forpets.repositories.FuncionarioRepository;
import co.edu.unbosque.forpets.repositories.models.ClienteModel;
import co.edu.unbosque.forpets.repositories.models.FuncionarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FuncionarioService {


    @Autowired
    FuncionarioRepository funcionarioRepository;

    public ArrayList<FuncionarioModel> obtenerFuncionario(){return (ArrayList<FuncionarioModel>)funcionarioRepository.findAll();}

    public FuncionarioModel obtenerfuncionarioCC(String cedula){
        return funcionarioRepository.funcionarioPorCedula(cedula);
    }

    public String agregarFuncionario(FuncionarioModel funcionario) {

        //falta verificaciones con las dependencias (laves foraneas)
        funcionarioRepository.save(funcionario);
        return "fucnionario creado correctamente";

        //falta terminar metodo
    }
    //borrar funcionario
    public String borrarFuncionario(FuncionarioModel funcionario1,String cc) {
        Long ccAux = Long.parseLong(cc);
        FuncionarioModel funcionario = funcionarioRepository.findById(ccAux)
                .orElseThrow(() -> new IllegalStateException("no existe esta cita"));
        funcionario.setEstado("inactivo");
        funcionarioRepository.save(funcionario);
        return "datos de la cita actualizados";
    }

    //actualizar fucnioanrio

    public String actualizarFuncionario(FuncionarioModel funcionario1,String cc) {
        Long ccAux = Long.parseLong(cc);
        FuncionarioModel funcionario = funcionarioRepository.findById(ccAux)
                .orElseThrow(() -> new IllegalStateException("no existe esta cita"));

        funcionario.setContraseña(funcionario1.getContraseña());
        funcionario.setNombre(funcionario1.getNombre());
        funcionario.setDireccion(funcionario1.getDireccion());
        funcionarioRepository.save(funcionario);
        return "datos de la cita actualizados";
    }

}
