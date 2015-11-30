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
import org.jdbc.entities.Programas;

/**
 *
 * @author USUARIO
 */
@Stateless
public class ProgramasFacade {
    @PersistenceContext(unitName = "MallaCurricularPU")
    private EntityManager em;

    public void create(Programas programas) {
        em.persist(programas);
    }

    public void edit(Programas programas) {
        em.merge(programas);
    }

    public void remove(Programas programas) {
        em.remove(em.merge(programas));
    }

    public Programas find(Object id) {
        return em.find(Programas.class, id);
    }

    public List<Programas> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Programas.class));
        return em.createQuery(cq).getResultList();
    }

    public List<Programas> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Programas.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Programas> rt = cq.from(Programas.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
