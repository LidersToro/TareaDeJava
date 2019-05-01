/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Liders Toro
 */
@Entity
@Table(name = "Clientex1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientex1.findAll", query = "SELECT c FROM Clientex1 c")
    , @NamedQuery(name = "Clientex1.findByClienteID", query = "SELECT c FROM Clientex1 c WHERE c.clienteID = :clienteID")
    , @NamedQuery(name = "Clientex1.findByNombre", query = "SELECT c FROM Clientex1 c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Clientex1.findByCorreo", query = "SELECT c FROM Clientex1 c WHERE c.correo = :correo")})
public class Clientex1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "clienteID")
    private Integer clienteID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteID")
    private Collection<Venta> ventaCollection;

    public Clientex1() {
    }

    public Clientex1(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public Clientex1(Integer clienteID, String nombre, String correo) {
        this.clienteID = clienteID;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Integer getClienteID() {
        return clienteID;
    }

    public void setClienteID(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteID != null ? clienteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientex1)) {
            return false;
        }
        Clientex1 other = (Clientex1) object;
        if ((this.clienteID == null && other.clienteID != null) || (this.clienteID != null && !this.clienteID.equals(other.clienteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Clientex1[ clienteID=" + clienteID + " ]";
    }
    
}
