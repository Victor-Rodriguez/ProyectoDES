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
@Table(name = "talla")
@NamedQueries({
    @NamedQuery(name = "TallaEntity.findAll", query = "SELECT t FROM TallaEntity t")
    , @NamedQuery(name = "TallaEntity.findByIdTalla", query = "SELECT t FROM TallaEntity t WHERE t.idTalla = :idTalla")
    , @NamedQuery(name = "TallaEntity.findByTalla", query = "SELECT t FROM TallaEntity t WHERE t.talla = :talla")})
public class TallaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_talla")
    private Integer idTalla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String talla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTalla")
    private List<ArticuloEntity> articuloEntityList;

    public TallaEntity() {
    }

    public TallaEntity(Integer idTalla) {
        this.idTalla = idTalla;
    }

    public TallaEntity(Integer idTalla, String talla) {
        this.idTalla = idTalla;
        this.talla = talla;
    }

    public Integer getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(Integer idTalla) {
        this.idTalla = idTalla;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
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
        hash += (idTalla != null ? idTalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TallaEntity)) {
            return false;
        }
        TallaEntity other = (TallaEntity) object;
        if ((this.idTalla == null && other.idTalla != null) || (this.idTalla != null && !this.idTalla.equals(other.idTalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.TallaEntity[ idTalla=" + idTalla + " ]";
    }
    
}
