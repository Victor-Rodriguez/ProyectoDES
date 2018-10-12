
package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.MarcaEntity;
import sv.edu.udb.www.model.MarcaModel;


@Named(value = "marcaBean")
@RequestScoped
public class MarcaBean {

    @EJB
    private MarcaModel marcaModel;
    
    private List<MarcaEntity> listarMarca;
    private MarcaEntity marca = new MarcaEntity();
    
    public MarcaBean() {
    }

    public MarcaEntity getMarca() {
        return marca;
    }

    public void setMarca(MarcaEntity marca) {
        this.marca = marca;
    }
    
    public List<MarcaEntity> getlistarMarca(){
        listarMarca = marcaModel.listarMarca();
        return listarMarca;
    }
}
