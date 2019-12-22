/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.RoomBookings;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author temosare
 */
@Local
public interface RoomBookingsFacadeLocal {

    void create(RoomBookings roomBookings);

    void edit(RoomBookings roomBookings);

    void remove(RoomBookings roomBookings);

    RoomBookings find(Object id);

    List<RoomBookings> findAll();

    List<RoomBookings> findRange(int[] range);

    int count();
    
}
