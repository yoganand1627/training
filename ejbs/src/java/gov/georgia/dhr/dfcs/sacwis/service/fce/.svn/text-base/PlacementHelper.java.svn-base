package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.PlacementDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.grnds.facility.log.GrndsTrace;

public class PlacementHelper implements Serializable {
  protected static final String TRACE_TAG = "PlacementHelper";

  protected static final String EMERGENCY_PLACEMENT = CodesTables.CPLCMT_67;
  //limit my search for placements within open stages
  protected static final String SELECT_PLACEMENT_BASE_SQL =
          "  select id_plcmt_event, \n" +
          "         caps_resource.cd_rsrc_facil_type, \n" +
          "         ind_plcmt_emerg, \n" +
          "         cd_plcmt_type, \n" +
          "         cd_plcmt_liv_arr \n" +
          "  from placement, \n" +
          "       caps_resource, \n" +
          "       event, \n" +
          "       stage \n" +
          "  where placement.id_rsrc_facil = caps_resource.id_resource (+) \n" +
          "    and placement.id_plcmt_event = event.id_event \n" +
          "    and event.id_event_stage = stage.id_stage \n" +
          "    and stage.ind_stage_close = 'N' \n" +
          "    and placement.id_plcmt_child = ?  \n" +
          "    and placement.dt_plcmt_end <> placement.dt_plcmt_start \n" +
          "    and placement.cd_plcmt_act_planned = 'A' \n";

  @SuppressWarnings({"deprecation"})
  protected static List<PlacementDB> findRecentPlacements(Connection connection, long idStage) throws SQLException {
    PreparedStatement preparedStatement = null;
    List<PlacementDB> placements;
    List list;
    try {
      preparedStatement = connection.prepareStatement("select event.*, \n" +
                                                      "       person.nm_person_full \n" +
                                                      "from event, \n" +
                                                      "     person \n" +
                                                      "where event.cd_task = '3080' \n" +
                                                      "  and event.id_event_stage = ? \n" +
                                                      "  and event.id_event_person = person.id_person \n" +
                                                      "order by event.dt_event_occurred desc \n");
      preparedStatement.setLong(1, idStage);
      placements = new ArrayList<PlacementDB>();
      list = SqlHelper.createListFromQuery(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      // We will now be displaying all placements on the app & bg page.
      Map map = (Map) iterator.next();
      PlacementDB placementDB = new PlacementDB();
      placementDB.setDtEventOccurred((Date) map.get("DT_EVENT_OCCURRED"));
      placementDB.setCdEventStatus((String) map.get("CD_EVENT_STATUS"));
      placementDB.setNmPersonFull((String) map.get("NM_PERSON_FULL"));
      placementDB.setTxtDescription((String) map.get("TXT_EVENT_DESCR"));
      placements.add(placementDB);
    }
    return placements;
  }

  protected static Map findActivePlacement(Connection connection, long idPerson) throws SQLException {
    List list = findActivePlacements(connection, idPerson);
    if (list.size() == 0) {
      return null;
    }
    return (Map) list.get(0);
  }

  @SuppressWarnings({"deprecation"})
  protected static List findActivePlacements(Connection connection, long idPerson) throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement(SELECT_PLACEMENT_BASE_SQL +
                                                      "  and placement.dt_plcmt_end > sysDate \n" +
                                                      "order by placement.dt_plcmt_start desc \n");
      preparedStatement.setLong(1, idPerson);
      return SqlHelper.createListFromQuery(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static String getPrsPaidPlacementCode(String cdPlocChild, Map placement) {
    String cdRsrcFacilType = (String) placement.get("CD_RSRC_FACIL_TYPE");
    if (cdRsrcFacilType == null) {
      return null;
    }

    String indPlcmtEmerg = (String) placement.get("IND_PLCMT_EMERG");
    if (indPlcmtEmerg == null) {
      indPlcmtEmerg = ArchitectureConstants.N;
    }

    String cdPlcmtType = (String) placement.get("CD_PLCMT_TYPE");
    String cdPlcmtLivArr = (String) placement.get("CD_PLCMT_LIV_ARR");
    if (isPlacementPrsPaid(cdPlcmtType, cdPlcmtLivArr) == false) {
      return null;
    }

    String translatedLoc = getTranslatedLoc(cdPlocChild);

    //as of Sept 28, using plcmntsc table, there is no age indicator
    return translatedLoc + cdRsrcFacilType + indPlcmtEmerg + cdPlcmtType;
  }

  protected static String getTranslatedLoc(String loc) {
    //SIR 19831, Translate from old Level of Cares to new ones
    String translatedLoc = Lookup.simpleDecodeSafe(CodesTables.CLOCMAP, loc);

    if ("".equals(translatedLoc) == false) {
      return translatedLoc;
    }
    return loc;
  }

  protected static boolean isPlacementPrsPaid(String cdPlcmtType, String cdPlcmtLivArr) {
    GrndsTrace.msg("PlacementHelper.isPlacementPrsPaid", 7, "cdPlcmtType = '" + cdPlcmtType + "'");

    GrndsTrace.msg("PlacementHelper.isPlacementPrsPaid", 7, "cdPlcmtLivArr = '" + cdPlcmtLivArr + "'");

    //!!! fill in better constant names
    if (cdPlcmtType == null ||
        CodesTables.CPLMNTYP_010.equals(cdPlcmtType) ||
        CodesTables.CPLMNTYP_040.equals(cdPlcmtType)) {
      GrndsTrace.msg("PlacementHelper.isPlacementPrsPaid", 7, "cdPlcmtType check is false");
      return false;
    }
    //CD_PLCMT_LIV_ARR not in ('GT', '71') which is in prebill code
    if (CodesTables.CPLLAFRM_GT.equals(cdPlcmtLivArr) ||
        CodesTables.CPLLAFRM_71.equals(cdPlcmtLivArr)) {
      GrndsTrace.msg("PlacementHelper.isPlacementPrsPaid", 7, "cdPlcmtLivArr check is false");
      return false;
    }

    return true;
  }
}
