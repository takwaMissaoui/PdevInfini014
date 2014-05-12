package bean;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import Pidev.Service.Client.ClientServiceLocal;
import Pidev.Service.Currency.CurrencyServiceLocal;
import Pidev.Service.CurrencyAccountCorporate.CurrencyAccountCorporateServiceLocal;
import Pidev.entite.Client;
import Pidev.entite.Corporate;
import Pidev.entite.Currency;
import Pidev.entite.CurrencyAccountCorporate;


@ViewScoped
@ManagedBean
public class CorporateAccountBean {

	private Client client;
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
			.getExternalContext().getSession(true);
	private String connectedUser = (String) session
			.getAttribute("connectedUser");
	private CurrencyAccountCorporate cAR = new CurrencyAccountCorporate();
	private int selectedCOaccount;
	private List<String> availableIds;
	private Set<CurrencyAccountCorporate> cARset;
	private String AccountCurrencyId;
	private boolean formDisplay=false;
	@EJB
	ClientServiceLocal clientServiceLocal;

	@EJB
	CurrencyServiceLocal currencyServiceLocal;

	@EJB
	CurrencyAccountCorporateServiceLocal currencyAccountCorporateServiceLocal;
	@PostConstruct
	public void init() {
		
		client = clientServiceLocal.findByLogin(connectedUser);
		
		if (client instanceof Corporate)
			{
			
			cARset = ((Corporate) client).getAccount();
			
			}
			
		setAvailableIds(currencyServiceLocal.findallAvailableIds());
	}
	
	public Set<CurrencyAccountCorporate> getcARset() {
		return cARset;
	}

	public void setcARset(Set<CurrencyAccountCorporate> cARset) {
		this.cARset = cARset;
	}

	public CurrencyAccountCorporate getcAR() {
		return cAR;
	}

	public void setcAR(CurrencyAccountCorporate cAR) {
		this.cAR = cAR;
	}
	public int getSelectedCOaccount() {
		return selectedCOaccount;
	}

	public void setSelectedCOaccount(int selectedCOaccount) {
		this.selectedCOaccount = selectedCOaccount;

	}
	

		
		public String getAccountCurrencyId() {
			return AccountCurrencyId;
		}

		public void setAccountCurrencyId(String accountCurrencyId) {
			AccountCurrencyId = accountCurrencyId;
		}

		public List<String> getAvailableIds() {
			return availableIds;
		}

		public void setAvailableIds(List<String> availableIds) {
			this.availableIds = availableIds;
		}
		
		
		public boolean isFormDisplay() {
			return formDisplay;
		}

		public void setFormDisplay(boolean formDisplay) {
			this.formDisplay = formDisplay;
		}

		public void doAddAccount() {

			
			if (client instanceof Corporate) {

				Currency cur = currencyServiceLocal.findBy(AccountCurrencyId);
				cAR.setCurrency(cur);

				cARset.add(cAR);
				((Corporate) client).setAccount(cARset);
				clientServiceLocal.update(client);
				client = clientServiceLocal.findByLogin(connectedUser);
				cARset = ((Corporate) client).getAccount();

			}

		}
		

		public void doDeleteCOAccount() {
System.out.println(selectedCOaccount);
	

			if(selectedCOaccount!=0)

			{
				
				CurrencyAccountCorporate cA = currencyAccountCorporateServiceLocal
						.findByID(selectedCOaccount);
				
				

				cARset.remove(cA);
				((Corporate) client).setAccount(cARset);
				clientServiceLocal.update(client);
				client = clientServiceLocal.findByLogin(connectedUser);
				cARset = ((Corporate) client).getAccount();

			}}
	
	
}
