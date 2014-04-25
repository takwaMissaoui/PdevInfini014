package bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;


import Pidev.Service.Currency.CurrencyServiceLocal;
import Pidev.entite.Currency;

@ManagedBean
public class test {
	
	@EJB
	static CurrencyServiceLocal currencyServiceLocal;
	public static void main(String[] args) {
		
		
	    for(Currency c :currencyServiceLocal.findall())
      	 System.out.println(c.getId_currency());

	}

}
