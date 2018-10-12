
package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.RubroEntity;
import sv.edu.udb.www.model.RubrosModel;
import sv.edu.udb.www.utils.JsfUtils;


@Named(value = "rubroBean")
@RequestScoped
public class RubroBean {

    @EJB
    private RubrosModel rubrosModel;

    private RubroEntity rubro = new RubroEntity();
    private List<RubroEntity> listaRubros;
    
    public RubroBean() {
    }

    public List<RubroEntity> getListaRubros() {
        listaRubros=rubrosModel.listarRubros();
        return listaRubros;
    }

    public RubroEntity getRubro() {
        return rubro;
    }

    public void setRubro(RubroEntity rubro) {
        this.rubro = rubro;
    }
    
    
    
    public String insertarRubro(){
        if(rubrosModel.insertarRubro(rubro)==0){
            JsfUtils.addErrorMessage("rubro", "Ya existe un Rubro con ese nombre");
            return null;
        }
        
        JsfUtils.addFlashMessage("exito", "Rubro insertado exitosamente");
        
        return "/rubros/listaRubros?faces-redirect=true";
    }
    
    public String eliminarRubro(){
        int id = Integer.parseInt(JsfUtils.getRequest().getParameter("codigo"));
        
        if(rubrosModel.eliminarRubro(id)>0){
            JsfUtils.addFlashMessage("exito", "Rubro eliminado exitosamente");
        }
        else{
            JsfUtils.addFlashMessage("fracaso", "No se puede eliminar este Rubro");
        }
        
        return null;
    }
    
    public String obtenerRubro(){
        
        int codigo = Integer.parseInt(JsfUtils.getRequest().getParameter("codigo"));
        
        
        rubro = rubrosModel.obtenerRubro(codigo);
        
        return "/rubros/modificarRubro";
    }
    
    public String modificarRubro(){
        
        if(rubrosModel.modificarRubro(rubro)==0){
            
                JsfUtils.addErrorMessage("rubro", "Este Rubro ya existe.");
            return null;
        }
        
        JsfUtils.addFlashMessage("exito", "Rubro modificardo exitosamente");
       
        
        return "/rubros/listaRubros?faces-redirect=true";
    }
    
}
