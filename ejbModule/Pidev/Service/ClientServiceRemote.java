package Pidev.Service;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.Client;

@Remote
public interface ClientServiceRemote {
	void add(Client client);

	void update(Client client);

	Client findByID(int ID);

	List<Client> findAll();

	void delete(Client client);

}
