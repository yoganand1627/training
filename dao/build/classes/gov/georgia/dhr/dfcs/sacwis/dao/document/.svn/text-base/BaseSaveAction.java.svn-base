package gov.georgia.dhr.dfcs.sacwis.dao.document;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class BaseSaveAction extends BaseDao {

  public BaseSaveAction(Connection connection) {
    super(connection);
  }
  
  public abstract void execute(DocumentMetaData documentMetaData) throws SQLException, NoRowsUpdatedException, DuplicateRecordException;

}
