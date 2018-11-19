/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.CarritoEntity;

/**
 *
 * @author chesn
 */
@Stateless
public class CarritoModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;

    public List<CarritoEntity> listarCarritos(String correo){
        
        
        
        Query query = em.createNamedQuery("CarritoEntity.findByCorreo").setParameter("correo", correo);
        
        return query.getResultList();
    }
    
    public int insertarCarrito(CarritoEntity categoria){
        try {
            em.persist(categoria);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public CarritoEntity obtenerCategoria(int id){
        return em.find(CarritoEntity.class, id);
    }
    
    public int modificarCarrito(CarritoEntity categoria){
        try {
            em.merge(categoria);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    
     public int eliminarCarrito(int codigo) {
        try {
            CarritoEntity carrito = em.find(CarritoEntity.class, codigo);
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
