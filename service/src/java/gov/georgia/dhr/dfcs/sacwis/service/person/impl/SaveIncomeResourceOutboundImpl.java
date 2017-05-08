package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeResourceOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomeResourceOutbound;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IncomeResourceOutboundSI;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveIncomeResourceOutbound;


public class SaveIncomeResourceOutboundImpl extends BaseServiceImpl implements SaveIncomeResourceOutbound{

  private IncomeResourceOutboundDAO incomeResourceOutboundDAO = null;
  private PersonIdDAO personIdDAO = null;
  
  public void setIncomeResourceOutboundDAO(IncomeResourceOutboundDAO incomeResourceOutboundDAO) {
    this.incomeResourceOutboundDAO = incomeResourceOutboundDAO;
  }
  
  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }
 
  public int saveIncomeResourceOutbound(IncomeResourceOutboundSI input) throws ServiceException {
   
    IncomeResourceOutbound incomeResourceOutbound = new IncomeResourceOutbound();
    
    String nbrCrsId = personIdDAO.findNonEndDatePersonCRSId(input.getIdPerson());
    if (nbrCrsId != null){
      try{
      incomeResourceOutbound.setNbrCrsId(Integer.parseInt(nbrCrsId));
      incomeResourceOutbound.setDtLastUpdate(input.getDtLastUpdate());
      incomeResourceOutbound.setInterfaceStatus(input.getInterfaceStatus());
      incomeResourceOutbound.setIdInitiator(input.getIdInitiator());
      incomeResourceOutbound.setDtIncRequested(input.getDtMedRequested());
      incomeResourceOutbound.setCdTargetSystem(input.getCdTargetSystem());
      incomeResourceOutbound.setIdPerson(input.getIdPerson());
      incomeResourceOutbound.setCdReqIdent(input.getCdReqIdent());
      incomeResourceOutbound.setNbrCrsId(Integer.parseInt(nbrCrsId));
      int id = incomeResourceOutboundDAO.saveIncomeResourceOutbound(incomeResourceOutbound);
      return id;      
      } catch(NumberFormatException nfe){
        throw new ServiceException(Messages.MSG_CRS_ID_NOT_A_NUMBER);
      }
    }
    else{
      throw new ServiceException(Messages.MSG_CRS_ID_NOT_FND);
    }
      
   
      
  }        

}







