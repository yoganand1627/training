//DO NOT MAKE ANY CHANGES TO THIS FILE
//IT IS GENERATED
//see Matthew McClain (PRSmmcclain) if a change needs to be made

package gov.georgia.dhr.dfcs.sacwis.service.fce;


import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReasonNotEligibleDB;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;


public interface FceReasonNotEligibleHomeLocal extends EJBLocalHome {
  public FceReasonNotEligibleLocal findByPrimaryKey(Long key)
          throws FinderException;


  public FceReasonNotEligibleLocal create(FceReasonNotEligibleDB fceReasonNotEligibleDB)
          throws CreateException;
}
