
package sv.edu.udb.www.managed_beans;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.EmpleadoEntity;
import sv.edu.udb.www.entities.TipoUsuarioEntity;
import sv.edu.udb.www.entities.UsuarioEntity;
import sv.edu.udb.www.model.EmpleadoModel;
import sv.edu.udb.www.model.UsuarioModel;
import sv.edu.udb.www.utils.JsfUtils;
import sv.edu.udb.www.utils.SecurityUtils;


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
        String cadenaAleatoria = UUID.randomUUID().toString();//generador de la contraseña
        String cadena = cadenaAleatoria.substring(0, 7);//acortado de la cadena y contraseña final
        try {
        if (empleadoModel.verificarDUI(empleado.getDui())==null) {
            
                usuario.setIdTipo(new TipoUsuarioEntity(2));
                usuario.setClave(SecurityUtils.encriptarSHA(cadena));
                System.out.println("contra: "+cadena);
                System.out.println(usuario.getClave());
                if(usuarioModel.insertarUsuario(usuario)==0){
                    JsfUtils.addErrorMessage("correo", "Correo, ya existente");
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
            JsfUtils.addErrorMessage("dui", "Dui ingresado ya existente");
            return null;
        }
        } catch (Exception ex) {
                Logger.getLogger(EmpleadoBean.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }
}
