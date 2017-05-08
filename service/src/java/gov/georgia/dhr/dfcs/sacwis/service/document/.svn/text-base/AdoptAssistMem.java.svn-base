package gov.georgia.dhr.dfcs.sacwis.service.document;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptAssistMemSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoptAssistMemSO;

/**
 * Adoption Assistance Memorandum interface 
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  ------------------------------------------------------------
 *  08/22/2008  ssubram STGAP0000xxxx: Adoptive Assistance Memorandum has been added
 *  05/31/2011  schoi   SMS #109403: MR-082 Added constants for SSI information
 * </pre>
 *
 */

public interface AdoptAssistMem extends DocumentService {

  // The page size constant is also defined in PlacementLogConversation.  Both should
  // be set to the same value.
  public static final int PAGE_SIZE = 100;
  public static final String SORT_O = "O";
  public static final String ADOASSMEM = "ADOASSMEM";  
  
  // Other in-line bookmarks throughout the form
  public static final String COUNTY = "COUNTY";
  public static final String CASE_WORKER = "CASE_WORKER";
  public static final String TEL_NUMBER = "TEL_NUMBER";
  public static final String FAMILY_NAME = "FAMILY_NAME";
  public static final String FATHER = "FATHER";
  public static final String MOTHER = "MOTHER";
  public static final String ADDRESS = "ADDRESS";
  public static final String CHILD_BIRTH_NAME = "CHILD_BIRTH_NAME";
  public static final String DOB = "DOB";
  public static final String RACE = "RACE";
  public static final String SEX = "SEX";
  public static final String FC_MEDICAID = "FC_MEDICAID";
  public static final String SSN = "SSN";
  public static final String MA_CARD_NAME = "MA_CARD_NAME";
  public static final String DATE_FINALIZATION = "DATE_FINALIZATION";
  public static final String NEW_MA_NUMBER = "NEW_MA_NUMBER";
  public static final String NEW_SSN = "NEW_SSN";
  public static final String DATE_BEGIN = "DATE_BEGIN";
  public static final String DATE_END = "DATE_END";
  public static final String STATE_FUNDED_ADOPT_ASST = "STATE_FUNDED_ADOPT_ASST";
  public static final String CBX_STATE_FUNDED_ADOPT_ASST = "CBX_STATE_FUNDED_ADOPT_ASST";
  public static final String TITLE_IVE = "TITLE_IVE";
  public static final String CBX_TITLE_IVE = "CBX_TITLE_IVE";
  public static final String NON_RECURRING = "NON_RECURRING";
  public static final String CBX_NON_RECURRING = "CBX_NON_RECURRING";
  public static final String MONTH_PAID = "MONTH_PAID";
  public static final String PRIMARY = "PR";
  public static final String CBX_X = "X";
  public static final String BENFT_BEYND_18_YES = "BENFT_BEYND_18_YES";
  public static final String BENFT_BEYND_18_NO = "BENFT_BEYND_18_NO";
  public static final String TMPLAT_BIRTH_NAME = "TMPLAT_BIRTH_NAME";
  public static final String TMPLAT_BIRTH_IDS = "TMPLAT_BIRTH_IDS";
  
  // SMS #109403: MR-082
  public static final String AMOUNT_OF_SSI = "AMOUNT_OF_SSI";
  public static final String RECEIVE_SSI_YES = "RECEIVE_SSI_YES";
  public static final String RECEIVE_SSI_NO = "RECEIVE_SSI_NO";
  
  /**
   * The retrieveChildLifeHistoryCheckList method is the main entry point for the service.
   * 
   * @param childLifeHistoryCheckListSI
   *          Input object which should contain the Stage ID.
   * @return ChildLifeHistoryCheckListSO Output object which contains prefill data
   */
  public AdoptAssistMemSO retrieveAdoptAssistMem(AdoptAssistMemSI adoptAssistMemSI);
}
