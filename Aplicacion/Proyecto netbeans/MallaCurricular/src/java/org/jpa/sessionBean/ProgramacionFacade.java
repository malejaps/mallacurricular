/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jpa.sessionBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jdbc.entities.Programacion;

/**
 *
 * @author Maleja
 */
@Stateless
public class ProgramacionFacade extends AbstractFacade<Programacion> {
    @PersistenceContext(unitName = "MallaCurricularPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramacionFacade() {
        super(Programacion.class);
    }
    
}
