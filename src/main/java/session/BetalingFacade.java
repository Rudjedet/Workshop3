/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Betaling;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sonja
 */
@Stateless
public class BetalingFacade extends AbstractFacade<Betaling> {

    @PersistenceContext(unitName = "com.mycompany_DeMummiefabriek_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BetalingFacade() {
        super(Betaling.class);
    }
    
}
