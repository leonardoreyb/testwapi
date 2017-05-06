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
@Table(name = "twp_cuenta", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpCuenta.findAll", query = "SELECT t FROM TwpCuenta t")
    , @NamedQuery(name = "TwpCuenta.findByTcuenId", query = "SELECT t FROM TwpCuenta t WHERE t.tcuenId = :tcuenId")
    , @NamedQuery(name = "TwpCuenta.findByTcuenNo", query = "SELECT t FROM TwpCuenta t WHERE t.tcuenNo = :tcuenNo")
    , @NamedQuery(name = "TwpCuenta.findByTcuenBco", query = "SELECT t FROM TwpCuenta t WHERE t.tcuenBco = :tcuenBco")
    , @NamedQuery(name = "TwpCuenta.findByTcuenTipo", query = "SELECT t FROM TwpCuenta t WHERE t.tcuenTipo = :tcuenTipo")})
public class TwpCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tcuen_id", nullable = false)
    private Integer tcuenId;
    @Size(max = 45)
    @Column(name = "tcuen_no", length = 45)
    private String tcuenNo;
    @Size(max = 45)
    @Column(name = "tcuen_bco", length = 45)
    private String tcuenBco;
    @Size(max = 45)
    @Column(name = "tcuen_tipo", length = 45)
    private String tcuenTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpCuentaTcuenId")
    private List<TwpProveedor> twpProveedorList;

    public TwpCuenta() {
    }

    public TwpCuenta(Integer tcuenId) {
        this.tcuenId = tcuenId;
    }

    public Integer getTcuenId() {
        return tcuenId;
    }

    public void setTcuenId(Integer tcuenId) {
        this.tcuenId = tcuenId;
    }

    public String getTcuenNo() {
        return tcuenNo;
    }

    public void setTcuenNo(String tcuenNo) {
        this.tcuenNo = tcuenNo;
    }

    public String getTcuenBco() {
        return tcuenBco;
    }

    public void setTcuenBco(String tcuenBco) {
        this.tcuenBco = tcuenBco;
    }

    public String getTcuenTipo() {
        return tcuenTipo;
    }

    public void setTcuenTipo(String tcuenTipo) {
        this.tcuenTipo = tcuenTipo;
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
        hash += (tcuenId != null ? tcuenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpCuenta)) {
            return false;
        }
        TwpCuenta other = (TwpCuenta) object;
        if ((this.tcuenId == null && other.tcuenId != null) || (this.tcuenId != null && !this.tcuenId.equals(other.tcuenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpCuenta[ tcuenId=" + tcuenId + " ]";
    }
    
}
