
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.MarcaEntity;


@Stateless
public class MarcaModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;

    public List<MarcaEntity> listarMarca(){
        Query query = em.createNamedQuery("MarcaEntity.findAll");
        return query.getResultList();
    }
    
    public int insertarMarca(MarcaEntity marca){
        try {
            em.persist(marca);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public MarcaEntity obtenerMarca(String id){
        return em.find(MarcaEntity.class, id);
    }
    
    public int modificarEmpleado(MarcaEntity marca){
        try {
            em.merge(marca);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    
}
