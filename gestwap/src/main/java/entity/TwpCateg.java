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
@Table(name = "twp_categ", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpCateg.findAll", query = "SELECT t FROM TwpCateg t")
    , @NamedQuery(name = "TwpCateg.findByTcatId", query = "SELECT t FROM TwpCateg t WHERE t.tcatId = :tcatId")
    , @NamedQuery(name = "TwpCateg.findByTcatCod", query = "SELECT t FROM TwpCateg t WHERE t.tcatCod = :tcatCod")
    , @NamedQuery(name = "TwpCateg.findByTcatDet", query = "SELECT t FROM TwpCateg t WHERE t.tcatDet = :tcatDet")})
public class TwpCateg implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twCategoriaTcategId")
    private List<TwpProveedor> twpProveedorList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tcat_id", nullable = false)
    private Integer tcatId;
    @Size(max = 4)
    @Column(name = "tcat_cod", length = 4)
    private String tcatCod;
    @Size(max = 150)
    @Column(name = "tcat_det", length = 150)
    private String tcatDet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpCategTcatId")
    private List<TwProducto> twProductoList;

    public TwpCateg() {
    }

    public TwpCateg(Integer tcatId) {
        this.tcatId = tcatId;
    }

    public Integer getTcatId() {
        return tcatId;
    }

    public void setTcatId(Integer tcatId) {
        this.tcatId = tcatId;
    }

    public String getTcatCod() {
        return tcatCod;
    }

    public void setTcatCod(String tcatCod) {
        this.tcatCod = tcatCod;
    }

    public String getTcatDet() {
        return tcatDet;
    }

    public void setTcatDet(String tcatDet) {
        this.tcatDet = tcatDet;
    }

    @XmlTransient
    public List<TwProducto> getTwProductoList() {
        return twProductoList;
    }

    public void setTwProductoList(List<TwProducto> twProductoList) {
        this.twProductoList = twProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcatId != null ? tcatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpCateg)) {
            return false;
        }
        TwpCateg other = (TwpCateg) object;
        if ((this.tcatId == null && other.tcatId != null) || (this.tcatId != null && !this.tcatId.equals(other.tcatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpCateg[ tcatId=" + tcatId + " ]";
    }

    @XmlTransient
    public List<TwpProveedor> getTwpProveedorList() {
        return twpProveedorList;
    }

    public void setTwpProveedorList(List<TwpProveedor> twpProveedorList) {
        this.twpProveedorList = twpProveedorList;
    }
    
}
