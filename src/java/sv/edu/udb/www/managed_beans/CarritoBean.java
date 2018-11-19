
package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import sv.edu.udb.www.entities.CarritoEntity;
import sv.edu.udb.www.model.CarritoModel;
import sv.edu.udb.www.utils.JsfUtils;


@Named(value = "carritoBean")
@RequestScoped
public class CarritoBean {

  
    public CarritoBean() {
    }
    
    @EJB
    private CarritoModel carritoModel;
    

    
    private List<CarritoEntity> listaCarritos;

    private CarritoEntity carrito = new CarritoEntity();

    public CarritoModel getCarritoModel() {
        return carritoModel;
    }

    public void setCarritoModel(CarritoModel carritoModel) {
        this.carritoModel = carritoModel;
    }

    public List<CarritoEntity> getListaCarritos() {
        return listaCarritos;
    }

    public void setListaCarritos(List<CarritoEntity> listaCarritos) {
        this.listaCarritos = listaCarritos;
    }

   

    public CarritoEntity getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoEntity carrito) {
        this.carrito = carrito;
    }


    
}
