/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author temosare
 */
@Entity
@Table(name = "HOTEL_ROOMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HotelRooms.findAll", query = "SELECT h FROM HotelRooms h")
    , @NamedQuery(name = "HotelRooms.findByRoomNumber", query = "SELECT h FROM HotelRooms h WHERE h.hotelRoomsPK.roomNumber = :roomNumber")
    , @NamedQuery(name = "HotelRooms.findByHotelId", query = "SELECT h FROM HotelRooms h WHERE h.hotelRoomsPK.hotelId = :hotelId")
    , @NamedQuery(name = "HotelRooms.findByRoomTypeCode", query = "SELECT h FROM HotelRooms h WHERE h.roomTypeCode = :roomTypeCode")
    , @NamedQuery(name = "HotelRooms.findByRoomFloor", query = "SELECT h FROM HotelRooms h WHERE h.roomFloor = :roomFloor")
    , @NamedQuery(name = "HotelRooms.findByRoomFloorCount", query = "SELECT h FROM HotelRooms h WHERE h.roomFloorCount = :roomFloorCount")})
public class HotelRooms implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HotelRoomsPK hotelRoomsPK;
    @Size(max = 10)
    @Column(name = "ROOM_TYPE_CODE")
    private String roomTypeCode;
    @Column(name = "ROOM_FLOOR")
    private Integer roomFloor;
    @Column(name = "ROOM_FLOOR_COUNT")
    private Integer roomFloorCount;
    @JoinColumn(name = "HOTEL_ID", referencedColumnName = "HOTEL_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hotels hotels;

    public HotelRooms() {
    }

    public HotelRooms(HotelRoomsPK hotelRoomsPK) {
        this.hotelRoomsPK = hotelRoomsPK;
    }

    public HotelRooms(int roomNumber, int hotelId) {
        this.hotelRoomsPK = new HotelRoomsPK(roomNumber, hotelId);
    }

    public HotelRoomsPK getHotelRoomsPK() {
        return hotelRoomsPK;
    }

    public void setHotelRoomsPK(HotelRoomsPK hotelRoomsPK) {
        this.hotelRoomsPK = hotelRoomsPK;
    }

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public Integer getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(Integer roomFloor) {
        this.roomFloor = roomFloor;
    }

    public Integer getRoomFloorCount() {
        return roomFloorCount;
    }

    public void setRoomFloorCount(Integer roomFloorCount) {
        this.roomFloorCount = roomFloorCount;
    }

    public Hotels getHotels() {
        return hotels;
    }

    public void setHotels(Hotels hotels) {
        this.hotels = hotels;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelRoomsPK != null ? hotelRoomsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotelRooms)) {
            return false;
        }
        HotelRooms other = (HotelRooms) object;
        if ((this.hotelRoomsPK == null && other.hotelRoomsPK != null) || (this.hotelRoomsPK != null && !this.hotelRoomsPK.equals(other.hotelRoomsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HotelRooms[ hotelRoomsPK=" + hotelRoomsPK + " ]";
    }
    
}
