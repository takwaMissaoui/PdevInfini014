package bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import Pidev.Service.Admin.AdminServiceLocal;
import Pidev.Service.Client.ClientServiceLocal;
import Pidev.Service.Trader.TraderServiceLocal;
import Pidev.entite.Admin;
import Pidev.entite.BanqueCentrale;
import Pidev.entite.BanqueCommercial;
import Pidev.entite.Client;
import Pidev.entite.Corporate;
import Pidev.entite.Trader;

@ManagedBean
@SessionScoped
public class AuthenticateBean {

	 private String login;
	 private String password;
	 private Admin admin;
	 private Client client;
	 private Trader trader;
	 private boolean corporateRendred= false;
	 private boolean bankRendred=false;
	

	private boolean failure=false;

	 @EJB
	 public AdminServiceLocal adminServiceLocal;
	 @EJB
	 public TraderServiceLocal traderServiceLocal;
	 @EJB
	 public ClientServiceLocal clientServiceLocal;

	 
	 
	public boolean isFailure() {
		return failure;
	}

	public void setFailure(boolean failure) {
		this.failure = failure;
	}

	public AuthenticateBean() {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String authenticate() {
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		

		
		System.out.println(login+" "+password);
	
		  admin = adminServiceLocal.findAll().get(0);
		
		  client = clientServiceLocal.findByLogin(login);
		
		 trader = traderServiceLocal.findByLogin(login);
		
		 if (admin != null && admin.getLogin().equals(login))
		 {
			 
			 session.setAttribute("connectedUser", admin.getLogin()); 
		 return "admin";}
		 
		
		 else if (client != null && client.getPass().equals(password))
		 {
			if (client instanceof Corporate )
			{ session.setAttribute("connectedUser", client.getLogin());
			corporateRendred=true;
				return "Profile";}
			
			if (client instanceof BanqueCommercial )
			{ session.setAttribute("connectedUser", client.getLogin());
			bankRendred=true;
				return "Profile";}
			
			if(client instanceof BanqueCentrale)
			{
				session.setAttribute("connectedUser", client.getLogin());
				
				return "centralBank";
				
			}
			
			
		 }
		
		 
		 
		 else if (trader != null && trader.getPassword().equals(password))
		
		 { 
		 
		 session.setAttribute("connectedUser" , trader.getLogin());
		 return "success";
		 }
		
		 else{ 
			 failure=true;
			 return null;}
		 return null;
	}
	
	
	
	public boolean isCorporateRendred() {
		return corporateRendred;
	}

	public void setCorporateRendred(boolean corporateRendred) {
		this.corporateRendred = corporateRendred;
	}

	public boolean isBankRendred() {
		return bankRendred;
	}

	public void setBankRendred(boolean bankRendred) {
		this.bankRendred = bankRendred;
	}

	public String logout(){
		String navigateTo=null;
		admin= new Admin();
		client = new Client();
		trader = new Trader();
		navigateTo="login.jsf";
		return navigateTo;
		}
	

	
	
	
	
	
	
}


