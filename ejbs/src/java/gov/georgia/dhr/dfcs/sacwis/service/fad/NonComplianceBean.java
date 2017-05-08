/**
 * Created on Jun 5, 2008 at 12:56:56 AM by ssubram
 */
package gov.georgia.dhr.dfcs.sacwis.service.fad;

import javax.ejb.CreateException;

import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NonComplianceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonComplianceSO;

public class NonComplianceBean extends BaseSpringStatelessSessionBean implements NonCompliance {
  private RetrieveNonCompliance retrieveNonCompliance;
  private SaveNonCompliance saveNonCompliance;
  private RetrieveChildrenInHome retrieveChildrenInHome;
  private CheckDocExistsForNonCompliance checkDocExistsForNonCompliance;
  private RetrieveResourceHomeType retrieveResourceHomeType;
  
  public NonComplianceSO checkDocExistsForNonCompliance(NonComplianceSI nonComplianceSI) {
    return checkDocExistsForNonCompliance.checkDocExistsForNonCompliance(nonComplianceSI);
  }
  public NonComplianceSO retrieveChildrenInHome(NonComplianceSI nonComplianceSI) {
    return retrieveChildrenInHome.retrieveChildrenInHome(nonComplianceSI);
  }
  public String retrieveResourceHomeType(int idCase){
    return retrieveResourceHomeType.retrieveResourceHomeType(idCase);
  }
  public NonComplianceSO retrieveNonCompliance(NonComplianceSI nonComplianceSI) {
    return retrieveNonCompliance.retrieveNonCompliance(nonComplianceSI);
  }

  public NonComplianceSO saveNonCompliance(NonComplianceSI nonComplianceSI) {
    return saveNonCompliance.saveNonCompliance(nonComplianceSI);
  }
  protected void onEjbCreate() throws CreateException {
    retrieveChildrenInHome = getService(RetrieveChildrenInHome.class);
    retrieveNonCompliance = getService(RetrieveNonCompliance.class);
    retrieveResourceHomeType = getService(RetrieveResourceHomeType.class);
    saveNonCompliance = getService(SaveNonCompliance.class);
    checkDocExistsForNonCompliance = getService(CheckDocExistsForNonCompliance.class);
  }
}
