package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD08SO;

public interface SaveHomeDemographics {
  /** May want to put these in the CodesTales later */
  static final String UNIT_MEMBER_IN_ASSIGNED = CodesTables.CUMINOUT_IN;
  static final String UNIT_MEMBER_OUT_ASSIGNED = CodesTables.CUMINOUT_OUT;
  static final String DEMOGRAPHICS_TODO_UPDATE_STATUS = "FAD046";
  static final int FA_SIT_OCCUR = 1;
  static final String DEMOG_LONG_LITERAL =
          "The F/A Home has been an Inquiry for 12 months. Some action should be taken to progress the home.";
  static final String DEMOG_LITERAL_1 = "If ";
  static final String DEMOG_LITERAL_2 = " is still in Inquiry, please follow up.";
  static final String FA_CATG_FOST = CodesTables.CFACATEG_F;  
  static final String FA_CATG_ICPC = CodesTables.CFACATEG_I;  
  static final String FA_CATG_REL_ADOPT = CodesTables.CFACATEG_D;  
  static final String FA_CATG_REL_FOST = CodesTables.CFACATEG_O;
  static final String FA_CATG_ADOPT = CodesTables.CFACATEG_A;
  static final String FA_CATG_LEG_RISK = CodesTables.CFACATEG_L;
  static final int TS_EVENT = 0;//changed this to be equivalent to what it is from cfad08s
  static final int MAX_NUM_ADDR_ROWS = 15;
  static final int MAX_NUM_PHONE_ROWS = 15;
  static final int MAX_NUM_ETHNICITY_ROWS = 15;
  static final int MAX_NUM_CHARACTERISTICS_ROWS = 50;
  static final int FIRST_REC = 0;
  static final int ADOPTIVE = 2;
  static final int FOSTER = 1;
  static final int ONE = 1;
  static final int TWO = 2;
  static final int ZERO = 0;
  static final int NBR_OF_HOME_TYPE = 7;
  static final int HUNDRED = 100;

  /**
   * This service will either add a new F/A Home to CAPS or will modify Home Demographic information on an existing
   * home.  It will also perform event status checking, call post event, and update any To - Do's.
   * <p/>
   * Based on the RESOURCE_ADDRESS to CAPS_RESOURCE trigger, we must sequentially perform deletes, updates, and then
   * adds.  This will prevent the Address on Caps Resource from being set to NULL while a Primary Address exists on
   * Resource
   * <p/>
   * When a new Version is added (this happens when the primary address changes to another county), County Records will
   * be end dated for Adoptive Contracts as well as the Foster Care Contracts. In addition, we will insert Version and
   * County line items with the same end date as the prior Version had, not 100 years from today.
   * <p/>
   *
   * @param cfad08si {@link CFAD08SI} object
   * @return {@link CFAD08SO} object
   */
  public CFAD08SO saveHomeDemographics(CFAD08SI cfad08si);

}
