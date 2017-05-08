package gov.georgia.dhr.dfcs.sacwis.dao.fce;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

public class ThirdPartyHealthInsuranceDB implements Serializable, FceApplicationPageDB {
  public static final String ADDR_CITY = "addrCity";
  public static final String ADDR_ST_LN1 = "addrStLn1";
  public static final String ADDR_ST_LN2 = "addrStLn2";
  public static final String ADDR_STATE = "addrState";
  public static final String ADDR_ZIP = "addrZip";
  public static final String ADDR_ZIP_SUFF = "addrZipSuff";
  public static final String IND_CHILD_COVERAGE = "indChildCoverage";
  public static final String CD_TYPE = "cdType";
  public static final String NBR_PHONE = "nbrPhone";
  public static final String IND_AMENDED_APP = "indAmendedApp";
  public static final String IND_AUTH_RELEASE = "indAuthRelease";
  public static final String IND_AUTH_ASSIGN = "indAuthAssign";
  public static final String DT_AUTH_RELEASE_DATE = "dtAuthReleaseDate";
  public static final String DT_AUTH_ASSIGN_DATE = "dtAuthAssignDate";
  public static final String IND_CHANGE_CANCEL = "indChangeCancel";
  public static final String DT_CHANGE_CANCEL = "dtChangeCancel";
  public static final String DT_BEGIN_STRING = "dtBegin";
  public static final String DT_BEGIN_TIME = "dtBeginTime";
  public static final String DT_END_STRING = "dtEnd";
  public static final String DT_END_TIME = "dtEndTime";
  public static final String ID_FCE_ELIGIBILITY = "idFceEligibility";
  public static final String ID_FCE_APPLICATION = "idFceApplication";
  public static final String ID_PERSON = "idPerson";
  public static final String ID_FCE_PERSON = "idFcePerson";
  public static final String NM_COMPANY = "nmCompany";
  public static final String NM_EMPLOYEE_NM = "nmEmployeeNm";
  public static final String NM_EMPLOYER = "nmEmployer";
  public static final String CD_POLICY_HLDR = "cdPolicyHldr";
  public static final String NBR_GROUP = "nbrGroup";
  public static final String NBR_POLICY = "nbrPolicy";
  public static final String PRINCIPLES = "principles";
  public static final String ID_EVENT = "idEvent";
  public static final String ID_STAGE = "idStage";
  public static final String CD_EVENT_STATUS = "cdEventStatus";
  public static final String ID_LAST_UPDATE_PERSON = "idLastUpdatePerson";
  public static final String FCE_APPLICATION_DT_LAST_UPDATE_STRING = "fceApplicationDtLastUpdateString";
  public static final String FCE_APPLICATION_DT_LAST_UPDATE_TIME = "fceApplicationDtLastUpdateTime";
  public static final String DT_LAST_UPDATE_STRING = "dtLastUpdateString";
  public static final String CD_REL_INT = "cdRelInt";
  public static final String NM_PERSON_FULL = "nmPersonFull";
  public static final String DT_BIRTH_STRING = "dtBirthString";
  public static final String DT_BIRTH_TIME = "dtBirthTime";
  public static final String FCE_PERSON_DT_LAST_UPDATE_STRING = "fcePersonDtLastUpdateString";
  public static final String ID_FCE_THIRD_PARTY_INSURANCE = "idFceThirdPartyInsurance";
  public static final String NM_EMPLOYEE_PERSON_FULL = "nmEmployeePersonFull";
  public static final String NBR_EMPLOYEE_PERSON_PHONE = "nbrEmployeePersonPhone";
  public static final String IND_OTHER_HEALTH_INSURANCE = "indOtherHealthInsurance";
  public static final String CD_APPLICATION = "cdApplication";
  
  protected Long idFceThirdPartyInsurance = null;
  protected boolean hasIdFceThirdPartyInsurance = false;
  protected boolean hasFcePersonDtLastUpdate = false;
  protected Date fcePersonDtLastUpdate = null;
  protected boolean hasDtBirth = false;
  protected Date dtBirth = null;
  protected boolean hasNmPersonFull = false;
  protected String nmPersonFull = null;
  protected boolean hasCdRelInt = false;
  protected String cdRelInt = null;
  protected boolean hasFceApplicationDtLastUpdate = false;
  protected Date fceApplicationDtLastUpdate = null;
  protected boolean hasIdLastUpdatePerson = false;
  protected boolean hasIndOtherHealthInsurance = false;
  protected Boolean indOtherHealthInsurance = null;
  protected Long idLastUpdatePerson = null;
  protected boolean hasIdStage = false;
  protected Long idStage = null;
  protected boolean hasIdEvent = false;
  protected Long idEvent = null;
  protected boolean hasAddrCity = false;
  protected String addrCity = null;
  protected boolean hasAddrStLn1 = false;
  protected String addrStLn1 = null;
  protected boolean hasAddrStLn2 = false;
  protected String addrStLn2 = null;
  protected boolean hasAddrZip = false;
  protected String addrZip = null;
  protected boolean hasAddrState = false;
  protected String addrState = null;
  protected boolean hasIndChildCoverage = false;
  protected Boolean indChildCoverage = null;
  protected boolean hasCdType = false;
  protected String cdType = null;
  protected boolean hasDtAuthReleaseDate = false;
  protected Date dtAuthReleaseDate = null;
  protected boolean hasDtAuthAssignDate = false;
  protected Date dtAuthAssignDate = null;
  protected boolean hasDtChangeCancel = false;
  protected Date dtChangeCancel = null;
  protected boolean hasNbrPhone = false;
  protected String nbrPhone = null;
  protected boolean hasIndAmendedApp = false;
  protected Boolean indAmendedApp = null;
  protected Boolean indAuthRelease = null;
  protected boolean hasIndAuthRelease = false;
  protected Boolean indAuthAssign = null;
  protected boolean hasIndAuthAssign = false;
  protected Boolean indChangeCancel = null;
  protected boolean hasIndChangeCancel = false;
  protected Long idFceEligibility = null;
  protected boolean hasIdFceEligibility = false;
  protected Long idFceApplication = null;
  protected boolean hasIdFceApplication = false;
  protected Long idPerson = null;
  protected boolean hasIdPerson = false;
  protected String nmCompany = null;
  protected boolean hasNmCompany = false;
  protected String nmEmployeeNm = null;
  protected boolean hasNmEmployeeNm = false;
  protected String nmEmployer = null;
  protected boolean hasNmEmployer = false;
  protected String cdPolicyHldr = null;
  protected boolean hasCdPolicyHldr = false;
  protected String nbrGroup = null;
  protected boolean hasNbrGroup = false;
  protected String nbrPolicy = null;
  protected boolean hasNbrPolicy = false;
  protected boolean hasDtBegin = false;
  protected Date dtBegin = null;
  protected boolean hasDtEnd = false;
  protected Date dtEnd = null;
  protected boolean hasDtEndString = false;
  protected boolean hasPrinciples = false;
  protected List principles = null;
  protected boolean hasCdEventStatus = false;
  protected String cdEventStatus = null;
  protected boolean hasIdFcePerson = false;
  protected Long idFcePerson = null;
  protected boolean hasDtLastUpdate = false;
  protected Date dtLastUpdate = null;
  protected boolean hasNmEmployeePersonFull = false;
  protected String nmEmployeePersonFull = null;
  protected boolean hasNbrEmployeePersonPhone = false;
  protected String nbrEmployeePersonPhone = null;
  protected boolean hasCdApplication = false;
  protected String cdApplication = null;
  protected boolean hasAddrZipSuff = false;
  protected String addrZipSuff = null;
  
  public boolean hasIdFceThirdPartyInsurance() {
    return hasIdFceThirdPartyInsurance;
  }

  public long getIdFceThirdPartyInsurance() {
    if (idFceThirdPartyInsurance == null) {
      return (long) 0;
    }
    return idFceThirdPartyInsurance;
  }

  public Long getIdFceThirdPartyInsuranceObject() {
    return idFceThirdPartyInsurance;
  }

  public String getIdFceThirdPartyInsuranceString() {
    return FormattingHelper.formatLong(idFceThirdPartyInsurance);
  }

  public void setIdFceThirdPartyInsurance(long idFceThirdPartyInsurance) {
    this.hasIdFceThirdPartyInsurance = true;
    if (idFceThirdPartyInsurance == 0) {
      this.idFceThirdPartyInsurance = null;
      return;
    }
    this.idFceThirdPartyInsurance = idFceThirdPartyInsurance;
  }

  public void setIdFceThirdPartyInsurance(Long idFceThirdPartyInsurance) {
    this.hasIdFceThirdPartyInsurance = true;
    this.idFceThirdPartyInsurance = idFceThirdPartyInsurance;
  }

  public void setIdFceThirdPartyInsurance(Number idFceThirdPartyInsurance) {
    this.hasIdFceThirdPartyInsurance = true;
    this.idFceThirdPartyInsurance = null;
    if (idFceThirdPartyInsurance != null) {
      setIdFceThirdPartyInsurance(idFceThirdPartyInsurance.longValue());
    }
  }
  
  public boolean hasFcePersonDtLastUpdate() {
    return hasFcePersonDtLastUpdate;
  }

  public Date getFcePersonDtLastUpdate() {
    return fcePersonDtLastUpdate;
  }

  public Date getFcePersonDtLastUpdateObject() {
    return fcePersonDtLastUpdate;
  }

  public String getFcePersonDtLastUpdateString() {
    return toString(fcePersonDtLastUpdate);
  }

  public long getFcePersonDtLastUpdateTime() {
    return toTime(fcePersonDtLastUpdate);
  }

  public void setFcePersonDtLastUpdate(Date fcePersonDtLastUpdate) {
    this.hasFcePersonDtLastUpdate = true;
    if ((fcePersonDtLastUpdate != null) &&
        (fcePersonDtLastUpdate.getTime() == 0)) {
      fcePersonDtLastUpdate = null;
    }
    this.fcePersonDtLastUpdate = fcePersonDtLastUpdate;
  }

  public void setFcePersonDtLastUpdateString(String fcePersonDtLastUpdateString) {
    this.hasFcePersonDtLastUpdate = true;
    this.fcePersonDtLastUpdate = toDate(fcePersonDtLastUpdateString);
  }

  public void setFcePersonDtLastUpdateTime(long fcePersonDtLastUpdateTime) {
    this.hasFcePersonDtLastUpdate = true;
    this.fcePersonDtLastUpdate = toDate(fcePersonDtLastUpdateTime);
  }

  
  public boolean hasDtBirth() {
    return hasDtBirth;
  }

  public Date getDtBirth() {
    return dtBirth;
  }

  public Date getDtBirthObject() {
    return dtBirth;
  }

  public String getDtBirthString() {
    return toString(dtBirth);
  }

  public long getDtBirthTime() {
    return toTime(dtBirth);
  }

  public void setDtBirth(Date dtBirth) {
    this.hasDtBirth = true;
    if ((dtBirth != null) &&
        (dtBirth.getTime() == 0)) {
      dtBirth = null;
    }
    this.dtBirth = dtBirth;
  }

  public void setDtBirthString(String dtBirthString) {
    this.hasDtBirth = true;
    this.dtBirth = toDate(dtBirthString);
  }

  public void setDtBirthTime(long dtBirthTime) {
    this.hasDtBirth = true;
    this.dtBirth = toDate(dtBirthTime);
  }
  
  public boolean hasNmPersonFull() {
    return hasNmPersonFull;
  }

  public String getNmPersonFull() {
    if (nmPersonFull == null) {
      return "";
    }
    return nmPersonFull;
  }

  public String getNmPersonFullObject() {
    return nmPersonFull;
  }

  public void setNmPersonFull(String nmPersonFull) {
    this.hasNmPersonFull = true;
    this.nmPersonFull = nmPersonFull;
  }

  
  public boolean hasCdRelInt() {
    return hasCdRelInt;
  }

  public String getCdRelInt() {
    if (cdRelInt == null) {
      return "";
    }
    return cdRelInt;
  }

  public String getCdRelIntObject() {
    return cdRelInt;
  }

  public void setCdRelInt(String cdRelInt) {
    this.hasCdRelInt = true;
    this.cdRelInt = cdRelInt;
  }

  public boolean hasIndOtherHealthInsurance() {
    return hasIndOtherHealthInsurance;
  }

  public boolean getIndOtherHealthInsurance() {
    if (indOtherHealthInsurance == null) {
      return false;
    }
    return indOtherHealthInsurance;
  }

  public Boolean getIndOtherHealthInsuranceObject() {
    return indOtherHealthInsurance;
  }

  public String getIndOtherHealthInsuranceString() {
    if (indOtherHealthInsurance == null) {
      return "";
    }
    return indOtherHealthInsurance.toString();
  }

  public void setIndOtherHealthInsurance(boolean indOtherHealthInsurance) {
    this.hasIndOtherHealthInsurance = true;
    this.indOtherHealthInsurance = indOtherHealthInsurance;
  }

  public void setIndOtherHealthInsurance(Boolean indOtherHealthInsurance) {
    this.hasIndOtherHealthInsurance = true;
    this.indOtherHealthInsurance = indOtherHealthInsurance;
  }

  public void setIndOtherHealthInsurance(String indOtherHealthInsurance) {
    this.hasIndOtherHealthInsurance = true;
    this.indOtherHealthInsurance = isTrueBoolean(indOtherHealthInsurance);
  }

  public boolean hasFceApplicationDtLastUpdate() {
    return hasFceApplicationDtLastUpdate;
  }

  public Date getFceApplicationDtLastUpdate() {
    return fceApplicationDtLastUpdate;
  }

  public Date getFceApplicationDtLastUpdateObject() {
    return fceApplicationDtLastUpdate;
  }

  public String getFceApplicationDtLastUpdateString() {
    return toString(fceApplicationDtLastUpdate);
  }

  public long getFceApplicationDtLastUpdateTime() {
    return toTime(fceApplicationDtLastUpdate);
  }

  public void setFceApplicationDtLastUpdate(Date fceApplicationDtLastUpdate) {
    this.hasFceApplicationDtLastUpdate = true;
    if ((fceApplicationDtLastUpdate != null) && (fceApplicationDtLastUpdate.getTime() == 0)) {
      fceApplicationDtLastUpdate = null;
    }
    this.fceApplicationDtLastUpdate = fceApplicationDtLastUpdate;
  }

  public void setFceApplicationDtLastUpdateString(String fceApplicationDtLastUpdateString) {
    this.hasFceApplicationDtLastUpdate = true;
    this.fceApplicationDtLastUpdate = toDate(fceApplicationDtLastUpdateString);
  }

  public void setFceApplicationDtLastUpdateTime(long fceApplicationDtLastUpdateTime) {
    this.hasFceApplicationDtLastUpdate = true;
    this.fceApplicationDtLastUpdate = toDate(fceApplicationDtLastUpdateTime);
  }

  public boolean hasDtBegin() {
    return hasDtBegin;
  }

  public Date getDtBegin() {
    return dtBegin;
  }

  public Date getDtBeginObject() {
    return dtBegin;
  }

  public String getDtBeginString() {
    return toString(dtBegin);
  }

  public long getDtBeginTime() {
    return toTime(dtBegin);
  }

  public void setDtBegin(Date dtBegin) {
    this.hasDtBegin = true;
    if ((dtBegin != null) && (dtBegin.getTime() == 0)) {
      dtBegin = null;
    }
    this.dtBegin = dtBegin;
  }

  public void setDtBeginString(String dtBeginString) {
    this.hasDtBegin = true;
    this.dtBegin = toDate(dtBeginString);
  }

  public void setDtBeginTime(long dtBeginTime) {
    this.hasDtBegin = true;
    this.dtBegin = toDate(dtBeginTime);
  }

  public boolean hasDtEnd() {
    return hasDtEnd;
  }

  public Date getDtEnd() {
    return dtEnd;
  }

  public Date getDtEndObject() {
    return dtEnd;
  }

  public String getDtEndString() {
    return toString(dtEnd);
  }

  public long getDtEndTime() {
    return toTime(dtEnd);
  }

  public void setDtEnd(Date dtEnd) {
    this.hasDtEnd = true;
    if ((dtEnd != null) && (dtEnd.getTime() == 0)) {
      dtEnd = null;
    }
    this.dtEnd = dtEnd;
  }

  public void setDtEndString(String dtEndString) {
    this.hasDtEnd = true;
    this.dtEnd = toDate(dtEndString);
  }

  public void setDtEndTime(long dtEndTime) {
    this.hasDtEnd = true;
    this.dtEnd = toDate(dtEndTime);
  }

  public boolean hasIdFcePerson() {
    return hasIdFcePerson;
  }

  public long getIdFcePerson() {
    if (idFcePerson == null) {
      return (long) 0;
    }
    return idFcePerson;
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
    this.idFcePerson = idFcePerson;
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

  public boolean hasIdLastUpdatePerson() {
    return hasIdLastUpdatePerson;
  }

  public long getIdLastUpdatePerson() {
    if (idLastUpdatePerson == null) {
      return (long) 0;
    }
    return idLastUpdatePerson;
  }

  public Long getIdLastUpdatePersonObject() {
    return idLastUpdatePerson;
  }

  public String getIdLastUpdatePersonString() {
    return FormattingHelper.formatLong(idLastUpdatePerson);
  }

  public void setIdLastUpdatePerson(long idLastUpdatePerson) {
    this.hasIdLastUpdatePerson = true;
    if (idLastUpdatePerson == 0) {
      this.idLastUpdatePerson = null;
      return;
    }
    this.idLastUpdatePerson = idLastUpdatePerson;
  }

  public void setIdLastUpdatePerson(Long idLastUpdatePerson) {
    this.hasIdLastUpdatePerson = true;
    this.idLastUpdatePerson = idLastUpdatePerson;
  }

  public void setIdLastUpdatePerson(Number idLastUpdatePerson) {
    this.hasIdLastUpdatePerson = true;
    this.idLastUpdatePerson = null;
    if (idLastUpdatePerson != null) {
      setIdLastUpdatePerson(idLastUpdatePerson.longValue());
    }
  }

  public boolean hasIdEvent() {
    return hasIdEvent;
  }

  public long getIdEvent() {
    if (idEvent == null) {
      return (long) 0;
    }
    return idEvent;
  }

  public Long getIdEventObject() {
    return idEvent;
  }

  public String getIdEventString() {
    return FormattingHelper.formatLong(idEvent);
  }

  public void setIdEvent(long idEvent) {
    this.hasIdEvent = true;
    if (idEvent == 0) {
      this.idEvent = null;
      return;
    }
    this.idEvent = idEvent;
  }

  public void setIdEvent(Long idEvent) {
    this.hasIdEvent = true;
    this.idEvent = idEvent;
  }

  public void setIdEvent(Number idEvent) {
    this.hasIdEvent = true;
    this.idEvent = null;
    if (idEvent != null) {
      setIdEvent(idEvent.longValue());
    }
  }

  public boolean hasAddrCity() {
    return hasAddrCity;
  }

  public String getAddrCity() {
    if (addrCity == null) {
      return "";
    }
    return addrCity;
  }

  public String getAddrCityObject() {
    return addrCity;
  }

  public void setAddrCity(String addrCity) {
    this.hasAddrCity = true;
    this.addrCity = addrCity;
  }

  public boolean hasAddrStLn1() {
    return hasAddrStLn1;
  }

  public String getAddrStLn1() {
    if (addrStLn1 == null) {
      return "";
    }
    return addrStLn1;
  }

  public String getAddrStLn1Object() {
    return addrStLn1;
  }

  public void setAddrStLn1(String addrStLn1) {
    this.hasAddrStLn1 = true;
    this.addrStLn1 = addrStLn1;
  }

  public boolean hasAddrStLn2() {
    return hasAddrStLn2;
  }

  public String getAddrStLn2() {
    if (addrStLn2 == null) {
      return "";
    }
    return addrStLn2;
  }

  public String getAddrStLn2Object() {
    return addrStLn2;
  }

  public void setAddrStLn2(String addrStLn2) {
    this.hasAddrStLn2 = true;
    this.addrStLn2 = addrStLn2;
  }

  public boolean hasAddrZip() {
    return hasAddrZip;
  }

  public String getAddrZip() {
    if (addrZip == null) {
      return "";
    }
    return addrZip;
  }

  public String getAddrZipObject() {
    return addrZip;
  }

  public void setAddrZip(String addrZip) {
    this.hasAddrZip = true;
    this.addrZip = addrZip;
  }

  public boolean hasIdFceApplication() {
    return hasIdFceApplication;
  }

  public long getIdFceApplication() {
    if (idFceApplication == null) {
      return (long) 0;
    }
    return idFceApplication;
  }

  public Long getIdFceApplicationObject() {
    return idFceApplication;
  }

  public String getIdFceApplicationString() {
    return FormattingHelper.formatLong(idFceApplication);
  }

  public void setIdFceApplication(long idFceApplication) {
    this.hasIdFceApplication = true;
    if (idFceApplication == 0) {
      this.idFceApplication = null;
      return;
    }
    this.idFceApplication = idFceApplication;
  }

  public void setIdFceApplication(Long idFceApplication) {
    this.hasIdFceApplication = true;
    this.idFceApplication = idFceApplication;
  }

  public void setIdFceApplication(Number idFceApplication) {
    this.hasIdFceApplication = true;
    this.idFceApplication = null;
    if (idFceApplication != null) {
      setIdFceApplication(idFceApplication.longValue());
    }
  }

  public boolean hasIdFceEligibility() {
    return hasIdFceEligibility;
  }

  public long getIdFceEligibility() {
    if (idFceEligibility == null) {
      return (long) 0;
    }
    return idFceEligibility;
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
    this.idFceEligibility = idFceEligibility;
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

  public boolean hasNbrGroup() {
    return hasNbrGroup;
  }

  public String getNbrGroup() {
    if (nbrGroup == null) {
      return "";
    }
    return nbrGroup;
  }

  public String getNbrGroupObject() {
    return nbrGroup;
  }

  public void setNbrGroup(String nbrGroup) {
    this.hasNbrGroup = true;
    this.nbrGroup = nbrGroup;
  }

  public boolean hasNbrPolicy() {
    return hasNbrPolicy;
  }

  public String getNbrPolicy() {
    if (nbrPolicy == null) {
      return "";
    }
    return nbrPolicy;
  }

  public String getNbrPolicyObject() {
    return nbrPolicy;
  }

  public void setNbrPolicy(String nbrPolicy) {
    this.hasNbrPolicy = true;
    this.nbrPolicy = nbrPolicy;
  }

  public boolean hasNmCompany() {
    return hasNmCompany;
  }

  public String getNmCompany() {
    if (nmCompany == null) {
      return "";
    }
    return nmCompany;
  }

  public String getNmCompanyObject() {
    return nmCompany;
  }

  public void setNmCompany(String nmCompany) {
    this.hasNmCompany = true;
    this.nmCompany = nmCompany;
  }

  public boolean hasNmEmployeeNm() {
    return hasNmEmployeeNm;
  }

  public String getNmEmployeeNm() {
    if (nmEmployeeNm == null) {
      return "";
    }
    return nmEmployeeNm;
  }

  public String getNmEmployeeNmObject() {
    return nmEmployeeNm;
  }

  public void setNmEmployeeNm(String nmEmployeeNm) {
    this.hasNmEmployeeNm = true;
    this.nmEmployeeNm = nmEmployeeNm;
  }

  public boolean hasNmEmployer() {
    return hasNmEmployer;
  }

  public String getNmEmployer() {
    if (nmEmployer == null) {
      return "";
    }
    return nmEmployer;
  }

  public String getNmEmployerObject() {
    return nmEmployer;
  }

  public void setNmEmployer(String nmEmployer) {
    this.hasNmEmployer = true;
    this.nmEmployer = nmEmployer;
  }

  public boolean hasCdPolicyHldr() {
    return hasCdPolicyHldr;
  }

  public String getCdPolicyHldr() {
    if (cdPolicyHldr == null) {
      return "";
    }
    return cdPolicyHldr;
  }

  public String getCdPolicyHldrObject() {
    return cdPolicyHldr;
  }

  public void setCdPolicyHldr(String cdPolicyHldr) {
    this.hasCdPolicyHldr = true;
    this.cdPolicyHldr = cdPolicyHldr;
  }

  public boolean hasAddrState() {
    return hasAddrState;
  }

  public String getAddrState() {
    if (addrState == null) {
      return "";
    }
    return addrState;
  }

  public String getAddrStateObject() {
    return addrState;
  }

  public void setAddrState(String addrState) {
    this.hasAddrState = true;
    this.addrState = addrState;
  }

  public boolean hasIdPerson() {
    return hasIdPerson;
  }

  public long getIdPerson() {
    if (idPerson == null) {
      return (long) 0;
    }
    return idPerson;
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
    this.idPerson = idPerson;
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

  public boolean hasIndChildCoverage() {
    return hasIndChildCoverage;
  }

  public boolean getIndChildCoverage() {
    if (indChildCoverage == null) {
      return false;
    }
    return indChildCoverage;
  }

  public Boolean getIndChildCoverageObject() {
    return indChildCoverage;
  }

  public void setIndChildCoverage(boolean indChildCoverage) {
    this.hasIndChildCoverage = true;
    this.indChildCoverage = indChildCoverage;
  }
  
  public void setIndChildCoverage(Boolean indChildCoverage) {
    this.hasIndChildCoverage = true;
    this.indChildCoverage = indChildCoverage;
  }

  public void setIndChildCoverage(String indChildCoverage) {
    this.hasIndChildCoverage = true;
    this.indChildCoverage = isTrueBoolean(indChildCoverage);
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
    this.hasCdType = true;
    this.cdType = cdType;
  }

  public boolean hasNbrPhone() {
    return hasNbrPhone;
  }

  public String getNbrPhone() {
    if (nbrPhone == null) {
      return "";
    }
    return nbrPhone;
  }

  public String getNbrPhoneObject() {
    return nbrPhone;
  }

  public void setNbrPhone(String nbrPhone) {
    this.hasNbrPhone = true;
    this.nbrPhone = nbrPhone;
  }

  public boolean hasIndAuthRelease() {
    return hasIndAuthRelease;
  }

  public boolean hasIndAmendedApp() {
    return hasIndAmendedApp;
  }

  public boolean getIndAmendedApp() {
    if (indAmendedApp == null) {
      return false;
    }
    return indAmendedApp.booleanValue();
  }

  public Boolean getIndAmendedAppObject() {
    return indAmendedApp;
  }

  public String getIndAmendedAppString() {
    if (indAmendedApp == null) {
      return "";
    }
    return indAmendedApp.toString();
  }

  public void setIndAmendedApp(boolean indAmendedApp) {
    this.hasIndAmendedApp = true;
    this.indAmendedApp = new Boolean(indAmendedApp);
  }

  public void setIndAmendedApp(Boolean indAmendedApp) {
    this.hasIndAmendedApp = true;
    this.indAmendedApp = indAmendedApp;
  }

  public void setIndAmendedApp(String indAmendedApp) {
    this.hasIndAmendedApp = true;
    this.indAmendedApp = isTrueBoolean(indAmendedApp);
  }
  
  public boolean getIndAuthRelease() {
    if (indAuthRelease == null) {
      return false;
    }
    return indAuthRelease;
  }

  public Boolean getIndAuthReleaseObject() {
    return indAuthRelease;
  }

  public String getIndAuthReleaseString() {
    if (indAuthRelease == null) {
      return "";
    }
    return indAuthRelease.toString();
  }

  public void setIndAuthRelease(boolean indAuthRelease) {
    this.hasIndAuthRelease = true;
    this.indAuthRelease = indAuthRelease;
  }

  public void setIndAuthRelease(Boolean indAuthRelease) {
    this.hasIndAuthRelease = true;
    this.indAuthRelease = indAuthRelease;
  }

  public void setIndAuthRelease(String indAuthRelease) {
    this.hasIndAuthRelease = true;
    this.indAuthRelease = isTrueBoolean(indAuthRelease);
  }

  public boolean hasIndAuthAssign() {
    return hasIndAuthAssign;
  }

  public boolean getIndAuthAssign() {
    if (indAuthAssign == null) {
      return false;
    }
    return indAuthAssign;
  }

  public Boolean getIndAuthAssignObject() {
    return indAuthAssign;
  }

  public String getIndAuthAssignString() {
    if (indAuthAssign == null) {
      return "";
    }
    return indAuthAssign.toString();
  }

  public void setIndAuthAssign(boolean indAuthAssign) {
    this.hasIndAuthAssign = true;
    this.indAuthAssign = indAuthAssign;
  }

  public void setIndAuthAssign(Boolean indAuthAssign) {
    this.hasIndAuthAssign = true;
    this.indAuthAssign = indAuthAssign;
  }

  public void setIndAuthAssign(String indAuthAssign) {
    this.hasIndAuthAssign = true;
    this.indAuthAssign = isTrueBoolean(indAuthAssign);
  }

  public boolean hasIndChangeCancel() {
    return hasIndChangeCancel;
  }

  public boolean getIndChangeCancel() {
    if (indChangeCancel == null) {
      return false;
    }
    return indChangeCancel;
  }

  public Boolean getIndChangeCancelObject() {
    return indChangeCancel;
  }

  public String getIndChangeCancelString() {
    if (indChangeCancel == null) {
      return "";
    }
    return indChangeCancel.toString();
  }

  public void setIndChangeCancel(boolean indChangeCancel) {
    this.hasIndChangeCancel = true;
    this.indChangeCancel = indChangeCancel;
  }

  public void setIndChangeCancel(Boolean indChangeCancel) {
    this.hasIndChangeCancel = true;
    this.indChangeCancel = indChangeCancel;
  }

  public void setIndChangeCancel(String indChangeCancel) {
    this.hasIndChangeCancel = true;
    this.indChangeCancel = isTrueBoolean(indChangeCancel);
  }

  public boolean hasDtAuthAssignDate() {
    return hasDtAuthAssignDate;
  }

  public Date getDtAuthAssignDate() {
    return dtAuthAssignDate;
  }

  public Date getDtAuthAssignDateObject() {
    return dtAuthAssignDate;
  }

  public String getDtAuthAssignDateString() {
    return toString(dtAuthAssignDate);
  }

  public long getDtAuthAssignDateTime() {
    return toTime(dtAuthAssignDate);
  }

  public void setDtAuthAssignDate(Date dtAuthAssignDate) {
    this.hasDtAuthAssignDate = true;
    if ((dtAuthAssignDate != null) && (dtAuthAssignDate.getTime() == 0)) {
      dtAuthAssignDate = null;
    }
    this.dtAuthAssignDate = dtAuthAssignDate;
  }

  public void setDtAuthAssignDateString(String dtAuthAssignDateString) {
    this.hasDtAuthAssignDate = true;
    this.dtAuthAssignDate = toDate(dtAuthAssignDateString);
  }

  public void setDtAuthAssignDateTime(long dtAuthAssignDateTime) {
    this.hasDtAuthAssignDate = true;
    this.dtAuthAssignDate = toDate(dtAuthAssignDateTime);
  }

  public boolean hasDtAuthReleaseDate() {
    return hasDtAuthReleaseDate;
  }

  public Date getDtAuthReleaseDate() {
    return dtAuthReleaseDate;
  }

  public Date getDtAuthReleaseDateObject() {
    return dtAuthReleaseDate;
  }

  public String getDtAuthReleaseDateString() {
    return toString(dtAuthReleaseDate);
  }

  public long getDtAuthReleaseDateTime() {
    return toTime(dtAuthReleaseDate);
  }

  public void setDtAuthReleaseDate(Date dtAuthReleaseDate) {
    this.hasDtAuthReleaseDate = true;
    if ((dtAuthReleaseDate != null) && (dtAuthReleaseDate.getTime() == 0)) {
      dtAuthReleaseDate = null;
    }
    this.dtAuthReleaseDate = dtAuthReleaseDate;
  }

  public void setDtAuthReleaseDateString(String dtAuthReleaseDateString) {
    this.hasDtAuthReleaseDate = true;
    this.dtAuthReleaseDate = toDate(dtAuthReleaseDateString);
  }

  public void setDtAuthReleaseDateTime(long dtAuthReleaseDateTime) {
    this.hasDtAuthReleaseDate = true;
    this.dtAuthReleaseDate = toDate(dtAuthReleaseDateTime);
  }

  public boolean hasDtChangeCancel() {
    return hasDtChangeCancel;
  }

  public Date getDtChangeCancel() {
    return dtChangeCancel;
  }

  public Date getDtChangeCancelObject() {
    return dtChangeCancel;
  }

  public String getDtChangeCancelString() {
    return toString(dtChangeCancel);
  }

  public long getDtChangeCancelTime() {
    return toTime(dtChangeCancel);
  }

  public void setDtChangeCancel(Date dtChangeCancel) {
    this.hasDtChangeCancel = true;
    if ((dtChangeCancel != null) && (dtChangeCancel.getTime() == 0)) {
      dtChangeCancel = null;
    }
    this.dtChangeCancel = dtChangeCancel;
  }

  public void setDtChangeCancelString(String dtChangeCancelString) {
    this.hasDtChangeCancel = true;
    this.dtChangeCancel = toDate(dtChangeCancelString);
  }

  public void setDtChangeCancelTime(long DtChangeCancelTime) {
    this.hasDtChangeCancel = true;
    this.dtChangeCancel = toDate(DtChangeCancelTime);
  }

  public boolean hasPrinciples() {
    return hasPrinciples;
  }
  
  public List getPrinciples() {
    return principles;
  }

  public List getPrinciplesObject() {
    return principles;
  }
  public void setPrinciples(List principles) {
    this.hasPrinciples = true;
    this.principles = principles;
  }

  public boolean hasCdEventStatus() {
    return hasCdEventStatus;
  }

  public String getCdEventStatus() {
    if (cdEventStatus == null) {
      return "";
    }
    return cdEventStatus;
  }

  public String getCdEventStatusObject() {
    return cdEventStatus;
  }

  public void setCdEventStatus(String cdEventStatus) {
    this.hasCdEventStatus = true;
    this.cdEventStatus = cdEventStatus;
  }

  public boolean hasIdStage() {
    return hasIdStage;
  }

  public long getIdStage() {
    if (idStage == null) {
      return (long) 0;
    }
    return idStage;
  }

  public Long getIdStageObject() {
    return idStage;
  }

  public String getIdStageString() {
    return FormattingHelper.formatLong(idStage);
  }

  public void setIdStage(long idStage) {
    this.hasIdStage = true;
    if (idStage == 0) {
      this.idStage = null;
      return;
    }
    this.idStage = idStage;
  }

  public void setIdStage(Long idStage) {
    this.hasIdStage = true;
    this.idStage = idStage;
  }

  public void setIdStage(Number idStage) {
    this.hasIdStage = true;
    this.idStage = null;
    if (idStage != null) {
      setIdStage(idStage.longValue());
    }
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
    if ((dtLastUpdate != null) && (dtLastUpdate.getTime() == 0)) {
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
  
  public boolean hasNmEmployeePersonFull() {
    return hasNmEmployeePersonFull;
  }

  public String getNmEmployeePersonFull() {
    if (nmEmployeePersonFull == null) {
      return "";
    }
    return nmEmployeePersonFull;
  }

  public String getNmEmployeePersonFullObject() {
    return nmEmployeePersonFull;
  }

  public void setNmEmployeePersonFull(String nmEmployeePersonFull) {
    this.hasNmEmployeePersonFull = true;
    this.nmEmployeePersonFull = nmEmployeePersonFull;
  }

  public boolean hasNbrEmployeePersonPhone() {
    return hasNbrEmployeePersonPhone;
  }

  public String getNbrEmployeePersonPhone() {
    if (nbrEmployeePersonPhone == null) {
      return "";
    }
    return nbrEmployeePersonPhone;
  }

  public String getNbrEmployeePersonPhoneObject() {
    return nbrEmployeePersonPhone;
  }

  public void setNbrEmployeePersonPhone(String nbrEmployeePersonPhone) {
    this.hasNbrEmployeePersonPhone = true;
    this.nbrEmployeePersonPhone = nbrEmployeePersonPhone;
  }

  public boolean hasCdApplication() {
    return hasCdApplication;
  }

  public String getCdApplication() {
    if (cdApplication == null) {
      return "";
    }
    return cdApplication;
  }

  public String getCdApplicationObject() {
    return cdApplication;
  }

  public void setCdApplication(String cdApplication) {
    this.hasCdApplication = true;
    this.cdApplication = cdApplication;
  }
  
  public boolean hasAddrZipSuff() {
    return hasAddrZipSuff;
  }

  public String getAddrZipSuff() {
    if (addrZipSuff == null) {
      return "";
    }
    return addrZipSuff;
  }

  public String getAddrZipSuffObject() {
    return addrZipSuff;
  }

  public void setAddrZipSuff(String addrZipSuff) {
    this.hasAddrZipSuff = true;
    this.addrZipSuff = addrZipSuff;
  }
  
  public void copyInto(ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB) {
    if (hasDtBirth) {
      thirdPartyHealthInsuranceDB.setDtBirth(dtBirth);
    }
    if (hasNmPersonFull) {
      thirdPartyHealthInsuranceDB.setNmPersonFull(nmPersonFull);
    }
    if (hasCdRelInt) {
      thirdPartyHealthInsuranceDB.setCdRelInt(cdRelInt);
    }
    if (hasFceApplicationDtLastUpdate) {
      thirdPartyHealthInsuranceDB.setFceApplicationDtLastUpdate(fceApplicationDtLastUpdate);
    }
    if (hasAddrCity) {
      thirdPartyHealthInsuranceDB.setAddrCity(addrCity);
    }
    if (hasIdFcePerson) {
      thirdPartyHealthInsuranceDB.setIdFcePerson(idFcePerson);
    }
    if (hasIdLastUpdatePerson) {
      thirdPartyHealthInsuranceDB.setIdLastUpdatePerson(idLastUpdatePerson);
    }
    if (hasIdEvent) {
      thirdPartyHealthInsuranceDB.setIdEvent(idEvent);
    }
    if (hasAddrStLn1) {
      thirdPartyHealthInsuranceDB.setAddrStLn1(addrStLn1);
    }
    if (hasAddrStLn2) {
      thirdPartyHealthInsuranceDB.setAddrStLn2(addrStLn2);
    }
    if (hasAddrZip) {
      thirdPartyHealthInsuranceDB.setAddrZip(addrZip);
    }
    if (hasDtLastUpdate) {
      thirdPartyHealthInsuranceDB.setDtLastUpdate(dtLastUpdate);
    }
    if (hasDtBegin) {
      thirdPartyHealthInsuranceDB.setDtBegin(dtBegin);
    }
    if (hasDtEnd) {
      thirdPartyHealthInsuranceDB.setDtEnd(dtEnd);
    }
    if (hasCdPolicyHldr) {
      thirdPartyHealthInsuranceDB.setCdPolicyHldr(cdPolicyHldr);
    }
    if (hasAddrState) {
      thirdPartyHealthInsuranceDB.setAddrState(addrState);
    }
    if (hasIdFceApplication) {
      thirdPartyHealthInsuranceDB.setIdFceApplication(idFceApplication);
    }
    if (hasIdFceEligibility) {
      thirdPartyHealthInsuranceDB.setIdFceEligibility(idFceEligibility);
    }

    if (hasIdPerson) {
      thirdPartyHealthInsuranceDB.setIdPerson(idPerson);
    }
    if (hasNbrGroup) {
      thirdPartyHealthInsuranceDB.setNbrGroup(nbrGroup);
    }
    if (hasNbrPolicy) {
      thirdPartyHealthInsuranceDB.setNbrPolicy(nbrPolicy);
    }
    if (hasIndChildCoverage) {
      thirdPartyHealthInsuranceDB.setIndChildCoverage(indChildCoverage);
    }
    if (hasCdType) {
      thirdPartyHealthInsuranceDB.setCdType(cdType);
    }
    if (hasDtAuthReleaseDate) {
      thirdPartyHealthInsuranceDB.setDtAuthReleaseDate(dtAuthReleaseDate);
    }
    if (hasDtAuthAssignDate) {
      thirdPartyHealthInsuranceDB.setDtAuthAssignDate(dtAuthAssignDate);
    }
    if (hasDtChangeCancel) {
      thirdPartyHealthInsuranceDB.setDtChangeCancel(dtChangeCancel);
    }
    if (hasNbrPhone) {
      thirdPartyHealthInsuranceDB.setNbrPhone(nbrPhone);
    }
    if (hasIndAmendedApp) {
      thirdPartyHealthInsuranceDB.setIndAmendedApp(indAmendedApp);
    }
    if (hasIndAuthRelease) {
      thirdPartyHealthInsuranceDB.setIndAuthRelease(indAuthRelease);
    }
    if (hasIndAuthAssign) {
      thirdPartyHealthInsuranceDB.setIndAuthAssign(indAuthAssign);
    }
    if (hasIndChangeCancel) {
      thirdPartyHealthInsuranceDB.setIndChangeCancel(indChangeCancel);
    }
    if (hasPrinciples) {
      thirdPartyHealthInsuranceDB.setPrinciples(principles);
    }
    if (hasIdStage) {
      thirdPartyHealthInsuranceDB.setIdStage(idStage);
    }
    if (hasCdEventStatus) {
      thirdPartyHealthInsuranceDB.setCdEventStatus(cdEventStatus);
    }
    if (hasIdLastUpdatePerson) {
      thirdPartyHealthInsuranceDB.setIdLastUpdatePerson(idLastUpdatePerson);
    }
    if (hasIndOtherHealthInsurance) {
      thirdPartyHealthInsuranceDB.setIndOtherHealthInsurance(indOtherHealthInsurance);
    }
    if (hasNmEmployeePersonFull) {
      thirdPartyHealthInsuranceDB.setNmEmployeePersonFull(nmEmployeePersonFull);
    }
    if (hasNbrEmployeePersonPhone) {
      thirdPartyHealthInsuranceDB.setNbrEmployeePersonPhone(nbrEmployeePersonPhone);
    }
    if (hasCdApplication) {
      thirdPartyHealthInsuranceDB.setCdApplication(cdApplication);
    }
    if (hasAddrZipSuff) {
      thirdPartyHealthInsuranceDB.setAddrZipSuff(addrZipSuff);
    }
  }
  
  public FcePersonDB getFcePerson() {
    FcePersonDB fcePersonDB = new FcePersonDB();
    if (hasCdRelInt) {
      fcePersonDB.setCdRelInt(cdRelInt);
    }
    if (hasDtBirth) {
      fcePersonDB.setDtBirth(dtBirth);
    }
    if (hasFcePersonDtLastUpdate) {
      fcePersonDB.setDtLastUpdate(fcePersonDtLastUpdate);
    }
    if (hasIdFceEligibility) {
      fcePersonDB.setIdFceEligibility(idFceEligibility);
    }
    if (hasIdFcePerson) {
      fcePersonDB.setIdFcePerson(idFcePerson);
    }
    if (hasIdPerson) {
      fcePersonDB.setIdPerson(idPerson);
    }
    if (hasNmPersonFull) {
      fcePersonDB.setNmPersonFull(nmPersonFull);
    }
    if (hasIndOtherHealthInsurance) {
      fcePersonDB.setIndThirdPartyInsurance(indOtherHealthInsurance);
    }
    return fcePersonDB;
  }

  public void setFcePerson(FcePersonDB fcePersonDB) {
    if (fcePersonDB.hasCdRelInt()) {
      setCdRelInt(fcePersonDB.getCdRelIntObject());
    }
    if (fcePersonDB.hasDtBirth()) {
      setDtBirth(fcePersonDB.getDtBirthObject());
    }
    if (fcePersonDB.hasDtLastUpdate()) {
      setFcePersonDtLastUpdate(fcePersonDB.getDtLastUpdateObject());
    }
    if (fcePersonDB.hasIdFceEligibility()) {
      setIdFceEligibility(fcePersonDB.getIdFceEligibilityObject());
    }
    if (fcePersonDB.hasIdFcePerson()) {
      setIdFcePerson(fcePersonDB.getIdFcePersonObject());
    }
    if (fcePersonDB.hasIdPerson()) {
      setIdPerson(fcePersonDB.getIdPersonObject());
    }
    if (fcePersonDB.hasNmPersonFull()) {
      setNmPersonFull(fcePersonDB.getNmPersonFullObject());
    }
    if (fcePersonDB.hasIndThirdPartyInsurance()) {
      setIndOtherHealthInsurance(fcePersonDB.getIndThirdPartyInsuranceObject());
    }
  }
  
  public FceApplicationDB getFceApplication() {
    FceApplicationDB fceApplicationDB = new FceApplicationDB();
    
    if (hasFceApplicationDtLastUpdate) {
      fceApplicationDB.setDtLastUpdate(fceApplicationDtLastUpdate);
    }
    if (hasIdEvent) {
      fceApplicationDB.setIdEvent(idEvent);
    }
    if (hasIdFceApplication) {
      fceApplicationDB.setIdFceApplication(idFceApplication);
    }
    if (hasIdFceEligibility) {
      fceApplicationDB.setIdFceEligibility(idFceEligibility);
    }
    if (hasIdLastUpdatePerson) {
      fceApplicationDB.setIdLastUpdatePerson(idLastUpdatePerson);
    }
    if (hasIdPerson) {
      fceApplicationDB.setIdPerson(idPerson);
    }
    if (hasIdStage) {
      fceApplicationDB.setIdStage(idStage);
    }
    if (hasCdApplication) {
      fceApplicationDB.setCdApplication(cdApplication);
    }
    if (hasIndAmendedApp) {
      fceApplicationDB.setIndAmendedApp(indAmendedApp);
    }
    return fceApplicationDB;
  }

  public void setFceApplication(FceApplicationDB fceApplicationDB) {
    
    if (fceApplicationDB.hasIdEvent()) {
      setIdEvent(fceApplicationDB.getIdEventObject());
    }
    if (fceApplicationDB.hasIdFceApplication()) {
      setIdFceApplication(fceApplicationDB.getIdFceApplicationObject());
    }
    if (fceApplicationDB.hasIdFceEligibility()) {
      setIdFceEligibility(fceApplicationDB.getIdFceEligibilityObject());
    }
    if (fceApplicationDB.hasIdLastUpdatePerson()) {
      setIdLastUpdatePerson(fceApplicationDB.getIdLastUpdatePersonObject());
    }
    if (fceApplicationDB.hasIdPerson()) {
      setIdPerson(fceApplicationDB.getIdPersonObject());
    }
    if (fceApplicationDB.hasIdStage()) {
      setIdStage(fceApplicationDB.getIdStageObject());
    }
    if (fceApplicationDB.hasCdApplication()) {
      setCdApplication(fceApplicationDB.getCdApplicationObject());
    }
    if (fceApplicationDB.hasIndAmendedApp()) {
      setIndAmendedApp(fceApplicationDB.getIndAmendedAppObject());
    }
  }

  public String toString() {
    return "BEGIN bean: ThirdPartyHealthInsurance\n" + 
    " addrCity: " + addrCity + "\n" + 
    " addrStLn1: " + addrStLn1 + "\n" + 
    " addrStLn2: " + addrStLn2 + "\n" + 
    " addrZip: " + addrZip + "\n" + 
    " AddrState: " + addrState + "\n" + 
    " idFceApplication: " + idFceApplication + "\n" + 
    " idFceEligibility: " + idFceEligibility + "\n" + 
    " idPerson: " + idPerson + "\n" + 
    " nbrGroup: " + nbrGroup + "\n" + 
    " nbrPolicy: " + nbrPolicy + "\n" + 
    " nmCompany: " + nmCompany + "\n" + 
    " nmEmployeeNm: " + nmEmployeeNm + "\n" + 
    " nmEmployer: " + nmEmployer + "\n" + 
    " cdPolicyHldr: " + cdPolicyHldr + "\n" + 
    " indChildCoverage: " + indChildCoverage + "\n"  + 
    " cdType: " + cdType + "\n" + 
    " dtAuthReleaseDate: " + dtAuthReleaseDate + "\n" + 
    " dtAuthAssignDate: " + dtAuthAssignDate + "\n" + 
    " dtChangeCancel: " + dtChangeCancel + "\n" + 
    " nbrPhone: " + nbrPhone + "\n" + 
    " indAuthRelease: " + indAuthRelease + "\n" + 
    " indAuthAssign: " + indAuthAssign + "\n" + 
    " indChangeCancel: " + indChangeCancel + "\n" + 
    " principles: " + principles + "\n" + 
    " idEvent: " + idEvent + 
    " idLastUpdatePerson: " + idLastUpdatePerson + "\n" + 
    " cdEventStatus: " + cdEventStatus + "\n" + 
    " idStage: " + idStage + "\n" + 
    " idFcePerson: " + idFcePerson + "\n" + 
    " fceApplicationDtLastUpdate: " + fceApplicationDtLastUpdate + "\n" + 
    " indOtherHealthInsurance: " + indOtherHealthInsurance + "\n" +
    " dtBegin: " + dtBegin + "\n" + 
    " dtEnd: " + dtEnd + "\n" + 
    " dtLastUpdate: " + dtLastUpdate + "\n" + 
    " cdRelInt: " + cdRelInt + "\n" + 
    " nmPersonFull: " + nmPersonFull + "\n" +  
    " dtBirth: " + dtBirth + "\n"  +  
    " fcePersonDtLastUpdate: " + fcePersonDtLastUpdate + "\n"  + 
    " nmEmployeePersonFull: " + nmEmployeePersonFull + "\n" +
    " nbrEmployeePersonPhone: " + nbrEmployeePersonPhone + "\n" +
    " cdApplication: " + cdApplication + "\n" +
    " indAmendedApp: " + indAmendedApp + "\n" + 
    " addrZipSuff: " + addrZipSuff + "\n" + 
    "END bean: ThirdPartyHealthInsurance\n";
  }

  public static Boolean isTrueBoolean(String string) {
    if (string == null) {
      return null;
    }
    return isTrue(string);
  }

  public static boolean isTrue(String string) {
    return ((string != null) && ("Y".equals(string) || "1".equals(string)));
  }

  /** Similar to StringHelper.isFalse, except it handles null and "1" */
  public static boolean isFalse(String string) {
    return (isTrue(string) == false);
  }

  /** true --> "Y" false --> "N" */
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
    if (value) {
      return "Y";
    }
    return "N";
  }

  // copied from PalDB
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
