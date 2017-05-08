package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

import java.util.Date;

public abstract class DynamicBaseDAOImpl extends BaseDAOImpl {
  /**
   * Dynamic DAOs should use this method to validate that NOT ALL of their primary arguments
   * are null or 0 (zero) values.  In other words, if at least one of the args passed to
   * this method is non-null, the return value will be false.  Typically, the DAO should treat
   * a returned value of true as a means to throw a RuntimeException, which should
   * typically be a ServiceException.  This method accepts any number of arguments using
   * Java 5 var-args; simply pass each of the DAO's primary arguments as individual parameters
   * to this method.
   * 
   * @param args All primary arguments (passed as separate individual params) where at least one is required for the dynamic query
   * @return true if all args are null or 0 (zero), false otherwise
   */
  protected boolean allNullArgs(Object... args) {
    if(args.length < 1) {
      return false;
    }
    
    for (Object arg : args) {
      if (arg == null) {
        // so far, all null; continue check
        continue;
      } else if (arg instanceof String) {
        if(!"".equals(((String) arg).trim())) {
          return false;
        }
        continue;
      } else if (arg instanceof Number) {
        // Probably the fastest conversion can be done to int, so use that.
        if (((Number) arg).intValue() != 0) {
          return false;
        }
        continue;
      } else if (arg instanceof Date) {
        if (!DateHelper.isNull((Date) arg)) {
          return false;
        }
      }
      // DB values should never be boolean or char values, really.
    }
    return true;
  }
  
  /**
   * Dynamic DAOs should use this method to validate that NOT ANY of their primary arguments
   * are null or 0 (zero) values.  In other words, if at least one of the args passed to this
   * method is null, the return value will be true.  Typically, the DAO should treat
   * a returned value of true as a means to throw a RuntimeException, which should
   * typically be a ServiceException.  This method accepts any number of arguments using
   * Java 5 var-args; simply pass each of the DAO's primary arguments as individual parameters
   * to this method.
   * 
   * @param args All primary arguments (passed as separate individual params) where at least one is required for the dynamic query
   * @return true if at least one null or 0 (zero), false otherwise
   */
  protected boolean oneNullArg(Object... args) {
    if(args.length < 1) {
      return false;
    }
    
    for (Object arg : args) {
      if (arg == null) {
        return true;
      }
      if (arg instanceof String) {
        // The vast majority of DB columns are strings; just ignore these if they aren't null.
        if("".equals(((String) arg).trim())) {
          return true;
        }
        continue;
      } else if (arg instanceof Number) {
        // Probably the fastest conversion can be done to int, so use that.
        if (((Number) arg).intValue() == 0) {
          return true;
        }
        continue;
      } else if (arg instanceof Date) {
        if (DateHelper.isNull((Date) arg)) {
          return true;
        }
      }
      // DB values should never be boolean or char values, really.
    }
    return false;
  }
}
