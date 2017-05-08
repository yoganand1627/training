package gov.georgia.dhr.dfcs.sacwis.web.document;

import java.io.StringReader;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoDataReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageClosedException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.DocumentStageNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Column;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.TableFields;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.ExceptionHandler;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import org.exolab.castor.xml.Unmarshaller;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */
public class DocumentUtilityHelpers {
  public static DocumentMetaData completeDocumentMetaData(DocumentSave documentSave, HttpServletRequest request,
                                                          DocumentMetaData documentMetaData)
          throws SQLException, ParseException, RemoteException, TooManyRowsReturnedException,
                 DocumentStageClosedException, DuplicateRecordException, NoRowsUpdatedException,
                 DocumentStageNotFoundException {
    return completeDocumentMetaData(documentSave, request, documentMetaData, true);
  }

  public static DocumentMetaData completeDocumentMetaData(DocumentSave documentSave, HttpServletRequest request,
                                                          DocumentMetaData documentMetaData, boolean cfpRequest)
          throws SQLException, ParseException, RemoteException, TooManyRowsReturnedException,
                 DocumentStageClosedException, NoRowsUpdatedException, DuplicateRecordException,
                 DocumentStageNotFoundException {

    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentUtilityHelpers", "completeDocumentMetaData");
    performanceTrace.enterScope();

    boolean indTimestamp = false;

    if (request.getAttribute("docExists") != null) {
      GrndsTrace.msg(TRACE_TAG, 7, "Inside first If");
      if ("true".equals(String.valueOf(request.getAttribute("docExists")))) {
        GrndsTrace.msg(TRACE_TAG, 7, "Inside second If");
        documentMetaData.setDocumentExists(true);
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Inside second if else");
        documentMetaData.setDocumentExists(false);
      }
    } else {
      GrndsTrace.msg(TRACE_TAG, 7, "Didn't find docExists attribute.");
      documentMetaData.setDocumentExists(false);
    }

    if (request.getAttribute("renderFormat") != null) {
      GrndsTrace.msg(TRACE_TAG, 7, "Found render format");
      documentMetaData.setRenderFormat((RenderType.valueOf((String) request.getAttribute("renderFormat"))));
    }
    
    if (request.getAttribute("userName") != null) {
        GrndsTrace.msg(TRACE_TAG, 7, "Found render format");
        documentMetaData.setUserName(ContextHelper.getStringSafe(request, "userName"));
      }

    if (request.getAttribute("checkStage") != null) {
      GrndsTrace.msg(TRACE_TAG, 7, "Found check stage");
      String tempString = (String) request.getAttribute("checkStage");
      if (!"".equals(tempString)) {
        int tempInt = Integer.parseInt((String) request.getAttribute("checkStage"));
        documentMetaData.setCheckStage(tempInt);
      }
      GrndsTrace.msg(TRACE_TAG, 7, "End set check stage");
    }

    if (!cfpRequest) {
      if (GlobalData.getApprovalFlag(request) != null) {
        if (GlobalData.getApprovalFlag(request).equals(ArchitectureConstants.Y)) {
          documentMetaData.setIsInApproverMode(true);
        } else {
          documentMetaData.setIsInApproverMode(false);
        }
      } else {
        documentMetaData.setIsInApproverMode(false);
      }
    }

    if (documentMetaData.getTableMetaData() != null) {
      GrndsTrace.msg(TRACE_TAG, 7, "Inside the if statement");
      TableFields tableFields = documentMetaData.getTableMetaData().getTableFields();
      GrndsTrace.msg(TRACE_TAG, 7, "Entering the for loop");
      for (int x = 0; x < tableFields.getColumnCount(); x++) {
        Column column = tableFields.getColumn(x);
        if ("STIMESTAMP".equals(column.getRequestName().toUpperCase())) {
          indTimestamp = true;
        }

        if (request.getAttribute(column.getRequestName()) != null) {
          String requestAtt = (String) request.getAttribute(column.getRequestName());
          column.setContent(requestAtt);
        }
      }
      documentMetaData.getTableMetaData().setTableFields(tableFields);

      //Get the timestamp for the document
    }

    if (indTimestamp && !cfpRequest) {
      try {
        if ("true".equals(request.getAttribute("deleteDocument"))) {
          documentSave.deleteDocument(documentMetaData);
          documentMetaData.setDocumentExists(false);
        } else // get new timestamp
        {
          documentMetaData = documentSave.getTimestamp(documentMetaData);
          GrndsTrace.msg(TRACE_TAG, 7, "Value of metadata:" + documentMetaData);
          documentMetaData.setDocumentExists(true);
        }
      }
      catch (NoDataReturnedException ne) {
        GrndsTrace.msg(TRACE_TAG, 7, "No timestamp found for document");
        documentMetaData.setDocumentExists(false);
      }
    }

    //Check to verify document requested has docexists set correctly
    //if there  isn't tablemetadata the document cannot exist on the DB.
    if (documentMetaData.getTableMetaData() == null) {
      documentMetaData.setDocumentExists(false);
    }

    performanceTrace.exitScope();
    return documentMetaData;
  }

  public static DocumentMetaData completeNewUsingDocumentMetaData(HttpServletRequest request,
                                                                  DocumentMetaData documentMetaData) {
    GrndsTrace.enterScope(TRACE_TAG + ".completeNewUsingDocumentMetaData");

    if (documentMetaData.getTableMetaData() != null) {
      GrndsTrace.msg(TRACE_TAG, 7, "Inside the if statement");
      TableFields tableFields = documentMetaData.getTableMetaData().getTableFields();
      GrndsTrace.msg(TRACE_TAG, 7, "Entering the for loop");
      for (int x = 0; x < tableFields.getColumnCount(); x++) {
        Column column = tableFields.getColumn(x);
        if (!"DT_LAST_UPDATE".equals(column.getName())) {
          StringBuffer buildNewUseName = new StringBuffer("n");
          buildNewUseName.append(column.getRequestName().substring(1));

          String newUsingRequestName = buildNewUseName.toString();
          GrndsTrace.msg(TRACE_TAG, 7, "newUsingRequestName:" + newUsingRequestName);
          if (request.getAttribute(newUsingRequestName) != null) {
            String requestAtt = (String) request.getAttribute(newUsingRequestName);
            column.setContent(requestAtt);
          }
        }
      }
      documentMetaData.getTableMetaData().setTableFields(tableFields);
    }

    GrndsTrace.exitScope();
    return documentMetaData;

  }

  public static void changeParameterstoAttributes(HttpServletRequest request) {
    GrndsTrace.enterScope(TRACE_TAG + ".changeParameterstoAttributes");
    for (Enumeration en = request.getParameterNames(); en.hasMoreElements();) {
      String paramName = (String) en.nextElement();
      GrndsTrace.msg(TRACE_TAG, 7, "Parameter is:" + paramName);
      String paramValue = request.getParameter(paramName);
      GrndsTrace.msg(TRACE_TAG, 7, "Parameter value is:" + paramValue);
      if (request.getAttribute(paramName) == null) {
        GrndsTrace.msg(TRACE_TAG, 7, "Using parameter");
        request.setAttribute(paramName, paramValue);
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Using attribute value");
      }
    }
    GrndsTrace.exitScope();
  }

  public static String getErrorMessageName(String faultCode) {
    GrndsTrace.msg(TRACE_TAG, 7, "Value of SOAP Fault Code:" + faultCode);
    String errorMessageName = null;
    int x = faultCode.lastIndexOf(".");
    if (x != -1) {
      errorMessageName = faultCode.substring(x + 1, faultCode.length());
    }
    //Double check that this is really an expected error
    x = errorMessageName != null ? errorMessageName.lastIndexOf("ARC_") : -1;
    if (x == -1) {
      errorMessageName = null;
    }
    return errorMessageName;
  }

  public static Date getDocumentTsLastUpdate(DocumentSave documentSave, String documentType, int ulIdCase,
                                             int ulIdEvent) {
    Date date = null;
    try {
      StringReader docReader = new StringReader(DocumentLookup.lookup(documentType));
      DocumentMetaData docMetaData = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, docReader);
      TableFields tableFields = docMetaData.getTableMetaData().getTableFields();
      for (int x = 0; x < tableFields.getColumnCount(); x++) {
        Column column = tableFields.getColumn(x);
        if ("id_case".equals(column.getName())) {
          column.setContent(String.valueOf(ulIdCase));
        }
        if ("id_event".equals(column.getName())) {
          column.setContent(String.valueOf(ulIdEvent));
        }
      }
      docMetaData.getTableMetaData().setTableFields(tableFields);
      docMetaData = documentSave.getTimestamp(docMetaData);
      Column[] columns = docMetaData.getTableMetaData().getTableFields().getColumn();
      for (int i = 0; i < columns.length; i++) {
        Column column = columns[i];
        if ("dt_last_update".equals(column.getName())) {
          String content = column.getContent();
          // Explicit null check because SimpleDateFormat.parse() can thrown an NPE for null inputs.
          if (content != null) {
            date = new SimpleDateFormat(DOCUMENT_TS_DATE_FORMAT).parse(content);
          }
          break;
        }
      }
    }
    catch (Exception e) {
      // Log errors and return null.
      ExceptionHandler.handle(e);
    }
    return date;
  }

  /**
   * SIR 23379 -- Added getRecordDocumentTsLastUpdate method for narrative existance check,which don't uses event id and
   * case id in narrative table.
   *
   * @param documentType
   * @param idRecCheck
   * @return Date
   */

  public static Date getRecordDocumentTsLastUpdate(DocumentSave documentSave, String documentType, int idRecCheck) {
    Date date = null;
    try {
      StringReader docReader = new StringReader(DocumentLookup.lookup(documentType));
      DocumentMetaData docMetaData = (DocumentMetaData) Unmarshaller.unmarshal(
              DocumentMetaData.class, docReader);
      TableFields tableFields = docMetaData.getTableMetaData().getTableFields();
      for (int x = 0; x < tableFields.getColumnCount(); x++) {
        Column column = tableFields.getColumn(x);
        if ("id_rec_check".equals(column.getName())) {
          column.setContent(String.valueOf(idRecCheck));
        }
      }
      docMetaData.getTableMetaData().setTableFields(tableFields);
      docMetaData = documentSave.getTimestamp(docMetaData);
      Column[] columns = docMetaData.getTableMetaData().getTableFields().
              getColumn();
      for (int i = 0; i < columns.length; i++) {
        Column column = columns[i];
        if ("dt_last_update".equals(column.getName())) {
          String content = column.getContent();
          // Explicit null check because SimpleDateFormat.parse() can thrown an NPE for null inputs.
          if (content != null) {
            date = new SimpleDateFormat(DOCUMENT_TS_DATE_FORMAT).parse(content);
          }
          break;
        }
      }
    }
    catch (Exception e) {
      // Log errors and return null.
      ExceptionHandler.handle(e);
    }
    return date;
  }

  private static final String TRACE_TAG = "DocumentUtilityHelpers";
  private static final String DOCUMENT_TS_DATE_FORMAT = "M/d/yyyy H:m:s";
}
