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
import sv.edu.udb.www.entities.ArticuloEntity;
import sv.edu.udb.www.model.ArticuloModel;

@FacesConverter(forClass = ArticuloEntity.class)
public class ArticuloConverter implements Converter {

    ArticuloModel articuloModel = lookupArticuloModelBean();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return articuloModel.obtenerArticulo(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return "";
        }
       if(value instanceof ArticuloEntity){
            return ((ArticuloEntity) value).getIdArticulo();
        }
        return "";
    }

    private ArticuloModel lookupArticuloModelBean() {
        try {
            Context c = new InitialContext();
            return (ArticuloModel) c.lookup("java:global/ProyectoDES/ArticuloModel!sv.edu.udb.www.model.ArticuloModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
