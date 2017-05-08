/**
 * Created on Jun 28, 2006 at 10:11:43 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AAFundingSummaryRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.BatchContractServiceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.BudgetUpdateSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContractCountiesSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CountyBudgetLimitRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CountyBudgetLimitSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DtLicBeginSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RestrictedFundsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RestrictedFundsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveProgramCodeServicesSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecialNeedsDeterminationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecialNeedsDeterminationSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TCMClaimSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TCMClaimValidateSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TCMClaimsSearchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UASProgramCodeMtntRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UASProgramCodeMtntSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.VendorOutboundSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AAFundingSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.BatchContractServiceSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.BudgetUpdateSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON20SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON22SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD40SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN20SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseBudgetLimitRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseBudgetLimitSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContractCountiesSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CountyBudgetLimitRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DtLicBeginSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PolicyWaiverRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RestrictedFundsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveProgramCodeServicesSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpecialNeedsDeterminationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpecialNeedsDeterminationSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TCMClaimSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TCMClaimValidateSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TCMClaimsSearchSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeMtntRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeMtntSaveSO;

import java.util.List;

import javax.ejb.CreateException;

@SuppressWarnings("serial")
public class FinancialsBean extends BaseSpringStatelessSessionBean implements Financials {
  private SaveBatchContractServiceRows saveBatchContractServiceRows;
  
  private RetrieveProgramCodeServices retrieveProgramCodeServices;
  
  private ContractValidation contractValidation;

  private CountyBudgetLimitDetailValidation countyBudgetLimitDetailValidation;

  private DeliveredServiceValidation deliveredServiceValidation;

  private FosterCareDetailValidation fosterCareDetailValidation;

  private RetrieveAAFundingSummary retrieveAAFundingSummary;
  
  private RetrieveAdminDetail retrieveAdminDetail;

  private RetrieveAdoptionSubsidy retrieveAdoptionSubsidy;

  private RetrieveBudgetTransfer retrieveBudgetTransfer;
  
  private RetrieveCnperStart retrieveCnperStart;

  private RetrieveContract retrieveContract;
  
  private RetrieveContractCounties retrieveContractCounties;

  private RetrieveContractList retrieveContractList;

  private RetrieveContractPeriod retrieveContractPeriod;

  private RetrieveContractService retrieveContractService;

  private RetrieveContractVersion retrieveContractVersion;

  private RetrieveCostReimbursementDetail retrieveCostReimbursementDetail;

  private RetrieveCountyBudgetLimitDetail retrieveCountyBudgetLimitDetail;

  private RetrieveCountyBudgetLimitList retrieveCountyBudgetLimitList;

  private RetrieveCountyList retrieveCountyList;

  private RetrieveCaseBudgetLimitList retrieveCaseBudgetLimitList;

  private RetrieveDeliveredServiceDetail retrieveDeliveredServiceDetail;

  private RetrieveFosterCareDetail retrieveFosterCareDetail;

  private RetrieveInvoiceHeader retrieveInvoiceHeader;

  private RetrieveInvoiceList retrieveInvoiceList;

  private RetrievePaymentApprovalList retrievePaymentApprovalList;

  private RetrievePaymentHistoryList retrievePaymentHistoryList;

  private RetrieveRejectionReason retrieveRejectionReason;

  private RetrieveResource retrieveResource;

  private RetrieveRestrictedFunds retrieveRestrictedFunds;

  private RetrieveServiceAuthorizationDetail retrieveServiceAuthorizationDetail;

  private RetrieveServiceAuthorization retrieveServiceAuthorization;
  
  private RetrieveSpecialNeedsDetermination retrieveSpecialNeedsDetermination;

  private RetrieveSvcAuthPolicyWaiver retrieveSvcAuthPolicyWaiver;

  private RetrieveServiceList retrieveServiceList;

  private RetrieveTCMClaimsList retrieveTCMClaimsList;

  private SaveAAFundingSummary saveAAFundingSummary;
  
  private SaveAdminDetail saveAdminDetail;

  private SaveCaseBudgetLimitList saveCaseBudgetLimitList;

  private SaveContract saveContract;

  private SaveContractList saveContractList;

  private SaveContractService saveContractService;

  private SaveContractPeriod saveContractPeriod;

  private SaveContractVersion saveContractVersion;

  private SaveCostReimbursementDetail saveCostReimbursementDetail;

  private SaveCountyBudgetLimitDetail saveCountyBudgetLimitDetail;

  private SaveCountyList saveCountyList;

  private SaveDeliveredServiceDetail saveDeliveredServiceDetail;

  private SaveFosterCareDetail saveFosterCareDetail;

  private SaveInvoiceHeader saveInvoiceHeader;

  private SavePaymentApprovalList savePaymentApprovalList;

  private SaveRestrictedFunds saveRestrictedFunds;

  private SaveServiceAuthorizationDetail saveServiceAuthorizationDetail;

  private SaveServiceAuthorization saveServiceAuthorization;
  
  private SaveSpecialNeedsDetermination saveSpecialNeedsDetermination;

  private SaveAdoptionSubsidy saveAdoptionSubsidy;

  private SaveVendorOutbound saveVendorOutbound;

  private SaveTCMClaim saveTCMClaim;
  
  private UpdateBudgets updateBudgets;

  private ValidateTCMClaim validateTCMClaim;
  
  private DeleteInvoiceLineItem deleteInvoiceLineItem;
  
  private RetrieveUASProgramCodeMtnt retrieveUASProgramCodeMtnt;
  
  private SaveUASProgramCodeMtnt saveUASProgramCodeMtnt;
  
  public BatchContractServiceSO saveBatchContractServiceRows(BatchContractServiceSI batchContractServiceSI) throws ServiceException {
    return saveBatchContractServiceRows.saveBatchContractServiceRows(batchContractServiceSI);
  }
  
  public RetrieveProgramCodeServicesSO retrieveProgramCodeServices(RetrieveProgramCodeServicesSI retrieveProgramCodeServicesSI){
    return retrieveProgramCodeServices.retrieveProgramCodeServices(retrieveProgramCodeServicesSI);
  }
  
  public List<TCMClaimsSearchSO> retrieveTCMClaimsList(TCMClaimsSearchSI input) {
    return retrieveTCMClaimsList.retrieveTCMClaimsList(input);
  }

  public List<CountyBudgetLimitRetrieveSO> retrieveCountyBudgetLimitList(CountyBudgetLimitRetrieveSI input) {
    return retrieveCountyBudgetLimitList.retrieveCountyBudgetLimitList(input);
  }

  public CaseBudgetLimitRetrieveSO retrieveCaseBudgetLimitList(CaseBudgetLimitRetrieveSI input) {
    return retrieveCaseBudgetLimitList.retrieveCaseBudgetLimitList(input);
  }

  public CCON20SO contractValidation(CCON20SI ccon20si) throws ServiceException {
    return contractValidation.contractValidation(ccon20si);
  }

  public int isCountyBudgetLimitDetailValid(String county, String program, int fiscalYear) {
    return countyBudgetLimitDetailValidation.isCountyBudgetLimitDetailValid(county, program, fiscalYear);
  }

  public CFIN29SO retrieveDeliveredServiceValidation(CFIN29SI cfin29si) throws ServiceException {
    return deliveredServiceValidation.retrieveDeliveredServiceValidation(cfin29si);
  }

  public CFIN08SO retrieveFosterCareDetailValidation(CFIN08SI cfin08si) throws ServiceException {
    return fosterCareDetailValidation.retrieveFosterCareDetailValidation(cfin08si);
  }

  public AAFundingSummarySO retrieveAAFundingSummary (AAFundingSummaryRetrieveSI aAFundingSummaryRetrieveSI) throws ServiceException {
    return retrieveAAFundingSummary.retrieveAAFundingSummary(aAFundingSummaryRetrieveSI);
  }
  
  public CFIN15SO retrieveAdminDetail(CFIN15SI cfin15si) throws ServiceException {
    return retrieveAdminDetail.retrieveAdminDetail(cfin15si);
  }

  public CFAD39SO retrieveAdoptionSubsidy(CFAD39SI cfad39si) throws ServiceException {
    return retrieveAdoptionSubsidy.retrieveAdoptionSubsidy(cfad39si);
  }

  public CCON09SO retrieveBudgetTransfer(CCON09SI ccon09si) throws ServiceException {
    return retrieveBudgetTransfer.retrieveBudgetTransfer(ccon09si);
  }

  public CCON02SO findContract(CCON02SI ccon02si) throws ServiceException {
    return retrieveContract.findContract(ccon02si);
  }
  
  public ContractCountiesSO retrieveContractCounties(ContractCountiesSI contractCountiesSI) {
    return retrieveContractCounties.retrieveContractCounties(contractCountiesSI);
  }

  public CCON01SO retrieveContractList(CCON01SI ccon01si) throws ServiceException {
    return retrieveContractList.retrieveContractList(ccon01si);
  }

  public CCON05SO findContractPeriod(CCON05SI ccon05si) throws ServiceException {
    return retrieveContractPeriod.findContractPeriod(ccon05si);
  }

  public CCON11SO findContractService(CCON11SI ccon11si) throws ServiceException {
    return retrieveContractService.findContractService(ccon11si);
  }

  public CCON07SO findContractVersion(CCON07SI ccon07si) throws ServiceException {
    return retrieveContractVersion.findContractVersion(ccon07si);
  }

  public CFIN13SO retrieveCostReimbursementDetail(CFIN13SI cfin13si) throws ServiceException {
    return retrieveCostReimbursementDetail.retrieveCostReimbursementDetail(cfin13si);
  }

  public CCON13SO retrieveCounties(CCON13SI ccon13si) throws ServiceException {
    return retrieveCountyList.retrieveCounties(ccon13si);
  }

  public CountyBudgetLimitRetrieveSO retrieveCountyBudgetLimitDetail(CountyBudgetLimitRetrieveSI input) {
    return retrieveCountyBudgetLimitDetail.retrieveCountyBudgetLimitDetail(input);
  }

  public CFIN06SO findDeliveredServiceDetail(CFIN06SI cfin06si) throws ServiceException {
    return retrieveDeliveredServiceDetail.findDeliveredServiceDetail(cfin06si);
  }

  public CFIN10SO retrieveFosterCareDetail(CFIN10SI cfin10si) throws ServiceException {
    return retrieveFosterCareDetail.retrieveFosterCareDetail(cfin10si);
  }
  
  public DtLicBeginSO retrieveDtCnperStart(DtLicBeginSI dtLicBeginSI) throws ServiceException {
    return retrieveCnperStart.retrieveDtCnperStart(dtLicBeginSI);
  }
  public CFIN02SO findInvoiceHeaderInformation(CFIN02SI cfin02si) {
    return retrieveInvoiceHeader.findInvoiceHeaderInformation(cfin02si);
  }

  public CFIN01SO retrieveInvoiceList(CFIN01SI cfin01si) {
    return retrieveInvoiceList.retrieveInvoiceList(cfin01si);
  }

  public CFIN19SO retrievePaymentApprovalList(CFIN19SI cfin19si) throws ServiceException {
    return retrievePaymentApprovalList.retrievePaymentApprovalList(cfin19si);
  }

  public CFIN21SO retrievePaymentHistoryList(CFIN21SI cfin21si) throws ServiceException {
    return retrievePaymentHistoryList.retrievePaymentHistoryList(cfin21si);
  }

  public CFIN09SO retrieveRejectionReason(CFIN09SI cfin09si) throws ServiceException {
    return retrieveRejectionReason.retrieveRejectionReason(cfin09si);
  }

  public CCON04SO findResource(CCON04SI ccon04si) throws ServiceException {
    return retrieveResource.findResource(ccon04si);
  }

  public RestrictedFundsSO retrieveRestrictedFunds(RestrictedFundsRetrieveSI si) throws ServiceException {
    return retrieveRestrictedFunds.retrieveRestrictedFunds(si);
  }

  public CCON22SO retrieveServiceAuthorizationDetail(CCON22SI ccon22si) throws ServiceException {
    return retrieveServiceAuthorizationDetail.retrieveServiceAuthorizationDetail(ccon22si);
  }

  public CCON18SO retrieveServiceAuthorization(CCON18SI ccon18si) throws ServiceException {
    return retrieveServiceAuthorization.retrieveServiceAuthorization(ccon18si);
  }

  public CCON21SO retrieveServiceList(CCON21SI ccon21si) throws ServiceException {
    return retrieveServiceList.retrieveServiceList(ccon21si);
  }

  public SpecialNeedsDeterminationRetrieveSO retrieveSpecialNeedsDetermination(SpecialNeedsDeterminationRetrieveSI retSpcNdsDetermSI) throws ServiceException {
    return retrieveSpecialNeedsDetermination.retrieveSpecialNeedsDetermination(retSpcNdsDetermSI);
  }
  
  public PolicyWaiverRetrieveSO retrieveSvcAuthPolicyWaiver(int idEvent) throws ServiceException {
    return retrieveSvcAuthPolicyWaiver.retrieveSvcAuthPolicyWaiver(idEvent);
  }
  
  public int saveAAFundingSummary (AAFundingSummarySO aAFundingSummarySO) throws ServiceException {
    return saveAAFundingSummary.saveAAFundingSummary(aAFundingSummarySO);
  }
  
  public CFIN16SO saveAdminDetail(CFIN16SI cfin16si) throws ServiceException {
    return saveAdminDetail.saveAdminDetail(cfin16si);
  }

  public CaseBudgetLimitSaveSO saveCaseBudgetLimitList(CaseBudgetLimitSaveSI input) {
    return saveCaseBudgetLimitList.saveCaseBudgetLimitList(input);
  }

  public CCON03SO saveContract(CCON03SI ccon03si) throws ServiceException {
    return saveContract.saveContract(ccon03si);
  }

  public CCON12SO saveContractList(CCON12SI ccon12si) throws ServiceException {
    return saveContractList.saveContractList(ccon12si);
  }

  public CCON06SO saveContractPeriod(CCON06SI input) throws ServiceException {
    return saveContractPeriod.saveContractPeriod(input);
  }

  public CCON10SO saveContractService(CCON10SI input) throws ServiceException {
    return saveContractService.saveContractService(input);
  }

  public CCON08SO saveContractVersion(CCON08SI ccon08si) throws ServiceException {
    return saveContractVersion.saveContractVersion(ccon08si);
  }

  public CFIN14SO saveCostReimbursementDetail(CFIN14SI cfin14si) throws ServiceException {
    return saveCostReimbursementDetail.saveCostReimbursementDetail(cfin14si);
  }

  public int saveCountyBudgetLimitDetail(CountyBudgetLimitSaveSI input) {
    return saveCountyBudgetLimitDetail.saveCountyBudgetLimitDetail(input);
  }

  public CCON14SO saveCountyList(CCON14SI ccon14si) throws ServiceException {
    return saveCountyList.saveCountyList(ccon14si);
  }

  public CFIN07SO saveDelvrdSvcDtl(CFIN07SI cfin07si) throws ServiceException {
    return saveDeliveredServiceDetail.saveDelvrdSvcDtl(cfin07si);
  }

  public CFIN11SO saveFosterCareDetail(CFIN11SI cfin11si) throws ServiceException {
    return saveFosterCareDetail.saveFosterCareDetail(cfin11si);
  }

  public CFIN03SO saveInvoiceHeaderInformation(CFIN03SI cfin03si) throws ServiceException {
    return saveInvoiceHeader.saveInvoiceHeaderInformation(cfin03si);
  }

  public CFIN20SO savePaymentApprovalList(CFIN20SI cfin20si) throws ServiceException {
    return savePaymentApprovalList.savePaymentApprovalList(cfin20si);
  }

  public RestrictedFundsSO saveRestrictedFunds(RestrictedFundsSaveSI si) throws ServiceException {
    return saveRestrictedFunds.saveRestrictedFunds(si);
  }

  public CCON23SO saveServiceAuthorizationDetail(CCON23SI ccon23si) throws ServiceException {
    return saveServiceAuthorizationDetail.saveServiceAuthorizationDetail(ccon23si);
  }

  public CCON19SO saveServiceAuthorization(CCON19SI ccon19si) throws ServiceException {
    return saveServiceAuthorization.saveServiceAuthorization(ccon19si);
  }

  public SpecialNeedsDeterminationSaveSO saveSpecialNeedsDetermination(SpecialNeedsDeterminationSaveSI spNdsDetermSaveSI) throws ServiceException {
    return saveSpecialNeedsDetermination.saveSpecialNeedsDetermination(spNdsDetermSaveSI);
  }
  
  public int saveNewVendor(VendorOutboundSI vendorOutboundSI) throws ServiceException {
    return saveVendorOutbound.saveNewVendor(vendorOutboundSI);
  }

  public CFAD40SO saveAdoptionSubsidy(CFAD40SI cfad40si) throws ServiceException {
    return saveAdoptionSubsidy.saveAdoptionSubsidy(cfad40si);
  }

  public TCMClaimSaveSO saveTCMClaim(TCMClaimSaveSI tcmClaimSaveSI) {
    return saveTCMClaim.saveTCMClaim(tcmClaimSaveSI);
  }
  
  public BudgetUpdateSO updateBudgets(BudgetUpdateSI budgetUpdateSI) {
    return updateBudgets.updateBudgets(budgetUpdateSI);
  }

  public TCMClaimValidateSO validateTCMClaim(TCMClaimValidateSI tcmClaimValidateSI) {
    return validateTCMClaim.validateTCMClaim(tcmClaimValidateSI);
  }
  
  public void deleteInvoiceLineItem(int idLineItem, String cdLineItemType){
     deleteInvoiceLineItem.deleteInvoiceLineItem(idLineItem, cdLineItemType);
  }
  
  public Integer retrieveSubStageCount(CFAD39SI cfad39si) {
    return retrieveAdoptionSubsidy.retrieveSubStageCount(cfad39si);
  }
  
  public CFAD40SO checkForActiveNonRecAdoSubsidy(CFAD40SI cfad40si) throws ServiceException {
    return saveAdoptionSubsidy.checkForActiveNonRecAdoSubsidy(cfad40si);
  }
  
  public UASProgramCodeMtntRetrieveSO retrieveUASProgramCodeMtnt(UASProgramCodeMtntRetrieveSI uasProgramCodeMtntRetrieveSI) {
    return retrieveUASProgramCodeMtnt.retrieveUASProgramCodeMtnt(uasProgramCodeMtntRetrieveSI);
  }
  
  public UASProgramCodeMtntSaveSO saveUASProgramCodeMtnt(UASProgramCodeMtntSaveSI uasProgramCodeMtntSaveSI) {
    return saveUASProgramCodeMtnt.saveUASProgramCodeMtnt(uasProgramCodeMtntSaveSI);
  }

  protected void onEjbCreate() throws CreateException {
    contractValidation = getService(ContractValidation.class);
    countyBudgetLimitDetailValidation = getService(CountyBudgetLimitDetailValidation.class);
    deliveredServiceValidation = getService(DeliveredServiceValidation.class);
    fosterCareDetailValidation = getService(FosterCareDetailValidation.class);
    retrieveAAFundingSummary = getService(RetrieveAAFundingSummary.class);
    retrieveAdminDetail = getService(RetrieveAdminDetail.class);
    retrieveAdoptionSubsidy = getService(RetrieveAdoptionSubsidy.class);
    retrieveBudgetTransfer = getService(RetrieveBudgetTransfer.class);
    retrieveCnperStart = getService(RetrieveCnperStart.class);
    retrieveContract = getService(RetrieveContract.class);
    retrieveContractCounties = getService(RetrieveContractCounties.class);
    retrieveContractList = getService(RetrieveContractList.class);
    retrieveContractPeriod = getService(RetrieveContractPeriod.class);
    retrieveContractService = getService(RetrieveContractService.class);
    retrieveContractVersion = getService(RetrieveContractVersion.class);
    retrieveCostReimbursementDetail = getService(RetrieveCostReimbursementDetail.class);
    retrieveCountyList = getService(RetrieveCountyList.class);
    retrieveCountyBudgetLimitDetail = getService(RetrieveCountyBudgetLimitDetail.class);
    retrieveCountyBudgetLimitList = getService(RetrieveCountyBudgetLimitList.class);
    retrieveCaseBudgetLimitList = getService(RetrieveCaseBudgetLimitList.class);
    retrieveDeliveredServiceDetail = getService(RetrieveDeliveredServiceDetail.class);
    retrieveFosterCareDetail = getService(RetrieveFosterCareDetail.class);
    retrieveInvoiceHeader = getService(RetrieveInvoiceHeader.class);
    retrieveInvoiceList = getService(RetrieveInvoiceList.class);
    retrievePaymentApprovalList = getService(RetrievePaymentApprovalList.class);
    retrievePaymentHistoryList = getService(RetrievePaymentHistoryList.class);
    retrieveRejectionReason = getService(RetrieveRejectionReason.class);
    retrieveResource = getService(RetrieveResource.class);
    retrieveRestrictedFunds = getService(RetrieveRestrictedFunds.class);
    retrieveServiceAuthorizationDetail = getService(RetrieveServiceAuthorizationDetail.class);
    retrieveServiceAuthorization = getService(RetrieveServiceAuthorization.class);
    retrieveSpecialNeedsDetermination = getService(RetrieveSpecialNeedsDetermination.class);
    retrieveSvcAuthPolicyWaiver = getService(RetrieveSvcAuthPolicyWaiver.class);
    retrieveServiceList = getService(RetrieveServiceList.class);
    retrieveTCMClaimsList = getService(RetrieveTCMClaimsList.class);
    saveAAFundingSummary = getService(SaveAAFundingSummary.class);
    saveAdminDetail = getService(SaveAdminDetail.class);
    saveCaseBudgetLimitList = getService(SaveCaseBudgetLimitList.class);
    saveContract = getService(SaveContract.class);
    saveContractList = getService(SaveContractList.class);
    saveContractPeriod = getService(SaveContractPeriod.class);
    saveContractService = getService(SaveContractService.class);
    saveContractVersion = getService(SaveContractVersion.class);
    saveCostReimbursementDetail = getService(SaveCostReimbursementDetail.class);
    saveCountyBudgetLimitDetail = getService(SaveCountyBudgetLimitDetail.class);
    saveCountyList = getService(SaveCountyList.class);
    saveDeliveredServiceDetail = getService(SaveDeliveredServiceDetail.class);
    saveFosterCareDetail = getService(SaveFosterCareDetail.class);
    saveInvoiceHeader = getService(SaveInvoiceHeader.class);
    savePaymentApprovalList = getService(SavePaymentApprovalList.class);
    saveRestrictedFunds = getService(SaveRestrictedFunds.class);
    saveServiceAuthorizationDetail = getService(SaveServiceAuthorizationDetail.class);
    saveServiceAuthorization = getService(SaveServiceAuthorization.class);
    saveSpecialNeedsDetermination = getService(SaveSpecialNeedsDetermination.class);
    saveVendorOutbound = getService(SaveVendorOutbound.class);
    saveAdoptionSubsidy = getService(SaveAdoptionSubsidy.class);
    saveTCMClaim = getService(SaveTCMClaim.class);
    updateBudgets = getService(UpdateBudgets.class);
    validateTCMClaim = getService(ValidateTCMClaim.class);
    deleteInvoiceLineItem = getService(DeleteInvoiceLineItem.class);
    retrieveUASProgramCodeMtnt = getService(RetrieveUASProgramCodeMtnt.class);
    saveUASProgramCodeMtnt = getService(SaveUASProgramCodeMtnt.class);
    retrieveProgramCodeServices = getService(RetrieveProgramCodeServices.class);
    saveBatchContractServiceRows = getService(SaveBatchContractServiceRows.class);
  }


}
