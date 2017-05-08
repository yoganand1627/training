/**
 * Created on Jun 28, 2006 at 12:56:56 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.courtprocess;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB38SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB45SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB46SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AfcarsLegStatHistSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB38SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB45SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB46SO;

import javax.ejb.CreateException;

import org.springframework.beans.factory.BeanFactory;

public class CourtProcessBean extends BaseSpringStatelessSessionBean implements CourtProcess {
  private RetrieveAfcarsLegalStatus retrieveAfcarsLegalStatus;
  private RetrieveLegalAction retrieveLegalAction;
  private RetrieveLegalService retrieveLegalService;
  private SaveLegalAction saveLegalAction;
  private SaveLegalService saveLegalService;
  private DeleteLegalService deleteLegalService;

  
  public AfcarsLegStatHistSO retrieveAfcarsLegalStatus(int idStage) throws ServiceException {
    return retrieveAfcarsLegalStatus.retrieveAfcarsLegalStatus(idStage);
  }
  
  public CSUB38SO retrieveLegalAction(CSUB38SI csub38si) throws ServiceException {
    return retrieveLegalAction.retrieveLegalAction(csub38si);
  }

  public CSUB45SO retrieveLegalService(CSUB45SI csub45si) throws ServiceException {
    return retrieveLegalService.retrieveLegalService(csub45si);
  }
  
  public CSUB39SO saveLegalAction(CSUB39SI csub39si) throws ServiceException {
    return saveLegalAction.saveLegalAction(csub39si);
  }

  public CSUB46SO saveLegalService(CSUB46SI csub46si) throws ServiceException {
    return saveLegalService.saveLegalService(csub46si);
  }
  
  public void deleteLegalService(CCMN01UI ccmn01ui) throws ServiceException {
	    deleteLegalService.deleteLegalService(ccmn01ui);
  }
  
  protected void onEjbCreate() throws CreateException {
    BeanFactory beanFactory = getBeanFactory();
    retrieveAfcarsLegalStatus = getService(RetrieveAfcarsLegalStatus.class);
    retrieveLegalAction = getService(RetrieveLegalAction.class);
    retrieveLegalService = getService(RetrieveLegalService.class);
    saveLegalAction = getService(SaveLegalAction.class);
    saveLegalService = getService(SaveLegalService.class);
    deleteLegalService = getService(DeleteLegalService.class);
  }
}
