/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jpa.sessionBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jdbc.entities.Malla;
import org.jpa.sessionBean.AbstractFacade;

/**
 *
 * @author Maleja
 */
@Stateless
public class MallaFacade extends AbstractFacade<Malla> {
    @PersistenceContext(unitName = "MallaCurricularPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public MallaFacade() {
        super(Malla.class);
    }
    
}