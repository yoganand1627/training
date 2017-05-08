/**
 * Created by Kapil Aggarwal - SACWIS Atlanta
 */
package gov.georgia.dhr.dfcs.sacwis.service.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.WebServicesTestTableDAO;
import gov.georgia.dhr.dfcs.sacwis.db.WebServicesTestTable;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.SaveTestRow;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveTestRowSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveTestRowSO;

public class SaveTestRowImpl extends BaseServiceImpl implements SaveTestRow {
  private WebServicesTestTableDAO webServicesTestTableDAO = null;

  public void setWebServicesTestTableDAO(WebServicesTestTableDAO webServicesTestTableDAO) {
    this.webServicesTestTableDAO = webServicesTestTableDAO;
  }

  public SaveTestRowSO saveTestRow(SaveTestRowSI saveTestRowSI) {
    WebServicesTestTable webServicesTest = new WebServicesTestTable();
    webServicesTest.setTestColumnNum(saveTestRowSI.getNumVal());
    webServicesTest.setTestColumnChar(saveTestRowSI.getCharVal());
    webServicesTest.setTestColumnVar2(saveTestRowSI.getVar2Val());
    webServicesTest.setTestColumnDate(saveTestRowSI.getDateVal());
    int id = webServicesTestTableDAO.saveWebServiceTestTable(webServicesTest);
    SaveTestRowSO saveTestRowSO = new SaveTestRowSO();
    saveTestRowSO.setId(id);
    return saveTestRowSO;
  }
}
