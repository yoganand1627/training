package gov.georgia.dhr.dfcs.sacwis.web.document;

// -- java classes --

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class ShowDocumentActivity {

  public ShowDocumentActivity() {
  }
/*
  public void executeActivity ( GrndsExchangeContext context )
  {
    // Do performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace("ShowDocumentActivity", "executeActivity");
    performanceTrace.enterScope();
    GrndsTrace.enterScope( TRACE_TAG + ".executeActivity" );

    // Create local variables
    DocumentMetaData documentMetaData = null;
    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();

    String preFillData = null;

    // Place each of the request parameter into attributes
    changeParameterstoAttributes(request);

    // Get the specific document type requested and lookup in JNDI
    String docType = (String) request.getAttribute("documentType");
    String docMetaData = (String) JndiHelper.lookup(docType);


    documentMetaData = DocumentUtilityHelpers.unmarshalDocumentMetaData(docMetaData);

    if (documentMetaData.getPreFillMetaData()!= null)
    {
      preFillData = DocumentUtilityHelpers.returnPreFillData (request, documentMetaData);
    }

    documentMetaData = DocumentUtilityHelpers.completeDocumentMetaData (request, documentMetaData);
    String docMetaString = DocumentUtilityHelpers.marshalDocumentMetaData(documentMetaData);

    request.setAttribute("preFill", preFillData);
    request.setAttribute("docMetaData", docMetaString);

    DocumentServicesHandler.showDocument(documentMetaData, docMetaString, preFillData, request, response);

    GrndsTrace.exitScope( TRACE_TAG + ".executeActivity" );
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  public void changeParameterstoAttributes(HttpServletRequest request)
  {
    for (Enumeration en=request.getParameterNames(); en.hasMoreElements();)
    {
       String paramName = (String) en.nextElement();
       String paramValue = (String) request.getParameter(paramName);
       request.setAttribute(paramName,paramValue);

    }

  }
*/
/*
  private String returnPreFillData (HttpServletRequest request, DocumentMetaData docMetaData)
  {
    // Do performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace("ShowDocumentActivity", "returnPreFillData");
    performanceTrace.enterScope();
    GrndsTrace.enterScope( TRACE_TAG + ".returnPreFillData" );


    String preFillString = null;
    XmlValueBean input = null;
    String dataString = null;
    PreFillMetaData preFillService = docMetaData.getPreFillMetaData();
    InputClass inputDescriptor = preFillService.getInputClass();
    String className = inputDescriptor.getName();

    try
    {
      // Load the Input class
      Class serviceInput = Class.forName(className);

      // Create new instance of Input Class
      input = (XmlValueBean) serviceInput.newInstance();

      // Set the Arch Input Struct
      ArchInputStruct archStruct = new ArchInputStruct();
      archStruct.setCReqFuncCd("S");
      archStruct.setBPerfInd(true);
      archStruct.setBDataAcsInd(false);
      archStruct.setUsPageNbr(65535);
      archStruct.setUlPageSizeNbr(1111);
      archStruct.setUlSysNbrReserved1(2222);
      archStruct.setUlSysNbrReserved2(3333);
      archStruct.setUlSysServiceChksum(4444);
      archStruct.setSzUserId("User Id");
      archStruct.setSzDstribStrtTs("Street Toss");
      archStruct.setSzSysTxtGenericIP("2");
      archStruct.setSzSysTxtGenericSSN("xxx-xx-xxxx");

      GrndsTrace.msg( TRACE_TAG, 7, "Setting up the Arch Input Structure");
      Class[] archParameterTypes = new Class[] {gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct.class};
      Method setArchInputStruct = serviceInput.getMethod("setArchInputStruct",archParameterTypes);
      Object[] archArguments = new Object[] {archStruct};
      setArchInputStruct.invoke(input, archArguments);
      GrndsTrace.msg( TRACE_TAG, 7, "Completed Setting up the Arch Input Structure");

      for (int x=0; x<inputDescriptor.getParameterCount(); x++)
      {
        Parameter param = inputDescriptor.getParameter(x);
        String requestName = param.getRequestName();
        String paramType = param.getType();
        Class[] methodParameterTypes=null;
        Object[] parameters = null;
        GrndsTrace.msg( TRACE_TAG, 7,  "Inside For Loop ... determining parameters");
        if (paramType.equals("int"))
        {
          methodParameterTypes = new Class[] {int.class};
          Integer requestAtt = Integer.valueOf((String)request.getAttribute(requestName));
          GrndsTrace.msg( TRACE_TAG, 7,  param.getName() + ": " + String.valueOf(requestAtt));
          parameters = new Object[] {requestAtt};
        }
        else if (paramType.equals("long"))
        {
          methodParameterTypes = new Class[] {java.lang.Long.class};
          Long requestAtt = (Long) request.getAttribute(requestName);
          GrndsTrace.msg( TRACE_TAG, 7,  param.getName() + ": " + String.valueOf(requestAtt));
          parameters = new Object[] {requestAtt};
        }
        else
        {
          Class paramClass = Class.forName(paramType);
          Object requestAtt =  request.getAttribute(requestName);
          methodParameterTypes = new Class[] {paramClass.getClass()};
          parameters = new Object[] {requestAtt};
        }
          String setMethod = param.getSetMethod();
          GrndsTrace.msg( TRACE_TAG, 7,  "Finding Set-method:" + param.getSetMethod());
          Method call = serviceInput.getMethod(setMethod,methodParameterTypes);
          GrndsTrace.msg( TRACE_TAG, 7,  "Call Set-method:" + param.getSetMethod());
          call.invoke(input, parameters);
      }
    }
    catch(Exception e)
    {
      GrndsTrace.msg( TRACE_TAG, 7,  "Exception setting up Input class:" + e.getMessage() + input.toString());
    }

    // Call the Service
    try
    {
      dataString = WtcHelper.callService(preFillService.getServiceName(), input);
    }
    catch(WtcException we)
    {
      GrndsTrace.msg( TRACE_TAG, 7,   we.getMessage());
    }


    // Unmarshall the Xml to the output class

    try
    {
      GrndsTrace.msg(TRACE_TAG, 7, "Value of datastring:" + dataString);
      GrndsTrace.msg(TRACE_TAG, 7, "Setting up to unmarshal");
      //Find the output class
      Class serviceOutput = Class.forName(preFillService.getOutputClass().getName());


      //Get instance of output class
      XmlValueBean output = (XmlValueBean) serviceOutput.newInstance();
      StringReader sr = new StringReader(dataString);
      output =(XmlValueBean) Unmarshaller.unmarshal(serviceOutput, sr);

//      Class[] parameterTypes = new Class[] {java.io.Reader.class};

//      Method unmarshallOutput = serviceOutput.getMethod("unmarshal",parameterTypes);
//      StringReader sr = new StringReader(dataString);
//      Object[] arguments = new Object[] {sr};
 //     GrndsTrace.msg(TRACE_TAG, 7, "Unmarshalling Xml into output class");
 //     unmarshallOutput.invoke(output,arguments);


      GrndsTrace.msg(TRACE_TAG, 7, output.toString());

      // Get instance of preFillData Class
      Class preFillDataClass = Class.forName(preFillService.getOutputClass().getPreFillData().getType());

      // Setup parameter types for marshalling
      Class[] preFillParamTypes = new Class[] {java.io.Writer.class};
      Method preFillMarshal = preFillDataClass.getMethod("marshal", preFillParamTypes);
      XmlValueBean preFillData = (XmlValueBean) preFillDataClass.newInstance();


      //Find method to get PreFill Data
      Class[] emptyParameterTypes = null;
      Method call = serviceOutput.getMethod(preFillService.getOutputClass().getPreFillData().getGetMethod(), emptyParameterTypes);
      Object[] emptyArguments = null;

      GrndsTrace.msg(TRACE_TAG, 7, "Marshalling prefill out to Xml String");
      preFillData = (XmlValueBean) call.invoke(output, emptyArguments);


      GrndsTrace.msg(TRACE_TAG, 7, "Have prefill data, now starting marshall");
      //Finally marshall the prefill Xml to a string
      StringWriter sw = new StringWriter();
      Object[] preFillArgs = new Object[] {sw};
      GrndsTrace.msg(TRACE_TAG, 7, "Calling marshal method on PreFillData");
      GrndsTrace.msg(TRACE_TAG,7, preFillData.toString());
      preFillMarshal.invoke(preFillData, preFillArgs);

      GrndsTrace.msg(TRACE_TAG, 7, "Completed marshalling");
      sw = (StringWriter) preFillArgs[0];
      GrndsTrace.msg(TRACE_TAG, 7, sw.toString());
      preFillString = sw.toString();

    }

    catch (Exception e)
    {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception:" + e.getMessage());
    }


    // Get the prefill data





   GrndsTrace.exitScope( TRACE_TAG + ".returnPreFillData" );
   performanceTrace.getTotalTime();
   performanceTrace.exitScope();


   return preFillString;

  }


private DocumentMetaData returnDocumentMetaData(HttpServletRequest request, DocumentMetaData docMetaData)
{
  GrndsTrace.enterScope( TRACE_TAG + ".returnDocumentMetaData" );

  if (docMetaData.getTableMetaData() != null)
  {
    GrndsTrace.msg(TRACE_TAG, 7, "Inside the if statement");
    TableFields tableFields = docMetaData.getTableMetaData().getTableFields();
    GrndsTrace.msg(TRACE_TAG, 7, "Entering the for loop");
    for (int x=0; x < tableFields.getColumnCount(); x++)
    {
      Column column = tableFields.getColumn(x);
      String requestAtt = (String)request.getAttribute(column.getRequestName());
      column.setContent(requestAtt);
    }
    docMetaData.getTableMetaData().setTableFields(tableFields);
  }

  GrndsTrace.exitScope( TRACE_TAG + ".returnDocumentMetaData" );
  return docMetaData;


}

*/

  public static final String TRACE_TAG = "ShowDocumentActivity";

}