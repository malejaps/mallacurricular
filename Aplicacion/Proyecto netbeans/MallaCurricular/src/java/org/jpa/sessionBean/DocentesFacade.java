/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jpa.sessionBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jdbc.entities.Docentes;

/**
 *
 * @author Maleja
 */
@Stateless
public class DocentesFacade extends AbstractFacade<Docentes> {
    @PersistenceContext(unitName = "MallaCurricularPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public DocentesFacade() {
        super(Docentes.class);
    }
    
}
