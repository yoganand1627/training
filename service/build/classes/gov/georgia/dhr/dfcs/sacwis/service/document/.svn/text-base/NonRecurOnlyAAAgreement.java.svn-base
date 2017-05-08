package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.NONRECURONLYAAAGRMNTSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NONRECURONLYAAAGRMNTSO;

/**
 * Non-Recurring Only Adoption Assistance Agreement Service Interface 
 * <pre>
 * Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  06/06/2011  schoi     SMS #109403: MR-082 Initial Creation
 *  
 * </pre>
 *
 */

public interface NonRecurOnlyAAAgreement extends DocumentService {

  public static final String RELEVANT_AGENCY = "txtNameOfRelevantAgency";
  public static final String AGENCY_ADDRESS = "txtAgencyAddress";
  public static final String AGENCY_PHONE = "txtAgencyPhoneNumber";
  
  public static final String ADO_PARENTS_FULL_NAMES = "txtAdoptiveParentsName";
  public static final String ADO_ADDRESS = "txtAdoptiveAddress";
  public static final String ADO_PHONE_NUMBER = "txtAdoptivePhoneNumber";
  
  public static final String CHILD_NAME = "txtChildName";
  public static final String CHILD_DATE_OF_BIRTH = "txtChildDOB";  

  /**
   * The NonRecurOnlyAAAgreement method is the main entry point for the service
   * 
   * @param nonRecurOnlyAAAgrmntSI
   *          Input object which should contain the Stage ID.
   * @return NONRECURONLYAAAGRMNTSO Output object which contains pre-fill data
   */
  public NONRECURONLYAAAGRMNTSO retrieveNonRecurOnlyAAAgreement(NONRECURONLYAAAGRMNTSI nonRecurOnlyAAAgrmntSI);
}
