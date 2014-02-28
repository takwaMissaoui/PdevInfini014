package entitiesClient;
import java.util.Currency;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Pdev.Service.CurrencyServiceRemote;

public class boot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		String[] localestemp = Locale.getISOCountries(); // contient les iso de
															// tout les pays

//		Vector<String> locales = new Vector<String>();

//		for (int i = 0; i < localestemp.length; i++) {

//			if (!localestemp[i].equals("AQ"))

//				locales.add(localestemp[i]); // contient les iso de tout les
												// pays qui ont une monnaie ou
												// devise
		//}

	/*	for (String countryCode : locales) {

			Locale obj = new Locale("", countryCode);

			Currency cur = Currency.getInstance(obj);

			System.out.println(
				", Country Name = " + obj.getDisplayCountry()
				+ ",Currency symbole ="+ cur.getSymbol()
				+ " ,currency =" + cur + "  ,currency full name= "
				+ cur.getDisplayName());

			

		}*/
	

	
	InitialContext context ;
	
	try{
		context= new InitialContext();
		CurrencyServiceRemote csr = (CurrencyServiceRemote) context
				.lookup("Pdev0/CurrencyService!Pdev.Service.CurrencyServiceRemote");
		
	/*	for(String s : locales){
			
		Pdev.entity.Currency c = new Pdev.entity.Currency();
		Locale obj = new Locale("", s);*/

	//	Currency cur = Currency.getInstance(obj);
	//	c.setCountry( obj.getDisplayCountry());
		Pdev.entity.Currency c = new Pdev.entity.Currency();
		for (Currency cur : Currency.getAvailableCurrencies())
		{	
		c.setId_currency(cur.getSymbol());
		c.setName(cur.getDisplayName());
		csr.add(c);
		
		}
		
		
	}
	catch(NamingException e){
		e.printStackTrace();
	}
		
	}
	
}
