package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

/*                 Change History:
  *                  Date      User              Description
  *                  --------  ----------------  -----------------------------------------------------------------------
  *                  08/11/08  charden           STGAP00009853 - called new DAO method to pull back per Diem line items 
  *                                              for the given invoice that do not have the same "from" or "to" day as the 
  *                                              line item the user is attempting to save 
  *        
  *                
  */
 
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexDelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexInvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.DelvrdSvcDtl;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveFosterCareDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN11SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN11SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN11SO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class SaveFosterCareDetailImpl extends BaseServiceImpl implements SaveFosterCareDetail {

  private DelvrdSvcDtlDAO delvrdSvcDtlDAO = null;

  private ComplexInvoiceDAO complexInvoiceDAO = null;

  private ComplexDelvrdSvcDtlDAO complexDelvrdSvcDtlDAO = null;

  public void setDelvrdSvcDtlDAO(DelvrdSvcDtlDAO delvrdSvcDtlDAO) {
    this.delvrdSvcDtlDAO = delvrdSvcDtlDAO;
  }

  public void setComplexInvoiceDAO(ComplexInvoiceDAO complexInvoiceDAO) {
    this.complexInvoiceDAO = complexInvoiceDAO;
  }

  public void setComplexDelvrdSvcDtlDAO(ComplexDelvrdSvcDtlDAO complexDelvrdSvcDtlDAO) {
    this.complexDelvrdSvcDtlDAO = complexDelvrdSvcDtlDAO;
  }

  public CFIN11SO saveFosterCareDetail(CFIN11SI cfin11si) throws ServiceException {
    CFIN11SO cfin11so = new CFIN11SO();
    cfin11so.setTsLastUpdate(countReversalsAndAdjustments(cfin11si));
    updateDelvrdSvcDtl(cfin11si.getROWCFIN11SIG00_ARRAY());
    updateDelvrdSvcDtlIdSvcDtlRevrsalOrig(cfin11si);
    return cfin11so;
  }

  private Date countReversalsAndAdjustments(CFIN11SI cfin11si) throws ServiceException {
    if (!CodesTables.CINVPHSE_VLP.equals(cfin11si.getSzCdInvoPhase())) {
      cfin11si.setSzCdInvoPhase(CodesTables.CINVPHSE_VLP);
    }
    Date dtTimeStampLastUpdated = null;
    // caud44
    if (!ArchitectureConstants.Y.equals(cfin11si.getCIndCopiedInv())) {
      dtTimeStampLastUpdated = complexInvoiceDAO
                                                .updateInvoiceWithIdInvoiceAndCdInvoPhase(
                                                                                          cfin11si.getUlIdInvoInvoice(),
                                                                                          cfin11si.getSzCdInvoPhase(),
                                                                                          cfin11si
                                                                                                  .getTsSysTsLastUpdate2());
      if (DateHelper.isNull(dtTimeStampLastUpdated)) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    }
    if (cfin11si.getROWCFIN11SIG00_ARRAY() != null
        && cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00().length != 0) {
      // Pull the idInvoice out of the first rowcfin11sig00 object in the array.
      int idInvoice = cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(0).getUlIdInvoInvoice();
      // The count information in this method does not appear to be utilized in the original service code.
      // cmsc08d
      long reversalCount = delvrdSvcDtlDAO
                                          .countDelvrdSvcDtlByIdInvoiceCdSvcDtlLiType(idInvoice, CodesTables.CLNITMTP_R);
      // cmsc08d
      long adjustmentCount = delvrdSvcDtlDAO.countDelvrdSvcDtlByIdInvoiceCdSvcDtlLiType(idInvoice,
                                                                                        CodesTables.CLNITMTP_A);

      for (Enumeration rowcfin11sig00Enum = cfin11si.getROWCFIN11SIG00_ARRAY().enumerateROWCFIN11SIG00(); rowcfin11sig00Enum
                                                                                                                            .hasMoreElements();) {
        ROWCFIN11SIG00 rowcfin11sig00 = (ROWCFIN11SIG00) rowcfin11sig00Enum.nextElement();
        String cdSvcDtlLiType = rowcfin11sig00.getSzCdSvcDtlLiType();
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(rowcfin11sig00.getSzCdScrDataAction())) {
          if (CodesTables.CLNITMTP_R.equals(cdSvcDtlLiType)) {
            reversalCount++;
          } else if (CodesTables.CLNITMTP_A.equals(cdSvcDtlLiType)) {
            adjustmentCount++;
          }
        }
      }
    }
    return dtTimeStampLastUpdated;

  }

  private void updateDelvrdSvcDtl(ROWCFIN11SIG00_ARRAY rowcfin11sig00_array) throws ServiceException {
    for (Enumeration rowcfin11sig00Enum = rowcfin11sig00_array.enumerateROWCFIN11SIG00(); rowcfin11sig00Enum
                                                                                                            .hasMoreElements();) {
      ROWCFIN11SIG00 rowcfin11sig00 = (ROWCFIN11SIG00) rowcfin11sig00Enum.nextElement();
      String cdSvcDtlLiType = rowcfin11sig00.getSzCdSvcDtlLiType();
      String cdSvcDtlService = rowcfin11sig00.getSzCdSvcDtlService();
      String cdSvcDtlUnitType = rowcfin11sig00.getSzCdSvcDtlUnitType();
      Date dtLastUpdate = rowcfin11sig00.getTsLastUpdate();
      int yrSvcDtlServiceYear = rowcfin11sig00.getUYrSvcDtlServiceYear();
      double nbrSvcDtlUnitQty = rowcfin11sig00.getSNbrSvcDtlUnitQty();
      int nbrSvcDtlToDay = rowcfin11sig00.getSNbrSvcDtlToDay();
      int nbrSvcDtlFromDay = rowcfin11sig00.getSNbrSvcDtlFromDay();
      int moSvcDtlSvcMonth = rowcfin11sig00.getUMoSvcDtlSvcMonth();
      String indSvcDtlRejItem = rowcfin11sig00.getCIndSvcDtlRejItem();
      int idSvcDtl = rowcfin11sig00.getUlIdSvcDtl();
      int idResource = rowcfin11sig00.getUlIdResource();
      int idPerson = rowcfin11sig00.getUlIdPerson();
      int idInvoInvoice = rowcfin11sig00.getUlIdInvoInvoice();
      double amtSvcDtlUnitRate = rowcfin11sig00.getDAmtSvcDtlUnitRate();
      double amtSvcDtlIncome = rowcfin11sig00.getDAmtSvcDtlIncome();

      // The following 4 values are not set in the original service, so use default values.
      double amtSvcDtlFeePaid = 0.0;
      // int idSvcAuthDtl = 0;
      int nbrSvcDtlCsli = 0;
      String cdSvcDtlInvoDisptn = null;

      int numrows;
      String reqFuncCd = rowcfin11sig00.getSzCdScrDataAction();
      //STGAP00007737: Added code to validate person Id, resource Id to and From days 
      //and the per-diem services.
      //Begin
      if (idInvoInvoice != 0) {
        List<DelvrdSvcDtl> delSvcDtlList = delvrdSvcDtlDAO.findDelvrdSvcDtlByIdInvoiceAndIdPerson(idInvoInvoice,
                                                                                                  idPerson);
        //If the person Id does not match with the one on the already
        //existing line items throw an exception.
        if (delSvcDtlList != null && delSvcDtlList.size() > 0) {
          throw new ServiceException(Messages.MSG_FIN_INV_DTL_PERSON);
        }
        delSvcDtlList = null;
        delSvcDtlList = delvrdSvcDtlDAO.findDelvrdSvcDtlByIdInvoiceAndIdResource(idInvoInvoice, idResource);
        //If the Resource Id does not match with the one on the already
        //existing line items throw an exception.
        if (delSvcDtlList != null && delSvcDtlList.size() > 0) {
          throw new ServiceException(Messages.MSG_FIN_INV_DTL_RESOURCE);
        }
        if (CodesTables.CCONUNIT_DA2.equals(cdSvcDtlUnitType) || CodesTables.CCONUNIT_DAY.equals(cdSvcDtlUnitType)) {
          delSvcDtlList = null;
          //STGAP00009853 - called new DAO method to pull back per Diem line items for the given invoice
          //that do not have the same "from" or "to" day as the line item the user is attempting to save  
          delSvcDtlList = delvrdSvcDtlDAO.findDelvrdSvcDtlByIdInvoiceAndToDayAndCdSvcDtlService(idInvoInvoice, nbrSvcDtlToDay,
                                                                              nbrSvcDtlFromDay, idSvcDtl);
          //If the From and To days do not match with the one on the already
          //existing line items throw an exception.
          if (delSvcDtlList != null && delSvcDtlList.size() > 0) {
            throw new ServiceException(Messages.MSG_FIN_INV_DTL_DAYS);
          }
        }
        double itemTotal = nbrSvcDtlUnitQty * amtSvcDtlUnitRate;
        List<String> servicesList = new ArrayList<String>();
        populateServices(servicesList);
        if(cdSvcDtlService!=null && cdSvcDtlService.length()>=5){
        String entCode = cdSvcDtlService.substring(3, 5);
        Collection<String> restrictedFundList = new ArrayList<String>();
        populateRestrictedFundSvcs(entCode, restrictedFundList);
        String cdSvcDtlServiceTrunc = cdSvcDtlService.substring(0,5);
        if ((itemTotal == 0.0 || itemTotal==0.00) && servicesList.contains(cdSvcDtlServiceTrunc)) {
          List<DelvrdSvcDtl> delSvcList = delvrdSvcDtlDAO.findDlvrdDtlByIdInvoice(idInvoInvoice, restrictedFundList);
          //If the user is trying to save a per-diem service with zero item total
          //and there is no existing nonzero line item for restricted funds throw
          //an exception
          if (delSvcList == null || delSvcList.isEmpty()) {
            throw new ServiceException(Messages.MSG_FIN_INV_DTL_AMT);
          }
        }
        }
      }
      //STGAP00007737: end
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
        // caud04d
        numrows = delvrdSvcDtlDAO.insertDelvrdSvcDtl(dtLastUpdate, idInvoInvoice, idPerson, idResource,
                                                     amtSvcDtlFeePaid, amtSvcDtlIncome, amtSvcDtlUnitRate,
                                                     cdSvcDtlInvoDisptn, cdSvcDtlLiType, cdSvcDtlService,
                                                     cdSvcDtlUnitType, indSvcDtlRejItem, moSvcDtlSvcMonth,
                                                     nbrSvcDtlCsli, nbrSvcDtlFromDay, nbrSvcDtlToDay, nbrSvcDtlUnitQty,
                                                     yrSvcDtlServiceYear);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {
        // caud04d
        numrows = delvrdSvcDtlDAO.updateDelvrdSvcDtl(idSvcDtl, idInvoInvoice, idPerson, idResource, // idSvcAuthDtl,
                                                     amtSvcDtlFeePaid, amtSvcDtlIncome, amtSvcDtlUnitRate,
                                                     cdSvcDtlInvoDisptn, cdSvcDtlLiType, cdSvcDtlService,
                                                     cdSvcDtlUnitType, indSvcDtlRejItem, moSvcDtlSvcMonth,
                                                     nbrSvcDtlCsli, nbrSvcDtlFromDay, nbrSvcDtlToDay, nbrSvcDtlUnitQty,
                                                     yrSvcDtlServiceYear, dtLastUpdate);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      if (numrows == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
  }

  private void updateDelvrdSvcDtlIdSvcDtlRevrsalOrig(CFIN11SI cfin11si) throws ServiceException {
    for (Enumeration rowcfin11sig00Enum = cfin11si.getROWCFIN11SIG00_ARRAY().enumerateROWCFIN11SIG00(); rowcfin11sig00Enum
                                                                                                                          .hasMoreElements();) {
      ROWCFIN11SIG00 rowcfin11sig00 = (ROWCFIN11SIG00) rowcfin11sig00Enum.nextElement();
      if (rowcfin11sig00.getSNbrSvcDtlUnitQty() == 0
          && ArchitectureConstants.N.equals(rowcfin11sig00.getCIndSvcDtlRejItem())) {
        // clscb2d -- ignores SQL_NOT_FOUND
        DelvrdSvcDtl delvrdSvcDtl = delvrdSvcDtlDAO.findDelvrdSvcDtl(rowcfin11sig00.getUlIdInvoInvoice());
        // caude0d -- ignores SQl_NOT_FOUND
        complexDelvrdSvcDtlDAO.updateDelvrdSvcDtl(delvrdSvcDtl.getDelvrdSvcDtl().getIdSvcDtl());
      }
    }
  }
  
  //STGAP00007737: Added this method to populate the per-diem services in a collection
  private void populateServices(List<String> servicesList){

    servicesList.add("50101");
    servicesList.add("50102");
    servicesList.add("50201");
    servicesList.add("50202");
    servicesList.add("50301");
    servicesList.add("50302");
    servicesList.add("52060");
    servicesList.add("52901");
    servicesList.add("52902");
    servicesList.add("52999");
    servicesList.add("56001");
    servicesList.add("56002");
    servicesList.add("56001");
    servicesList.add("56002");
    servicesList.add("57401");
    servicesList.add("57402");
    servicesList.add("57499");
    servicesList.add("57501");
    servicesList.add("57502");
    servicesList.add("57599");
    servicesList.add("57901");
    servicesList.add("57902");
    servicesList.add("57999");
    servicesList.add("60501");
    servicesList.add("60599");
    servicesList.add("60601");
    servicesList.add("60699");
    servicesList.add("60701");
    servicesList.add("60799");
    servicesList.add("60801");
    servicesList.add("60899");
    servicesList.add("60901");
    servicesList.add("60999");
    servicesList.add("61001");
    servicesList.add("61099");
    servicesList.add("61101");
    servicesList.add("61199");
    servicesList.add("61201");
    servicesList.add("61299");
    servicesList.add("61301");
    servicesList.add("61399");
    servicesList.add("61401");
    servicesList.add("61499");
    servicesList.add("61501");
    servicesList.add("61599");
    servicesList.add("61601");
    servicesList.add("61699");
  }
  //STGAP00007737: Added this method to populate the restricted fund services in a collection
  private void populateRestrictedFundSvcs(String entCode, Collection<String> restrictedFundList) {
    restrictedFundList.add("252".concat(entCode));
    restrictedFundList.add("253".concat(entCode));
    restrictedFundList.add("450".concat(entCode));
    restrictedFundList.add("460".concat(entCode));
  }

}
