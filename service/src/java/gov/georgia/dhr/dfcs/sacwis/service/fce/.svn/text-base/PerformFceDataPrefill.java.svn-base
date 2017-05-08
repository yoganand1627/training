package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.structs.input.FceDataPrefillSI;
  
/**
 * <b>Description:</b><br><br>
 * 
 * <p>This class actually pre-populates all of the Foster Care application pages when the user selects the 
 * 'Notification of Change'(NOC) radio button on the Application & Background page or the user 'Add' a new 
 * Redetermination. It finds the latest approved application. This can either be an application(Initial or NOC)
 * or a Redetermination. </p>
 * 
 * If the user is doing an NOC:<ul>
 *   <li>It uses the data from the latest FCE Application(Initial or NOC) if that has the most recent Complete Date; OR</li>
 *   <li>It uses the data from the latest FCE Redetermination and the latest FCE application(Initial or NOC)
 *       if a Redetermination has the most recent Complete Date</li></ul>
 *      
 * If the user is doing a Redetermination<ul>
 *   <li>It uses the data from the latest FCE Application(Initial or NOC) if that has the most recent Complete Date; OR</li>
 *   <li>It uses the data from the latest FCE Redetermination if a Redetermination has the most recent Complete Date</li></ul>
 * 
 *   
 * <b>Change History(Add entries within the &lt;pre&gt; tag):</b><br>
 * <pre>
 * 3/14/2008    hjbaptiste          The Judicial Section on the Eligibility Determination(Worksheet) page is now being
 *                                  populated. Added the newly created method - prefillWorksheetJudicialSection()
 *                                                
 * </pre>
 *                                  
 */                                  
public interface PerformFceDataPrefill {
  
  /**
   * <p>This is the main method that is called to do the pre-population of all FCE Application pages</p>
   * 
   * @param fceDataPrefillSI
   */
  public void doFceDataPrefill(FceDataPrefillSI fceDataPrefillSI);

}
