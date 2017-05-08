package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.RestrictedFundsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.RestrictedFunds;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveRestrictedFunds;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RestrictedFundsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RestrictedFundsSO;

public class RetrieveRestrictedFundsImpl extends BaseServiceImpl implements RetrieveRestrictedFunds {
  
  private RestrictedFundsDAO restrictedFundsDAO;

  public void setRestrictedFundsDAO(RestrictedFundsDAO restrictedFundsDAO) {
    this.restrictedFundsDAO = restrictedFundsDAO;
  }

  public RestrictedFundsSO retrieveRestrictedFunds(RestrictedFundsRetrieveSI si) {
    RestrictedFundsSO so = new RestrictedFundsSO();
    RestrictedFunds rf = null;
    
    int idPerson = si.getIdPerson();
    if(idPerson > 0){ //-- only false when called from taskDisplay
      rf = restrictedFundsDAO.findByIdPerson(idPerson);
    } else {
      rf = restrictedFundsDAO.findByIdEvent(si.getIdEvent());
    }
    
    if(rf == null){
      so.setIdEvent(-1); //-- indicate insert on save
      so.setStatus(CodesTables.CEVTSTAT_NEW);
      if(idPerson > 0){
        Person person = getPersistentObject(Person.class, idPerson);
        so.setChildName(person.getNmPersonFull());
      }
      return so;
    }
    
    so.setIdPerson(rf.getIdPerson());
    so.setChildName(rf.getPerson().getNmPersonFull());
    so.setReservedAmount(rf.getAmtRes() != null ? rf.getAmtRes() : 0);
    so.setReservedReason(rf.getTxtRes());
    so.setCheckingBalance(rf.getAmtCheckBal() != null ? rf.getAmtCheckBal() : 0);
    so.setSavingsBalance(rf.getAmtSavBal() != null ? rf.getAmtSavBal() : 0);
    if(rf.getEvent() == null){
      so.setIdEvent(0);
      so.setStatus(CodesTables.CEVTSTAT_NEW);
    } else {
      so.setStatus(rf.getEvent().getCdEventStatus());
      so.setIdEvent(rf.getEvent().getIdEvent());
    }
    
    return so;
  }

}
