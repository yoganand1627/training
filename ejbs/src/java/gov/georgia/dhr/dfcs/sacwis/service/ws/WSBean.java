/**
 * Created on Jun 28, 2006 at 9:48:37 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.ws;

import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CprsCaseListQuerySI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CprsExtDocSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CprsQueryCaseListSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CprsQuerySI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsAuditSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsInquirySI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsRegistrationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsScreeningSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IncomeResourceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicaidCoareqInboundSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveTestRowSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveChildSupportPaymentInfoSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveTcmClaimInfoSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveTestRowSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SmileInvoiceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ClientSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CprsExtDocSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CprsQueryCaseListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CprsQuerySO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CrsInquirySO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CrsRegistrationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CrsScreeningSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IncomeResourceSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicaidCoareqInboundSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveTestRowSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveTcmClaimInfoSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveTestRowSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SmileInvoiceSO;

import javax.ejb.CreateException;

@SuppressWarnings("serial")
public class WSBean extends BaseSpringStatelessSessionBean implements WS {

  private SaveTestRow saveTestRow;
  private RetrieveTestRow retrieveTestRow;
  private SaveIncomeResource saveIncomeResource;
  private SaveSmileInvoice saveSmileInvoice; 
  //private CrsInquiry crsInquiry;
  private CrsScreening crsScreening;
  private CrsRegistration crsRegistration;
  private SaveClient saveClient;
  private SaveTcmClaimInfoWS saveTcmClaimInfo;
  private SaveMedicaidCoareq saveMedicaidCoareq;
  private SaveCrsAuditRow saveCrsAuditRow;
  private SaveChildSupportPaymentInfoWS saveChildSupportPaymentInfo;
  private CprsQuery cprsQuery;
  private RetrievePreAdoptiveChildId retrievePreAdoptiveChildId;
  private CprsExtDoc cprsExtDoc;
  
  public IncomeResourceSO saveIncomeResource(IncomeResourceSI incomeResourceSI) {
    return saveIncomeResource.saveIncomeResource(incomeResourceSI);
  }
  
  public SmileInvoiceSO saveSmileInvoice(SmileInvoiceSI smileInvoiceSI) {
    return saveSmileInvoice.saveSmileInvoice(smileInvoiceSI);
  }
  

  public MedicaidCoareqInboundSO saveMedicaidCoareq(MedicaidCoareqInboundSI medicaidCoareqInboundSI) {
    return saveMedicaidCoareq.saveMedicaidCoareq(medicaidCoareqInboundSI);
  }
  
  public SaveTestRowSO saveTestRow(SaveTestRowSI saveTestRowSI) {
    return saveTestRow.saveTestRow(saveTestRowSI);
  }

  public RetrieveTestRowSO getTestRow(RetrieveTestRowSI retrieveTestRowSI) {
    return retrieveTestRow.getTestRow(retrieveTestRowSI);
  }

  public CrsInquirySO performCrsInquiry(CrsInquirySI crsInquirySI) {
    // TODO Auto-generated method stub
    return null;
  }

  public CrsScreeningSO performCrsScreening(CrsScreeningSI crsScreeningSI) {
    return crsScreening.performCrsScreening(crsScreeningSI);
  }

  public CrsRegistrationSO performCrsRegistration(CrsRegistrationSI crsRegistrationSI) {
    return crsRegistration.performCrsRegistration(crsRegistrationSI);
  }
  
  public ClientSO saveClient(ClientSI clientSI){
    return saveClient.saveClient(clientSI);
  }
  
  public SaveTcmClaimInfoSO saveTcmClaimInfo(SaveTcmClaimInfoSI saveTcmClaimInfoSI) {
    return saveTcmClaimInfo.saveTcmClaimInfo(saveTcmClaimInfoSI);
  }

  public int saveChildSupportPaymentInfo(SaveChildSupportPaymentInfoSI saveChildSupportPaymentInfoSI) {
    return saveChildSupportPaymentInfo.saveChildSupportPaymentInfo(saveChildSupportPaymentInfoSI);
  }
  
  public void saveCrsAuditRow(CrsAuditSI CrsRegistrationSO) {
    saveCrsAuditRow.saveCrsAuditRow(CrsRegistrationSO);
  }

  public CprsQuerySO performCPRSQuery(CprsQuerySI cprsQuerySI) {
    return cprsQuery.performCPRSQuery(cprsQuerySI);
  }
  
  public CprsQueryCaseListSO retrieveCPRSCaseList(CprsCaseListQuerySI cprsCaseListQuerySI) {
    return cprsQuery.retrieveCPRSCaseList(cprsCaseListQuerySI);
  }
  
  public CprsQuerySO retrieveCPRSCases(CprsQueryCaseListSI cprsQueryCaseListSI) {
    return cprsQuery.retrieveCPRSCases(cprsQueryCaseListSI);
  } 
  
  public Integer retrievePreAdoptiveChildId(int idStage) {
    return retrievePreAdoptiveChildId.retrievePreAdoptiveChildId(idStage);
  } 
  
  public CprsExtDocSO saveCprsExtDoc(CprsExtDocSI cprsExtDocSI) {
    return cprsExtDoc.saveCprsExtDoc(cprsExtDocSI);
  }

  protected void onEjbCreate() throws CreateException {
    saveTestRow = getService(SaveTestRow.class);
    retrieveTestRow = getService(RetrieveTestRow.class);
    //crsInquiry = getService(CrsInquiry.class);
    crsScreening = getService(CrsScreening.class);
    crsRegistration = getService(CrsRegistration.class);
    saveClient = getService(SaveClient.class);
    saveIncomeResource = getService(SaveIncomeResource.class);
    saveSmileInvoice = getService(SaveSmileInvoice.class);
    saveMedicaidCoareq = getService(SaveMedicaidCoareq.class);
    saveTcmClaimInfo = getService(SaveTcmClaimInfoWS.class);
    saveChildSupportPaymentInfo = getService(SaveChildSupportPaymentInfoWS.class);
    saveCrsAuditRow  = getService(SaveCrsAuditRow.class);
    cprsQuery = getService(CprsQuery.class);
    retrievePreAdoptiveChildId = getService(RetrievePreAdoptiveChildId.class);
    cprsExtDoc = getService(CprsExtDoc.class);
  }
}