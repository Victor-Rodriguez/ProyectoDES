
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.SubCategoriaEntity;


@Stateless
public class SubcategoriaModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;

    public List<SubCategoriaEntity> listaSubCategorias(){
        Query query = em.createNamedQuery("SubCategoriaEntity.findAll");
        return query.getResultList();
    }
    
    public int insertarSubCategoria(SubCategoriaEntity subC){
        try {
            em.persist(subC);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public SubCategoriaEntity obtenerSubCategoria(int id){
        return em.find(SubCategoriaEntity.class, id);
    }
    
    public int modificarSubCategoria(SubCategoriaEntity subC){
        try {
            em.merge(subC);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
