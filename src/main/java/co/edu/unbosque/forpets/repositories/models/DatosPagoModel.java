package co.edu.unbosque.forpets.repositories.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "datosPagos")
public class DatosPagoModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_datos;

    @Column( nullable = false)
    private Long Numero_tarjeta;

    @Column( nullable = false)
    private int cvv_tarjeta;

    @Column( nullable = false)
    private String fechaExpe_tarjeta;

    @Column(nullable = false)
    private String estado;


    @ManyToOne
    @JoinColumn(name="cc_cliente", nullable=false)
    private ClienteModel cc_cliente;

    public Long getId_datos() {
        return id_datos;
    }

    public void setId_datos(Long id_datos) {
        this.id_datos = id_datos;
    }

    public Long getNumero_tarjeta() {
        return Numero_tarjeta;
    }

    public void setNumero_tarjeta(Long numero_tarjeta) {
        Numero_tarjeta = numero_tarjeta;
    }

    public int getCvv_tarjeta() {
        return cvv_tarjeta;
    }

    public void setCvv_tarjeta(int cvv_tarjeta) {
        this.cvv_tarjeta = cvv_tarjeta;
    }

    public String getFechaExpe_tarjeta() {
        return fechaExpe_tarjeta;
    }

    public void setFechaExpe_tarjeta(String fechaExpe_tarjeta) {
        this.fechaExpe_tarjeta = fechaExpe_tarjeta;
    }

    public ClienteModel getCc_cliente() {
        return cc_cliente;
    }

    public void setCc_cliente(ClienteModel cc_cliente) {
        this.cc_cliente = cc_cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
