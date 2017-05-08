//DO NOT MAKE ANY CHANGES TO THIS FILE
//IT IS GENERATED
//see Matthew McClain (PRSmmcclain) if a change needs to be made

package gov.georgia.dhr.dfcs.sacwis.service.fce;


import java.sql.Connection;

import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;


public interface FcePersonHomeLocal extends EJBLocalHome {
  public FcePersonLocal findByPrimaryKey(Long key)
          throws FinderException;


  public FcePersonLocal create(FcePersonDB fcePersonDB, Connection connection)
          throws CreateException;


  //!!! add to generated code
  public FcePersonLocal findByIdFceEligibilityAndIdPerson(long idFceEligibility,
                                                          long idPerson)
          throws FinderException;
}
