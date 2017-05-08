package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonMergeDAO;

import java.util.Date;

public class ComplexPersonMergeDAOImpl extends BaseDAOImpl implements ComplexPersonMergeDAO {
  private PersonMergeDAO personMergeDAO = null;

  public void setPersonMergeDAO(PersonMergeDAO personMergeDAO) {
    this.personMergeDAO = personMergeDAO;
  }

  public int updatePersonMerge(int idPersonMerge, int idPersMergeForward, int idPersMergeClosed, int idPersMergeWrkr,
                               int idPersMergeSplitWrkr, String indPersMergeInvalid, Date dtPersMergeSplit,
                               Date lastUpdate) {

    
    int rows = 0;
    if (idPersMergeSplitWrkr != 0) {
      rows = personMergeDAO.updatePersonMerge(idPersonMerge, idPersMergeForward, idPersMergeClosed,
                                                  idPersMergeWrkr, idPersMergeSplitWrkr, indPersMergeInvalid,
                                                  dtPersMergeSplit, lastUpdate);
    } else {
      rows = personMergeDAO.updatePersonMerge(idPersonMerge, idPersMergeForward, idPersMergeClosed,
                                                  idPersMergeWrkr, indPersMergeInvalid, dtPersMergeSplit, lastUpdate);
    }

    return rows;
  }
}