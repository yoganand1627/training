package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.IncomingFacilityDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingFacility;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class IncomingFacilityDAOImpl extends BaseDAOImpl implements IncomingFacilityDAO {
  public IncomingFacility findIncomingFacilityByIdStage(int idStage) {
    Query query = getSession().createQuery(" from IncomingFacility" + "  where idStage = :idStage");

    query.setInteger("idStage", idStage);
    return (IncomingFacility) firstResult(query);
  }

  public int insertIncomingFacility_With_ResourceId(String indIncmgOnGrnds, String cdNmIncmgFacilName, String cdNmIncmgFacilSuprtdant,
                                    String cdIncFacilOperBy, String cdNmIncmgFacilAffiliated,
                                    String indIncmgFacilSearch, String indIncmgFacilAbSupvd, String cdIncmgFacilType,
                                    String cdAddrIncmgFacilStLn1, String cdAddrIncmgFacilStLn2,
                                    String cdIncmgFacilState, String cdIncmgFacilCnty, String cdAddrIncmgFacilCity,
                                    String cdAddrIncmgFacilZip, String cdNbrIncmgFacilPhone,
                                    String cdNbrIncmgFacilPhoneExt, String cdNmUnitWard, String cdTxtFacilCmnts,
                                    int idStage, int idResource) {
    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO INCOMING_FACILITY " + "   (IND_INCMG_FACIL_OFF_GRNDS, "
                                                                 + "     NM_INCMG_FACIL_NAME, "
                                                                 + "     NM_INCMG_FACIL_SUPRTDANT, "
                                                                 + "     CD_INCMG_FACIL_OPER_BY, "
                                                                 + "     NM_INCMG_FACIL_AFFILIATED, "
                                                                 + "     IND_INCMG_FACIL_SEARCH, "
                                                                 + "     IND_INCMG_FACIL_AB_SUPVD, "
                                                                 + "     CD_INCMG_FACIL_TYPE, "
                                                                 + "     ADDR_INCMG_FACIL_ST_LN_1, "
                                                                 + "     ADDR_INCMG_FACIL_ST_LN_2, "
                                                                 + "     CD_INCMG_FACIL_STATE, "
                                                                 + "     CD_INCMG_FACIL_CNTY, "
                                                                 + "     ADDR_INCMG_FACIL_CITY, "
                                                                 + "     ADDR_INCMG_FACIL_ZIP, "
                                                                 + "     NBR_INCMG_FACIL_PHONE, "
                                                                 + "     NBR_INCMG_FACIL_PHONE_EXT, "
                                                                 + "     NM_INCMG_FACIL_UNIT_WARD,  "
                                                                 + "     TXT_INCOMING_FACIL_CMNTS,  "
                                                                 + "     ID_STAGE, " + "     ID_RESOURCE) "
                                                                 + " VALUES  ( " + "     :indIncmgOnGrnds, "
                                                                 + "     :cdNmIncmgFacilName, "
                                                                 + "     :cdNmIncmgFacilSuprtdant, "
                                                                 + "     :cdIncFacilOperBy,  "
                                                                 + "     :cdNmIncmgFacilAffiliated, "
                                                                 + "     :indIncmgFacilSearch, "
                                                                 + "     :indIncmgFacilAbSupvd, "
                                                                 + "     :cdIncmgFacilType, "
                                                                 + "     :cdAddrIncmgFacilStLn1, "
                                                                 + "     :cdAddrIncmgFacilStLn2, "
                                                                 + "     :cdIncmgFacilState, "
                                                                 + "     :cdIncmgFacilCnty, "
                                                                 + "     :cdAddrIncmgFacilCity, "
                                                                 + "     :cdAddrIncmgFacilZip, "
                                                                 + "     :cdNbrIncmgFacilPhone, "
                                                                 + "     :cdNbrIncmgFacilPhoneExt, "
                                                                 + "     :cdNmUnitWard, " + "     :cdTxtFacilCmnts, "
                                                                 + "     :idStage, " + "     :idResource)");

    query.setString("indIncmgOnGrnds", indIncmgOnGrnds);
    query.setString("cdNmIncmgFacilName", cdNmIncmgFacilName);
    query.setString("cdNmIncmgFacilSuprtdant", cdNmIncmgFacilSuprtdant);
    query.setString("cdIncFacilOperBy", cdIncFacilOperBy);
    query.setString("cdNmIncmgFacilAffiliated", cdNmIncmgFacilAffiliated);
    query.setString("indIncmgFacilSearch", indIncmgFacilSearch);
    query.setString("indIncmgFacilAbSupvd", indIncmgFacilAbSupvd);
    query.setString("cdIncmgFacilType", cdIncmgFacilType);
    query.setString("cdAddrIncmgFacilStLn1", cdAddrIncmgFacilStLn1);
    query.setString("cdAddrIncmgFacilStLn2", cdAddrIncmgFacilStLn2);
    query.setString("cdIncmgFacilState", cdIncmgFacilState);
    query.setString("cdIncmgFacilCnty", cdIncmgFacilCnty);
    query.setString("cdAddrIncmgFacilCity", cdAddrIncmgFacilCity);
    query.setString("cdAddrIncmgFacilZip", cdAddrIncmgFacilZip);
    query.setString("cdNbrIncmgFacilPhone", cdNbrIncmgFacilPhone);
    query.setString("cdNbrIncmgFacilPhoneExt", cdNbrIncmgFacilPhoneExt);
    query.setString("cdNmUnitWard", cdNmUnitWard);
    query.setString("cdTxtFacilCmnts", cdTxtFacilCmnts);
    query.setInteger("idStage", idStage);
    query.setInteger("idResource", idResource);

    return query.executeUpdate();
  }
  
  public int insertIncomingFacility_Without_ResourceId(String indIncmgOnGrnds, String cdNmIncmgFacilName, String cdNmIncmgFacilSuprtdant,
                                                    String cdIncFacilOperBy, String cdNmIncmgFacilAffiliated,
                                                    String indIncmgFacilSearch, String indIncmgFacilAbSupvd, String cdIncmgFacilType,
                                                    String cdAddrIncmgFacilStLn1, String cdAddrIncmgFacilStLn2,
                                                    String cdIncmgFacilState, String cdIncmgFacilCnty, String cdAddrIncmgFacilCity,
                                                    String cdAddrIncmgFacilZip, String cdNbrIncmgFacilPhone,
                                                    String cdNbrIncmgFacilPhoneExt, String cdNmUnitWard, String cdTxtFacilCmnts,
                                                    int idStage) {
                    SQLQuery query = getSession().createSQLQuery(
                                                                 "INSERT INTO INCOMING_FACILITY " + "   (IND_INCMG_FACIL_OFF_GRNDS, "
                                                                                 + "     NM_INCMG_FACIL_NAME, "
                                                                                 + "     NM_INCMG_FACIL_SUPRTDANT, "
                                                                                 + "     CD_INCMG_FACIL_OPER_BY, "
                                                                                 + "     NM_INCMG_FACIL_AFFILIATED, "
                                                                                 + "     IND_INCMG_FACIL_SEARCH, "
                                                                                 + "     IND_INCMG_FACIL_AB_SUPVD, "
                                                                                 + "     CD_INCMG_FACIL_TYPE, "
                                                                                 + "     ADDR_INCMG_FACIL_ST_LN_1, "
                                                                                 + "     ADDR_INCMG_FACIL_ST_LN_2, "
                                                                                 + "     CD_INCMG_FACIL_STATE, "
                                                                                 + "     CD_INCMG_FACIL_CNTY, "
                                                                                 + "     ADDR_INCMG_FACIL_CITY, "
                                                                                 + "     ADDR_INCMG_FACIL_ZIP, "
                                                                                 + "     NBR_INCMG_FACIL_PHONE, "
                                                                                 + "     NBR_INCMG_FACIL_PHONE_EXT, "
                                                                                 + "     NM_INCMG_FACIL_UNIT_WARD,  "
                                                                                 + "     TXT_INCOMING_FACIL_CMNTS,  "
                                                                                 + "     ID_STAGE,  ID_RESOURCE ) "
                                                                                 + " VALUES  ( " + "     :indIncmgOnGrnds, "
                                                                                 + "     :cdNmIncmgFacilName, "
                                                                                 + "     :cdNmIncmgFacilSuprtdant, "
                                                                                 + "     :cdIncFacilOperBy,  "
                                                                                 + "     :cdNmIncmgFacilAffiliated, "
                                                                                 + "     :indIncmgFacilSearch, "
                                                                                 + "     :indIncmgFacilAbSupvd, "
                                                                                 + "     :cdIncmgFacilType, "
                                                                                 + "     :cdAddrIncmgFacilStLn1, "
                                                                                 + "     :cdAddrIncmgFacilStLn2, "
                                                                                 + "     :cdIncmgFacilState, "
                                                                                 + "     :cdIncmgFacilCnty, "
                                                                                 + "     :cdAddrIncmgFacilCity, "
                                                                                 + "     :cdAddrIncmgFacilZip, "
                                                                                 + "     :cdNbrIncmgFacilPhone, "
                                                                                 + "     :cdNbrIncmgFacilPhoneExt, "
                                                                                 + "     :cdNmUnitWard, " + "     :cdTxtFacilCmnts, "
                                                                                 + "     :idStage, null ) " );

                    query.setString("indIncmgOnGrnds", indIncmgOnGrnds);
                    query.setString("cdNmIncmgFacilName", cdNmIncmgFacilName);
                    query.setString("cdNmIncmgFacilSuprtdant", cdNmIncmgFacilSuprtdant);
                    query.setString("cdIncFacilOperBy", cdIncFacilOperBy);
                    query.setString("cdNmIncmgFacilAffiliated", cdNmIncmgFacilAffiliated);
                    query.setString("indIncmgFacilSearch", indIncmgFacilSearch);
                    query.setString("indIncmgFacilAbSupvd", indIncmgFacilAbSupvd);
                    query.setString("cdIncmgFacilType", cdIncmgFacilType);
                    query.setString("cdAddrIncmgFacilStLn1", cdAddrIncmgFacilStLn1);
                    query.setString("cdAddrIncmgFacilStLn2", cdAddrIncmgFacilStLn2);
                    query.setString("cdIncmgFacilState", cdIncmgFacilState);
                    query.setString("cdIncmgFacilCnty", cdIncmgFacilCnty);
                    query.setString("cdAddrIncmgFacilCity", cdAddrIncmgFacilCity);
                    query.setString("cdAddrIncmgFacilZip", cdAddrIncmgFacilZip);
                    query.setString("cdNbrIncmgFacilPhone", cdNbrIncmgFacilPhone);
                    query.setString("cdNbrIncmgFacilPhoneExt", cdNbrIncmgFacilPhoneExt);
                    query.setString("cdNmUnitWard", cdNmUnitWard);
                    query.setString("cdTxtFacilCmnts", cdTxtFacilCmnts);
                    query.setInteger("idStage", idStage);
                  

                    return query.executeUpdate();
                  }

  public int updateIncomingFacilityDetail_With_ResourceId(String indIncmgOnGrnds, String cdNmIncmgFacilName,
                                           String cdNmIncmgFacilSuprtdant, String cdIncFacilOperBy,
                                           String cdNmIncmgFacilAffiliated, String indIncmgFacilSearch,
                                           String indIncmgFacilAbSupvd, String cdIncmgFacilType,
                                           String cdAddrIncmgFacilStLn1, String cdAddrIncmgFacilStLn2,
                                           String cdIncmgFacilState, String cdIncmgFacilCnty,
                                           String cdAddrIncmgFacilCity, String cdAddrIncmgFacilZip,
                                           String cdNbrIncmgFacilPhone, String cdNbrIncmgFacilPhoneExt,
                                           String cdNmUnitWard, String cdTxtFacilCmnts, int idStage, int idResource) {

    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "  UPDATE INCOMING_FACILITY "
                                                                 + "  SET                      "
                                                                 + " IND_INCMG_FACIL_OFF_GRNDS = :indIncmgOnGrnds, "
                                                                 + " NM_INCMG_FACIL_NAME       = :cdNmIncmgFacilName,   "
                                                                 + " NM_INCMG_FACIL_SUPRTDANT  = :cdNmIncmgFacilSuprtdant,  "
                                                                 + " CD_INCMG_FACIL_OPER_BY    = :cdIncFacilOperBy,         "
                                                                 + " NM_INCMG_FACIL_AFFILIATED = :cdNmIncmgFacilAffiliated,  "
                                                                 + " IND_INCMG_FACIL_SEARCH    = :indIncmgFacilSearch,   "
                                                                 + " IND_INCMG_FACIL_AB_SUPVD  = :indIncmgFacilAbSupvd,  "
                                                                 + " CD_INCMG_FACIL_TYPE       = :cdIncmgFacilType,          "
                                                                 + " ADDR_INCMG_FACIL_ST_LN_1  = :cdAddrIncmgFacilStLn1,  "
                                                                 + " ADDR_INCMG_FACIL_ST_LN_2  = :cdAddrIncmgFacilStLn2,  "
                                                                 + " CD_INCMG_FACIL_STATE      = :cdIncmgFacilState,   "
                                                                 + " CD_INCMG_FACIL_CNTY       = :cdIncmgFacilCnty,             "
                                                                 + " ADDR_INCMG_FACIL_CITY     = :cdAddrIncmgFacilCity,    "
                                                                 + " ADDR_INCMG_FACIL_ZIP      = :cdAddrIncmgFacilZip,      "
                                                                 + " NBR_INCMG_FACIL_PHONE     = :cdNbrIncmgFacilPhone,       "
                                                                 + " NBR_INCMG_FACIL_PHONE_EXT = :cdNbrIncmgFacilPhoneExt,   "
                                                                 + " NM_INCMG_FACIL_UNIT_WARD  = :cdNmUnitWard,      "
                                                                 + " TXT_INCOMING_FACIL_CMNTS  = :cdTxtFacilCmnts,   "
                                                                 + " ID_RESOURCE               = :idResource   "
                                                                 + " WHERE  ID_STAGE           = :idStage  ");

    query.setString("indIncmgOnGrnds", indIncmgOnGrnds);
    query.setString("cdNmIncmgFacilName", cdNmIncmgFacilName);
    query.setString("cdNmIncmgFacilSuprtdant", cdNmIncmgFacilSuprtdant);
    query.setString("cdIncFacilOperBy", cdIncFacilOperBy);
    query.setString("cdNmIncmgFacilAffiliated", cdNmIncmgFacilAffiliated);
    query.setString("indIncmgFacilSearch", indIncmgFacilSearch);
    query.setString("indIncmgFacilAbSupvd", indIncmgFacilAbSupvd);
    query.setString("cdIncmgFacilType", cdIncmgFacilType);
    query.setString("cdAddrIncmgFacilStLn1", cdAddrIncmgFacilStLn1);
    query.setString("cdAddrIncmgFacilStLn2", cdAddrIncmgFacilStLn2);
    query.setString("cdIncmgFacilState", cdIncmgFacilState);
    query.setString("cdIncmgFacilCnty", cdIncmgFacilCnty);
    query.setString("cdAddrIncmgFacilCity", cdAddrIncmgFacilCity);
    query.setString("cdAddrIncmgFacilZip", cdAddrIncmgFacilZip);
    query.setString("cdNbrIncmgFacilPhone", cdNbrIncmgFacilPhone);
    query.setString("cdNbrIncmgFacilPhoneExt", cdNbrIncmgFacilPhoneExt);
    query.setString("cdNmUnitWard", cdNmUnitWard);
    query.setString("cdTxtFacilCmnts", cdTxtFacilCmnts);
    query.setInteger("idStage", idStage);
    query.setInteger("idResource", idResource);
    return query.executeUpdate();

  }
  public int updateIncomingFacilityDetail_Without_ResourceId(String indIncmgOnGrnds, String cdNmIncmgFacilName,
                                          String cdNmIncmgFacilSuprtdant, String cdIncFacilOperBy,
                                          String cdNmIncmgFacilAffiliated, String indIncmgFacilSearch,
                                          String indIncmgFacilAbSupvd, String cdIncmgFacilType,
                                          String cdAddrIncmgFacilStLn1, String cdAddrIncmgFacilStLn2,
                                          String cdIncmgFacilState, String cdIncmgFacilCnty,
                                          String cdAddrIncmgFacilCity, String cdAddrIncmgFacilZip,
                                          String cdNbrIncmgFacilPhone, String cdNbrIncmgFacilPhoneExt,
                                          String cdNmUnitWard, String cdTxtFacilCmnts, int idStage) {

   SQLQuery query = getSession()
                                .createSQLQuery(
                                                "  UPDATE INCOMING_FACILITY "
                                                                + "  SET                      "
                                                                + " IND_INCMG_FACIL_OFF_GRNDS = :indIncmgOnGrnds, "
                                                                + " NM_INCMG_FACIL_NAME       = :cdNmIncmgFacilName,   "
                                                                + " NM_INCMG_FACIL_SUPRTDANT  = :cdNmIncmgFacilSuprtdant,  "
                                                                + " CD_INCMG_FACIL_OPER_BY    = :cdIncFacilOperBy,         "
                                                                + " NM_INCMG_FACIL_AFFILIATED = :cdNmIncmgFacilAffiliated,  "
                                                                + " IND_INCMG_FACIL_SEARCH    = :indIncmgFacilSearch,   "
                                                                + " IND_INCMG_FACIL_AB_SUPVD  = :indIncmgFacilAbSupvd,  "
                                                                + " CD_INCMG_FACIL_TYPE       = :cdIncmgFacilType,          "
                                                                + " ADDR_INCMG_FACIL_ST_LN_1  = :cdAddrIncmgFacilStLn1,  "
                                                                + " ADDR_INCMG_FACIL_ST_LN_2  = :cdAddrIncmgFacilStLn2,  "
                                                                + " CD_INCMG_FACIL_STATE      = :cdIncmgFacilState,   "
                                                                + " CD_INCMG_FACIL_CNTY       = :cdIncmgFacilCnty,             "
                                                                + " ADDR_INCMG_FACIL_CITY     = :cdAddrIncmgFacilCity,    "
                                                                + " ADDR_INCMG_FACIL_ZIP      = :cdAddrIncmgFacilZip,      "
                                                                + " NBR_INCMG_FACIL_PHONE     = :cdNbrIncmgFacilPhone,       "
                                                                + " NBR_INCMG_FACIL_PHONE_EXT = :cdNbrIncmgFacilPhoneExt,   "
                                                                + " NM_INCMG_FACIL_UNIT_WARD  = :cdNmUnitWard,      "
                                                                + " TXT_INCOMING_FACIL_CMNTS  = :cdTxtFacilCmnts,   "
                                                                + " ID_RESOURCE               = null   "
                                                                + " WHERE  ID_STAGE           = :idStage  ");

   query.setString("indIncmgOnGrnds", indIncmgOnGrnds);
   query.setString("cdNmIncmgFacilName", cdNmIncmgFacilName);
   query.setString("cdNmIncmgFacilSuprtdant", cdNmIncmgFacilSuprtdant);
   query.setString("cdIncFacilOperBy", cdIncFacilOperBy);
   query.setString("cdNmIncmgFacilAffiliated", cdNmIncmgFacilAffiliated);
   query.setString("indIncmgFacilSearch", indIncmgFacilSearch);
   query.setString("indIncmgFacilAbSupvd", indIncmgFacilAbSupvd);
   query.setString("cdIncmgFacilType", cdIncmgFacilType);
   query.setString("cdAddrIncmgFacilStLn1", cdAddrIncmgFacilStLn1);
   query.setString("cdAddrIncmgFacilStLn2", cdAddrIncmgFacilStLn2);
   query.setString("cdIncmgFacilState", cdIncmgFacilState);
   query.setString("cdIncmgFacilCnty", cdIncmgFacilCnty);
   query.setString("cdAddrIncmgFacilCity", cdAddrIncmgFacilCity);
   query.setString("cdAddrIncmgFacilZip", cdAddrIncmgFacilZip);
   query.setString("cdNbrIncmgFacilPhone", cdNbrIncmgFacilPhone);
   query.setString("cdNbrIncmgFacilPhoneExt", cdNbrIncmgFacilPhoneExt);
   query.setString("cdNmUnitWard", cdNmUnitWard);
   query.setString("cdTxtFacilCmnts", cdTxtFacilCmnts);
   query.setInteger("idStage", idStage);
   return query.executeUpdate();

 }
}
