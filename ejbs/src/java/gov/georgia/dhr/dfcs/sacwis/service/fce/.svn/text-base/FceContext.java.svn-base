package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class FceContext implements Serializable {
  protected long idEvent = 0;
  protected long idPerson = 0;
  protected long idFceApplication = 0;
  protected long idFcePerson = 0;
  protected long idFceEligibility = 0;
  protected long idFceReview = 0;
  protected long idFceExpenditures = 0;
  protected Fce fce;

  public void setFce(Fce fce) {
    this.fce = fce;
  }
  
  public long getIdEvent() {
    return idEvent;
  }

  public void setIdEvent(long idEvent) {
    this.idEvent = idEvent;
  }

  public long getIdPerson() {
    return idPerson;
  }

  public void setIdPerson(long idPerson) {
    this.idPerson = idPerson;
  }

  public long getIdFceApplication() {
    return idFceApplication;
  }

  public void setIdFceApplication(long idFceApplication) {
    this.idFceApplication = idFceApplication;
  }

  public long getIdFcePerson() {
    return idFcePerson;
  }

  public void setIdFcePerson(long idFcePerson) {
    this.idFcePerson = idFcePerson;
  }

  public long getIdFceEligibility() {
    return idFceEligibility;
  }

  public void setIdFceEligibility(long idFceEligibility) {
    this.idFceEligibility = idFceEligibility;
  }

  public long getIdFceReview() {
    return idFceReview;
  }

  public void setIdFceReview(long idFceReview) {
    this.idFceReview = idFceReview;
  }
  
  public long getIdFceExpenditures() {
    return idFceExpenditures;
  }

  public void setIdFceExpenditures(long idFceExpenditures) {
    this.idFceExpenditures = idFceExpenditures;
  }

  public FceApplicationDB getFceApplicationDB(Fce fce) {
    return fce.retrieveFceApplication(idFceApplication);
  }

  public FceEligibilityDB getFceEligibilityDB(Fce fce) {
    return fce.retrieveFceEligibility(idFceEligibility);
  }

  @SuppressWarnings({"deprecation"})
  public EligibilityDB getEligibilityDB(Connection connection) throws SQLException {
    /** @todo remove extraneous comment */
    //!!! copied from OldEligibilityHelper
    //need to delegate to it (once it's checked in & renamed)
    PreparedStatement preparedStatement = null;
    List list;
    try {
      preparedStatement = connection.prepareStatement("select * \n" +
                                                      "from eligibility \n" +
                                                      "where id_elig_event = ? \n");
      preparedStatement.setLong(1, idEvent);
      list = SqlHelper.createListFromQuery(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    if (list.size() == 0) {
      return null;
    }
    if (list.size() > 1) {
      throw new IllegalStateException("expected only 1 result (got " + list.size() + ").");
    }
    HashMap hashMap = (HashMap) list.get(0);
    EligibilityDB eligibilityDB = new EligibilityDB();
    EligibilityDB.populateWithMap(eligibilityDB, hashMap);
    return eligibilityDB;
  }
  
  public FcePersonDB getFcePersonDBByIdFcePerson(Fce fce) {
    return fce.retrieveFcePerson(idFcePerson);
  }
  
  public FcePersonDB getFcePersonDB(Fce fce) {
    return fce.retrieveFcePersonByIdPerson(idPerson);
  }

  public FceReviewDB getFceReviewDB(Fce fce) {
    return fce.retrieveFceReview(idFceReview);
  }

  public String getCdEventStatus(Connection connection) throws SQLException {
    return EventHelper.findEvent(connection, idEvent).getCdEventStatus();
  }
}
