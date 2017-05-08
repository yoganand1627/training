package gov.georgia.dhr.dfcs.sacwis.web.reports;

// architecture classes

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DataNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DuplicateRecordFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataLookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataLookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.TableNotFoundException;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class ReportsLookup {

  public static final String TRACE_TAG = "ReportsLookup";

  // Prevent instantiation.
  private ReportsLookup() {
  }

  public static String getSqrVersion(String rptName)
          throws DataNotFoundException, TableNotFoundException, CodeNotFoundException, DuplicateRecordFoundException,
                 ReferenceDataLookupException {
    return (String) ReferenceDataLookup.get("REPORTS", rptName, "NM_RPT_SQR_VER");
  }

  public static String getSqrName(String rptName)
          throws DataNotFoundException, TableNotFoundException, CodeNotFoundException, DuplicateRecordFoundException,
                 ReferenceDataLookupException {
    return (String) ReferenceDataLookup.get("REPORTS", rptName, "NM_RPT_SQR_NAME");
  }

  public static String getFullName(String rptName)
          throws DataNotFoundException, TableNotFoundException, CodeNotFoundException, DuplicateRecordFoundException,
                 ReferenceDataLookupException {
    return (String) ReferenceDataLookup.get("REPORTS", rptName, "TXT_RPT_FULL_NAME");
  }

  public static int getParameterCount(String rptName)
          throws DataNotFoundException, TableNotFoundException, CodeNotFoundException, DuplicateRecordFoundException,
                 ReferenceDataLookupException {
    return (Integer) ReferenceDataLookup.get("REPORTS", rptName, "PARM_COUNT");
  }
}
