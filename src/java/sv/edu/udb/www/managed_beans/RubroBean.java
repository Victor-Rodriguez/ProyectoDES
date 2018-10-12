
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
        if(rubrosModel.insertarRubro(rubro) == 0){
            JsfUtils.addErrorMessage("idRubro", "Ya existe un rubro con este nombre");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Rubro insertado exitosamente");
        return "/empleado/listarRubro?faces-redirecttrue";
    }
    
    public String obtenerRubro(){
        int id = Integer.parseInt(JsfUtils.getRequest().getParameter("id").toString());
        rubro = rubrosModel.obtenerRubro(id);
        return "/empleado/modificarRubro";
    }
    
    public String modificarRubro(){
        if(rubrosModel.modificarRubro(rubro) == 0){
            JsfUtils.addErrorMessage("idRubro", "No se pudo modificar");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Rubro modificado exitosamente");
        return "/empleado/listarRubro?faces-redirect=true";
    }
}
