package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpJobHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterCareRateDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PaymentOfCareDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FosterCareRate;
import gov.georgia.dhr.dfcs.sacwis.db.PaymentOfCare;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrievePaymentOfCare;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PaymentOfCareRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PaymentOfCareRetrieveSO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * This is the Service that retrieves the Payment of care record from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User       Description
 *   --------  ---------  --------------------------------------------------
 *   03/19/08  vdevarak   STGAP00007334: Need to retrieve an approved placement 
 *                        of any type that comes under CCI program. Passing the 
 *                        list of placement types that come under CCI program to 
 *                        the SQL. 
 *                       
 *   10/17/08 alwilliams  STGAP00009397: Updated method retrievePaymentOfCare to 
 *                        check for a null FosterCareRate object.  
 *                   
 *   04/21/2009 arege     STGAP00013397: Added changes for MR-033 Relative
 *                        Care Invoicing Changes.     
 *   06/08/2009 arege     STGAP00014111 - Modified code to reflect design change of check box to radio button for 
 *                        the waiver options of 80%, 100% and custom waiver.      
 *   07/02/09   arege     STGAP00014315 - Added code to include Enhanced Relative Care Subsidy to include the same 
 *                        dynamic behavior as the enhanced subsidized guardianship
 *                        and enhanced non-relative subsidized guardianship          
 *   07/29/09   arege     STGAP00014315 - Disable the functionality added with defect STGAP00014315
 *   08/10/10   wjcochran SMS #64906 - Enable custom and 100% waiver on Payment of Care
 *   05/24/11   hnguyen   SMS#109407: MR-087 Added new Child turns 18 checkbox.
 * </pre>
 */
public class RetrievePaymentOfCareImpl extends BaseServiceImpl implements RetrievePaymentOfCare {
  // declare local variables
  private static final String NEW = CodesTables.CEVTSTAT_NEW;

  private static final String CCI = CodesTables.CPLMNTYP_CCI;

  private static final String CPA = CodesTables.CPLMNTYP_CFH;

  public static final String CONCURRENT = CodesTables.CTMPLTYP_COR;

  public static final String RESPITE_DAY = CodesTables.CTMPLTYP_RED;

  public static final String RESPITE_NIGHT = CodesTables.CTMPLTYP_REN;

  private ContractServiceDAO contractServiceDAO = null;

  private EventDAO eventDAO = null;

  private ApprovalEventLinkDAO approvalEventLinkDAO = null;

  private PaymentOfCareDAO paymentOfCareDAO = null;

  private EmpJobHistoryDAO empJobHistoryDAO = null;

  private FosterCareRateDAO fosterCareRateDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private PersonDAO personDAO = null;

  private PlacementDAO placementDAO = null;

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setEmpJobHistoryDAO(EmpJobHistoryDAO empJobHistoryDAO) throws ServiceException {
    this.empJobHistoryDAO = empJobHistoryDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) throws ServiceException {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setFosterCareRateDAO(FosterCareRateDAO fosterCareRateDAO) throws ServiceException {
    this.fosterCareRateDAO = fosterCareRateDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) throws ServiceException {
    this.personDAO = personDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) throws ServiceException {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setEventDAO(EventDAO eventDAO) throws ServiceException {
    this.eventDAO = eventDAO;
  }

  public void setPaymentOfCareDAO(PaymentOfCareDAO paymentOfCareDAO) throws ServiceException {
    this.paymentOfCareDAO = paymentOfCareDAO;
  }

  public PaymentOfCareRetrieveSO retrievePaymentOfCare(PaymentOfCareRetrieveSI paymentOfCareRetrieve) {
    PaymentOfCareRetrieveSO pocReturn = new PaymentOfCareRetrieveSO();
    int idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(paymentOfCareRetrieve.getUlIdStage(),
                                                                              PRIMARY_CHILD);
    pocReturn.setUlIdPerson(idPerson);

    if (paymentOfCareRetrieve.getUlIdEvent() != 0) {
      int idPOCEvent = paymentOfCareRetrieve.getUlIdEvent();

      Event event = eventDAO.findEventByIdEvent(idPOCEvent);

      // If eventDAO fails to find an event an exception is thrown
      if (event == null || event.equals(null)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      pocReturn.setIdNmStage(event.getStage().getIdStage() != null ? event.getStage().getIdStage() : 0);
      pocReturn.setUlIdEvent(idPOCEvent);
      pocReturn.setCdEventStatus(event.getCdEventStatus());
      pocReturn.setDtEventOccurred(event.getDtEventOccurred());

      if (approvalEventLinkDAO.findApprovalEventLinkByIdEvent(idPOCEvent) != null) {
        pocReturn.setApprovalStatus(true);
      } else {
        pocReturn.setApprovalStatus(false);
      }

      String eventStatusSO = event.getCdEventStatus();
      // If the event isn't New then there should be data to retrieve from wtlp_plan table.
      if (!(NEW.equals(eventStatusSO))) {
        PaymentOfCare poc = paymentOfCareDAO.findPOC(idPOCEvent);
        if (poc == null || poc.equals(null)) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        try {
          pocReturn.setPocType(poc.getCdPocType());
          pocReturn.setEndDate(poc.getDtEnd());
          pocReturn.setStartDate(poc.getDtStart());
          pocReturn.setDtTerminate(poc.getDtTerminate());
          pocReturn.setSpecialRate(poc.getNbrSpecPerDiem());
          pocReturn.setIndConcurrentPerDiem(poc.getIndConcurrent());
          pocReturn.setTxtReasonConcurrentPD(poc.getTxtConcurPDiem());
          pocReturn.setTxtReasonSpecializedPD(poc.getTxtSpecPerDiem());
          pocReturn.setDtPacketComplete(poc.getDtPacketComp());
          pocReturn.setDtEmergSupApprv(poc.getDtPacketAprv());
          pocReturn.setDtPacketSent(poc.getDtPacketSent());
          pocReturn.setDtStaffingComplete(poc.getDtStaffCompl());
          pocReturn.setDtStateOfficeResponse(poc.getDtSoResp());
          pocReturn.setDtRBWOReview(poc.getDtRbwoAprv());
          pocReturn.setAgreeDate(poc.getDtAgreement());
          pocReturn.setAnnualRevDate(poc.getDtAnnReview());
          pocReturn.setEffPaymentDate(poc.getDtStart());
          pocReturn.setRenewDate(poc.getDtEnd());
          pocReturn.setCourtRevDate(poc.getDtCourt());
          // MR-087 Added new Child turns 18 checkbox
          pocReturn.setInd18ByNextCrtRvw(poc.getInd18ByNextCrtRvw());
          pocReturn.setIndFamIncomeLess(poc.getIndIncome());
          pocReturn.setIndTerminate(poc.getIndTerminate());
          pocReturn.setIndSuspend(poc.getIndSuspend());
          pocReturn.setTxtReasonTerm(poc.getTxtTerminate());
          pocReturn.setIndRbwoType(poc.getIndRbwoType());
          pocReturn.setIndRcsType(poc.getIndRcsType());
          pocReturn.setSpecFcRbwoWaiver(poc.getAmtSpecFcRbwoWaiver());
          pocReturn.setTxtReasonSpecWaiver(poc.getTxtReasonSpecWaiver());

          if (poc.getPersonByIdSpvPacketAprv() != null) {
            pocReturn.setIdSuprvsrApprv(poc.getPersonByIdSpvPacketAprv().getIdPerson());
            pocReturn.setNmSuprvsrApprv(poc.getPersonByIdSpvPacketAprv().getNmPersonFull());
          }
          if (poc.getPersonByIdRbwoRevAprv() != null) {
            pocReturn.setIdRBWOStaffApprv(poc.getPersonByIdRbwoRevAprv().getIdPerson());
            pocReturn.setNmRBWOStaffApprv(poc.getPersonByIdRbwoRevAprv().getNmPersonFull());
          }
          if (poc.getPersonByIdCmPacketComp() != null) {
            pocReturn.setIdPersonCompleting(poc.getPersonByIdCmPacketComp().getIdPerson());
            pocReturn.setNmPersonCompleting(poc.getPersonByIdCmPacketComp().getNmPersonFull());
          }
          if (poc.getCapsResourceByIdResource() != null) {
            pocReturn.setIdRelative(poc.getCapsResourceByIdResource().getIdResource());
            pocReturn.setNmRelative(poc.getCapsResourceByIdResource().getNmResource());
          }
          if (poc.getPersonByIdSoAprv() != null) {
            pocReturn.setIdSOStaffApprv(poc.getPersonByIdSoAprv().getIdPerson());
            pocReturn.setNmSOStaffApprv(poc.getPersonByIdSoAprv().getNmPersonFull());
          }
          pocReturn
                   .setSuprvsrApprvTitle(Lookup
                                               .simpleDecodeSafe(
                                                                 CodesTables.CEMPJBCL,
                                                                 (empJobHistoryDAO
                                                                                  .findEmpJobTitle(pocReturn
                                                                                                            .getIdSuprvsrApprv()))));
          pocReturn
                   .setRbwoStaffApprvTitle(Lookup
                                                 .simpleDecodeSafe(
                                                                   CodesTables.CEMPJBCL,
                                                                   (empJobHistoryDAO
                                                                                    .findEmpJobTitle(pocReturn
                                                                                                              .getIdRBWOStaffApprv()))));
          pocReturn
                   .setPersCompTitle(Lookup
                                           .simpleDecodeSafe(
                                                             CodesTables.CEMPJBCL,
                                                             (empJobHistoryDAO
                                                                              .findEmpJobTitle(pocReturn
                                                                                                        .getIdPersonCompleting()))));
          pocReturn
                   .setSoStaffApprvTitle(Lookup
                                               .simpleDecodeSafe(
                                                                 CodesTables.CEMPJBCL,
                                                                 (empJobHistoryDAO
                                                                                  .findEmpJobTitle(pocReturn
                                                                                                            .getIdSOStaffApprv()))));
          // STGAP00004406
          pocReturn.setIndProgramType(poc.getIndCCI());
          pocReturn.setRbwoProgramType(poc.getCdRbwoProgram());
          // end STGAP00004406
          
          //MR- 033 STGAP00013397
          pocReturn.setInd80PerDiem(poc.getInd80PerDiem());
          pocReturn.setInd100PerDiem(poc.getInd100PerDiem());
          pocReturn.setIndCustomWaiver(poc.getIndCustomWaiver());

         if(poc.getAmtWaiver()!=null){
          pocReturn.setWaiverAmount(poc.getAmtWaiver());
          }
          pocReturn.setTxtWaiverReason(poc.getTxtWaiverReason());             
         //End MR- 033 STGAP00013397

        } catch (Exception e) {
          throw new RuntimeWrappedException(e);
        }
      }// end if not NEW
    }// end if event != 0

    int childAge = 0;
    childAge = DateHelper.getAge(personDAO.findPersonByIdPerson(idPerson).getDtPersonBirth());
    String ageRange = "";
    if (childAge <= 5) {
      ageRange = "005";
    } else if (childAge > 5 && childAge < 13) {
      ageRange = "612";
    } else if (childAge >= 13) {
      ageRange = "13P";
    }

    Date currentDate = new Date();
    String service = "";
    String serviceWaiver = StringHelper.EMPTY_STRING;

    if (CodesTables.CPOCTYPE_RFD.equals(pocReturn.getPocType())
        || CodesTables.CPOCTYPE_EFD.equals(pocReturn.getPocType())
        || CodesTables.CPOCTYPE_SFD.equals(pocReturn.getPocType())) {
      service = "50101";
    } else if (CodesTables.CPOCTYPE_LOC.equals(pocReturn.getPocType())
               || CodesTables.CPOCTYPE_RWW.equals(pocReturn.getPocType())) {
      // STGAP00004406
      // service = "60901";
      String cdRbwoProgType = pocReturn.getRbwoProgramType();
      if (ArchitectureConstants.Y.equals(pocReturn.getIndProgramType())) { // CCI placement type
        service = "60501";
      } else { // CPA placement type
        service = "60901";
      }
      if (StringHelper.isValid(cdRbwoProgType)) {
        service = service + cdRbwoProgType;
      }
      // end STGAP00004406
    } else if (CodesTables.CPOCTYPE_ERR.equals(pocReturn.getPocType())) {
      service = "54201";
    } else if (CodesTables.CPOCTYPE_RCS.equals(pocReturn.getPocType())) {
      service = "55381";
    } else if (CodesTables.CPOCTYPE_ERS.equals(pocReturn.getPocType())) {
      service = "55301";
    } else if (CodesTables.CPOCTYPE_SUG.equals(pocReturn.getPocType())) {
      service = "55281";
    } else if (CodesTables.CPOCTYPE_ESG.equals(pocReturn.getPocType())) {
      service = "55201";
    } else if (CodesTables.CPOCTYPE_NSG.equals(pocReturn.getPocType())) {
      service = "55081";
    } else if (CodesTables.CPOCTYPE_NEG.equals(pocReturn.getPocType())) {
      service = "55001";
    } 
    
    
 // STGAP00013397 MR-033  
    if(CodesTables.CPOCTYPE_ESG.equals(pocReturn.getPocType())&& ArchitectureConstants.Y.equals(pocReturn.getInd100PerDiem())
       ||CodesTables.CPOCTYPE_SUG.equals(pocReturn.getPocType())&& ArchitectureConstants.Y.equals(pocReturn.getInd100PerDiem())){  
      serviceWaiver = "55299";
    } else if (CodesTables.CPOCTYPE_NEG.equals(pocReturn.getPocType())&& ArchitectureConstants.Y.equals(pocReturn.getInd100PerDiem())
               || CodesTables.CPOCTYPE_NSG.equals(pocReturn.getPocType())&& ArchitectureConstants.Y.equals(pocReturn.getInd100PerDiem())){  
      serviceWaiver = "55099";     
    }           
   //End STGAP00013397 MR-033
    //Added this if for STGAP00014315 
    //Commented out the following to disable the functionality added by STGAP00014315 until further notice.
    //SMS #64906 - uncommented out the code for use in Release 4.0 - Also added other PoC types, as requested by client
        else if (CodesTables.CPOCTYPE_ERS.equals(pocReturn.getPocType())&& ArchitectureConstants.Y.equals(pocReturn.getInd100PerDiem())
                 || CodesTables.CPOCTYPE_RCS.equals(pocReturn.getPocType())&& ArchitectureConstants.Y.equals(pocReturn.getInd100PerDiem())){  
      serviceWaiver = "55399";     
    }   else if (CodesTables.CPOCTYPE_ERR.equals(pocReturn.getPocType())&& ArchitectureConstants.Y.equals(pocReturn.getInd100PerDiem())){  
      serviceWaiver = "54299";     
    }


    if (paymentOfCareRetrieve.getUlIdEvent() == 0 || CodesTables.CPOCTYPE_L1.equals(pocReturn.getPocType())
        || CodesTables.CPOCTYPE_L2.equals(pocReturn.getPocType())
        || CodesTables.CPOCTYPE_L3.equals(pocReturn.getPocType())
        || CodesTables.CPOCTYPE_L4.equals(pocReturn.getPocType())
        || CodesTables.CPOCTYPE_L5.equals(pocReturn.getPocType())
        || CodesTables.CPOCTYPE_L6.equals(pocReturn.getPocType())
        || CodesTables.CPOCTYPE_A3.equals(pocReturn.getPocType())) {
      pocReturn.setPerDiemRate(0);
      pocReturn.setEnhancedRelRate(0);
      pocReturn.setSubsidyPerDiem(0);
      pocReturn.setTotalPerDiemRate(0);
    }
    // STGAP00004406
    else if (CodesTables.CPOCTYPE_RWW.equals(pocReturn.getPocType())
             || CodesTables.CPOCTYPE_LOC.equals(pocReturn.getPocType())) {
      if (ArchitectureConstants.Y.equals(pocReturn.getIndProgramType())) {
        calclatePerDiemByPlacementTypeByService(pocReturn, CCI, service);
      } else {
        calclatePerDiemByPlacementTypeByService(pocReturn, CPA, service);
      }
    }
    // end STGAP00004406
    else {
   
      // STGAP00009397 - Added a fosterCareRate object and throw and exception if the object is null
      FosterCareRate fosterCareRate = fosterCareRateDAO.findFosterCareRateByAgeDateRangeAndService(ageRange, currentDate, service);

      if (fosterCareRate == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);  
      }
      
      pocReturn.setPerDiemRate(fosterCareRate.getAmtFcareRtUnitRate());

      //  STGAP00005190 - remove *rateMultiplier (=.80) since rate in table is already at 80%
      pocReturn.setEnhancedRelRate(fosterCareRate.getAmtFcareRtUnitRate());
      pocReturn.setSubsidyPerDiem(fosterCareRate.getAmtFcareRtUnitRate());
      // end STGAP00005190
      
      pocReturn.setTotalPerDiemRate(pocReturn.getPerDiemRate() + pocReturn.getSpecialRate()
                                    + pocReturn.getSpecFcRbwoWaiver());
      
      //MR-033 STGAP00013397 
      //Get the rate from FosterCare rate table if 100% waiver option is selected.
      if(ArchitectureConstants.Y.equals(pocReturn.getInd100PerDiem())){
      FosterCareRate waiverFosterCareRate = fosterCareRateDAO.findFosterCareRateByAgeDateRangeAndService(ageRange, currentDate, serviceWaiver);  
      pocReturn.setWaiverAmount(waiverFosterCareRate.getAmtFcareRtUnitRate());
      }
      //End MR-033 STGAP00013397 
    }
    return pocReturn;
  }

  // STGAP00004406
  private void calclatePerDiemByPlacementTypeByService(PaymentOfCareRetrieveSO pocReturn, String programType,
                                                       String service) {
    Placement rbwoPlacement;
    Date dtEnd = pocReturn.getEndDate();
    Date dtTerm = pocReturn.getDtTerminate();
    Date dtActualEnd;

    // if payment of care has an end or terminate date, use that to find the active placement for that period
    // otherwise, use current date to find currently active placement
    if (!DateHelper.isNull(dtEnd) && !DateHelper.isNull(dtTerm)) {
      dtActualEnd = dtTerm.before(dtEnd) ? dtTerm : dtEnd;
    } else {
      dtActualEnd = DateHelper.isNull(dtEnd) ? dtTerm : dtEnd;
    }
    if (DateHelper.isNull(dtActualEnd)) {
      dtActualEnd = new Date();
    }
    //STGAP00007334: Need to retrieve an approved placement of any type that comes under CCI program.
    //Passing the list of placement types that come under CCI program to the SQL.
    if (CCI.equals(programType)) {
      List<String> placementTypes = new ArrayList<String>();
      placementTypes.add(CodesTables.CPLCMTRU_IFH);
      placementTypes.add(CodesTables.CPLCMTRU_EMS);
      placementTypes.add(CodesTables.CPLCMTRU_GRH);
      placementTypes.add(CodesTables.CPLCMTRU_CCI);
      placementTypes.add(CodesTables.CPLCMTRU_SFH);
      placementTypes.add(CodesTables.CPLCMTRU_ICF);
      rbwoPlacement = findCciPlacement(pocReturn.getUlIdPerson(), dtActualEnd, placementTypes);
    } else if (CPA.equals(programType)) {
      rbwoPlacement = findCpaPlacement(pocReturn.getUlIdPerson(), dtActualEnd, programType);
    } else {
      return;
    }
    if (rbwoPlacement == null) { // no approved placement for the child at the specified time frame
      return;
    }
    // if it is concurrrent RBWO payment then placement's temporary type is Concurrent, Respite Day or Respite Night
    String cdTempType = rbwoPlacement.getCdTempType();
    if (CodesTables.CPOCTYPE_LOC.equals(pocReturn.getPocType())) {
      if (ArchitectureConstants.Y.equals(pocReturn.getIndConcurrentPerDiem())) {
        if (!(RESPITE_DAY.equals(cdTempType) || RESPITE_NIGHT.equals(cdTempType) || CONCURRENT.equals(cdTempType))) {
          return;
        }
      }
    }
    // if payment of care is RBWO with Waiver or full RBWO then placement's temp type should not be any of
    // Concurrent, Respite Day or Respite Night
    // use not Y since IndConcurrentPerDiem could be empty
    if (!ArchitectureConstants.Y.equals(pocReturn.getIndConcurrentPerDiem())
        && (RESPITE_DAY.equals(cdTempType) || RESPITE_NIGHT.equals(cdTempType) || CONCURRENT.equals(cdTempType))) {
      return;
    }
    // find base perdiem
    double baseRate = 0.00;
    if (CCI.equals(programType)) {

      baseRate = contractServiceDAO
                                   .findContractedRateByIdResourceByDateByService(
                                                                                  rbwoPlacement
                                                                                               .getCapsResourceByIdRsrcFacil()
                                                                                               .getIdResource(),
                                                                                  dtActualEnd, service);
    } else if (CPA.equals(programType)) {
      int childAge = 0;
      childAge = DateHelper.getAge(personDAO.findPersonByIdPerson(pocReturn.getUlIdPerson()).getDtPersonBirth());
      String ageRange = "";
      if (childAge <= 5) {
        ageRange = "005";
      } else if (childAge > 5 && childAge < 13) {
        ageRange = "612";
      } else if (childAge >= 13) {
        ageRange = "13P";
      }
      Date currentDate = new Date();
      double contractedRate = contractServiceDAO
                                                .findContractedRateByIdResourceByDateByService(
                                                                                               rbwoPlacement
                                                                                                            .getCapsResourceByIdRsrcAgency()
                                                                                                            .getIdResource(),
                                                                                               dtActualEnd, service);
      double tableRate = fosterCareRateDAO.findFosterCareRateByAgeDateRangeAndService(ageRange, currentDate, service)
                                          .getAmtFcareRtUnitRate();
      baseRate = tableRate + contractedRate;
    }
    if (baseRate > 0.00) {
      pocReturn.setPerDiemRate(baseRate);
      pocReturn.setTotalPerDiemRate(baseRate + pocReturn.getSpecFcRbwoWaiver());
    } else { // not having the matching service with payment of care being viewed
      return;
    }
  }

  /**
   * find approved CPA placement for the child subject of payment type RBWO or RBWO with waiver at a 
   * certain date.
   * @param idChild
   * @return
   */
  private Placement findCpaPlacement(int idChild, Date dtEffDate, String cdProgType) {
    return placementDAO.findActivePlacementByIdPersonByDateByPlcmntType(idChild, dtEffDate, cdProgType);
  }
  /**
   * find approved placement of any placement Type that comes under the CCI Program for the child subject 
   * of payment type RBWO or RBWO with waiver at a certain date.
   * @param idChild
   * @return
   */
  //STGAP00007334:Added this method to retrieve an approved placement of any placement Type that comes under the CCI Program 
  private Placement findCciPlacement(int idChild, Date dtEffDate, List<String> cdProgTypes) {
    return placementDAO.findActivePlacementByIdPersonByDateByPlcmntTypes(idChild, dtEffDate, cdProgTypes);
  }

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

}
