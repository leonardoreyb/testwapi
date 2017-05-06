/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leona
 */
@Entity
@Table(name = "twp_servicio", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpServicio.findAll", query = "SELECT t FROM TwpServicio t")
    , @NamedQuery(name = "TwpServicio.findByTservId", query = "SELECT t FROM TwpServicio t WHERE t.tservId = :tservId")
    , @NamedQuery(name = "TwpServicio.findByTservCod", query = "SELECT t FROM TwpServicio t WHERE t.tservCod = :tservCod")
    , @NamedQuery(name = "TwpServicio.findByTservDetalle", query = "SELECT t FROM TwpServicio t WHERE t.tservDetalle = :tservDetalle")})
public class TwpServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tserv_id", nullable = false)
    private Integer tservId;
    @Size(max = 45)
    @Column(name = "tserv_cod", length = 45)
    private String tservCod;
    @Size(max = 200)
    @Column(name = "tserv_detalle", length = 200)
    private String tservDetalle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpServicioTservId")
    private List<TwpProveedor> twpProveedorList;

    public TwpServicio() {
    }

    public TwpServicio(Integer tservId) {
        this.tservId = tservId;
    }

    public Integer getTservId() {
        return tservId;
    }

    public void setTservId(Integer tservId) {
        this.tservId = tservId;
    }

    public String getTservCod() {
        return tservCod;
    }

    public void setTservCod(String tservCod) {
        this.tservCod = tservCod;
    }

    public String getTservDetalle() {
        return tservDetalle;
    }

    public void setTservDetalle(String tservDetalle) {
        this.tservDetalle = tservDetalle;
    }

    @XmlTransient
    public List<TwpProveedor> getTwpProveedorList() {
        return twpProveedorList;
    }

    public void setTwpProveedorList(List<TwpProveedor> twpProveedorList) {
        this.twpProveedorList = twpProveedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tservId != null ? tservId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpServicio)) {
            return false;
        }
        TwpServicio other = (TwpServicio) object;
        if ((this.tservId == null && other.tservId != null) || (this.tservId != null && !this.tservId.equals(other.tservId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpServicio[ tservId=" + tservId + " ]";
    }
    
}
