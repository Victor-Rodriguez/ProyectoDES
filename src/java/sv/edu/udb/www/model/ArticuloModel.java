
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.ArticuloEntity;


@Stateless
public class ArticuloModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;

    public List<ArticuloEntity> listaArticulos(){
        Query query = em.createNamedQuery("ArticuloEntity.findAll");
        return query.getResultList();
    }
    
    public int insertarArticulo(ArticuloEntity articulo){
        try {
            em.persist(articulo);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public ArticuloEntity obtenerArticulo(String codigo){
        return em.find(ArticuloEntity.class, codigo);
    }
    
    public int modificarArticulo(ArticuloEntity articulo){
        try {
            em.merge(articulo);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
