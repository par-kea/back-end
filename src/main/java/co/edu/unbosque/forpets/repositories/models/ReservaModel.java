package co.edu.unbosque.forpets.repositories.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "reserva")

public class ReservaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_reserva;

    private String fecha_reserva;
    @Column(nullable = false)
    private String fechaHora_ingreso;
    @Column(nullable = false)
    private String fechaHora_salida;
    @Column(nullable = false)
    private String costo;

    @Column(nullable = false)
    private String estado;


    @ManyToOne
    @JoinColumn(name="cc_cliente", nullable=false)
    private ClienteModel cc_cliente;

    @ManyToOne
    @JoinColumn(name="id_Parqueadero", nullable=false)
    private ParqueaderoModel id_Parqueadero;

    public Long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getFechaHora_ingreso() {
        return fechaHora_ingreso;
    }

    public void setFechaHora_ingreso(String fechaHora_ingreso) {
        this.fechaHora_ingreso = fechaHora_ingreso;
    }

    public String getFechaHora_salida() {
        return fechaHora_salida;
    }

    public void setFechaHora_salida(String fechaHora_salida) {
        this.fechaHora_salida = fechaHora_salida;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public ClienteModel getCc_cliente() {
        return cc_cliente;
    }

    public void setCc_cliente(ClienteModel cc_cliente) {
        this.cc_cliente = cc_cliente;
    }

    public ParqueaderoModel getId_Parqueadero() {
        return id_Parqueadero;
    }

    public void setId_Parqueadero(ParqueaderoModel id_Parqueadero) {
        this.id_Parqueadero = id_Parqueadero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
