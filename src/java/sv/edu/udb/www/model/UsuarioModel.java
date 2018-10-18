
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.UsuarioEntity;


@Stateless
public class UsuarioModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;

    public UsuarioEntity verificarUsuario(String clave, String correo){
        try {
            Query query = em.createNamedQuery("UsuarioEntity.checkLogin");
            query.setParameter("usuario", correo);
            query.setParameter("clave", (clave));//SecurityUtils.encriptarSHA
            
            return (UsuarioEntity) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public int insertarUsuario(UsuarioEntity usuario){
        try{
            em.persist(usuario);
            em.flush();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }

    public UsuarioEntity obtenerUsuario(int id){
        return em.find(UsuarioEntity.class, id);
    }
    
    
    
}
