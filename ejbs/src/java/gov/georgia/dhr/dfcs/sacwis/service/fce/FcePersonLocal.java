//DO NOT MAKE ANY CHANGES TO THIS FILE
//IT IS GENERATED
//see Matthew McClain (PRSmmcclain) if a change needs to be made

package gov.georgia.dhr.dfcs.sacwis.service.fce;


import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;

import javax.ejb.EJBLocalObject;
import java.util.Date;


public interface FcePersonLocal extends EJBLocalObject {
  public void save(FcePersonDB fcePersonDB)
          throws EjbValidationException;


  public void saveNoTimestampCheck(FcePersonDB fcePersonDB);


  public void copyInto(FcePersonDB fcePersonDB);


  public String getCdRelInt();


  public void setCdRelInt(String cdRelInt);


  public Date getDtBirth();


  public void setDtBirth(Date dtBirth);


  public Date getDtLastUpdate();


  public void setDtLastUpdate(Date dtLastUpdate);


  public Long getIdFceEligibility();


  public void setIdFceEligibility(Long idFceEligibility);


  public Long getIdFcePerson();


  public void setIdFcePerson(Long idFcePerson);


  public Long getIdPerson();


  public void setIdPerson(Long idPerson);


  public String getIndCertifiedGroup();


  public void setIndCertifiedGroup(String indCertifiedGroup);


  public String getIndDobApprox();


  public void setIndDobApprox(String indDobApprox);


  public String getIndPersonHmRemoval();


  public void setIndPersonHmRemoval(String indPersonHmRemoval);


  public Long getNbrAge();


  public void setNbrAge(Long nbrAge);
}
