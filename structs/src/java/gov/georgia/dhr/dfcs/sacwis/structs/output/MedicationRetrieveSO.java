/**
 *
 */
package gov.georgia.dhr.dfcs.sacwis.structs.output;

import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonMedicationList;

import java.io.Serializable;

import java.util.List;

@SuppressWarnings("serial")
public class MedicationRetrieveSO implements Serializable {

  private int ulIdPerson;
  private int ulIdMedication;
  private PersonMedicationList pmBean;
  private List<PersonMedicationList> pmBeanList;

  public int getUlIdPerson() {
    return ulIdPerson;
  }

  public void setUlIdPerson(int ulIdPerson) {
    this.ulIdPerson = ulIdPerson;
  }

  public int getUlIdMedication() {
    return ulIdMedication;
  }

  public void setUlIdMedication(int ulIdMedication) {
    this.ulIdMedication = ulIdMedication;
  }

  public PersonMedicationList getPmBean() {
    return pmBean;
  }

  public void setPmList(PersonMedicationList pmBean) {
    this.pmBean = pmBean;
  }

  public List<PersonMedicationList> getPmBeanList() {
    return pmBeanList;
  }

  public void setPmBeanList(List<PersonMedicationList> pmBeanList) {
    this.pmBeanList = pmBeanList;
  }
}
