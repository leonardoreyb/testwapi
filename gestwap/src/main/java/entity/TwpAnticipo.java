/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leona
 */
@Entity
@Table(name = "twp_anticipo", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpAnticipo.findAll", query = "SELECT t FROM TwpAnticipo t")
    , @NamedQuery(name = "TwpAnticipo.findByTcipoId", query = "SELECT t FROM TwpAnticipo t WHERE t.tcipoId = :tcipoId")
    , @NamedQuery(name = "TwpAnticipo.findByTcipoFecha", query = "SELECT t FROM TwpAnticipo t WHERE t.tcipoFecha = :tcipoFecha")
    , @NamedQuery(name = "TwpAnticipo.findByTcipoValor", query = "SELECT t FROM TwpAnticipo t WHERE t.tcipoValor = :tcipoValor")
    , @NamedQuery(name = "TwpAnticipo.findByTcipoA", query = "SELECT t FROM TwpAnticipo t WHERE t.tcipoA = :tcipoA")
    , @NamedQuery(name = "TwpAnticipo.findByTcipoI", query = "SELECT t FROM TwpAnticipo t WHERE t.tcipoI = :tcipoI")
    , @NamedQuery(name = "TwpAnticipo.findByTcipoU", query = "SELECT t FROM TwpAnticipo t WHERE t.tcipoU = :tcipoU")
    , @NamedQuery(name = "TwpAnticipo.findByTcipoIVA", query = "SELECT t FROM TwpAnticipo t WHERE t.tcipoIVA = :tcipoIVA")})
public class TwpAnticipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tcipo_id", nullable = false)
    private Integer tcipoId;
    @Column(name = "tcipo_fecha")
    @Temporal(TemporalType.DATE)
    private Date tcipoFecha;
    @Size(max = 100)
    @Column(name = "tcipo_valor", length = 100)
    private String tcipoValor;
    @Column(name = "tcipo_A")
    private Boolean tcipoA;
    @Column(name = "tcipo_I")
    private Boolean tcipoI;
    @Column(name = "tcipo_U")
    private Boolean tcipoU;
    @Column(name = "tcipo_IVA")
    private Boolean tcipoIVA;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpAnticipoTcipoId")
    private List<TwpProy> twpProyList;

    public TwpAnticipo() {
    }

    public TwpAnticipo(Integer tcipoId) {
        this.tcipoId = tcipoId;
    }

    public Integer getTcipoId() {
        return tcipoId;
    }

    public void setTcipoId(Integer tcipoId) {
        this.tcipoId = tcipoId;
    }

    public Date getTcipoFecha() {
        return tcipoFecha;
    }

    public void setTcipoFecha(Date tcipoFecha) {
        this.tcipoFecha = tcipoFecha;
    }

    public String getTcipoValor() {
        return tcipoValor;
    }

    public void setTcipoValor(String tcipoValor) {
        this.tcipoValor = tcipoValor;
    }

    public Boolean getTcipoA() {
        return tcipoA;
    }

    public void setTcipoA(Boolean tcipoA) {
        this.tcipoA = tcipoA;
    }

    public Boolean getTcipoI() {
        return tcipoI;
    }

    public void setTcipoI(Boolean tcipoI) {
        this.tcipoI = tcipoI;
    }

    public Boolean getTcipoU() {
        return tcipoU;
    }

    public void setTcipoU(Boolean tcipoU) {
        this.tcipoU = tcipoU;
    }

    public Boolean getTcipoIVA() {
        return tcipoIVA;
    }

    public void setTcipoIVA(Boolean tcipoIVA) {
        this.tcipoIVA = tcipoIVA;
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
        hash += (tcipoId != null ? tcipoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpAnticipo)) {
            return false;
        }
        TwpAnticipo other = (TwpAnticipo) object;
        if ((this.tcipoId == null && other.tcipoId != null) || (this.tcipoId != null && !this.tcipoId.equals(other.tcipoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpAnticipo[ tcipoId=" + tcipoId + " ]";
    }
    
}
