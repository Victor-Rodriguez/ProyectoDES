
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.ProveedorEntity;


@Stateless
public class ProveedorModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;

    

    public List<ProveedorEntity> listarProveedor(){
        Query query = em.createNamedQuery("ProveedorEntity.findAll");
        return query.getResultList();
    }

    public int insertarProveedor(ProveedorEntity proveedor){
        try {
            em.persist(proveedor);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public ProveedorEntity obtenerProveedor(String id){
        return em.find(ProveedorEntity.class, id);
    }
    
    public int modificarProveedor(ProveedorEntity proveedor){
        try {
            em.merge(proveedor);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
