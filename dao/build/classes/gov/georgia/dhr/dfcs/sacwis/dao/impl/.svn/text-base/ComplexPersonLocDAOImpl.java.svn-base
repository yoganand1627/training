package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonLocDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonLocDAO;

public class ComplexPersonLocDAOImpl extends BaseDAOImpl implements ComplexPersonLocDAO {
  private CommonDAO commonDAO = null;
  private PersonLocDAO personLocDAO = null;

  public void setCommonDAO(CommonDAO commonDAO) {
    this.commonDAO = commonDAO;
  }

  public void setPersonLocDAO(PersonLocDAO personLocDAO) {
    this.personLocDAO = personLocDAO;
  }

  public int insertPersonLoc(int idPerson, int idStage, String sysIndPrfrmValidation, String cdPlocChild,
                             String cdPlocType, Date dtPlocEnd, Date dtPlocStart, String indPlocCsupSend,
                             String indPlocWriteHistory, int idPersUpdt, String cdRevType) throws ServiceException {
    // Check if there's any record of this ID_PERSON with an ALOC with in this stage.
    // If none, No need to go through all these validation.
    // If some, then must go through all checks.
    Integer result = personLocDAO.findIdPlocEventByAnyAloc(idPerson, idStage);
    if (result != null) {
      // VALIDATE 1: Check if new records overlaps other records on LEFT
      //   (works whether new record overlaps 1 or more existing records
      // Do not use <= or >= signs because dates can overlap on same day:
      //                OK:                         OVERLAP_1:
      // old:          +--+--+                      +--+--+--+
      //               +--+--+                      +--+--+--+
      // new:             +--+----------+              +--+------------+
      //                  +--+----------+              +--+------------+
      Integer result2 = personLocDAO.findIdPlocEventByDtEndNotEqlDtStart(idPerson, idStage, dtPlocStart, dtPlocEnd);
      if (result2 != null) {
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);
      }
      // VALIDATE 2: Check if new records overlaps other records on RIGHT
      //   (works whether new record overlaps 1 or more existing records
      // Do not use <= or >= signs because dates can overlap on same day:
      //                           OK:                      OVERLAP_2:
      // old:                     +--+--+                   +--+--+--+
      //                          +--+--+                   +--+--+--+
      // new:          +----------+--+           +-------------+--+
      //               +----------+--+           +-------------+--+
      Integer result3 = personLocDAO.findIdPlocEventByDtStartNotEqlDtEnd(idPerson, idStage, dtPlocStart, dtPlocEnd);
      if (result3 != null) {
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_2);
      }

      // VALIDATE 3: Check if new records is either identical OR within a record
      //                (1) (2)     (3)     (4)      (5)          (6)
      //               LEFT RIGHT IDENTICAL WITHIN
      // old:         +-+-+ +-+-+ +-+-+-+ +-+-+-+-+ +-+-+-+-+-+ +-+-+-+-+-+
      //              +-+-+ +-+-+ +-+-+-+ +-+-+-+-+ +-+-+-+-+-+ +-+-+-+-+-+
      //
      // new:         +-+     +-+ +-+-+-+   +-+-+    +-+-+-+        +-+-+-+
      //              +-+     +-+ +-+-+-+   +-+-+    +-+-+-+        +-+-+-+
      //               OK      OK   BAD      BAD       OK             OK
      Integer result4 = personLocDAO.findPersonLocIdPlocEvent(idPerson, idStage, dtPlocStart, dtPlocEnd);
      if (result4 != null) {
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);
      }

      if (ArchitectureConstants.Y.equals(sysIndPrfrmValidation)) {
        // VALIDATE 4: Check if the gap on LEFT of hI_dtDtPlocStart is bigger than 1 day. SELECT statement will return
        //   record if it finds one, which means gap is >= 1.0 day ==> ERROR!
        Object[] map = personLocDAO.findIdPlocEventDtPlocEndByMaxDtPlocEnd(idPerson, idStage, dtPlocStart);
        boolean leftGapExists = false;
        if (map != null) {
          leftGapExists = true;
        }
        // VALIDATE 5: Check if the gap on RIGHT of hI_dtDtPlocStart is bigger than 1 day. SELECT statement will return
        //   record if it finds one, which means gap is >= 1.0 day ==> ERROR!
        Object[] map2 = personLocDAO.findIdPlocEventDtPlocEndByMinDtPlocStart(idPerson, idStage, dtPlocStart,
                                                                              dtPlocEnd);
        boolean rightGapExists = false;

        if (map2 != null) {
          rightGapExists = true;
        }

        if (leftGapExists && rightGapExists) {
          throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_3);
        } else if (leftGapExists) {
          throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_1);
        } else if (rightGapExists) {
          throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_2);
        }
      }

    }
    return personLocDAO.insertPersonLoc(idPerson, cdPlocChild, cdPlocType, dtPlocEnd, dtPlocStart, indPlocCsupSend,
                                        indPlocWriteHistory, idPersUpdt, cdRevType);
  }

  public int updatePersonLoc(int idPerson, String cdPlocType, Date dtPlocStart, Date dtPlocEnd, int idPlocEvent,
                             int idStage, String cdPlocChild, String indPlocCsupSend, String indPlocWriteHistory,
                             int idPersUpdt, String cdRevType, Date lastUpdate) throws ServiceException {
    // Update an existing record. New dates (Start, End) could be either 'shrinking' or 'expanding':
    // +-----+ +----------+ +-----+
    // | | <------o---> <---o------> | |
    // +-----+ +----------+ +-----+

    // Check if there's any record at all. It should already exist in order to do an update.
    //
    // If exists, gets START and END date for other processing (with timestamp removed.)
    //
    // Also remove timestamp on both input dates: hI_xxx because they are being used a lot.
    //   So it's better to remove them once
    Object[] obj = personLocDAO.findPersonLocIdPlocEvent(dtPlocStart, dtPlocEnd, idPlocEvent, lastUpdate, idPerson);
    if (obj == null) {
      // Indicate that nothing was done.
      return 0;
    }
    Date dtCurrPlocStart = (Date) obj[0];
    Date dtCurrPlocEnd = (Date) obj[1];
    Date newDtPlocStart = (Date) obj[2];
    Date newDtPlocEnd = (Date) obj[4];

    Integer result = personLocDAO.findIdPlocEventByCurrDtPlocStart(idPerson, cdPlocType, dtCurrPlocStart,
                                                                   newDtPlocStart, idPlocEvent);
    if (result != null) {
      throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);
    }
    // VALIDATE 2: check for RIGHT-SIDE OVERLAP
    // If new START_DATE overlaps any of its RIGHT record(s) (If its overlaps some, then it must at least overlaps its
    //   immediate next record, and that's what we want to know)
    Integer result2 = personLocDAO.findIdPlocEventDtPlocStartGreaterOrEqualDtCurrplocEnd(idPerson, cdPlocType,
                                                                                         dtCurrPlocEnd, newDtPlocEnd,
                                                                                         idPlocEvent);

    if (result2 != null) {
      throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_2);
    }
    // VALIDATE 4: Gap LEFT of hI_dtDtPlocStart
    // Check this gap ONLY IF hI_dtDtPlocStart <> curr_ploc_star because: if the 2 are the same, then the user does
    //   NOT want to update that end. Only when the 2 are different does it mean that the user wants to update that end
    Object[] result3 = personLocDAO.findPlocByDtPlocStartIdPersonIdStageAndCurrPlocStart(newDtPlocStart, idPerson,
                                                                                         idStage, dtCurrPlocStart);
    boolean leftGapExists = false;
    if (result3 != null) {
      leftGapExists = true;
    }
    Object[] result4 = personLocDAO.findPlocByDtPlocEndIdPersonIdStageDtCurrPlocEnd(newDtPlocEnd, idPerson, idStage,
                                                                                    dtCurrPlocEnd);

    boolean rightGapExists = false;
    if (result4 != null) {
      rightGapExists = true;
    }

    if (leftGapExists && rightGapExists) {
      throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_3);
    } else if (leftGapExists) {
      throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_1);
    } else if (rightGapExists) {
      throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_2);
    }

    // Here record is ready to be updated.
    // It has passed all validation (supposing it is requested to do so)
    return personLocDAO.updatePersonLoc(idPerson, cdPlocChild, newDtPlocEnd, newDtPlocStart, indPlocCsupSend,
                                        indPlocWriteHistory, idPersUpdt, cdRevType, idPlocEvent, lastUpdate);
  }

  @SuppressWarnings({"unchecked"})
  public int insertPersonLocRloc(String indPrfrmValidation, int idPlocEvent, int idPerson, String cdPlocChild,
                                 String cdPlocType, Date dtPlocEnd, Date dtPlocStart, String indPlocCsupSend,
                                 String indPlocWriteHistory, int idPersUpdt, String cdRevType)
          throws ServiceException {
    // convert NULL DATE to MAX DATE
    if (dtPlocStart == null) {
      dtPlocStart = DateHelper.MAX_JAVA_DATE;
    }
    if (dtPlocEnd == null) {
      dtPlocEnd = DateHelper.MAX_JAVA_DATE;
    }

    // Check if there's any record of this ID_PERSON and not RLOC. If none, then  everything passed. No need to go
    //   through all these validation. If some, then must go through all checks.
    List<Integer> tempInt = personLocDAO.findIdPlocEventByIdPersonCdPlocType(idPerson, cdPlocType);
    if (tempInt != null) {
      if (!(CodesTables.CPLOCELG_RLOC.equals(cdPlocType))) {
        tempInt = personLocDAO.findIdPlocEventOverLapGapOnLeft(idPerson, cdPlocType, dtPlocStart, dtPlocEnd);
        // VALIDATE 1:  Check if new records overlaps other records on LEFT
        // (works whether new record overlaps 1 or more existing records)
        if (tempInt != null) {
          throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);
        }
        tempInt = personLocDAO.findIdPlocEventOverLapGapOnRight(idPerson, cdPlocType, dtPlocStart, dtPlocEnd);
        // VALIDATE 2:  Check if new records overlaps other records on RIGHT
        //   (works whether new record overlaps 1 or more existing records)
        if (tempInt != null) {
          throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_2);
        }
        tempInt = personLocDAO.findIdPlocEventIdenticalOrInRecord(idPerson, cdPlocType, dtPlocStart, dtPlocEnd);
        // VALIDATE 3: Check if new records is either identical OR within a record
        if (tempInt != null) {
          throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);
        }
      }
      boolean bLeftGapExists = false;
      if (ArchitectureConstants.Y.equals(indPrfrmValidation)) {
        Object[] tempPersonLoc = personLocDAO.findIdPlocEventDtPlocEndDtDiffDateOnLeft(idPerson, cdPlocType,
                                                                                       dtPlocStart);
        // VALIDATE 4: Check if the gap on LEFT of dtPlocStart is
        // bigger than 1 day.  SELECT statement will return record if
        // it finds one, which means gap is >= 1.0 day ==> ERROR!
        if (tempPersonLoc != null) {
          bLeftGapExists = true;
        }
      }

      boolean bRightGapExists = false;
      if (ArchitectureConstants.Y.equals(indPrfrmValidation)) {
        Object[] tempPersonLoc = personLocDAO.findIdPlocEventDtPlocEndDtDiffDateOnRight(idPerson, cdPlocType,
                                                                                        dtPlocEnd);
        // VALIDATE 5: Check if the gap on RIGHT of dtPlocStart is
        //     bigger than 1 day.  SELECT statement will return record if
        //     it finds one, which means gap is >= 1.0 day ==> ERROR!
        if (tempPersonLoc != null) {
          bRightGapExists = true;
        }
      }

      if (bLeftGapExists && bRightGapExists) {
        throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_3);
      } else if (bLeftGapExists) {
        throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_1);
      } else if (bRightGapExists) {
        throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_2);
      }
    }
    if (idPlocEvent == 0) {
      idPlocEvent = commonDAO.getNextval("SEQ_EVENT");
    }
    return personLocDAO.insertPersonLoc(idPlocEvent, idPerson, cdPlocChild, cdPlocType, dtPlocEnd, dtPlocStart,
                                        indPlocCsupSend, indPlocWriteHistory, idPersUpdt, cdRevType);
  }

  public int updatePersonLocRloc(String indPrfrmValidation, int idPlocEvent, int idPerson, String cdPlocChild,
                                 String cdPlocType, Date dtPlocEnd, Date dtPlocStart, String indPlocCsupSend,
                                 String indPlocWriteHistory, int idPersUpdt, String cdRevType, Date dtLastUpdate)
          throws ServiceException {
    // Check if there's any record at all.  It should already exist in order to do an update.
    // If exists, gets START and END date for other processing (with timestamp removed.)
    // Also remove timestamp on both input dates: xxx because  they are being used a lot.
    //   So it's better to remove them once
    Object[] tempPersonLoc = personLocDAO.findDtPlocStartDtPlocEnd(idPerson, cdPlocType, dtPlocStart, dtPlocEnd,
                                                                   idPlocEvent, dtLastUpdate);
    if (tempPersonLoc == null) {
      // Indicate that nothing was done.
      return 0;
    }
    Date tempCurrPlocStart = (Date) tempPersonLoc[1];
    Date tempCurrPlocEnd = (Date) tempPersonLoc[2];
    Date tempDtPlocStart = (Date) tempPersonLoc[3];
    Date tempDtPlocEnd = (Date) tempPersonLoc[4];

    List<Integer> tempInt = personLocDAO.findIdPlocEventCheckForLeftSideOverlap(idPerson, cdPlocType, tempDtPlocStart,
                                                                                idPlocEvent, tempCurrPlocStart);
    // VALIDATE 1:  check for LEFT-SIDE  OVERLAP
    // If new START_DATE overlaps any of its LEFT record(s)
    // (If its overlaps some, then it must at least overlaps its
    // immediate previous record, and that's what we want to know)
    if (tempInt != null) {
      throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);
    } else {
      tempInt = personLocDAO.findIdPlocEventCheckForRightSideOverlap(idPerson, cdPlocType, tempDtPlocEnd, idPlocEvent,
                                                                     tempCurrPlocEnd);
    }
    // VALIDATE 2:  check for RIGHT-SIDE  OVERLAP
    // If new START_DATE overlaps any of its RIGHT record(s)
    // (If its overlaps some, then it must at least overlaps its
    // immediate next record, and that's what we want to know)
    if (tempInt != null) {
      throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_2);
    }
    boolean bLeftGapExists = false;
    if (ArchitectureConstants.Y.equals(indPrfrmValidation)) {
      tempPersonLoc = personLocDAO.findIdPlocEventDtPlocEndDtPlocDiffOnLeft(idPerson, cdPlocType, tempDtPlocStart);
      // VALIDATE 4: Gap LEFT of dtPlocStart
      // Check this gap ONLY IF dtPlocStart <> curr_ploc_start
      // because: if the 2 are the same, then the user does NOT want
      //       to update that end.  Only when the 2 are different
      //       does it mean that the user wants to update that end
      if (tempPersonLoc != null) {
        bLeftGapExists = true;
      }
    }
    boolean bRightGapExists = false;
    if (ArchitectureConstants.Y.equals(indPrfrmValidation)) {
      tempPersonLoc = personLocDAO.findIdPlocEventDtPlocEndDtPlocDiffOnRight(idPerson, cdPlocType, tempDtPlocEnd,
                                                                             tempCurrPlocEnd);
      // VALIDATE 5: Gap RIGHT of dtDtPlocEnd Check this gap ONLY IF dtPlocEnd <> curr_ploc_end
      if (tempPersonLoc != null) {
        bRightGapExists = true;
      }
    }
    if (bLeftGapExists && bRightGapExists) {
      throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_3);
    } else if (bLeftGapExists) {
      throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_1);
    } else if (bRightGapExists) {
      throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_2);
    }
    return personLocDAO.updatePersonLoc(idPerson, cdPlocChild, dtPlocEnd, dtPlocStart, indPlocCsupSend,
                                        indPlocWriteHistory, idPersUpdt, cdRevType, idPlocEvent, dtLastUpdate);
  }
}
