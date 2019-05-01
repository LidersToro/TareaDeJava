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
@Table(name = "Productox1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productox1.findAll", query = "SELECT p FROM Productox1 p")
    , @NamedQuery(name = "Productox1.findByProductoID", query = "SELECT p FROM Productox1 p WHERE p.productoID = :productoID")
    , @NamedQuery(name = "Productox1.findByNombre", query = "SELECT p FROM Productox1 p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Productox1.findByPrecio", query = "SELECT p FROM Productox1 p WHERE p.precio = :precio")})
public class Productox1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "productoID")
    private Integer productoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoID")
    private Collection<Venta> ventaCollection;

    public Productox1() {
    }

    public Productox1(Integer productoID) {
        this.productoID = productoID;
    }

    public Productox1(Integer productoID, String nombre, int precio) {
        this.productoID = productoID;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getProductoID() {
        return productoID;
    }

    public void setProductoID(Integer productoID) {
        this.productoID = productoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
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
        hash += (productoID != null ? productoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productox1)) {
            return false;
        }
        Productox1 other = (Productox1) object;
        if ((this.productoID == null && other.productoID != null) || (this.productoID != null && !this.productoID.equals(other.productoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Productox1[ productoID=" + productoID + " ]";
    }
    
}
