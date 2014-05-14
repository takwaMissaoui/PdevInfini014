package Pidev.Service.BanqueCommercial;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Pidev.entite.AskBid;
import Pidev.entite.BanqueCommercial;
import Pidev.entite.Currency;
import Pidev.entite.Trader;

/**
 * Session Bean implementation class BanqueCommercialService
 */
@Stateless
@LocalBean
public class BanqueCommercialService implements BanqueCommercialServiceRemote,BanqueCommercialServiceLocal {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public BanqueCommercialService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(BanqueCommercial B) {
		em.persist(B);

	}

	@Override
	public void update(BanqueCommercial B) {
		em.merge(B);

	}

	@Override
	public BanqueCommercial findByID(int ID) {
		return em.find(BanqueCommercial.class, ID);
	}

	@Override
	public List<BanqueCommercial> findAll() {
		return em.createQuery("from BanqueCommercial", BanqueCommercial.class)
				.getResultList();
	}

	@Override
	public void delete(BanqueCommercial B) {
		BanqueCommercial Ba = findByID(B.getIdClient());
		em.remove(Ba);

	}

	@Override
	public void updatePrices(Currency currency, AskBid ask_bid) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<String> findALLNames(){
		
		return em.createQuery("select b.login from BanqueCommercial b ", String.class)
				.getResultList();
		
	}

	
	@Override
	public BanqueCommercial findByLogin(String login){
		BanqueCommercial found = null;
		String jpql = "select b from BanqueCommercial b where b.login=:login ";
		Query query = em.createQuery(jpql);
		query.setParameter("login", login);

		try {
			found = (BanqueCommercial) query.getSingleResult();
		} catch (Exception ex) {
		}
		return found;
		
	}
}
