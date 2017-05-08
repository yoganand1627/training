package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceApplicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FcePersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.FceReview;
import gov.georgia.dhr.dfcs.sacwis.service.fce.AgeAndCitizenshipCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class AgeAndCitizenshipCommonFunctionImpl extends BaseServiceImpl implements AgeAndCitizenshipCommonFunction {
  
  private FceApplicationDAO fceApplicationDAO = null;

  private FceEligibilityDAO fceEligibilityDAO = null;
  
  private FcePersonDAO fcePersonDAO = null;
  
  private FceReviewDAO fceReviewDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  public void setFceApplicationDAO(FceApplicationDAO fceApplicationDAO) {
    this.fceApplicationDAO = fceApplicationDAO;
  }

  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }
  
  public void setFcePersonDAO(FcePersonDAO fcePersonDAO) {
    this.fcePersonDAO = fcePersonDAO;
  }

  public void setFceReviewDAO(FceReviewDAO fceReviewDAO) {
    this.fceReviewDAO = fceReviewDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  /*
   * The following function updates the personCitizenship value in Fce_Eligibility table (non-Javadoc)
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.service.fce.FceService#updateFceEligibilityCdPersonCitizenship(long,
   *      java.lang.String)
   */
  public void updateFceEligibilityCdPersonCitizenship(long idFceEligibility, String cdPersonCitizenship) {
    fceEligibilityDAO.updateFceEligibilityByCdPersonCitizenship(idFceEligibility, cdPersonCitizenship);
  }

  public void updateFceApplicationIndEvalConclusion(long idFceApplication, String indEvaluationConclusion) {

    fceApplicationDAO.updateFceApplicationByIndEvalConclusion(idFceApplication, indEvaluationConclusion);
  }
  
  public FcePersonDB findFcePersonByIdFceEligibilityAndIdPerson(long idFceEligibility, long idPerson) {
    FcePerson fcePerson = fcePersonDAO.findFcePersonByIdFceEligibilityAndIdPerson(idFceEligibility, idPerson);
    if (fcePerson == null) {
      return null;
    }
    return PopulateFceUtility.populateFcePersonDB(fcePerson);
  }
  
  public long findPrimaryChildForStage (long idStage, String cdStagePersonRole){
    int idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole((int) idStage, cdStagePersonRole);
    return (long) idPerson;
  }
  
  public FceReviewDB findReviewByReviewEvent(long idReviewEvent) {
    FceReview fceReview = fceReviewDAO.findFceReviewByIdReviewEvent(idReviewEvent);
    if (fceReview == null) {
      return null;
    }
    return PopulateFceUtility.populateFceReviewDB(fceReview);
  }
 
}
