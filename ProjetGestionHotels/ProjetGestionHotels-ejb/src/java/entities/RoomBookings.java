/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "ROOM_BOOKINGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoomBookings.findAll", query = "SELECT r FROM RoomBookings r")
    , @NamedQuery(name = "RoomBookings.findByBookingId", query = "SELECT r FROM RoomBookings r WHERE r.bookingId = :bookingId")
    , @NamedQuery(name = "RoomBookings.findByHotelId", query = "SELECT r FROM RoomBookings r WHERE r.hotelId = :hotelId")
    , @NamedQuery(name = "RoomBookings.findByRoomNumber", query = "SELECT r FROM RoomBookings r WHERE r.roomNumber = :roomNumber")
    , @NamedQuery(name = "RoomBookings.findByDateBookingFrom", query = "SELECT r FROM RoomBookings r WHERE r.dateBookingFrom = :dateBookingFrom")
    , @NamedQuery(name = "RoomBookings.findByDateBookingTo", query = "SELECT r FROM RoomBookings r WHERE r.dateBookingTo = :dateBookingTo")
    , @NamedQuery(name = "RoomBookings.findByRoomCount", query = "SELECT r FROM RoomBookings r WHERE r.roomCount = :roomCount")})
public class RoomBookings implements Serializable {

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
    @Column(name = "DATE_BOOKING_FROM")
    @Temporal(TemporalType.DATE)
    private Date dateBookingFrom;
    @Column(name = "DATE_BOOKING_TO")
    @Temporal(TemporalType.DATE)
    private Date dateBookingTo;
    @Column(name = "ROOM_COUNT")
    private Integer roomCount;
    @JoinColumn(name = "BOOKING_ID", referencedColumnName = "BOOKING_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Bookings bookings;

    public RoomBookings() {
    }

    public RoomBookings(Integer bookingId) {
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

    public Date getDateBookingFrom() {
        return dateBookingFrom;
    }

    public void setDateBookingFrom(Date dateBookingFrom) {
        this.dateBookingFrom = dateBookingFrom;
    }

    public Date getDateBookingTo() {
        return dateBookingTo;
    }

    public void setDateBookingTo(Date dateBookingTo) {
        this.dateBookingTo = dateBookingTo;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public Bookings getBookings() {
        return bookings;
    }

    public void setBookings(Bookings bookings) {
        this.bookings = bookings;
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
        if (!(object instanceof RoomBookings)) {
            return false;
        }
        RoomBookings other = (RoomBookings) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RoomBookings[ bookingId=" + bookingId + " ]";
    }
    
}
