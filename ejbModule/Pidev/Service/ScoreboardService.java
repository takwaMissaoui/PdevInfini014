package Pidev.Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Pidev.entite.ScoreboardPrices;

/**
 * Session Bean implementation class ScoreboardService
 */
@Stateless
@LocalBean
public class ScoreboardService implements ScoreboardServiceRemote {
	@PersistenceContext(unitName = "JPA")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ScoreboardService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(ScoreboardPrices S) {
		em.persist(S);
		
	}

	@Override
	public void update(ScoreboardPrices S) {
		em.merge(S);
		
	}

	@Override
	public ScoreboardPrices findByID(int ID) {
		return em.find(ScoreboardPrices.class,ID);
	}

	@Override
	public List<ScoreboardPrices> findAll() {
		return em.createQuery("from scoreboardprices",ScoreboardPrices.class).getResultList();
	}

	@Override
	public void delete(ScoreboardPrices S) {
		ScoreboardPrices So=findByID(S.getId());
		em.remove(So);
		
	}

}
