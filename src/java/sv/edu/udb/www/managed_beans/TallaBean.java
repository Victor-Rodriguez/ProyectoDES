
package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.TallaEntity;
import sv.edu.udb.www.model.TallaModel;
import sv.edu.udb.www.utils.JsfUtils;


@Named(value = "tallaBean")
@RequestScoped
public class TallaBean {

    @EJB
    private TallaModel tallaModel;

    private List<TallaEntity> listarTalla;
    
    private TallaEntity talla = new TallaEntity();

    public TallaBean() {
    }

    public List<TallaEntity> getListarTalla() {
        listarTalla = tallaModel.listaTalla();
        return listarTalla;
    }

    public TallaEntity getTalla() {
        return talla;
    }

    public void setTalla(TallaEntity talla) {
        this.talla = talla;
    }
    public String obtenerTalla(){
        int id = Integer.parseInt(JsfUtils.getRequest().getParameter("id"));
        talla = tallaModel.obtenerTalla(id);
        return "/empleado/modificarTalla";
    }
}
