package gov.georgia.dhr.dfcs.sacwis.web.core.tags;

// java classes

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper;

/**
 * This custom tag will take make it easy for developers to create the documents or reports dropdown boxes that will
 * give pages access to documents and reports. The custom tag will be of the form:
 * <p/>
 * <br> <code> &lt;impact:reportList personId="2717"&gt; &lt;impact:report sqrName="ccf02o00" emailMessage="..."&gt;
 * &lt;impact:reportParameter value="24544096"&gt; &lt;impact:reportParameter value="24544213"&gt;
 * &lt;/impact:report&gt; &lt;impact:report reportName="PAL Case Summary" sqrName="ccf03o" sqrVersion="00"
 * emailMessage="..."&gt; &lt;parameter value="24544096"&gt; &lt;/impact:report&gt; &lt;/impact:reportList&gt; </code>
 * <br>
 * <p/>
 * The output tag will create a dropdown menu and the code to link to the reports in the "report" tags with the
 * parameters in the "parameter" tag
 *
 * @author Daniel Webster, June 9, 2002
 */
@SuppressWarnings({"unchecked"})
public abstract class BaseDocTag extends TagSupport implements DocTagInterface {

  // variables that must be overridden by subclasses
  public static String TRACE_TAG = "BaseDocTag";
  public static String PARAMETER_LIST = "parmList";
  public static String USE_HIDDEN_PARAMETERS = "useHiddenParameters";

  protected List parameterList;
  protected String docName = "";
  protected String fullName = "";
  protected boolean useHiddenParameters = true;

  private int position = 0;

  public BaseDocTag() {
    parameterList = new ArrayList();
  }

  protected void setFullName(String fullName) {
    this.fullName = defaulter(fullName);
  }

  public void setParameterList(Collection paramList) {
    if (paramList == null) {
      parameterList = new ArrayList();
    } else {
      parameterList = new ArrayList(paramList);
    }
  }

  public void addParameter(DocParameterInterface param) {
    GrndsTrace.enterScope(TRACE_TAG + ".addParameter(" + param + ")");
    parameterList.add(param);
    GrndsTrace.exitScope();
  }

  public boolean getUseHiddenParameters() {
    return useHiddenParameters;
  }

  public String getDocName() {
    return docName;
  }

  public String getFullName() {
    return fullName;
  }

  public List getParameterList() {
    return parameterList;
  }

  public DocParameterInterface getParameter(int index) {
    return (DocParameterInterface) parameterList.get(index);
  }

  public void setDocName(String name) {
    docName = defaulter(name);
  }

  public void setUseHiddenParameters(boolean useHiddenParms) {
    GrndsTrace.enterScope(TRACE_TAG + ".setUseHiddenParameters(" + useHiddenParms + ")");
    this.useHiddenParameters = useHiddenParms;
    GrndsTrace.exitScope(TRACE_TAG + ".setUseHiddenParameters(" + this.useHiddenParameters + ")");
  }

  public String defaulter(String txt) {
    if (txt == null) {
      txt = "";
    }
    return txt;
  }

  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    this.initBaseDocTag();
    GrndsTrace.exitScope();
    return Tag.EVAL_BODY_INCLUDE;
  }

  public int doEndTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    createDoc();
    GrndsTrace.exitScope();
    return Tag.EVAL_BODY_INCLUDE;
  }

  protected void createDoc() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".createDoc");
    DocListInterface parent = (DocListInterface) findAncestorWithClass(this, DocListInterface.class);
    DocTagInterface dti = (DocTagInterface) this.clone();
    parent.addDoc(dti);
    GrndsTrace.exitScope();
  }

  protected void initBaseDocTag() {
    this.setParameterList(null);
  }

  /**
   * Formats a name/value pair for output as a URL string parameter. before using this method the first time in a given
   * URL, the "position" parameter should be set to 0. The program uses this parameter to keep track of whether to add a
   * ? or a & before a give name value pair.
   * <p/>
   * If either the name or the value parameter is blank or null, it returns nothing an empty string.
   */
  public String addUrlParameter(String name, String value) {
    GrndsTrace.enterScope(TRACE_TAG + ".addUrlParameter");
    String temp = "";
    if ((name == null) || (value == null) || (this.position < 0)) {
      temp = "";
    } else if ("".equals(name) || "".equals(value)) {
      temp = "";
    } else {
      if (this.position == 0) {
        temp += "?";
      } else {
        temp += "&";
      }
      temp += URLHelper.encode(name) + "=" + URLHelper.encode(value);
      position++;
    }
    GrndsTrace.exitScope();
    return temp;
  }

  public String getDataString() {
    return addUrlParameter(USE_HIDDEN_PARAMETERS, "" + this.getUseHiddenParameters());
  }

  /**
   * This is not supposed to be a real clone method; it is just for making copies.
   *
   * @return
   */
  public abstract Object clone();
}