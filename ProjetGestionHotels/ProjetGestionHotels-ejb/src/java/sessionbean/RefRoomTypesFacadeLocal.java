/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.RefRoomTypes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author temosare
 */
@Local
public interface RefRoomTypesFacadeLocal {

    void create(RefRoomTypes refRoomTypes);

    void edit(RefRoomTypes refRoomTypes);

    void remove(RefRoomTypes refRoomTypes);

    RefRoomTypes find(Object id);

    List<RefRoomTypes> findAll();

    List<RefRoomTypes> findRange(int[] range);

    int count();
    
}
