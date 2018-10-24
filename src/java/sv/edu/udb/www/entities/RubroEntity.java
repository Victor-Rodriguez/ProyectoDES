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
@Table(name = "rubros")
@NamedQueries({
    @NamedQuery(name = "RubroEntity.findAll", query = "SELECT r FROM RubroEntity r")
    , @NamedQuery(name = "RubroEntity.findByIdRubro", query = "SELECT r FROM RubroEntity r WHERE r.idRubro = :idRubro")
    , @NamedQuery(name = "RubroEntity.findByRubro", query = "SELECT r FROM RubroEntity r WHERE r.rubro = :rubro")
    , @NamedQuery(name = "RubroEntity.findByDescripcion", query = "SELECT r FROM RubroEntity r WHERE r.descripcion = :descripcion")})
public class RubroEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rubro")
    private Integer idRubro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String rubro;
    @Size(max = 100)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRubro")
    private List<SubRubroEntity> subRubroEntityList;

    public RubroEntity() {
    }

    public RubroEntity(Integer idRubro) {
        this.idRubro = idRubro;
    }

    public RubroEntity(Integer idRubro, String rubro) {
        this.idRubro = idRubro;
        this.rubro = rubro;
    }

    public Integer getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(Integer idRubro) {
        this.idRubro = idRubro;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<SubRubroEntity> getSubRubroEntityList() {
        return subRubroEntityList;
    }

    public void setSubRubroEntityList(List<SubRubroEntity> subRubroEntityList) {
        this.subRubroEntityList = subRubroEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRubro != null ? idRubro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RubroEntity)) {
            return false;
        }
        RubroEntity other = (RubroEntity) object;
        if ((this.idRubro == null && other.idRubro != null) || (this.idRubro != null && !this.idRubro.equals(other.idRubro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.RubroEntity[ idRubro=" + idRubro + " ]";
    }
    
}
