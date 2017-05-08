package gov.georgia.dhr.dfcs.sacwis.dao.person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;

public class AddressValueBean extends BaseValueBean {
  private static final String TRACE_TAG = "AddressValueBean";

  private String peronFullName = null;
  private int personId = 0;
  private String streetLn1 = null;
  private String streetLn2 = null;
  private String city = null;
  private String state = null;
  private String county = null;
  private String zip = null;
  private String primary = null;
  private String invalid = null;
  private String addressType = null;
  private String attention = null;
  private Date startDate = null;
  private int stageId;
  private String stageCode = null;
  private List addresses;

  //Sir22875 Changed constructor so that it is not null but empty
  public AddressValueBean() {
    personId = 0;
    streetLn1 = null;
    streetLn2 = null;
    city = null;
    state = null;
    county = null;
    zip = null;
    primary = null;
    invalid = null;
    addressType = null;
    attention = null;
    startDate = null;
    stageId = 0;
    stageCode = null;
    addresses = null;
  }

  public AddressValueBean(int stageId, String stageCode) {
    this.setStageId(stageId);
    this.setStageCode(stageCode);
  }

  public AddressValueBean(ResultSet results)
          throws DaoException {
    GrndsTrace.enterScope(TRACE_TAG + " constructor");

    try {
      // Set the following bean properties to the corresponding values retrieved
      // from the database only if the values from the database are not null.
      GrndsTrace.enterScope(TRACE_TAG + " before full name");
      if (results.getString(AddressDao.NM_PERSON_FULL_COLUMN) != null) {
        this.setPeronFullName(results.getString(AddressDao.NM_PERSON_FULL_COLUMN));
      }
      GrndsTrace.enterScope(TRACE_TAG + " before id_person");
      if (results.getString(AddressDao.ID_PERSON_COLUMN) != null) {
        this.setPersonId(results.getInt(AddressDao.ID_PERSON_COLUMN));
      }
      GrndsTrace.enterScope(TRACE_TAG + " before_address_ln1");
      if (results.getString(AddressDao.ADDR_PERS_ADDR_ST_LN_1_COLUMN) != null) {
        this.setStreetLn1(results.getString(AddressDao.ADDR_PERS_ADDR_ST_LN_1_COLUMN));
      }
      GrndsTrace.enterScope(TRACE_TAG + " before_addressLn2");
      if (results.getString(AddressDao.ADDR_PERS_ADDR_ST_LN_2_COLUMN) != null) {
        this.setStreetLn2(results.getString(AddressDao.ADDR_PERS_ADDR_ST_LN_2_COLUMN));
      }
      GrndsTrace.enterScope(TRACE_TAG + " before_attention");
      if (results.getString(AddressDao.ADDR_PERSON_ADDR_ATTN_COLUMN) != null) {
        this.setAttention(results.getString(AddressDao.ADDR_PERSON_ADDR_ATTN_COLUMN));
      }
      GrndsTrace.enterScope(TRACE_TAG + " before_city");
      if (results.getString(AddressDao.ADDR_PERSON_ADDR_CITY_COLUMN) != null) {
        this.setCity(results.getString(AddressDao.ADDR_PERSON_ADDR_CITY_COLUMN));
      }
      GrndsTrace.enterScope(TRACE_TAG + " before_state");
      if (results.getString(AddressDao.CD_PERSON_ADDR_STATE_COLUMN) != null) {
        this.setState(results.getString(AddressDao.CD_PERSON_ADDR_STATE_COLUMN));
      }
      GrndsTrace.enterScope(TRACE_TAG + " before_county");
      if (results.getString(AddressDao.CD_PERSON_ADDR_COUNTY_COLUMN) != null) {
        this.setCounty(results.getString(AddressDao.CD_PERSON_ADDR_COUNTY_COLUMN));
      }
      GrndsTrace.enterScope(TRACE_TAG + " before_zip");
      if (results.getString(AddressDao.ADDR_PERSON_ADDR_ZIP_COLUMN) != null) {
        this.setZip(results.getString(AddressDao.ADDR_PERSON_ADDR_ZIP_COLUMN));
      }
      GrndsTrace.enterScope(TRACE_TAG + " before_DateStart");
      //if (results.getDate(AddressDao.DT_PERS_ADDR_LINK_START_COLUMN) != null)
      //{
      //  this.setStartDate(results.getDate(AddressDao.DT_PERS_ADDR_LINK_START_COLUMN));
      //}
      GrndsTrace.enterScope(TRACE_TAG + " prim_Str_is \n" + results.getString(
              AddressDao.IND_PERS_ADDR_LINK_PRIMARY_COLUMN));

      if (results.getString(AddressDao.IND_PERS_ADDR_LINK_PRIMARY_COLUMN) != null) {
        this.setPrimary(results.getString(AddressDao.IND_PERS_ADDR_LINK_PRIMARY_COLUMN));
      }
      GrndsTrace.enterScope(TRACE_TAG + " before_invalid");
      if (results.getString(AddressDao.IND_PERS_ADDR_LINK_INVALID_COLUMN) != null) {
        this.setInvalid(results.getString(AddressDao.IND_PERS_ADDR_LINK_INVALID_COLUMN));
      }
      GrndsTrace.enterScope(TRACE_TAG + " before_type");
      if (results.getString(AddressDao.CD_PERS_ADDR_LINK_TYPE_COLUMN) != null) {
        this.setAddressType(results.getString(AddressDao.CD_PERS_ADDR_LINK_TYPE_COLUMN));
      }
    }
    catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception while setting results from DAO to AddressValueBean.");
      GrndsTrace.msg(TRACE_TAG, 10, "SQLException message 1 " + e.getMessage());
      GrndsTrace.msg(TRACE_TAG, 10, "SQLException code " + e.getErrorCode());
      GrndsTrace.msg(TRACE_TAG, 10, "SQLException code " + e.toString());
      throw new DaoException("Exception translating ResultSet to AddressBean", e, 7);
    }
    GrndsTrace.exitScope();
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public int getPersonId() {
    return personId;
  }

  public void setAddressType(String addressType) {
    this.addressType = addressType;
  }

  public String getAddressType() {
    return addressType;
  }

  public void setPrimary(String primary) {
    this.primary = primary;
  }

  public String getPrimary() {
    return primary;
  }

  public void setInvalid(String invalid) {
    this.invalid = invalid;
  }

  public String getInvalid() {
    return invalid;
  }

  public void setStreetLn1(String streetLn1) {
    this.streetLn1 = streetLn1;
  }

  public String getStreetLn1() {
    return streetLn1;
  }

  public void setStreetLn2(String streetLn2) {
    this.streetLn2 = streetLn2;
  }

  public String getStreetLn2() {
    return streetLn2;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getCounty() {
    return county;
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

  public void setAttention(String attention) {
    this.attention = attention;
  }

  public String getAttention() {
    return attention;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  public int getStageId() {
    return stageId;
  }

  public void setStageCode(String stageCode) {
    this.stageCode = stageCode;
  }

  public String getStageCode() {
    return stageCode;
  }

  public List getAddresses() {
    return addresses;
  }

  public void setAddresses(List addresses) {
    this.addresses = addresses;
  }
}
