package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The SiblingGroupSO struct is used to transport all information in a sibling group
 * which will be used for adoption exchange matching.
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
 * </PRE>
 */
public class SiblingGroupInformationSO implements Serializable {
	private int idCase;
		
	private List<SiblingSO> allSiblingsRetrievedSOList;
	
	private List<SiblingPlacementGroupSO> siblingPlacementGroups;
	
	private Map<SiblingSO,SiblingPlacementGroupSO> groupings;
	
	private Map<Integer,Integer> registeredChildMap;
	
	private int numOfNewSiblingGroups;
	
	private Map<SiblingSO,SiblingPlacementGroupSO> newGroupGroupings;
	
	private int totalAvailableForAdoption;
	
	private List<SiblingExternalLinkStruct> siblingExternalLinkStructList; // MR-092

	public void setSiblingPlacementGroups(List<SiblingPlacementGroupSO> siblingPlacementGroups ) {
		this.siblingPlacementGroups = siblingPlacementGroups;
	}
	
	public List<SiblingPlacementGroupSO> getSiblingPlacementGroups(){
		return siblingPlacementGroups;
	}

	public List<SiblingSO>  getAllSiblingsRetrievedSOList() {
		return allSiblingsRetrievedSOList;
	}

	public void setSiblingRetrieveSOList(List<SiblingSO> siblingRetrieveSOList ) {
		this.allSiblingsRetrievedSOList = siblingRetrieveSOList;
	}
	
	public int getIdCase() {
		return idCase;
	}

	public void setIdCase(int idCase) {
		this.idCase = idCase;
	}
	
	public void setGroupings(Map<SiblingSO,SiblingPlacementGroupSO> groupings){
		this.groupings = groupings;
	}
	
	public Map<SiblingSO,SiblingPlacementGroupSO> getGroupings(){
		return groupings;
	}

	public void setRegisteredChildMap(Map<Integer,Integer> registeredChildMap){
		this.registeredChildMap = registeredChildMap;
	}
	
	public Map<Integer,Integer> getRegisteredChildMap(){
		return registeredChildMap;
	}
	
	public void setTotalAvailableForAdoption(int totalAvailableForAdoption){
		this.totalAvailableForAdoption = totalAvailableForAdoption;
	}
	
	public int getTotalAvailableForAdoption(){
		return totalAvailableForAdoption;
	}
		
	public Map<SiblingSO,SiblingPlacementGroupSO> getNewGroupGroupings(){
		return newGroupGroupings;
	}	
	
	public void setNewGroupGroupings(Map<SiblingSO,SiblingPlacementGroupSO> newGroupGroupings){
		this.newGroupGroupings = newGroupGroupings;
	}
	
	public int getNumOfNewSiblingGroups() {
		return numOfNewSiblingGroups;
	}

	public void setNumOfNewSiblingGroups(int numOfNewSiblingGroups) {
		this.numOfNewSiblingGroups = numOfNewSiblingGroups;
	}

	public List<SiblingExternalLinkStruct> getSiblingExternalLinkStructList() {
		return siblingExternalLinkStructList;
	}

	public void setSiblingExternalLinkStructList(List<SiblingExternalLinkStruct> siblingExternalLinkStructList) {
		this.siblingExternalLinkStructList = siblingExternalLinkStructList;
	}
	
	
}
