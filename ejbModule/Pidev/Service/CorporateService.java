package Pidev.Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Pidev.entite.Corporate;

/**
 * Session Bean implementation class CorporateService
 */
@Stateless
@LocalBean
public class CorporateService implements CorporateServiceRemote {
	@PersistenceContext(unitName = "JPA")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public CorporateService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(Corporate C) {
		em.persist(C);	
		}

	@Override
	public void update(Corporate C) {
		em.merge(C);
		
	}

	@Override
	public Corporate findByID(int ID) {
		return em.find(Corporate.class,ID);
	}

	@Override
	public List<Corporate> findAll() {
		return em.createQuery("from Corporate",Corporate.class).getResultList();
	           
	}

	@Override
	public void delete(Corporate C) {
	Corporate Co=findByID(C.getID_Client());
	em.remove(Co);
	}

}
