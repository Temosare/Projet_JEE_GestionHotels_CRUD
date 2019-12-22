/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author temosare
 */
@Entity
@Table(name = "REF_ROOM_TYPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefRoomTypes.findAll", query = "SELECT r FROM RefRoomTypes r")
    , @NamedQuery(name = "RefRoomTypes.findByRoomTypeCode", query = "SELECT r FROM RefRoomTypes r WHERE r.roomTypeCode = :roomTypeCode")
    , @NamedQuery(name = "RefRoomTypes.findByRoomStandardRate", query = "SELECT r FROM RefRoomTypes r WHERE r.roomStandardRate = :roomStandardRate")
    , @NamedQuery(name = "RefRoomTypes.findByRoomTypeDescription", query = "SELECT r FROM RefRoomTypes r WHERE r.roomTypeDescription = :roomTypeDescription")
    , @NamedQuery(name = "RefRoomTypes.findByRoomSmokingYn", query = "SELECT r FROM RefRoomTypes r WHERE r.roomSmokingYn = :roomSmokingYn")})
public class RefRoomTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ROOM_TYPE_CODE")
    private String roomTypeCode;
    @Column(name = "ROOM_STANDARD_RATE")
    private Integer roomStandardRate;
    @Size(max = 100)
    @Column(name = "ROOM_TYPE_DESCRIPTION")
    private String roomTypeDescription;
    @Column(name = "ROOM_SMOKING_YN")
    private Character roomSmokingYn;

    public RefRoomTypes() {
    }

    public RefRoomTypes(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public Integer getRoomStandardRate() {
        return roomStandardRate;
    }

    public void setRoomStandardRate(Integer roomStandardRate) {
        this.roomStandardRate = roomStandardRate;
    }

    public String getRoomTypeDescription() {
        return roomTypeDescription;
    }

    public void setRoomTypeDescription(String roomTypeDescription) {
        this.roomTypeDescription = roomTypeDescription;
    }

    public Character getRoomSmokingYn() {
        return roomSmokingYn;
    }

    public void setRoomSmokingYn(Character roomSmokingYn) {
        this.roomSmokingYn = roomSmokingYn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomTypeCode != null ? roomTypeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefRoomTypes)) {
            return false;
        }
        RefRoomTypes other = (RefRoomTypes) object;
        if ((this.roomTypeCode == null && other.roomTypeCode != null) || (this.roomTypeCode != null && !this.roomTypeCode.equals(other.roomTypeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RefRoomTypes[ roomTypeCode=" + roomTypeCode + " ]";
    }
    
}
