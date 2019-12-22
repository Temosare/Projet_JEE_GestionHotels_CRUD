/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.RefHotelCharacteristics;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author temosare
 */
@Stateless
public class RefHotelCharacteristicsFacade extends AbstractFacade<RefHotelCharacteristics> implements RefHotelCharacteristicsFacadeLocal {

    @PersistenceContext(unitName = "ProjetGestionHotels-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RefHotelCharacteristicsFacade() {
        super(RefHotelCharacteristics.class);
    }
    
}
