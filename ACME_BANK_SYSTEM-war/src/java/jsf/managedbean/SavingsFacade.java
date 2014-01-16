/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jsf.managedbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.entities.Savings;

/**
 *
 * @author WEIQIANG LIANG
 */
@Stateless
public class SavingsFacade extends AbstractFacade<Savings> {
    @PersistenceContext(unitName = "ACME_BANK_SYSTEM-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SavingsFacade() {
        super(Savings.class);
    }
    
}
