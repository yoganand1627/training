package gov.georgia.dhr.dfcs.sacwis.web.document.cfp;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.ejb.CreateException;

import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DataNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DuplicateRecordFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataLookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.TableNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageClosedException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageNotFoundException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.springframework.beans.factory.BeanFactory;

/**
 * Base class for GenerateRiskAssessment, GenerateContactLog, and GenerateAbuseNeglectReport which don't simply loop
 * through the ids returned by CCFC33S and call GenerateReport or GenerateForm.
 */
public abstract class GenerateSpecialCase implements Serializable {
  protected JobDescriptor jobDescriptor = null;
  protected String userLogin = null;
  protected int userId = 0;
  protected int caseId = 0;
  protected int selectedStageId = 0;
  protected int[] stageIds = null;
  protected int[] eventIds = null;
  protected int[] personIds = null;
  protected int[] criminalHistoryIds = null;
  protected int[] systemNumberKeys = null;
  //kept the bad C names because I couldn't figure out what they should be
  protected int[] ulSysNbrUlongKeys = null;
  //intranetRiskAssesmentIndicator?
  protected String cIndRiskAssmtIntranet = null;
  protected int ulNbrReviewContact = 0;

  private BeanFactory beanFactory;

  public GenerateSpecialCase(BeanFactory beanFactory) {
    this.beanFactory = beanFactory;
  }

  public BeanFactory getBeanFactory() {
    return beanFactory;
  }

  @SuppressWarnings({"unchecked"})
  protected <T extends Object> T getEjb(Class<T> aClass) {
    String simpleName = aClass.getSimpleName();
    String beanName = Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
    return (T) beanFactory.getBean(beanName);
  }

  public abstract void generateSpecialCase()
          throws RemoteException, TooManyRowsReturnedException, CreateException, ValidationException,
                 DuplicateRecordException, NoSuchMethodException, ParseException, IllegalAccessException,
                 InstantiationException, MarshalException, CodeNotFoundException, DocumentStageClosedException,
                 InvocationTargetException, ClassNotFoundException, NoRowsUpdatedException, SQLException,
                 DocumentStageNotFoundException, ReferenceDataLookupException, TableNotFoundException,
                 DuplicateRecordFoundException, DataNotFoundException;

  public JobDescriptor getJobDescriptor() {
    return jobDescriptor;
  }

  public void setJobDescriptor(JobDescriptor jobDescriptor) {
    this.jobDescriptor = jobDescriptor;
  }

  public String getUserLogin() {
    return userLogin;
  }

  public void setUserLogin(String userLogin) {
    this.userLogin = userLogin;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public int getSelectedStageId() {
    return selectedStageId;
  }

  public void setSelectedStageId(int selectedStageId) {
    this.selectedStageId = selectedStageId;
  }

  public int[] getStageIds() {
    return stageIds;
  }

  public void setStageIds(int[] stageIds) {
    this.stageIds = stageIds;
  }

  public int[] getEventIds() {
    return eventIds;
  }

  public void setEventIds(int[] eventIds) {
    this.eventIds = eventIds;
  }

  public int[] getPersonIds() {
    return personIds;
  }

  public void setPersonIds(int[] personIds) {
    this.personIds = personIds;
  }

  public int[] getCriminalHistoryIds() {
    return criminalHistoryIds;
  }

  public void setCriminalHistoryIds(int[] criminalHistoryIds) {
    this.criminalHistoryIds = criminalHistoryIds;
  }

  public int[] getUlSysNbrUlongKeys() {
    return ulSysNbrUlongKeys;
  }

  public void setUlSysNbrUlongKeys(int[] ulSysNbrUlongKeys) {
    this.ulSysNbrUlongKeys = ulSysNbrUlongKeys;
  }

  public String getCIndRiskAssmtIntranet() {
    return cIndRiskAssmtIntranet;
  }

  public void setCIndRiskAssmtIntranet(String cIndRiskAssmtIntranet) {
    this.cIndRiskAssmtIntranet = cIndRiskAssmtIntranet;
  }

  public int getUlNbrReviewContact() {
    return ulNbrReviewContact;
  }

  public void setUlNbrReviewContact(int ulNbrReviewContact) {
    this.ulNbrReviewContact = ulNbrReviewContact;
  }
}
