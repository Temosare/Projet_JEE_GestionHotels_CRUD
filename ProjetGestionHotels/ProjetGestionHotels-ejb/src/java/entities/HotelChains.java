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
@Table(name = "HOTEL_CHAINS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HotelChains.findAll", query = "SELECT h FROM HotelChains h")
    , @NamedQuery(name = "HotelChains.findByHotelChainId", query = "SELECT h FROM HotelChains h WHERE h.hotelChainId = :hotelChainId")
    , @NamedQuery(name = "HotelChains.findByHotelChainCode", query = "SELECT h FROM HotelChains h WHERE h.hotelChainCode = :hotelChainCode")
    , @NamedQuery(name = "HotelChains.findByHotelChainName", query = "SELECT h FROM HotelChains h WHERE h.hotelChainName = :hotelChainName")})
public class HotelChains implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOTEL_CHAIN_ID")
    private Integer hotelChainId;
    @Size(max = 10)
    @Column(name = "HOTEL_CHAIN_CODE")
    private String hotelChainCode;
    @Size(max = 50)
    @Column(name = "HOTEL_CHAIN_NAME")
    private String hotelChainName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelChainId")
    private List<Hotels> hotelsList;

    public HotelChains() {
    }

    public HotelChains(Integer hotelChainId) {
        this.hotelChainId = hotelChainId;
    }

    public Integer getHotelChainId() {
        return hotelChainId;
    }

    public void setHotelChainId(Integer hotelChainId) {
        this.hotelChainId = hotelChainId;
    }

    public String getHotelChainCode() {
        return hotelChainCode;
    }

    public void setHotelChainCode(String hotelChainCode) {
        this.hotelChainCode = hotelChainCode;
    }

    public String getHotelChainName() {
        return hotelChainName;
    }

    public void setHotelChainName(String hotelChainName) {
        this.hotelChainName = hotelChainName;
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
        hash += (hotelChainId != null ? hotelChainId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotelChains)) {
            return false;
        }
        HotelChains other = (HotelChains) object;
        if ((this.hotelChainId == null && other.hotelChainId != null) || (this.hotelChainId != null && !this.hotelChainId.equals(other.hotelChainId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HotelChains[ hotelChainId=" + hotelChainId + " ]";
    }
    
}
