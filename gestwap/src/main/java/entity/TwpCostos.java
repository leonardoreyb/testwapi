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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leona
 */
@Entity
@Table(name = "twp_costos", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpCostos.findAll", query = "SELECT t FROM TwpCostos t")
    , @NamedQuery(name = "TwpCostos.findByTcostId", query = "SELECT t FROM TwpCostos t WHERE t.tcostId = :tcostId")
    , @NamedQuery(name = "TwpCostos.findByTcostDetalle", query = "SELECT t FROM TwpCostos t WHERE t.tcostDetalle = :tcostDetalle")
    , @NamedQuery(name = "TwpCostos.findByTcostValor", query = "SELECT t FROM TwpCostos t WHERE t.tcostValor = :tcostValor")
    , @NamedQuery(name = "TwpCostos.findByTcostCant", query = "SELECT t FROM TwpCostos t WHERE t.tcostCant = :tcostCant")})
public class TwpCostos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tcost_id", nullable = false)
    private Integer tcostId;
    @Size(max = 200)
    @Column(name = "tcost_detalle", length = 200)
    private String tcostDetalle;
    @Size(max = 100)
    @Column(name = "tcost_valor", length = 100)
    private String tcostValor;
    @Column(name = "tcost_cant")
    private Integer tcostCant;
    @JoinColumn(name = "twp_centrocost_tcentc_id", referencedColumnName = "tcentc_id", nullable = false)
    @ManyToOne(optional = false)
    private TwpCentrocost twpCentrocostTcentcId;
    @JoinColumn(name = "twp_proveedor_tprov_id", referencedColumnName = "tprov_id", nullable = false)
    @ManyToOne(optional = false)
    private TwpProveedor twpProveedorTprovId;

    public TwpCostos() {
    }

    public TwpCostos(Integer tcostId) {
        this.tcostId = tcostId;
    }

    public Integer getTcostId() {
        return tcostId;
    }

    public void setTcostId(Integer tcostId) {
        this.tcostId = tcostId;
    }

    public String getTcostDetalle() {
        return tcostDetalle;
    }

    public void setTcostDetalle(String tcostDetalle) {
        this.tcostDetalle = tcostDetalle;
    }

    public String getTcostValor() {
        return tcostValor;
    }

    public void setTcostValor(String tcostValor) {
        this.tcostValor = tcostValor;
    }

    public Integer getTcostCant() {
        return tcostCant;
    }

    public void setTcostCant(Integer tcostCant) {
        this.tcostCant = tcostCant;
    }

    public TwpCentrocost getTwpCentrocostTcentcId() {
        return twpCentrocostTcentcId;
    }

    public void setTwpCentrocostTcentcId(TwpCentrocost twpCentrocostTcentcId) {
        this.twpCentrocostTcentcId = twpCentrocostTcentcId;
    }

    public TwpProveedor getTwpProveedorTprovId() {
        return twpProveedorTprovId;
    }

    public void setTwpProveedorTprovId(TwpProveedor twpProveedorTprovId) {
        this.twpProveedorTprovId = twpProveedorTprovId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcostId != null ? tcostId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpCostos)) {
            return false;
        }
        TwpCostos other = (TwpCostos) object;
        if ((this.tcostId == null && other.tcostId != null) || (this.tcostId != null && !this.tcostId.equals(other.tcostId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpCostos[ tcostId=" + tcostId + " ]";
    }
    
}
