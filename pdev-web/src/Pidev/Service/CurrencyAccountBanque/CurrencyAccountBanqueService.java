package Pidev.Service.CurrencyAccountBanque;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Pidev.entite.CurrencyAccountBanque;

/**
 * Session Bean implementation class PositionService
 */
@Stateless
@LocalBean
public class CurrencyAccountBanqueService implements
		CurrencyAccountBanqueServiceRemote , CurrencyAccountBanqueServiceLocal {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public CurrencyAccountBanqueService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(CurrencyAccountBanque accountB) {
		em.persist(accountB);

	}

	@Override
	public void update(CurrencyAccountBanque accountB) {
		em.merge(accountB);

	}

	@Override
	public CurrencyAccountBanque findByID(int id) {
		return em.find(CurrencyAccountBanque.class, id);
	}

	@Override
	public List<CurrencyAccountBanque> findAll() {
		return em.createQuery("from CurrencyAccountBanque", CurrencyAccountBanque.class)
				.getResultList();
	}

	@Override
	public void delete(CurrencyAccountBanque accountB) {
		CurrencyAccountBanque cab = findByID(accountB.getIdAccountBanque());
		em.remove(cab);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findInitializedCurrency() {
		
		Query query = em.createQuery("select c.currency_id_currency from CurrencyAccountBanque c where c.initialized=:param");
		query.setParameter("param", true);
		return query.getResultList();
		
	
		
	}

}
