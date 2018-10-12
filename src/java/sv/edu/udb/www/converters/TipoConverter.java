
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
import sv.edu.udb.www.entities.TipoUsuarioEntity;
import sv.edu.udb.www.model.TipoModel;

@FacesConverter(forClass = TipoUsuarioEntity.class)
public class TipoConverter implements Converter{

    TipoModel tipoModel = lookupTipoModelBean();
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null || value.isEmpty())
        {
            return null;
        }
        return tipoModel.obtenerTipo(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return "";
        }
        if(value instanceof TipoUsuarioEntity){
            ((TipoUsuarioEntity) value).getIdTipo().toString();
        }
        return "";
    }

    private TipoModel lookupTipoModelBean() {
        try {
            Context c = new InitialContext();
            return (TipoModel) c.lookup("java:global/ProyectoDES/TipoModel!sv.edu.udb.www.model.TipoModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
