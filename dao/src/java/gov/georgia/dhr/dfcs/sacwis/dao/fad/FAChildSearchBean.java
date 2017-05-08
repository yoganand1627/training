package gov.georgia.dhr.dfcs.sacwis.dao.fad;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.BasePaginationValueBean;

import java.sql.Date;
import java.util.List;

/**
 * <pre>
 * Change History:
 * Date      User      Sir#           Description
 * --------  ----------------  --------------------------------------------------
 *           cwells            Initial Creation
 * 11/06/11  htvo              STGAP00017459 retrieve person first, last name and suffix instead of full name for child search          
 * </pre>
 */

@SuppressWarnings("serial")
public class FAChildSearchBean extends BasePaginationValueBean {

  private String cdPersonSuffix = null;

  private String nmPersonFirst = null;

  private String nmPersonLast = null;

  private String ethnicity = null;

  private String gender = null;

  private String indPrevAdopt = null;

  private String indAdptDis = null;

  private List<String> races = null;

  private Date dtDob = null;

  private int idPerson = 0;

  private List resourceCharacteristics = null;

  public FAChildSearchBean() {
  }

  /**
   * Constructor that build the bean from homeResourceId * @param homeResourceId an int
   */
  public FAChildSearchBean(int idPerson) {
    this.setIdPerson(idPerson);
  }

  public void setRaces(List<String> races) {
    this.races = races;
  }

  public List<String> getRaces() {
    return races;
  }

  public void setIndPrevAdopt(String indPrevAdopt) {
    this.indPrevAdopt = indPrevAdopt;
  }

  public String getCdPersonSuffix() {
    return cdPersonSuffix;
  }

  public void setCdPersonSuffix(String cdPersonSuffix) {
    this.cdPersonSuffix = cdPersonSuffix;
  }

  public String getIndPrevAdopt() {
    return indPrevAdopt;
  }

  public void setIndAdptDis(String indAdptDis) {
    this.indAdptDis = indAdptDis;
  }

  public String getIndAdptDis() {
    return indAdptDis;
  }

  public void setDob(Date dtDob) {
    this.dtDob = dtDob;
  }

  public Date getDob() {
    return dtDob;
  }

  public String getNmPersonFirst() {
    return nmPersonFirst;
  }

  public void setNmPersonFirst(String nmPersonFirst) {
    this.nmPersonFirst = nmPersonFirst;
  }

  public String getNmPersonLast() {
    return nmPersonLast;
  }

  public void setNmPersonLast(String nmPersonLast) {
    this.nmPersonLast = nmPersonLast;
  }

  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }

  public int getIdPerson() {
    return idPerson;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getGender() {
    return gender;
  }

  public String getEthnicity() {
    return ethnicity;
  }

  public void setEthnicity(String ethnicity) {
    this.ethnicity = ethnicity;
  }

  public List getResourceCharacteristics() {
    return resourceCharacteristics;
  }

  public void setResourceCharacteristics(List resourceCharacteristics) {
    this.resourceCharacteristics = resourceCharacteristics;
  }

}
