package co.edu.unbosque.forpets.repositories.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Funcionario")
public class FuncionarioModel {

    @Id
    @Column(unique = true, nullable = false)
    private Long cc_funcionario;
    @Column( nullable = false)
    private String nombre;
    @Column( nullable = false)
    private String contraseña;
    @Column( nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String estado;


    @OneToMany(mappedBy="cc_funcionario",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<ParqueaderoModel> parqueadero;

    @OneToMany(mappedBy="cc_funcionario",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<RegistroModel> registro;

    public Long getCc_funcionario() {
        return cc_funcionario;
    }

    public void setCc_funcionario(Long cc_funcionario) {
        this.cc_funcionario = cc_funcionario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<ParqueaderoModel> getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Set<ParqueaderoModel> parqueadero) {
        this.parqueadero = parqueadero;
    }

    public Set<RegistroModel> getRegistro() {
        return registro;
    }

    public void setRegistro(Set<RegistroModel> registro) {
        this.registro = registro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
