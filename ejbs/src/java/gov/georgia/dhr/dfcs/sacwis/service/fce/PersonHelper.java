package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlHelper;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.PersonDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * Change History:
 * Date      User              Description
 * --------  ----------------  -------------------------------------------------
 * 06/24/08  mchillman         STGAP00009240: PersonHelper.getRemovalHomeAddress Was not filtering on the end date in 
 *                             determining which removal address to retrieve
 * 12/02/09  wcochran          SMS #41090: Added check for Biological and Legal Father
 *                             in the isParent method. 
 * </pre>
 *
 */
public class PersonHelper implements Serializable {
  
  protected static final String PARENTAL_RIGHTS_TERMINATED_PCT = CodesTables.CLEGSTAT_PCT;

  protected static final String PARENTAL_RIGHTS_TERMINATED_PVL = CodesTables.CLEGSTAT_PVL;

  protected static String findBloc(Connection connection, long idPerson) throws SQLException {
    // !!! can there be more than 1 of the same type that isn't invalid and hasn't been end-dated
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select cd_ploc_child \n" + "from person_loc \n"
                                                      + "where cd_ploc_type = '" + CodesTables.CPLOCELG_BLOC + "' \n"
                                                      + "  and dt_ploc_start <= sysDate \n"
                                                      + "  and dt_ploc_end > sysdate \n"
                                                      + "  and dt_ploc_start <> dt_ploc_end \n"
                                                      + "  and id_person = ? \n");
      preparedStatement.setLong(1, idPerson);
      return SqlHelper.selectString(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static String findSsn(Connection connection, long idPerson) throws SQLException {
    return findPersonId(connection, idPerson, CodesTables.CNUMTYPE_SSN);
  }

  protected static String findMedicaid(Connection connection, long idPerson) throws SQLException {
    return findPersonId(connection, idPerson, CodesTables.CNUMTYPE_MEDICAID_NUMBER);
  }

  // Finds the CRS ID of the person
  protected static String findCrsId(Connection connection, long idPerson) throws SQLException {
    return findPersonId(connection, idPerson, CodesTables.CNUMTYPE_CRS_IDNUMBER);
  }

  //Finds the MHN ID of the person
  protected static String findMhn(Connection connection, long idPerson) throws SQLException {
    return findPersonId(connection, idPerson, CodesTables.CNUMTYPE_MEDICAIDMHN_NUMBER);
  }

  protected static String findMedAppMonth(Connection connection, long idCase) throws SQLException {
    // Note: there can only be 1 of a type that hasn't been end-dated.
    // They can not be end-dated in the future.
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select min(dt_removal) from ( \n"
                                                      + " select id_victim, max (dt_removal) dt_removal \n"
                                                      + " from cnsrvtrshp_removal \n"
                                                      + " where id_case = ? \n"
                                                      + " and dt_removal is not null \n"
                                                      + " and dt_removal <>" + FceHelper.SQL_MAX_DATE + " \n"
                                                      + " group by id_victim ) \n");
      preparedStatement.setLong(1, idCase);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        return FormattingHelper.formatDateMonthYear(rs.getDate(1));
      } else {
        return null;
      }
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }
  
  protected static String findMedAppMonthAsPlcmtDate(Connection connection, long idPerson) throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select dt_plcmt_start from placement \n "
                                                      + " where id_plcmt_child = ? \n"
                                                      + " order by dt_plcmt_start desc \n");
      preparedStatement.setLong(1, idPerson);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        return FormattingHelper.formatDateMonthYear(rs.getDate(1));
      } else {
          return null;
      }
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static String findNmPersonFull(Connection connection, long idPerson) throws SQLException {
    // Note: there can only be 1 of a type that hasn't been end-dated.
    // They can not be end-dated in the future.
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select nm_person_full \n" + "from person \n"
                                                      + "where id_person = ? \n");
      preparedStatement.setLong(1, idPerson);
      return SqlHelper.selectString(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  private static String findPersonId(Connection connection, long idPerson, String personIdType) throws SQLException {
    // Note: there can only be 1 of a type that hasn't been end-dated.
    // They can not be end-dated in the future.
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select nbr_person_id_number \n" + "from person_id \n"
                                                      + "where id_person = ? \n" + "  and cd_person_id_type = ? \n"
                                                      + "  and ind_person_id_invalid = 'N' \n"
                                                      + "  and (dt_person_id_end = " + FceHelper.SQL_MAX_DATE + " \n"
                                                      + "  or dt_person_id_end is null ) \n");
      preparedStatement.setLong(1, idPerson);
      preparedStatement.setString(2, personIdType);
      return SqlHelper.selectString(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static Long findIdFcePerson(Connection connection, long idPerson) throws SQLException {
    // Note: there can only be 1 of a type that hasn't been end-dated.
    // They can not be end-dated in the future.
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select id_fce_person \n" + "from fce_person \n"
                                                      + "where id_person = ? \n");
      preparedStatement.setLong(1, idPerson);
      return SqlHelper.selectLong(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  @SuppressWarnings({"deprecation"})
  protected static PersonDB findPrimaryWorkerForStage(Connection connection, long idStage) throws SQLException {
    PreparedStatement preparedStatement = null;
    List list;
    try {
      preparedStatement = connection.prepareStatement("select person.* \n" + "from stage_person_link link, \n"
                                                      + "     person \n" + "where link.id_stage = ? \n"
                                                      + "and link.cd_stage_pers_role in ('HP', 'PR') \n"
                                                      + "and link.id_person = person.id_person \n");
      preparedStatement.setLong(1, idStage);
      list = SqlHelper.createListFromQuery(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    if (list.isEmpty()) {
      throw new IllegalStateException("no primary worker for stage: " + idStage);
    }
    // !!! perform query against database to see if this is impossible
    if (list.size() > 1) {
      throw new IllegalStateException("only expected 1 primary worker for stage: " + idStage);
    }
    Map map = (Map) list.get(0);
    PersonDB personDB = new PersonDB();
    PersonDB.populateWithMap(personDB, map);
    return personDB;
  }

  protected static long findPrimaryChildForStage(Connection connection, long idStage) throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select id_person \n" + "from stage_person_link \n"
                                                      + "where id_stage = ? \n" + "and cd_stage_pers_role = 'PC'\n");
      preparedStatement.setLong(1, idStage);
      return SqlHelper.selectLong(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  @SuppressWarnings({"deprecation"})
  protected static Map<String, Object> findLegalStatusForChild(Connection connection, long idCase, long idPerson)
          throws SQLException {
    PreparedStatement preparedStatement = null;
    List<Map<String, Object>> list;
    try {
      preparedStatement = connection.prepareStatement("select * \n" + "from legal_status \n" + "where id_case = ? \n"
                                                      + "  and id_person = ? \n" + "  and cd_legal_stat_status in (\n"
                                                      + "      '" + PARENTAL_RIGHTS_TERMINATED_PCT + "', \n"
                                                      + "      '" + PARENTAL_RIGHTS_TERMINATED_PVL + "' \n" + ") \n"
                                                      + "order by dt_legal_stat_status_dt desc \n");
      preparedStatement.setLong(1, idCase);
      preparedStatement.setLong(2, idPerson);
      // FIXME: !!! This gets all rows when I only need it to get 1
      list = SqlHelper.createListFromQuery(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    if (list.size() == 0) {
      return new HashMap<String, Object>();
    }
    return list.get(0);
  }

  // Changed name of method since it will now delete non principles and/or principles that are not related in the stage
  protected static void deleteUnrelatedOrNonPrinciples(Connection connection, long idFceEligibility, long idStage)
          throws SQLException {
    PreparedStatement selectIdPersonStatement = null;
    long[] unrelatedOrNonPrinciples;
    try {
      selectIdPersonStatement = connection.prepareStatement("select id_person from fce_person \n"
                                                            + "where id_fce_eligibility = ? \n"
                                                            + "  and id_person not in (\n"
                                                            + "  select link.id_person \n"
                                                            + "  from stage_person_link link \n"
                                                            + "  where link.id_person = fce_person.id_person \n"
                                                            + "    and link.id_stage = ? \n"
                                                            + "    and link.cd_stage_pers_type = 'PRN' \n" + ")\n");
      selectIdPersonStatement.setLong(1, idFceEligibility);
      selectIdPersonStatement.setLong(2, idStage);
      unrelatedOrNonPrinciples = SqlHelper.selectLongArray(selectIdPersonStatement);
    } finally {
      SqlHelper.cleanup(selectIdPersonStatement);
    }
    if (unrelatedOrNonPrinciples.length == 0) {
      return;
    }
    String personSetString = SqlHelper.toSetString(unrelatedOrNonPrinciples);

    // Delete fce_income if he's no longer a principle
    PreparedStatement deleteFceIncomeStatement = null;
    try {
      deleteFceIncomeStatement = connection.prepareStatement("delete from fce_income \n"
                                                             + "where id_fce_eligibility = ? \n"
                                                             + "  and id_person in (" + personSetString + ") \n");
      deleteFceIncomeStatement.setLong(1, idFceEligibility);
      SqlHelper.setLongArray(deleteFceIncomeStatement, 2, unrelatedOrNonPrinciples);
      deleteFceIncomeStatement.executeUpdate();
    } finally {
      SqlHelper.cleanup(deleteFceIncomeStatement);
    }

    // Delete fce_person if he's no longer a principle
    PreparedStatement deleteFcePersonStatement = null;
    try {
      deleteFcePersonStatement = connection.prepareStatement("delete from fce_person \n"
                                                             + "where id_fce_eligibility = ? \n"
                                                             + "  and id_person in (" + personSetString + ") \n");
      deleteFcePersonStatement.setLong(1, idFceEligibility);
      SqlHelper.setLongArray(deleteFcePersonStatement, 2, unrelatedOrNonPrinciples);
      deleteFcePersonStatement.executeUpdate();
    } finally {
      SqlHelper.cleanup(deleteFcePersonStatement);
    }
  }
  
  @SuppressWarnings({"deprecation"})
  protected static void createPrinciples(Fce fce, Connection connection, long idFceEligibility,
                                         long idStage)
          throws SQLException {
    
    PreparedStatement selectPersonStatement = null;
    List principlesList;
    try {
      selectPersonStatement = connection
              .prepareStatement("select person.nm_person_full as nm_person_full, \n"
                                + "       person.cd_person_suffix as cd_person_suffix, \n"
                                + "       person.id_person as id_person, \n"
                                + "       person.ind_person_dob_approx as ind_person_dob_approx, \n"
                                + "       person.dt_person_birth as dt_person_birth, \n"
                                + "       person.nm_person_first as nm_person_first, \n"
                                + "       person.nm_person_last as nm_person_last, \n"
                                + "       person.addr_person_st_ln_1 as addr_person_st_ln_1, \n"
                                + "       person.addr_person_city as addr_person_city, \n"
                                + "       person.addr_person_zip as addr_person_zip, \n"
                                + "       person.cd_person_state as cd_person_state, \n"
                                + "       person.cd_person_county as cd_person_county, \n"
                                + "       link.cd_stage_pers_rel_int as cd_stage_pers_rel_int, \n"
                                + "       link.cd_stage_pers_role as cd_stage_pers_role \n"
                                + "from person person, \n" + "     stage_person_link link \n"
                                + "where person.id_person = link.id_person \n"
                                + "  and (person.cd_person_status != 'M' \n"
                                + "       or person.cd_person_status is null) \n"
                                + "  and link.id_stage = ? \n"
                                + "  and link.cd_stage_pers_type = 'PRN' \n");
      selectPersonStatement.setLong(1, idStage);
      principlesList = SqlHelper.createListFromQuery(selectPersonStatement);

    } finally {
      SqlHelper.cleanup(selectPersonStatement);
    }

    PreparedStatement selectFcePersonStatement = null;
    Map fcePersonTable;
    try {
      selectFcePersonStatement = connection
              .prepareStatement("select id_person, id_fce_person \n"
                                + "from fce_person \n" + "where id_fce_eligibility = ? \n");
      selectFcePersonStatement.setLong(1, idFceEligibility);
      fcePersonTable = SqlHelper.createIdMapFromQuery(selectFcePersonStatement, "ID_PERSON", "ID_FCE_PERSON");
    } finally {
      SqlHelper.cleanup(selectFcePersonStatement);
    }

    // instead of bringing all into object space can do a group of updates followed by inserts, or v.v. all in sql
    Iterator iterator = principlesList.iterator();
    while (iterator.hasNext()) {
      Map personMap = (Map) iterator.next();
      long idPerson = SqlHelper.getLong(personMap, "ID_PERSON");
      long idFcePerson = SqlHelper.getLong(fcePersonTable, idPerson);
      // fyi: rel_int column is CRPTRINT
      String cdRelInt = (String) personMap.get("CD_STAGE_PERS_REL_INT");
      FcePersonDB fcePersonDB;
      PreparedStatement selectLegalCustodianStatement = null;
      if (idFcePerson == 0l) {
        String legalCustodianValue = null;
        try {
          selectLegalCustodianStatement = connection.prepareStatement("select ind_legal_custody " +
                                                                      "from person_dtl " +
                                                                      "where id_person = ? ");
          selectLegalCustodianStatement.setLong(1, idPerson);
          ResultSet resultSet = selectLegalCustodianStatement.executeQuery();
          if (resultSet.next()) {
            legalCustodianValue = resultSet.getString("ind_legal_custody");
          }
        } finally {
          SqlHelper.cleanup(selectLegalCustodianStatement);
        }
        fcePersonDB = createFcePerson(fce, idFceEligibility, idPerson, cdRelInt,
                                      legalCustodianValue);
      } else {
        fcePersonDB = fce.retrieveFcePerson(idFcePerson);
      }
      PersonDB personDB = new PersonDB();
      PersonDB.populateWithMap(personDB, personMap);
      updateBirthday(fce, fcePersonDB, personDB);
    }
  }

  @SuppressWarnings({"deprecation"})
  protected static List<FcePersonDB> findPrinciples(Connection connection, long idFceEligibility, Fce fce)
          throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace("PersonHelper", ".findPrinciples()");
    performanceTrace.enterScope();

    PreparedStatement preparedStatement = null;
    List principlesList;
    try {

      preparedStatement =
              connection.prepareStatement("select fcp.*, \n" +
                                          "       p.nm_person_full as nm_person_full, \n" +
                                          "       p.cd_person_suffix as cd_person_suffix, \n" +
                                          "       p.id_person as id_person, \n" +
                                          "       p.ind_person_dob_approx as ind_person_dob_approx, \n" +
                                          "       p.dt_person_birth as dt_person_birth, \n" +
                                          "       p.nm_person_first as nm_person_first, \n" +
                                          "       p.nm_person_last as nm_person_last, \n" +
                                          "       p.addr_person_st_ln_1 as addr_person_st_ln_1, \n" +
                                          "       p.addr_person_city as addr_person_city, \n" +
                                          "       p.addr_person_zip as addr_person_zip, \n" +
                                          "       p.cd_person_state as cd_person_state, \n" +
                                          "       p.cd_person_county as cd_person_county, \n" +
                                          "       spl.cd_stage_pers_rel_int as cd_stage_pers_rel_int, \n" +
                                          "       pdtl.ind_legal_custody as ind_legal_custody \n" +
                                          "from fce_person fcp, fce_eligibility fce, person p, \n" +
                                          "     stage_person_link spl, \n" +
                                          "     person_dtl pdtl \n" +
                                          "where fcp.id_fce_eligibility = ? \n" +
                                          "  and  fcp.id_fce_eligibility = fce.id_fce_eligibility \n" +
                                          "  and fcp.id_person = p.id_person \n" +
                                          "  and spl.id_stage = fce.id_stage \n " +
                                          "  and spl.id_person = fcp.id_person \n" +
                                          "  and spl.cd_stage_pers_type = 'PRN' \n" +
                                          "  and p.id_person = pdtl.id_person(+) \n" +
                                          "order by fcp.nbr_age asc \n");
      preparedStatement.setLong(1, idFceEligibility);
      principlesList = SqlHelper.createListFromQuery(preparedStatement);

    } finally {
      SqlHelper.cleanup(preparedStatement);
    }

    List<FcePersonDB> outputList = new ArrayList<FcePersonDB>();
    Iterator iterator = principlesList.iterator();
    while (iterator.hasNext()) {
      Map map = (Map) iterator.next();
      FcePersonDB fcePersonDB = createFcePersonDB(map, map);
      fce.updateCdRelIntandLegalCustodian(fcePersonDB.getIdFcePerson(), fcePersonDB.getCdRelInt(),
                                          fcePersonDB.getIndLegalCustodian());
      outputList.add(fcePersonDB);
      continue;
    }
    performanceTrace.exitScope();
    //FcePerson (Name & Id) - for Income/Expenditures detail need more data for ApplicationBackground
    return outputList;

  }

  private static FcePersonDB createFcePersonDB(Map fcePersonMap, Map personMap) {
    FcePersonDB fcePersonDB = new FcePersonDB();
    PersonDB.populateWithMap(fcePersonDB, personMap);
    FcePersonDB.populateWithMap(fcePersonDB, fcePersonMap);
    synchronizeBirthDays(fcePersonDB);
    return fcePersonDB;
  }

  private static void synchronizeBirthDays(FcePersonDB fcePersonDB) {
    // because there are 2 DOB values; make sure FcePerson's is used
    fcePersonDB.setDtPersonBirth(fcePersonDB.getDtBirth());
    fcePersonDB.setIndPersonDobApprox(fcePersonDB.getIndDobApprox());
  }

  protected static String getCdPersonCitizenship(Connection connection, long idPerson) throws SQLException {
    PreparedStatement preparedStatement = null;
    try {

      preparedStatement = connection.prepareStatement("select cd_person_citizenship \n" +
                                                      "from person_dtl \n" +
                                                      "where id_person = ?");

      preparedStatement.setLong(1, idPerson);
      return SqlHelper.selectString(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static void updateAddress(FceApplicationDB fceApplicationDB, PersonDB personDB,
                                      Fce fce, String cdState) {
    fceApplicationDB.setAddrRemovalAddrZip(personDB.getAddrPersonZip());
    fceApplicationDB.setAddrRemovalCity(personDB.getAddrPersonCity());
    fceApplicationDB.setAddrRemovalStLn1(personDB.getAddrPersonStLn1());
    fceApplicationDB.setCdRemovalAddrCounty(personDB.getCdPersonCounty());
    fceApplicationDB.setCdRemovalAddrState(personDB.getCdPersonState());
    fceApplicationDB.setCdState(cdState);
    fce.updateFceApplicationPersonAddress(fceApplicationDB);
  }
  
  //STGAP00009240 added filter for end date
  protected static boolean getRemovalHomeAddress(Connection connection, FceApplicationDB fceApplicationDB, Fce fce) throws SQLException {
    boolean updatedAddress = false;
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select pa.ADDR_PERS_ADDR_ST_LN_1 as ADDR_PERS_ADDR_ST_LN_1, \n" +
                                                      "pa.ADDR_PERS_ADDR_ST_LN_2 as ADDR_PERS_ADDR_ST_LN_2, \n" +
                                                      "pa.ADDR_PERSON_ADDR_CITY as ADDR_PERSON_ADDR_CITY, \n" +
                                                      "pa.CD_PERSON_ADDR_STATE as CD_PERSON_ADDR_STATE, \n" +
                                                      "pa.ADDR_PERSON_ADDR_ZIP as ADDR_PERSON_ADDR_ZIP, \n" +
                                                      "pa.CD_PERSON_ADDR_COUNTY as CD_PERSON_ADDR_COUNTY\n" +
                                                      "from ADDRESS_PERSON_LINK apl, PERSON_ADDRESS pa \n" +
                                                      "where apl.ID_PERSON_ADDR = pa.ID_PERSON_ADDR \n" +
                                                      " and apl.IND_REMOVAL_HOME = 'Y' \n" +
                                                      " and DT_PERS_ADDR_LINK_END = " + FceHelper.SQL_MAX_DATE + "\n" + 
                                                      "and apl.id_person = ? \n");
      preparedStatement.setLong(1, fceApplicationDB.getIdPerson());
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        updatedAddress = true;
        fceApplicationDB.setAddrRemovalStLn1(rs.getString("ADDR_PERS_ADDR_ST_LN_1"));
        fceApplicationDB.setAddrRemovalStLn2(rs.getString("ADDR_PERS_ADDR_ST_LN_2"));
        fceApplicationDB.setAddrRemovalCity(rs.getString("ADDR_PERSON_ADDR_CITY"));
        fceApplicationDB.setCdRemovalAddrState(rs.getString("CD_PERSON_ADDR_STATE"));
        fceApplicationDB.setCdRemovalAddrCounty(rs.getString("CD_PERSON_ADDR_COUNTY"));
        fceApplicationDB.setAddrRemovalAddrZip(rs.getString("ADDR_PERSON_ADDR_ZIP"));
      }
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    return updatedAddress;
  }
  
  protected static void updateRemovalHomeAddress(FceApplicationDB fceApplicationDB, Fce fce) {
    fce.updateFceApplicationPersonAddress(fceApplicationDB);
  }

  protected static void updateBirthday(Fce fce, FcePersonDB fcePersonDB, PersonDB personDB) {
    fcePersonDB.setDtBirth(personDB.getDtPersonBirth());
    fcePersonDB.setNbrAge(calculateAge(personDB));
    fcePersonDB.setIndDobApprox(personDB.getIndPersonDobApprox());
    fce.updateFcePersonBirthday(fcePersonDB);
  }

  private static long calculateAge(PersonDB personDB) {
    Date birthDate = personDB.getDtPersonBirth();
    if (birthDate != null) {
      return (long) DateHelper.getAge(birthDate);
    }
    // The database has junk values for ages when birth date is null
    return 0l;
  }

  protected static void saveFcePersons(List list, Fce fce) {
    if (list == null) {
      return;
    }
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      FcePersonDB fcePersonDB = (FcePersonDB) iterator.next();
      saveFcePerson(fcePersonDB, fce);
    }
  }

  private static void saveFcePerson(FcePersonDB fcePersonDB, Fce fce) {
    long idFcePerson = fcePersonDB.getIdFcePerson();
    if (idFcePerson == 0l) {
      return;
    } else {
      fce.saveFcePerson(fcePersonDB);
    }
  }

  protected static FcePersonDB findFcePerson(Fce fce, long idFcePerson) {
    return fce.retrieveFcePerson(idFcePerson);
  }
  
  protected static FcePersonDB findFcePersonByIdPerson(Fce fce, long idPerson) {
    return fce.retrieveFcePerson(idPerson);
  }

  @SuppressWarnings({"deprecation"})
  protected static PersonDB findPerson(Connection connection, long personId) throws SQLException {
    PreparedStatement preparedStatement = null;
    List list;
    try {
      preparedStatement = connection.prepareStatement("select * from person where id_person = ?");
      preparedStatement.setLong(1, personId);
      list = SqlHelper.createListFromQuery(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    Map map = (Map) list.get(0);
    PersonDB personDB = new PersonDB();
    PersonDB.populateWithMap(personDB, map);
    return personDB;
  }

  protected static FcePersonDB createFcePerson(Fce fce, long idFceEligibility, long idPerson,
                                               String cdRelInt, String legalCustodianValue) {
    FcePersonDB fcePersonDB = new FcePersonDB();
    fcePersonDB.setIdFceEligibility(idFceEligibility);
    fcePersonDB.setIdPerson(idPerson);
    fcePersonDB.setCdRelInt(cdRelInt);
    fcePersonDB.setIndLegalCustodian(legalCustodianValue);
    int idFceperon = fce.saveFcePerson(fcePersonDB);
    fcePersonDB.setIdFcePerson((long) idFceperon);
    return fcePersonDB;
  }

  public static boolean isStepParent(String cdRelInt) {
    return CodesTables.CRELPRN2_ST.equals(cdRelInt);
  }

  protected static boolean isParent(String cdRelInt) {
    return ((CodesTables.CRELVICT_PA.equals(cdRelInt)) || (CodesTables.CRELVICT_BM.equals(cdRelInt))
            || (CodesTables.CRELVICT_BF.equals(cdRelInt)) || (CodesTables.CRELVICT_BP.equals(cdRelInt))
            || (CodesTables.CRELVICT_LF.equals(cdRelInt)) || (CodesTables.CRELVICT_LM.equals(cdRelInt))
            || (CodesTables.CRELVICT_PF.equals(cdRelInt)) || (CodesTables.CRELVICT_AF.equals(cdRelInt))
            || (CodesTables.CRELVICT_BB.equals(cdRelInt)));
  }

  //This method update in fce_Person table
  protected static void updateFcePersons(List list, Fce fce) {
    if (list == null) {
      return;
    }
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      FcePersonDB fcePersonDB = (FcePersonDB) iterator.next();
      updateFcePerson(fcePersonDB, fce);
    }
  }

  private static void updateFcePerson(FcePersonDB fcePersonDB, Fce fce) {
    long idFcePerson = fcePersonDB.getIdFcePerson();
    if (idFcePerson == 0l) {
      return;
    } else {
      fce.updateFcePerson(fcePersonDB);
    }
  }
}
