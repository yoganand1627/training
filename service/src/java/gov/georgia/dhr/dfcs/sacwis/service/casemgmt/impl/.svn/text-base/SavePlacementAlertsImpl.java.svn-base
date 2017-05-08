package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdptSubEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeHomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeHome;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveFadHome;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveSpecializedUnitPersonnel;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SavePlacementAlerts;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecializedUnitPersonalBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FadHomeRetrieveSO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This is the Service that performs the creation of alerts, setting of the Write History indicator and the AFCARS indicator in the placement table on approval of a placement. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User          Description
 *   --------  --------      ------------------------------------------------------------------------------------------------
 *   06/06/08  vdevarak      STGAP00007715 - Modified code to address the two new temporary placement types Respite overdue and concurrent overdue
 *   10/24/08  wjcochran     STGAP00010735 - Added new alerts
 *   12/11/08  charden       STGAP00009536 - rewrote code to get rid of null pointer exceptions resulting from null values in placement object that were
 *                                           being compared to values in latest placement object
 *   12/12/08  charden       STGAP00010273 - took out else if statement so that childUnder3Counter variable will be incremented correctly and 
 *                                           used idChild so that todo will not be incorrectly generated on approval of placement removal
 *   04/13/09  hjbaptiste    STGAP00013247 - modified addPlcmtAdoptiveAlertTodo() to inform SAU/RAC if Adoptive Placement has been entered and 
 *                                           Adoption Assistance Agreement has not been completed.
 *   04/28/09  mxpatel       STGAP00013416 - It is possible to select homes in the placement which have no FAD (no idCase or idStage
 *                                           associate with them.  When we select such homes, we have can not create alerts as 
 *                                           there will be no resource manager attached to the resource. 
 *   06/01/09  hjbaptiste    STGAP00012521 - Call the modified method name called findCompletedAdoptionSubsidiesByIdCaseIdStageIdPerson() of the adptSubEventLinkDAO
 *   07/23/09  hjbaptiste    STGAP00014781 - Modified addPlcmtAdoptiveAlertTodo()to send the alert to SEs, Regional Adoption Exchange Consultants and RACs
 *                                         - Modified addPlcmtEndAdoptiveAlertTodo() to send the alert to SEs, Regional Adoption Exchange Consultants, 
 *                                           Regional Adoption Assistance Consultants and RACs
 *                                         - Modified addPlcmtSiblingAdoptedAlertTodo() to send alert only to Regional Adoption Exchange Consultants
 *                                         - Modified childHasOtherSiblingAdopted() to check for siblings that share a biological parent. Send the alert
 *                                         if the placement is a Foster Care Placement.
 *                                         - Modified addPlcmtInExchangeHomeAlertTodo() to send alert to Regional Adoption Exchange Consultants and RACs
 *                                           and the registered home should be of type 'Foster/Adopt' or 'Adoptive. Do not send alert if the placement is ended 
 *                                         - Removed ICPC alert 
 *  07/31/09  hjbaptiste     STGAP00014926 - Modified childHasOtherSiblingAdopted() to get the ADO stage of the sibling instead of the placed child                                                                                                 
 *  09/21/09  mxpatel        STGAP00015409: added code to make sure not to generate alert when closing the placement
 *  07/26/11  cwells         SMS #116335: ECEM 5.0 Updated size of the MAX_NUM_ATTRIBUTES from 100(hardcoded) 
 *                           to ArchitectureConstants.MAX_NUM_ATTRIBUTES (200) to accommodate database field update 
 *                           and to respond better for future size increase 
 * </pre>
 */

public class SavePlacementAlertsImpl extends BaseServiceImpl implements SavePlacementAlerts {
  // SMS #116335: ECEM 5.0 Updated hardcoded 100 to the constant variable 
  public static final int MAX_NUM_ATTRIBUTES = ArchitectureConstants.MAX_NUM_ATTRIBUTES;

  private static final String PRIMARY_CHILD = CodesTables.CROLES_PC;

  private StageDAO stageDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private PersonDAO personDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  private WorkloadDAO workloadDAO = null;

  private ComplexTodoDAO complexTodoDAO = null;

  private TodoDAO todoDAO = null;

  private CapsResourceDAO capsResourceDAO = null;

  private PlacementDAO placementDAO = null;

  private RetrieveSpecializedUnitPersonnel retrieveSpecializedUnitPersonnel = null;

  private RetrieveFadHome retrieveFadHome = null;

  private ResourceAddressDAO resourceAddressDAO = null;

  private ExchangeHomeDAO exchangeHomeDAO = null;
  
  private AdptSubEventLinkDAO adptSubEventLinkDAO = null;
  
  public void setRetrieveSpecializedUnitPersonnel(RetrieveSpecializedUnitPersonnel retrieveSpecializedUnitPersonnel) {
    this.retrieveSpecializedUnitPersonnel = retrieveSpecializedUnitPersonnel;
  }

  public void setRetrieveFadHome(RetrieveFadHome retrieveFadHome) {
    this.retrieveFadHome = retrieveFadHome;
  }

  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public void setComplexTodoDAO(ComplexTodoDAO complexTodoDAO) {
    this.complexTodoDAO = complexTodoDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }

  public void setExchangeHomeDAO(ExchangeHomeDAO exchangeHomeDAO) {
    this.exchangeHomeDAO = exchangeHomeDAO;
  }
  
  public void setAdptSubEventLinkDAO(AdptSubEventLinkDAO adptSubEventLinkDAO) {
    this.adptSubEventLinkDAO = adptSubEventLinkDAO;
  }
  
  
  public void savePlacementAlerts(int idEvent, String securityAttr) throws ServiceException {

    Placement placement = new Placement();
    placement = placementDAO.findPlacementByIdPlcmtEvent(idEvent);
    int idResource = 0;
    if (placement.getCapsResourceByIdRsrcFacil() != null) {
      idResource = placement.getCapsResourceByIdRsrcFacil().getIdResource();
    }
    CapsResource capsRsrc = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
    // STGAP00006138: Code added to set the AFCARS indicator Begin
    setAFCARSIndicator(placement, idResource, capsRsrc);
    // End
    // STGAP00006067: When an actual end dated placement is being approved then IND_PLCMT_WRITE_HISTORY has to be
    // set to 'Y' so that the trigger writes a record in ADJUSTMENT_REQUEST table
    if (placement != null && CodesTables.CPLCMTAC_A.equals(placement.getCdPlcmtActPlanned())
        && !DateHelper.isNull(placement.getDtPlcmtEnd())) {
      placement.setIndPlcmtWriteHistory(ArchitectureConstants.Y);
    }
    placementDAO.savePlacement(placement);

    // Create alerts
    boolean indLegalCnt = false;
    Date dtPlcmtEnd = placement.getDtPlcmtEnd();
    Date dtPlcmtStart = placement.getDtPlcmtStart();
    Date dtTempYearBorn = null;
    int childAge = 0;
    int idCaseSI = placement.getCapsCase().getIdCase();
    int idEventSI = placement.getEvent().getIdEvent();
    int idPersonSI = placement.getEvent().getPerson().getIdPerson();
    int idStageSI = placement.getEvent().getStage().getIdStage();
    int idWaiver = 0;
    boolean siblingWasAdopted = false;
    int ulIdPrimaryChild = 0;
    String boardingCounty = "";
    if (placement.getCdBoardingCnty() != null) {
      boardingCounty = placement.getCdBoardingCnty();
    }
    String cdPlcmtRemovalRsn = placement.getCdPlcmtRemovalRsn();
    String cdPlcmtType = placement.getCdPlcmtType();
    String cdStageSI = placement.getEvent().getStage().getCdStage();
    String legalCounty = "";
    String nmChild = "";
    String szCdTempPlcmtType = placement.getCdTempType();
    if (placement.getPolicyWaiver() != null) {
      idWaiver = placement.getPolicyWaiver().getIdWvrEvent();
    }
	
	boolean homeRegisteredWithTheExchange = false;	 
    if(idResource != 0){
    	ExchangeHome exchangeHome = exchangeHomeDAO.findCurrentExchangeHomeRegistrationForIdResource(idResource);
    	if (exchangeHome != null) {
    		homeRegisteredWithTheExchange = true;
    	}
    }
    if (idStageSI != 0 && "A".equals(placement.getCdPlcmtActPlanned())) {
      // Get the id of the primary child
        ulIdPrimaryChild = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStageSI, PRIMARY_CHILD)
        .intValue();
        
      if (ulIdPrimaryChild != 0) {
        nmChild = personDAO.findNmFullByIdPerson(ulIdPrimaryChild);
        Person personChild = personDAO.findPersonByIdPerson(ulIdPrimaryChild);
        if (personChild == null || personChild.equals(null)) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        } else {
          dtTempYearBorn = personChild.getDtPersonBirth();
          childAge = DateHelper.getAge(dtTempYearBorn, dtPlcmtStart);
        }

        LegalStatus legalCnty = legalStatusDAO.findCurrentLegalStatusByIdPerson(ulIdPrimaryChild);
        if (legalCnty != null) {
          legalCounty = legalCnty.getCdLegalStatCnty();
        }
      }
      if (!"".equals(boardingCounty) && !legalCounty.equals(boardingCounty) && childAge > 14) {
        indLegalCnt = true;
      }
      if (!"".equals(dtPlcmtStart) && !DateHelper.isNull(dtPlcmtStart)
          && !dtPlcmtStart.equals(DateHelper.MAX_JAVA_DATE)) {
        if (indLegalCnt) {
          // Alert to indicate Approval of placement end when child is over 14 and legal county is not the same
          // as the new county of placement
          addPlcmtStartCountyChangeAlertTodo(idEventSI, idCaseSI, idStageSI, idPersonSI, dtPlcmtStart, nmChild,
                                             securityAttr, legalCounty, boardingCounty);
        }
      }
      if (!"".equals(dtPlcmtEnd) && !DateHelper.isNull(dtPlcmtEnd) && !dtPlcmtEnd.equals(DateHelper.MAX_JAVA_DATE)) {
        if ("RFU".equals(cdPlcmtRemovalRsn)) {
          // Alert to indicate Approval of placement end with reason of Reunification
          addPlcmtReunificationAlertTodo(idEventSI, idCaseSI, idStageSI, idPersonSI, dtPlcmtEnd, nmChild);
        }
        if (indLegalCnt) {
          // Alert to indicate Approval of placement end when child is over 14 and legal county is not the same as the
          // current county of placement
          addPlcmtEndCountyChangeAlertTodo(idEventSI, idCaseSI, idStageSI, idPersonSI, dtPlcmtEnd, nmChild,
                                           securityAttr, legalCounty, boardingCounty);
        }
        if ("ADF".equals(cdPlcmtRemovalRsn)) {
          // add an alert for a placement ending due to an adoption finalized
          addPlcmtAdoptionFinalizedAlertTodo(idResource, idEventSI, idPersonSI, idCaseSI, idStageSI);
        }
      }
      if (!CodesTables.CSTAGES_ADO.equals(cdStageSI)) {
        if (!"".equals(dtPlcmtStart) && !DateHelper.isNull(dtPlcmtStart)
            && !dtPlcmtStart.equals(DateHelper.MAX_JAVA_DATE)) {
          if (!"COR".equals(szCdTempPlcmtType) || !"RED".equals(szCdTempPlcmtType) || !"REN".equals(szCdTempPlcmtType)) {
            // Alert to indicate Approval of new, non adoptive placement
            addPlcmtStartNonAdoptiveAlertTodo(idEventSI, idCaseSI, idStageSI, idPersonSI, dtPlcmtStart, nmChild);

          }

        }
        if (!"".equals(dtPlcmtEnd) && !DateHelper.isNull(dtPlcmtEnd) && !dtPlcmtEnd.equals(DateHelper.MAX_JAVA_DATE)) {
          // Alert to indicate Approval of placement end for any placement besides adoptive placements
          addPlcmtEndNonAdoptiveAlertTodo(idEventSI, idCaseSI, idStageSI, idPersonSI, dtPlcmtEnd, nmChild);
        }

      } else if (CodesTables.CSTAGES_ADO.equals(cdStageSI)) {
        //STGAP00010735: Added a check to ensure Placement Removal Reason is not "Adoption Finalized"
        if (!"".equals(dtPlcmtEnd) && !DateHelper.isNull(dtPlcmtEnd) && !dtPlcmtEnd.equals(DateHelper.MAX_JAVA_DATE) && !"ADF".equals(cdPlcmtRemovalRsn)) {
          // Alert to indicate Approval of the end of an adoptive placement
          addPlcmtEndAdoptiveAlertTodo(idEventSI, idCaseSI, idStageSI, idPersonSI, dtPlcmtEnd, nmChild, securityAttr);

        }
        //mxpatel STGAP00015409: added code to make sure not to generate alert when closing the placement
        if ((!"".equals(dtPlcmtStart) && !DateHelper.isNull(dtPlcmtStart)) && ((DateHelper.isNull(dtPlcmtEnd)))) {
          // Alert to indicate Approval of new adoptive placement
          addPlcmtAdoptiveAlertTodo(idEventSI, idCaseSI, idStageSI, idPersonSI, dtPlcmtStart, ulIdPrimaryChild,
                                    nmChild, securityAttr);
        }
      }

      if (CodesTables.CTMPLTYP_EMG.equals(szCdTempPlcmtType)) {
        // Alert to indicate Creation of a Temporary Emergency placement
        addTempPlcmt30DayAlertTodo(idEventSI, idCaseSI, idStageSI, idPersonSI, dtPlcmtStart, nmChild);
      }
      if (CodesTables.CPLMNTYP_YDC.equals(cdPlcmtType)) {
        // Alert to indicate Creation of placement in YDCorRYDC
        addTempPlcmt150DayAlertTodo(idEventSI, idCaseSI, idStageSI, idPersonSI, dtPlcmtStart, nmChild);
      }
      //STGAP00010273 - sending ulIdPrimaryChild to method to be used in DAO data retrieval
      if (idResource != 0 && checkPlcmtCapacity(idResource, dtPlcmtStart, ulIdPrimaryChild)) {

        if (capsRsrc != null && capsRsrc.getStage() != null && capsRsrc.getStage().getIdStage() != 0) {
          // Alert to indicate A placement is approved which requires a Home waiver (capacity, children under age, etc.)
          int idFaHome = capsRsrc.getStage().getIdStage();
          addPlcmtHomeWaiverAlertTodo(idFaHome, idResource, idEventSI, idCaseSI, idStageSI, idPersonSI, dtPlcmtStart,
                                      dtPlcmtEnd, nmChild);
        }
      }
      if (!"".equals(dtPlcmtEnd) && !DateHelper.isNull(dtPlcmtEnd) && !dtPlcmtEnd.equals(DateHelper.MAX_JAVA_DATE)) {
        // Alert to indicate - A placement is ended, and the system checks to see if any of the children still at the
        // placement resource have siblings in care (additional FCC stages tied to their case)
        addPlcmtAdditionalSibblingsAlertTodo(idResource, idEventSI, idPersonSI, idCaseSI, idStageSI, dtPlcmtStart);
      }

      //STGAP00011305
      if (("".equals(dtPlcmtEnd) || DateHelper.isNull(dtPlcmtEnd) || dtPlcmtEnd.equals(DateHelper.MAX_JAVA_DATE)) && homeRegisteredWithTheExchange){
        // Send the alert if the home is registered with the exchange and is of type Foster/Adoptive (Legal Risk) or Adoptive
        if (CodesTables.CFACATEG_L.equals(capsRsrc.getCdRsrcCategory()) || CodesTables.CFACATEG_A.equals(capsRsrc.getCdRsrcCategory()) ) {
          addPlcmtInExchangeHomeAlertTodo(idResource, idEventSI, idPersonSI, idCaseSI, idStageSI, nmChild);
        }
      }
      
      //STGAP00010893
      if(CodesTables.CSTAGES_SUB.equals(cdStageSI) && childHasOtherSiblingAdopted(idCaseSI, idStageSI, ulIdPrimaryChild)){
    	  addPlcmtSiblingAdoptedAlertTodo(idResource, idEvent, idPersonSI, idCaseSI, idStageSI, nmChild);
      }  
     }
  }

  private void setAFCARSIndicator(Placement placement, int idResource, CapsResource capsRsrc) {
    // Only those Placements for which the AFCARS indicator is set to 'N' are counted for AFCARS
    placement.setIndPlcmtNotApplic("N");
    if (CodesTables.CPLCMTAC_P.equals(placement.getCdPlcmtActPlanned())) {
      // Attempted placements are not counted for AFCARS
      placement.setIndPlcmtNotApplic("Y");
    } else {
      String nmResource = "";
      String cdTempType = "";
      nmResource = placement.getNmPlcmtFacil();
      cdTempType = placement.getCdTempType();
      String rsrcFacilType = "";
      boolean indConcurr = concurrentTypeCheck(cdTempType);
      if (capsRsrc != null) {
        rsrcFacilType = capsRsrc.getCdRsrcType();
      }
      String plcmtType = placement.getCdPlcmtType();
      // If the current Placement Type is Runaway, or Parent, set the AFCARS indicator to 'Y'.
      if (CodesTables.CPLMNTYP_RNA.equals(plcmtType) || CodesTables.CPLMNTYP_PRN.equals(plcmtType)) {
        placement.setIndPlcmtNotApplic("Y");
      }
      // If the temporary placement type is not concurrent or respite and Placement Type is equal to Hospital and the 
      // Resource Type selected for the placement is MHMR Facility
      // or Home/Other Facility set the indicator to 'N'
      else if (!indConcurr && CodesTables.CPLMNTYP_HOS.equals(plcmtType)
               && (CodesTables.CRSCTYPE_05.equals(rsrcFacilType) || CodesTables.CRSCTYPE_06.equals(rsrcFacilType))) {
        placement.setIndPlcmtNotApplic("N");
      }
      // If the rsource selected is provider or if it is null and the resource name is entered manually then set the
      // indicator to 'Y'
      else if (CodesTables.CRSCTYPE_01.equals(rsrcFacilType) || (idResource == 0 && StringHelper.isValid(nmResource))) {
        placement.setIndPlcmtNotApplic("Y");
      }
      // If the placement is temporary of type Concurrent, Respite Day or Respite Night then set the indicator to 'Y'
      else if (indConcurr) {
        placement.setIndPlcmtNotApplic("Y");
      }
      // Get the list of actual approved placements for the given case for the given child
      else {
        List<Placement> lstPlacement = placementDAO
                                                   .findPlacementListByIdCaseByIdPerson(
                                                                                        placement.getCapsCase()
                                                                                                 .getIdCase(),
                                                                                        placement
                                                                                                 .getPersonByIdPlcmtChild()
                                                                                                 .getIdPerson());
        if (lstPlacement != null && lstPlacement.size() > 0) {
          int index = lstPlacement.indexOf(placement);
          if (index >= 0) {
            lstPlacement.remove(placement);
          }
          if (lstPlacement != null && lstPlacement.size() > 0) {
            Placement latestPlcmt = lstPlacement.get(0);
            Placement prevToLatestPlcmt = null;
            if (latestPlcmt != null) {
              String latestPlcmtType = latestPlcmt.getCdPlcmtType() == null ? "" : latestPlcmt.getCdPlcmtType();
              String tempPlcmtType = latestPlcmt.getCdTempType() == null ? "" : latestPlcmt.getCdTempType();
              int idResourceLatestplcmt = latestPlcmt.getCapsResourceByIdRsrcFacil() == null ? 0
                                                                                            : latestPlcmt
                                                                                                         .getCapsResourceByIdRsrcFacil()
                                                                                                         .getIdResource();
              if (lstPlacement.size() > 1) {
                prevToLatestPlcmt = lstPlacement.get(1);
              }
              if (prevToLatestPlcmt != null) {
                int idResourcePrevToLatestPlcmt = prevToLatestPlcmt.getCapsResourceByIdRsrcFacil() == null ? 0
                                                                                                          : prevToLatestPlcmt
                                                                                                                             .getCapsResourceByIdRsrcFacil()
                                                                                                                             .getIdResource();
                //STGAP00007715: If the placement preceeding the current placement is of temp type Respite overdue or concurrent overdue
                //and if the current placement resource is same as the one the child is placed before the Respite overdue or concurrent overdue
                //placement than set the indicator to 'Y'
                if(CodesTables.CTMPLTYP_ROD.equals(tempPlcmtType) || CodesTables.CTMPLTYP_COD.equals(tempPlcmtType)){
                  if (idResource > 0 && idResource == idResourcePrevToLatestPlcmt) {
                    placement.setIndPlcmtNotApplic("Y");
                  }
                }
                if (CodesTables.CPLMNTYP_RNA.equals(latestPlcmtType)
                    || CodesTables.CPLMNTYP_PRN.equals(latestPlcmtType)
                    || (CodesTables.CPLMNTYP_HOS.equals(latestPlcmtType) && ArchitectureConstants.Y
                                                                                                   .equals(latestPlcmt
                                                                                                                      .getIndPlcmtNotApplic()))) {
                  // If the most recent approved placement is of type runaway or parent or (Hospital with Afcars
                  // indicator set to 'Y') and the resource id of the placement prior to that one and the current
                  // placement is same, set the indicator to 'Y'
                  if (idResource > 0 && idResource == idResourcePrevToLatestPlcmt) {
                    placement.setIndPlcmtNotApplic("Y");
                  }
                }
              }
              // If idResource of the current placement and the most recent approved placement is same set the indicator
              // to 'Y'
              if (idResource == idResourceLatestplcmt) {
                placement.setIndPlcmtNotApplic("Y");
              }
              if (ArchitectureConstants.N.equals(placement.getIndPlcmtNotApplic())) {
                ResourceAddress curPlcmtRsrcAddr = resourceAddressDAO.findRsrcAddressByAddressTypeOnly(idResource);
                ResourceAddress ltstPlcmtRsrcAddr = resourceAddressDAO
                                                                      .findRsrcAddressByAddressTypeOnly(idResourceLatestplcmt);
                if (curPlcmtRsrcAddr != null && ltstPlcmtRsrcAddr != null) {
                  //STGAP00009536 - rewrote code to get rid of null pointer exceptions resulting from null values in placement object
                  //being compared to values in latest placement object
                  String emptyString = "";
                  String addrPlcmtCity = placement.getAddrPlcmtCity() == null ? emptyString : placement.getAddrPlcmtCity();
                  String addrPlcmtCnty = placement.getAddrPlcmtCnty() == null ? emptyString : placement.getAddrPlcmtCnty();
                  String addrPlcmtLn1 = placement.getAddrPlcmtLn1() == null ? emptyString : placement.getAddrPlcmtLn1();
                  String addrPlcmtSt = placement.getAddrPlcmtSt() == null ? emptyString : placement.getAddrPlcmtSt();
                  String addrPlcmtZip = placement.getAddrPlcmtZip() == null ? emptyString :placement.getAddrPlcmtZip();
                  
                  String latestAddrPlcmtCity = latestPlcmt.getAddrPlcmtCity() == null ? emptyString : latestPlcmt.getAddrPlcmtCity();
                  String latestAddrPlcmtCnty = latestPlcmt.getAddrPlcmtCnty() == null ? emptyString : latestPlcmt.getAddrPlcmtCnty();
                  String latestAddrPlcmtLn1 = latestPlcmt.getAddrPlcmtLn1() == null ? emptyString : latestPlcmt.getAddrPlcmtLn1();
                  String latestAddrPlcmtSt = latestPlcmt.getAddrPlcmtSt() == null ? emptyString : latestPlcmt.getAddrPlcmtSt();
                  String latestAddrPlcmtZip = latestPlcmt.getAddrPlcmtZip() == null ? emptyString :latestPlcmt.getAddrPlcmtZip();
                  
                  Double curRsrcAddrLat = curPlcmtRsrcAddr.getNbrRsrcAddrLat() == null ? 0.0 : curPlcmtRsrcAddr.getNbrRsrcAddrLat();
                  Double curRsrcAddrlong = curPlcmtRsrcAddr.getNbrRsrcAddrLong() == null ? 0.0 : curPlcmtRsrcAddr.getNbrRsrcAddrLong();
                  Double ltstRsrcAddrLat = ltstPlcmtRsrcAddr.getNbrRsrcAddrLat() == null ? 0.0 : ltstPlcmtRsrcAddr.getNbrRsrcAddrLat();
                  Double ltstRsrcAddrLong = ltstPlcmtRsrcAddr.getNbrRsrcAddrLong() == null ? 0.0 : ltstPlcmtRsrcAddr.getNbrRsrcAddrLong();
                  
                  
                  // If the latitude and longitude or the address city,county,lane,street and zip of the resource address
                  // of the current placement are same as the most recent placment set the indicator to 'Y'
                  if (curRsrcAddrLat != 0.0 && curRsrcAddrlong != 0.0 && curRsrcAddrLat.compareTo(ltstRsrcAddrLat) == 0
                      && curRsrcAddrlong.compareTo(ltstRsrcAddrLong) == 0) {
                    placement.setIndPlcmtNotApplic("Y");
                  } else {
                    if (addrPlcmtCity.equals(latestAddrPlcmtCity)
                        && addrPlcmtCnty.equals(latestAddrPlcmtCnty)
                        && addrPlcmtLn1.equals(latestAddrPlcmtLn1)
                        && addrPlcmtSt.equals(latestAddrPlcmtSt)
                        && addrPlcmtZip.equals(latestAddrPlcmtZip)) {
                      placement.setIndPlcmtNotApplic("Y");
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }


  private Person retrieveUnitSupervisorByCaseManagerId(int idPerson) {

    Map resultMap = unitEmpLinkDAO.findNmPersonFullAndIdPersonByIdPersonAndCdUnitMemberIn(idPerson);
    Integer idSupervisor = null;
    boolean throwError = false;
    if (resultMap != null && resultMap.size() > 0) {
      idSupervisor = (Integer) resultMap.get("idPerson");
      if (idSupervisor == null) {
        throwError = true;
      }
    } else {
      throwError = true;
    }
    if (throwError) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return getPersistentObject(Person.class, idSupervisor);
  }

  private boolean listIsValid(Collection aList) {
    return (aList != null && !aList.isEmpty());
  }

  private void addPlcmtEndNonAdoptiveAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date dtPlcmtEnd,
                                               String nmChild) {
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    List<Integer> secList = workloadDAO.findIdPersonsByIdStageAndCdStagePersRole(idStage, CodesTables.CROLEALL_SE);
    if (listIsValid(secList)) {
      Iterator<Integer> itrSecList = secList.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrSecList.hasNext()) {
        Integer idAssgnd = (Integer) itrSecList.next();
        if (idAssgnd != null) {
          int idAssigned = idAssgnd;
          Todo todo1 = new Todo();
          String cdTask = "";
          Date dateCreated = new Date();
          Date todoDueDate = dtPlcmtEnd;
          String todoDesc = "Placement for " + nmChild + " has been ended ";
          todo1.setEvent(getPersistentObject(Event.class, idEvent));
          todo1.setTxtTodoDesc(todoDesc);
          todo1.setCdTodoTask(cdTask);
          todo1.setCdTodoType(CodesTables.CTODOTYP_A);
          todo1.setDtTodoDue(todoDueDate);
          todo1.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo1.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
          todo1.setDtTodoCreated(dateCreated);
          todo1.setCapsCase(capsCase);
          todo1.setStage(getPersistentObject(Stage.class, idStage));
          todoList.add(todo1);
        }
      }
      complexTodoDAO.saveTodo(todoList);
    }
  }

  private void addPlcmtStartNonAdoptiveAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date dtPlcmtStart,
                                                 String nmChild) {
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    List<Integer> secList = workloadDAO.findIdPersonsByIdStageAndCdStagePersRole(idStage, CodesTables.CROLEALL_SE);
    if (listIsValid(secList)) {
      Iterator<Integer> itrSecList = secList.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrSecList.hasNext()) {
        Integer idAssgnd = (Integer) itrSecList.next();
        if (idAssgnd != null) {
          int idAssigned = idAssgnd;
          Todo todo2 = new Todo();
          String cdTask = "";
          Date dateCreated = new Date();
          Date todoDueDate = dtPlcmtStart;
          String todoDesc = "New Placement for " + nmChild;
          todo2.setEvent(getPersistentObject(Event.class, idEvent));
          todo2.setTxtTodoDesc(todoDesc);
          todo2.setCdTodoTask(cdTask);
          todo2.setCdTodoType(CodesTables.CTODOTYP_A);
          todo2.setDtTodoDue(todoDueDate);
          todo2.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo2.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
          todo2.setDtTodoCreated(dateCreated);
          todo2.setCapsCase(capsCase);
          todo2.setStage(getPersistentObject(Stage.class, idStage));
          todoList.add(todo2);
        }
      }
      complexTodoDAO.saveTodo(todoList);
    }
  }

  private void addPlcmtReunificationAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date dtPlcmtEnd,
                                              String nmChild) {
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    List<Integer> secList = workloadDAO.findIdPersonsByIdStageAndCdStagePersRole(idStage, CodesTables.CROLEALL_SE);
    if (listIsValid(secList)) {
      Iterator<Integer> itrSecList = secList.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrSecList.hasNext()) {
        Integer idAssgnd = (Integer) itrSecList.next();
        if (idAssgnd != null) {
          int idAssigned = idAssgnd;
          Todo todo3 = new Todo();
          String cdTask = "";
          Date dateCreated = new Date();
          Date todoDueDate = dtPlcmtEnd;
          String todoDesc = "Child " + nmChild + "has returned home.Update Eligibility";
          todo3.setEvent(getPersistentObject(Event.class, idEvent));
          todo3.setTxtTodoDesc(todoDesc);
          todo3.setCdTodoTask(cdTask);
          todo3.setCdTodoType(CodesTables.CTODOTYP_A);
          todo3.setDtTodoDue(todoDueDate);
          todo3.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo3.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
          todo3.setDtTodoCreated(dateCreated);
          todo3.setCapsCase(capsCase);
          todo3.setStage(getPersistentObject(Stage.class, idStage));
          todoList.add(todo3);
        }
      }
      complexTodoDAO.saveTodo(todoList);
    }
  }

  private void addPlcmtAdoptiveAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date dtPlcmtStart,
                                         int idPrimaryChild, String nmChild, String securityAttr) {
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    String cdCounty = capsCase.getCdCaseCounty();
    if(cdCounty != null){
      if(cdCounty.length() == 1 ){
        cdCounty = "00" + cdCounty;
      } else if (cdCounty.length() == 2){
        cdCounty = "0" + cdCounty;
      }
    }
    // Get the region of the county
    String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
    List<Integer> adoExchangeList = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);
    List<Integer> secList = workloadDAO.findIdPersonsByIdStageAndCdStagePersRole(idStage, CodesTables.CROLEALL_SE);
    List<Integer> racAuthorizedSauAndSEList = new ArrayList<Integer>();
    if (listIsValid(secList)) {
      racAuthorizedSauAndSEList.addAll(secList);
    }
    if (listIsValid(racList)) {
      racAuthorizedSauAndSEList.addAll(racList);
    }
    if (listIsValid(adoExchangeList)) {
      racAuthorizedSauAndSEList.addAll(adoExchangeList);
    }

    boolean adoAssistanceAgreementExists = true;
    List<Integer> idAgreements = adptSubEventLinkDAO.findCompletedAdoptionSubsidiesByIdCaseIdStageIdPerson(idCase, idStage, idPrimaryChild);
    if (idAgreements == null || idAgreements.size() == 0) {
      adoAssistanceAgreementExists = false;
    }
    if (listIsValid(racAuthorizedSauAndSEList)) {
      Iterator<Integer> itrRacAuthorizedSauAndSEList = racAuthorizedSauAndSEList.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrRacAuthorizedSauAndSEList.hasNext()) {
        Integer idAssgnd = (Integer) itrRacAuthorizedSauAndSEList.next();
        if (idAssgnd != null) {
          int idAssigned = idAssgnd;
          Todo todo4 = new Todo();
          String cdTask = "";
          Date dateCreated = new Date();
          Date todoDueDate = dtPlcmtStart;
          String todoDesc = "Child " + nmChild + " has entered an adoptive placement";
          // let it be known that the placement has been approved and there was no adoption assistance agreement existing
          if (!adoAssistanceAgreementExists){
            todoDesc += " and Adoption Assistance Agreement has not been completed.";
            todo4.setTxtTodoLongDesc(todoDesc);
          }
          todoDesc = StringHelper.truncate(todoDesc, 80);
          todo4.setEvent(getPersistentObject(Event.class, idEvent));
          todo4.setTxtTodoDesc(todoDesc);
          todo4.setCdTodoTask(cdTask);
          todo4.setCdTodoType(CodesTables.CTODOTYP_A);
          todo4.setDtTodoDue(todoDueDate);
          todo4.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo4.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
          todo4.setDtTodoCreated(dateCreated);
          todo4.setCapsCase(capsCase);
          todo4.setStage(getPersistentObject(Stage.class, idStage));
          todoList.add(todo4);
        }
      }
      complexTodoDAO.saveTodo(todoList);
    }
  }

  private void addPlcmtEndAdoptiveAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date dtPlcmtEnd,
                                            String nmChild, String securityAttr) {
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    String cdCounty = capsCase.getCdCaseCounty();
    if(cdCounty != null){
      if(cdCounty.length() == 1 ){
        cdCounty = "00" + cdCounty;
      } else if (cdCounty.length() == 2){
        cdCounty = "0" + cdCounty;
      }
    }
    // Get the region of the county
    String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    // Send the alert to Secondary Workers(SE), RACs, Regional Adoption Assistance Consultants
    // and Regional Adoption Exchange Consultants
    List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
    List<Integer> adoAssistanceList = unitEmpLinkDAO.findSAUAdoptionSpecSupRegionalMembersByIdRegion(cdRegion);
    List<Integer> adoExchangeList = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);
    List<Integer> secList = workloadDAO.findIdPersonsByIdStageAndCdStagePersRole(idStage, CodesTables.CROLEALL_SE);
    List<Integer> racAuthorizedSauAndSEList = new ArrayList<Integer>();
    if (listIsValid(secList)) {
      racAuthorizedSauAndSEList.addAll(secList);
    }
    if (listIsValid(racList)) {
      racAuthorizedSauAndSEList.addAll(racList);
    }
    if (listIsValid(adoAssistanceList)) {
      racAuthorizedSauAndSEList.addAll(adoAssistanceList);
    }
    if (listIsValid(adoExchangeList)) {
      racAuthorizedSauAndSEList.addAll(adoExchangeList);
    }
    
    if (listIsValid(racAuthorizedSauAndSEList)) {
      Iterator<Integer> itrRacAuthorizedSauAndSEList = racAuthorizedSauAndSEList.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrRacAuthorizedSauAndSEList.hasNext()) {
        Integer idAssgnd = (Integer) itrRacAuthorizedSauAndSEList.next();
        if (idAssgnd != null) {
          int idAssigned = idAssgnd;
          Todo todo5 = new Todo();
          String cdTask = "";
          Date dateCreated = new Date();
          Date todoDueDate = dtPlcmtEnd;
          String todoDesc = nmChild + "- Adoption disrupted";
          todo5.setEvent(getPersistentObject(Event.class, idEvent));
          todo5.setTxtTodoDesc(todoDesc);
          todo5.setCdTodoTask(cdTask);
          todo5.setCdTodoType(CodesTables.CTODOTYP_A);
          todo5.setDtTodoDue(todoDueDate);
          todo5.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo5.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
          todo5.setDtTodoCreated(dateCreated);
          todo5.setCapsCase(capsCase);
          todo5.setStage(getPersistentObject(Stage.class, idStage));
          todoList.add(todo5);
        }
      }
      complexTodoDAO.saveTodo(todoList);
    }
  }

  private void addPlcmtStartCountyChangeAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date dtPlcmtStart,
                                                  String nmChild, String securityAttr, String legalCounty,
                                                  String boardingCounty) {
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    boolean isUniqueResult = true;
    SpecializedUnitPersonalBean spUnitPsnlBean = new SpecializedUnitPersonalBean();
    spUnitPsnlBean.setIdStage(idStage);
    spUnitPsnlBean.setCdCounty(legalCounty);
    spUnitPsnlBean.setSecurityAttribute(securityAttr);
    spUnitPsnlBean.setSpecialization(CodesTables.CSPCUNTS_ILP);
    spUnitPsnlBean.setRAC(!isUniqueResult);
    List<Integer> personnelList = new ArrayList<Integer>();
    // retrieve id persons of state Independent Living unit personnel
    List<Integer> sauList1 = retrieveSpecializedUnitPersonnel.retrieveSpecializedUnitPersonnel(spUnitPsnlBean);
    spUnitPsnlBean.setCdCounty(boardingCounty);
    List<Integer> sauList2 = retrieveSpecializedUnitPersonnel.retrieveSpecializedUnitPersonnel(spUnitPsnlBean);

    // create a list of persons to send alert to
    if (listIsValid(sauList1)) {
      personnelList.addAll(sauList1);
    }
    if (listIsValid(sauList2)) {
      for (int i = 0; i < sauList2.size(); i++) {
        if (!personnelList.contains(sauList2.get(i))) {
          personnelList.add(sauList2.get(i));
        }
      }
    }
    if (listIsValid(personnelList)) {
      Iterator<Integer> itrPersonnelList = personnelList.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrPersonnelList.hasNext()) {
        Integer idAssgnd = (Integer) itrPersonnelList.next();
        if (idAssgnd != null) {
          int idAssigned = idAssgnd;
          Todo todo7 = new Todo();
          String cdTask = "";
          Date dateCreated = new Date();
          Date todoDueDate = dtPlcmtStart;
          String todoDesc = "New Placement for child in a boarding county" + nmChild;
          todo7.setEvent(getPersistentObject(Event.class, idEvent));
          todo7.setTxtTodoDesc(todoDesc);
          todo7.setCdTodoTask(cdTask);
          todo7.setCdTodoType(CodesTables.CTODOTYP_A);
          todo7.setDtTodoDue(todoDueDate);
          todo7.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo7.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
          todo7.setDtTodoCreated(dateCreated);
          todo7.setCapsCase(capsCase);
          todo7.setStage(getPersistentObject(Stage.class, idStage));
          todoList.add(todo7);
        }
      }
      complexTodoDAO.saveTodo(todoList);
    }
  }

  private void addPlcmtEndCountyChangeAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date dtPlcmtEnd,
                                                String nmChild, String securityAttr, String legalCounty,
                                                String boardingCounty) {
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    boolean isUniqueResult = true;
    SpecializedUnitPersonalBean spUnitPsnlBean = new SpecializedUnitPersonalBean();
    spUnitPsnlBean.setIdStage(idStage);
    spUnitPsnlBean.setCdCounty("");
    spUnitPsnlBean.setSecurityAttribute(securityAttr);
    spUnitPsnlBean.setSpecialization(CodesTables.CSPCUNTS_ILP);
    spUnitPsnlBean.setRAC(!isUniqueResult);
    List<Integer> personnelList = new ArrayList<Integer>();
    // retrieve id persons of state Independent Living unit personnel
    List<Integer> sauList1 = retrieveSpecializedUnitPersonnel.retrieveSpecializedUnitPersonnel(spUnitPsnlBean);
    spUnitPsnlBean.setCdCounty(boardingCounty);
    List<Integer> sauList2 = retrieveSpecializedUnitPersonnel.retrieveSpecializedUnitPersonnel(spUnitPsnlBean);

    // create a list of persons to send alert to
    if (listIsValid(sauList1)) {
      personnelList.addAll(sauList1);
    }
    if (listIsValid(sauList2)) {
      for (int i = 0; i < sauList2.size(); i++) {
        if (!personnelList.contains(sauList2.get(i))) {
          personnelList.add(sauList2.get(i));
        }
      }
    }
    if (listIsValid(personnelList)) {
      Iterator<Integer> itrPersonnelList = personnelList.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrPersonnelList.hasNext()) {
        Integer idAssgnd = (Integer) itrPersonnelList.next();
        if (idAssgnd != null) {
          int idAssigned = idAssgnd;
          Todo todo8 = new Todo();
          String cdTask = "";
          Date dateCreated = new Date();
          Date todoDueDate = dtPlcmtEnd;
          String todoDesc = "Terminated Placement for child in a boarding county" + nmChild;
          todo8.setEvent(getPersistentObject(Event.class, idEvent));
          todo8.setTxtTodoDesc(todoDesc);
          todo8.setCdTodoTask(cdTask);
          todo8.setCdTodoType(CodesTables.CTODOTYP_A);
          todo8.setDtTodoDue(todoDueDate);
          todo8.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo8.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
          todo8.setDtTodoCreated(dateCreated);
          todo8.setCapsCase(capsCase);
          todo8.setStage(getPersistentObject(Stage.class, idStage));
          todoList.add(todo8);
        }
      }
      complexTodoDAO.saveTodo(todoList);
    }
  }

  private void addTempPlcmt30DayAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date dtPlcmtStart,
                                          String nmChild) {

    List<Integer> secList = new ArrayList<Integer>();
    CapsCase capsCase;
    List<Todo> todoList = new ArrayList<Todo>();
    capsCase = getPersistentObject(CapsCase.class, idCase);
    Integer caseManagerId = workloadDAO.findIdWkldPersonByIdStageAndCdWkldStagePersRole(idStage,
                                                                                        CodesTables.CROLEALL_PR);
    if (caseManagerId != null) {
      secList.add(caseManagerId);
      Person person = retrieveUnitSupervisorByCaseManagerId(caseManagerId);
      if (person != null) {
        secList.add(person.getIdPerson());
      }
    }
    for (int i = 0; i < secList.size() && secList.get(i) != null; i++) {
      int idPerson = (Integer) secList.get(i);
      Todo todo9 = new Todo();
      String cdTask = "";
      Date dateCreated = new Date();
      Date todoDueDate = DateHelper.addToDate(dtPlcmtStart, 0, 0, 25);
      String todoDesc = nmChild + " approaching 30 days in emergency placement";
      todo9.setTxtTodoDesc(todoDesc);
      todo9.setCdTodoTask(cdTask);
      todo9.setCdTodoType(CodesTables.CTODOTYP_A);
      todo9.setDtTodoDue(todoDueDate);
      todo9.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPerson));
      todo9.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
      todo9.setDtTodoCreated(dateCreated);
      todo9.setCapsCase(capsCase);
      todo9.setStage(getPersistentObject(Stage.class, idStage));
      todoList.add(todo9);
    }
    complexTodoDAO.saveTodo(todoList);
  }

  // Alert:- 150 days after placement start date on YDC.
  private void addTempPlcmt150DayAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date dtPlcmtStart,
                                           String nmChild) {

    Integer caseManagerId = workloadDAO.findIdWkldPersonByIdStageAndCdWkldStagePersRole(idStage,
                                                                                        CodesTables.CROLEALL_PR);
    if (caseManagerId != null) {
      Todo todo10 = new Todo();
      CapsCase capsCase;
      capsCase = getPersistentObject(CapsCase.class, idCase);
      String cdTask = "";
      Date dateCreated = new Date();
      Date todoDueDate = DateHelper.addToDate(dtPlcmtStart, 0, 0, 150);
      String todoDesc = "Perform case review for " + nmChild + " in facility";
      todo10.setTxtTodoDesc(todoDesc);
      todo10.setCdTodoTask(cdTask);
      todo10.setCdTodoType(CodesTables.CTODOTYP_A);
      todo10.setDtTodoDue(todoDueDate);
      todo10.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, caseManagerId));
      todo10.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
      todo10.setDtTodoCreated(dateCreated);
      todo10.setCapsCase(capsCase);
      todo10.setStage(getPersistentObject(Stage.class, idStage));
      todoDAO.saveTodo(todo10);
    }
  }

  private void addPlcmtHomeWaiverAlertTodo(int idFaHome, int idResource, int idEvent, int idCase, int idStage,
                                           int idUser, Date dtPlcmtStart, Date dtPlcmtEnd, String nmChild) {
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    List<Integer> personnelList = new ArrayList<Integer>();
    // Getting the Primary worker for the child who is being placed
    Integer caseManagerId = workloadDAO.findIdWkldPersonByIdStageAndCdWkldStagePersRole(idStage,
                                                                                        CodesTables.CROLEALL_PR);
    if (caseManagerId != null) {
      Person person = retrieveUnitSupervisorByCaseManagerId(caseManagerId);
      if (person != null) {
        personnelList.add(person.getIdPerson());
      }
    }
    // Getting the case manager for teh Fa Home where the child is being placed
    FadHomeRetrieveSO fadRetSO = retrieveFadHome.retrieveFadHome(idResource);
    int homeStageId = 0;
    if (fadRetSO != null) {
      homeStageId = fadRetSO.getUlIdStage();
    }
    Integer caseManagerFaHomeId = workloadDAO.findIdWkldPersonByIdStageAndCdWkldStagePersRole(homeStageId,
                                                                                              CodesTables.CROLEALL_PR);
    String cdStatus = CodesTables.CEVTSTAT_APRV;
    String cdActPlanned = "A";
    if (caseManagerFaHomeId != null && !personnelList.contains(caseManagerFaHomeId)) {
      personnelList.add(caseManagerFaHomeId);
    }
    // Getting the stage ids of all the kids that are currently placed in the Fa home where the child is being placed.
    List<Integer> stageIdList = placementDAO.findIdStageByIdRsrcFacil(new Date(), idResource, cdStatus, cdActPlanned);
    if (stageIdList != null) {
      Iterator itStageIdList = stageIdList.iterator();
      while (itStageIdList.hasNext()) {
        Integer stgId = (Integer) itStageIdList.next();
        if (stgId != null) {
          int stageId = stgId;
          // Getting the primary case workers for each stage
          Integer idPrmCsMgrList = workloadDAO.findIdWkldPersonByIdStageAndCdWkldStagePersRole(stageId,
                                                                                               CodesTables.CROLEALL_PR);
          if (idPrmCsMgrList != null && !personnelList.contains(idPrmCsMgrList)) {
            personnelList.add(idPrmCsMgrList);
          }
          // Getting the secondary case workers for each stage
          List<Integer> idSeCsMgrList = workloadDAO.findIdPersonsByIdStageAndCdStagePersRole(stageId,
                                                                                             CodesTables.CROLEALL_SE);
          if (listIsValid(idSeCsMgrList)) {
            for (int i = 0; i < idSeCsMgrList.size(); i++) {
              if (!personnelList.contains(idSeCsMgrList.get(i))) {
                personnelList.add(idSeCsMgrList.get(i));
              }
            }
          }
        }
      }
    }
    if (listIsValid(personnelList)) {
      Iterator<Integer> itrPersonnelList = personnelList.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrPersonnelList.hasNext()) {
        Todo todo11 = new Todo();
        Integer idAssnd = (Integer) itrPersonnelList.next();
        if (idAssnd != null) {
          int idAssigned = idAssnd;
          String cdTask = "";
          Date dateCreated = new Date();
          Date todoDueDate = dtPlcmtStart;
          String todoDesc = "A new placement has made the home IVE ineligible.Update the eligibility summary";
          todo11.setEvent(getPersistentObject(Event.class, idEvent));
          todo11.setTxtTodoDesc(todoDesc);
          todo11.setCdTodoTask(cdTask);
          todo11.setCdTodoType(CodesTables.CTODOTYP_A);
          todo11.setDtTodoDue(todoDueDate);
          todo11.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo11.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
          todo11.setDtTodoCreated(dateCreated);
          todo11.setCapsCase(capsCase);
          todo11.setStage(getPersistentObject(Stage.class, idStage));
          todoList.add(todo11);
        }
      }
      complexTodoDAO.saveTodo(todoList);
    }
  }

  private void addPlcmtAdditionalSibblingsAlertTodo(int idResource, int idEvent, int idUser, int idCase, int idStage,
                                                    Date dtPlcmtStart) {
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    String status = "APRV";
    List<Integer> subStageIdList = new ArrayList<Integer>();
    // Getting the combination of stage and case ids for all the approved placements that are recorded
    // for the given resource id.
    List<Map> caseStageIdList = placementDAO.findIdCaseIdstage(new Date(), idResource, status);
    Iterator<Map> itrCaseStageIdList = caseStageIdList.iterator();
    while (itrCaseStageIdList.hasNext()) {
      Map caseStageId = itrCaseStageIdList.next();
      int caseId = (Integer) caseStageId.get("idCase");
      Integer stageId = (Integer) caseStageId.get("idStage");
      String cdStage = CodesTables.CSTAGES_SUB;
      String indClosure = ArchitectureConstants.N;
      List<Integer> stageIdList = stageDAO.findSubStagesByCaseId(caseId, cdStage, indClosure);
      if (stageIdList != null && stageIdList.contains(stageId)) {
        stageIdList.remove(stageId);
      }
      subStageIdList.addAll(stageIdList);
    }
    List<Integer> caseMgrIdlist = new ArrayList<Integer>();
    Iterator<Integer> itrSubStageIdList = subStageIdList.iterator();
    while (itrSubStageIdList.hasNext()) {
      int fccStageId = itrSubStageIdList.next();
      int caseMgrId = workloadDAO.findIdWkldPersonByIdStageAndCdWkldStagePersRole(fccStageId, CodesTables.CROLEALL_PR);
      if (caseMgrId != 0 && !caseMgrIdlist.contains(caseMgrId)) {
        caseMgrIdlist.add(caseMgrId);
      }
    }
    if (listIsValid(caseMgrIdlist)) {
      Iterator<Integer> itrCaseMgrIdlistt = caseMgrIdlist.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrCaseMgrIdlistt.hasNext()) {
        Todo todo12 = new Todo();
        Integer idAssnd = (Integer) itrCaseMgrIdlistt.next();
        if (idAssnd != null) {
          int idAssigned = idAssnd;
          String cdTask = "";
          Date dateCreated = new Date();
          Date todoDueDate = dtPlcmtStart;
          String todoDesc = "Space available in sibling placement";
          todo12.setEvent(getPersistentObject(Event.class, idEvent));
          todo12.setTxtTodoDesc(todoDesc);
          todo12.setCdTodoTask(cdTask);
          todo12.setCdTodoType(CodesTables.CTODOTYP_A);
          todo12.setDtTodoDue(todoDueDate);
          todo12.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo12.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
          todo12.setDtTodoCreated(dateCreated);
          todo12.setCapsCase(capsCase);
          todo12.setStage(getPersistentObject(Stage.class, idStage));
          todoList.add(todo12);
        }
      }
      complexTodoDAO.saveTodo(todoList);
    }

  }

  private void addPlcmtSiblingAdoptedAlertTodo(int idResource, int idEvent, int idUser, int idCase, int idStage,
                                                    String nmChild) {
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    String cdCounty = capsCase.getCdCaseCounty();
    String cdRegion = "0"+Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    // Only send the alert to the Regional Adoption Exchange Consultants
    List<Integer> adoExchangeList = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);

    if (listIsValid(adoExchangeList)) {
      Iterator<Integer> itrAdoExchangeList = adoExchangeList.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrAdoExchangeList.hasNext()) {
        Todo todo13 = new Todo();
        Integer idAssnd = (Integer) itrAdoExchangeList.next();
        if (idAssnd != null) {
          int idAssigned = idAssnd;
          String cdTask = "";
          Date dateCreated = new Date();
          Date todoDueDate = dateCreated;
          String todoDesc = nmChild + " has a sibling that was adopted.";
          todo13.setEvent(getPersistentObject(Event.class, idEvent));
          todo13.setTxtTodoDesc(todoDesc);
          todo13.setCdTodoTask(cdTask);
          todo13.setCdTodoType(CodesTables.CTODOTYP_A);
          todo13.setDtTodoDue(todoDueDate);
          todo13.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo13.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
          todo13.setDtTodoCreated(dateCreated);
          todo13.setCapsCase(capsCase);
          todo13.setStage(getPersistentObject(Stage.class, idStage));
          todoList.add(todo13);
        }
      }
      complexTodoDAO.saveTodo(todoList);
    }

  }

  private void addPlcmtInExchangeHomeAlertTodo(int idResource, int idEvent, int idUser, int idCase, int idStage,
                                               String nmChild) {
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    String cdCounty = capsCase.getCdCaseCounty();
    String cdRegion = "0"+Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    // Only send the alert to the Regional Adoption Exchange Consultants and RACs
    List<Integer> adoExchangeConsultants = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);
    List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
    List<Integer> racAndAuthorizedSauList = new ArrayList<Integer>();
    if (listIsValid(adoExchangeConsultants)) {
      racAndAuthorizedSauList.addAll(adoExchangeConsultants);
    }
    if (listIsValid(racList)) {
      racAndAuthorizedSauList.addAll(racList);
    }

    if (listIsValid(racAndAuthorizedSauList)) {
      Iterator<Integer> itrRacAndAuthorizedSauList = racAndAuthorizedSauList.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrRacAndAuthorizedSauList.hasNext()) {
        Todo todo14 = new Todo();
        Integer idAssnd = (Integer) itrRacAndAuthorizedSauList.next();
        if (idAssnd != null) {
          int idAssigned = idAssnd;
          String cdTask = "";
          Date dateCreated = new Date();
          Date todoDueDate = dateCreated;
          String todoDesc = nmChild + " has been placed into a home registered with the Exchange.";
          todo14.setEvent(getPersistentObject(Event.class, idEvent));
          todo14.setTxtTodoDesc(todoDesc);
          todo14.setCdTodoTask(cdTask);
          todo14.setCdTodoType(CodesTables.CTODOTYP_A);
          todo14.setDtTodoDue(todoDueDate);
          todo14.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo14.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
          todo14.setDtTodoCreated(dateCreated);
          todo14.setCapsCase(capsCase);
          todo14.setStage(getPersistentObject(Stage.class, idStage));
          todoList.add(todo14);
        }
      }
      complexTodoDAO.saveTodo(todoList);
    }


  }

  private void addPlcmtAdoptionFinalizedAlertTodo(int idResource, int idEvent, int idUser, int idCase, int idStage) {

    List<Integer> secList = new ArrayList<Integer>();
    Stage stage = getPersistentObject(Stage.class, idStage);
    String stageName = stage.getNmStage();

    Integer caseManagerId = workloadDAO.findIdWkldPersonByIdStageAndCdWkldStagePersRole(idStage,
                                                                                        CodesTables.CROLEALL_PR);
    if (caseManagerId != null) {
      secList.add(caseManagerId);
      Person person = retrieveUnitSupervisorByCaseManagerId(caseManagerId);
      if (person != null) {
        secList.add(person.getIdPerson());
      }
    }

    CapsResource capsResource = null;
    int idResourceStage = 0;
    if (idResource != 0) {
      capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
      //STGAP00013416 - It is possible to select homes in the placement which have no FAD (no idCase or idStage
      //associate with them.  When we select such homes, we have can not create the following alerts as 
      //there will be no resource manager attached to the resource.
      if (capsResource.getStage() != null) { 
        idResourceStage = capsResource.getStage().getIdStage();

        StagePersonLink rmSpl = stagePersonLinkDAO
                                                  .findStagePersonLinkByIdStageAndIdPersonAndTypeAndRole(
                                                                                                         idResourceStage,
                                                                                                         CodesTables.CROLEALL_PR,
                                                                                                         CodesTables.CPRSNALL_STF);
        if (rmSpl != null) {
          // add resource manager to secList
          secList.add(rmSpl.getPerson().getIdPerson());
        }

        for (int i = 0; i < secList.size() && secList.get(i) != null; i++) {
          int assignedUserId = secList.get(i);
          Todo todo15 = new Todo();
          String cdTask = "";
          Date dateCreated = new Date();
          String todoDesc = "Adoption Finalized - Please close Foster/Adopt or Adoptive Home within 30 days";
          String longToDoDesc = "Adoption Finalized (child: " + stageName + ") - Please close Foster/Adopt"
                                + " or Adoptive Home (name: " + capsResource.getNmResource() + ")within 30 days";
          todo15.setTxtTodoDesc(todoDesc);
          todo15.setTxtTodoLongDesc(longToDoDesc);
          todo15.setCdTodoTask(cdTask);
          todo15.setCdTodoType(CodesTables.CTODOTYP_A);
          todo15.setDtTodoDue(new Date());
          todo15.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, assignedUserId));
          todo15.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
          todo15.setDtTodoCreated(dateCreated);
          todo15.setCapsCase(capsResource.getCapsCase());
          todo15.setStage(getPersistentObject(Stage.class, idResourceStage));
          todoDAO.saveTodo(todo15);
        }
      }
    }
  }

  private boolean checkPlcmtCapacity(int idResourceSI, Date dtPlcmtStartSI, int ulIdPrimaryChild) {
    // Check to see if the placement exceeds licensed capacity of placement facility.
    int curRsCapacity = 0;
    int maxRsCapacity = 0;
    int childUnder2Counter = 0;
    int childUnder3Counter = 0;
    boolean indDfcs = false;
    CapsResource cResource = (CapsResource) capsResourceDAO.findCapsResourceByIdResourceOnly(idResourceSI);
    if (cResource != null) {
      if (cResource.getNbrRsrcFacilCapacity() != null) {
        maxRsCapacity = cResource.getNbrRsrcFacilCapacity();
      }
      if (CodesTables.CFACTYP4_70.equals(cResource.getCdRsrcFacilType())
          || CodesTables.CFACTYP4_71.equals(cResource.getCdRsrcFacilType())) {
        indDfcs = true;
      }
      String status = CodesTables.CEVTSTAT_APRV;
      //STGAP00010273 - called new method to get correct list of placements
      List<Map> placements = placementDAO.findAprvPlacementsByCapsResourceByIdRsrcFacilByIdPlcmtChild(new Date(), idResourceSI,
                                                                                        status, ulIdPrimaryChild);
      if (placements != null && !placements.isEmpty()) {
        for (Iterator<Map> it = placements.iterator(); it.hasNext();) {
          Map placement = it.next();
          String cdPlcmtType = (String) placement.get("cdPlcmtType") == null ? ""
                                                                            : (String) placement.get("cdPlcmtType");
          int plcmtChildId = (Integer) placement.get("personByIdPlcmtChild") == null ? 0
                                                                                    : (Integer) placement
                                                                                                         .get("personByIdPlcmtChild");
          int plcmtChildAge = -1;
          Date dtYearBorn = null;
          Person child = personDAO.findPersonByIdPerson(plcmtChildId);
          if (child != null) {
            dtYearBorn = child.getDtPersonBirth();
            /* Get child's age as of start date */
            plcmtChildAge = DateHelper.getAge(dtYearBorn, dtPlcmtStartSI);
          }
          curRsCapacity++;
          //STGAP00010273 - took out else if statement so that childUnder3Counter variable will be incremented correctly
          if (indDfcs && !CodesTables.CPLMNTYP_REP.equals(cdPlcmtType) && !CodesTables.CPLMNTYP_RFH.equals(cdPlcmtType)) {
            if (plcmtChildAge >= 0 && plcmtChildAge < 2) {
              childUnder2Counter++;
            }
            if (plcmtChildAge >= 0 && plcmtChildAge < 3) {
              childUnder3Counter++;
            }
          }
        }
      }
    }
    if (maxRsCapacity <= curRsCapacity || childUnder2Counter >= 2 || childUnder3Counter >= 3) {
      return true;
    } else {
      return false;
    }
  }
  
  //STGAP00007715: Added this method to check the temporary placement type
  private boolean concurrentTypeCheck(String cdTempType) {
    return (StringHelper.isValid(cdTempType) && (CodesTables.CTMPLTYP_COR.equals(cdTempType)
                                                 || CodesTables.CTMPLTYP_RED.equals(cdTempType)
                                                 || CodesTables.CTMPLTYP_ROD.equals(cdTempType)
                                                 || CodesTables.CTMPLTYP_COD.equals(cdTempType) || CodesTables.CTMPLTYP_REN
                                                                                                                           .equals(cdTempType)));
  }
  
  private boolean childHasOtherSiblingAdopted(int idCase, int idStage, int primaryChildId) {
    List<Integer> siblingIdList = stagePersonLinkDAO.findAllPrimaryChildIdsForAdoStagesByIdCase(idCase);
    List<String> relationships = new ArrayList<String>();
    relationships.add(CodesTables.CRELVICT_BM);
    relationships.add(CodesTables.CRELVICT_BF);
    relationships.add(CodesTables.CRELVICT_BB);
    // Find all principals that have any of these relationships to this child
    List<Integer> bioParentsForPlacedChild = stagePersonLinkDAO
                                                               .findIdPersonFromStagePersonLinkByIdStageCdStagePersTypeAndRelationships(
                                                                                                                                        idStage,
                                                                                                                                        CodesTables.CPRSNTYP_PRN,
                                                                                                                                        relationships);
    boolean shareCommonBioParent = false;
    if (listIsValid(siblingIdList)) {
      Iterator<Integer> siblingIterator = siblingIdList.iterator();
      while (siblingIterator.hasNext()) {
        int idPerson = siblingIterator.next();
        // Check to see if the sibling is not this child and has a legal status of Not in DFCS Custody - Adoption
        // Finalized
        LegalStatus siblingLegalStatus = legalStatusDAO.findCurrentLegalStatusByIdPerson(idPerson);
        if (idPerson != primaryChildId && siblingLegalStatus != null
            && CodesTables.CLEGSTAT_NAF.equals(siblingLegalStatus.getCdLegalStatStatus())) {
          // Get stage id of the sibling
          int idSiblingStage = (int) stagePersonLinkDAO.findIdStageByIdPersonCdStageIdCase(idPerson, idCase,
                                                                                           CodesTables.CSTAGES_ADO);
          List<Integer> bioParentsForSibling = stagePersonLinkDAO
                                                                 .findIdPersonFromStagePersonLinkByIdStageCdStagePersTypeAndRelationships(
                                                                                                                                          idSiblingStage,
                                                                                                                                          CodesTables.CPRSNTYP_PRN,
                                                                                                                                          relationships);
          if (listIsValid(bioParentsForSibling)) {
            Iterator<Integer> itBioParentsForSibling = bioParentsForSibling.iterator();
            while (itBioParentsForSibling.hasNext() && listIsValid(bioParentsForPlacedChild)) {
              Integer idSiblingPrincipal =  itBioParentsForSibling.next();
              // If there's a principal on the sibling's stage has one of the relationships of a principal
              // on this child's stage then child does have other sibling adopted
              if (bioParentsForPlacedChild.contains(idSiblingPrincipal)) {
                shareCommonBioParent = true;
                break;
              }
            }
          }
        }
        if (shareCommonBioParent) {
          break;
        }
      }
    }
    return shareCommonBioParent;
  }
}
