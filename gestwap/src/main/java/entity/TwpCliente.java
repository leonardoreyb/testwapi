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
@Table(name = "twp_cliente", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpCliente.findAll", query = "SELECT t FROM TwpCliente t")
    , @NamedQuery(name = "TwpCliente.findByTclieId", query = "SELECT t FROM TwpCliente t WHERE t.tclieId = :tclieId")
    , @NamedQuery(name = "TwpCliente.findByTclieCod", query = "SELECT t FROM TwpCliente t WHERE t.tclieCod = :tclieCod")
    , @NamedQuery(name = "TwpCliente.findByTclieNombre", query = "SELECT t FROM TwpCliente t WHERE t.tclieNombre = :tclieNombre")
    , @NamedQuery(name = "TwpCliente.findByTclieTelefono", query = "SELECT t FROM TwpCliente t WHERE t.tclieTelefono = :tclieTelefono")
    , @NamedQuery(name = "TwpCliente.findByTclieDirec", query = "SELECT t FROM TwpCliente t WHERE t.tclieDirec = :tclieDirec")
    , @NamedQuery(name = "TwpCliente.findByTcliTppersona", query = "SELECT t FROM TwpCliente t WHERE t.tcliTppersona = :tcliTppersona")})
public class TwpCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tclie_id", nullable = false)
    private Integer tclieId;
    @Size(max = 45)
    @Column(name = "tclie_cod", length = 45)
    private String tclieCod;
    @Size(max = 45)
    @Column(name = "tclie_nombre", length = 45)
    private String tclieNombre;
    @Size(max = 45)
    @Column(name = "tclie_telefono", length = 45)
    private String tclieTelefono;
    @Size(max = 45)
    @Column(name = "tclie_direc", length = 45)
    private String tclieDirec;
    @Size(max = 2)
    @Column(name = "tcli_tppersona", length = 2)
    private String tcliTppersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpClienteTclieId")
    private List<TwpFactura> twpFacturaList;
    @JoinColumn(name = "twp_contact_tcont_id", referencedColumnName = "tcont_id", nullable = false)
    @ManyToOne(optional = false)
    private TwpContact twpContactTcontId;

    public TwpCliente() {
    }

    public TwpCliente(Integer tclieId) {
        this.tclieId = tclieId;
    }

    public Integer getTclieId() {
        return tclieId;
    }

    public void setTclieId(Integer tclieId) {
        this.tclieId = tclieId;
    }

    public String getTclieCod() {
        return tclieCod;
    }

    public void setTclieCod(String tclieCod) {
        this.tclieCod = tclieCod;
    }

    public String getTclieNombre() {
        return tclieNombre;
    }

    public void setTclieNombre(String tclieNombre) {
        this.tclieNombre = tclieNombre;
    }

    public String getTclieTelefono() {
        return tclieTelefono;
    }

    public void setTclieTelefono(String tclieTelefono) {
        this.tclieTelefono = tclieTelefono;
    }

    public String getTclieDirec() {
        return tclieDirec;
    }

    public void setTclieDirec(String tclieDirec) {
        this.tclieDirec = tclieDirec;
    }

    public String getTcliTppersona() {
        return tcliTppersona;
    }

    public void setTcliTppersona(String tcliTppersona) {
        this.tcliTppersona = tcliTppersona;
    }

    @XmlTransient
    public List<TwpFactura> getTwpFacturaList() {
        return twpFacturaList;
    }

    public void setTwpFacturaList(List<TwpFactura> twpFacturaList) {
        this.twpFacturaList = twpFacturaList;
    }

    public TwpContact getTwpContactTcontId() {
        return twpContactTcontId;
    }

    public void setTwpContactTcontId(TwpContact twpContactTcontId) {
        this.twpContactTcontId = twpContactTcontId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tclieId != null ? tclieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpCliente)) {
            return false;
        }
        TwpCliente other = (TwpCliente) object;
        if ((this.tclieId == null && other.tclieId != null) || (this.tclieId != null && !this.tclieId.equals(other.tclieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpCliente[ tclieId=" + tclieId + " ]";
    }
    
}
