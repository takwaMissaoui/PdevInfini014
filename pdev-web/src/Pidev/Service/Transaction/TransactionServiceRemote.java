package Pidev.Service.Transaction;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.Transaction;

@Remote
public interface TransactionServiceRemote {
	void add(Transaction T);
	void update(Transaction T);
	Transaction findByID(int ID);
	 List<Transaction> findAll();
	 void delete(Transaction T);
}
