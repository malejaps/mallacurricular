/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jpa.sessionBean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.jdbc.entities.Resoluciones;

/**
 *
 * @author USUARIO
 */
@Stateless
public class ResolucionesFacade {
    @PersistenceContext(unitName = "MallaCurricularPU")
    private EntityManager em;

    public void create(Resoluciones resoluciones) {
        em.persist(resoluciones);
    }

    public void edit(Resoluciones resoluciones) {
        em.merge(resoluciones);
    }

    public void remove(Resoluciones resoluciones) {
        em.remove(em.merge(resoluciones));
    }

    public Resoluciones find(Object id) {
        return em.find(Resoluciones.class, id);
    }

    public List<Resoluciones> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Resoluciones.class));
        return em.createQuery(cq).getResultList();
    }

    public List<Resoluciones> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Resoluciones.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Resoluciones> rt = cq.from(Resoluciones.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
