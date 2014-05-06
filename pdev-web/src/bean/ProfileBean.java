package bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import Pidev.Service.Client.ClientServiceLocal;
import Pidev.Service.Currency.CurrencyServiceLocal;
import Pidev.entite.Client;



@ViewScoped
@ManagedBean
public class ProfileBean {

	
private Client client ;

private String phone;
private String address;
private String email;
private String description;
HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
private String connectedUser = (String)session.getAttribute("connectedUser");
@EJB
ClientServiceLocal clientServiceLocal;

@EJB
CurrencyServiceLocal currencyServiceLocal;

@PostConstruct
public void init(){
	
	client=clientServiceLocal.findByLogin(connectedUser);

}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String doAddContact(){
	 String navigateTo = null;
	 System.out.println("!!");
	System.out.println(client.getLogin());
	if(address !=null)
	 client.setAddress(address);
	if(phone!=null)
	 client.setTel(phone);
	if(email!=null)
	 client.setMail(email);
	 clientServiceLocal.update(client);
	return navigateTo;
}


public String doAddDescription(){
	
	String navigateTo = null;
	client.setDescreption(description);
	clientServiceLocal.update(client);
	
	return navigateTo;
	
}

public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


}
