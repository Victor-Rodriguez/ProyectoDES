
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.TipoUsuarioEntity;


@Stateless
public class TipoModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;

    public List<TipoUsuarioEntity> listarTipos(){
        Query query = em.createNamedQuery("TipoUsuarioEntity.findAll");
        return query.getResultList();
    }
    
    public TipoUsuarioEntity obtenerTipo(int codigo){
        return em.find(TipoUsuarioEntity.class,codigo);
    }

}
