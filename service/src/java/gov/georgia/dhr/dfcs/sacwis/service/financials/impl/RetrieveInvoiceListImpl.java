package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicInvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.DelvrdSvcDtl;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveInvoiceList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN01SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN01SOG00_ARRAY;

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
 *   04/08/2009 bgehlot   STGAP00013273: Added the code to set the UAS Codes in the return object
 *   06/10/2009 bgehlot   STGAP00014197: Checking for null 
 *                        
 * </pre>
 */

public class RetrieveInvoiceListImpl extends BaseServiceImpl implements RetrieveInvoiceList {

  private DynamicInvoiceDAO dynamicInvoiceDAO = null;
  
  private DelvrdSvcDtlDAO delvrdSvcDtlDAO;

  public void setDynamicInvoiceDAO(DynamicInvoiceDAO dynamicInvoiceDAO) {
    this.dynamicInvoiceDAO = dynamicInvoiceDAO;
  }
  
  public void setDelvrdSvcDtlDAO(DelvrdSvcDtlDAO delvrdSvcDtlDAO) {
    this.delvrdSvcDtlDAO = delvrdSvcDtlDAO;
  }

  public CFIN01SO retrieveInvoiceList(CFIN01SI cfin01si) {
    CFIN01SO output = new CFIN01SO();
    //ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    //output.setArchOutputStruct(archOutputStruct);
    String cdCntrctRegion = cfin01si.getSzCdCntrctRegion();
    String cdInvoCounty = cfin01si.getSzCdCounty();
    String cdInvoPhase = cfin01si.getSzCdInvoPhase();
    String cdInvoType = cfin01si.getSzCdInvoType();
    int idInvoInvoice = cfin01si.getUlIdInvoInvoice();
    int idContract = cfin01si.getUlIdContract();
    int idResource = cfin01si.getUlIdResource();
    int moInvoMonth = cfin01si.getUMoInvoMonth();
    int yrInvoYear = cfin01si.getUYrInvoYear();
    
    //STGAP00013273 : Added new field Client Person ID to search on
    int idClientPerson = cfin01si.getUlIdClientPerson();
    
    //-- pagination
    int pageNbr = cfin01si.getArchInputStruct().getUsPageNbr();
    int pageSize = cfin01si.getArchInputStruct().getUlPageSizeNbr();
    
    // cdyn07dQUERYdam
    PaginatedHibernateList<Object[]> objectArrayList = dynamicInvoiceDAO.findInvoices(idInvoInvoice, idContract, idResource,
                                                                    cdCntrctRegion, cdInvoCounty, moInvoMonth, cdInvoPhase,
                                                                    cdInvoType, yrInvoYear, pageNbr, pageSize, idClientPerson);
    
    ROWCFIN01SOG00_ARRAY rowCFIN01SOG00_ARRAY = new ROWCFIN01SOG00_ARRAY();
    int count = 0;
    
    if (objectArrayList != null && !objectArrayList.isEmpty()) {
      //ROWCFIN01SOG00_ARRAY rowCFIN01SOG00_ARRAY = output.getROWCFIN01SOG00_ARRAY();
      //if (rowCFIN01SOG00_ARRAY==null){
      //  rowCFIN01SOG00_ARRAY = new ROWCFIN01SOG00_ARRAY();
      //  output.setROWCFIN01SOG00_ARRAY(rowCFIN01SOG00_ARRAY);
      //}
      for (Iterator<Object[]> it = objectArrayList.iterator(); it.hasNext();) {
        Object[] objectArray = it.next();
        ROWCFIN01SOG00 rowCFIN01SOG00 = new ROWCFIN01SOG00();

        cdCntrctRegion = (String) objectArray[0];
        cdInvoPhase = (String) objectArray[10];
        cdInvoType = (String) objectArray[11];
        String nmResource = (String) objectArray[2];
        double amtInvoValidAmount = 0;
        if (objectArray[20]!=null){
          amtInvoValidAmount = (Double) objectArray[20];
        }
        Date dtInvoSubmitDate = (Date) objectArray[17];
        String indInvoRejItems = (String) objectArray[23];
        idContract = (Integer) objectArray[5];
        idInvoInvoice = (Integer) objectArray[3];
        idResource = (Integer) objectArray[1];
        cdInvoCounty = (String) objectArray[28];
        String nmPersonFull = (String) objectArray[29];
        rowCFIN01SOG00.setSzCdCntrctRegion(cdCntrctRegion);
        rowCFIN01SOG00.setSzCdInvoPhase(cdInvoPhase);
        rowCFIN01SOG00.setSzCdInvoType(cdInvoType);
        rowCFIN01SOG00.setSzNmResource(nmResource);
        rowCFIN01SOG00.setDAmtInvoValidAmount(amtInvoValidAmount);
        rowCFIN01SOG00.setDtDtInvoSubmitDate(DateHelper.toCastorDate(dtInvoSubmitDate));
        rowCFIN01SOG00.setCIndInvoRejItems(indInvoRejItems);
        rowCFIN01SOG00.setUlIdContract(idContract);
        rowCFIN01SOG00.setUlIdInvoInvoice(idInvoInvoice);
        rowCFIN01SOG00.setUlIdResource(idResource);
        rowCFIN01SOG00.setSzCdCounty(cdInvoCounty != null ? cdInvoCounty : "");
        rowCFIN01SOG00.setSzNmPersonFull(nmPersonFull);
        
        //STGAP00013273: Get the Service codes for the invoice
        List<DelvrdSvcDtl> listdsd = delvrdSvcDtlDAO.findSvcAuthDtlByIdInvoice(idInvoInvoice);
        List<String> cdUASCodedList = new ArrayList<String>();
        String cdSvcDtlServices = StringHelper.EMPTY_STRING;
        
        //Get the first three characters from the service code. These three characters is the UAS code
        //Add these UAS codes to a list.
        if (listdsd != null) {
          for (Iterator<DelvrdSvcDtl> iter = listdsd.iterator(); iter.hasNext();) {
            DelvrdSvcDtl delvrdSvcDtl = iter.next();
            String cdSvcDtlService = delvrdSvcDtl.getCdSvcDtlService();
            //STGAP00014197: Checking for null 
            if(cdSvcDtlService != null){
              if(cdSvcDtlService.length() >= 3){
                cdSvcDtlService = cdSvcDtlService.substring(0, 3);
              }
            }
            cdUASCodedList.add(cdSvcDtlService != null? cdSvcDtlService : StringHelper.EMPTY_STRING);
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
        rowCFIN01SOG00.setSzTxtUASCodes(cdSvcDtlServices);
        rowCFIN01SOG00_ARRAY.addROWCFIN01SOG00(rowCFIN01SOG00);
        count++;
      }
    }
    
    rowCFIN01SOG00_ARRAY.setUlRowQty(count);
    output.setROWCFIN01SOG00_ARRAY(rowCFIN01SOG00_ARRAY);
    
    //-- pagination
    ArchOutputStruct aos = new ArchOutputStruct();
    aos.setBMoreDataInd(objectArrayList.getBMoreDataInd());
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
