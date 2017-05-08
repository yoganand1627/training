//DO NOT MAKE ANY CHANGES TO THIS FILE
//IT IS GENERATED
//see Matthew McClain (PRSmmcclain) if a change needs to be made

package gov.georgia.dhr.dfcs.sacwis.dao.fce;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

public class PersonDB
        implements Serializable {
  public static final String ADDR_PERSON_CITY = "addrPersonCity";
  public static final String ADDR_PERSON_ST_LN1 = "addrPersonStLn1";
  public static final String ADDR_PERSON_ZIP = "addrPersonZip";
  public static final String CD_PERSON_CHAR = "cdPersonChar";
  public static final String CD_PERSON_COUNTY = "cdPersonCounty";
  public static final String CD_PERSON_DEATH = "cdPersonDeath";
  public static final String CD_PERSON_ETHNIC_GROUP = "cdPersonEthnicGroup";
  public static final String CD_PERSON_LANGUAGE = "cdPersonLanguage";
  public static final String CD_PERSON_LIV_ARR = "cdPersonLivArr";
  public static final String CD_PERSON_MARITAL_STATUS = "cdPersonMaritalStatus";
  public static final String CD_PERSON_RELIGION = "cdPersonReligion";
  public static final String CD_PERSON_SEX = "cdPersonSex";
  public static final String CD_PERSON_STATE = "cdPersonState";
  public static final String CD_PERSON_STATUS = "cdPersonStatus";
  public static final String CD_PERSON_SUFFIX = "cdPersonSuffix";
  public static final String CD_PERS_GUARD_CNSRV = "cdPersGuardCnsrv";
  public static final String DT_LAST_UPDATE_STRING = "dtLastUpdateString";
  public static final String DT_LAST_UPDATE_TIME = "dtLastUpdateTime";
  public static final String DT_PERSON_BIRTH_STRING = "dtPersonBirthString";
  public static final String DT_PERSON_BIRTH_TIME = "dtPersonBirthTime";
  public static final String DT_PERSON_DEATH_STRING = "dtPersonDeathString";
  public static final String DT_PERSON_DEATH_TIME = "dtPersonDeathTime";
  public static final String ID_PERSON = "idPerson";
  public static final String IND_PERSON_DOB_APPROX = "indPersonDobApprox";
  public static final String IND_PERS_CANCEL_HIST = "indPersCancelHist";
  public static final String NBR_PERSON_AGE = "nbrPersonAge";
  public static final String NBR_PERSON_ID_NUMBER = "nbrPersonIdNumber";
  public static final String NBR_PERSON_PHONE = "nbrPersonPhone";
  public static final String NM_PERSON_FIRST = "nmPersonFirst";
  public static final String NM_PERSON_FULL = "nmPersonFull";
  public static final String NM_PERSON_LAST = "nmPersonLast";
  public static final String NM_PERSON_MIDDLE = "nmPersonMiddle";
  public static final String TXT_PERSON_OCCUPATION = "txtPersonOccupation";

  protected boolean hasAddrPersonCity = false;
  protected String addrPersonCity = null;
  protected boolean hasAddrPersonStLn1 = false;
  protected String addrPersonStLn1 = null;
  protected boolean hasAddrPersonZip = false;
  protected String addrPersonZip = null;
  protected boolean hasCdPersonChar = false;
  protected String cdPersonChar = null;
  protected boolean hasCdPersonCounty = false;
  protected String cdPersonCounty = null;
  protected boolean hasCdPersonDeath = false;
  protected String cdPersonDeath = null;
  protected boolean hasCdPersonEthnicGroup = false;
  protected String cdPersonEthnicGroup = null;
  protected boolean hasCdPersonLanguage = false;
  protected String cdPersonLanguage = null;
  protected boolean hasCdPersonLivArr = false;
  protected String cdPersonLivArr = null;
  protected boolean hasCdPersonMaritalStatus = false;
  protected String cdPersonMaritalStatus = null;
  protected boolean hasCdPersonReligion = false;
  protected String cdPersonReligion = null;
  protected boolean hasCdPersonSex = false;
  protected String cdPersonSex = null;
  protected boolean hasCdPersonState = false;
  protected String cdPersonState = null;
  protected boolean hasCdPersonStatus = false;
  protected String cdPersonStatus = null;
  protected boolean hasCdPersonSuffix = false;
  protected String cdPersonSuffix = null;
  protected boolean hasCdPersGuardCnsrv = false;
  protected String cdPersGuardCnsrv = null;
  protected boolean hasDtLastUpdate = false;
  protected Date dtLastUpdate = null;
  protected boolean hasDtPersonBirth = false;
  protected Date dtPersonBirth = null;
  protected boolean hasDtPersonDeath = false;
  protected Date dtPersonDeath = null;
  protected boolean hasIdPerson = false;
  protected Long idPerson = null;
  protected boolean hasIndPersonDobApprox = false;
  protected Boolean indPersonDobApprox = null;
  protected boolean hasIndPersCancelHist = false;
  protected Boolean indPersCancelHist = null;
  protected boolean hasNbrPersonAge = false;
  protected Long nbrPersonAge = null;
  protected boolean hasNbrPersonIdNumber = false;
  protected String nbrPersonIdNumber = null;
  protected boolean hasNbrPersonPhone = false;
  protected String nbrPersonPhone = null;
  protected boolean hasNmPersonFirst = false;
  protected String nmPersonFirst = null;
  protected boolean hasNmPersonFull = false;
  protected String nmPersonFull = null;
  protected boolean hasNmPersonLast = false;
  protected String nmPersonLast = null;
  protected boolean hasNmPersonMiddle = false;
  protected String nmPersonMiddle = null;
  protected boolean hasTxtPersonOccupation = false;
  protected String txtPersonOccupation = null;

  public boolean hasAddrPersonCity() {
    return hasAddrPersonCity;
  }

  public String getAddrPersonCity() {
    if (addrPersonCity == null) {
      return "";
    }
    return addrPersonCity;
  }

  public String getAddrPersonCityObject() {
    return addrPersonCity;
  }

  public void setAddrPersonCity(String addrPersonCity) {
    if ((addrPersonCity != null) &&
        (addrPersonCity.length() > 20)) {
      throw new IllegalStateException("Data is too large for 'addrPersonCity'; \n" +
                                      " max size = 20; \n" +
                                      " data = '" + addrPersonCity + "'");
    }
    this.hasAddrPersonCity = true;
    this.addrPersonCity = addrPersonCity;
  }

  public boolean hasAddrPersonStLn1() {
    return hasAddrPersonStLn1;
  }

  public String getAddrPersonStLn1() {
    if (addrPersonStLn1 == null) {
      return "";
    }
    return addrPersonStLn1;
  }

  public String getAddrPersonStLn1Object() {
    return addrPersonStLn1;
  }

  public void setAddrPersonStLn1(String addrPersonStLn1) {
    if ((addrPersonStLn1 != null) &&
        (addrPersonStLn1.length() > 30)) {
      throw new IllegalStateException("Data is too large for 'addrPersonStLn1'; \n" +
                                      " max size = 30; \n" +
                                      " data = '" + addrPersonStLn1 + "'");
    }
    this.hasAddrPersonStLn1 = true;
    this.addrPersonStLn1 = addrPersonStLn1;
  }

  public boolean hasAddrPersonZip() {
    return hasAddrPersonZip;
  }

  public String getAddrPersonZip() {
    if (addrPersonZip == null) {
      return "";
    }
    return addrPersonZip;
  }

  public String getAddrPersonZipObject() {
    return addrPersonZip;
  }

  public void setAddrPersonZip(String addrPersonZip) {
    if ((addrPersonZip != null) &&
        (addrPersonZip.length() > 10)) {
      throw new IllegalStateException("Data is too large for 'addrPersonZip'; \n" +
                                      " max size = 10; \n" +
                                      " data = '" + addrPersonZip + "'");
    }
    this.hasAddrPersonZip = true;
    this.addrPersonZip = addrPersonZip;
  }

  public boolean hasCdPersonChar() {
    return hasCdPersonChar;
  }

  public String getCdPersonChar() {
    if (cdPersonChar == null) {
      return "";
    }
    return cdPersonChar;
  }

  public String getCdPersonCharObject() {
    return cdPersonChar;
  }

  public void setCdPersonChar(String cdPersonChar) {
    if ((cdPersonChar != null) &&
        (cdPersonChar.length() > 1)) {
      throw new IllegalStateException("Data is too large for 'cdPersonChar'; \n" +
                                      " max size = 1; \n" +
                                      " data = '" + cdPersonChar + "'");
    }
    this.hasCdPersonChar = true;
    this.cdPersonChar = cdPersonChar;
  }

  public boolean hasCdPersonCounty() {
    return hasCdPersonCounty;
  }

  public String getCdPersonCounty() {
    if (cdPersonCounty == null) {
      return "";
    }
    return cdPersonCounty;
  }

  public String getCdPersonCountyObject() {
    return cdPersonCounty;
  }

  public void setCdPersonCounty(String cdPersonCounty) {
    if ((cdPersonCounty != null) &&
        (cdPersonCounty.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdPersonCounty'; \n" +
                                      " max size = 3; \n" +
                                      " data = '" + cdPersonCounty + "'");
    }
    this.hasCdPersonCounty = true;
    this.cdPersonCounty = cdPersonCounty;
  }

  public boolean hasCdPersonDeath() {
    return hasCdPersonDeath;
  }

  public String getCdPersonDeath() {
    if (cdPersonDeath == null) {
      return "";
    }
    return cdPersonDeath;
  }

  public String getCdPersonDeathObject() {
    return cdPersonDeath;
  }

  public void setCdPersonDeath(String cdPersonDeath) {
    if ((cdPersonDeath != null) &&
        (cdPersonDeath.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdPersonDeath'; \n" +
                                      " max size = 3; \n" +
                                      " data = '" + cdPersonDeath + "'");
    }
    this.hasCdPersonDeath = true;
    this.cdPersonDeath = cdPersonDeath;
  }

  public boolean hasCdPersonEthnicGroup() {
    return hasCdPersonEthnicGroup;
  }

  public String getCdPersonEthnicGroup() {
    if (cdPersonEthnicGroup == null) {
      return "";
    }
    return cdPersonEthnicGroup;
  }

  public String getCdPersonEthnicGroupObject() {
    return cdPersonEthnicGroup;
  }

  public void setCdPersonEthnicGroup(String cdPersonEthnicGroup) {
    if ((cdPersonEthnicGroup != null) &&
        (cdPersonEthnicGroup.length() > 2)) {
      throw new IllegalStateException("Data is too large for 'cdPersonEthnicGroup'; \n" +
                                      " max size = 2; \n" +
                                      " data = '" + cdPersonEthnicGroup + "'");
    }
    this.hasCdPersonEthnicGroup = true;
    this.cdPersonEthnicGroup = cdPersonEthnicGroup;
  }

  public boolean hasCdPersonLanguage() {
    return hasCdPersonLanguage;
  }

  public String getCdPersonLanguage() {
    if (cdPersonLanguage == null) {
      return "";
    }
    return cdPersonLanguage;
  }

  public String getCdPersonLanguageObject() {
    return cdPersonLanguage;
  }

  public void setCdPersonLanguage(String cdPersonLanguage) {
    if ((cdPersonLanguage != null) &&
        (cdPersonLanguage.length() > 2)) {
      throw new IllegalStateException("Data is too large for 'cdPersonLanguage'; \n" +
                                      " max size = 2; \n" +
                                      " data = '" + cdPersonLanguage + "'");
    }
    this.hasCdPersonLanguage = true;
    this.cdPersonLanguage = cdPersonLanguage;
  }

  public boolean hasCdPersonLivArr() {
    return hasCdPersonLivArr;
  }

  public String getCdPersonLivArr() {
    if (cdPersonLivArr == null) {
      return "";
    }
    return cdPersonLivArr;
  }

  public String getCdPersonLivArrObject() {
    return cdPersonLivArr;
  }

  public void setCdPersonLivArr(String cdPersonLivArr) {
    if ((cdPersonLivArr != null) &&
        (cdPersonLivArr.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdPersonLivArr'; \n" +
                                      " max size = 3; \n" +
                                      " data = '" + cdPersonLivArr + "'");
    }
    this.hasCdPersonLivArr = true;
    this.cdPersonLivArr = cdPersonLivArr;
  }

  public boolean hasCdPersonMaritalStatus() {
    return hasCdPersonMaritalStatus;
  }

  public String getCdPersonMaritalStatus() {
    if (cdPersonMaritalStatus == null) {
      return "";
    }
    return cdPersonMaritalStatus;
  }

  public String getCdPersonMaritalStatusObject() {
    return cdPersonMaritalStatus;
  }

  public void setCdPersonMaritalStatus(String cdPersonMaritalStatus) {
    if ((cdPersonMaritalStatus != null) &&
        (cdPersonMaritalStatus.length() > 2)) {
      throw new IllegalStateException("Data is too large for 'cdPersonMaritalStatus'; \n" +
                                      " max size = 2; \n" +
                                      " data = '" + cdPersonMaritalStatus + "'");
    }
    this.hasCdPersonMaritalStatus = true;
    this.cdPersonMaritalStatus = cdPersonMaritalStatus;
  }

  public boolean hasCdPersonReligion() {
    return hasCdPersonReligion;
  }

  public String getCdPersonReligion() {
    if (cdPersonReligion == null) {
      return "";
    }
    return cdPersonReligion;
  }

  public String getCdPersonReligionObject() {
    return cdPersonReligion;
  }

  public void setCdPersonReligion(String cdPersonReligion) {
    if ((cdPersonReligion != null) &&
        (cdPersonReligion.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdPersonReligion'; \n" +
                                      " max size = 3; \n" +
                                      " data = '" + cdPersonReligion + "'");
    }
    this.hasCdPersonReligion = true;
    this.cdPersonReligion = cdPersonReligion;
  }

  public boolean hasCdPersonSex() {
    return hasCdPersonSex;
  }

  public String getCdPersonSex() {
    if (cdPersonSex == null) {
      return "";
    }
    return cdPersonSex;
  }

  public String getCdPersonSexObject() {
    return cdPersonSex;
  }

  public void setCdPersonSex(String cdPersonSex) {
    if ((cdPersonSex != null) &&
        (cdPersonSex.length() > 1)) {
      throw new IllegalStateException("Data is too large for 'cdPersonSex'; \n" +
                                      " max size = 1; \n" +
                                      " data = '" + cdPersonSex + "'");
    }
    this.hasCdPersonSex = true;
    this.cdPersonSex = cdPersonSex;
  }

  public boolean hasCdPersonState() {
    return hasCdPersonState;
  }

  public String getCdPersonState() {
    if (cdPersonState == null) {
      return "";
    }
    return cdPersonState;
  }

  public String getCdPersonStateObject() {
    return cdPersonState;
  }

  public void setCdPersonState(String cdPersonState) {
    if ((cdPersonState != null) &&
        (cdPersonState.length() > 2)) {
      throw new IllegalStateException("Data is too large for 'cdPersonState'; \n" +
                                      " max size = 2; \n" +
                                      " data = '" + cdPersonState + "'");
    }
    this.hasCdPersonState = true;
    this.cdPersonState = cdPersonState;
  }

  public boolean hasCdPersonStatus() {
    return hasCdPersonStatus;
  }

  public String getCdPersonStatus() {
    if (cdPersonStatus == null) {
      return "";
    }
    return cdPersonStatus;
  }

  public String getCdPersonStatusObject() {
    return cdPersonStatus;
  }

  public void setCdPersonStatus(String cdPersonStatus) {
    if ((cdPersonStatus != null) &&
        (cdPersonStatus.length() > 1)) {
      throw new IllegalStateException("Data is too large for 'cdPersonStatus'; \n" +
                                      " max size = 1; \n" +
                                      " data = '" + cdPersonStatus + "'");
    }
    this.hasCdPersonStatus = true;
    this.cdPersonStatus = cdPersonStatus;
  }

  public boolean hasCdPersonSuffix() {
    return hasCdPersonSuffix;
  }

  public String getCdPersonSuffix() {
    if (cdPersonSuffix == null) {
      return "";
    }
    return cdPersonSuffix;
  }

  public String getCdPersonSuffixObject() {
    return cdPersonSuffix;
  }

  public void setCdPersonSuffix(String cdPersonSuffix) {
    if ((cdPersonSuffix != null) &&
        (cdPersonSuffix.length() > 2)) {
      throw new IllegalStateException("Data is too large for 'cdPersonSuffix'; \n" +
                                      " max size = 2; \n" +
                                      " data = '" + cdPersonSuffix + "'");
    }
    this.hasCdPersonSuffix = true;
    this.cdPersonSuffix = cdPersonSuffix;
  }

  public boolean hasCdPersGuardCnsrv() {
    return hasCdPersGuardCnsrv;
  }

  public String getCdPersGuardCnsrv() {
    if (cdPersGuardCnsrv == null) {
      return "";
    }
    return cdPersGuardCnsrv;
  }

  public String getCdPersGuardCnsrvObject() {
    return cdPersGuardCnsrv;
  }

  public void setCdPersGuardCnsrv(String cdPersGuardCnsrv) {
    if ((cdPersGuardCnsrv != null) &&
        (cdPersGuardCnsrv.length() > 1)) {
      throw new IllegalStateException("Data is too large for 'cdPersGuardCnsrv'; \n" +
                                      " max size = 1; \n" +
                                      " data = '" + cdPersGuardCnsrv + "'");
    }
    this.hasCdPersGuardCnsrv = true;
    this.cdPersGuardCnsrv = cdPersGuardCnsrv;
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

  public boolean hasDtPersonBirth() {
    return hasDtPersonBirth;
  }

  public Date getDtPersonBirth() {
    return dtPersonBirth;
  }

  public Date getDtPersonBirthObject() {
    return dtPersonBirth;
  }

  public String getDtPersonBirthString() {
    return toString(dtPersonBirth);
  }

  public long getDtPersonBirthTime() {
    return toTime(dtPersonBirth);
  }

  public void setDtPersonBirth(Date dtPersonBirth) {
    this.hasDtPersonBirth = true;
    if ((dtPersonBirth != null) &&
        (dtPersonBirth.getTime() == 0)) {
      dtPersonBirth = null;
    }
    this.dtPersonBirth = dtPersonBirth;
  }

  public void setDtPersonBirthString(String dtPersonBirthString) {
    this.hasDtPersonBirth = true;
    this.dtPersonBirth = toDate(dtPersonBirthString);
  }

  public void setDtPersonBirthTime(long dtPersonBirthTime) {
    this.hasDtPersonBirth = true;
    this.dtPersonBirth = toDate(dtPersonBirthTime);
  }

  public boolean hasDtPersonDeath() {
    return hasDtPersonDeath;
  }

  public Date getDtPersonDeath() {
    return dtPersonDeath;
  }

  public Date getDtPersonDeathObject() {
    return dtPersonDeath;
  }

  public String getDtPersonDeathString() {
    return toString(dtPersonDeath);
  }

  public long getDtPersonDeathTime() {
    return toTime(dtPersonDeath);
  }

  public void setDtPersonDeath(Date dtPersonDeath) {
    this.hasDtPersonDeath = true;
    if ((dtPersonDeath != null) &&
        (dtPersonDeath.getTime() == 0)) {
      dtPersonDeath = null;
    }
    this.dtPersonDeath = dtPersonDeath;
  }

  public void setDtPersonDeathString(String dtPersonDeathString) {
    this.hasDtPersonDeath = true;
    this.dtPersonDeath = toDate(dtPersonDeathString);
  }

  public void setDtPersonDeathTime(long dtPersonDeathTime) {
    this.hasDtPersonDeath = true;
    this.dtPersonDeath = toDate(dtPersonDeathTime);
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

  public boolean hasIndPersonDobApprox() {
    return hasIndPersonDobApprox;
  }

  public boolean getIndPersonDobApprox() {
    if (indPersonDobApprox == null) {
      return false;
    }
    return indPersonDobApprox.booleanValue();
  }

  public Boolean getIndPersonDobApproxObject() {
    return indPersonDobApprox;
  }

  public String getIndPersonDobApproxString() {
    if (indPersonDobApprox == null) {
      return "";
    }
    return indPersonDobApprox.toString();
  }

  public void setIndPersonDobApprox(boolean indPersonDobApprox) {
    this.hasIndPersonDobApprox = true;
    this.indPersonDobApprox = new Boolean(indPersonDobApprox);
  }

  public void setIndPersonDobApprox(Boolean indPersonDobApprox) {
    this.hasIndPersonDobApprox = true;
    this.indPersonDobApprox = indPersonDobApprox;
  }

  public void setIndPersonDobApprox(String indPersonDobApprox) {
    this.hasIndPersonDobApprox = true;
    this.indPersonDobApprox = isTrueBoolean(indPersonDobApprox);
  }

  public boolean hasIndPersCancelHist() {
    return hasIndPersCancelHist;
  }

  public boolean getIndPersCancelHist() {
    if (indPersCancelHist == null) {
      return false;
    }
    return indPersCancelHist.booleanValue();
  }

  public Boolean getIndPersCancelHistObject() {
    return indPersCancelHist;
  }

  public String getIndPersCancelHistString() {
    if (indPersCancelHist == null) {
      return "";
    }
    return indPersCancelHist.toString();
  }

  public void setIndPersCancelHist(boolean indPersCancelHist) {
    this.hasIndPersCancelHist = true;
    this.indPersCancelHist = new Boolean(indPersCancelHist);
  }

  public void setIndPersCancelHist(Boolean indPersCancelHist) {
    this.hasIndPersCancelHist = true;
    this.indPersCancelHist = indPersCancelHist;
  }

  public void setIndPersCancelHist(String indPersCancelHist) {
    this.hasIndPersCancelHist = true;
    this.indPersCancelHist = isTrueBoolean(indPersCancelHist);
  }

  public boolean hasNbrPersonAge() {
    return hasNbrPersonAge;
  }

  public long getNbrPersonAge() {
    if (nbrPersonAge == null) {
      return (long) 0;
    }
    return nbrPersonAge.longValue();
  }

  public Long getNbrPersonAgeObject() {
    return nbrPersonAge;
  }

  public String getNbrPersonAgeString() {
    return FormattingHelper.formatLong(nbrPersonAge);
  }

  public void setNbrPersonAge(long nbrPersonAge) {
    this.hasNbrPersonAge = true;
    if (nbrPersonAge == 0) {
      this.nbrPersonAge = null;
      return;
    }
    this.nbrPersonAge = new Long(nbrPersonAge);
  }

  public void setNbrPersonAge(Long nbrPersonAge) {
    this.hasNbrPersonAge = true;
    this.nbrPersonAge = nbrPersonAge;
  }

  public void setNbrPersonAge(Number nbrPersonAge) {
    this.hasNbrPersonAge = true;
    this.nbrPersonAge = null;
    if (nbrPersonAge != null) {
      setNbrPersonAge(nbrPersonAge.longValue());
    }
  }

  public boolean hasNbrPersonIdNumber() {
    return hasNbrPersonIdNumber;
  }

  public String getNbrPersonIdNumber() {
    if (nbrPersonIdNumber == null) {
      return "";
    }
    return nbrPersonIdNumber;
  }

  public String getNbrPersonIdNumberObject() {
    return nbrPersonIdNumber;
  }

  public void setNbrPersonIdNumber(String nbrPersonIdNumber) {
    if ((nbrPersonIdNumber != null) &&
        (nbrPersonIdNumber.length() > 15)) {
      throw new IllegalStateException("Data is too large for 'nbrPersonIdNumber'; \n" +
                                      " max size = 15; \n" +
                                      " data = '" + nbrPersonIdNumber + "'");
    }
    this.hasNbrPersonIdNumber = true;
    this.nbrPersonIdNumber = nbrPersonIdNumber;
  }

  public boolean hasNbrPersonPhone() {
    return hasNbrPersonPhone;
  }

  public String getNbrPersonPhone() {
    if (nbrPersonPhone == null) {
      return "";
    }
    return nbrPersonPhone;
  }

  public String getNbrPersonPhoneObject() {
    return nbrPersonPhone;
  }

  public void setNbrPersonPhone(String nbrPersonPhone) {
    if ((nbrPersonPhone != null) &&
        (nbrPersonPhone.length() > 10)) {
      throw new IllegalStateException("Data is too large for 'nbrPersonPhone'; \n" +
                                      " max size = 10; \n" +
                                      " data = '" + nbrPersonPhone + "'");
    }
    this.hasNbrPersonPhone = true;
    this.nbrPersonPhone = nbrPersonPhone;
  }

  public boolean hasNmPersonFirst() {
    return hasNmPersonFirst;
  }

  public String getNmPersonFirst() {
    if (nmPersonFirst == null) {
      return "";
    }
    return nmPersonFirst;
  }

  public String getNmPersonFirstObject() {
    return nmPersonFirst;
  }

  public void setNmPersonFirst(String nmPersonFirst) {
    if ((nmPersonFirst != null) &&
        (nmPersonFirst.length() > 12)) {
      throw new IllegalStateException("Data is too large for 'nmPersonFirst'; \n" +
                                      " max size = 12; \n" +
                                      " data = '" + nmPersonFirst + "'");
    }
    this.hasNmPersonFirst = true;
    this.nmPersonFirst = nmPersonFirst;
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
    if ((nmPersonFull != null) &&
        (nmPersonFull.length() > 25)) {
      throw new IllegalStateException("Data is too large for 'nmPersonFull'; \n" +
                                      " max size = 25; \n" +
                                      " data = '" + nmPersonFull + "'");
    }
    this.hasNmPersonFull = true;
    this.nmPersonFull = nmPersonFull;
  }

  public boolean hasNmPersonLast() {
    return hasNmPersonLast;
  }

  public String getNmPersonLast() {
    if (nmPersonLast == null) {
      return "";
    }
    return nmPersonLast;
  }

  public String getNmPersonLastObject() {
    return nmPersonLast;
  }

  public void setNmPersonLast(String nmPersonLast) {
    if ((nmPersonLast != null) &&
        (nmPersonLast.length() > 22)) {
      throw new IllegalStateException("Data is too large for 'nmPersonLast'; \n" +
                                      " max size = 22; \n" +
                                      " data = '" + nmPersonLast + "'");
    }
    this.hasNmPersonLast = true;
    this.nmPersonLast = nmPersonLast;
  }

  public boolean hasNmPersonMiddle() {
    return hasNmPersonMiddle;
  }

  public String getNmPersonMiddle() {
    if (nmPersonMiddle == null) {
      return "";
    }
    return nmPersonMiddle;
  }

  public String getNmPersonMiddleObject() {
    return nmPersonMiddle;
  }

  public void setNmPersonMiddle(String nmPersonMiddle) {
    if ((nmPersonMiddle != null) &&
        (nmPersonMiddle.length() > 12)) {
      throw new IllegalStateException("Data is too large for 'nmPersonMiddle'; \n" +
                                      " max size = 12; \n" +
                                      " data = '" + nmPersonMiddle + "'");
    }
    this.hasNmPersonMiddle = true;
    this.nmPersonMiddle = nmPersonMiddle;
  }

  public boolean hasTxtPersonOccupation() {
    return hasTxtPersonOccupation;
  }

  public String getTxtPersonOccupation() {
    if (txtPersonOccupation == null) {
      return "";
    }
    return txtPersonOccupation;
  }

  public String getTxtPersonOccupationObject() {
    return txtPersonOccupation;
  }

  public void setTxtPersonOccupation(String txtPersonOccupation) {
    if ((txtPersonOccupation != null) &&
        (txtPersonOccupation.length() > 20)) {
      throw new IllegalStateException("Data is too large for 'txtPersonOccupation'; \n" +
                                      " max size = 20; \n" +
                                      " data = '" + txtPersonOccupation + "'");
    }
    this.hasTxtPersonOccupation = true;
    this.txtPersonOccupation = txtPersonOccupation;
  }

  public void copyInto(PersonDB personDB) {
    if (hasAddrPersonCity) {
      personDB.setAddrPersonCity(addrPersonCity);
    }
    if (hasAddrPersonStLn1) {
      personDB.setAddrPersonStLn1(addrPersonStLn1);
    }
    if (hasAddrPersonZip) {
      personDB.setAddrPersonZip(addrPersonZip);
    }
    if (hasCdPersonChar) {
      personDB.setCdPersonChar(cdPersonChar);
    }
    if (hasCdPersonCounty) {
      personDB.setCdPersonCounty(cdPersonCounty);
    }
    if (hasCdPersonDeath) {
      personDB.setCdPersonDeath(cdPersonDeath);
    }
    if (hasCdPersonEthnicGroup) {
      personDB.setCdPersonEthnicGroup(cdPersonEthnicGroup);
    }
    if (hasCdPersonLanguage) {
      personDB.setCdPersonLanguage(cdPersonLanguage);
    }
    if (hasCdPersonLivArr) {
      personDB.setCdPersonLivArr(cdPersonLivArr);
    }
    if (hasCdPersonMaritalStatus) {
      personDB.setCdPersonMaritalStatus(cdPersonMaritalStatus);
    }
    if (hasCdPersonReligion) {
      personDB.setCdPersonReligion(cdPersonReligion);
    }
    if (hasCdPersonSex) {
      personDB.setCdPersonSex(cdPersonSex);
    }
    if (hasCdPersonState) {
      personDB.setCdPersonState(cdPersonState);
    }
    if (hasCdPersonStatus) {
      personDB.setCdPersonStatus(cdPersonStatus);
    }
    if (hasCdPersonSuffix) {
      personDB.setCdPersonSuffix(cdPersonSuffix);
    }
    if (hasCdPersGuardCnsrv) {
      personDB.setCdPersGuardCnsrv(cdPersGuardCnsrv);
    }
    if (hasDtLastUpdate) {
      personDB.setDtLastUpdate(dtLastUpdate);
    }
    if (hasDtPersonBirth) {
      personDB.setDtPersonBirth(dtPersonBirth);
    }
    if (hasDtPersonDeath) {
      personDB.setDtPersonDeath(dtPersonDeath);
    }
    if (hasIdPerson) {
      personDB.setIdPerson(idPerson);
    }
    if (hasIndPersonDobApprox) {
      personDB.setIndPersonDobApprox(indPersonDobApprox);
    }
    if (hasIndPersCancelHist) {
      personDB.setIndPersCancelHist(indPersCancelHist);
    }
    if (hasNbrPersonAge) {
      personDB.setNbrPersonAge(nbrPersonAge);
    }
    if (hasNbrPersonIdNumber) {
      personDB.setNbrPersonIdNumber(nbrPersonIdNumber);
    }
    if (hasNbrPersonPhone) {
      personDB.setNbrPersonPhone(nbrPersonPhone);
    }
    if (hasNmPersonFirst) {
      personDB.setNmPersonFirst(nmPersonFirst);
    }
    if (hasNmPersonFull) {
      personDB.setNmPersonFull(nmPersonFull);
    }
    if (hasNmPersonLast) {
      personDB.setNmPersonLast(nmPersonLast);
    }
    if (hasNmPersonMiddle) {
      personDB.setNmPersonMiddle(nmPersonMiddle);
    }
    if (hasTxtPersonOccupation) {
      personDB.setTxtPersonOccupation(txtPersonOccupation);
    }
  }

  public static void populateWithMap(PersonDB personDB,
                                     Map map) {
    if (map.containsKey("ADDR_PERSON_CITY")) {
      String value = (String) map.get("ADDR_PERSON_CITY");
      personDB.setAddrPersonCity(value);
    }
    if (map.containsKey("ADDR_PERSON_ST_LN_1")) {
      String value = (String) map.get("ADDR_PERSON_ST_LN_1");
      personDB.setAddrPersonStLn1(value);
    }
    if (map.containsKey("ADDR_PERSON_ZIP")) {
      String value = (String) map.get("ADDR_PERSON_ZIP");
      personDB.setAddrPersonZip(value);
    }
    if (map.containsKey("CD_PERSON_CHAR")) {
      String value = (String) map.get("CD_PERSON_CHAR");
      personDB.setCdPersonChar(value);
    }
    if (map.containsKey("CD_PERSON_COUNTY")) {
      String value = (String) map.get("CD_PERSON_COUNTY");
      personDB.setCdPersonCounty(value);
    }
    if (map.containsKey("CD_PERSON_DEATH")) {
      String value = (String) map.get("CD_PERSON_DEATH");
      personDB.setCdPersonDeath(value);
    }
    if (map.containsKey("CD_PERSON_ETHNIC_GROUP")) {
      String value = (String) map.get("CD_PERSON_ETHNIC_GROUP");
      personDB.setCdPersonEthnicGroup(value);
    }
    if (map.containsKey("CD_PERSON_LANGUAGE")) {
      String value = (String) map.get("CD_PERSON_LANGUAGE");
      personDB.setCdPersonLanguage(value);
    }
    if (map.containsKey("CD_PERSON_LIV_ARR")) {
      String value = (String) map.get("CD_PERSON_LIV_ARR");
      personDB.setCdPersonLivArr(value);
    }
    if (map.containsKey("CD_PERSON_MARITAL_STATUS")) {
      String value = (String) map.get("CD_PERSON_MARITAL_STATUS");
      personDB.setCdPersonMaritalStatus(value);
    }
    if (map.containsKey("CD_PERSON_RELIGION")) {
      String value = (String) map.get("CD_PERSON_RELIGION");
      personDB.setCdPersonReligion(value);
    }
    if (map.containsKey("CD_PERSON_SEX")) {
      String value = (String) map.get("CD_PERSON_SEX");
      personDB.setCdPersonSex(value);
    }
    if (map.containsKey("CD_PERSON_STATE")) {
      String value = (String) map.get("CD_PERSON_STATE");
      personDB.setCdPersonState(value);
    }
    if (map.containsKey("CD_PERSON_STATUS")) {
      String value = (String) map.get("CD_PERSON_STATUS");
      personDB.setCdPersonStatus(value);
    }
    if (map.containsKey("CD_PERSON_SUFFIX")) {
      String value = (String) map.get("CD_PERSON_SUFFIX");
      personDB.setCdPersonSuffix(value);
    }
    if (map.containsKey("CD_PERS_GUARD_CNSRV")) {
      String value = (String) map.get("CD_PERS_GUARD_CNSRV");
      personDB.setCdPersGuardCnsrv(value);
    }
    if (map.containsKey("DT_LAST_UPDATE")) {
      Date value = (Date) map.get("DT_LAST_UPDATE");
      personDB.setDtLastUpdate(value);
    }
    if (map.containsKey("DT_PERSON_BIRTH")) {
      Date value = (Date) map.get("DT_PERSON_BIRTH");
      personDB.setDtPersonBirth(value);
    }
    if (map.containsKey("DT_PERSON_DEATH")) {
      Date value = (Date) map.get("DT_PERSON_DEATH");
      personDB.setDtPersonDeath(value);
    }
    if (map.containsKey("ID_PERSON")) {
      Number value = (Number) map.get("ID_PERSON");
      personDB.setIdPerson(value);
    }
    if (map.containsKey("IND_PERSON_DOB_APPROX")) {
      String value = (String) map.get("IND_PERSON_DOB_APPROX");
      personDB.setIndPersonDobApprox(value);
    }
    if (map.containsKey("IND_PERS_CANCEL_HIST")) {
      String value = (String) map.get("IND_PERS_CANCEL_HIST");
      personDB.setIndPersCancelHist(value);
    }
    if (map.containsKey("NBR_PERSON_AGE")) {
      Number value = (Number) map.get("NBR_PERSON_AGE");
      personDB.setNbrPersonAge(value);
    }
    if (map.containsKey("NBR_PERSON_ID_NUMBER")) {
      String value = (String) map.get("NBR_PERSON_ID_NUMBER");
      personDB.setNbrPersonIdNumber(value);
    }
    if (map.containsKey("NBR_PERSON_PHONE")) {
      String value = (String) map.get("NBR_PERSON_PHONE");
      personDB.setNbrPersonPhone(value);
    }
    if (map.containsKey("NM_PERSON_FIRST")) {
      String value = (String) map.get("NM_PERSON_FIRST");
      personDB.setNmPersonFirst(value);
    }
    if (map.containsKey("NM_PERSON_FULL")) {
      String value = (String) map.get("NM_PERSON_FULL");
      personDB.setNmPersonFull(value);
    }
    if (map.containsKey("NM_PERSON_LAST")) {
      String value = (String) map.get("NM_PERSON_LAST");
      personDB.setNmPersonLast(value);
    }
    if (map.containsKey("NM_PERSON_MIDDLE")) {
      String value = (String) map.get("NM_PERSON_MIDDLE");
      personDB.setNmPersonMiddle(value);
    }
    if (map.containsKey("TXT_PERSON_OCCUPATION")) {
      String value = (String) map.get("TXT_PERSON_OCCUPATION");
      personDB.setTxtPersonOccupation(value);
    }
  }

  public String toString() {
    return
            "BEGIN bean: Person\n" +
            " addrPersonCity: " + addrPersonCity + "\n" +
            " addrPersonStLn1: " + addrPersonStLn1 + "\n" +
            " addrPersonZip: " + addrPersonZip + "\n" +
            " cdPersonChar: " + cdPersonChar + "\n" +
            " cdPersonCounty: " + cdPersonCounty + "\n" +
            " cdPersonDeath: " + cdPersonDeath + "\n" +
            " cdPersonEthnicGroup: " + cdPersonEthnicGroup + "\n" +
            " cdPersonLanguage: " + cdPersonLanguage + "\n" +
            " cdPersonLivArr: " + cdPersonLivArr + "\n" +
            " cdPersonMaritalStatus: " + cdPersonMaritalStatus + "\n" +
            " cdPersonReligion: " + cdPersonReligion + "\n" +
            " cdPersonSex: " + cdPersonSex + "\n" +
            " cdPersonState: " + cdPersonState + "\n" +
            " cdPersonStatus: " + cdPersonStatus + "\n" +
            " cdPersonSuffix: " + cdPersonSuffix + "\n" +
            " cdPersGuardCnsrv: " + cdPersGuardCnsrv + "\n" +
            " dtLastUpdate: " + dtLastUpdate + "\n" +
            " dtPersonBirth: " + dtPersonBirth + "\n" +
            " dtPersonDeath: " + dtPersonDeath + "\n" +
            " idPerson: " + idPerson + "\n" +
            " indPersonDobApprox: " + indPersonDobApprox + "\n" +
            " indPersCancelHist: " + indPersCancelHist + "\n" +
            " nbrPersonAge: " + nbrPersonAge + "\n" +
            " nbrPersonIdNumber: " + nbrPersonIdNumber + "\n" +
            " nbrPersonPhone: " + nbrPersonPhone + "\n" +
            " nmPersonFirst: " + nmPersonFirst + "\n" +
            " nmPersonFull: " + nmPersonFull + "\n" +
            " nmPersonLast: " + nmPersonLast + "\n" +
            " nmPersonMiddle: " + nmPersonMiddle + "\n" +
            " txtPersonOccupation: " + txtPersonOccupation + "\n" +
            "END bean: Person\n";
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
