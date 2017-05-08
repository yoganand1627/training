package gov.georgia.dhr.dfcs.sacwis.service.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.WebServicesTestTableDAO;
import gov.georgia.dhr.dfcs.sacwis.db.WebServicesTestTable;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.RetrieveTestRow;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveTestRowSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveTestRowSO;

public class RetrieveTestRowImpl extends BaseServiceImpl implements RetrieveTestRow {
  private WebServicesTestTableDAO webServicesTestTableDAO = null;

  public void setWebServicesTestTableDAO(WebServicesTestTableDAO webServicesTestTableDAO) {
    this.webServicesTestTableDAO = webServicesTestTableDAO;
  }

  public RetrieveTestRowSO getTestRow(RetrieveTestRowSI retrieveTestRowSI) {
    WebServicesTestTable servicesTestTable = webServicesTestTableDAO.findWebServiceTestTableRow(retrieveTestRowSI.getId());
    RetrieveTestRowSO retrieveTestRowSO = new RetrieveTestRowSO();
    retrieveTestRowSO.setId(servicesTestTable.getIdws());
    retrieveTestRowSO.setNumVal(servicesTestTable.getTestColumnNum());
    retrieveTestRowSO.setCharVal(servicesTestTable.getTestColumnChar());
    retrieveTestRowSO.setVar2Val(servicesTestTable.getTestColumnVar2());
    retrieveTestRowSO.setDateVal(servicesTestTable.getTestColumnDate());
    return retrieveTestRowSO;
  }
}