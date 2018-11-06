
package sv.edu.udb.www.managed_beans;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import sv.edu.udb.www.entities.EmpleadoEntity;
import sv.edu.udb.www.entities.TipoUsuarioEntity;
import sv.edu.udb.www.entities.UsuarioEntity;
import sv.edu.udb.www.model.EmpleadoModel;
import sv.edu.udb.www.model.UsuarioModel;
import sv.edu.udb.www.utils.Correo;
import sv.edu.udb.www.utils.JsfUtils;
import sv.edu.udb.www.utils.SecurityUtils;


@Named(value = "empleadoBean")
@RequestScoped
public class EmpleadoBean {

    @EJB
    private UsuarioModel usuarioModel;

    @EJB
    private EmpleadoModel empleadoModel;
    
    HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
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
            //insertar empleado
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
                }//fin de insercion
                
                //Envio de correo
                String texto = empleado.getNombres()+" "+empleado.getApellidos()+" tu usuario ha sido registrado exitosamente.<br>";
                    texto+="Tu contraseña es: "+cadena+"<br>";
                    texto+="Para ingresar a tu cuenta puedes dar click";
                    String url = origRequest.getRequestURL().toString();
                    String enlace = url.substring(0, url.length() - origRequest.getRequestURI().length()) + origRequest.getContextPath() +"/faces/login.xhtml";
                    texto+="<a target='a_blank'"
                            + "href='"+enlace+"'>aqui</a>";

                    Correo correo = new Correo();
                    correo.setAsunto("Registro de empleado");
                    correo.setMensaje(texto);
                    correo.setDestinatario(usuario.getCorreo());

                    //String directorio = getServletContext().getRealPath("assets/pdf");
                    //correo.setRutaAdjunto(directorio+"\\proyecto.pdf");
                    //correo.setNombreAdjunto("Especificaciones del proyecto de catedra.pdf");

                    correo.enviarCorreo();
                
                //Fin de correo
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
    
    public String obtenerEmpleado(){
        int id = Integer.parseInt( JsfUtils.getRequest().getParameter("id"));
        empleado = empleadoModel.obtenerEmpleado(id);
        return "/administrador/modificarEmpleado";
    } 
    
    
    
    
}
