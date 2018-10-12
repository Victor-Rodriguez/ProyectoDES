
package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.EmpleadoEntity;
import sv.edu.udb.www.model.EmpleadoModel;


@Named(value = "empleadoBean")
@RequestScoped
public class EmpleadoBean {

    @EJB
    private EmpleadoModel empleadoModel;
    
    private List<EmpleadoEntity>listarEmpleado;
    
    private EmpleadoEntity empleado = new EmpleadoEntity();
    
    public EmpleadoBean() {
    }

    public List<EmpleadoEntity> getListarEmpleado() {
        listarEmpleado = empleadoModel.listarEmpleado();
        return listarEmpleado;
    }

    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }
    
    
}
