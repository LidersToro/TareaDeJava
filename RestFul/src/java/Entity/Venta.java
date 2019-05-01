/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Liders Toro
 */
@Entity
@Table(name = "Venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByVentaID", query = "SELECT v FROM Venta v WHERE v.ventaID = :ventaID")
    , @NamedQuery(name = "Venta.findByFacha", query = "SELECT v FROM Venta v WHERE v.facha = :facha")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ventaID")
    private Integer ventaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "facha")
    @Temporal(TemporalType.DATE)
    private Date facha;
    @JoinColumn(name = "clienteID", referencedColumnName = "clienteID")
    @ManyToOne(optional = false)
    private Clientex1 clienteID;
    @JoinColumn(name = "productoID", referencedColumnName = "productoID")
    @ManyToOne(optional = false)
    private Productox1 productoID;

    public Venta() {
    }

    public Venta(Integer ventaID) {
        this.ventaID = ventaID;
    }

    public Venta(Integer ventaID, Date facha) {
        this.ventaID = ventaID;
        this.facha = facha;
    }

    public Integer getVentaID() {
        return ventaID;
    }

    public void setVentaID(Integer ventaID) {
        this.ventaID = ventaID;
    }

    public Date getFacha() {
        return facha;
    }

    public void setFacha(Date facha) {
        this.facha = facha;
    }

    public Clientex1 getClienteID() {
        return clienteID;
    }

    public void setClienteID(Clientex1 clienteID) {
        this.clienteID = clienteID;
    }

    public Productox1 getProductoID() {
        return productoID;
    }

    public void setProductoID(Productox1 productoID) {
        this.productoID = productoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventaID != null ? ventaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.ventaID == null && other.ventaID != null) || (this.ventaID != null && !this.ventaID.equals(other.ventaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Venta[ ventaID=" + ventaID + " ]";
    }
    
}
