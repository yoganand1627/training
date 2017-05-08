package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

import gov.georgia.dhr.dfcs.sacwis.structs.output.RestrictedFundsSO;

@SuppressWarnings("serial")
public class RestrictedFundsSI implements Serializable {
  private RestrictedFundsSO oldData;
  private int idPerson;
  private double reservedAmount;
  private String reservedReason;
  private boolean submitForApproval;
  private int idEvent;

  public int getIdPerson() {
    return idPerson;
  }

  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }

  public RestrictedFundsSO getOldData() {
    return oldData;
  }

  public void setOldData(RestrictedFundsSO oldData) {
    this.oldData = oldData;
  }

  public double getReservedAmount() {
    return reservedAmount;
  }

  public void setReservedAmount(double reservedAmount) {
    this.reservedAmount = reservedAmount;
  }

  public String getReservedReason() {
    return reservedReason;
  }

  public void setReservedReason(String reservedReason) {
    this.reservedReason = reservedReason;
  }

  public boolean isSubmitForApproval() {
    return submitForApproval;
  }

  public void setSubmitForApproval(boolean submitForApproval) {
    this.submitForApproval = submitForApproval;
  }

  public int getIdEvent() {
    return idEvent;
  }

  public void setIdEvent(int idEvent) {
    this.idEvent = idEvent;
  }
}
