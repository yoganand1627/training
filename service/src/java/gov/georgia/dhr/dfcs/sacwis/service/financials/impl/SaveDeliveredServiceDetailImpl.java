package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexDelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexInvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.DelvrdSvcDtl;
import gov.georgia.dhr.dfcs.sacwis.db.Invoice;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveDeliveredServiceDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN07SO;

import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

public class SaveDeliveredServiceDetailImpl extends BaseServiceImpl implements SaveDeliveredServiceDetail {

  private static final String FIN_CD_INVO_PHASE_PEND = CodesTables.CINVPHSE_VLP;
  private static final String FIN_COST_REIM = CodesTables.CCONPAY_CRM;

  private ComplexInvoiceDAO complexInvoiceDAO = null;
  private DelvrdSvcDtlDAO delvrdSvcDtlDAO = null;
  private ComplexDelvrdSvcDtlDAO complexDelvrdSvcDtlDAO = null;
  private ContractDAO contractDAO = null;
  private SvcAuthDetailDAO svcAuthDetailDAO = null;
  
  public void setContractDAO(ContractDAO contractDAO){
    this.contractDAO = contractDAO;
  }

  public void setComplexInvoiceDAO(ComplexInvoiceDAO complexInvoiceDAO) {
    this.complexInvoiceDAO = complexInvoiceDAO;
  }

  public void setComplexDelvrdSvcDtlDAO(ComplexDelvrdSvcDtlDAO complexDelvrdSvcDtlDAO) {
    this.complexDelvrdSvcDtlDAO = complexDelvrdSvcDtlDAO;
  }

  public void setDelvrdSvcDtlDAO(DelvrdSvcDtlDAO delvrdSvcDtlDAO) {
    this.delvrdSvcDtlDAO = delvrdSvcDtlDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public CFIN07SO saveDelvrdSvcDtl(CFIN07SI cfin07si) throws ServiceException {

    CFIN07SO cfin07so = new CFIN07SO();
    int idInvoice =0;
    int personId =0;
    ROWCFIN07SIG row0 = null;
    if (cfin07si.getROWCFIN07SIG_ARRAY() != null && cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG() != null
        && cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG().length != 0) {
      // First, update invoice
      row0 = cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(0);
      personId = row0.getUlIdPerson();
      idInvoice = row0.getUlIdInvoInvoice();
    }
    //STGAP00007737: Added the following if block to check if the person Id that is being saved is same as the 
    //other line items.If not an exception is thrown
    if(idInvoice!=0){
       List<DelvrdSvcDtl> delSvcDtlList = delvrdSvcDtlDAO.findDelvrdSvcDtlByIdInvoiceAndIdPerson(idInvoice, personId);
        if(delSvcDtlList!=null && delSvcDtlList.size()>0){
          throw new ServiceException(Messages.MSG_FIN_INV_DTL_PERSON);
        }
    }
    Date dtLastUpdate2 = cfin07si.getTsSysTsLastUpdate2();
    // If the invoice phase is not Pending Validation, set it back to Pending Validation   
    String cdInvoPhase = FIN_CD_INVO_PHASE_PEND;

    // caud44dAUDdam
    if(!ArchitectureConstants.Y.equals(cfin07si.getCIndCopiedInv())){
    Date dtLastUpdate = complexInvoiceDAO.updateInvoiceWithIdInvoiceAndCdInvoPhase(idInvoice, cdInvoPhase,
                                                                                   dtLastUpdate2);

    if (dtLastUpdate == null) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    } else {
      // Copy the new timestamp for the Invoice
      cfin07so.setTsLastUpdate(dtLastUpdate);
    }
    }
    // get the Resource ID from Contract
    Map map = contractDAO.findContractAndMore(cfin07si.getUlIdContract());
    int idResource = 0;
    if(map!=null){
        idResource = ((Integer) map.get("idResource")).intValue();
    }
    Date date = new Date();
    // now update service detail rows
    Enumeration enumArray = cfin07si.getROWCFIN07SIG_ARRAY().enumerateROWCFIN07SIG();
    while (enumArray.hasMoreElements()) {
      ROWCFIN07SIG row = (ROWCFIN07SIG) enumArray.nextElement();
      String cReqFuncCd = row.getSzCdSysDataActionOutcome();
      int idSvcDtl = row.getUlIdSvcDtl();
      
      DelvrdSvcDtl delvrdSvcDtl = null;
      if(ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
        delvrdSvcDtl = delvrdSvcDtlDAO.findDelvrdSvcDtlByPrimaryKey(idSvcDtl);
        if(delvrdSvcDtl == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        delvrdSvcDtlDAO.deleteDelvrdSvcDtl(delvrdSvcDtl);
      } else {
        String cdSvcDtlCounty = row.getSzCdSvcDtlCounty();
        String cdSvcDtlService = row.getSzCdSvcDtlService();
        String cdSvcDtlUnitType = row.getSzCdSvcDtlUnitType();
        String cdSvcDtlLiType = row.getSzCdSvcDtlLiType();
        String indSvcDtlRejItem = row.getCIndSvcDtlRejItem();
        double dAmtSvcDtlFeePaid = row.getDAmtSvcDtlFeePaid();
        double dAmtSvcDtlUnitRate = row.getDAmtSvcDtlUnitRate();
        int idPerson = row.getUlIdPerson();
        int idInvoInvoice = row.getUlIdInvoInvoice();
        int idSvcAuthDtl = row.getUlIdSvcAuthDtl();
        int iMoSvcDtlSvcMonth = row.getUMoSvcDtlSvcMonth();
        int iYrSvcDtlServiceYear = row.getUYrSvcDtlServiceYear();
        int iNbrSvcDtlCsli = row.getUsNbrSvcDtlCsli();
        double dNbrSvcDtlUnitQty = row.getSNbrSvcDtlUnitQty();
        
        if(ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
          if(idInvoInvoice < 1 || idPerson < 1) {
            throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
          }
          delvrdSvcDtl = new DelvrdSvcDtl();
          delvrdSvcDtl.setIdSvcDtl(0);
          delvrdSvcDtl.setInvoice(getPersistentObject(Invoice.class, idInvoInvoice));
          
          if(idResource > 0) {
            delvrdSvcDtl.setCapsResource(getPersistentObject(CapsResource.class, idResource));
          }
          if(idSvcAuthDtl > 0) {
            delvrdSvcDtl.setSvcAuthDetail(getPersistentObject(SvcAuthDetail.class, idSvcAuthDtl));
          }
          delvrdSvcDtl.setCdSvcDtlLiType(cdSvcDtlLiType);
          delvrdSvcDtl.setIndSvcDtlRejItem(indSvcDtlRejItem);
          
        } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
          if(idPerson < 1) {
            throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
          }
          
          delvrdSvcDtl = delvrdSvcDtlDAO.findDelvrdSvcDtlByPrimaryKey(idSvcDtl);
          if(delvrdSvcDtl == null) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
        // STGAP00006330: CR - 14 Changes Begin
        if (!CodesTables.CINVTYPE_EDS.equals(cfin07si.getSzCdInvoType())) {
          Collection<String> mileageServices = null;
          try {
            mileageServices = Lookup.getCategoryCodesCollection(CodesTables.CMILEAGE);
          } catch (LookupException le) {
            throw new IllegalStateException("Lookup data not initialized for DeliveredServiceValidation service", le);
          }
          if (mileageServices.contains(cdSvcDtlService)) {
            if (delvrdSvcDtl.getSvcAuthDetail() == null) {
              List<DelvrdSvcDtl> delvrdSvcDtlList = delvrdSvcDtlDAO.findIdSvcAuthDtlByIdInvoice(idInvoInvoice);
              int svcAuthDtlId = 0;
              if (delvrdSvcDtlList != null) {
                for (int i = 0; i < delvrdSvcDtlList.size(); i++) {
                  if (delvrdSvcDtlList.get(i) != null && delvrdSvcDtlList.get(i).getSvcAuthDetail() != null) {
                    svcAuthDtlId = delvrdSvcDtlList.get(i).getSvcAuthDetail().getIdSvcAuthDtl();
                    break;
                  }
                }
                if (svcAuthDtlId > 0) {
                  Integer svcAuthId = svcAuthDetailDAO.findIdSvcAuth(svcAuthDtlId);
                  if (svcAuthId != null) {
                    ServiceAuthorization svcAuth = getPersistentObject(ServiceAuthorization.class, svcAuthId);
                    Date fstDay = DateHelper.toJavaDateFromInputWithDefault(iMoSvcDtlSvcMonth + "/01/"
                                                                            + iYrSvcDtlServiceYear,
                                                                            DateHelper.MAX_JAVA_DATE);
                    Date lstDay = DateHelper.getLastDayOfTheMonth(fstDay);
                    Date dtDtSvcAuthDtlBegin = DateHelper.isAfter(svcAuth.getDtSvcAuthEff(), fstDay) ? svcAuth
                                                                                                              .getDtSvcAuthEff()
                                                                                                    : fstDay;
                    SvcAuthDetail svcAuthDetail = new SvcAuthDetail();
                    // If the current date is more than 15 days from the term date, set the show date to 15 days before
                    // the term date. Other wise set the show date to the current date.
                    double dayDifference = 0.0;
                    Date fifteenFromTerm = null;
                    if (lstDay != null) {
                      dayDifference = DateHelper.minutesDifference(date, lstDay);
                      fifteenFromTerm = DateHelper.addToDate(lstDay, 0, 0, -15);
                    }
                    if (dayDifference > 21600) {
                      svcAuthDetail.setDtSvcAuthDtlShow(fifteenFromTerm);
                    } else {
                      svcAuthDetail.setDtSvcAuthDtlShow(date);
                    }
                    int idNewSvcAuthDtl = commonDAO.getNextval("SEQ_SVC_AUTH_DETAIL");
                    svcAuthDetail.setIdSvcAuthDtl(idNewSvcAuthDtl);
                    svcAuthDetail.setServiceAuthorization(svcAuth);
                    svcAuthDetail.setPerson(getPersistentObject(Person.class, idPerson));
                    svcAuthDetail.setCdSvcAuthDtlAuthType(CodesTables.CSVATYPE_TRM);
                    svcAuthDetail.setCdSvcAuthDtlPeriod(CodesTables.CNPERIOD_MMO);
                    svcAuthDetail.setCdSvcAuthDtlSvc(cdSvcDtlService);
                    svcAuthDetail.setCdSvcAuthDtlUnitType(CodesTables.CCONUNIT_ONE);
                    svcAuthDetail.setDtSvcAuthDtl(date);
                    svcAuthDetail.setDtSvcAuthDtlBegin(dtDtSvcAuthDtlBegin);
                    svcAuthDetail.setDtSvcAuthDtlEnd(lstDay);
                    svcAuthDetail.setDtSvcAuthDtlTerm(lstDay);
                    svcAuthDetail.setAmtSvcAuthDtlAmtReq(dAmtSvcDtlUnitRate * dNbrSvcDtlUnitQty);
                    svcAuthDetail.setAmtSvcAuthDtlAmtUsed(0.0);
                    svcAuthDetail.setNbrSvcAuthDtlFreq(1);
                    svcAuthDetail.setNbrSvcAuthDtlLineItm(iNbrSvcDtlCsli);
                    svcAuthDetail.setNbrSvcAuthDtlSugUnit((int) (dNbrSvcDtlUnitQty));
                    svcAuthDetail.setNbrSvcAuthDtlUnitsReq(dNbrSvcDtlUnitQty);
                    svcAuthDetail.setNbrSvcAuthDtlUnitRate(dAmtSvcDtlUnitRate);
                    svcAuthDetail.setNbrSvcAuthDtlUnitUsed(0.0);
                    svcAuthDetail.setIndServAcpt(ArchitectureConstants.Y);
                    svcAuthDetailDAO.saveSvcAuthDetail(svcAuthDetail);
                    delvrdSvcDtl.setSvcAuthDetail(svcAuthDetail);
                  }
                }
              }
            } else {
              SvcAuthDetail svcAuthDtl = delvrdSvcDtl.getSvcAuthDetail();
              svcAuthDtl.setNbrSvcAuthDtlSugUnit((int) (dNbrSvcDtlUnitQty));
              svcAuthDtl.setNbrSvcAuthDtlUnitsReq(dNbrSvcDtlUnitQty);
              svcAuthDtl.setNbrSvcAuthDtlUnitRate(dAmtSvcDtlUnitRate);
              svcAuthDtl.setAmtSvcAuthDtlAmtReq(dAmtSvcDtlUnitRate * dNbrSvcDtlUnitQty);
              svcAuthDetailDAO.saveSvcAuthDetail(svcAuthDtl);
            }
          }
        }
        // CR - 14 Changes End
        delvrdSvcDtl.setPerson(getPersistentObject(Person.class, idPerson));
        delvrdSvcDtl.setMoSvcDtlSvcMonth(iMoSvcDtlSvcMonth);
        delvrdSvcDtl.setYrSvcDtlSvcYear(iYrSvcDtlServiceYear);
        delvrdSvcDtl.setCdSvcDtlService(cdSvcDtlService);
        delvrdSvcDtl.setCdSvcDtlCounty(cdSvcDtlCounty);
        delvrdSvcDtl.setNbrSvcDtlCsli(iNbrSvcDtlCsli);
        delvrdSvcDtl.setCdSvcDtlUnitType(cdSvcDtlUnitType);
        delvrdSvcDtl.setAmtSvcDtlUnitRate(dAmtSvcDtlUnitRate);
        delvrdSvcDtl.setNbrSvcDtlUnitQty(dNbrSvcDtlUnitQty);
        delvrdSvcDtl.setAmtSvcDtlFeePaid(dAmtSvcDtlFeePaid);
        delvrdSvcDtlDAO.saveDelvrdSvcDtl(delvrdSvcDtl);
      }
    }

    // Now verify that the number of Adjustment
    // entries are equal to or greater than the number of Reversal entries
    // **** These are retrieved but never used in this service
    // Call CMSC08D to retrieve # of adjustment line items
    //long usAdjCounter =
    //delvrdSvcDtlDAO.countDelvrdSvcDtlByIdInvoiceCdSvcDtlLiType(idInvoice, CodesTables.CLNITMTP_A);
    //long usRevCounter =
    //delvrdSvcDtlDAO.countDelvrdSvcDtlByIdInvoiceCdSvcDtlLiType(idInvoice, CodesTables.CLNITMTP_R);

    enumArray = cfin07si.getROWCFIN07SIG_ARRAY().enumerateROWCFIN07SIG();
    while (enumArray.hasMoreElements()) {
      ROWCFIN07SIG row = (ROWCFIN07SIG) enumArray.nextElement();

      if ((row.getSNbrSvcDtlUnitQty() == 0) &&
          !ServiceConstants.FND_YES.equals(row.getCIndSvcDtlRejItem())) {

        int idInv2 = row.getUlIdInvoInvoice();
        // retrieve the records from the Delivered Service Detail for a given Invoice ID.
        //  clscb2dQUERYdam
        DelvrdSvcDtl dsdtl = delvrdSvcDtlDAO.findDelvrdSvcDtl(idInv2);

        if (dsdtl != null) {
          // caude0dAUDdam
          // note that delvrdSvcDtl maps to the field ID_SVC_DTL_REVRSAL_ORIG
          complexDelvrdSvcDtlDAO.updateDelvrdSvcDtl(dsdtl.getDelvrdSvcDtl().getIdSvcDtl());
        }
      }
    }

    // Update the UnitRate  
    if (FIN_COST_REIM.equals(cfin07si.getSzCdCnsvcPaymentType()) && row0!=null) {
      double dAmtSvcDtlUnitRate = row0.getDAmtSvcDtlUnitRate() + .0005;
      int nbrSvcDtlCsli = row0.getUsNbrSvcDtlCsli();
      String cdSvcDtlLiType = row0.getSzCdSvcDtlLiType();
      Date tsLastUpdate = cfin07so.getTsLastUpdate();
      //cmsc21dAUDdam      
      int rowsUpdated = delvrdSvcDtlDAO.updateDelvrdSvcDtlamtSvcDtlUnitRate(dAmtSvcDtlUnitRate, idInvoice,
                                                                            nbrSvcDtlCsli, cdSvcDtlLiType,
                                                                            tsLastUpdate);
      if (rowsUpdated < 1) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    }

    return cfin07so;
  }
}