package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;

public interface ComplexCaseMergeDAO {
  /**
   * Select of all merged cases for one case (MERGED_TO cases).
   *
   * @param idCaseMerge
   * @return List<Object[]>
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findCaseMerge(int idCaseMerge);

  /**
   * Select of all merged cases for one case (MERGED_FROM cases).
   *
   * @param idCaseMerge
   * @return List<Object[]>
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findCaseMergeFrom(int idCaseMerge);
}
