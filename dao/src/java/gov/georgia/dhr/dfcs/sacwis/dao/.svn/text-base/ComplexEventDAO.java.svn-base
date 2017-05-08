package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.Map;

public interface ComplexEventDAO {
  public static final String ELIG_DETERM_SUB = "3120";
  public static final String ELIG_DETERM_ADO = "8620";
  public static final String ELIG_DETERM_PAD = "9110";
  public static final String RISK_ASSESSMENT = "2290";
  public static final String RISK_ASSESSMENT_SUB = "3250";
  public static final String RISK_ASSESSMENT_ADO = "8750";
  public static final String RISK_ASSESSMENT_FPR = "7185";

  /**
   * This method will do a partial update on the event table using the given fields.
   *
   * @param cdEventStatus
   * @param cdEventType
   * @param dtEventOccurred
   * @param idPerson
   * @param idStage
   * @param txtEventDescr
   * @param cdTask
   * @param idEvent
   * @param dtLastUpdate
   */
  public int updateEventByIdEventDtLastUpdate(String cdEventStatus, String cdEventType, Date dtEventOccurred,
                                              int idPerson, int idStage, String txtEventDescr, String cdTask,
                                              int idEvent, Date dtLastUpdate);

  /**
   * This method will do a partial update on the event table using the given fields.
   *
   * @param cdEventStatus
   * @param cdEventType
   * @param dtEventOccurred
   * @param idStage
   * @param txtEventDescr
   * @param cdTask
   * @param idEvent
   * @param dtLastUpdate
   */
public int updatePortalEventByIdEventDtLastUpdate(String cdEventStatus, String cdEventType, Date dtEventOccurred,
                                              int idStage, String txtEventDescr, String cdTask,
                                              int idEvent, Date dtLastUpdate);

  /**
   * Retrieves IdEvent and idEventStatus by querying Event and RiskAssessment tables.
   *
   * @param idStage
   * @param cdTask
   */
  public Map findIdEventAndCdEventStatus(int idStage, String cdTask);

  /**
   * Partial insert of Event table using the supplied parameters(column values).
   *
   * @param cdEventStatus
   * @param cdEventType
   * @param dtEventOccurred
   * @param idPerson
   * @param idStage
   * @param txtEventDescr
   * @param cdTask
   * @return int The int value, 'idEvent', of the newly inserted row.
   */
  public int insertEvent(String cdEventStatus, String cdEventType, Date dtEventOccurred, int idPerson, int idStage,
                         String txtEventDescr, String cdTask);
}


