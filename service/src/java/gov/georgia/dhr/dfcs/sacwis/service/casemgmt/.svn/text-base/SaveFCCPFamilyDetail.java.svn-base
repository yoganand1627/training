package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSaveSO;

public interface SaveFCCPFamilyDetail {
  public static final String AFTER_CARE = CodesTables.CCTPLNTY_AFC; 
  /**
   * Save all relevant info of family case plan to FCCP_FAMILY, PLAN_STEP, PLAN_PARTICIPANT, 
   * A copy of all current principals for the plan is kept so that if any principal is deselected, that entry will be removed from 
   * EVEN_PERSON
   * @param principalsForEventfromState, saveFCCPFamilyDetailSI
   * @return FCCPFamilyDetailSaveSO
   */
  FCCPFamilyDetailSaveSO saveFCCPFamilyDetail(List<FCCPFamilyDetailSO.RowPlanPrincipal> principalsForEventfromState, FCCPFamilyDetailSO saveFCCPFamilyDetailSI);
}
