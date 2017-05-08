package gov.georgia.dhr.dfcs.sacwis.structs.input;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SiblingSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingExternalLinkStruct;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 * The SiblingGroupInformationSI struct is used to transport all sibling information to a service in order
 * to save the records to the database.
 * 
 * @author Ronnie Phelps, October 7, 2008
 * 
 * <PRE>
 * 
 * Date         Updated by                Description
 * ----------   ------------              -------------------------------------
 * 09/06/2011   Hai Nguyen                STGAP00017011: MR-092 Added new Sibling external link list
 *                                        to store list of sibling who are to be placed in the same
 *                                        adoptive home as primary child but has an open ADO in a
 *                                        different case.
 * 
 * </PRE>
 */
public class SiblingGroupInformationSI implements Serializable {
	private String name = null;

	private int idCase;

	private int idAdoInfoEvent;
	
	private int numOfNewSiblingGroupsToSave;
	
	private List<SiblingSI> siblingsToSaveInExistingGroups;

	private List<SiblingSI> siblingsToSaveInNewGroups;
	
	private List<SiblingSI> allSiblingsList;

	private Map<SiblingSI, Integer> siblingMappedToExistingGroups;
	
	private Map<SiblingSI, Integer> siblingsMappedToNewGroups;
	
	private Map<Integer, Integer> initialRegisteredChildMap;
	
	private List<SiblingExternalLinkStruct> siblingExternalLinkStructList; // MR-092

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdCase() {
		return idCase;
	}

	public void setIdCase(int idCase) {
		this.idCase = idCase;
	}

	public int getIdAdoInfoEvent() {
		return idAdoInfoEvent;
	}

	public void setIdAdoInfoEvent(int idAdoInfoEvent) {
		this.idAdoInfoEvent = idAdoInfoEvent;
	}

	public void setSiblingMappedToExistingGroups(Map<SiblingSI, Integer> groupings) {
		this.siblingMappedToExistingGroups = groupings;
	}

	public Map<SiblingSI, Integer> getSiblingMappedToExistingGroups() {
		return siblingMappedToExistingGroups;
	}

	public void setSiblingsMappedToNewGroups(Map<SiblingSI, Integer> newGroupings) {
		this.siblingsMappedToNewGroups = newGroupings;
	}

	public Map<SiblingSI, Integer> getSiblingsMappedToNewGroups() {
		return siblingsMappedToNewGroups;
	}
	
	public List<SiblingSI> getSiblingsToSaveInExistingGroups(){
		return siblingsToSaveInExistingGroups;
	}

	public void setSiblingsToSaveInExistingGroups(List<SiblingSI> existingSiblingList){
		this.siblingsToSaveInExistingGroups = existingSiblingList;
	}

	public List<SiblingSI> getSiblingsToSaveInNewGroups(){
		return siblingsToSaveInNewGroups;
	}

	public void setSiblingsToSaveInNewGroups(List<SiblingSI> siblingsToSaveInNewGroups){
		this.siblingsToSaveInNewGroups = siblingsToSaveInNewGroups;
	}
	
	public int getNumOfNewSiblingGroupsToSave() {
		return numOfNewSiblingGroupsToSave;
	}

	public void setNumOfNewSiblingGroupsToSave(int numOfNewSiblingGroups) {
		this.numOfNewSiblingGroupsToSave = numOfNewSiblingGroups;
	}
	
	public void setInitialRegisteredChildMap(Map<Integer,Integer> initialRegisteredChildMap){
		this.initialRegisteredChildMap = initialRegisteredChildMap;
	}
	
	public Map<Integer,Integer> getInitialRegisteredChildMap(){
		return initialRegisteredChildMap;
	}
	
	
	public List<SiblingSI> getAllSiblingsList(){
		return allSiblingsList;
	}

	public void setAllSiblingsList(List<SiblingSI> allSiblingList){
		this.allSiblingsList = allSiblingList;
	}

	public List<SiblingExternalLinkStruct> getSiblingExternalLinkStructList() {
		return siblingExternalLinkStructList;
	}

	public void setSiblingExternalLinkStructList(List<SiblingExternalLinkStruct> siblingExternalLinkStructList) {
		this.siblingExternalLinkStructList = siblingExternalLinkStructList;
	}
	
}
