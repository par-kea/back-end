package co.edu.unbosque.forpets.repositories.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parqueadero")
public class ParqueaderoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_Parqueadero;

    @Column( nullable = false)
    private String tipoTecho;
    @Column( nullable = false)
    private String Direccion;
    @Column( nullable = false)
    private String Ciudad;
    @Column( nullable = false)
    private Integer EspaciosTotales;
    @Column( nullable = false)
    private Integer EspaciosOcupados;
    @Column( nullable = false)
    private String HorasAtencion;
    @Column( nullable = false)
    private Float PrecioMinuto;
    @Column( nullable = false)
    private Boolean Fidelizacion;

    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name="cc_admin", nullable=false)
    @JsonIgnore
    private AdminModel cc_admin;

    @ManyToOne
    @JoinColumn(name="cc_funcionario", nullable=false)
    @JsonIgnore
    private FuncionarioModel cc_funcionario;


    public Long getId_Parqueadero() {
        return id_Parqueadero;
    }

    public void setId_Parqueadero(Long id_Parqueadero) {
        this.id_Parqueadero = id_Parqueadero;
    }

    public String getTipoTecho() {
        return tipoTecho;
    }

    public void setTipoTecho(String tipoTecho) {
        this.tipoTecho = tipoTecho;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public Integer getEspaciosTotales() {
        return EspaciosTotales;
    }

    public void setEspaciosTotales(Integer espaciosTotales) {
        EspaciosTotales = espaciosTotales;
    }

    public Integer getEspaciosOcupados() {
        return EspaciosOcupados;
    }

    public void setEspaciosOcupados(Integer espaciosOcupados) {
        EspaciosOcupados = espaciosOcupados;
    }

    public String getHorasAtencion() {
        return HorasAtencion;
    }

    public void setHorasAtencion(String horasAtencion) {
        HorasAtencion = horasAtencion;
    }


    public Float getPrecioMinuto() {
        return PrecioMinuto;
    }

    public void setPrecioMinuto(Float precioMinuto) {
        PrecioMinuto = precioMinuto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getFidelizacion() {
        return Fidelizacion;
    }

    public void setFidelizacion(Boolean fidelizacion) {
        Fidelizacion = fidelizacion;
    }

    public AdminModel getCc_admin() {
        return cc_admin;
    }

    public void setCc_admin(AdminModel cc_admin) {
        this.cc_admin = cc_admin;
    }

    public FuncionarioModel getCc_funcionario() {
        return cc_funcionario;
    }

    public void setCc_funcionario(FuncionarioModel cc_funcionario) {
        this.cc_funcionario = cc_funcionario;
    }



}
