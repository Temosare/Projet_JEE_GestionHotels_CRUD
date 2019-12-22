/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.HotelRooms;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author temosare
 */
@Local
public interface HotelRoomsFacadeLocal {

    void create(HotelRooms hotelRooms);

    void edit(HotelRooms hotelRooms);

    void remove(HotelRooms hotelRooms);

    HotelRooms find(Object id);

    List<HotelRooms> findAll();

    List<HotelRooms> findRange(int[] range);

    int count();
    
}
