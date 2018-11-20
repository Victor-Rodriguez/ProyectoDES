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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author chesn
 */
@Entity
@Table(name = "deseo")
@NamedQueries({
    @NamedQuery(name = "DeseoEntity.findAll", query = "SELECT d FROM DeseoEntity d")
    , @NamedQuery(name = "DeseoEntity.findByIdDeseo", query = "SELECT d FROM DeseoEntity d WHERE d.idDeseo = :idDeseo")
    , @NamedQuery(name = "DeseoEntity.findByCorreo", query = "SELECT d FROM DeseoEntity d WHERE d.correo = :correo")
    , @NamedQuery(name = "DeseoEntity.findByIdProducto", query = "SELECT d FROM DeseoEntity d WHERE d.idProducto = :idProducto")
    , @NamedQuery(name = "DeseoEntity.findByArticulo", query = "SELECT d FROM DeseoEntity d WHERE d.articulo = :articulo")
    , @NamedQuery(name = "DeseoEntity.findByPrecio", query = "SELECT d FROM DeseoEntity d WHERE d.precio = :precio")
    , @NamedQuery(name = "DeseoEntity.findByImg", query = "SELECT d FROM DeseoEntity d WHERE d.img = :img")})
public class DeseoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_deseo")
    private Integer idDeseo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_producto")
    private String idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String articulo;
    @Basic(optional = false)
    @NotNull
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String img;

    public DeseoEntity() {
    }

    public DeseoEntity(Integer idDeseo) {
        this.idDeseo = idDeseo;
    }

    public DeseoEntity(Integer idDeseo, String correo, String idProducto, String articulo, double precio, String img) {
        this.idDeseo = idDeseo;
        this.correo = correo;
        this.idProducto = idProducto;
        this.articulo = articulo;
        this.precio = precio;
        this.img = img;
    }

    public Integer getIdDeseo() {
        return idDeseo;
    }

    public void setIdDeseo(Integer idDeseo) {
        this.idDeseo = idDeseo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeseo != null ? idDeseo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeseoEntity)) {
            return false;
        }
        DeseoEntity other = (DeseoEntity) object;
        if ((this.idDeseo == null && other.idDeseo != null) || (this.idDeseo != null && !this.idDeseo.equals(other.idDeseo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.DeseoEntity[ idDeseo=" + idDeseo + " ]";
    }
    
}
