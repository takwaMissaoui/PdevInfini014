package Pidev.Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import Pidev.entite.Currency;

/**
 * Session Bean implementation class CurrencyService
 */
@Stateless
@LocalBean
public class CurrencyService implements CurrencyServiceRemote {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	private EntityManager em;

	public CurrencyService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Currency currency) {
		em.persist(currency);

	}

	@Override
	public void update(Currency currency) {
		
		em.merge(currency);
	}

	@Override
	public Currency findBy(String id) {

		return em.find(Currency.class,id);
	}

	@Override
	public List<Currency> findall() {

		return em.createQuery("select c from Currency c ", Currency.class)
				.getResultList();
	}

	@Override
	public void delete(Currency currency) {
		Currency cu=this.findBy(currency.getId_currency());
		em.remove(cu);

	}

	@SuppressWarnings("unchecked")
	public List<Currency> findAvailables() {

		Query query = em
				.createQuery("select c from Currency c where c.is_available=:param ");
		query.setParameter("param", true);

		return query.getResultList();

	}



}
