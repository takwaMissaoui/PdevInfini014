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
	public void add(ScoreboardPrices scoreBP) {
		em.persist(scoreBP);

	}

	@Override
	public void update(ScoreboardPrices scoreBP) {
		em.merge(scoreBP);

	}

	@Override
	public ScoreboardPrices findByID(int id) {
		return em.find(ScoreboardPrices.class, id);
	}

	@Override
	public List<ScoreboardPrices> findAll() {
		return em.createQuery("from ScoreboardPrices", ScoreboardPrices.class)
				.getResultList();
	}

	@Override
	public void delete(ScoreboardPrices scoreBP) {
		ScoreboardPrices so = findByID(scoreBP.getId());
		em.remove(so);

	}

}
