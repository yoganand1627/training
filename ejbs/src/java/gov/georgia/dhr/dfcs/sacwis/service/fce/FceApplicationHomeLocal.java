//DO NOT MAKE ANY CHANGES TO THIS FILE
//IT IS GENERATED
//see Matthew McClain (PRSmmcclain) if a change needs to be made

package gov.georgia.dhr.dfcs.sacwis.service.fce;


import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.service.fce.FceApplicationLocal;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.sql.Connection;


public interface FceApplicationHomeLocal extends EJBLocalHome {
  public FceApplicationLocal findByPrimaryKey(Long key)
          throws FinderException;


  public FceApplicationLocal create(FceApplicationDB fceApplicationDB,Connection connection)
          throws CreateException;


  //!!! add to generated code
  public FceApplicationLocal findByApplicationEventId(long idEvent)
          throws FinderException;
}
