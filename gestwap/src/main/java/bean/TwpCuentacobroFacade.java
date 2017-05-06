/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.TwpCuentacobro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leona
 */
@Stateless
public class TwpCuentacobroFacade extends AbstractFacade<TwpCuentacobro> {

    @PersistenceContext(unitName = "gestwapPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TwpCuentacobroFacade() {
        super(TwpCuentacobro.class);
    }
    
}
