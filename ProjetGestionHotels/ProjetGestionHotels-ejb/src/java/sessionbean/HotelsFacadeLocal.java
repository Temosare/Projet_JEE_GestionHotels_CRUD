/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.Hotels;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author temosare
 */
@Local
public interface HotelsFacadeLocal {

    void create(Hotels hotels);

    void edit(Hotels hotels);

    void remove(Hotels hotels);

    Hotels find(Object id);

    List<Hotels> findAll();

    List<Hotels> findRange(int[] range);

    int count();
    
}
