package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildLifeHistoryCheckListSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildLifeHistoryCheckListSO;
/**
 * Child Life History Checklist service interface 
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  07/24/2008  ssubram STGAP00009509: Child life History check list has been added
 * </pre>
 *
 */
public interface ChildLifeHistoryCheckList extends DocumentService {
  // The page size constant is also defined in PlacementLogConversation.  Both should
  // be set to the same value.
  public static final int PAGE_SIZE = 100;
  public static final String SORT_O = "O";
  
  // Other in-line bookmarks throughout the form
  public static final String COUNTY = "COUNTY";
  public static final String CHILD_NAME = "CHILD_NAME";
  public static final String DOB = "DOB";
  
  /**
   * The retrieveChildLifeHistoryCheckList method is the main entry point for the service.
   * 
   * @param childLifeHistoryCheckListSI
   *          Input object which should contain the Stage ID.
   * @return ChildLifeHistoryCheckListSO Output object which contains prefill data
   */
  public ChildLifeHistoryCheckListSO retrieveChildLifeHistoryCheckList(ChildLifeHistoryCheckListSI childLifeHistoryCheckListSI);
}
