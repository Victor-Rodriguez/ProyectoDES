
package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.MarcaEntity;
import sv.edu.udb.www.entities.ProveedorEntity;
import sv.edu.udb.www.model.MarcaModel;
import sv.edu.udb.www.model.ProveedorModel;
import sv.edu.udb.www.utils.JsfUtils;


@Named(value = "marcaBean")
@RequestScoped
public class MarcaBean {

    @EJB
    private ProveedorModel proveedorModel;

    @EJB
    private MarcaModel marcaModel;
    
    
    
    private List<MarcaEntity> listarMarca;
    private MarcaEntity marca = new MarcaEntity();
    
    public MarcaBean() {
    }
    public List<MarcaEntity> getListaMarca() {
        return marcaModel.listarMarca();
    }
    
    public List<ProveedorEntity> getListaProveedor() {
        return proveedorModel.listarProveedor();
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
    
    public String insertarMarca(){
        //System.out.println("HOLAHOLAHOLA"+marca.getMarca());
        if(marcaModel.insertarMarca(marca)==0){
            JsfUtils.addErrorMessage("marca", "Ya existe una marca con ese codigo");
            return null;
        }
        
        JsfUtils.addFlashMessage("exito", "Marca insertada exitosamente");
        
        return "/administrador/listaMarcas?faces-redirect=true";
    }
    
    public String obtenerMarca(){
        
        int codigo = Integer.parseInt(JsfUtils.getRequest().getParameter("codigo"));
        
        
        marca = marcaModel.obtenerMarca(codigo);
        
        return "/administrador/modificarMarca";
    }
    
    public String modificarMarca(){
        
        if(marcaModel.modificarMarca(marca)==0){
            
                JsfUtils.addErrorMessage("marca", "Esta marca ya existe.");
            return null;
        }
        
        JsfUtils.addFlashMessage("exito", "Marca modificada exitosamente");
       
        
        return "/administrador/listaMarcas?faces-redirect=true";
    }
}
