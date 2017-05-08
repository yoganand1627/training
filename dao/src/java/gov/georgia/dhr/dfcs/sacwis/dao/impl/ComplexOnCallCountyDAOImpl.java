package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexOnCallCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OnCallCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.OnCallCounty;

public class ComplexOnCallCountyDAOImpl extends BaseDAOImpl implements ComplexOnCallCountyDAO {
  private OnCallCountyDAO onCallCountyDAO = null;

  public void setOnCallCountyDAO(OnCallCountyDAO onCallCountyDAO) {
    this.onCallCountyDAO = onCallCountyDAO;
  }

  public void saveOnCallCounty(OnCallCounty onCallCounty, String[] cdOnCallCounty) {
    // for (int index = 0; index < cdOnCallCounty.length; index++) {
    onCallCounty.setCdOnCallCounty(cdOnCallCounty[0]);
    onCallCountyDAO.saveOnCallCounty(onCallCounty);
    //}
  }
}
