/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.TwpCuenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leona
 */
@Stateless
public class TwpCuentaFacade extends AbstractFacade<TwpCuenta> {

    @PersistenceContext(unitName = "gestwapPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TwpCuentaFacade() {
        super(TwpCuenta.class);
    }
    
}
