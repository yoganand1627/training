package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/*** Change History:
  **  Date        User              Description
  **  --------    ----------------  --------------------------------------------------
  **  04/01/2008  Corey Harden      STGAP00006396: made new method updateNmNamefstMddlLast() 
  *                                 to update the first, middle and last name in the name table
  *                                 
  *   12/31/2008  SSUBRAM           STGAP00011764: Added Null check to the SQL for CD Person Status.    
  *   
  *   2/16/2009   CWells            STGAP00006688 Removing updateNmNamefstMddlLast(method has too much logic for 
  *                                 a simple DAO.  Remove all code calling it as well.                     
  **/
  
public class NameDAOImpl extends BaseDAOImpl implements NameDAO {
  
  @SuppressWarnings({"unchecked"})
  /*
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   */
  public Object[] findDistinctNameByIdPersonAndRelPA(int idPerson) {
    SQLQuery query = getSession().createSQLQuery(" SELECT n.nm_name_first, "
            + "n.nm_name_last, "
            + "n.nm_name_middle, "
            + "n.ind_name_primary, "
            + "n.dt_name_start_date, "
            + "n.dt_name_end_date FROM "
            + "NAME n, STAGE_PERSON_LINK spl " 
            + "WHERE "
            + "n.id_person = spl.id_person AND "
            + "n.id_person = :idPerson AND "
            + "(spl.cd_stage_pers_rel_int = 'PA' OR spl.cd_stage_pers_rel_int = 'AP') "
            + "ORDER BY n.dt_name_end_date DESC, "
            + "n.ind_name_primary DESC, "
            + "n.dt_name_start_date DESC");
    query.setInteger("idPerson", idPerson);
    return (Object[]) firstResult(query);  
  }
  
  @SuppressWarnings({"unchecked"})
  /*
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   */
  public Name findDistinctNameByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
            " from Name a " 
            + "where " 
            + "a.person.idPerson = :idPerson and "
            + "a.indNamePrimary = 'Y' and "
            + "a.indNameInvalid = 'N' and "
            + "(a.dtNameEndDate = '12/31/4712' or a.dtNameEndDate IS NULL) "
            + "order by a.dtNameEndDate desc, "
            + "a.indNamePrimary desc, "
            + "a.dtNameStartDate desc");
    query.setInteger("idPerson", idPerson);
    return (Name) firstResult(query);
  }
  
  public Name findNameByPersonPrimary(int idPerson) {
    Query query = getSession().createQuery(" from Name " +
                                           "where person.idPerson = :idPerson " +
                                           "  and indNamePrimary = 'Y' " +
                                           "  and dtNameEndDate = :dtDateMax");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtDateMax", DateHelper.MAX_JAVA_DATE);
    return (Name) firstResult(query);
  }

  public Map findNameFromNameAndPhoneticNameByIdPerson(int idPerson) {

    Query query = getSession().createQuery(" select new map(a.person.idPerson as idPerson , " +
                                           "                a.cdNameSuffix as cdNameSuffix, " +
                                           "                a.dtNameEndDate as dtNameEndDate, " +
                                           "                a.dtNameStartDate as dtNameStartDate, " +
                                           "                a.idName as idName, " +
                                           "                a.indNameInvalid as indNameInvalid, " +
                                           "                a.indNamePrimary as indNamePrimary, " +
                                           "                a.nmNameFirst as nmNameFirst, " +
                                           "                a.nmNameLast as nmNameLast, " +
                                           "                a.nmNameMiddle as nmNameMiddle, " +
                                           //"                b.nmPhkName as nmPhkName, " +
                                           "                a.dtLastUpdate as dtLastUpdate)" +
                                           "   from Name a  " +
                                           //"        PhoneticName b " +
                                           "  where a.person.idPerson = :idPerson " +
                                           "    and a.indNamePrimary = '" + ArchitectureConstants.Y + "' " +
                                           "    and (a.dtNameEndDate = :maxDate or a.dtNameEndDate is null) ");
    //"    and a.idName = b.idPhkNameKey " +
    //"    and b.cdPhkNameType = '" +   CodesTables.CPHKNTYP_NA + "' ");

    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    query.setInteger("idPerson", idPerson);
    return (Map) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Name> findNameByIdStage(int idStage) {
    Session session = getSession();
    Query query = session.createQuery(" select n " + "   from Name n ," + "        StagePersonLink s ,"
                                      + "        IncomingDetail i " + "  where n.indNamePrimary <> :indYes "
                                      + "    and i.idStage = s.stage.idStage "
                                      + "    and n.dtNameStartDate <= nvl(i.dtIncomingCallDisposed, :dtMaxDate) "
                                      + "    and n.dtNameEndDate >= nvl(i.dtIncomingCallDisposed, :dtMaxDate) "
                                      + "    and n.person.idPerson = s.person.idPerson "
                                      + "    and s.stage.idStage = :idStage ");
    query.setString("indYes", ArchitectureConstants.Y);
    query.setInteger("idStage", idStage);
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Name>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public Name findNameByIdPersonDtSysTsQuery(int idPerson, Date dtSysTsQuery) {
    Session session = getSession();
    Query query = session.createQuery("   from Name n" + "  where n.person.idPerson = :idPerson"
                                      + "    and n.indNamePrimary = 'Y'" + "    and n.indNameInvalid != 'Y'"
                                      + "    and n.dtNameStartDate <= :dtSysTsQuery"
                                      + "    and (n.dtNameEndDate >= :dtSysTsQuery"
                                      + "         or n.dtNameEndDate is null) and rownum = 1");

    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtSysTsQuery", dtSysTsQuery);
    return (Name) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findPrimaryIdPersonsByFirstLastMiddle(String first, String last, String middle, 
                                                             String indSealed) {
    Session session = getSession();
    //STGAP00010705: filters out the Adopted Persons if the Sealed Indicator attribute of the user is N
    String adoString = (indSealed.equals(ArchitectureConstants.N))?" and (p.indAdopted <> 'Y' or p.indAdopted is null) ":"";
    String sql = "select n.person.idPerson " 
                 + " from Name n, Person p " //mxpatel added Person p
                 + " where n.person.idPerson = p.idPerson " //mxpatel added this statement
                 + "and n.nmNameFirst = :first "
                 + " and n.nmNameLast = :last "
                 + " and n.nmNameMiddle = :middle "
                 + adoString
                 + " and n.indNamePrimary = 'Y' "
                 + " and ( n.dtNameEndDate = :maxDate or n.dtNameEndDate is null) "
                 + " and ( p.cdPersonStatus <> 'M' or p.cdPersonStatus is null) "; //mxpatel added this statement
    Query query = session.createQuery(sql);
    query.setString("first", first);
    query.setString("last", last);
    query.setString("middle", middle);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findPrimaryIdPersonsByFirstLast(String first, String last, String indSealed) {
    Session session = getSession();
    //STGAP00010705: filters out the Adopted Persons if the Sealed Indicator attribute of the user is N
    String adoString = (indSealed.equals(ArchitectureConstants.N))?" and (p.indAdopted <> 'Y' or p.indAdopted is null) ":"";
    String sql = "select n.person.idPerson " 
                 + " from Name n, Person p " //mxpatel added Person p
                 + " where n.person.idPerson = p.idPerson "//mxpatel added this statement
                 +"  and n.nmNameFirst = :first "
                 + " and n.nmNameLast = :last "
                 + adoString
                 + " and n.indNamePrimary = 'Y' "
                 + " and ( n.dtNameEndDate = :maxDate or n.dtNameEndDate is null) "
                 + " and ( p.cdPersonStatus <> 'M' or p.cdPersonStatus is null) "; //mxpatel added this statement";

    Query query = session.createQuery(sql);
    query.setString("first", first);
    query.setString("last", last);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Integer>) query.list();

  }

  public long countNameIdName(int idPerson, Date dtSysTsQuery) {
    Query query = getSession().createQuery(
            " select count(n.idName) " + "   from Name n "
            + "  where n.person.idPerson = :idPerson "
            + "    and n.dtNameStartDate <= :dtSysTsQuery "
            + "    and (n.dtNameEndDate >= :dtSysTsQuery or n.dtNameEndDate is null)");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtSysTsQuery", dtSysTsQuery);
    return (Long) query.uniqueResult();
  }

  public long countNameIdNameByNmFull(String first, String mid, String last) {
    Query query = getSession().createQuery(
            " select count(n.idName) " + "   from Name n "
            + "  where n.nmNameFirst = :nmFirst "
            + "    and n.nmNameMiddle = :nmMiddle "
            + "    and n.nmNameLast = :nmLast ");
    query.setString("nmFirst", first);
    query.setString("nmMiddle", mid);
    query.setString("nmLast", last);
    return (Long) query.uniqueResult();
  }

  public Name findNameByIdPersonAndMaxDate(int idPerson, Date maxDate) {
    Query query = getSession().createQuery(
            "   from Name" + "  where person.idPerson = :idPerson"
            + "    and indNamePrimary = 'Y'"
            + "    and indNameInvalid != 'Y'"
            + "    and dtNameEndDate = :maxDate" + "    and rownum = 1");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", maxDate);
    return (Name) firstResult(query);
  }

  public long countIdNameByIdPersonAndMaxDate(int idPerson, Date maxDate) {
    Query query = getSession().createQuery(
            "select count(idName)" + "   from Name"
            + "  where person.idPerson = :idPerson"
            + "    and dtNameEndDate = :maxDate");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", maxDate);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings({"unchecked"})
  public List<Name> findNameByIdPersonAndDtNameStartDate(int idPerson, Date dtSysTsQuery) {
    Query query = getSession().createQuery(
            "     from Name a" + "    where a.person.idPerson = :idPerson"
            + "      and a.dtNameStartDate <= :tsSysTsQuery"
            + "      and (:tsSysTsQuery <= a.dtNameEndDate or a.dtNameEndDate is null)"
            + " order by a.dtNameEndDate desc,"
            + "          a.indNamePrimary desc,"
            + "          a.dtNameStartDate desc");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("tsSysTsQuery", dtSysTsQuery);
    return (List<Name>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Name> findNameByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
            "     from Name a" + "    where a.person.idPerson = :idPerson"
            + " order by a.dtNameEndDate desc,"
            + "          a.indNamePrimary desc,"
            + "          a.dtNameStartDate desc");
    query.setInteger("idPerson", idPerson);
    return (List<Name>) query.list();
  }

  public int insertName(int idPerson, String indNameInvalid, String nmNameFirst, String nmNameMiddle,
                        String nmNameLast, String indNamePrimary, String cdNameSuffix, Date dtDtNameStartDate) {
    Name name = new Name();
    Person person = (Person) getSession().load(Person.class, idPerson);
    name.setPerson(person);
    name.setIndNameInvalid(indNameInvalid);
    name.setNmNameFirst(nmNameFirst);
    name.setNmNameMiddle(nmNameMiddle);
    name.setNmNameLast(nmNameLast);
    name.setIndNamePrimary(indNamePrimary);
    name.setCdNameSuffix(cdNameSuffix);
    name.setDtNameStartDate(dtDtNameStartDate);
    getSession().saveOrUpdate(name);
    return name.getIdName();
  }

  public int updateName(int idName, Date dtDtNameEndDate, Date tsLastUpdate) {
    Query query = getSession().createQuery(
            "update Name" + " set dtNameEndDate = :dtDtNameEndDate"
            + " where idName = :idName"
            + " and dtLastUpdate = :tsLastUpdate");
    query.setTimestamp("dtDtNameEndDate", dtDtNameEndDate);
    query.setInteger("idName", idName);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    return query.executeUpdate();

  }
  
  public int updateNameNmNameLast(String nmNameLast, int idName, int idPerson) {

    Query query = getSession().createQuery(
            "update Name" + " set nmNameLast = :nmNameLast" + " where idName = :idName"
            + " and person.idPerson = :idPerson");
    query.setString("nmNameLast", nmNameLast);
    query.setInteger("idName", idName);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  public int insertName(String nmNameLast, int idPerson) {

    Name name = new Name();

    Person person = (Person) getSession().load(Person.class, idPerson);
    name.setPerson(person);

    name.setNmNameLast(nmNameLast);
    name.setIndNameInvalid("N");
    getSession().saveOrUpdate(name);
    return name.getIdName();
  }

  public int insertName(int idPerson, String nmNameFirst, String nmNameMiddle, String nmNameLast, String cdNameSuffix,
                        String indNamePrimary, String indNameInvalid, Date dtNameStartDate, Date dtNameEndDate) {
    Name name = new Name();
    name.setCdNameSuffix(cdNameSuffix);
    Person person = (Person) getSession().load(Person.class, idPerson);
    name.setPerson(person);
    name.setDtNameStartDate(dtNameStartDate);
    name.setDtNameEndDate(dtNameEndDate);
    name.setIndNameInvalid(indNameInvalid);
    name.setIndNamePrimary(indNamePrimary);
    name.setNmNameFirst(nmNameFirst);
    name.setNmNameLast(nmNameLast);
    name.setNmNameMiddle(nmNameMiddle);
    getSession().saveOrUpdate(name);
    return name.getIdName();
  }

  public int insertName(String cdNameSuffix, Date dtNameEndDate, int idName, int idPerson, String indNameInvalid,
                        String indNamePrimary, String nmNameFirst, String nmNameLast, String nmNameMiddle) {
    Name name = new Name();
    name.setCdNameSuffix(cdNameSuffix);
    Person person = (Person) getSession().load(Person.class, idPerson);
    name.setPerson(person);
    name.setDtNameEndDate(dtNameEndDate);
    name.setIndNameInvalid(indNameInvalid);
    name.setIndNamePrimary(indNamePrimary);
    name.setNmNameFirst(nmNameFirst);
    name.setNmNameLast(nmNameLast);
    name.setNmNameMiddle(nmNameMiddle);
    name.setIdName(idName);
    getSession().saveOrUpdate(name);
    return name.getIdName();
  }

  public int insertName(String cdNameSuffix, int idName, int idPerson, String indNameInvalid, String indNamePrimary,
                        String nmNameFirst, String nmNameLast, String nmNameMiddle) {
    Name name = new Name();
    name.setCdNameSuffix(cdNameSuffix);
    Person person = (Person) getSession().load(Person.class, idPerson);
    name.setPerson(person);
    name.setDtNameStartDate(new GregorianCalendar().getTime());
    name.setDtNameEndDate(new GregorianCalendar().getTime());
    name.setIndNameInvalid(indNameInvalid);
    name.setIndNamePrimary(indNamePrimary);
    name.setNmNameFirst(nmNameFirst);
    name.setNmNameLast(nmNameLast);
    name.setNmNameMiddle(nmNameMiddle);
    name.setIdName(idName);
    getSession().saveOrUpdate(name);
    return name.getIdName();
  }
  
  
 
  public Date findNameDtNameEndDateByIdName(int idName) {
    Session session = getSession();
    Query query = session.createQuery("select dtNameEndDate " + "  from Name " + " where idName = :idName ");
    query.setInteger("idName", idName);
    return (Date) firstResult(query);
  }

  public int updateNameIncludingDtNameEndDate(String cdNameSuffix, int idPerson, String indNameInvalid,
                                              String indNamePrimary, String nmNameFirst, String nmNameLast,
                                              String nmNameMiddle, int idName, Date lastUpdate) {
    Query query = getSession().createQuery(
            " update Name " + "    set cdNameSuffix = :cdNameSuffix, "
            + "        dtNameEndDate = sysdate, "
            + "        person.idPerson = :idPerson, "
            + "        indNameInvalid = :indNameInvalid, "
            + "        indNamePrimary = :indNamePrimary, "
            + "        nmNameFirst = :nmNameFirst, "
            + "        nmNameLast = :nmNameLast, "
            + "        nmNameMiddle = :nmNameMiddle "
            + "  where idName = :idName "
            + "    and dtLastUpdate <= :lastUpdate ");
    query.setString("cdNameSuffix", cdNameSuffix);
    query.setInteger("idPerson", idPerson);
    query.setString("indNameInvalid", indNameInvalid);
    query.setString("indNamePrimary", indNamePrimary);
    query.setString("nmNameFirst", nmNameFirst);
    query.setString("nmNameLast", nmNameLast);
    query.setString("nmNameMiddle", nmNameMiddle);
    query.setInteger("idName", idName);
    query.setTimestamp("lastUpdate", lastUpdate);
    return query.executeUpdate();
  }

  public int updateName(String cdNameSuffix, int idPerson, String indNameInvalid, String indNamePrimary,
                        String nmNameFirst, String nmNameLast, String nmNameMiddle, int idName, Date lastUpdate) {

    Query query = getSession().createQuery(
            " update Name " + "    set cdNameSuffix = :cdNameSuffix, "
            + "        person.idPerson = :idPerson, "
            + "        indNameInvalid = :indNameInvalid, "
            + "        indNamePrimary = :indNamePrimary, "
            + "        nmNameFirst = :nmNameFirst, "
            + "        nmNameLast = :nmNameLast, "
            + "        nmNameMiddle = :nmNameMiddle "
            + "  where idName = :idName "
            + "    and dtLastUpdate <= :lastUpdate ");
    query.setString("cdNameSuffix", cdNameSuffix);
    query.setInteger("idPerson", idPerson);
    query.setString("indNameInvalid", indNameInvalid);
    query.setString("indNamePrimary", indNamePrimary);
    query.setString("nmNameFirst", nmNameFirst);
    query.setString("nmNameLast", nmNameLast);
    query.setString("nmNameMiddle", nmNameMiddle);
    query.setInteger("idName", idName);
    query.setTimestamp("lastUpdate", lastUpdate);
    return query.executeUpdate();
//    Name name = new Name();
//    name.setCdNameSuffix(cdNameSuffix);
//    Person person = (Person) getSession().load(Person.class, idPerson);
//    name.setPerson(person);
//    name.setIndNameInvalid(indNameInvalid);
//    name.setIndNamePrimary(indNamePrimary);
//    name.setNmNameFirst(nmNameFirst);
//    name.setNmNameLast(nmNameLast);
//    name.setNmNameMiddle(nmNameMiddle);
//    name.setIdName(idName);
//    name.setDtLastUpdate('11/21/2006 1:44:25 PM');
//    getSession().saveOrUpdate(name);
//    return name.getIdName();

    // rc = ARC_SSAPhoneticKeysAUD(pSQLCA, // REQ_FUNC_CD_UPDATE, // pInputDataRec->szNmNameFirst,
    // pInputDataRec->szNmNameMiddle, // pInputDataRec->szNmNameLast, // ARC_SSA_NAME,
    // pInputDataRec->bIndNamePrimary, // pInputDataRec->bIndNameInvalid, // dtEndDate,
    // pInputDataRec->ulIdName, // pInputDataRec->ulIdPerson);
  }

  public int deleteName(int idName, Date dtLastUpdate) {
    Query query = getSession().createQuery(
            "delete Name " + " where idName = :idName "
            + "   and dtLastUpdate = :dtLastUpdate");
    query.setParameter("idName", idName);
    query.setParameter("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public long countNameIdNameByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
            "select count(idName)" + "   from Name"
            + "  where person.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }
  
  //STGAP00010749 : Save or update a Name record
  public int saveOrUpdateName(Name name) {
    getSession().saveOrUpdate(name);
    return name.getIdName();
  }
}
