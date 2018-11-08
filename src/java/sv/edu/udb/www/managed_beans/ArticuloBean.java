package sv.edu.udb.www.managed_beans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
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

  private Part imagen;
  private Part imagen2;
  private Part imagen3;
  private Part imagen4;
  private Part imagen5;

    public Part getImagen2() {
        return imagen2;
    }

    public void setImagen2(Part imagen2) {
        this.imagen2 = imagen2;
    }

    public Part getImagen3() {
        return imagen3;
    }

    public void setImagen3(Part imagen3) {
        this.imagen3 = imagen3;
    }

    public Part getImagen4() {
        return imagen4;
    }

    public void setImagen4(Part imagen4) {
        this.imagen4 = imagen4;
    }

    public Part getImagen5() {
        return imagen5;
    }

    public void setImagen5(Part imagen5) {
        this.imagen5 = imagen5;
    }

  
  
    public Part getImagen() {
        return imagen;
    }

    public void setImagen(Part imagen) {
        this.imagen = imagen;
    }
  
  
  
  
   public String insertarArticulo() {
       
   String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");    
     
   try {

            InputStream input = imagen.getInputStream();
            
            InputStream input2 = imagen2.getInputStream();
            InputStream input3 = imagen3.getInputStream();
            InputStream input4 = imagen4.getInputStream();
            InputStream input5 = imagen5.getInputStream();
            
            articulo.setImg1(imagen.getSubmittedFileName());
            
            articulo.setImg2(imagen2.getSubmittedFileName());
            articulo.setImg3(imagen3.getSubmittedFileName());
            articulo.setImg4(imagen4.getSubmittedFileName());
            articulo.setImg5(imagen5.getSubmittedFileName());
            
            Files.copy(input, new File(path + "/resources/img/", articulo.getImg1()).toPath());
            
            Files.copy(input2, new File(path + "/resources/img/", articulo.getImg2()).toPath());
            Files.copy(input3, new File(path + "/resources/img/", articulo.getImg3()).toPath());
            Files.copy(input4, new File(path + "/resources/img/", articulo.getImg4()).toPath());
            Files.copy(input5, new File(path + "/resources/img/", articulo.getImg5()).toPath());
            
        } catch (IOException e) {
            JsfUtils.addErrorMessage("idArticulo", e.toString());
            return null;
        }
       
    if (articuloModel.insertarArticulo(articulo)== 0) {
      JsfUtils.addErrorMessage("articulo", "Ya existe otro articulo con este nombre o código");
      return null;
    }
    JsfUtils.addFlashMessage("exito", "Articulo insertado exitosamente");
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
