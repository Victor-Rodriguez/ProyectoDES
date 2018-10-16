
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.TallaEntity;


@Stateless
public class TallaModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;

    public List<TallaEntity> listaTalla(){
        Query query = em.createNamedQuery("TallaEntity.findAll");
        return query.getResultList();
    }
    
    public TallaEntity obtenerTalla(int id){
        return em.find(TallaEntity.class, id);
    }
}
