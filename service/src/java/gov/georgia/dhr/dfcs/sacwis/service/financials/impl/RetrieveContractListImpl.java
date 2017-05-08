package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicContractDAO;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveContractList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON01SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON01SOG00_ARRAY;

import java.util.Iterator;
import java.util.List;

public class RetrieveContractListImpl extends BaseServiceImpl implements RetrieveContractList {

  private ContractCountyDAO contractCountyDAO = null;
  private DynamicContractDAO dynamicContractDAO = null;

  public static final String COUNTY_CODES_TABLES = "CCOUNT";

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setDynamicContractDAO(DynamicContractDAO dynamicContractDAO) {
    this.dynamicContractDAO = dynamicContractDAO;
  }

  public CCON01SO retrieveContractList(CCON01SI ccon01si) throws ServiceException {

    CCON01SO ccon01so = new CCON01SO();
    ArchInputStruct archInputStruct = ccon01si.getArchInputStruct();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();

    PaginatedHibernateList<Object[]> objectArrayList = dynamicContractDAO.findContracts(ccon01si.getUlIdContract(),
                                                                      ccon01si.getSzCdCntrctProgramType(),
                                                                      ccon01si.getSzCdCntrctCounty(),
                                                                      ccon01si.getSzCdCntrctRegion(),
                                                                      ccon01si.getUlIdResource(),
                                                                      ccon01si.getSzCdCntrctFuncType(),
                                                                      DateHelper.toJavaDate(ccon01si.getDtDtCnperStart()),
                                                                      DateHelper.toJavaDate(ccon01si.getDtDtCnperTerm()),
                                                                      ccon01si.getCIndCntrctBudgLimit(), pageNbr, pageSize);
    
    ROWCCON01SOG00_ARRAY rowccon01sog00_array = new ROWCCON01SOG00_ARRAY();
    
    List<Object[]> countyCounts = dynamicContractDAO.findCounts(ccon01si.getUlIdContract(),
                                                                   ccon01si.getSzCdCntrctProgramType(),
                                                                   ccon01si.getSzCdCntrctCounty(),
                                                                   ccon01si.getSzCdCntrctRegion(),
                                                                   ccon01si.getUlIdResource(),
                                                                   ccon01si.getSzCdCntrctFuncType(),
                                                                   DateHelper.toJavaDate(ccon01si.getDtDtCnperStart()),
                                                                   DateHelper.toJavaDate(ccon01si.getDtDtCnperTerm()),
                                                                   ccon01si.getCIndCntrctBudgLimit());    

    
    ccon01so.setMoreDataAvailable(StringHelper.toBooleanOrNull(objectArrayList.getBMoreDataInd()));
   

    for (Iterator<Object[]> it = objectArrayList.iterator(); it.hasNext();) {
      Object[] objectArray = it.next();
      
      Integer idContract = getIntSafe((Integer) objectArray[0]);
      if(idContract == 0) {
        continue;
      }
      
      String countyValue = "";
      if(countyCounts != null && countyCounts.size() > 0) {
        for(Object[] countyCount : countyCounts) {
          int idContractCounty = getIntSafe((Integer)countyCount[0]);
          if(idContractCounty == idContract) {
            int count = getIntSafe((Integer)countyCount[1]);
            if(count == 1) {
              // if search used county value and match found, use the input county code value to return, no need to call DAO
              if (StringHelper.isValid(ccon01si.getSzCdCntrctCounty())) {
                countyValue = ccon01si.getSzCdCntrctCounty();
              }
              else {
                countyValue = contractCountyDAO.findContractCounties(idContractCounty);
              }
            } else {
              countyValue = "" + count + " Counties";
            }
          }
        }
      }
      
      ROWCCON01SOG00 rowccon01sog00 = new ROWCCON01SOG00();

      // Retrieve the Function Type
      String fType = (String) objectArray[2];

      // check if Function Type is not "APS POS", then set rowccon01sog00 values
      if (!("APS".equals(fType))) {
        rowccon01sog00.setUlIdContract((Integer) objectArray[0] != null ? (Integer) objectArray[0] : 0);
        rowccon01sog00.setSzCdCntrctRegion((String) objectArray[1]);
        rowccon01sog00.setSzCdCntrctFuncType((String) objectArray[2]);
        rowccon01sog00.setSzCdCntrctCounty(countyValue);
        rowccon01sog00.setCIndCntrctBudgLimit((String) objectArray[3]);
        rowccon01sog00.setUlIdResource((Integer) objectArray[4] != null ? (Integer) objectArray[4] : 0);
        rowccon01sog00.setSzNmResource((String) objectArray[5]);
        rowccon01sog00.setSzNmPersonFull((String) objectArray[6]);
        rowccon01sog00.setSzNbrRsrcAddrVid((String) objectArray[7]);
        rowccon01sog00_array.addROWCCON01SOG00(rowccon01sog00);
      }
    }
    ccon01so.setROWCCON01SOG00_ARRAY(rowccon01sog00_array);

    return ccon01so;
  }
  
  private int getIntSafe(Integer i) {
    if(i == null) {
      return 0;
    }
    return i;
  }

}
