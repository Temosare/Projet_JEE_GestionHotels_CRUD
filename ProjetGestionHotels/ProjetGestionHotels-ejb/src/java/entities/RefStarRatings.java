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
import javax.persistence.ManyToMany;
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
@Table(name = "REF_STAR_RATINGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefStarRatings.findAll", query = "SELECT r FROM RefStarRatings r")
    , @NamedQuery(name = "RefStarRatings.findByStarRatingId", query = "SELECT r FROM RefStarRatings r WHERE r.starRatingId = :starRatingId")
    , @NamedQuery(name = "RefStarRatings.findByStarRatingCode", query = "SELECT r FROM RefStarRatings r WHERE r.starRatingCode = :starRatingCode")
    , @NamedQuery(name = "RefStarRatings.findByStarRatingImage", query = "SELECT r FROM RefStarRatings r WHERE r.starRatingImage = :starRatingImage")})
public class RefStarRatings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STAR_RATING_ID")
    private Integer starRatingId;
    @Size(max = 8)
    @Column(name = "STAR_RATING_CODE")
    private String starRatingCode;
    @Size(max = 20)
    @Column(name = "STAR_RATING_IMAGE")
    private String starRatingImage;
    @ManyToMany(mappedBy = "refStarRatingsList")
    private List<Hotels> hotelsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "starRatingId")
    private List<Hotels> hotelsList1;

    public RefStarRatings() {
    }

    public RefStarRatings(Integer starRatingId) {
        this.starRatingId = starRatingId;
    }

    public Integer getStarRatingId() {
        return starRatingId;
    }

    public void setStarRatingId(Integer starRatingId) {
        this.starRatingId = starRatingId;
    }

    public String getStarRatingCode() {
        return starRatingCode;
    }

    public void setStarRatingCode(String starRatingCode) {
        this.starRatingCode = starRatingCode;
    }

    public String getStarRatingImage() {
        return starRatingImage;
    }

    public void setStarRatingImage(String starRatingImage) {
        this.starRatingImage = starRatingImage;
    }

    @XmlTransient
    public List<Hotels> getHotelsList() {
        return hotelsList;
    }

    public void setHotelsList(List<Hotels> hotelsList) {
        this.hotelsList = hotelsList;
    }

    @XmlTransient
    public List<Hotels> getHotelsList1() {
        return hotelsList1;
    }

    public void setHotelsList1(List<Hotels> hotelsList1) {
        this.hotelsList1 = hotelsList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (starRatingId != null ? starRatingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefStarRatings)) {
            return false;
        }
        RefStarRatings other = (RefStarRatings) object;
        if ((this.starRatingId == null && other.starRatingId != null) || (this.starRatingId != null && !this.starRatingId.equals(other.starRatingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RefStarRatings[ starRatingId=" + starRatingId + " ]";
    }
    
}
