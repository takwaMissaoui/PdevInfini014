package Pidev.Service;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.Client;

@Remote
public interface ClientServiceRemote {
	void add(Client C);
	void update(Client C);
	 Client findByID(int ID);
	 List<Client> findAll();
	 void delete(Client C);
	

}
