package gov.georgia.dhr.dfcs.sacwis.web.core.tags;

// java classes

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.log.GrndsTrace;

public abstract class BaseDocParameterTag extends TagSupport
        implements DocParameterInterface {
  public static String TRACE_TAG = "BaseDocParameterTag";

  private String value;
  private String name;

  public BaseDocParameterTag() {
    super();
  }

  public BaseDocParameterTag(String val) {
    super();
    this.setValue(val);
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setValue(String val) {
    this.value = val;
  }

  public String getValue() {
    return this.value;
  }

  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    createParameter();

    GrndsTrace.exitScope();
    return super.SKIP_BODY;
  }

  protected void createParameter() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".createReportParameter");
    BaseDocTag parent = (BaseDocTag) findAncestorWithClass(
            this, BaseDocTag.class);
    parent.addParameter((DocParameterInterface) this.clone());
    GrndsTrace.exitScope();
  }

  public abstract Object clone();
}