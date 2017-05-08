package gov.georgia.dhr.dfcs.sacwis.web.document;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag;

/**
 * <p>Title: Spell Check Tag</p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author Stephen Roberts
 * @version 1.0
 */

public class SpellCheckTag extends ButtonTag {

  // SPB 6/16/2003 - Modified Spell Check Tag to extend button tag SIR 18114
  private String formToSpellCheck = null;
  private String fieldsToSpellCheck = null;
  private static final String SPELL_CHECK_IMAGE = "btnSpellCheck";

  public SpellCheckTag() {
    super();
    super.setImg(SPELL_CHECK_IMAGE);
  }

  public int doStartTag()
          throws JspException {
    super.setFunction("spellCheckPage('" + formToSpellCheck + "'); return false;");
    super.setAction("/not/a/real/path");
    super.setName("spellCheckButton");
    super.setForm(this.formToSpellCheck);
    return super.doStartTag();
  }

  public int doEndTag() throws JspException {
    super.doEndTag();
    // Write out the image that will launch the spell
    StringBuffer stringBuffer = new StringBuffer();

    // Write out the hidden field that holds the names of the fields to be spell checked.
    stringBuffer.append("<input type=\"hidden\" name=\"hidSpellFields\" value=\"");
    if (fieldsToSpellCheck != null) {
      stringBuffer.append(fieldsToSpellCheck);
    }
    stringBuffer.append("\">");

    JspWriter jspWriter = pageContext.getOut();
    try {
      jspWriter.println(stringBuffer.toString());
    }
    catch (Exception e) {
      throw new JspException(e);
    }
    return EVAL_PAGE;

  }

  public String getFormToSpellCheck() {
    return this.formToSpellCheck;
  }

  public void setFormToSpellCheck(String form) {
    this.formToSpellCheck = form;
  }

  public String getFieldsToSpellCheck() {
    return this.fieldsToSpellCheck;
  }

  public void setFieldsToSpellCheck(String fields) {
    this.fieldsToSpellCheck = fields;
  }

}


