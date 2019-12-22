/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author temosare
 */
@Embeddable
public class HotelRoomsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ROOM_NUMBER")
    private int roomNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOTEL_ID")
    private int hotelId;

    public HotelRoomsPK() {
    }

    public HotelRoomsPK(int roomNumber, int hotelId) {
        this.roomNumber = roomNumber;
        this.hotelId = hotelId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) roomNumber;
        hash += (int) hotelId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotelRoomsPK)) {
            return false;
        }
        HotelRoomsPK other = (HotelRoomsPK) object;
        if (this.roomNumber != other.roomNumber) {
            return false;
        }
        if (this.hotelId != other.hotelId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HotelRoomsPK[ roomNumber=" + roomNumber + ", hotelId=" + hotelId + " ]";
    }
    
}
