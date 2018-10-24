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
@Table(name = "categorias")
@NamedQueries({
    @NamedQuery(name = "CategoriaEntity.findAll", query = "SELECT c FROM CategoriaEntity c")
    , @NamedQuery(name = "CategoriaEntity.findByIdCategoria", query = "SELECT c FROM CategoriaEntity c WHERE c.idCategoria = :idCategoria")
    , @NamedQuery(name = "CategoriaEntity.findByCategoria", query = "SELECT c FROM CategoriaEntity c WHERE c.categoria = :categoria")
    , @NamedQuery(name = "CategoriaEntity.findByDescripcion", query = "SELECT c FROM CategoriaEntity c WHERE c.descripcion = :descripcion")})
public class CategoriaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String categoria;
    @Size(max = 100)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private List<SubCategoriaEntity> subCategoriaEntityList;

    public CategoriaEntity() {
    }

    public CategoriaEntity(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public CategoriaEntity(Integer idCategoria, String categoria) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<SubCategoriaEntity> getSubCategoriaEntityList() {
        return subCategoriaEntityList;
    }

    public void setSubCategoriaEntityList(List<SubCategoriaEntity> subCategoriaEntityList) {
        this.subCategoriaEntityList = subCategoriaEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaEntity)) {
            return false;
        }
        CategoriaEntity other = (CategoriaEntity) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.CategoriaEntity[ idCategoria=" + idCategoria + " ]";
    }
    
}
