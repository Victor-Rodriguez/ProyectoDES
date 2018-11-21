
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.DeseoEntity;


@Stateless
public class DeseoModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;
    
    
    public List<DeseoEntity> listarDeseos(String correo){
        
        
        
        Query query = em.createNamedQuery("DeseoEntity.findByCorreo").setParameter("correo", correo);
        
        return query.getResultList();
    }
    
    public int insertarDeseo(DeseoEntity categoria){
        try {
            em.persist(categoria);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public DeseoEntity obtenerDeseo(int id){
        return em.find(DeseoEntity.class, id);
    }
    
    public int modificarDeseo(DeseoEntity categoria){
        try {
            em.merge(categoria);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    
     public int eliminarDeseo(int codigo) {
        try {
            DeseoEntity carrito = em.find(DeseoEntity.class, codigo);
            if (carrito != null) {
                em.remove(carrito);
                em.flush();
                return 1;
            }

            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
     
     

    

}
