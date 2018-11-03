
package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.ArticuloEntity;
import sv.edu.udb.www.entities.PromocionEntity;
import sv.edu.udb.www.model.ArticuloModel;
import sv.edu.udb.www.model.PromocionModel;
import sv.edu.udb.www.utils.JsfUtils;


@Named(value = "promocionBean")
@RequestScoped
public class PromocionBean {

    @EJB
    private ArticuloModel articuloModel;

    @EJB
    private PromocionModel promocionModel;
    
    
    private PromocionEntity promocion = new PromocionEntity();
    
    public PromocionBean() {
    }

    public PromocionEntity getPromocion() {
        return promocion;
    }

    public void setPromocion(PromocionEntity promocion) {
        this.promocion = promocion;
    }
    
    public List<PromocionEntity> getListaPromocion(){
        return promocionModel.listarPromocion();
    }
    
    public List<ArticuloEntity> getListaArticulos(){
        return articuloModel.listaArticulos();
    }
    
    public String insertarPromocion(){
        
        if(promocionModel.insertarPromocion(promocion) == 0){
            JsfUtils.addErrorMessage("idpromocion", "Ya existe una promocion con este ID");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Promocion registrado exitosamente");
        return "/administrador/listaPromociones?faces-redirect=true";
    }
    
    public String obtenerPromocion(){
        String id = JsfUtils.getRequest().getParameter("id");
        promocion = promocionModel.obtenerPromocion(id);
        return "/administrador/modificarPromocion";
    }
    
    public String modificarPromocion(){   
        if(promocionModel.modificarPromocion(promocion)== 0){
            JsfUtils.addErrorMessage("idpromocion", "No se pudo modificar");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Promocion modificada exitosamente");
        return "/administrador/listaPromociones?faces-redirect=true";
    }
}
