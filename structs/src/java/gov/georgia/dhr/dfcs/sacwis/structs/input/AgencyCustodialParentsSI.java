/**
 * Created on May 7, 2007 at 2:27:44 PM by Kapil Aggarwal - SACWIS Atlanta
 */
package gov.georgia.dhr.dfcs.sacwis.structs.input;


import java.io.Serializable;


@SuppressWarnings("serial")
public class AgencyCustodialParentsSI implements Serializable {
  
  private Integer idAgencyCustodialParents;
  private String cdCounty;
  private String nmPersonLast;
  private String nmPersonFirst;
  private String nmPersonMiddle;
  private String cdPersonSex;
  private String cdEthnicity;
  private String cdRace;
  private String idInitiator;
  private Integer nbrCrsId;
  private Integer nbrNcpCrsId;
  private String  szBlnNtvAmerican; //  1 Y or N 
  private String  szBlnAsian;       //  1 Y or N 
  private String  szBlnAfAmerican;  //  1 Y or N 
  private String  szBlnPcfcislander;//  1 Y or N 
  private String  szBlnWhite;       //  1 Y or N 
  
  public String getSzBlnAfAmerican() {
    return szBlnAfAmerican;
  }
  public void setSzBlnAfAmerican(String szBlnAfAmerican) {
    this.szBlnAfAmerican = szBlnAfAmerican;
  }
  public String getSzBlnAsian() {
    return szBlnAsian;
  }
  public void setSzBlnAsian(String szBlnAsian) {
    this.szBlnAsian = szBlnAsian;
  }
  public String getSzBlnNtvAmerican() {
    return szBlnNtvAmerican;
  }
  public void setSzBlnNtvAmerican(String szBlnNtvAmerican) {
    this.szBlnNtvAmerican = szBlnNtvAmerican;
  }
  public String getSzBlnPcfcislander() {
    return szBlnPcfcislander;
  }
  public void setSzBlnPcfcislander(String szBlnPcfcislander) {
    this.szBlnPcfcislander = szBlnPcfcislander;
  }
  public String getSzBlnWhite() {
    return szBlnWhite;
  }
  public void setSzBlnWhite(String szBlnWhite) {
    this.szBlnWhite = szBlnWhite;
  }
  public void setIdAgencyCustodialParents(Integer idAgencyCustodialParents) {
    this.idAgencyCustodialParents = idAgencyCustodialParents;
  }
  /**
   * @return the idAgencyCustodialParents
   */
  public Integer getIdAgencyCustodialParents() {
    return idAgencyCustodialParents;
  }
  /**
   * @return the cdCounty
   */
  public String getCdCounty() {
    return cdCounty;
  }
  /**
   * @param cdCounty the cdCounty to set
   */
  public void setCdCounty(String cdCounty) {
    this.cdCounty = cdCounty;
  }
  /**
   * @return the cdEthnicity
   */
  public String getCdEthnicity() {
    return cdEthnicity;
  }
  /**
   * @param cdEthnicity the cdEthnicity to set
   */
  public void setCdEthnicity(String cdEthnicity) {
    this.cdEthnicity = cdEthnicity;
  }
  /**
   * @return the cdPersonSex
   */
  public String getCdPersonSex() {
    return cdPersonSex;
  }
  /**
   * @param cdPersonSex the cdPersonSex to set
   */
  public void setCdPersonSex(String cdPersonSex) {
    this.cdPersonSex = cdPersonSex;
  }
  /**
   * @return the cdRace
   */
  public String getCdRace() {
    return cdRace;
  }
  /**
   * @param cdRace the cdRace to set
   */
  public void setCdRace(String cdRace) {
    this.cdRace = cdRace;
  }
  /**
   * @return the nbrCrsId
   */
  public Integer getNbrCrsId() {
    return nbrCrsId;
  }
  /**
   * @param nbrCrsId the nbrCrsId to set
   */
  public void setNbrCrsId(Integer nbrCrsId) {
    this.nbrCrsId = nbrCrsId;
  }
  /**
   * @return the nbrNcpCrsId
   */
  public Integer getNbrNcpCrsId() {
    return nbrNcpCrsId;
  }
  /**
   * @param nbrNcpCrsId the nbrNcpCrsId to set
   */
  public void setNbrNcpCrsId(Integer nbrNcpCrsId) {
    this.nbrNcpCrsId = nbrNcpCrsId;
  }
  /**
   * @return the nmPersonFirst
   */
  public String getNmPersonFirst() {
    return nmPersonFirst;
  }
  /**
   * @param nmPersonFirst the nmPersonFirst to set
   */
  public void setNmPersonFirst(String nmPersonFirst) {
    this.nmPersonFirst = nmPersonFirst;
  }
  /**
   * @return the nmPersonLast
   */
  public String getNmPersonLast() {
    return nmPersonLast;
  }
  /**
   * @param nmPersonLast the nmPersonLast to set
   */
  public void setNmPersonLast(String nmPersonLast) {
    this.nmPersonLast = nmPersonLast;
  }
  /**
   * @return the nmPersonMiddle
   */
  public String getNmPersonMiddle() {
    return nmPersonMiddle;
  }
  /**
   * @param nmPersonMiddle the nmPersonMiddle to set
   */
  public void setNmPersonMiddle(String nmPersonMiddle) {
    this.nmPersonMiddle = nmPersonMiddle;
  }
  /**
   * @return the idInitiator
   */
  public String getIdInitiator() {
    return idInitiator;
  }
  /**
   * @param idInitiator the idInitiator to set
   */
  public void setIdInitiator(String idInitiator) {
    this.idInitiator = idInitiator;
  }


}
