package gov.georgia.dhr.dfcs.sacwis.web.core.state;

import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This class was developed to help retrieving variables such as idEvent,
 * cdTask, idCase, etc. when returning from a mobile narrative or form.
 * @author wjcochran
 *
 */
public class MobileDataHelper {

  public static final String SZ_CD_TASK = "taskCD";
  public static final String ID_STAGE = "idStage";
  public static final String ID_CASE = "idCase";
  
  public static String getSzCdTask(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    
    String szCdTask = "";
    String globalCdTask = GlobalData.getSzCdTask(request);
    if ( globalCdTask != null && globalCdTask != "") {
      szCdTask = globalCdTask;
    } else {
      String tmpCdTask = request.getParameter(SZ_CD_TASK);
      if (tmpCdTask != null) {
        szCdTask = tmpCdTask;
      }
    }
    return szCdTask;
    
  }
  
  public static int getUlIdStage(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    
    int ulIdStage = 0;
    int globalIdStage = GlobalData.getUlIdStage(request);
    if (globalIdStage > 0) {
      ulIdStage = globalIdStage;
    } else {
      String tmpIdStage = request.getParameter(ID_STAGE);
      if (tmpIdStage != null && tmpIdStage != "") {
        ulIdStage = Integer.parseInt(tmpIdStage);
      }
    }
    
    return ulIdStage;

  }
  
  public static int getUlIdCase(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    
    int ulIdCase = 0;
    int globalIdCase = GlobalData.getUlIdCase(request);
    if (globalIdCase > 0) {
      ulIdCase = globalIdCase;
    } else {
      String tmpIdCase = request.getParameter(ID_CASE);
      if (tmpIdCase != null && tmpIdCase != "") {
        ulIdCase = Integer.parseInt(tmpIdCase);
      }
    }
    
    return ulIdCase;
  }
  
  public static String getSzCdCounty(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    
    String szCdCounty = "";
    
    String globalCdCounty = GlobalData.getSzCdCounty(request);
    if (globalCdCounty != null && globalCdCounty != "") {
      szCdCounty = globalCdCounty;
    } else {
      String tmpSzCdCounty = request.getParameter("cdCounty");
      if (tmpSzCdCounty != null && tmpSzCdCounty != "") {
        szCdCounty = tmpSzCdCounty;
      }
    }
    return szCdCounty;
  }

  public static String getSzCdStage(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    
    String szCdStage = "";
    
    String globalCdStage = GlobalData.getSzCdStage(request);
    if (globalCdStage != null && globalCdStage != "") {
      szCdStage = globalCdStage;
    } else {
      String tmpSzCdCounty = request.getParameter("cdStage");
      if (tmpSzCdCounty != null && tmpSzCdCounty != "") {
        szCdStage = tmpSzCdCounty;
      }
    }
    return szCdStage;
  }

  public static String getSzCdStageType(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    
    String szCdStageType = "";
    
    String globalCdStageType = GlobalData.getSzCdStageType(request);
    if (globalCdStageType != null && globalCdStageType != "") {
      szCdStageType = globalCdStageType;
    } else {
      String tmpSzCdStageType = request.getParameter("cdStageType");
      if (tmpSzCdStageType != null && tmpSzCdStageType != "") {
        szCdStageType = tmpSzCdStageType;
      }
    }
    return szCdStageType;
  }

  public static String getAppMode(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    
    String appMode = "";
    
    String globalAppMode = GlobalData.getAppMode(request);
    if (globalAppMode != null && globalAppMode != "") {
      appMode = globalAppMode;
    } else {
      String tmpAppMode = request.getParameter("appMode");
      if (tmpAppMode != null && tmpAppMode != "") {
        appMode = tmpAppMode;
      }
    }
    return appMode;
  }
  
  public static boolean isReturningFromForm(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    boolean isComingFromForm = false;
    /*
     * This is a total hack. It checks to see if idStage is in the param
     * string, which is present when returning from a form.
     */
    String tmpIdStage = request.getParameter(ID_STAGE);
    if (tmpIdStage != null && !"".equals(tmpIdStage)) {
      isComingFromForm = true;
    }
    
    return isComingFromForm;
  }

}
