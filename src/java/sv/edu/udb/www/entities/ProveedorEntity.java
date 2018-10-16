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
import javax.persistence.Id;
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
@Table(name = "proveedor")
@NamedQueries({
    @NamedQuery(name = "ProveedorEntity.findAll", query = "SELECT p FROM ProveedorEntity p")
    , @NamedQuery(name = "ProveedorEntity.findByIdProveedor", query = "SELECT p FROM ProveedorEntity p WHERE p.idProveedor = :idProveedor")
    , @NamedQuery(name = "ProveedorEntity.findByNombre", query = "SELECT p FROM ProveedorEntity p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "ProveedorEntity.findByCorreo", query = "SELECT p FROM ProveedorEntity p WHERE p.correo = :correo")
    , @NamedQuery(name = "ProveedorEntity.findByDireccion", query = "SELECT p FROM ProveedorEntity p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "ProveedorEntity.findByEstado", query = "SELECT p FROM ProveedorEntity p WHERE p.estado = :estado")})
public class ProveedorEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_proveedor")
    private String idProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String direccion;
    @Basic(optional = false)
    @NotNull
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private List<ArticuloEntity> articuloEntityList;

    public ProveedorEntity() {
    }

    public ProveedorEntity(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public ProveedorEntity(String idProveedor, String nombre, String correo, String direccion, boolean estado) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<ArticuloEntity> getArticuloEntityList() {
        return articuloEntityList;
    }

    public void setArticuloEntityList(List<ArticuloEntity> articuloEntityList) {
        this.articuloEntityList = articuloEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedorEntity)) {
            return false;
        }
        ProveedorEntity other = (ProveedorEntity) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.ProveedorEntity[ idProveedor=" + idProveedor + " ]";
    }
    
}
