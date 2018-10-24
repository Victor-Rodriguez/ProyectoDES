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
@Table(name = "marca")
@NamedQueries({
    @NamedQuery(name = "MarcaEntity.findAll", query = "SELECT m FROM MarcaEntity m")
    , @NamedQuery(name = "MarcaEntity.findByIdMarca", query = "SELECT m FROM MarcaEntity m WHERE m.idMarca = :idMarca")
    , @NamedQuery(name = "MarcaEntity.findByMarca", query = "SELECT m FROM MarcaEntity m WHERE m.marca = :marca")})
public class MarcaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_marca")
    private Integer idMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String marca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarca")
    private List<ArticuloEntity> articuloEntityList;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne(optional = false)
    private ProveedorEntity idProveedor;

    public MarcaEntity() {
    }

    public MarcaEntity(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public MarcaEntity(Integer idMarca, String marca) {
        this.idMarca = idMarca;
        this.marca = marca;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<ArticuloEntity> getArticuloEntityList() {
        return articuloEntityList;
    }

    public void setArticuloEntityList(List<ArticuloEntity> articuloEntityList) {
        this.articuloEntityList = articuloEntityList;
    }

    public ProveedorEntity getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(ProveedorEntity idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarca != null ? idMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaEntity)) {
            return false;
        }
        MarcaEntity other = (MarcaEntity) object;
        if ((this.idMarca == null && other.idMarca != null) || (this.idMarca != null && !this.idMarca.equals(other.idMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.MarcaEntity[ idMarca=" + idMarca + " ]";
    }
    
}
