package Pidev.Service.Client;

import java.util.List;

import javax.ejb.Local;

import Pidev.entite.Client;
@Local
public interface ClientServiceLocal {
	void add(Client client);

	void update(Client client);

	Client findByID(int ID);
	
	Client findByLogin(String login);

	List<Client> findAll();

	void delete(Client client);

}
