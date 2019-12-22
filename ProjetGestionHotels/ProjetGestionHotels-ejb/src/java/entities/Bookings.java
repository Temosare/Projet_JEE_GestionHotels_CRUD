/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author temosare
 */
@Entity
@Table(name = "BOOKINGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookings.findAll", query = "SELECT b FROM Bookings b")
    , @NamedQuery(name = "Bookings.findByBookingId", query = "SELECT b FROM Bookings b WHERE b.bookingId = :bookingId")
    , @NamedQuery(name = "Bookings.findByHotelId", query = "SELECT b FROM Bookings b WHERE b.hotelId = :hotelId")
    , @NamedQuery(name = "Bookings.findByRoomNumber", query = "SELECT b FROM Bookings b WHERE b.roomNumber = :roomNumber")
    , @NamedQuery(name = "Bookings.findByDateFrom", query = "SELECT b FROM Bookings b WHERE b.dateFrom = :dateFrom")
    , @NamedQuery(name = "Bookings.findByDateTo", query = "SELECT b FROM Bookings b WHERE b.dateTo = :dateTo")})
public class Bookings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKING_ID")
    private Integer bookingId;
    @Column(name = "HOTEL_ID")
    private Integer hotelId;
    @Column(name = "ROOM_NUMBER")
    private Integer roomNumber;
    @Column(name = "DATE_FROM")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "DATE_TO")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @JoinColumn(name = "GUEST_NUMBER", referencedColumnName = "GUEST_NUMBER")
    @ManyToOne
    private Guests guestNumber;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bookings")
    private RoomBookings roomBookings;

    public Bookings() {
    }

    public Bookings(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Guests getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(Guests guestNumber) {
        this.guestNumber = guestNumber;
    }

    public RoomBookings getRoomBookings() {
        return roomBookings;
    }

    public void setRoomBookings(RoomBookings roomBookings) {
        this.roomBookings = roomBookings;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookings)) {
            return false;
        }
        Bookings other = (Bookings) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bookings[ bookingId=" + bookingId + " ]";
    }
    
}
