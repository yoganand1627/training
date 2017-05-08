package gov.georgia.dhr.dfcs.sacwis.core.utility;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;

@SuppressWarnings({"unchecked"})
public abstract class CastorArrayHelper {

  public static List getStringVector(Enumeration castorEnum, String propertyName) throws IntrospectionException {
    return getCheckedValueVector(castorEnum, propertyName, null, null);
  }

  public static List getStringVector(XmlValueBean castor_ARRAY, String propertyName) throws IntrospectionException {
    Enumeration castorEnum = CastorArrayHelper.getEnumeration(castor_ARRAY);
    return CastorArrayHelper.getStringVector(castorEnum, propertyName);
  }

  /**
   * @param castorEnum
   * @param propertyName
   * @param checkedValueName
   * @param checkedValueValue
   * @return
   * @throws IntrospectionException
   */
  public static List getCheckedValueVector(Enumeration castorEnum, String propertyName, String checkedValueName,
                                           String checkedValueValue) throws IntrospectionException {
    try {
      Object[] args = new Object[0];
      Class[] argList = new Class[0];

      List stringVector = new ArrayList();

      Class beanClass;
      Object row1;

      //If no classname specified, get it from the first element in the enum
      if (castorEnum.hasMoreElements()) {
        row1 = castorEnum.nextElement();
        beanClass = Class.forName(row1.getClass().getName());
      } else {
        return stringVector;
      }

      String capPropertyName = FormattingHelper.initCaps(propertyName);

      String getPropertyMethodName = "get" + capPropertyName;
      Method getProperty = beanClass.getMethod(getPropertyMethodName, argList);

      if ((checkedValueName != null) && (checkedValueValue != null)) {
        String capCheckedValueName = checkedValueName.substring(0, 1).toUpperCase() +
                                     checkedValueName.substring(1);
        String getCheckedValueName = "get" + capCheckedValueName;
        Method getCheckedValue = beanClass.getMethod(getCheckedValueName, argList);
        while (castorEnum.hasMoreElements() || row1 != null) {
          Object row;
          //Get row1 object first if we already called nextElement() on the enumeration.
          if (row1 == null) {
            row = castorEnum.nextElement();
          } else {
            row = row1;
            //noinspection AssignmentToNull
            row1 = null;
          }

          Object property = getProperty.invoke(row, args);
          Object checkedValueObject = getCheckedValue.invoke(row, args);
          String checkedValue = checkedValueObject.toString();
          if (checkedValue.equals(checkedValueValue)) {
//            String propertyValue = property.toString();
            stringVector.add(property.toString());
          }
        }
      } else {
        while (castorEnum.hasMoreElements() || row1 != null) {
          Object row;
          //Get row1 object first if we already called nextElement() on the enumeration.
          if (row1 == null) {
            row = castorEnum.nextElement();
          } else {
            row = row1;
            //noinspection AssignmentToNull
            row1 = null;
          }

          Object property = getProperty.invoke(row, args);
//          String propertyValue = property.toString();
          stringVector.add(property.toString());
        }
      }
      return stringVector;
    }
    catch (Exception e) {
      throw handleException(e, "getStringVector");
    }
  }

  public static List getOptionsVector(XmlValueBean castor_ARRAY, String keyPropertyName, String valuePropertyName) throws IntrospectionException {
    Enumeration castorEnum = getEnumeration(castor_ARRAY);
    return CastorArrayHelper.getOptionsVector(castorEnum, keyPropertyName, valuePropertyName);
  }

  public static List getOptionsVector(Enumeration castorEnum, String keyPropertyName, String valuePropertyName) throws IntrospectionException {

    try {
      Object[] args = new Object[0];
      Class[] argList = new Class[0];

      List optionVector = new ArrayList();

      Class beanClass = null;
      Object row1 = null;

      if (castorEnum.hasMoreElements()) {
        row1 = castorEnum.nextElement();
        beanClass = Class.forName(row1.getClass().getName());
      }

      String capKeyPropertyName = keyPropertyName.substring(0, 1).toUpperCase() +
                                  keyPropertyName.substring(1);
      String capValuePropertyName = valuePropertyName.substring(0, 1).toUpperCase() +
                                    valuePropertyName.substring(1);
      String getKeyMethodName = "get" + capKeyPropertyName;
      String getValueMethodName = "get" + capValuePropertyName;

      Method getKey = beanClass.getMethod(getKeyMethodName, argList);
      Method getValue = beanClass.getMethod(getValueMethodName, argList);
      while (castorEnum.hasMoreElements() || row1 != null) {
        Object row;
        //Get row1 object first if we already called nextElement() on the enum.
        if (row1 == null) {
          row = castorEnum.nextElement();
        } else {
          row = row1;
          //noinspection AssignmentToNull
          row1 = null;
        }
        Object key = getKey.invoke(row, args);
        Object value = getValue.invoke(row, args);
        Option opt = new Option(key.toString(), value.toString());
        optionVector.add(opt);
      }
      return optionVector;
    }
    catch (Exception e) {
      //noinspection CallToPrintStackTrace
      e.printStackTrace();
      throw handleException(e, "getOptionsVector");
    }
  }

  public static Enumeration getEnumeration(XmlValueBean castor_ARRAY) throws IntrospectionException {
    try {
      String castorArrayName = castor_ARRAY.getClass().getName();
      String fullCastorClassName = removeArraySuffix(castorArrayName);
      String castorClassName = fullCastorClassName.substring(fullCastorClassName.lastIndexOf('.') + 1);
      Class arrayClass = Class.forName(castorArrayName);
      Method arrayMethod = arrayClass.getMethod("enumerate" + castorClassName);
      return (Enumeration) arrayMethod.invoke(castor_ARRAY, new Object[0]);
    }
    catch (Exception e) {
      throw handleException(e, "getEnumeration");
    }
  }

  public static int getEnumerationLength(XmlValueBean castor_ARRAY) throws IntrospectionException {
    try {
      String castorArrayName = castor_ARRAY.getClass().getName();
      String castorClassName = removeArraySuffix(castorArrayName);
      Class arrayClass = Class.forName(castorArrayName);
      Method countMethod = arrayClass.getMethod("get" + castorClassName + "Count");
      return (Integer) countMethod.invoke(castor_ARRAY, new Object[0]);
    }
    catch (Exception e) {
      throw handleException(e, "getEnumerationLength");
    }
  }

  public static IntrospectionException handleException(Exception e, String methodName) throws IntrospectionException {
    if (e instanceof ClassNotFoundException) {
      return new IntrospectionException(methodName + "(): ClassNotFoundException " + e.getMessage());
    } else if (e instanceof NoSuchMethodException) {
      return new IntrospectionException(methodName + "(): NoSuchMethodException " + e.getMessage());
    } else if (e instanceof InvocationTargetException) {
      return new IntrospectionException(methodName + "(): InvocationTargetException " + e.getMessage());
    } else if (e instanceof IllegalAccessException) {
      return new IntrospectionException(methodName + "(): IllegalAccessException " + e.getMessage());
    } else if (e instanceof ClassCastException) {
      return new IntrospectionException(methodName + "(): ClassCastException " + e.getMessage());
    } else {
      return new IntrospectionException(methodName + "(): Exception " + e.getMessage());
    }
  }

  public static String removeArraySuffix(String className) {
    int index = className.indexOf("_");
    return className.substring(0, index);
  }
}