
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.RubroEntity;


@Stateless
public class RubrosModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;

        
    public List<RubroEntity> listarRubros(){
        Query query = em.createNamedQuery("RubroEntity.findAll");
        return query.getResultList();
    }
    
    public int insertarRubro(RubroEntity rubro){
        
        try{
            
            em.persist(rubro);
            em.flush();
            return 1;
            
        }catch(Exception e){
            return 0;
        }
        
    }
    
    public int modificarRubro(RubroEntity rubro){
        try {
            em.merge(rubro);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public RubroEntity obtenerRubro(int id){
        return em.find(RubroEntity.class, id);
    }
    
    public int eliminarRubro(int id){
        try {
            RubroEntity rubto = em.find(RubroEntity.class, id);
            
            if(rubto != null){
                em.remove(rubto);
                em.flush();
                return 1;
            }
            
            return 0;  
        } catch (Exception e) {
            return  0;
        }
    }
}
