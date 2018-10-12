
package sv.edu.udb.www.converters;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sv.edu.udb.www.entities.ProveedorEntity;
import sv.edu.udb.www.model.ProveedorModel;

@FacesConverter(forClass = ProveedorEntity.class)
public class ProveedorConverter implements Converter{

    ProveedorModel proveedorModel = lookupProveedorModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null || value.isEmpty()){
              return null;
          }
        return proveedorModel.obtenerProveedor((value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value==null){
            return "";
        }
       if(value instanceof ProveedorEntity){
            return ((ProveedorEntity) value).getIdProveedor();
        }
        return "";
    }

    private ProveedorModel lookupProveedorModelBean() {
        try {
            Context c = new InitialContext();
            return (ProveedorModel) c.lookup("java:global/ProyectoDES/ProveedorModel!sv.edu.udb.www.model.ProveedorModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
