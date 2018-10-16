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
@Table(name = "sub_rubros")
@NamedQueries({
    @NamedQuery(name = "SubRubroEntity.findAll", query = "SELECT s FROM SubRubroEntity s")
    , @NamedQuery(name = "SubRubroEntity.findByIdSubrubro", query = "SELECT s FROM SubRubroEntity s WHERE s.idSubrubro = :idSubrubro")
    , @NamedQuery(name = "SubRubroEntity.findBySubrubro", query = "SELECT s FROM SubRubroEntity s WHERE s.subrubro = :subrubro")
    , @NamedQuery(name = "SubRubroEntity.findByDescripcion", query = "SELECT s FROM SubRubroEntity s WHERE s.descripcion = :descripcion")})
public class SubRubroEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_subrubro")
    private Integer idSubrubro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String subrubro;
    @Size(max = 100)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubrubro")
    private List<ArticuloEntity> articuloEntityList;
    @JoinColumn(name = "id_rubro", referencedColumnName = "id_rubro")
    @ManyToOne(optional = false)
    private RubroEntity idRubro;

    public SubRubroEntity() {
    }

    public SubRubroEntity(Integer idSubrubro) {
        this.idSubrubro = idSubrubro;
    }

    public SubRubroEntity(Integer idSubrubro, String subrubro) {
        this.idSubrubro = idSubrubro;
        this.subrubro = subrubro;
    }

    public Integer getIdSubrubro() {
        return idSubrubro;
    }

    public void setIdSubrubro(Integer idSubrubro) {
        this.idSubrubro = idSubrubro;
    }

    public String getSubrubro() {
        return subrubro;
    }

    public void setSubrubro(String subrubro) {
        this.subrubro = subrubro;
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

    public RubroEntity getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(RubroEntity idRubro) {
        this.idRubro = idRubro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubrubro != null ? idSubrubro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubRubroEntity)) {
            return false;
        }
        SubRubroEntity other = (SubRubroEntity) object;
        if ((this.idSubrubro == null && other.idSubrubro != null) || (this.idSubrubro != null && !this.idSubrubro.equals(other.idSubrubro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.SubRubroEntity[ idSubrubro=" + idSubrubro + " ]";
    }
    
}
