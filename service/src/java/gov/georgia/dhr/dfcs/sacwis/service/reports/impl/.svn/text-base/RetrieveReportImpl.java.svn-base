/**
 * Created on Jan 8, 2007 at 4:13:23 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.reports.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ReportsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Reports;
import gov.georgia.dhr.dfcs.sacwis.launcher.ReportLauncher;
import gov.georgia.dhr.dfcs.sacwis.service.common.CheckIfUserHasRight;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.reports.RetrieveReport;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveReportSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportPageSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportSO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/*Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
04/14/10    vvo               49899: added indicate batch report since the type is now used to set SQR or UDR  
*/

public class RetrieveReportImpl extends BaseServiceImpl implements RetrieveReport {

  /** Special field used to retrieve the report over RMI. */
  private ReportLauncher reportLauncher = null;

  private ReportsDAO reportsDAO = null;
  
  private CheckIfUserHasRight checkIfUserHasRight = null; 

  public void setReportLauncher(ReportLauncher reportLauncher) {
    this.reportLauncher = reportLauncher;
  }

  public void setReportsDAO(ReportsDAO reportsDAO) {
    this.reportsDAO = reportsDAO;
  }

  public void setCheckIfUserHasRight(CheckIfUserHasRight checkIfUserHasRight) {
    this.checkIfUserHasRight = checkIfUserHasRight;
  }

  public RetrieveReportSO retrieveReport(RetrieveReportSI retrieveReportSI) {
    RetrieveReportSO retrieveReportSO = new RetrieveReportSO();
    retrieveReportSO.setReportBytes(reportLauncher.retreieveReport(retrieveReportSI.getReportFilename(), retrieveReportSI.getReportType()));
    retrieveReportSO.setReportType(retrieveReportSI.getReportType());
    return retrieveReportSO;
  }

  /**
   * STGAP00010625 
   * This method retrieves all reports from Reports table and set access indicator to Y if a report
   * does not require any clearance or it does and user possess the clearance; it sets access indicator 
   * to N if report requires certain security attribute and user does not have it.
   */
  public List<RetrieveReportPageSO> retrieveAllReportPageReports(int idUser) {
    List<RetrieveReportPageSO> result = new ArrayList<RetrieveReportPageSO>();
    int[] userRights = checkIfUserHasRight.retrieveUserRights(idUser);

    List<Reports> reportList = reportsDAO.findReportsPageReports();
    Iterator iterator = reportList.iterator();

    while (iterator.hasNext()) {
      Reports reports = (Reports) iterator.next();
      RetrieveReportPageSO retrieveReportPageSO = new RetrieveReportPageSO();

      retrieveReportPageSO.setNmRptSqrName(reports.getId().getNmRptSqrName());
      retrieveReportPageSO.setNmRptSqrVer(reports.getId().getNmRptSqrVer());
      retrieveReportPageSO.setTxtRptFullName(reports.getTxtRptFullName());
      retrieveReportPageSO.setTxtRptDesc(reports.getTxtRptDesc());
      retrieveReportPageSO.setTxtRptAreaType(reports.getTxtRptAreaType());
      retrieveReportPageSO.setNmRptType(reports.getNmRptType());
      retrieveReportPageSO.setIndShinesBatch(reports.getIndShinesBatch()); 
      String cdSecAttr = reports.getCdSecAttr();
      if (cdSecAttr == null) {
        retrieveReportPageSO.setIndAccessAllowed("Y");
      } else if (hasRight(cdSecAttr, userRights)) {
        retrieveReportPageSO.setIndAccessAllowed("Y");
      } else {
        retrieveReportPageSO.setIndAccessAllowed("N");
      }

      result.add(retrieveReportPageSO);

    }
    return result;
  }
  /**
   * This method returns a boolean value indicating whether or not the user has the right that was passed in.
   *  
   * @param securityAttribute
   *          The right to check for on the user
   * @param userRights
   *          The array of attributes that makes a person's profile
   * @return boolean Whether or not the user has the right
   */
  private boolean hasRight(String securityAttribute, int[] rights) {
    try {
      int secAtt = Integer.parseInt(securityAttribute);
      return hasRight(secAtt, rights);
    } catch (NullPointerException npe) {
      return false; 
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

  /**
   * This method returns a boolean value indicating whether or not the user has the right that was passed in.
   * 
   * @param securityAttribute
   *          The right to check for on the user
   * @param userRights 
   *          The array of attributes that makes a person's profile        
   * @return boolean Whether or not the user has the right
   */
  private boolean hasRight(int securityAttribute, int[] userRights) {
    if (userRights[securityAttribute] == 1) {
      return true;
    } else {
      return false;
    }
  }
}
