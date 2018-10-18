
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.ImagenEntity;

/**
 *
 * @author Rodriguez
 */
@Stateless
public class ImagenModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;

    public List<ImagenEntity> listaImagenes(){
        Query query = em.createNamedQuery("ImagenEntity.findAll");
        return query.getResultList();
    }
    
    public int insertarImagen(ImagenEntity imagen){
        try {
            em.persist(imagen);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public ImagenEntity obtenerImagen(int id){
        return em.find(ImagenEntity.class, id);
    }
    
    public int modificarImagen(ImagenEntity imagen){
        try {
            em.merge(imagen);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

   
}
