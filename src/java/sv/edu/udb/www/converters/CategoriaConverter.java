/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import sv.edu.udb.www.entities.CategoriaEntity;
import sv.edu.udb.www.model.CategoriaModel;

/**
 *
 * @author Nora Mirian
 */
@FacesConverter(forClass = CategoriaEntity.class)
public class CategoriaConverter implements Converter {

    CategoriaModel categoriaModel = lookupCategoriasModelBean();

    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
             if (value == null || value.isEmpty()) {
            return null;
        }
        int id = Integer.parseInt(value);
        return categoriaModel.obtenerCategoria(id); 
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if(value == null){
            return "";
        }
        if(value instanceof CategoriaEntity){
            ((CategoriaEntity) value).getIdCategoria().toString();
        }
        return "";
    }
    private CategoriaModel lookupCategoriasModelBean() {
        try {
            Context c = new InitialContext();
            return (CategoriaModel) c.lookup("java:global/ProyectoDES/CategoriaModel!sv.edu.udb.www.model.CategoriaModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
