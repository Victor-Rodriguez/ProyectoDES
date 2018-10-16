package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.RubroEntity;
import sv.edu.udb.www.entities.SubRubroEntity;
import sv.edu.udb.www.model.RubrosModel;
import sv.edu.udb.www.model.SubRubroModel;
import sv.edu.udb.www.utils.JsfUtils;

@Named(value = "subRubroBean")
@RequestScoped
public class SubRubroBean {

  @EJB
  private SubRubroModel subRubroModel;
  @EJB
  private RubrosModel rubroModel;
  private SubRubroEntity subRubro = new SubRubroEntity();

  public SubRubroBean() {}

  public List<SubRubroEntity> getListaSubRubro() {
    return subRubroModel.listarSubRubros();
  }

  public List<RubroEntity> getListaRubro() {
    return rubroModel.listarRubros();
  }

  public SubRubroEntity getSubRubro() {
    return subRubro;
  }

  public void setSubRubro(SubRubroEntity subRubro) {
    this.subRubro = subRubro;
  }

  public String insertarSubRubro() {
    JsfUtils.addErrorMessage("idSubRubro", "Ya existe otra Sub-categoría con este nombre");  
    if (subRubroModel.insertarSubRubro(subRubro) == 0) {
      JsfUtils.addErrorMessage("idSubRubro", "Ya existe otra Sub-categoría con este nombre");
      return null;
    }
    JsfUtils.addFlashMessage("exito", "Sub-categoría insertada exitosamente");
    return "/empleado/listarSubRubro?faces-redirect=true";
  }

  public String obtenerSubRubro() {
    int id = Integer.parseInt(JsfUtils.getRequest().getParameter("id").toString());
    subRubro = subRubroModel.obtenerSubRubro(id);
    return "/empleado/modificarSubRubro";
  }

  public String modificarSubRubro() {
    if (subRubroModel.modificarSubRubro(subRubro) == 0) {
      JsfUtils.addErrorMessage("idSubRubro", "No se pudo modificar");
      return null;
    }
    JsfUtils.addFlashMessage("exito", "Sub-categoría modificada exitosamente");
    return "/empleado/listarSubRubro?faces-redirect=true";
  }
}
