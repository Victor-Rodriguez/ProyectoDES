/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "imagenes")
@NamedQueries({
    @NamedQuery(name = "ImagenEntity.findAll", query = "SELECT i FROM ImagenEntity i")
    , @NamedQuery(name = "ImagenEntity.findByIdImagen", query = "SELECT i FROM ImagenEntity i WHERE i.idImagen = :idImagen")
    , @NamedQuery(name = "ImagenEntity.findByUrl", query = "SELECT i FROM ImagenEntity i WHERE i.url = :url")})
public class ImagenEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_imagen")
    private Integer idImagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String url;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo")
    @ManyToOne(optional = false)
    private ArticuloEntity idArticulo;

    public ImagenEntity() {
    }

    public ImagenEntity(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public ImagenEntity(Integer idImagen, String url) {
        this.idImagen = idImagen;
        this.url = url;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArticuloEntity getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(ArticuloEntity idArticulo) {
        this.idArticulo = idArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImagen != null ? idImagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImagenEntity)) {
            return false;
        }
        ImagenEntity other = (ImagenEntity) object;
        if ((this.idImagen == null && other.idImagen != null) || (this.idImagen != null && !this.idImagen.equals(other.idImagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.ImagenEntity[ idImagen=" + idImagen + " ]";
    }
    
}
