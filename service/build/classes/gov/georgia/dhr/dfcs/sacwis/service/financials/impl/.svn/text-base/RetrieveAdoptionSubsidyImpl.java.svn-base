package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

/**
 * @author
 * 
 * <pre>
 *   Change History:
 *   Date         User                  Description
 *   --------     -------------------   --------------------------------------
 *   04/20/2009   hjbaptiste            STGAP00013331: use the ternary operator to check to see if each 'getNbrxxxxAmt()' method
 *                                      returns a null. If so, set the amount to '0.0'. Added this Change History section   
 *                                      
 *  04/14/2009    bgehlot               STGAP00013779: MR-50 changes       
 *  06/08/2009    bgehlot               STGAP00014143: Adding the null check      
 *  06/09/2009    bgehlot               STGAP00014155: Adding the null check   
 *  06/12/2009    bgehlot               STGAP00014203: For conversion data "Child has never been in permanent custody of DFCS (Non-Incident)" is displaying when it should not display
 *  07/06/2009    bgehlot               STGAP00014563: Basic rate recalculated depending on what's selected on Adoption Application                                                                                    
 *   07/13/2009   bgehlot               STGAP00014680: Calculation redone 
 *  07/14/2009    bgehlot               STGAP00014688: Get the approved date entered by SAU of the latest special needs application  
 *  03/07/2011    htvo                  SMS#97845 MR-074-2 AFCARS: retrieve incident/non-incident status from AA Application associated
 *                                      with the agreement. Remove duplicate code.
 * </pre>
 * 
 */

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoSubsidyRateDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdptSubEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoSubsidyRate;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.ContractCounty;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveAdoptionSubsidy;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01_ARRAY;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RetrieveAdoptionSubsidyImpl extends BaseServiceImpl implements RetrieveAdoptionSubsidy {
  
  private static final int MONTHS = 12; 
  
  private static final int DAYS_IN_YEAR = 365; 
  
  private EventDAO eventDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private PlacementDAO placementDAO = null;

  private ContractCountyDAO contractCountyDAO = null;

  private ContractPeriodDAO contractPeriodDAO = null;

  private AdptSubEventLinkDAO adptSubEventLinkDAO = null;

  private CapsResourceDAO capsResourceDAO = null;

  private ResourceAddressDAO resourceAddressDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO = null;
  
  private AdoSubsidyRateDAO adoSubsidyRateDAO = null;
  
  private ApprovalEventLinkDAO approvalEventLinkDAO = null;
  
  private StageLinkDAO stageLinkDAO = null;

  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;
  
  private StageDAO stageDAO = null;
  
  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setContractPeriodDAO(ContractPeriodDAO contractPeriodDAO) {
    this.contractPeriodDAO = contractPeriodDAO;
  }

  public void setAdptSubEventLinkDAO(AdptSubEventLinkDAO adptSubEventLinkDAO) {
    this.adptSubEventLinkDAO = adptSubEventLinkDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }
  
  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  
  public CFAD39SO retrieveAdoptionSubsidy(CFAD39SI cfad39si) throws ServiceException {

    CFAD39SO cfad39so = new CFAD39SO();
    int ulTempIdResource = 0;
    String szTempCounty = new String();
    int ulSpecialNeedsEvent = 0;

    // Set dtLastUpdate to today's date and time
    // retrieve the current system date
    Calendar cal = Calendar.getInstance();
    Date dtCurrentDate = cal.getTime();
    cfad39so.setDtWCDDtSystemDate(DateHelper.toCastorDate(dtCurrentDate));
    // Added the Special Needs Determination details
    // Begin
    CFAD39SOG00 cfad39sog00 = new CFAD39SOG00();
      
    // Special Needs Determination details End
    if (cfad39si.getUlIdEvent() != 0) {

      // one rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
      Event eventInfo = eventDAO.findEventByIdEvent(cfad39si.getUlIdEvent());

      if (eventInfo == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      } else {
        ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
        rowccmn01uig00.setSzCdEventType(eventInfo.getCdEventType());
        rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(eventInfo.getDtEventOccurred()));
        rowccmn01uig00.setUlIdEvent(eventInfo.getIdEvent() != null ? eventInfo.getIdEvent() : 0);
        rowccmn01uig00.setUlIdStage(eventInfo.getStage().getIdStage() != null ? eventInfo.getStage().getIdStage() : 0);
        rowccmn01uig00.setUlIdPerson(eventInfo.getPerson() != null ? eventInfo.getPerson().getIdPerson() : 0);
        rowccmn01uig00.setSzTxtEventDescr(eventInfo.getTxtEventDescr());
        rowccmn01uig00.setSzCdTask(eventInfo.getCdTask());
        rowccmn01uig00.setSzCdEventStatus(eventInfo.getCdEventStatus());
        rowccmn01uig00.setTsLastUpdate(eventInfo.getDtLastUpdate());
        cfad39so.setROWCCMN01UIG00(rowccmn01uig00);

        // two rc = csec58dQUERYdam(sqlca, pCSEC58DInputRec, pCSEC58DOutputRec);
        Map stagePersonLinkInfo = stagePersonLinkDAO.findStagePersonLinkByIdPerson(cfad39si.getUlIdStage(),
                                                                                   PRIMARY_CHILD);

        if (stagePersonLinkInfo == null || stagePersonLinkInfo.isEmpty()) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        } else {
          cfad39so
                  .setUlIdPerson((Integer) stagePersonLinkInfo.get("idPerson") != null ? (Integer) stagePersonLinkInfo
                                                                                                                      .get("idPerson")
                                                                                      : 0);
          cfad39so.setDtDtPersonBirth(DateHelper.toCastorDate((Date) stagePersonLinkInfo.get("dtPersonBirth")));
          cfad39so
                  .setUlIdCase((Integer) stagePersonLinkInfo.get("idCase") != null ? (Integer) stagePersonLinkInfo
                                                                                                                  .get("idCase")
                                                                                  : 0);
        }
      }
    } // end if (cfad39si.getUlIdEvent() != 0)

    if (cfad39si.getUlIdEvent() == 0) {
      ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
      cfad39so.setROWCCMN01UIG00(rowccmn01uig00);
      ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
      cfad39so.getROWCCMN01UIG00().setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);

      Map stagePersonLinkInfo = stagePersonLinkDAO
                                                  .findStagePersonLinkByIdPerson(cfad39si.getUlIdStage(), PRIMARY_CHILD);

      if (stagePersonLinkInfo == null || stagePersonLinkInfo.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      } else {
        cfad39so
                .setUlIdPerson((Integer) stagePersonLinkInfo.get("idPerson") != null ? (Integer) stagePersonLinkInfo
                                                                                                                    .get("idPerson")
                                                                                    : 0);
        cfad39so.setDtDtPersonBirth(DateHelper.toCastorDate((Date) stagePersonLinkInfo.get("dtPersonBirth")));
        cfad39so
                .setUlIdCase((Integer) stagePersonLinkInfo.get("idCase") != null ? (Integer) stagePersonLinkInfo
                                                                                                                .get("idCase")
                                                                                : 0);
        cfad39so.setBIndStageOpen(ArchitectureConstants.Y);
      }

      // three rc = csec32dQUERYdam(sqlca, pCSEC32DInputRec, pCSEC32DOutputRec);
      Placement placementInfo = placementDAO.findPlacementByIdPlcmtChildAndPlcmtAcctPlanned(cfad39so.getUlIdPerson(),
                                                                                            dtCurrentDate);
      int dateCompareVal = 0;

      if (placementInfo == null) {
        throw new ServiceException(Messages.MSG_ASV_NO_PLCMT);
      } else {
        //STGAP00013779: Set the Placement start date for prepopulation of Agreement start date.
        cfad39sog00.setDtDtPlcmtStart(placementInfo.getDtPlcmtStart());
        if (!DateHelper.isNull(placementInfo.getDtPlcmtEnd())) {
          if (!DateHelper.isBefore(DateHelper.toJavaDate(cfad39so.getDtWCDDtSystemDate()),
                                   placementInfo.getDtPlcmtEnd())) {
            dateCompareVal = 0;
          }
        } else {
          dateCompareVal = TIMEVAR;
        }

        cfad39so.setUlIdPlcmtEvent(placementInfo.getIdPlcmtEvent() != null ? placementInfo.getIdPlcmtEvent() : 0);
        if (placementInfo.getCapsResourceByIdRsrcFacil() != null) {
          cfad39sog00
                     .setUlIdAdptSubPayee(placementInfo.getCapsResourceByIdRsrcFacil().getIdResource() != null ? placementInfo
                                                                                                                              .getCapsResourceByIdRsrcFacil()
                                                                                                                              .getIdResource()
                                                                                                              : 0);
          ulTempIdResource = placementInfo.getCapsResourceByIdRsrcFacil().getIdResource();
        }
        int idResource = 0;
        int idPerson = 0;
        if (placementInfo.getCapsResourceByIdRsrcFacil() != null) {
          idResource = placementInfo.getCapsResourceByIdRsrcFacil().getIdResource();
        }
        if (placementInfo.getPersonByIdPlcmtAdult() != null) {
          idPerson = placementInfo.getPersonByIdPlcmtAdult().getIdPerson();
        }
        if (idResource != 0 && dateCompareVal >= 0) {
          throw new ServiceException(Messages.MSG_ASV_NO_PLCMT);
        } else if ((idResource == 0) && (idPerson != 0)) {
          throw new ServiceException(Messages.MSG_ASV_NO_RESOURCE);
        } else {
          int capsResource = cfad39sog00.getUlIdAdptSubPayee();
          String cdCncntyCounty = placementInfo.getAddrPlcmtCnty();
          // dtCurrentDate
          // four rc = csec60dQUERYdam(sqlca, pCSEC60DInputRec, pCSEC60DOutputRec);
          // String cdService = cfad39si.get
          ContractCounty contractCountyInfo = contractCountyDAO
                                                               .findContractCountyForAdoptionSubsidy(
                                                                                                     capsResource,
                                                                                                     cdCncntyCounty,
                                                                                                     dtCurrentDate,
                                                                                                     lookupAdoptionServices());
          if (contractCountyInfo == null) {
            throw new ServiceException(Messages.MSG_ASV_NO_ASV_CONTRACT);
          } else {
            int idContract = contractCountyInfo.getContract().getIdContract();
            int nbrCncntyPeriod = contractCountyInfo.getNbrCncntyPeriod();
            cfad39so.setUlIdContract(idContract);
            // five rc = csec11dQUERYdam(sqlca, pCSEC11DInputRec, pCSEC11DOutputRec);
            ContractPeriod contractPeriodInfo1 = contractPeriodDAO.findContractPeriodAndContract(idContract,
                                                                                                 nbrCncntyPeriod);

            if (contractPeriodInfo1 == null) {
              throw new ServiceException(Messages.MSG_ASV_NO_ACT_CNRCT);
            } else {
              if (DateHelper.isBefore(contractPeriodInfo1.getDtCnperTerm(),
                                      DateHelper.toJavaDate(cfad39so.getDtWCDDtSystemDate()))) {
                throw new ServiceException(Messages.MSG_ASV_NO_CONTRACT);
              } else {
                nbrCncntyPeriod = 1;
                // six rc = csec12dQUERYdam(sqlca, pCSEC12DInputRec, pCSEC12DOutputRec);
                ContractPeriod contractPeriodInfo2 = contractPeriodDAO
                                                                      .findContractPeriodWithIdContractAndNbrCnperPeriod(
                                                                                                                         idContract,
                                                                                                                         nbrCncntyPeriod);

                if (contractPeriodInfo2 == null) {
                  throw new ServiceException(Messages.MSG_ASV_NO_ACT_CNRCT);
                } else {
                  cfad39so.setDtDtCnperStart(DateHelper.toCastorDate(contractPeriodInfo2.getDtCnperStart()));
                  // seven rc = cmsc42dQUERYdam(sqlca, pCMSC42DInputRec, pCMSC42DOutputRec);
                  Date dtCnperTerm = contractPeriodDAO.findDtCnperTermByMaxNbrCnperPeriod(idContract);

                  if (dtCnperTerm == null) {
                    throw new ServiceException(Messages.SQL_NOT_FOUND);
                  } else {
                    cfad39so.setDtDtCnperTerm(DateHelper.toCastorDate(dtCnperTerm));
                  }
                } // else (contractPeriodInfo2 != null)
              } // end else ALTERNATIVE to (DateHelper.isAfter
            } // end else (contractPeriodInfo1 != null)
          } // end else (contractCountyInfo != null)
        } // end else ALTERNATIVE to if ((placementInfo.getCapsResourceByIdRsrcFacil().getIdResource()
        cfad39so.setCFAD39SOG00(cfad39sog00);
      } // end else (placementInfo != null)
    } // end if (cfad39si.getUlIdEvent() == 0)
    else {
      // eight rc = cses64dQUERYdam(sqlca, pxCSES64DInputRec, pCSES64DOutputRec);
      Map adptSubEventLinkInfo = adptSubEventLinkDAO.findAdptSubEventLink(cfad39si.getUlIdEvent());

      if (adptSubEventLinkInfo == null || adptSubEventLinkInfo.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      } else {

        cfad39so
                .setUlIdPlcmtEvent((Integer) adptSubEventLinkInfo.get("idPlcmtEvent") != null ? (Integer) adptSubEventLinkInfo
                                                                                                                              .get("idPlcmtEvent")
                                                                                             : 0);
        cfad39sog00
                   .setUlIdAdptSub((Integer) adptSubEventLinkInfo.get("idAdptSub") != null ? (Integer) adptSubEventLinkInfo
                                                                                                                           .get("idAdptSub")
                                                                                          : 0);
        Date dtAdptSubAgreeRetn = (Date) adptSubEventLinkInfo.get("dtAdptSubAgreeRetn");
        cfad39sog00.setDtDtAdptSubAgreeRetn(DateHelper.toCastorDate(dtAdptSubAgreeRetn));
        cfad39sog00
                   .setUlIdAdptSubPayee((Integer) adptSubEventLinkInfo.get("idResource") != null ? (Integer) adptSubEventLinkInfo
                                                                                                                                       .get("idResource")
                                                                                                      : 0);
        Date dtAdptSubAgreeSent = (Date) adptSubEventLinkInfo.get("dtAdptSubAgreeSent");
        cfad39sog00.setDtDtAdptSubAgreeSent(DateHelper.toCastorDate(dtAdptSubAgreeSent));
        Date dtAdptSubAppReturned = (Date) adptSubEventLinkInfo.get("dtAdptSubAppReturned");
        cfad39sog00.setDtDtAdptSubAppReturned(DateHelper.toCastorDate(dtAdptSubAppReturned));
        Date dtAdptSubAppSent = (Date) adptSubEventLinkInfo.get("dtAdptSubAppSent");
        cfad39sog00.setDtDtAdptSubAppSent(DateHelper.toCastorDate(dtAdptSubAppSent));
        Date dtAdptSubApprvd = (Date) adptSubEventLinkInfo.get("dtAdptSubApprvd");
        cfad39sog00.setDtDtAdptSubApprvd(DateHelper.toCastorDate(dtAdptSubApprvd));
        Date dtAdptSubEffective = (Date) adptSubEventLinkInfo.get("dtAdptSubEffective");
        cfad39sog00.setDtDtAdptSubEffective(DateHelper.toCastorDate(dtAdptSubEffective));
        Date dtAdptSubEnd = (Date) adptSubEventLinkInfo.get("dtAdptSubEnd");
        cfad39sog00.setDtDtAdptSubEnd(DateHelper.toCastorDate(dtAdptSubEnd));
        cfad39sog00.setSAmtAdptSub((Double) adptSubEventLinkInfo.get("amtAdptSub"));
        cfad39sog00.setSzTxtAdptSubRsn((String) adptSubEventLinkInfo.get("txtAdptSubRsn"));
        cfad39sog00.setSzCdAdptSubCloseRsn((String) adptSubEventLinkInfo.get("cdAdptSubCloseRsn"));
        cfad39sog00.setCIndAdptSubThirdParty((String) adptSubEventLinkInfo.get("indAdptSubThirdParty"));
        cfad39sog00.setCIndAdptSubProcess((String) adptSubEventLinkInfo.get("indAdptSubProcess"));
        cfad39sog00.setSzCdAdptSubDeterm((String) adptSubEventLinkInfo.get("cdAdptSubDeterm"));
        Date dtLastUpdate = (Date) adptSubEventLinkInfo.get("dtLastUpdate");
        cfad39sog00.setTsLastUpdate(dtLastUpdate);
        Date dtAdptSubLastInvc = (Date) adptSubEventLinkInfo.get("dtAdptSubLastInvc");
        cfad39sog00.setDtDtAdptSubLastInvc(DateHelper.toCastorDate(dtAdptSubLastInvc));
        Date dtRenwlEffBegin = (Date) adptSubEventLinkInfo.get("dtRenwlEffBegin");
        cfad39sog00.setDtDtRenwlEffBegin(DateHelper.toCastorDate(dtRenwlEffBegin));
        Date dtRenwlEffEnd = (Date) adptSubEventLinkInfo.get("dtRenwlEffEnd");
        cfad39sog00.setDtDtRenwlEffEnd(DateHelper.toCastorDate(dtRenwlEffEnd));
        cfad39sog00.setSAmtSpclAsstReq((Double) adptSubEventLinkInfo.get("amtSpclAsstReq"));
        cfad39sog00.setSzTxtSpclAsstCmnts((String) adptSubEventLinkInfo.get("txtSpclAsstCmnts"));
        cfad39sog00.setSzCdSpclAsstType((String) adptSubEventLinkInfo.get("cdSpclAsstType"));
        cfad39sog00.setSzTxtSpclAsstSpecify((String) adptSubEventLinkInfo.get("txtSpclAsstSpecify"));
        cfad39sog00.setCIndSauConf((String) adptSubEventLinkInfo.get("indSauConf"));
        cfad39sog00.setCIndSpclAsstApprvl((String) adptSubEventLinkInfo.get("indSpclAsstApprv"));
        Date dtAdptSubTerm = (Date) adptSubEventLinkInfo.get("dtAdptSubTerminated");
        cfad39sog00.setDtDtAdptSubTerm(DateHelper.toCastorDate(dtAdptSubTerm));
        cfad39sog00.setCIndSchoolVerified((String) adptSubEventLinkInfo.get("indSchoolVer"));
        cfad39sog00.setSzCdPlaymentMthd((String) adptSubEventLinkInfo.get("cdPaymentMthd"));
        cfad39sog00.setSzCdAllNonIncidentSSA((String) adptSubEventLinkInfo.get("indNonIncSSA"));
        cfad39sog00.setSzCdEventStatus((String) adptSubEventLinkInfo.get("cdEventStatus"));
        ulSpecialNeedsEvent = (Integer) adptSubEventLinkInfo.get("idSpecialNeedsDetermination") != null ? (Integer) adptSubEventLinkInfo
                                                                                                       .get("idSpecialNeedsDetermination")
                                                                                                       : 0;
        cfad39sog00.setUlIdSpecialNeedsEvent((ulSpecialNeedsEvent));
        // nine rc = cses37dQUERYdam(sqlca, pCSES37DInputRec, pCSES37DOutputRec);
        //STGAP00014143: Adding the null check
        Placement placementInfo = placementDAO.findPlacementByIdPlcmtEvent((Integer) adptSubEventLinkInfo.get("idPlcmtEvent") != null ? 
                                                                            (Integer) adptSubEventLinkInfo.get("idPlcmtEvent") : 0 );

        if (placementInfo == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        } else {
          cfad39sog00.setDtDtPlcmtStart(placementInfo.getDtPlcmtStart());
          if (DateHelper.isNull(placementInfo.getDtPlcmtEnd())) {
            if (DateHelper.isBefore(DateHelper.toJavaDate(cfad39so.getDtWCDDtSystemDate()),
                                    placementInfo.getDtPlcmtEnd())) {
              // cfad39so.getCFAD39SOG00().setBSysIndGeneric(ArchitectureConstants.Y);
              cfad39sog00.setBSysIndGeneric(ArchitectureConstants.Y);
            } else {
              // cfad39so.getCFAD39SOG00().setBSysIndGeneric(ArchitectureConstants.N);
              cfad39sog00.setBSysIndGeneric(ArchitectureConstants.N);
            }
          }
          ulTempIdResource = placementInfo.getCapsResourceByIdRsrcFacil().getIdResource();
          szTempCounty = placementInfo.getAddrPlcmtCnty();

          if (ArchitectureConstants.Y.equals(cfad39sog00.getBSysIndGeneric())) {
            cfad39so.setCSysIndContractCurrent(ArchitectureConstants.Y);
            dtAdptSubEnd = DateHelper.toJavaDate(cfad39sog00.getDtDtAdptSubEnd());
            ContractCounty contractCountyInfo = null;
            // ten/four rc = csec60dQUERYdam(sqlca, pCSEC60DInputRec, pCSEC60DOutputRec);
            if(dtAdptSubEnd != null){
              contractCountyInfo = contractCountyDAO.findContractCountyForAdoptionSubsidy(
                                                    ulTempIdResource,
                                                    szTempCounty,
                                                    dtAdptSubEnd,
                                                    lookupAdoptionServices());
            }else{
              contractCountyInfo = contractCountyDAO.findContractCountyForAdoptionSubsidy(ulTempIdResource,
                                                                                          szTempCounty,
                                                                                          dtCurrentDate,
                                                                                          lookupAdoptionServices());
            }
            if (contractCountyInfo == null) {
              cfad39so.setCSysIndContractCurrent(ArchitectureConstants.N);
              //STGAP00013507: In COMP status only do validations for the fields modifiable in the COMP
              if(cfad39si.getUlIdEvent() != 0 && !EVENT_STATUS_COMP.equals(cfad39so.getROWCCMN01UIG00().getSzCdEventStatus())){
                throw new ServiceException(Messages.MSG_ASV_NO_ASV_CONTRACT);
              }
            } else {
              int idContract = contractCountyInfo.getContract().getIdContract();
              int nbrCncntyPeriod = contractCountyInfo.getNbrCncntyPeriod();
              cfad39so.setUlIdContract(idContract);
              // eleven/five rc = csec11dQUERYdam(sqlca, pCSEC11DInputRec, pCSEC11DOutputRec);
              ContractPeriod contractPeriodInfo1 = contractPeriodDAO.findContractPeriodAndContract(idContract,
                                                                                                   nbrCncntyPeriod);

              // STGAP00011586 - Get the ID of the primary child
              // to perform a lookup of service authorizations for this child
              int idPrimaryChild = cfad39so.getUlIdPerson();
              
              // Find Service Authorization using idContract
              // Set flag in SI object (create new flag)
              String cdAdptSubDeterm= (String) adptSubEventLinkInfo.get("cdAdptSubDeterm");
              String decodeType = "";
              //STGAP00013779: Corrected and added service code as per the design document
              if (CodesTables.CSUBTYPE_18.equals(cdAdptSubDeterm)) {
                decodeType = CodesTables.CADOSVCD_51217;
              } else if (CodesTables.CSUBTYPE_10.equals(cdAdptSubDeterm)) {
                decodeType = CodesTables.CADOSVCD_51260;
              } else if (CodesTables.CSUBTYPE_30.equals(cdAdptSubDeterm)) {
                decodeType = CodesTables.CADOSVCD_51258B; //STGAP00013779: changed it to 51258B as per Design Document
              } else if (CodesTables.CSUBTYPE_28.equals(cdAdptSubDeterm)) {
                decodeType = CodesTables.CADOSVCD_51258C; //STGAP00013779: changed it to 51258C
              }  else if (CodesTables.CSUBTYPE_29.equals(cdAdptSubDeterm)) {
                decodeType = CodesTables.CADOSVCD_51258A; //STGAP00013779: changed it to 51258A
              }  else if (CodesTables.CSUBTYPE_21.equals(cdAdptSubDeterm)) {
                decodeType = CodesTables.CADOSVCD_51258D;
              } else if (CodesTables.CSUBTYPE_22.equals(cdAdptSubDeterm)) {
                decodeType = CodesTables.CADOSVCD_51033A;
              } else if (CodesTables.CSUBTYPE_25.equals(cdAdptSubDeterm)) {
                decodeType = CodesTables.CADOSVCD_51033B;
              } else if (CodesTables.CSUBTYPE_23.equals(cdAdptSubDeterm)) {
                decodeType = CodesTables.CADOSVCD_51033C;
              }else if (CodesTables.CSUBTYPE_24.equals(cdAdptSubDeterm)) {
                decodeType = CodesTables.CADOSVCD_51033C;
              }
              
              if (contractPeriodInfo1 == null) {
                cfad39so.setCSysIndContractCurrent(ArchitectureConstants.N);
                //STGAP00013507: In COMP status only do validations for the fields modifiable in the COMP
                if(cfad39si.getUlIdEvent() != 0 && !EVENT_STATUS_COMP.equals(cfad39so.getROWCCMN01UIG00().getSzCdEventStatus())){
                  throw new ServiceException(Messages.MSG_ASV_NO_ACT_CNRCT);
                }
              } else {
                nbrCncntyPeriod = 1;
                // twelve/six rc = csec12dQUERYdam(sqlca, pCSEC12DInputRec, pCSEC12DOutputRec);
                ContractPeriod contractPeriodInfo2 = contractPeriodDAO
                                                                      .findContractPeriodWithIdContractAndNbrCnperPeriod(
                                                                                                                         idContract,
                                                                                                                         nbrCncntyPeriod);

                if (contractPeriodInfo2 == null) {
                  //STGAP00013507: In COMP status only do validations for the fields modifiable in the COMP
                  if(cfad39si.getUlIdEvent() != 0 && !EVENT_STATUS_COMP.equals(cfad39so.getROWCCMN01UIG00().getSzCdEventStatus())){
                    throw new ServiceException(Messages.MSG_ASV_NO_ACT_CNRCT);
                  }
                } else {
                  cfad39so.setDtDtCnperStart(DateHelper.toCastorDate(contractPeriodInfo2.getDtCnperStart()));
                  // thirteen/seven rc = cmsc42dQUERYdam(sqlca, pCMSC42DInputRec, pCMSC42DOutputRec);
                  Date dtCnperTerm = contractPeriodDAO.findDtCnperTermByMaxNbrCnperPeriod(idContract);

                  if (dtCnperTerm == null) {
                    throw new ServiceException(Messages.SQL_NOT_FOUND);
                  } else {
                    cfad39so.setDtDtCnperTerm(DateHelper.toCastorDate(dtCnperTerm));
                  }
                } // end else ALTERNATIVE to if (contractPeriodInfo2 == null)
              } // end else ALTERNATIVE to if (contractPeriodInfo1 == null)
            } // end else ALTERNATIVE to if (contractCountyInfo == null)
          } // end if (ArchitectureConstants.Y.equals(cfad39so.getCFAD39SOG00().getBSysIndGeneric()))
        } // end else ALTERNATIVE to if (placementInfo == null)
        cfad39so.setCFAD39SOG00(cfad39sog00);

      } // end else ALTERNATIVE to if (adptSubEventLinkInfo == null || adptSubEventLinkInfo.isEmpty())
    } // end else ALTERNATIVE to if ((cfad39si.getUlIdEvent() == 0)

    // fourteen rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, capsResourceInfo);
    CapsResource capsResourceInfo = capsResourceDAO.findCapsResourceByIdResourceOnly(ulTempIdResource);

    if (capsResourceInfo == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    } else {
      if (null == capsResourceInfo.getAddrRsrcStLn1()) {
        //STGAP00013507: In COMP status only do validations for the fields modifiable in the COMP
        if(cfad39si.getUlIdEvent() != 0 && !EVENT_STATUS_COMP.equals(cfad39so.getROWCCMN01UIG00().getSzCdEventStatus())){
          throw new ServiceException(Messages.MSG_FAD_NO_PAYEE_ADDR);
        }
      }
      CFAD39SOG01 cfad39sog01 = new CFAD39SOG01();

      cfad39sog01.setSzNmResource(capsResourceInfo.getNmResource());
      cfad39sog01.setSzAddrRsrcAddrStLn1(capsResourceInfo.getAddrRsrcStLn1());
      cfad39sog01.setSzAddrRsrcAddrStLn2(capsResourceInfo.getAddrRsrcStLn2());
      cfad39sog01.setSzAddrRsrcAddrCity(capsResourceInfo.getAddrRsrcCity());
      cfad39sog01.setSzAddrRsrcAddrState(capsResourceInfo.getCdRsrcState());
      cfad39sog01.setSzCdFacilityCounty(capsResourceInfo.getCdRsrcCnty());
      cfad39sog01.setSzAddrRsrcAddrZip(capsResourceInfo.getAddrRsrcZip());
      cfad39so.setCFAD39SOG01(cfad39sog01);

      // fifteen rc = cses84dQUERYdam(sqlca, pCSES84DInputRec, pCSES84DOutputRec);
      String nbrRsrcAddrVid = resourceAddressDAO.findResourceAddressVID(ulTempIdResource);

      cfad39so.getCFAD39SOG01().setSzNbrRsrcVid(nbrRsrcAddrVid);

      // seventeen rc = cmsc41dQUERYdam(sqlca, pCMSC41DInputRec, pCMSC41DOutputRec);
      String cdLegalStatStatus = legalStatusDAO.findCdLegalStatStatusByMaxIdLegalStatEvent(cfad39so.getUlIdPerson(),
                                                                                           CD_LEGAL_STAT_STATUS_TYPE_1);

      cfad39so.setSzCdLegalStatStatus(cdLegalStatStatus);

      if (cfad39si.getUlIdEvent() != 0 && !EVENT_STATUS_NEW.equals(cfad39so.getROWCCMN01UIG00().getSzCdEventStatus())) {
        // eighteen/eight rc = cses64dQUERYdam(sqlca, pCSES64DInputRec, pCSES64DOutputRec);
        Map adptSubEventLinkInfo = adptSubEventLinkDAO.findAdptSubEventLink(cfad39si.getUlIdEvent());

        if (adptSubEventLinkInfo == null || adptSubEventLinkInfo.isEmpty()) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        } else {
          cfad39so
                  .setUlIdPlcmtEvent((Integer) adptSubEventLinkInfo.get("idPlcmtEvent") != null ? (Integer) adptSubEventLinkInfo
                                                                                                                                .get("idPlcmtEvent")
                                                                                               : 0);
          cfad39so
                  .getCFAD39SOG00()
                  .setUlIdAdptSub(
                                  (Integer) adptSubEventLinkInfo.get("idAdptSub") != null ? (Integer) adptSubEventLinkInfo
                                                                                                                          .get("idAdptSub")
                                                                                         : 0);
          Date dtAdptSubAgreeRetn = (Date) adptSubEventLinkInfo.get("dtAdptSubAgreeRetn");
          cfad39so.getCFAD39SOG00().setDtDtAdptSubAgreeRetn(DateHelper.toCastorDate(dtAdptSubAgreeRetn));
          cfad39so
                  .getCFAD39SOG00()
                  .setUlIdAdptSubPayee(
                                       (Integer) adptSubEventLinkInfo.get("idResource") != null ? (Integer) adptSubEventLinkInfo
                                                                                                                                      .get("idResource")
                                                                                                     : 0);
          Date dtAdptSubAgreeSent = (Date) adptSubEventLinkInfo.get("dtAdptSubAgreeSent");
          cfad39so.getCFAD39SOG00().setDtDtAdptSubAgreeSent(DateHelper.toCastorDate(dtAdptSubAgreeSent));
          Date dtAdptSubAppReturned = (Date) adptSubEventLinkInfo.get("dtAdptSubAppReturned");
          cfad39so.getCFAD39SOG00().setDtDtAdptSubAppReturned(DateHelper.toCastorDate(dtAdptSubAppReturned));
          Date dtAdptSubAppSent = (Date) adptSubEventLinkInfo.get("dtAdptSubAppSent");
          cfad39so.getCFAD39SOG00().setDtDtAdptSubAppSent(DateHelper.toCastorDate(dtAdptSubAppSent));
          Date dtAdptSubApprvd = (Date) adptSubEventLinkInfo.get("dtAdptSubApprvd");
          cfad39so.getCFAD39SOG00().setDtDtAdptSubApprvd(DateHelper.toCastorDate(dtAdptSubApprvd));
          Date dtAdptSubEffective = (Date) adptSubEventLinkInfo.get("dtAdptSubEffective");
          cfad39so.getCFAD39SOG00().setDtDtAdptSubEffective(DateHelper.toCastorDate(dtAdptSubEffective));
          Date dtAdptSubEnd = (Date) adptSubEventLinkInfo.get("dtAdptSubEnd");
          cfad39so.getCFAD39SOG00().setDtDtAdptSubEnd(DateHelper.toCastorDate(dtAdptSubEnd));
          cfad39so.getCFAD39SOG00().setSAmtAdptSub((Double) adptSubEventLinkInfo.get("amtAdptSub"));
          cfad39so.getCFAD39SOG00().setSzTxtAdptSubRsn((String) adptSubEventLinkInfo.get("txtAdptSubRsn"));
          cfad39so.getCFAD39SOG00().setSzCdAdptSubCloseRsn((String) adptSubEventLinkInfo.get("cdAdptSubCloseRsn"));
          cfad39so.getCFAD39SOG00().setCIndAdptSubThirdParty((String) adptSubEventLinkInfo.get("indAdptSubThirdParty"));
          cfad39so.getCFAD39SOG00().setCIndAdptSubProcess((String) adptSubEventLinkInfo.get("indAdptSubProcess"));
          cfad39so.getCFAD39SOG00().setSzCdAdptSubDeterm((String) adptSubEventLinkInfo.get("cdAdptSubDeterm"));
          cfad39so.getCFAD39SOG00().setTsLastUpdate((Date) adptSubEventLinkInfo.get("dtLastUpdate"));
          Date dtAdptSubLastInvc = (Date) adptSubEventLinkInfo.get("dtAdptSubLastInvc");
          cfad39so.getCFAD39SOG00().setDtDtAdptSubLastInvc(DateHelper.toCastorDate(dtAdptSubLastInvc));
          Date dtRenwlEffBegin = (Date) adptSubEventLinkInfo.get("dtRenwlEffBegin");
          cfad39so.getCFAD39SOG00().setDtDtRenwlEffBegin(DateHelper.toCastorDate(dtRenwlEffBegin));
          Date dtRenwlEffEnd = (Date) adptSubEventLinkInfo.get("dtRenwlEffEnd");
          cfad39so.getCFAD39SOG00().setDtDtRenwlEffEnd(DateHelper.toCastorDate(dtRenwlEffEnd));
          cfad39so.getCFAD39SOG00().setSAmtSpclAsstReq((Double) adptSubEventLinkInfo.get("amtSpclAsstReq"));
          cfad39so.getCFAD39SOG00().setSzTxtSpclAsstCmnts((String) adptSubEventLinkInfo.get("txtSpclAsstCmnts"));
          cfad39so.getCFAD39SOG00().setSzCdSpclAsstType((String) adptSubEventLinkInfo.get("cdSpclAsstType"));
          cfad39so.getCFAD39SOG00().setSzTxtSpclAsstSpecify((String) adptSubEventLinkInfo.get("txtSpclAsstSpecify"));
          cfad39so.getCFAD39SOG00().setCIndSauConf((String) adptSubEventLinkInfo.get("indSauConf"));
          cfad39so.getCFAD39SOG00().setCIndSpclAsstApprvl((String) adptSubEventLinkInfo.get("indSpclAsstApprvl"));
          cfad39sog00.setCIndSchoolVerified((String) adptSubEventLinkInfo.get("indSchoolVer"));
          cfad39sog00.setSzCdPlaymentMthd((String) adptSubEventLinkInfo.get("cdPaymentMthd"));
          ulSpecialNeedsEvent = (Integer) adptSubEventLinkInfo.get("idSpecialNeedsDetermination") != null ? (Integer) adptSubEventLinkInfo
                                                                                                         .get("idSpecialNeedsDetermination")
                                                                                                         : 0;
          cfad39sog00.setUlIdSpecialNeedsEvent((ulSpecialNeedsEvent));
        }
      } // end if (cfad39si.getUlIdEvent() != 0
      else {
        cfad39so.getCFAD39SOG00().setDtDtAdptSubAgreeRetn(null);
        cfad39so.getCFAD39SOG00().setDtDtAdptSubAgreeSent(null);
        cfad39so.getCFAD39SOG00().setDtDtAdptSubAppReturned(null);
        cfad39so.getCFAD39SOG00().setDtDtAdptSubAppSent(null);
        cfad39so.getCFAD39SOG00().setDtDtAdptSubApprvd(null);
        cfad39so.getCFAD39SOG00().setDtDtAdptSubEffective(null);
        cfad39so.getCFAD39SOG00().setDtDtAdptSubEnd(null);
        cfad39so.getCFAD39SOG00().setDtDtAdptSubLastInvc(null);
        cfad39so.getCFAD39SOG00().setDtDtRenwlEffBegin(null);
        cfad39so.getCFAD39SOG00().setDtDtRenwlEffEnd(null);
      } // // end else ALTERNATIVE to if (cfad39si.getUlIdEvent() != 0
    }
    // end else ALTERNATIVE to if (capsResourceInfo == null)
    
    //if the special needs is null then test to if one was passed in, it is new agreement
    int newSpecialNeedsEvent = ((Integer)cfad39si.getUlIdSpecialNeedsEvent() != null) ? (Integer) cfad39si.getUlIdSpecialNeedsEvent() : 0;
    ulSpecialNeedsEvent = (ulSpecialNeedsEvent != 0 ? ulSpecialNeedsEvent : newSpecialNeedsEvent);
    if(ulSpecialNeedsEvent > 0) {
      cfad39sog00.setUlIdSpecialNeedsEvent(ulSpecialNeedsEvent);
      SpecialNeedsDetermination specialNeedsDetermination = specialNeedsDeterminationDAO.findSpecialNeedsDeterminationByIdEvent(ulSpecialNeedsEvent);
      if(specialNeedsDetermination != null) {
        cfad39sog00.setCIndIncidentChildInPad(specialNeedsDetermination.getIndIncidentChild()); // SMS#97845 MR-074-2 AFCARS
        cfad39sog00.setCIndSauConf(ArchitectureConstants.Y);
        cfad39sog00.setSzSndFndType(specialNeedsDetermination.getCdFundingType());
        cfad39sog00.setSzSpcSvcAprvAmt(specialNeedsDetermination.getNbrApprvAmt() != null ? specialNeedsDetermination.getNbrApprvAmt() : 0.0);
        cfad39sog00.setSzSpcRtAprvAmt(specialNeedsDetermination.getNbrTotalIveIvbAmt() != null ? specialNeedsDetermination.getNbrTotalIveIvbAmt() : 0.0);
        cfad39sog00.setSzNonRecAprvAmt(specialNeedsDetermination.getNbrNonRecAprvAmt() != null ? specialNeedsDetermination.getNbrNonRecAprvAmt(): 0.0);
        //STGAP00013779: Added these to display selected options in the Type/Class drop down, Agreement dates,
        //Approved date, Amount fields depending on the conditions
        cfad39sog00.setBIndBasicRateReq(specialNeedsDetermination.getIndBasicRateReqChild());
        cfad39sog00.setBIndSpcNeedsApproved(specialNeedsDetermination.getIndSpcNeedsApproved());
        cfad39sog00.setBIndNonRecRequested(specialNeedsDetermination.getIndNonRecRequested());
        cfad39sog00.setBIndNonRecApproved(specialNeedsDetermination.getIndNonRecApproved());
        cfad39sog00.setBIndSpclServiceReq(specialNeedsDetermination.getIndSpclSerReqChild());
        cfad39sog00.setBIndSpclReqApproved(specialNeedsDetermination.getIndSpclReqApproved());
        cfad39sog00.setBIndSpecializedRateReq(specialNeedsDetermination.getIndSpclRateReqChild());
        cfad39sog00.setBIndSpclRateAdoAppr(specialNeedsDetermination.getIndSpclRateAdoAppr());
        cfad39sog00.setDtDtApprvDate(DateHelper.toCastorDate(specialNeedsDetermination.getDtApprvDate()));
        cfad39sog00.setDtDtExpirationDate(DateHelper.toCastorDate(specialNeedsDetermination.getDtExpirationDate()));
        cfad39sog00.setSzCdPaymentMethodApp(specialNeedsDetermination.getCdPaymentMthd());
        cfad39sog00.setSzTxtOtherSpcServ(specialNeedsDetermination.getTxtPleaseSpecify());
        cfad39sog00.setSzTxtComments(specialNeedsDetermination.getTxtComments());
        cfad39sog00.setBIndReasonSpecialRequest(specialNeedsDetermination.getIndReasonSpecialRequest());
        
        //STGAP00014563: Get the new fields added on the Application page
        cfad39sog00.setCdBasicRateType(specialNeedsDetermination.getCdBasicRateType());
        cfad39sog00.setSNbrBasicAmt(specialNeedsDetermination.getNbrBasicRateAmt() != null ? specialNeedsDetermination.getNbrBasicRateAmt() : 0.0);
        cfad39sog00.setSNbrCountyAddonAmt(specialNeedsDetermination.getNbrCountyAddonAmt() != null ? specialNeedsDetermination.getNbrCountyAddonAmt() : 0.0);
        //STGAP00014563: Set the Date Approved by the Date Approved on the special Needs Approval section on Application
        cfad39sog00.setDtDtLatestSndAprv(DateHelper.toCastorDate(specialNeedsDetermination.getDtSpclNeedsApprvd()));
        //STGAP00014563: Set the Date Approved by the Date Approved on the special Needs Approval section on Application
        cfad39sog00.setDtDtSndAprv(DateHelper.toCastorDate(specialNeedsDetermination.getDtSpclNeedsApprvd()));

        // Get the Approval Date of the special needs
        // DAO call returns all the approval events.  Loop will go thru all and set the approval date of the last approval.
        List<Object[]> approvalList = approvalEventLinkDAO.findApprovalsforCaseEvent(ulSpecialNeedsEvent);
        for (Iterator<Object[]> it = approvalList.iterator(); it.hasNext();) {
          Object[] approvalArray = it.next();
          if ("APRV".equals(approvalArray[2].toString())) {
            cfad39sog00.setDtDtSndAprv(DateHelper.toCastorDate((Timestamp) approvalArray[1]));
          }
        }  
      }
    }
    

      //STGAP00013924 : Get the Approved date from the latest approved special needs application
      SpecialNeedsDetermination spcNeedsD = specialNeedsDeterminationDAO.findLatestApprovedSpclDetermination(cfad39si.getUlIdStage(), cfad39so.getUlIdPerson(), cfad39si.getUlIdCase());
      //STGAP00014155: Adding the null check
      if(spcNeedsD != null){
         cfad39sog00.setSzSndAprvType(spcNeedsD.getIndAprType());
      }
      
      //STGAP00014563: If the Date Approved on the Special Needs Approval Section is not entered then get the date event Approved
      //STGAP00014688: Get the approved date entered by SAU of the latest special needs application
      if(spcNeedsD != null){
        if(spcNeedsD.getDtSpclNeedsApprvd() != null){
          cfad39sog00.setDtDtLatestSndAprv(DateHelper.toCastorDate(spcNeedsD.getDtSpclNeedsApprvd()));
        }else{
          // Get the Approval Date of the special needs
          // DAO call returns all the approval events.  Loop will go thru all and set the approval date of the last approval.
          List<Object[]> approvalList = approvalEventLinkDAO.findApprovalsforCaseEvent(spcNeedsD.getIdEvent());
          for (Iterator<Object[]> it = approvalList.iterator(); it.hasNext();) {
            Object[] approvalArray = it.next();
            if ("APRV".equals(approvalArray[2].toString())) {
              cfad39sog00.setDtDtLatestSndAprv(DateHelper.toCastorDate((Timestamp) approvalArray[1]));
            }
          } 
        }
       if(ArchitectureConstants.Y.equals(cfad39sog00.getBIndBasicRateReq()) && ArchitectureConstants.Y.equals(cfad39sog00.getBIndSpcNeedsApproved())){
        //STGAP00014688: Get the approved date entered by SAU of the latest special needs application
           cfad39sog00.setDtDtSndAprv(cfad39sog00.getDtDtLatestSndAprv());
        }
      }

    
    if(cfad39so.getDtDtPersonBirth() != null) {
      int personAge = DateHelper.getAge(cfad39so.getDtDtPersonBirth());
      //STGAP00014563: Get the basic rate as per the Basic Rate Type selected
      AdoSubsidyRate asr = null;
      if(CodesTables.CBRTYPE_PRE.equals(cfad39sog00.getCdBasicRateType())){
        Date endDate = adoSubsidyRateDAO.findAdoptionSubsidyRateEndDate();
        asr = adoSubsidyRateDAO.findPreAdoptionSubsidyRateByAge(personAge, endDate);
        if (asr != null) {
          //STGAP00014680: Calculation redone
          cfad39sog00.setSAmtAdptBaseRate(asr.getAmtAdptSub() + 
                                          Round((cfad39sog00.getSNbrCountyAddonAmt()* DAYS_IN_YEAR) / MONTHS , 2));
        } else {
          cfad39sog00.setSAmtAdptBaseRate((double)0  + (cfad39sog00.getSNbrCountyAddonAmt()* DAYS_IN_YEAR) / MONTHS);
        }
      }else if(CodesTables.CBRTYPE_POS.equals(cfad39sog00.getCdBasicRateType())){
        Date startDate = adoSubsidyRateDAO.findAdoptionSubsidyRateStartDate();
        asr = adoSubsidyRateDAO.findPostAdoptionSubsidyRateByAge(personAge, startDate);
        if (asr != null) {
          cfad39sog00.setSAmtAdptBaseRate(asr.getAmtAdptSub());
        } else {
          cfad39sog00.setSAmtAdptBaseRate((double)0);
        }
      }else if(CodesTables.CBRTYPE_CUS.equals(cfad39sog00.getCdBasicRateType())){
        cfad39sog00.setSAmtAdptBaseRate(cfad39sog00.getSNbrBasicAmt());
      }else{
        cfad39sog00.setSAmtAdptBaseRate((double)0);
      }
    }
    
    Long priorEndedCount = null;
    if(cfad39so.getUlIdPerson() > 0 ) {
      priorEndedCount = adptSubEventLinkDAO.findPriorEndedAAAgreementCount(cfad39si.getUlIdStage(), cfad39so.getUlIdPerson());
    }
    cfad39sog00.setIndPriorEndedArgreement((priorEndedCount != null && priorEndedCount > 0) ? ArchitectureConstants.Y : ArchitectureConstants.N);
    
    //STGAP00014203: For conversion data "Child has never been in permanent custody of DFCS (Non-Incident)" is displaying when it should not
    // SMS#97845 MR-074-2 AFCARS: new logic is being used to set child is incident or non-incident (pulled from AA Application)
    // BIndHasIntakeStage still gets set but will not be used in conversation in displaying attention message whether child is incident/nin-incident
    Integer idStage = stageDAO.findIdStageByIdCaseAndCdStage(cfad39si.getUlIdCase(), CodesTables.CSTAGES_INT);
    if(idStage != null){
      cfad39so.setBIndHasIntakeStage(ArchitectureConstants.Y);
    }else{
      cfad39so.setBIndHasIntakeStage(ArchitectureConstants.N);
    }
    
    return cfad39so;
  }
  
  public Integer retrieveSubStageCount(CFAD39SI cfad39si) throws ServiceException{
    
    Integer returnValue  = new Integer(0);
    
    Map stagePersonLinkInform = stagePersonLinkDAO.findStagePersonLinkByIdPerson(cfad39si.getUlIdStage(), PRIMARY_CHILD);

    //check for a prior fcc stage
    if (stagePersonLinkInform != null && stagePersonLinkInform.size() > 0) {
      int idChild = ((Integer) stagePersonLinkInform.get("idPerson") != null ? (Integer) stagePersonLinkInform.get("idPerson") : 0);
      returnValue =  new Integer((int) stagePersonLinkDAO.countSubStageByIdPersonCdStage(idChild));
    }
    //change if the stage was progress from a prior sealed ado
    if(returnValue.intValue() == 0) {
      Integer idStage =  stageLinkDAO.findPreviousIdStageByIdStageByCdStage(cfad39si.getUlIdStage());
      if(idStage != null && idStage.intValue() > 0) {
        Stage stage = getPersistentObject(Stage.class, idStage.intValue());
        if(stage != null && ArchitectureConstants.Y.equals(stage.getIndStageSealed())) {
          returnValue = 1;
        }
      }
    }
    
    return returnValue;
  }

  private Collection<String> lookupAdoptionServices() {
    try {
      return Lookup.getCategoryCodesCollection(CodesTables.CLADPT);
    } catch (LookupException le) {
      throw new IllegalStateException("Lookup of " + CodesTables.CLADPT + " codes table failed!", le);
    }
  }

  public LegalStatusDAO getLegalStatusDAO() {
    return legalStatusDAO;
  }

  public void setAdoSubsidyRateDAO(AdoSubsidyRateDAO adoSubsidyRateDAO) {
    this.adoSubsidyRateDAO = adoSubsidyRateDAO;
  }
  
  private static double Round(double Rval, int Rpl) {
    double p = (double)Math.pow(10,Rpl);
    Rval = Rval * p;
    double tmp = Math.round(Rval);
    return (double)tmp/p;
  }
}
