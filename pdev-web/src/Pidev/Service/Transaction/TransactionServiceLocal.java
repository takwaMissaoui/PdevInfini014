package Pidev.Service.Transaction;

import java.util.List;

import javax.ejb.Local;

import Pidev.entite.Transaction;
@Local
public interface TransactionServiceLocal {
	void add(Transaction T);
	void update(Transaction T);
	Transaction findByID(int ID);
	 List<Transaction> findAll();
	 void delete(Transaction T);
}
