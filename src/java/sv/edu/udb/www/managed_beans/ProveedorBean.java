
package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.ProveedorEntity;
import sv.edu.udb.www.model.ProveedorModel;
import sv.edu.udb.www.utils.JsfUtils;


@Named(value = "proveedorBean")
@RequestScoped
public class ProveedorBean {

    @EJB
    private ProveedorModel proveedorModel;

    private List<ProveedorEntity> listarProveedor;
    
    private ProveedorEntity proveedor = new ProveedorEntity();

    public ProveedorBean() {
    }

    public List<ProveedorEntity> getListarProveedor() {
        listarProveedor = proveedorModel.listarProveedor();
        return listarProveedor;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }
    
    public String insertarProveedor(){
        if(proveedorModel.insertarProveedor(proveedor) == 0){
            JsfUtils.addErrorMessage("idProveedor", "Ya existe un proveedor con este ID");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Proveedor registrado exitosamente");
        return "/administrador/listarProveedor?faces-redirect=true";
    }
    
    public String obtenerProveedor(){
        int id = Integer.parseInt(JsfUtils.getRequest().getParameter("id").toString());
        proveedor = proveedorModel.obtenerProveedor(id);
        return "/administrador/modificarProveedor";
    }
    
    public String modificarProveedor(){
        if(proveedorModel.modificarProveedor(proveedor)== 0){
            JsfUtils.addErrorMessage("idProveedor", "No se pudo modificar");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Proveedor modificado exitosamente");
        return "/administrador/listarProveedor?faces-redirect=true";
    }

    
}
