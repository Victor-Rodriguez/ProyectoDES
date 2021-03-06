/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Usuario
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
    private List<PromocionEntity> promocionEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticulo")
    private List<ImagenEntity> imagenEntityList;
    @JoinColumn(name = "id_rubro", referencedColumnName = "id_rubro")
    @ManyToOne(optional = false)
    private RubroEntity idRubro;
    @JoinColumn(name = "id_subcategoria", referencedColumnName = "id_subcategoria")
    @ManyToOne(optional = false)
    private SubCategoriaEntity idSubcategoria;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    private MarcaEntity idMarca;
    @JoinColumn(name = "id_talla", referencedColumnName = "id_talla")
    @ManyToOne(optional = false)
    private TallaEntity idTalla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticulo")
    private List<VentaEntity> ventaEntityList;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String img1;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String img2;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String img3;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String img4;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String img5;
    
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

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public String getImg5() {
        return img5;
    }

    public void setImg5(String img5) {
        this.img5 = img5;
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

    public List<PromocionEntity> getPromocionEntityList() {
        return promocionEntityList;
    }

    public void setPromocionEntityList(List<PromocionEntity> promocionEntityList) {
        this.promocionEntityList = promocionEntityList;
    }

    public List<ImagenEntity> getImagenEntityList() {
        return imagenEntityList;
    }

    public void setImagenEntityList(List<ImagenEntity> imagenEntityList) {
        this.imagenEntityList = imagenEntityList;
    }

    public RubroEntity getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(RubroEntity idRubro) {
        this.idRubro = idRubro;
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

    public List<VentaEntity> getVentaEntityList() {
        return ventaEntityList;
    }

    public void setVentaEntityList(List<VentaEntity> ventaEntityList) {
        this.ventaEntityList = ventaEntityList;
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
