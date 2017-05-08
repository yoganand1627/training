package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

/**
 * <pre>
 *                        Change History:
 *                        Date      User              Description
 *                        --------  ----------------  --------------------------------------------------
 * </pre>                 6/12/2008 mchillman         STGAP00009156 added method to pull form narrative
 *                        6/19/2008 mchillman         STGAP00005275 add/inculde the same method that is used populated
 *                                                    the non aftercare to the aftercare population
 * 
 */

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FCCPFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OutputLaunchEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FccpFamily;
import gov.georgia.dhr.dfcs.sacwis.db.OutputLaunchEventLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveFCCPFamilyDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCCPFamilyDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO.RowPlanPrincipal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
* 
* <pre>
*                        Change History:
*                        Date      User             Description
*                        --------  ---------------- --------------------------------------------------
* </pre>                 07/15/2008 mchillman       STGAP00009588: Insured that for Aftercare plans only
*                                                   Principals on the Plan that are checked are in the drop list
*                        09/16/2008  arege          STGAP00010091 Modified getPrimaryChildList() ,this retrieves children if 
*                                                   Plan type is !AFC and the FCC stage is closed or open, initially code did not
*                                                   account for a closed FCC stage for plans other than AFC.
*                        06/12/2009  mxpatel        STGAP00013356: removed changed that were made fore defect #10091   
*                        09/27/2009  arege          STGAP00013356: Child's name should be available in form launch dropdown even if the child has closed FCC
*                                                   but open ADO stage.                         
*                        08/03/2010  bgehlot        SMS# 65400 MR-068 Assigned Judge is now a Drop Down and would remain enabled and 
*                        							Save button displaying even after the FFCP Plan is APRV 
*                        10/11/2011  hnguyen        STGAP00017012: MR-094 Added logic to generate alert to notify case manager and approver 
*                        							that at least one of the
*                                                   principal children does not any current visitation plan.
*                        04/18//2012 caminor		STGAP00018086: User should always have access to child plans that 
*                        							a child has previously been placed on for historical access.  Added logic to retrieve child
*                        							for drop down.
*/

public class RetrieveFCCPFamilyDetailImpl extends BaseServiceImpl implements RetrieveFCCPFamilyDetail {

  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;

  private EventDAO eventDAO = null;

  static final String FCCP_DTL_FORM_NARR = "FCCP_DTL_FORM_NARR";

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private FCCPFamilyDAO fccpFamilyDAO = null;
  
  private StageDAO stageDAO = null;
  
  private OutputLaunchEventLinkDAO outputLaunchEventLinkDAO = null;

  private PersonDAO personDAO = null;

  public FCCPFamilyDetailSO retrieveFCCPFamilyDetail(FCCPFamilyDetailSI fccpFamilyDetailSI) {
    FCCPFamilyDetailSO fccpFamilyDetailSO = new FCCPFamilyDetailSO();
    List<RowPlanPrincipal> fccpStagePrincipalList = new ArrayList<RowPlanPrincipal>();
    List<RowPlanPrincipal> fccpEventPrincipalList = new ArrayList<RowPlanPrincipal>();
    List<RowPlanPrincipal> fccpEventPrincipalFormList;
    List<Integer> eventPrincipalsFormList = new ArrayList<Integer>();
    FccpFamily fccpFamily = null;
    int idCase = fccpFamilyDetailSI.getCaseId();
    int idStage = fccpFamilyDetailSI.getStageId();
    int idEvent = fccpFamilyDetailSI.getEventId();

    // Retrieve all persons in this stage
    List<Map> stagePrincipalList = stagePersonLinkDAO.findAllPrincipalsForStage(CodesTables.CPRSNTYP_PRN, idStage);
    if (stagePrincipalList != null && !stagePrincipalList.isEmpty() && stagePrincipalList.size() != 0) {
      // MR-094 get principal id person list
      List<Integer> idPersonPrns = new ArrayList<Integer>();
      Iterator<Map> iter = stagePrincipalList.iterator();
      // principal list always exists at this point, no need for null check here
      while (iter.hasNext()) {
        Map prn = iter.next();
        
        int idPerson = (Integer) prn.get("ID_PERSON");
        idPersonPrns.add(idPerson);
      }
      // End MR-094

      Iterator itr = stagePrincipalList.iterator();
      while (itr.hasNext()) {
        Map prn = (Map) (itr.next());
        RowPlanPrincipal planPrincipal = fccpFamilyDetailSO.new RowPlanPrincipal();
        planPrincipal.setName((String) prn.get("NM_PERSON_FULL"));
        planPrincipal.setRelationship((String) prn.get("CD_REL_INT"));
        
        int idPerson = (Integer) prn.get("ID_PERSON");
        
        planPrincipal.setIdPerson(idPerson);
        
        // MR-094 See if list of victims has a current visitation plan
        // STGAP00017378: get list of primary child for the current case that are principal in this stage that has open ADO or FCC
        List<Integer> idPrimaryChildList = personDAO.findIdPrimaryChildWithOpenSubAdoFromPrnsList(idCase, idPersonPrns);

        // STGAP00017397 & STGAP00017389: only get current visitation plans for child open ADO & FCC stage
        List<OutputLaunchEventLink> currentVisitationPlanList = outputLaunchEventLinkDAO.findCurrentVisitationPlansForOpenStageByIdPersonByIdCase(idPerson, idCase);

        if(currentVisitationPlanList != null && currentVisitationPlanList.size() > 0){
          planPrincipal.setIndHasCurrentVisitationPlan(true);
        }else{
          // STGAP00017389: if a primary child with an open ADO or FCC and no current visitation plan
          // then we set to false
          if(idPrimaryChildList != null && idPrimaryChildList.contains(new Integer(idPerson))){
            planPrincipal.setIndHasCurrentVisitationPlan(false);
          } else {
            // Not a primary child with an open ADO or FCC and no visitation plan then set to true
            // to bypass validation for this principal
            // STGAP00017389: this could mean principal child
            // is a primary child in case but does not have an open FCC or ADO stage open
            // therefore set indicator to true to bypass validation alert
            planPrincipal.setIndHasCurrentVisitationPlan(true);
          }
        }
        // End MR-094
        
        fccpStagePrincipalList.add(planPrincipal);
      }
    } else {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    if (idEvent != 0) {
      // retrieve all persons relate to the plan
      List<Map> eventPrincipalsList = eventPersonLinkDAO.findPersonsByIdEvent(idEvent);
      if (eventPrincipalsList != null && !eventPrincipalsList.isEmpty() && eventPrincipalsList.size() > 0) {
        Iterator itr = eventPrincipalsList.iterator();
        while (itr.hasNext()) {
          Map prn = (Map) (itr.next());
          RowPlanPrincipal planPrincipal = fccpFamilyDetailSO.new RowPlanPrincipal();
          planPrincipal.setIdPerson((Integer) prn.get("ID_PERSON"));
          eventPrincipalsFormList.add((Integer) prn.get("ID_PERSON"));
          planPrincipal.setName((String) prn.get("NM_PERSON_FULL"));
          planPrincipal.setIsCaregiver((String) prn.get("IND_CAREGIVER")); // this is String value, not boolean
          planPrincipal.setEventPersonLinkDateLastUpdate((Date) (prn.get("DT_LAST_UPDATE")));
          fccpEventPrincipalList.add(planPrincipal);
        }
      }
      Event closureEvent = eventDAO.findEventByStageTypeAndStatus(idStage, CodesTables.CEVNTTYP_CCL,
                                                                  CodesTables.CEVTSTAT_PEND);
      if (closureEvent != null) {
        fccpFamilyDetailSO.setHasStageClosureEvent(true);
      }

      Event fccpEvent = eventDAO.findEventByIdEvent(idEvent);
      if (fccpEvent == null) { // only happens when bad data
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      fccpFamilyDetailSO.setCdEventStatus(fccpEvent.getCdEventStatus());
      fccpFamilyDetailSO.setCdOrigEventStatus(fccpEvent.getCdEventStatus());
      fccpFamilyDetailSO.setCdTask(fccpEvent.getCdTask());
      fccpFamilyDetailSO.setDtEventOccurred(fccpEvent.getDtEventOccurred());
      fccpFamilyDetailSO.setDtEventLastUpdate(fccpEvent.getDtLastUpdate());
      fccpFamilyDetailSO.setTxtEventDesc(fccpEvent.getTxtEventDescr());

      // retrieve foster care case plan family data
      fccpFamily = fccpFamilyDAO.findFCCPFamilyByIdEvent(idEvent);
      if (fccpFamily != null) {
        fccpFamilyDetailSO.setEventId(idEvent);
        fccpFamilyDetailSO.setOldPlanId(idEvent);
        fccpFamilyDetailSO.setSelCrtPlanType(fccpFamily.getCdPlanType());
        //MR-068 If the cdAssgnJudge is null then copy from nmAssgnJudge
        if(!StringHelper.isValid(fccpFamily.getCdAssgnJudge())){
          fccpFamilyDetailSO.setTxtAssnJudge(fccpFamily.getNmAssgnJudge());
        }else{
          fccpFamilyDetailSO.setTxtAssnJudge(fccpFamily.getCdAssgnJudge());
        }
        fccpFamilyDetailSO.setNmAssgnJudge(fccpFamily.getNmAssgnJudge());
        fccpFamilyDetailSO.setRbDatesType(fccpFamily.getIndInitReview());
        fccpFamilyDetailSO.setDtInitDue(fccpFamily.getDtInitDue());
        fccpFamilyDetailSO.setDtOrigSub(fccpFamily.getDtOrigSub());
        fccpFamilyDetailSO.setDtCurReview(fccpFamily.getDtCurrRev());
        fccpFamilyDetailSO.setDtNextReview(fccpFamily.getDtNextReview());
        fccpFamilyDetailSO.setDtPrevReview(fccpFamily.getDtPrevRev());
        fccpFamilyDetailSO.setSelPPP(fccpFamily.getCdPrimPermPlan());
        fccpFamilyDetailSO.setTxtPPPRsns(fccpFamily.getTxtPrimCompRsns());
        fccpFamilyDetailSO.setSelSPP(fccpFamily.getCdSecndPermPlan());
        fccpFamilyDetailSO.setTxtSPPRsns(fccpFamily.getTxtSecndCompRsns());
        fccpFamilyDetailSO.setSelRvwType(fccpFamily.getCdRevTyp());
        fccpFamilyDetailSO.setTxtRsnsChildNotHome(fccpFamily.getTxtRsnsProt());
        fccpFamilyDetailSO.setTxtHarmChildLeftInHome(fccpFamily.getTxtHarm());
        fccpFamilyDetailSO.setDtProjPerm(fccpFamily.getDtPermAchvd());
        fccpFamilyDetailSO.setRbParentPart(fccpFamily.getIndPrntPrtcpt());
        fccpFamilyDetailSO.setRbChildPart(fccpFamily.getIndChildPrtcpt());
        fccpFamilyDetailSO.setTxtNoParentPart(fccpFamily.getTxtPrntPrtcpt());
        fccpFamilyDetailSO.setTxtNoChildPart(fccpFamily.getTxtChildPrtcpt());
        fccpFamilyDetailSO.setCbxParentRefuseSign(fccpFamily.getIndPrntPresent());
        fccpFamilyDetailSO.setRbHearReqSub(fccpFamily.getIndHearingSub());
        fccpFamilyDetailSO.setDtHearReq(fccpFamily.getDtHearingReqstd());
        fccpFamilyDetailSO.setRbHearReqAsst(fccpFamily.getIndAsstnc());
        // AFC
        Date dtBegin = fccpFamily.getDtBeginAftercare();
        Date dtEnd = fccpFamily.getDtEndAftercare();
        fccpFamilyDetailSO.setDtBeginAft(dtBegin);
        fccpFamilyDetailSO.setDtEndAft(dtEnd);
        fccpFamilyDetailSO.setDurationAft(calculateAfcDuration(dtBegin, dtEnd));
        fccpFamilyDetailSO.setTxtTsnDischg(fccpFamily.getTxtRsnDschrgAftercare());

        fccpFamilyDetailSO.setUpdatedPlan(ArchitectureConstants.Y.equals(fccpFamily.getIndUpdatePlan()));
        fccpFamilyDetailSO.setLastUpdate(fccpFamily.getDtLastUpdate());
        fccpFamilyDetailSO.setTxtHearingRequestComments(fccpFamily.getTxtHearingRequestCmnts());
      } else {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }

    fccpFamilyDetailSO.setDtRemoval(cnsrvtrshpRemovalDAO.findEarliestCurrentRemovalDate(idCase));
    fccpEventPrincipalFormList = getPrimaryChildList(idCase, idStage, eventPrincipalsFormList, fccpFamilyDetailSO,
                                                     fccpFamily, idEvent);

    
    
    List<Map> adoptionStageMap = stageDAO.findOpenStagesByIdCaseCdStage(idCase, CodesTables.CSTAGES_ADO);
    
    if(adoptionStageMap!= null && !adoptionStageMap.isEmpty()){
    	/*STGAP00010522: Set indicator to show that an adoption stage exists for this plan*/
    	fccpFamilyDetailSO.setIndHasADOStage(true);
    }
    
    fccpFamilyDetailSO.setCaseId(idCase);
    fccpFamilyDetailSO.setStageId(idStage);
    fccpFamilyDetailSO.setPrincipalsForEvent(fccpEventPrincipalList);
    fccpFamilyDetailSO.setPrincipalsForStage(fccpStagePrincipalList);
    fccpFamilyDetailSO.setPrincipalsForForm(fccpEventPrincipalFormList);
    return fccpFamilyDetailSO;
  }

  // STGAP00009156 added method to pull form narrative
  public byte[] retrieveFCCPForm(FCCPFamilyDetailSI fccpFamilyDetailSI) {
    return fccpFamilyDAO.retrieveFCCPForm(fccpFamilyDetailSI.getStageId(), fccpFamilyDetailSI.getEventId());
  }

  private String calculateAfcDuration(Date dtFrom, Date dtTo) {
    int months = DateUtility.getAgeInMonths(dtFrom, dtTo);
    if (months < 2) {
      return months + " month";
    }
    return months + " months";
  }

  // Get the list of children in care who meet one of the following condition:
  // If FCCP Family permanency plan type is
  // 1) "After care": get the children who were primary children and previously had a SUB and ADO stage
  // 2) "Not after care": get the children who were primary children in either an open ADO or SUB stage for
  // that case
  private List<RowPlanPrincipal> getPrimaryChildList(int idCase, int idStage, Collection<Integer> principalsList,
                                                     FCCPFamilyDetailSO fccpFamilyDetailSO, FccpFamily fccpFamily,
                                                     int idEvent) {
    List<RowPlanPrincipal> fccpEventPrincipalFormList = null;
    List<Person> primaryChildList = null;
    List<Person> primaryChildWithOpenADO = null;
    if (fccpFamily != null) {
      String cdPlanType = fccpFamily.getCdPlanType();
      if (principalsList != null && !principalsList.isEmpty()) {
        // get the list of primary children listed in the plan
        // find the primary children and consider the child as a candidate if for that child a:
        // a) SUB (also known as FCC) stage is open with no ADO (adoption) stage for the same idCase.
        // b) SUB stage is open and ADO stage is open for the same idCase .
        // Return only one person for those 2 scenario not 2.
        // c) SUB stage is open and ADO stage is closed for the same idCase.
        // Return only one person for those 2 scenario not 2.
        primaryChildList = stagePersonLinkDAO
                                             .findStagePersonLinkByIdCaseByIdPersonsByCdStagesByCdPersonRole(
                                                                                                             idCase,
                                                                                                             principalsList,
                                                                                                             CodesTables.CROLES_PC,
                                                                                                             CodesTables.CPRSNTYP_PRN);
        //STGAP00013356: Find out if there exists a PC that has an open ADO stage   
        primaryChildWithOpenADO = stagePersonLinkDAO.findPersonsByIdCaseByIdPersonsByCdPersonRoleByCdStagePersTypeByCdADOStage(idCase,
                                                                                                                   principalsList,
                                                                                                                   CodesTables.CROLES_PC,
                                                                                                                   CodesTables.CPRSNTYP_PRN);
        if (primaryChildWithOpenADO != null && !primaryChildWithOpenADO.isEmpty()) {
          for (Iterator<Person> it = primaryChildWithOpenADO.iterator(); it.hasNext();) {
            Person adoPerson = it.next();
            if (primaryChildList != null && !primaryChildList.contains(adoPerson)) {
              primaryChildList.add(adoPerson);
            }
          }
        }
        
       
        // After care": get the children who were primary children and previously had a closed SUB and ADO stage if
        // an ADO stage existed or just a close SUB stage if no ADO stage existed in that case
        List<Person> primaryChildListSUB = stagePersonLinkDAO
        .findStagePersonLinkClosedByIdCaseByCdPersonRoleByDiffCdStages(
                                                                       idCase,
                                                                       CodesTables.CSTAGES_SUB,
                                                                       CodesTables.CSTAGES_ADO,
                                                                       CodesTables.CROLES_PC,
                                                                       CodesTables.CPRSNTYP_PRN);
        if (primaryChildListSUB != null && !primaryChildListSUB.isEmpty()) {
        //if (CodesTables.CCTPLNTY_AFC.equals(cdPlanType)) {
          //combine the list with no duplicate persons
          primaryChildList = buildPersonList(primaryChildList, primaryChildListSUB, principalsList);
        }

        // build the list of victims for the page
        if (primaryChildList != null && !primaryChildList.isEmpty()) {
          fccpEventPrincipalFormList = new ArrayList<RowPlanPrincipal>();
          for (Iterator<Person> it = primaryChildList.iterator(); it.hasNext();) {
            Person victim = it.next();
            RowPlanPrincipal rowPlanPrincipal = fccpFamilyDetailSO.new RowPlanPrincipal();
            rowPlanPrincipal.setIdPerson(victim.getIdPerson());
            rowPlanPrincipal.setName(getFullName(victim));

            StagePersonLink stagePersonLinkSub;

            String cdStagePersRole = CodesTables.CROLES_PC;
            if (!CodesTables.CCTPLNTY_AFC.equals(cdPlanType)) { // get the open SUB stage for that child
              stagePersonLinkSub = getChildSubStagePersonLink(cdStagePersRole, victim.getIdPerson());
              //STGAP00013356
              if (stagePersonLinkSub == null) {
	              //If FCC stage is closed and there exists an Open ADO stage get closed SUB stage
	              List<Integer> idPersonList = new ArrayList<Integer>();
	              idPersonList.add(victim.getIdPerson());
	              primaryChildWithOpenADO = stagePersonLinkDAO.findPersonsByIdCaseByIdPersonsByCdPersonRoleByCdStagePersTypeByCdADOStage(idCase,
	                                                                                                                         idPersonList,
	                                                                                                                         CodesTables.CROLES_PC,
	                                                                                                                         CodesTables.CPRSNTYP_PRN);
	             if( primaryChildWithOpenADO != null && !primaryChildWithOpenADO.isEmpty()){
	               stagePersonLinkSub = getCloseChildSubStagePersonLink(cdStagePersRole, victim.getIdPerson()); 
	             }else { //STGAP00018086: retrieve closed child for Case plan
	            	 stagePersonLinkSub = getCloseChildSubStagePersonLink(cdStagePersRole, victim.getIdPerson());
	                 if (stagePersonLinkSub == null) {
	                   // STGAP00018086: else get the open SUB stage for that child
	                   stagePersonLinkSub = getChildSubStagePersonLink(cdStagePersRole, victim.getIdPerson());
	                 }
	             }
              }
            } else { // get the closed sub stage first for that child
              stagePersonLinkSub = getCloseChildSubStagePersonLink(cdStagePersRole, victim.getIdPerson());
              if (stagePersonLinkSub == null) {
                // STGAP00005275: else get the open SUB stage for that child
                stagePersonLinkSub = getChildSubStagePersonLink(cdStagePersRole, victim.getIdPerson());
              }
            }
            rowPlanPrincipal.setIdStagePrincipal(stagePersonLinkSub.getStage().getIdStage());
            Date dtLastUpdate = fccpFamilyDAO.findDtLastUpdate(stagePersonLinkSub.getStage().getIdStage(), idEvent);
            if (dtLastUpdate == null) {
              rowPlanPrincipal.setBIndBLOBExistsInDatabase(ArchitectureConstants.N);
            } else {
              rowPlanPrincipal.setBIndBLOBExistsInDatabase(ArchitectureConstants.Y);
              rowPlanPrincipal.setTemplateVersion(fccpFamilyDAO.findFCCPFormVersion(stagePersonLinkSub.getStage()
                                                                                                      .getIdStage(),
                                                                                    idEvent));
            }

            fccpEventPrincipalFormList.add(rowPlanPrincipal);
          }
        }
      }
    }
    return fccpEventPrincipalFormList;
  }

  private String getFullName(Person person) {
    StringBuffer fullName = new StringBuffer();
    if (person != null) {
      fullName.append(person.getNmPersonLast());
      if (person.getNmPersonFirst() != null) {
        fullName.append(", ").append(person.getNmPersonFirst());
      }
      if (person.getNmPersonMiddle() != null) {
        fullName.append(" ").append(person.getNmPersonMiddle());
      }
    }
    return fullName.toString();
  }
  
  //insure that no duplicate person are added
  private List<Person> buildPersonList(List<Person> primaryChildList, List<Person> primaryChildListSUB, Collection<Integer> principalsList) {  
    if (primaryChildListSUB != null && primaryChildListSUB.size() > 0) {
      Iterator<Person> itrSub = primaryChildListSUB.iterator();
      while(itrSub.hasNext()) {
        Person ps = itrSub.next();
        if ((primaryChildList == null || (primaryChildList != null && primaryChildList.contains(ps) == false)) && 
                        (principalsList.contains(ps.getIdPerson()))) {
          primaryChildList.add(ps);
        }
      }
    }
    
    return primaryChildList;
  }

  // get the open sub stage of that child given the FSU stage
  private StagePersonLink getChildSubStagePersonLink(String cdStagePersRole, int idPerson) {
    return stagePersonLinkDAO.findStagePersonLinkByIdStageByCdStageByIdPerson(cdStagePersRole, null, idPerson);
  }

  // get the closed sub stage of that child given the FSU stage
  private StagePersonLink getCloseChildSubStagePersonLink(String cdStagePersRole, int idPerson) {
    return stagePersonLinkDAO.findClosedSUBStagePersonLinkByIdStageByCdStageByIdPerson(cdStagePersRole, idPerson);
  }

  public StagePersonLinkDAO getStagePersonLinkDAO() {
    return stagePersonLinkDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public EventPersonLinkDAO getEventPersonLinkDAO() {
    return eventPersonLinkDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public FCCPFamilyDAO getFccpFamilyDAO() {
    return fccpFamilyDAO;
  }

  public void setFccpFamilyDAO(FCCPFamilyDAO fccpFamilyDAO) {
    this.fccpFamilyDAO = fccpFamilyDAO;
  }

  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO){
	  this.stageDAO = stageDAO;
  }

  public void setOutputLaunchEventLinkDAO(OutputLaunchEventLinkDAO outputLaunchEventLinkDAO) {
    this.outputLaunchEventLinkDAO = outputLaunchEventLinkDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

}
