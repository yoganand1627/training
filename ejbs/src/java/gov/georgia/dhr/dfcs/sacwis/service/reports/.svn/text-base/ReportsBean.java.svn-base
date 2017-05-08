/**
 * Created on Jun 28, 2006 at 12:56:56 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.reports;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDNFRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDNFSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB59SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB60SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveReportSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDNFRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDNFSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB59SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB60SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportPageSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportParametersSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportSO;

import java.util.List;

import javax.ejb.CreateException;

public class ReportsBean extends BaseSpringStatelessSessionBean implements Reports {
  private DeleteReportList deleteReportList;
  private LaunchReportAsync launchReportAsync;
  private RetrieveOutputLaunch retrieveOutputLaunch;
  private RetrieveReportList retrieveReportList;
  private RetrieveReportParmlist retrieveReportParmlist;
  private RetrieveReport retrieveReport;
  private SaveOutputLaunch saveOutputLaunch;

  public CARC19SO deleteReportList(CARC19SI carc19si) throws ServiceException {
    return deleteReportList.deleteReportList(carc19si);
  }

  public void launchReportAsync(int idReportList, CARC07SI carc07si) throws ServiceException {
    launchReportAsync.launchReportAsync(idReportList, carc07si);
  }
  
  public void launchBatchReportAsync(CARC07SI carc07si) throws ServiceException {
	    launchReportAsync.launchBatchReportAsync(carc07si);
	  }
  
  public int saveReportList(CARC07SI carc07si) throws ServiceException {
    return launchReportAsync.saveReportList(carc07si);
  }
  
  public CSUB59SO retrieveOutputLaunch(CSUB59SI csub59si) throws ServiceException {
    return retrieveOutputLaunch.retrieveOutputLaunch(csub59si);
  }

  public CARC06SO retrieveReportList(CARC06SI carc06si) throws ServiceException {
    return retrieveReportList.retrieveReportList(carc06si);
  }
  
  public CARC21SO retrieveReportParamList(CARC21SI carc21si) throws ServiceException {
    return retrieveReportParmlist.retrieveReportParamList(carc21si);
  }
  public List<RetrieveReportParametersSO> retrieveLaunchReportParameters(String nmRptSqrName, String nmRptSqrVer)
  throws ServiceException {
	    return retrieveReportParmlist.retrieveLaunchReportParameters(nmRptSqrName, nmRptSqrVer);
  }

  public RetrieveReportSO retrieveReport(RetrieveReportSI retrieveReportSI) {
    return retrieveReport.retrieveReport(retrieveReportSI);
  }
  public List<RetrieveReportPageSO> retrieveAllReportPageReports(int idUser){
	  return retrieveReport.retrieveAllReportPageReports(idUser);
  }

  public CSUB60SO saveOutputLaunch(CSUB60SI csub60si) throws ServiceException {
    return saveOutputLaunch.saveOutputLaunch(csub60si);
  }

  public CDNFSaveSO saveOutputLaunch(CDNFSaveSI cdnfSaveSI) throws ServiceException {
    return saveOutputLaunch.saveOutputLaunch(cdnfSaveSI);
  }
  
  public CDNFRetrieveSO retrieveOutputLaunch(CDNFRetrieveSI cdnfRetrieveSI) throws ServiceException {
    return retrieveOutputLaunch.retrieveOutputLaunch(cdnfRetrieveSI);
  }
  
  protected void onEjbCreate() throws CreateException {
    deleteReportList = getService(DeleteReportList.class);
    launchReportAsync = getService(LaunchReportAsync.class);
    retrieveOutputLaunch = getService(RetrieveOutputLaunch.class);
    retrieveReportList = getService(RetrieveReportList.class);
    retrieveReportParmlist = getService(RetrieveReportParmlist.class);
    retrieveReport = getService(RetrieveReport.class);
    saveOutputLaunch = getService(SaveOutputLaunch.class);
  }
}
