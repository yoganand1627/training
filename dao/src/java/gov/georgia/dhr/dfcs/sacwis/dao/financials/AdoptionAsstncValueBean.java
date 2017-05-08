package gov.georgia.dhr.dfcs.sacwis.dao.financials;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;

/**
 * Holds all data pertaining to an Adoption Asstnc Agreement.
 *
 * @author Jason Rios, February 5, 2003
 */
public class AdoptionAsstncValueBean extends BaseValueBean {
  // instance variables
  private int caseId;
  private int stageId;
  private int adoptionAsstncId;
  private Date adoptionAsstncDateLastUpdate;
  private int personId;
  private int payeeId;
  private int placementEvenId;
  private double adoptionAsstncAmount;
  private String closureReasonCode;
  private String adoptionAsstncTypeCode;
  private org.exolab.castor.types.Date dateAgreementSent;
  private org.exolab.castor.types.Date dateAgreementReturned;
  private org.exolab.castor.types.Date dateApplicationSent;
  private org.exolab.castor.types.Date dateApplicationReturned;
  private org.exolab.castor.types.Date dateApproved;
  private org.exolab.castor.types.Date dateStart;
  private org.exolab.castor.types.Date dateEnd;
  private org.exolab.castor.types.Date dateLastInvoice;
  private boolean hasThirdPartyInsurance;
  private boolean isPreviouslyProcessed;
  private String reasonNeeded;

  /** Constructor */
  public AdoptionAsstncValueBean() {
    caseId = 0;
    stageId = 0;
    adoptionAsstncId = 0;
    adoptionAsstncDateLastUpdate = null;
    personId = 0;
    payeeId = 0;
    placementEvenId = 0;
    adoptionAsstncAmount = 0.0;
    closureReasonCode = null;
    adoptionAsstncTypeCode = null;
    dateAgreementSent = null;
    dateAgreementReturned = null;
    dateApplicationSent = null;
    dateApplicationReturned = null;
    dateApproved = null;
    dateStart = null;
    dateEnd = null;
    dateLastInvoice = null;
    hasThirdPartyInsurance = false;
    isPreviouslyProcessed = false;
    reasonNeeded = null;
  }

  public double getAdoptionAsstncAmount() {
    return adoptionAsstncAmount;
  }

  public Date getAdoptionAsstncDateLastUpdate() {
    return adoptionAsstncDateLastUpdate;
  }

  public int getAdoptionAsstncId() {
    return adoptionAsstncId;
  }

  public String getAdoptionAsstncTypeCode() {
    return adoptionAsstncTypeCode;
  }

  public int getCaseId() {
    return caseId;
  }

  public String getClosureReasonCode() {
    return closureReasonCode;
  }

  public org.exolab.castor.types.Date getDateAgreementReturned() {
    return dateAgreementReturned;
  }

  public org.exolab.castor.types.Date getDateAgreementSent() {
    return dateAgreementSent;
  }

  public org.exolab.castor.types.Date getDateApplicationReturned() {
    return dateApplicationReturned;
  }

  public org.exolab.castor.types.Date getDateApplicationSent() {
    return dateApplicationSent;
  }

  public org.exolab.castor.types.Date getDateApproved() {
    return dateApproved;
  }

  public org.exolab.castor.types.Date getDateEnd() {
    return dateEnd;
  }

  public org.exolab.castor.types.Date getDateLastInvoice() {
    return dateLastInvoice;
  }

  public org.exolab.castor.types.Date getDateStart() {
    return dateStart;
  }

  public boolean hasThirdPartyInsurance() {
    return hasThirdPartyInsurance;
  }

  public boolean isPreviouslyProcessed() {
    return isPreviouslyProcessed;
  }

  public int getPayeeId() {
    return payeeId;
  }

  public int getPersonId() {
    return personId;
  }

  public int getPlacementEvenId() {
    return placementEvenId;
  }

  public String getReasonNeeded() {
    return reasonNeeded;
  }

  public int getStageId() {
    return stageId;
  }

  public void setAdoptionAsstncAmount(double adoptionAsstncAmount) {
    this.adoptionAsstncAmount = adoptionAsstncAmount;
  }

  public void setAdoptionAsstncDateLastUpdate(Date adoptionAsstncDateLastUpdate) {
    this.adoptionAsstncDateLastUpdate = adoptionAsstncDateLastUpdate;
  }

  public void setAdoptionAsstncId(int adoptionAsstncId) {
    this.adoptionAsstncId = adoptionAsstncId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public void setClosureReasonCode(String closureReasonCode) {
    this.closureReasonCode = closureReasonCode;
  }

  public void setDateAgreementReturned(org.exolab.castor.types.Date dateAgreementReturned) {
    this.dateAgreementReturned = dateAgreementReturned;
  }

  public void setDateAgreementSent(org.exolab.castor.types.Date dateAgreementSent) {
    this.dateAgreementSent = dateAgreementSent;
  }

  public void setDateApplicationReturned(org.exolab.castor.types.Date dateApplicationReturned) {
    this.dateApplicationReturned = dateApplicationReturned;
  }

  public void setDateApplicationSent(org.exolab.castor.types.Date dateApplicationSent) {
    this.dateApplicationSent = dateApplicationSent;
  }

  public void setDateApproved(org.exolab.castor.types.Date dateApproved) {
    this.dateApproved = dateApproved;
  }

  public void setDateEnd(org.exolab.castor.types.Date dateEnd) {
    this.dateEnd = dateEnd;
  }

  public void setDateLastInvoice(org.exolab.castor.types.Date dateLastInvoice) {
    this.dateLastInvoice = dateLastInvoice;
  }

  public void setDateStart(org.exolab.castor.types.Date dateStart) {
    this.dateStart = dateStart;
  }

  public void setAdoptionAsstncTypeCode(String adoptionAsstncTypeCode) {
    this.adoptionAsstncTypeCode = adoptionAsstncTypeCode;
  }

  public void setHasThirdPartyInsurance(boolean hasThirdPartyInsurance) {
    this.hasThirdPartyInsurance = hasThirdPartyInsurance;
  }

  public void setIsPreviouslyProcessed(boolean isPreviouslyProcessed) {
    this.isPreviouslyProcessed = isPreviouslyProcessed;
  }

  public void setPayeeId(int payeeId) {
    this.payeeId = payeeId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public void setPlacementEvenId(int placementEvenId) {
    this.placementEvenId = placementEvenId;
  }

  public void setReasonNeeded(String reasonNeeded) {
    this.reasonNeeded = reasonNeeded;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  /**
   * Get a string representation of the variable names and values.
   *
   * @ return String
   */
  public String toString() {
    return (
            "\n" +
            "AdoptionAsstncValueBean \n" +
            "      caseId = " + caseId + "\n" +
            "      stageId = " + stageId + "\n" +
            "      adoptionAsstncId = " + adoptionAsstncId + "\n" +
            "      adoptionAsstncDateLastUpdate = " + adoptionAsstncDateLastUpdate + "\n" +
            "      personId = " + personId + "\n" +
            "      payeeId = " + payeeId + "\n" +
            "      placementEvenId = " + placementEvenId + "\n" +
            "      adoptionAsstncAmount = " + adoptionAsstncAmount + "\n" +
            "      closureReasonCode = " + closureReasonCode + "\n" +
            "      adoptionAsstncTypeCode = " + adoptionAsstncTypeCode + "\n" +
            "      dateAgreementSent = " + dateAgreementSent + "\n" +
            "      dateAgreementReturned = " + dateAgreementReturned + "\n" +
            "      dateApplicationSent = " + dateApplicationSent + "\n" +
            "      dateApplicationReturned = " + dateApplicationReturned + "\n" +
            "      dateApproved = " + dateApproved + "\n" +
            "      dateStart = " + dateStart + "\n" +
            "      dateEnd = " + dateEnd + "\n" +
            "      dateLastInvoice = " + dateLastInvoice + "\n" +
            "      hasThirdPartyInsurance = " + hasThirdPartyInsurance + "\n" +
            "      isPreviouslyProcessed = " + isPreviouslyProcessed + "\n" +
            "      reasonNeeded = " + reasonNeeded + "\n" +
            "end AdoptionAsstncValueBean \n");
  }
}

