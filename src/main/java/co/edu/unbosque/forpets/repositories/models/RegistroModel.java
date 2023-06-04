package co.edu.unbosque.forpets.repositories.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "resgistro")
public class RegistroModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_registro;
    @Column( nullable = false)
    private String fecha;
    @Column( nullable = false)
    private String ip;
    @Column(nullable = false)
    private String estado;
    @ManyToOne
    @JoinColumn(name="cc_usuarioF")
    private FuncionarioModel cc_funcionario;
    @ManyToOne
    @JoinColumn(name="cc_usuarioC")
    private ClienteModel cc_cliente;

    public Long getId_registro() {
        return id_registro;
    }

    public void setId_registro(Long id_registro) {
        this.id_registro = id_registro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public FuncionarioModel getCc_funcionario() {
        return cc_funcionario;
    }

    public void setCc_funcionario(FuncionarioModel cc_funcionario) {
        this.cc_funcionario = cc_funcionario;
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
