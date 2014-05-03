package Pidev.Service.Currency;

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
public class CurrencyService implements CurrencyServiceRemote , CurrencyServiceLocal {

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

		return em.createQuery("from Currency", Currency.class)
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

	@Override
	public void setLocal(Currency currency) {
		
		Query query = em
				.createQuery("update  Currency c SET c.is_local_currency=:param ");
		query.setParameter("param", false);
		query.executeUpdate ();
		currency.setIs_local_currency(true);
		em.merge(currency);
		
	}

	@Override
	public List<String> findallIds() {
		return em.createQuery("select c.id_currency from Currency c", String.class)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findallAvailableIds() {
		

		Query query= em.createQuery("select c.id_currency from Currency c where c.is_available=:param");
		query.setParameter("param", true);
		return query.getResultList();
	}



}
