package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoDataReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageClosedException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.InvalidDocumentStatusException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.NewUsingDocumentValueBean;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public interface DocumentSave {

  public NewUsingDocumentValueBean selectDocumentBlob(DocumentMetaData documentMetaData)
          throws TooManyRowsReturnedException, NoDataReturnedException, SQLException, IOException;

  public NewUsingDocumentValueBean selectDocumentBlobMobile(DocumentMetaData documentMetaData)
          throws TooManyRowsReturnedException, NoDataReturnedException, SQLException, IOException;

  public DocumentMetaData saveDocument(DocumentMetaData documentMetaData, byte[] documentData)
          throws SQLException, DocumentStageNotFoundException, DocumentStageClosedException, ParseException,
                 InvalidDocumentStatusException, DuplicateRecordException, NoRowsUpdatedException,
                 NoDataReturnedException, TooManyRowsReturnedException;

  public DocumentMetaData saveDocumentToStaging(DocumentMetaData documentMetaData, byte[] documentData, int caseId)
          throws SQLException, DuplicateRecordException, NoRowsUpdatedException;

  public DocumentMetaData saveIntakeReport(DocumentMetaData documentMetaData, byte[] documentData, int caseId)
          throws SQLException, DuplicateRecordException, NoRowsUpdatedException;

  public void deleteDocument(DocumentMetaData documentMetaData)
          throws SQLException, DocumentStageNotFoundException, DocumentStageClosedException, DuplicateRecordException,
                 NoRowsUpdatedException;

  public DocumentMetaData getTimestamp(DocumentMetaData documentMetaData)
          throws SQLException, NoDataReturnedException, TooManyRowsReturnedException, ParseException;

  public DocumentMetaData getTimestampMobile(DocumentMetaData documentMetaData)
          throws SQLException, NoDataReturnedException, TooManyRowsReturnedException, ParseException;

}