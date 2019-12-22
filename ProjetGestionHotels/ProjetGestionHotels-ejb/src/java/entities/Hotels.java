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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "HOTELS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotels.findAll", query = "SELECT h FROM Hotels h")
    , @NamedQuery(name = "Hotels.findByHotelId", query = "SELECT h FROM Hotels h WHERE h.hotelId = :hotelId")
    , @NamedQuery(name = "Hotels.findByHotelCode", query = "SELECT h FROM Hotels h WHERE h.hotelCode = :hotelCode")
    , @NamedQuery(name = "Hotels.findByHotelName", query = "SELECT h FROM Hotels h WHERE h.hotelName = :hotelName")
    , @NamedQuery(name = "Hotels.findByHotelUrl", query = "SELECT h FROM Hotels h WHERE h.hotelUrl = :hotelUrl")
    , @NamedQuery(name = "Hotels.findByHotelPostCode", query = "SELECT h FROM Hotels h WHERE h.hotelPostCode = :hotelPostCode")})
public class Hotels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOTEL_ID")
    private Integer hotelId;
    @Size(max = 10)
    @Column(name = "HOTEL_CODE")
    private String hotelCode;
    @Size(max = 50)
    @Column(name = "HOTEL_NAME")
    private String hotelName;
    @Size(max = 100)
    @Column(name = "HOTEL_URL")
    private String hotelUrl;
    @Size(max = 10)
    @Column(name = "HOTEL_POST_CODE")
    private String hotelPostCode;
    @ManyToMany(mappedBy = "hotelsList")
    private List<RefHotelCharacteristics> refHotelCharacteristicsList;
    @JoinTable(name = "HOTEL_STAR_RATINGS", joinColumns = {
        @JoinColumn(name = "HOTEL_ID", referencedColumnName = "HOTEL_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "STAR_RATING_ID", referencedColumnName = "STAR_RATING_ID")})
    @ManyToMany
    private List<RefStarRatings> refStarRatingsList;
    @JoinColumn(name = "HOTEL_CHAIN_ID", referencedColumnName = "HOTEL_CHAIN_ID")
    @ManyToOne(optional = false)
    private HotelChains hotelChainId;
    @JoinColumn(name = "COUNTRY_CODE", referencedColumnName = "COUNTRY_CODE")
    @ManyToOne(optional = false)
    private RefCountrys countryCode;
    @JoinColumn(name = "STAR_RATING_ID", referencedColumnName = "STAR_RATING_ID")
    @ManyToOne(optional = false)
    private RefStarRatings starRatingId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotels")
    private List<HotelRooms> hotelRoomsList;

    public Hotels() {
    }

    public Hotels(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelUrl() {
        return hotelUrl;
    }

    public void setHotelUrl(String hotelUrl) {
        this.hotelUrl = hotelUrl;
    }

    public String getHotelPostCode() {
        return hotelPostCode;
    }

    public void setHotelPostCode(String hotelPostCode) {
        this.hotelPostCode = hotelPostCode;
    }

    @XmlTransient
    public List<RefHotelCharacteristics> getRefHotelCharacteristicsList() {
        return refHotelCharacteristicsList;
    }

    public void setRefHotelCharacteristicsList(List<RefHotelCharacteristics> refHotelCharacteristicsList) {
        this.refHotelCharacteristicsList = refHotelCharacteristicsList;
    }

    @XmlTransient
    public List<RefStarRatings> getRefStarRatingsList() {
        return refStarRatingsList;
    }

    public void setRefStarRatingsList(List<RefStarRatings> refStarRatingsList) {
        this.refStarRatingsList = refStarRatingsList;
    }

    public HotelChains getHotelChainId() {
        return hotelChainId;
    }

    public void setHotelChainId(HotelChains hotelChainId) {
        this.hotelChainId = hotelChainId;
    }

    public RefCountrys getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(RefCountrys countryCode) {
        this.countryCode = countryCode;
    }

    public RefStarRatings getStarRatingId() {
        return starRatingId;
    }

    public void setStarRatingId(RefStarRatings starRatingId) {
        this.starRatingId = starRatingId;
    }

    @XmlTransient
    public List<HotelRooms> getHotelRoomsList() {
        return hotelRoomsList;
    }

    public void setHotelRoomsList(List<HotelRooms> hotelRoomsList) {
        this.hotelRoomsList = hotelRoomsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelId != null ? hotelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotels)) {
            return false;
        }
        Hotels other = (Hotels) object;
        if ((this.hotelId == null && other.hotelId != null) || (this.hotelId != null && !this.hotelId.equals(other.hotelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Hotels[ hotelId=" + hotelId + " ]";
    }
    
}
