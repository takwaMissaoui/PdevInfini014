package Pidev.Service.Trader;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Pidev.entite.Trader;

/**
 * Session Bean implementation class TraderService
 */
@Stateless
@LocalBean
public class TraderService implements TraderServiceRemote, TraderServiceLocal {

	@PersistenceContext
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
		return em.find(Trader.class, id);
	}

	@Override
	public List<Trader> findAll() {
		return em.createQuery("from Trader", Trader.class).getResultList();
	}

	@Override
	public void delete(Trader trader) {
		Trader ta = findByID(trader.getIdTradeur());
		em.remove(ta);

	}

	@Override
	public Trader findByLogin(String login) {
		Trader found = null;
		String jpql = "select u from Trader u where u.login=:login ";
		Query query = em.createQuery(jpql);
		query.setParameter("login", login);

		try {
			found = (Trader) query.getSingleResult();
		} catch (Exception ex) {
		}
		return found;
	}

}
