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
@Table(name = "carrito")
@NamedQueries({
    @NamedQuery(name = "CarritoEntity.findAll", query = "SELECT c FROM CarritoEntity c")
    , @NamedQuery(name = "CarritoEntity.findByIdCarrito", query = "SELECT c FROM CarritoEntity c WHERE c.idCarrito = :idCarrito")
    , @NamedQuery(name = "CarritoEntity.findByCorreo", query = "SELECT c FROM CarritoEntity c WHERE c.correo = :correo")
    , @NamedQuery(name = "CarritoEntity.findByIdProducto", query = "SELECT c FROM CarritoEntity c WHERE c.idProducto = :idProducto")
    , @NamedQuery(name = "CarritoEntity.findByArticulo", query = "SELECT c FROM CarritoEntity c WHERE c.articulo = :articulo")
    , @NamedQuery(name = "CarritoEntity.findByPrecio", query = "SELECT c FROM CarritoEntity c WHERE c.precio = :precio")
    , @NamedQuery(name = "CarritoEntity.findByImg", query = "SELECT c FROM CarritoEntity c WHERE c.img = :img")})
public class CarritoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carrito")
    private Integer idCarrito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
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

    public CarritoEntity() {
    }

    public CarritoEntity(Integer idCarrito) {
        this.idCarrito = idCarrito;
    }

    public CarritoEntity(Integer idCarrito, String correo, String idProducto, String articulo, double precio, String img) {
        this.idCarrito = idCarrito;
        this.correo = correo;
        this.idProducto = idProducto;
        this.articulo = articulo;
        this.precio = precio;
        this.img = img;
    }

    public Integer getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Integer idCarrito) {
        this.idCarrito = idCarrito;
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
        hash += (idCarrito != null ? idCarrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarritoEntity)) {
            return false;
        }
        CarritoEntity other = (CarritoEntity) object;
        if ((this.idCarrito == null && other.idCarrito != null) || (this.idCarrito != null && !this.idCarrito.equals(other.idCarrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.CarritoEntity[ idCarrito=" + idCarrito + " ]";
    }

    
    
}
