package gov.georgia.dhr.dfcs.sacwis.dao.exchange;

import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.BasePaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

/**
 * This is a bean class used to marshall the search parameters back and forth
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  09/24/08    vdevarak    Initial Implementation.
 *  11/29/09    mxpatel     37253: Added code for CHILD_MIDDLE_NAME
 * </pre>
 * 
 * 
 */

public class ExchangeChildValueBean extends BasePaginationValueBean {
  private static final String TRACE_TAG = "ExchangeChildValueBean";
  
  //Child Locate Parameters
  private String nmFirst =null;
  
  private String nmLast=null;
  
  private String nmMiddle=null;
  
  private String cdCounty=null;
  
  private String cdRegion=null;
  
  private List<String> lstCountysFromRegion = null;
  
  //Sibling Locate Parameter
  
  private int idSiblingGrp=0;
  
  //Demographics parameters
  
  private int maleMinRangeInMonths=0;
  
  private int maleMaxRangeInMonths=0;

  private int femaleMinRangeInMonths=0;
  
  private int femaleMaxRangeInMonths=0;
  
  private int numChildren=0;
  
  private String indLegalRisk = null;
  
  //Special Needs Parameters
  
  private String indMentalRet= null;
  
  private String indVisHearImp= null;
  
  private String indPhyDisabled= null;
  
  private String indEmotDist= null;
  
  private String indOthMedDiag= null;
  
  private String cdMentRetSev= null;
  
  private String cdVisHearImpSev= null;
  
  private String cdPhyDisbldSev= null;
  
  private String cdEmotDistSev= null;
  
  private String cdOthDiagSev= null;
  
  private String indFamHxDrAlc= null;
  
  private String indFamHxMentIll= null;
  
  private String indFamHxMr= null;
  
  private String indChildHxSexAbuse= null;
  
  //Race parameters
  
  private List<String> lstRacePrefs = new ArrayList<String>();
  
  //Ethnicity parameters
  private List<String> lstEthnicityPrefs = new ArrayList<String>();
  
  //Non-Availability Codes Section
  
  private List<String> lstNonAvailCodes = new ArrayList<String>();
  
  private String nmFull = null;
  
  private int idChild = 0;
  
  private String nonAvailCode = null;
  
  private Date dtOut = null;
  
  private int idExchangeChildEvent = 0;
  
  private int nbrInGroup = 0;
  
  private int idStage = 0;
  
  private Date dtBirth = null;
  
  private String cdGender = null;
  
 public String getCdGender() {
    return cdGender;
  }

  public void setCdGender(String cdGender) {
    this.cdGender = cdGender;
  }

public Date getDtBirth() {
    return dtBirth;
  }

  public void setDtBirth(Date dtBirth) {
    this.dtBirth = dtBirth;
  }

public int getIdStage() {
    return idStage;
  }

  public void setIdStage(int idStage) {
    this.idStage = idStage;
  }

public int getNbrInGroup() {
    return nbrInGroup;
  }

  public void setNbrInGroup(int nbrInGroup) {
    this.nbrInGroup = nbrInGroup;
  }

public ExchangeChildValueBean() {
    
  }

  /**
   * Constructor that builds the bean from the ResultSet retrieved from the * database *
   * 
   * @throws DaoException *
   * @param results
   *                ResultSet object
   */
  public ExchangeChildValueBean(ResultSet results) throws DaoException {
    GrndsTrace.enterScope(TRACE_TAG + " constructor");
    
      try {
        if (results.getString(ExchangeChildSearchDAO.CHILD_NAME) != null) {
          this.setNmFull(StringHelper.getNonNullString(results.getString(ExchangeChildSearchDAO.CHILD_NAME)));
        }
        if (results.getString(ExchangeChildSearchDAO.PERSON_ID) != null) {
          this.setIdChild(results.getInt(ExchangeChildSearchDAO.PERSON_ID));
        }
        if (results.getString(ExchangeChildSearchDAO.SIBLING_GRP_ID) != null) {
          this.setIdSiblingGrp(results.getInt(ExchangeChildSearchDAO.SIBLING_GRP_ID));
        }
        if (results.getString(ExchangeChildSearchDAO.NON_AVAIL_CODE) != null) {
          this.setNonAvailCode(StringHelper.getNonNullString(results.getString(ExchangeChildSearchDAO.NON_AVAIL_CODE)));
        }
        if (results.getString(ExchangeChildSearchDAO.COUNTY) != null) {
          this.setCdCounty(StringHelper.getNonNullString(results.getString(ExchangeChildSearchDAO.COUNTY)));
        }
        if (results.getString(ExchangeChildSearchDAO.DT_OUT) != null) {
          this.setDtOut(results.getDate(ExchangeChildSearchDAO.DT_OUT));
        }
        if (results.getString(ExchangeChildSearchDAO.GROUP_SIZE) != null) {
          this.setNbrInGroup(results.getInt(ExchangeChildSearchDAO.GROUP_SIZE));
        }
        if(results.getString(ExchangeChildSearchDAO.EXCHANGE_CHILD_EVENT)!=null){
          this.setIdExchangeChildEvent(results.getInt(ExchangeChildSearchDAO.EXCHANGE_CHILD_EVENT));
        }
        if(results.getString(ExchangeChildSearchDAO.EXCHANGE_CHILD_STAGE)!=null){
          this.setIdStage(results.getInt(ExchangeChildSearchDAO.EXCHANGE_CHILD_STAGE));
        }
        if(results.getString(ExchangeChildSearchDAO.CHILD_FIRST_NAME)!=null){
          this.setNmFirst(results.getString(ExchangeChildSearchDAO.CHILD_FIRST_NAME));
        }
        if(results.getString(ExchangeChildSearchDAO.CHILD_MIDDLE_NAME)!=null){
            this.setNmMiddle(results.getString(ExchangeChildSearchDAO.CHILD_MIDDLE_NAME));
          }
        if(results.getString(ExchangeChildSearchDAO.CHILD_LAST_NAME)!=null){
          this.setNmLast(results.getString(ExchangeChildSearchDAO.CHILD_LAST_NAME));
        }
        if(results.getString(ExchangeChildSearchDAO.CHILD_DOB)!=null){
          this.setDtBirth(results.getDate(ExchangeChildSearchDAO.CHILD_DOB));
        }
        if(results.getString(ExchangeChildSearchDAO.CHILD_GENDER)!=null){
          this.setCdGender(results.getString(ExchangeChildSearchDAO.CHILD_GENDER));
        }
      }
      catch (SQLException e) {
        GrndsTrace.msg(TRACE_TAG, 7, " Exception while setting results from DAO to " + TRACE_TAG + ".");
        GrndsTrace.msg(TRACE_TAG, 7, "SQLException message 1 " + e.getMessage());
        GrndsTrace.msg(TRACE_TAG, 7, "SQLException code " + e.getErrorCode());
        throw new DaoException("Exception translating ResultSet to " + TRACE_TAG, e, 7);
      }
      GrndsTrace.exitScope();
  }


  public String getNmFirst() {
    return nmFirst;
  }

  public void setNmFirst(String nmFirst) {
    this.nmFirst = nmFirst;
  }

  public String getNmLast() {
    return nmLast;
  }

  public void setNmLast(String nmLast) {
    this.nmLast = nmLast;
  }

  public String getNmMiddle() {
    return nmMiddle;
  }

  public void setNmMiddle(String nmMiddle) {
    this.nmMiddle = nmMiddle;
  }

  public String getCdCounty() {
    return cdCounty;
  }

  public void setCdCounty(String cdCounty) {
    this.cdCounty = cdCounty;
  }

  public String getCdRegion() {
    return cdRegion;
  }

  public void setCdRegion(String cdRegion) {
    this.cdRegion = cdRegion;
  }

  public int getIdSiblingGrp() {
    return idSiblingGrp;
  }

  public void setIdSiblingGrp(int idSiblingGrp) {
    this.idSiblingGrp = idSiblingGrp;
  }

  public int getMaleMinRangeInMonths() {
    return maleMinRangeInMonths;
  }

  public void setMaleMinRangeInMonths(int maleMinRangeInMonths) {
    this.maleMinRangeInMonths = maleMinRangeInMonths;
  }

  public int getMaleMaxRangeInMonths() {
    return maleMaxRangeInMonths;
  }

  public void setMaleMaxRangeInMonths(int maleMaxRangeInMonths) {
    this.maleMaxRangeInMonths = maleMaxRangeInMonths;
  }

  public int getFemaleMinRangeInMonths() {
    return femaleMinRangeInMonths;
  }

  public void setFemaleMinRangeInMonths(int femaleMinRangeInMonths) {
    this.femaleMinRangeInMonths = femaleMinRangeInMonths;
  }

  public int getFemaleMaxRangeInMonths() {
    return femaleMaxRangeInMonths;
  }

  public void setFemaleMaxRangeInMonths(int femaleMaxRangeInMonths) {
    this.femaleMaxRangeInMonths = femaleMaxRangeInMonths;
  }

  public int getNumChildren() {
    return numChildren;
  }

  public void setNumChildren(int numChildren) {
    this.numChildren = numChildren;
  }

  public String getIndLegalRisk() {
    return indLegalRisk;
  }

  public void setIndLegalRisk(String indLegalRisk) {
    this.indLegalRisk = indLegalRisk;
  }

  public String getIndMentalRet() {
    return indMentalRet;
  }

  public void setIndMentalRet(String indMentalRet) {
    this.indMentalRet = indMentalRet;
  }

  public String getIndVisHearImp() {
    return indVisHearImp;
  }

  public void setIndVisHearImp(String indVisHearImp) {
    this.indVisHearImp = indVisHearImp;
  }

  public String getIndPhyDisabled() {
    return indPhyDisabled;
  }

  public void setIndPhyDisabled(String indPhyDisabled) {
    this.indPhyDisabled = indPhyDisabled;
  }

  public String getIndEmotDist() {
    return indEmotDist;
  }

  public void setIndEmotDist(String indEmotDist) {
    this.indEmotDist = indEmotDist;
  }

  public String getIndOthMedDiag() {
    return indOthMedDiag;
  }

  public void setIndOthMedDiag(String indOthMedDiag) {
    this.indOthMedDiag = indOthMedDiag;
  }

  public String getCdMentRetSev() {
    return cdMentRetSev;
  }

  public void setCdMentRetSev(String cdMentRetSev) {
    this.cdMentRetSev = cdMentRetSev;
  }

  public String getCdVisHearImpSev() {
    return cdVisHearImpSev;
  }

  public void setCdVisHearImpSev(String cdVisHearImpSev) {
    this.cdVisHearImpSev = cdVisHearImpSev;
  }

  public String getCdPhyDisbldSev() {
    return cdPhyDisbldSev;
  }

  public void setCdPhyDisbldSev(String cdPhyDisbldSev) {
    this.cdPhyDisbldSev = cdPhyDisbldSev;
  }

  public String getCdEmotDistSev() {
    return cdEmotDistSev;
  }

  public void setCdEmotDistSev(String cdEmotDistSev) {
    this.cdEmotDistSev = cdEmotDistSev;
  }

  public String getCdOthDiagSev() {
    return cdOthDiagSev;
  }

  public void setCdOthDiagSev(String cdOthDiagSev) {
    this.cdOthDiagSev = cdOthDiagSev;
  }

  public String getIndFamHxDrAlc() {
    return indFamHxDrAlc;
  }

  public void setIndFamHxDrAlc(String indFamHxDrAlc) {
    this.indFamHxDrAlc = indFamHxDrAlc;
  }

  public String getIndFamHxMentIll() {
    return indFamHxMentIll;
  }

  public void setIndFamHxMentIll(String indFamHxMentIll) {
    this.indFamHxMentIll = indFamHxMentIll;
  }

  public String getIndFamHxMr() {
    return indFamHxMr;
  }

  public void setIndFamHxMr(String indFamHxMr) {
    this.indFamHxMr = indFamHxMr;
  }

  public String getIndChildHxSexAbuse() {
    return indChildHxSexAbuse;
  }

  public void setIndChildHxSexAbuse(String indChildHxSexAbuse) {
    this.indChildHxSexAbuse = indChildHxSexAbuse;
  }

  public List<String> getLstRacePrefs() {
    return lstRacePrefs;
  }

  public void setLstRacePrefs(List<String> lstRacePrefs) {
    this.lstRacePrefs = lstRacePrefs;
  }

  public List<String> getLstEthnicityPrefs() {
    return lstEthnicityPrefs;
  }

  public void setLstEthnicityPrefs(List<String> lstEthnicityPrefs) {
    this.lstEthnicityPrefs = lstEthnicityPrefs;
  }

  public List<String> getLstNonAvailCodes() {
    return lstNonAvailCodes;
  }

  public void setLstNonAvailCodes(List<String> lstNonAvailCodes) {
    this.lstNonAvailCodes = lstNonAvailCodes;
  }

  public static String getTRACE_TAG() {
    return TRACE_TAG;
  }

  public String getNmFull() {
    return nmFull;
  }

  public void setNmFull(String nmFull) {
    this.nmFull = nmFull;
  }

  public int getIdChild() {
    return idChild;
  }

  public void setIdChild(int idChild) {
    this.idChild = idChild;
  }

  public String getNonAvailCode() {
    return nonAvailCode;
  }

  public void setNonAvailCode(String nonAvailCode) {
    this.nonAvailCode = nonAvailCode;
  }

  public Date getDtOut() {
    return dtOut;
  }

  public void setDtOut(Date dtOut) {
    this.dtOut = dtOut;
  }

  public int getIdExchangeChildEvent() {
    return idExchangeChildEvent;
  }

  public void setIdExchangeChildEvent(int idExchangeChildEvent) {
    this.idExchangeChildEvent = idExchangeChildEvent;
  }

  public List<String> getLstCountysFromRegion() {
    return lstCountysFromRegion;
  }

  public void setLstCountysFromRegion(List<String> lstCountysFromRegion) {
    this.lstCountysFromRegion = lstCountysFromRegion;
  }
}