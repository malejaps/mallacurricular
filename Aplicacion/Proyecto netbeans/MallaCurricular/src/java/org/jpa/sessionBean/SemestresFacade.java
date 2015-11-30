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
import org.jdbc.entities.Asignaturas;
import org.jdbc.entities.Semestres;

/**
 *
 * @author USUARIO
 */
@Stateless
public class SemestresFacade {
    @PersistenceContext(unitName = "MallaCurricularPU")
    private EntityManager em;

    public void create(Semestres semestres) {
        em.persist(semestres);
    }

    public void edit(Semestres semestres) {
        em.merge(semestres);
    }

    public void remove(Semestres semestres) {
        em.remove(em.merge(semestres));
    }

    public Semestres find(Object id) {
        return em.find(Semestres.class, id);
    }

    
     
    public List<Semestres> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Semestres.class));
        return em.createQuery(cq).getResultList();
    }

    public List<Semestres> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Semestres.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Semestres> rt = cq.from(Semestres.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
