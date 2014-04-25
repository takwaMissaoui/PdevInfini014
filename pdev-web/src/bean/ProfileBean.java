package bean;

import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import Pidev.Service.Client.ClientServiceLocal;
import Pidev.entite.Client;
import Pidev.entite.Trader;


@SessionScoped
@ManagedBean
public class ProfileBean {

	
private Client client ;

private String phone;
private String address;
private String email;
private String description;
HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
private String connectedUser = (String)session.getAttribute("connectedUser");

private Trader trader=new Trader();



@EJB
ClientServiceLocal clientServiceLocal;

@PostConstruct
public void init(){
	System.out.println(connectedUser);
	client=clientServiceLocal.findByLogin(connectedUser);
	
}


public Trader getTrader() {
	return trader;
}


public void setTrader(Trader trader) {
	this.trader = trader;
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

public void doAddTrader(){
	Set<Trader> set= new TreeSet<Trader>();
	set.add(trader);
	client.setTrader(set);
	
	clientServiceLocal.update(client);
	
	
}	
}
