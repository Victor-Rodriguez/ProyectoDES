
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
import sv.edu.udb.www.entities.TallaEntity;
import sv.edu.udb.www.model.TallaModel;

@FacesConverter(forClass = TallaEntity.class)
public class TallaConverter implements Converter{

    TallaModel tallaModel = lookupTallaModelBean();

    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return tallaModel.obtenerTalla(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof TallaEntity) {
            ((TallaEntity) value).getIdTalla().toString();
        }
        return "";
    }

    private TallaModel lookupTallaModelBean() {
        try {
            Context c = new InitialContext();
            return (TallaModel) c.lookup("java:global/ProyectoDES/TallaModel!sv.edu.udb.www.model.TallaModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
