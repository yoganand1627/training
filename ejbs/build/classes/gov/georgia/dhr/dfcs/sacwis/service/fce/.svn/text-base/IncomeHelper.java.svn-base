package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.PersonDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IncomeHelper implements Serializable {
  protected static final boolean INCOME = true;
  protected static final boolean RESOURCE = !INCOME;
  protected static final boolean CHILD = true;
  protected static final boolean FAMILY = !CHILD;

  protected static double calculateCountableIncome(Connection connection, long idFcePerson) throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select sum(amt_income) \n" +
                                                      "from fce_income  \n" +
                                                      "where id_fce_person = ? \n" +
                                                      "  and ind_income_source = 'Y' \n" +
                                                      "  and ind_countable = 'Y' \n");
      preparedStatement.setLong(1, idFcePerson);
      return SqlHelper.selectDouble(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static double findSsi(Connection connection, long idPerson) throws SQLException {
    // It is safe to assume only 1 exists.
    // You are only allowed to have resource of a given type for a certain time period
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select amt_inc_rsrc \n" +
                                                      "from income_and_resources \n" +
                                                      "where id_person = ? \n" +
                                                      "  and dt_inc_rsrc_to > sysdate \n" +
                                                      "  and cd_inc_rsrc_type = '" + CodesTables.CINC_SSI + "' \n");
      preparedStatement.setLong(1, idPerson);
      return SqlHelper.selectDouble(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static void saveIncome(List<FceIncomeDB> list, Fce fce) {
    if (list == null) {
      return;
    }
    Iterator<FceIncomeDB> iterator = list.iterator();
    while (iterator.hasNext()) {
      FceIncomeDB fceIncomeDB = iterator.next();
      saveIncome(fceIncomeDB, fce);
    }
  }

  private static void saveIncome(FceIncomeDB fceIncomeDB, Fce fce) {
    long idFceIncome = fceIncomeDB.getIdFceIncome();
    if (idFceIncome == 0) {
      return;
    }
    fce.saveFceIncome(fceIncomeDB);
  }

  protected static List<FceIncomeDB> findIncomeForChild(Connection connection, long idFceEligibility) throws SQLException {
    return findFceIncome(connection, idFceEligibility, INCOME, CHILD);
  }

  protected static List<FceIncomeDB> findResourcesForChild(Connection connection, long idFceEligibility) throws SQLException {
    return findFceIncome(connection, idFceEligibility, RESOURCE, CHILD);
  }

  protected static List<FceIncomeDB> findIncomeForFamily(Connection connection, long idFceEligibility) throws SQLException {
    return findFceIncome(connection, idFceEligibility, INCOME, FAMILY);
  }

  protected static List<FceIncomeDB> findResourcesForFamily(Connection connection, long idFceEligibility) throws SQLException {
    return findFceIncome(connection, idFceEligibility, RESOURCE, FAMILY);
  }

  @SuppressWarnings({"deprecation"})
  protected static void createIncomeForFcePersons(Fce fce, Connection connection, long idFceEligibility,
                                                  long childIdFcePerson)
          throws SQLException {
    PreparedStatement preparedStatement = null;
    Map personMap;
    try {

      preparedStatement = connection.prepareStatement("select id_person, id_fce_person \n" +
                                                      "from fce_person \n" +
                                                      "where id_fce_eligibility = ? \n");
      preparedStatement.setLong(1, idFceEligibility);
      personMap = SqlHelper.createIdMapFromQuery(preparedStatement, "ID_PERSON", "ID_FCE_PERSON");
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    copyIncomeResources(fce, connection, personMap, idFceEligibility, childIdFcePerson);
    deleteBlankRecords(connection, idFceEligibility, INCOME);
    deleteBlankRecords(connection, idFceEligibility, RESOURCE);
    createBlankRecordsForFcePersons(fce, connection, idFceEligibility, childIdFcePerson, INCOME);
    createBlankRecordsForFcePersons(fce, connection, idFceEligibility, childIdFcePerson, RESOURCE);
  }

  //side effect: populates FceIncomeDB.idFceIncome
  private static void createFceIncome(Fce fce, FceIncomeDB fceIncomeDB) {
    if (fceIncomeDB.getIndIncomeSourceObject() == null || fceIncomeDB.getIndResourceSourceObject() == null) {
      throw new IllegalStateException("indIncomeSource and indResourceSource must be set");
    }
    if (!fceIncomeDB.hasCdType()) {
      throw new IllegalStateException("cdType must be set, but can be null");
    }
    if (fceIncomeDB.getIndResourceSource() == fceIncomeDB.getIndIncomeSource()) {
      throw new IllegalStateException("indResourceSource should not equal indIncomeSource: " +
                                      fceIncomeDB.getIndIncomeSource());
    }
    int idFceIncome = fce.saveInitialFceIncome(fceIncomeDB);
    fceIncomeDB.setIdFceIncome(idFceIncome);
  }


  @SuppressWarnings({"deprecation", "unchecked"})
  private static List<FceIncomeDB> findFceIncome(Connection connection, long idFceEligibility, boolean incomeOrResource,
                                                 boolean childOrFamily)
          throws SQLException {
    PreparedStatement preparedStatementIncome = null;
    PreparedStatement preparedStatementPerson = null;
    PreparedStatement preparedStatementFceApp = null;
    Map incomeAndResourceMap;
    Map personMap;
    List fceAppInfoLst;
    try {
      preparedStatementPerson = connection.prepareStatement("select id_person, id_fce_person \n" +
                                                      "from fce_person \n" +
                                                      "where id_fce_eligibility = ? \n");
      preparedStatementPerson.setLong(1, idFceEligibility);
      personMap = SqlHelper.createIdMapFromQuery(preparedStatementPerson, "ID_PERSON", "ID_FCE_PERSON");
      preparedStatementFceApp = connection.prepareStatement("select ind_amended_app, dt_removal_date \n" +
              "from fce_application \n" +
              "where id_fce_eligibility = ? \n");
      preparedStatementFceApp.setLong(1, idFceEligibility);
      fceAppInfoLst = SqlHelper.createListFromQuery(preparedStatementFceApp);
    } finally {
      SqlHelper.cleanup(preparedStatementPerson);
      SqlHelper.cleanup(preparedStatementFceApp);
    }
    try {
          String isAmendedAppStr = "";
          Date fceRemovalDt = null;
          if(fceAppInfoLst != null) {
            Iterator iterator = fceAppInfoLst.iterator();
            while (iterator.hasNext()) {
              Map map = (Map) iterator.next();
              isAmendedAppStr = (String) map.get("IND_AMENDED_APP");
              fceRemovalDt = (Date) map.get("DT_REMOVAL_DATE");
            }
          }
      String personSetString = SqlHelper.toSetString(personMap.keySet());
      java.util.GregorianCalendar tempCal = new java.util.GregorianCalendar();
      tempCal.setTime(new Date());
      int firstDayOfMonth = tempCal.getActualMinimum(java.util.GregorianCalendar.DATE);
      tempCal.set(java.util.GregorianCalendar.DATE, firstDayOfMonth);
      String currentMonthStartDate = FormattingHelper.formatDate(tempCal.getTime());
      String currentMonthEndDate = FormattingHelper.formatDate(DateHelper.addToDate(DateHelper.getLastDayOfTheMonth(new Date()), 0, 0, 1));
      String format = "MM/DD/YYYY";
      if("Y".equalsIgnoreCase(isAmendedAppStr) && fceRemovalDt != null) {
          tempCal = new java.util.GregorianCalendar();
          tempCal.setTime(fceRemovalDt);
          int firstDayOfRemovalMonth = tempCal.getActualMinimum(java.util.GregorianCalendar.DATE);
          tempCal.set(java.util.GregorianCalendar.DATE, firstDayOfRemovalMonth);
          String removalMonthStartDate = FormattingHelper.formatDate(tempCal.getTime());
          preparedStatementIncome = connection.prepareStatement("select distinct * \n" +
                  "from income_and_resources \n" +
                  "where id_person in (" + personSetString + ") \n" +
                  "and (dt_inc_rsrc_from >= to_date('" + removalMonthStartDate + "', '" + format + "'))\n"
                  );
      } else {
          preparedStatementIncome = connection.prepareStatement("select distinct * \n" +
                  "from income_and_resources \n" +
                  "where id_person in (" + personSetString + ") \n" +
                  "and ((dt_inc_rsrc_from < to_date('" + currentMonthEndDate + "', '" + format + "') and dt_inc_rsrc_to >= to_date('" + currentMonthStartDate + "', '" + format + "')))\n"
                  ); 
      }
      SqlHelper.setCollection(preparedStatementIncome, 1, personMap.keySet());
      incomeAndResourceMap = SqlHelper.createIdMapFromQuery(preparedStatementIncome, "ID_INC_RSRC", "ID_PERSON");
    } finally {
      SqlHelper.cleanup(preparedStatementIncome);
    }
    String incomeResourceSetString = SqlHelper.toSetString(incomeAndResourceMap.keySet());
    String sql = "select fce_income.*, \n" +
                 "       person.NM_PERSON_FIRST, \n" +
                 "       person.NM_PERSON_MIDDLE, \n" +
                 "       person.NM_PERSON_LAST, \n" +
                 "       person.NM_PERSON_FULL, \n" +
                 "       fce_person.CD_REL_INT, \n" +
                 "       fce_person.DT_BIRTH, \n" +
                 "       fce_person.NBR_AGE, \n" +
                 "       fce_person.IND_CERTIFIED_GROUP, \n" +
                 "       fce_person.IND_PERSON_HM_REMOVAL \n" +
                 "from fce_income, \n" +
                 "     fce_person, \n" +
                 "     person \n" +
                 "where \n" +
                 "      fce_income.id_fce_person = fce_person.id_fce_person \n" +
                 "  and fce_income.id_person = person.id_person \n" +
                 "  and fce_person.id_person = person.id_person \n" +

                 "  and fce_income.id_fce_eligibility = ? \n" +
                 "  and fce_person.id_fce_eligibility = ? \n";
    
    if(!"".equals(incomeResourceSetString)){
      sql +=  "  and fce_income.id_inc_rsrc in ('" + "0" + "', " + incomeResourceSetString + ")\n";
    }else{
      sql +=  "  and fce_income.id_inc_rsrc in ('" + "0" + "')\n";
    }
    if (isIncome(incomeOrResource)) {
      sql += "  and fce_income.ind_income_source = 'Y' \n";
    } else {
      sql += "  and fce_income.ind_resource_source = 'Y' \n";
    }
    if (isChild(childOrFamily)) {
      sql += "  and fce_income.ind_child = 'Y' \n";
    } else {
      sql += "  and fce_income.ind_family = 'Y' \n";
    }
    sql += "  order by fce_income.id_person \n";
    PreparedStatement preparedStatement = null;
    List<FceIncomeDB> output;
    List rows;
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setLong(1, idFceEligibility);
      preparedStatement.setLong(2, idFceEligibility);
      if(!"".equals(incomeResourceSetString)){
        SqlHelper.setCollection(preparedStatement, 3, incomeAndResourceMap.keySet());
      }
      output = new ArrayList<FceIncomeDB>();
      rows = SqlHelper.createListFromQuery(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    Iterator iterator = rows.iterator();
    while (iterator.hasNext()) {
      Map map = (Map) iterator.next();
      FceIncomeDB fceIncomeDB = new FceIncomeDB();
      PersonDB.populateWithMap(fceIncomeDB, map);
      FcePersonDB.populateWithMap(fceIncomeDB, map);
      FceIncomeDB.populateWithMap(fceIncomeDB, map);
      output.add(fceIncomeDB);
    }
    return output;
  }

  @SuppressWarnings({"deprecation", "unchecked"})
  private static void copyIncomeResources(Fce fce, Connection connection, Map personMap,
                                          long idFceEligibility, long childIdFcePerson)
          throws SQLException {
    String personSetString = SqlHelper.toSetString(personMap.keySet());
    String fcePersonSetString = SqlHelper.toSetString(personMap.values());

    //delete records from fce_income that are no longer valid in income_and_resources

    PreparedStatement deleteFceIncomeStatement = null;
    PreparedStatement preparedStatementFceApp = null;
    List fceAppInfoLst;
    String removalMonthStartDate = "";
    java.util.GregorianCalendar tempCal = new java.util.GregorianCalendar();
    tempCal.setTime(new Date());
    int firstDayOfMonth = tempCal.getActualMinimum(java.util.GregorianCalendar.DATE);
    int lastDayOfMonth = tempCal.getActualMaximum(java.util.GregorianCalendar.DATE);
    tempCal.set(java.util.GregorianCalendar.DATE, firstDayOfMonth);
    String currentMonthStartDate = FormattingHelper.formatDate(tempCal.getTime());
    String currentMonthEndDate = FormattingHelper.formatDate(DateHelper.addToDate(DateHelper.getLastDayOfTheMonth(new Date()), 0, 0, 1));
    String format = "MM/DD/YYYY";
    String isAmendedAppStr = "";
        Date fceRemovalDt = null;
    try {
        preparedStatementFceApp = connection.prepareStatement("select ind_amended_app, dt_removal_date \n" +
                "from fce_application \n" +
                "where id_fce_eligibility = ? \n");
        preparedStatementFceApp.setLong(1, idFceEligibility);
        fceAppInfoLst = SqlHelper.createListFromQuery(preparedStatementFceApp);
        if(fceAppInfoLst != null) {
              Iterator iterator = fceAppInfoLst.iterator();
              while (iterator.hasNext()) {
                Map map = (Map) iterator.next();
                isAmendedAppStr = (String) map.get("IND_AMENDED_APP");
                fceRemovalDt = (Date) map.get("DT_REMOVAL_DATE");
              }
              if(fceRemovalDt != null) {
                  tempCal = new java.util.GregorianCalendar();
                  tempCal.setTime(fceRemovalDt);
                  int firstDayOfRemovalMonth = tempCal.getActualMinimum(java.util.GregorianCalendar.DATE);
                  tempCal.set(java.util.GregorianCalendar.DATE, firstDayOfRemovalMonth);
                  removalMonthStartDate = FormattingHelper.formatDate(tempCal.getTime());
              }
        }
    } finally {
        SqlHelper.cleanup(preparedStatementFceApp);
    }
    try {
      if("Y".equalsIgnoreCase(isAmendedAppStr) && fceRemovalDt !=  null) {
          deleteFceIncomeStatement = connection.prepareStatement("delete from fce_income \n" +
                                        "where id_person in (" + personSetString + ") \n" +
                                        "  and id_fce_eligibility = ? \n" +
                                        "  and id_inc_rsrc is not null \n" +
                                        "  and id_inc_rsrc not in (\n" +
                                        "    select id_inc_rsrc \n" +
                                        "    from income_and_resources \n" +
                                        "    where income_and_resources.id_inc_rsrc = fce_income.id_inc_rsrc \n" +
                                        "  and (dt_inc_rsrc_from >= to_date('" + removalMonthStartDate + "', '" + format + "')))\n");
      } else {
          deleteFceIncomeStatement = connection.prepareStatement("delete from fce_income \n" +
                                "where id_person in (" + personSetString + ") \n" +
                                "  and id_fce_eligibility = ? \n" +
                                "  and id_inc_rsrc is not null \n" +
                                "  and id_inc_rsrc not in (\n" +
                                "    select id_inc_rsrc \n" +
                                "    from income_and_resources \n" +
                                "    where income_and_resources.id_inc_rsrc = fce_income.id_inc_rsrc \n" +
                                "  and ((dt_inc_rsrc_from < to_date('" + currentMonthEndDate + "', '" + format + "') and dt_inc_rsrc_to >= to_date('" + currentMonthStartDate + "', '" + format + "')))\n" +
                                ")\n");
      }
      deleteFceIncomeStatement.setLong(SqlHelper.setCollection(deleteFceIncomeStatement, 1, personMap.keySet()),
                                       idFceEligibility);
      deleteFceIncomeStatement.executeUpdate();
    } finally {

      SqlHelper.cleanup(deleteFceIncomeStatement);
    }

    //get mapping of id_inc_rsrc to id_fce_income

    PreparedStatement selectFceIncomeStatement = null;
    Map fceIncomes;
    try {
      selectFceIncomeStatement = connection.prepareStatement("select id_fce_income, id_inc_rsrc \n" +
                                                             "from fce_income \n" +
                                                             "where id_fce_person in (" + fcePersonSetString + ") \n" +
                                                             "  and id_fce_eligibility = ? \n");
      selectFceIncomeStatement.setLong(SqlHelper.setCollection(selectFceIncomeStatement, 1, personMap.values()),
                                       idFceEligibility);

      fceIncomes = SqlHelper.createIdMapFromQuery(selectFceIncomeStatement, "ID_INC_RSRC", "ID_FCE_INCOME");
    } finally {
      SqlHelper.cleanup(selectFceIncomeStatement);
    }

    //Note: dollar amount values in income_and_resources can change
    //create/update fce_income with data in income_and_resources

    PreparedStatement selectIncomeAndResourcesStatement = null;
    List list;
    try {
    //STGAP00017097
      if("Y".equalsIgnoreCase(isAmendedAppStr) && fceRemovalDt !=  null) {
          selectIncomeAndResourcesStatement = 
              connection.prepareStatement("select distinct * \n" +
                                          "from income_and_resources \n" +
                                          "where id_person in (" + personSetString + ") \n" +
                                          "  and (dt_inc_rsrc_from >= to_date('" + removalMonthStartDate + "', '" + format + "'))\n");
      } else {
          selectIncomeAndResourcesStatement = 
              connection.prepareStatement("select distinct * \n" +
                                          "from income_and_resources \n" +
                                          "where id_person in (" + personSetString + ") \n" +
                                          "and ((dt_inc_rsrc_from < to_date('" + currentMonthEndDate + "', '" + format + "') and dt_inc_rsrc_to >= to_date('" + currentMonthStartDate + "', '" + format + "')))\n"
                                          );
      }
      SqlHelper.setCollection(selectIncomeAndResourcesStatement, 1, personMap.keySet());

      list = SqlHelper.createListFromQuery(selectIncomeAndResourcesStatement);
    } finally {
      SqlHelper.cleanup(selectIncomeAndResourcesStatement);
    }
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      Map map = (Map) iterator.next();

      long idIncRsrc = SqlHelper.getLong(map, "ID_INC_RSRC");
      long idFceIncome = SqlHelper.getLong(fceIncomes, idIncRsrc);
      long idPerson = SqlHelper.getLong(map, "ID_PERSON");
      long idFcePerson = SqlHelper.getLong(personMap, idPerson);

      FceIncomeDB fceIncomeDB = new FceIncomeDB();
      fceIncomeDB.setIdFceEligibility(idFceEligibility);
      fceIncomeDB.setIdFceIncome(idFceIncome);
      fceIncomeDB.setIdFcePerson(idFcePerson);
      fceIncomeDB.setIdIncRsrc(idIncRsrc);
      fceIncomeDB.setIdPerson(idPerson);

      boolean isChild = (idFcePerson == childIdFcePerson);

      fceIncomeDB.setIndChild(isChild);
      fceIncomeDB.setIndFamily((isChild == false));

      String incomeOrResource = (String) map.get("CD_INC_RSRC_INCOME");
      if (incomeOrResource.equals(CodesTables.CINCORES_INC)) {
        fceIncomeDB.setIndIncomeSource(true);
        fceIncomeDB.setIndResourceSource(false);
      } else {
        fceIncomeDB.setIndIncomeSource(false);
        fceIncomeDB.setIndResourceSource(true);
      }
      
      Date incomeResrcFrom = (Date) map.get("DT_INC_RSRC_FROM");
      GregorianCalendar rsrcFromCalc = new GregorianCalendar();
      rsrcFromCalc.setTime(incomeResrcFrom);
      int dayIncStart = rsrcFromCalc.get(GregorianCalendar.DAY_OF_MONTH);
      // Set time fields to zero  
      tempCal.set(java.util.GregorianCalendar.HOUR_OF_DAY, 0);  
      tempCal.set(java.util.GregorianCalendar.MINUTE, 0);  
      tempCal.set(java.util.GregorianCalendar.SECOND, 0);  
      tempCal.set(java.util.GregorianCalendar.MILLISECOND, 0);
      tempCal.set (java.util.GregorianCalendar.MILLISECOND, 0);
      rsrcFromCalc.set(java.util.GregorianCalendar.HOUR_OF_DAY, 0);  
      rsrcFromCalc.set(java.util.GregorianCalendar.MINUTE, 0);  
      rsrcFromCalc.set(java.util.GregorianCalendar.SECOND, 0);  
      rsrcFromCalc.set(java.util.GregorianCalendar.MILLISECOND, 0);
      // Check to see if the income start day is in a previous month. If so, the income start day 
      // is the first instance of that day in the current month
      if (rsrcFromCalc.getTime().compareTo(tempCal.getTime()) < 0) {
        int dayOfWeek = rsrcFromCalc.get(GregorianCalendar.DAY_OF_WEEK);
        GregorianCalendar firstSpecificDayOfMonth = getNthOfMonth(1, dayOfWeek, tempCal.get(GregorianCalendar.MONTH), tempCal.get(GregorianCalendar.YEAR));
        if (firstSpecificDayOfMonth != null) {
          dayIncStart = firstSpecificDayOfMonth.get(GregorianCalendar.DAY_OF_MONTH);
        }
      }

      //Added this code to calculate the monthly income. It checks for the frequency of the income and 
      //converts that into income per month.
      if (fceIncomeDB.getIndIncomeSource()) {
        String freq = (String) map.get("CD_INC_RSRC_FREQ_TYPE");
        double monthlyIncRsrc = ((Number) (map.get("AMT_INC_RSRC"))).doubleValue();
        double freqFactor = 1.0;
        if (freq != null) {
          if ("ANN".equals(freq)) {
            freqFactor = 1.0 / 12.0;
          } else if ("BWK".equals(freq)) {
            // MR-053: Get the number of pay periods in the month
            int count = 0;
            while (dayIncStart <= lastDayOfMonth) {
              count++;
              dayIncStart += 14;
            }
            freqFactor *= count;
          } else if ("MON".equals(freq)) {
            freqFactor = 1.0; // redundant, but included for clearer calculation
          } else if ("OTM".equals(freq)) {
            freqFactor = 0.0;
          } else if ("QRT".equals(freq)) {
            freqFactor = 4.0 / 12.0;
          } else if ("SMN".equals(freq)) {
            freqFactor = 24.0 / 12.0;
          } else if ("WEK".equals(freq)) {
            // MR-053: Get the number of pay periods in the month
            int count = 0;
            while (dayIncStart <= lastDayOfMonth){
              count++;
              dayIncStart += 7;
            }
            freqFactor *= count;
          }
        }
        monthlyIncRsrc *= freqFactor;
        fceIncomeDB.setAmtIncome(monthlyIncRsrc);
      } else {
        fceIncomeDB.setAmtIncome((Number) map.get("AMT_INC_RSRC"));
      }

      fceIncomeDB.setCdType((String) map.get("CD_INC_RSRC_TYPE"));
      fceIncomeDB.setIndNotAccessible((String) map.get("IND_INC_RSRC_NOT_ACCESS"));
      fceIncomeDB.setTxtSource((String) map.get("SDS_INC_RSRC_SOURCE"));
      fceIncomeDB.setTxtVerificationMethod((String) map.get("SDS_INC_RSRC_VERF_METHOD"));
      fceIncomeDB.setTxtComments((String) map.get("TXT_INC_RSRC_DESC"));
      
      if(fceIncomeDB.getAmtIncome() == 0){
        fceIncomeDB.setIndNone(true);
      }

      if (idFceIncome != 0) {
        //we're updating values from income_and_resources
        //it doesn't matter what the timestamp is on fce_income
        // so it's safe to ignore timestamps
        fce.saveFceIncome(fceIncomeDB);
      } else {
        createFceIncome(fce, fceIncomeDB);
      }
    }
  }

  @SuppressWarnings({"deprecation"})
  private static void createBlankRecordsForFcePersons(Fce fce, Connection connection,
                                                      long idFceEligibility, long childIdFcePerson,
                                                      boolean incomeOrResource)
          throws SQLException {

    String sql = "select distinct id_person, id_fce_person \n" +
                 "from fce_person \n" +
                 "where id_fce_eligibility = ? \n" +
                 "MINUS \n" +
                 "select distinct id_person, id_fce_person \n" +
                 "from fce_income \n" +
                 "where id_fce_eligibility = ? \n";
    if (isIncome(incomeOrResource)) {
      sql += "  and ind_income_source = 'Y' \n";
    } else {
      sql += "  and ind_resource_source = 'Y' \n";
    }

    PreparedStatement preparedStatement = null;
    List list;
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setLong(1, idFceEligibility);
      preparedStatement.setLong(2, idFceEligibility);
      list = SqlHelper.createListFromQuery(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      Map map = (Map) iterator.next();
      long idPerson = SqlHelper.getLong(map, "ID_PERSON");
      long idFcePerson = SqlHelper.getLong(map, "ID_FCE_PERSON");
      //create a blank income
      createBlankFceIncome(fce, idFceEligibility, idFcePerson, idPerson, idFcePerson == childIdFcePerson,
                           incomeOrResource);
    }
  }

  private static void createBlankFceIncome(Fce fce, long idFceEligibility, long idFcePerson,
                                           long idPerson, boolean isChild, boolean incomeOrResource) {
    FceIncomeDB fceIncomeDB = new FceIncomeDB();

    fceIncomeDB.setIdPerson(idPerson);
    fceIncomeDB.setIdFcePerson(idFcePerson);
    fceIncomeDB.setIdFceEligibility(idFceEligibility);

    fceIncomeDB.setIndChild(isChild);
    fceIncomeDB.setIndFamily((isChild == false));

    fceIncomeDB.setIndIncomeSource(isIncome(incomeOrResource));
    fceIncomeDB.setIndResourceSource(isResource(incomeOrResource));
    fceIncomeDB.setCdType(null);
    fceIncomeDB.setIndNone(true);

    createFceIncome(fce, fceIncomeDB);
  }

  private static void deleteBlankRecords(Connection connection, long idFceEligibility, boolean incomeOrResource)
          throws SQLException {
    String resourceCheck = "ind_income_source = 'Y'";
    if (isResource(incomeOrResource)) {
      resourceCheck = "ind_resource_source = 'Y'";
    }

    //If EJB store fails, records weren't saved to the database prior to
    //this transaction; so records are incorrectly being marked for deletion
    String delete = "delete \n" +
                    "from fce_income outer \n" +
                    "where id_inc_rsrc = 0 \n" +
                    "  and id_fce_eligibility = ? \n" +
                    "  and " + resourceCheck + " \n" +
                    "  and id_fce_person in \n" +
                    "  (select id_fce_person  \n" +
                    "   from fce_income \n" +
                    "   where id_fce_person = outer.id_fce_person \n" +
                    "   and id_fce_eligibility = ? \n" +
                    "   and id_inc_rsrc <> 0  \n" +
                    "   and " + resourceCheck + ") \n";

    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement(delete);
      preparedStatement.setLong(1, idFceEligibility);
      preparedStatement.setLong(2, idFceEligibility);
      preparedStatement.executeUpdate();
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  @SuppressWarnings({"deprecation"})
  protected static List<FceExpendituresDB> findFceExpenditures(Connection connection, long idFceEligibility)
          throws SQLException {
    String sql = "select fce_expenditures.* \n" +
                 "from fce_expenditures \n" +
                 "where \n" +
                 " fce_expenditures.id_fce_eligibility = ? \n";
    PreparedStatement preparedStatement = null;
    List<FceExpendituresDB> output;
    List rows;
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setLong(1, idFceEligibility);
      output = new ArrayList<FceExpendituresDB>();
      rows = SqlHelper.createListFromQuery(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    Iterator iterator = rows.iterator();
    while (iterator.hasNext()) {
      Map map = (Map) iterator.next();
      FceExpendituresDB fceExpendituresDB = new FceExpendituresDB();
      FceExpendituresDB.populateWithMap(fceExpendituresDB, map);
      output.add(fceExpendituresDB);
    }
    return output;
  }

  @SuppressWarnings({"deprecation"})
  protected static List<FceExpendituresDB> findFceExpendituresForChild(Connection connection, long idFceEligibility, long idFcePerson)
          throws SQLException {
    String sql = "select fce_expenditures.* \n" +
                 "from fce_expenditures \n" +
                 "where \n" +
                 " fce_expenditures.id_fce_eligibility = ? \n" +
                 " and fce_expenditures.id_fce_person = ? \n";
    PreparedStatement preparedStatement = null;
    List<FceExpendituresDB> output;
    List rows;
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setLong(1, idFceEligibility);
      preparedStatement.setLong(2, idFcePerson);
      output = new ArrayList<FceExpendituresDB>();
      rows = SqlHelper.createListFromQuery(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    Iterator iterator = rows.iterator();
    while (iterator.hasNext()) {
      Map map = (Map) iterator.next();
      FceExpendituresDB fceExpendituresDB = new FceExpendituresDB();
      FceExpendituresDB.populateWithMap(fceExpendituresDB, map);
      output.add(fceExpendituresDB);
    }
    return output;
  }

  //in case someone decides to reassign true/false values to income/resource
  private static final boolean isIncome(boolean incomeOrResource) {
    return (incomeOrResource == INCOME);
  }

  //in case someone decides to reassign true/false values to income/resource
  private static final boolean isResource(boolean incomeOrResource) {
    return (incomeOrResource == RESOURCE);
  }

  //in case someone decides to reassign true/false values to child/family
  private static final boolean isChild(boolean childOrFamily) {
    return (childOrFamily == CHILD);
  }

  protected static void saveExpenditures(List<FceExpendituresDB> list, Fce fce) {
    if (list == null) {
      return;
    }
    Iterator<FceExpendituresDB> iterator = list.iterator();
    while (iterator.hasNext()) {
      FceExpendituresDB fceExpendituresDB = iterator.next();
      if (fceExpendituresDB.getIdPerson() != 0) {
        fce.saveFceExpenditures(fceExpendituresDB);
      }
    }
  }
  
  protected static void copyExpenditures(Fce fce,
                                       Connection connection,
                                       long idFceEligibilityOld,
                                       long idFceEligibilityNew,
                                       long childIdFcePerson)
          throws SQLException {
    if (idFceEligibilityOld == 0 || idFceEligibilityNew == 0 || childIdFcePerson == 0) {
      return;
    }
    List<FceExpendituresDB> list = findFceExpendituresForChild(connection, idFceEligibilityOld, childIdFcePerson);
    
    Iterator<FceExpendituresDB> iterator = list.iterator();
    
    while (iterator.hasNext()){
      FceExpendituresDB original = iterator.next();
      
      FceExpendituresDB copy = new FceExpendituresDB();
      copy.setIdFceExpenditures(0);
      copy.setIdFceEligibility(idFceEligibilityNew);
      copy.setIdFcePerson(original.getIdFcePerson());
      copy.setAmtPdMonthly(original.getAmtPdMonthly());
      copy.setIdLastUpdatePerson(original.getIdLastUpdatePerson());
      copy.setNmServiceProvider(original.getNmServiceProvider());
      copy.setIdPersonCareReceive(original.getIdPersonCareReceive());
      
      fce.saveFceExpenditures(copy);
    }
  }
  
  /**
   * Find the n'th xxxxday of specified month (for instance find 1st sunday
   * of May 2006; findNthOfMonth (1, Calendar.SUNDAY, Calendar.MAY, 2006);
   * Return null if the specified day doesn't exists.
   *
   * @param n          Nth day to look for.
   * @param dayOfWeek  Day to look for (Calendar.XXXDAY).
   * @param month      Month to check (Calendar.XXX).
   * @param year       Year to check.
   * @return           Required GregorianCalendar (or null if non-existent)
   * @throws IllegalArgumentException if dyaOfWeek parameter
   *                   doesn't represent a valid day.
   */
  protected static GregorianCalendar getNthOfMonth(int n, int dayOfWeek, int month, int year) {
    // Validate the dayOfWeek argument
    if (dayOfWeek < 1 || dayOfWeek > 7)
      throw new IllegalArgumentException("Invalid day of week: " + dayOfWeek);

    GregorianCalendar first = new GregorianCalendar(year, month, 1);

    int offset = dayOfWeek - first.get(GregorianCalendar.DAY_OF_WEEK);
    if (offset < 0) offset = 7 + offset;

    int dayNo = (n - 1) * 7 + offset + 1;

    return dayNo > first.getActualMaximum(GregorianCalendar.DAY_OF_MONTH) ? null : new GregorianCalendar(year, month, dayNo);
  }
}
