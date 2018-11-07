
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.UsuarioEntity;
import sv.edu.udb.www.utils.SecurityUtils;


@Stateless
public class UsuarioModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;

    public UsuarioEntity verificarUsuario(String clave, String correo){
        try {
            Query query = em.createNamedQuery("UsuarioEntity.checkLogin");
            query.setParameter("usuario", correo);
            query.setParameter("clave", SecurityUtils.encriptarSHA(clave));//
            
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
    
    public UsuarioEntity obtenerUsuario1(){
        Query query = em.createNamedQuery("UsuarioEntity.ultimo");
        List<UsuarioEntity> usuarioList = query.setMaxResults(1).getResultList();
        UsuarioEntity usuario = usuarioList.get(0);
        return usuario;
    }
    public int modificarUsuario(UsuarioEntity usuario){
        try {
            em.merge(usuario);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
