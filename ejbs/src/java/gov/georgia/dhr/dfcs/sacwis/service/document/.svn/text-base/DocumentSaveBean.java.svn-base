package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoDataReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.document.BaseSaveAction;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentCheckStageDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentEventValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentInsertDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentSaveCheckEventStatusDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentSelectBlobDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentSelectDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageClosedException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentUpdateDao;
import gov.georgia.dhr.dfcs.sacwis.dao.document.InvalidDocumentStatusException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.NewUsingDocumentValueBean;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Column;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

/**
 * The DocumentSaveBean class is used to save documents to the IMPACT or MPS remote database.
 *
 * @author robertsw
 * @version 1.0
 *          <p/>
 *          Change History: Date       User       Description --------   ---------  ----------------------------------------------------
 *          06/16/05   dejuanar   Changed to impact where impactm (previous staging DB) 07/25/05   cooganpj   Added
 *          method saveIntakeReport
 *          06/05/2009  cwells    STGAP00013826 - allowing users to save Forms while stage is closed when it is a Contact event. 
 *          02/16/2010  mchillman Added code to check for SaveActionClass tag and if one execute the method
 */

public class DocumentSaveBean extends DocumentSaveBase {
  public NewUsingDocumentValueBean selectDocumentBlobMobile(DocumentMetaData documentMetaData)
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

  protected void verifyModifiableEvent(DocumentMetaData documentMetaData, Connection connection)
          throws SQLException, InvalidDocumentStatusException, ServiceException {
    DocumentSaveCheckEventStatusDao documentSaveCheckEventStatusDao;
    DocumentEventValueBean documentEventValueBean;
    // If the document is tied to an event verify the document is in a
    // modifiable state.

    if (documentMetaData.getTableMetaData() != null) {
      TableFields tableFields = documentMetaData.getTableMetaData().getTableFields();

      for (int x = 0; x < tableFields.getColumnCount(); x++) {
        Column column = tableFields.getColumn(x);
        String columnName = column.getName().toUpperCase();
        if ("ID_EVENT".equals(columnName)) {
          if (documentMetaData.getValidEventStatus() != null) {
            documentSaveCheckEventStatusDao = new DocumentSaveCheckEventStatusDao(connection);
            documentEventValueBean = documentSaveCheckEventStatusDao.checkEventStatus(documentMetaData);

            if (documentEventValueBean.getEventStatusCode() != null) {
              if (!documentMetaData.getIsInApproverMode()
                  && CodesTables.CEVTSTAT_PEND.equals(documentEventValueBean.getEventStatusCode())) {
                //Call Invalidate Approval
                GrndsTrace.msg(TRACE_TAG, 7, "Calling InvalidateApproval");
                ArchInputStruct archInputStruct = new ArchInputStruct();
                archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
                archInputStruct.setSzUserId("DOCARCH");
                CCMN05UI ccmn05ui = new CCMN05UI();
                ccmn05ui.setArchInputStruct(archInputStruct);
                ccmn05ui.setUlIdEvent(documentEventValueBean.getEventId());
                WtcHelper.callService("CCMN05US", ccmn05ui);
                GrndsTrace.msg(TRACE_TAG, 7, "Finished Calling InvalidateApproval");

                GrndsTrace.msg(TRACE_TAG, 7, "Setting up Post Event");
                CCMN01UI ccmn01ui = new CCMN01UI();
                ccmn01ui.setArchInputStruct(archInputStruct);

                ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
                rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(documentEventValueBean.getEventOccurred()));
                rowccmn01uig00.setSzCdEventStatus("COMP");
                rowccmn01uig00.setUlIdEvent(documentEventValueBean.getEventId());
                rowccmn01uig00.setUlIdPerson(documentEventValueBean.getPersonId());
                rowccmn01uig00.setUlIdStage(documentEventValueBean.getStageId());
                rowccmn01uig00.setSzCdEventType(documentEventValueBean.getEventTypeCode());
                rowccmn01uig00.setTsLastUpdate(documentEventValueBean.getDateLastUpdate());

                // This is an expensive trace message, so I'm commenting it out for now.
                //GrndsTrace.msg(TRACE_TAG, 7, documentEventValueBean.getDateLastUpdate().toString());
                rowccmn01uig00.setSzCdTask(documentEventValueBean.getTaskCode());
                rowccmn01uig00.setSzTxtEventDescr(documentEventValueBean.getEventDescription());

                ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
                WtcHelper.callService("CCMN01US", ccmn01ui);
                GrndsTrace.msg(TRACE_TAG, 7, "Finished calling Post Events");
              }
            }
          }
        }
      }
    }
  }

  public DocumentMetaData saveDocument(DocumentMetaData documentMetaData, byte[] documentData)
          throws SQLException, DocumentStageNotFoundException, DocumentStageClosedException, ServiceException,
                 InvalidDocumentStatusException, DuplicateRecordException, NoRowsUpdatedException,
                 NoDataReturnedException, TooManyRowsReturnedException, ParseException, ClassNotFoundException, 
                 IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

    GrndsTrace.enterScope(TRACE_TAG + ".saveDocument");
    DocumentInsertDao documentInsertDao;
    DocumentSelectDao documentSelectDao;
    DocumentUpdateDao documentUpdateDao;
    DocumentCheckStageDao documentCheckStageDao;
    Connection connection = null;

    try {
      List<String> contactTypes = new ArrayList<String>();
      contactTypes.add("CVISITN");
      contactTypes.add("BLANKNAR");
      contactTypes.add("SPWBNARR");
      
      connection = JdbcHelper.getConnection();
      String documentType = documentMetaData.getDocumentType().toUpperCase();
      
      
      // STGAP00013826 - allowing users to save Forms while stage is closed when it is a Contact event.
      //SMS#49018 - allow users to save Form while stage is closed when it is a ChildDeath (CNS)  event

      if (!(contactTypes.contains(documentType) || "CHILDDEATH".equals(documentType))&& documentMetaData.getCheckStage() != 0) {
        // Check to see if the stage is closed
        documentCheckStageDao = new DocumentCheckStageDao(connection);
        documentCheckStageDao.checkStage(documentMetaData);
      }

      verifyModifiableEvent(documentMetaData, connection);
      
      if (documentMetaData.getDocumentExists() || documentMetaData.getDocumentExists() != false) {
        // Update the record
        documentUpdateDao = new DocumentUpdateDao(connection);
        documentUpdateDao.updateDocument(documentMetaData, documentData);
      } else {
        // Insert the record
        documentInsertDao = new DocumentInsertDao(connection);
        documentInsertDao.insertDocument(documentMetaData, documentData);
      }
      
      //invoke the save action class is one is defined
      if(documentMetaData.getSaveActionClass() != null && documentMetaData.getSaveActionClass().length() > 0) {
        String actionClass = documentMetaData.getSaveActionClass().trim();
        Class saveActionClass = Class.forName(actionClass);
        Class[] args = {Connection.class};
        Constructor cons = saveActionClass.getConstructor(args);
        BaseSaveAction documentSaveAction = (BaseSaveAction) cons.newInstance(connection);
        documentSaveAction.execute(documentMetaData);
      }

      documentSelectDao = new DocumentSelectDao(connection);
      documentSelectDao.selectDocument(documentMetaData);
    }
    finally {
      cleanup(connection);
    }
    GrndsTrace.exitScope();
    return documentMetaData;
  }

  public DocumentMetaData saveDocumentToStaging(DocumentMetaData documentMetaData, byte[] documentData, int caseId)
          throws SQLException, DuplicateRecordException, NoRowsUpdatedException {

    GrndsTrace.enterScope(TRACE_TAG + ".saveDocumentToStaging");
    DocumentInsertDao documentInsertDao;
    Connection connection = null;
    documentMetaData.setLegacy(false);
    try {
      connection = JdbcHelper.getConnection();
      if (connection == null) {
        throw new NullPointerException("<<< Mobile Connection Null !!! >>>");
      }

      if (documentMetaData.getTableMetaData() != null) {
        TableFields tableFields = documentMetaData.getTableMetaData().getTableFields();

        for (int x = 0; x < tableFields.getColumnCount(); x++) {
          Column column = tableFields.getColumn(x);
          String columnName = column.getName().toUpperCase();

          if ("ID_CASE".equalsIgnoreCase(columnName)) {
            column.setContent(String.valueOf(caseId));
          }
        }//end for
        documentMetaData.setDocumentExists(false);
        documentMetaData.setActualTemplateVersion(370);
        documentMetaData.getTableMetaData().setTableFields(tableFields);
        // Insert the record
        documentInsertDao = new DocumentInsertDao(connection);
        documentInsertDao.insertDocument(documentMetaData, documentData);
      }//end if
    }
    finally {
      cleanup(connection);
    }
    GrndsTrace.exitScope();
    return documentMetaData;
  }

  /**
   * Method saveIntakeReport is called to save the pregenerated intake report to the MPS remote db.
   *
   * @param documentMetaData
   * @param documentData
   * @param caseId
   * @return
   * @throws SQLException
   * @throws DuplicateRecordException
   * @throws gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException
   */

  public DocumentMetaData saveIntakeReport(DocumentMetaData documentMetaData, byte[] documentData, int caseId)
          throws SQLException, DuplicateRecordException, NoRowsUpdatedException {

    GrndsTrace.enterScope(TRACE_TAG + ".saveIntakeReport");
    DocumentInsertDao documentInsertDao;
    Connection connection = null;
    documentMetaData.setLegacy(false);
    try {
      connection = JdbcHelper.getConnection();
      if (connection == null) {
        throw new NullPointerException("<<< Mobile Connection Null !!! >>>");
      }

      if (documentMetaData.getTableMetaData() != null) {
        TableFields tableFields = documentMetaData.getTableMetaData().getTableFields();

        for (int x = 0; x < tableFields.getColumnCount(); x++) {
          Column column = tableFields.getColumn(x);
          String columnName = column.getName().toUpperCase();

          if ("ID_CASE".equalsIgnoreCase(columnName)) {
            column.setContent(String.valueOf(caseId));
          }
        }//end for
        documentMetaData.setDocumentExists(false);
        documentMetaData.setActualTemplateVersion(370);
        documentMetaData.getTableMetaData().setTableFields(tableFields);
        // Insert the record
        documentInsertDao = new DocumentInsertDao(connection);
        documentInsertDao.insertDocument(documentMetaData, documentData);
      }//end if
    }
    finally {
      cleanup(connection);
    }
    GrndsTrace.exitScope();
    return documentMetaData;
  }

  public DocumentMetaData getTimestampMobile(DocumentMetaData documentMetaData)
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

  private static final String TRACE_TAG = "DocumentSaveBean";
}
