package gov.georgia.dhr.dfcs.sacwis.web.document;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.document.NewUsingDocumentValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Column;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.ColumnType;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

public class DocumentTestConversation extends BaseHiddenFieldStateConversation {

  private static final String TRACE_TAG = "DocumentTestConversation";

  private DocumentSave documentSave;

  public void setDocumentSave(DocumentSave documentSave) {
    this.documentSave = documentSave;
  }

  public void displayDocumentForm_xa(GrndsExchangeContext context) {

    GrndsTrace.enterScope(TRACE_TAG + ".displayDocumentForm_xa");
    HttpServletRequest request = context.getRequest();
    String docType;
    String docMetaData = null;
    DocumentMetaData documentMetaData = null;
    GrndsTrace.msg(TRACE_TAG, 7, "Variables are set");
    if (request.getParameter("docType") != null) {
      docType = request.getParameter("docType");
      GrndsTrace.msg(TRACE_TAG, 7, "Doing lookup");
      docMetaData = DocumentLookup.lookup(docType.toUpperCase());
      //docMetaData = (String)JndiHelper.lookup( docType.toUpperCase() );
      GrndsTrace.msg(TRACE_TAG, 7, "lookup was successful");
    }
    GrndsTrace.msg(TRACE_TAG, 7, "Variables are set");
    StringReader sr = new StringReader(docMetaData);
    try {
      // Unmarshall the Xml String into the DocumentMetaData object
      documentMetaData = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, sr);
    } catch (MarshalException me) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in marshalling:" + me.getMessage());
      processSevereException(context, me);
    } catch (ValidationException ve) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in Validation:" + ve.getMessage());
      processSevereException(context, ve);
    }

    request.setAttribute("documentMetaData", documentMetaData);
    GrndsTrace.exitScope();
    return;
  }

  public void deleteDocument_xa(GrndsExchangeContext context) {

    GrndsTrace.enterScope(TRACE_TAG + ".displayDocumentForm_xa");
    HttpServletRequest request = context.getRequest();
    String docType;
    String docMetaData = null;
    DocumentMetaData documentMetaData = null;
    GrndsTrace.msg(TRACE_TAG, 7, "Variables are set");

    // Place each of the request parameter into attributes
    DocumentUtilityHelpers.changeParameterstoAttributes(request);
    if (request.getParameter("docType") != null) {
      docType = request.getParameter("docType");
      GrndsTrace.msg(TRACE_TAG, 7, "Doing lookup");
      docMetaData = DocumentLookup.lookup(docType.toUpperCase());
      //docMetaData = (String)Helper.lookup( docType.toUpperCase() );
      GrndsTrace.msg(TRACE_TAG, 7, "lookup was successful");
    }
    GrndsTrace.msg(TRACE_TAG, 7, "Variables are set");
    StringReader sr = new StringReader(docMetaData);
    try {
      // Unmarshall the Xml String into the DocumentMetaData object
      documentMetaData = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, sr);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in Validation:" + e.getMessage());
      processSevereException(context, e);
    }

    try {
      documentMetaData = DocumentUtilityHelpers.completeDocumentMetaData(documentSave, request, documentMetaData);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    StringBuffer sql = new StringBuffer();
    sql.append("DELETE FROM ");
    sql.append(documentMetaData.getTableMetaData().getTableName());

    int y = 0;
    for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);
      if (!"DT_LAST_UPDATE".equals(column.getName().toUpperCase())) {
        if (y == 0) {
          sql.append(" where ");
          y++;
        } else {
          sql.append(" and ");
        }
        sql.append(column.getName());

        if (column.getType().equals(ColumnType.NUMBER)) {
          sql.append(" = ");
          sql.append(column.getContent());
        } else {
          sql.append(" = '");
          sql.append(column.getContent());
          sql.append("' ");
        }
      }
    }

    GrndsTrace.msg(TRACE_TAG, 7, "SQL Statment:" + sql.toString());
    String message = null;
    Connection connection = null;
    Statement deleteStatement = null;
    try {
      connection = JdbcHelper.getConnection();
      deleteStatement = connection.createStatement();

      int rowsAffected = deleteStatement.executeUpdate(sql.toString());

      if (rowsAffected == 0) {
        message = "No document was deleted.";
      } else if (rowsAffected == 1) {
        message = "Document was successfully deleted.";
      } else {
        message = "Many documents were deleted:" + String.valueOf(rowsAffected);
      }

      connection.commit();
    } catch (Exception e) {
      processSevereException(context, e);
      return;
    } finally {
      try {
        if (deleteStatement != null) {
          deleteStatement.close();
        }
      } catch (SQLException e) {
        // Ignore
      }
      try {
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
      } catch (SQLException e) {
        // Ignore
      }
    }
    request.setAttribute("message", message);
    request.setAttribute("documentMetaData", documentMetaData);
    GrndsTrace.exitScope();
    return;
  }

  public void newUseDocument_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + "newUseDocument_xa");
    try {
      NewUsingDocumentValueBean newUsingDocumentValueBean =
              DocumentRecordHelper.newUseDocumentRecord(documentSave, context.getRequest());
      DocumentRecordHelper.saveNewUseDocumentRecord(documentSave, context.getRequest(), newUsingDocumentValueBean);
      context.getRequest().setAttribute("message", "New Document created.");
    } catch (Exception e) {
      processSevereException(context, e);
    }

    GrndsTrace.exitScope();
  }
}