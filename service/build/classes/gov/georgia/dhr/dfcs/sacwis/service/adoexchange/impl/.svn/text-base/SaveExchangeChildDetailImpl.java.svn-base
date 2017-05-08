package gov.georgia.dhr.dfcs.sacwis.service.adoexchange.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExcChildAdoInfoCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildFamLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeHomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionOutcomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SiblingDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SiblingGroupDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.ExcChildAdoInfoCbx;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChild;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.SiblingGroup;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.SaveExchangeChildDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeChildDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExcChildAdoInfoCbxStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeChildDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpecialNeedsDeterminationSaveSO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  04/14/09   mxpatel     STGAP00012983: wrote code to update NAC of EHD when NAC of ECD is changed to "Selected"
 *  05/26/09   mchillman   STGAP00012852: mark record as COMP when Non-Availability code is saved with Closed/No Placement.    
 *  08/20/09   arege       STGAP00014976: Added Null check to resolve Null Pointer Error on Save
 *  08/28/09   arege       STGAP00014976: Modified code as per peer review.
 *  11/19/09   mxpatel     37288: modified code so that dtOout is not set to current date when saving ECD for the first time
 *  12/05/09   mxpatel     SMS # 37348: wrote code to set the variable - indRsnClosedChanged
 *  12/06/09   arege       SMS#40965 The Dissolution Date in the Closed With Placement section should be modifiable with a Date ticker. 
 *  12/15/09   mxpatel     SMS# 37447: wrote code to set the variable - indBirthNameChanged 						    					
 *  06/06/11   hnguyen     SMS#109405: MR-083 Updated save logic to save recruitment activities.                                                                                     
 */

public class SaveExchangeChildDetailImpl extends BaseServiceImpl implements SaveExchangeChildDetail {

  private ExchangeChildDAO exchangeChildDAO = null;

  private ExcChildAdoInfoCbxDAO excChildAdoInfoCbxDAO = null;

  private EventDAO eventDAO = null;

  private ExchangeChildFamLinkDAO exchangeChildFamLinkDAO = null;
  
  private ExchangeHomeDAO exchangeHomeDAO = null;
  
  private SiblingGroupDAO siblingGroupDAO = null;
  
  private SiblingDAO siblingDAO = null;
  
  private PostEvent postEvent = null;

  private LegalActionOutcomeDAO legalActionOutcomeDAO = null;

  private LegalActionDAO legalActionDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  public void setLegalActionOutcomeDAO(LegalActionOutcomeDAO legalActionOutcomeDAO) {
	    this.legalActionOutcomeDAO = legalActionOutcomeDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
	    this.legalActionDAO = legalActionDAO;
  }

  public void setSiblingGroupDAO(SiblingGroupDAO siblingGroupDAO) {
	    this.siblingGroupDAO = siblingGroupDAO;
  }

  public void setSiblingDAO(SiblingDAO siblingDAO) {
	    this.siblingDAO = siblingDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setExchangeChildFamLinkDAO(ExchangeChildFamLinkDAO exchangeChildFamLinkDAO) {
    this.exchangeChildFamLinkDAO = exchangeChildFamLinkDAO;
  }
  
  public void setExchangeHomeDAO(ExchangeHomeDAO exchangeHomeDAO) {
    this.exchangeHomeDAO = exchangeHomeDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setExchangeChildDAO(ExchangeChildDAO exchangeChildDAO) {
    this.exchangeChildDAO = exchangeChildDAO;
  }

  public void setExcChildAdoInfoCbxDAO(ExcChildAdoInfoCbxDAO excChildAdoInfoCbxDAO) {
    this.excChildAdoInfoCbxDAO = excChildAdoInfoCbxDAO;
  }

  public ExchangeChildDetailSaveSO saveExchangeChildDetail(ExchangeChildDetailSaveSI exchangeChildDetailSaveSI) {
    ExchangeChildDetailSaveSO exchangeChildDetailSaveSO = new ExchangeChildDetailSaveSO();
    int idEvent = exchangeChildDetailSaveSI.getIdEvent();
    int idStage = exchangeChildDetailSaveSI.getIdStage();
    int idUser = exchangeChildDetailSaveSI.getIdCaseWorker();
    String cdRsnNonAvail = exchangeChildDetailSaveSI.getCdNonAvailStatus();
    try {
      Collection emotionalCodesList = Lookup.getCategoryCodesCollection(CodesTables.CANONAV);

      if (emotionalCodesList != null) {
        emotionalCodesList.remove(CodesTables.CANONAV_00);
        emotionalCodesList.remove(CodesTables.CANONAV_03);
        emotionalCodesList.remove(CodesTables.CANONAV_55);
        if (emotionalCodesList.contains(cdRsnNonAvail)) {
          Long countExistingLinks = exchangeChildFamLinkDAO
                                                           .countExcChildFamLinksByChildRegEventIdAndCurInd(
                                                                                                            idEvent,
                                                                                                            ArchitectureConstants.Y);
          if (countExistingLinks != null && countExistingLinks > 1) {
            throw new ServiceException(Messages.MSG_UNLINK_BEFORE_PLACEMENT);
          }
        }
      }
    } catch (LookupException e) {
      throw new ServiceException(Messages.SQL_NOT_FOUND, e);
    }
    Event event = new Event();
    String actionCode = ServiceConstants.REQ_FUNC_CD_ADD;
    if (idEvent != 0) {
      actionCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }
    CCMN06UI ccmn06ui = populateCCMN06UI_CheckStageEventStatus(idStage, idUser, exchangeChildDetailSaveSI.getCdTask(), actionCode);
    checkStageEventStatus.status(ccmn06ui);
    ExchangeChild excChild = populate_Exchange_Child_SaveSI(exchangeChildDetailSaveSI);
    if (idEvent != 0) {
      excChild.setIdEvent(idEvent);
      excChild.setDtLastUpdate(exchangeChildDetailSaveSI.getDtLastUpdate());
    }
    
    CCMN01UO ccmn01uo = callPostEvent(exchangeChildDetailSaveSI, actionCode);
    if (ccmn01uo != null) {
      idEvent = ccmn01uo.getUlIdEvent();
      excChild.setIdEvent(idEvent);
    }
    
    //update sibling group information if childs legal action shows child should
    //be available for adoption
    updateSiblingGroupNumberAvailableForAdoption(exchangeChildDetailSaveSI);
    
    event = (Event) getPersistentObject(Event.class, idEvent);
    excChild.setEvent(event);
    
    // do all of this if the NAC is "Selected" (#STGAP00012983)
    if (CodesTables.CANONAV_04.equals(excChild.getCdNonAvailStatus())) {
      // find idHomeRegEvent (id_event_home_regitation) to which the child is linked to
      
      // STGAP00014976: Added Null check to resolve Null Pointer Error on Save
      Integer idHomeRegEvent = exchangeChildFamLinkDAO.findIdHomeRegEvenbtByIdEventChildReg(idEvent,ArchitectureConstants.Y);
      if(idHomeRegEvent == null){
        idHomeRegEvent = 0; 
      }
      
      // find the list of children (id_event_child_registration) for the home
      List<Integer> listIdExchangeChildFamLink = exchangeChildFamLinkDAO
                                                                        .findListIdExchangeChildFamilyLinkByIdEventHomeReg(
                                                                                                                           idHomeRegEvent,
                                                                                                                           ArchitectureConstants.Y);
      int countChildRegsPerHome = 0;
      if (listIdExchangeChildFamLink != null && !listIdExchangeChildFamLink.isEmpty()) {
        // check how many children are linked to the home
        countChildRegsPerHome = listIdExchangeChildFamLink.size();
      }
      // ONLY update the following if the home is only linked to one child.
      if (countChildRegsPerHome == 1) {
        int idExchangeChildFamLink = exchangeChildFamLinkDAO
                                                            .findIdExchangeChildFamilyLinkByIdEventHomeReg(
                                                                                                           idHomeRegEvent,
                                                                                                           ArchitectureConstants.Y);
        String exchangeChildFamLinkNAC = exchangeChildFamLinkDAO
                                                                .findCdNonAvlCodeByIdExchangeChildFamLink(
                                                                                                          idExchangeChildFamLink,
                                                                                                          ArchitectureConstants.Y);
        if (!CodesTables.CANONAV_04.equals(exchangeChildFamLinkNAC)) {
          exchangeChildFamLinkDAO.updateExchangeHomeCdNonAvlRsnByIdExchangeChildFamLink(idExchangeChildFamLink,
                                                                                        CodesTables.CANONAV_04);
        }
        String exchangeHomeNAC = exchangeHomeDAO.findCdNonAvlCodeByIdEvent(idHomeRegEvent);
        if (!CodesTables.CANONAV_04.equals(exchangeHomeNAC)) {
          exchangeHomeDAO.updateExchangeHomeCdNonAvailStatus(idHomeRegEvent, CodesTables.CANONAV_04);
        }
      }
    }
    
    exchangeChildDAO.saveExchangeChild(excChild);
    setExcChildAdoInfoCbx(exchangeChildDetailSaveSI, idEvent);
    exchangeChildDetailSaveSO.setIdEvent(idEvent);
    return exchangeChildDetailSaveSO;
  }


  private ExchangeChild populate_Exchange_Child_SaveSI(ExchangeChildDetailSaveSI exchangeChildDetailSaveSI) {
    ExchangeChild excChild = new ExchangeChild();
    excChild.setCdNonAvailStatus(exchangeChildDetailSaveSI.getCdNonAvailStatus());
    if(ArchitectureConstants.Y.equals(exchangeChildDetailSaveSI.getIndRsnClosedChanged())){
      excChild.setIndRsnClosedChanged(ArchitectureConstants.Y);
    }
    excChild.setIndBirthNameChanged(exchangeChildDetailSaveSI.getIndBirthNameChanged());
    excChild.setCdReasonClosed(exchangeChildDetailSaveSI.getCdReasonClosed());
    excChild.setCdSevEmotionallyDist(exchangeChildDetailSaveSI.getCdSevEmotionallyDist());
    excChild.setCdSevMentalRetardation(exchangeChildDetailSaveSI.getCdSevMentalRetardation());
    excChild.setCdSevOtherMed(exchangeChildDetailSaveSI.getCdSevOtherMed());
    excChild.setCdSevPhysicallyDisabled(exchangeChildDetailSaveSI.getCdSevPhysicallyDisabled());
    excChild.setCdSevVisualHearingImp(exchangeChildDetailSaveSI.getCdSevVisualHearingImp());
    excChild.setDtApproved(exchangeChildDetailSaveSI.getDtApproved());
    excChild.setDtClose(exchangeChildDetailSaveSI.getDtClose());
    excChild.setDtFinal(exchangeChildDetailSaveSI.getDtFinal());
    excChild.setDtFinalEntered(exchangeChildDetailSaveSI.getDtFinalEntered());
    excChild.setDtFinalEntered(exchangeChildDetailSaveSI.getDtFinalEntered());
    excChild.setDtNotified(exchangeChildDetailSaveSI.getDtNotified());
    excChild.setDtOut(exchangeChildDetailSaveSI.getDtOut());
    excChild.setDtRegistered(exchangeChildDetailSaveSI.getDtRegistered());
    excChild.setDtReRegistered(exchangeChildDetailSaveSI.getDtReRegistered());
    excChild.setIdPerson(exchangeChildDetailSaveSI.getIdPerson());
    excChild.setIndBioIsLegFather(exchangeChildDetailSaveSI.getIndBioIsLegFather());
    excChild.setIndChHxSexualAbuse(exchangeChildDetailSaveSI.getIndChHxSexualAbuse());
    excChild.setIndEmotionallyDist(exchangeChildDetailSaveSI.getIndEmotionallyDist());
    excChild.setIndFamHxDrugsAlcohol(exchangeChildDetailSaveSI.getIndFamHxDrugsAlcohol());
    excChild.setIndFamHxMentalIll(exchangeChildDetailSaveSI.getIndFamHxMentalIll());
    excChild.setIndFamHxMr(exchangeChildDetailSaveSI.getIndFamHxMr());
    excChild.setIndLegalRisk(exchangeChildDetailSaveSI.getIndLegalRisk());
    excChild.setIndMentalRetardation(exchangeChildDetailSaveSI.getIndMentalRetardation());
    excChild.setIndOtherMed(exchangeChildDetailSaveSI.getIndOtherMed());
    excChild.setIndPhysicallyDisabled(exchangeChildDetailSaveSI.getIndPhysicallyDisabled());
    excChild.setIndVisualHearingImp(exchangeChildDetailSaveSI.getIndVisualHearingImp());
    excChild.setNbrAfile(exchangeChildDetailSaveSI.getNbrAfile());
    excChild.setTxtAvailComments(exchangeChildDetailSaveSI.getTxtAvailComments());
    excChild.setTxtBirthName(exchangeChildDetailSaveSI.getTxtBirthName());
    excChild.setTxtChildIsLinked(exchangeChildDetailSaveSI.getTxtChildIsLinked());
    excChild.setDtDissolutionCWP(exchangeChildDetailSaveSI.getDtDissolutionCWP());
    excChild.setTxtChildPlacedWith(exchangeChildDetailSaveSI.getTxtChildPlacedWith());
    excChild.setTxtExplanationNoPlcmt(exchangeChildDetailSaveSI.getTxtExplanationNoPlcmt());
    excChild.setTxtRecruitComment(exchangeChildDetailSaveSI.getTxtRecruitComment());
    excChild.setTxtSpclNeedsComment(exchangeChildDetailSaveSI.getTxtSpclNdsCmnts());
    // MR-083 set indicator for state actively recruiting for child
    excChild.setCdStateActivelyRecruiting(exchangeChildDetailSaveSI.getCdStateActivelyRecruiting());
    return excChild;
  }

  private void setExcChildAdoInfoCbx(ExchangeChildDetailSaveSI exchangeChildDetailSaveSI, int idEvent) {
    Collection<String> activityCodesList = new ArrayList<String>();
    Map<String, Date> newRecActivityDate = exchangeChildDetailSaveSI.getNewRecActivityDate();
    Map<String, List<ExcChildAdoInfoCbxStruct>> modifiedRecActivitiesDates = exchangeChildDetailSaveSI.getModifiedRecActivitiesDates();
    
    try{
      // get all possible recruitment activity codes
      activityCodesList = Lookup.getCategoryCodesCollection(CodesTables.CADRACS);
    } catch( Exception e ){
      // this should never occur
      throw new ServiceException(Messages.MSG_CODE_NOT_FOUND);
    }
    
    if(null != activityCodesList && !activityCodesList.isEmpty()){
      Iterator<String> it = activityCodesList.iterator();
      
      // loop through each activity code
      while(it.hasNext()){
        String actCode = it.next();
        
        if(modifiedRecActivitiesDates != null && !modifiedRecActivitiesDates.isEmpty()){
          List<ExcChildAdoInfoCbxStruct> recActList = modifiedRecActivitiesDates.get(actCode);
          
          for( int i = 0; i < recActList.size(); i++ ){
            ExcChildAdoInfoCbxStruct recActSO = recActList.get(i);
            
            if(null != recActSO){
              if(recActSO.getDtPerformed() == null && recActSO.getIdInfoChar() > 0){
                // date is null but idInfoChar > 0, therefore user
                // has deleted value from date field, therefore delete record with the old date.                
                excChildAdoInfoCbxDAO.deleteExcChildAdoInfoCbx(recActSO.getIdInfoChar());
              }else{ // otherwise save or update
                ExcChildAdoInfoCbx excChildAdoInfoCbx = null;
                if(recActSO.getIdInfoChar() > 0){
                  excChildAdoInfoCbx = getPersistentObject(ExcChildAdoInfoCbx.class, recActSO.getIdInfoChar());
                }else{
                  excChildAdoInfoCbx = new ExcChildAdoInfoCbx();
                  excChildAdoInfoCbx.setIdInfoChar(0);
                }
                excChildAdoInfoCbx.setCdAdoInfoCbx(recActSO.getCdAdoInfoCbx());
                excChildAdoInfoCbx.setCdCbxCodeType(recActSO.getCdCbxCodeType());
                excChildAdoInfoCbx.setDtPerformed(recActSO.getDtPerformed());
                excChildAdoInfoCbx.setExchangeChild((ExchangeChild) getPersistentObject(ExchangeChild.class, idEvent));
                excChildAdoInfoCbxDAO.saveExcChildAdoInfoDetail(excChildAdoInfoCbx);
              }
            }
          } // end for loop
        } // end if
        
        // Added the new date entered by user using calendar control
        if(null != newRecActivityDate){
          Date newActDate = newRecActivityDate.get(actCode);
          
          if(null != newActDate){
            ExcChildAdoInfoCbx excChildAdoInfoCbx = new ExcChildAdoInfoCbx();
            excChildAdoInfoCbx.setIdInfoChar(0);
            excChildAdoInfoCbx.setCdAdoInfoCbx(actCode);
            excChildAdoInfoCbx.setCdCbxCodeType(CodesTables.CADRACS);
            excChildAdoInfoCbx.setDtPerformed(newActDate);
            excChildAdoInfoCbx.setExchangeChild((ExchangeChild) getPersistentObject(ExchangeChild.class, idEvent));
            excChildAdoInfoCbxDAO.saveExcChildAdoInfoDetail(excChildAdoInfoCbx);
          }
        } // end if
      } // end while
    } // if
  } // end method

  /**
   * Creates/updates the event for Special Needs/Adoption Assist App
   * 
   * @param exchangeChildDetailSaveSI
   * @param actionCode
   * @return Post Event Output Bean
   */
  private CCMN01UO callPostEvent(ExchangeChildDetailSaveSI exchangeChildDetailSaveSI, String actionCode) {
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    String desc = "";

    int idEvent = exchangeChildDetailSaveSI.getIdEvent();
    int idPerson = exchangeChildDetailSaveSI.getIdPerson();
    String eventStatus = CodesTables.CEVTSTAT_PROC;
    Date dtFinal = exchangeChildDetailSaveSI.getDtFinal();
    String rsnClosed = exchangeChildDetailSaveSI.getCdReasonClosed();
    String cdNonAvailStatus = exchangeChildDetailSaveSI.getCdNonAvailStatus();
    if(!DateHelper.isNull(dtFinal)  || StringHelper.isValid(rsnClosed) || CodesTables.CANONAV_11.equals(cdNonAvailStatus)) {
      eventStatus = CodesTables.CEVTSTAT_COMP;
    }
    desc = exchangeChildDetailSaveSI.getNmChild() + "-" + idPerson + " has been registered with the exchange";
    if (idEvent!= 0) {
     rowccmn01uig00.setUlIdEvent(idEvent);
     rowccmn01uig00.setTsLastUpdate(exchangeChildDetailSaveSI.getDtEventLastUpdate());
   }
    rowccmn01uig00.setSzCdEventStatus(eventStatus);
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_EXC);
    rowccmn01uig00.setSzTxtEventDescr(desc);
    rowccmn01uig00.setSzCdTask(exchangeChildDetailSaveSI.getCdTask());
    rowccmn01uig00.setUlIdPerson(exchangeChildDetailSaveSI.getIdCaseWorker());
    rowccmn01uig00.setUlIdStage(exchangeChildDetailSaveSI.getIdStage());

    if (!DateHelper.isNull(exchangeChildDetailSaveSI.getDtEventOccurred()) && idEvent != 0) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(exchangeChildDetailSaveSI.getDtEventOccurred()));
    } else {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));

    }
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 rowccmn01uig01;
    if (idPerson != 0) {
      rowccmn01uig01 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01();
      rowccmn01uig01.setUlIdPerson(idPerson);
      rowccmn01uig01.setSzCdScrDataAction(actionCode);
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    }
    if (idEvent != 0) {
      rowccmn01uig01_array = null;
    }
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(actionCode);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);

  }
  /**
   * Populates the bean necessary to run the CheckStageEventStatus service
   * 
   * @param idStage
   * @param idUser
   * @param cdTask
   * @param actionCode
   * @return Populated CheckStageEventStatus Bean
   */
  private CCMN06UI populateCCMN06UI_CheckStageEventStatus(int idStage, int idUser, String cdTask, String actionCode) {

    CCMN06UI ccmn06ui = new CCMN06UI();
    ArchInputStruct input = new ArchInputStruct();

    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdTask);

    input.setSzUserId(String.valueOf(idUser));
    input.setCReqFuncCd(actionCode);

    ccmn06ui.setArchInputStruct(input);

    return ccmn06ui;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }
  
  private void updateSiblingGroupNumberAvailableForAdoption(
		  ExchangeChildDetailSaveSI exchangeChildDetailSaveSI){
	    Integer idCase = exchangeChildDetailSaveSI.getIdCase();
	    Integer idEvent = exchangeChildDetailSaveSI.getIdEvent();
	    Integer idPerson = exchangeChildDetailSaveSI.getIdPerson();
	    
	    Integer idSiblingGroupInteger = siblingDAO.findSiblingGroupIdByIdPerson(idPerson);
	    
	    if(idSiblingGroupInteger != null && idSiblingGroupInteger.intValue() != 0){//child is in a sibling group
	    	if(childLegalActionShowsAvailableForAdoption(idCase, idPerson)){
	    		//status change only needed if the child is legally available	    		
	    		String oldNonAvailStatus = exchangeChildDAO.findExchangeChildNonAvailCodeByIdEvent(idEvent); 
	    		String newNonAVailStatus = exchangeChildDetailSaveSI.getCdNonAvailStatus();

	    		boolean statusChangeRequiresSiblingGroupUpdate = (
	    				statusChangedFromAvailable(oldNonAvailStatus, newNonAVailStatus) ||
	    				statusChangedToAvailable(oldNonAvailStatus, newNonAVailStatus)
	    		);
	    		
	    		if(statusChangeRequiresSiblingGroupUpdate) {
	    			//update the number in group
	    			SiblingGroup siblingGroup = getPersistentObject(SiblingGroup.class, idSiblingGroupInteger);
	    			Integer numAvailable = siblingGroup.getNbrAvail();
	    		
	    			if(statusChangedToAvailable(oldNonAvailStatus, newNonAVailStatus)) {
	    				numAvailable = numAvailable + 1;
	    			} else if(statusChangedFromAvailable(oldNonAvailStatus, newNonAVailStatus)) {
	    				numAvailable = numAvailable - 1;
	    			}
	    			siblingGroup.setNbrAvail(numAvailable);
	    			siblingGroupDAO.saveSiblingGroup(siblingGroup);
	    		
	    		}	
	    	}
	    		
	    }
}
  


  private boolean childLegalActionShowsAvailableForAdoption(int idCase, int idPerson) {
	  List <LegalAction> legalActionList = retrieveLegalActionTPRAchieved(idCase, idPerson);
	  return (legalActionList != null && !legalActionList.isEmpty());
  }
  
	private List<LegalAction> retrieveLegalActionTPRAchieved(int idCase, int idPerson) {
	    List<String> cdLegalActActions = new ArrayList<String>();
	    cdLegalActActions.add(CodesTables.CLEGCPS_VLM); // Voluntary Surrrender-Mother
	    cdLegalActActions.add(CodesTables.CLEGCPS_VLF); // Voluntary Surrrender-Father
	    cdLegalActActions.add(CodesTables.CLEGCPS_VAM); // Voluntary Surrender by Adoptive Mother
	    cdLegalActActions.add(CodesTables.CLEGCPS_VAF); // Voluntary Surrender by Adoptive Father

	    String[] cdOutcomes = new String[4];
	    cdOutcomes[0] = CodesTables.CLEGLOUT_TPC; // Perm Custody to DHR
	    cdOutcomes[1] = CodesTables.CLEGLOUT_TPS; // Perm Custody to Specified Relative for Adoption
	    cdOutcomes[2] = CodesTables.CLEGLOUT_TPT; // Perm Custody to a 3rd Party
	    cdOutcomes[3] = CodesTables.CLEGLOUT_DPC; // Deceased Parents perm custody to dhr
	    
	    List<String> cdHrTypCrtOrds = new ArrayList<String>();
	    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPF);
	    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPM);
	    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPA);
	    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFA);
	    
	    List<LegalAction> legalActionsQueriedList = legalActionDAO
					.findLegalActionListByIdStageByIdPersonBycdActionsByCdOutcomes(
							idCase, idPerson, cdLegalActActions, cdOutcomes,
							cdHrTypCrtOrds);
	    
	    List<LegalAction> filteredLegalActionList = new ArrayList<LegalAction>();
	    if(legalActionsQueriedList != null && !legalActionsQueriedList.isEmpty()){
		    Iterator allIterator = legalActionsQueriedList.iterator();

	    	while(allIterator.hasNext()) {
	    		LegalAction la = (LegalAction)allIterator.next();
	    		
	    		if(courtOrderIsTPR(la.getCdHrTypCrtOrd()) ){
	    			//ensure that TPR was granted before returning this legal action
	    		      //Get all the legal action outcome records for this event
	    		      List<String> cdOutcomeList = legalActionOutcomeDAO.findCdOutcomeListByIdEvent(la.getIdLegalActEvent());
	    		      if(cdOutcomeList.contains(CodesTables.CLEGLOUT_TPG)
	    		    		  ||cdOutcomeList.contains(CodesTables.CLEGLOUT_DPC)) {
	    		    	  filteredLegalActionList.add(la);
	    		      }      
	    		} else {
	    			filteredLegalActionList.add(la);
	    		}
	    	}
	    } 
	    
	    return filteredLegalActionList;
	}

	private boolean courtOrderIsTPR(String cdHrTypCrtOrd){
	  if(StringHelper.isValid(cdHrTypCrtOrd)){
		  
		  return (
				  cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPF)||
				  cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPM)||
				  cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPA)||
				  cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TFA)
		  );
		  
	  }
	  return false;
	}
	
	private boolean statusChangedToAvailable(String oldStatus, String newStatus){		
		if(oldStatus == null || newStatus == null){
			return false;
		}
		
		boolean oldStatusWasNonAvailable = (!oldStatus.equals("00")&&
												!oldStatus.equals("03")&&
												!oldStatus.equals("55"));

		boolean newStatusWillBeAvailable = (oldStatus.equals("00")||
				oldStatus.equals("03")||
				oldStatus.equals("55"));
		
		return (oldStatusWasNonAvailable && newStatusWillBeAvailable);
	}
	
	private boolean statusChangedFromAvailable(String oldStatus, String newStatus) {
		if(oldStatus == null || newStatus == null){
			return false;
		}

		
		boolean oldStatusWasAvailable = (oldStatus.equals("00")||
										oldStatus.equals("03")||
										oldStatus.equals("55"));
		
		boolean newStatusWillBeNonAvailable = (!oldStatus.equals("00")&&
												!oldStatus.equals("03")&&
												!oldStatus.equals("55"));
		
		return (oldStatusWasAvailable && newStatusWillBeNonAvailable);
	}
}
