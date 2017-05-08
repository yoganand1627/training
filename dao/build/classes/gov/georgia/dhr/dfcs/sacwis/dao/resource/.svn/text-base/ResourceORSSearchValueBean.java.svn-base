package gov.georgia.dhr.dfcs.sacwis.dao.resource;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.BasePaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

/**
 * This class is the Bean class for ORS Resource Search. The ResourceORSSearchBean stores search parameters and results.
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  03/10/08    Sriram    Initial Coding.
 * </pre>
 * 
 * @author Sriram S,
 */
public class ResourceORSSearchValueBean extends BasePaginationValueBean {
  // instance variables
  /** Name of the Facility - Also the Resource Name. */
  private String resourceName;

  /** ID of the Facility*/
  private String facilityID;
  
  /** Legal Name of the Facility*/
  private String legalName;
  
  /** Facility Type - ORS Facility Type*/
  private String facilityType;
  
  /** ORS Operating Status*/
  private String orsOperatingStatus;
  
  /** Address*/
  private String address;
  
  /** City*/
  private String city;
  
  /** County*/
  private String county;
  
  /** SHINESRSRCID*/
  private String shinesResourceId;

  // Tracing
  private static final String TRACE_TAG = "ResourceORSSearchBean";
  
  /** Null Constructor */
  public ResourceORSSearchValueBean() {
    resourceName = "";
    facilityID = "";
    legalName = "";
    facilityType = "";
    orsOperatingStatus = "";
    address = "";
    city = "";
    county = "";
  }
  
  /** Constructor that builds the bean from a ResultSet object */
  public ResourceORSSearchValueBean(ResultSet results) throws ResourceORSSearchDaoException {
    try {
      GrndsTrace.enterScope(TRACE_TAG + " constructor");
      ResultSetMetaData rsmd = results.getMetaData();
      String columnName = null;
      for (int i = 1; i <= rsmd.getColumnCount(); i++) {
        columnName = rsmd.getColumnName(i);
      }
      String id = results.getString(ResourceORSSearchDAO.ID_COLUMN);
      this.setFacilityID(id);
      this.setResourceName(results.getString(ResourceORSSearchDAO.NAME_COLUMN));
      this.setLegalName(results.getString(ResourceORSSearchDAO.LEGAL_NAME_COLUMN));
      this.setOrsOperatingStatus(results.getString(ResourceORSSearchDAO.OPERSTAT_COLUMN));
      this.setAddress(results.getString(ResourceORSSearchDAO.ADDRESS_COLUMN));
      this.setCity(FormattingHelper.initCaps(results.getString(ResourceORSSearchDAO.CITY_COLUMN)));
      String county = results.getString(ResourceORSSearchDAO.COUNTY_COLUMN);
      this.setCounty(county);
      this.setFacilityType(results.getString(ResourceORSSearchDAO.FACTYPE_COLUMN));
      this.setShinesResourceId(results.getString(ResourceORSSearchDAO.SHINES_RSRC_ID_COLUMN));
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception while setting results from DAO to ResourceORSSearchBean.");
      throw new ResourceORSSearchDaoException("Exception translating ResultSet to ResourceBean", e,
                                           BasePrsException.WARNING_PRIORITY);
    }
    GrndsTrace.exitScope();
  }
  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getFacilityID() {
    return facilityID;
  }

  public void setFacilityID(String facilityID) {
    this.facilityID = facilityID;
  }

  public String getLegalName() {
    return legalName;
  }

  public void setLegalName(String legalName) {
    this.legalName = legalName;
  }

  public String getFacilityType() {
    return facilityType;
  }

  public void setFacilityType(String facilityType) {
    this.facilityType = facilityType;
  }

  public String getOrsOperatingStatus() {
    return orsOperatingStatus;
  }

  public void setOrsOperatingStatus(String orsOperatingStatus) {
    this.orsOperatingStatus = orsOperatingStatus;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getShinesResourceId() {
    return shinesResourceId;
  }

  public void setShinesResourceId(String shinesResourceId) {
    this.shinesResourceId = shinesResourceId;
  }
  
}
