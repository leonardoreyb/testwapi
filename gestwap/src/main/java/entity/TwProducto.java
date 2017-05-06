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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tw_producto", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwProducto.findAll", query = "SELECT t FROM TwProducto t")
    , @NamedQuery(name = "TwProducto.findByTprodId", query = "SELECT t FROM TwProducto t WHERE t.tprodId = :tprodId")
    , @NamedQuery(name = "TwProducto.findByTprodCod", query = "SELECT t FROM TwProducto t WHERE t.tprodCod = :tprodCod")
    , @NamedQuery(name = "TwProducto.findByTprodDetalle", query = "SELECT t FROM TwProducto t WHERE t.tprodDetalle = :tprodDetalle")})
public class TwProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tprod_id", nullable = false)
    private Integer tprodId;
    @Size(max = 45)
    @Column(name = "tprod_cod", length = 45)
    private String tprodCod;
    @Size(max = 200)
    @Column(name = "tprod_detalle", length = 200)
    private String tprodDetalle;
    @JoinColumn(name = "twp_categ_tcat_id", referencedColumnName = "tcat_id", nullable = false)
    @ManyToOne(optional = false)
    private TwpCateg twpCategTcatId;

    public TwProducto() {
    }

    public TwProducto(Integer tprodId) {
        this.tprodId = tprodId;
    }

    public Integer getTprodId() {
        return tprodId;
    }

    public void setTprodId(Integer tprodId) {
        this.tprodId = tprodId;
    }

    public String getTprodCod() {
        return tprodCod;
    }

    public void setTprodCod(String tprodCod) {
        this.tprodCod = tprodCod;
    }

    public String getTprodDetalle() {
        return tprodDetalle;
    }

    public void setTprodDetalle(String tprodDetalle) {
        this.tprodDetalle = tprodDetalle;
    }

    public TwpCateg getTwpCategTcatId() {
        return twpCategTcatId;
    }

    public void setTwpCategTcatId(TwpCateg twpCategTcatId) {
        this.twpCategTcatId = twpCategTcatId;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tprodId != null ? tprodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwProducto)) {
            return false;
        }
        TwProducto other = (TwProducto) object;
        if ((this.tprodId == null && other.tprodId != null) || (this.tprodId != null && !this.tprodId.equals(other.tprodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwProducto[ tprodId=" + tprodId + " ]";
    }
    
}
