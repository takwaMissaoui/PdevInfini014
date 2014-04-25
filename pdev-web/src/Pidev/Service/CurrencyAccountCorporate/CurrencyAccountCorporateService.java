package Pidev.Service.CurrencyAccountCorporate;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Pidev.entite.CurrencyAccountCorporate;

/**
 * Session Bean implementation class CurrencyAccountService
 */
@Stateless
@LocalBean
public class CurrencyAccountCorporateService implements
		CurrencyAccountCorporateServiceRemote ,CurrencyAccountCorporateServiceLocal{
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public CurrencyAccountCorporateService() {

	}

	@Override
	public void add(CurrencyAccountCorporate accountC) {
		em.persist(accountC);

	}

	@Override
	public void update(CurrencyAccountCorporate accountC) {
		em.merge(accountC);

	}

	@Override
	public CurrencyAccountCorporate findByID(int id) {
		return em.find(CurrencyAccountCorporate.class, id);
	}

	@Override
	public List<CurrencyAccountCorporate> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from CurrencyAccountCorporate",
				CurrencyAccountCorporate.class).getResultList();
	}

	@Override
	public void delete(CurrencyAccountCorporate accountC) {
		CurrencyAccountCorporate cac = findByID(accountC
				.getIdAccountCorporate());
		em.remove(cac);

	}

}
