/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "twp_iva", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpIva.findAll", query = "SELECT t FROM TwpIva t")
    , @NamedQuery(name = "TwpIva.findByTivaId", query = "SELECT t FROM TwpIva t WHERE t.tivaId = :tivaId")
    , @NamedQuery(name = "TwpIva.findByTivaPorc", query = "SELECT t FROM TwpIva t WHERE t.tivaPorc = :tivaPorc")
    , @NamedQuery(name = "TwpIva.findByTivaA\u00f1o", query = "SELECT t FROM TwpIva t WHERE t.tivaA\u00f1o = :tivaA\u00f1o")})
public class TwpIva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tiva_id", nullable = false)
    private Integer tivaId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tiva_porc", precision = 2, scale = 1)
    private BigDecimal tivaPorc;
    @Size(max = 4)
    @Column(name = "tiva_a\u00f1o", length = 4)
    private String tivaAño;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpIvaTivaId")
    private List<TwpProy> twpProyList;

    public TwpIva() {
    }

    public TwpIva(Integer tivaId) {
        this.tivaId = tivaId;
    }

    public Integer getTivaId() {
        return tivaId;
    }

    public void setTivaId(Integer tivaId) {
        this.tivaId = tivaId;
    }

    public BigDecimal getTivaPorc() {
        return tivaPorc;
    }

    public void setTivaPorc(BigDecimal tivaPorc) {
        this.tivaPorc = tivaPorc;
    }

    public String getTivaAño() {
        return tivaAño;
    }

    public void setTivaAño(String tivaAño) {
        this.tivaAño = tivaAño;
    }

    @XmlTransient
    public List<TwpProy> getTwpProyList() {
        return twpProyList;
    }

    public void setTwpProyList(List<TwpProy> twpProyList) {
        this.twpProyList = twpProyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tivaId != null ? tivaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpIva)) {
            return false;
        }
        TwpIva other = (TwpIva) object;
        if ((this.tivaId == null && other.tivaId != null) || (this.tivaId != null && !this.tivaId.equals(other.tivaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpIva[ tivaId=" + tivaId + " ]";
    }
    
}
