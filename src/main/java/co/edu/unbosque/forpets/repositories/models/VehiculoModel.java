package co.edu.unbosque.forpets.repositories.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "vehiculo")
public class VehiculoModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_vehiculo;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name="cc_cliente", nullable=false)
    private ClienteModel cc_cliente;


    public Long getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Long id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public ClienteModel getCc_cliente() {
        return cc_cliente;
    }

    public void setCc_cliente(ClienteModel cc_cliente) {
        this.cc_cliente = cc_cliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
