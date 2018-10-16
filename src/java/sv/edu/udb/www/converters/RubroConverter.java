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
import sv.edu.udb.www.entities.RubroEntity;
import sv.edu.udb.www.model.RubrosModel;

/**
 *
 * @author Nora Mirian
 */
@FacesConverter(forClass = RubroEntity.class)
public class RubroConverter implements Converter {

  RubrosModel rubroModel = lookupRubrosModelBean();

  
  private RubrosModel lookupRubrosModelBean() {
    try {
      Context c = new InitialContext();
      return (RubrosModel) c.lookup("java:global/ProyectoDES/RubrosModel!sv.edu.udb.www.model.RubrosModel");
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
    return rubroModel.obtenerRubro(id);
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    if (value == null) {
      return "";
    }
    if (value instanceof RubroEntity) {
      return ((RubroEntity) value).getIdRubro().toString();
    }
    return "";
  }
}
