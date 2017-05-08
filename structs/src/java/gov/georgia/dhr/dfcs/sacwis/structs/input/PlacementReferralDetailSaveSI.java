package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;


public class PlacementReferralDetailSaveSI implements Serializable {
  private ArchInputStruct archInputStruct = null;
  private Integer idPlacementReferral;
  private String cdPlacementType;
  private Date dtBegin;
  private Date dtExpiration;
  private String nmPersonFull;
  private Integer idPerson;
  private Integer idResource;
  private Integer idEmployee;
  private String cdStatus;
  
  public PlacementReferralDetailSaveSI() {
    this.archInputStruct = null;
    this.cdPlacementType = "";
    this.dtBegin = null;
    this.dtExpiration = null;
    this.idPerson = 0;
    this.nmPersonFull = "";
    
  }
  public ArchInputStruct getArchInputStruct() {
    return this.archInputStruct;
  }

  public void setArchInputStruct(ArchInputStruct archInputStruct) {
    this.archInputStruct = archInputStruct;
  }
  
  public Integer getIdPlacementReferral() {
    return this.idPlacementReferral;
  }

  public void setIdPlacementReferral(int idPlacementReferral) {
    this.idPlacementReferral = idPlacementReferral;
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
  
  public String getNmPersonFull() {
    return this.nmPersonFull;
  }
  
  public void setNmPersonFull(String nmPersonFull) {
    this.nmPersonFull = nmPersonFull;
  }
  public String getCdPlacementType() {
    return this.cdPlacementType;
  }

  public void setCdPlacementType(String cdPlacementType) {
    this.cdPlacementType = cdPlacementType;
  }
  
  public String getCdStatus() {
    return this.cdStatus;
  }

  public void setCdStatus(String cdStatus) {
    this.cdStatus = cdStatus;
  }

}