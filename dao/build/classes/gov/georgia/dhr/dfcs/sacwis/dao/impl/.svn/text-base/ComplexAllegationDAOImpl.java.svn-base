package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexAllegationDAO;

public class ComplexAllegationDAOImpl extends BaseDAOImpl implements
                                                          ComplexAllegationDAO {
  private AllegationDAO allegationDAO = null;

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public long countAllegationForUpdateFunction(int idAllegedPerpetrator, String cdAllegType, int idVictim,
                                               int idStage) {
    if (idAllegedPerpetrator == 0) {
      return allegationDAO.countAllegationByCdAllegType(cdAllegType, idVictim, idStage);
    } else {
      return allegationDAO.countAllegationByPersonByIdAllegedPerpetrator(idAllegedPerpetrator, cdAllegType, idVictim,
                                                                         idStage);
    }
  }

  public int findAllegationForUpdateFunction(int idAllegedPerpetrator, String cdAllegType, int idVictim, int idStage) {
    if (idAllegedPerpetrator == 0) {

      Integer ret = allegationDAO.findAllegation(cdAllegType, idVictim, idStage);

      return (ret != null ? ret : 0);
    } else {
      Integer ret = allegationDAO.findAllegationByPersonByIdAllegedPerpetrator(idAllegedPerpetrator, cdAllegType,
                                                                               idVictim, idStage);
      return (ret != null ? ret : 0);
    }
  }
}
