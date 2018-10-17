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
import sv.edu.udb.www.entities.MarcaEntity;
import sv.edu.udb.www.model.MarcaModel;

@FacesConverter(forClass = MarcaEntity.class)
public class MarcaConverter implements Converter{

    MarcaModel marcaModel = lookupMarcaModelBean();

    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return marcaModel.obtenerMarca(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof MarcaEntity) {
            return ((MarcaEntity) value).getIdMarca().toString();
        }
        return "";
    }

    private MarcaModel lookupMarcaModelBean() {
        try {
            Context c = new InitialContext();
            return (MarcaModel) c.lookup("java:global/ProyectoDES/MarcaModel!sv.edu.udb.www.model.MarcaModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
