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
@Table(name = "twp_contact", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpContact.findAll", query = "SELECT t FROM TwpContact t")
    , @NamedQuery(name = "TwpContact.findByTcontId", query = "SELECT t FROM TwpContact t WHERE t.tcontId = :tcontId")
    , @NamedQuery(name = "TwpContact.findByTcontNombre", query = "SELECT t FROM TwpContact t WHERE t.tcontNombre = :tcontNombre")
    , @NamedQuery(name = "TwpContact.findByTcontCargo", query = "SELECT t FROM TwpContact t WHERE t.tcontCargo = :tcontCargo")
    , @NamedQuery(name = "TwpContact.findByTcontMail", query = "SELECT t FROM TwpContact t WHERE t.tcontMail = :tcontMail")
    , @NamedQuery(name = "TwpContact.findByTcontTel", query = "SELECT t FROM TwpContact t WHERE t.tcontTel = :tcontTel")})
public class TwpContact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tcont_id", nullable = false)
    private Integer tcontId;
    @Size(max = 45)
    @Column(name = "tcont_nombre", length = 45)
    private String tcontNombre;
    @Size(max = 45)
    @Column(name = "tcont_cargo", length = 45)
    private String tcontCargo;
    @Size(max = 45)
    @Column(name = "tcont_mail", length = 45)
    private String tcontMail;
    @Size(max = 45)
    @Column(name = "tcont_tel", length = 45)
    private String tcontTel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpContactTcontId")
    private List<TwpProveedor> twpProveedorList;
    @JoinColumn(name = "twp_socio_tsoc_id", referencedColumnName = "tsoci_id", nullable = true)
    @ManyToOne(optional = false)
    private TwpSocio twpSocioTsocId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpContactTcontId")
    private List<TwpCliente> twpClienteList;

    public TwpContact() {
    }

    public TwpContact(Integer tcontId) {
        this.tcontId = tcontId;
    }

    public Integer getTcontId() {
        return tcontId;
    }

    public void setTcontId(Integer tcontId) {
        this.tcontId = tcontId;
    }

    public String getTcontNombre() {
        return tcontNombre;
    }

    public void setTcontNombre(String tcontNombre) {
        this.tcontNombre = tcontNombre;
    }

    public String getTcontCargo() {
        return tcontCargo;
    }

    public void setTcontCargo(String tcontCargo) {
        this.tcontCargo = tcontCargo;
    }

    public String getTcontMail() {
        return tcontMail;
    }

    public void setTcontMail(String tcontMail) {
        this.tcontMail = tcontMail;
    }

    public String getTcontTel() {
        return tcontTel;
    }

    public void setTcontTel(String tcontTel) {
        this.tcontTel = tcontTel;
    }

    @XmlTransient
    public List<TwpProveedor> getTwpProveedorList() {
        return twpProveedorList;
    }

    public void setTwpProveedorList(List<TwpProveedor> twpProveedorList) {
        this.twpProveedorList = twpProveedorList;
    }

    public TwpSocio getTwpSocioTsocId() {
        return twpSocioTsocId;
    }

    public void setTwpSocioTsocId(TwpSocio twpSocioTsocId) {
        this.twpSocioTsocId = twpSocioTsocId;
    }

    @XmlTransient
    public List<TwpCliente> getTwpClienteList() {
        return twpClienteList;
    }

    public void setTwpClienteList(List<TwpCliente> twpClienteList) {
        this.twpClienteList = twpClienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcontId != null ? tcontId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpContact)) {
            return false;
        }
        TwpContact other = (TwpContact) object;
        if ((this.tcontId == null && other.tcontId != null) || (this.tcontId != null && !this.tcontId.equals(other.tcontId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpContact[ tcontId=" + tcontId + " ]";
    }
    
}
