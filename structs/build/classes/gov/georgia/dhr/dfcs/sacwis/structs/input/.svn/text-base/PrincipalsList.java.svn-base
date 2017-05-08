package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

public class PrincipalsList implements Serializable {

private String addrPersonStLn1;
  
  private String addrPersonCity;
  
  private String addrPersonZip;
  
  private String cdPersonState;
  
  private String cdPersonMaritalStatus;
  
  private String indPersonPaternityEst;
  
  private String nbrPersonIdNumber;
  
  private String cdStagePersRelInt;
  
  private String nmPrincipals;
  
  private String race;
  
  private Date dob;
  
  private String indParent;
  
  private int idPerson;
  
  private Date dtLastUpdate = null;
  
  

  public PrincipalsList() {
    super();
  }

  public String getRace() {
    return race;
  }
  
  public void setRace(String race) {
    this.race = race;
  }
  
  public String getAddrPersonStLn1() {
    return addrPersonStLn1;
  }
  
  public void setAddrPersonStLn1(String addrPersonStLn1) {
    this.addrPersonStLn1 = addrPersonStLn1;
  }
  public String getAddrPersonCity() {
    return addrPersonCity;
  }
  
  public void setAddrPersonCity(String addrPersonCity) {
    this.addrPersonCity = addrPersonCity;
  }
  public String getAddrPersonZip() {
    return addrPersonZip;
  }
  
  public void setAddrPersonZip(String addrPersonZip) {
    this.addrPersonZip = addrPersonZip;
  }
  public String getCdPersonState() {
    return cdPersonState;
  }
  
  public void setCdPersonState(String cdPersonState) {
    this.cdPersonState = cdPersonState;
  }
  public String getCdPersonMaritalStatus() {
    return cdPersonMaritalStatus;
  }
  
  public void setCdPersonMaritalStatus(String cdPersonMaritalStatus) {
    this.cdPersonMaritalStatus = cdPersonMaritalStatus;
  }
  public String getIndPersonPaternityEst() {
    return indPersonPaternityEst;
  }
  
  public void setIndPersonPaternityEst(String indPersonPaternityEst) {
    this.indPersonPaternityEst = indPersonPaternityEst;
  }
  public String getNbrPersonIdNumber() {
    return nbrPersonIdNumber;
  }
  
  public void setNbrPersonIdNumber(String nbrPersonIdNumber) {
    this.nbrPersonIdNumber = nbrPersonIdNumber;
  }
  public String getCdStagePersRelInt() {
    return cdStagePersRelInt;
  }
  
  public void setCdStagePersRelInt(String cdStagePersRelInt) {
    this.cdStagePersRelInt = cdStagePersRelInt;
  }
  
  public String getNmPrincipals() {
    return nmPrincipals;
  }
  
  public void setNmPrincipals(String nmPrincipals) {
    this.nmPrincipals = nmPrincipals;
  }
  public Date getDob() {
    return dob;
  }
  
  public void setDob(Date  dob) {
    this.dob = dob;
  }  
  public String getIndParent() {
    return indParent;
  }
  
  public void setIndParent(String  indParent) {
    this.indParent = indParent;
  }  
  public int getIdPerson() {
    return idPerson;
  }
  
  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  } 
  
  public long getDtLastUpdateTime() {
    return toTime(dtLastUpdate);
  }
  
  public void setDtLastUpdateTime(long dtLastUpdateTime) {
    this.dtLastUpdate = toDate(dtLastUpdateTime);
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