package gov.georgia.dhr.dfcs.sacwis.web.core.tags;

// java classes

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;

/**
 * This custom tag will take an Iterator of CodeAttributes objects that has been returned from the Codes Table Lookup
 * Framework and will populate them into a Option/Combo box.  The options will be populated in the order they occur in
 * the Iterator -- which may be modified by the end user after receiving it from the lookup framework but prior to
 * setting it as an attribute of this tag.
 *
 * @author Randy O'Neil, October 3, 2001
 */
public class CodesOptionBoxTag extends SelectTag {

  /**
   * This method will accept the name for the option box.  The method is called through the name attribute on the tag
   * definition.  The name is set to "city" in this example: <prs:codesOptionBox <b>name="city"</b> iterator="<%=
   * myIterator %>" />
   *
   * @param name The name to define for the resulting option box
   */
  public void setName(String name) {
    super.setName(name);
  }

  /**
   * This method will accept the iterator that will populate the options in this option box. The method is called
   * through the iterator attribute on the tag definition.  The iterator is set to be the myIterator variable in this
   * example: <prs:codesOptionBox name="city" <b>iterator="<%= myIterator %>"</b> />
   *
   * @param iterator The iterator to use to populate the option box
   */
  public void setIterator(Iterator iterator) {
    //translates the CodesAttributes objects  returned by the Lookup.getCategoryListing
    //or Lookup.getChildCategoryListing into an OrderedMap
    GrndsTrace.enterScope(TRACE_TAG + ".setIterator");
    List options = new ArrayList();

    while (iterator.hasNext()) {
      CodeAttributes attribute = (CodeAttributes) iterator.next();
      options.add(attribute);
    }

    super.setOptions(options);
    GrndsTrace.exitScope();
  }

  /**
   * This method will set the default code to be displayed in the dropdown box. This is useful in the event where the
   * developer wants to display the current selection and allow the user to change that value with the dropdown box of
   * choices. The default code is passed into the tag as shown in this example: <prs:codesOptionBox name="city"
   * iterator="<%= myIterator %>" <b>defaultCode="<%= defaultCode %>"</b> />
   *
   * @param String The string that is the default setting for the option box
   */
  public void setDefaultCode(String defaultCode) {
    super.setValue(defaultCode);
  }

  /**
   * This method will accept the code table name that will populate the options in this option box. The method is called
   * through the codesTable attribute on the tag definition. <prs:codesOptionBox name="city" <b>iterator="<%= myIterator
   * %>"</b> />
   *
   * @param iterator The iterator to use to populate the option box
   */
  public void setCodesTable(String codesTable) {
    GrndsTrace.enterScope(TRACE_TAG + ".setConstraint");
    if (codesTable != null && !"".equals(codesTable)) {
      //Iterator iterator = options.entrySet().iterator();
      try {
        Iterator categoryIterator = Lookup.getCategoryListing(codesTable);
        //BEE Iterator categoryIterator = categoryList.iterator();
        this.setIterator(categoryIterator);
      }
      catch (LookupException le) {
        //Do nothing for now
      }
    }
    GrndsTrace.exitScope();
  }

  // static constants
  private static final String TRACE_TAG = "CodesOptionBoxTag"; //for tracing

}






