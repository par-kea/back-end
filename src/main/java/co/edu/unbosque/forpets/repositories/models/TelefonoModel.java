package co.edu.unbosque.forpets.repositories.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "telefono")

public class TelefonoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_telefono;
    @Column(nullable = false)
    private String num_Telefono;
    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name="cc_cliente", nullable=false)

    private ClienteModel cc_cliente;

    public Long getId_telefono() {
        return id_telefono;
    }

    public void setId_telefono(Long id_telefono) {
        this.id_telefono = id_telefono;
    }

    public ClienteModel getCc_cliente() {
        return cc_cliente;
    }

    public void setCc_cliente(ClienteModel cc_cliente) {
        this.cc_cliente = cc_cliente;
    }

    public String getNum_Telefono() {
        return num_Telefono;
    }

    public void setNum_Telefono(String num_Telefono) {
        this.num_Telefono = num_Telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
