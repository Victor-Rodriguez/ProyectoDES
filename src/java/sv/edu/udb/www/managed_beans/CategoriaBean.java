
package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.CategoriaEntity;
import sv.edu.udb.www.model.CategoriaModel;
import sv.edu.udb.www.utils.JsfUtils;


@Named(value = "categoriaBean")
@RequestScoped
public class CategoriaBean {

    @EJB
    private CategoriaModel categoriaModel;
    
    private List<CategoriaEntity> listarCategoria;
    
    private CategoriaEntity categoria = new CategoriaEntity();
    
    public CategoriaBean() {
    }

    public List<CategoriaEntity> getListarCategoria() {
        listarCategoria = categoriaModel.listarCategorias();
        return listarCategoria;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }
    
    public String insertarCategoria(){
        if(categoriaModel.insertarCategoria(categoria) == 0){
            JsfUtils.addErrorMessage("idCategoria", "Ya existe una categoria con este nombre");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Categoria registrada exitosamente");
        return "/empleado/listarCategoria?faces-redirect=true";
    }
    
    public String obtenerCategoria(){
        int id = Integer.parseInt(JsfUtils.getRequest().getParameter("id").toString());
        categoria = categoriaModel.obtenerCategoria(id);
        return "/empleado/modificarCategoria";
    }
    
    public String modificarCategoria(){
        if(categoriaModel.modificarCategoria(categoria) == 0){
            JsfUtils.addErrorMessage("idCategoria", "No se pudo modificar");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Categoria modificada exitosamente");
        return "/empleado/listarCategoria?faces-redirect=true";
    }
}
