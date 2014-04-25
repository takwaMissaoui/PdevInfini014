package bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import Pidev.Service.BanqueCommercial.BanqueCommercialServiceLocal;
import Pidev.Service.Corporate.CorporateServiceLocal;
import Pidev.entite.BanqueCommercial;
import Pidev.entite.Corporate;


@ManagedBean
@RequestScoped
public class RegisterBean {

private String login;
private String password;
private String confirmedpassword;
private String mail;
private String clientType;
private SelectOneRadioView selectOneRadioView;
private boolean validateRegister=false;
private boolean noValidRegister=false;
private boolean noPassMatch=false;
private boolean validateRegisterbank=false;







@EJB
BanqueCommercialServiceLocal banqueCommercialServiceLocal;

@EJB
CorporateServiceLocal corporateServiceLocal;




public boolean isValidateRegisterbank() {
	return validateRegisterbank;
}
public void setValidateRegisterbank(boolean validateRegisterbank) {
	this.validateRegisterbank = validateRegisterbank;
}
public boolean isValidateRegister() {
	return validateRegister;
}
public void setValidateRegister(boolean validateRegister) {
	this.validateRegister = validateRegister;
}
public boolean isNoValidRegister() {
	return noValidRegister;
}
public void setNoValidRegister(boolean noValidRegister) {
	this.noValidRegister = noValidRegister;
}
public boolean isNoPassMatch() {
	return noPassMatch;
}
public void setNoPassMatch(boolean noPassMatch) {
	this.noPassMatch = noPassMatch;
}
public RegisterBean() {

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
public String getConfirmedpassword() {
	return confirmedpassword;
}
public void setConfirmedpassword(String confirmedpassword) {
	this.confirmedpassword = confirmedpassword;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getClientType() {
	return clientType;
}
public void setClientType(String clientType) {
	this.clientType = clientType;
}

public SelectOneRadioView getSelectOneRadioView() {
    if(selectOneRadioView == null)
        selectOneRadioView = new SelectOneRadioView();
    return selectOneRadioView;
}

public void setSelectOneRadioView(SelectOneRadioView selectOneRadioView) {
    this.selectOneRadioView = selectOneRadioView;
}

public void onSubmit(){
	
if(selectOneRadioView.getclientType().equals("Corporate"))
{
	if(password.equals(confirmedpassword)){
Corporate corporate=new Corporate();
corporate.setLogin(login);
corporate.setPass(password);
corporate.setMail(mail);
try{
corporateServiceLocal.add(corporate);
validateRegister=true;
	
} catch(Exception e){
	
	noValidRegister=true;
}
}
	else noPassMatch=true;}
	
	
		
		
else 	if(selectOneRadioView.getclientType().equals("Commercial Bank")){
			
			if(password.equals(confirmedpassword)){
				BanqueCommercial commercialBanque=new BanqueCommercial();
				commercialBanque.setLogin(login);
				commercialBanque.setPass(password);
				commercialBanque.setMail(mail);
				try{
					banqueCommercialServiceLocal.add(commercialBanque);
					validateRegisterbank=true;
						
					} catch(Exception e){
						
						noValidRegister=true;
					}
				
					}
			else noPassMatch=true;
}	

	
	
	}

public String doCancel(){
	
	login=" ";
	password=" ";
	mail=" ";
	confirmedpassword=" ";
	selectOneRadioView.setclientType(" ");
	
	return "login.xhtml";

}
	
}

	
	

	

