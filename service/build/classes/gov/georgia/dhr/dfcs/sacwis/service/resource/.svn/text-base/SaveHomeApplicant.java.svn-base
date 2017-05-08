package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HomeApplicantSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HomeApplicantSaveSO;

/**
 * @author ade.odutayo
 *
 */
public interface SaveHomeApplicant {

  static final String ADD = ServiceConstants.REQ_FUNC_CD_ADD;
  static final String MODIFY = ServiceConstants.REQ_FUNC_CD_UPDATE;
  static final String HISTORY = ServiceConstants.REQ_FUNC_CD_HISTORY;
  /** 
   *<p> The Home Applicant Info represents both the 
   *   inquiry information and orientation preservice sections of the
   *   Home Information,FA Home History and Add Home pages.
   *</p>
   *<p>
   *    The save process is based on whether the individual is saving a 
   *    resource via the AddHome.jsp or saving an old resource via
   *    the HomeInformation.jsp or FAHomeHistory.jsp. Only the inquiry
   *    information section is saved when saving a new resource via
   *    the AddHome page. On all other occassions the information from
   *    the orientation preservice section may or may not be saved because
   *    this section is visible for all but the AddHome.jsp
   *</p>
   * @param homeApplicantSaveSI
   * @return homeApplicantSaveSO
   */
  public HomeApplicantSaveSO saveHomeApplicantInfo( HomeApplicantSaveSI homeApplicantSaveSI );
}
