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
 * @author Rodriguez
 */
@Entity
@Table(name = "tipo_usuario")
@NamedQueries({
    @NamedQuery(name = "TipoUsuarioEntity.findAll", query = "SELECT t FROM TipoUsuarioEntity t")
    , @NamedQuery(name = "TipoUsuarioEntity.findByIdTipo", query = "SELECT t FROM TipoUsuarioEntity t WHERE t.idTipo = :idTipo")
    , @NamedQuery(name = "TipoUsuarioEntity.findByTipo", query = "SELECT t FROM TipoUsuarioEntity t WHERE t.tipo = :tipo")})
public class TipoUsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private Integer idTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private List<UsuarioEntity> usuarioEntityList;

    public TipoUsuarioEntity() {
    }

    public TipoUsuarioEntity(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public TipoUsuarioEntity(Integer idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<UsuarioEntity> getUsuarioEntityList() {
        return usuarioEntityList;
    }

    public void setUsuarioEntityList(List<UsuarioEntity> usuarioEntityList) {
        this.usuarioEntityList = usuarioEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuarioEntity)) {
            return false;
        }
        TipoUsuarioEntity other = (TipoUsuarioEntity) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.TipoUsuarioEntity[ idTipo=" + idTipo + " ]";
    }
    
}
