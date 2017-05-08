/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.ExtDocPersonLink;

/**
 * @author ekemini.s.udofiah
 *
 */
public interface ExtDocPersonLinkDAO { 
	
	
	/**
	 * Deletes checked person from external documentation person link table
	 * @param idPerson
	 * @return int
	 */
	public int deleteExtDocPersonLinkByPerson(int idPerson); 
	/**
	 * Deletes checked person from external documentation person link table
	 * @param idExtDoumentation
	 * @return list
	 */
	public List<Integer>findPersonCheckedByIdExtDocumentation(int idExtDoumentation); 
	/**
	 * Deletes checked person from external documentation person link table
	 * @param idExtDoumentation
	 * @return int
	 */
	public int deleteExtDocPersonLinkByIdExtDocumentation(int idExtDoumentation); 

	/**
	 * saves and updates names associated with a document
	 * @param extDocPersonLink
	 */
	public  void saveOrUpdateExtDocPersonLinkByPerson(ExtDocPersonLink extDocPersonLink);
	
	/**
	 * Updates forward person ID to the existing records during the case merge
	 * @param idForwardPerson
	 * @param idClosedPerson
	 * @return int
	 */
	public int updateExtDocPersonLinkForPersonMerge(int idForwardPerson, int idClosedPerson);
}
