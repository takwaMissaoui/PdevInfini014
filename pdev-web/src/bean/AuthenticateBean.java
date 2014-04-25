package bean;

import javax.ejb.EJB;
import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import Pidev.Service.Admin.AdminServiceLocal;
import Pidev.Service.Client.ClientServiceLocal;
import Pidev.Service.Trader.TraderServiceLocal;
import Pidev.entite.Admin;
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
				return "CorporateProfile";}
			
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
	
	public String logout(){
		String navigateTo=null;
		admin= new Admin();
		client = new Client();
		trader = new Trader();
		
		navigateTo="login.jsf";
		return navigateTo;}
	
//	public static Object getAuthenticateBean(final String AuthenticateBean) {
//	    FacesContext fc = FacesContext.getCurrentInstance();
//	    Object bean;
//	    
//	    try {
//	        ELContext elContext = fc.getELContext();
//	        bean = elContext.getELResolver().getValue(elContext, null, AuthenticateBean);
//	    } catch (RuntimeException e) {
//	        throw new FacesException(e.getMessage(), e);
//	    }
//
//	    if (bean == null) {
//	        throw new FacesException("Managed bean with name '" + AuthenticateBean
//	            + "' was not found. Check your faces-config.xml or @ManagedBean annotation.");
//	    }
//
//	    return bean;
//	}
	
	
	
	
	
	
}


