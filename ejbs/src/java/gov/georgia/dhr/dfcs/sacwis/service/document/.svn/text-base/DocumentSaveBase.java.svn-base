/**
 * Created on May 4, 2005 at 2:44:36 PM
 * 
 * Created by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.document;

import org.grnds.facility.log.GrndsTrace;
import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoDataReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentCheckStageDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentDeleteDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentSelectBlobDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentSelectDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageClosedException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.NewUsingDocumentValueBean;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public abstract class DocumentSaveBase extends BaseServiceEjb {
  public NewUsingDocumentValueBean selectDocumentBlob(DocumentMetaData documentMetaData)
          throws TooManyRowsReturnedException, NoDataReturnedException, SQLException, IOException {

    GrndsTrace.enterScope(TRACE_TAG + ".selectBlob");
    DocumentSelectBlobDao selectBlob;
    Connection connection = null;
    NewUsingDocumentValueBean newUsingDocumentValueBean = null;

    try {
      connection = JdbcHelper.getConnection();
      selectBlob = new DocumentSelectBlobDao(connection);
      newUsingDocumentValueBean = selectBlob.selectBlobDocument(documentMetaData);
    }
    finally {
      cleanup(connection);
    }

    GrndsTrace.exitScope();
    return newUsingDocumentValueBean;
  }

  public void deleteDocument(DocumentMetaData documentMetaData)
          throws SQLException, DocumentStageNotFoundException, DocumentStageClosedException, DuplicateRecordException,
                 NoRowsUpdatedException {
    DocumentDeleteDao documentDeleteDao;
    DocumentCheckStageDao documentCheckStageDao;
    Connection connection = null;

    try {
      connection = JdbcHelper.getConnection();

      if (documentMetaData.getCheckStage() != 0) {
        // Check to see if the stage is closed
        // wil thorw excpetion if there is problem.
        documentCheckStageDao = new DocumentCheckStageDao(connection);
        documentCheckStageDao.checkStage(documentMetaData);
      }

      documentDeleteDao = new DocumentDeleteDao(connection);
      documentDeleteDao.deleteDocument(documentMetaData);
    }
    finally {
      cleanup(connection);
    }
  }

  public DocumentMetaData getTimestamp(DocumentMetaData documentMetaData)
          throws SQLException, NoDataReturnedException, TooManyRowsReturnedException, ParseException {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "getTimestamp");
    performanceTrace.enterScope();

    Connection connection = null;
    DocumentSelectDao documentSelectDao;
    try {
      connection = JdbcHelper.getConnection();
      documentSelectDao = new DocumentSelectDao(connection);
      documentSelectDao.selectDocument(documentMetaData);
    }
    finally {
      cleanup(connection);
    }
    performanceTrace.exitScope();
    return documentMetaData;
  }


  public static final String TRACE_TAG = "DocumentSaveBase";
}
