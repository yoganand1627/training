//DO NOT MAKE ANY CHANGES TO THIS FILE
//IT IS GENERATED
//see Matthew McClain (PRSmmcclain) if a change needs to be made

package gov.georgia.dhr.dfcs.sacwis.service.fce;


import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;


public interface FceReviewHomeLocal extends EJBLocalHome {
  public FceReviewLocal findByPrimaryKey(Long key)
          throws FinderException;


  public FceReviewLocal create(FceReviewDB fceReviewDB)
          throws CreateException;


  //!!! add to generated code
  public FceReviewLocal findByReviewEventId(long idEvent)
          throws FinderException;
}
