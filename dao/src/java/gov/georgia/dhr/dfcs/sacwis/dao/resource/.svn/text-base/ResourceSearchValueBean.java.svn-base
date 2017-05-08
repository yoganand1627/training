package gov.georgia.dhr.dfcs.sacwis.dao.resource;

// -- java classes --

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.BasePaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

/**
 * This class is the Bean class for Resource Search. The ResourceSearchBean stores search parameters and results.
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  05/20/04    reedlg    SIR 18791 - add COUNTY to Search Resource Results List page.
 *  04/18/05    CORLEYAN  SIR 23538 - Add Donated Service Indicator for Service Authorization pullback.
 *  05/31/05    CORLEYAN  SIR 23622 - Add Donated Service Indicator to re-set of bean so that it will be available
 *                        on pagination.
 *  06/21/05    piazzat   Changes to support MPS
 *  04/05/06    aodutayo  Updated to reflect the requirements for SHINES - proximity search, etc.
 * </pre>
 * 
 * @author Sanjay Rana,
 */
public class ResourceSearchValueBean extends BasePaginationValueBean {
  
  // instance variables

  /** Type of Resource. */
  private String resourceType;

  /** Name of the Facility - Also the Resource Name. */
  private String resourceName;

  /** Identification Type - Resource ID, MHMR Code, Licensing ID or Contract ID. */
  private String identificationType;

  /** Identification Number. */
  private String identificationNum;

  /** Category. */
  private String category;

  /** Service. */
  private String service;

  /** Program. */
  private String program;

  /** Location/Area. */
  private String locationArea;

  /** Region of Resource. */
  private String rsrcRegion;

  /** Name of County. */
  private String nameCounty;

  /** Street Address. */
  private String streetAddress;

  /** Name of City. */
  private String nameCity;

  /** Zip Code Prefix - First 5 digits. */
  private String zipCode;

  /** Zip Code Suffix - optional 4 digits. */
  private String zipCodeSuffix;

  /** State Name. */
  private String stateName;

  /** Status of Resource - Active or Inactive. */
  private String resourceStatus;

  /** Contract Status of Resource. */
  private String rsrcContracted;

  /** Type of Facility. */
  private String facilityType;

  /** Level of Care Resource Provides. */
  private String levelCare;

  /** Genders the facility can serve. */
  private String genderServed;

  /** Ages the facility can serve. */
  private String ageServed;

  /** Characteristics of Client. */
  private String clientCharacteristics;

  /** Phone Number of the resource. */
  private String phoneNumber;

  /** Phone Extension of the resource. */
  private String phoneExtension;

  /** Effective Date of contract. */
  private String effectiveDate;

  /** Donated Service Indicator */
  private String donatedService;

  /** Proximity Range (mile) */
  private String proximityRange;

  /** Avalible After Hours */
  private String avalibleAfterHours;

  // Report ID
  private int ulIdStage;

  // Dispstn
  private String cdDispstn;
  
  //Latitude
  private Double latX;
  
  //Longitude
  private Double longY;
  
  //Distance
  private Double distance;
  
  // isValid
  private boolean isValid;
  
  // cdFamviol_03
  private String cdFamviol_03 ;
  
  // cdFamviol_04
  private String cdFamviol_04;
  
  // cdFamviol_05
  private String cdFamviol_05;
  
  // cdCnclsnRiskFind
  private String cdCnclsnRiskFind;
  
  // cbxBIndAvalibleAfterHours
  private String cbxBIndAvalibleAfterHours;
  
  // Event ID
  private int ulIdEvent;
  
  // cdEventStatus
  private String cdEventStatus;
  

  // Tracing
  private static final String TRACE_TAG = "ResourceSearchBean";
  
  /** Null Constructor */
  public ResourceSearchValueBean() {
    resourceType = "";
    resourceName = "";
    identificationType = "";
    identificationNum = "";
    category = "";
    service = "";
    program = "";
    locationArea = "";
    rsrcRegion = "";
    nameCounty = "";
    streetAddress = "";
    nameCity = "";
    zipCode = "";
    zipCodeSuffix = "";
    stateName = "";
    resourceStatus = "";
    rsrcContracted = "";
    facilityType = "";
    levelCare = "";
    genderServed = "";
    ageServed = "";
    clientCharacteristics = "";
    phoneNumber = "";
    phoneExtension = "";
    effectiveDate = "";
    donatedService = "";
    proximityRange = "";
    avalibleAfterHours = "";
    latX = 0.0;
    longY = 0.0;
    distance = 0.0;
    isValid = false;
  }

  /** Constructor that builds the bean from a ResultSet object */
  public ResourceSearchValueBean(ResultSet results) throws ResourceSearchDaoException {
    try {
      GrndsTrace.enterScope(TRACE_TAG + " constructor");
      ResultSetMetaData rsmd = results.getMetaData();
      int id = results.getInt(ResourceSearchDAO.ID_COLUMN);
      this.setResourceName(results.getString(ResourceSearchDAO.NAME_COLUMN));
      this.setIdentificationNum(((BigDecimal) results.getBigDecimal(ResourceSearchDAO.ID_COLUMN)).toString());
      this.setResourceStatus(results.getString(ResourceSearchDAO.RESOURCE_STATUS_COLUMN));
      this.setResourceType(results.getString(ResourceSearchDAO.RESOURCE_TYPE_COLUMN));
      this.setFacilityType(results.getString(ResourceSearchDAO.FACILITY_TYPE_COLUMN));
      this.setStreetAddress(results.getString(ResourceSearchDAO.STREET_ADDRESS_COLUMN));
      this.setNameCity(FormattingHelper.initCaps(results.getString(ResourceSearchDAO.CITY_COLUMN)));
      /* SIR 18791 - add COUNTY to Search Resource Results List page */
      this.setNameCounty(results.getString(ResourceSearchDAO.COUNTY_COLUMN));
      this.setPhoneNumber(results.getString(ResourceSearchDAO.PHONE_COLUMN));
      this.setPhoneExtension(results.getString(ResourceSearchDAO.PHONE_EXTENSION_COLUMN));
      if (results.getString(ResourceSearchDAO.CONTRACT_STATUS_COLUMN) != null) {
        this.setRsrcContracted(results.getString(ResourceSearchDAO.CONTRACT_STATUS_COLUMN));
      }
      this.setUlIdStage(results.getInt(ResourceSearchDAO.ID_STAGE));
      this.setCdDispstn(results.getString(ResourceSearchDAO.CD_CPS_INVST_DTL_OVRLL_DISPTN));
      this.setCdFamviol03(results.getString(ResourceSearchDAO.CD_FAMVIOL_03));
      this.setCdFamviol04(results.getString(ResourceSearchDAO.CD_FAMVIOL_04));
      this.setCdFamviol05(results.getString(ResourceSearchDAO.CD_FAMVIOL_05));
      this.setCdCnclsnRiskFind(results.getString(ResourceSearchDAO.CD_CNCLSN_RISK_FND));
      this.setUlIdEvent(results.getInt(ResourceSearchDAO.ID_EVENT));
      this.setCdEventStatus(results.getString(ResourceSearchDAO.CD_EVENT_STATUS));
      this.distance = 0.0;

    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception while setting results from DAO to ResourceSearchBean.");
      throw new ResourceSearchDaoException("Exception translating ResultSet to ResourceBean", e,
                                           BasePrsException.WARNING_PRIORITY);
    }
    GrndsTrace.exitScope();
  }

  /**
   * Retrieves the Resource Type that was previously set into this Java Bean
   *  @ return Resource Type
   */
  public String getResourceType() {
    return resourceType;
  }

  /**
   * Sets the Resource Type that was previously set into this Java Bean
   *  @ param Resource Type
   */
  public void setResourceType(String x) {
    resourceType = x;
    return;
  }

  /**
   * Retrieves the Resource Name that was previously set into this Java Bean
   *  @ return Resource Name
   */
  public String getResourceName() {
    return resourceName;
  }

  /**
   * Sets the Resource Name into this Java Bean
   *  @ param Resource Name
   */
  public void setResourceName(String x) {
    resourceName = x;
    return;
  }

  /**
   * Retrieves the IdentificationType that was previously set into this Java Bean
   *  @ return IdentificationType
   */
  public String getIdentificationType() {
    return identificationType;
  }

  /**
   * Sets the IdentificationType that was previously set into this Java Bean
   *  @ param IdentificationType
   */
  public void setIdentificationType(String x) {
    identificationType = x;
    return;
  }

  /**
   * Retrieves the Identification Number that was previously set into this Java Bean
   *  @ return Identification Number
   */
  public String getIdentificationNum() {
    return identificationNum;
  }

  /**
   * Sets the Identification Number that was previously set into this Java Bean
   *  @ param Identification Number
   */
  public void setIdentificationNum(String x) {
    identificationNum = x;
    return;
  }

  /**
   * Retrieves the Category that was previously set into this Java Bean
   *  @ return Category
   */
  public String getCategory() {
    return category;
  }

  /**
   * Sets the Category into this Java Bean
   *  @ param Category
   */
  public void setCategory(String x) {
    category = x;
    return;
  }

  /**
   * Retrieves the Service that was previously set into this Java Bean
   *  @ return Service
   */
  public String getService() {
    return service;
  }

  /**
   * Sets the Service into this Java Bean
   *  @ param Service
   */
  public void setService(String x) {
    service = x;
    return;
  }

  /**
   * Retrieves the Program that was previously set into this Java Bean
   *  @ return Program
   */
  public String getProgram() {
    return program;
  }

  /**
   * Sets the Program into this Java Bean
   *  @ param Program
   */
  public void setProgram(String x) {
    program = x;
    return;
  }

  /**
   * Retrieves the LocationArea that was previously set into this Java Bean
   *  @ return LocationArea
   */
  public String getLocationArea() {
    return locationArea;
  }

  /**
   * Sets the LocationArea into this Java Bean
   *  @ param LocationArea
   */
  public void setLocationArea(String x) {
    locationArea = x;
    return;
  }

  /**
   * Retrieves the Resource Region that was previously set into this Java Bean
   *  @ return Resource Region
   */
  public String getRsrcRegion() {
    return rsrcRegion;
  }

  /**
   * Set the Resource Region that was previously set into this Java Bean
   *  @ param Resource Region
   */
  public void setRsrcRegion(String x) {
    rsrcRegion = x;
    return;
  }

  /**
   * Retrieves the County Name that was previously set into this Java Bean
   *  @ return County Name
   */
  public String getNameCounty() {
    return nameCounty;
  }

  /**
   * Set the County Name that was previously set into this Java Bean
   *  @ param County Name
   */
  public void setNameCounty(String x) {
    nameCounty = x;
    return;
  }

  /**
   * Retrieves the Street Address that was previously set into this Java Bean
   *  @ return Street Address
   */
  public String getStreetAddress() {
    return streetAddress;
  }

  /**
   * Set the Street Address into this Java Bean
   *  @ param Street Address
   */
  public void setStreetAddress(String x) {
    streetAddress = x;
    return;
  }

  /**
   * Retrieves the City Name that was previously set into this Java Bean
   *  @ return City Name
   */
  public String getNameCity() {
    return nameCity;
  }

  /**
   * Set the City Name into this Java Bean
   *  @ param City Name
   */
  public void setNameCity(String x) {
    nameCity = x;
    return;
  }

  /**
   * Retrieves the Zip Code that was previously set into this Java Bean
   *  @ return Zip Code
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * Set the Zip Code that was previously set into this Java Bean
   *  @ param Zip Code
   */
  public void setZipCode(String x) {
    zipCode = x;
    return;
  }

  /**
   * Retrieves the Zip Code Suffix that was previously set into this Java Bean
   *  @ return Zip Code Suffix
   */
  public String getZipCodeSuffix() {
    return zipCodeSuffix;
  }

  /**
   * Set the Zip Code Suffix that was previously set into this Java Bean
   *  @ param Zip Code Suffix
   */
  public void setZipCodeSuffix(String x) {
    zipCodeSuffix = x;
    return;
  }

  /**
   * Retrieves the State that was previously set into this Java Bean
   *  @ return State
   */
  public String getStateName() {
    return stateName;
  }

  /**
   * Set the State that was previously set into this Java Bean
   *  @ param State
   */
  public void setStateName(String x) {
    stateName = x;
    return;
  }

  /**
   * Retrieves the Resource Inactive that was previously set into this Java Bean
   *  @ return Resource Status
   */
  public String getResourceStatus() {
    return resourceStatus;
  }

  /**
   * Sets the Resource Inactive into this Java Bean
   *  @ param resourceStatus (resource status)
   */
  public void setResourceStatus(String x) {
    resourceStatus = x;
    return;
  }

  /**
   * Retrieves the Contract Status that was previously set into this Java Bean
   *  @ return Contract Status
   */
  public String getRsrcContracted() {
    return rsrcContracted;
  }

  /**
   * Sets the Contract Status that was previously set into this Java Bean
   *  @ param Contract Status
   */
  public void setRsrcContracted(String x) {
    rsrcContracted = x;
    return;
  }

  /**
   * Retrieves the Facility Type that was previously set into this Java Bean
   *  @ return Facility Type
   */
  public String getFacilityType() {
    return facilityType;
  }

  /**
   * Set the Facility Type that was previously set into this Java Bean
   *  @ param Facility Type
   */
  public void setFacilityType(String x) {
    facilityType = x;
    return;
  }

  /**
   * Retrieves the Level of Care that was previously set into this Java Bean
   *  @ return Level of Care
   */
  public String getLevelCare() {
    return levelCare;
  }

  /**
   * Set the Level of Care that was previously set into this Java Bean
   *  @ param Level of Care
   */
  public void setLevelCare(String x) {
    levelCare = x;
    return;
  }

  /**
   * Retrieves the Age Served that was previously set into this Java Bean
   *  @ return Age Served
   */
  public String getAgeServed() {
    return ageServed;
  }

  /**
   * Set the Age Served that was previously set into this Java Bean
   *  @ param Age Served
   */
  public void setAgeServed(String x) {
    ageServed = x;
    return;
  }

  /**
   * Retrieves the Gender Served that was previously set into this Java Bean
   *  @ return Gender Served
   */
  public String getGenderServed() {
    return genderServed;
  }

  /**
   * Set the Gender Served that was previously set into this Java Bean
   *  @ param Gender Served
   */
  public void setGenderServed(String x) {
    genderServed = x;
    return;
  }

  /**
   * Retrieves the Client Characteristics that was previously set into this Java Bean
   *  @ return Client Characteristics
   */
  public String getClientCharacteristics() {
    return clientCharacteristics;
  }

  /**
   * Set the Client Characteristics that was previously set into this Java Bean
   *  @ param Client Characteristics
   */
  public void setClientCharacteristics(String x) {
    clientCharacteristics = x;
    return;
  }

  /**
   * Retrieves the Phone Number that was previously set into this Java Bean
   *  @ return Phone Number
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Set the Phone Number that was previously set into this Java Bean
   *  @ param Phone Number
   */
  public void setPhoneNumber(String x) {
    phoneNumber = x;
    return;
  }

  /**
   * Retrieves the Phone Extension that was previously set into this Java Bean
   *  @ return Phone Extension
   */
  public String getPhoneExtension() {
    return phoneExtension;
  }

  /**
   * Set the Phone Extension into this Java Bean
   *  @ param Phone Extension
   */
  public void setPhoneExtension(String x) {
    phoneExtension = x;
    return;
  }

  /**
   * Retrieves the Effective Date that was previously set into this Java Bean
   *  @ return Effective Date
   */
  public String getEffectiveDate() {
    return effectiveDate;
  }

  /**
   * Set the Effective Date into this Java Bean
   *  @ param Effective Date
   */
  public void setEffectiveDate(String x) {
    effectiveDate = x;
    return;
  }

  /**
   * Retrieves the Effective Date that was previously set into this Java Bean
   *  @ return Effective Date
   */
  public String getDonatedService() {
    return donatedService;
  }

  /**
   * Set the Effective Date into this Java Bean
   *  @ param Effective Date
   */
  public void setDonatedService(String x) {
    donatedService = x;
    return;
  }

  /**
   * Retrieves the Proximity Range that was previously set into this Java Bean
   *  @ return Effective Date
   */
  public String getProximityRange() {
    return proximityRange;
  }

  /**
   * Set the Proximity Range into this Java Bean
   *  @ param Proximity Range
   */
  public void setProximityRange(String x) {
    proximityRange = x;
    return;
  }

  /**
   * Retrieves the AvalibleAfterHours that was previously set into this Java Bean
   *  @ return Effective Date
   */
  public String getAvalibleAfterHours() {
    return avalibleAfterHours;
  }

  /**
   * Set the Avalible After Hours into this Java Bean
   *  @ param Proximity Range
   */
  public void setAvalibleAfterHours(String x) {
    avalibleAfterHours = x;
    return;
  }

  /**
   * Gets the disposition.
   * @return
   */
  public String getCdDispstn() {
    return cdDispstn;
  }

  /**
   * Sets the disposition.
   * @param cdDispstn
   */
  public void setCdDispstn(String cdDispstn) {
    this.cdDispstn = cdDispstn;
  }

  /**
   * Gets the stage id
   * @return
   */
  public int getUlIdStage() {
    return ulIdStage;
  }

  /**
   * Sets the stage id
   * @param ulIdStage
   */
  public void setUlIdStage(int ulIdStage) {
    this.ulIdStage = ulIdStage;
  }

  /**
   * Gets the distance between the given address
   * and addresses in the resource address table
   * after a search is performed.
   * @return
   */
  public Double getDistance() {
    return distance;
  }

  /**
   * Sets the distance between the given address
   * and addresses in the resource address table
   * after a search is performed.
   * @param distance
   */
  public void setDistance(Double distance) {
    this.distance = distance;
  }

  /**
   * Gets the latitude value used in proximity search
   * @return
   */
  public Double getLatX() {
    return latX;
  }

  /**
   * Sets the latitude value used in proximity search
   * @param latX
   */
  public void setLatX(Double latX) {
    this.latX = latX;
  }

  /**
   * Gets the longitude value used in proximity search
   * @return
   */
  public Double getLongY() {
    return longY;
  }

  /**
   * Sets the longitude value used in proximity search
   * @param longY
   */
  public void setLongY(Double longY) {
    this.longY = longY;
  }

  /**
   * Gets the value valid which indicates if an address was
   * validated by the address validation engine
   * @return
   */
  public boolean getIsValid() {
    return isValid;
  }

  /**
   * Sets the isValid value used in proximity search
   * @param isValid
   */
  public void setIsValid(boolean isValid) {
    this.isValid = isValid;
  }
  
  /**
   * Gets the cdFamviol_03.
   * @return
   */
  public String getCdFamviol03() {
    return cdFamviol_03;
  }

  /**
   * Sets the cdFamviol_03.
   * @param FamViol_03
   */
  public void setCdFamviol03(String cdFamviol_03) {
    this. cdFamviol_03 =  cdFamviol_03;
  }
  
  /**
   * Gets the cdFamviol_04.
   * @return
   */
  public String getCdFamviol04() {
    return cdFamviol_04;
  }

  /**
   * Sets the cdFamviol_04.
   * @param FamViol_04
   */
  public void setCdFamviol04(String cdFamviol_04) {
    this. cdFamviol_04 =  cdFamviol_04;
  }
  
  /**
   * Gets the cdFamviol_05.
   * @return
   */
  public String getCdFamviol05() {
    return cdFamviol_05;
  }

  /**
   * Sets the cdFamviol_05.
   * @param FamViol_05
   */
  public void setCdFamviol05(String cdFamviol_05) {
    this. cdFamviol_05 =  cdFamviol_05;
  }
  
  /**
   * Gets the cdFamviol_05.
   * @return
   */
  public String getCdCnclsnRiskFind() {
    return cdCnclsnRiskFind;
  }

  /**
   * Sets the cdFamviol_05.
   * @param FamViol_05
   */
  public void setCdCnclsnRiskFind(String cdCnclsnRiskFind) {
    this. cdCnclsnRiskFind =  cdCnclsnRiskFind;
  }
  
  /**
   * gets AvailableAfterHOurs
   * @return
   */
  public String getCbxBIndAvalibleAfterHours() {
    return cbxBIndAvalibleAfterHours;
  }
  
  /**
   * sets AvailableAfterHours
   * @param cbxBIndAvalibleAfterHours
   */
  public void setCbxBIndAvalibleAfterHours(String cbxBIndAvalibleAfterHours) {
    this.cbxBIndAvalibleAfterHours = cbxBIndAvalibleAfterHours;
  }
  
  /**
   * Gets the event id
   * @return
   */
  public int getUlIdEvent() {
    return ulIdEvent;
  }

  /**
   * Sets the event id
   * @param ulIdEvent
   */
  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }
  
  /**
   * Gets the cdEventStatus.
   * @return
   */
  public String getCdEventStatus() {
    return cdEventStatus;
  }

  /**
   * Sets the EventStatus.
   * @param cdEventStatus
   */
  public void setCdEventStatus(String cdEventStatus) {
    this.cdEventStatus = cdEventStatus;
  }

  /**
   * Clear the form bean
   *  @ return void
   */
  public void clearSearchParameters() {
    resourceType = null;
    resourceName = null;
    identificationType = null;
    identificationNum = null;
    category = null;
    service = null;
    program = null;
    locationArea = null;
    rsrcRegion = null;
    streetAddress = null;
    nameCounty = null;
    nameCity = null;
    zipCode = null;
    zipCodeSuffix = null;
    stateName = null;
    resourceStatus = null;
    rsrcContracted = null;
    facilityType = null;
    levelCare = null;
    ageServed = null;
    genderServed = null;
    clientCharacteristics = null;
    effectiveDate = null;
    donatedService = null;
    proximityRange = null;
    avalibleAfterHours = null;
    ulIdStage = 0;
    cdDispstn = null;
    isValid = false;
    cdFamviol_03 = null;
    cdFamviol_04 = null;
    cdFamviol_05 = null;
    ulIdEvent = 0;
    cdEventStatus = null;
  }

  /**
   * Get a string of variable names and values
   *  @ return String
   */
  public String toString() {
    return ("resourceName=" + resourceName + " service=" + service + " identificationType=" + identificationType
            + " identificationNum=" + identificationNum + " resourceType=" + resourceType + " rsrcContracted="
            + rsrcContracted + " facilityType=" + facilityType + " levelCare=" + levelCare + " rsrcRegion="
            + rsrcRegion + " nameCity=" + nameCity + " nameCounty=" + nameCounty + " zipCode=" + zipCode
            + " zipCodeSuffix=" + zipCodeSuffix + " stateName=" + stateName + " genderServed=" + genderServed
            + " ageServed=" + ageServed + " clientCharacteristics=" + clientCharacteristics + " proximityRange="
            + proximityRange + " avalibleAfterHours=" + avalibleAfterHours);
  }

}
