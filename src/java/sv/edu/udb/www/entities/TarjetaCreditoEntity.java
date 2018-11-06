/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "tarjeta_credito")
@NamedQueries({
    @NamedQuery(name = "TarjetaCreditoEntity.findAll", query = "SELECT t FROM TarjetaCreditoEntity t")
    , @NamedQuery(name = "TarjetaCreditoEntity.findByCc", query = "SELECT t FROM TarjetaCreditoEntity t WHERE t.cc = :cc")
    , @NamedQuery(name = "TarjetaCreditoEntity.findByCCnum", query = "SELECT t FROM TarjetaCreditoEntity t WHERE t.cCnum = :cCnum")
    , @NamedQuery(name = "TarjetaCreditoEntity.findByNombreTitular", query = "SELECT t FROM TarjetaCreditoEntity t WHERE t.nombreTitular = :nombreTitular")
    , @NamedQuery(name = "TarjetaCreditoEntity.findByFechaExp", query = "SELECT t FROM TarjetaCreditoEntity t WHERE t.fechaExp = :fechaExp")})
public class TarjetaCreditoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer cc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CC_num")
    private String cCnum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_titular")
    private String nombreTitular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_exp")
    @Temporal(TemporalType.DATE)
    private Date fechaExp;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private ClienteEntity idCliente;

    public TarjetaCreditoEntity() {
    }

    public TarjetaCreditoEntity(Integer cc) {
        this.cc = cc;
    }

    public TarjetaCreditoEntity(Integer cc, String cCnum, String nombreTitular, Date fechaExp) {
        this.cc = cc;
        this.cCnum = cCnum;
        this.nombreTitular = nombreTitular;
        this.fechaExp = fechaExp;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public String getCCnum() {
        return cCnum;
    }

    public void setCCnum(String cCnum) {
        this.cCnum = cCnum;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public Date getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(Date fechaExp) {
        this.fechaExp = fechaExp;
    }

    public ClienteEntity getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClienteEntity idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cc != null ? cc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarjetaCreditoEntity)) {
            return false;
        }
        TarjetaCreditoEntity other = (TarjetaCreditoEntity) object;
        if ((this.cc == null && other.cc != null) || (this.cc != null && !this.cc.equals(other.cc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.TarjetaCreditoEntity[ cc=" + cc + " ]";
    }
    
}
