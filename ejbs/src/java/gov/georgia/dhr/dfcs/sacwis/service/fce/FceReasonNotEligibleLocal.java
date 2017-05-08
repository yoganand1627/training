//DO NOT MAKE ANY CHANGES TO THIS FILE
//IT IS GENERATED
//see Matthew McClain (PRSmmcclain) if a change needs to be made

package gov.georgia.dhr.dfcs.sacwis.service.fce;


import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReasonNotEligibleDB;

import javax.ejb.EJBLocalObject;
import java.util.Date;


public interface FceReasonNotEligibleLocal extends EJBLocalObject {
  public void save(FceReasonNotEligibleDB fceReasonNotEligibleDB)
          throws EjbValidationException;


  public void saveNoTimestampCheck(FceReasonNotEligibleDB fceReasonNotEligibleDB);


  public void copyInto(FceReasonNotEligibleDB fceReasonNotEligibleDB);


  public String getCdReasonNotEligible();


  public void setCdReasonNotEligible(String cdReasonNotEligible);


  public Date getDtLastUpdate();


  public void setDtLastUpdate(Date dtLastUpdate);


  public Long getIdFceEligibility();


  public void setIdFceEligibility(Long idFceEligibility);


  public Long getIdFceReasonNotEligible();


  public void setIdFceReasonNotEligible(Long idFceReasonNotEligible);
}
