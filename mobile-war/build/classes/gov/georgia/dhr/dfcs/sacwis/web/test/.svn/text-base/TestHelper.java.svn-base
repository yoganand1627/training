/**
 * Created on Apr 20, 2005 at 6:21:46 PM
 *
 * Created by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserRight;

public class TestHelper {
  public static Map getGlobalDataSetters() {
    // use reflection to get the set methods on global data
    if (gdSetterMethodMap == null) {
      synchronized (TRACE_TAG) {
        if (gdSetterMethodMap == null) {
          gdSetterMethodMap = new TreeMap();
          Class gdc = GlobalData.class;
          Method[] gdcMethods = gdc.getMethods();
          for (int i = 0; i < gdcMethods.length; i++) {
            Method method = gdcMethods[i];
            String methodName = method.getName();
            if (methodName.startsWith("set")) {
              methodName = methodName.length() > 3 ? methodName.substring(3, methodName.length()) : null;
              if (methodName != null) {
                gdSetterMethodMap.put(methodName, method);
              }
            }
          }
        }
      }
    }
    return gdSetterMethodMap;
  }

  public static Map getGlobalDataGetters() {
    // use reflection to get the set methods on global data
    if (gdGetterMethodMap == null) {
      synchronized (TRACE_TAG) {
        if (gdGetterMethodMap == null) {
          gdGetterMethodMap = new TreeMap();
          Class gdc = GlobalData.class;
          Method[] gdcMethods = gdc.getMethods();
          for (int i = 0; i < gdcMethods.length; i++) {
            Method method = gdcMethods[i];
            Class[] params = method.getParameterTypes();
            if (params.length == 1 && HttpServletRequest.class.equals(params[0])) {
              Class returnType = method.getReturnType();
              if (Integer.TYPE.equals(returnType) || Long.TYPE.equals(returnType)
                  || Boolean.TYPE.equals(returnType)
                  || Float.TYPE.equals(returnType)
                  || Double.TYPE.equals(returnType)
                  || String.class.equals(returnType)
                  || org.exolab.castor.types.Date.class.equals(returnType)) {
                String methodName = method.getName();
                if (methodName.startsWith("get") || methodName.startsWith("has")) {
                  methodName = methodName.length() > 3 ? methodName.substring(3, methodName.length()) : null;
                  if (methodName != null) {
                    gdGetterMethodMap.put(methodName, method);
                  }
                } else if (methodName.startsWith("is")) {
                  methodName = methodName.length() > 2 ? methodName.substring(2, methodName.length()) : null;
                  if (methodName != null) {
                    gdGetterMethodMap.put(methodName, method);
                  }
                }
              }
            }
          }
        }
      }
    }
    return gdGetterMethodMap;
  }

  public static Set getExcptionNames() {
    // use an exceptions class for special handling of certain methods
    if (exceptionNameSet == null) {
      synchronized (TRACE_TAG) {
        if (exceptionNameSet == null) {
          exceptionNameSet = new HashSet();
          exceptionNameSet.add("AppMode");
          exceptionNameSet.add("PageMode");
          exceptionNameSet.add("StageAccess");
        }
      }
    }
    return exceptionNameSet;
  }

  public static SortedSet getUserRightSet() {
    if (userRightSet == null) {
      synchronized (TRACE_TAG) {
        if (userRightSet == null) {
          Class userProfileClass = UserProfile.class;
          Field[] userProfileFields = userProfileClass.getFields();
          userRightSet = new TreeSet();
          for (int i = 0; i < userProfileFields.length; i++) {
            Field userProfileField = userProfileFields[i];
            String userProfileFieldName = userProfileField.getName();
            if (userProfileField.getType().equals(String.class) && userProfileFieldName.startsWith("SEC_")) {
              try {
                userRightSet.add(new UserRight(userProfileFieldName, (String) userProfileField.get(null)));
              }
              catch (Exception e) {
                //Handle exception here
                GrndsTrace.msg(TRACE_TAG, 8, "Couldn't add user right " + userProfileFieldName + " to userRightSet.");
                e.printStackTrace(System.out);
              }
            }
          }
        }
      }
    }
    return userRightSet;
  }

  private static Map gdGetterMethodMap = null;
  private static Map gdSetterMethodMap = null;
  private static Set exceptionNameSet = null;
  private static SortedSet userRightSet = null;

  private static final String TRACE_TAG = "TestHelper";
}
