package Pidev.Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import Pidev.entite.Client;

/**
 * Session Bean implementation class ClientService
 */
@Stateless
@LocalBean
public class ClientService implements ClientServiceRemote {
	@PersistenceContext(unitName = "JPA")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ClientService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Client client) {
		em.persist(client);

	}

	@Override
	public void update(Client client) {
		em.merge(client);

	}

	@Override
	public Client findByID(int ID) {
		return em.find(Client.class, ID);

	}

	@Override
	public List<Client> findAll() {

		return em.createQuery("from Client", Client.class).getResultList();
	}

	@Override
	public void delete(Client client) {
		Client cl = findByID(client.getIdClient());
		em.remove(cl);

	}

}
