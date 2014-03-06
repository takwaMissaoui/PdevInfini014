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
	public void add(Trader trader) {
		em.persist(trader);
		
	}

	@Override
	public void update(Trader trader) {
		em.merge(trader);
		
	}

	@Override
	public Trader findByID(int id) {
		// TODO Auto-generated method stub
		return em.find(Trader.class,id);
	}

	@Override
	public List<Trader> findAll() {
		return em.createQuery("from Trader",Trader.class).getResultList();
	}

	@Override
	public void delete(Trader trader) {
		Trader ta=findByID(trader.getIdTradeur());
		em.remove(ta);
		
	}

}
