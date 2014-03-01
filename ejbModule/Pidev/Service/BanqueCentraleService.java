package Pidev.Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Pidev.entite.BanqueCentrale;

/**
 * Session Bean implementation class BanqueCentrale
 */
@Stateless
@LocalBean
public class BanqueCentraleService implements BanqueCentraleServiceRemote {
	@PersistenceContext(unitName = "JPA")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public BanqueCentraleService() {
       
    }

	@Override
	public void add(BanqueCentrale B) {
		em.persist(B);
		
	}

	@Override
	public void update(BanqueCentrale B) {
		em.merge(B);
		
	}

	@Override
	public BanqueCentrale findByID(int ID) {
		return em.find(BanqueCentrale.class,ID);
	}

	@Override
	public List<BanqueCentrale> findAll() {
		return em.createQuery("from BanqueCentrale",BanqueCentrale.class).getResultList();
	}

	@Override
	public void delete(BanqueCentrale B) {
		BanqueCentrale Ba=findByID(B.getID_Client());
		em.remove(Ba);
		
	}

}
