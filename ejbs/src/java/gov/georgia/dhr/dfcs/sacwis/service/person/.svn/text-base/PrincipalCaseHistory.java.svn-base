package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.core.base.NoDataReturnedException;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.CaseInfoDB;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.CaseLinkDB;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.PrincipalListDB;

import java.util.List;

/**
 * This PrincipalCaseHistory Remote class contains all the remote methods to get Case List and Principal List
 * Information. Also it Saves & Updates the Case List Info on the Case Link table.
 * <pre>
 * Change History:
 * Date      User         Description
 * -------  -----------  ----------------------------------------------
 * 04/08/05  ANANDV       SIR 23522 - PrincipalCaseHistory Remote Object for PrincipalCaseHistory Page
 * </pre>
 *
 * @author Vijaya Anand
 */
public interface PrincipalCaseHistory {
  public List<CaseInfoDB> caseList(int caseID);

  public List<PrincipalListDB> selectPrincipalList(int caseID, int globalCaseID) throws NoDataReturnedException;

  public void saveCaseInfo(List<CaseLinkDB> linkDBList) throws NoDataReturnedException;

  public void updateCaseInfo(String indCaseLink, int prnUpdate, int idLinkedCase, int mainCaseID)
          throws NoDataReturnedException;
}