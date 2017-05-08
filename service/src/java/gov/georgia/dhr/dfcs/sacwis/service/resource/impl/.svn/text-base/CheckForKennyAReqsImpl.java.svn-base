package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Ccount;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Crsctype;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.CheckForKennyAReqs;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckForKennyAReqsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CheckForKennyAReqsSO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author corey-khalil.harden
 * 
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   11/20/11  htvo      STGAP00017398: do not save last view date in Copy mode which has id event = 0
 */

public class CheckForKennyAReqsImpl extends BaseServiceImpl implements CheckForKennyAReqs {
  private static final String FAD = "FAD";
  private PlacementDAO placementDAO;
  private LegalStatusDAO legalStatusDAO;
  private CapsResourceDAO capsResourceDAO;
  private ApproversDAO approversDAO;
  private ApprovalEventLinkDAO approvalEventLinkDAO;
  
  
  public ApprovalEventLinkDAO getApprovalEventLinkDAO() {
    return approvalEventLinkDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public ApproversDAO getApproversDAO() {
    return approversDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  /**
   * This method checks to see if the Kenny A. message needs to be thrown (if there are any currently placed 
   * children from Fulton or Dekalb Counties
   */
  public CheckForKennyAReqsSO checkForKennyAReqs(CheckForKennyAReqsSI checkForKennyAReqsSI) {
    // get indicators from SI object
    int idResource = checkForKennyAReqsSI.getIdResource();
    Date placementLogViewDate = checkForKennyAReqsSI.getPlacementLogViewDate();

    // check for presence of indicators to determine which functions to execute
    if(placementLogViewDate != null){
      return saveLastViewPlcmtLogDate(checkForKennyAReqsSI);
    }else if(idResource != 0){
      return updateCertificationData(checkForKennyAReqsSI, idResource);
    }
    return new CheckForKennyAReqsSO();
  }
  
  
  private CheckForKennyAReqsSO saveLastViewPlcmtLogDate(CheckForKennyAReqsSI checkForKennyAReqsSI){
    int idPlcmtEvent = checkForKennyAReqsSI.getIdPlcmtEvent();
    // STGAP00017398: Copy mode has id event = 0
    if (idPlcmtEvent > 0) {
    // save the current date as the last view date for the placement log
    Placement placement = getPersistentObject(Placement.class, idPlcmtEvent);
    placement.setDtLastPlcmtLogView(checkForKennyAReqsSI.getPlacementLogViewDate());
    placementDAO.savePlacement(placement);
    }
    return new CheckForKennyAReqsSO();
  }
  
  private CheckForKennyAReqsSO updateCertificationData(CheckForKennyAReqsSI checkForKennyAReqsSI, int idResource){
    // get data from transport object
    CheckForKennyAReqsSO checkForKennyAReqsSO = new CheckForKennyAReqsSO();
    boolean setKennyA = false;
    int currChild = checkForKennyAReqsSI.getCurrChild();
    int idPlcmtEvent = checkForKennyAReqsSI.getIdPlcmtEvent();
    String eventStatus = checkForKennyAReqsSI.getEventStatus();
    String nmRsrcCert = "";
    Date dtCertSigned = null;
    String indCertSigned = "N";
    Date today = new Date();
    // get the resource and determine whether it is an FA Home or Facility
    CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResc(idResource);
    
    // check to see if resource is a facility or FA Home so we will know whether the placement log link
    // needs to be displayed on the placement information page (only FA Homes and Facilities have placement logs)
    if(capsResource != null){
      // get stage and type to determine if resource is a home or facility
      String resourceType = capsResource.getCdRsrcType();
      Stage resourceStage = capsResource.getStage();
      
      // a resource type of 05 or 06 indicates that the resource is a Facility
      if(resourceType != null && (Crsctype.CRSCTYPE_05.equals(resourceType) || Crsctype.CRSCTYPE_06.equals(resourceType))){
        checkForKennyAReqsSO.setFacility(true);
      }else{
        checkForKennyAReqsSO.setFacility(false);
      }
      
      // the presence of a FAD stage indicates that the resource is an FA Home
      if(resourceStage != null && FAD.equals(resourceStage.getCdStage())){
        checkForKennyAReqsSO.setFAHome(true);
      }else{
        checkForKennyAReqsSO.setFAHome(false);
      }
      
      // check approvals to see if placement has been previously approved. This is necessary since placement events function different
      // than other events in the system. A placement event, when saved, goes immediately into COMP status. When Submitted for
      // approval, a placement event goes into PEND status. Approving the placement places the placement event in APRV status.
      // End dating an approved (APRV status) placement and saving and submitting (u have to save and submit an end date... validations
      // prevent performing a regular save) the page puts the placement back in COMP status until the submittal has been saved which then
      // places the page in PEND. This situation must be accounted for when determining whether to allow the certification section of 
      // the placement information page to be modifiable (or not) and when determining whether to validate the certification data in 
      // the placement custom validation
      boolean isCertificationFrozen = false;
      if(idPlcmtEvent != 0){
        List<Integer> approvalIdList = approvalEventLinkDAO.findIdApprovalEventLinksByIdEvent(idPlcmtEvent);
        if(approvalIdList != null && !approvalIdList.isEmpty()){
          for(Integer idApproval : approvalIdList){
            List<Approvers> approverList = approversDAO.findApproversByIdApprovalReverseChronology(idApproval);
            if(approverList != null && !approverList.isEmpty()){
              Approvers approver = approverList.get(0);
              if(approver != null && approver.getDtApproversDetermination() != null && "APRV".equals(approver.getCdApproversStatus())){
                isCertificationFrozen = true;
                break;
              }
            }
          }
        }
        // set indicator into SO
        checkForKennyAReqsSO.setCertificationFrozen(isCertificationFrozen);
      }
      
    }
    if (currChild != 0) {
      //if this is not a new placement, erase old last view placement log date
      // STGAP00017398: do not update cert data if there has been an APRV
      if(idPlcmtEvent != 0 && !checkForKennyAReqsSO.isCertificationFrozen()){
        // Do not actually clear DB until user save the new resource pullback
        // Uncommented code left for reference until design finalized
        /*if(!"APRV".equals(eventStatus)){
          Date nullDate = new Date();
          nullDate = null;
          placementDAO.updateDtLastPlcmtLogView(nullDate, idPlcmtEvent);
        }
        
        // clear case manager certification data 
        if("COMP".equals(eventStatus)){
          placementDAO.updateCaseMngrCert(idPlcmtEvent, indCertSigned, dtCertSigned, nmRsrcCert); 
        }
        
        // clear supervisor certification data
        if("PEND".equals(eventStatus)){
          placementDAO.updateSupCert(idPlcmtEvent, indCertSigned, dtCertSigned, nmRsrcCert);
        }
        
        Placement placement = placementDAO.findPlacementByIdPlcmtEvent(idPlcmtEvent);
        if(placement != null){
          checkForKennyAReqsSO.setDtLastUpdate(placement.getDtLastUpdate());
        }*/
      }
      
      // find all current placements for resource
      List<Integer> currentPlacements = placementDAO.findApprovedCompIdPlcmtChildByIdRsrcFacil(new Date(), idResource);
      // make sure list is null-safe
      if (currentPlacements == null) {
        currentPlacements = new ArrayList<Integer>();
      }
      // add current child being placed to the list
      currentPlacements.add(currChild);

      // check to see if current child being placed or children currently placed in the resource are from Fulton or Dekalb counties 
      for(Integer idChild : currentPlacements){
        // get legal status of child
        LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idChild);
        
        // check to see if child's current legal county is fulton or dekalb
        if(legalStatus != null && DateHelper.isValidDate(legalStatus.getDtLegalStatStatusDt()) 
                        && (Ccount.CCOUNT_089.equals(legalStatus.getCdLegalStatCnty()) || 
                                        Ccount.CCOUNT_121.equals(legalStatus.getCdLegalStatCnty())) 
                                        && today.compareTo(legalStatus.getDtLegalStatStatusDt()) >= 0){
          
          // set indicator to display message upon page refresh
          setKennyA = true;
          break;
        }
      }
    }
    // set whether any of the children are from Fulton or Dekalb
    checkForKennyAReqsSO.setKennyAReq(setKennyA);
    
    return checkForKennyAReqsSO;
  }
}
