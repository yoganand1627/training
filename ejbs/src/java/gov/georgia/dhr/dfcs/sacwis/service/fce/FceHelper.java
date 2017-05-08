package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EventDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePageDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.PersonDB;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FceDataPrefillSI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import org.grnds.facility.log.GrndsTrace;

public class FceHelper extends BaseFceSessionBean implements Serializable {

  protected static final String SQL_MAX_DATE = "to_date('12/31/4712', 'mm/dd/yyyy')";
  protected static final String TRACE_TAG = "FceHelper";
  
  public static final String APPLICATION = CodesTables.CFCEAPRE_A;
  public static final String REAPPLICATION = CodesTables.CFCEAPRE_R;
  public static final String SELF = CodesTables.CRELVICT_SL;
  protected static final String FCE_APPLICATION_TABLE = "fce_application_temp_event";
  protected static final String FCE_APPLICATION_COLUMN = "id_event";

  protected static void syncFceApplicationStatus(Connection connection, FceEligibilityDB fceEligibilityDB,
                                                 FceApplicationDB fceApplicationDB,
                                                 Fce fce) throws SQLException {
    long idFceApplication = fceEligibilityDB.getIdFceApplication();
    long idFceEligibility = fceEligibilityDB.getIdFceEligibility();
    long idFcePerson = fceEligibilityDB.getIdFcePerson();
    long idPerson = fceEligibilityDB.getIdPerson();
    long idStage = fceEligibilityDB.getIdStage();

    fce.updateFceApplicationCdApplication(fceApplicationDB);
    
    //copy CD_PERSON_CITIZENSHIP from person_dtl to eligibility
    String cdPersonCitizenship = PersonHelper.getCdPersonCitizenship(connection, idPerson);
    fce.updateFceEligibilityCdPersonCitizenship(idFceEligibility, cdPersonCitizenship);

    //IND_EVALUATION_CONCLUSION; for AgeCitizenship
    String indEvaluationConclusion = getIndEvaluationConclusion(connection, idFceApplication);
    fce.updateFceApplicationIndEvalConclusion(idFceApplication, indEvaluationConclusion);
    // Update removal date on application
    fce.updateRemovalDate((int) idFceApplication);
    //copy person birthday to fce_person birthday (& calc age)
    FcePersonDB fcePersonDB = fce.retrieveFcePerson(idFcePerson);
    PersonDB personDB = PersonHelper.findPerson(connection, idPerson);
    PersonHelper.updateBirthday(fce, fcePersonDB, personDB);
    // Remove all persons not related to the stage as well as all non principles
    PersonHelper.deleteUnrelatedOrNonPrinciples(connection, idFceEligibility, idStage);
    PersonHelper.createPrinciples(fce, connection, idFceEligibility, idStage);
    IncomeHelper.createIncomeForFcePersons(fce, connection, idFceEligibility, idFcePerson);
    //Check to see if a Removal Address has been selected on Person Detail Screen. If
    //so, update address fields on application
    boolean removalAddr = PersonHelper.getRemovalHomeAddress(connection, fceApplicationDB, fce);
    if (removalAddr) {
      fce.updateFceApplicationPersonAddress(fceApplicationDB);
    }
  }

  protected static String getIndEvaluationConclusion(Connection connection, long idFceApplication)
          throws SQLException {
    PreparedStatement preparedStatement = null;
    long idNarrativeEvent;
    try {
      preparedStatement = connection.prepareStatement("select fce_narrative.id_event \n" +
                                                      "from fce_narrative, \n" +
                                                      "     fce_application \n" +
                                                      "where fce_narrative.id_event = fce_application.id_event \n" +
                                                      "  and fce_application.id_fce_application = ? \n");
      preparedStatement.setLong(1, idFceApplication);
      idNarrativeEvent = SqlHelper.selectLong(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    if (idNarrativeEvent != 0) {
      return ArchitectureConstants.Y;
    }
    return ArchitectureConstants.N;
  }

  protected static void syncFceEligibilityStatus(Connection connection, FceEligibilityDB fceEligibilityDB,
                                                 Fce fce)
          throws SQLException {
    long idPerson = fceEligibilityDB.getIdPerson();
    long idFcePerson = fceEligibilityDB.getIdFcePerson();
    FcePersonDB fcePersonDB = fce.retrieveFcePerson(idFcePerson);

    PersonDB personDB = PersonHelper.findPerson(connection, idPerson);
    PersonHelper.updateBirthday(fce, fcePersonDB, personDB);

    String cdBlocChild = PersonHelper.findBloc(connection, idPerson);
    fceEligibilityDB.setCdBlocChild(cdBlocChild);

    double amtSsi = IncomeHelper.findSsi(connection, idPerson);
    fceEligibilityDB.setAmtSsi(amtSsi);
    fce.updateFceEligibilityCdBlocAmtSsi(fceEligibilityDB.getIdFceEligibility(), cdBlocChild, amtSsi);
  }

  protected static void syncFceReviewStatus(Connection connection, FceEligibilityDB fceEligibilityDB,
                                            FceReviewDB fceReviewDB, Fce fce)
          throws SQLException, EjbValidationException {
    long idPerson = fceEligibilityDB.getIdPerson();
    long idFcePerson = fceEligibilityDB.getIdFcePerson();
    long idFceEligibility = fceEligibilityDB.getIdFceEligibility();

    //update birthdate/age
    FcePersonDB fcePersonDB = PersonHelper.findFcePerson(fce, idFcePerson);
    PersonDB personDB = PersonHelper.findPerson(connection, idPerson);
    PersonHelper.updateBirthday(fce, fcePersonDB, personDB);

    // Update judicial review
    fce.updateReimbursabilityJudicialRequirements(fceReviewDB);

    IncomeHelper.createIncomeForFcePersons(fce, connection, idFceEligibility, idFcePerson);

    //set legal status information on foster care review
    long idCase = fceEligibilityDB.getIdCase();
    Map legalStatus = PersonHelper.findLegalStatusForChild(connection, idCase, idPerson);

    String cdLegalStatStatus = (String) legalStatus.get("CD_LEGAL_STAT_STATUS");
    if (cdLegalStatStatus != null) {
      Date dtLegalStatStatusDt = (Date) legalStatus.get("DT_LEGAL_STAT_STATUS_DT");
      fceReviewDB.setIndRightsTerminated(FceReviewDB.toCharIndicator(true));
      fceReviewDB.setDtRightsTerminated(dtLegalStatStatusDt);
    } else {
      fceReviewDB.setIndRightsTerminated(FceReviewDB.toCharIndicator(false));
      fceReviewDB.setDtRightsTerminated(null);
    }
    fce.saveFceReview(fceReviewDB);
    syncFosterCareRate(fce, connection, fceEligibilityDB, fceReviewDB, idPerson, false);
  }

  /** updates fceEligibilityLocal, fceReviewLocal */
  protected static void syncFosterCareRate(Fce fce, Connection connection,
                                           FceEligibilityDB fceEligibilityDB, FceReviewDB fceReviewDB, long idPerson,
                                           boolean throwException)
          throws SQLException, EjbValidationException {
    fceReviewDB.setIndNoActivePlacement(ArchitectureConstants.N);
    fceReviewDB.setIndNonPrsPaidPlacement(ArchitectureConstants.N);
    fceReviewDB.setIndNoActiveBloc(ArchitectureConstants.N);
    fceReviewDB.setIndNoOpenPaidEligibility(ArchitectureConstants.N);
    fceReviewDB.setIdCurrentPlacementEvent(null);
    fceReviewDB.setIdPlacementRateEvent(null);
    fceReviewDB.setCdRate(null);

    //null means we bypass the reason-not-eligible check; $0 means the child is ineligible
    fceReviewDB.setAmtFosterCareRate(0.0);

    long idCase = fceReviewDB.getIdCase();
    if (EligibilityHelper.isLatestLegacyEligibilityOpenPrsPaid(connection, idCase, idPerson) == false) {
      fceReviewDB.setIndNoOpenPaidEligibility(ArchitectureConstants.Y);
    }

    String cdBlocChild = PersonHelper.findBloc(connection, idPerson);
    fce.updateFceEligibilityCdBlocChild(fceEligibilityDB.getIdFceEligibility(), cdBlocChild);

    if (cdBlocChild == null) {
      trace("syncFosterCareRate: no active bloc");
      fceReviewDB.setIndNoActiveBloc(ArchitectureConstants.Y);
    }

    Map activePlacement =
            PlacementHelper.findActivePlacement(connection, idPerson);

    if (activePlacement == null) {
      trace("syncFosterCareRate: no active placement");

      fceReviewDB.setIndNoActivePlacement(ArchitectureConstants.Y);

      if (throwException) {
        //throw new EjbValidationException(Messages.MSG_CHILD_NO_PLACEMENT, BasePrsException.WARNING_PRIORITY);
      }
      return;
    }

    Number idPlcmtEvent = (Number) activePlacement.get("ID_PLCMT_EVENT");
    fceReviewDB.setIdCurrentPlacementEvent(idPlcmtEvent.longValue());

    String prsPaidPlacementCode =
            PlacementHelper.getPrsPaidPlacementCode(cdBlocChild, activePlacement);

    if (prsPaidPlacementCode == null) {
      trace("syncFosterCareRate: active placement not PRS paid; skipping calculation");

      fceReviewDB.setIndNonPrsPaidPlacement(ArchitectureConstants.Y);
      //bypass the reason-not-eligible check
      fceReviewDB.setAmtFosterCareRate(null);
      return;
    }

    if (cdBlocChild == null) {
      trace("syncFosterCareRate: no active bloc; using highest rate for BLOC 1");
      Double rate = getHighestRateForBloc(connection, CodesTables.CBILPLOC_010);
      fceReviewDB.setAmtFosterCareRate(rate);
      return;
    }

    String cdRsrcFacilType = (String) activePlacement.get("CD_RSRC_FACIL_TYPE");

    if (cdRsrcFacilType == null) {
      trace("syncFosterCareRate: no cdRsrcFacilType on placement");
      if (throwException) {
        throw new EjbValidationException(Messages.MSG_NO_FACILITY_TYPE_RECORDED, BasePrsException.WARNING_PRIORITY);
      }
      return;
    }

    //if PlacementIsEmergencyPlacment, use the highest (non-emergency) rate for Bloc
    if (PlacementHelper.EMERGENCY_PLACEMENT.equals(cdRsrcFacilType)) {
      trace("syncFosterCareRate: emergency placement; using highest " +
            "non-emergency rate for active Bloc: " + cdBlocChild);

      Double rate = getHighestRateForBloc(connection, cdBlocChild);
      fceReviewDB.setAmtFosterCareRate(rate);
      return;
    }

    String codes = PlacementHelper.getPrsPaidPlacementCode(cdBlocChild, activePlacement);

    Map fosterCareRate = findFosterCareRate(connection, codes);

    if (fosterCareRate == null) {
      trace("syncFosterCareRate: no foster care rate found for " +
            "placement (" + idPlcmtEvent.longValue() + ") and BLOC (" + cdBlocChild + "); \n" +
            "\t using highest rate for active bloc");

      Double rate = getHighestRateForBloc(connection, cdBlocChild);
      fceReviewDB.setAmtFosterCareRate(rate);
      return;
    }

    String code = (String) fosterCareRate.get("CODE");
    fceReviewDB.setCdRate(code);

    Number amount = (Number) fosterCareRate.get("AMT_FCARE_RT_UNIT_RATE");
    fceReviewDB.setAmtFosterCareRate(amount.doubleValue());

    trace("syncFosterCareRate: fosterCareRate found");

    fceReviewDB.setIdPlacementRateEvent(idPlcmtEvent.longValue());
    fce.saveFceReview(fceReviewDB);
  }

  @SuppressWarnings({"deprecation"})
  protected static Map findFosterCareRate(Connection connection, String codes) throws SQLException {
    PreparedStatement preparedStatement = null;
    List list;
    try {
      preparedStatement = connection.prepareStatement("select codes.code, \n" +
                                                      "       codes.decode, \n" +
                                                      "       amt_fcare_rt_unit_rate \n" +
                                                      "from foster_care_rate fcr, \n" +
                                                      "     plcmntsc codes \n" +
                                                      "where fcr.dt_fcare_rt_end > sysDate \n" +
                                                      "  and fcr.cd_fcare_rate_service = codes.decode \n" +
                                                      "  and codes.code = ? \n");
      preparedStatement.setString(1, codes);
      list = SqlHelper.createListFromQuery(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    if (list.size() == 0) {
      return null;
    }
    Map map = (Map) list.get(0);
    FceHelper.trace("allAgesRate: " + map);
    return map;
  }

  /** Return highest non-emergency rate for BLOC */
  private static Double getHighestRateForBloc(Connection connection, String bloc)
          throws SQLException {
    bloc = PlacementHelper.getTranslatedLoc(bloc);

    PreparedStatement preparedStatement = null;
    try {
      preparedStatement =
              connection.prepareStatement("select /*+ ORDERED */ max(foster_care_rate.amt_fcare_rt_unit_rate) \n" +
                                          "from plcmntsc, foster_care_rate \n" +
                                          "where plcmntsc.decode = foster_care_rate.cd_fcare_rate_service \n" +
                                          "  and plcmntsc.code like ? \n" +
                                          "  and plcmntsc.code not like ? \n" +
                                          "  and foster_care_rate.dt_fcare_rt_end > sysDate \n");
      preparedStatement.setString(1, (bloc + "%"));
      preparedStatement.setString(2, (bloc + "67%"));
      return SqlHelper.selectDouble(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static void verifyCanSave(Connection connection, FcePageDB fcePageDB)
          throws SQLException, EjbValidationException {
    long idStage = fcePageDB.getIdStage();
    FceHelper.verifyNonZero("idStage", idStage);
    FceHelper.verifyOpenStage(connection, idStage);
    FceHelper.verifyNonZero("idLastUpdatePerson", fcePageDB.getIdLastUpdatePerson());
  }

  private static void verifyOpenStage(Connection connection, long idStage)
          throws SQLException, EjbValidationException {
    String query = "select ind_stage_close from stage where id_stage = ?";

    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setLong(1, idStage);

      String indStageClose = SqlHelper.selectString(preparedStatement);
      if (PersonDB.isTrue(indStageClose)) {
        throw new EjbValidationException(Messages.MSG_SYS_STAGE_CLOSED, BasePrsException.WARNING_PRIORITY);
      }
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static void trace(String string) {
    GrndsTrace.msg(TRACE_TAG, 7, string);
  }

  protected static void verifyNonZero(String propertyName, long value) {
    if (value == 0) {
      throw new IllegalStateException("property '" + propertyName + "' must be non-zero");
    }
  }
}
