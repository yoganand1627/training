package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
/**
 * The SiblingSI struct is used to transport sibling records and relevant information 
 * in order to store the data in the database.
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
public class SiblingSI implements Serializable {
	int idPerson;
	
//	String childName;
	String nonAvailStatus;
	int idSiblingGroup;
//	String legalActionList;
	boolean indAvailableToAdopt;
	
	public int getIdPerson(){
		return idPerson;
	}
	
	public void setIdPerson(int idPerson){
		this.idPerson = idPerson;
	}
	
//	public String getLegalActionsList(){
//		return legalActionList;
//	}
//	
//	public void setLegalActionsList(String legalActionList){
//		this.legalActionList = legalActionList;
//	}
	
//	public String getChildName(){
//		return childName;
//	}
//	
//	public void setChildName(String childName){
//		this.childName = childName;
//	}
//	
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
	
	
	@Override
	public int hashCode(){
		return idPerson;
	}

}
