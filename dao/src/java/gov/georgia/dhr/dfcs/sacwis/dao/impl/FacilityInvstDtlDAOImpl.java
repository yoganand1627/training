package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.FacilityInvstDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FacilityInvstDtl;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class FacilityInvstDtlDAOImpl extends BaseDAOImpl implements FacilityInvstDtlDAO {
  @SuppressWarnings({"unchecked"})
  public String findNmFacilInvstFacilityFromFacilityInvstDtlByIdStage(int idStage) {

    Query query = getSession().createQuery("select f.nmFacilInvstFacility " +
                                           "  from FacilityInvstDtl f " +
                                           " where f.stage.idStage = :idStage");

    query.setInteger("idStage", idStage);
    return (String) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findFacilityInvstDtlOvrallDisCompltReasonClosedByIdStage(int idStage) {
    Query query = getSession().createQuery("select new map (f.cdFacilInvstOvrallDis as cdFacilInvstOvrallDis, " +
                                           "                f.dtFacilInvstComplt as dtFacilInvstComplt, " +
                                           "                s.cdStageReasonClosed as cdStageReasonClosed) " +
                                           "  from FacilityInvstDtl f " +
                                           "  join f.stage s " +
                                           " where f.stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }

  public FacilityInvstDtl findFacilityInvstDtlByIdStage(int idStage) {
    Query query = getSession().createQuery(" from FacilityInvstDtl f " +
                                           "where f.stage.idStage=:idStage ");
    query.setInteger("idStage", idStage);
    return (FacilityInvstDtl) firstResult(query);
  }

  public int insertFacilityInvstDtl2(int idEvent,
                                     int idStage,
                                     int idFacilResource,
                                     int idAffilResource,
                                     String cdFacilInvstOvrallDis,
                                     String cdAddrFacilInvstAffAttn,
                                     String cdAddrFacilInvstAffCity,
                                     String cdAddrFacilInvstAffCnty,
                                     String cdAddrFacilInvstAffilSt,
                                     String cdAddrFacilInvstAffStr1,
                                     String cdAddrFacilInvstAffStr2,
                                     String cdAddrFacilInvstAffZip,
                                     String cdAddrFacilInvstAttn,
                                     String cdAddrFacilInvstCity,
                                     String cdAddrFacilInvstCnty,
                                     String cdAddrFacilInvstState,
                                     String cdAddrFacilInvstStr1,
                                     String cdAddrFacilInvstStr2,
                                     String cdAddrFacilInvstZip,
                                     Date dtFacilInvstIntake,
                                     Date dtFacilInvstIncident,
                                     Date dtFacilInvstBegun,
                                     Date dtFacilInvstComplt,
                                     int iNbrFacilInvstAffilPhn,
                                     int iNbrFacilInvstPhone,
                                     String cdNbrFacilInvstAffilExt,
                                     String cdNbrFacilInvstExtension,
                                     String cdTxtFacilInvstAffilCmnt,
                                     String cdTxtFacilInvstComments,
                                     String cdNmFacilInvstAff,
                                     String cdNmFacilInvstFacility) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO FACILITY_INVST_DTL ( " +
                                                 "     ID_EVENT, " +
                                                 "     ID_FACIL_INVST_STAGE, " +
                                                 "     ID_FACIL_RESOURCE, " +
                                                 "     ID_AFFIL_RESOURCE, " +
                                                 "     CD_FACIL_INVST_OVRALL_DIS, " +
                                                 "     ADDR_FACIL_INVST_AFF_ATTN, " +
                                                 "     ADDR_FACIL_INVST_AFF_CITY, " +
                                                 "     ADDR_FACIL_INVST_AFF_CNTY, " +
                                                 "     ADDR_FACIL_INVST_AFF_ST, " +
                                                 "     ADDR_FACIL_INVST_AFF_STR1, " +
                                                 "     ADDR_FACIL_INVST_AFF_STR2, " +
                                                 "     ADDR_FACIL_INVST_AFF_ZIP, " +
                                                 "     ADDR_FACIL_INVST_ATTN, " +
                                                 "     ADDR_FACIL_INVST_CITY, " +
                                                 "     ADDR_FACIL_INVST_CNTY, " +
                                                 "     ADDR_FACIL_INVST_STATE, " +
                                                 "     ADDR_FACIL_INVST_STR1, " +
                                                 "     ADDR_FACIL_INVST_STR2, " +
                                                 "     ADDR_FACIL_INVST_ZIP, " +
                                                 "     DT_FACIL_INVST_INTAKE, " +
                                                 "     DT_FACIL_INVST_INCIDENT, " +
                                                 "     DT_FACIL_INVST_BEGUN, " +
                                                 "     DT_FACIL_INVST_COMPLT, " +
                                                 "     NBR_FACIL_INVST_AFFIL_PHN, " +
                                                 "     NBR_FACIL_INVST_PHONE, " +
                                                 "     NBR_FACIL_INVST_AFFIL_EXT, " +
                                                 "     NBR_FACIL_INVST_EXTENSION, " +
                                                 "     TXT_FACIL_INVST_AFFIL_CMNT, " +
                                                 "     TXT_FACIL_INVST_COMMENTS, " +
                                                 "     NM_FACIL_INVST_AFF, " +
                                                 "     NM_FACIL_INVST_FACILITY) " +
                                                 " VALUES ( " +
                                                 "      :idEvent, " +
                                                 "      :idStage, " +
                                                 "      :idFacilResource, " +
                                                 "      :idAffilResource, " +
                                                 "      :cdFacilInvstOvrallDis, " +
                                                 "      :cdAddrFacilInvstAffAttn, " +
                                                 "      :cdAddrFacilInvstAffCity, " +
                                                 "      :cdAddrFacilInvstAffCnty, " +
                                                 "      :cdAddrFacilInvstAffilSt, " +
                                                 "      :cdAddrFacilInvstAffStr1, " +
                                                 "      :cdAddrFacilInvstAffStr2, " +
                                                 "      :cdAddrFacilInvstAffZip, " +
                                                 "      :cdAddrFacilInvstAttn, " +
                                                 "      :cdAddrFacilInvstCity, " +
                                                 "      :cdAddrFacilInvstCnty, " +
                                                 "      :cdAddrFacilInvstState, " +
                                                 "      :cdAddrFacilInvstStr1, " +
                                                 "      :cdAddrFacilInvstStr2, " +
                                                 "      :cdAddrFacilInvstZip, " +
                                                 "      :dtFacilInvstIntake, " +
                                                 "      :dtFacilInvstIncident, " +
                                                 "      :dtFacilInvstBegun, " +
                                                 "      :dtFacilInvstComplt, " +
                                                 "      :iNbrFacilInvstAffilPhn, " +
                                                 "      :iNbrFacilInvstPhone, " +
                                                 "      :cdNbrFacilInvstAffilExt, " +
                                                 "      :cdNbrFacilInvstExtension, " +
                                                 "      :cdTxtFacilInvstAffilCmnt, " +
                                                 "      :cdTxtFacilInvstComments, " +
                                                 "      :cdNmFacilInvstAff, " +
                                                 "      :cdNmFacilInvstFacility)");

    query.setInteger("idEvent", idEvent);
    query.setInteger("idStage", idStage);
    query.setInteger("idFacilResource", idFacilResource);
    query.setInteger("idAffilResource", idAffilResource);
    query.setString("cdFacilInvstOvrallDis", cdFacilInvstOvrallDis);
    query.setString("cdAddrFacilInvstAffAttn", cdAddrFacilInvstAffAttn);
    query.setString("cdAddrFacilInvstAffCity", cdAddrFacilInvstAffCity);
    query.setString("cdAddrFacilInvstAffCnty", cdAddrFacilInvstAffCnty);
    query.setString("cdAddrFacilInvstAffilSt", cdAddrFacilInvstAffilSt);
    query.setString("cdAddrFacilInvstAffStr1", cdAddrFacilInvstAffStr1);
    query.setString("cdAddrFacilInvstAffStr2", cdAddrFacilInvstAffStr2);
    query.setString("cdAddrFacilInvstAffZip", cdAddrFacilInvstAffZip);
    query.setString("cdAddrFacilInvstAttn", cdAddrFacilInvstAttn);
    query.setString("cdAddrFacilInvstCity", cdAddrFacilInvstCity);
    query.setString("cdAddrFacilInvstCnty", cdAddrFacilInvstCnty);
    query.setString("cdAddrFacilInvstState", cdAddrFacilInvstState);
    query.setString("cdAddrFacilInvstStr1", cdAddrFacilInvstStr1);
    query.setString("cdAddrFacilInvstStr2", cdAddrFacilInvstStr2);
    query.setString("cdAddrFacilInvstZip", cdAddrFacilInvstZip);
    query.setTimestamp("dtFacilInvstIntake", dtFacilInvstIntake);
    query.setTimestamp("dtFacilInvstIncident", dtFacilInvstIncident);
    query.setTimestamp("dtFacilInvstBegun", dtFacilInvstBegun);
    query.setTimestamp("dtFacilInvstComplt", dtFacilInvstComplt);
    query.setInteger("iNbrFacilInvstAffilPhn", iNbrFacilInvstAffilPhn);
    query.setInteger("iNbrFacilInvstPhone", iNbrFacilInvstPhone);
    query.setString("cdNbrFacilInvstAffilExt", cdNbrFacilInvstAffilExt);
    query.setString("cdNbrFacilInvstExtension", cdNbrFacilInvstExtension);
    query.setString("cdTxtFacilInvstAffilCmnt", cdTxtFacilInvstAffilCmnt);
    query.setString("cdTxtFacilInvstComments", cdTxtFacilInvstComments);
    query.setString("cdNmFacilInvstAff", cdNmFacilInvstAff);
    query.setString("cdNmFacilInvstFacility", cdNmFacilInvstFacility);

    return query.executeUpdate();
  }

  public int updateFacilInvstDtlSetNullByIdStage(int idStage) {
    Query query = getSession().createQuery("update FacilityInvstDtl" +
                                           "    set cdFacilInvstOrigDisp = null," +
                                           "        cdFacilInvstOrigClsRsn = null," +
                                           "        dtFacilInvstOrigCompl = null" +
                                           "  where stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

}
