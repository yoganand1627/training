package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsCheckDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck;
import gov.georgia.dhr.dfcs.sacwis.service.common.SyncFaPersonDetailRecordsCheck;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Hai Nguyen
 * 
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------
 *   02/24/2011   hnguyen                  Initial Creation
 *   02/24/2011   hnguyen                  Added initial business logic for doing the sync.
 *   03/31/2011   hnguyen                  SMS#97850: MR-075 Set last GCIC or NCIC regardless if due date
 *                                         is calculated or not.
 *   06/06/2011   hnguyen                  SMS#111056: Due date to be an additional 1 year if 5 year RC period had not
 *                                         lapse at the end of the approval period.
 *   09/07/2011   hnguyen                  STGAP00017009: Due date to be an additional 1 year if 5 year RC period had not
 *                                         lapse by the end of the calculated due date.
 *   
 * </pre>
 * 
 */

public class SyncFaPersonDetailRecordsCheckImpl extends BaseServiceImpl implements SyncFaPersonDetailRecordsCheck {
  private CapsResourceDAO capsResourceDAO = null;

  private PersonDtlDAO personDtlDAO = null;
  
  private RecordsCheckDAO recordsCheckDAO = null;
  
  private CapsResource capsResource = null;

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  public void setRecordsCheckDAO(RecordsCheckDAO recordsCheckDAO) {
    this.recordsCheckDAO = recordsCheckDAO;
  }
  
  public void syncFaPersonDetailRecordsCheck(int idPerson) {
    PersonDtl recCheckPersonDtl = getPersistentObject(PersonDtl.class, idPerson);

    if (recCheckPersonDtl == null || idPerson == 0){
      // this should never happen, but just in case
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    capsResource = capsResourceDAO.findCapsResourceByIdResourceHhMemberPerson(idPerson);
  
    // Sync record checks
    syncGcicRecordsCheck(recCheckPersonDtl);
    syncNcicRecordsCheck(recCheckPersonDtl);
    
    personDtlDAO.savePersonDtl(recCheckPersonDtl);
  }
  
  private void syncGcicRecordsCheck(PersonDtl recCheckPersonDtl){
    RecordsCheck lastGcicRecCheck = recordsCheckDAO.findLatestCompletedRecordsCheckByIdRecCheckPersonByCdRecCheckCheckType(recCheckPersonDtl.getPerson().getIdPerson(), CodesTables.CCHKTYPE_GC);

    if(lastGcicRecCheck != null){
      Date dtLastGcicRcCheck = lastGcicRecCheck.getDtRecCheckCompleted();
      Date dtGcicRcCheckDue = null;

      if(capsResource != null && capsResource.getDtLicEnd() != null){
        // set next check due 5 years later
        dtGcicRcCheckDue = DateHelper.addToDate(dtLastGcicRcCheck, 5, 0, 0);
  
        Calendar calGcicRc5Year = Calendar.getInstance();
        Calendar calGcicRcDue = Calendar.getInstance();
        Calendar calDtLicEnd = Calendar.getInstance();
        
        calGcicRc5Year.setTime(dtGcicRcCheckDue);
        calGcicRcDue.setTime(dtGcicRcCheckDue);
        calDtLicEnd.setTime(capsResource.getDtLicEnd());
        
        //  set month and day due from earliest month/day from FAD(s) Approval End date
        calGcicRcDue.set(Calendar.MONTH, calDtLicEnd.get(Calendar.MONTH));
        calGcicRcDue.set(Calendar.DAY_OF_MONTH, calDtLicEnd.get(Calendar.DAY_OF_MONTH));
        
        // check if 5 year would lapse on the calculated due date.
        // if not then increment due date by one year.
        // the deciding factor here is when the month and day fall.
        if(calGcicRc5Year.compareTo(calGcicRcDue) > 0){
            calGcicRcDue.add(Calendar.YEAR, 1);
        }
        
        // reference new Date
        dtGcicRcCheckDue = calGcicRcDue.getTime();
        
      }
  
      // set last check completed regardless if due calculated or not.
      recCheckPersonDtl.setDtLastGcicRc(dtLastGcicRcCheck);
      recCheckPersonDtl.setDtGcicRcDue(dtGcicRcCheckDue);
    }else{
      recCheckPersonDtl.setDtLastGcicRc(null);
      recCheckPersonDtl.setDtGcicRcDue(null);
    }
  }
  
  private void syncNcicRecordsCheck(PersonDtl recCheckPersonDtl){
    RecordsCheck lastNcicRecCheck = recordsCheckDAO.findLatestCompletedRecordsCheckByIdRecCheckPersonByCdRecCheckCheckType(recCheckPersonDtl.getPerson().getIdPerson(), CodesTables.CCHKTYPE_NC);
    
    if(lastNcicRecCheck != null){
      Date dtLastNcicRcCheck = lastNcicRecCheck.getDtRecCheckCompleted();
      Date dtNcicRcCheckDue = null;

      if(capsResource != null && capsResource.getDtLicEnd() != null){
        // set next check due 5 years later
        dtNcicRcCheckDue = DateHelper.addToDate(dtLastNcicRcCheck, 5, 0, 0);
  
        Calendar calNcicRc5Year = Calendar.getInstance();
        Calendar calNcicRcDue = Calendar.getInstance();
        Calendar calDtLicEnd = Calendar.getInstance();
        
        calNcicRc5Year.setTime(dtNcicRcCheckDue);
        calNcicRcDue.setTime(dtNcicRcCheckDue);
        calDtLicEnd.setTime(capsResource.getDtLicEnd());
        
        //  set month and day due from earliest month/day from FAD(s) Approval End date
        calNcicRcDue.set(Calendar.MONTH, calDtLicEnd.get(Calendar.MONTH));
        calNcicRcDue.set(Calendar.DAY_OF_MONTH, calDtLicEnd.get(Calendar.DAY_OF_MONTH));
        
        // check if 5 year would lapse on the calculated due date.
        // if not then increment due date by one year.
        // the deciding factor here is when the month and day fall.
        if(calNcicRc5Year.compareTo(calNcicRcDue) > 0){
            calNcicRcDue.add(Calendar.YEAR, 1);
        }
        
        // reference new Date
        dtNcicRcCheckDue = calNcicRcDue.getTime();
        
      }

      // set latest check completed regardless if due date is calculated or not.
      recCheckPersonDtl.setDtLastNcicRc(dtLastNcicRcCheck);
      // set due date
      recCheckPersonDtl.setDtNcicRcDue(dtNcicRcCheckDue);
    }else{
      recCheckPersonDtl.setDtLastNcicRc(null);
      recCheckPersonDtl.setDtNcicRcDue(null);
    }
  }
  
}