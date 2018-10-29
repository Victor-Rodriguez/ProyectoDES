
package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import sv.edu.udb.www.entities.TipoUsuarioEntity;
import sv.edu.udb.www.entities.UsuarioEntity;
import sv.edu.udb.www.model.TipoModel;
import sv.edu.udb.www.model.UsuarioModel;
import sv.edu.udb.www.utils.JsfUtils;



@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    @EJB
    private TipoModel tipoModel;

    @EJB
    private UsuarioModel usuarioModel;

    private UsuarioEntity usuario = new UsuarioEntity();
    private String correo;
    private String clave;
    public LoginBean() {
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public List<TipoUsuarioEntity> getListaTipo(){
        return tipoModel.listarTipos();
    }
    
    public String iniciarSesion(){
        UsuarioEntity user= usuarioModel.verificarUsuario(clave, correo);
        if(user==null){
            JsfUtils.addErrorMessage(null, "Usuario y/o contraseña incorrecto");
            return null;
        }
        else{
            HttpServletRequest request= JsfUtils.getRequest();
            request.getSession().setAttribute("user", correo);
            request.getSession().setAttribute("nombre", user.getNombreUsuario());
            request.getSession().setAttribute("rol",user.getIdTipo());
            if(null==user.getIdTipo().getIdTipo()){
                return "/login?faces-redirect=true"; //direccion del cliente
            }else //System.out.println("hola"+user.getIdTipo().getIdTipo());
            switch (user.getIdTipo().getIdTipo()) {
                case 1:
                    return "/administrador/index?faces-redirect=true"; //direccion del administrador
                case 2:
                    return "/empleado/listarArticulo?faces-redirect=true"; //direccion del empleado
                case 3:
                    return "/index?faces-redirect=true"; //direccion del cliente
                default:
                    return "/login?faces-redirect=true";
            }
        }
    }
    
    public String cerrarSesion(){
        JsfUtils.getRequest().getSession().invalidate();
        return "/login?faces-redirect=true";
    }
    
    public String insertarUsuario(){
        usuario.setIdTipo(new TipoUsuarioEntity(3));
        if(usuarioModel.insertarUsuario(usuario)==0){
            JsfUtils.addErrorMessage("codigoUsuario", "Ya existe un usuario con ese correo o nombre de usuario");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "usuario insertado exitosamente");
        return "/login?faces-redirect=true";
    }
    public String insertarUsuario2(){
        usuario.setIdTipo(new TipoUsuarioEntity(2));
        if(usuarioModel.insertarUsuario(usuario)==0){
            JsfUtils.addErrorMessage("codigoUsuario", "Ya existe un usuario con ese codigo");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "usuario insertado exitosamente");
        return "/administrador/listarEmpleado?faces-redirect=true";
    }
}
