package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicInvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.DelvrdSvcDtl;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrievePaymentApprovalList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This is the Service that retrieves the invoice records as per the search criterai from the Database. <p/> <p/>
 * 
 * <pre>
 *    Change History:
 *    Date      User      Description
 *    --------  --------  --------------------------------------------------
 *   05/22/08  vdevarak   STGAP00004617 - Modified code to retrieve the invoices based on the search
 *                                        criteria entered on the Payment Approval page.
 *                                        
 *   04/08/2009 bgehlot   STGAP00013273 - Added the code to set the UAS Codes in the return object
 *                        
 * </pre>
 */

public class RetrievePaymentApprovalListImpl extends BaseServiceImpl implements RetrievePaymentApprovalList {

  private DynamicInvoiceDAO dynamicInvoiceDAO = null;
  
  private DelvrdSvcDtlDAO delvrdSvcDtlDAO;

  public void setDynamicInvoiceDAO(DynamicInvoiceDAO dynamicInvoiceDAO) {
    this.dynamicInvoiceDAO = dynamicInvoiceDAO;
  }
  
  public void setDelvrdSvcDtlDAO(DelvrdSvcDtlDAO delvrdSvcDtlDAO) {
    this.delvrdSvcDtlDAO = delvrdSvcDtlDAO;
  }

  public CFIN19SO retrievePaymentApprovalList(CFIN19SI cfin19si) throws ServiceException {
    CFIN19SO output = new CFIN19SO();
    ArchOutputStruct aos = new ArchOutputStruct();
    String bMoreDataInd = "N";
    String cdCntrctRegion = cfin19si.getSzCdCntrctRegion();
    String cdInvoCounty = cfin19si.getSzCdCounty();
    String cdInvoAprvStatus = cfin19si.getSzCdInvoAprvStatus();
    String cdInvoType = cfin19si.getSzCdInvoType();
    int idContract = cfin19si.getUlIdContract();
    int idResource = cfin19si.getUlIdResource();
    int moInvoMonth = cfin19si.getUMoInvoMonth();
    int yrInvoYear = cfin19si.getUYrInvoYear();
    int pageNbr = cfin19si.getArchInputStruct().getUsPageNbr();
    int pageSize = cfin19si.getArchInputStruct().getUlPageSizeNbr();
    
    //STGAP00013273 : Added new field Client Person ID to search on
    int idClientPerson = cfin19si.getUlIdClientPerson();
    
    // cdyn05dQUERYdam
    // STGAP00004617: Calling a different sql to retrieve only those invoices that are filtered based on the
    // search criteria entered on the Payment Approval page.
    PaginatedHibernateList<Object[]> objectArrayList = dynamicInvoiceDAO.findPymtAprvInvoices(idContract, idResource,
                                                                                              cdCntrctRegion,
                                                                                              cdInvoCounty,
                                                                                              moInvoMonth,
                                                                                              cdInvoAprvStatus,
                                                                                              cdInvoType, yrInvoYear,
                                                                                              pageNbr, pageSize, idClientPerson);
    ROWCFIN19SOG_ARRAY rowCFIN19SOG_ARRAY = new ROWCFIN19SOG_ARRAY();
    int ulRowQty = 0;
    if (objectArrayList != null && !objectArrayList.isEmpty()) {
      bMoreDataInd = objectArrayList.getBMoreDataInd();
      for (Iterator<Object[]> it = objectArrayList.iterator(); it.hasNext();) {
        Object[] objectArray = it.next();
        ROWCFIN19SOG rowCFIN19SOG = new ROWCFIN19SOG();
        Integer ulIdResource = (Integer) objectArray[0];
        String nmResource = (String) objectArray[1];
        Integer ulIdInvoice = (Integer) objectArray[2];
        Date dtlastUpdate = (Date) objectArray[3];
        Integer ulIdContract = (Integer) objectArray[4];
        Integer idPerson = (Integer) objectArray[5];
        String szCdInvoApproved = (String) objectArray[6];
        String cdInvoPhase = (String) objectArray[7];
        Date dtInvoApprovalDate = (Date) objectArray[8];
        Date dInvoReceivedDate = (Date) objectArray[9];
        Double amtInvoValidAmount = (Double) objectArray[10];
        String nmClient = (String) objectArray[11];

        rowCFIN19SOG.setUlIdResource(ulIdResource != null ? ulIdResource : 0);
        rowCFIN19SOG.setSzNmResource(nmResource);
        rowCFIN19SOG.setUlIdInvoInvoice(ulIdInvoice != null ? ulIdInvoice : 0);
        rowCFIN19SOG.setUlIdContract(ulIdContract != null ? idContract : 0);
        rowCFIN19SOG.setUlIdPerson(idPerson != null ? idPerson : 0);
        rowCFIN19SOG.setSzCdInvoApproved(szCdInvoApproved);
        rowCFIN19SOG.setSzCdInvoPhase(cdInvoPhase);
        rowCFIN19SOG.setDtDtInvoApprovalDate(DateHelper.toCastorDate(dtInvoApprovalDate));
        rowCFIN19SOG.setDtDtInvoReceivedDate(DateHelper.toCastorDate(dInvoReceivedDate));
        rowCFIN19SOG.setDAmtInvoValidAmount(amtInvoValidAmount != null ? amtInvoValidAmount : 0.00);
        rowCFIN19SOG.setSzNmPersonFull(nmClient);
        rowCFIN19SOG.setTsLastUpdate(dtlastUpdate);
        
      //STGAP00013273: Get the Service codes for the invoice
        List<DelvrdSvcDtl> listdsd = delvrdSvcDtlDAO.findSvcAuthDtlByIdInvoice(ulIdInvoice);
        List<String> cdUASCodedList = new ArrayList<String>();
        String cdSvcDtlServices = StringHelper.EMPTY_STRING;
        
        //Get the first three characters from the service code. These three characters is the UAS code
        //Add these UAS codes to a list.
        if (listdsd != null) {
          for (Iterator<DelvrdSvcDtl> iter = listdsd.iterator(); iter.hasNext();) {
            DelvrdSvcDtl delvrdSvcDtl = iter.next();
            String cdSvcDtlService = delvrdSvcDtl.getCdSvcDtlService();
            cdSvcDtlService = cdSvcDtlService.substring(0, 3);
            cdUASCodedList.add(cdSvcDtlService);
          }
        }
        
        //Get unique UAS code from the list created in previous step
        if (cdUASCodedList != null) {
          cdUASCodedList = GetUniqueValues(cdUASCodedList);
        } 
        
        //Put all the UAS codes in a String Variable inserting commas in between the codes.
        if (cdUASCodedList != null) {
          for (Iterator<String> iter1 = cdUASCodedList.iterator(); iter1.hasNext();) {
            String cdSvcDtlService = iter1.next();
            if(iter1.hasNext()){
              cdSvcDtlServices += cdSvcDtlService + ", ";
            }else{
              cdSvcDtlServices += cdSvcDtlService;
            }
          }
        }

        //Set the variable to the return object
        rowCFIN19SOG.setSzTxtUASCodes(cdSvcDtlServices);

        rowCFIN19SOG_ARRAY.addROWCFIN19SOG(rowCFIN19SOG);
        ulRowQty++;
      }
    }
    rowCFIN19SOG_ARRAY.setUlRowQty(ulRowQty);
    output.setROWCFIN19SOG_ARRAY(rowCFIN19SOG_ARRAY);
    aos.setBMoreDataInd(bMoreDataInd);
    output.setArchOutputStruct(aos);
    return output;
  }
  
  //This method returns the unique values from the List
  public static ArrayList<String> GetUniqueValues(Collection<String> values)
  {
      return (ArrayList<String>)Union(values, values);
  }
  
  //This method returns the unique values from the List
  public static Collection<String> Union(Collection<String> coll1, Collection<String> coll2)
  {
      Set<String> union = new HashSet<String>(coll1);
      union.addAll(new HashSet<String>(coll2));
      return new ArrayList<String>(union);
  }
}
