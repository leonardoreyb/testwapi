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
@Table(name = "twp_sociedad", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpSociedad.findAll", query = "SELECT t FROM TwpSociedad t")
    , @NamedQuery(name = "TwpSociedad.findByTsocId", query = "SELECT t FROM TwpSociedad t WHERE t.tsocId = :tsocId")
    , @NamedQuery(name = "TwpSociedad.findByTsocCod", query = "SELECT t FROM TwpSociedad t WHERE t.tsocCod = :tsocCod")
    , @NamedQuery(name = "TwpSociedad.findByTsocNom", query = "SELECT t FROM TwpSociedad t WHERE t.tsocNom = :tsocNom")
    , @NamedQuery(name = "TwpSociedad.findByTsocNueva", query = "SELECT t FROM TwpSociedad t WHERE t.tsocNueva = :tsocNueva")
    , @NamedQuery(name = "TwpSociedad.findByTsocAdmfina", query = "SELECT t FROM TwpSociedad t WHERE t.tsocAdmfina = :tsocAdmfina")})
public class TwpSociedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tsoc_id", nullable = false)
    private Integer tsocId;
    @Size(max = 10)
    @Column(name = "tsoc_cod", length = 10)
    private String tsocCod;
    @Size(max = 250)
    @Column(name = "tsoc_nom", length = 250)
    private String tsocNom;
    @Column(name = "tsoc_nueva")
    private Boolean tsocNueva;
    @Size(max = 45)
    @Column(name = "tsoc_admfina", length = 45)
    private String tsocAdmfina;
    @JoinColumn(name = "twp_socio_tsoci_id", referencedColumnName = "tsoci_id", nullable = false)
    @ManyToOne(optional = false)
    private TwpSocio twpSocioTsociId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpSociedadTsocId")
    private List<TwpProy> twpProyList;

    public TwpSociedad() {
    }

    public TwpSociedad(Integer tsocId) {
        this.tsocId = tsocId;
    }

    public Integer getTsocId() {
        return tsocId;
    }

    public void setTsocId(Integer tsocId) {
        this.tsocId = tsocId;
    }

    public String getTsocCod() {
        return tsocCod;
    }

    public void setTsocCod(String tsocCod) {
        this.tsocCod = tsocCod;
    }

    public String getTsocNom() {
        return tsocNom;
    }

    public void setTsocNom(String tsocNom) {
        this.tsocNom = tsocNom;
    }

    public Boolean getTsocNueva() {
        return tsocNueva;
    }

    public void setTsocNueva(Boolean tsocNueva) {
        this.tsocNueva = tsocNueva;
    }

    public String getTsocAdmfina() {
        return tsocAdmfina;
    }

    public void setTsocAdmfina(String tsocAdmfina) {
        this.tsocAdmfina = tsocAdmfina;
    }

    public TwpSocio getTwpSocioTsociId() {
        return twpSocioTsociId;
    }

    public void setTwpSocioTsociId(TwpSocio twpSocioTsociId) {
        this.twpSocioTsociId = twpSocioTsociId;
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
        hash += (tsocId != null ? tsocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpSociedad)) {
            return false;
        }
        TwpSociedad other = (TwpSociedad) object;
        if ((this.tsocId == null && other.tsocId != null) || (this.tsocId != null && !this.tsocId.equals(other.tsocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpSociedad[ tsocId=" + tsocId + " ]";
    }
    
}
