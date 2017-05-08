package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.FacilityLocDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FacilityLoc;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class FacilityLocDAOImpl extends BaseDAOImpl implements FacilityLocDAO {

  @SuppressWarnings({"unchecked"})
  public List<FacilityLoc> findFacilityLocByIdResource(int idResource) {
    Query query = getSession().createQuery(//"select * " +
                                           " from FacilityLoc f" +
                                           " where f.capsResource.idResource = :idResource" +
                                           " order by dtFlocEnd desc," +
                                           "          dtLastUpdate desc," +
                                           "          dtFlocEffect desc");
    query.setInteger("idResource", idResource);
    return (List<FacilityLoc>) query.list();
  }

  public int updateFacilityLoc(Date dtFlocEnd, int idResource) {
    Query query = getSession().createQuery("update FacilityLoc f" +
                                           "    set f.dtFlocEnd = :dtFlocEnd" +
                                           "  where dtFlocEnd = :maxDate" +
                                           "    and f.capsResource.idResource = :idResource");
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    query.setTimestamp("dtFlocEnd", dtFlocEnd);
    query.setInteger("idResource", idResource);

    return query.executeUpdate();

  }

  public int updateFacilityLocDtFlocEnd(Date dtFlocEffect, Date dtMaxDate, int idResource) {
    Query query = getSession().createQuery("update FacilityLoc fl " +
                                           "    set fl.dtFlocEnd = :dtFlocEffect " +
                                           "  where dtFlocEnd = :dtMaxDate " +
                                           "    and fl.capsResource.idResource = :idResource ");

    query.setTimestamp("dtFlocEffect", dtFlocEffect);
    query.setTimestamp("dtMaxDate", dtMaxDate);
    query.setInteger("idResource", idResource);
    return query.executeUpdate();
  }

  public int insertFacilityLoc(int idResource, Date dtFlocEffect, Date dtFlocEnd,
                               int nbrFlocLevelsOfCare, String cdFlocStatus1, String cdFlocStatus2,
                               String cdFlocStatus3, String cdFlocStatus4, String cdFlocStatus5,
                               String cdFlocStatus6, String cdFlocStatus7, String cdFlocStatus8,
                               String cdFlocStatus9, String cdFlocStatus10, String cdFlocStatus11,
                               String cdFlocStatus12, String cdFlocStatus13, String cdFlocStatus14,
                               String cdFlocStatus15

  ) {
    SQLQuery query = getSession().createSQLQuery(
            "insert into FACILITY_LOC (ID_FLOC,ID_RESOURCE,DT_FLOC_EFFECT,DT_FLOC_END,NBR_FLOC_LEVELS_OF_CARE,CD_FLOC_STATUS_1,CD_FLOC_STATUS_2,CD_FLOC_STATUS_3,CD_FLOC_STATUS_4,CD_FLOC_STATUS_5,CD_FLOC_STATUS_6,CD_FLOC_STATUS_7,CD_FLOC_STATUS_8,CD_FLOC_STATUS_9,CD_FLOC_STATUS_10,CD_FLOC_STATUS_11,CD_FLOC_STATUS_12,CD_FLOC_STATUS_13,CD_FLOC_STATUS_14,CD_FLOC_STATUS_15 )" +
            "      values(SEQ_FACILITY_LOC.NEXTVAL," +
            "             :idResource," +
            "             :dtFlocEffect," +
            "             :dtFlocEnd," +
            "             :nbrFlocLevelsOfCare," +
            "             :cdFlocStatus1," +
            "             :cdFlocStatus2," +
            "             :cdFlocStatus3," +
            "             :cdFlocStatus4," +
            "             :cdFlocStatus5," +
            "             :cdFlocStatus6," +
            "             :cdFlocStatus7," +
            "             :cdFlocStatus8," +
            "             :cdFlocStatus9," +
            "             :cdFlocStatus10," +
            "             :cdFlocStatus11," +
            "             :cdFlocStatus12," +
            "             :cdFlocStatus13," +
            "             :cdFlocStatus14," +
            "             :cdFlocStatus15)"
    );
    query.setInteger("idResource", idResource);
    query.setTimestamp("dtFlocEffect", dtFlocEffect);
    query.setTimestamp("dtFlocEnd", dtFlocEnd);
    query.setInteger("nbrFlocLevelsOfCare", nbrFlocLevelsOfCare);
    query.setString("cdFlocStatus1", cdFlocStatus1);
    query.setString("cdFlocStatus2", cdFlocStatus2);
    query.setString("cdFlocStatus3", cdFlocStatus3);
    query.setString("cdFlocStatus4", cdFlocStatus4);
    query.setString("cdFlocStatus5", cdFlocStatus5);
    query.setString("cdFlocStatus6", cdFlocStatus6);
    query.setString("cdFlocStatus7", cdFlocStatus7);
    query.setString("cdFlocStatus8", cdFlocStatus8);
    query.setString("cdFlocStatus9", cdFlocStatus9);
    query.setString("cdFlocStatus10", cdFlocStatus10);
    query.setString("cdFlocStatus11", cdFlocStatus11);
    query.setString("cdFlocStatus12", cdFlocStatus12);
    query.setString("cdFlocStatus13", cdFlocStatus13);
    query.setString("cdFlocStatus14", cdFlocStatus14);
    query.setString("cdFlocStatus15", cdFlocStatus15);

    return query.executeUpdate();
  }

  public int updateFacilityLoc(
          Date dtFlocEnd, String cdFlocStatus1, String cdFlocStatus2,
          String cdFlocStatus3, String cdFlocStatus4, String cdFlocStatus5,
          String cdFlocStatus6, String cdFlocStatus7, String cdFlocStatus8,
          String cdFlocStatus9, String cdFlocStatus10, String cdFlocStatus11,
          String cdFlocStatus12, String cdFlocStatus13, String cdFlocStatus14,
          String cdFlocStatus15, int idFloc, Date tsLastUpdate
  ) {
    Query query = getSession().createQuery("update FacilityLoc" +
                                           "    set dtFlocEnd = :dtFlocEnd," +
                                           "        cdFlocStatus1 = :cdFlocStatus1," +
                                           "        cdFlocStatus2 = :cdFlocStatus2," +
                                           "        cdFlocStatus3 = :cdFlocStatus3," +
                                           "        cdFlocStatus4 = :cdFlocStatus4," +
                                           "        cdFlocStatus5 = :cdFlocStatus5," +
                                           "        cdFlocStatus6 = :cdFlocStatus6," +
                                           "        cdFlocStatus7 = :cdFlocStatus7," +
                                           "        cdFlocStatus8 = :cdFlocStatus8," +
                                           "        cdFlocStatus9 = :cdFlocStatus9," +
                                           "        cdFlocStatus10 = :cdFlocStatus10," +
                                           "        cdFlocStatus11 = :cdFlocStatus11," +
                                           "        cdFlocStatus12 = :cdFlocStatus12," +
                                           "        cdFlocStatus13 = :cdFlocStatus13," +
                                           "        cdFlocStatus14 = :cdFlocStatus14," +
                                           "        cdFlocStatus15 = :cdFlocStatus15" +
                                           "  where idFloc = :idFloc" +
                                           "    and dtLastUpdate = :tsLastUpdate");
    query.setTimestamp("dtFlocEnd", dtFlocEnd);
    query.setString("cdFlocStatus1", cdFlocStatus1);
    query.setString("cdFlocStatus2", cdFlocStatus2);
    query.setString("cdFlocStatus3", cdFlocStatus3);
    query.setString("cdFlocStatus4", cdFlocStatus4);
    query.setString("cdFlocStatus5", cdFlocStatus5);
    query.setString("cdFlocStatus6", cdFlocStatus6);
    query.setString("cdFlocStatus7", cdFlocStatus7);
    query.setString("cdFlocStatus8", cdFlocStatus8);
    query.setString("cdFlocStatus9", cdFlocStatus9);
    query.setString("cdFlocStatus10", cdFlocStatus10);
    query.setString("cdFlocStatus11", cdFlocStatus11);
    query.setString("cdFlocStatus12", cdFlocStatus12);
    query.setString("cdFlocStatus13", cdFlocStatus13);
    query.setString("cdFlocStatus14", cdFlocStatus14);
    query.setString("cdFlocStatus15", cdFlocStatus15);
    query.setInteger("idFloc", idFloc);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    return query.executeUpdate();

  }

  public int deleteFacilityLoc(int idResource) {
    Query query = getSession().createQuery("delete FacilityLoc f" +
                                           "  where f.capsResource.idResource = :idResource");
    query.setInteger("idResource", idResource);

    return query.executeUpdate();
  }
}
