package gov.georgia.dhr.dfcs.sacwis.dao.exchange;

import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.BasePaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

/**
 * This class is the Bean class for Exchange Home Search. The ExchangeHomeValueBean stores search parameters and
 * results.
 * 
 * <pre>
 *  Change History:
 *  Date        User           Description
 *  ----------  --------       --------------------------------------------------
 *  09/21/08    mchillman      Initial Coding.
 *  03/26/09    hjbaptiste     STGAP00012915 - this.setAgency() was never called. Instead, this.setCdFAHomeStatus
 *                             was being overwritten with the Agency name
 * </pre>
 * 
 * 
 */

public class ExchangeHomeValueBean extends BasePaginationValueBean {
  private static final String TRACE_TAG = "ExchangeHomeValueBean";

  private String homeName = null;

  private Integer idResource = null;

  private String cdStatus = null;

  private String cdCategory = null;

  private String cdCounty = null;

  private String cdRegion = null;

  private String agency = null;
  
  private String agencyCode = null;

  private Date dtInquired = null;

  private Integer numOfChildren = null;

  private List<String> lstCdNonAvaCodes = null;

  private String indMentalRetardation = null;

  private String cdLevelMentalRetardation = null;

  private String indVisualHearingImpairments = null;

  private String cdLevelVisualHearingImpairments = null;

  private String indPhysicallyDisabled = null;

  private String cdLevelPhysicallyDisabled = null;

  private String indEmotionallyDisturbed = null;

  private String cdLevelEmotionallyDisturbed = null;

  private String indOtherMedicalDiagnoses = null;

  private String cdlevelOtherMedicalDiagnoses = null;

  private String indFamilyHxofDrugsAlcohol = null;

  private String indFamilyHxofMentalIllness = null;

  private String indFamilyHxofMR = null;

  private String indChilsHxofSexualAbuse = null;

  private List<String> childRacePref = new ArrayList<String>();

  private List<String> childEthnicityPerf = new ArrayList<String>();
  
  private String cdGender = null;

  private Integer minRangeInMonths = null;

  private Integer maxRangeInMonths = null;

  private String cdNonAvaCode = null;

  private String cdFAHomeStatus = null;

  private Integer idExchangeHome = null;
  
  private Date dateOut = null;
  
  private Integer idHomeStage = null;
  
  
  public ExchangeHomeValueBean() {
    
  }

  /**
   * Constructor that builds the bean from the ResultSet retrieved from the * database *
   * 
   * @throws DaoException *
   * @param results
   *                ResultSet object
   */
  public ExchangeHomeValueBean(ResultSet results) throws DaoException {
    GrndsTrace.enterScope(TRACE_TAG + " constructor");
    
      try {
        if (results.getString(ExchangeHomeSearchDao.RESOURCE_NAME) != null) {
          this.setHomeName(StringHelper.getNonNullString(results.getString(ExchangeHomeSearchDao.RESOURCE_NAME)));
        }
        
        if (results.getString(ExchangeHomeSearchDao.CATEGORY) != null) {
          this.setCdCategory(StringHelper.getNonNullString(results.getString(ExchangeHomeSearchDao.CATEGORY)));
        }
        
        if (results.getString(ExchangeHomeSearchDao.AVAILABILITY_CODE) != null) {
          this.setCdNonAvaCode(StringHelper.getNonNullString(results.getString(ExchangeHomeSearchDao.AVAILABILITY_CODE)));
        }
        
        if (results.getString(ExchangeHomeSearchDao.COUNTY) != null) {
          this.setCdCounty(StringHelper.getNonNullString( results.getString(ExchangeHomeSearchDao.COUNTY)));
        }
        
        if (results.getString(ExchangeHomeSearchDao.FA_HOME_STATUS) != null) {
          this.setCdFAHomeStatus(StringHelper.getNonNullString(results.getString(ExchangeHomeSearchDao.FA_HOME_STATUS)));
        }
        
        this.setIdExchangeHome(results.getInt(ExchangeHomeSearchDao.EXCHANGE_HOME_EVENT));
        
        this.setIdResource(results.getInt(ExchangeHomeSearchDao.RESOURCE_ID));
        
        if (results.getDate(ExchangeHomeSearchDao.DATE_OUT) != null) {
          this.setDateOut(results.getDate(ExchangeHomeSearchDao.DATE_OUT));
        }
        
        this.setIdHomeStage(results.getInt(ExchangeHomeSearchDao.HOME_STAGE));
        
        if (results.getString(ExchangeHomeSearchDao.AGENCY) != null) {
          this.setAgency(StringHelper.getNonNullString(results.getString(ExchangeHomeSearchDao.AGENCY)));
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

  public String getHomeName() {
    return homeName;
  }

  public void setHomeName(String homeName) {
    this.homeName = homeName;
  }

  public Integer getIdResource() {
    return idResource;
  }

  public void setIdResource(Integer idResource) {
    this.idResource = idResource;
  }

  public String getCdStatus() {
    return cdStatus;
  }

  public void setCdStatus(String cdStatus) {
    this.cdStatus = cdStatus;
  }

  public String getCdCategory() {
    return cdCategory;
  }

  public void setCdCategory(String cdCategory) {
    this.cdCategory = cdCategory;
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

  public String getAgency() {
    return agency;
  }

  public void setAgency(String agency) {
    this.agency = agency;
  }

  public Date getDtInquired() {
    return dtInquired;
  }

  public void setDtInquired(Date dtInquired) {
    this.dtInquired = dtInquired;
  }

  public Integer getNumOfChildren() {
    return numOfChildren;
  }

  public void setNumOfChildren(Integer numOfChildren) {
    this.numOfChildren = numOfChildren;
  }

  public List<String> getLstCdNonAvaCodes() {
    return lstCdNonAvaCodes;
  }

  public void setLstCdNonAvaCodes(List<String> lstCdNonAvaCodes) {
    this.lstCdNonAvaCodes = lstCdNonAvaCodes;
  }

  public String getIndMentalRetardation() {
    return indMentalRetardation;
  }

  public void setIndMentalRetardation(String indMentalRetardation) {
    this.indMentalRetardation = indMentalRetardation;
  }

  public String getCdLevelMentalRetardation() {
    return cdLevelMentalRetardation;
  }

  public void setCdLevelMentalRetardation(String cdLevelMentalRetardation) {
    this.cdLevelMentalRetardation = cdLevelMentalRetardation;
  }

  public String getIndVisualHearingImpairments() {
    return indVisualHearingImpairments;
  }

  public void setIndVisualHearingImpairments(String indVisualHearingImpairments) {
    this.indVisualHearingImpairments = indVisualHearingImpairments;
  }

  public String getCdLevelVisualHearingImpairments() {
    return cdLevelVisualHearingImpairments;
  }

  public void setCdLevelVisualHearingImpairments(String cdLevelVisualHearingImpairments) {
    this.cdLevelVisualHearingImpairments = cdLevelVisualHearingImpairments;
  }

  public String getIndPhysicallyDisabled() {
    return indPhysicallyDisabled;
  }

  public void setIndPhysicallyDisabled(String indPhysicallyDisabled) {
    this.indPhysicallyDisabled = indPhysicallyDisabled;
  }

  public String getCdLevelPhysicallyDisabled() {
    return cdLevelPhysicallyDisabled;
  }

  public void setCdLevelPhysicallyDisabled(String cdLevelPhysicallyDisabled) {
    this.cdLevelPhysicallyDisabled = cdLevelPhysicallyDisabled;
  }

  public String getIndEmotionallyDisturbed() {
    return indEmotionallyDisturbed;
  }

  public void setIndEmotionallyDisturbed(String indEmotionallyDisturbed) {
    this.indEmotionallyDisturbed = indEmotionallyDisturbed;
  }

  public String getCdLevelEmotionallyDisturbed() {
    return cdLevelEmotionallyDisturbed;
  }

  public void setCdLevelEmotionallyDisturbed(String cdLevelEmotionallyDisturbed) {
    this.cdLevelEmotionallyDisturbed = cdLevelEmotionallyDisturbed;
  }

  public String getIndOtherMedicalDiagnoses() {
    return indOtherMedicalDiagnoses;
  }

  public void setIndOtherMedicalDiagnoses(String indOtherMedicalDiagnoses) {
    this.indOtherMedicalDiagnoses = indOtherMedicalDiagnoses;
  }

  public String getCdlevelOtherMedicalDiagnoses() {
    return cdlevelOtherMedicalDiagnoses;
  }

  public void setCdlevelOtherMedicalDiagnoses(String cdlevelOtherMedicalDiagnoses) {
    this.cdlevelOtherMedicalDiagnoses = cdlevelOtherMedicalDiagnoses;
  }

  public String getIndFamilyHxofDrugsAlcohol() {
    return indFamilyHxofDrugsAlcohol;
  }

  public void setIndFamilyHxofDrugsAlcohol(String indFamilyHxofDrugsAlcohol) {
    this.indFamilyHxofDrugsAlcohol = indFamilyHxofDrugsAlcohol;
  }

  public String getIndFamilyHxofMentalIllness() {
    return indFamilyHxofMentalIllness;
  }

  public void setIndFamilyHxofMentalIllness(String indFamilyHxofMentalIllness) {
    this.indFamilyHxofMentalIllness = indFamilyHxofMentalIllness;
  }

  public String getIndFamilyHxofMR() {
    return indFamilyHxofMR;
  }

  public void setIndFamilyHxofMR(String indFamilyHxofMR) {
    this.indFamilyHxofMR = indFamilyHxofMR;
  }

  public String getIndChilsHxofSexualAbuse() {
    return indChilsHxofSexualAbuse;
  }

  public void setIndChilsHxofSexualAbuse(String indChilsHxofSexualAbuse) {
    this.indChilsHxofSexualAbuse = indChilsHxofSexualAbuse;
  }

  public List<String> getChildRacePref() {
    return childRacePref;
  }

  public void setChildRacePref(List<String> childRacePref) {
    this.childRacePref = childRacePref;
  }

  public List<String> getChildEthnicityPerf() {
    return childEthnicityPerf;
  }

  public void setChildEthnicityPerf(List<String> childEthnicityPerf) {
    this.childEthnicityPerf = childEthnicityPerf;
  }

  public String getCdNonAvaCode() {
    return cdNonAvaCode;
  }

  public void setCdNonAvaCode(String cdNonAvaCode) {
    this.cdNonAvaCode = cdNonAvaCode;
  }

  public String getCdFAHomeStatus() {
    return cdFAHomeStatus;
  }

  public void setCdFAHomeStatus(String cdFAHomeStatus) {
    this.cdFAHomeStatus = cdFAHomeStatus;
  }

  public Integer getIdExchangeHome() {
    return idExchangeHome;
  }

  public void setIdExchangeHome(Integer idExchangeHome) {
    this.idExchangeHome = idExchangeHome;
  }

  public String getCdGender() {
    return cdGender;
  }

  public void setCdGender(String childrenGender) {
    this.cdGender = childrenGender;
  }

  public Integer getMinRangeInMonths() {
    return minRangeInMonths;
  }

  public void setMinRangeInMonths(Integer minRangeInMonths) {
    this.minRangeInMonths = minRangeInMonths;
  }

  public Integer getMaxRangeInMonths() {
    return maxRangeInMonths;
  }

  public void setMaxRangeInMonths(Integer maxRangeInMonths) {
    this.maxRangeInMonths = maxRangeInMonths;
  }

  public String getAgencyCode() {
    return agencyCode;
  }

  public void setAgencyCode(String agencyCode) {
    this.agencyCode = agencyCode;
  }

  public Date getDateOut() {
    return dateOut;
  }

  public void setDateOut(Date dateOut) {
    this.dateOut = dateOut;
  }

  public Integer getIdHomeStage() {
    return idHomeStage;
  }

  public void setIdHomeStage(Integer idHomeStage) {
    this.idHomeStage = idHomeStage;
  }

}
