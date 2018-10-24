/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "promocion")
@NamedQueries({
    @NamedQuery(name = "PromocionEntity.findAll", query = "SELECT p FROM PromocionEntity p")
    , @NamedQuery(name = "PromocionEntity.findByIdPromocion", query = "SELECT p FROM PromocionEntity p WHERE p.idPromocion = :idPromocion")
    , @NamedQuery(name = "PromocionEntity.findByNombre", query = "SELECT p FROM PromocionEntity p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PromocionEntity.findByFechaInico", query = "SELECT p FROM PromocionEntity p WHERE p.fechaInico = :fechaInico")
    , @NamedQuery(name = "PromocionEntity.findByFechaFin", query = "SELECT p FROM PromocionEntity p WHERE p.fechaFin = :fechaFin")
    , @NamedQuery(name = "PromocionEntity.findByPrecioOferta", query = "SELECT p FROM PromocionEntity p WHERE p.precioOferta = :precioOferta")
    , @NamedQuery(name = "PromocionEntity.findByDescripcion", query = "SELECT p FROM PromocionEntity p WHERE p.descripcion = :descripcion")})
public class PromocionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_promocion")
    private String idPromocion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inico")
    @Temporal(TemporalType.DATE)
    private Date fechaInico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_oferta")
    private BigDecimal precioOferta;
    @Size(max = 200)
    private String descripcion;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo")
    @ManyToOne(optional = false)
    private ArticuloEntity idArticulo;

    public PromocionEntity() {
    }

    public PromocionEntity(String idPromocion) {
        this.idPromocion = idPromocion;
    }

    public PromocionEntity(String idPromocion, String nombre, Date fechaInico, Date fechaFin, BigDecimal precioOferta) {
        this.idPromocion = idPromocion;
        this.nombre = nombre;
        this.fechaInico = fechaInico;
        this.fechaFin = fechaFin;
        this.precioOferta = precioOferta;
    }

    public String getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(String idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInico() {
        return fechaInico;
    }

    public void setFechaInico(Date fechaInico) {
        this.fechaInico = fechaInico;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(BigDecimal precioOferta) {
        this.precioOferta = precioOferta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idPromocion != null ? idPromocion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromocionEntity)) {
            return false;
        }
        PromocionEntity other = (PromocionEntity) object;
        if ((this.idPromocion == null && other.idPromocion != null) || (this.idPromocion != null && !this.idPromocion.equals(other.idPromocion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.PromocionEntity[ idPromocion=" + idPromocion + " ]";
    }
    
}
