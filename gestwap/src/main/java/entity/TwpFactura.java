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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leona
 */
@Entity
@Table(name = "twp_factura", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpFactura.findAll", query = "SELECT t FROM TwpFactura t")
    , @NamedQuery(name = "TwpFactura.findByTfactId", query = "SELECT t FROM TwpFactura t WHERE t.tfactId = :tfactId")
    , @NamedQuery(name = "TwpFactura.findByTfactCod", query = "SELECT t FROM TwpFactura t WHERE t.tfactCod = :tfactCod")
    , @NamedQuery(name = "TwpFactura.findByTfactFech", query = "SELECT t FROM TwpFactura t WHERE t.tfactFech = :tfactFech")
    , @NamedQuery(name = "TwpFactura.findByTfactSubt", query = "SELECT t FROM TwpFactura t WHERE t.tfactSubt = :tfactSubt")
    , @NamedQuery(name = "TwpFactura.findByTfactTot", query = "SELECT t FROM TwpFactura t WHERE t.tfactTot = :tfactTot")})
public class TwpFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tfact_id", nullable = false)
    private Integer tfactId;
    @Size(max = 45)
    @Column(name = "tfact_cod", length = 45)
    private String tfactCod;
    @Size(max = 45)
    @Column(name = "tfact_fech", length = 45)
    private String tfactFech;
    @Size(max = 100)
    @Column(name = "tfact_subt", length = 100)
    private String tfactSubt;
    @Size(max = 100)
    @Column(name = "tfact_tot", length = 100)
    private String tfactTot;
    @JoinColumn(name = "twp_cliente_tclie_id", referencedColumnName = "tclie_id", nullable = false)
    @ManyToOne(optional = false)
    private TwpCliente twpClienteTclieId;
    @JoinColumn(name = "twp_proy_tproy_id", referencedColumnName = "tproy_id", nullable = false)
    @ManyToOne(optional = false)
    private TwpProy twpProyTproyId;

    public TwpFactura() {
    }

    public TwpFactura(Integer tfactId) {
        this.tfactId = tfactId;
    }

    public Integer getTfactId() {
        return tfactId;
    }

    public void setTfactId(Integer tfactId) {
        this.tfactId = tfactId;
    }

    public String getTfactCod() {
        return tfactCod;
    }

    public void setTfactCod(String tfactCod) {
        this.tfactCod = tfactCod;
    }

    public String getTfactFech() {
        return tfactFech;
    }

    public void setTfactFech(String tfactFech) {
        this.tfactFech = tfactFech;
    }

    public String getTfactSubt() {
        return tfactSubt;
    }

    public void setTfactSubt(String tfactSubt) {
        this.tfactSubt = tfactSubt;
    }

    public String getTfactTot() {
        return tfactTot;
    }

    public void setTfactTot(String tfactTot) {
        this.tfactTot = tfactTot;
    }

    public TwpCliente getTwpClienteTclieId() {
        return twpClienteTclieId;
    }

    public void setTwpClienteTclieId(TwpCliente twpClienteTclieId) {
        this.twpClienteTclieId = twpClienteTclieId;
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
        hash += (tfactId != null ? tfactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpFactura)) {
            return false;
        }
        TwpFactura other = (TwpFactura) object;
        if ((this.tfactId == null && other.tfactId != null) || (this.tfactId != null && !this.tfactId.equals(other.tfactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpFactura[ tfactId=" + tfactId + " ]";
    }
    
}
