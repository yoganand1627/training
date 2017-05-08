package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;

public class ExchangeChildFamilyLinkBean implements Serializable {
	private int idExchangeChildFamilyLink;	
	private int idEventHomeRegistration;
	private int idEventChildRegistration;
	private Date dtOut;
	private String indLinkCurrent;
	private String cdNonSelectionReason;
	private String cdNonAvailReason;
	private int idResource;
	private String resourceName;
	
	public int getIdExchangeChildFamilyLink(){
		return idExchangeChildFamilyLink;
	}
	
	public void setIdExchangeChildFamilyLink(int idExchangeChildFamilyLink){
		this.idExchangeChildFamilyLink = idExchangeChildFamilyLink;
	}
	
	public int getIdEventHomeRegistration(){
		return idEventHomeRegistration;
	}
	
	public void setIdEventHomeRegistration(int idEventHomeRegistration){
		this.idEventHomeRegistration = idEventHomeRegistration;
	}
	
	public int getIdEventChildRegistration(){
		return idEventChildRegistration;
	}
	
	public void setIdEventChildRegistration(int idEventChildRegistration){
		this.idEventChildRegistration = idEventChildRegistration;
	}
	
	public Date getDtOut(){
		return dtOut;
	}
	
	public void setDtOut(Date dtOut){
		this.dtOut = dtOut;
	}
	
	public String getIndLinkCurrent(){
		return indLinkCurrent;
	}
	
	public void setIndLinkCurrent(String indLinkCurrent){
		this.indLinkCurrent = indLinkCurrent;
	}
	
	public String getCdNonSelectionReason(){
		return cdNonSelectionReason;
	}
	
	public void setCdNonSelectionReason(String cdNonSelectionReason){
		this.cdNonSelectionReason = cdNonSelectionReason;
	}
	
	public String getCdNonAvailReason(){
		return cdNonAvailReason;
	}
	
	public void setCdNonAvailReason(String cdNonAvailReason){
		this.cdNonAvailReason = cdNonAvailReason;
	}
	
	public int getIdResource(){
		return idResource;
	}
	
	public void setIdResource(int idResource){
		this.idResource = idResource;
	}
		
	public String getResourceName(){
		return resourceName;
	}
	
	public void setResourceName(String resourceName){
		this.resourceName = resourceName;
	}
	
}
