/**
 * Created on Mar 29, 2007 by Kapil Aggarwal, SACWIS Project
 */
package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

/**
 * Input Bean for CRS Screening Web Service
 * <li> (R): Required
 * <li> Number indicates the size of the field
 * <li> sz: String
 * <li> ln: Number
 */
@SuppressWarnings("serial")
public class CrsScreeningWI implements Serializable {

  /**  9 (R) Crs Client Identifier */
  private int    lnIrnClientId;    
  /**  5 (R) Crs Return Indicator: 99308-Screening successfull, 91056-Last name must be entered */
  private int    lnCrsReturnValue; 
  /**  4 */
  private int     ulNoRows;             
  /**  8 */
  private String  szShinesLogonShort;             

  /** (R)Required  */
  /** 20 (R) Required / Not Null */
  private String  szLName = "";    
  /** 12 CRS allows 15 we allow 12 */
  private String  szFName;         
  /** 12  */
  private String  szMName;          
  /**  4 SACWIS code mapped to CRS code */
  private String  szSuffix;        
  /**  1 M or F */
  private String  szSexCode;       
  /**  8 Must be valid date and converted in format MMDDYYYY */
  private String    ulDob;        
  /**  9 */
  private String    ulSsn;        
  /**  1 Y or N */
  private String  szBlnNtvAmerican;
  /**  1 Y or N */
  private String  szBlnAsian;       
  /**  1 Y or N */
  private String  szBlnAfAmerican;  
  /**  1 Y or N */
  private String  szBlnPcfcislander;
  /**  1 Y or N */
  private String  szBlnWhite;    
  /**  1 SACWIS 2 char to be mapped to CRS 1 char code */
  private String  szEthnCode;    
  
  
  private int ulPageNumber = 0;
  /**  Defalut rows requested */
  private int ulPageRowSize = 25;
  
  private String lnIdInitiator;
 
  
  /**
   * @return the lnCrsReturnValue
   */
  public int getLnCrsReturnValue() {
    return lnCrsReturnValue;
  }
  /**
   * @param lnCrsReturnValue the lnCrsReturnValue to set
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
   * @param lnIrnClientId the lnIrnClientId to set
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
   * @param szBlnAfAmerican the szBlnAfAmerican to set
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
   * @param szBlnAsian the szBlnAsian to set
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
   * @param szBlnNtvAmerican the szBlnNtvAmerican to set
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
   * @param szBlnPcfcislander the szBlnPcfcislander to set
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
   * @param szBlnWhite the szBlnWhite to set
   */
  public void setSzBlnWhite(String szBlnWhite) {
    this.szBlnWhite = szBlnWhite;
  }
  /**
   * @return the szEthnCode
   */
  public String getSzEthnCode() {
    return szEthnCode;
  }
  /**
   * @param szEthnCode the szEthnCode to set
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
   * @param szFName the szFName to set
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
   * @param szLName the szLName to set
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
   * @param szMName the szMName to set
   */
  public void setSzMName(String szMName) {
    this.szMName = szMName;
  }
  /**
   * @return the szUserId
   */
  public String getSzShinesLogonShort() {
    return szShinesLogonShort;
  }
  /**
   * @param ShinesLogonShort the ShinesLogonShort to set
   */
  public void setSzShinesLogonShort(String szShinesLogonShort) {
    this.szShinesLogonShort= szShinesLogonShort;
  }
  /**
   * @return the szSexCode
   */
  public String getSzSexCode() {
    return szSexCode;
  }
  /**
   * @param szSexCode the szSexCode to set
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
   * @param szSuffix the szSuffix to set
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
   * @param ulDob the ulDob to set
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
   * @param ulNoRows the ulNoRows to set
   */
  public void setUlNoRows(int ulNoRows) {
    this.ulNoRows = ulNoRows;
  }
  /**
   * @return the ulSsn
   */
  public String getUlSsn() {
    return ulSsn;
  }
  /**
   * @param ulSsn the ulSsn to set
   */
  public void setUlSsn(String ulSsn) {
    this.ulSsn = ulSsn;
  }
  /**
   * @return the ulPageRowSize
   */
  public int getUlPageRowSize() {
    return ulPageRowSize;
  }
  /**
   * @param ulPageRowSize the ulPageRowSize to set
   */
  public void setUlPageRowSize(int ulPageRowSize) {
    this.ulPageRowSize = ulPageRowSize;
  }
  /**
   * @return the ulPageNumber
   */
  public int getUlPageNumber() {
    return ulPageNumber;
  }
  /**
   * @param ulPageNumber the ulPageNumber to set
   */
  public void setUlPageNumber(int ulPageNumber) {
    this.ulPageNumber = ulPageNumber;
  }
  public String getLnIdInitiator() {
    return lnIdInitiator;
  }
  public void setLnIdInitiator(String lnIdInitiator) {
    this.lnIdInitiator = lnIdInitiator;
  }
 
}
