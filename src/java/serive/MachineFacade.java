/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serive;

import entity.Machine;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author khabb
 */
@Stateless
public class MachineFacade extends AbstractFacade<Machine> {
    @PersistenceContext(unitName = "ParcInformatiquePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MachineFacade() {
        super(Machine.class);
    }
    public List<Machine> getMachinesAttribuees(int idEmploye) {
        TypedQuery<Machine> query = em.createQuery("SELECT m FROM Machine m WHERE m.employe.id = :idEmploye", Machine.class);
        query.setParameter("idEmploye", idEmploye);
        return query.getResultList();
    }
    
}
