/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author temosare
 */
@Entity
@Table(name = "REF_COUNTRYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefCountrys.findAll", query = "SELECT r FROM RefCountrys r")
    , @NamedQuery(name = "RefCountrys.findByCountryCode", query = "SELECT r FROM RefCountrys r WHERE r.countryCode = :countryCode")
    , @NamedQuery(name = "RefCountrys.findByCountryCurrency", query = "SELECT r FROM RefCountrys r WHERE r.countryCurrency = :countryCurrency")
    , @NamedQuery(name = "RefCountrys.findByCountryName", query = "SELECT r FROM RefCountrys r WHERE r.countryName = :countryName")})
public class RefCountrys implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "COUNTRY_CODE")
    private String countryCode;
    @Size(max = 10)
    @Column(name = "COUNTRY_CURRENCY")
    private String countryCurrency;
    @Size(max = 50)
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryCode")
    private List<Hotels> hotelsList;

    public RefCountrys() {
    }

    public RefCountrys(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCurrency() {
        return countryCurrency;
    }

    public void setCountryCurrency(String countryCurrency) {
        this.countryCurrency = countryCurrency;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @XmlTransient
    public List<Hotels> getHotelsList() {
        return hotelsList;
    }

    public void setHotelsList(List<Hotels> hotelsList) {
        this.hotelsList = hotelsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryCode != null ? countryCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefCountrys)) {
            return false;
        }
        RefCountrys other = (RefCountrys) object;
        if ((this.countryCode == null && other.countryCode != null) || (this.countryCode != null && !this.countryCode.equals(other.countryCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RefCountrys[ countryCode=" + countryCode + " ]";
    }
    
}
