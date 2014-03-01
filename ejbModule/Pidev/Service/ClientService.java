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
	public void add(Client C) {
	em.persist(C);

	}

	@Override
	public void update(Client C) {
		em.merge(C);

	}

	@Override
	
	public Client findByID(int ID) {
		return em.find(Client.class, ID);

	}

	@Override
	public List<Client> findAll() {
		
		return em.createQuery("from Client",Client.class).getResultList();
	}

	@Override
	public void delete(Client C) {
		Client Cl=findByID(C.getID_Client());
		em.remove(Cl);
		

	}

}
