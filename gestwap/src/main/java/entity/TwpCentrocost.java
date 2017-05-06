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
@Table(name = "twp_centrocost", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpCentrocost.findAll", query = "SELECT t FROM TwpCentrocost t")
    , @NamedQuery(name = "TwpCentrocost.findByTcentcId", query = "SELECT t FROM TwpCentrocost t WHERE t.tcentcId = :tcentcId")
    , @NamedQuery(name = "TwpCentrocost.findByTcentcCod", query = "SELECT t FROM TwpCentrocost t WHERE t.tcentcCod = :tcentcCod")
    , @NamedQuery(name = "TwpCentrocost.findByTcentcDet", query = "SELECT t FROM TwpCentrocost t WHERE t.tcentcDet = :tcentcDet")})
public class TwpCentrocost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tcentc_id", nullable = false)
    private Integer tcentcId;
    @Size(max = 10)
    @Column(name = "tcentc_cod", length = 10)
    private String tcentcCod;
    @Size(max = 250)
    @Column(name = "tcentc_det", length = 250)
    private String tcentcDet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpCentrocostTcentcId")
    private List<TwpProy> twpProyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpCentrocostTcentcId")
    private List<TwpCostos> twpCostosList;

    public TwpCentrocost() {
    }

    public TwpCentrocost(Integer tcentcId) {
        this.tcentcId = tcentcId;
    }

    public Integer getTcentcId() {
        return tcentcId;
    }

    public void setTcentcId(Integer tcentcId) {
        this.tcentcId = tcentcId;
    }

    public String getTcentcCod() {
        return tcentcCod;
    }

    public void setTcentcCod(String tcentcCod) {
        this.tcentcCod = tcentcCod;
    }

    public String getTcentcDet() {
        return tcentcDet;
    }

    public void setTcentcDet(String tcentcDet) {
        this.tcentcDet = tcentcDet;
    }

    @XmlTransient
    public List<TwpProy> getTwpProyList() {
        return twpProyList;
    }

    public void setTwpProyList(List<TwpProy> twpProyList) {
        this.twpProyList = twpProyList;
    }

    @XmlTransient
    public List<TwpCostos> getTwpCostosList() {
        return twpCostosList;
    }

    public void setTwpCostosList(List<TwpCostos> twpCostosList) {
        this.twpCostosList = twpCostosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcentcId != null ? tcentcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpCentrocost)) {
            return false;
        }
        TwpCentrocost other = (TwpCentrocost) object;
        if ((this.tcentcId == null && other.tcentcId != null) || (this.tcentcId != null && !this.tcentcId.equals(other.tcentcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpCentrocost[ tcentcId=" + tcentcId + " ]";
    }
    
}
