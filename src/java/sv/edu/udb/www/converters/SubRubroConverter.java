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
import sv.edu.udb.www.entities.SubRubroEntity;
import sv.edu.udb.www.model.SubRubroModel;

/**
 *
 * @author Nora Mirian
 */
@FacesConverter(forClass = SubRubroEntity.class)
public class SubRubroConverter implements Converter {

    SubRubroModel subRubroModel = lookupSubRubroModelBean();

    private SubRubroModel lookupSubRubroModelBean() {
    try {
            Context c = new InitialContext();
            return (SubRubroModel) c.lookup("java:global/ProyectoDES/SubRubroModel!sv.edu.udb.www.model.SubRubroModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         if (value == null || value.isEmpty()) {
            return null;
        }
        int id = Integer.parseInt(value);
        return subRubroModel.obtenerSubRubro(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof SubRubroEntity) {
            return ((SubRubroEntity) value).getIdSubrubro().toString();
        }
        return "";
    }
}
