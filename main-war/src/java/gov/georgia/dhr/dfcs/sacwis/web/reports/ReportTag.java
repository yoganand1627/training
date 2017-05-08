package gov.georgia.dhr.dfcs.sacwis.web.reports;

// java classes

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DataNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.DuplicateRecordFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataLookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.TableNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.tags.BaseDocTag;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0 07/09/2004    Hadjimh  SIR#22902:  Need to add the Report launch functionality to the Staff Todo page.
 */

public class ReportTag extends BaseDocTag {
  public static String TRACE_TAG = "ReportTag";

  public static String SQR_NAME = "szNmRptSqrName";
  public static String SQR_VERSION = "szNmRptSqrVer";
  public static String PARAMETER_LIST = "txtRptParmList";
  public static String EMAIL_MESSAGE = "szTxtEmailMessage";
  public static String REPORT_TYPE = "szNmRptType";

  private String sqrName = "";
  private String sqrVersion = "";
  private int parameterCount = 0;
  private String emailMessage = "";
  /*SIR 22902: added displayName variable */
  private String displayName = "";
  private String reportType = "";

  public ReportTag() {
  }

  /* SIR 22902: added the displayReportName parameter */
  private ReportTag(String rptName, String sqrName, String sqrVer, String fullName, String emailMsg, int parmCount,
                    Collection<String> rptParmList, boolean useHiddenParms, String displayReportName, String reportType) {
    this.docName = rptName;
    this.sqrName = sqrName;
    this.sqrVersion = sqrVer;
    this.fullName = fullName;
    this.emailMessage = emailMsg;
    this.parameterCount = parmCount;
    this.parameterList = new ArrayList<String>(rptParmList);
    this.useHiddenParameters = useHiddenParms;
    this.displayName = displayReportName;
    this.reportType = reportType;
  }

  protected void init() throws JspException {
    if (docName == null) {
      throw new JspException("You must enter a report name");
    } else if ("".equals(docName)) {
      throw new JspException("You must enter a report name");
    }
    try {

      this.setSqrName(ReportsLookup.getSqrName(docName));
      this.setSqrVersion(ReportsLookup.getSqrVersion(docName));
      /* SIR 22902: added the if statement. if displayName is not null, then
      ** use it for populating the dropdown list box on the jsp
      */
      if (!StringHelper.isValid(this.displayName)) {
        this.setFullName(ReportsLookup.getFullName(docName));
      }
      this.setParameterCount(ReportsLookup.getParameterCount(docName));

    }
    catch (DataNotFoundException dnfe) {
      throw new JspException(docName + " is not a valid report name.", dnfe);
    }
    catch (TableNotFoundException dnfe) {
      throw new JspException(docName + ": there was a problem finding the reports reference table.", dnfe);
    }
    catch (CodeNotFoundException dnfe) {
      throw new JspException(docName + ": is not a valid report name.", dnfe);
    }
    catch (DuplicateRecordFoundException dnfe) {
      throw new JspException(docName + ": there are two reports using that name.", dnfe);
    }
    catch (ReferenceDataLookupException dnfe) {
      throw new JspException(docName + " there was a problem finding the reports reference table.", dnfe);
    }
  }

  public String getParameterListString() {
    GrndsTrace.enterScope(TRACE_TAG + ".getParameterListString");
    ReportParameterTag paramTag;

    Iterator i = this.getParameterList().iterator();

    if (!i.hasNext()) {
      return "";
    }

    StringBuffer paramListString = new StringBuffer("");

    while (i.hasNext()) {
      paramTag = (ReportParameterTag) i.next();
      paramListString.append(paramTag.getValue()).append("^");
    }
    GrndsTrace.exitScope();
    return paramListString.toString();
  }

  public String getDataString() {
    GrndsTrace.enterScope(TRACE_TAG + ".getDataString");
    String queryString = super.getDataString();

    queryString += super.addUrlParameter(SQR_NAME, this.getSqrName());
    queryString += super.addUrlParameter(SQR_VERSION, this.getSqrVersion());
    queryString += super.addUrlParameter(EMAIL_MESSAGE, this.getEmailMessage());
    queryString += super.addUrlParameter(PARAMETER_LIST,
                                         this.getParameterListString());

    GrndsTrace.exitScope();
    return queryString;
  }

  protected void setParameterCount(int parmCount) {
    parameterCount = parmCount;
  }

  protected void setSqrName(String name) {
    sqrName = defaulter(name);
  }

  protected void setSqrVersion(String version) {
    sqrVersion = defaulter(version);
  }

  public void setReportName(String name) throws JspException {
    super.setDocName(name);
    init();
  }

  public String getReportName() {
    return super.getDocName();
  }

  public void setEmailMessage(String msg) {
    emailMessage = defaulter(msg);
  }

  public String getSqrName() {
    return sqrName;
  }

  public String getSqrVersion() {
    return sqrVersion;
  }

  public int getParameterCount() {
    return parameterCount;
  }

  public String getEmailMessage() {
    return emailMessage;
  }
  
  public String getReportType() {
    return reportType;
  }

  public void setReportType(String reportType) {
    this.reportType = reportType;
  }

  /* SIR 22902: added new get & set method for displayName */
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayReportName) {
    displayName = defaulter(displayReportName);
    this.setFullName(displayName);
  }

  /* SIR 22902: added getDisplayName */

  /**
   * This is not a real clone method; it just makes a new instance with the same data.
   *
   * @return
   */
  public Object clone() {
    return new ReportTag(
            this.getDocName(),
            this.getSqrName(),
            this.getSqrVersion(),
            this.getFullName(),
            this.getEmailMessage(),
            this.getParameterCount(),
            this.getParameterList(),
            this.getUseHiddenParameters(),
            this.getDisplayName(),
            this.getReportType()
    );
  }

}