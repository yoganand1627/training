package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------
 *   06/09/2011  Corey Harden      SMS#109631 Added method findAllCpsInvstDetailByIdResource(int idResource)  
 *   10/07/2011  Courtney Wells    SMS# 172674 Added method findCpsInvstDetailByIdCase              
 *                                 
 **/


public class CpsInvstDetailDAOImpl extends BaseDAOImpl implements CpsInvstDetailDAO {
  @SuppressWarnings("unchecked")
  public List<Map> findAllCpsInvstDetailByIdResource(int idResource){
    Query query = getSession().createQuery(
                                           "select new map(s.capsCase.idCase as idCase, s.capsCase.nmCase as nmCase, c.cdCpsInvstDtlOvrllDisptn as overallDisptn, " +
                                           "c.cdCnclsnRiskFnd as cdCnclsnRiskFnd, c.indInvMaltreatInCare as indInvMaltreatInCare, " +
                                           "c.stage.idStage as idStage) from CpsInvstDetail c, IncomingFacility i, Stage s " +
                                           " where c.stage.idStage = i.idStage and i.idStage = s.idStage " +
                                           " and i.capsResource.idResource = :idResource ");

    query.setInteger("idResource", idResource);
    return query.list();
  }
  
  public CpsInvstDetail findCpsInvstDetailByIdStage(int IdCpsInvstStage) {
    Query query = getSession().createQuery(" from CpsInvstDetail " +
                                           "where stage.idStage = :IdCpsInvstStage " +
                                           "  and indCpsInvstDtlEaConcl = 'y'");

    query.setInteger("IdCpsInvstStage", IdCpsInvstStage);
    return (CpsInvstDetail) firstResult(query);
  }
  
  public CpsInvstDetail findCpsInvstDetailByIdCase(int IdCpsInvstCase) {
	    Query query = getSession().createQuery(" from CpsInvstDetail " +
	                                           "where capsCase.idCase = :IdCpsInvstCase " +
	                                           "  and indCpsInvstDtlEaConcl = 'y'" +
        									   " order by dtLastUpdate");

	    query.setInteger("IdCpsInvstCase", IdCpsInvstCase);
	    return (CpsInvstDetail) firstResult(query);
	  }
  
  public CpsInvstDetail findCpsInvstDetailByIdCaseOnly(int IdCpsInvstCase) {
	    Query query = getSession().createQuery(" from CpsInvstDetail " +
	                                           "where capsCase.idCase = :IdCpsInvstCase " +
      									   " order by dtLastUpdate desc");

	    query.setInteger("IdCpsInvstCase", IdCpsInvstCase);
	    return (CpsInvstDetail) firstResult(query);
	  }


  public CpsInvstDetail findCpsInvstDetailByIdStageOnly(int idStage) {
    Query query = getSession().createQuery(" from CpsInvstDetail " +
                                           "where stage.idStage=:idStage");
    query.setInteger("idStage", idStage);
    return (CpsInvstDetail) firstResult(query);
  }
  
  
  public String findFinalDispositionByIdStage(int idStage) {
    Query query = getSession().createQuery("select cid.cdCpsInvstDtlOvrllDisptn from CpsInvstDetail cid  " +
                                           " where cid.stage.idStage=:idStage " +
                                           " order by cid.idEvent desc");
    query.setInteger("idStage", idStage);
    return (String) firstResult(query);
  }

  public CpsInvstDetail findCpsInvstDetailByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" from CpsInvstDetail c " +
                                           "where c.idEvent=:idEvent ");
    query.setInteger("idEvent", idEvent);
    return (CpsInvstDetail) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findCpsInvstDetailIdCase(int idCase0, int idCase1, int idCase2, int idCase3, int idCase4,
                                                int idCase5, int idCase6, int idCase7, int idCase8, int idCase9,
                                                int idCase10, int idCase11, int idCase12, int idCase13, int idCase14,
                                                int idCase15, int idCase16, int idCase17, int idCase18, int idCase19,
                                                int idCase20, int idCase21, int idCase22, int idCase23, int idCase24,
                                                int idCase25, int idCase26, int idCase27, int idCase28, int idCase29,
                                                int idCase30, int idCase31, int idCase32, int idCase33, int idCase34,
                                                int idCase35, int idCase36, int idCase37, int idCase38, int idCase39,
                                                int idCase40, int idCase41, int idCase42, int idCase43, int idCase44,
                                                int idCase45, int idCase46, int idCase47, int idCase48, int idCase49) {
    Query query = getSession().createQuery(" select distinct capsCase.idCase" +
                                           "   from CpsInvstDetail" +
                                           "  where capsCase.idCase in (" +
                                           ":idCase0, :idCase1, :idCase2, :idCase3, :idCase4, :idCase5, :idCase6," +
                                           ":idCase7, :idCase8, :idCase9, :idCase10, :idCase11, :idCase12, :idCase13," +
                                           ":idCase14, :idCase15, :idCase16, :idCase17, :idCase18, :idCase19, :idCase20," +
                                           ":idCase21, :idCase22, :idCase23, :idCase24, :idCase25, :idCase26, :idCase27," +
                                           ":idCase28, :idCase29, :idCase30, :idCase31, :idCase32, :idCase33, :idCase34," +
                                           ":idCase35, :idCase36, :idCase37, :idCase38, :idCase39, :idCase40, :idCase41," +
                                           ":idCase42, :idCase43, :idCase44, :idCase45, :idCase46, :idCase47, :idCase48," +
                                           ":idCase49)" +
                                           "    and (cdCpsInvstDtlOvrllDisptn = 'mov'" +
                                           "          or cdCpsInvstDtlOvrllDisptn = 'utc')");
    query.setInteger("idCase0", idCase0);
    query.setInteger("idCase1", idCase1);
    query.setInteger("idCase2", idCase2);
    query.setInteger("idCase3", idCase3);
    query.setInteger("idCase4", idCase4);
    query.setInteger("idCase5", idCase5);
    query.setInteger("idCase6", idCase6);
    query.setInteger("idCase7", idCase7);
    query.setInteger("idCase8", idCase8);
    query.setInteger("idCase9", idCase9);
    query.setInteger("idCase10", idCase10);
    query.setInteger("idCase11", idCase11);
    query.setInteger("idCase12", idCase12);
    query.setInteger("idCase13", idCase13);
    query.setInteger("idCase14", idCase14);
    query.setInteger("idCase15", idCase15);
    query.setInteger("idCase16", idCase16);
    query.setInteger("idCase17", idCase17);
    query.setInteger("idCase18", idCase18);
    query.setInteger("idCase19", idCase19);
    query.setInteger("idCase20", idCase20);
    query.setInteger("idCase21", idCase21);
    query.setInteger("idCase22", idCase22);
    query.setInteger("idCase23", idCase23);
    query.setInteger("idCase24", idCase24);
    query.setInteger("idCase25", idCase25);
    query.setInteger("idCase26", idCase26);
    query.setInteger("idCase27", idCase27);
    query.setInteger("idCase28", idCase28);
    query.setInteger("idCase29", idCase29);
    query.setInteger("idCase30", idCase30);
    query.setInteger("idCase31", idCase31);
    query.setInteger("idCase32", idCase32);
    query.setInteger("idCase33", idCase33);
    query.setInteger("idCase34", idCase34);
    query.setInteger("idCase35", idCase35);
    query.setInteger("idCase36", idCase36);
    query.setInteger("idCase37", idCase37);
    query.setInteger("idCase38", idCase38);
    query.setInteger("idCase39", idCase39);
    query.setInteger("idCase40", idCase40);
    query.setInteger("idCase41", idCase41);
    query.setInteger("idCase42", idCase42);
    query.setInteger("idCase43", idCase43);
    query.setInteger("idCase44", idCase44);
    query.setInteger("idCase45", idCase45);
    query.setInteger("idCase46", idCase46);
    query.setInteger("idCase47", idCase47);
    query.setInteger("idCase48", idCase48);
    query.setInteger("idCase49", idCase49);
    return (List<Integer>) query.list();
  }

  public int updateCpsInvstDetail(int idEvent, String cdCpsInvstDtlFamIncm,
                                  String cdCpsOverallDisptn, Date dtCPSInvstDtlAssigned,
                                  Date dtCPSInvstDtlBegun, Date dtCpsInvstDtlComplt,
                                  Date dtCPSInvstDtlIntake, String indCpsInvstEaConcl,
                                  String indCpsInvstSafetyPln, String indCpsInvstDtlRaNa,
                                  int idStage, Date tsLastUpdate) {
    Query query = getSession().createQuery("update CpsInvstDetail" +
                                           "    set cdCpsInvstDtlFamIncm = :cdCpsInvstDtlFamIncm," +
                                           "        cdCpsInvstDtlOvrllDisptn = :cdCpsOverallDisptn," +
                                           "        dtCpsInvstDtlAssigned = :dtCPSInvstDtlAssigned," +
                                           "        dtCpsInvstDtlBegun = :dtCPSInvstDtlBegun," +
                                           "        dtCpsInvstDtlComplt = :dtCpsInvstDtlComplt," +
                                           "        dtCpsInvstDtlIntake = :dtCPSInvstDtlIntake," +
                                           "        idEvent = :idEvent," +
                                           "        indCpsInvstDtlEaConcl = :indCpsInvstEaConcl," +
                                           "        indCpsInvstSafetyPln = :indCpsInvstSafetyPln," +
                                           "        indCpsInvstDtlRaNa = :indCpsInvstDtlRaNa," +
                                           "        indCpsInvstDtlAbbrv = null" +
                                           "  where stage.idStage = :idStage" +
                                           "    and dtLastUpdate = :tsLastUpdate");

    query.setInteger("idEvent", idEvent);
    query.setString("cdCpsInvstDtlFamIncm", cdCpsInvstDtlFamIncm);
    query.setString("cdCpsOverallDisptn", cdCpsOverallDisptn);
    query.setTimestamp("dtCPSInvstDtlAssigned", dtCPSInvstDtlAssigned);
    query.setTimestamp("dtCPSInvstDtlBegun", dtCPSInvstDtlBegun);
    query.setTimestamp("dtCpsInvstDtlComplt", dtCpsInvstDtlComplt);
    query.setTimestamp("dtCPSInvstDtlIntake", dtCPSInvstDtlIntake);
    query.setString("indCpsInvstEaConcl", indCpsInvstEaConcl);
    query.setString("indCpsInvstSafetyPln", indCpsInvstSafetyPln);
    query.setString("indCpsInvstDtlRaNa", indCpsInvstDtlRaNa);
    query.setInteger("idStage", idStage);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    return query.executeUpdate();
  }
  
  public void saveCpsInvstDetail(CpsInvstDetail cpsInvstDetail) {
    getSession().saveOrUpdate(cpsInvstDetail);
  }
}
