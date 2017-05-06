/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "twp_proy", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpProy.findAll", query = "SELECT t FROM TwpProy t")
    , @NamedQuery(name = "TwpProy.findByTproyId", query = "SELECT t FROM TwpProy t WHERE t.tproyId = :tproyId")
    , @NamedQuery(name = "TwpProy.findByTproyCod", query = "SELECT t FROM TwpProy t WHERE t.tproyCod = :tproyCod")
    , @NamedQuery(name = "TwpProy.findByTproyNom", query = "SELECT t FROM TwpProy t WHERE t.tproyNom = :tproyNom")
    , @NamedQuery(name = "TwpProy.findByTproySociedad", query = "SELECT t FROM TwpProy t WHERE t.tproySociedad = :tproySociedad")
    , @NamedQuery(name = "TwpProy.findByTproyA", query = "SELECT t FROM TwpProy t WHERE t.tproyA = :tproyA")
    , @NamedQuery(name = "TwpProy.findByTproyI", query = "SELECT t FROM TwpProy t WHERE t.tproyI = :tproyI")
    , @NamedQuery(name = "TwpProy.findByTproyU", query = "SELECT t FROM TwpProy t WHERE t.tproyU = :tproyU")
    , @NamedQuery(name = "TwpProy.findByTproyEsta", query = "SELECT t FROM TwpProy t WHERE t.tproyEsta = :tproyEsta")})
public class TwpProy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tproy_id", nullable = false)
    private Integer tproyId;
    @Size(max = 8)
    @Column(name = "tproy_cod", length = 8)
    private String tproyCod;
    @Size(max = 200)
    @Column(name = "tproy_nom", length = 200)
    private String tproyNom;
    @Column(name = "tproy_sociedad")
    private Boolean tproySociedad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tproy_A", precision = 2, scale = 1)
    private BigDecimal tproyA;
    @Column(name = "tproy_I", precision = 2, scale = 1)
    private BigDecimal tproyI;
    @Column(name = "tproy_U", precision = 2, scale = 1)
    private BigDecimal tproyU;
    @Size(max = 1)
    @Column(name = "tproy_esta", length = 1)
    private String tproyEsta;
    @JoinColumn(name = "twp_anticipo_tcipo_id", referencedColumnName = "tcipo_id", nullable = false)
    @ManyToOne(optional = false)
    private TwpAnticipo twpAnticipoTcipoId;
    @JoinColumn(name = "twp_centrocost_tcentc_id", referencedColumnName = "tcentc_id", nullable = false)
    @ManyToOne(optional = false)
    private TwpCentrocost twpCentrocostTcentcId;
    @JoinColumn(name = "twp_ciudad_tciud_id", referencedColumnName = "tciud_id", nullable = false)
    @ManyToOne(optional = false)
    private TwpCiudad twpCiudadTciudId;
    @JoinColumn(name = "twp_iva_tiva_id", referencedColumnName = "tiva_id", nullable = false)
    @ManyToOne(optional = false)
    private TwpIva twpIvaTivaId;
    @JoinColumn(name = "twp_sociedad_tsoc_id", referencedColumnName = "tsoc_id", nullable = false)
    @ManyToOne(optional = false)
    private TwpSociedad twpSociedadTsocId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpProyTproyId")
    private List<TwpFactura> twpFacturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpProyTproyId")
    private List<TwpCuentacobro> twpCuentacobroList;

    public TwpProy() {
    }

    public TwpProy(Integer tproyId) {
        this.tproyId = tproyId;
    }

    public Integer getTproyId() {
        return tproyId;
    }

    public void setTproyId(Integer tproyId) {
        this.tproyId = tproyId;
    }

    public String getTproyCod() {
        return tproyCod;
    }

    public void setTproyCod(String tproyCod) {
        this.tproyCod = tproyCod;
    }

    public String getTproyNom() {
        return tproyNom;
    }

    public void setTproyNom(String tproyNom) {
        this.tproyNom = tproyNom;
    }

    public Boolean getTproySociedad() {
        return tproySociedad;
    }

    public void setTproySociedad(Boolean tproySociedad) {
        this.tproySociedad = tproySociedad;
    }

    public BigDecimal getTproyA() {
        return tproyA;
    }

    public void setTproyA(BigDecimal tproyA) {
        this.tproyA = tproyA;
    }

    public BigDecimal getTproyI() {
        return tproyI;
    }

    public void setTproyI(BigDecimal tproyI) {
        this.tproyI = tproyI;
    }

    public BigDecimal getTproyU() {
        return tproyU;
    }

    public void setTproyU(BigDecimal tproyU) {
        this.tproyU = tproyU;
    }

    public String getTproyEsta() {
        return tproyEsta;
    }

    public void setTproyEsta(String tproyEsta) {
        this.tproyEsta = tproyEsta;
    }

    public TwpAnticipo getTwpAnticipoTcipoId() {
        return twpAnticipoTcipoId;
    }

    public void setTwpAnticipoTcipoId(TwpAnticipo twpAnticipoTcipoId) {
        this.twpAnticipoTcipoId = twpAnticipoTcipoId;
    }

    public TwpCentrocost getTwpCentrocostTcentcId() {
        return twpCentrocostTcentcId;
    }

    public void setTwpCentrocostTcentcId(TwpCentrocost twpCentrocostTcentcId) {
        this.twpCentrocostTcentcId = twpCentrocostTcentcId;
    }

    public TwpCiudad getTwpCiudadTciudId() {
        return twpCiudadTciudId;
    }

    public void setTwpCiudadTciudId(TwpCiudad twpCiudadTciudId) {
        this.twpCiudadTciudId = twpCiudadTciudId;
    }

    public TwpIva getTwpIvaTivaId() {
        return twpIvaTivaId;
    }

    public void setTwpIvaTivaId(TwpIva twpIvaTivaId) {
        this.twpIvaTivaId = twpIvaTivaId;
    }

    public TwpSociedad getTwpSociedadTsocId() {
        return twpSociedadTsocId;
    }

    public void setTwpSociedadTsocId(TwpSociedad twpSociedadTsocId) {
        this.twpSociedadTsocId = twpSociedadTsocId;
    }

    @XmlTransient
    public List<TwpFactura> getTwpFacturaList() {
        return twpFacturaList;
    }

    public void setTwpFacturaList(List<TwpFactura> twpFacturaList) {
        this.twpFacturaList = twpFacturaList;
    }

    @XmlTransient
    public List<TwpCuentacobro> getTwpCuentacobroList() {
        return twpCuentacobroList;
    }

    public void setTwpCuentacobroList(List<TwpCuentacobro> twpCuentacobroList) {
        this.twpCuentacobroList = twpCuentacobroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tproyId != null ? tproyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpProy)) {
            return false;
        }
        TwpProy other = (TwpProy) object;
        if ((this.tproyId == null && other.tproyId != null) || (this.tproyId != null && !this.tproyId.equals(other.tproyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpProy[ tproyId=" + tproyId + " ]";
    }
    
}
