package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.List;

/**
 * The SiblingSO struct is used to transport sibling records and relevant information 
 * retrieved.
 * 
 * @author Ronnie Phelps, October 7, 2008
 * 
 * <PRE>
 * 
 * Date        Updated by                Description
 * ---------   ------------              -------------------------------------
 * 
 * </PRE>
 */
public class SiblingSO implements Serializable {
	int idPerson;
	
	String childName;
	String nonAvailStatus;
	int idSiblingGroup;
	String legalActionList;
	boolean indAvailableToAdopt;
	int idChildRegEvent;
	
	public int getIdPerson(){
		return idPerson;
	}
	
	public void setIdPerson(int idPerson){
		this.idPerson = idPerson;
	}
	
	public String getLegalActionsList(){
		return legalActionList;
	}
	
	public void setLegalActionsList(String legalActionList){
		this.legalActionList = legalActionList;
	}
	
	public String getChildName(){
		return childName;
	}
	
	public void setChildName(String childName){
		this.childName = childName;
	}
	
	public String getNonAvailStatus(){
		return nonAvailStatus;
	}
	
	public void setNonAvailStatus(String nonAvailStatus){
		this.nonAvailStatus = nonAvailStatus;
	}
	
	public int getIdSiblingGroup(){
		return idSiblingGroup;
	}
	
	public void setIdSiblingGroup(int idSiblingGroup){
		this.idSiblingGroup = idSiblingGroup;
	}

	public boolean getIndAvailableToAdopt(){
		return indAvailableToAdopt;
	}
	
	public void setIndAvailableToAdopt(boolean indAvailableToAdopt){
		this.indAvailableToAdopt = indAvailableToAdopt;
	}
	
	public int getIdChildRegEvent(){
		return idChildRegEvent;
	}
	
	public void setIdChildRegEvent(int idChildRegEvent){
		this.idChildRegEvent = idChildRegEvent;
	}
		
	@Override
	public int hashCode(){
		return idPerson;
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof SiblingSO){
			SiblingSO s =(SiblingSO)o;
			return s.getIdPerson() == this.idPerson;
		}
		return false;
	}	
}