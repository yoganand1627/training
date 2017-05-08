package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveServiceList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00_ARRAY;

public class RetrieveServiceListImpl extends BaseServiceImpl implements RetrieveServiceList {

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public CCON21SO retrieveServiceList(CCON21SI ccon21si) {
    CCON21SO ccon21so = new CCON21SO();
    // Calling clsc20d
    List<SvcAuthDetail> listSvcAuthDetail =
            svcAuthDetailDAO.findServiceAuthDetailPersonByIdSvcAuth(ccon21si.getUlIdSvcAuth());
    if (listSvcAuthDetail != null && listSvcAuthDetail.size() > 0) {
      ROWCCON21SOG00_ARRAY rowccon21sogoo_array = new ROWCCON21SOG00_ARRAY();
      for (Iterator<SvcAuthDetail> it = listSvcAuthDetail.iterator(); it.hasNext();) {
        SvcAuthDetail svcAuthDetail = it.next();
        ROWCCON21SOG00 rowccon21sogoo = new ROWCCON21SOG00();
        rowccon21sogoo.setSzCdSvcAuthDtlAuthType(svcAuthDetail.getCdSvcAuthDtlAuthType());
        rowccon21sogoo.setSzCdSvcAuthDtlSvc(svcAuthDetail.getCdSvcAuthDtlSvc());
        rowccon21sogoo.setSzNmPersonFull(svcAuthDetail.getPerson().getNmPersonFull());
        rowccon21sogoo.setDtDtSvcAuthDtlBegin(DateHelper.toCastorDate(svcAuthDetail.getDtSvcAuthDtlBegin()));
        rowccon21sogoo.setDtDtSvcAuthDtlEnd(DateHelper.toCastorDate(svcAuthDetail.getDtSvcAuthDtlEnd()));
        rowccon21sogoo.setDtDtSvcAuthDtlTerm(DateHelper.toCastorDate(svcAuthDetail.getDtSvcAuthDtlTerm()));
        rowccon21sogoo.setLAmtSvcAuthDtlAmtReq(svcAuthDetail.getAmtSvcAuthDtlAmtReq());
        rowccon21sogoo.setLNbrSvcAuthDtlUnitReq(svcAuthDetail.getNbrSvcAuthDtlUnitsReq());
        rowccon21sogoo.setLNbrSvcAuthDtlSugUnit(svcAuthDetail.getNbrSvcAuthDtlSugUnit() != null ? svcAuthDetail.getNbrSvcAuthDtlSugUnit() : 0);
        rowccon21sogoo.setSzCdSvcAuthDtlPeriod(svcAuthDetail.getCdSvcAuthDtlPeriod());
        rowccon21sogoo.setSzCdSvcAuthDtlUnitType(svcAuthDetail.getCdSvcAuthDtlUnitType());
        rowccon21sogoo.setUNbrSvcAuthDtlFreq(svcAuthDetail.getNbrSvcAuthDtlFreq());
        rowccon21sogoo.setLNbrSvcAuthDtlUnitUsed(svcAuthDetail.getNbrSvcAuthDtlUnitUsed() != null ? svcAuthDetail.getNbrSvcAuthDtlUnitUsed() : 0);
        rowccon21sogoo.setUlIdSvcAuthDtl(svcAuthDetail.getIdSvcAuthDtl() != null ? svcAuthDetail.getIdSvcAuthDtl() : 0);
        rowccon21sogoo_array.addROWCCON21SOG00(rowccon21sogoo);
      }
      ccon21so.setROWCCON21SOG00_ARRAY(rowccon21sogoo_array);
    }
    return ccon21so;
  }
}
