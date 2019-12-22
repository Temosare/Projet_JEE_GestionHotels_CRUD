/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.Bookings;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author temosare
 */
@Stateless
public class BookingsFacade extends AbstractFacade<Bookings> implements BookingsFacadeLocal {

    @PersistenceContext(unitName = "ProjetGestionHotels-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookingsFacade() {
        super(Bookings.class);
    }
    
}
