package Pidev.Service;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Pidev.entite.BanqueCentrale;
import Pidev.entite.BanqueCommercial;
import Pidev.entite.Currency;

/**
 * Session Bean implementation class BanqueCentrale
 */
@Stateless
@LocalBean
public class BanqueCentraleService implements BanqueCentraleServiceRemote {
	@PersistenceContext(unitName = "JPA")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public BanqueCentraleService() {

	}

	@Override
	public void add(BanqueCentrale B) {
		/*
		 * List<BanqueCentrale> banques = this.findAll(); if (banques.size() >
		 * 0) { System.out
		 * .println("A central bank is already enrolled, it will be deleted ." +
		 * "Click yes if you want to continue !!");
		 * 
		 * @SuppressWarnings("resource") Scanner input = new Scanner(System.in);
		 * String responce = input.nextLine(); if (responce.equals("yes")) {
		 * em.clear(); em.persist(B); } else
		 * System.out.println("Operation Canceled!!"); } else
		 */
		// em.createQuery("delete from banquecentrale").executeUpdate();
		em.persist(B);
	}

	@Override
	public void update(BanqueCentrale B) {
		em.merge(B);

	}

	@Override
	public BanqueCentrale findByID(int ID) {
		return em.find(BanqueCentrale.class, ID);
	}

	@Override
	public List<BanqueCentrale> findAll() {
		return em.createQuery("from BanqueCentrale", BanqueCentrale.class)
				.getResultList();
	}

	@Override
	public void delete(BanqueCentrale B) {
		BanqueCentrale Ba = findByID(B.getIdClient());
		em.remove(Ba);

	}

	@Override
	public void setAvailable_currency(Currency cl, boolean val) {
		cl.setIs_available(val);
		CurrencyService curSer = new CurrencyService();
		curSer.update(cl);

	}

	@Override
	public void accept_request(BanqueCommercial banqueCommerciale) {
		banqueCommerciale.setReqConfirmed(true);
		BanqueCommercialService banqueCS = new BanqueCommercialService();
		banqueCS.update(banqueCommerciale);

	}

	@Override
	public void delete_request(BanqueCommercial banqueCommerciale) {
		BanqueCommercialService banqueCS = new BanqueCommercialService();
		banqueCS.delete(banqueCommerciale);

	}

}
