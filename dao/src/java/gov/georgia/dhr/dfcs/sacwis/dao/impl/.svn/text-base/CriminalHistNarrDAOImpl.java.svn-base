package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CriminalHistNarrDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CriminalHistNarr;

public class CriminalHistNarrDAOImpl extends BaseDAOImpl implements CriminalHistNarrDAO {
  public int deleteCriminalHistNarr(int idCriminalHistNarr) {
    CriminalHistNarr criminalHistNarr =
            (CriminalHistNarr) getSession().load(CriminalHistNarr.class, idCriminalHistNarr);
    if (criminalHistNarr == null) {
      return 0;
    }
    getSession().delete(criminalHistNarr);
    return 1;
  }
}

