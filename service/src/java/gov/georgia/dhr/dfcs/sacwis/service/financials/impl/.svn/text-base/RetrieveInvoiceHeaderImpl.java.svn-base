package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.Invoice;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveInvoiceHeader;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO;

/**
* 
* <pre>
*    Change History:
*    Date      User      Description
*    --------  --------  --------------------------------------------------
*   04/08/2009 bgehlot   STGAP00013273: Added the code to set the Provider Invoice number
*                        
* </pre>
*/

public class RetrieveInvoiceHeaderImpl extends BaseServiceImpl implements RetrieveInvoiceHeader {
  
  private ContractDAO contractDAO = null;
  private InvoiceDAO invoiceDAO = null;

  public void setContractDAO(ContractDAO contractDAO) {
    this.contractDAO = contractDAO;
  }

  public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
    this.invoiceDAO = invoiceDAO;
  }

  public CFIN02SO findInvoiceHeaderInformation(CFIN02SI cfin02si) {
    CFIN02SO cfin02so = null;
    int idContract = cfin02si.getUlIdContract();
    // If the window is in NEW mode, the service will call ContractDAO to retrieve information specific to the contract
    //   from CONTRACT, CAPS RESOURCE, AND RESOURCE ADDRESS tables. In modify or BROWSE mode, the DAM will retrieve
    //   invoice information from INVOICE tables too.
    if (idContract > 0) {
      cfin02so = findContractInfo(idContract);
    }
    int idInvoice = cfin02si.getUlIdInvoInvoice();
    if(ArchitectureConstants.Y.equals(cfin02si.getCIndCopiedInv())){
      idInvoice = cfin02si.getUlIdInvoInvoiceCopied();
    }
      
    if ((idContract == 0 || ArchitectureConstants.Y.equals(cfin02si.getCIndCopiedInv())) && idInvoice > 0) {
      cfin02so = findInvoiceInfo(idInvoice);
    }
    if(ArchitectureConstants.Y.equals(cfin02si.getCIndCopiedInv())){
      cfin02so.setUlIdInvoInvoice(0);
    }
    // This was moved from the top to the bottom of the service so it could be populated after the output object was
    //   created by the helper methods.
    //noinspection ConstantConditions
    cfin02so.setDtScrDtCurrentDate(DateHelper.getTodayCastorDate());
    return cfin02so;
  }

  private CFIN02SO findInvoiceInfo(int idInvoice) {
    CFIN02SO cfin02so = new CFIN02SO();
    // csec06d
    Invoice invoice = invoiceDAO.findInvoiceContractResourceIdInvoice(idInvoice);
    // Errors are ignored in the service.
    if (invoice != null) {
      // Otherwise, Populate all of the output fields from the DAM output record.  When an Invoice ID exists the VID is
      //   a historical VID thus, the VID retrieved in this case should be the VID stored on the Invoice table.
      cfin02so.setUlIdInvoInvoice(invoice.getIdInvoice() != null ? invoice.getIdInvoice() : 0);
      Contract contract = invoice.getContract();
      int idContract = contract.getIdContract() != null ? contract.getIdContract() : 0;
      cfin02so.setUlIdContract(idContract);
      
      //-- invoice already created with valid county value; add it to county array for page display
      //SzCdCounty_Array countyArray = new SzCdCounty_Array();
      //countyArray.addSzCdCounty(invoice.getCdInvoCounty());
      //cfin02so.setSzCdCounty_Array(countyArray);
      
      cfin02so.setSzNmResource(contract.getCapsResource().getNmResource());
      cfin02so.setUlIdResource(contract.getCapsResource().getIdResource());
      cfin02so.setSzNbrInvoVid(invoice.getNbrInvoVid());
      cfin02so.setSzCdCntrctProgramType(contract.getCdCntrctProgramType());
      cfin02so.setSzCdCntrctRegion(invoice.getCdInvoRegion());
      cfin02so.setSzCdInvoType(invoice.getCdInvoType());
      cfin02so.setUMoInvoMonth(invoice.getMoInvoMonth() != null ? invoice.getMoInvoMonth() : 0);
      cfin02so.setUYrInvoYear(invoice.getYrInvoYear() != null ? invoice.getYrInvoYear() : 0);
      if (invoice.getAmtInvoClaimedAmount()!=null){
        cfin02so.setDAmtInvoClaimedAmount(invoice.getAmtInvoClaimedAmount());
      }
      if (invoice.getAmtInvoValidAmount()!=null){
        cfin02so.setDAmtInvoValidAmount(invoice.getAmtInvoValidAmount());
      }
      if (invoice.getAmtInvoWarrant()!=null){
        cfin02so.setDAmtInvoWarrant(invoice.getAmtInvoWarrant());
      }
      cfin02so.setSzNbrInvoWarrant(invoice.getNbrInvoWarrant());
      cfin02so.setDtDtInvoReceivedDate(DateHelper.toCastorDate(invoice.getDtInvoReceivedDate()));
      cfin02so.setDtDtInvoSubmitDate(DateHelper.toCastorDate(invoice.getDtInvoSubmitDate()));
      cfin02so.setDtDtInvoWarrantDate(DateHelper.toCastorDate(invoice.getDtInvoWarrantDate()));
      cfin02so.setDtDtInvoEntryCompleted(DateHelper.toCastorDate(invoice.getDtInvoEntryCompleted()));
      cfin02so.setDtDtInvoEntryStarted(DateHelper.toCastorDate(invoice.getDtInvoEntryStarted()));
      cfin02so.setSzCdInvoAdjustmentRb(invoice.getCdInvoAdjustmentRb());
      cfin02so.setCIndInvoReadyForValid(invoice.getIndInvoReadyForValid());
      cfin02so.setSzCdInvoPhase(invoice.getCdInvoPhase());
      cfin02so.setSzCdInvoApproved(invoice.getCdInvoApproved());
      cfin02so.setTsLastUpdate(invoice.getDtLastUpdate());
      cfin02so.setSzCdCounty(invoice.getCdInvoCounty());
      cfin02so.setSzTxtInvoContact(invoice.getTxtInvoContact());
      
      //STGAP00013273: Get the Provider Invoice Number and set it in the return object
      cfin02so.setSzNbrInvProvider(invoice.getNbrInvProvider());
    }
    return cfin02so;
  }

  private CFIN02SO findContractInfo(int idContract) {
    CFIN02SO cfin02so;
    cfin02so = new CFIN02SO();
    // Set all of the output dates to null because they are not populated.
    cfin02so.setDtDtInvoSubmitDate(null);
    cfin02so.setDtDtInvoWarrantDate(null);
    cfin02so.setDtDtInvoEntryCompleted(null);
    cfin02so.setDtDtInvoEntryStarted(null);
    // csec06d
    Contract contract = contractDAO.findContractIdContract(idContract);
    // Errors are ignored in the service.
    if (contract != null) {
      // If the Contract Id was passed as the search parameter, only populate the fields that
      // relate to the resource.  In addition, return the contract Id that was passed.  In this
      // case, the Vendor ID (VID) is retrieved from the Resource_Address table.
      cfin02so.setUlIdContract(idContract);
      cfin02so.setSzNmResource(contract.getCapsResource().getNmResource());
      cfin02so.setUlIdResource(contract.getCapsResource().getIdResource());
      cfin02so.setSzNbrInvoVid(contract.getResourceAddress().getNbrRsrcAddrVid());
      cfin02so.setSzCdCntrctProgramType(contract.getCdCntrctProgramType());
      //cfin02so.setSzCdCounty_Array(findContractCounties(idContract));
    }
    return cfin02so;
  }
  
  /*
  private SzCdCounty_Array findContractCounties(int idContract){
    //-- populate county values from ContractCounty using idContract and current date
    SzCdCounty_Array countyArray = new SzCdCounty_Array(); 
    List<String> counties = contractCountyDAO.findEffectiveCountiesByIdContract(idContract, new Date());
    if(counties != null && !counties.isEmpty()){
      for(Iterator<String> it=counties.iterator(); it.hasNext();){
        countyArray.addSzCdCounty(it.next());
      }
    }
    return countyArray;
  }
  */
}
