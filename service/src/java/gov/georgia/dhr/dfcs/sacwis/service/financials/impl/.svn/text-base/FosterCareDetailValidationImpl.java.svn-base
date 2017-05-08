package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.financials.FosterCareDetailValidation;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN08SO;

public class FosterCareDetailValidationImpl extends BaseServiceImpl implements FosterCareDetailValidation {

  private PersonDAO personDAO = null;
  private CapsResourceDAO capsResourceDAO = null;

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public CFIN08SO retrieveFosterCareDetailValidation(CFIN08SI cfin08si) throws ServiceException {
    CFIN08SO cfin08so = new CFIN08SO();
    
    if (ArchitectureConstants.Y.equals(cfin08si.getWcdIndPrsnChng())) {
      //rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
      Person personInfo = personDAO.findPersonByIdPerson(cfin08si.getUlIdPerson());
      if (personInfo == null) {
        throw new ServiceException(Messages.SSM_FIN_INVALID_PRSN_ID);
      }
      cfin08so.setSzNmPersonFull(personInfo.getNmPersonFull());
      
      String cdSmileClient = personDAO.findSMILEClientByIdPerson(cfin08si.getUlIdPerson());
      if (cdSmileClient==null){
        throw new ServiceException(Messages.MSG_CLIENT_SMILE);
      }

      //rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
      CapsResource capsResourceInfo = capsResourceDAO.findCapsResourceByIdResourceOnly(cfin08si.getUlIdResource());
      if (capsResourceInfo == null) {
        throw new ServiceException(Messages.SSM_FIN_INVALID_RSRC_ID);
      }
      cfin08so.setLNbrRsrcFacilAcclaim(
              capsResourceInfo.getNbrRsrcFacilAcclaim() != null ? capsResourceInfo.getNbrRsrcFacilAcclaim() : 0);
    }
    
    return cfin08so;
  }

}
