/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.RefHotelCharacteristics;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author temosare
 */
@Local
public interface RefHotelCharacteristicsFacadeLocal {

    void create(RefHotelCharacteristics refHotelCharacteristics);

    void edit(RefHotelCharacteristics refHotelCharacteristics);

    void remove(RefHotelCharacteristics refHotelCharacteristics);

    RefHotelCharacteristics find(Object id);

    List<RefHotelCharacteristics> findAll();

    List<RefHotelCharacteristics> findRange(int[] range);

    int count();
    
}
