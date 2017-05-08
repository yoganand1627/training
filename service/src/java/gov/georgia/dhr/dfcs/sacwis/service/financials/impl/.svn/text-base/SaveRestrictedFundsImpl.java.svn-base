package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RestrictedFundsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.RestrictedFunds;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveRestrictedFunds;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RestrictedFundsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RestrictedFundsSO;

import java.util.Date;

public class SaveRestrictedFundsImpl extends BaseServiceImpl implements SaveRestrictedFunds {
  
  private EventDAO eventDAO;
  private RestrictedFundsDAO restrictedFundsDAO;

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setRestrictedFundsDAO(RestrictedFundsDAO restrictedFundsDAO) {
    this.restrictedFundsDAO = restrictedFundsDAO;
  }

  public RestrictedFundsSO saveRestrictedFunds(RestrictedFundsSaveSI si) {
    RestrictedFundsSO so;
    boolean resetStatusIA = false;
    boolean resetStatusAA = false;
    if(si.getOldData() != null){ //-- should never be null
      so = si.getOldData();
      resetStatusIA = so.invalidateApproval();
      resetStatusAA = so.getIdEvent() > 0 && (CodesTables.CEVTSTAT_APRV.equals(so.getStatus()) || CodesTables.CEVTSTAT_COMP.equals(so.getStatus()));
    } else {
      so = new RestrictedFundsSO();
      so.setIdEvent(-1);
    }
    
    //-- determine insert or update based on idEvent
    boolean insertRF = so.getIdEvent() == -1;
    boolean createEvent = false;
    
    RestrictedFunds rf;
    if(!insertRF){
      rf = getPersistentObject(RestrictedFunds.class, si.getIdPerson());
      createEvent = rf.getEvent() == null;
    } else {
      rf = new RestrictedFunds();
      rf.setPerson(getPersistentObject(Person.class, si.getIdPerson()));
      rf.setAmtCheckBal(so.getCheckingBalance());
      rf.setAmtSavBal(so.getSavingsBalance());
      createEvent = true;
    }
    
    if(createEvent){
      //-- create Event, save (?), and place in rf
      Event event = new Event();
      
      //-- required
      event.setIdEvent(0);
      Stage stage = getPersistentObject(Stage.class, si.getIdStage());
      event.setStage(stage);
      //event.setCdEventType(CodesTables.CEVNTTYP_RSF);
      event.setCdEventType("RSF");
      
      //-- optional
      Person user = getPersistentObject(Person.class, si.getIdUser());
      if(user != null) {
        event.setPerson(user);
      }
      event.setCapsCase(stage.getCapsCase());
      event.setCdTask(si.getTaskCode());
      Person person = getPersistentObject(Person.class, si.getIdPerson());
      event.setTxtEventDescr("Restricted Funds set for "+person.getNmPersonFull());
      event.setDtEventOccurred(new Date());
      event.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
      
      rf.setEvent(event);
    }
    
    if(si.isSubmitForApproval()){
      //-- by this point, we have an associated Event; update event status
      rf.getEvent().setCdEventStatus(CodesTables.CEVTSTAT_COMP);
    } else if(resetStatusIA) {
      //-- represents user that is not approver clicking save for previously submitted approval
      rf.getEvent().setCdEventStatus(CodesTables.CEVTSTAT_PROC);
      so.setInvalidateApproval(false);
    } else if(resetStatusAA) {
      //-- represents any user clicking save for previously approved event
      rf.getEvent().setCdEventStatus(CodesTables.CEVTSTAT_PROC);
    }
    
    if(createEvent || si.isSubmitForApproval() || resetStatusIA || resetStatusAA){
      eventDAO.saveEvent(rf.getEvent());
    }
    rf.setAmtRes(si.getReservedAmount());
    rf.setTxtRes(si.getReservedReason());
    restrictedFundsDAO.save(rf);
    
    //-- if save successful, populate so
    so.setReservedAmount(rf.getAmtRes());
    so.setReservedReason(rf.getTxtRes());
    so.setCheckingBalance(rf.getAmtCheckBal() != null ? rf.getAmtCheckBal() : 0);
    so.setSavingsBalance(rf.getAmtSavBal() != null ? rf.getAmtSavBal() : 0);
    so.setStatus(rf.getEvent().getCdEventStatus());
    so.setIdEvent(rf.getEvent().getIdEvent());
    
    return so;
  }

}
