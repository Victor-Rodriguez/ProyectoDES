/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Rodriguez
 */
@Entity
@Table(name = "clientes")
@NamedQueries({
    @NamedQuery(name = "ClienteEntity.findAll", query = "SELECT c FROM ClienteEntity c")
    , @NamedQuery(name = "ClienteEntity.findByIdCliente", query = "SELECT c FROM ClienteEntity c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "ClienteEntity.findByNombres", query = "SELECT c FROM ClienteEntity c WHERE c.nombres = :nombres")
    , @NamedQuery(name = "ClienteEntity.findByApellidos", query = "SELECT c FROM ClienteEntity c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "ClienteEntity.findByTelefono", query = "SELECT c FROM ClienteEntity c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "ClienteEntity.findByDireccion", query = "SELECT c FROM ClienteEntity c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "ClienteEntity.findByDui", query = "SELECT c FROM ClienteEntity c WHERE c.dui = :dui")
    , @NamedQuery(name = "ClienteEntity.findByConfirmar", query = "SELECT c FROM ClienteEntity c WHERE c.confirmar = :confirmar")
    , @NamedQuery(name = "ClienteEntity.findByIdConfirmar", query = "SELECT c FROM ClienteEntity c WHERE c.idConfirmar = :idConfirmar")})
public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String dui;
    @Basic(optional = false)
    @NotNull
    private boolean confirmar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_confirmar")
    private String idConfirmar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<FacturaEntity> facturaEntityList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private UsuarioEntity idUsuario;

    public ClienteEntity() {
    }

    public ClienteEntity(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public ClienteEntity(Integer idCliente, String nombres, String apellidos, String telefono, String direccion, String dui, boolean confirmar, String idConfirmar) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dui = dui;
        this.confirmar = confirmar;
        this.idConfirmar = idConfirmar;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public boolean getConfirmar() {
        return confirmar;
    }

    public void setConfirmar(boolean confirmar) {
        this.confirmar = confirmar;
    }

    public String getIdConfirmar() {
        return idConfirmar;
    }

    public void setIdConfirmar(String idConfirmar) {
        this.idConfirmar = idConfirmar;
    }

    public List<FacturaEntity> getFacturaEntityList() {
        return facturaEntityList;
    }

    public void setFacturaEntityList(List<FacturaEntity> facturaEntityList) {
        this.facturaEntityList = facturaEntityList;
    }

    public UsuarioEntity getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioEntity idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteEntity)) {
            return false;
        }
        ClienteEntity other = (ClienteEntity) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.ClienteEntity[ idCliente=" + idCliente + " ]";
    }
    
}
