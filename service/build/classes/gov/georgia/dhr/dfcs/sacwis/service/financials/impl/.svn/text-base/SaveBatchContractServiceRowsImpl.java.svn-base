package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveBatchContractServiceRows;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveContractList;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveCountyList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.BatchContractServiceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.BatchContractServiceSI.BatchContractServiceRow;
import gov.georgia.dhr.dfcs.sacwis.structs.output.BatchContractServiceSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.Csli_ARRAY;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *                                        Change History
 *
 *   Date          User                                         Description
 * --------  ----------------  --------------------------------------------------
 * 10/16/11  charden           STGAP00017058: created new service to save contract services
 * 11/20/11  htvo              STGAP00017679: patch to not save to contract list if there is no county associated (specified by Services by Area page)
 *
 *
*/


public class SaveBatchContractServiceRowsImpl extends BaseServiceImpl implements SaveBatchContractServiceRows {

  private SaveContractList saveContractList;
  private SaveCountyList saveCountyList;
  private ComplexCapsResourceDAO complexCapsResourceDAO;
  private ContractServiceDAO contractServiceDAO;
  
  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public void setComplexCapsResourceDAO(ComplexCapsResourceDAO complexCapsResourceDAO) {
    this.complexCapsResourceDAO = complexCapsResourceDAO;
  }

  public void setSaveContractList(SaveContractList saveContractList) {
    this.saveContractList = saveContractList;
  }

  public void setSaveCountyList(SaveCountyList saveCountyList) {
    this.saveCountyList = saveCountyList;
  }


  public BatchContractServiceSO saveBatchContractServiceRows(BatchContractServiceSI batchContractServiceSI) throws ServiceException{
    List<BatchContractServiceRow> batchContractServiceRowList = batchContractServiceSI.getBatchContractServiceRowList();
    Map<Integer, Integer> duplicateServiceMap = new HashMap<Integer, Integer>();
    int numDuplicateServices = 0;
    if(batchContractServiceRowList != null){
      // save contract services
      CCON12SI ccon12si = populateCCON12SI_AU(batchContractServiceSI);
      CCON12SO ccon12so = saveContractList.saveContractList(ccon12si);
      // get duplicate csli's
      Csli_ARRAY csliArray = ccon12so.getCsli_ARRAY();
      if(csliArray != null && csliArray.getUlRowQty() > 0){
        numDuplicateServices = csliArray.getUlRowQty();
        Iterator<Integer> it = csliArray.iterateCsli();
        while(it.hasNext()){
          Integer csli = it.next();
          duplicateServiceMap.put(csli, csli);
        }
      }
      
      // save contract counties
      for(BatchContractServiceRow contractServiceRow : batchContractServiceRowList){
        CCON14SI ccon14si = populateCCON14SI_AU_COUNTY_LIST(contractServiceRow, batchContractServiceSI, numDuplicateServices);
        if(ccon14si != null && !duplicateServiceMap.containsKey(contractServiceRow.getUlNbrCnsvcLineItem())){
          saveCountyList.saveCountyList(ccon14si);
        }
      }  
    }
    return new BatchContractServiceSO();
  }
  
  private CCON12SI populateCCON12SI_AU(BatchContractServiceSI batchContractServiceSI) {
    // get data structures
    ROWCCON12SIG00 rowccon12sig00 = null;
    CCON12SI ccon12si = new CCON12SI();
    String szCdScrDataAction = ServiceConstants.REQ_FUNC_CD_ADD;
    ROWCCON12SIG00_ARRAY rowccon12sig00_array = new ROWCCON12SIG00_ARRAY();
    List<BatchContractServiceRow> BatchContractServiceRowList = batchContractServiceSI.getBatchContractServiceRowList();
    
    // get the maximum line number
    Integer csli = contractServiceDAO
                                 .findMaxCnsvcLineItemByIdContractPeriodVersion(
                                                                                batchContractServiceSI.getIdContract(),
                                                                                batchContractServiceSI
                                                                                                      .getUlNbrContractPeriod(),
                                                                                batchContractServiceSI
                                                                                                      .getUlNbrContractVersion());
    
    if(csli == null){
      csli = 0;
    }

    // add row data to array object
    for(BatchContractServiceRow contractServiceRow : BatchContractServiceRowList){
      // increment the line number for the new line
      rowccon12sig00 = new ROWCCON12SIG00();
      csli++;
      // STGAP00017679: patch to not save to contract list if there is no county associated (specified by Services by Area page)
      // get the counties that the service is offered in where there is not a current contract
      int idContract = batchContractServiceSI.getIdContract();
      String cdRsrcSvcService = contractServiceRow.getServiceCode();
      int nbrCncntyPeriod = batchContractServiceSI.getUlNbrContractPeriod();
      int nbrCncntyVersion = batchContractServiceSI.getUlNbrContractVersion();
      int idResource = batchContractServiceSI.getIdResource();
      Date dtCncntyEffective = batchContractServiceSI.getCountyEffective();
      Date dtCncntyEnd = batchContractServiceSI.getCountyEnd();
      List<Map>  countyList = complexCapsResourceDAO.findCountyResource(idContract, cdRsrcSvcService, nbrCncntyPeriod, nbrCncntyVersion,
                                                                        csli, idResource, dtCncntyEffective, dtCncntyEnd);
      
      // do not perform this save if there are no counties to save this service under
      if (countyList == null || countyList.size() == 0) {
        continue;
      }
      
      // set the csli in the row
      contractServiceRow.setUlNbrCnsvcLineItem(csli);
      
      // set as zero's for add but since all of these are adds, there is no need to check for an add
      rowccon12sig00.setUlAmtCnsvcUnitRate(0);
      rowccon12sig00.setUlAmtCnsvcEquip(0);
      rowccon12sig00.setUlAmtCnsvcFrgBenft(0);
      rowccon12sig00.setUlAmtCnsvcOther(0);
      rowccon12sig00.setUlAmtCnsvcSalary(0);
      rowccon12sig00.setUlAmtCnsvcSupply(0);
      rowccon12sig00.setUlAmtCnsvcTravel(0); 
      rowccon12sig00.setSzCdCnsvcPaymentType(contractServiceRow.getPaymentType());
      rowccon12sig00.setSzCdCnsvcService(contractServiceRow.getServiceCode());
      rowccon12sig00.setSzNbrCnsvcUnitType(contractServiceRow.getUnitType());
      rowccon12sig00.setCIndCnsvcNewRow("Y");
      // ROWCCON11SOG00 (pulled from the request in the jsp and named contractDetailRow) is only placed 
      // into the request during display of contract service detail if we are not in add mode. This being the
      // case, contractDetailRow variable is pointed to a new ROWCCON11SOG00 row and so the attempt to store 
      // the id of the contract service into a hidden variable actually stores 0 into the variable. So place
      // a 0 into setUlIdCnsvc.
      rowccon12sig00.setUlIdCnsvc(0); 
      rowccon12sig00.setUlNbrCnsvcFedMatch(contractServiceRow.getFederalMatch());
      rowccon12sig00.setUlNbrCnsvcLineItem(csli);
      rowccon12sig00.setUlNbrCnsvcLocalMatch(contractServiceRow.getLocalMatch());
      rowccon12sig00.setUlNbrCnsvcUnitRate(contractServiceRow.getUnitRate());
      rowccon12sig00.setSzCdScrDataAction(szCdScrDataAction);
      rowccon12sig00.setTsLastUpdate(DateHelper.toJavaDateSafe(""));
      rowccon12sig00_array.addROWCCON12SIG00(rowccon12sig00);
    }
    
    // insert data into so object
    ccon12si.setROWCCON12SIG00_ARRAY(rowccon12sig00_array);
    ccon12si.setArchInputStruct(batchContractServiceSI.getInput());
    ccon12si.setSzCdCntrctFuncType(batchContractServiceSI.getContractFunctionType());
    ccon12si.setDtDtCncntyEffective(DateHelper.toCastorDate(batchContractServiceSI.getCountyEffective()));
    ccon12si.setDtDtCncntyEnd(DateHelper.toCastorDate(batchContractServiceSI.getCountyEnd()));
    ccon12si.setUlIdCntrctWkr(batchContractServiceSI.getUserId());
    ccon12si.setUlIdContract(batchContractServiceSI.getIdContract());
    ccon12si.setUlNbrCnsvcPeriod(batchContractServiceSI.getUlNbrContractPeriod());
    ccon12si.setUlNbrCnsvcVersion(batchContractServiceSI.getUlNbrContractVersion());

    return ccon12si;
  }
  
  
  private CCON14SI populateCCON14SI_AU_COUNTY_LIST(BatchContractServiceRow contractServiceRow, BatchContractServiceSI batchContractServiceSI, int numDuplicateServices){
    int idContract = batchContractServiceSI.getIdContract();
    String cdRsrcSvcService = contractServiceRow.getServiceCode();
    int nbrCncntyPeriod = batchContractServiceSI.getUlNbrContractPeriod();
    int nbrCncntyVersion = batchContractServiceSI.getUlNbrContractVersion();
    int nbrCncntyLineItem = contractServiceRow.getUlNbrCnsvcLineItem() - numDuplicateServices;
    int idResource = batchContractServiceSI.getIdResource();
    Date dtCncntyEffective = batchContractServiceSI.getCountyEffective();
    Date dtCncntyEnd = batchContractServiceSI.getCountyEnd();
    String szCdScrDataAction = ServiceConstants.REQ_FUNC_CD_ADD;
    
    // get the counties that the service is offered in where there is not a current contract
    List<Map>  countyList = complexCapsResourceDAO.findCountyResource(idContract, cdRsrcSvcService, nbrCncntyPeriod, nbrCncntyVersion,
                                              nbrCncntyLineItem, idResource, dtCncntyEffective, dtCncntyEnd);
    
    // do not perform this save if there are no counties to save this service under
    if (countyList == null || countyList.size() == 0) {
      return null;
    }

    // package up counties
    ROWCCON13SOG_ARRAY rowccon13sog_array = new ROWCCON13SOG_ARRAY();
    for (Iterator<Map> it = countyList.iterator(); it.hasNext();) {
      Map row = it.next();
      ROWCCON13SOG rowccon13sog = new ROWCCON13SOG();
      rowccon13sog.setUlIdCncnty((Integer) row.get("idCncnty") != null ? (Integer) row.get("idCncnty") : 0);
      rowccon13sog.setSzCdCncntyCounty((String) row.get("cdRsrcSvcCnty"));
      rowccon13sog.setTsLastUpdate((Date) row.get("dtLastUpdate"));
      rowccon13sog_array.addROWCCON13SOG(rowccon13sog);
    }


    CCON14SI ccon14si = new CCON14SI();
    ArchInputStruct input = batchContractServiceSI.getInput();
    input.setUlPageSizeNbr(countyList.size());
    ccon14si.setArchInputStruct(input);
    ccon14si.setSzCdRsrcSvcService(contractServiceRow.getServiceCode());
    ccon14si.setDtDtCncntyEffective(DateHelper.toCastorDate(batchContractServiceSI.getCountyEffective()));
    ccon14si.setDtDtCncntyEnd(DateHelper.toCastorDate(batchContractServiceSI.getCountyEnd()));
    ccon14si.setUlIdCntrctWkr(batchContractServiceSI.getUserId());
    ccon14si.setUlIdContract(batchContractServiceSI.getIdContract());
    ccon14si.setUlIdResource(batchContractServiceSI.getIdResource());
    ccon14si.setUlNbrCncntyLineItem(nbrCncntyLineItem);
    ccon14si.setUlNbrCncntyPeriod(batchContractServiceSI.getUlNbrContractPeriod());
    ccon14si.setUlNbrCncntyVersion(batchContractServiceSI.getUlNbrContractVersion());

    ROWCCON14SIG_ARRAY rowccon14sig_array = new ROWCCON14SIG_ARRAY();
    Enumeration e = rowccon13sog_array.enumerateROWCCON13SOG();

    while (e.hasMoreElements()) {
      ROWCCON13SOG rowccon13sog = (ROWCCON13SOG) e.nextElement();
      ROWCCON14SIG rowccon14sig = new ROWCCON14SIG();

      rowccon14sig.setSzCdCncntyCounty(rowccon13sog.getSzCdCncntyCounty());
      rowccon14sig.setUlIdCncnty(rowccon13sog.getUlIdCncnty());
      rowccon14sig.setSzCdScrDataAction(szCdScrDataAction);
      rowccon14sig.setTsLastUpdate(rowccon13sog.getTsLastUpdate());
      rowccon14sig_array.addROWCCON14SIG(rowccon14sig);
    }
    ccon14si.setROWCCON14SIG_ARRAY(rowccon14sig_array);

    return ccon14si;
  }

  
}
