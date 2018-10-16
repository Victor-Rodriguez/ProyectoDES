/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Rodriguez
 */
@Entity
@Table(name = "empleados")
@NamedQueries({
    @NamedQuery(name = "EmpleadoEntity.findAll", query = "SELECT e FROM EmpleadoEntity e")
    , @NamedQuery(name = "EmpleadoEntity.findByIdEmpleado", query = "SELECT e FROM EmpleadoEntity e WHERE e.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "EmpleadoEntity.findByNombres", query = "SELECT e FROM EmpleadoEntity e WHERE e.nombres = :nombres")
    , @NamedQuery(name = "EmpleadoEntity.findByApellidos", query = "SELECT e FROM EmpleadoEntity e WHERE e.apellidos = :apellidos")
    , @NamedQuery(name = "EmpleadoEntity.findByDui", query = "SELECT e FROM EmpleadoEntity e WHERE e.dui = :dui")})
public class EmpleadoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String dui;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private UsuarioEntity idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<VentaEntity> ventaEntityList;

    public EmpleadoEntity() {
    }

    public EmpleadoEntity(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public EmpleadoEntity(Integer idEmpleado, String nombres, String apellidos, String dui) {
        this.idEmpleado = idEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dui = dui;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public UsuarioEntity getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioEntity idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<VentaEntity> getVentaEntityList() {
        return ventaEntityList;
    }

    public void setVentaEntityList(List<VentaEntity> ventaEntityList) {
        this.ventaEntityList = ventaEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoEntity)) {
            return false;
        }
        EmpleadoEntity other = (EmpleadoEntity) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.EmpleadoEntity[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
