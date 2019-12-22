/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.HotelChains;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author temosare
 */
@Local
public interface HotelChainsFacadeLocal {

    void create(HotelChains hotelChains);

    void edit(HotelChains hotelChains);

    void remove(HotelChains hotelChains);

    HotelChains find(Object id);

    List<HotelChains> findAll();

    List<HotelChains> findRange(int[] range);

    int count();
    
}
