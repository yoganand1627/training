package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoptionSubsidyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexAdoptionSubsidyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;

public class ComplexAdoptionSubsidyDAOImpl extends BaseDAOImpl implements ComplexAdoptionSubsidyDAO {
  AdoptionSubsidyDAO adoptionSubsidyDAO = null;

  public void setAdoptionSubsidyDAO(AdoptionSubsidyDAO adoptionSubsidyDAO) {
    this.adoptionSubsidyDAO = adoptionSubsidyDAO;
  }

  public void insertWithoutDateOverlap(int adptSubPerson, Date dtAdptSubEffective, Date dtAdptSubEnd,
                                       AdoptionSubsidy adoptionSubsidy, String cdAdptAudDeterm) throws ServiceException {
    // =================================================================
    // VALIDATE 1: Check if new records overlaps other records on LEFT
    // (works whether new record overlaps 1 or more existing records
    // =================================================================
    // *****************************************************************
    // Do not use <= or >= signs because dates can overlap on same day:
    //                OK:                         OVERLAP_1:
    // old:          +--+--+                      +--+--+--+
    //               +--+--+                      +--+--+--+
    // new:             +--+----------+              +--+------------+
    //                  +--+----------+              +--+------------+
    // ******************************************************************
    Integer result1 = adoptionSubsidyDAO.findIdPersonByDtAdptSubEnd(adptSubPerson, dtAdptSubEffective, dtAdptSubEnd);
    if (result1 != null) {
      boolean isType = checkPreviousType(cdAdptAudDeterm);
      if(isType){
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);
      }
    }
    // =================================================================
    // VALIDATE 2: Check if new records overlaps other records on RIGHT
    // (works whether new record overlaps 1 or more existing records
    // ==================================================================
    // *****************************************************************
    // Do not use <= or >= signs because dates can overlap on same day:
    //                           OK:                      OVERLAP_2:
    // old:                     +--+--+                   +--+--+--+
    //                          +--+--+                   +--+--+--+
    // new:          +----------+--+           +-------------+--+
    //               +----------+--+           +-------------+--+
    // *****************************************************************/
    Integer result2 = adoptionSubsidyDAO.findIdPersonByCdAdptSubCloseRsn(adptSubPerson, dtAdptSubEffective,
                                                                         dtAdptSubEnd);
    if (result2 != null) {
      boolean isType = checkPreviousType(cdAdptAudDeterm);
      if(isType){
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_2);
      }
    }
    // ====================================================================*/
    // VALIDATE 3: Check if new records is either identical OR within */
    // a record */
    // ====================================================================*/
    // *************************************************************************
    //                (1) (2)     (3)     (4)      (5)          (6)
    //               LEFT RIGHT IDENTICAL WITHIN
    // old:         +-+-+ +-+-+ +-+-+-+ +-+-+-+-+ +-+-+-+-+-+ +-+-+-+-+-+
    //              +-+-+ +-+-+ +-+-+-+ +-+-+-+-+ +-+-+-+-+-+ +-+-+-+-+-+
    //
    // new:         +-+     +-+ +-+-+-+   +-+-+    +-+-+-+        +-+-+-+
    //              +-+     +-+ +-+-+-+   +-+-+    +-+-+-+        +-+-+-+
    //               OK      OK   BAD      BAD       OK             OK
    // ***************************************************************************
    Integer result3 = adoptionSubsidyDAO.findIdPersonByAdptSubPerson(adptSubPerson, dtAdptSubEffective, dtAdptSubEnd);
    if (result3 != null) {
      boolean isType = checkPreviousType(cdAdptAudDeterm);
      if(isType){
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);
      }
    }
    adoptionSubsidyDAO.saveAdoptionSubsidy(adoptionSubsidy);
  }

  public void updateWithoutDateOverlap(int adptSubPerson, int idAdptSub, Date dtAdptSubEnd, Date dtAdptSubEffective,
                                       Date tsLastUpdate, String cdAdptAudDeterm, AdoptionSubsidy adoptionSubsidy)
          throws ServiceException {
    // =================================================================
    // VALIDATE 1: Check if new records overlaps other records on LEFT
    // (works whether new record overlaps 1 or more existing records
    // =================================================================
    // ****************************************************************
    // Do not use <= or >= signs because dates can overlap on same day:
    //                      OK:                  OVERLAP_1:
    // old:            +--+--+                    +--+--+--+
    //                 +--+--+                    +--+--+--+
    // new:               +--+----------+            +--+------------+
    //                    +--+----------+            +--+------------+
    // *****************************************************************
    Integer result1 = adoptionSubsidyDAO.findAdptSubPersonByIdAdptSub(idAdptSub, dtAdptSubEnd, dtAdptSubEffective,
                                                                      adptSubPerson);
    if (result1 != null) {
      boolean isType = checkPreviousType(cdAdptAudDeterm);
      if(isType){
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);
      }
    }

    // =================================================================
    // VALIDATE 2: Check if new records overlaps other records on RIGHT
    // (works whether new record overlaps 1 or more existing records
    // =================================================================
    // ****************************************************************
    // Do not use <= or >= signs because dates can overlap on same day:

    //                           OK:                      OVERLAP_2:
    // old:                     +--+--+                   +--+--+--+
    //                          +--+--+                   +--+--+--+
    // new:          +----------+--+           +-------------+--+
    //               +----------+--+           +-------------+--+
    // ******************************************************************
    Integer result2 = adoptionSubsidyDAO.findIdPersonByAdPtSubAndCdAdptSubCloseRsn(adptSubPerson, dtAdptSubEffective,
                                                                                   dtAdptSubEnd, idAdptSub);

    if (result2 != null) {
      boolean isType = checkPreviousType(cdAdptAudDeterm);
      if(isType){
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_2);
      }
    }

    // ====================================================================
    // VALIDATE 3: Check if new records is either identical OR within
    // a record */
    // ====================================================================
    // **************************************************************************
    //                (1) (2)     (3)     (4)      (5)          (6)
    //               LEFT RIGHT IDENTICAL WITHIN
    // old:         +-+-+ +-+-+ +-+-+-+ +-+-+-+-+ +-+-+-+-+-+ +-+-+-+-+-+
    //              +-+-+ +-+-+ +-+-+-+ +-+-+-+-+ +-+-+-+-+-+ +-+-+-+-+-+
    //
    // new:         +-+     +-+ +-+-+-+   +-+-+    +-+-+-+        +-+-+-+
    //              +-+     +-+ +-+-+-+   +-+-+    +-+-+-+        +-+-+-+
    //               OK      OK   BAD      BAD       OK             OK
    // ***************************************************************************
    Integer result3 = adoptionSubsidyDAO
            .findIdAdptSubPersonByIdAdptSub(adptSubPerson, dtAdptSubEffective, dtAdptSubEnd, idAdptSub);

    if (result3 != null) {
      boolean isType = checkPreviousType(cdAdptAudDeterm);
      if(isType){
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);
      }
    }

    // ************************************************************************
    // Update an existing record. New dates (Start, End) could be either
    // 'shrinking' or 'expanding':
    //                  +-----+       +----------+           +-----+
    //                       |    | <------o---> <---o------> |       |
    //                  +-----+       +----------+           +-----+
    // ************************************************************************

    // =================================================================
    // Check if there's any record at all. It should already exist
    // in order to do an update.
    //
    // If exists, gets START and END date for other processing (with
    // timestamp removed.)
    //
    // Also remove timestamp on both input dates: hI_xxx because
    // they are being used a lot. So it's better to remove them once
    // =================================================================

    Object[] result4 = adoptionSubsidyDAO.findAdoptionSubsidyByIdAdptSubPerson(dtAdptSubEffective, dtAdptSubEnd,
                                                                               adptSubPerson, tsLastUpdate);
    Date dtCurrStart = (Date) result4[1];
    Date dtCurrEnd = (Date) result4[2];
    dtAdptSubEffective = (Date) result4[3];
    dtAdptSubEnd = (Date) result4[4];

    // =================================================================
    // VALIDATE 1: check for LEFT-SIDE OVERLAP
    // If new START_DATE overlaps any of its LEFT record(s)
    // (If its overlaps some, then it must at least overlaps its
    // immediate previous record, and that's what we want to know)
    // =================================================================
    // *********************************************************
    // Must use <= in comparing with :curr_start because
    // 2 consecutive records might have END_DATE (of left
    // record) same as START_DATE (of right record)
    // *********************************************************
    Integer result5 = adoptionSubsidyDAO
            .findIdAdptSubPersonByDtAdptSubEndLessEqlDtCurrStartAndGrtrDtAdptSubEffective(
                    adptSubPerson,
                    idAdptSub,
                    cdAdptAudDeterm,
                    dtCurrStart,
                    dtAdptSubEffective);

    if (result5 != null) {
      boolean isType = checkPreviousType(cdAdptAudDeterm);
      if(isType){
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);
      }
    }

    // =================================================================
    // VALIDATE 2: check for RIGHT-SIDE OVERLAP
    // If new START_DATE overlaps any of its RIGHT record(s)
    // (If its overlaps some, then it must at least overlaps its
    // immediate next record, and that's what we want to know)
    // =================================================================
    // *********************************************************
    // Must use >= in comparing with :curr_start because
    // 2 consecutive records might have END_DATE (of left
    // record) same as START_DATE (of right record)
    // *********************************************************
    Integer result6 = adoptionSubsidyDAO
            .findIdAdptSubPersonByDtAdptSubEffectiveGrtrEqlDtCurrEndAndLessDtAdptSubEnd(
                    adptSubPerson,
                    idAdptSub,
                    cdAdptAudDeterm,
                    dtCurrEnd,
                    dtAdptSubEnd);
    if (result6 != null) {
      boolean isType = checkPreviousType(cdAdptAudDeterm);
      if(isType){
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_2);
      }
    }
    adoptionSubsidyDAO.saveAdoptionSubsidy(adoptionSubsidy);

  }
  
  private boolean checkPreviousType(String cdAdptAudDeterm){
    boolean isTypeSame = false;
    if(cdAdptAudDeterm != null){
      if(!(CodesTables.CSUBTYPE_10.equals(cdAdptAudDeterm) ||
                      CodesTables.CSUBTYPE_18.equals(cdAdptAudDeterm) ||
                      CodesTables.CSUBTYPE_21.equals(cdAdptAudDeterm) ||
                      CodesTables.CSUBTYPE_28.equals(cdAdptAudDeterm) ||
                      CodesTables.CSUBTYPE_29.equals(cdAdptAudDeterm) ||
                      CodesTables.CSUBTYPE_30.equals(cdAdptAudDeterm))){
        isTypeSame = true;
     }
    }
    return isTypeSame;
  }
}
