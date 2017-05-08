package gov.georgia.dhr.dfcs.sacwis.service.common;


import org.grnds.facility.log.GrndsTrace;
import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.AddressDao;
import gov.georgia.dhr.dfcs.sacwis.dao.person.AddressValueBean;

import java.sql.Connection;


/**
 * Used to handle adddress
 */
public class AddressListBean extends BaseServiceEjb {
  public static final String TRACE_TAG = "AddressListBean";


  /* Retrieve the addresses  */
  public AddressValueBean getActiveAddressForStage(AddressValueBean searchBean) {
    GrndsTrace.enterScope(TRACE_TAG + ".getActiveAddressForStage function");

    Connection connection = null;

    try {
      connection = JdbcHelper.getConnection();

      AddressDao addressDao = new AddressDao(connection);
      return addressDao.getActiveAddressForStage(searchBean);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    }
    finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
  }
}
