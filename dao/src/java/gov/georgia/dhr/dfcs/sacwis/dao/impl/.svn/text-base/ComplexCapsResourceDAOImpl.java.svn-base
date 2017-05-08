package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.ContractCounty;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.db.Event;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 *   04/05/2009  cwells            STGAP00013543 Set the resource Name since there is code that may 
 *                                 change the name according to the legal name changing.    
 *   08/10/2009  cwells            STGAP00014709 properly evaluating the minute difference between the date a home is approved 
 *                                 till the date we are trying to close the home.  Positive numbers will result in updating the 
 *                                 status to closed while negative numbers will display MSG_FAD_INVAL_CLOSE_DT                              
 *   03/25/2011  hnguyen           SMS#97850: MR-075 Updated methods to take an extra argument for indHoldPlacements 
 *                                 and also to removed resource status from some methods which are not needed.
 *                                   
 *                                 
 **/
public class ComplexCapsResourceDAOImpl extends BaseDAOImpl implements ComplexCapsResourceDAO {

  private ApproversDAO approversDAO = null;
  private CapsResourceDAO capsResourceDAO = null;
  private CommonDAO commonDAO = null;
  private ContractDAO contractDAO = null;
  private ContractCountyDAO contractCountyDAO = null;
  private ContractPeriodDAO contractPeriodDAO = null;
  private ResourceServiceDAO resourceServiceDAO = null;

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setCommonDAO(CommonDAO commonDAO) {
    this.commonDAO = commonDAO;
  }

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setResourceServiceDAO(ResourceServiceDAO resourceServiceDAO) {
    this.resourceServiceDAO = resourceServiceDAO;
  }

  public int updateCapsResource(int idResource, String cdRsrcFaHomeStatus, String cdRsrcClosureRsn,
                                String cdRsrcInvolClosure, String cdRsrcRecmndReopen, String szTxtStatusRsnComments,
                                int idRsrcFaHomeEvent, String indRsrcWriteHist,
                                Date dtRsrcClose, Date lastUpdate, int idRsrcFaHomeStage, String indHoldPlacements) {
    int nbrRowsUpdated = 0;
    Date newDtRsrcClose = dtRsrcClose;
    Map returnMap = (Map) capsResourceDAO.findRsrcCertAndNonprsByIdResource(idResource);
    Date dtRsrcCert = (Date) returnMap.get("dtRsrcCert");
    String indRsrcNonDfcs = (String) returnMap.get("indRsrcNonDfcs");
    if (CodesTables.CAFCTRSP_Y.equals(indRsrcNonDfcs)) {
      if (CodesTables.CFAHMSTA_AFA.equals(cdRsrcFaHomeStatus) ||
          CodesTables.CFAHMSTA_ASA.equals(cdRsrcFaHomeStatus) ||
          CodesTables.CFAHMSTA_ATA.equals(cdRsrcFaHomeStatus)) {
        dtRsrcCert = new Date(System.currentTimeMillis());
        newDtRsrcClose = null;
      }
      if (CodesTables.CFAHMSTA_CSD.equals(cdRsrcFaHomeStatus)) {
        newDtRsrcClose = new Date(System.currentTimeMillis());
      }
    } else {
      // || CodesTables.CFAHMSTA_020.equals(cdRsrcFaHomeStatus)
      // fa home status of recruit no longer exists
      if (CodesTables.CFAHMSTA_INQ.equals(cdRsrcFaHomeStatus) || 
          CodesTables.CFAHMSTA_APP.equals(cdRsrcFaHomeStatus)) {
        dtRsrcCert = null;
        newDtRsrcClose = null;
      } else {
        if (CodesTables.CFAHMSTA_CSD.equals(cdRsrcFaHomeStatus)) {
          newDtRsrcClose = new Date(System.currentTimeMillis());
        } else {
          newDtRsrcClose = null;
        }
      }
    }
    nbrRowsUpdated = capsResourceDAO.updateCapsResource(idResource, cdRsrcFaHomeStatus, cdRsrcClosureRsn, cdRsrcInvolClosure,
                                                        cdRsrcRecmndReopen, szTxtStatusRsnComments, idRsrcFaHomeEvent, indRsrcWriteHist,
                                                        dtRsrcCert, newDtRsrcClose, lastUpdate, indHoldPlacements);
    
    return nbrRowsUpdated;
  }

  public int updateCapsResource(String nmRsrcResource, boolean sysIndRsrcPrsChg, String cdRsrcEthnicity, String cdRsrcLanguage,
                                String cdRsrcMaritalStatus, String cdRsrcReligion, String cdRsrcRespite,
                                String cdRsrcFacilType, Date dtRsrcMarriage, int idEvent,
                                String indRsrcCareProv, String indRsrcEmergPlace, String indCurrHmStdyExsts,
                                String indRsrcNonDfcs, String ndfcsCertEntity, String cdRsrcFaHomeStatus,
                                String cdRsrcMaintainer, String cdRsrcRegion,
                                String indRsrcTransport, String indRsrcWriteHist, int nbrRsrcAnnualIncome,
                                String indSpecificChild, int nbrRsrcFmAgeMin, int nbrRsrcFmAgeMax,
                                int nbrRsrcIntFeAgeMax, int nbrRsrcIntFeAgeMin, int nbrRsrcIntMaAgeMin,
                                int nbrRsrcIntMaAgeMax, int nbrRsrcMlAgeMin, int nbrRsrcMlAgeMax,
                                String txtRsrcComments, Date dtRsrcCert, int idResource, Date lastUpdate,
                                String indPrevFamStdyRqstd, String cdSchDist, String cdElem,
                                String cdMiddle, String cdHigh, String cdExchangeStat,
                                String indWaiver, String nmLegal, String txtHmPrgInterest) {
    
    int nbrRowsUpdated = 0;
    
    //create new caps resource object and load into memory before 
    //persisting
    CapsResource capsResource = commonDAO.getPersistentObject( CapsResource.class, idResource );
    Event event = commonDAO.getPersistentObject( Event.class, idEvent );
    //  update caps resource object with new values before calling save in the if statements
    
    capsResource.setNmResource( nmRsrcResource ); // STGAP00013543
    capsResource.setCdRsrcLanguage( cdRsrcLanguage );
    capsResource.setCdRsrcMaritalStatus( cdRsrcMaritalStatus );
    capsResource.setCdRsrcReligion( cdRsrcReligion );
    capsResource.setCdRsrcRespite(cdRsrcRespite );
    capsResource.setCdRsrcFacilType(cdRsrcFacilType );
    capsResource.setDtRsrcMarriage( dtRsrcMarriage );
    capsResource.setIndRsrcCareProv( indRsrcCareProv );
    capsResource.setIndRsrcEmergPlace( indRsrcEmergPlace );
    capsResource.setIndCurrHmStdyExsts( indCurrHmStdyExsts );
    capsResource.setIndRsrcNonDfcs( indRsrcNonDfcs );
    capsResource.setNdfcsCertEntity( ndfcsCertEntity );
    capsResource.setCdRsrcFaHomeStatus( cdRsrcFaHomeStatus );
    capsResource.setCdRsrcMaintainer( cdRsrcMaintainer );
    capsResource.setCdRsrcRegion( cdRsrcRegion );
    capsResource.setIndRsrcTransport( indRsrcTransport );
    capsResource.setIndRsrcWriteHist( indRsrcWriteHist );
    capsResource.setNbrRsrcAnnualIncome( nbrRsrcAnnualIncome );
    capsResource.setIndSpecificChild( indSpecificChild );
    capsResource.setNbrRsrcFmAgeMin( nbrRsrcFmAgeMin );
    capsResource.setNbrRsrcFmAgeMax( nbrRsrcFmAgeMax );
    capsResource.setNbrRsrcIntFeAgeMax( nbrRsrcIntFeAgeMax );
    capsResource.setNbrRsrcIntFeAgeMin( nbrRsrcIntFeAgeMin );
    capsResource.setNbrRsrcIntMaAgeMin( nbrRsrcIntMaAgeMin );
    capsResource.setNbrRsrcIntMaAgeMax(nbrRsrcIntMaAgeMax);        
    capsResource.setNbrRsrcMaAgeMin( nbrRsrcMlAgeMin );
    capsResource.setNbrRsrcMaAgeMax( nbrRsrcMlAgeMax );
    capsResource.setTxtRsrcComments( txtRsrcComments );
    capsResource.setDtLastUpdate( lastUpdate );
    capsResource.setIndPrevFamStdyRqstd( indPrevFamStdyRqstd );
    capsResource.setCdSchDist( cdSchDist );
    capsResource.setCdElem( cdElem);
    capsResource.setCdMiddle( cdMiddle );
    capsResource.setCdHigh( cdHigh );
    capsResource.setCdExchangeStat( cdExchangeStat );
    capsResource.setIndWaiver( indWaiver );
    capsResource.setNmLegal(nmLegal);
    capsResource.setEvent( event );
    capsResource.setTxtHmPrgInterest( txtHmPrgInterest);
    if (sysIndRsrcPrsChg) {
      if (CodesTables.CAFCTRSP_Y.equals(indRsrcNonDfcs)) {
        //assign current system date and time to dtRsrcCert and save capsResource object
        dtRsrcCert = new Date();
        capsResource.setDtRsrcCert( dtRsrcCert );
        capsResourceDAO.saveOrUpdateCapsResource( capsResource );
      } else {
        //assign null value to dtRsrcCert and save capsResource object 
        dtRsrcCert = null;
        capsResource.setDtRsrcCert( dtRsrcCert );
        capsResourceDAO.saveOrUpdateCapsResource( capsResource );
      }
    } else {
      //assign null value to dtRsrcCert and save capsResource object 
      dtRsrcCert = null;
      capsResource.setDtRsrcCert( dtRsrcCert );
      //save the capsResource object
      capsResourceDAO.saveOrUpdateCapsResource( capsResource );
    }
    //compare values to see if any updates were performed
    //the values to be compared are fields that should never be null
    CapsResource capsResource2 = commonDAO.getPersistentObject( CapsResource.class, idResource );
    if( StringHelper.checkForEquality(capsResource2.getCdRsrcMaritalStatus(), capsResource.getCdRsrcMaritalStatus())&&
        StringHelper.checkForEquality(capsResource2.getCdRsrcFacilType(), capsResource.getCdRsrcFacilType())&&
        StringHelper.checkForEquality(capsResource2.getIndRsrcNonDfcs(), capsResource.getIndRsrcNonDfcs())&&
        StringHelper.checkForEquality(capsResource2.getNdfcsCertEntity(), capsResource.getNdfcsCertEntity())&&
        StringHelper.checkForEquality(capsResource2.getCdRsrcFaHomeStatus(), capsResource.getCdRsrcFaHomeStatus())&&
        StringHelper.checkForEquality(capsResource2.getCdRsrcMaintainer(), capsResource.getCdRsrcMaintainer())&&
        StringHelper.checkForEquality(capsResource2.getCdRsrcRegion(), capsResource.getCdRsrcRegion())&&
        StringHelper.checkForEquality(capsResource2.getCdRsrcStatus(), capsResource.getCdRsrcStatus())&&
        capsResource2.getNbrRsrcAnnualIncome().equals(capsResource.getNbrRsrcAnnualIncome())&& 
        capsResource2.getEvent().getIdEvent().equals(capsResource.getEvent().getIdEvent())) 
      nbrRowsUpdated++;
    
    return nbrRowsUpdated;
  }

  public int updateCapsResource(String cdRsrcCategory, String cdRsrcFaHomeStatus, String indRsrcWriteHist,
                                int nbrRsrcMaAgeMin, int nbrRsrcMaAgeMax, int nbrRsrcFmAgeMin, int nbrRsrcFmAgeMax,
                                int nbrRsrcFacilCapacity, Integer nbrRsrcOpenSlots, String cdRsrcFaHomeType1,
                                String cdRsrcFaHomeType2, String cdRsrcFaHomeType3, String cdRsrcFaHomeType4,
                                String cdRsrcFaHomeType5, String cdRsrcFaHomeType6, String cdRsrcFaHomeType7,
                                int idEvent, String nmRsrcLastUpdate, String cdRsrcRegion,
                                String cdRsrcInvolClosure, String cdRsrcClosureRsn, String cdRsrcRecmndReopen, int idResource,
                                Date dtLastUpdate, Date approvalBeginDate, Date approvalEndDate,
                                String szTxtStatusRsnComments, Date fosterParentManualDate, Date fosterParentBillDate,
                                String indHoldPlacements){
    int nbrRowsUpdated = 0;
    //create new caps resource object and load into memory before 
    //persisting
    CapsResource capsResource = commonDAO.getPersistentObject( CapsResource.class, idResource );
    Event event = commonDAO.getPersistentObject( Event.class, idEvent );
    //  update caps resource object with new values before calling save in the if statements
    capsResource.setCdRsrcCategory( cdRsrcCategory );
    capsResource.setCdRsrcFaHomeStatus( cdRsrcFaHomeStatus );
    capsResource.setIndRsrcWriteHist(indRsrcWriteHist);
    capsResource.setNbrRsrcMaAgeMin(nbrRsrcMaAgeMin);
    capsResource.setNbrRsrcMaAgeMax(nbrRsrcMaAgeMax);
    capsResource.setNbrRsrcFmAgeMin(nbrRsrcFmAgeMin);
    capsResource.setNbrRsrcFmAgeMax(nbrRsrcFmAgeMax);
    capsResource.setNbrRsrcFacilCapacity(nbrRsrcFacilCapacity);
    capsResource.setNbrRsrcOpenSlots(nbrRsrcOpenSlots);
    capsResource.setCdRsrcFaHomeType1(cdRsrcFaHomeType1);
    capsResource.setCdRsrcFaHomeType2(cdRsrcFaHomeType2);
    capsResource.setCdRsrcFaHomeType3(cdRsrcFaHomeType3);
    capsResource.setCdRsrcFaHomeType4(cdRsrcFaHomeType4);
    capsResource.setCdRsrcFaHomeType5(cdRsrcFaHomeType5);
    capsResource.setCdRsrcFaHomeType6(cdRsrcFaHomeType6);
    capsResource.setNmRsrcLastUpdate(nmRsrcLastUpdate);
    capsResource.setCdRsrcRegion(cdRsrcRegion);
    capsResource.setCdRsrcInvolClosure(cdRsrcInvolClosure);
    capsResource.setCdRsrcClosureRsn(cdRsrcClosureRsn);
    capsResource.setCdRsrcRecmndReopen(cdRsrcRecmndReopen);
    capsResource.setDtLastUpdate(dtLastUpdate);
    capsResource.setDtLicBegin(approvalBeginDate);
    capsResource.setDtLicEnd(approvalEndDate);
    capsResource.setTxtClosureComm(szTxtStatusRsnComments);
    capsResource.setDtFostManual(fosterParentManualDate);
    capsResource.setDtFostBill(fosterParentBillDate);
    capsResource.setEvent(event);
    //MR-075 Update Hold placement indicator.
    capsResource.setIndHoldPlacements(indHoldPlacements);
    //save caps resource
    capsResourceDAO.saveOrUpdateCapsResource( capsResource );
    //get new object to verify if update was made
    //iff update was made increment nbrRowsUpdated
    CapsResource capsResource2 = commonDAO.getPersistentObject( CapsResource.class, idResource );
    if( StringHelper.checkForEquality(capsResource2.getCdRsrcCategory(), capsResource.getCdRsrcCategory())&&
                    StringHelper.checkForEquality(capsResource2.getCdRsrcFaHomeStatus(), capsResource.getCdRsrcFaHomeStatus( ))&&
                    StringHelper.checkForEquality(capsResource2.getIndRsrcWriteHist(), capsResource.getIndRsrcWriteHist())&&
                    StringHelper.checkForEquality(capsResource2.getNmRsrcLastUpdate(), capsResource.getNmRsrcLastUpdate())&&
                    StringHelper.checkForEquality(capsResource2.getCdRsrcStatus(), capsResource.getCdRsrcStatus())&&
                    capsResource2.getNbrRsrcMaAgeMin().equals(capsResource.getNbrRsrcMaAgeMin( ))&&
                    capsResource2.getNbrRsrcMaAgeMax().equals(capsResource.getNbrRsrcMaAgeMax( ))&&
                    capsResource2.getNbrRsrcFmAgeMin().equals(capsResource.getNbrRsrcFmAgeMin( ))&&
                    capsResource2.getNbrRsrcFacilCapacity().equals(capsResource.getNbrRsrcFacilCapacity( ))&&
                    capsResource2.getNbrRsrcOpenSlots().equals(capsResource.getNbrRsrcOpenSlots( ))&&
                    capsResource2.getIndHoldPlacements().equals(capsResource.getIndHoldPlacements( ))&&
                    capsResource2.getEvent().getIdEvent().equals(capsResource.getEvent().getIdEvent( )))
      nbrRowsUpdated++;
      
    return nbrRowsUpdated;
  }
  
  public int updateCapsResource(int idRsrcFaHomeStage, int idApproval, String cdRsrcFaHomeStatus, String cdRsrcStatus,
                                int idRsrcFaHomeEvent, String indRsrcWriteHist, String indHoldPlacements) {

    int nbrRowsUpdated = 0;
    double timeBetween = 0.0;

    Date dtRsrcDate = capsResourceDAO.findDtRsrcCertByIdRsrcFaHomeStage(idRsrcFaHomeStage);

    Date dtApprvDet = approversDAO.findApproversDtApproversDetermination(idApproval);
    
    if(dtRsrcDate != null && dtApprvDet != null) {
      timeBetween = DateHelper.minutesDifference(dtApprvDet, dtRsrcDate);
    }

    if (CodesTables.CFAHMSTA_AFA.equals(cdRsrcFaHomeStatus) ||
        CodesTables.CFAHMSTA_ASA.equals(cdRsrcFaHomeStatus) ||
        CodesTables.CFAHMSTA_AUN.equals(cdRsrcFaHomeStatus) ||
        CodesTables.CFAHMSTA_FLG.equals(cdRsrcFaHomeStatus) ||
        CodesTables.CFAHMSTA_FSG.equals(cdRsrcFaHomeStatus) ||
        CodesTables.CFAHMSTA_ATA.equals(cdRsrcFaHomeStatus)) {
      if (dtRsrcDate == null || (timeBetween < 0.0)) {
        nbrRowsUpdated = capsResourceDAO.updateCapsResourceByCdRsrcFaHomeStatus(cdRsrcFaHomeStatus, cdRsrcStatus,
                                                                                idRsrcFaHomeEvent, indRsrcWriteHist,
                                                                                dtApprvDet, idRsrcFaHomeStage, indHoldPlacements);
      } else {
        nbrRowsUpdated = capsResourceDAO.updateCapsResourceByDtRsrcDate(cdRsrcFaHomeStatus, cdRsrcStatus,
                                                                        idRsrcFaHomeEvent, indRsrcWriteHist,
                                                                        dtRsrcDate, idRsrcFaHomeStage, indHoldPlacements);
      }
    }
    //  STGAP00014709 properly evaluating the minute difference between the date a home is approved 
    //  till the date we are trying to close the home.  Positive numbers will result in updating the 
    //  status to closed while negative numbers will display MSG_FAD_INVAL_CLOSE_DT 
    if (CodesTables.CFAHMSTA_CSD.equals(cdRsrcFaHomeStatus)) {
      if (timeBetween < 0.0) {
        nbrRowsUpdated = 0;
      } else {
        nbrRowsUpdated = capsResourceDAO.updateCapsResourceByDtRsrcClose(cdRsrcFaHomeStatus, cdRsrcStatus,
                                                                         idRsrcFaHomeEvent, indRsrcWriteHist,
                                                                         dtApprvDet, idRsrcFaHomeStage, indHoldPlacements);
      }
    }
    return nbrRowsUpdated;
  }

  public int insertCapsResourceForPrsAndNonPrsHome(String addrRsrcStLn1, String addrRsrcStLn2,
                                                   String addrRsrcCity, String cdRsrcState, String addrRsrcZip,
                                                   String addrRsrcAttn,
                                                   String cdRsrcCnty, String cdRsrcInvolClosure,
                                                   String cdRsrcClosureRsn, String cdRsrcType,
                                                   String cdRsrcCampusType,
                                                   String cdRsrcMaintainer, String cdRsrcSchDist,
                                                   String cdRsrcOwnership,
                                                   String cdRsrcFacilType, String cdRsrcHub, String cdRsrcCertBy,
                                                   String cdRsrcOperBy, String cdRsrcPayment, String cdRsrcCategory,
                                                   String cdRsrcEthnicity, String cdRsrcLanguage,
                                                   String cdRsrcMaritalStatus,
                                                   String cdRsrcRecmndReopen, String cdRsrcRegion,
                                                   String cdRsrcReligion,
                                                   String cdRsrcRespite, String cdRsrcFaHomeStatus,
                                                   String cdRsrcFaHomeType1,
                                                   String cdRsrcFaHomeType2, String cdRsrcFaHomeType3,
                                                   String cdRsrcFaHomeType4,
                                                   String cdRsrcFaHomeType5, String cdRsrcFaHomeType6,
                                                   String cdRsrcFaHomeType7,
                                                   Date dtRsrcMarriage, Date dtRsrcClose,
                                                   Date dtRsrcCert,
                                                   int idRsrcFaHomeStage, int idRsrcFaHomeEvent,
                                                   String indRsrcWriteHist,
                                                   String indRsrcCareProv, String indRsrcEmergPlace,
                                                   String indRsrcInactive,
                                                   String indRsrcTransport, String indCurrHmStdyExsts,
                                                   String indRsrcNonDfcs,
                                                   String ndfcsCertEntity, String nmRsrcLastUpdate, String nmResource,
                                                   String nmRsrcContact, String nbrRsrcPhn,
                                                   String nbrFacilPhoneExtension,
                                                   int nbrRsrcFacilCapacity, int nbrRsrcFacilAcclaim, String nbrRsrcVid,
                                                   int nbrRsrcCampusNbr, String indSpecificChild,
                                                   int nbrRsrcIntFeAgeMax,
                                                   int nbrRsrcIntFeAgeMin, int nbrRsrcIntMaAgeMax,
                                                   int nbrRsrcIntMaAgeMin,
                                                   int nbrRsrcAnnualIncome, int nbrRsrcFMAgeMax, int nbrRsrcFMAgeMin,
                                                   int nbrRsrcMlAgeMax,
                                                   int nbrRsrcMlAgeMin, int nbrRsrcOpenSlots, String txtRsrcAddrCmnts,
                                                   String txtRsrcComments, String indPrevFamStdyRqstd, String cdSchDist,
                                                   String cdElem,
                                                   String cdMiddle, String cdHigh, String cdExchangeStat,
                                                   String indWaiver, String nmLegal, String txtHmPrgInterest,
                                                   String indHoldPlacements) {
    int idResource = commonDAO.getNextval("SEQ_CAPS_RESOURCE");
    if (CodesTables.CAFCTRSP_Y.equals(indRsrcNonDfcs)) {
      // The Unix time is needed for dtRsrcCert
      dtRsrcCert = new Date();
    }
    int nbrRowsInserted = capsResourceDAO.insertCapsResource(addrRsrcStLn1, addrRsrcStLn2,
                                                             addrRsrcCity, cdRsrcState, addrRsrcZip, addrRsrcAttn,
                                                             cdRsrcCnty, cdRsrcInvolClosure, cdRsrcClosureRsn, cdRsrcType, cdRsrcCampusType,
                                                             cdRsrcMaintainer, cdRsrcSchDist, cdRsrcOwnership,
                                                             cdRsrcFacilType, cdRsrcHub, cdRsrcCertBy, cdRsrcOperBy,
                                                             cdRsrcPayment, cdRsrcCategory,
                                                             cdRsrcEthnicity, cdRsrcLanguage, cdRsrcMaritalStatus,
                                                             cdRsrcRecmndReopen, cdRsrcRegion, cdRsrcReligion,
                                                             cdRsrcRespite, cdRsrcFaHomeStatus, cdRsrcFaHomeType1,
                                                             cdRsrcFaHomeType2, cdRsrcFaHomeType3, cdRsrcFaHomeType4,
                                                             cdRsrcFaHomeType5, cdRsrcFaHomeType6,
                                                             dtRsrcMarriage, dtRsrcClose, dtRsrcCert,
                                                             idRsrcFaHomeStage, idRsrcFaHomeEvent, indRsrcWriteHist,
                                                             indRsrcCareProv, indRsrcEmergPlace, indRsrcInactive,
                                                             indRsrcTransport, indCurrHmStdyExsts, indRsrcNonDfcs,
                                                             ndfcsCertEntity, nmRsrcLastUpdate, nmResource,
                                                             nmRsrcContact, nbrRsrcPhn, nbrFacilPhoneExtension,
                                                             nbrRsrcFacilCapacity, nbrRsrcFacilAcclaim, nbrRsrcVid,
                                                             nbrRsrcCampusNbr, indSpecificChild, nbrRsrcIntFeAgeMax,
                                                             nbrRsrcIntFeAgeMin, nbrRsrcIntMaAgeMax, nbrRsrcIntMaAgeMin,
                                                             nbrRsrcAnnualIncome, nbrRsrcFMAgeMax, nbrRsrcFMAgeMin,
                                                             nbrRsrcMlAgeMax,
                                                             nbrRsrcMlAgeMin, nbrRsrcOpenSlots, txtRsrcAddrCmnts,
                                                             txtRsrcComments, idResource, indPrevFamStdyRqstd,
                                                             cdSchDist, cdElem,
                                                             cdMiddle, cdHigh, cdExchangeStat,
                                                             indWaiver, nmLegal, txtHmPrgInterest, indHoldPlacements);
    if (nbrRowsInserted == 0) {
      return 0;
    } else {
      return idResource;
    }
  }

  public int updateCapsResourceForPrsAndNonPrsHome(boolean sysIndRsrcPrsChg, int idResource, String addrRsrcStLn1,
                                                   String addrRsrcStLn2, String addrRsrcCity,
                                                   String cdRsrcState, String addrRsrcZip, String addrRsrcAttn,
                                                   String cdRsrcCnty,
                                                   String cdRsrcInvolClosure, String cdRsrcClosureRsn,
                                                   String cdRsrcType, String cdRsrcCampusType, String cdRsrcMaintainer,
                                                   String cdRsrcSchDist, String cdRsrcOwnership, String cdRsrcFacilType,
                                                   String cdRsrcHub,
                                                   String cdRsrcCertBy, String cdRsrcOperBy, String cdRsrcSetting,
                                                   String cdRsrcPayment,
                                                   String cdRsrcCategory, String cdRsrcEthnicity, String cdRsrcLanguage,
                                                   String cdRsrcMaritalStatus, String cdRsrcRecmndReopen,
                                                   String cdRsrcRegion,
                                                   String cdRsrcReligion, String cdRsrcRespite,
                                                   String cdRsrcFaHomeStatus,
                                                   String cdRsrcFaHomeType1, String cdRsrcFaHomeType2,
                                                   String cdRsrcFaHomeType3,
                                                   String cdRsrcFaHomeType4, String cdRsrcFaHomeType5,
                                                   String cdRsrcFaHomeType6,
                                                   String cdRsrcFaHomeType7, Date dtRsrcMarriage,
                                                   Date dtRsrcClose,
                                                   Date dtRsrcCert, int idRsrcFaHomeStage, int idRsrcFaHomeEvent,
                                                   String indRsrcWriteHist,
                                                   String indRsrcCareProv, String indRsrcEmergPlace,
                                                   String indRsrcInactive,
                                                   String indRsrcTransport, String indCurrHmStdyExsts,
                                                   String indRsrcNonDfcs,
                                                   String ndfcsCertEntity, String nmRsrcLastUpdate, String nmResource,
                                                   String nmRsrcContact, String nbrRsrcPhn,
                                                   String nbrFacilPhoneExtension,
                                                   int nbrRsrcFacilCapacity, int nbrRsrcFacilAcclaim, String nbrRsrcVid,
                                                   int nbrRsrcCampusNbr, String indSpecificChild,
                                                   int nbrRsrcIntFeAgeMax,
                                                   int nbrRsrcIntFeAgeMin, int nbrRsrcIntMaAgeMax,
                                                   int nbrRsrcIntMaAgeMin,
                                                   int nbrRsrcAnnualIncome, int nbrRsrcFmAgeMax, int nbrRsrcFmAgeMin,
                                                   int nbrRsrcMaAgeMax,
                                                   int nbrRsrcMaAgeMin, int nbrRsrcOpenSlots, String txtRsrcAddrCmnts,
                                                   String txtRsrcComments, Date lastUpdate, String indPrevFamStdyRqstd,
                                                   String cdSchDist, String cdElem, String cdMiddle, String cdHigh,
                                                   String cdExchangeStat, String indWaiver, String nmLegal, String txtHmPrgInterest) {

    int nbrRowsUpdated = 0;
    if (sysIndRsrcPrsChg) {
      if (CodesTables.CAFCTRSP_Y.equals(indRsrcNonDfcs)) {
        // The Unix time is needed for dtRsrcCert
        dtRsrcCert = new Date();
      } else {
        dtRsrcCert = null;
      }
    }
    nbrRowsUpdated = capsResourceDAO.updateCapsResource(idResource, addrRsrcStLn1, addrRsrcStLn2,
                                              addrRsrcCity, cdRsrcState, addrRsrcZip, addrRsrcAttn,
                                              cdRsrcCnty, cdRsrcInvolClosure, cdRsrcClosureRsn,
                                              cdRsrcType, cdRsrcCampusType,
                                              cdRsrcMaintainer, cdRsrcSchDist, cdRsrcOwnership,
                                              cdRsrcFacilType, cdRsrcHub, cdRsrcCertBy, cdRsrcOperBy,
                                              cdRsrcSetting, cdRsrcPayment, cdRsrcCategory,
                                              cdRsrcEthnicity, cdRsrcLanguage, cdRsrcMaritalStatus,
                                              cdRsrcRecmndReopen, cdRsrcRegion, cdRsrcReligion,
                                              cdRsrcRespite, cdRsrcFaHomeStatus, cdRsrcFaHomeType1,
                                              cdRsrcFaHomeType2, cdRsrcFaHomeType3, cdRsrcFaHomeType4,
                                              cdRsrcFaHomeType5, cdRsrcFaHomeType6,
                                              dtRsrcMarriage, dtRsrcClose, dtRsrcCert,
                                              idRsrcFaHomeStage, idRsrcFaHomeEvent, indRsrcWriteHist,
                                              indRsrcCareProv, indRsrcEmergPlace, indRsrcInactive,
                                              indRsrcTransport, indCurrHmStdyExsts, indRsrcNonDfcs,
                                              ndfcsCertEntity, nmRsrcLastUpdate, nmResource,
                                              nmRsrcContact, nbrRsrcPhn, nbrFacilPhoneExtension,
                                              nbrRsrcFacilCapacity, nbrRsrcFacilAcclaim, nbrRsrcVid,
                                              nbrRsrcCampusNbr, indSpecificChild, nbrRsrcIntFeAgeMax,
                                              nbrRsrcIntFeAgeMin, nbrRsrcIntMaAgeMax, nbrRsrcIntMaAgeMin,
                                              nbrRsrcAnnualIncome, nbrRsrcFmAgeMax, nbrRsrcFmAgeMin,
                                              nbrRsrcMaAgeMax, nbrRsrcMaAgeMin, nbrRsrcOpenSlots,
                                              txtRsrcAddrCmnts, txtRsrcComments, lastUpdate, indPrevFamStdyRqstd,
                                              cdSchDist, cdElem, cdMiddle, cdHigh, cdExchangeStat, indWaiver,
                                              nmLegal, txtHmPrgInterest);
    
    return nbrRowsUpdated;
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findCountyResource(int idContract, String cdRsrcSvcService, int nbrCncntyPeriod,
                                      int nbrCncntyVersion, int nbrCncntyLineItem, int idResource,
                                      Date dtCncntyEffective, Date dtCncntyEnd) {
    Map<String, Map> countyMap = new HashMap<String, Map>();
    // Get a list of counties for a particular resource and service type.
    List<String> cdRsrcSvcCntys = resourceServiceDAO.findResourceServiceCounties(idResource, cdRsrcSvcService);
    for (Iterator<String> it = cdRsrcSvcCntys.iterator(); it.hasNext();) {
      String cdRsrcSvcCnty = it.next();
      Map<String, String> row = new HashMap<String, String>();
      row.put("cdRsrcSvcCnty", cdRsrcSvcCnty);
      countyMap.put(cdRsrcSvcCnty, row);
    }
    List<ContractCounty> contractCounties =
            contractCountyDAO.findContractCountyIdCountyLastUpdate(idContract, idResource, cdRsrcSvcService,
                                                                   nbrCncntyPeriod, nbrCncntyVersion, nbrCncntyLineItem,
                                                                   dtCncntyEffective, dtCncntyEnd);

    // Loop through the returned counties; if a returned county matches a returned county from the first select,
    //   copy the idCounty from the second select to the idCounty in the first select
    for (Iterator<ContractCounty> it = contractCounties.iterator(); it.hasNext();) {
      ContractCounty contractCounty = it.next();
      Map row = countyMap.get(contractCounty.getCdCncntyCounty());
      if (row != null) {
        row.put("idCncnty", contractCounty.getIdCncnty());
        row.put("dtLastUpdate", contractCounty.getDtLastUpdate());
      }
    }

    // Return only counties that have not been contracted.
    List resultsList = new LinkedList<Map>();
    resultsList.addAll(countyMap.values());
    
    List<String> removes = contractCountyDAO.findContractCountyCncntyCounty(idResource, cdRsrcSvcService,
                                                                            dtCncntyEffective, dtCncntyEnd);
    for (String cdCncntyCounty : removes) {
      //String cdCncntyCounty = it.next();
      if (countyMap.containsKey(cdCncntyCounty)) {
        countyMap.remove(cdCncntyCounty);
        //Map row = countyMap.get(cdCncntyCounty);
        //resultsList.add(row);
      }
    }
    
    //resultsList.addAll(countyMap.values());
    
    return resultsList;
  }
  
  public int updateResourceIndRsrcContracted(int idContract) {
    // find contract associated to the being-modified period and find resource id for that the contract
    Contract contract = contractDAO.findContractIdContract(idContract);
    int idResource = 0;
    if (contract != null && contract.getCapsResource() != null) {
      idResource = contract.getCapsResource().getIdResource();
    } else {
      throw new ServiceException(Messages.SQL_NOT_FOUND); // caught in conversation in bulk
    }
    // find all contracts by that resource
    List<Contract> contractListByIdResource = contractDAO.findContractByIdResource(idResource);
    String contractIsActive = ArchitectureConstants.N;

    // to see of any active contract exists for that resource
    for (Iterator<Contract> itrContractList = contractListByIdResource.iterator(); itrContractList.hasNext();) {
      Contract ctr = itrContractList.next();
      List<ContractPeriod> contractList = contractPeriodDAO.findListOfContractPeriodByIdContract(ctr.getIdContract());
      if (contractList != null && !contractList.isEmpty()) {
        ContractPeriod mostRecentContract = contractList.get(0);
        if (CodesTables.CCONSTAT_ACT.equals(mostRecentContract.getCdCnperStatus())
            && !DateHelper.isBeforeToday(mostRecentContract.getDtCnperClosure())) {
          contractIsActive = ArchitectureConstants.Y;
        }
        CapsResource res = (CapsResource) getSession().load(CapsResource.class, idResource);
        String indRsrcContracted = res.getIndRsrcContracted();
        // only update when there is change in status of indicator or indicator never gets set
        if (!contractIsActive.equals(indRsrcContracted)) {
          if (StringHelper.isTrue(contractIsActive)) {
            capsResourceDAO.updateResourceByIndContractedDtLastUpdate(ArchitectureConstants.Y, res.getDtLastUpdate(),
                                                                      idResource);
          } else {
            capsResourceDAO.updateResourceByIndContractedDtLastUpdate(ArchitectureConstants.N, res.getDtLastUpdate(),
                                                                      idResource);
          }
        }
        // one active contract found for the resource (i.e. resource currently contracted, stop
        if (StringHelper.isTrue(contractIsActive)) {
          return 0;
        }
      }
    }
    return 0;
  }

  public void setContractDAO(ContractDAO contractDAO) {
    this.contractDAO = contractDAO;
  }

  public void setContractPeriodDAO(ContractPeriodDAO contractPeriodDAO) {
    this.contractPeriodDAO = contractPeriodDAO;
  }

  
}