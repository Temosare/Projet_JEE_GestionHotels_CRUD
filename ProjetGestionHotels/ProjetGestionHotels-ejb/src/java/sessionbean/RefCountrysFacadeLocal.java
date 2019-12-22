/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.RefCountrys;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author temosare
 */
@Local
public interface RefCountrysFacadeLocal {

    void create(RefCountrys refCountrys);

    void edit(RefCountrys refCountrys);

    void remove(RefCountrys refCountrys);

    RefCountrys find(Object id);

    List<RefCountrys> findAll();

    List<RefCountrys> findRange(int[] range);

    int count();
    
}
