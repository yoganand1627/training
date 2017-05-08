package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SequenceHelper;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class EligibilityHelper implements Serializable {
  
  private final static String FOSTER_CARE_EVENT = CodesTables.CEVNTTYP_FCA;
  private final static String APPROVE = CodesTables.CEVTSTAT_APRV;
  private final static String CD_INITIAL_APP = CodesTables.CFCEAPRE_A;
  
  protected static boolean isChildNewToSubcare(Connection connection, long idPerson) throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select id_fce_application \n" +
                                                      "from fce_application \n" +
                                                      "where id_person = ? \n" +
                                                      "  and rownum < 2 \n");
      preparedStatement.setLong(1, idPerson);
      long idFceApplication = SqlHelper.selectLong(preparedStatement);
      return idFceApplication != 0l;
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static FceEligibilityDB copyEligibility(Fce fce, Connection connection,
                                                    FceEligibilityDB lastFceEligibilityDB,
                                                    long idLastUpdatePerson) throws SQLException {
    return copyEligibility(fce, connection, lastFceEligibilityDB, idLastUpdatePerson, true);
  }

  protected static FceEligibilityDB copyEligibility(Fce fce, Connection connection,
                                                    FceEligibilityDB lastFceEligibilityDB,
                                                    long idLastUpdatePerson, boolean copyReasonsNotEligible)
          throws SQLException {
    long idCase = lastFceEligibilityDB.getIdCase();
    long idStage = lastFceEligibilityDB.getIdStage();

    FceEligibilityDB fceEligibilityDB = new FceEligibilityDB();
    fceEligibilityDB.setIdCase(idCase);
    fceEligibilityDB.setIdLastUpdatePerson(idLastUpdatePerson);
    fceEligibilityDB.setIdStage(idStage);
    // Save the FceEligibility with the non-null fields to get the saved ID
    int idFceEligibility = fce.saveInitialFceEligibility(fceEligibilityDB);
    fceEligibilityDB = fce.retrieveFceEligibility(idFceEligibility);
    //fceEligibilityDB.setIdFceEligibility(idFceEligibility);

    fceEligibilityDB.setIdFceApplication(lastFceEligibilityDB.getIdFceApplication());
    //fceEligibilityDB.setIdFceReview(lastFceEligibilityDB.getIdFceReview());

    //NO LONGER COPIES ALL NON-ID ATTRIBUTES

    //!!! should I copy these ?
    //used by ApplicationReasonsNotEligible.calculateSystemDerivedParentalDeprivation
    //even from review
    fceEligibilityDB.setNbrCertifiedGroup(lastFceEligibilityDB.getNbrCertifiedGroup());
    
    // MR-053: The summary should always reflect whether the child is eligible and the actual eligibility based on the Initial 
    // or latest Amended Foster Care Application
    FceEligibilityDB fceEligibilityOfInitialOrAmendedApp = EligibilityHelper.findLatestInitialOrAmendedFceEligibility(fce, connection, 
                                                                                                                      idStage, FOSTER_CARE_EVENT, APPROVE, CD_INITIAL_APP);
    if (fceEligibilityOfInitialOrAmendedApp != null) {
      fceEligibilityDB.setIndEligible(fceEligibilityOfInitialOrAmendedApp.getIndEligible());
      // Get the Actual Eligibility from the Summary created from the initial or amended application
//      EligibilityDB initialOrAmendedLegacyElig = (findLatestInitialOrAmendedLegacyEligibility(connection, fceEligibilityOfInitialOrAmendedApp.getIdFceEligibility()));
//      if (initialOrAmendedLegacyElig != null) {
//        fceEligibilityDB.setCdEligibilityActual(initialOrAmendedLegacyElig.getCdEligActual());
//      }
      // MR-053: The summary should always reflect the reasons the child is not eligible based on the Initial 
      // or latest Amended Foster Care Application
      if (copyReasonsNotEligible) {
        ReasonNotEligibleHelper.copyReasonsNotEligible(connection, fceEligibilityOfInitialOrAmendedApp.getIdFceEligibility(), idFceEligibility);
      }

    }

    //displayed on FosterCareReview page from application
    fceEligibilityDB.setCdPersonCitizenship(lastFceEligibilityDB.getCdPersonCitizenship());

    //copy fce_person
    long lastIdFcePerson = lastFceEligibilityDB.getIdFcePerson();
    FcePersonDB fcePersonDB = fce.retrieveFcePerson(lastIdFcePerson);

    //set idPerson to 0 to force the creation of a new record
    fcePersonDB.setIdFcePerson(0);
    fcePersonDB.setIdFceEligibility(idFceEligibility);

    int idFcePerson = fce.saveFcePerson(fcePersonDB);

    //associate child with eligibility
    fceEligibilityDB.setIdFcePerson(idFcePerson);
    fceEligibilityDB.setIdPerson(fcePersonDB.getIdPerson());
    fce.updateInitialFceEligibility(fceEligibilityDB);
    return fce.retrieveFceEligibility(idFceEligibility);
  }

  /**
   * <pre>gets either the last eligibility associated with a closed review event
   *           or     the last eligibility associated with an approved application event
   * </pre>
   *
   * @param connection
   * @param idStage
   * @return
   * @throws SQLException
   */
  protected static FceEligibilityDB findLatestEligibilityForStage(Connection connection, long idStage,
                                                                  Fce fce)
          throws SQLException {
    // Assumes that a review can't be open when an eligibility specialist clicks confirm on Eligibility Determination.
    // Otherwise, need to find latest application, then see if there's a review for that application.
    PreparedStatement preparedStatement = null;
    long idFceEligibility;
    try {
      preparedStatement = connection.prepareStatement("select id_fce_eligibility from (\n" +
                                                      "  select id_fce_eligibility as id_fce_eligibility,  \n" +
                                                      "         dt_application_complete as date_complete \n" +
                                                      "  from fce_application \n" +
                                                      "  where id_stage = ? \n" +
                                                      "    and dt_application_complete is not null \n" +
                                                      "  UNION \n" +
                                                      "  select id_fce_eligibility as id_fce_eligibility, \n" +
                                                      "         dt_review_complete as date_complete \n" +
                                                      "  from fce_review \n" +
                                                      "  where id_stage = ? \n" +
                                                      "    and dt_review_complete is not null \n" +
                                                      ") \n" +
                                                      "order by date_complete desc \n");
      preparedStatement.setLong(1, idStage);
      preparedStatement.setLong(2, idStage);
      idFceEligibility = SqlHelper.selectLong(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    if (idFceEligibility == 0) {
      return null;
    }
    return fce.retrieveFceEligibility(idFceEligibility);
  }

  protected static FceEligibilityDB createEligibility(long idCase, long idLastUpdatePerson, long idStage) {
    FceEligibilityDB fceEligibilityDB = new FceEligibilityDB();
    fceEligibilityDB.setIdCase(idCase);
    fceEligibilityDB.setIdLastUpdatePerson(idLastUpdatePerson);
    fceEligibilityDB.setIdStage(idStage);
    return fceEligibilityDB;
  }

  protected static FceEligibilityDB findEligibilityByIdFceApplication(Connection connection, long idFceApplication,
                                                                      Fce fce)
          throws SQLException {
    //!!! custom finder; need relationship
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select id_fce_eligibility \n" +
                                                      "from fce_application \n" +
                                                      "where id_fce_application = ?\n");
      preparedStatement.setLong(1, idFceApplication);
      long idFceEligibility = SqlHelper.selectLong(preparedStatement);
      return fce.retrieveFceEligibility(idFceEligibility);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  //!!! rather have FceEligibilityHelper and EligibilityHelper
  protected static EligibilityDB findLegacyEligibility(Connection connection, long idEligibilityEvent)
          throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select * \n" +
                                                      "from eligibility \n" +
                                                      "where id_elig_event = ? \n");
      preparedStatement.setLong(1, idEligibilityEvent);
      return findLegacyEligibility(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static boolean isLatestLegacyEligibilityOpenPrsPaid(Connection connection, long idCase, long idPerson)
          throws SQLException {
    EligibilityDB eligibilityDB = findLatestLegacyEligibility(connection, idCase, idPerson);
    if (eligibilityDB == null) {
      return false;
    }
    Date endDate = eligibilityDB.getDtEligEnd();
    if ((endDate != null) &&
        (DateHelper.MAX_JAVA_DATE.getTime() != endDate.getTime())) {
      return false;
    }
    //eligibility is open
    //is it a paid eligibility (!!! fill in better constant names)
    String actualEligibility = eligibilityDB.getCdEligActual();
    return CodesTables.CELIGIBI_010.equals(actualEligibility) ||
           CodesTables.CELIGIBI_020.equals(actualEligibility) ||
           CodesTables.CELIGIBI_030.equals(actualEligibility);
  }

  protected static EligibilityDB findLatestLegacyEligibility(Connection connection, long idCase, long idPerson)
          throws SQLException {
    //This should return the latest PROC/COMP legacy eligibility
    //Talked to Christine and that's fine:
    //it just needs a start date as the eligibility will have to
    //be end-dated before the review can be completed
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select * \n" +
                                                      "from eligibility \n" +
                                                      "where id_case = ? \n" +
                                                      "  and id_person = ? \n" +
                                                      "  and cd_elig_actual is not null \n" +
                                                      "  and dt_elig_start != dt_elig_end \n" +
                                                      "order by dt_elig_start desc, dt_elig_end desc \n");
      preparedStatement.setLong(1, idCase);
      preparedStatement.setLong(2, idPerson);
      return findLegacyEligibility(preparedStatement, true);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  //!!! rather have FceEligibilityHelper and EligibilityHelper
  private static EligibilityDB findLegacyEligibility(PreparedStatement preparedStatement) throws SQLException {
    return findLegacyEligibility(preparedStatement, false);
  }

  @SuppressWarnings({"deprecation"})
  private static EligibilityDB findLegacyEligibility(PreparedStatement preparedStatement, boolean moreThan1ResultOk)
          throws SQLException {
    List list = SqlHelper.createListFromQuery(preparedStatement);
    if (list.size() == 0) {
      return null;
    }
    if ((moreThan1ResultOk == false) &&
        (list.size() > 1)) {
      throw new IllegalStateException("expected only 1 result (got " + list.size() + ")");
    }
    HashMap hashMap = (HashMap) list.get(0);
    EligibilityDB eligibilityDB = new EligibilityDB();
    EligibilityDB.populateWithMap(eligibilityDB, hashMap);
    return eligibilityDB;
  }
  
  protected static FceEligibilityDB findLatestInitialOrAmendedFceEligibility (Fce fce, Connection connection, long idEventStage, 
                                                               String cdEventType, String cdEventStatus, String cdApplication) throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select a.id_fce_eligibility \n" +
                                                      "from event e, fce_application a \n" +
                                                      "where e.id_event_stage = a.id_stage \n" +
                                                      "  and  e.id_event_stage = ? \n" +
                                                      "  and e.cd_event_type = ? \n" +
                                                      "  and e.cd_event_status = ? \n" +
                                                      "  and  e.id_event = a.id_event \n" +
                                                      "  and a.cd_application = ? \n" +
                                                      "order by e.dt_event_occurred desc, e.dt_last_update desc \n");
      preparedStatement.setLong(1, idEventStage);
      preparedStatement.setString(2, cdEventType);
      preparedStatement.setString(3, cdEventStatus);
      preparedStatement.setString(4, cdApplication);
      List list = SqlHelper.createListFromQuery(preparedStatement);
      if (list.size() == 0) {
        return null;
      }
      HashMap hashMap = (HashMap) list.get(0);
      Number idFceEligibility = (Number) hashMap.get("ID_FCE_ELIGIBILITY"); 
      return fce.retrieveFceEligibility(idFceEligibility.longValue());
      
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }
  
  protected static EligibilityDB findLatestInitialOrAmendedLegacyEligibility (Connection connection, long idFceEligibility) throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("select * \n" + 
                                                      "from eligibility e, fce_eligibility f \n" + 
                                                      "where f.id_eligibility_event = e.elig_event \n" +
                                                      "  and f.id_fce_application in \n" +
                                                      "    (select a.id_fce_application from fce_eligibility b \n" +
                                                      "     where b.id_fce_eligibility = ? ) \n");
      preparedStatement.setLong(1, idFceEligibility);
      return findLegacyEligibility(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static boolean isQuestionAnswered(String question, EligibilityDB eligibilityDB) {
    return question.equals(eligibilityDB.getCdEligCsupQuest1()) ||
           question.equals(eligibilityDB.getCdEligCsupQuest2()) ||
           question.equals(eligibilityDB.getCdEligCsupQuest3()) ||
           question.equals(eligibilityDB.getCdEligCsupQuest4());
  }

  protected static Long nextSequenceVal(Connection connection, String pSequenceName) {
    return (long) SequenceHelper.getSequence(pSequenceName, connection);
  }
}
