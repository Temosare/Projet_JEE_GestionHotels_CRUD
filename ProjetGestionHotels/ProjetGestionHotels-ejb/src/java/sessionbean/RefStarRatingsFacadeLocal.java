/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.RefStarRatings;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author temosare
 */
@Local
public interface RefStarRatingsFacadeLocal {

    void create(RefStarRatings refStarRatings);

    void edit(RefStarRatings refStarRatings);

    void remove(RefStarRatings refStarRatings);

    RefStarRatings find(Object id);

    List<RefStarRatings> findAll();

    List<RefStarRatings> findRange(int[] range);

    int count();
    
}
