/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leona
 */
@Entity
@Table(name = "twp_provhtcont", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpProvhtcont.findAll", query = "SELECT t FROM TwpProvhtcont t")
    , @NamedQuery(name = "TwpProvhtcont.findByTwphc", query = "SELECT t FROM TwpProvhtcont t WHERE t.twphc = :twphc")})
public class TwpProvhtcont implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "twphc", nullable = false)
    private Integer twphc;
    @JoinColumn(name = "twpContid", referencedColumnName = "tcont_id")
    @ManyToOne
    private TwpContact twpContid;
    @JoinColumn(name = "twpProvid", referencedColumnName = "tprov_id")
    @ManyToOne
    private TwpProveedor twpProvid;

    public TwpProvhtcont() {
    }

    public TwpProvhtcont(Integer twphc) {
        this.twphc = twphc;
    }

    public Integer getTwphc() {
        return twphc;
    }

    public void setTwphc(Integer twphc) {
        this.twphc = twphc;
    }

    public TwpContact getTwpContid() {
        return twpContid;
    }

    public void setTwpContid(TwpContact twpContid) {
        this.twpContid = twpContid;
    }

    public TwpProveedor getTwpProvid() {
        return twpProvid;
    }

    public void setTwpProvid(TwpProveedor twpProvid) {
        this.twpProvid = twpProvid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (twphc != null ? twphc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpProvhtcont)) {
            return false;
        }
        TwpProvhtcont other = (TwpProvhtcont) object;
        if ((this.twphc == null && other.twphc != null) || (this.twphc != null && !this.twphc.equals(other.twphc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpProvhtcont[ twphc=" + twphc + " ]";
    }
    
}
