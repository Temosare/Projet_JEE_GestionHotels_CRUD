/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.Bookings;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author temosare
 */
@Local
public interface BookingsFacadeLocal {

    void create(Bookings bookings);

    void edit(Bookings bookings);

    void remove(Bookings bookings);

    Bookings find(Object id);

    List<Bookings> findAll();

    List<Bookings> findRange(int[] range);

    int count();
    
}
