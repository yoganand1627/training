package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

public interface ComplexPersonMergeDAO {

  
  
  /**
   * Partial update of PersonMerge table using the supplied parameters(column values).
   *
   * @param idPersonMerge
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idPersMergeWrkr
   * @param idPersMergeSplitWrkr
   * @param indPersMergeInvalid
   * @param dtPersMergeSplit
   * @param lastUpdate
   */
  @SuppressWarnings({"unchecked"})
  int updatePersonMerge(int idPersonMerge, int idPersMergeForward, int idPersMergeClosed,
                        int idPersMergeWrkr, int idPersMergeSplitWrkr, String indPersMergeInvalid,
                        Date dtPersMergeSplit, Date lastUpdate);  
}
