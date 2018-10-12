
package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.CategoriaEntity;
import sv.edu.udb.www.entities.SubCategoriaEntity;
import sv.edu.udb.www.model.CategoriaModel;
import sv.edu.udb.www.model.SubcategoriaModel;
import sv.edu.udb.www.utils.JsfUtils;


@Named(value = "subCategoriaBean")
@RequestScoped
public class SubCategoriaBean {

    @EJB
    private SubcategoriaModel subcategoriaModel;
    @EJB
    private CategoriaModel categoriaModel;
    
    private List<SubCategoriaEntity> listaSubCategoria;
    
    
    private SubCategoriaEntity subCate = new SubCategoriaEntity();
    
    public SubCategoriaBean() {
    }

    public List<SubCategoriaEntity> getListaSubCategoria() {
        listaSubCategoria = subcategoriaModel.listaSubCategorias();
        return listaSubCategoria;
    }
    
    public List<CategoriaEntity> getListaCategoria(){
        return categoriaModel.listarCategorias();
    }
    public SubCategoriaEntity getSubCate() {
        return subCate;
    }

    public void setSubCate(SubCategoriaEntity subCate) {
        this.subCate = subCate;
    }
    
    public String insertarSubCategoria(){
        if(subcategoriaModel.insertarSubCategoria(subCate) == 0){
            JsfUtils.addErrorMessage("idSubcategoria", "Ya existe otra Sub-categoría con este nombre");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Sub-categoría insertada exitosamente");
        return "/empleado/listarSubcategoria?faces-redirect=true";
    }
    
    public String obtenerSubCategoria(){
        int id = Integer.parseInt(JsfUtils.getRequest().getParameter("id").toString());
        subCate = subcategoriaModel.obtenerSubCategoria(id);
        return "/empleado/modificarSubcategoria";
    }
    
    public String modificarSubCategoria(){
        if(subcategoriaModel.modificarSubCategoria(subCate) == 0){
            JsfUtils.addErrorMessage("idSubcategoria", "No se pudo modificar");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Sub-categoría modificada exitosamente");
        return "/empleado/listarSubcategoria?faces-redirect=true";
    }
}
