/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leona
 */
@Entity
@Table(name = "twp_cuentacobro", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpCuentacobro.findAll", query = "SELECT t FROM TwpCuentacobro t")
    , @NamedQuery(name = "TwpCuentacobro.findByTcuecoCod", query = "SELECT t FROM TwpCuentacobro t WHERE t.tcuecoCod = :tcuecoCod")
    , @NamedQuery(name = "TwpCuentacobro.findByTcuecoValor", query = "SELECT t FROM TwpCuentacobro t WHERE t.tcuecoValor = :tcuecoValor")
    , @NamedQuery(name = "TwpCuentacobro.findByTcuecoCorte", query = "SELECT t FROM TwpCuentacobro t WHERE t.tcuecoCorte = :tcuecoCorte")
    , @NamedQuery(name = "TwpCuentacobro.findByTcuecoFecha", query = "SELECT t FROM TwpCuentacobro t WHERE t.tcuecoFecha = :tcuecoFecha")})
public class TwpCuentacobro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tcueco_cod", nullable = false)
    private Integer tcuecoCod;
    @Size(max = 100)
    @Column(name = "tcueco_valor", length = 100)
    private String tcuecoValor;
    @Column(name = "tcueco_corte")
    private Integer tcuecoCorte;
    @Column(name = "tcueco_fecha")
    @Temporal(TemporalType.DATE)
    private Date tcuecoFecha;
    @JoinColumn(name = "twp_proy_tproy_id", referencedColumnName = "tproy_id", nullable = false)
    @ManyToOne(optional = false)
    private TwpProy twpProyTproyId;

    public TwpCuentacobro() {
    }

    public TwpCuentacobro(Integer tcuecoCod) {
        this.tcuecoCod = tcuecoCod;
    }

    public Integer getTcuecoCod() {
        return tcuecoCod;
    }

    public void setTcuecoCod(Integer tcuecoCod) {
        this.tcuecoCod = tcuecoCod;
    }

    public String getTcuecoValor() {
        return tcuecoValor;
    }

    public void setTcuecoValor(String tcuecoValor) {
        this.tcuecoValor = tcuecoValor;
    }

    public Integer getTcuecoCorte() {
        return tcuecoCorte;
    }

    public void setTcuecoCorte(Integer tcuecoCorte) {
        this.tcuecoCorte = tcuecoCorte;
    }

    public Date getTcuecoFecha() {
        return tcuecoFecha;
    }

    public void setTcuecoFecha(Date tcuecoFecha) {
        this.tcuecoFecha = tcuecoFecha;
    }

    public TwpProy getTwpProyTproyId() {
        return twpProyTproyId;
    }

    public void setTwpProyTproyId(TwpProy twpProyTproyId) {
        this.twpProyTproyId = twpProyTproyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcuecoCod != null ? tcuecoCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpCuentacobro)) {
            return false;
        }
        TwpCuentacobro other = (TwpCuentacobro) object;
        if ((this.tcuecoCod == null && other.tcuecoCod != null) || (this.tcuecoCod != null && !this.tcuecoCod.equals(other.tcuecoCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpCuentacobro[ tcuecoCod=" + tcuecoCod + " ]";
    }
    
}
