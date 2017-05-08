package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/*Change History:
 **  Date        User              Description
 **  --------    ----------------  ---------------------------------------------                                
 *   12/31/2008  charden           STGAP00009110: called encryption function on findDistinctIdPersonByCrsId
 *                                 and findDistinctIdPersonByCrsIdPadded methods to resolve code performance
 *                                 issues
 *   03/11/2009  hjbaptiste        STGAP00010763: in findDistinctIdPersonByCrsId() and findDistinctIdPersonByCrsIdPadded(),
 *                                 called the decrypt() function to decrypt the column nbr_person_id_number                            
 */   

public class PersonIdDAOImpl extends BaseDAOImpl implements PersonIdDAO {
  
  /*
   * This method is used for updating the INCOME_AND_RESOURCES table for 
   * Receive Child Support Payment Info Service
   */
  public Object[] findDistinctIdPersonByCrsId(String idPersonIdNumber) {
    SQLQuery query = getSession().createSQLQuery("SELECT pid.id_person, "
                                                 + "caps.decrypt(pid.nbr_person_id_number) "
                                                 + "FROM "
                                                 + "PERSON_ID_ENC pid "
                                                 + "WHERE "
                                                 + "pid.nbr_person_id_number = encrypt(:idPersonIdNumber) AND "
                                                 + "cd_person_id_type = 'CRS ID#' AND "
                                                 + "pid.ind_person_id_invalid = 'N' AND "
                                                 + "(pid.dt_person_id_end = '12/31/4712' OR pid.dt_person_id_end IS NULL) "
                                                 + "ORDER BY dt_last_update DESC");

    query.setString("idPersonIdNumber", idPersonIdNumber);
       
    return (Object[]) firstResult(query);
  }
  
  public Object[] findDistinctIdPersonByCrsIdPadded(String idPersonIdNumber, String idPersonIdNumberPadded) {
    SQLQuery query = getSession().createSQLQuery("SELECT pid.id_person, "
                                                 + "caps.decrypt(pid.nbr_person_id_number) "
                                                 + "FROM "
                                                 + "PERSON_ID_ENC pid "
                                                 + "WHERE "
                                                 + "(pid.nbr_person_id_number = encrypt(:idPersonIdNumber) "
                                                 + " or pid.nbr_person_id_number = encrypt(:idPersonIdNumberPadded)) AND "
                                                 + "cd_person_id_type = 'CRS ID#' AND "
                                                 + "pid.ind_person_id_invalid = 'N' AND "
                                                 + "(pid.dt_person_id_end = '12/31/4712' OR pid.dt_person_id_end IS NULL) "
                                                 + "ORDER BY dt_last_update DESC");

    query.setString("idPersonIdNumber", idPersonIdNumber);
    query.setString("idPersonIdNumberPadded", idPersonIdNumberPadded);
       
    return (Object[]) firstResult(query);
  }
  
  /*
   * This method is used for updating the CSUP_CHILDLEFTCARE_OUTBOUND table
   */
  public Object[] findDistinctChildCrsIdByIdPerson(int idPerson) {
    SQLQuery query = getSession().createSQLQuery("SELECT pid.id_person, "
                                                 + "pid.nbr_person_id_number "
                                                 + "FROM "
                                                 + "PERSON p, PERSON_ID pid, STAGE_PERSON_LINK spl "
                                                 + "WHERE "
                                                 + "p.id_person = pid.id_person AND "
                                                 + "p.id_person = spl.id_person AND "
                                                 + "pid.id_person = :idPerson AND "
                                                 + "pid.ind_person_id_invalid = 'N' AND "
                                                 + "(pid.dt_person_id_end = '12/31/4712' OR dt_person_id_end IS NULL) AND "
                                                 + "pid.cd_person_id_type  = 'CRS ID#'");

    query.setInteger("idPerson", idPerson);
    return (Object[]) firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  /*
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   */
  public Object[] findDistinctParentByStagePersRelId(int idPerson) {
    SQLQuery query = getSession().createSQLQuery("SELECT pid.id_person, pid.nbr_person_id_number "
                                                 + "FROM "
                                                 + "PERSON_ID pid, STAGE_PERSON_LINK spl "
                                                 + "WHERE "
                                                 + "pid.id_person = spl.id_person AND "
                                                 + "pid.id_person = :idPerson AND "
                                                 + "spl.cd_stage_pers_rel_int IN ('PA', 'AB', 'BF', 'BM', 'LM', 'LF', 'MP', 'PF', 'AP', 'PK')");

    query.setInteger("idPerson", idPerson);
    return (Object[]) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  /*
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   */
  public Object[] findDistinctParentNbrPersonIdCrsIdByIdPerson(int idPerson) {
    SQLQuery query = getSession().createSQLQuery("SELECT pid.id_person, "
                                                 + "pid.nbr_person_id_number "
                                                 + "FROM "
                                                 + "PERSON p, PERSON_ID pid, STAGE_PERSON_LINK spl "
                                                 + "WHERE "
                                                 + "p.id_person = pid.id_person AND "
                                                 + "p.id_person = spl.id_person AND "
                                                 + "pid.id_person = :idPerson AND "
                                                 + "pid.ind_person_id_invalid = 'N' AND "
                                                 + "(pid.dt_person_id_end = '12/31/4712' OR dt_person_id_end IS NULL) AND "
                                                 + "pid.cd_person_id_type  = 'CRS ID#'");

    query.setInteger("idPerson", idPerson);
    return (Object[]) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  /*
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   */
  public Object[] findDistinctParentNbrPersonIdSsnByIdPerson(int idPerson) {
    SQLQuery query = getSession().createSQLQuery("SELECT pid.id_person, "
                                                 + "pid.nbr_person_id_number "
                                                 + "FROM "
                                                 + "PERSON p, PERSON_ID pid, STAGE_PERSON_LINK spl "
                                                 + "WHERE "
                                                 + "p.id_person = pid.id_person AND "
                                                 + "p.id_person = spl.id_person AND "
                                                 + "pid.id_person = :idPerson AND "
                                                 + "pid.ind_person_id_invalid = 'N' AND "
                                                 + "(pid.dt_person_id_end = '12/31/4712' OR dt_person_id_end IS NULL) AND "
                                                 + "pid.cd_person_id_type  = 'SSN'");

    query.setInteger("idPerson", idPerson);
    return (Object[]) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  /*
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   */
  public Object[] findDistinctChildNbrPersonIdCrsIdByIdPerson(int idPerson) {
    SQLQuery query = getSession().createSQLQuery("SELECT pid.id_person, "
                                                 + "pid.nbr_person_id_number "
                                                 + "FROM "
                                                 + "PERSON p, PERSON_ID pid, STAGE_PERSON_LINK spl "
                                                 + "WHERE "
                                                 + "p.id_person = pid.id_person AND "
                                                 + "p.id_person = spl.id_person AND "
                                                 + "pid.id_person = :idPerson AND "
                                                 + "(spl.cd_stage_pers_rel_int = 'SO' or spl.cd_stage_pers_rel_int = 'DA' or spl.cd_stage_pers_rel_int = 'SL') AND "
                                                 + "pid.ind_person_id_invalid = 'N' AND "
                                                 + "(pid.dt_person_id_end = '12/31/4712' OR dt_person_id_end IS NULL) AND "
                                                 + "pid.cd_person_id_type  = 'CRS ID#'");

    query.setInteger("idPerson", idPerson);
    return (Object[]) firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  /*
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   */
  public List<PersonId> findChildIdPersonByParentIdPerson(int idPerson) {
    SQLQuery query = getSession().createSQLQuery("SELECT DISTINCT id_person "
                                                 + "FROM "
                                                 + "STAGE_PERSON_LINK "
                                                 + "WHERE "
                                                 + "id_stage IN "
                                                 + "(SELECT spl.id_stage "
                                                 + "FROM "
                                                 + "PERSON p, PERSON_ID pid, STAGE_PERSON_LINK spl "
                                                 + "WHERE p.id_person = pid.id_person AND "
                                                 + "p.id_person = spl.id_person AND "
                                                 + "pid.id_person = :idPerson) AND "
                                                 + "cd_Stage_Pers_Role = 'PC' "
                                                 + "ORDER BY id_person");

    query.setInteger("idPerson", idPerson);
    return (List<PersonId>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public String findNbrCrsId(int idPerson) {
     
     Query query = getSession().createQuery(" select p.nbrPersonIdNumber from PersonId p " + "where p.person.idPerson = :idPerson" +
                                          " and p.cdPersonIdType ='CRS ID#' and  p.dtPersonIdEnd is null ");
     query.setLong("idPerson", idPerson);
     return (String)firstResult(query);
     
   }
  @SuppressWarnings("unchecked")
  public List<PersonId> findPersonIdByType(int idPerson, String... types) {
    Query query = getSession().createQuery("  from PersonId p " +
                                           " where p.person.idPerson = :idPerson " +
                                           "   and (p.dtPersonIdEnd is null  " +
                                           "        or p.dtPersonIdEnd = :maxJavaDate) " +
                                           "   and p.cdPersonIdType in (:types)");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxJavaDate", DateHelper.MAX_JAVA_DATE);
    query.setParameterList("types", types, Hibernate.STRING);
    return (List<PersonId>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public String findNonEndDatePersonSSN(int idPerson) {
    Query query = getSession().createQuery("select p1.nbrPersonIdNumber " +
                                           "  from PersonId p1 " +
                                           " where p1.person.idPerson = :idPerson " +
                                           "   and (p1.dtPersonIdEnd = null  " +
                                           "        or p1.dtPersonIdEnd = :maxDate) " +
                                           "   and p1.cdPersonIdType = 'SSN'");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (String) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public String findNonEndDatePersonMedicaid(int person) {
    Query query = getSession().createQuery("select p3.nbrPersonIdNumber " +
                                           "  from PersonId p3 " +
                                           " where p3.person.idPerson = :idPerson " +
                                           "   and (p3.dtPersonIdEnd = null  " +
                                           "   or p3.dtPersonIdEnd = :maxDate) " +
                                           "   and p3.cdPersonIdType = 'Medicaid/MHN #'");
    query.setInteger("idPerson", person);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (String) firstResult(query);
  }

  public String findNonEndDatePersonCRSId(int person) {
    Query query = getSession().createQuery("select p5.nbrPersonIdNumber " +
                                           "  from PersonId p5 " +
                                           " where p5.person.idPerson = :idPerson " +
                                           "   and (p5.dtPersonIdEnd = null  " +
                                           "   or p5.dtPersonIdEnd = :maxDate) " +
                                           "   and p5.cdPersonIdType = 'CRS ID#'");
    query.setInteger("idPerson", person);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (String) firstResult(query);
  }
  public PersonId findPersonIdByIdPersonCdPersonIdTypeIndPersonIdInvalidDtPersonIdEnd(int idPerson,
                                                                                      String cdPersonIdType,
                                                                                      String indPersonIdInvalid,
                                                                                      Date dtPersonIdEnd) {

    Query query = getSession().createQuery(" from PersonId " +
                                           "where person.idPerson = :idPerson " +
                                           "      and cdPersonIdType = :cdPersonIdType " +
                                           "      and indPersonIdInvalid = :indPersonIdInvalid " +
                                           "      and dtPersonIdEnd = :dtPersonIdEnd ");

    query.setInteger("idPerson", idPerson);
    query.setString("cdPersonIdType", cdPersonIdType);
    query.setString("indPersonIdInvalid", indPersonIdInvalid);
    query.setTimestamp("dtPersonIdEnd", dtPersonIdEnd);
    return (PersonId) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<PersonId> findPersonIdByIdPersonAndSysTsQueryInIntakeStage(int idPerson, Date sysTsQuery) {

    Query query = getSession().createQuery("    from PersonId p " +
                                           "   where p.person.idPerson = :idPerson " +
                                           "     and p.dtPersonIdStart <= :sysTsQuery " +
                                           "     and p.dtPersonIdEnd >= :sysTsQuery " +
                                           "order by p.dtPersonIdEnd desc, " +
                                           "         p.dtPersonIdStart desc");

    query.setInteger("idPerson", idPerson);
    query.setTimestamp("sysTsQuery", sysTsQuery);

    return (List<PersonId>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<PersonId> findPersonIdByIdPersonAndSysTsQueryInInvestigationStage(int idPerson) {

    Query query = getSession().createQuery("    from PersonId p " +
                                           "   where p.person.idPerson = :idPerson " +
                                           "order by p.dtPersonIdEnd desc, " +
                                           "         p.dtPersonIdStart desc");

    query.setInteger("idPerson", idPerson);
    return (List<PersonId>) query.list();
  }

  public long countPersonIdIdPersonId(int idPerson, Date dtSysTsQuery) {
    Query query = getSession().createQuery("select count(p.idPersonId) " +
                                           "  from PersonId p " +
                                           " where p.person.idPerson = :idPerson " +
                                           "   and p.dtPersonIdStart <= :dtSysTsQuery " +
                                           "   and p.dtPersonIdEnd >= :dtSysTsQuery " +
                                           "   and p.cdPersonIdType != 'SSN' ");

    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtSysTsQuery", dtSysTsQuery);

    return (Long) query.uniqueResult();
  }

  public long countIdPersonIdByIdPersonAndMaxDate(int idPerson, Date maxDate) {
    Query query = getSession().createQuery("select count(idPersonId) " +
                                           "  from PersonId " +
                                           " where person.idPerson = :idPerson " +
                                           "   and dtPersonIdEnd = :maxDate " +
                                           "   and cdPersonIdType != 'SSN'");

    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", maxDate);
    return (Long) query.uniqueResult();
  }

  public PersonId findIdPersonIdByIdPersonAndMaxDate(int idPerson, Date maxDate) {
    Query query = getSession().createQuery(" from PersonId " +
                                           " where person.idPerson = :idPerson " +
                                           "  and dtPersonIdEnd = :maxDate");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", maxDate);
    return (PersonId) firstResult(query);
  }

  public int insertPersonId(int idPerson, String cdNbrPersonIdNumber, String cdPersonIdType, String cdDescPersonId,
                            String indPersonIdInvalid, Date dtPersonIdStart) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO PERSON_ID ( " +
                                                 "            ID_PERSON_ID, " +
                                                 "            ID_PERSON, " +
                                                 "            NBR_PERSON_ID_NUMBER, " +
                                                 "            CD_PERSON_ID_TYPE, " +
                                                 "            DESC_PERSON_ID, " +
                                                 "            IND_PERSON_ID_INVALID, " +
                                                 "            DT_PERSON_ID_START) " +
                                                 " VALUES (SEQ_PERSON_ID.NEXTVAL, " +
                                                 "         :idPerson, " +
                                                 "         :cdNbrPersonIdNumber, " +
                                                 "         :cdPersonIdType, " +
                                                 "         :cdDescPersonId, " +
                                                 "         :indPersonIdInvalid, " +
                                                 "         :dtPersonIdStart)");

    query.setInteger("idPerson", idPerson);
    query.setString("cdNbrPersonIdNumber", cdNbrPersonIdNumber);
    query.setString("cdPersonIdType", cdPersonIdType);
    query.setString("cdDescPersonId", cdDescPersonId);
    query.setString("indPersonIdInvalid", indPersonIdInvalid);
    query.setTimestamp("dtPersonIdStart", dtPersonIdStart);
    return query.executeUpdate();
  }

  public int insertPersonIdByIdPerson(int idPerson, int idIncmgPerson) {
    SQLQuery query = getSession().createSQLQuery("insert into PERSON_ID (ID_PERSON_ID, " +
                                                 "                       ID_PERSON, " +
                                                 "                       NBR_PERSON_ID_NUMBER, " +
                                                 "                       CD_PERSON_ID_TYPE, " +
                                                 "                       DT_PERSON_ID_START, " +
                                                 "                       DT_PERSON_ID_END, " +
                                                 "                       IND_PERSON_ID_INVALID, " +
                                                 "                       DESC_PERSON_ID ) " +
                                                 "select SEQ_PERSON_ID.NEXTVAL, " +
                                                 "       :idPerson, " +
                                                 "       NBR_INCMG_PERS_ID_NUMBER, " +
                                                 "       CD_INCMG_PERS_ID_TYPE, " +
                                                 "       DT_INCMG_PERS_ID_START, " +
                                                 "       DT_INCMG_PERSON_ID_END, " +
                                                 "       IND_INCMG_PERSON_ID_INV, " +
                                                 "       DESC_INCMG_PERSON_ID " +
                                                 "  from INCOMING_PERSON_ID " +
                                                 " where ID_INCMG_PERSON = :idIncmgPerson");
    query.setInteger("idIncmgPerson", idIncmgPerson);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  public int insertPersonIdByStartEnd(int idPerson, String cdNbrPersonIdNumber, String cdPersonIdType,
                                      String cdDescPersonID, String indPersonIDInvalid, Date dtPersonIDStart,
                                      Date dtPersonIDEnd, String indValidateByInterface) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO PERSON_ID (ID_PERSON_ID, " +
                                                 "                       ID_PERSON, " +
                                                 "                       NBR_PERSON_ID_NUMBER, " +
                                                 "                       CD_PERSON_ID_TYPE, " +
                                                 "                       DESC_PERSON_ID, " +
                                                 "                       IND_PERSON_ID_INVALID, " +
                                                 "                       DT_PERSON_ID_START, " +
                                                 "                       DT_PERSON_ID_END, " +
                                                 "                       IND_VALIDATE_BY_INTERFACE) " +
                                                 "     VALUES (SEQ_PERSON_ID.NEXTVAL, " +
                                                 "             :idPerson, " +
                                                 "             :cdNbrPersonIdNumber, " +
                                                 "             :cdPersonIdType, " +
                                                 "             :cdDescPersonID, " +
                                                 "             :indPersonIDInvalid, " +
                                                 "             :dtPersonIDStart, " +
                                                 "             :dtPersonIDEnd, " +
                                                 "             :indValidateByInterface)");

    query.setInteger("idPerson", idPerson);
    query.setString("cdNbrPersonIdNumber", cdNbrPersonIdNumber);
    query.setString("cdPersonIdType", cdPersonIdType);
    query.setString("cdDescPersonID", cdDescPersonID);
    query.setString("indPersonIDInvalid", indPersonIDInvalid);
    query.setTimestamp("dtPersonIDStart", dtPersonIDStart);
    query.setTimestamp("dtPersonIDEnd", dtPersonIDEnd);
    query.setString("indValidateByInterface", indValidateByInterface);
    return query.executeUpdate();
  }

  public int updatePersonIdEndDate(int idPerson, int idPersonId, String cdNbrPersonIdNumber, String cdPersonIdType,
                                   String cdDescPersonID, String indPersonIDInvalid, Date dtPersonIDEnd,
                                   String indValidateByInterface, Date tsSysTsLastUpdate) {
    Query query = getSession().createQuery("update PersonId " +
                                           "   set idPersonId = :idPersonId, " +
                                           "       person.idPerson = :idPerson, " +
                                           "       nbrPersonIdNumber = :cdNbrPersonIdNumber, " +
                                           "       cdPersonIdType = :cdPersonIdType, " +
                                           "       descPersonId = :cdDescPersonID, " +
                                           "       indPersonIdInvalid = :indPersonIDInvalid, " +
                                           "       dtPersonIdEnd = :dtPersonIDEnd, " +
                                           "       indValidateByInterface = :indValidateByInterface " +
                                           " where (idPersonId = :idPersonId) " +
                                           "   and (dtLastUpdate <= :tsSysTsLastUpdate)");

    query.setInteger("idPerson", idPerson);
    query.setInteger("idPersonId", idPersonId);
    query.setString("cdNbrPersonIdNumber", cdNbrPersonIdNumber);
    query.setString("cdPersonIdType", cdPersonIdType);
    query.setString("cdDescPersonID", cdDescPersonID);
    query.setString("indPersonIDInvalid", indPersonIDInvalid);
    query.setTimestamp("dtPersonIDEnd", dtPersonIDEnd);
    query.setString("indValidateByInterface", indValidateByInterface);
    query.setTimestamp("tsSysTsLastUpdate", tsSysTsLastUpdate);

    return query.executeUpdate();
  }

  public int deletePersonId(int idPersonId, Date dtSysTsLastUpdate2) {
    Query query = getSession().createQuery("delete from PersonId p " +
                                           "      where (p.idPersonId = :idPersonId) " +
                                           "        and (p.dtLastUpdate <= :dtSysTsLastUpdate2) ");
    query.setInteger("idPersonId", idPersonId);
    query.setTimestamp("dtSysTsLastUpdate2", dtSysTsLastUpdate2);
    return query.executeUpdate();
  }

  public long countPersonIdByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select count(idPersonId) " +
                                           "  from PersonId " +
                                           " where person.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }
  
  public long findPersonIdByType(int idPerson) {
    Query query = getSession().createQuery("select count(idPersonId) " +
                                           "  from PersonId " +
                                           " where person.idPerson = :idPerson " +
                                           " and cdPersonIdType = 'CRS ID#'");
    query.setInteger("idPerson", idPerson);
    return (Long)query.uniqueResult();
  }
  
}
