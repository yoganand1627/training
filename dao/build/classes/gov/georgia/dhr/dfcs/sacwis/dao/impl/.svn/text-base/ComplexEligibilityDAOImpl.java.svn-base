package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;

public class ComplexEligibilityDAOImpl extends BaseDAOImpl implements ComplexEligibilityDAO {
  private EligibilityDAO eligibilityDAO = null;

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  @SuppressWarnings({"unchecked"})
  public void insertEligibility(String indPrfrmValidation, String indGeneric, Eligibility eligibility)
          throws ServiceException {
    if (eligibility.getDtEligReview() == null) {
      eligibility.setDtEligReview(DateHelper.MAX_JAVA_DATE);
    }
    if (eligibility.getDtEligStart() == null) {
      eligibility.setDtEligStart(DateHelper.MAX_JAVA_DATE);
    }
    if (eligibility.getDtEligEnd() == null) {
      eligibility.setDtEligEnd(DateHelper.MAX_JAVA_DATE);
    }
    // Check if there's any record of this ID_PERSON. If none, then
    //  everything passed. No need to go through all these validation.
    List<Integer> tempInt = eligibilityDAO.findIdEligEventByIdPerson(eligibility.getPersonByIdPerson().getIdPerson());
    if (tempInt == null || tempInt.size() == 0) {
      doInsert(eligibility);
    } else {
      tempInt = eligibilityDAO.findIdEligEventOnLeft(eligibility.getPersonByIdPerson().getIdPerson(),
                                                     eligibility.getDtEligEnd(), eligibility.getDtEligStart());
      // VALIDATE 1:  Check if new records overlaps other records on LEFT
      // (works whether new record overlaps 1 or more existing records
      if (tempInt != null && tempInt.size() != 0) {
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);
      } else {
        tempInt = eligibilityDAO.findIdEligEventOnRight(eligibility.getPersonByIdPerson().getIdPerson(),
                                                        eligibility.getDtEligEnd(), eligibility.getDtEligStart());
      }
      // VALIDATE 1:  Check if new records overlaps other records on RIGHT
      //   (works whether new record overlaps 1 or more existing records
      if (tempInt != null && tempInt.size() != 0) {
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_2);
      } else {
        tempInt = eligibilityDAO.findIdEligEventCheckIdentical(eligibility.getPersonByIdPerson().getIdPerson(),
                                                               eligibility.getDtEligEnd(),
                                                               eligibility.getDtEligStart());
      }
      // VALIDATE 3: Check if new records is either identical OR within a record
      if (tempInt != null && tempInt.size() != 0) {
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);
      }

      Object[] tempEligibility = null;
      boolean bLeftGapExists = false;
      if (ArchitectureConstants.Y.equals(indPrfrmValidation)) {
        tempEligibility = eligibilityDAO.findIdEligEventDtEligEndOnLeft(eligibility.getDtEligStart(),
                                                                       eligibility.getPersonByIdPerson().getIdPerson());
        // VALIDATE 4: Check if the gap on LEFT of hI_dtDtEligStart is
        // bigger than 1 day.  SELECT statement will return record if
        // it finds one, which means gap is >= 1.0 day ==> ERROR!
        if (tempEligibility != null && tempEligibility.length != 0) {
          bLeftGapExists = true;
        }
      } // end if
      boolean bRightGapExists = false;
      boolean bPrevCourtOrdered = false;
      if (ArchitectureConstants.Y.equals(indPrfrmValidation)) {
        tempEligibility = eligibilityDAO.findIdEligEventDtEligStartOnRight(eligibility.getDtEligEnd(),
                                                                          eligibility.getPersonByIdPerson().getIdPerson());
        // VALIDATE 5: Check if the gap on RIGHT of hI_dtDtEligStart is
        // bigger than 1 day.  SELECT statement will return record if
        // it finds one, which means gap is >= 1.0 day ==> ERROR!
        if (tempEligibility != null && tempEligibility.length != 0) {
          bRightGapExists = true;
        }
        if (ArchitectureConstants.Y.equals(indGeneric)) {
          Map courtOrdered = new HashMap();
          courtOrdered = eligibilityDAO.findPrevEligOrdered(eligibility.getEvent().getIdEvent(),
                                                            eligibility.getPersonByIdPerson().getIdPerson());

          // VALIDATE 6: Determines if previous eligibility was court ordered
          if (courtOrdered != null) {
            if ((CodesTables.CAIA_030.equals(courtOrdered.get("cdEligCsupQuest1"))) ||
                (CodesTables.CAIA_030.equals(courtOrdered.get("cdEligCsupQuest2"))) ||
                (CodesTables.CAIA_030.equals(courtOrdered.get("cdEligCsupQuest3"))) ||
                (CodesTables.CAIA_030.equals(courtOrdered.get("cdEligCsupQuest4"))) ||
                (CodesTables.CAIA_030.equals(courtOrdered.get("cdEligCsupQuest5"))) ||
                (CodesTables.CAIA_030.equals(courtOrdered.get("cdEligCsupQuest6"))) ||
                (CodesTables.CAIA_030.equals(courtOrdered.get("cdEligCsupQuest7")))) {
              bPrevCourtOrdered = true;
            }
          }
        }
      }// end if
      if (bLeftGapExists && bRightGapExists) {
        throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_3);
      } else if (bLeftGapExists) {
        throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_1);
      } else if (bRightGapExists) {
        throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_2);
      } else if (bPrevCourtOrdered) {
        throw new ServiceException(Messages.MSG_SUB_COURT_ORDERED);
      }
      doInsert(eligibility);
    } // end of else
  }

  private void doInsert(Eligibility eligibility) {
    eligibilityDAO.saveEligibility(eligibility);
  }

  @SuppressWarnings({"unchecked"})
  public void updateEligibility(String indPrfrmValidation, Eligibility eligibility) throws ServiceException {
    if (eligibility.getDtEligReview() == null) {
      eligibility.setDtEligReview(DateHelper.MAX_JAVA_DATE);
    }
    if (eligibility.getDtEligStart() == null) {
      eligibility.setDtEligStart(DateHelper.MAX_JAVA_DATE);
    }
    if (eligibility.getDtEligEnd() == null) {
      eligibility.setDtEligEnd(DateHelper.MAX_JAVA_DATE);
    }
    
    Object[] tempEligibility = null;
    tempEligibility = eligibilityDAO.findIdEligEventExists(eligibility.getEvent().getIdEvent(),
                                                          eligibility.getDtEligStart(), eligibility.getDtEligEnd(),
                                                          eligibility.getPersonByIdPerson().getIdPerson(),
                                                          eligibility.getDtLastUpdate());
    Integer tempIdEligEvent = (Integer) tempEligibility[0];
    Date tempCurrPlocStart = (Date) tempEligibility[1];
    Date tempCurrPlocEnd = (Date) tempEligibility[2];
    Date tempDtEligStart = (Date) tempEligibility[3];
    Date tempDtEligEnd = (Date) tempEligibility[4];

    List<Integer> tempInt = eligibilityDAO.findIdEventOverlapLeft(eligibility.getPersonByIdPerson().getIdPerson(),
                                                                  eligibility.getEvent().getIdEvent(),
                                                                  tempCurrPlocStart, tempDtEligStart);
    // VALIDATE 1:  check for LEFT-SIDE  OVERLAP
    // If new START_DATE overlaps any of its LEFT record(s)
    // (If its overlaps some, then it must at least overlaps its
    // immediate previous record, and that's what we want to know)
    if (tempInt != null && tempInt.size() != 0) {
      throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);
    } else {
      tempInt = eligibilityDAO.findIdEventOverlapRight(eligibility.getPersonByIdPerson().getIdPerson(),
                                                       eligibility.getEvent().getIdEvent(),
                                                       tempCurrPlocEnd, tempDtEligEnd);
    }
    // VALIDATE 2:  check for RIGHT-SIDE  OVERLAP
    // If new START_DATE overlaps any of its RIGHT record(s)
    // (If its overlaps some, then it must at least overlaps its
    // immediate next record, and that's what we want to know)
    if (tempInt != null && tempInt.size() != 0) {
      throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_2);
    }
    boolean bLeftGapExists = false;
    if (ArchitectureConstants.Y.equals(indPrfrmValidation)) {
      tempEligibility = eligibilityDAO.findIdEligEventOnLeftOfDtEligStart(tempDtEligStart,
                                                                         eligibility.getPersonByIdPerson().getIdPerson(),
                                                                         tempCurrPlocStart);
      // tempIdEligEvent = (Integer) tempEligibility[0];
      // VALIDATE 4: Gap LEFT of hI_dtDtEligStart
      // Check this gap ONLY IF hI_dtDtEligStart <> curr_ploc_star
      // because: if the 2 are the same, then the user does NOT want
      //       to update that end.  Only when the 2 are different
      //       does it mean that the user wants to update that end
      if (tempEligibility != null && tempEligibility.length != 0) {
        bLeftGapExists = true;
      }
    } // end if
    boolean bRightGapExists = false;
    if (ArchitectureConstants.Y.equals(indPrfrmValidation)) {
      tempEligibility = eligibilityDAO.findIdEligEventOnRightOfDtEligEnd(tempDtEligEnd,
                                                                        eligibility.getPersonByIdPerson().getIdPerson(),
                                                                        tempCurrPlocEnd);
      //tempIdEligEvent = (Integer) tempEligibility[0];
      // VALIDATE 5: Gap RIGHT of hI_dtDtEligEnd Check this gap ONLY IF hI_dtDtEligEnd <> curr_ploc_end
      if (tempEligibility != null && tempEligibility.length != 0) {
        bRightGapExists = true;
      }
    } // end if
    if (bLeftGapExists && bRightGapExists) {
      throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_3);
    } else if (bLeftGapExists) {
      throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_1);
    } else if (bRightGapExists) {
      throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_2);
    }
    eligibilityDAO.saveEligibility(eligibility);
  }
}
