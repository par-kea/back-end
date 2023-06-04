package co.edu.unbosque.forpets.repositories.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table (name="cliente")
public class ClienteModel {

    @Id
    @Column(unique= true, nullable = false)
    private Long cc_cliente;

    @Column( nullable = false)
    private String nombre;

    @Column( nullable = false)
    private String contraseña;

    @Column( nullable = false)
    private String email;

    private int puntos_fid;

    @Column( nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String estado;


    @OneToMany(mappedBy="cc_cliente",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<ReservaModel> reserva;

    @OneToMany(mappedBy="cc_cliente",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<RegistroModel> registro;

    @OneToMany(mappedBy="cc_cliente",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<DatosPagoModel> datosPago;

    @OneToMany(mappedBy="cc_cliente",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<TelefonoModel> telefono;

    @OneToMany(mappedBy="cc_cliente",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<VehiculoModel> vehiculo;

    public Long getCc_cliente() {
        return cc_cliente;
    }

    public void setCc_cliente(Long cc_cliente) {
        this.cc_cliente = cc_cliente;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPuntos_fid() {
        return puntos_fid;
    }

    public void setPuntos_fid(int puntos_fid) {
        this.puntos_fid = puntos_fid;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<ReservaModel> getReserva() {
        return reserva;
    }

    public void setReserva(Set<ReservaModel> reserva) {
        this.reserva = reserva;
    }

    public Set<RegistroModel> getRegistro() {
        return registro;
    }

    public void setRegistro(Set<RegistroModel> registro) {
        this.registro = registro;
    }

    public Set<DatosPagoModel> getDatosPago() {
        return datosPago;
    }

    public void setDatosPago(Set<DatosPagoModel> datosPago) {
        this.datosPago = datosPago;
    }

    public Set<TelefonoModel> getTelefono() {
        return telefono;
    }

    public void setTelefono(Set<TelefonoModel> telefono) {
        this.telefono = telefono;
    }

    public Set<VehiculoModel> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Set<VehiculoModel> vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
