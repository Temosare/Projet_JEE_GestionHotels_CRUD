/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.RefRoomTypes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author temosare
 */
@Stateless
public class RefRoomTypesFacade extends AbstractFacade<RefRoomTypes> implements RefRoomTypesFacadeLocal {

    @PersistenceContext(unitName = "ProjetGestionHotels-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RefRoomTypesFacade() {
        super(RefRoomTypes.class);
    }
    
}
