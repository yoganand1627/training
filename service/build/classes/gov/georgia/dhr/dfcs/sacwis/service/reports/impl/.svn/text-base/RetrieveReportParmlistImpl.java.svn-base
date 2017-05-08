package gov.georgia.dhr.dfcs.sacwis.service.reports.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ReportListDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ReportParameterDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ReportParameter;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.reports.LaunchReportAsync;
import gov.georgia.dhr.dfcs.sacwis.service.reports.RetrieveReportParmlist;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportParametersSO;

public class RetrieveReportParmlistImpl extends BaseServiceImpl implements RetrieveReportParmlist {

  private ReportListDAO reportListDAO = null;
  private ReportParameterDAO reportParameterDAO= null;
  private LaunchReportAsync launchReportAsync = null;

  public void setReportListDAO(ReportListDAO reportListDAO) {
    this.reportListDAO = reportListDAO;
  }
  
  public void setReportParameterDAO(ReportParameterDAO reportParameterDAO){
	  this.reportParameterDAO = reportParameterDAO;	  
  }

  public void setLaunchReportAsync(LaunchReportAsync launchReportAsync) {
    this.launchReportAsync = launchReportAsync;
  }

  public CARC21SO retrieveReportParamList(CARC21SI carc21si) throws ServiceException {
    CARC21SO carc21so = new CARC21SO();
    // retrieve the parameter string from the REPORT LIST table.
    // cses72d
    String szParmList = reportListDAO.findReportList(carc21si.getUlIdRptList());
    if (!StringHelper.isValid(szParmList)) {
      // failed to find the list
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    // Call the ON-DEMAND RPT LAUNCH
    CARC07SI carc07si = new CARC07SI();
    carc07si.setArchInputStruct(new ArchInputStruct());
    carc07si.setSzNmRptSqrName(carc21si.getSzNmRptSqrName());
    carc07si.setSzNmRptSqrVer(carc21si.getSzNmRptSqrVer());
    carc07si.setUlIdPerson(carc21si.getUlIdPerson());
    carc07si.setSzTxtEmailMessage(carc21si.getSzTxtEmailMessage());
    carc07si.setTxtRptParmList(szParmList);
    carc07si.setSzTxtNmRptType(carc21si.getSzTxtNmRptType());
    
    // The call to this service will handle all Exceptions while processing
    /* @todo See if the following two method calls should be separated. */
    
    int idReportList = launchReportAsync.saveReportList(carc07si);
    launchReportAsync.launchReportAsync(idReportList, carc07si);
    return carc21so;
  }
  
  /**
   * This service will fetch a report's parameter list for the Launch screen
   *
   * @param string nmRptSqrName
   * @param string nmRptSqrVer
   * @return List<RetrieveReportParametersSO> 
   */
  public  List<RetrieveReportParametersSO>  retrieveLaunchReportParameters(String nmRptSqrName, String nmRptSqrVer){
	  List<RetrieveReportParametersSO> result = new ArrayList<RetrieveReportParametersSO>();	 
	  
	  List<ReportParameter> reportParametersList = 
		 reportParameterDAO.findReportParameter(nmRptSqrName, nmRptSqrVer);
    	  
	  Iterator iterator = reportParametersList.iterator();

          while (iterator.hasNext()) {
	      ReportParameter reportParameter = (ReportParameter) iterator.next();

	      RetrieveReportParametersSO  retrieveReportParametersSO =
		     new RetrieveReportParametersSO();
	      //TODO RMP add all Report fields
	      retrieveReportParametersSO.setIdRptParameter(reportParameter.getIdRptParameter());
	      retrieveReportParametersSO.setDtLastUpdate(reportParameter.getDtLastUpdate());
	      retrieveReportParametersSO.setNbrRptParmLength(reportParameter.getNbrRptParmLength());
	      retrieveReportParametersSO.setNbrRptParmSeq(reportParameter.getNbrRptParmSeq());
	      retrieveReportParametersSO.setNmRptParmName(reportParameter.getNmRptParmName());
	      retrieveReportParametersSO.setTxtRptParmType(reportParameter.getTxtRptParmType());
	      retrieveReportParametersSO.setNmRptParmLabel(reportParameter.getNmRptParmLabel());
	      retrieveReportParametersSO.setIndRequired(reportParameter.getIndRequired());

	      
          result.add(retrieveReportParametersSO);	      
	  }


	//for (Iterator<ReportParameter> it = reportParameterList.iterator(); it.hasNext();) {	  
  	
	 return result;
  }
  
}
