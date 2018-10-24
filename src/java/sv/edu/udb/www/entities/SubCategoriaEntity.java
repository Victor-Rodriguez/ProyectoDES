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
@Table(name = "sub_categoria")
@NamedQueries({
    @NamedQuery(name = "SubCategoriaEntity.findAll", query = "SELECT s FROM SubCategoriaEntity s")
    , @NamedQuery(name = "SubCategoriaEntity.findByIdSubcategoria", query = "SELECT s FROM SubCategoriaEntity s WHERE s.idSubcategoria = :idSubcategoria")
    , @NamedQuery(name = "SubCategoriaEntity.findBySubcategoria", query = "SELECT s FROM SubCategoriaEntity s WHERE s.subcategoria = :subcategoria")
    , @NamedQuery(name = "SubCategoriaEntity.findByDescripcion", query = "SELECT s FROM SubCategoriaEntity s WHERE s.descripcion = :descripcion")})
public class SubCategoriaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_subcategoria")
    private Integer idSubcategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String subcategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubcategoria")
    private List<ArticuloEntity> articuloEntityList;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private CategoriaEntity idCategoria;

    public SubCategoriaEntity() {
    }

    public SubCategoriaEntity(Integer idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public SubCategoriaEntity(Integer idSubcategoria, String subcategoria, String descripcion) {
        this.idSubcategoria = idSubcategoria;
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
    }

    public Integer getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(Integer idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ArticuloEntity> getArticuloEntityList() {
        return articuloEntityList;
    }

    public void setArticuloEntityList(List<ArticuloEntity> articuloEntityList) {
        this.articuloEntityList = articuloEntityList;
    }

    public CategoriaEntity getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(CategoriaEntity idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubcategoria != null ? idSubcategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubCategoriaEntity)) {
            return false;
        }
        SubCategoriaEntity other = (SubCategoriaEntity) object;
        if ((this.idSubcategoria == null && other.idSubcategoria != null) || (this.idSubcategoria != null && !this.idSubcategoria.equals(other.idSubcategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.SubCategoriaEntity[ idSubcategoria=" + idSubcategoria + " ]";
    }
    
}
