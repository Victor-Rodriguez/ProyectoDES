
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
import sv.edu.udb.www.entities.SubCategoriaEntity;
import sv.edu.udb.www.model.SubcategoriaModel;

@FacesConverter(forClass = SubCategoriaEntity.class)
public class SubcategoriaConverter implements Converter{

    SubcategoriaModel subcategoriaModel = lookupSubcategoriaModelBean();

    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null || value.isEmpty()){
              return null;
          }
        return subcategoriaModel.obtenerSubCategoria(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return "";
        }
        if(value instanceof SubCategoriaEntity){
            return ((SubCategoriaEntity) value).getIdSubcategoria().toString();
        }
        return "";
    }

    private SubcategoriaModel lookupSubcategoriaModelBean() {
        try {
            Context c = new InitialContext();
            return (SubcategoriaModel) c.lookup("java:global/ProyectoDES/SubcategoriaModel!sv.edu.udb.www.model.SubcategoriaModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
