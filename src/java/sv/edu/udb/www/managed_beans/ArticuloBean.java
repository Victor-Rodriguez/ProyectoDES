package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.ArticuloEntity;
import sv.edu.udb.www.entities.CategoriaEntity;
import sv.edu.udb.www.entities.MarcaEntity;
import sv.edu.udb.www.entities.ProveedorEntity;
import sv.edu.udb.www.entities.SubCategoriaEntity;
import sv.edu.udb.www.entities.SubRubroEntity;
import sv.edu.udb.www.entities.TallaEntity;
import sv.edu.udb.www.model.ArticuloModel;
import sv.edu.udb.www.model.CategoriaModel;
import sv.edu.udb.www.model.MarcaModel;
import sv.edu.udb.www.model.ProveedorModel;
import sv.edu.udb.www.model.SubcategoriaModel;
import sv.edu.udb.www.model.SubRubroModel;
import sv.edu.udb.www.model.TallaModel;
import sv.edu.udb.www.utils.JsfUtils;

@Named(value = "articuloBean")
@RequestScoped
public class ArticuloBean {

  @EJB
  private ArticuloModel articuloModel;
  @EJB
  private CategoriaModel categoriaModel;
  @EJB
  private ProveedorModel proveedorModel;
  private SubRubroModel subRubroModel;
  private SubcategoriaModel subCategoriaModel;
  private MarcaModel marcaModel;
  private TallaModel tallaModel;
  private List<ArticuloEntity> listaArticulos;

  private ArticuloEntity articulo = new ArticuloEntity();

  public ArticuloBean() {
  }
  
  
   public List<TallaEntity> getListaTalla() {
    return tallaModel.listaTalla();
  }
  
  public List<MarcaEntity> getListaMarca() {
    return marcaModel.listarMarca();
  }
  
  public List<SubCategoriaEntity> getListaSubCategoria() {
    return subCategoriaModel.listaSubCategorias();
  }
  
  public List<SubRubroEntity> getListaSubRubro() {
    return subRubroModel.listarSubRubros();
  }
    
  public List<ProveedorEntity> getListaProveedor() {
    return proveedorModel.listarProveedor();
  }

  public List<ArticuloEntity> getListaArticulos() {
    listaArticulos = articuloModel.listaArticulos();
    return listaArticulos;
  }

  public List<CategoriaEntity> getListaCategoria() {
    return categoriaModel.listarCategorias();
  }

  public ArticuloEntity getArticulo() {
    return articulo;
  }

  public void setArticulo(ArticuloEntity articulo) {
    this.articulo = articulo;
  }

   public String insertarArticulo() {
    if (articuloModel.insertarArticulo(articulo)== 0) {
      JsfUtils.addErrorMessage("articulo", "Ya existe otro articulo con este nombre");
      return null;
    }
    JsfUtils.addFlashMessage("exito", "Articulo insertada exitosamente");
    return "/empleado/listarArticulo?faces-redirect=true";
  }

  public String obtenerArticulo() {
    String codigo = JsfUtils.getRequest().getParameter("codigo");
    articulo = articuloModel.obtenerArticulo(codigo);
    return "/empleado/modificarArticulo";
  }

  public String modificarArticulo() {
    if (articuloModel.modificarArticulo(articulo) == 0) {
      JsfUtils.addErrorMessage("idArticulo", "No se pudo modificar");
      return null;
    }
    JsfUtils.addFlashMessage("exito", "Artículo modificado exitosamente");
    return "/empleado/listarArticulo?faces-redirect=true";
  }

}
