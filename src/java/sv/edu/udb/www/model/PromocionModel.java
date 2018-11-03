
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.PromocionEntity;


@Stateless
public class PromocionModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;
    
    
    
    public List<PromocionEntity> listarPromocion(){
        Query query = em.createNamedQuery("PromocionEntity.findAll");
        return query.getResultList();
    }

    public int insertarPromocion(PromocionEntity promocion){
        try {
            em.persist(promocion);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public PromocionEntity obtenerPromocion(String id){
        return em.find(PromocionEntity.class, id);
    }
    
    public int modificarPromocion(PromocionEntity promocion){
        try {
            em.merge(promocion);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
