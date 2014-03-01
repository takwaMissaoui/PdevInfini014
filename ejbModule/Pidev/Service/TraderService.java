package Pidev.Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Pidev.entite.Trader;

/**
 * Session Bean implementation class TraderService
 */
@Stateless
@LocalBean
public class TraderService implements TraderServiceRemote {
    
	@PersistenceContext(unitName = "JPA")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public TraderService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(Trader T) {
		em.persist(T);
		
	}

	@Override
	public void update(Trader T) {
		em.merge(T);
		
	}

	@Override
	public Trader findByID(int ID) {
		// TODO Auto-generated method stub
		return em.find(Trader.class,ID);
	}

	@Override
	public List<Trader> findAll() {
		return em.createQuery("from trader",Trader.class).getResultList();
	}

	@Override
	public void delete(Trader T) {
		Trader Ta=findByID(T.getIdTradeur());
		em.remove(Ta);
		
	}

}
