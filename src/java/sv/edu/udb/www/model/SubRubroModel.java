package sv.edu.udb.www.model;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.SubRubroEntity;
import sv.edu.udb.www.utils.JsfUtils;
@Stateless
public class SubRubroModel {

  @PersistenceContext(unitName = "ProyectoDESPU")
  private EntityManager em;

  public List<SubRubroEntity> listarSubRubros() {
    Query query = em.createNamedQuery("SubRubroEntity.findAll");
    return query.getResultList();
  }

  public int insertarSubRubro(SubRubroEntity subR) {
    try {
      em.persist(subR);
      em.flush();
      return 1;
    } catch (Exception e) {
      JsfUtils.addErrorMessage("idSubRubro", e.toString());
      return 0;
    }
  }

  public SubRubroEntity obtenerSubRubro(int id) {
    return em.find(SubRubroEntity.class, id);
  }

  public int modificarSubRubro(SubRubroEntity subC) {
    try {
      em.merge(subC);
      em.flush();
      return 1;
    } catch (Exception e) {
      return 0;
    }
  }
}
