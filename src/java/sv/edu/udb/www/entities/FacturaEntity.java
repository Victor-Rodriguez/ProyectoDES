/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "factura")
@NamedQueries({
    @NamedQuery(name = "FacturaEntity.findAll", query = "SELECT f FROM FacturaEntity f")
    , @NamedQuery(name = "FacturaEntity.findByIdFactura", query = "SELECT f FROM FacturaEntity f WHERE f.idFactura = :idFactura")
    , @NamedQuery(name = "FacturaEntity.findByFechaCompra", query = "SELECT f FROM FacturaEntity f WHERE f.fechaCompra = :fechaCompra")})
public class FacturaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_factura")
    private String idFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private ClienteEntity idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private List<VentaEntity> ventaEntityList;

    public FacturaEntity() {
    }

    public FacturaEntity(String idFactura) {
        this.idFactura = idFactura;
    }

    public FacturaEntity(String idFactura, Date fechaCompra) {
        this.idFactura = idFactura;
        this.fechaCompra = fechaCompra;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public ClienteEntity getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClienteEntity idCliente) {
        this.idCliente = idCliente;
    }

    public List<VentaEntity> getVentaEntityList() {
        return ventaEntityList;
    }

    public void setVentaEntityList(List<VentaEntity> ventaEntityList) {
        this.ventaEntityList = ventaEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaEntity)) {
            return false;
        }
        FacturaEntity other = (FacturaEntity) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.FacturaEntity[ idFactura=" + idFactura + " ]";
    }
    
}
