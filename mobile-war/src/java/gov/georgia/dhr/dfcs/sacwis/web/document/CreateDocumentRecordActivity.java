package gov.georgia.dhr.dfcs.sacwis.web.document;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class CreateDocumentRecordActivity {

  public CreateDocumentRecordActivity() {
  }

  /*
    public void executeActivity(GrndsExchangeContext context)
    {
      // Do performance tracing
      PerformanceTrace performanceTrace = new PerformanceTrace("ShowDocumentActivity", "executeActivity");
      performanceTrace.enterScope();
      GrndsTrace.enterScope( TRACE_TAG + ".executeActivity" );

      HttpServletRequest request = context.getRequest();
      HttpServletResponse response = context.getResponse();
      String preFillData = null;
      DocumentMetaData documentMetaData = null;

      // Get the specific document type requested and lookup in JNDI
      String docType = (String) request.getAttribute("documentType");
      String docMetaData = (String) JndiHelper.lookup(docType);

      documentMetaData = DocumentUtilityHelpers.unmarshalDocumentMetaData(docMetaData);

      if (documentMetaData.getPreFillMetaData()!= null)
      {
        preFillData = DocumentUtilityHelpers.returnPreFillData (request, documentMetaData);
      }

      // Set the actual template version so it can be saved to the database
      documentMetaData.setActualTemplateVersion(documentMetaData.getNewTemplateVersion());
      // Fill in the rest of the Xml
      documentMetaData = DocumentUtilityHelpers.completeDocumentMetaData (request, documentMetaData);
      String docMetaString = DocumentUtilityHelpers.marshalDocumentMetaData(documentMetaData);

      DocumentSave documentSave = this.getDocumentSaveEjb(context);
      String xmlData = DocumentUtilityHelpers.constructDocumentXml(preFillData);
      try
      {
        documentMetaData = documentSave.saveDocument(documentMetaData, xmlData.getBytes());
      }
      catch (Exception e)
      {
        GrndsTrace.msg( TRACE_TAG, 7, "Exception saving form" + e.getMessage());
      }


      request.setAttribute("preFill", preFillData);
      request.setAttribute("docMetaData", docMetaString);

      DocumentServicesHandler.showDocument(documentMetaData, docMetaString, preFillData, request, response);

      GrndsTrace.exitScope( TRACE_TAG + ".executeActivity" );
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();

    }



    private DocumentSave getDocumentSaveEjb( GrndsExchangeContext context )
    {
      GrndsTrace.enterScope( TRACE_TAG + ".getDocumentSaveEjb" );
      DocumentSave documentSave = null;

      try
      {
          documentSave = ( DocumentSave )JndiHelper.lookupSessionBeanFromClient( JNDI_NAME, DocumentSaveHome.class);
      }
      catch( Exception e )
      {
          GrndsTrace.msg( TRACE_TAG, 7,  " Exception getting the DocumentSave EJB." );
          GrndsTrace.msg( TRACE_TAG, 7, "JNDI Lookup:" + JNDI_NAME );
          GrndsTrace.msg( TRACE_TAG, 7,  e.getMessage());
      }

      GrndsTrace.exitScope();
      return documentSave;
    }

  */
  private static final String TRACE_TAG = "CreateDocumentRecordActivity";
}