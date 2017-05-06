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
@Table(name = "twp_proveedor", catalog = "twpdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwpProveedor.findAll", query = "SELECT t FROM TwpProveedor t")
    , @NamedQuery(name = "TwpProveedor.findByTprovId", query = "SELECT t FROM TwpProveedor t WHERE t.tprovId = :tprovId")
    , @NamedQuery(name = "TwpProveedor.findByTprovCod", query = "SELECT t FROM TwpProveedor t WHERE t.tprovCod = :tprovCod")
    , @NamedQuery(name = "TwpProveedor.findByTprovNom", query = "SELECT t FROM TwpProveedor t WHERE t.tprovNom = :tprovNom")
    , @NamedQuery(name = "TwpProveedor.findByTprovDir", query = "SELECT t FROM TwpProveedor t WHERE t.tprovDir = :tprovDir")
    , @NamedQuery(name = "TwpProveedor.findByTprovTel", query = "SELECT t FROM TwpProveedor t WHERE t.tprovTel = :tprovTel")
    , @NamedQuery(name = "TwpProveedor.findByTprovTipo", query = "SELECT t FROM TwpProveedor t WHERE t.tprovTipo = :tprovTipo")})
public class TwpProveedor implements Serializable {

    @JoinColumn(name = "tw_categoria_tcateg_id", referencedColumnName = "tcat_id", nullable = false)
    @ManyToOne(optional = false)
    private TwpCateg twCategoriaTcategId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tprov_id", nullable = false)
    private Integer tprovId;
    @Size(max = 45)
    @Column(name = "tprov_cod", length = 45)
    private String tprovCod;
    @Size(max = 200)
    @Column(name = "tprov_nom", length = 200)
    private String tprovNom;
    @Size(max = 45)
    @Column(name = "tprov_dir", length = 45)
    private String tprovDir;
    @Column(name = "tprov_tel")
    private Integer tprovTel;
    @Size(max = 1)
    @Column(name = "tprov_tipo", length = 1)
    private String tprovTipo;

    @JoinColumn(name = "twp_ciudad_tciud_id", referencedColumnName = "tciud_id", nullable = true)
    @ManyToOne(optional = false)
    private TwpCiudad twpCiudadTciudId;
    @JoinColumn(name = "twp_contact_tcont_id", referencedColumnName = "tcont_id", nullable = true)
    @ManyToOne(optional = false)
    private TwpContact twpContactTcontId;
    @JoinColumn(name = "twp_cuenta_tcuen_id", referencedColumnName = "tcuen_id", nullable = true)
    @ManyToOne(optional = false)
    private TwpCuenta twpCuentaTcuenId;
    @JoinColumn(name = "twp_servicio_tserv_id", referencedColumnName = "tserv_id", nullable = true)
    @ManyToOne(optional = false)
    private TwpServicio twpServicioTservId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twpProveedorTprovId")
    private List<TwpCostos> twpCostosList;

    public TwpProveedor() {
    }

    public TwpProveedor(Integer tprovId) {
        this.tprovId = tprovId;
    }

    public Integer getTprovId() {
        return tprovId;
    }

    public void setTprovId(Integer tprovId) {
        this.tprovId = tprovId;
    }

    public String getTprovCod() {
        return tprovCod;
    }

    public void setTprovCod(String tprovCod) {
        this.tprovCod = tprovCod;
    }

    public String getTprovNom() {
        return tprovNom;
    }

    public void setTprovNom(String tprovNom) {
        this.tprovNom = tprovNom;
    }

    public String getTprovDir() {
        return tprovDir;
    }

    public void setTprovDir(String tprovDir) {
        this.tprovDir = tprovDir;
    }

    public Integer getTprovTel() {
        return tprovTel;
    }

    public void setTprovTel(Integer tprovTel) {
        this.tprovTel = tprovTel;
    }

    public String getTprovTipo() {
        return tprovTipo;
    }

    public void setTprovTipo(String tprovTipo) {
        this.tprovTipo = tprovTipo;
    }

    public TwpCiudad getTwpCiudadTciudId() {
        return twpCiudadTciudId;
    }

    public void setTwpCiudadTciudId(TwpCiudad twpCiudadTciudId) {
        this.twpCiudadTciudId = twpCiudadTciudId;
    }

    public TwpContact getTwpContactTcontId() {
        return twpContactTcontId;
    }

    public void setTwpContactTcontId(TwpContact twpContactTcontId) {
        this.twpContactTcontId = twpContactTcontId;
    }

    public TwpCuenta getTwpCuentaTcuenId() {
        return twpCuentaTcuenId;
    }

    public void setTwpCuentaTcuenId(TwpCuenta twpCuentaTcuenId) {
        this.twpCuentaTcuenId = twpCuentaTcuenId;
    }

    public TwpServicio getTwpServicioTservId() {
        return twpServicioTservId;
    }

    public void setTwpServicioTservId(TwpServicio twpServicioTservId) {
        this.twpServicioTservId = twpServicioTservId;
    }

    @XmlTransient
    public List<TwpCostos> getTwpCostosList() {
        return twpCostosList;
    }

    public void setTwpCostosList(List<TwpCostos> twpCostosList) {
        this.twpCostosList = twpCostosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tprovId != null ? tprovId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwpProveedor)) {
            return false;
        }
        TwpProveedor other = (TwpProveedor) object;
        if ((this.tprovId == null && other.tprovId != null) || (this.tprovId != null && !this.tprovId.equals(other.tprovId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TwpProveedor[ tprovId=" + tprovId + " ]";
    }

    public TwpCateg getTwCategoriaTcategId() {
        return twCategoriaTcategId;
    }

    public void setTwCategoriaTcategId(TwpCateg twCategoriaTcategId) {
        this.twCategoriaTcategId = twCategoriaTcategId;
    }
    
}
