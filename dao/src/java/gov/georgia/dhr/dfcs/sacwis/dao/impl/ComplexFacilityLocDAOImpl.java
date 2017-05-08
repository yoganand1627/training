package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexFacilityLocDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FacilityLocDAO;

public class ComplexFacilityLocDAOImpl extends BaseDAOImpl implements ComplexFacilityLocDAO {
  private FacilityLocDAO facilityLocDAO = null;

  public void setFacilityLocDAO(FacilityLocDAO facilityLocDAO) {
    this.facilityLocDAO = facilityLocDAO;
  }

  public int insertFacilityLoc(Date dtFlocEffect, Date dtMaxDate, int idResource,
                               Date dtFlocEnd, int nbrFlocLevelsOfCare, String cdFlocStatus1,
                               String cdFlocStatus2, String cdFlocStatus3, String cdFlocStatus4, String cdFlocStatus5,
                               String cdFlocStatus6, String cdFlocStatus7, String cdFlocStatus8,
                               String cdFlocStatus9, String cdFlocStatus10, String cdFlocStatus11,
                               String cdFlocStatus12, String cdFlocStatus13, String cdFlocStatus14,
                               String cdFlocStatus15) {

    facilityLocDAO.updateFacilityLocDtFlocEnd(dtFlocEffect, dtMaxDate, idResource);
    return facilityLocDAO.insertFacilityLoc(idResource, dtFlocEffect, dtFlocEnd,
                                            nbrFlocLevelsOfCare, cdFlocStatus1, cdFlocStatus2,
                                            cdFlocStatus3, cdFlocStatus4, cdFlocStatus5,
                                            cdFlocStatus6, cdFlocStatus7, cdFlocStatus8,
                                            cdFlocStatus9, cdFlocStatus10, cdFlocStatus11,
                                            cdFlocStatus12, cdFlocStatus13, cdFlocStatus14,
                                            cdFlocStatus15);
  }
}
