package gov.georgia.dhr.dfcs.sacwis.dao.financials;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;

/**
 * Holds all data pertaining to a Service Authorization.
 *
 * @author Wes Thompson, create date:  08/11/2005
 *         <p/>
 *         Change History: Date      User           Description --------  -------------
 *         ---------------------------------------------------
 */

public class ServiceAuthValueBean extends BaseValueBean {
  // instance variables
  private int caseId;
  private int contractId;
  private int resourceId;
  private int stageId;
  private int serviceAuthId;
  private Date serviceAuthDateLastUpdate;
  private Date serviceAuthDateEffective;
  private Date serviceAuthDateVerbalReferral;
  private int personId;
  private double serviceAuthAmount;
  private String serviceAuthCounty;
  private String serviceAuthAbilityToRespond;
  private String serviceAuthCategory;
  private String serviceAuthRegion;
  private String serviceAuthService;

  /** Constructor */
  public ServiceAuthValueBean() {
    caseId = 0;
    contractId = 0;
    resourceId = 0;
    stageId = 0;
    serviceAuthId = 0;
    serviceAuthDateLastUpdate = null;
    serviceAuthDateEffective = null;
    serviceAuthDateVerbalReferral = null;
    personId = 0;
    serviceAuthAmount = 0.00;
    serviceAuthCounty = null;
    serviceAuthAbilityToRespond = null;
    serviceAuthCategory = null;
    serviceAuthRegion = null;
    serviceAuthService = null;
  }

  /**
   * Construct a new ServiceAuthValueBean to contain the given data.
   *
   * @param caseId   The case id for this case.
   * @param personId The person id for the PRN.
   */
  public ServiceAuthValueBean(int ulIdCase, int ulIdPerson, int ulIdResource) {
    this();
    setCaseId(ulIdCase);
    setPersonId(ulIdPerson);
    setResourceId(ulIdResource);

  }

  public int getCaseId() {
    return caseId;
  }

  public int getContractId() {
    return contractId;
  }

  public int getResourceId() {
    return resourceId;
  }

  public int getStageId() {
    return stageId;
  }

  public int getServiceAuthId() {
    return serviceAuthId;
  }

  public Date getServiceAuthDateLastUpdate() {
    return serviceAuthDateLastUpdate;
  }

  public Date getServiceAuthDateEffective() {
    return serviceAuthDateEffective;
  }

  public Date getServiceAuthDateVerbalReferral() {
    return serviceAuthDateVerbalReferral;
  }

  public int getPersonId() {
    return personId;
  }

  public double getServiceAuthAmount() {
    return serviceAuthAmount;
  }

  public String getServiceAuthCounty() {
    return serviceAuthCounty;
  }

  public String getServiceAuthAbilityToRespond() {
    return serviceAuthAbilityToRespond;
  }

  public String getServiceAuthCategory() {
    return serviceAuthCategory;
  }

  public String getServiceAuthRegion() {
    return serviceAuthRegion;
  }

  public String getServiceAuthService() {
    return serviceAuthService;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public void setContractId(int contractId) {
    this.contractId = contractId;
  }

  public void setResourceId(int resourceId) {
    this.resourceId = resourceId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  public void setServiceAuthId(int serviceAuthId) {
    this.serviceAuthId = serviceAuthId;
  }

  public void setServiceAuthDateLastUpdate(Date serviceAuthDateLastUpdate) {
    this.serviceAuthDateLastUpdate = serviceAuthDateLastUpdate;
  }

  public void setServiceAuthDateEffective(Date serviceAuthDateEffective) {
    this.serviceAuthDateEffective = serviceAuthDateEffective;
  }

  public void setServiceAuthDateVerbalReferral(Date serviceAuthDateVerbalReferral) {
    this.serviceAuthDateVerbalReferral = serviceAuthDateVerbalReferral;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public void setServiceAuthAmount(double serviceAuthAmount) {
    this.serviceAuthAmount = serviceAuthAmount;
  }

  public void setServiceAuthCounty(String serviceAuthCounty) {
    this.serviceAuthCounty = serviceAuthCounty;
  }

  public void setServiceAuthAbilityToRespond(String serviceAuthAbilityToRespond) {
    this.serviceAuthAbilityToRespond = serviceAuthAbilityToRespond;
  }

  public void setServiceAuthCategory(String serviceAuthCategory) {
    this.serviceAuthCategory = serviceAuthCategory;
  }

  public void setServiceAuthRegion(String serviceAuthRegion) {
    this.serviceAuthRegion = serviceAuthRegion;
  }

  public void setServiceAuthService(String serviceAuthService) {
    this.serviceAuthService = serviceAuthService;
  }

  /**
   * Get a string representation of the variable names and values.
   *
   * @ return String
   */
  public String toString() {
    return "caseId = " + caseId +
           " contractId = " + contractId +
           " resourceId = " + resourceId +
           " stageId = " + stageId +
           " serviceAuthId = " + serviceAuthId +
           " serviceAuthDateLastUpdate = " + serviceAuthDateLastUpdate +
           " serviceAuthDateEffective = " + serviceAuthDateEffective +
           " serviceAuthDateVerbalReferral = " + serviceAuthDateVerbalReferral +
           " personId = " + personId +
           " serviceAuthAmount = " + serviceAuthAmount +
           " serviceAuthCounty = " + serviceAuthCounty +
           " serviceAuthAbilityToRespond = " + serviceAuthAbilityToRespond +
           " serviceAuthCategory = " + serviceAuthCategory +
           " serviceAuthRegion = " + serviceAuthRegion +
           " serviceAuthService = " + serviceAuthService;
  }

}

