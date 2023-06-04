package co.edu.unbosque.forpets.repositories.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "admin")
public class AdminModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long cc;
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private String estado;

    @OneToMany(mappedBy="cc_admin",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<ParqueaderoModel> parqueadero;

    public Long getCc() {
        return cc;
    }

    public void setCc(Long cc) {
        this.cc = cc;
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

    public Set<ParqueaderoModel> getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Set<ParqueaderoModel> parqueadero) {
        this.parqueadero = parqueadero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
