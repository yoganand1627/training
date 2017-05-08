package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.*;

import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;

/**
 * This is the output object returns form the RetrievePlacementReferralLog service.
 * This object holds the placement referral log list, to display on JSP page.
 *
 * @author Lata Lokhande 02/15/2007
 */
public class PlacementReferralDetailRetrieveSO implements Serializable {
  private ArchOutputStruct archOutputStruct = null;
  private Integer idPlacementReferral;
  private Date dtLastUpdate;
  private Integer idPerson;
  private Integer idResource;
  private Integer idEmployee;
  private Date dtBegin;
  private Date dtExpiration;
  private String cdStatus;
  private String cdPlacementType;
  private String nmPersonFull;
  private String nmEmployeeFull;
  private Integer nbrPersonAge;
  private String cdPersonSex;
  private Date dtPersonBirth;
  
  public PlacementReferralDetailRetrieveSO(){
    this.archOutputStruct = null;
    this.cdPersonSex = "";
    this.cdPlacementType = "";
    this.cdStatus = "";
    this.dtBegin = null;
    this.dtExpiration = null;
    this.dtLastUpdate = null;
    this.dtPersonBirth = null;
    this.idEmployee = 0;
    this.idPerson = 0;
    this.idPlacementReferral = 0;
    this.idResource = 0;
    this.nbrPersonAge = 0;
    this.nmEmployeeFull = "";
    this.nmPersonFull = "";
    
    }
    
  public ArchOutputStruct getArchOutputStruct() {
    return this.archOutputStruct;
  }

  public void setArchOutputStruct(ArchOutputStruct archOutputStruct) {
    this.archOutputStruct = archOutputStruct;
  }
  
  public Integer getIdResource() {
    return this.idResource;
  }

  public void setIdResource(int idResource) {
    this.idResource = idResource;
  }
  
  public Integer getIdPerson() {
    return this.idPerson;
  }

  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }
  
  public Integer getIdEmployee() {
    return this.idEmployee;
  }

  public void setIdEmployee(int idEmployee) {
    this.idEmployee = idEmployee;
  }
  
  public Integer getIdPlacementReferral() {
    return this.idPlacementReferral;
  }

  public void setIdPlacementReferral(int idPlacementReferral) {
    this.idPlacementReferral = idPlacementReferral;
  }
  public Integer getNbrPersonAge() {
    return this.nbrPersonAge;
  }

  public void setNbrPersonAge(int nbrPersonAge) {
    this.nbrPersonAge = nbrPersonAge;
  }
  public Date getDtLastUpdate() {
    return this.dtLastUpdate;
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }
  public Date getDtBegin() {
    return this.dtBegin;
  }

  public void setDtBegin(Date dtBegin) {
    this.dtBegin = dtBegin;
  }
  
  public Date getDtExpiration() {
    return this.dtExpiration;
  }
  
  public void setDtExpiration(Date dtExpiration) {
    this.dtExpiration = dtExpiration;
  }
  
  public Date getDtPersonBirth() {
    return this.dtPersonBirth;
  }

  public void setDtPersonBirth(Date dtPersonBirth) {
    this.dtPersonBirth = dtPersonBirth;
  }
  
  public String getCdStatus() {
    return this.cdStatus;
  }

  public void setCdStatus(String cdStatus) {
    this.cdStatus = cdStatus;
  }
  
  public String getNmPersonFull() {
    return this.nmPersonFull;
  }
  public String getCdPlacementType() {
    return this.cdPlacementType;
  }

  public void setCdPlacementType(String cdPlacementType) {
    this.cdPlacementType = cdPlacementType;
  }

  public void setNmPersonFull(String nmPersonFull) {
    this.nmPersonFull = nmPersonFull;
  }
    
  public String getCdPersonSex() {
    return this.cdPersonSex;
  }

  public void setCdPersonSex(String cdPersonSex) {
    this.cdPersonSex = cdPersonSex;
  }
  public String getNmEmployeeFull() {
    return this.nmEmployeeFull;
  }

  public void setNmEmployeeFull(String nmEmployeeFull) {
    this.nmEmployeeFull = nmEmployeeFull;
  }
 
}