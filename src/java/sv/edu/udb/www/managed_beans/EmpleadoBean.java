
package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.EmpleadoEntity;
import sv.edu.udb.www.entities.TipoUsuarioEntity;
import sv.edu.udb.www.entities.UsuarioEntity;
import sv.edu.udb.www.model.EmpleadoModel;
import sv.edu.udb.www.model.UsuarioModel;
import sv.edu.udb.www.utils.JsfUtils;


@Named(value = "empleadoBean")
@RequestScoped
public class EmpleadoBean {

    @EJB
    private UsuarioModel usuarioModel;

    @EJB
    private EmpleadoModel empleadoModel;
    
    
    private List<EmpleadoEntity>listarEmpleado;
    
    private EmpleadoEntity empleado = new EmpleadoEntity();
    private UsuarioEntity usuario = new UsuarioEntity();
    
    private UsuarioEntity usuario2 = new UsuarioEntity();
    
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

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    
    public String insertarEmpleado(){
        if (empleadoModel.verificarDUI(empleado.getDui())==null) {
            usuario.setIdTipo(new TipoUsuarioEntity(2));
            if(usuarioModel.insertarUsuario(usuario)==0){
                JsfUtils.addErrorMessage("usuario", "Datos de empleado ingresados incorrectamente");
                return null;
            }
            usuario2 = usuarioModel.obtenerUsuario1();
            empleado.setIdUsuario(new UsuarioEntity(usuario2.getIdUsuario()));
            if(empleadoModel.insertarEmpleado(empleado)==0){
                JsfUtils.addErrorMessage("empleado", "Datos del empleado ingresados incorrectamente");
                return null;
            }

            JsfUtils.addFlashMessage("exito", "Empleado insertada exitosamente");

            return "/administrador/listarEmpleado?faces-redirect=true";
        }else{
            JsfUtils.addErrorMessage("empleado", "Dui ingresado ya existente");
            return null;
        }
    }
}
