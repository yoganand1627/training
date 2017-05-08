package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

// -- grnds classes --

import javax.servlet.jsp.JspException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;

/**
 * Custom tag for fields that are display only, but need to have the value submitted in the request and need to be
 * redisplayed if data is invalid
 *
 * @author Bradley Eilers
 * @version 1.0
 */
public class DisplayOnlyInputTag extends InputTag {

  public DisplayOnlyInputTag() {
    super();
  }

  /**
   * Sets the custom select tag attribute: options
   *
   * @param codesTableName The name of a codes table.  The values will be set into the options for this tag.
   */
  public void setCodesTable(String codesTableName) throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".setCodesTable");
    //Set codes table
    this.codesTableName = codesTableName;
    GrndsTrace.exitScope( /*codesTableName*/);
  }

  /**
   * Sets the flag indicating whether formatting should be maintained with a "pre" tag.
   *
   * @param maintain The boolean indicating whether to use the "pre" tag or not
   */
  public void setMaintainFormatting(boolean maintain) throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".setMaintainFormatting");
    //Set maintainFormatting
    this.maintainFormatting = maintain;
    GrndsTrace.exitScope( /*setMaintainFormatting*/);
  }

  /**
   * Creates the opening HTML tag for this input.
   *
   * @return String containing HTML
   */
  protected String createOpeningHtml() {
    GrndsTrace.enterScope(TRACE_TAG + ".createOpeningHtml");

    StringBuffer buffer = new StringBuffer();
    StringBuffer htmlBuffer = new StringBuffer();
    StringBuffer labelBuffer = new StringBuffer(super.createLabelHtml());

    //If a codes table was specified, use Lookup to get the decode for the specified value.
    htmlBuffer.append("<span id=\"").append(super.getName()).append("_id\">");
    if (codesTableName != null) {
      htmlBuffer.append(Lookup.simpleDecodeSafe(codesTableName, super.getValue()));
    } else {
      if (this.maintainFormatting) {
        htmlBuffer.append("<pre>");
      }
      htmlBuffer.append(super.getValue());
      if (this.maintainFormatting) {
        htmlBuffer.append("</pre>");
      }
    }
    htmlBuffer.append("</span>");
    htmlBuffer.append(super.createViewModeHiddenField());
    buffer = labelBuffer.append(htmlBuffer.toString());

    GrndsTrace.exitScope();
    return buffer.toString();
  }

  // -- static constants --
  private static final String TRACE_TAG = "DisplayOnlyInputTag";
  private String codesTableName = null;
  private boolean maintainFormatting = false;

}