package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeAndResourcesDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomeAndResources;
import gov.georgia.dhr.dfcs.sacwis.db.ChildSupportInbound;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/*Change History:
Date         User            Description
-----------  --------------  --------------------------------------------------

05/31/2011   schoi           SMS #109403: MR-082 Added new method findMostRecentInccomeByIdPersonByCdIncRsrcType
06/01/2011   schoi           SMS #109403: MR-082 Updated the name of the method findMostRecentInccomeByIdPersonByCdIncRsrcType
                             to findMostRecentIncomeAsOfTodayByIdPersonByCdIncRsrcType to reflect new Date parameter
06/09/2011   schoi           SMS #109403: MR-082 Removed unused import statement per code peer review finding                             

*/

public class IncomeAndResourcesDAOImpl extends BaseDAOImpl implements IncomeAndResourcesDAO {
  public long countIncomeAndResourceForToday(int idPerson) {
    Query query = getSession().createQuery("select count(*) " +
                                           "   from IncomeAndResources r1 " +
                                           "  where r1.personByIdPerson.idPerson = :idPerson " +
                                           "    and r1.dtIncRsrcFrom <= trunc(sysdate) " +
                                           "    and r1.dtIncRsrcTo > trunc(sysdate)");
    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }

  public long countIncomeAndResourceMergeFwdClsdToday(int idPersMergeForward, int idPersMergeClosed) {
    Query query = getSession().createQuery("select count(*) " +
                                           "   from IncomeAndResources r3, " +
                                           "        IncomeAndResources r4 " +
                                           "  where r3.personByIdPerson.idPerson = :idPersMergeForward " +
                                           "    and r4.personByIdPerson.idPerson = :idPersMergeClosed " +
                                           "    and r3.cdIncRsrcType = r4.cdIncRsrcType " +
                                           "    and r3.amtIncRsrc = r4.amtIncRsrc " +
                                           "    and r3.cdIncRsrcIncome = r4.cdIncRsrcIncome " +
                                           "    and r3.dtIncRsrcFrom <= trunc(sysdate) " +
                                           "    and r3.dtIncRsrcTo > trunc(sysdate) " +
                                           "    and r4.dtIncRsrcFrom <= trunc(sysdate) " +
                                           "    and r4.dtIncRsrcTo > trunc(sysdate)");

    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    return (Long) query.uniqueResult();
  }
  
  @SuppressWarnings({"unchecked"})
  /*
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   */
  public IncomeAndResources findDistinctIncomeAndResourcesInfo(int idPerson) {
    Query query = getSession().createQuery(" from "
                                           + "IncomeAndResources i "
                                           + "where "
                                           + "i.personByIdPerson.idPerson = :idPerson and "
                                           + "(i.dtIncRsrcTo = '12/31/4712' or i.dtIncRsrcTo IS NULL) "
                                           + "order by i.dtIncRsrcFrom desc");
    query.setInteger("idPerson", idPerson);
    return (IncomeAndResources) firstResult(query);
  }
  @SuppressWarnings({"unchecked"}) 
  public IncomeAndResources findIncomeandResourcesByInboundParamsnZip(String cdIncRsrcType, String cdIncRsrcIncome, Date dtIncRsrcTo,
                                                                  Date dtIncRsrcFrom, int idPerson, int idIncRsrcWorker, String sdsIncRsrcSource, String txtIncRsrcSrcAddrZip ){
        Query query = getSession().createQuery( " from IncomeAndResources i " +
                                                " where i.personByIdPerson.idPerson = :idPerson and " + 
                                                " i.personByIdIncRsrcWorker.idPerson = :idIncRsrcWorker and " + 
                                                " i.cdIncRsrcType = :cdIncRsrcType and " + 
                                                " i.cdIncRsrcIncome = :cdIncRsrcIncome and " + 
                                                " i.dtIncRsrcFrom = :dtIncRsrcFrom and " + 
                                                " i.dtIncRsrcTo = :dtIncRsrcTo and " +
                                                " i.sdsIncRsrcSource = :sdsIncRsrcSource and" +
                                                " i.txtIncRsrcSrcAddrZip = :txtIncRsrcSrcAddrZip");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idIncRsrcWorker", idIncRsrcWorker);
    query.setString("cdIncRsrcType", cdIncRsrcType);
    query.setString("cdIncRsrcIncome", cdIncRsrcIncome);
    query.setDate("dtIncRsrcFrom", dtIncRsrcFrom);
    query.setDate("dtIncRsrcTo", dtIncRsrcTo);
    query.setString("sdsIncRsrcSource", sdsIncRsrcSource);
    query.setString("txtIncRsrcSrcAddrZip", txtIncRsrcSrcAddrZip);
    return (IncomeAndResources)firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public IncomeAndResources findIncomeandResourcesByInboundParams(String cdIncRsrcType, String cdIncRsrcIncome, Date dtIncRsrcTo,
                                                                      Date dtIncRsrcFrom, int idPerson, int idIncRsrcWorker, String sdsIncRsrcSource ){
            Query query = getSession().createQuery( " from IncomeAndResources i " +
                                                    " where i.personByIdPerson.idPerson = :idPerson and " + 
                                                    " i.personByIdIncRsrcWorker.idPerson = :idIncRsrcWorker and " + 
                                                    " i.cdIncRsrcType = :cdIncRsrcType and " + 
                                                    " i.cdIncRsrcIncome = :cdIncRsrcIncome and " + 
                                                    " i.dtIncRsrcFrom = :dtIncRsrcFrom and " + 
                                                    " i.dtIncRsrcTo = :dtIncRsrcTo and " +
                                                    " i.sdsIncRsrcSource = :sdsIncRsrcSource");
        query.setInteger("idPerson", idPerson);
        query.setInteger("idIncRsrcWorker", idIncRsrcWorker);
        query.setString("cdIncRsrcType", cdIncRsrcType);
        query.setString("cdIncRsrcIncome", cdIncRsrcIncome);
        query.setDate("dtIncRsrcFrom", dtIncRsrcFrom);
        query.setDate("dtIncRsrcTo", dtIncRsrcTo);
        query.setString("sdsIncRsrcSource", sdsIncRsrcSource);
        return (IncomeAndResources)firstResult(query);
      }
  
  

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdIncRsrcFromIncomeAndResources(String cdIncRsrcType, int idIncRsrc, Date dtIncRsrcTo,
                                                           Date dtIncRsrcFrom, int idPerson, String cdIncRsrcIncome) {
    Query query = getSession().createQuery(" select i.idIncRsrc " +
                                           "   from IncomeAndResources i , " +
                                           "        PersonMergeView v " +
                                           "  where i.cdIncRsrcType = :cdIncRsrcType " +
                                           "    and i.idIncRsrc <> :idIncRsrc " +
                                           "    and i.dtIncRsrcFrom <= :dtIncRsrcTo " +
                                           "    and i.dtIncRsrcTo >= :dtIncRsrcFrom " +
                                           "    and v.id.idPersonInput = :idPerson " +
                                           "    and i.personByIdPerson.idPerson =  v.id.idPersonOutput " +
                                           "    and i.cdIncRsrcIncome = :cdIncRsrcIncome ");
    query.setString("cdIncRsrcType", cdIncRsrcType);
    query.setInteger("idIncRsrc", idIncRsrc);
    query.setTimestamp("dtIncRsrcTo", dtIncRsrcTo);
    query.setTimestamp("dtIncRsrcFrom", dtIncRsrcFrom);
    query.setInteger("idPerson", idPerson);
    query.setString("cdIncRsrcIncome", cdIncRsrcIncome);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findIncomeAndResourcesAndNmFull(int idPerson) {
    Query query = getSession().createQuery("   select new map ( i.idIncRsrc as idIncRsrc, " +
                                           "                   i.personByIdIncRsrcWorker.idPerson as idIncRsrcWorker, " +
                                           "                   i.personByIdPerson.idPerson as idPerson, " +
                                           "                   i.dtLastUpdate as dtLastUpdate, " +
                                           "                   i.amtIncRsrc as amtIncRsrc, " +
                                           "                   i.cdIncRsrcType as cdIncRsrcType, " +
                                           "                   i.cdIncRsrcIncome as cdIncRsrcIncome, " +
                                           "                   i.dtIncRsrcFrom as dtIncRsrcFrom, " +
                                           "                   i.dtIncRsrcTo as dtIncRsrcTo, " +
                                           "                   i.indIncRsrcNotAccess as indIncRsrcNotAccess, " +
                                           "                   i.sdsIncRsrcSource as sdsIncRsrcSource, " +
                                           "                   i.sdsIncRsrcVerfMethod as sdsIncRsrcVerfMethod, " +
                                           "                   i.cdIncRsrcFreqType as cdIncRsrcFreqType, " +
                                           "                   i.txtIncRsrcDesc as txtIncRsrcDesc , "+
                                           "                   i.txtIncRsrcSrcPhoneNum as txtIncRsrcSrcPhoneNum, " +
                                           "                   i.txtIncRsrcSrcPhoneExt as txtIncRsrcSrcPhoneExt, " +
                                           "                   i.txtIncRsrcSrcAddrStLn1 as txtIncRsrcSrcAddrStLn1, " +
                                           "                   i.txtIncRsrcSrcAddrStLn2 as txtIncRsrcSrcAddrStLn2, " +
                                           "                   i.txtIncRsrcSrcAddrCity as txtIncRsrcSrcAddrCity, " +
                                           "                   i.txtIncRsrcSrcAddrState as txtIncRsrcSrcAddrState, " +
                                           "                   i.txtIncRsrcSrcAddrZip as txtIncRsrcSrcAddrZip, " +
                                           "                   i.cdIncRsrcSrcAddrCounty as txtIncRsrcSrcAddrCounty, " +
                                           "                   i.txtIncRsrcSrcAddrCmnts as txtIncRsrcSrcAddrCmnts, " +
                                           "                   i.dtIncRsrcModified as dtIncRsrcModified, " +
                                           "                   p.nmPersonFull as nmPersonFull ) " +
                                           "     from IncomeAndResources i, " +
                                           "          Person p " +
                                           "    where i.personByIdPerson.idPerson =  :idPerson " +
                                           "      and i.personByIdIncRsrcWorker.idPerson = p.idPerson " +
                                           " order by i.cdIncRsrcIncome, i.dtIncRsrcFrom, i.dtIncRsrcTo");

    query.setInteger("idPerson", idPerson);
    return (List<Map>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<IncomeAndResources> findByIdPersonAndTypeAndDate(int idPerson, String[] cdIncRsrcType, Date dtEffective) {
    Query query = getSession().createQuery(" from IncomeAndResources i " +
                                           "where i.personByIdPerson.idPerson = :idPerson " +
                                           "  and i.cdIncRsrcType in (:cdIncRsrcType) " +
                                           "  and i.dtIncRsrcFrom <= :dtEffective " +
                                           "  and i.dtIncRsrcTo >= :dtEffective");
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdIncRsrcType", cdIncRsrcType, Hibernate.STRING);
    query.setDate("dtEffective", dtEffective);
    return (List<IncomeAndResources>) query.list();
  }

  public void saveIncomeAndResources(IncomeAndResources incomeAndResources) {
    getSession().saveOrUpdate(incomeAndResources);
  }
  
  /*
   * This method is used for updating the INCOME_AND_RESOURCES table for 
   * Receive Child Support Payment Info Service
  */
  @SuppressWarnings("unchecked")
  public int insertPaymentRecdIncomeAndResources(int idPerson, int idWorker, double amtIncRsrc,
                                      String cdIncRsrcType, String cdIncRsrcIncome, Date dtIncRsrcFrom,
                                      Date dtIncRsrcTo, String txtIncRsrcDesc, String cdIncRsrcFreqType) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO INCOME_AND_RESOURCES " 
                                                 + "(ID_INC_RSRC, " 
                                                 + "ID_PERSON, "
                                                 + "ID_INC_RSRC_WORKER, "
                                                 + "AMT_INC_RSRC, " 
                                                 + "CD_INC_RSRC_TYPE, " 
                                                 + "CD_INC_RSRC_INCOME, " 
                                                 + "DT_INC_RSRC_FROM, " 
                                                 + "DT_INC_RSRC_TO, " 
                                                 + "TXT_INC_RSRC_DESC, "
                                                 + "CD_INC_RSRC_FREQ_TYPE) "
                                                 + "VALUES " 
                                                 + "(SEQ_INCOME_AND_RESOURCES.NEXTVAL, " 
                                                 + ":idPerson, " 
                                                 + ":idWorker, "
                                                 + ":amtIncRsrc, " 
                                                 + ":cdIncRsrcType, " 
                                                 + ":cdIncRsrcIncome, " 
                                                 + ":dtIncRsrcFrom, " 
                                                 + ":dtIncRsrcTo, " 
                                                 + ":txtIncRsrcDesc, "
                                                 + ":cdIncRsrcFreqType)");

    query.setInteger("idPerson", idPerson);
    query.setInteger("idWorker", idWorker);
    query.setDouble("amtIncRsrc", amtIncRsrc);
    query.setString("cdIncRsrcType", cdIncRsrcType);
    query.setString("cdIncRsrcIncome", cdIncRsrcIncome);
    query.setTimestamp("dtIncRsrcFrom", dtIncRsrcFrom);
    query.setTimestamp("dtIncRsrcTo", dtIncRsrcTo);
    query.setString("txtIncRsrcDesc", txtIncRsrcDesc);
    query.setString("cdIncRsrcFreqType", cdIncRsrcFreqType);
    
    return query.executeUpdate();
  }

  /*
   * This method is used for updating the CHILD_SUPPORT_INBOUND audit table for 
   * Receive Child Support Payment Info Service
  */
  @SuppressWarnings("unchecked")
  public void saveChildSupportInbound(ChildSupportInbound childSupportInbound) {
    getSession().saveOrUpdate(childSupportInbound);
  }
  
  public void deleteIncomeAndResources(IncomeAndResources incomeAndResources) {
    getSession().delete(incomeAndResources);
  }

  /*
   * This method is used for updating the INCOME_AND_RESOURCES table for 
   * Receive Child Support Payment Info Service
  */
  public int insertIncomeAndResources(int idPerson, int idIncRsrcWorker, Date dtLastUpdate, double amtIncRsrc,
                                      String cdIncRsrcType, String cdIncRsrcIncome, Date dtIncRsrcFrom,
                                      Date dtIncRsrcTo, String indIncRsrcNotAccess, String sdsIncRrcsSource,
                                      String sdsIncRsrcVerfMethod, String txtIncRsrcDesc) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO INCOME_AND_RESOURCES " +
                                                 "       (ID_INC_RSRC," +
                                                 "        ID_INC_RSRC_WORKER," +
                                                 "        ID_PERSON," +
                                                 "        DT_LAST_UPDATE," +
                                                 "        AMT_INC_RSRC," +
                                                 "        CD_INC_RSRC_TYPE," +
                                                 "        CD_INC_RSRC_INCOME," +
                                                 "        DT_INC_RSRC_FROM," +
                                                 "        DT_INC_RSRC_TO," +
                                                 "        IND_INC_RSRC_NOT_ACCESS," +
                                                 "        SDS_INC_RSRC_SOURCE," +
                                                 "        SDS_INC_RSRC_VERF_METHOD," +
                                                 "        TXT_INC_RSRC_DESC)" +
                                                 " VALUES " +
                                                 "       (SEQ_INCOME_AND_RESOURCES.NEXTVAL, " +
                                                 "        :idIncRsrcWorker," +
                                                 "        :idPerson," +
                                                 "        :dtLastUpdate," +
                                                 "        :amtIncRsrc," +
                                                 "        :cdIncRsrcType," +
                                                 "        :cdIncRsrcIncome," +
                                                 "        :dtIncRsrcFrom," +
                                                 "        :dtIncRsrcTo," +
                                                 "        :indIncRsrcNotAccess," +
                                                 "        :sdsIncRrcsSource," +
                                                 "        :sdsIncRsrcVerfMethod," +
                                                 "        :txtIncRsrcDesc)");

    query.setInteger("idIncRsrcWorker", idIncRsrcWorker);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setDouble("amtIncRsrc", amtIncRsrc);
    query.setString("cdIncRsrcType", cdIncRsrcType);
    query.setString("cdIncRsrcIncome", cdIncRsrcIncome);
    query.setTimestamp("dtIncRsrcFrom", dtIncRsrcFrom);
    query.setTimestamp("dtIncRsrcTo", dtIncRsrcTo);
    query.setString("indIncRsrcNotAccess", indIncRsrcNotAccess);
    query.setString("sdsIncRrcsSource", sdsIncRrcsSource);
    query.setString("sdsIncRsrcVerfMethod", sdsIncRsrcVerfMethod);
    query.setString("txtIncRsrcDesc", txtIncRsrcDesc);

    return query.executeUpdate();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Map> findIncomeAndResourcesByIdPerson(int idPerson, Date currentMonthStartDate, Date currentMonthEndDate) {
    Query query = getSession().createQuery("   select new map ( i.idIncRsrc as idIncRsrc, " +
                                           "                   i.personByIdPerson.idPerson as idPerson, " +
                                           "                   i.dtLastUpdate as dtLastUpdate, " +
                                           "                   i.amtIncRsrc as amtIncRsrc, " +
                                           "                   i.cdIncRsrcType as cdIncRsrcType, " +
                                           "                   i.indIncRsrcNotAccess as indIncRsrcNotAccess, " +
                                           "                   i.sdsIncRsrcSource as sdsIncRsrcSource, " +
                                           "                   i.sdsIncRsrcVerfMethod as sdsIncRsrcVerfMethod, " +
                                           "                   i.cdIncRsrcIncome as cdIncRsrcIncome, " +
                                           "                   p.nmPersonFull as nmPersonFull ) " +
                                           "     from IncomeAndResources i, " +
                                           "          Person p " +
                                           "    where i.personByIdPerson.idPerson =  :idPerson " +
                                           "      and i.personByIdPerson.idPerson = p.idPerson " +
                                           "      and i.dtIncRsrcFrom < :currentMonthEndDate " +
                                           "      and i.dtIncRsrcTo >= :currentMonthStartDate ");

    query.setInteger("idPerson", idPerson);
    query.setDate("currentMonthStartDate", currentMonthStartDate);
    query.setDate("currentMonthEndDate", currentMonthEndDate);
    return (List<Map>) query.list();
  }
  
  //STGAP00010749 : Gets the income and resources records for the given person
  @SuppressWarnings("unchecked")
  public List<IncomeAndResources> findByIdPerson(int idPerson) {
    Query query = getSession().createQuery(" from IncomeAndResources i " +
                                           "where i.personByIdPerson.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (List<IncomeAndResources>) query.list();
  }
  
  // SMS #109403: MR-082
  /*
   * This method is used for finding the most recent Income from the INCOME_AND_RESOURCES table as of the current date
   * by idPerson and cdIncRsrcType
   */
  @SuppressWarnings("unchecked")
  public IncomeAndResources findMostRecentIncomeAsOfTodayByIdPersonByCdIncRsrcType(int idPerson, String cdIncRsrcType,
                                                                                   Date dtCurrentDate) {
    Query query = getSession().createQuery(
                                           " from IncomeAndResources i "
                                                           + " where i.personByIdPerson.idPerson = :idPerson "
                                                           + " and i.cdIncRsrcType = :cdIncRsrcType "
                                                           + " and (i.dtIncRsrcTo >= :dtCurrentDate "
                                                           + " or i.dtIncRsrcTo = :maxDate) "
                                                           + " order by i.dtIncRsrcFrom desc");
    query.setInteger("idPerson", idPerson);
    query.setString("cdIncRsrcType", cdIncRsrcType);
    query.setTimestamp("dtCurrentDate", dtCurrentDate);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (IncomeAndResources) firstResult(query);
  }
}