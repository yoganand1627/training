package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;

public interface DynamicIncomingDetailDAO {

  /**
   * This method creates the single query needed for data displayed on the Intake Report Log page.
   *
   * @param pageNbr
   * @param pageSize
   * @param nmIncomingCallerFirst
   * @param nmIncomingCallerMiddle
   * @param nmIncomingCallerLast
   * @param cdStageClassification
   * @param cdCityList
   * @param cdIncomingCallerCounty
   * @param cdIncmgRegion
   * @param cdIncomingDisposition
   * @param cdStageCurrPriority
   * @param nbrIncmgUnit
   * @param dtIncomingCallFrom
   * @param dtIncomingCallTo
   * @param cdIncmgAllegType
   * @param idStages
   * @return PaginatedHibernateList<Map>
   */
  PaginatedHibernateList<Map> findIncomingDetailByIdName(int pageNbr, int pageSize,
                                                         String cdStageClassification, Collection<String> cdCityList,
                                                         String cdIncomingCallerCounty, String cdIncmgRegion,
                                                         String cdIncomingDisposition, String cdStageCurrPriority,
                                                         String nbrIncmgUnit, Date dtIncomingCallFrom,
                                                         Date dtIncomingCallTo,
                                                         String cdIncmgAllegType, Collection<Integer> idStags);

}
