package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ---------------------------------------------------------
 * 05/10/10  hjbaptiste               Initial creation
 * 09/14/10  wjcochran                SMS#67942 - Update the check to see if the returned in-custody
 *                                    legal statuses are from open cases. Only open cases should be
 *                                    considered for maltreatment in care.
 * 06/07/11  cwells                   CAPTA 4.3 Adding Maltreatment In Care logic for Intake and Inv Allegations.
 * 01/20/12  habraham                 STGAP00017829 - MR-097 : Unsubstantiated MIC - The method signature for the checkIfMaltreatmentInCare 
 *                         			  has changed and added the logic for unSubstantiated MIC 		                                        
 * 
 * </pre>
 *
 * @author Herve Jean-Baptiste May 10, 2010
 */

import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.service.common.CheckIfMaltreatmentInCare;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfMaltreatmentInCareSI;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckIfMaltreatmentInCareImpl extends BaseServiceImpl implements CheckIfMaltreatmentInCare {

  private CapsCaseDAO capsCaseDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public Map<String,Boolean> checkIfMaltreatmentInCare(CheckIfMaltreatmentInCareSI checkIfMaltreatmentInCareSI) {
    int idVictim = checkIfMaltreatmentInCareSI.getIdVictim();
    int idCase = checkIfMaltreatmentInCareSI.getIdCase();
    Map<String,Boolean> mapMIC= new HashMap<String,Boolean>();
    String cdAllegDisposition = checkIfMaltreatmentInCareSI.getAllegDisposition();
    String cdStageType = checkIfMaltreatmentInCareSI.getCdStageType();
    String cdMaltreatorRel = checkIfMaltreatmentInCareSI.getCdMaltreatorRel();
    Date dtAllegedIncident = checkIfMaltreatmentInCareSI.getDtAllegedIncident();
    boolean matreatmentInCare = false;
    boolean unsubstantiated = false;
    boolean isUnSubMIC = false;

    // 4.3 CAPTA Maltreatment of Care Relationship types.
    // Foster/Adoptive Parent (Legal Risk)
    // Foster Parent (CPA/CCI)
    // Foster Parent (DFCS)
    // Adoptive Parent
    // Residential Facility Staff (DFCS)
    // Residential Facility Staff (Non DFCS)
    // Relative Foster Parent ** Not found in CRPTRINT
    // Relative Placement Provider
    List<String> micRelType = new ArrayList<String>();
    micRelType.add(CodesTables.CRPTRINT_AF);
    micRelType.add(CodesTables.CRPTRINT_FA);
    micRelType.add(CodesTables.CRPTRINT_FP);
    micRelType.add(CodesTables.CRPTRINT_PT);
    micRelType.add(CodesTables.CRPTRINT_RD);
    micRelType.add(CodesTables.CRPTRINT_RN);
    micRelType.add(CodesTables.CRPTRINT_RP);
    micRelType.add(CodesTables.CRELPRN2_AF);

    if (CodesTables.CSTAGES_INV.equals(cdStageType) && !CodesTables.CDISPSTN_SUB.equals(cdAllegDisposition)) {
      unsubstantiated = true;
    }

    // Look in the Legal Status View to see if Date of Alleged Incident falls within an 'In DFCS Care' period.
    // If child is 'In DFCS Care', this indicates Maltreatment In Care.
    List<Integer> inCustodyLegaStatuses = legalStatusDAO.findInDFCSCareLegalStatus(idVictim, idCase, dtAllegedIncident);
    if (inCustodyLegaStatuses != null && !inCustodyLegaStatuses.isEmpty() && micRelType.contains(cdMaltreatorRel)) {
      /*
       * SMS#67942 - If an in custody legal status is returned, check to see that it comes from an open case. Only open
       * cases should be considered.
       */
      for (Integer idLegalStatusEvent : inCustodyLegaStatuses) {
        Integer idCaseForLglStat = legalStatusDAO.findIdCaseForLegalStatusByIdLegalStatEvent(idLegalStatusEvent);
        CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCaseForLglStat);
        Date dtCaseClosed = capsCase.getDtCaseClosed();
        if (dtCaseClosed == null) {  
        	//if the child is in Custody of DFCS when the MIC happened and the disposition is Substantiated 
        	// then MICind is true else UnSubMIC is true        	
         if(!unsubstantiated)	
           matreatmentInCare = true;
         else 
        	 isUnSubMIC = true;
        
        }
      }
    }
    
    mapMIC.put("isMIC", matreatmentInCare);
    mapMIC.put("isUnSubMIC", isUnSubMIC);
    
    return mapMIC;
  }

}
