
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
import sv.edu.udb.www.entities.UsuarioEntity;
import sv.edu.udb.www.model.UsuarioModel;

@FacesConverter(forClass = UsuarioEntity.class)
public class UsuarioConverter implements Converter{

    UsuarioModel usuarioModel = lookupUsuarioModelBean();

    
            
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
          if(value==null || value.isEmpty()){
              return null;
          }
          return usuarioModel.obtenerUsuario(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return "";
        }
        if(value instanceof UsuarioEntity){
            return ((UsuarioEntity) value).getIdUsuario().toString();
        }
        return "";
    }

    private UsuarioModel lookupUsuarioModelBean() {
        try {
            Context c = new InitialContext();
            return (UsuarioModel) c.lookup("java:global/ProyectoDES/UsuarioModel!sv.edu.udb.www.model.UsuarioModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
