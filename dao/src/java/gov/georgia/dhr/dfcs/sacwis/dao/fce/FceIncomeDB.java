//DO NOT MAKE ANY CHANGES TO THIS FILE
//IT IS GENERATED
//see Matthew McClain (PRSmmcclain) if a change needs to be made

package gov.georgia.dhr.dfcs.sacwis.dao.fce;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

public class FceIncomeDB extends gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB implements Serializable {
  public static final String AMT_INCOME_MONEY = "amtIncomeMoney";
  public static final String AMT_INCOME = "amtIncome";
  public static final String CD_TYPE = "cdType";
  public static final String DT_LAST_UPDATE_STRING = "dtLastUpdateString";
  public static final String DT_LAST_UPDATE_TIME = "dtLastUpdateTime";
  public static final String ID_FCE_ELIGIBILITY = "idFceEligibility";
  public static final String ID_FCE_INCOME = "idFceIncome";
  public static final String ID_FCE_PERSON = "idFcePerson";
  public static final String ID_INC_RSRC = "idIncRsrc";
  public static final String ID_PERSON = "idPerson";
  public static final String IND_CHILD = "indChild";
  public static final String IND_COUNTABLE = "indCountable";
  public static final String IND_EARNED = "indEarned";
  public static final String IND_FAMILY = "indFamily";
  public static final String IND_INCOME_SOURCE = "indIncomeSource";
  public static final String IND_NONE = "indNone";
  public static final String IND_NOT_ACCESSIBLE = "indNotAccessible";
  public static final String IND_RESOURCE_SOURCE = "indResourceSource";
  public static final String TXT_COMMENTS = "txtComments";
  public static final String TXT_SOURCE = "txtSource";
  public static final String TXT_VERIFICATION_METHOD = "txtVerificationMethod";

  protected boolean hasAmtIncome = false;
  protected Double amtIncome = null;
  protected boolean hasCdType = false;
  protected String cdType = null;
  protected boolean hasDtLastUpdate = false;
  protected Date dtLastUpdate = null;
  protected boolean hasIdFceEligibility = false;
  protected Long idFceEligibility = null;
  protected boolean hasIdFceIncome = false;
  protected Long idFceIncome = null;
  protected boolean hasIdFcePerson = false;
  protected Long idFcePerson = null;
  protected boolean hasIdIncRsrc = false;
  protected Long idIncRsrc = null;
  protected boolean hasIdPerson = false;
  protected Long idPerson = null;
  protected boolean hasIndChild = false;
  protected Boolean indChild = null;
  protected boolean hasIndCountable = false;
  protected Boolean indCountable = null;
  protected boolean hasIndEarned = false;
  protected Boolean indEarned = null;
  protected boolean hasIndFamily = false;
  protected Boolean indFamily = null;
  protected boolean hasIndIncomeSource = false;
  protected Boolean indIncomeSource = null;
  protected boolean hasIndNone = false;
  protected Boolean indNone = null;
  protected boolean hasIndNotAccessible = false;
  protected Boolean indNotAccessible = null;
  protected boolean hasIndResourceSource = false;
  protected Boolean indResourceSource = null;
  protected boolean hasTxtComments = false;
  protected String txtComments = null;
  protected boolean hasTxtSource = false;
  protected String txtSource = null;
  protected boolean hasTxtVerificationMethod = false;
  protected String txtVerificationMethod = null;

  public boolean hasAmtIncome() {
    return hasAmtIncome;
  }

  public double getAmtIncome() {
    if (amtIncome == null) {
      return (double) 0;
    }
    return amtIncome.doubleValue();
  }

  public Double getAmtIncomeObject() {
    return amtIncome;
  }

  public String getAmtIncomeString() {
    return FormattingHelper.formatDouble(amtIncome);
  }

  public void setAmtIncome(double amtIncome) {
    this.hasAmtIncome = true;
    this.amtIncome = new Double(amtIncome);
  }

  public void setAmtIncome(Double amtIncome) {
    this.hasAmtIncome = true;
    this.amtIncome = amtIncome;
  }

  public void setAmtIncome(Number amtIncome) {
    this.hasAmtIncome = true;
    this.amtIncome = null;
    if (amtIncome != null) {
      setAmtIncome(amtIncome.doubleValue());
    }
  }

  public boolean hasCdType() {
    return hasCdType;
  }

  public String getCdType() {
    if (cdType == null) {
      return "";
    }
    return cdType;
  }

  public String getCdTypeObject() {
    return cdType;
  }

  public void setCdType(String cdType) {
    if ((cdType != null) &&
        (cdType.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdType'; \n" +
                                      " max size = 3; \n" +
                                      " data = '" + cdType + "'");
    }
    this.hasCdType = true;
    this.cdType = cdType;
  }

  public boolean hasDtLastUpdate() {
    return hasDtLastUpdate;
  }

  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  public Date getDtLastUpdateObject() {
    return dtLastUpdate;
  }

  public String getDtLastUpdateString() {
    return toString(dtLastUpdate);
  }

  public long getDtLastUpdateTime() {
    return toTime(dtLastUpdate);
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.hasDtLastUpdate = true;
    if ((dtLastUpdate != null) &&
        (dtLastUpdate.getTime() == 0)) {
      dtLastUpdate = null;
    }
    this.dtLastUpdate = dtLastUpdate;
  }

  public void setDtLastUpdateString(String dtLastUpdateString) {
    this.hasDtLastUpdate = true;
    this.dtLastUpdate = toDate(dtLastUpdateString);
  }

  public void setDtLastUpdateTime(long dtLastUpdateTime) {
    this.hasDtLastUpdate = true;
    this.dtLastUpdate = toDate(dtLastUpdateTime);
  }

  public boolean hasIdFceEligibility() {
    return hasIdFceEligibility;
  }

  public long getIdFceEligibility() {
    if (idFceEligibility == null) {
      return (long) 0;
    }
    return idFceEligibility.longValue();
  }

  public Long getIdFceEligibilityObject() {
    return idFceEligibility;
  }

  public String getIdFceEligibilityString() {
    return FormattingHelper.formatLong(idFceEligibility);
  }

  public void setIdFceEligibility(long idFceEligibility) {
    this.hasIdFceEligibility = true;
    if (idFceEligibility == 0) {
      this.idFceEligibility = null;
      return;
    }
    this.idFceEligibility = new Long(idFceEligibility);
  }

  public void setIdFceEligibility(Long idFceEligibility) {
    this.hasIdFceEligibility = true;
    this.idFceEligibility = idFceEligibility;
  }

  public void setIdFceEligibility(Number idFceEligibility) {
    this.hasIdFceEligibility = true;
    this.idFceEligibility = null;
    if (idFceEligibility != null) {
      setIdFceEligibility(idFceEligibility.longValue());
    }
  }

  public boolean hasIdFceIncome() {
    return hasIdFceIncome;
  }

  public long getIdFceIncome() {
    if (idFceIncome == null) {
      return (long) 0;
    }
    return idFceIncome.longValue();
  }

  public Long getIdFceIncomeObject() {
    return idFceIncome;
  }

  public String getIdFceIncomeString() {
    return FormattingHelper.formatLong(idFceIncome);
  }

  public void setIdFceIncome(long idFceIncome) {
    this.hasIdFceIncome = true;
    if (idFceIncome == 0) {
      this.idFceIncome = null;
      return;
    }
    this.idFceIncome = new Long(idFceIncome);
  }

  public void setIdFceIncome(Long idFceIncome) {
    this.hasIdFceIncome = true;
    this.idFceIncome = idFceIncome;
  }

  public void setIdFceIncome(Number idFceIncome) {
    this.hasIdFceIncome = true;
    this.idFceIncome = null;
    if (idFceIncome != null) {
      setIdFceIncome(idFceIncome.longValue());
    }
  }

  public boolean hasIdFcePerson() {
    return hasIdFcePerson;
  }

  public long getIdFcePerson() {
    if (idFcePerson == null) {
      return (long) 0;
    }
    return idFcePerson.longValue();
  }

  public Long getIdFcePersonObject() {
    return idFcePerson;
  }

  public String getIdFcePersonString() {
    return FormattingHelper.formatLong(idFcePerson);
  }

  public void setIdFcePerson(long idFcePerson) {
    this.hasIdFcePerson = true;
    if (idFcePerson == 0) {
      this.idFcePerson = null;
      return;
    }
    this.idFcePerson = new Long(idFcePerson);
  }

  public void setIdFcePerson(Long idFcePerson) {
    this.hasIdFcePerson = true;
    this.idFcePerson = idFcePerson;
  }

  public void setIdFcePerson(Number idFcePerson) {
    this.hasIdFcePerson = true;
    this.idFcePerson = null;
    if (idFcePerson != null) {
      setIdFcePerson(idFcePerson.longValue());
    }
  }

  public boolean hasIdIncRsrc() {
    return hasIdIncRsrc;
  }

  public long getIdIncRsrc() {
    if (idIncRsrc == null) {
      return (long) 0;
    }
    return idIncRsrc.longValue();
  }

  public Long getIdIncRsrcObject() {
    return idIncRsrc;
  }

  public String getIdIncRsrcString() {
    return FormattingHelper.formatLong(idIncRsrc);
  }

  public void setIdIncRsrc(long idIncRsrc) {
    this.hasIdIncRsrc = true;
    if (idIncRsrc == 0) {
      this.idIncRsrc = null;
      return;
    }
    this.idIncRsrc = new Long(idIncRsrc);
  }

  public void setIdIncRsrc(Long idIncRsrc) {
    this.hasIdIncRsrc = true;
    this.idIncRsrc = idIncRsrc;
  }

  public void setIdIncRsrc(Number idIncRsrc) {
    this.hasIdIncRsrc = true;
    this.idIncRsrc = null;
    if (idIncRsrc != null) {
      setIdIncRsrc(idIncRsrc.longValue());
    }
  }

  public boolean hasIdPerson() {
    return hasIdPerson;
  }

  public long getIdPerson() {
    if (idPerson == null) {
      return (long) 0;
    }
    return idPerson.longValue();
  }

  public Long getIdPersonObject() {
    return idPerson;
  }

  public String getIdPersonString() {
    return FormattingHelper.formatLong(idPerson);
  }

  public void setIdPerson(long idPerson) {
    this.hasIdPerson = true;
    if (idPerson == 0) {
      this.idPerson = null;
      return;
    }
    this.idPerson = new Long(idPerson);
  }

  public void setIdPerson(Long idPerson) {
    this.hasIdPerson = true;
    this.idPerson = idPerson;
  }

  public void setIdPerson(Number idPerson) {
    this.hasIdPerson = true;
    this.idPerson = null;
    if (idPerson != null) {
      setIdPerson(idPerson.longValue());
    }
  }

  public boolean hasIndChild() {
    return hasIndChild;
  }

  public boolean getIndChild() {
    if (indChild == null) {
      return false;
    }
    return indChild.booleanValue();
  }

  public Boolean getIndChildObject() {
    return indChild;
  }

  public String getIndChildString() {
    if (indChild == null) {
      return "";
    }
    return indChild.toString();
  }

  public void setIndChild(boolean indChild) {
    this.hasIndChild = true;
    this.indChild = new Boolean(indChild);
  }

  public void setIndChild(Boolean indChild) {
    this.hasIndChild = true;
    this.indChild = indChild;
  }

  public void setIndChild(String indChild) {
    this.hasIndChild = true;
    this.indChild = isTrueBoolean(indChild);
  }

  public boolean hasIndCountable() {
    return hasIndCountable;
  }

  public boolean getIndCountable() {
    if (indCountable == null) {
      return false;
    }
    return indCountable.booleanValue();
  }

  public Boolean getIndCountableObject() {
    return indCountable;
  }

  public String getIndCountableString() {
    if (indCountable == null) {
      return "";
    }
    return indCountable.toString();
  }

  public void setIndCountable(boolean indCountable) {
    this.hasIndCountable = true;
    this.indCountable = new Boolean(indCountable);
  }

  public void setIndCountable(Boolean indCountable) {
    this.hasIndCountable = true;
    this.indCountable = indCountable;
  }

  public void setIndCountable(String indCountable) {
    this.hasIndCountable = true;
    this.indCountable = isTrueBoolean(indCountable);
  }

  public boolean hasIndEarned() {
    return hasIndEarned;
  }

  public boolean getIndEarned() {
    if (indEarned == null) {
      return false;
    }
    return indEarned.booleanValue();
  }

  public Boolean getIndEarnedObject() {
    return indEarned;
  }

  public String getIndEarnedString() {
    if (indEarned == null) {
      return "";
    }
    return indEarned.toString();
  }

  public void setIndEarned(boolean indEarned) {
    this.hasIndEarned = true;
    this.indEarned = new Boolean(indEarned);
  }

  public void setIndEarned(Boolean indEarned) {
    this.hasIndEarned = true;
    this.indEarned = indEarned;
  }

  public void setIndEarned(String indEarned) {
    this.hasIndEarned = true;
    this.indEarned = isTrueBoolean(indEarned);
  }

  public boolean hasIndFamily() {
    return hasIndFamily;
  }

  public boolean getIndFamily() {
    if (indFamily == null) {
      return false;
    }
    return indFamily.booleanValue();
  }

  public Boolean getIndFamilyObject() {
    return indFamily;
  }

  public String getIndFamilyString() {
    if (indFamily == null) {
      return "";
    }
    return indFamily.toString();
  }

  public void setIndFamily(boolean indFamily) {
    this.hasIndFamily = true;
    this.indFamily = new Boolean(indFamily);
  }

  public void setIndFamily(Boolean indFamily) {
    this.hasIndFamily = true;
    this.indFamily = indFamily;
  }

  public void setIndFamily(String indFamily) {
    this.hasIndFamily = true;
    this.indFamily = isTrueBoolean(indFamily);
  }

  public boolean hasIndIncomeSource() {
    return hasIndIncomeSource;
  }

  public boolean getIndIncomeSource() {
    if (indIncomeSource == null) {
      return false;
    }
    return indIncomeSource.booleanValue();
  }

  public Boolean getIndIncomeSourceObject() {
    return indIncomeSource;
  }

  public String getIndIncomeSourceString() {
    if (indIncomeSource == null) {
      return "";
    }
    return indIncomeSource.toString();
  }

  public void setIndIncomeSource(boolean indIncomeSource) {
    this.hasIndIncomeSource = true;
    this.indIncomeSource = new Boolean(indIncomeSource);
  }

  public void setIndIncomeSource(Boolean indIncomeSource) {
    this.hasIndIncomeSource = true;
    this.indIncomeSource = indIncomeSource;
  }

  public void setIndIncomeSource(String indIncomeSource) {
    this.hasIndIncomeSource = true;
    this.indIncomeSource = isTrueBoolean(indIncomeSource);
  }

  public boolean hasIndNone() {
    return hasIndNone;
  }

  public boolean getIndNone() {
    if (indNone == null) {
      return false;
    }
    return indNone.booleanValue();
  }

  public Boolean getIndNoneObject() {
    return indNone;
  }

  public String getIndNoneString() {
    if (indNone == null) {
      return "";
    }
    return indNone.toString();
  }

  public void setIndNone(boolean indNone) {
    this.hasIndNone = true;
    this.indNone = new Boolean(indNone);
  }

  public void setIndNone(Boolean indNone) {
    this.hasIndNone = true;
    this.indNone = indNone;
  }

  public void setIndNone(String indNone) {
    this.hasIndNone = true;
    this.indNone = isTrueBoolean(indNone);
  }

  public boolean hasIndNotAccessible() {
    return hasIndNotAccessible;
  }

  public boolean getIndNotAccessible() {
    if (indNotAccessible == null) {
      return false;
    }
    return indNotAccessible.booleanValue();
  }

  public Boolean getIndNotAccessibleObject() {
    return indNotAccessible;
  }

  public String getIndNotAccessibleString() {
    if (indNotAccessible == null) {
      return "";
    }
    return indNotAccessible.toString();
  }

  public void setIndNotAccessible(boolean indNotAccessible) {
    this.hasIndNotAccessible = true;
    this.indNotAccessible = new Boolean(indNotAccessible);
  }

  public void setIndNotAccessible(Boolean indNotAccessible) {
    this.hasIndNotAccessible = true;
    this.indNotAccessible = indNotAccessible;
  }

  public void setIndNotAccessible(String indNotAccessible) {
    this.hasIndNotAccessible = true;
    this.indNotAccessible = isTrueBoolean(indNotAccessible);
  }

  public boolean hasIndResourceSource() {
    return hasIndResourceSource;
  }

  public boolean getIndResourceSource() {
    if (indResourceSource == null) {
      return false;
    }
    return indResourceSource.booleanValue();
  }

  public Boolean getIndResourceSourceObject() {
    return indResourceSource;
  }

  public String getIndResourceSourceString() {
    if (indResourceSource == null) {
      return "";
    }
    return indResourceSource.toString();
  }

  public void setIndResourceSource(boolean indResourceSource) {
    this.hasIndResourceSource = true;
    this.indResourceSource = new Boolean(indResourceSource);
  }

  public void setIndResourceSource(Boolean indResourceSource) {
    this.hasIndResourceSource = true;
    this.indResourceSource = indResourceSource;
  }

  public void setIndResourceSource(String indResourceSource) {
    this.hasIndResourceSource = true;
    this.indResourceSource = isTrueBoolean(indResourceSource);
  }

  public boolean hasTxtComments() {
    return hasTxtComments;
  }

  public String getTxtComments() {
    if (txtComments == null) {
      return "";
    }
    return txtComments;
  }

  public String getTxtCommentsObject() {
    return txtComments;
  }

  public void setTxtComments(String txtComments) {
    if ((txtComments != null) &&
        (txtComments.length() > 300)) {
      throw new IllegalStateException("Data is too large for 'txtComments'; \n" +
                                      " max size = 300; \n" +
                                      " data = '" + txtComments + "'");
    }
    this.hasTxtComments = true;
    this.txtComments = txtComments;
  }

  public boolean hasTxtSource() {
    return hasTxtSource;
  }

  public String getTxtSource() {
    if (txtSource == null) {
      return "";
    }
    return txtSource;
  }

  public String getTxtSourceObject() {
    return txtSource;
  }

  public void setTxtSource(String txtSource) {
    if ((txtSource != null) &&
        (txtSource.length() > 20)) {
      throw new IllegalStateException("Data is too large for 'txtSource'; \n" +
                                      " max size = 20; \n" +
                                      " data = '" + txtSource + "'");
    }
    this.hasTxtSource = true;
    this.txtSource = txtSource;
  }

  public boolean hasTxtVerificationMethod() {
    return hasTxtVerificationMethod;
  }

  public String getTxtVerificationMethod() {
    if (txtVerificationMethod == null) {
      return "";
    }
    return txtVerificationMethod;
  }

  public String getTxtVerificationMethodObject() {
    return txtVerificationMethod;
  }

  public void setTxtVerificationMethod(String txtVerificationMethod) {
    if ((txtVerificationMethod != null) &&
        (txtVerificationMethod.length() > 20)) {
      throw new IllegalStateException("Data is too large for 'txtVerificationMethod'; \n" +
                                      " max size = 20; \n" +
                                      " data = '" + txtVerificationMethod + "'");
    }
    this.hasTxtVerificationMethod = true;
    this.txtVerificationMethod = txtVerificationMethod;
  }

  public void copyInto(FceIncomeDB fceIncomeDB) {
    if (hasAmtIncome) {
      fceIncomeDB.setAmtIncome(amtIncome);
    }
    if (hasCdType) {
      fceIncomeDB.setCdType(cdType);
    }
    if (hasDtLastUpdate) {
      fceIncomeDB.setDtLastUpdate(dtLastUpdate);
    }
    if (hasIdFceEligibility) {
      fceIncomeDB.setIdFceEligibility(idFceEligibility);
    }
    if (hasIdFceIncome) {
      fceIncomeDB.setIdFceIncome(idFceIncome);
    }
    if (hasIdFcePerson) {
      fceIncomeDB.setIdFcePerson(idFcePerson);
    }
    if (hasIdIncRsrc) {
      fceIncomeDB.setIdIncRsrc(idIncRsrc);
    }
    if (hasIdPerson) {
      fceIncomeDB.setIdPerson(idPerson);
    }
    if (hasIndChild) {
      fceIncomeDB.setIndChild(indChild);
    }
    if (hasIndCountable) {
      fceIncomeDB.setIndCountable(indCountable);
    }
    if (hasIndEarned) {
      fceIncomeDB.setIndEarned(indEarned);
    }
    if (hasIndFamily) {
      fceIncomeDB.setIndFamily(indFamily);
    }
    if (hasIndIncomeSource) {
      fceIncomeDB.setIndIncomeSource(indIncomeSource);
    }
    if (hasIndNone) {
      fceIncomeDB.setIndNone(indNone);
    }
    if (hasIndNotAccessible) {
      fceIncomeDB.setIndNotAccessible(indNotAccessible);
    }
    if (hasIndResourceSource) {
      fceIncomeDB.setIndResourceSource(indResourceSource);
    }
    if (hasTxtComments) {
      fceIncomeDB.setTxtComments(txtComments);
    }
    if (hasTxtSource) {
      fceIncomeDB.setTxtSource(txtSource);
    }
    if (hasTxtVerificationMethod) {
      fceIncomeDB.setTxtVerificationMethod(txtVerificationMethod);
    }
  }

  public static void populateWithMap(FceIncomeDB fceIncomeDB,
                                     Map map) {
    if (map.containsKey("AMT_INCOME")) {
      Number value = (Number) map.get("AMT_INCOME");
      fceIncomeDB.setAmtIncome(value);
    }
    if (map.containsKey("CD_TYPE")) {
      String value = (String) map.get("CD_TYPE");
      fceIncomeDB.setCdType(value);
    }
    if (map.containsKey("DT_LAST_UPDATE")) {
      Date value = (Date) map.get("DT_LAST_UPDATE");
      fceIncomeDB.setDtLastUpdate(value);
    }
    if (map.containsKey("ID_FCE_ELIGIBILITY")) {
      Number value = (Number) map.get("ID_FCE_ELIGIBILITY");
      fceIncomeDB.setIdFceEligibility(value);
    }
    if (map.containsKey("ID_FCE_INCOME")) {
      Number value = (Number) map.get("ID_FCE_INCOME");
      fceIncomeDB.setIdFceIncome(value);
    }
    if (map.containsKey("ID_FCE_PERSON")) {
      Number value = (Number) map.get("ID_FCE_PERSON");
      fceIncomeDB.setIdFcePerson(value);
    }
    if (map.containsKey("ID_INC_RSRC")) {
      Number value = (Number) map.get("ID_INC_RSRC");
      fceIncomeDB.setIdIncRsrc(value);
    }
    if (map.containsKey("ID_PERSON")) {
      Number value = (Number) map.get("ID_PERSON");
      fceIncomeDB.setIdPerson(value);
    }
    if (map.containsKey("IND_CHILD")) {
      String value = (String) map.get("IND_CHILD");
      fceIncomeDB.setIndChild(value);
    }
    if (map.containsKey("IND_COUNTABLE")) {
      String value = (String) map.get("IND_COUNTABLE");
      fceIncomeDB.setIndCountable(value);
    }
    if (map.containsKey("IND_EARNED")) {
      String value = (String) map.get("IND_EARNED");
      fceIncomeDB.setIndEarned(value);
    }
    if (map.containsKey("IND_FAMILY")) {
      String value = (String) map.get("IND_FAMILY");
      fceIncomeDB.setIndFamily(value);
    }
    if (map.containsKey("IND_INCOME_SOURCE")) {
      String value = (String) map.get("IND_INCOME_SOURCE");
      fceIncomeDB.setIndIncomeSource(value);
    }
    if (map.containsKey("IND_NONE")) {
      String value = (String) map.get("IND_NONE");
      fceIncomeDB.setIndNone(value);
    }
    if (map.containsKey("IND_NOT_ACCESSIBLE")) {
      String value = (String) map.get("IND_NOT_ACCESSIBLE");
      fceIncomeDB.setIndNotAccessible(value);
    }
    if (map.containsKey("IND_RESOURCE_SOURCE")) {
      String value = (String) map.get("IND_RESOURCE_SOURCE");
      fceIncomeDB.setIndResourceSource(value);
    }
    if (map.containsKey("TXT_COMMENTS")) {
      String value = (String) map.get("TXT_COMMENTS");
      fceIncomeDB.setTxtComments(value);
    }
    if (map.containsKey("TXT_SOURCE")) {
      String value = (String) map.get("TXT_SOURCE");
      fceIncomeDB.setTxtSource(value);
    }
    if (map.containsKey("TXT_VERIFICATION_METHOD")) {
      String value = (String) map.get("TXT_VERIFICATION_METHOD");
      fceIncomeDB.setTxtVerificationMethod(value);
    }
  }

/*
  public static void populateWithRequest(FceIncomeDB fceIncomeDB,
                                         HttpServletRequest request) {

    Map map = request.getParameterMap();
    if (map.containsKey(AMT_INCOME)) {
      fceIncomeDB.setAmtIncome(ContextHelper.getDoubleSafe(request, AMT_INCOME));
    }
    if (map.containsKey(AMT_INCOME_MONEY)) {
      fceIncomeDB.setAmtIncome(ContextHelper.getMoneyAsDoubleSafe(request, AMT_INCOME_MONEY));
    }
    if (map.containsKey(CD_TYPE)) {
      fceIncomeDB.setCdType(ContextHelper.getStringSafe(request, CD_TYPE));
    }
    if (map.containsKey(DT_LAST_UPDATE_STRING)) {
      fceIncomeDB.setDtLastUpdateString(ContextHelper.getStringSafe(request, DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(DT_LAST_UPDATE_TIME)) {
      fceIncomeDB.setDtLastUpdateTime(ContextHelper.getLongSafe(request, DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(ID_FCE_ELIGIBILITY)) {
      fceIncomeDB.setIdFceEligibility(ContextHelper.getLongSafe(request, ID_FCE_ELIGIBILITY));
    }
    if (map.containsKey(ID_FCE_INCOME)) {
      fceIncomeDB.setIdFceIncome(ContextHelper.getLongSafe(request, ID_FCE_INCOME));
    }
    if (map.containsKey(ID_FCE_PERSON)) {
      fceIncomeDB.setIdFcePerson(ContextHelper.getLongSafe(request, ID_FCE_PERSON));
    }
    if (map.containsKey(ID_INC_RSRC)) {
      fceIncomeDB.setIdIncRsrc(ContextHelper.getLongSafe(request, ID_INC_RSRC));
    }
    if (map.containsKey(ID_PERSON)) {
      fceIncomeDB.setIdPerson(ContextHelper.getLongSafe(request, ID_PERSON));
    }
    if (map.containsKey(IND_CHILD)) {
      fceIncomeDB.setIndChild(ContextHelper.getBooleanSafe(request, IND_CHILD));
    }
    if (map.containsKey(IND_COUNTABLE)) {
      fceIncomeDB.setIndCountable(ContextHelper.getBooleanSafe(request, IND_COUNTABLE));
    }
    if (map.containsKey(IND_EARNED)) {
      fceIncomeDB.setIndEarned(ContextHelper.getBooleanSafe(request, IND_EARNED));
    }
    if (map.containsKey(IND_FAMILY)) {
      fceIncomeDB.setIndFamily(ContextHelper.getBooleanSafe(request, IND_FAMILY));
    }
    if (map.containsKey(IND_INCOME_SOURCE)) {
      fceIncomeDB.setIndIncomeSource(ContextHelper.getBooleanSafe(request, IND_INCOME_SOURCE));
    }
    if (map.containsKey(IND_NONE)) {
      fceIncomeDB.setIndNone(ContextHelper.getBooleanSafe(request, IND_NONE));
    }
    if (map.containsKey(IND_NOT_ACCESSIBLE)) {
      fceIncomeDB.setIndNotAccessible(ContextHelper.getBooleanSafe(request, IND_NOT_ACCESSIBLE));
    }
    if (map.containsKey(IND_RESOURCE_SOURCE)) {
      fceIncomeDB.setIndResourceSource(ContextHelper.getBooleanSafe(request, IND_RESOURCE_SOURCE));
    }
    if (map.containsKey(TXT_COMMENTS)) {
      fceIncomeDB.setTxtComments(ContextHelper.getStringSafe(request, TXT_COMMENTS));
    }
    if (map.containsKey(TXT_SOURCE)) {
      fceIncomeDB.setTxtSource(ContextHelper.getStringSafe(request, TXT_SOURCE));
    }
    if (map.containsKey(TXT_VERIFICATION_METHOD)) {
      fceIncomeDB.setTxtVerificationMethod(ContextHelper.getStringSafe(request, TXT_VERIFICATION_METHOD));
    }
  }
*/

  public String toString() {
    return
            "BEGIN bean: FceIncome\n" +
            " amtIncome: " + amtIncome + "\n" +
            " cdType: " + cdType + "\n" +
            " dtLastUpdate: " + dtLastUpdate + "\n" +
            " idFceEligibility: " + idFceEligibility + "\n" +
            " idFceIncome: " + idFceIncome + "\n" +
            " idFcePerson: " + idFcePerson + "\n" +
            " idIncRsrc: " + idIncRsrc + "\n" +
            " idPerson: " + idPerson + "\n" +
            " indChild: " + indChild + "\n" +
            " indCountable: " + indCountable + "\n" +
            " indEarned: " + indEarned + "\n" +
            " indFamily: " + indFamily + "\n" +
            " indIncomeSource: " + indIncomeSource + "\n" +
            " indNone: " + indNone + "\n" +
            " indNotAccessible: " + indNotAccessible + "\n" +
            " indResourceSource: " + indResourceSource + "\n" +
            " txtComments: " + txtComments + "\n" +
            " txtSource: " + txtSource + "\n" +
            " txtVerificationMethod: " + txtVerificationMethod + "\n" +
            "END bean: FceIncome\n";
  }

  public static Boolean isTrueBoolean(String string) {
    if (string == null) {
      return null;
    }
    return new Boolean(isTrue(string));
  }

  public static boolean isTrue(String string) {
    return ((string != null) &&
            (string.equals("Y") || string.equals("1")));
  }

  /** Similar to StringHelper.isFalse, except it handles null and "1" */
  public static boolean isFalse(String string) {
    return (isTrue(string) == false);
  }

  /** true  --> "Y" false --> "N" */
  public static String toCharIndicator(boolean value) {
    if (value) {
      return "Y";
    }
    return "N";
  }

  public static String toCharIndicator(Boolean value) {
    if (value == null) {
      return null;
    }
    if (value.booleanValue()) {
      return "Y";
    }
    return "N";
  }

  //copied from PalDB
  protected static Date toDate(String string) {
    return DateHelper.toJavaDateFromInputWithDefault(string, null);
  }

  protected static String toString(Date date) {
    return FormattingHelper.formatDate(date);
  }

  protected static long toTime(Date date) {
    if (date == null) {
      return 0;
    }
    return date.getTime();
  }

  protected static Date toDate(long time) {
    if (time == 0) {
      return null;
    }
    return new Date(time);
  }
}
