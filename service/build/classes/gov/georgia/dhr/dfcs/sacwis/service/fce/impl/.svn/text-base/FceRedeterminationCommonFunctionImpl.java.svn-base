package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceReview;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.LegalActionCrtLang;
import gov.georgia.dhr.dfcs.sacwis.db.LegalActionOutcome;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.service.fce.FceRedeterminationCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

/*
Change History:
 Date      User              Description
 --------  ----------------  --------------------------------------------------
 12/29/10  hnguyen           SMS#89026; MR-053 Corrected Judicial Requirement comment to not display if not applies.                           
 02/09/11  Hai Nguyen        SMS#95590: Update logic as to how to determine judicial requirements as needed for
                             reimbursability determination. Extension order only applies if child is not in
                             permanent custody according to current legal status.                                                                                                                                                                                                         
 02/11/11  Hai Nguyen        SMS#95590: Further updated logic to get latest permanency hearing that has reasonable
                             effort for finalizing permanency. Updated extension of
                             custody check to look at most recent legal status instead of legal action.                                                                                                                                                                                                         
 
*/

public class FceRedeterminationCommonFunctionImpl extends BaseServiceImpl implements FceRedeterminationCommonFunction {
  
  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;
  
  private FceEligibilityDAO fceEligibilityDAO = null;

  private FceReviewDAO fceReviewDAO = null;

  private LegalActionDAO legalActionDAO = null;
  
  private LegalStatusDAO legalStatusDAO = null;
  
  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }

  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }
  
  public void setFceReviewDAO(FceReviewDAO fceReviewDAO) {
    this.fceReviewDAO = fceReviewDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public FceEligibilityDB retrieveEligibilityByIdFceApplication(long idFceApplication) {
    long idFceEligibility = fceEligibilityDAO.findFceEligibilityByIdFceApplication(idFceApplication);
    FceEligibility fceEligibility = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(idFceEligibility);
    if (fceEligibility == null) {
      return null;
    }
    return PopulateFceUtility.populateFceEligibilityDB(fceEligibility);
  }
  
  public int updateFceEligibilityCdBlocChild(long idFceEligibility, String cdBlocChild) {
    FceEligibility fceEligibility = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(idFceEligibility);
    fceEligibility.setCdBlocChild(cdBlocChild);
    fceEligibilityDAO.saveFceEligibility(fceEligibility);
    return 1;
  }
  
  public void updateReimbursabilityJudicialRequirements(FceReviewDB fceReviewDB) {
    FceEligibility fceEligibility = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(fceReviewDB.getIdFceEligibility());
    FceReview fceReview = fceReviewDAO.findFceReviewByIdFceReview(fceReviewDB.getIdFceReview());
    int idCase = fceEligibility.getCapsCase().getIdCase();
    int idPerson = fceEligibility.getPersonByIdPerson().getIdPerson();
    
    Date dtMostRecentRemoval = fceReview.getFceApplication().getDtRemovalDate();
    
    if( dtMostRecentRemoval == null ){
      dtMostRecentRemoval = cnsrvtrshpRemovalDAO.findLatestCnsrvtrshpRemovalDatetByIdCase(
                                                                idCase, 
                                                                idPerson);
    }
    
    if( dtMostRecentRemoval == null ){
      // this should never occur, but just in case
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    LegalStatus ls = legalStatusDAO.findMostRecentLegalStatusByIdPersonIdCase(idPerson, idCase);
    
    //In DFCS Custody legal statuses
    List<String> cdInDFCSCustodyLegalStatuses = new ArrayList<String>();
    cdInDFCSCustodyLegalStatuses.add(CodesTables.CLEGSTAT_PCT); // Permanent Court
    cdInDFCSCustodyLegalStatuses.add(CodesTables.CLEGSTAT_PVL); // Permanent Voluntary
    cdInDFCSCustodyLegalStatuses.add(CodesTables.CLEGSTAT_JCP); // Joint Commitment with DJJ - Permanent Court
    cdInDFCSCustodyLegalStatuses.add(CodesTables.CLEGSTAT_TCT); // Temporary Court
    cdInDFCSCustodyLegalStatuses.add(CodesTables.CLEGSTAT_TVL); // Temporary Voluntary
    cdInDFCSCustodyLegalStatuses.add(CodesTables.CLEGSTAT_JCT); // Joint Commitment with DJJ - Temporary Court
    
    if( cdInDFCSCustodyLegalStatuses.contains( ls.getCdLegalStatStatus()) ){
      // child is in dfcs custody

      Calendar calToday = Calendar.getInstance();
      
      Calendar calYearAgoToday = (Calendar) calToday.clone();
      calYearAgoToday.add(Calendar.YEAR, -1);
      
      Calendar calRemovalStart = Calendar.getInstance();
      calRemovalStart.setTime(dtMostRecentRemoval);
          
      Calendar calYearFromRemoval = (Calendar) calRemovalStart.clone();
      calYearFromRemoval.add(Calendar.YEAR, 1);
      
      // this may be null if no permanency hearing exists that addresses
      // reasonable efforts to finalize permanency plan
      Date dtCourtOrder = getLatestPermanencyHearingCourtOrderDateByIdCaseByIdPerson(
                                                                               idCase, 
                                                                               idPerson);

      Date dtCustodyExpiration = ls.getDtLegalStatCusExpDt();
            
      if( calToday.before(calYearFromRemoval) ){
        // child in custody for less than a year
        // therefore permanency hearing reasonable effort to finalize not required
        // but if there is one set the date
        fceReview.setIndPrmncyHearingsDue("N");
        fceReview.setIndPrmncyHrngs12Month((dtCourtOrder != null ? "Y" : "N"));
        fceReview.setDtPrmncyHrngs12Month(dtCourtOrder);
  
        // less than 12 months in custody, not required
        // but if there is an extension then set date
        fceReview.setIndExtnsionProvided12Mnths((dtCustodyExpiration != null ? "Y" : "N"));
        // only set date legal status provided custody if there is a custody expiration date.
        fceReview.setDtExtnsionProvided12Mnths(dtCustodyExpiration);
      } else {        
        // permanency plan is always due beyond one year of removal
        fceReview.setIndPrmncyHearingsDue("Y");
        
        // court order date determines if IV-E Reimbursable or not
        fceReview.setIndPrmncyHrngs12Month((dtCourtOrder != null ? "Y" : "N"));
        fceReview.setDtPrmncyHrngs12Month(dtCourtOrder);
  
        //permanent custody legal statuses
        List<String> cdPermCustodyLegalStatuses = new ArrayList<String>();
        cdPermCustodyLegalStatuses.add(CodesTables.CLEGSTAT_PCT); // Permanent Court
        cdPermCustodyLegalStatuses.add(CodesTables.CLEGSTAT_PVL); // Permanent Voluntary
        cdPermCustodyLegalStatuses.add(CodesTables.CLEGSTAT_JCP); // Joint Commitment with DJJ - Permanent Court
                
        if( cdPermCustodyLegalStatuses.contains(ls.getCdLegalStatStatus()) ){
          // Child in permanent custody therefore custody extension check not required
          fceReview.setIndExtnsionProvided12Mnths(null);
          fceReview.setDtExtnsionProvided12Mnths(null);
        }else{
          // temporary custody legal status, so custody extension check required.
          if( dtCustodyExpiration != null ){
            // year from court order date minus 1 day
            Calendar calCustodyExpiration = Calendar.getInstance();
            calCustodyExpiration.setTime(dtCustodyExpiration);
            
            // Custody expires during or after 
            // current month of reimbursability determination
            // therefore may still be IV-E Reimbursable until end of current month and after.
            if((calCustodyExpiration.get(Calendar.YEAR) > calToday.get(Calendar.YEAR))){
              // regardless, if custody expiration year is greater, set date
              fceReview.setIndExtnsionProvided12Mnths("Y");
              fceReview.setDtExtnsionProvided12Mnths(dtCustodyExpiration);
            } else if( (calCustodyExpiration.get(Calendar.MONTH) >= calToday.get(Calendar.MONTH)) 
                & (calCustodyExpiration.get(Calendar.YEAR) >= calToday.get(Calendar.YEAR)) ){
              // this is to handle expiration in the same year, where month need to be equal or greater
              fceReview.setIndExtnsionProvided12Mnths("Y");
              fceReview.setDtExtnsionProvided12Mnths(dtCustodyExpiration);
            }else{
              // Even though we have legal status in dfcs custody, custody had lapse
              // therefore latest legal status is no longer valid and not IVE Reimbursable
              fceReview.setIndExtnsionProvided12Mnths("N");
              fceReview.setDtExtnsionProvided12Mnths(null);
            }
          }else{
            // Even though we have legal status in dfcs custody, no custody expiration date
            // therefore not IV-E Reimbursable
            fceReview.setIndExtnsionProvided12Mnths("N");
            fceReview.setDtExtnsionProvided12Mnths(null);
          }
        } // end if permanent custody check
      } // end else      
    } else {
      // not in dfcs custody status so clear out all check
      fceReview.setIndPrmncyHearingsDue(null);
      fceReview.setIndPrmncyHrngs12Month(null);
      fceReview.setDtPrmncyHrngs12Month(null);
      fceReview.setIndExtnsionProvided12Mnths(null);
      fceReview.setDtExtnsionProvided12Mnths(null);      
    } // end else in dfcs custody
    
    fceReviewDAO.saveFceReview(fceReview);
    FceReviewDB reviewDB = PopulateFceUtility.populateFceReviewDB(fceReview);
    reviewDB.copyInto(fceReviewDB);
  } // end method
  
  /*
   * This method will retrieve the latest permanency hearing legal action by court order date
   * that has court languange for reasonable efforts to finalize permanency plan
   * if so return the court order date of that legal action if it had not expired.
   * Also note the permanency plan period ends one year form the court order date minus 1 day.
   */
  private Date getLatestPermanencyHearingCourtOrderDateByIdCaseByIdPerson(int idCase, int idPerson){
    LegalAction legalAction = null;
    Collection<LegalActionCrtLang> cdLegalActionCrtLangs = null;
    
    legalAction = legalActionDAO.findLatestPrmncyHrgWithReasonbleEffByIdCaseByIdPerson(
                                                                               idCase,
                                                                               idPerson);
    
    if( legalAction != null ){
      Date dtCourtOrder = legalAction.getDtCrtOrdDate();
      
      if( dtCourtOrder != null ){
        // court language contains reason effort made to finalized permanency plan
        Calendar calToday = Calendar.getInstance();
        
        // year from court order date minus 1 day
        Calendar calYearFromCourtOrder = Calendar.getInstance();
        calYearFromCourtOrder.setTime(dtCourtOrder);
        calYearFromCourtOrder.add(Calendar.YEAR, 1);
        calYearFromCourtOrder.add(Calendar.DAY_OF_MONTH, -1);
        
        // Annual Permanency Plan expires during or after 
        // current month of reimbursability determination
        // therefore may still be IV-E Reimbursable until end of current month and after.
        if((calYearFromCourtOrder.get(Calendar.YEAR) > calToday.get(Calendar.YEAR))){
          // regardless if permanency plan expiration year is greater, return date
          return dtCourtOrder;
        } else if( (calYearFromCourtOrder.get(Calendar.MONTH) >= calToday.get(Calendar.MONTH)) 
                        & (calYearFromCourtOrder.get(Calendar.YEAR) >= calToday.get(Calendar.YEAR)) ){
          // since year is the same, we check the month Permanency plan expires
          return dtCourtOrder;
        }
      }
    }
    // no legal action with court language of reasonable effort made to 
    // finalize permanency plan within period
    return null;
  }
}
