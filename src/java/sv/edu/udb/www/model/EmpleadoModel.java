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
import sv.edu.udb.www.entities.EmpleadoEntity;

/**
 *
 * @author Rodriguez
 */
@Stateless
public class EmpleadoModel {

    @PersistenceContext(unitName = "ProyectoDESPU")
    private EntityManager em;

    public List<EmpleadoEntity> listarEmpleado(){
        Query query = em.createNamedQuery("EmpleadoEntity.findAll");
        return query.getResultList();
    }
    
    public int insertarEmpleado(EmpleadoEntity empleado){
        try {
            em.persist(empleado);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public EmpleadoEntity obtenerEmpleado(int id){
        return em.find(EmpleadoEntity.class, id);
    }
    
    public EmpleadoEntity verificarDUI(String dui){
        Query query = em.createNamedQuery("EmpleadoEntity.findByDui");
        query.setParameter("dui", dui);
        List<EmpleadoEntity> empleadoList = query.setMaxResults(1).getResultList();
        if (empleadoList.isEmpty()) {
            return null;
        }else{
            EmpleadoEntity empleado = empleadoList.get(0) ;
            return empleado;
        }
        
    }
    
    public int modificarEmpleado(EmpleadoEntity empleado){
        try {
            em.merge(empleado);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
