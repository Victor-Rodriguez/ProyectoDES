package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.ArticuloEntity;
import sv.edu.udb.www.entities.CategoriaEntity;
import sv.edu.udb.www.entities.MarcaEntity;
import sv.edu.udb.www.entities.ProveedorEntity;
import sv.edu.udb.www.entities.RubroEntity;
import sv.edu.udb.www.entities.SubCategoriaEntity;
import sv.edu.udb.www.entities.TallaEntity;
import sv.edu.udb.www.model.ArticuloModel;
import sv.edu.udb.www.model.CategoriaModel;
import sv.edu.udb.www.model.MarcaModel;
import sv.edu.udb.www.model.ProveedorModel;
import sv.edu.udb.www.model.RubrosModel;
import sv.edu.udb.www.model.SubcategoriaModel;
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
  @EJB
  private SubcategoriaModel subCategoriaModel;
  @EJB
  private MarcaModel marcaModel;
  @EJB
  private TallaModel tallaModel;
  
  @EJB
  private RubrosModel rubrosModel;
  
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

  public List<RubroEntity> getListaRubro(){
      return rubrosModel.listarRubros();
  }
  
  public ArticuloEntity getArticulo() {
    return articulo;
  }

  public void setArticulo(ArticuloEntity articulo) {
    this.articulo = articulo;
  }

  public RubrosModel getRubrosModel() {
    return rubrosModel;
 }

 public void setRubrosModel(RubrosModel rubrosModel) {
    this.rubrosModel = rubrosModel;
 }

  
  
  
   public String insertarArticulo() {
    if (articuloModel.insertarArticulo(articulo)== 0) {
      JsfUtils.addErrorMessage("articulo", "Ya existe otro articulo con este nombre o código");
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
