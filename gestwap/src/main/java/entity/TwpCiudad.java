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
@Table(name = "twp_ciudad", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpCiudad.findAll", query = "SELECT t FROM TwpCiudad t")
    , @NamedQuery(name = "TwpCiudad.findByTciudId", query = "SELECT t FROM TwpCiudad t WHERE t.tciudId = :tciudId")
    , @NamedQuery(name = "TwpCiudad.findByTciudCod", query = "SELECT t FROM TwpCiudad t WHERE t.tciudCod = :tciudCod")
    , @NamedQuery(name = "TwpCiudad.findByTciudNombre", query = "SELECT t FROM TwpCiudad t WHERE t.tciudNombre = :tciudNombre")
    , @NamedQuery(name = "TwpCiudad.findByTdeptoId", query = "SELECT t FROM TwpCiudad t WHERE t.tdeptoId = :tdeptoId")})
public class TwpCiudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tciud_id", nullable = false)
    private Integer tciudId;
    @Size(max = 6)
    @Column(name = "tciud_cod", length = 6)
    private String tciudCod;
    @Size(max = 45)
    @Column(name = "tciud_nombre", length = 45)
    private String tciudNombre;
    @Size(max = 45)
    @Column(name = "tdepto_id", length = 45)
    private String tdeptoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpCiudadTciudId")
    private List<TwpProy> twpProyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpCiudadTciudId")
    private List<TwpProveedor> twpProveedorList;

    public TwpCiudad() {
    }

    public TwpCiudad(Integer tciudId) {
        this.tciudId = tciudId;
    }

    public Integer getTciudId() {
        return tciudId;
    }

    public void setTciudId(Integer tciudId) {
        this.tciudId = tciudId;
    }

    public String getTciudCod() {
        return tciudCod;
    }

    public void setTciudCod(String tciudCod) {
        this.tciudCod = tciudCod;
    }

    public String getTciudNombre() {
        return tciudNombre;
    }

    public void setTciudNombre(String tciudNombre) {
        this.tciudNombre = tciudNombre;
    }

    public String getTdeptoId() {
        return tdeptoId;
    }

    public void setTdeptoId(String tdeptoId) {
        this.tdeptoId = tdeptoId;
    }

    @XmlTransient
    public List<TwpProy> getTwpProyList() {
        return twpProyList;
    }

    public void setTwpProyList(List<TwpProy> twpProyList) {
        this.twpProyList = twpProyList;
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
        hash += (tciudId != null ? tciudId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpCiudad)) {
            return false;
        }
        TwpCiudad other = (TwpCiudad) object;
        if ((this.tciudId == null && other.tciudId != null) || (this.tciudId != null && !this.tciudId.equals(other.tciudId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpCiudad[ tciudId=" + tciudId + " ]";
    }
    
}
