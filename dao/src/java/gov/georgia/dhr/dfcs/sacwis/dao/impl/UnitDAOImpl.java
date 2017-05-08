package gov.georgia.dhr.dfcs.sacwis.dao.impl;
//*--------------------------------------------------------------------------------
//*  DAO Impl Name:     UnitDAOImpl
//*
//*  Description:
//*  This DAO Implementation persists and retrieves data in & out from Unit table.
//*
//*  Change History:
//*  Date      User       Description
//*  --------  ---------- ---------------------------------------------------------
//*  04/19/08  ssubram   - Added new method findParentIdPersonByIdPerson
//*  06/11/09  cwells    -  Added new Method findSuperiorUnitByIdStageAndIdPerson(int, int)
//*--------------------------------------------------------------------------------
import java.math.BigDecimal;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class UnitDAOImpl extends BaseDAOImpl implements UnitDAO {
  public Unit findUnit(int idPerson, String cdUnitSpecialization) {
    Query query = getSession().createQuery("from Unit u " +
                                           "where u.person.idPerson = :idPerson " +
                                           "and u.cdUnitSpecialization = :cdUnitSpecialization");
    query.setInteger("idPerson", idPerson);
    query.setString("cdUnitSpecialization", cdUnitSpecialization);
    return (Unit) firstResult(query);
  }

  public Map findUnitByCdCountyCdUnitRegionNbrUnit(String cdCounty, String cdUnitRegion, String nbrUnit) {
    Query query = getSession().createQuery(" select new map(b.person.idPerson as idPerson, " +
                                           "                b.person.nmPersonFull as nmPersonFull) " +
                                           "   from Unit b " +
                                           "  where b.cdCounty = :cdCounty " +
                                           "    and b.cdUnitRegion = :cdUnitRegion " +
                                           "    and b.nbrUnit = :nbrUnit ");

    query.setString("cdCounty", cdCounty);
    query.setString("cdUnitRegion", cdUnitRegion);
    query.setString("nbrUnit", nbrUnit);
    return (Map) firstResult(query);
  }

  public Unit findUnitByIdUnit(int idUnit) {
    Session session = getSession();
    Query query = session.createQuery(" from Unit " +
                                      "where idUnit = :idUnit ");
    query.setInteger("idUnit", idUnit);
    return (Unit) firstResult(query);
  }

  public Unit findUnitFullRowByCdUnitProgramCdUnitRegionNbrUnit(String cdUnitProgram, String cdUnitRegion,
                                                                String cdUnitCounty, String nbrUnit) {
    Session session = getSession();
    Query query = session.createQuery("   from Unit u " +
                                      "  where u.cdUnitProgram = :cdUnitProgram " +
                                      "    and u.cdUnitRegion = :cdUnitRegion " +
                                      "    and u.cdCounty = :cdUnitCounty " +
                                      "    and u.nbrUnit = :nbrUnit ");
    query.setString("cdUnitProgram", cdUnitProgram);
    query.setString("cdUnitRegion", cdUnitRegion);
    query.setString("cdUnitCounty", cdUnitCounty);
    query.setString("nbrUnit", nbrUnit);
    return (Unit) firstResult(query);
  }
  
  public Unit findUnitFullRowByCdCountyCdUnitRegionNbrUnit(String cdCounty, String cdUnitRegion,
                                                           String nbrUnit) {
    Session session = getSession();
    Query query = session.createQuery("   from Unit u " +
                                      "  where u.cdCounty = :cdCounty " +
                                      "    and u.cdUnitRegion = :cdUnitRegion " +
                                      "    and u.nbrUnit = :nbrUnit ");
    query.setString("cdCounty", cdCounty);
    query.setString("cdUnitRegion", cdUnitRegion);
    query.setString("nbrUnit", nbrUnit);
    return (Unit) firstResult(query);
  }
  
  public Unit findUnitFullRowByCdCountyNbrUnit(String cdCounty, String nbrUnit) {
    Session session = getSession();
    Query query = session.createQuery("   from Unit u " +
                                      "  where u.cdCounty = :cdCounty " +
                                      "    and u.nbrUnit = :nbrUnit ");
    query.setString("cdCounty", cdCounty);
    query.setString("nbrUnit", nbrUnit);
    return (Unit) firstResult(query);
  }

  public Unit findUnitByIdPerson(int idPerson) {
    Session session = getSession();
    Query query = session.createQuery("   from Unit u " +
                                      "  where u.person.idPerson = :idPerson ");

//    Query query = session.createQuery(" select u.idUnit " +
//                                      "   from Unit u " +
//                                      "  where u.person.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    return (Unit) firstResult(query);
  }

  public Unit findUnitFromUnitAndParentUnitByIdUnit(int idUnit) {
    Query query = getSession().createQuery("            from Unit u  " +
                                           " left join fetch u.unit n " +
                                           "           where u.idUnit = :idUnit ");
    query.setInteger("idUnit", idUnit);
    return (Unit) firstResult(query);
  }

  public void saveUnit(Unit unit) {
    getSession().saveOrUpdate(unit);
  }

  public int updateUnitIDUnitParent(int idUnit) {
    Query query = getSession().createQuery("update Unit" +
                                           "    set unit.idUnit = null" +
                                           "  where unit.idUnit = :idUnit");
    query.setInteger("idUnit", idUnit);
    return query.executeUpdate();
  }

  public int updateUnitIdPerson(int idPerson, String cdUnitMemberInOut) {
    Query query = getSession().createQuery("update Unit a" +
                                           "    set a.person.idPerson = null" +
                                           "  where a.idUnit in (select b.unit.idUnit" +
                                           "                   from UnitEmpLink b" +
                                           "                  where a.person.idPerson = :idPerson" +
                                           "                    and b.cdUnitMemberInOut = :cdUnitMemberInOut" +
                                           "                    and a.person.idPerson = b.person.idPerson)");
    query.setInteger("idPerson", idPerson);
    query.setString("cdUnitMemberInOut", cdUnitMemberInOut);
    return query.executeUpdate();
  }

  public void deleteUnit(Unit unit) {
    getSession().delete(unit);
  }

  public Unit findUnitFromUnitAndPersonByCdCountyCdUnitRegionNbrUnit(String cdCounty,
                                                                  String cdUnitRegion, String nbrUnit){

    Query query = getSession().createQuery("      from Unit u " +
                                           "join fetch u.person " +
                                           "       where u.cdUnitRegion = :cdUnitRegion " +
                                           "       and u.nbrUnit = :nbrUnit " +
                                           "       and u.cdCounty = :cdCounty ");

    query.setString("cdCounty", cdCounty);
    query.setString("cdUnitRegion", cdUnitRegion);
    query.setString("nbrUnit", nbrUnit);
    return (Unit) firstResult(query);
  }
  
  public Integer findIdUnitFromUnitByCdStageCntyAndCdSpecialization(String cdCounty){
    Query query = getSession().createQuery(" select u.idUnit"
                                           + " from Unit u "
                                           + " where u.cdCounty = :cdCounty"
                                           + " and u.cdUnitSpecialization = 'EFC'");
                                          
    query.setString("cdCounty", cdCounty);
    return (Integer) firstResult(query);
  }
  
  public Integer findIdUnitFromUnitByCdStageRegionAndCdSpecialization(String cdUnitRegion){
    Query query = getSession().createQuery(" select u.idUnit"
                                           + " from Unit u "
                                           + " where u.cdUnitRegion = :cdUnitRegion"
                                           + " and u.cdUnitSpecialization = 'EFC'");
                                          
    query.setString("cdUnitRegion", cdUnitRegion);
    return (Integer) firstResult(query);
  }
  @SuppressWarnings( { "unchecked" })
  public List<Map> findParentUnitByIdPerson(Integer idPerson){
    Query query = getSession().createQuery (" select new map( u1.idUnit as idUnit "
                                            +"              , u1.nbrUnit as nbrUnit "
                                            +"              , u1.person.idPerson as idPerson "
                                            +"              , u1.unit.idUnit as idParentUnit "
                                            +"              , u2.nbrUnit as nbrParentUnit "
                                            +"              , u2.person.idPerson as idParentPerson) "
                                            +" from Unit u1, Unit u2, Unit u3 "
                                            +" where u1.unit.idUnit = u2.idUnit " 
                                            +" and u1.cdCounty = u3.cdCounty  "
                                            +" and (u1.idUnit = u3.unit.idUnit "
                                            +" or u1.idUnit = u3.idUnit) "
                                            +" and u3.person.idPerson = :idPerson "
                                            +" order by u1.nbrUnit desc ");
    query.setInteger("idPerson",idPerson);
    return (List<Map>) query.list();
  }
  @SuppressWarnings("unchecked")
  public List<Integer> findSuperiorUnitByIdStageAndIdPerson(int idStage, int idPerson){
      SQLQuery query = getSession()
                                   .createSQLQuery(
  " SELECT U.ID_UNIT\n" +
  "FROM UNIT U\n" +
  "START WITH U.ID_UNIT IN (SELECT ID_UNIT_PARENT FROM UNIT WHERE ID_UNIT IN (SELECT UEL.ID_UNIT FROM UNIT_EMP_LINK UEL\n" + 
  "                                                    WHERE UEL.ID_PERSON IN (SELECT SPL.ID_PERSON\n" + 
  "                                                                            FROM STAGE_PERSON_LINK SPL\n" + 
  "                                                                           WHERE SPL.ID_STAGE = :idStage\n" + 
  "                                                                           AND SPL.CD_STAGE_PERS_ROLE = 'HP')\n" + 
  "                                                    AND UEL.CD_UNIT_MEMBER_IN_OUT IN('IN','OUT')))\n" + 
  "CONNECT BY (PRIOR U.ID_UNIT_PARENT  = U.ID_UNIT\n" + 
  "             AND U.ID_UNIT <> U.ID_UNIT_PARENT\n" +
  "             AND U.CD_COUNTY <> 'XXX'\n" + 
  "             AND PRIOR U.CD_COUNTY = U.CD_COUNTY)\n" + 
  "INTERSECT\n" + 
  "SELECT U.ID_UNIT\n" + 
  "FROM UNIT U, UNIT_EMP_LINK UEL\n" + 
  "WHERE UEL.ID_PERSON = :idPerson\n" +
  "AND UEL.CD_UNIT_MEMBER_IN_OUT IN ('IN','OUT')\n" + //WAS ='IN'
  "AND U.ID_UNIT =  UEL.ID_UNIT\n");
  
  query.setInteger("idStage", idStage);
  query.setInteger("idPerson", idPerson);
  return (List) query.list();
  }
  
  public Unit findUnitByCdCountyAndCdUnitSpecialization(String cdCounty,String cdSpecialization){
    Query query = getSession().createQuery("      from Unit u " +
                                           "       where u.cdUnitSpecialization = :cdSpecialization " +
                                           "       and u.cdCounty = :cdCounty ");

    query.setString("cdCounty", cdCounty);
    query.setString("cdSpecialization", cdSpecialization);
    return (Unit) firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Unit> findUnitByCdRegionAndCdUnitSpecialization(String cdRegion,String cdSpecialization){
    Query query = getSession().createQuery("   from Unit u " +
                                           "       where u.cdUnitSpecialization = :cdSpecialization " +
                                           "       and u.cdUnitRegion = :cdRegion ");

    query.setString("cdRegion", cdRegion);
    query.setString("cdSpecialization", cdSpecialization);
    return (List) query.list();
  }
  @SuppressWarnings({"unchecked"})
  public List<Unit> findUnitByCdUnitSpecialization(String cdSpecialization){
    Query query = getSession().createQuery("   from Unit u " +
                                           "       where u.cdUnitSpecialization = :cdSpecialization ");

    query.setString("cdSpecialization", cdSpecialization);
    return (List) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<Unit> findChildUnitsByIdUnitParent(int idUnitParent) {
    Query query = getSession().createQuery(" from Unit u " +
                                           "where u.unit.idUnit = :idUnitParent");
    query.setInteger("idUnitParent", idUnitParent);
    return (List<Unit>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<Unit> findChildUnitsByIdUnitParentOrdered(int idUnitParent) {
    Query query = getSession().createQuery(" from Unit u " +
                                           "where u.unit.idUnit = :idUnitParent " +
                                           "order by u.nbrUnit asc");
    query.setInteger("idUnitParent", idUnitParent);
    return (List<Unit>) query.list();
  }

}
