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
 * @author Usuario
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "UsuarioEntity.findAll", query = "SELECT u FROM UsuarioEntity u")
    , @NamedQuery(name = "UsuarioEntity.findByIdUsuario", query = "SELECT u FROM UsuarioEntity u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "UsuarioEntity.checkLogin", query = "SELECT u FROM UsuarioEntity u WHERE u.correo=:usuario AND u.clave=:clave")
    , @NamedQuery(name = "UsuarioEntity.ultimo", query = "SELECT u FROM UsuarioEntity u ORDER BY u.idUsuario DESC")
    , @NamedQuery(name = "UsuarioEntity.findByNombreUsuario", query = "SELECT u FROM UsuarioEntity u WHERE u.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "UsuarioEntity.findByCorreo", query = "SELECT u FROM UsuarioEntity u WHERE u.correo = :correo")
    , @NamedQuery(name = "UsuarioEntity.findByClave", query = "SELECT u FROM UsuarioEntity u WHERE u.clave = :clave")})
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    private String clave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<EmpleadoEntity> empleadoEntityList;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private TipoUsuarioEntity idTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<ClienteEntity> clienteEntityList;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioEntity(Integer idUsuario, String nombreUsuario, String correo, String clave) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.clave = clave;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<EmpleadoEntity> getEmpleadoEntityList() {
        return empleadoEntityList;
    }

    public void setEmpleadoEntityList(List<EmpleadoEntity> empleadoEntityList) {
        this.empleadoEntityList = empleadoEntityList;
    }

    public TipoUsuarioEntity getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoUsuarioEntity idTipo) {
        this.idTipo = idTipo;
    }

    public List<ClienteEntity> getClienteEntityList() {
        return clienteEntityList;
    }

    public void setClienteEntityList(List<ClienteEntity> clienteEntityList) {
        this.clienteEntityList = clienteEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioEntity)) {
            return false;
        }
        UsuarioEntity other = (UsuarioEntity) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.UsuarioEntity[ idUsuario=" + idUsuario + " ]";
    }
    
}
