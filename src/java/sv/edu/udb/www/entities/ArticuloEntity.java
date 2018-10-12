/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Rodriguez
 */
@Entity
@Table(name = "articulos")
@NamedQueries({
    @NamedQuery(name = "ArticuloEntity.findAll", query = "SELECT a FROM ArticuloEntity a")
    , @NamedQuery(name = "ArticuloEntity.findByIdArticulo", query = "SELECT a FROM ArticuloEntity a WHERE a.idArticulo = :idArticulo")
    , @NamedQuery(name = "ArticuloEntity.findByArticulo", query = "SELECT a FROM ArticuloEntity a WHERE a.articulo = :articulo")
    , @NamedQuery(name = "ArticuloEntity.findByCantidad", query = "SELECT a FROM ArticuloEntity a WHERE a.cantidad = :cantidad")
    , @NamedQuery(name = "ArticuloEntity.findByEstilo", query = "SELECT a FROM ArticuloEntity a WHERE a.estilo = :estilo")
    , @NamedQuery(name = "ArticuloEntity.findByPrecio", query = "SELECT a FROM ArticuloEntity a WHERE a.precio = :precio")
    , @NamedQuery(name = "ArticuloEntity.findByDescripcion", query = "SELECT a FROM ArticuloEntity a WHERE a.descripcion = :descripcion")})
public class ArticuloEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_articulo")
    private String idArticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String articulo;
    @Basic(optional = false)
    @NotNull
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String estilo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    private BigDecimal precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticulo")
    private Collection<PromocionEntity> promocionEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticulo")
    private Collection<ImagenEntity> imagenEntityCollection;
    @JoinColumn(name = "id_subrubro", referencedColumnName = "id_subrubro")
    @ManyToOne(optional = false)
    private SubRubroEntity idSubrubro;
    @JoinColumn(name = "id_subcategoria", referencedColumnName = "id_subcategoria")
    @ManyToOne(optional = false)
    private SubCategoriaEntity idSubcategoria;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    private MarcaEntity idMarca;
    @JoinColumn(name = "id_talla", referencedColumnName = "id_talla")
    @ManyToOne(optional = false)
    private TallaEntity idTalla;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne(optional = false)
    private ProveedorEntity idProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticulo")
    private Collection<VentaEntity> ventaEntityCollection;

    public ArticuloEntity() {
    }

    public ArticuloEntity(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public ArticuloEntity(String idArticulo, String articulo, int cantidad, String estilo, BigDecimal precio, String descripcion) {
        this.idArticulo = idArticulo;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.estilo = estilo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<PromocionEntity> getPromocionEntityCollection() {
        return promocionEntityCollection;
    }

    public void setPromocionEntityCollection(Collection<PromocionEntity> promocionEntityCollection) {
        this.promocionEntityCollection = promocionEntityCollection;
    }

    public Collection<ImagenEntity> getImagenEntityCollection() {
        return imagenEntityCollection;
    }

    public void setImagenEntityCollection(Collection<ImagenEntity> imagenEntityCollection) {
        this.imagenEntityCollection = imagenEntityCollection;
    }

    public SubRubroEntity getIdSubrubro() {
        return idSubrubro;
    }

    public void setIdSubrubro(SubRubroEntity idSubrubro) {
        this.idSubrubro = idSubrubro;
    }

    public SubCategoriaEntity getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(SubCategoriaEntity idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public MarcaEntity getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(MarcaEntity idMarca) {
        this.idMarca = idMarca;
    }

    public TallaEntity getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(TallaEntity idTalla) {
        this.idTalla = idTalla;
    }

    public ProveedorEntity getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(ProveedorEntity idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Collection<VentaEntity> getVentaEntityCollection() {
        return ventaEntityCollection;
    }

    public void setVentaEntityCollection(Collection<VentaEntity> ventaEntityCollection) {
        this.ventaEntityCollection = ventaEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticulo != null ? idArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticuloEntity)) {
            return false;
        }
        ArticuloEntity other = (ArticuloEntity) object;
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.ArticuloEntity[ idArticulo=" + idArticulo + " ]";
    }
    
}
