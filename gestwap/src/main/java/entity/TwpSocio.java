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
@Table(name = "twp_socio", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpSocio.findAll", query = "SELECT t FROM TwpSocio t")
    , @NamedQuery(name = "TwpSocio.findByTsociId", query = "SELECT t FROM TwpSocio t WHERE t.tsociId = :tsociId")
    , @NamedQuery(name = "TwpSocio.findByTsociIdentifi", query = "SELECT t FROM TwpSocio t WHERE t.tsociIdentifi = :tsociIdentifi")
    , @NamedQuery(name = "TwpSocio.findByTsociNombre", query = "SELECT t FROM TwpSocio t WHERE t.tsociNombre = :tsociNombre")
    , @NamedQuery(name = "TwpSocio.findByTsociTelefono", query = "SELECT t FROM TwpSocio t WHERE t.tsociTelefono = :tsociTelefono")
    , @NamedQuery(name = "TwpSocio.findByTsociDirec", query = "SELECT t FROM TwpSocio t WHERE t.tsociDirec = :tsociDirec")})
public class TwpSocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tsoci_id", nullable = false)
    private Integer tsociId;
    @Size(max = 11)
    @Column(name = "tsoci_identifi", length = 11)
    private String tsociIdentifi;
    @Size(max = 450)
    @Column(name = "tsoci_nombre", length = 450)
    private String tsociNombre;
    @Size(max = 20)
    @Column(name = "tsoci_telefono", length = 20)
    private String tsociTelefono;
    @Size(max = 150)
    @Column(name = "tsoci_direc", length = 150)
    private String tsociDirec;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpSocioTsociId")
    private List<TwpSociedad> twpSociedadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpSocioTsocId")
    private List<TwpContact> twpContactList;

    public TwpSocio() {
    }

    public TwpSocio(Integer tsociId) {
        this.tsociId = tsociId;
    }

    public Integer getTsociId() {
        return tsociId;
    }

    public void setTsociId(Integer tsociId) {
        this.tsociId = tsociId;
    }

    public String getTsociIdentifi() {
        return tsociIdentifi;
    }

    public void setTsociIdentifi(String tsociIdentifi) {
        this.tsociIdentifi = tsociIdentifi;
    }

    public String getTsociNombre() {
        return tsociNombre;
    }

    public void setTsociNombre(String tsociNombre) {
        this.tsociNombre = tsociNombre;
    }

    public String getTsociTelefono() {
        return tsociTelefono;
    }

    public void setTsociTelefono(String tsociTelefono) {
        this.tsociTelefono = tsociTelefono;
    }

    public String getTsociDirec() {
        return tsociDirec;
    }

    public void setTsociDirec(String tsociDirec) {
        this.tsociDirec = tsociDirec;
    }

    @XmlTransient
    public List<TwpSociedad> getTwpSociedadList() {
        return twpSociedadList;
    }

    public void setTwpSociedadList(List<TwpSociedad> twpSociedadList) {
        this.twpSociedadList = twpSociedadList;
    }

    @XmlTransient
    public List<TwpContact> getTwpContactList() {
        return twpContactList;
    }

    public void setTwpContactList(List<TwpContact> twpContactList) {
        this.twpContactList = twpContactList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tsociId != null ? tsociId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpSocio)) {
            return false;
        }
        TwpSocio other = (TwpSocio) object;
        if ((this.tsociId == null && other.tsociId != null) || (this.tsociId != null && !this.tsociId.equals(other.tsociId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpSocio[ tsociId=" + tsociId + " ]";
    }
    
}
