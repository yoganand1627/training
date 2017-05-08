package gov.georgia.dhr.dfcs.sacwis.service.reports.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ReportListDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ReportList;
import gov.georgia.dhr.dfcs.sacwis.db.Reports;
import gov.georgia.dhr.dfcs.sacwis.db.ReportsId;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.UDRObjectFactory;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.reports.RetrieveReportList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC06SOG_ARRAY;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;


/**
 * This class provides the implementation of the service methods that retrieve the Report List 
 * 
 * <pre>
 *    Change History:
 *    Date      User        Description
 *    --------  ----------  --------------------------------------------------
 *    12/01/08  alwilliams  STGAP00009474 - Updated pagination support for methods
 *                              a. retrieveReportList (public)
 *                              b. retrieveReportList (private)
 *    04/08/2010 vvo        SMS49899: retrieve batch report(common to a group/everybody) too 
 *                                    retrieve batch indicator for report                         
 *                        
 * </pre>
 */
public class RetrieveReportListImpl extends BaseServiceImpl implements RetrieveReportList {

  private ReportListDAO reportListDAO = null;

  /**
   * This method initializes the report list DAO member
   * 
   * @param reportListDAO
   */
  public void setReportListDAO(ReportListDAO reportListDAO) {
    this.reportListDAO = reportListDAO;
  }

  
  /**
   * This method provides the retrieve report list service
   * 
   * @param CARCO6SI
   * @return CARCO6SO
   * 
   */
  public CARC06SO retrieveReportList(CARC06SI carc06si) throws ServiceException {
    
    // STGAP00009474: Added pagination support
    PaginatedHibernateList<ReportList> reportList;
    
    ArchInputStruct archInputStruct = carc06si.getArchInputStruct();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();
    
    
    int idPerson = carc06si.getUlIdPerson();
    String cSysIndRptRtrvType = carc06si.getCSysIndRptRtrvType();
    
    // cdyn24d
    if (ArchitectureConstants.N.equals(cSysIndRptRtrvType)) {
      // cdyn24d
      reportList = reportListDAO.findReportListNonMisByIdPerson(idPerson, pageNbr, pageSize);
      if (reportList == null || reportList.isEmpty()) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }
    } else if (ArchitectureConstants.Y.equals(cSysIndRptRtrvType)) {
      // cdyn24d
      //reportList = reportListDAO.findReportListAllByIdPerson(idPerson, pageNbr, pageSize);
      Collection<String> batchReports = UDRObjectFactory.BATCH_REPORTS.keySet();
      reportList = reportListDAO.findReportListByIdPersonReportName(idPerson, batchReports, pageNbr, pageSize);
      if (reportList == null || reportList.isEmpty()) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    
    CARC06SO carc06so = retrieveReportList(reportList);
    
    return carc06so;
  }

  
  /**
   * This method retrieves the report list from the list of report list
   * 
   * @param reportListList
   * @return CARCO6SO
   */
  private CARC06SO retrieveReportList(PaginatedHibernateList<ReportList> reportListList) {
    
    
    ROWCARC06SOG_ARRAY rowcarc06sog_array = new ROWCARC06SOG_ARRAY();
    
    //STGAP00009474: Added pagination support
    String bMoreDataInd = ArchitectureConstants.N;
    int ulRowQty = 0;
    if (reportListList != null && !reportListList.isEmpty()) {
      bMoreDataInd = reportListList.getBMoreDataInd();
      for (Iterator<ReportList> it = reportListList.iterator(); it.hasNext();) {
        ReportList reportList = it.next();
        ROWCARC06SOG rowcarc06sog = new ROWCARC06SOG();
        Reports reports = reportList.getReports();
        rowcarc06sog.setSzTxtRptFullName(reports.getTxtRptFullName());
        rowcarc06sog.setSzTxtRptLstStatus(reportList.getTxtRptLstStatus());
        Date dtRptLstGeneration = reportList.getDtRptLstGeneration();
        rowcarc06sog.setDtDtRptLstGeneration(DateHelper.toCastorDate(dtRptLstGeneration));
        Date dtRptLstRetainage = reportList.getDtRptLstRetainage();
        rowcarc06sog.setDtDtRptLstRetainage(DateHelper.toCastorDate(dtRptLstRetainage));
        rowcarc06sog.setSzTxtRptLstRuntimeName(reportList.getTxtRptLstRuntimeName());
        rowcarc06sog.setUlIdRptList(reportList.getIdRptList() != null ? reportList.getIdRptList() : 0);
        ReportsId reportsId = reports.getId();
        rowcarc06sog.setSzNmRptSqrName(reportsId.getNmRptSqrName());
        rowcarc06sog.setSzNmRptSqrVer(reportsId.getNmRptSqrVer());
        rowcarc06sog.setSzTxtRptGenName(reportList.getTxtRptGenName());
        rowcarc06sog.setSzNmRptOrientation(reports.getNmRptOrientation());
        rowcarc06sog.setSzNmRptTemplateName(reports.getNmRptTemplateName());
        rowcarc06sog.setSzNmRptType(reports.getNmRptType());
        rowcarc06sog.setSzTxtRptEmailOption(reports.getTxtRptEmailOptions());
        rowcarc06sog.setBIndShinesBatch(reports.getIndShinesBatch());
        rowcarc06sog_array.addROWCARC06SOG(rowcarc06sog);
        ulRowQty++;
      }
    } 
    
    CARC06SO carc06so = new CARC06SO();
    ArchOutputStruct outputStruct = new ArchOutputStruct();
    outputStruct.setBMoreDataInd(bMoreDataInd);
    carc06so.setArchOutputStruct(outputStruct);
    carc06so.setROWCARC06SOG_ARRAY(rowcarc06sog_array);
    
    return carc06so;
  }
}
