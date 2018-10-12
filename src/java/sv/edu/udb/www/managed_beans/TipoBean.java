
package sv.edu.udb.www.managed_beans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.TipoUsuarioEntity;
import sv.edu.udb.www.model.TipoModel;



@Named(value = "tipoBean")
@RequestScoped
public class TipoBean {

    @EJB
    private TipoModel tipoModel;
    
    private TipoUsuarioEntity tipo = new TipoUsuarioEntity();
    
    
    public TipoBean() {
    }

    public TipoUsuarioEntity getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuarioEntity tipo) {
        this.tipo = tipo;
    }
    
    
    
}
