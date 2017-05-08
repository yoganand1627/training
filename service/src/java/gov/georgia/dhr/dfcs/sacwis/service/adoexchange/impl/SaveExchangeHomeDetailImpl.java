package gov.georgia.dhr.dfcs.sacwis.service.adoexchange.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildFamLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeHomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeHome;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.SaveExchangeHomeDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeHomeDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeHomeDetailSO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;



/**
 * This is the Service contains the methods to save ExchangeHome records to the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  08/20/08   mchillman   STGAP00010004: Initial code            
 *  11/09/08   mchillman   STGAP00010868: Changed code on comp status is set based on changed to design
 *  04/14/09   mxpatel     STGAP00012983: wrote code to update NAC of ECD when NAC of EHD is changed to "Selected"
 * </pre>
 */

public class SaveExchangeHomeDetailImpl extends BaseServiceImpl implements SaveExchangeHomeDetail {
  
  private static String TASK_EXCANGE_HOME_REGISTRATION = "8085"; 
  private static String EXCANGE_HOME_REGISTRATION_EVENT_TYPE = CodesTables.CEVNTTYP_EXH;
  private static String EXCANGE_HOME_REGISTRATION_DESC = "has been registered with the exchange.";
  
  private StageDAO stageDAO = null;
  private CapsCaseDAO capsCaseDAO = null;
  private PersonDAO personDAO = null;
  private EventDAO eventDAO = null;
  private CapsResourceDAO capsResourceDAO = null;
  private ExchangeHomeDAO exchangeHomeDAO = null;
  private ExchangeChildFamLinkDAO exchangeChildFamLinkDAO = null; 
  private ExchangeChildDAO exchangeChildDAO = null;

  public ExchangeHomeDetailSO saveExchangeHomeDetail(ExchangeHomeDetailSI exchangeHomeDetail) {
    
    //save the event and set the event id
    Integer idEvent = saveEvent(exchangeHomeDetail);
    exchangeHomeDetail.getEvent().setUlIdEvent(idEvent);
    
    //save off the detail
    saveExchangeHome(exchangeHomeDetail);
    
    ExchangeHomeDetailSO exchangeHomeDetailSO = new ExchangeHomeDetailSO();
    gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 eventStruct = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00();
    eventStruct.setUlIdEvent(idEvent);
    eventStruct.setUlIdPerson(exchangeHomeDetail.getEvent().getUlIdPerson());
    exchangeHomeDetailSO.setEvent(eventStruct);
    return exchangeHomeDetailSO;
  }
  
  private void saveExchangeHome(ExchangeHomeDetailSI exchangeHomeDetail) {
    ExchangeHome exchangeHomeDB = new ExchangeHome(); 
    exchangeHomeDB.setCapsResource(capsResourceDAO.findCapsResourceByIdResc(exchangeHomeDetail.getIdResource()));
    exchangeHomeDB.setIdEvent(exchangeHomeDetail.getEvent().getUlIdEvent());
    exchangeHomeDB.setEvent(eventDAO.findEventByIdEvent(exchangeHomeDetail.getEvent().getUlIdEvent()));
    exchangeHomeDB.setDtLastUpdate(exchangeHomeDetail.getDtLastUpdate());
    exchangeHomeDB.setNbrAgencyContractCode(exchangeHomeDetail.getAgencyContractNumber());
    exchangeHomeDB.setNmAgncyCaseworker(exchangeHomeDetail.getPrivateAgencyCaseWorker());
    exchangeHomeDB.setNbrAgncyContactPhn(exchangeHomeDetail.getPhoneNumber());
    exchangeHomeDB.setNbrAgncyContactPhoneExt(exchangeHomeDetail.getPhoneExtension());
    exchangeHomeDB.setDtRegistered(exchangeHomeDetail.getDtRegistered());
    exchangeHomeDB.setDtReRegistered(exchangeHomeDetail.getDtReRegistered());
    exchangeHomeDB.setDtApproved(exchangeHomeDetail.getDtApproved());
    
    exchangeHomeDB.setIndMentalRetardation(exchangeHomeDetail.getIndMentalRetardation());
    exchangeHomeDB.setCdSevMentalRetardation(exchangeHomeDetail.getCdLevelMentalRetardation());
    exchangeHomeDB.setIndVisualHearingImp(exchangeHomeDetail.getIndVisualHearingImpairments());
    exchangeHomeDB.setCdSevVisualHearingImp(exchangeHomeDetail.getCdLevelVisualHearingImpairments());
    exchangeHomeDB.setIndPhysicallyDisabled(exchangeHomeDetail.getIndPhysicallyDisabled());
    exchangeHomeDB.setCdSevPhysicallyDisabled(exchangeHomeDetail.getCdLevelPhysicallyDisabled());
    exchangeHomeDB.setIndEmotionallyDist(exchangeHomeDetail.getIndEmotionallyDisturbed());
    exchangeHomeDB.setCdSevEmotionallyDist(exchangeHomeDetail.getCdLevelEmotionallyDisturbed());
    exchangeHomeDB.setIndOtherMed(exchangeHomeDetail.getIndOtherMedicalDiagnoses());
    exchangeHomeDB.setCdSevOtherMed(exchangeHomeDetail.getCdlevelOtherMedicalDiagnoses());
    
    exchangeHomeDB.setIndFamHxDrugsAlcohol(exchangeHomeDetail.getIndFamilyHxofDrugsAlcohol());
    exchangeHomeDB.setIndFamHxMentalIll(exchangeHomeDetail.getIndFamilyHxofMentalIllness());
    exchangeHomeDB.setIndFamHxMr(exchangeHomeDetail.getIndFamilyHxofMR());
    exchangeHomeDB.setIndChHxSexualAbuse(exchangeHomeDetail.getIndChilsHxofSexualAbuse());
    
    exchangeHomeDB.setNbrChildInterest(exchangeHomeDetail.getNumOfChildren());
    exchangeHomeDB.setTxtCommentsInterest(exchangeHomeDetail.getHomePrefComments());
    
    
    exchangeHomeDB.setCdNonAvailStatus(exchangeHomeDetail.getCdNonAvReasonHA());
    exchangeHomeDB.setDtOut(exchangeHomeDetail.getDateOutHA());
    exchangeHomeDB.setTxtComments(exchangeHomeDetail.getCommentsHA());
    exchangeHomeDB.setTxtFamilyIsLinked(exchangeHomeDetail.getFamilyIsLinkedHA());
        
    exchangeHomeDB.setDtClose(exchangeHomeDetail.getDtClosedNP());
    exchangeHomeDB.setCdReasonClosed(exchangeHomeDetail.getCdReasonClosed());
    exchangeHomeDB.setTxtExplanation(exchangeHomeDetail.getExplanationNPComments());
    
    exchangeHomeDB.setDtFinal(exchangeHomeDetail.getDtFinal());
    exchangeHomeDB.setDtFinalEntered(exchangeHomeDetail.getDtFinalEntered());
    exchangeHomeDB.setNbrAfile(exchangeHomeDetail.getAFileNumCWP());
    exchangeHomeDB.setTxtChildPlacedWith(exchangeHomeDetail.getChildrenPlacedWithCommentCWP());
    
    // added this code for defect #STGAP00012983
    int idEvent = exchangeHomeDB.getIdEvent();
    List<Integer> listIdChildren = new ArrayList<Integer>();
    List<Integer> listIdExchangeChildFamLink = new ArrayList<Integer>();
    // update only if NAC = "selected"
    if (CodesTables.CANONAV_04.equals(exchangeHomeDB.getCdNonAvailStatus())) {
      // find list of children that the home is linked to
      List<Integer> listIdChildrenRegEvent = exchangeChildFamLinkDAO
                                                                    .findIdChildRegEventByIdHomeReg(
                                                                                                    idEvent,
                                                                                                    ArchitectureConstants.Y);
     //make sure not to update if the home is considering more than one child.
      if (listIdChildrenRegEvent != null && !listIdChildrenRegEvent.isEmpty() && listIdChildrenRegEvent.size() == 1) {
        if (listIdChildrenRegEvent != null && !listIdChildrenRegEvent.isEmpty()) {
          Iterator itrChildrenReg = listIdChildrenRegEvent.iterator();
          // find children which are only linked to this one Exchange Home
          while (itrChildrenReg.hasNext()) {
            int idEventChildReg = (Integer) itrChildrenReg.next();
            long countHomeRegPerChildReg = exchangeChildFamLinkDAO
                                                                  .countIdHomeRegEventByIdEventChildReg(
                                                                                                        idEventChildReg,
                                                                                                        ArchitectureConstants.Y);
            if (countHomeRegPerChildReg == 1) {
              listIdChildren.add(idEventChildReg);
            }
          }
        }
        if (listIdChildren != null && !listIdChildren.isEmpty()) {
          // find idEventExchangeCHildFamLink for each child
          Iterator itrChildren = listIdChildren.iterator();
          while (itrChildren.hasNext()) {
            int idEventChildReg = (Integer) itrChildren.next();
            int idExchangeChildFamLink = exchangeChildFamLinkDAO
                                                                .findIdExchangeChildFamilyLinkByIdEventChildReg(
                                                                                                                idEventChildReg,
                                                                                                                ArchitectureConstants.Y);
            listIdExchangeChildFamLink.add(idExchangeChildFamLink);
          }
        }
        if (listIdExchangeChildFamLink != null && !listIdExchangeChildFamLink.isEmpty()) {
          Iterator itrExchangeChildFamLink = listIdExchangeChildFamLink.iterator();
          while (itrExchangeChildFamLink.hasNext()) {
            int idExchangeChildFamLink = (Integer) itrExchangeChildFamLink.next();
            String cdExchangeChildFamLinkNAC = exchangeChildFamLinkDAO
                                                                      .findCdNonAvlCodeByIdExchangeChildFamLink(
                                                                                                                idExchangeChildFamLink,
                                                                                                                ArchitectureConstants.Y);
            if (!CodesTables.CANONAV_04.equals(cdExchangeChildFamLinkNAC)) {
              exchangeChildFamLinkDAO.updateExchangeHomeCdNonAvlRsnByIdExchangeChildFamLink(idExchangeChildFamLink,
                                                                                            CodesTables.CANONAV_04);
            }
            int idEventExchangeChildReg = exchangeChildFamLinkDAO.findIdEventExchangeChildReg(idExchangeChildFamLink);
            String cdExchangeChildNAC = exchangeChildDAO
                                                        .findExchangeChildNonAvailCodeByIdEvent(idEventExchangeChildReg);
            if (!CodesTables.CANONAV_04.equals(cdExchangeChildNAC)) {
              exchangeChildDAO.updateExchangeChildCdNonAvlCdByIdExchangeChildFamLink(idEventExchangeChildReg,
                                                                                     CodesTables.CANONAV_04);
            }
          }
        }
      }
    
    }
    
    exchangeHomeDAO.saveUpdatExchangeHome(exchangeHomeDB);
  }
  
  private Integer saveEvent(ExchangeHomeDetailSI exchangeHomeDetail) {
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 eventStruct = exchangeHomeDetail.getEvent();   
    //no current need to update the event 
    int idEvent = eventStruct.getUlIdEvent();
    if(idEvent == 0) {
      Event event = new Event();
      event.setDtLastUpdate(eventStruct.getTsLastUpdate());
      event.setStage(stageDAO.findStageByIdStage(eventStruct.getUlIdStage()));
      event.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
      event.setCdEventType(EXCANGE_HOME_REGISTRATION_EVENT_TYPE);
      event.setCapsCase(capsCaseDAO.findCapsCaseByIdCase(exchangeHomeDetail.getIdCase()));
      event.setPerson(personDAO.findPersonByIdPerson(eventStruct.getUlIdPerson()));
      event.setCdTask(TASK_EXCANGE_HOME_REGISTRATION);
      event.setDtEventOccurred(new Date());
      event.setTxtEventDescr(exchangeHomeDetail.getName() + " - " + exchangeHomeDetail.getIdResource() + " - " + EXCANGE_HOME_REGISTRATION_DESC);
      idEvent = eventDAO.saveEventReturnsEventId(event);
    } else {
      List<String> nolongerAviableCodes = new ArrayList<String>();
      nolongerAviableCodes.add(CodesTables.CANONAV_11); //Closed/No Placement
      nolongerAviableCodes.add(CodesTables.CANONAV_09); //Regular Placement
      nolongerAviableCodes.add(CodesTables.CANONAV_12); //Foster/Adopt Placement
      nolongerAviableCodes.add(CodesTables.CANONAV_10); //Foster Parent Placement
      nolongerAviableCodes.add(CodesTables.CANONAV_16); //In Rel. Fstr-Prnt Plcmnt
      nolongerAviableCodes.add(CodesTables.CANONAV_15); //In Relative Placement
      nolongerAviableCodes.add(CodesTables.CANONAV_17); //Reunify W/Other Parent
      if(nolongerAviableCodes.contains(exchangeHomeDetail.getCdNonAvReasonHA())) {
        eventDAO.updateEventByIdEvent(idEvent, CodesTables.CEVTSTAT_COMP);
      }
    }
    return new Integer(idEvent);
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setExchangeHomeDAO(ExchangeHomeDAO exchangeHomeDAO) {
    this.exchangeHomeDAO = exchangeHomeDAO;
  }
  
  public void setExchangeChildFamLinkDAO(ExchangeChildFamLinkDAO exchangeChildFamLinkDAO) {
    this.exchangeChildFamLinkDAO = exchangeChildFamLinkDAO;
  }
  
  public void setExchangeChildDAO(ExchangeChildDAO exchangeChildDAO) {
    this.exchangeChildDAO = exchangeChildDAO;
  }
  
}
