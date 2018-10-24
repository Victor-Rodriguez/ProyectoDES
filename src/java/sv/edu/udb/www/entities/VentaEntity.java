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
@Table(name = "ventas")
@NamedQueries({
    @NamedQuery(name = "VentaEntity.findAll", query = "SELECT v FROM VentaEntity v")
    , @NamedQuery(name = "VentaEntity.findByIdVenta", query = "SELECT v FROM VentaEntity v WHERE v.idVenta = :idVenta")
    , @NamedQuery(name = "VentaEntity.findByFechaCompra", query = "SELECT v FROM VentaEntity v WHERE v.fechaCompra = :fechaCompra")
    , @NamedQuery(name = "VentaEntity.findByCantidad", query = "SELECT v FROM VentaEntity v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "VentaEntity.findByPrecio", query = "SELECT v FROM VentaEntity v WHERE v.precio = :precio")})
public class VentaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_venta")
    private String idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Basic(optional = false)
    @NotNull
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    private BigDecimal precio;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private EmpleadoEntity idEmpleado;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo")
    @ManyToOne(optional = false)
    private ArticuloEntity idArticulo;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
    @ManyToOne(optional = false)
    private FacturaEntity idFactura;

    public VentaEntity() {
    }

    public VentaEntity(String idVenta) {
        this.idVenta = idVenta;
    }

    public VentaEntity(String idVenta, Date fechaCompra, int cantidad, BigDecimal precio) {
        this.idVenta = idVenta;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public EmpleadoEntity getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(EmpleadoEntity idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public ArticuloEntity getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(ArticuloEntity idArticulo) {
        this.idArticulo = idArticulo;
    }

    public FacturaEntity getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(FacturaEntity idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaEntity)) {
            return false;
        }
        VentaEntity other = (VentaEntity) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.VentaEntity[ idVenta=" + idVenta + " ]";
    }
    
}
