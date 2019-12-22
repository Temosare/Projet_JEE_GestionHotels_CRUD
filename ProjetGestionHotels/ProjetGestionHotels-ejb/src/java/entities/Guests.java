/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "GUESTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guests.findAll", query = "SELECT g FROM Guests g")
    , @NamedQuery(name = "Guests.findByGuestNumber", query = "SELECT g FROM Guests g WHERE g.guestNumber = :guestNumber")
    , @NamedQuery(name = "Guests.findByGuestName", query = "SELECT g FROM Guests g WHERE g.guestName = :guestName")
    , @NamedQuery(name = "Guests.findByGuestAddress", query = "SELECT g FROM Guests g WHERE g.guestAddress = :guestAddress")
    , @NamedQuery(name = "Guests.findByGuestCity", query = "SELECT g FROM Guests g WHERE g.guestCity = :guestCity")
    , @NamedQuery(name = "Guests.findByGuestPhone", query = "SELECT g FROM Guests g WHERE g.guestPhone = :guestPhone")})
public class Guests implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GUEST_NUMBER")
    private Integer guestNumber;
    @Size(max = 50)
    @Column(name = "GUEST_NAME")
    private String guestName;
    @Size(max = 100)
    @Column(name = "GUEST_ADDRESS")
    private String guestAddress;
    @Size(max = 50)
    @Column(name = "GUEST_CITY")
    private String guestCity;
    @Size(max = 12)
    @Column(name = "GUEST_PHONE")
    private String guestPhone;
    @OneToMany(mappedBy = "guestNumber")
    private List<Bookings> bookingsList;

    public Guests() {
    }

    public Guests(Integer guestNumber) {
        this.guestNumber = guestNumber;
    }

    public Integer getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(Integer guestNumber) {
        this.guestNumber = guestNumber;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestAddress() {
        return guestAddress;
    }

    public void setGuestAddress(String guestAddress) {
        this.guestAddress = guestAddress;
    }

    public String getGuestCity() {
        return guestCity;
    }

    public void setGuestCity(String guestCity) {
        this.guestCity = guestCity;
    }

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }

    @XmlTransient
    public List<Bookings> getBookingsList() {
        return bookingsList;
    }

    public void setBookingsList(List<Bookings> bookingsList) {
        this.bookingsList = bookingsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guestNumber != null ? guestNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guests)) {
            return false;
        }
        Guests other = (Guests) object;
        if ((this.guestNumber == null && other.guestNumber != null) || (this.guestNumber != null && !this.guestNumber.equals(other.guestNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Guests[ guestNumber=" + guestNumber + " ]";
    }
    
}
