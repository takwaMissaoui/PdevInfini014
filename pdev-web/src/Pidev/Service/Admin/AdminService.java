package Pidev.Service.Admin;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Pidev.Service.BanqueCentrale.BanqueCentraleService;
import Pidev.Service.Currency.CurrencyService;
import Pidev.entite.Admin;
import Pidev.entite.BanqueCentrale;
import Pidev.entite.Currency;

/**
 * Session Bean implementation class AdminService
 */
@Stateless
@LocalBean
public class AdminService implements AdminServiceRemote,AdminServiceLocal {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public AdminService() {
		
	}

	@Override
	public void setLocalCurrency(Currency currency) {
        currency.setIs_local_currency(true);
		CurrencyService curservice = new CurrencyService();
		curservice.update(currency);

	}

	@Override
	public void add(Admin admin) {
	
		em.persist(admin);

	}

	@Override
	public void update(Admin admin) {
		em.merge(admin);

	}

	@Override
	public void remove(Admin admin) {
		Admin ad=findByID(admin.getId());
		em.remove(ad);

	}

	@Override
	public void addCentralBank(BanqueCentrale banqueCentrale) {
		BanqueCentraleService banqueCentral = new BanqueCentraleService();
		banqueCentral.add(banqueCentrale);

	}

	@Override
	public void addCurrency(String id_currency, String name) {

		CurrencyService curservice = new CurrencyService();
		Currency currency = new Currency(id_currency, name);
		curservice.add(currency);

	}

	@Override
	public Admin findByID(int id) {
		return em.find(Admin.class, id);
	}

	@Override
	public List<Admin> findAll() {
		return em.createQuery("from Admin",Admin.class).getResultList();
	}

	

}
