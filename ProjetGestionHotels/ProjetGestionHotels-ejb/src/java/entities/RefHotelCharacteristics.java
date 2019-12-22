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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "REF_HOTEL_CHARACTERISTICS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefHotelCharacteristics.findAll", query = "SELECT r FROM RefHotelCharacteristics r")
    , @NamedQuery(name = "RefHotelCharacteristics.findByCharacteristicId", query = "SELECT r FROM RefHotelCharacteristics r WHERE r.characteristicId = :characteristicId")
    , @NamedQuery(name = "RefHotelCharacteristics.findByCharacteristicCode", query = "SELECT r FROM RefHotelCharacteristics r WHERE r.characteristicCode = :characteristicCode")
    , @NamedQuery(name = "RefHotelCharacteristics.findByCharacteristicDescription", query = "SELECT r FROM RefHotelCharacteristics r WHERE r.characteristicDescription = :characteristicDescription")})
public class RefHotelCharacteristics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHARACTERISTIC_ID")
    private Integer characteristicId;
    @Size(max = 10)
    @Column(name = "CHARACTERISTIC_CODE")
    private String characteristicCode;
    @Size(max = 50)
    @Column(name = "CHARACTERISTIC_DESCRIPTION")
    private String characteristicDescription;
    @JoinTable(name = "HOTEL_CHARACTERISTICS", joinColumns = {
        @JoinColumn(name = "CHARACTERISTIC_ID", referencedColumnName = "CHARACTERISTIC_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "HOTEL_ID", referencedColumnName = "HOTEL_ID")})
    @ManyToMany
    private List<Hotels> hotelsList;

    public RefHotelCharacteristics() {
    }

    public RefHotelCharacteristics(Integer characteristicId) {
        this.characteristicId = characteristicId;
    }

    public Integer getCharacteristicId() {
        return characteristicId;
    }

    public void setCharacteristicId(Integer characteristicId) {
        this.characteristicId = characteristicId;
    }

    public String getCharacteristicCode() {
        return characteristicCode;
    }

    public void setCharacteristicCode(String characteristicCode) {
        this.characteristicCode = characteristicCode;
    }

    public String getCharacteristicDescription() {
        return characteristicDescription;
    }

    public void setCharacteristicDescription(String characteristicDescription) {
        this.characteristicDescription = characteristicDescription;
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
        hash += (characteristicId != null ? characteristicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefHotelCharacteristics)) {
            return false;
        }
        RefHotelCharacteristics other = (RefHotelCharacteristics) object;
        if ((this.characteristicId == null && other.characteristicId != null) || (this.characteristicId != null && !this.characteristicId.equals(other.characteristicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RefHotelCharacteristics[ characteristicId=" + characteristicId + " ]";
    }
    
}
