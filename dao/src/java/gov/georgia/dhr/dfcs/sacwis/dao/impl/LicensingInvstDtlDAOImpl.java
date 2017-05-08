package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.LicensingInvstDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.LicensingInvstDtl;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class LicensingInvstDtlDAOImpl extends BaseDAOImpl implements LicensingInvstDtlDAO {
  public LicensingInvstDtl findLicensingInvstDtlByIdStageOnly(int idStage) {
    Query query = getSession().createQuery(" from LicensingInvstDtl " +
                                           "where stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (LicensingInvstDtl) firstResult(query);
  }

  public String findLicensingInvstDtlByIdStage(int idStage) {
    Query query = getSession().createQuery("select l.nmResource " +
                                           "  from LicensingInvstDtl l " +
                                           " where l.stage.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return (String) firstResult(query);
  }

  public int insertLicensingInvstDtl(int idEvent, int idStage, String cdLicngInvstOvrallDisp, Date dtLicngInvstIntake,
                                     Date dtLicngInvstDtlBegun, Date dtLicngInvstComplt, Date dtLicngInvstAssigned,
                                     String cdTxtLicngInvstNoncomp, String cdLicngInvstCoractn, int idResource,
                                     String cdNmResource, int iNbrAcclaim, String cdFacilType, String cdTxtComments,
                                     String cdNbrPhone, String cdNbrPhoneExt, String cdAddrAttn, String cdAddrStLn1,
                                     String cdAddrStLn2, String cdAddrCity, String cdAddrCounty, String cdAddrState,
                                     String cdAddrZip, int idAffilResource, String cdNmAffilResource,
                                     String cdTxtAffilComments, String cdNbrAffilPhone, String cdNbrAffilPhoneExt,
                                     String cdAddrAffilAttn, String cdAddrAffilStLn1, String cdAddrAffilStLn2,
                                     String cdAddrAffilCity, String cdAddrAffilCounty, String cdAddrAffilState,
                                     String cdAddrAffilZip, int idClassFclty, int idClassAffilFclty,
                                     int iNbrAffilAcclaim, int iNbrAgency, int iNbrBranch, int iNbrAffilAgency,
                                     int iNbrAffilBranch, String cdAffilFacilType) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO LICENSING_INVST_DTL ( " +
                                                 "           ID_EVENT, " +
                                                 "           ID_LICNG_INVST_STAGE, " +
                                                 "           CD_LICNG_INVST_OVRALL_DISP, " +
                                                 "           DT_LICNG_INVST_INTAKE, " +
                                                 "           DT_LICNG_INVST_BEGUN, " +
                                                 "           DT_LICNG_INVST_COMPLT, " +
                                                 "           DT_LICNG_INVST_ASSIGNED, " +
                                                 "           TXT_LICNG_INVST_NONCOMP, " +
                                                 "           CD_LICNG_INVST_CORACTN, " +
                                                 "           ID_RESOURCE, " +
                                                 "           NM_RESOURCE, " +
                                                 "           NBR_ACCLAIM, " +
                                                 "           CD_RSRC_FACIL_TYPE, " +
                                                 "           TXT_COMMENTS, " +
                                                 "           NBR_PHONE, " +
                                                 "           NBR_PHONE_EXT, " +
                                                 "           ADDR_ATTN, " +
                                                 "           ADDR_ST_LN1, " +
                                                 "           ADDR_ST_LN2, " +
                                                 "           ADDR_CITY, " +
                                                 "           ADDR_COUNTY, " +
                                                 "           ADDR_STATE, " +
                                                 "           ADDR_ZIP, " +
                                                 "           ID_AFFIL_RESOURCE, " +
                                                 "           NM_AFFIL_RESOURCE, " +
                                                 "           TXT_AFFIL_COMMENTS, " +
                                                 "           NBR_AFFIL_PHONE, " +
                                                 "           NBR_AFFIL_PHONE_EXT, " +
                                                 "           ADDR_AFFIL_ATTN, " +
                                                 "           ADDR_AFFIL_ST_LN1, " +
                                                 "           ADDR_AFFIL_ST_LN2, " +
                                                 "           ADDR_AFFIL_CITY, " +
                                                 "           ADDR_AFFIL_COUNTY, " +
                                                 "           ADDR_AFFIL_STATE, " +
                                                 "           ADDR_AFFIL_ZIP, " +
                                                 "           ID_CLASS_FCLTY, " +
                                                 "           ID_CLASS_AFFIL_FCLTY, " +
                                                 "           NBR_AFFIL_ACCLAIM, " +
                                                 "           NBR_AGENCY, " +
                                                 "           NBR_BRANCH, " +
                                                 "           NBR_AFFIL_AGENCY, " +
                                                 "           NBR_AFFIL_BRANCH, " +
                                                 "           CD_AFFIL_FACIL_TYPE) " +
                                                 "   VALUES ( " +
                                                 "           :idEvent, " +
                                                 "           :idStage, " +
                                                 "           :cdLicngInvstOvrallDisp, " +
                                                 "           :dtLicngInvstIntake, " +
                                                 "           :dtLicngInvstDtlBegun, " +
                                                 "           :dtLicngInvstComplt, " +
                                                 "           :dtLicngInvstAssigned, " +
                                                 "           :cdTxtLicngInvstNoncomp, " +
                                                 "           :cdLicngInvstCoractn, " +
                                                 "           :idResource, " +
                                                 "           :cdNmResource, " +
                                                 "           :iNbrAcclaim, " +
                                                 "           :cdFacilType, " +
                                                 "           :cdTxtComments, " +
                                                 "           :cdNbrPhone, " +
                                                 "           :cdNbrPhoneExt, " +
                                                 "           :cdAddrAttn, " +
                                                 "           :cdAddrStLn1, " +
                                                 "           :cdAddrStLn2, " +
                                                 "           :cdAddrCity, " +
                                                 "           :cdAddrCounty, " +
                                                 "           :cdAddrState, " +
                                                 "           :cdAddrZip, " +
                                                 "           :idAffilResource, " +
                                                 "           :cdNmAffilResource, " +
                                                 "           :cdTxtAffilComments, " +
                                                 "           :cdNbrAffilPhone, " +
                                                 "           :cdNbrAffilPhoneExt, " +
                                                 "           :cdAddrAffilAttn, " +
                                                 "           :cdAddrAffilStLn1, " +
                                                 "           :cdAddrAffilStLn2, " +
                                                 "           :cdAddrAffilCity, " +
                                                 "           :cdAddrAffilCounty, " +
                                                 "           :cdAddrAffilState, " +
                                                 "           :cdAddrAffilZip, " +
                                                 "           :idClassFclty, " +
                                                 "           :idClassAffilFclty, " +
                                                 "           :iNbrAffilAcclaim, " +
                                                 "           :iNbrAgency, " +
                                                 "           :iNbrBranch, " +
                                                 "           :iNbrAffilAgency, " +
                                                 "           :iNbrAffilBranch, " +
                                                 "           :cdAffilFacilType)");

    query.setInteger("idEvent", idEvent);
    query.setInteger("idStage", idStage);
    query.setString("cdLicngInvstOvrallDisp", cdLicngInvstOvrallDisp);
    query.setTimestamp("dtLicngInvstIntake", dtLicngInvstIntake);
    query.setTimestamp("dtLicngInvstDtlBegun", dtLicngInvstDtlBegun);
    query.setTimestamp("dtLicngInvstComplt", dtLicngInvstComplt);
    query.setTimestamp("dtLicngInvstAssigned", dtLicngInvstAssigned);
    query.setString("cdTxtLicngInvstNoncomp", cdTxtLicngInvstNoncomp);
    query.setString("cdLicngInvstCoractn", cdLicngInvstCoractn);
    query.setInteger("idResource", idResource);
    query.setString("cdNmResource", cdNmResource);
    query.setInteger("iNbrAcclaim", iNbrAcclaim);
    query.setString("cdFacilType", cdFacilType);
    query.setString("cdTxtComments", cdTxtComments);
    query.setString("cdNbrPhone", cdNbrPhone);
    query.setString("cdNbrPhoneExt", cdNbrPhoneExt);
    query.setString("cdAddrAttn", cdAddrAttn);
    query.setString("cdAddrStLn1", cdAddrStLn1);
    query.setString("cdAddrStLn2", cdAddrStLn2);
    query.setString("cdAddrCity", cdAddrCity);
    query.setString("cdAddrCounty", cdAddrCounty);
    query.setString("cdAddrState", cdAddrState);
    query.setString("cdAddrZip", cdAddrZip);
    query.setInteger("idAffilResource", idAffilResource);
    query.setString("cdNmAffilResource", cdNmAffilResource);
    query.setString("cdTxtAffilComments", cdTxtAffilComments);
    query.setString("cdNbrAffilPhone", cdNbrAffilPhone);
    query.setString("cdNbrAffilPhoneExt", cdNbrAffilPhoneExt);
    query.setString("cdAddrAffilAttn", cdAddrAffilAttn);
    query.setString("cdAddrAffilStLn1", cdAddrAffilStLn1);
    query.setString("cdAddrAffilStLn2", cdAddrAffilStLn2);
    query.setString("cdAddrAffilCity", cdAddrAffilCity);
    query.setString("cdAddrAffilCounty", cdAddrAffilCounty);
    query.setString("cdAddrAffilState", cdAddrAffilState);
    query.setString("cdAddrAffilZip", cdAddrAffilZip);
    query.setInteger("idClassFclty", idClassFclty);
    query.setInteger("idClassAffilFclty", idClassAffilFclty);
    query.setInteger("iNbrAffilAcclaim", iNbrAffilAcclaim);
    query.setInteger("iNbrAgency", iNbrAgency);
    query.setInteger("iNbrBranch", iNbrBranch);
    query.setInteger("iNbrAffilAgency", iNbrAffilAgency);
    query.setInteger("iNbrAffilBranch", iNbrAffilBranch);
    query.setString("cdAffilFacilType", cdAffilFacilType);

    return query.executeUpdate();
  }

  public int updateLicensingInvstDtl(int idEvent, int idStage, String cdLicngInvstOvrallDisp, Date dtLicngInvstIntake,
                                     Date dtLicngInvstDtlBegun, Date dtLicngInvstComplt, Date dtLicngInvstAssigned,
                                     String cdTxtLicngInvstNoncomp, String cdLicngInvstCoractn, int idResource,
                                     String cdNmResource, int iNbrAcclaim, String cdFacilType, String cdTxtComments,
                                     String cdNbrPhone, String cdNbrPhoneExt, String cdAddrAttn, String cdAddrStLn1,
                                     String cdAddrStLn2, String cdAddrCity, String cdAddrCounty, String cdAddrState,
                                     String cdAddrZip, int idAffilResource, String cdNmAffilResource,
                                     String cdTxtAffilComments, String cdNbrAffilPhone, String cdNbrAffilPhoneExt,
                                     String cdAddrAffilAttn, String cdAddrAffilStLn1, String cdAddrAffilStLn2,
                                     String cdAddrAffilCity, String cdAddrAffilCounty, String cdAddrAffilState,
                                     String cdAddrAffilZip, int idClassFclty, int idClassAffilFclty,
                                     int iNbrAffilAcclaim, int iNbrAgency, int iNbrBranch, int iNbrAffilAgency,
                                     int iNbrAffilBranch, String cdAffilFacilType) {

    Query query = getSession()
            .createQuery("update LicensingInvstDtl" +
                         "    set idEvent = :idEvent," +
                         "        cdLicngInvstOvrallDisp = :cdLicngInvstOvrallDisp," +
                         "        dtLicngInvstIntake = :dtLicngInvstIntake," +
                         "        dtLicngInvstBegun = :dtLicngInvstDtlBegun," +
                         "        dtLicngInvstComplt = :dtLicngInvstComplt," +
                         "        dtLicngInvstAssigned = :dtLicngInvstAssigned," +
                         "        txtLicngInvstNoncomp = :cdTxtLicngInvstNoncomp," +
                         "        cdLicngInvstCoractn = :cdLicngInvstCoractn," +
                         "        capsResource.idResource = :idResource," +
                         "        nmResource = :cdNmResource," +
                         "        nbrAcclaim = :iNbrAcclaim," +
                         "        cdRsrcFacilType = :cdFacilType," +
                         "        txtComments = :cdTxtComments," +
                         "        nbrPhone = :cdNbrPhone," +
                         "        nbrPhoneExt = :cdNbrPhoneExt," +
                         "        addrAttn = :cdAddrAttn," +
                         "        addrStLn1 = :cdAddrStLn1," +
                         "        addrStLn2 = :cdAddrStLn2," +
                         "        addrCity = :cdAddrCity," +
                         "        addrCounty = :cdAddrCounty," +
                         "        addrState = :cdAddrState," +
                         "        addrZip = :cdAddrZip," +
                         "        idAffilResource = :idAffilResource," +
                         "        nmAffilResource = :cdNmAffilResource," +
                         "        txtAffilComments = :cdTxtAffilComments," +
                         "        nbrAffilPhone = :cdNbrAffilPhone," +
                         "        nbrAffilPhoneExt = :cdNbrAffilPhoneExt," +
                         "        addrAffilAttn = :cdAddrAffilAttn," +
                         "        addrAffilStLn1 = :cdAddrAffilStLn1," +
                         "        addrAffilStLn2 = :cdAddrAffilStLn2," +
                         "        addrAffilCity = :cdAddrAffilCity," +
                         "        addrAffilCounty = :cdAddrAffilCounty," +
                         "        addrAffilState = :cdAddrAffilState," +
                         "        addrAffilZip = :cdAddrAffilZip," +
                         "        idClassFclty = :idClassFclty," +
                         "        idClassAffilFclty = :idClassAffilFclty," +
                         "        nbrAffilAcclaim = :iNbrAffilAcclaim," +
                         "        nbrAgency = :iNbrAgency," +
                         "        nbrBranch = :iNbrBranch," +
                         "        nbrAffilAgency = :iNbrAffilAgency," +
                         "        nbrAffilBranch = :iNbrAffilBranch," +
                         "        cdAffilFacilType = :cdAffilFacilType" +
                         "  where stage.idStage = :idStage");

    query.setInteger("idEvent", idEvent);
    query.setInteger("idStage", idStage);
    query.setString("cdLicngInvstOvrallDisp", cdLicngInvstOvrallDisp);
    query.setTimestamp("dtLicngInvstIntake", dtLicngInvstIntake);
    query.setTimestamp("dtLicngInvstDtlBegun", dtLicngInvstDtlBegun);
    query.setTimestamp("dtLicngInvstComplt", dtLicngInvstComplt);
    query.setTimestamp("dtLicngInvstAssigned", dtLicngInvstAssigned);
    query.setString("cdTxtLicngInvstNoncomp", cdTxtLicngInvstNoncomp);
    query.setString("cdLicngInvstCoractn", cdLicngInvstCoractn);
    query.setInteger("idResource", idResource);
    query.setString("cdNmResource", cdNmResource);
    query.setInteger("iNbrAcclaim", iNbrAcclaim);
    query.setString("cdFacilType", cdFacilType);
    query.setString("cdTxtComments", cdTxtComments);
    query.setString("cdNbrPhone", cdNbrPhone);
    query.setString("cdNbrPhoneExt", cdNbrPhoneExt);
    query.setString("cdAddrAttn", cdAddrAttn);
    query.setString("cdAddrStLn1", cdAddrStLn1);
    query.setString("cdAddrStLn2", cdAddrStLn2);
    query.setString("cdAddrCity", cdAddrCity);
    query.setString("cdAddrCounty", cdAddrCounty);
    query.setString("cdAddrState", cdAddrState);
    query.setString("cdAddrZip", cdAddrZip);
    query.setInteger("idAffilResource", idAffilResource);
    query.setString("cdNmAffilResource", cdNmAffilResource);
    query.setString("cdTxtAffilComments", cdTxtAffilComments);
    query.setString("cdNbrAffilPhone", cdNbrAffilPhone);
    query.setString("cdNbrAffilPhoneExt", cdNbrAffilPhoneExt);
    query.setString("cdAddrAffilAttn", cdAddrAffilAttn);
    query.setString("cdAddrAffilStLn1", cdAddrAffilStLn1);
    query.setString("cdAddrAffilStLn2", cdAddrAffilStLn2);
    query.setString("cdAddrAffilCity", cdAddrAffilCity);
    query.setString("cdAddrAffilCounty", cdAddrAffilCounty);
    query.setString("cdAddrAffilState", cdAddrAffilState);
    query.setString("cdAddrAffilZip", cdAddrAffilZip);
    query.setInteger("idClassFclty", idClassFclty);
    query.setInteger("idClassAffilFclty", idClassAffilFclty);
    query.setInteger("iNbrAffilAcclaim", iNbrAffilAcclaim);
    query.setInteger("iNbrAgency", iNbrAgency);
    query.setInteger("iNbrBranch", iNbrBranch);
    query.setInteger("iNbrAffilAgency", iNbrAffilAgency);
    query.setInteger("iNbrAffilBranch", iNbrAffilBranch);
    query.setString("cdAffilFacilType", cdAffilFacilType);
    return query.executeUpdate();
  }

  public void saveLicensingInvstDtl(LicensingInvstDtl licensingInvstDtl) {
    getSession().saveOrUpdate(licensingInvstDtl);
  }

}
