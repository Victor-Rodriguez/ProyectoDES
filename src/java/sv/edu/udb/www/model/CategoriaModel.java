
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.CategoriaEntity;


@Stateless
public class CategoriaModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;

    public List<CategoriaEntity> listarCategorias(){
        Query query = em.createNamedQuery("CategoriaEntity.findAll");
        return query.getResultList();
    }
    
    public int insertarCategoria(CategoriaEntity categoria){
        try {
            em.persist(categoria);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public CategoriaEntity obtenerCategoria(int id){
        return em.find(CategoriaEntity.class, id);
    }
    
    public int modificarCategoria(CategoriaEntity categoria){
        try {
            em.merge(categoria);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
}
