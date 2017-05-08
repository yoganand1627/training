/**
 * Created on Mar 29, 2007 by Kapil Aggarwal, SACWIS Project
 */
package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.List;

/**
 * Output Bean for response from CRS Screening Web Service
 * <li> (R): Required
 * <li> Number indicates the size of the field
 * <li> sz: String
 * <li> ln: Number
 */
@SuppressWarnings("serial")
public class CrsScreeningSO implements Serializable {
  
  public static int SUCCESSFULL_SCREENING = 99308;
  
  private List<ReturnItem> returnItems = null;
  
  private Integer returnCode = null;
  
  public static class ReturnItem implements Serializable {
    /** 9 (R) Crs Client Identifier */
    private int lnIrnClientId;

    /** 1 Crs Identifier Error Indicator */
    private String szCrsIdenErrInd;

    /** 5 (R) Crs Return Indicator: 99308-Screening successfull, 91056-Last name must be entered */
    private int lnCrsReturnValue;

    /** 4 */
    private int ulNoRows;

    /** 8 */
    private String szRacfid;

    /** 12 CRS allows 15 we allow 12 */
    private String szFName;

    /** 12 */
    private String szMName;

    /** 20 (R) Required / Not Null */
    private String szLName = "";

    /** 4 SACWIS code mapped to CRS code */
    private String szSuffix;

    /** 1 M or F */
    private String szSexCode;

    /** 9 (R) */
    private int ulSsn;

    /** 1 */
    private int ulSsnErrInd;

    /** 8 Must be valid date and converted in format MMDDYYYY */
    private String ulDob;

    /** 1 Y or N */
    private String szBlnNtvAmerican;

    /** 1 Y or N */
    private String szBlnAsian;

    /** 1 Y or N */
    private String szBlnAfAmerican;

    /** 1 Y or N */
    private String szBlnPcfcislander;

    /** 1 Y or N */
    private String szBlnWhite;

    /** 1 SACWIS 2 char to be mapped to CRS 1 char code */
    private String szEthnCode;

    /** 1 */
    private String szRaceCode;

    /** Whether more rows exist in the Result Set received from the Screening Query */
    private String szMoreRowsExist = "false";

    /**
     * @return the lnCrsReturnValue
     */
    public int getLnCrsReturnValue() {
      return lnCrsReturnValue;
    }

    /**
     * @param lnCrsReturnValue
     *          the lnCrsReturnValue to set
     */
    public void setLnCrsReturnValue(int lnCrsReturnValue) {
      this.lnCrsReturnValue = lnCrsReturnValue;
    }

    /**
     * @return the lnIrnClientId
     */
    public int getLnIrnClientId() {
      return lnIrnClientId;
    }

    /**
     * @param lnIrnClientId
     *          the lnIrnClientId to set
     */
    public void setLnIrnClientId(int lnIrnClientId) {
      this.lnIrnClientId = lnIrnClientId;
    }

    /**
     * @return the szBlnAfAmerican
     */
    public String getSzBlnAfAmerican() {
      return szBlnAfAmerican;
    }

    /**
     * @param szBlnAfAmerican
     *          the szBlnAfAmerican to set
     */
    public void setSzBlnAfAmerican(String szBlnAfAmerican) {
      this.szBlnAfAmerican = szBlnAfAmerican;
    }

    /**
     * @return the szBlnAsian
     */
    public String getSzBlnAsian() {
      return szBlnAsian;
    }

    /**
     * @param szBlnAsian
     *          the szBlnAsian to set
     */
    public void setSzBlnAsian(String szBlnAsian) {
      this.szBlnAsian = szBlnAsian;
    }

    /**
     * @return the szBlnNtvAmerican
     */
    public String getSzBlnNtvAmerican() {
      return szBlnNtvAmerican;
    }

    /**
     * @param szBlnNtvAmerican
     *          the szBlnNtvAmerican to set
     */
    public void setSzBlnNtvAmerican(String szBlnNtvAmerican) {
      this.szBlnNtvAmerican = szBlnNtvAmerican;
    }

    /**
     * @return the szBlnPcfcislander
     */
    public String getSzBlnPcfcislander() {
      return szBlnPcfcislander;
    }

    /**
     * @param szBlnPcfcislander
     *          the szBlnPcfcislander to set
     */
    public void setSzBlnPcfcislander(String szBlnPcfcislander) {
      this.szBlnPcfcislander = szBlnPcfcislander;
    }

    /**
     * @return the szBlnWhite
     */
    public String getSzBlnWhite() {
      return szBlnWhite;
    }

    /**
     * @param szBlnWhite
     *          the szBlnWhite to set
     */
    public void setSzBlnWhite(String szBlnWhite) {
      this.szBlnWhite = szBlnWhite;
    }

    /**
     * @return the szCrsIdenErrInd
     */
    public String getSzCrsIdenErrInd() {
      return szCrsIdenErrInd;
    }

    /**
     * @param szCrsIdenErrInd
     *          the szCrsIdenErrInd to set
     */
    public void setSzCrsIdenErrInd(String szCrsIdenErrInd) {
      this.szCrsIdenErrInd = szCrsIdenErrInd;
    }

    /**
     * @return the szEthnCode
     */
    public String getSzEthnCode() {
      return szEthnCode;
    }

    /**
     * @param szEthnCode
     *          the szEthnCode to set
     */
    public void setSzEthnCode(String szEthnCode) {
      this.szEthnCode = szEthnCode;
    }

    /**
     * @return the szFName
     */
    public String getSzFName() {
      return szFName;
    }

    /**
     * @param szFName
     *          the szFName to set
     */
    public void setSzFName(String szFName) {
      this.szFName = szFName;
    }

    /**
     * @return the szLName
     */
    public String getSzLName() {
      return szLName;
    }

    /**
     * @param szLName
     *          the szLName to set
     */
    public void setSzLName(String szLName) {
      this.szLName = szLName;
    }

    /**
     * @return the szMName
     */
    public String getSzMName() {
      return szMName;
    }

    /**
     * @param szMName
     *          the szMName to set
     */
    public void setSzMName(String szMName) {
      this.szMName = szMName;
    }

    /**
     * @return the szRaceCode
     */
    public String getSzRaceCode() {
      return szRaceCode;
    }

    /**
     * @param szRaceCode
     *          the szRaceCode to set
     */
    public void setSzRaceCode(String szRaceCode) {
      this.szRaceCode = szRaceCode;
    }

    /**
     * @return the szRacfid
     */
    public String getSzRacfid() {
      return szRacfid;
    }

    /**
     * @param szRacfid
     *          the szRacfid to set
     */
    public void setSzRacfid(String szRacfid) {
      this.szRacfid = szRacfid;
    }

    /**
     * @return the szSexCode
     */
    public String getSzSexCode() {
      return szSexCode;
    }

    /**
     * @param szSexCode
     *          the szSexCode to set
     */
    public void setSzSexCode(String szSexCode) {
      this.szSexCode = szSexCode;
    }

    /**
     * @return the szSuffix
     */
    public String getSzSuffix() {
      return szSuffix;
    }

    /**
     * @param szSuffix
     *          the szSuffix to set
     */
    public void setSzSuffix(String szSuffix) {
      this.szSuffix = szSuffix;
    }

    /**
     * @return the ulDob
     */
    public String getUlDob() {
      return ulDob;
    }

    /**
     * @param ulDob
     *          the ulDob to set
     */
    public void setUlDob(String ulDob) {
      this.ulDob = ulDob;
    }

    /**
     * @return the ulNoRows
     */
    public int getUlNoRows() {
      return ulNoRows;
    }

    /**
     * @param ulNoRows
     *          the ulNoRows to set
     */
    public void setUlNoRows(int ulNoRows) {
      this.ulNoRows = ulNoRows;
    }

    /**
     * @return the ulSsn
     */
    public int getUlSsn() {
      return ulSsn;
    }

    /**
     * @param ulSsn
     *          the ulSsn to set
     */
    public void setUlSsn(int ulSsn) {
      this.ulSsn = ulSsn;
    }

    /**
     * @return the ulSsnErrInd
     */
    public int getUlSsnErrInd() {
      return ulSsnErrInd;
    }

    /**
     * @param ulSsnErrInd
     *          the ulSsnErrInd to set
     */
    public void setUlSsnErrInd(int ulSsnErrInd) {
      this.ulSsnErrInd = ulSsnErrInd;
    }

    /**
     * @return the szMoreRowsExist
     */
    public String getSzMoreRowsExist() {
      return szMoreRowsExist;
    }

    /**
     * @param szMoreRowsExist
     *          the szMoreRowsExist to set
     */
    public void setSzMoreRowsExist(String szMoreRowsExist) {
      this.szMoreRowsExist = szMoreRowsExist;
    }
  }

  public Integer getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(Integer returnCode) {
    this.returnCode = returnCode;
  }

  public List<ReturnItem> getReturnItems() {
    return returnItems;
  }

  public void setReturnItems(List<ReturnItem> returnItems) {
    this.returnItems = returnItems;
  }
}
