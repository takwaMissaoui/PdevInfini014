package bean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import Pidev.entite.Currency;



public class currencyConverter implements Converter {

		public Object getAsObject(FacesContext context, UIComponent component,
				String value) {
			
			
			return null;
		}

		public String getAsString(FacesContext context, UIComponent component,
				Object value) {
			Currency currency = (Currency) value;
			return currency.toString();
		}
	
}
