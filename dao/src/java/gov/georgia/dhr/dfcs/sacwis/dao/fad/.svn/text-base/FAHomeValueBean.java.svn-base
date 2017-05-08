package gov.georgia.dhr.dfcs.sacwis.dao.fad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.exolab.castor.types.Date;
import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.BasePaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

/**
 * <pre>
 * Change History:
 * Date      User      Sir#           Description
 * --------  ----------------  --------------------------------------------------
 * 03/18/05 Hadjimh   SIR#23327. Add a new field to the Home Information page. This new
 *                    field would be stored in the CAPS_RESOURCE table. 1) If the Non-FPS
 *                    Adoptive Home checkbox is checked, staff will have to select a
 *                    'Certifying Entity'. to indicate the certifying agency
 *                    2) This will be a required field when the Non-FPS Adoptive Home
 *                    checkbox is checked for a new home. 3) If a user is modifying an
 *                    existing Non-FPS Adoptive Home, this new field will be required,
 *                    unless the home status is also being changed to 'Pending Closure'
 *                    or 'Closed'.
 * 11/01/06 aodutayo  Adding modifications necessary for SHINES development.This includes
 *                    setter and getter methods for new fields required.
 * 10/27/2008 mchillman STGAP00010728  Altered code to support new race and ethnic display
 * </pre>
 */

public class FAHomeValueBean extends BasePaginationValueBean {
  private static final String TRACE_TAG = "FAHomeValueBean";
  static final long serialVersionUID = 5318727280029640019L;

  private int homeStageId = 0;
  private int personId = 0;
  private int homeResourceId = 0;
  private String resourceCategory = null;
  private String resourceCounty = null;
  private String resourceEthnicity = null;
  private List<String> raceCriteria = null;
  private List<String> ethnicityCriteria = null;
  private String faHomeStatus = null;
  private String state = null;
  private String city = null;
  private String zip = null;
  private String peronFullName = null;
  private String resourceName = null;
  private String indRsrcNonPrs;
  /* sir#23327. added  certifyEntity */
  private String certifyEntity = null;
  private String streetLn1 = null;
  private String phoneNumber = null;
  private String phoneExtensionNumber = null;
  private String region = null;
  private String resourceFaHomeType1 = null;
  private int minAge = 0;
  private int maxAge = 0;
  private int openSlot = 0;
  private int iNumberOfCharacteristics = 42;
  private String language = null;
  private String gender = null;
  private List FAHomes;
  private List resourceCharacteristics;
  public static final String Adoptive = "A";
  public static final int SEARCH_RESULTS_PER_PAGE = 50;
  public static final int MAX_SEARCH_RESULTS = 200;
  //adding instance data members for SHINES modifications
  private String maritalStatus = null;
  private String schoolDistrict = null;
  private Date  inquiryDate = null;
  private String indRegAdptnExchge = null;
  private int intCapacity = 0;
  private int iCurrPlcmnts = 0;
  private String race = null;
  private String ethnicity = null;
  private String religion = null;
  private int ulIdStage;
  private String cdDispstn;
  

  public FAHomeValueBean() {
  }

  /** Constructor that build the bean from homeResourceId * @param homeResourceId an int */
  public FAHomeValueBean(int homeResourceId) {
    this.setHomeResourceId(homeResourceId);
  }

  /**
   * Constructor that builds the bean from the ResultSet retrieved from the * database * @throws DaoException * @param
   * results ResultSet object
   */
  public FAHomeValueBean(ResultSet results) throws DaoException {
    GrndsTrace.enterScope(TRACE_TAG + " constructor");

    try {
      // Set the following bean properties to the corresponding values retrieved
      // from the database only if the values from the database are not null.
      if (results.getString(FAHomeListDao.CD_RSRC_CATEGORY_COLUMN) != null) {
        this.setResourceCategory( StringHelper.getNonNullString( results.getString(FAHomeListDao.CD_RSRC_CATEGORY_COLUMN)) );
      }

      if (results.getString(FAHomeListDao.CD_RSRC_CNTY_COLUMN) != null) {
        this.setResourceCounty(StringHelper.getNonNullString( results.getString(FAHomeListDao.CD_RSRC_CNTY_COLUMN)) );
      }

      /*if (results.getString(FAHomeListDao.CD_RSRC_ETHNICITY_COLUMN) != null) {
        this.setResourceEthnicity(StringHelper.getNonNullString(results.getString(FAHomeListDao.CD_RSRC_ETHNICITY_COLUMN)));
      }*/

      if (results.getString(FAHomeListDao.CD_RSRC_FA_HOME_STATUS_COLUMN) != null) {
        this.setFaHomeStatus(StringHelper.getNonNullString( results.getString(FAHomeListDao.CD_RSRC_FA_HOME_STATUS_COLUMN)));
      }

      if (results.getString(FAHomeListDao.CD_RSRC_STATE_COLUMN) != null) {
        this.setState(StringHelper.getNonNullString(results.getString(FAHomeListDao.CD_RSRC_STATE_COLUMN)));
      }

      if (results.getString(FAHomeListDao.ID_RSRC_FA_HOME_STAGE_COLUMN) != null) {
        int stageId = Integer.parseInt(results.getString(FAHomeListDao.ID_RSRC_FA_HOME_STAGE_COLUMN));
        this.setHomeStageId(stageId);
      }

      if (results.getString(FAHomeListDao.IND_RSRC_NONPRS_COLUMN) != null) {
        this.setIndRsrcNonPrs(StringHelper.getNonNullString( results.getString(FAHomeListDao.IND_RSRC_NONPRS_COLUMN)));
      }
      /* sir#23327. added  CD_CERTIFY_ENTITY_COLUMN */
      if (results.getString(FAHomeListDao.CD_CERTIFY_ENTITY_COLUMN) != null) {
        this.setCertifyEntity(StringHelper.getNonNullString( results.getString(FAHomeListDao.CD_CERTIFY_ENTITY_COLUMN)));
      }

      if (results.getString(FAHomeListDao.NM_RESOURCE_COLUMN) != null) {
        this.setResourceName(StringHelper.getNonNullString(results.getString(FAHomeListDao.NM_RESOURCE_COLUMN)));
      }
      //GrndsTrace.enterScope( TRACE_TAG + " befor ADDR_RSRC_CITY_COLUMN_is \n" + results.getString( FAHomeListDao.ADDR_RSRC_CITY_COLUMN ));

      if (results.getString(FAHomeListDao.ADDR_RSRC_CITY_COLUMN) != null) {
        this.setCity(StringHelper.getNonNullString(results.getString(FAHomeListDao.ADDR_RSRC_CITY_COLUMN)));
      }

      if (results.getString(FAHomeListDao.ADDR_RSRC_ST_LN_1_COLUMN) != null) {
        this.setStreetLn1(StringHelper.getNonNullString(results.getString(FAHomeListDao.ADDR_RSRC_ST_LN_1_COLUMN)));
      }
      //GrndsTrace.enterScope( TRACE_TAG + " befor ADDR_RSRC_ZIP_COLUMN_is \n" + results.getString( FAHomeListDao.ADDR_RSRC_ZIP_COLUMN ));

      if (results.getString(FAHomeListDao.ADDR_RSRC_ZIP_COLUMN) != null) {
        this.setZip(StringHelper.getNonNullString(results.getString(FAHomeListDao.ADDR_RSRC_ZIP_COLUMN)));
      }

      if (results.getString(FAHomeListDao.ID_PERSON_COLUMN) != null) {
        this.setPersonId(Integer.parseInt(results.getString(FAHomeListDao.ID_PERSON_COLUMN)));
      }
      //GrndsTrace.enterScope( TRACE_TAG + " befor NM_PERSON_FULL_COLUMN_is \n" + results.getString( FAHomeListDao.NM_PERSON_FULL_COLUMN ));

      if (results.getString(FAHomeListDao.NM_PERSON_FULL_COLUMN) != null) {
        this.setPeronFullName(StringHelper.getNonNullString( results.getString(FAHomeListDao.NM_PERSON_FULL_COLUMN)));
      }

      if (results.getString(FAHomeListDao.NBR_PERSON_PHONE_COLUMN) != null) {
        this.setPhoneNumber(StringHelper.getNonNullString(results.getString(FAHomeListDao.NBR_PERSON_PHONE_COLUMN)));
      }

      if (results.getString(FAHomeListDao.NBR_PERSON_PHONE_EXTENSION_COLUMN) != null) {
        this.setPhoneExtensionNumber(StringHelper.getNonNullString(results.getString(FAHomeListDao.NBR_PERSON_PHONE_EXTENSION_COLUMN)));
      }
      if (results.getString(FAHomeListDao.ID_STAGE) != null) {
        this.setUlIdStage(Integer.parseInt(results.getString(FAHomeListDao.ID_STAGE)));
      }
      if (results.getString(FAHomeListDao.CD_CPS_INVST_DTL_OVRLL_DISPTN) != null) {
        this.setCdDispstn(StringHelper.getNonNullString(results.getString(FAHomeListDao.CD_CPS_INVST_DTL_OVRLL_DISPTN)));
      }
      //GrndsTrace.enterScope( TRACE_TAG + " after NBR_PERSON_PHONE_EXTENSION" );

    }
    catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception while setting results from DAO to FAHomeValueBean.");
      GrndsTrace.msg(TRACE_TAG, 7, "SQLException message 1 " + e.getMessage());
      GrndsTrace.msg(TRACE_TAG, 7, "SQLException code " + e.getErrorCode());
      throw new DaoException("Exception translating ResultSet to FAHomeBean", e, 7);
    }
    GrndsTrace.exitScope();
  }

  public void setHomeStageId(int homeStageId) {
    this.homeStageId = homeStageId;
  }

  public int getHomeStageId() {
    return homeStageId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public int getPersonId() {
    return personId;
  }

  public void setResourceCategory(String resourceCategory) {
    this.resourceCategory = resourceCategory;
  }

  public String getResourceCategory() {
    return resourceCategory;
  }

  public void setResourceCounty(String resourceCounty) {
    this.resourceCounty = resourceCounty;
  }

  public String getResourceCounty() {
    return resourceCounty;
  }

  public void setResourceEthnicity(String resourceEthnicity) {
    this.resourceEthnicity = resourceEthnicity;
  }

  public String getResourceEthnicity() {
    return resourceEthnicity;
  }

  public void setFaHomeStatus(String faHomeStatus) {
    this.faHomeStatus = faHomeStatus;
  }

  public String getFaHomeStatus() {
    return faHomeStatus;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCity() {
    return city;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getZip() {
    return zip;
  }

  public void setPeronFullName(String peronFullName) {
    this.peronFullName = peronFullName;
  }

  public String getPeronFullName() {
    return peronFullName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setIndRsrcNonPrs(String indRsrcNonPrs) {
    this.indRsrcNonPrs = indRsrcNonPrs;
  }

  public String getIndRsrcNonPrs() {
    return indRsrcNonPrs;
  }

  /* sir#23327. added  get & set method for certifyEntity */
  public void setCertifyEntity(String certifyEntity) {
    this.certifyEntity = certifyEntity;
  }

  public String getCertifyEntity() {
    return certifyEntity;
  }

  public void setStreetLn1(String streetLn1) {
    this.streetLn1 = streetLn1;
  }

  public String getStreetLn1() {
    return streetLn1;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneExtensionNumber(String phoneExtensionNumber) {
    this.phoneExtensionNumber = phoneExtensionNumber;
  }

  public String getPhoneExtensionNumber() {
    return phoneExtensionNumber;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getRegion() {
    return region;
  }

  public void setRsrcFaHomeType1(String resourceFaHomeType1) {
    this.resourceFaHomeType1 = resourceFaHomeType1;
  }

  public String getRsrcFaHomeType1() {
    return resourceFaHomeType1;
  }

  public void setHomeResourceId(int homeResourceId) {
    this.homeResourceId = homeResourceId;
  }

  public int getHomeResourceId() {
    return homeResourceId;
  }

  public void setMinAge(int minAge) {
    this.minAge = minAge;
  }

  public int getMinAge() {
    return minAge;
  }

  public void setMaxAge(int maxAge) {
    this.maxAge = maxAge;
  }

  public int getMaxAge() {
    return maxAge;
  }

  public void setOpenSlot(int openSlot) {
    this.openSlot = openSlot;
  }

  public int getOpenSlot() {
    return openSlot;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getLanguage() {
    return language;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getGender() {
    return gender;
  }

  public List getFAHomes() {
    return FAHomes;
  }

  public void setFAHomes(List FAHomes) {
    this.FAHomes = FAHomes;
  }

  public List getResourceCharacteristics() {
    return resourceCharacteristics;
  }

  public void setResourceCharacteristics(List resourceCharacteristics) {
    this.resourceCharacteristics = resourceCharacteristics;
  }

  /**
   * ***************************************************************************** This method will concat the resource
   * name * @return  sName  Output * @param sTmp String Object. ******************************************************************************
   */
  protected String getResourceName(String sTmp) {
    //GrndsTrace.msg( TRACE_TAG, 10, "inside_getname_function\n" );
    String sFirstName = "";
    String sLastName = "";
    String sMiddleName = "";
    String sName = "";
    String sTmp2 = "";
    int iCommaPosition = sTmp.indexOf(',');
    int iFirstBlankPosition = 0;
    int iLastBlankPosition = 0;
    /* if there is a comma, there may be a first name */
    if (iCommaPosition > 0) {
      sLastName = sTmp.substring(0, iCommaPosition);
      sLastName = sLastName.trim();
      sLastName = sLastName.substring(0, 1).toUpperCase() + sLastName.substring(1, sLastName.length()).toLowerCase();
      sFirstName = sTmp.substring(iCommaPosition + 1, sTmp.length());
      for (int k = 0; k < sFirstName.length(); k++) {
        /* convert the first char of the first name*/
        if (sFirstName.charAt(k) != ' ') {
          sFirstName = sFirstName.substring(0, k) + sFirstName.substring(k, k + 1).toUpperCase() + sFirstName.substring(
                  k + 1, sFirstName.length()).toLowerCase();
          break;
        }
      }

      int j;
      /* get rid of spaces to the right of the first name*/
      for (j = sFirstName.length() - 1; j > 0; j--) {
        if (sFirstName.charAt(j) == ' ') {
          sFirstName = sFirstName.substring(0, sFirstName.length() - 1);
        } else {
          break;
        }
      }
      /* if there is a blank space in first name
      ** there may be a middle initial
      */
      sTmp2 = sFirstName.trim();
      iLastBlankPosition = sTmp2.lastIndexOf(' ');
      if (iLastBlankPosition > 0) {
        sFirstName = sFirstName.substring(0, sFirstName.length() - 1) + sFirstName.substring(sFirstName.length() - 1,
                                                                                             sFirstName.length()).toUpperCase();
      }
      sName = sLastName + "," + sFirstName;
    } else {
      sName = sTmp.substring(0, 1).toUpperCase() + sTmp.substring(1, sTmp.length()).toLowerCase();
    }
    //GrndsTrace.msg( TRACE_TAG, 10, "sName_is ?" + sName + "?" );
    return sName;
  }

  /**
   * This method will get the number of characteristics from codetable CPL.
   *
   * @return i  Output
   * @throws gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException
   *
   */
  public static int getNumOfCharacs() throws LookupException {
    int i = 0;
    // Get all securities from the security codestable.
    Collection categoryCollection = Lookup.getCategoryCollection(CodesTables.CCHRTCA2);

    Iterator catIterator = categoryCollection.iterator();
    while(catIterator.hasNext()){
    	CodeAttributes charCatCodeAtt = (CodeAttributes)catIterator.next();
    	 String catCode = charCatCodeAtt.getCode();
			int catCodeSize =  Lookup.getCategoryCollection(catCode).size();
			
			 i =+ catCodeSize;	 	
    }
    GrndsTrace.msg(TRACE_TAG, 10,
                   "charcateristics_size = " + i );
    return i;
  }

  public String getEthnicity() {
    return ethnicity;
  }

  public void setEthnicity(String ethnicity) {
    this.ethnicity = ethnicity;
  }

  public int getICurrPlcmnts() {
    return iCurrPlcmnts;
  }

  public void setICurrPlcmnts(int currPlcmnts) {
    iCurrPlcmnts = currPlcmnts;
  }

  public String getIndRegAdptnExchge() {
    return indRegAdptnExchge;
  }

  public void setIndRegAdptnExchge(String indRegAdptnExchge) {
    this.indRegAdptnExchge = indRegAdptnExchge;
  }

  public Date getInquiryDate() {
    return inquiryDate;
  }

  public void setInquiryDate(Date inquiryDate) {
    this.inquiryDate = inquiryDate;
  }

  public int getIntCapacity() {
    return intCapacity;
  }

  public void setIntCapacity(int intCapacity) {
    this.intCapacity = intCapacity;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public String getRace() {
    return race;
  }

  public void setRace(String race) {
    this.race = race;
  }

  public String getReligion() {
    return religion;
  }

  public void setReligion(String religion) {
    this.religion = religion;
  }

  public String getSchoolDistrict() {
    return schoolDistrict;
  }

  public void setSchoolDistrict(String schoolDistrict) {
    this.schoolDistrict = schoolDistrict;
  }

  public String getCdDispstn() {
    return cdDispstn;
  }

  public void setCdDispstn(String cdDispstn) {
    this.cdDispstn = cdDispstn;
  }

  public int getUlIdStage() {
    return ulIdStage;
  }

  public void setUlIdStage(int ulIdStage) {
    this.ulIdStage = ulIdStage;
  }

  public List<String> getRaceCriteria() {
    return raceCriteria;
  }

  public void setRaceCriteria(List<String> raceCriteria) {
    this.raceCriteria = raceCriteria;
  }

  public List<String> getEthnicityCriteria() {
    return ethnicityCriteria;
  }

  public void setEthnicityCriteria(List<String> ethnicityCriteria) {
    this.ethnicityCriteria = ethnicityCriteria;
  }
}
