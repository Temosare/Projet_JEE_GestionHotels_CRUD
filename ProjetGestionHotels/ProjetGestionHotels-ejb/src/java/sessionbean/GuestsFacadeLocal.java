/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.Guests;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author temosare
 */
@Local
public interface GuestsFacadeLocal {

    void create(Guests guests);

    void edit(Guests guests);

    void remove(Guests guests);

    Guests find(Object id);

    List<Guests> findAll();

    List<Guests> findRange(int[] range);

    int count();
    
}
