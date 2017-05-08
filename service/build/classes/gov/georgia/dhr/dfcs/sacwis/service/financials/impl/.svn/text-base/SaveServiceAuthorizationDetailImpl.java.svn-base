package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoptionSubsidyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexSvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CountyBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EquivalencyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;
import gov.georgia.dhr.dfcs.sacwis.db.ContractService;
import gov.georgia.dhr.dfcs.sacwis.db.CountyBudgetLimit;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveCaseBudgetLimitList;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveServiceAuthorizationDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON23SO;

import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD40SO;
import java.util.ArrayList;

/**
 * 
 * <pre>
 *               Change History:
 *                Date        User      Description
 *                ----------  --------  --------------------------------------------------
 *                04/24/08    CWells    STGAP00008181 Only updating Case Budget Limit if 
 *					The Auth is in Pending Status and the Supervisor is 
 *					Changing the amount
 *                06/11/08    mxpatel   STGAP00013508: added "IF" statement to only update the case budget limit if the 
 *                                      Authorization type was NOT "term" on pageload and is "TERM" when "save" is clicked
 *                12/30/09    mchillman Change to support bring up ado application list for Ado 510 - 512 service codes from ser aut detail page   
 *                01/11/2010  arege     STGAP00015696: Passed just the specific service code instead of list of all the 512 service codes getTotalSvcAuthDetailAmountReq()
 *                01/27/2010  mxpatel   SMS #44087:  Added code to verify that the approved amount for Non Recurring services on the Adoption Assistance 
 *                                      Application is strictly adhered to by looking to previously approved and paid Assistance Agreements 
 *                                      and Service Authorization before allowing the Case Manager to Save a new svc auth detail
 *                02/04/2010  mxpatel   SMS #44762:  Added code not to carry out validations (of SMS #44087) when terminating the service auth detail. 
 *                02/10/2010  mxpatel   SMS #44084: Added code to check for existing service auths details and agreements with same type and same amount as the current svc_auth_Dtl.  
 *                02/22/2010  mxpatel   SMS #44084: Added code to consider amount as well when searching for agreements with same type    
 *                03/02/2010  mxpatel   SMS #45293: modified the code so that all service auths will copied from ADO to PAD (including end dated and terminated).  Also
 *                                      added code to make sure approved amount for Non Recurring services on the Adoption Assistance 
 *                                      Application is strictly adhered to by looking to previously approved and paid Assistance Agreements
 *                03/05/2010  mxpatel   SMS #46734: added code to display message MSG_CON_NO_ACTIVE_SERVICE when contract does not have the necessary service for the Svc auth
 *                12/22/2010  cwells    SMS #37224: Removed check for supervisor when updating case budget limit after saving a detail to an pending Service Authorization Header
 * 				  01/31/2012  vcollooru STGAP00017831: MR-102: Modified to make changes to save/retrieve the comments 
 							   			added in the new field Reason for Referral/Other Comments.
 */



public class SaveServiceAuthorizationDetailImpl extends BaseServiceImpl implements SaveServiceAuthorizationDetail {
  private SaveCaseBudgetLimitList saveCaseBudgetLimitList = null;
  
  private AdoptionSubsidyDAO adoptionSubsidyDAO = null;

  private ComplexSvcAuthDetailDAO complexSvcAuthDetailDAO = null;

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  private ContractServiceDAO contractServiceDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private EventDAO eventDAO = null;

  private EquivalencyDAO equivalencyDAO = null;

  private TodoCommonFunction todoCommonFunction = null;
  
  private CountyBudgetLimitDAO countyBudgetLimitDAO = null;
  
  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO = null;  
  
  public void setAdoptionSubsidyDAO(AdoptionSubsidyDAO adoptionSubsidyDAO) {
    this.adoptionSubsidyDAO = adoptionSubsidyDAO;
  }

  public void setCountyBudgetLimitDAO(CountyBudgetLimitDAO countyBudgetLimitDAO) {
    this.countyBudgetLimitDAO = countyBudgetLimitDAO;
  }

  public void setComplexSvcAuthDetailDAO(ComplexSvcAuthDetailDAO complexSvcAuthDetailDAO) {
    this.complexSvcAuthDetailDAO = complexSvcAuthDetailDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setEquivalencyDAO(EquivalencyDAO equivalencyDAO) {
    this.equivalencyDAO = equivalencyDAO;
  }

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public void setSaveCaseBudgetLimitList(SaveCaseBudgetLimitList saveCaseBudgetLimitList) {
    this.saveCaseBudgetLimitList = saveCaseBudgetLimitList;
  }

  public CCON23SO saveServiceAuthorizationDetail(CCON23SI ccon23si) throws ServiceException {
    CCON23SO ccon23so = new CCON23SO();
    ArchInputStruct archInputStruct = ccon23si.getArchInputStruct();
    int idEvent = ccon23si.getUlIdEvent();
    int idCase = ccon23si.getUlIdCase();
    String cdStage = ccon23si.getSzCdStage();
    
    ROWCCON23SIG00_ARRAY rowccon23sig00_array = ccon23si.getROWCCON23SIG00_ARRAY();
    Enumeration rowccon23sig00_enum = rowccon23sig00_array.enumerateROWCCON23SIG00();
    while (rowccon23sig00_enum.hasMoreElements()) {
      ROWCCON23SIG00 rowccon23sig00 = (ROWCCON23SIG00) rowccon23sig00_enum.nextElement();
      org.exolab.castor.types.Date rowccon23sig00DtSvcAuthDtlBegin = rowccon23sig00.getDtDtSvcAuthDtlBegin();
      org.exolab.castor.types.Date rowccon23sig00DtSvcAuthDtlEnd = rowccon23sig00.getDtDtSvcAuthDtlEnd();
      org.exolab.castor.types.Date rowccon23sig00DtSvcAuthDtlTerm = rowccon23sig00.getDtDtSvcAuthDtlTerm();
      String rowccon23sig00CdSvcAuthDtlSvc = rowccon23sig00.getSzCdSvcAuthDtlSvc();
      int rowccon23sig00IdPerson = rowccon23sig00.getUlIdPerson();
      if (CodesTables.CSVATYPE_INI.equals(rowccon23sig00.getSzCdSvcAuthDtlAuthType())
          || CodesTables.CSVATYPE_ONT.equals(rowccon23sig00.getSzCdSvcAuthDtlAuthType())) {
        // Call CMSC52D
        // select from Non_equivalency table
        long equivCount = equivalencyDAO
                                        .countExemptServiceCodeFromNonEquivalency(
                                                                                  rowccon23sig00CdSvcAuthDtlSvc,
                                                                                  DateHelper
                                                                                            .toJavaDate(rowccon23sig00DtSvcAuthDtlBegin),
                                                                                  DateHelper
                                                                                            .toJavaDate(rowccon23sig00DtSvcAuthDtlEnd));
        org.exolab.castor.types.Date ccon23siDtStageStart = ccon23si.getDtDtStageStart();
        if (!(equivCount >= 1)) {
          // This means the Service doesn't exist on the Non_Equivalency
          // table and is therefore not exempt from the new equivalency edits
          if (!DateHelper.isBefore(rowccon23sig00DtSvcAuthDtlBegin, ccon23siDtStageStart)) {
            // This means the svc_auth begin date is on or after the
            // stage start date; we will only need to call the
            // Equivalency table once
            equivCount = equivalencyDAO
                                       .countExistenceOfServiceCodeForGivenTimeAndStage(
                                                                                        rowccon23sig00CdSvcAuthDtlSvc,
                                                                                        DateHelper
                                                                                                  .toJavaDate(rowccon23sig00DtSvcAuthDtlBegin),
                                                                                        DateHelper
                                                                                                  .toJavaDate(rowccon23sig00DtSvcAuthDtlEnd),
                                                                                        idEvent);
          } else {
            // The svc auth starts before the stage start date
            // Check to make sure the Svc Auth Ends after the Stage Start Date
            if (DateHelper.isAfter(rowccon23sig00DtSvcAuthDtlEnd, ccon23siDtStageStart)) {
              equivCount = equivalencyDAO
                                         .countExistenceOfServiceCodeForGivenTimeAndStage(
                                                                                          rowccon23sig00CdSvcAuthDtlSvc,
                                                                                          DateHelper
                                                                                                    .toJavaDate(ccon23siDtStageStart),
                                                                                          DateHelper
                                                                                                    .toJavaDate(rowccon23sig00DtSvcAuthDtlEnd),
                                                                                          idEvent);
            } else {
              equivCount = 1;
            }
            if (equivCount >= 1) {
              // The first call to the Equiv was successful - This means
              // that the time period from the stage start to the svc auth
              // end was validated; now we need to validate from the
              // svc auth start to the stage start
              Date dtEquivEndDate = DateHelper.toJavaDate(rowccon23sig00DtSvcAuthDtlEnd);
              // We want the lesser of Stage Start and Svc Auth End
              // if (dateCompare > 0){
              if (DateHelper.isAfter(rowccon23sig00DtSvcAuthDtlEnd, ccon23siDtStageStart)) {
                dtEquivEndDate = DateHelper.toJavaDate(ccon23siDtStageStart);
              }
              equivCount = equivalencyDAO
                                         .countExistenceOfServiceCodeWhenSvAuthBeforeStageStart(
                                                                                                rowccon23sig00CdSvcAuthDtlSvc,
                                                                                                DateHelper
                                                                                                          .toJavaDate(rowccon23sig00DtSvcAuthDtlBegin),
                                                                                                dtEquivEndDate,
                                                                                                rowccon23sig00IdPerson);

            }
          }
        }
      }

      int idAdopAsstAppl = rowccon23sig00.getUlIdAdopAssistAppl();
      String cdSvcDtlService = rowccon23sig00.getSzCdSvcAuthDtlSvc();
      double reqAmount = rowccon23sig00.getLAmtSvcAuthDtlAmtReq();
      SpecialNeedsDetermination snd = null;
      if (idAdopAsstAppl > 0) {
        snd = getPersistentObject(SpecialNeedsDetermination.class,
                                                            rowccon23sig00.getUlIdAdopAssistAppl());

        // MR-52 Verify that Begin and End dates fall within the approval period dates of attached application.
        Date apprvBeginDate = snd.getDtApprvDate();
        Date apprvEndDate = snd.getDtExpirationDate();
        org.exolab.castor.types.Date apprvBeginDateCastor = DateHelper.toCastorDate(apprvBeginDate);
        org.exolab.castor.types.Date apprvEndDateCastor = DateHelper.toCastorDate(apprvEndDate);
        Date dtToday = new Date();
        if (cdSvcDtlService.startsWith("512")) {
          if (DateHelper.isBefore(rowccon23sig00DtSvcAuthDtlBegin, apprvBeginDateCastor)
              || DateHelper.isAfter(rowccon23sig00DtSvcAuthDtlBegin, apprvEndDateCastor)
              || DateHelper.isAfter(rowccon23sig00DtSvcAuthDtlEnd, apprvEndDateCastor)
              || DateHelper.isBefore(rowccon23sig00DtSvcAuthDtlEnd, apprvBeginDateCastor)) {
            throw new ServiceException(Messages.MSG_SP_SVC_SA_DATES);
          }

          // MR-52 User attempts to save a Special Services Service Authorization and the amount exceeds the
          // approved Special Services amount from the associated Adoption Assistance Application
          double approvedAmount = 0;
          approvedAmount = snd.getNbrApprvAmt();
          if (reqAmount > approvedAmount) {
            throw new ServiceException(Messages.MSG_SA_AMT_EXCEEDS_AAA);
          }

          // MR-52 Verify User attempts to save a Special Services Service Authorization that is associated with an
          // Adoption Assistance Application
          // that is currently associated with an active (non terminated) Special Services Service Authorization
          // AND the Service Authorization amount exceeds the approved amount on the associated Adoption Assistance
          // Application.
          List<String> cdSvcDtlServiceList = new ArrayList<String>();
          cdSvcDtlServiceList.add(cdSvcDtlService);

          Double usedAmount = svcAuthDetailDAO.getTotalSvcAuthDetailAmountReq(idAdopAsstAppl, cdSvcDtlServiceList,
                                                                              dtToday,
                                                                              rowccon23sig00.getUlIdSvcAuthDtl());
          
          Double usedAmountTerm = svcAuthDetailDAO.getTotalSvcAuthDetailAmountUsed(idAdopAsstAppl, cdSvcDtlServiceList,
                                                                                  dtToday,
                                                                                  rowccon23sig00.getUlIdSvcAuthDtl());
          if (usedAmount == null) {
            usedAmount = 0.0;
          }

          if (usedAmountTerm == null) {
            usedAmountTerm = 0.0;
          }
          if ((usedAmount + reqAmount + usedAmountTerm) > approvedAmount) {
            throw new ServiceException(Messages.MSG_SA_AMT_WILL_EXCEED_AAA);
          }
        }
      }      
     
        // check for the only in PAD stage for non-recurring svc auth details
      if ((CodesTables.CSTAGES_PAD.equals(cdStage))
          && (CodesTables.CSVCCODE_51033A.equals(rowccon23sig00.getSzCdSvcAuthDtlSvc())
              || CodesTables.CSVCCODE_51033B.equals(rowccon23sig00.getSzCdSvcAuthDtlSvc()) || CodesTables.CSVCCODE_51033C
                                                                                                                         .equals(rowccon23sig00
                                                                                                                                               .getSzCdSvcAuthDtlSvc()))) {
        if (!CodesTables.CSVATYPE_TRM.equals(rowccon23sig00.getSzCdSvcAuthDtlAuthType())) {

          // check for any other service auth details with the same amount and type
          List<String> cdSvcAuthDtlSvc = new ArrayList<String>();
          String cdEventType = CodesTables.CEVNTTYP_AUT;
          if (CodesTables.CADOSVCD_51033A.equals(rowccon23sig00.getSzCdSvcAuthDtlSvc())) {
            cdSvcAuthDtlSvc.add(CodesTables.CADOSVCD_51033A);
            List<SvcAuthDetail> svcAuthDtls = svcAuthDetailDAO
                                                              .findSvcAuthDtlByIdPersonForSvcAuthDtl(
                                                                                                     rowccon23sig00
                                                                                                                   .getUlIdPerson(),
                                                                                                     rowccon23sig00
                                                                                                                   .getUlIdSvcAuthDtl(),
                                                                                                     cdEventType,
                                                                                                     ccon23si
                                                                                                             .getUlIdStage(),
                                                                                                     cdSvcAuthDtlSvc,
                                                                                                     rowccon23sig00
                                                                                                                   .getLAmtSvcAuthDtlAmtReq());
            // check for ado_subsidy of the same type
            List<String> cdAdoptionType = new ArrayList<String>();
            Date dtEffective = DateHelper.toJavaDate(rowccon23sig00.getDtDtSvcAuthDtlBegin());
            Date dtTerm = DateHelper.toJavaDate(rowccon23sig00.getDtDtSvcAuthDtlTerm());
            cdAdoptionType.add(CodesTables.CSUBTYPE_22);
            List<AdoptionSubsidy> adoSub = adoptionSubsidyDAO
                                                             .findActiveAdoptionSubsidyByIdPersonCdAdoptionTypeOfSvcAuthDtl(
                                                                                                                            idCase,
                                                                                                                            rowccon23sig00
                                                                                                                                          .getUlIdPerson(),
                                                                                                                            cdAdoptionType,
                                                                                                                            dtEffective,
                                                                                                                            dtTerm,
                                                                                                                            rowccon23sig00
                                                                                                                                          .getLAmtSvcAuthDtlAmtReq());

            if ((svcAuthDtls != null && svcAuthDtls.size() > 0) || (adoSub != null && adoSub.size() > 0)) {
              ccon23so.setDAmtActiveNonRecurrAdopLegalFees(rowccon23sig00.getLAmtSvcAuthDtlAmtReq());
              ccon23so.setBIndActiveNonRecurrAdopLegalFeesExists(ArchitectureConstants.Y);
            }
          }
          
          
          if (CodesTables.CADOSVCD_51033B.equals(rowccon23sig00.getSzCdSvcAuthDtlSvc())) {
            cdSvcAuthDtlSvc.clear();
            cdSvcAuthDtlSvc.add(CodesTables.CADOSVCD_51033B);
            List<SvcAuthDetail> svcAuthDtls = svcAuthDetailDAO
                                                              .findSvcAuthDtlByIdPersonForSvcAuthDtl(
                                                                                                     rowccon23sig00
                                                                                                                   .getUlIdPerson(),
                                                                                                     rowccon23sig00
                                                                                                                   .getUlIdSvcAuthDtl(),
                                                                                                     cdEventType,
                                                                                                     ccon23si
                                                                                                             .getUlIdStage(),
                                                                                                     cdSvcAuthDtlSvc,
                                                                                                     rowccon23sig00
                                                                                                                   .getLAmtSvcAuthDtlAmtReq());
            // check for ado_subsidy of the same type
            List<String> cdAdoptionType = new ArrayList<String>();
            Date dtEffective = DateHelper.toJavaDate(rowccon23sig00.getDtDtSvcAuthDtlBegin());
            Date dtTerm = DateHelper.toJavaDate(rowccon23sig00.getDtDtSvcAuthDtlTerm());
            cdAdoptionType.clear();
            cdAdoptionType.add(CodesTables.CSUBTYPE_25);
            List<AdoptionSubsidy> adoSub = adoptionSubsidyDAO
                                                             .findActiveAdoptionSubsidyByIdPersonCdAdoptionTypeOfSvcAuthDtl(
                                                                                                                            idCase,
                                                                                                                            rowccon23sig00
                                                                                                                                          .getUlIdPerson(),
                                                                                                                            cdAdoptionType,
                                                                                                                            dtEffective,
                                                                                                                            dtTerm,
                                                                                                                            rowccon23sig00
                                                                                                                                          .getLAmtSvcAuthDtlAmtReq());

            if ((svcAuthDtls != null && svcAuthDtls.size() > 0) || (adoSub != null && adoSub.size() > 0)) {
              ccon23so.setDAmtActiveNonRecurrPhyAdopParent(rowccon23sig00.getLAmtSvcAuthDtlAmtReq());
              ccon23so.setBIndActiveNonRecurrPhyAdopParentExists(ArchitectureConstants.Y);
            }
          }

          if (CodesTables.CADOSVCD_51033C.equals(rowccon23sig00.getSzCdSvcAuthDtlSvc())) {
            cdSvcAuthDtlSvc.clear();
            cdSvcAuthDtlSvc.add(CodesTables.CADOSVCD_51033C);
            List<SvcAuthDetail> svcAuthDtls = svcAuthDetailDAO
                                                              .findSvcAuthDtlByIdPersonForSvcAuthDtl(
                                                                                                     rowccon23sig00
                                                                                                                   .getUlIdPerson(),
                                                                                                     rowccon23sig00
                                                                                                                   .getUlIdSvcAuthDtl(),
                                                                                                     cdEventType,
                                                                                                     ccon23si
                                                                                                             .getUlIdStage(),
                                                                                                     cdSvcAuthDtlSvc,
                                                                                                     rowccon23sig00
                                                                                                                   .getLAmtSvcAuthDtlAmtReq());
            // check for ado_subsidy of the same type
            List<String> cdAdoptionType = new ArrayList<String>();
            Date dtEffective = DateHelper.toJavaDate(rowccon23sig00.getDtDtSvcAuthDtlBegin());
            Date dtTerm = DateHelper.toJavaDate(rowccon23sig00.getDtDtSvcAuthDtlTerm());
            cdAdoptionType.clear();
            cdAdoptionType.add(CodesTables.CSUBTYPE_23);
            List<AdoptionSubsidy> adoSub = adoptionSubsidyDAO
                                                             .findActiveAdoptionSubsidyByIdPersonCdAdoptionTypeOfSvcAuthDtl(
                                                                                                                            idCase,
                                                                                                                            rowccon23sig00
                                                                                                                                          .getUlIdPerson(),
                                                                                                                            cdAdoptionType,
                                                                                                                            dtEffective,
                                                                                                                            dtTerm,
                                                                                                                            rowccon23sig00
                                                                                                                                          .getLAmtSvcAuthDtlAmtReq());

            if ((svcAuthDtls != null && svcAuthDtls.size() > 0) || (adoSub != null && adoSub.size() > 0)) {
              ccon23so.setDAmtActiveNonRecurrTravel(rowccon23sig00.getLAmtSvcAuthDtlAmtReq());
              ccon23so.setBIndActiveNonRecurrTravelExists(ArchitectureConstants.Y);
            }
            cdAdoptionType.clear();
            cdAdoptionType.add(CodesTables.CSUBTYPE_24);
            List<AdoptionSubsidy> adoSubList = adoptionSubsidyDAO
                                                                 .findActiveAdoptionSubsidyByIdPersonCdAdoptionTypeOfSvcAuthDtl(
                                                                                                                                idCase,
                                                                                                                                rowccon23sig00
                                                                                                                                              .getUlIdPerson(),
                                                                                                                                cdAdoptionType,
                                                                                                                                dtEffective,
                                                                                                                                dtTerm,
                                                                                                                                rowccon23sig00
                                                                                                                                              .getLAmtSvcAuthDtlAmtReq());

            if ((svcAuthDtls != null && svcAuthDtls.size() > 0) || (adoSubList != null && adoSubList.size() > 0)) {
              ccon23so.setDAmtActiveNonRecurrLogMeals(rowccon23sig00.getLAmtSvcAuthDtlAmtReq());
              ccon23so.setBIndActiveNonRecurrLogMealsExists(ArchitectureConstants.Y);
            }
          }

          // get the id_Ado_asst_application for the non_recurring application that is attached to the svs_auth_dtl
          int idAdoApplication = rowccon23sig00.getUlIdAdopAssistAppl();

          // get the total amount for current service_auth
          Double amountAgreement = 0.0;
          Double usedAmount = 0.0;
          Double usedAmountTerm = 0.0;

          SpecialNeedsDetermination specialNeedsNonRec = null;
          specialNeedsNonRec = specialNeedsDeterminationDAO.findSpecNeedsDeterByIdSpcNeedsDeter(idAdoApplication);

          if (specialNeedsNonRec != null) {
            ccon23so.setDAmtNonRecLimit(specialNeedsNonRec.getNbrNonRecAmt());
          }

          // for the application find all the other service auths attached
          List<Integer> idAgreements = new ArrayList<Integer>();

          if (specialNeedsNonRec != null) {

            List<String> cdSvcDtlServiceList = new ArrayList<String>();
            cdSvcDtlServiceList.clear();
            cdSvcDtlServiceList.add(CodesTables.CSVCCODE_51033A);
            cdSvcDtlServiceList.add(CodesTables.CSVCCODE_51033B);
            cdSvcDtlServiceList.add(CodesTables.CSVCCODE_51033C);
            cdEventType = CodesTables.CEVNTTYP_AUT;
            Date dtToday = new Date();
            usedAmount = svcAuthDetailDAO.getTotalSvcAuthDetailAmountReqFor510(idAdopAsstAppl, cdSvcDtlServiceList,
                                                                               dtToday,
                                                                               rowccon23sig00.getUlIdSvcAuthDtl(),
                                                                               cdEventType);
            if (usedAmount == null) {
              usedAmount = 0.0;
            }

            usedAmountTerm = svcAuthDetailDAO
                                             .getTotalSvcAuthDetailAmountReqFor510Term(
                                                                                       idAdopAsstAppl,
                                                                                       cdSvcDtlServiceList,
                                                                                       dtToday,
                                                                                       rowccon23sig00
                                                                                                     .getUlIdSvcAuthDtl(),
                                                                                       cdEventType);
            if (usedAmountTerm == null) {
              usedAmountTerm = 0.0;
            }

            // find the total of all agreements attached to this application
            String cdEventStatus = CodesTables.CEVTSTAT_COMP;
            cdEventType = CodesTables.CEVNTTYP_ADP;
            String cdPaymentMthd = CodesTables.CPAYMTHD_PAR;
            List<String> cdSpclAsstType = new ArrayList<String>();
            cdSpclAsstType.add(CodesTables.CSUBTYPE_22);
            cdSpclAsstType.add(CodesTables.CSUBTYPE_23);
            cdSpclAsstType.add(CodesTables.CSUBTYPE_24);
            cdSpclAsstType.add(CodesTables.CSUBTYPE_25);
            amountAgreement = adoptionSubsidyDAO.getTotalAgreementAmountUsed(idAdoApplication, ccon23si.getUlIdStage(),
                                                                             cdEventStatus, cdEventType, cdPaymentMthd,
                                                                             cdSpclAsstType);
            if (amountAgreement == null) {
              amountAgreement = 0.0;
            }
          }
          Double totalAmount = usedAmount + usedAmountTerm + amountAgreement + rowccon23sig00.getLAmtSvcAuthDtlAmtReq();

          if (specialNeedsNonRec != null) {
            if (totalAmount > specialNeedsNonRec.getNbrNonRecAprvAmt()) {
              ccon23so.setBIndOverSpendingLimitPad(ArchitectureConstants.Y);
              return ccon23so;
            }
          }
        }
      }
      
      int rowccon23sig00IdSvcAuthDtl = rowccon23sig00.getUlIdSvcAuthDtl();
      int rowccon23sig00NbrSvcAuthDtlLineItm = rowccon23sig00.getUlNbrSvcAuthDtlLineItm();
      // STGAP00006287: Removing the validation to check if there is a service Authorization
      // record for the same service for the same client as per the change request
      // Call CSES36D
        int idContract = ccon23si.getUlIdContract();
        ContractService contractService = contractServiceDAO
                                                            .findContractServiceByIdContract(
                                                                                             ccon23si
                                                                                                     .getUlNbrCnperPeriod(),
                                                                                             ccon23si
                                                                                                     .getUlNbrCnverVersion(),
                                                                                             rowccon23sig00NbrSvcAuthDtlLineItm,
                                                                                             idContract,
                                                                                             rowccon23sig00CdSvcAuthDtlSvc);
        if (contractService == null) {
          throw new ServiceException(Messages.MSG_CON_NO_ACTIVE_SERVICE);
        }
        String ccon23siIndCntrctBudgLimit = ccon23si.getCIndCntrctBudgLimit();
        // Only return MSG_CON_NEG_SVC_BALANCE if Contract has a budget limit BSM
        // fix NPE in R2 page stand-up. Coder should look at business logic to decide set the 'amt' variables to 0
        // or check it against null which will skip call ToDoCommonFunction
        // Set it to 0 when NULL based on C convention initializing numeric field to 0
        Double amtCnsvcUnitRate = contractService.getAmtCnsvcUnitRate() != null ? contractService.getAmtCnsvcUnitRate()
                                                                               : 0;
        Double amtCnsvcUnitRateUsed = contractService.getAmtCnsvcUnitRateUsed() != null ? contractService
                                                                                                         .getAmtCnsvcUnitRateUsed()
                                                                                       : 0;
        // (amtCnsvcUnitRate != null && amtCnsvcUnitRateUsed != null) &&
        // end NPE fix

        if (!((amtCnsvcUnitRate - amtCnsvcUnitRateUsed) < rowccon23sig00.getLAmtSvcAuthDtlAmtReq() && ArchitectureConstants.Y
                                                                                                                             .equals(ccon23siIndCntrctBudgLimit))) {
          // if Amount requested is not greater than the balance
          // if the Amount requested plus the Unit Rate Used divided
          // by the Unit rate is greater than 85% processing
          // Note: The Amount requested cannot decrease to remaining
          // balance to less than 15% of the total balance
          if (BUDGET_PCT < ((rowccon23sig00.getLAmtSvcAuthDtlAmtReq() + amtCnsvcUnitRateUsed) / amtCnsvcUnitRate)
              && ArchitectureConstants.Y.equals(ccon23siIndCntrctBudgLimit)) {
            // Preparing to call TodoCommonFunction
            CSUB40UI csub40ui = new CSUB40UI();
            csub40ui.setArchInputStruct(archInputStruct);
            CSUB40UIG00 csub40uig00 = new CSUB40UIG00();
            csub40uig00.setSzSysCdTodoCf(ccon23si.getSzSysCdTodoCf());
            csub40uig00.setUlSysIdTodoCfPersAssgn(ccon23si.getUlIdCntrctManager());
            csub40uig00.setUlSysIdTodoCfPersCrea(ccon23si.getUlIdPerson());
            csub40uig00.setUlSysIdTodoCfStage(ccon23si.getUlIdStage());
            csub40uig00.setDtSysDtTodoCfDueFrom(DateHelper.getTodayCastorDate());
            csub40uig00.setSzSysTxtTodoCfDesc("The budget for Contract " + idContract + " Svc "
                                              + (rowccon23sig00CdSvcAuthDtlSvc) + " is expended.");
            csub40ui.setCSUB40UIG00(csub40uig00);
            // This call will handle any exception that takes place while processing
            todoCommonFunction.audTodo(csub40ui);
          }
        }
      // Updating CaseBudgetLimit table when the service auth is in pending status and the svcauthdetail is modified.
      // Begin Case Budget limit update
      Event event = eventDAO.findEventByIdEvent(idEvent);
      SvcAuthDetail svcAuthDtl = new SvcAuthDetail();
      // STGAP00008181 Check if the corresponding service auth header is in pending status
      // SMS 37224 - Since the Service Auth is not invalidated when a CM enters a additional svc auth detail
      // We need to update the case budget limit even when not in approval mode. 
      if (CodesTables.CEVTSTAT_PEND.equals(event.getCdEventStatus())){
        // Check if the service code updated service code has budget limits
        String bdgtLimit = Lookup.simpleDecodeSafe(CodesTables.CSBGTLMT, rowccon23sig00CdSvcAuthDtlSvc);
        if (bdgtLimit != null) {
          double prevAmountReq = 0.0;
          // If the service auth detail is an existing one then get the difference of the previous requested
          // amount and the updated amount
          if (rowccon23sig00IdSvcAuthDtl != 0) {
            svcAuthDtl = svcAuthDetailDAO.findSvcAuthDetail(rowccon23sig00IdSvcAuthDtl);
            prevAmountReq = svcAuthDtl.getAmtSvcAuthDtlAmtReq();
          }
          double diffAmtReq = rowccon23sig00.getLAmtSvcAuthDtlAmtReq() - prevAmountReq;
          CaseBudgetLimitSaveSI csBdgtSaveSI = new CaseBudgetLimitSaveSI();
          // Populate the SI object
          csBdgtSaveSI.setUlIdCase(idCase);
          csBdgtSaveSI.setUlIdEvent(idEvent);
          csBdgtSaveSI.setSvcCode(rowccon23sig00CdSvcAuthDtlSvc);
          csBdgtSaveSI.setAmtReq(diffAmtReq);
          csBdgtSaveSI.setModeIndicator(CodesTables.CEVTSTAT_COMP);
          saveCaseBudgetLimitList.saveCaseBudgetLimitList(csBdgtSaveSI);
        }
      } else if (CodesTables.CEVTSTAT_APRV.equals(event.getCdEventStatus())
                 && DateHelper.isBefore(DateHelper.toJavaDate(rowccon23sig00DtSvcAuthDtlTerm),
                                        DateHelper.toJavaDate(rowccon23sig00DtSvcAuthDtlEnd))) {
          CaseBudgetLimitSaveSI csBdgtSaveSI = new CaseBudgetLimitSaveSI();
          // Populate the SI object
          csBdgtSaveSI.setUlIdCase(idCase);
          csBdgtSaveSI.setUlIdEvent(idEvent);
          csBdgtSaveSI.setSvcCode(rowccon23sig00CdSvcAuthDtlSvc);
          double amtReq = rowccon23sig00.getLAmtSvcAuthDtlAmtReq();
          csBdgtSaveSI.setAmtReq(amtReq);
          csBdgtSaveSI.setModeIndicator(CodesTables.CSVATYPE_TRM);
          csBdgtSaveSI.setIndReferralRejection(rowccon23sig00.getIndServAcpt());
          double unitRate = rowccon23sig00.getLNbrSvcAuthDtlUnitRate();
          double unitsUsed = rowccon23sig00.getLNbrSvcAuthDtlUnitUsed();
          double amtSpent = unitRate * unitsUsed ;
          csBdgtSaveSI.setAmtSpent(amtSpent);
          // mxpatel added this for defect #STGAP00013508 to only update the case budget limit if the Authorization type
          // was NOT "term" on pageload and is "TERM" when "save" is clicked
        if (!CodesTables.CSVATYPE_TRM.equals(ccon23si.getHdnSzCdSvcAuthDtlAuthType())
            && CodesTables.CSVATYPE_TRM.equals(rowccon23sig00.getSzCdSvcAuthDtlAuthType())) {
          saveCaseBudgetLimitList.saveCaseBudgetLimitList(csBdgtSaveSI);
        }
        //Update the county Budget Limit Table if for the prog code effective date and the county combo 
        //there is a corresponding row in county budget limit table.
        //Begin County Budget update
        ServiceAuthorization serviceAuthorization = (ServiceAuthorization) getPersistentObject(
                                                                                               ServiceAuthorization.class,
                                                                                               rowccon23sig00
                                                                                                             .getUlIdSvcAuth());
        String county = serviceAuthorization.getCdPayCnty();
        String program = serviceAuthorization.getCdSvcAuthCategory();
        Date effectivedate = serviceAuthorization.getDtSvcAuthEff();
        int month = DateHelper.getMonth(effectivedate);
        int year = DateHelper.getYear(effectivedate);
        if(month>6){
          year = year+1;
        }
        CountyBudgetLimit cntyBdgtlmt = countyBudgetLimitDAO.findCountyBudgetLimitByProgramAndFiscalYear(county,program,year);        
        if(cntyBdgtlmt!=null){
          double amtRemaining = amtReq - amtSpent;
          cntyBdgtlmt.setAmtObg(cntyBdgtlmt.getAmtObg()-amtRemaining);
          cntyBdgtlmt.setAmtBalance(cntyBdgtlmt.getAmtBalance()+ amtRemaining);
          countyBudgetLimitDAO.saveOrUpdateCountyBudgetLimit(cntyBdgtlmt);
        }
        //end County Budget update
      }
      // end Case Budget limit update
      // CAUD13D
      SvcAuthDetail newSvcAuthDetail = new SvcAuthDetail();
      String szCdScrDataAction = rowccon23sig00.getSzCdScrDataAction();
      if (rowccon23sig00IdSvcAuthDtl != 0 && CodesTables.CEVTSTAT_PEND.equals(event.getCdEventStatus())) {
        newSvcAuthDetail = svcAuthDtl;
      }
      newSvcAuthDetail.setIdSvcAuthDtl(rowccon23sig00IdSvcAuthDtl);
      newSvcAuthDetail.setDtLastUpdate(rowccon23sig00.getTsLastUpdate());
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdScrDataAction)
          || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdScrDataAction)) {
        newSvcAuthDetail.setCdSvcAuthDtlAuthType(rowccon23sig00.getSzCdSvcAuthDtlAuthType());
        newSvcAuthDetail.setCdSvcAuthDtlPeriod(rowccon23sig00.getSzCdSvcAuthDtlPeriod());
        newSvcAuthDetail.setCdSvcAuthDtlSvc(rowccon23sig00CdSvcAuthDtlSvc);
        newSvcAuthDetail.setCdSvcAuthDtlUnitType(rowccon23sig00.getSzCdSvcAuthDtlUnitType());
        newSvcAuthDetail.setDtSvcAuthDtl(DateHelper.toJavaDate(rowccon23sig00.getDtDtSvcAuthDtl()));
        newSvcAuthDetail.setDtSvcAuthDtlBegin(DateHelper.toJavaDate(rowccon23sig00DtSvcAuthDtlBegin));
        newSvcAuthDetail.setDtSvcAuthDtlEnd(DateHelper.toJavaDate(rowccon23sig00DtSvcAuthDtlEnd));
        newSvcAuthDetail.setDtSvcAuthDtlTerm(DateHelper.toJavaDate(rowccon23sig00DtSvcAuthDtlTerm));
        newSvcAuthDetail.setDtSvcAuthDtlShow(DateHelper.toJavaDate(rowccon23sig00.getDtSvcAuthDtlShow()));
        if (rowccon23sig00IdPerson != 0) {
          Person svcAuthPerson = (Person) getPersistentObject(Person.class, rowccon23sig00IdPerson);
          newSvcAuthDetail.setPerson(svcAuthPerson);
        }
        if (rowccon23sig00.getUlIdSvcAuth() != 0) {
          ServiceAuthorization serviceAuthorization = (ServiceAuthorization) getPersistentObject(
                                                                                                 ServiceAuthorization.class,
                                                                                                 rowccon23sig00
                                                                                                               .getUlIdSvcAuth());
          newSvcAuthDetail.setServiceAuthorization(serviceAuthorization);

        }
        newSvcAuthDetail.setAmtSvcAuthDtlAmtReq(rowccon23sig00.getLAmtSvcAuthDtlAmtReq());
        newSvcAuthDetail.setNbrSvcAuthDtlFreq(rowccon23sig00.getUNbrSvcAuthDtlFreq());
        newSvcAuthDetail.setNbrSvcAuthDtlLineItm(rowccon23sig00NbrSvcAuthDtlLineItm);
        newSvcAuthDetail.setNbrSvcAuthDtlSugUnit(rowccon23sig00.getLNbrSvcAuthDtlSugUnit());
        newSvcAuthDetail.setNbrSvcAuthDtlUnitUsed(rowccon23sig00.getLNbrSvcAuthDtlUnitUsed());
        newSvcAuthDetail.setAmtSvcAuthDtlAmtUsed(rowccon23sig00.getLNbrSvcAuthDtlUnitRate() * rowccon23sig00.getLNbrSvcAuthDtlUnitUsed());
        newSvcAuthDetail.setNbrSvcAuthDtlUnitRate(rowccon23sig00.getLNbrSvcAuthDtlUnitRate());
        newSvcAuthDetail.setNbrSvcAuthDtlUnitsReq(rowccon23sig00.getLNbrSvcAuthDtlUnitReq());
        newSvcAuthDetail.setIndServAcpt(rowccon23sig00.getIndServAcpt());
        newSvcAuthDetail.setIndCasePlnSvc(rowccon23sig00.getIndCasePlanSvc());
        newSvcAuthDetail.setCdSvcQlty(rowccon23sig00.getSzCdSvcQlty());
        newSvcAuthDetail.setTxtCmmts(rowccon23sig00.getSzTxtRefQltyCmnts());
        newSvcAuthDetail.setTxtCmmtsAdditional(rowccon23sig00.getSzTxtCommentsAdditional());
        if(rowccon23sig00.getUlIdAdopAssistAppl() > 0) {
          newSvcAuthDetail.setSpecialNeedsDetermination(getPersistentObject(SpecialNeedsDetermination.class, rowccon23sig00.getUlIdAdopAssistAppl()));
        }
        complexSvcAuthDetailDAO.saveSvcAuthDetail(newSvcAuthDetail);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(szCdScrDataAction)) {
        svcAuthDetailDAO.deleteSvcAuthDetail(newSvcAuthDetail);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }

      // Call CCMN68D if the Service Auth Detail window Mode is NEW.(i.e. ulIdSvcAuthDtl = 0)
      if (0 == rowccon23sig00IdSvcAuthDtl) {
        EventPersonLink eventPersonLink = eventPersonLinkDAO
                                                            .findEventPersonLinkByIdEventAndIdPerson(idEvent,
                                                                                                     rowccon23sig00IdPerson);
        // only insert if that person and this type of service have never been linked
        if (eventPersonLink == null) {
          int insertedRows = eventPersonLinkDAO.insertEventPersonLink(idEvent, rowccon23sig00IdPerson);
          if (0 == insertedRows) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
        }

      }
    }
    return ccon23so;
  }
}
