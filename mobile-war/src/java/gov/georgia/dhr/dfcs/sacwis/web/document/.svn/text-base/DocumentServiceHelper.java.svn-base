package gov.georgia.dhr.dfcs.sacwis.web.document;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentService;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentServiceExecutor;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.InputClass;
import gov.georgia.dhr.dfcs.sacwis.structs.document.OutputClass;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter;
import gov.georgia.dhr.dfcs.sacwis.structs.document.PreFillMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;

import org.exolab.castor.types.Date;

public class DocumentServiceHelper {
  private static final String TRACE_TAG = "DocumentServiceHelper";

  @SuppressWarnings({"unchecked"})
  public static String returnPreFillData(DocumentServiceExecutor documentServiceExecutor, HttpServletRequest request,
                                         DocumentMetaData docMetaData)
          throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException,
                 InvocationTargetException, ParseException, CreateException {
    // Do performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentUtilityHelpers", "returnPreFillData");
    performanceTrace.enterScope();

    PreFillMetaData preFillService = docMetaData.getPreFillMetaData();
    InputClass inputDescriptor = preFillService.getInputClass();
    XmlValueBean input = createInputClass(inputDescriptor, request);

    OutputClass serviceOutputClassMetaData = preFillService.getOutputClass();
    Class serviceOutputClass = Class.forName(serviceOutputClassMetaData.getName());
    String serviceName = preFillService.getServiceName();
    GrndsTrace.msg(TRACE_TAG, 7, "Calling service " + serviceName);
    //GrndsTrace.msg(TRACE_TAG, 7, "input: " + input);
    Class<? extends DocumentService> serviceInterface = (Class<? extends DocumentService>) Class.forName(serviceName);
    XmlValueBean output;
    try {
      output = documentServiceExecutor.callDocumentService(serviceInterface, input);
    } catch (EJBException e) {
      Throwable cause = e.getCause();
      if (cause instanceof RuntimeException) {
        throw (RuntimeException) cause;
      } else {
        throw e;
      }
    }
    //GrndsTrace.msg(TRACE_TAG, 7, "received " + output);
    Method preFillGetter = serviceOutputClass.getMethod(serviceOutputClassMetaData.getPreFillData().getGetMethod());
    XmlValueBean preFillData = (XmlValueBean) preFillGetter.invoke(output);
    //GrndsTrace.msg(TRACE_TAG, 7, "prefillData: " + preFillData);
    performanceTrace.exitScope();
    //don't want <?xml...?>
    return preFillData.toString(false);
  }

  private static XmlValueBean createInputClass(InputClass inputDescriptor, HttpServletRequest request)
          throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
                 InvocationTargetException, ParseException {
    String className = inputDescriptor.getName();
    // Load the Input class
    Class serviceInput = Class.forName(className);
    // Create new instance of Input Class
    XmlValueBean input = (XmlValueBean) serviceInput.newInstance();
    // Set the Arch Input Struct
    GrndsTrace.msg(TRACE_TAG, 7, "Setting up the Arch Input Structure");
    ArchInputStruct archStruct = new ArchInputStruct();
    archStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);
    String userId;
    if (UserProfileHelper.getUserProfile(request) != null) {
      userId = UserProfileHelper.getUserProfile(request).getUserLogonID();
    } else {
      userId = "DOCARCH";
    }
    archStruct.setSzUserId(userId);
    archStruct.setBPerfInd(ArchitectureConstants.Y);
    archStruct.setBDataAcsInd(ArchitectureConstants.N);
    archStruct.setUsPageNbr(ServiceConstants.INITIAL_PAGE);
    Class[] archParameterTypes = new Class[] {ArchInputStruct.class};
    Method setArchInputStruct = serviceInput.getMethod("setArchInputStruct", archParameterTypes);
    Object[] archArguments = new Object[] {archStruct};
    setArchInputStruct.invoke(input, archArguments);
    GrndsTrace.msg(TRACE_TAG, 7, "Completed Setting up the Arch Input Structure");
    BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

    
    for (int x = 0; x < inputDescriptor.getParameterCount(); x++) {
      Parameter param = inputDescriptor.getParameter(x);
      String paramName = param.getRequestName();
      String paramType = param.getType();
      Class[] methodParameterTypes;
      Object[] parameters;
      String paramValue = null;
      Object paramObjectValue = null;


      if (param.getState()) {
        paramObjectValue = state.getAttribute(paramName, request);
      } else if (request.getAttribute(paramName) != null) {
        paramValue = (String) request.getAttribute(paramName);
      }

      if ((paramValue != null && !"".equals(paramValue)) || paramObjectValue !=null) {
        if ("int".equals(paramType)) {
          methodParameterTypes = new Class[] {int.class};
          Integer requestAtt = Integer.valueOf(paramValue);
          GrndsTrace.msg(TRACE_TAG, 7, param.getName() + ": " + String.valueOf(paramValue));
          parameters = new Object[] {requestAtt};
        } else if ("long".equals(paramType)) {
          methodParameterTypes = new Class[] {long.class};
          Long requestAtt = Long.valueOf(paramValue);
          GrndsTrace.msg(TRACE_TAG, 7, param.getName() + ": " + String.valueOf(paramValue));
          parameters = new Object[] {requestAtt};
        } else if ("org.exolab.castor.types.Date".equals(paramType)) {
          methodParameterTypes = new Class[] {Date.class};
          Date requestAtt = DateHelper.toCastorDate(paramValue);
          GrndsTrace.msg(TRACE_TAG, 7, param.getName() + ": " + paramValue);
          parameters = new Object[] {requestAtt};
        } 
        else {
          Class paramClass = Class.forName(paramType);
          Object requestAtt = null;
          if (param.getState()) {
             requestAtt = state.getAttribute(paramName, request);
          } else {
             requestAtt = request.getAttribute(paramName);
          }
          methodParameterTypes = new Class[] {paramClass};
          parameters = new Object[] {requestAtt};
        }
        String setMethod = param.getSetMethod();
        GrndsTrace.msg(TRACE_TAG, 7, "Finding Set-method:" + param.getSetMethod());
        Method call = serviceInput.getMethod(setMethod, methodParameterTypes);
        GrndsTrace.msg(TRACE_TAG, 7, "Call Set-method:" + param.getSetMethod());
        call.invoke(input, parameters);
      }
    }
    return input;
  }
}
