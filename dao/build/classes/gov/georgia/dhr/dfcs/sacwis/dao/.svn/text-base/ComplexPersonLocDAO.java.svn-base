package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;

public interface ComplexPersonLocDAO {
  /**
   * Inserts a row in Person Loc table after validations
   *
   * @param idPerson
   * @param idStage
   * @param sysIndPrfrmValidation
   * @param cdPlocChild
   * @param cdPlocType
   * @param dtPlocEnd
   * @param dtPlocStart
   * @param indPlocCsupSend
   * @param indPlocWriteHistory
   * @param idPersUpdt
   * @param cdRevType
   * @return
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   */
  public int insertPersonLoc(int idPerson, int idStage, String sysIndPrfrmValidation, String cdPlocChild,
                             String cdPlocType, Date dtPlocEnd, Date dtPlocStart, String indPlocCsupSend,
                             String indPlocWriteHistory, int idPersUpdt, String cdRevType) throws ServiceException;

  /**
   * Updates a row in Person Loc table after validations
   *
   * @param idPerson
   * @param cdPlocType
   * @param dtPlocStart
   * @param dtPlocEnd
   * @param idPlocEvent
   * @param idStage
   * @param cdPlocChild
   * @param indPlocCsupSend
   * @param indPlocWriteHistory
   * @param idPersUpdt
   * @param cdRevType
   * @param lastUpdate
   * @return
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   */
  public int updatePersonLoc(int idPerson, String cdPlocType, Date dtPlocStart, Date dtPlocEnd, int idPlocEvent,
                             int idStage, String cdPlocChild, String indPlocCsupSend, String indPlocWriteHistory,
                             int idPersUpdt, String cdRevType, Date lastUpdate) throws ServiceException;

  /**
   * <pre>
   * 1) INSERT:
   *   Input criteria:
   *   a) CdPlocType and SysIndPrfrmValidation
   *  For a given ID_PERSON (idPerson) do the following:
   * <p/>
   *      If new CdPlocType!="RLOC" then      checks OVERLAP_1 and OVERLAP_2
   *      If SysIndPrfrmValidation ="Y" then checks EXISTS_1  and EXISTS_2
   *        Both checks "dtPlocStart" and "dtPlocEnd" against
   *         other existing records
   *  If both are passed: insert new record
   * <p/>
   * <p/>
   *  If CdPlocType=="RLOC" then no need to check for OVERLAP_1 and OVERLAP2.
   *      If SysIndPrfrmValidation <>"Y" no need to check EXISTS_1  and EXISTS_2.
   *  Thus a record can be inserted with its PlocStart Date and PlocEnd Date
   *      overlaps with other existing records if its PlocType is RLOC and
   *  you do not want to check (set SysIndPrfrmValidation='N')
   * </pre>
   *
   * @param indPrfrmValidation
   * @param idPlocEvent
   * @param idPerson
   * @param cdPlocChild
   * @param cdPlocType
   * @param dtPlocEnd
   * @param dtPlocStart
   * @param indPlocCsupSend
   * @param indPlocWriteHistory
   * @param idPersUpdt
   * @param cdRevType
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   */
  @SuppressWarnings({"unchecked"})
  public int insertPersonLocRloc(String indPrfrmValidation, int idPlocEvent, int idPerson, String cdPlocChild,
                                 String cdPlocType, Date dtPlocEnd, Date dtPlocStart, String indPlocCsupSend,
                                 String indPlocWriteHistory, int idPersUpdt, String cdRevType) throws ServiceException;

  /**
   * <pre>
   * 2) UPDATE:
   *   Input criteria: for a given  ID_PLOC_EVENT, DT_LAST_UPDATE, and PLOC_TYPE
   *   These 3 fields must match in order for that record to be updated
   *      (different input for INSERT)
   *   a) CdPlocType and SysIndPrfrmValidation
   *      If new CdPlocType!="RLOC" then      checks OVERLAP_1 and OVERLAP_2
   *      If SysIndPrfrmValidation ="Y" then
   *         If new START date is diff from old START date ==> check GAP_EXIST_1
   *            (set GAP_EXIST_1 if the gap is >= 1.0 day)
   *         If new END   date is diff from old END   date ==> check GAP_EXIST_2
   *            (set GAP_EXIST_2 if the gap is >= 1.0 day)
   *  If both are passed: update record.
   *      Note that PLOC_TYPE is not updateable. You cannot change from
   *      one PLOC_TYPE to another (because eventually after a couple of
   *      changing PLOC_TYPE back and forth, PlocStart Date and PlocEnd
   *      Date might become overlapped.
   *  If CdPlocType=="RLOC" then no need to check for OVERLAP_1 and OVERLAP2.
   *      If SysIndPrfrmValidation <>"Y" no need to check EXISTS_1  and EXISTS_2.
   *  Thus a record can be updated  with its PlocStart Date and PlocEnd Date
   *      overlaps with other existing records if its PlocType is RLOC and
   *  you do not want to check (set SysIndPrfrmValidation='N')
   * New dates (Start, End) could be either
   * 'shrinking' or 'expanding':
   *    +-----+         +----------+         +-----+
   *        |     |  &lt;------o---&gt;  &lt;---o------&gt;  |     |
   *    +-----+         +----------+         +-----+
   * </pre>
   *
   * @param indPrfrmValidation
   * @param idPlocEvent
   * @param idPerson
   * @param cdPlocChild
   * @param cdPlocType
   * @param dtPlocEnd
   * @param dtPlocStart
   * @param indPlocCsupSend
   * @param indPlocWriteHistory
   * @param idPersUpdt
   * @param cdRevType
   * @param dtLastUpdate
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   */
  @SuppressWarnings({"unchecked"})
  public int updatePersonLocRloc(String indPrfrmValidation, int idPlocEvent, int idPerson, String cdPlocChild,
                                 String cdPlocType, Date dtPlocEnd, Date dtPlocStart, String indPlocCsupSend,
                                 String indPlocWriteHistory, int idPersUpdt, String cdRevType, Date dtLastUpdate)
          throws ServiceException;
}
