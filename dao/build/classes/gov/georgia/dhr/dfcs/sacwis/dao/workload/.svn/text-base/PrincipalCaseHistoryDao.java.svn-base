package gov.georgia.dhr.dfcs.sacwis.dao.workload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;

/**
 * PrincipalCaseHistoryDao performs  the database activities to Process all the methods which has been called from
 * PrincipalCaseHistoryBean class. Each Method will execute the SQLs based on the functionality.
 * <pre>
 * Change History:
 * Date      User         Description
 * --------  -----------  ----------------------------------------------
 * 04/08/05  ANANDV       SIR 23522 - PrincipalCaseHistoryDao for Principal Case History Information Page
 * 05/09/05  ANANDV       SIR 23522 - Added one condition in FINAL_SQL b'coz of duplicate records.
 * 05/16/05  ANANDV       SIR 23522 - Added two separate methods to Insert/Update Parent Child Relationship record as
 *                        well as Child Parent Relations ship records.
 * 05/23/05  ANANDV       SIR 23598 - In the PrincipalList Section the Overall Disposition Indicator will be populated
 *                        for all the Stage IDs also it will populate Order By Stage ID desc, ID Person asc.
 * </pre>
 *
 * @author Vijaya Anand
 * @version 1.0
 */
public class PrincipalCaseHistoryDao extends BaseDao {

  private static final String TRACE_TAG = "PrincipalCaseHistoryDao";

  /** This FINAL_SQL will get all the unique case ids list information. */
  private static final String FINAL_SQL = "  SELECT DISTINCT C.ID_CASE, " +
                                          "                  C.CD_CASE_PROGRAM, " +
                                          "                  C.IND_CASE_SENSITIVE, " +
                                          "                  C.DT_CASE_CLOSED, " +
                                          "                  C.DT_CASE_OPENED, " +
                                          "                  C.NM_CASE, " +
                                          "                  S.CD_STAGE, " +
                                          "                  D.ID_DELETE_CASE, " +
                                          "                  CL.IND_CASE_LINK, " +
                                          "                  CL.DT_CASE_LINKED, " +
                                          "                  CL.ID_LINKED_CASE, " +
                                          "                  CL.DT_CASE_LINKED, " +
                                          "                  CL.ID_PERSON_UPDATE, " +
                                          "                  P.NM_PERSON_FULL, " +
                                          "                  CM.ID_CASE_MERGE_TO, " +
                                          "                  CID.CD_CPS_INVST_DTL_OVRLL_DISPTN " +
                                          "    FROM STAGE_PERSON_LINK SPL, " +
                                          "         PERSON P, " +
                                          "         STAGE S, " +
                                          "         CAPS_CASE C, " +
                                          "         (SELECT DISTINCT ID_CASE_MERGE_TO " +
                                          "            FROM CASE_MERGE " +
                                          "           WHERE IND_CASE_MERGE_PENDING IS NULL " +
                                          "             AND DT_CASE_MERGE_SPLIT IS NULL) CM, " +
                                          "         CASE_LINK CL, " +
                                          "         DELETE_CASE D, " +
                                          "         CPS_INVST_DETAIL CID " +
                                          "   WHERE SPL.CD_STAGE_PERS_TYPE = 'PRN' " +
                                          "     AND SPL.ID_PERSON IN (SELECT DISTINCT SPL2.ID_PERSON " +
                                          "                             FROM STAGE_PERSON_LINK SPL2 " +
                                          "                            WHERE SPL2.CD_STAGE_PERS_TYPE = 'PRN' " +
                                          "                              AND SPL2.ID_CASE = ?) " +
                                          "     AND C.ID_CASE != ? " +
                                          "     AND SPL.ID_CASE = C.ID_CASE " +
                                          "     AND C.ID_CASE = S.ID_CASE " +
                                          "     AND S.ID_STAGE = (SELECT MAX (SL.ID_STAGE ) " +
                                          "                         FROM STAGE SL " +
                                          "                        WHERE SL.ID_CASE  = C.ID_CASE) " +
                                          "     AND D.ID_DELETE_CASE(+) = C.ID_CASE " +
                                          "     AND CL.ID_LINKED_CASE(+) = C.ID_CASE " +
                                          "     AND CL.ID_CASE (+) = ?  " +
                                          //added this condition to retrieve parent CASE ID also linked to Child on 05/16/2005
                                          "     AND (CL.IND_CASE_LINK IN ('Y','N') OR CL.IND_CASE_LINK IS NULL) " +
                                          "     AND CM.ID_CASE_MERGE_TO (+) = C.ID_CASE " +
                                          "     AND P.ID_PERSON (+) = CL.ID_PERSON_UPDATE " +
                                          "     AND CID.ID_CASE (+) = C.ID_CASE " +
                                          "ORDER BY CL.IND_CASE_LINK DESC NULLS LAST, " +
                                          "         C.DT_CASE_OPENED DESC";

  /** This PRN_SQL - will be execute to get all the Principal List Info when the radio button for a case is selected. */
  private static final String PRN_SQL = "  SELECT DISTINCT L.ID_PERSON, " +
                                        "                  L.CD_STAGE_PERS_REL_INT, " +
                                        "                  L.CD_STAGE_PERS_ROLE, " +
                                        "                  S.ID_STAGE, " +
                                        "                  S.CD_STAGE, " +
                                        "                  P.ID_PERSON, " +
                                        "                  P.NM_PERSON_FULL, " +
                                        "                  P.DT_PERSON_BIRTH, " +
                                        "                  P.CD_PERSON_SEX, " +
                                        "                  CID.CD_CPS_INVST_DTL_OVRLL_DISPTN " +
                                        "    FROM STAGE_PERSON_LINK L, " +
                                        "         STAGE S, " +
                                        "         PERSON P, " +
                                        "         CPS_INVST_DETAIL CID " +
                                        "   WHERE L.ID_CASE = ? " +
                                        "     AND L.CD_STAGE_PERS_TYPE = 'PRN' " +
                                        "     AND L.ID_CASE = S.ID_CASE " +
                                        "     AND L.ID_STAGE = S.ID_STAGE " +
                                        "     AND L.ID_PERSON = P.ID_PERSON " +
                                        "     AND CID.ID_CPS_INVST_STAGE (+) = L.ID_STAGE " +
                                        "ORDER BY S.ID_STAGE DESC, P.ID_PERSON ASC ";

  /** This CASE_SQL will insert checked link case list info. */
  private static final String CASE_SQL = "INSERT INTO CASE_LINK (ID_CASE_LINK, " +
                                         "                       DT_LAST_UPDATE, " +
                                         "                       ID_CASE, IND_CASE_LINK, " +
                                         "                       ID_LINKED_CASE, " +
                                         "                       DT_CASE_LINKED, " +
                                         "                       ID_PERSON_UPDATE) " +
                                         "     VALUES (?, SYSDATE, ?, ?, ?, SYSDATE, ? ) ";

  /** This UPDCASE_SQL will update the unchecked linked case information. */
  private static final String UPDCASE_SQL = "UPDATE CASE_LINK " +
                                            "   SET DT_LAST_UPDATE = SYSDATE, " +
                                            "       IND_CASE_LINK = ? , " +
                                            "       DT_CASE_LINKED = SYSDATE, " +
                                            "       ID_PERSON_UPDATE = ? " +
                                            " WHERE ID_LINKED_CASE =? " +
                                            "   AND ID_CASE = ?";

  /**
   * Constructor.
   *
   * @param connection The Connection object to be used for this transaction.
   */
  public PrincipalCaseHistoryDao(Connection connection) {
    super(connection);
  }

  /**
   * caseList
   * <p/>
   * This method will get the unique Case IDs. Also get the relvant Case List information for each Case Id from the
   * following table. CAPS_CASE, STAGE, STAGE_PERSON_LINK, CASE_LINK, CASE_,MERGE, CPS_INVST_DETAIL, PERSON table.
   * caseList() will populate Case List Section on the PrincipalCaseHistory page.
   *
   * @param caseID
   * @return
   */
  public List<CaseInfoDB> caseList(int caseID) {
    PerformanceTrace performTrace = new PerformanceTrace(TRACE_TAG, "caseList");
    performTrace.enterScope();
    List<CaseInfoDB> caseList = new ArrayList<CaseInfoDB>();
    Connection connection;
    PreparedStatement stmtFinal = null;
    ResultSet rsFinal = null;
    try {
      connection = super.getConnection();
      List<Object> bindVector = new ArrayList<Object>();
      bindVector.add(caseID);
      bindVector.add(caseID);
      bindVector.add(caseID);
      stmtFinal = connection.prepareStatement(FINAL_SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      stmtFinal = addBindVariablesToStatement(stmtFinal, bindVector);
      rsFinal = stmtFinal.executeQuery();
      // Will get all the Unique Case IDs Information also set the values into CaseInfoDB.
      while (rsFinal.next()) {
        CaseInfoDB caseInfoDB = new CaseInfoDB();
        int idCase = rsFinal.getInt("ID_CASE");
        caseInfoDB.setCaseID(idCase);
        caseInfoDB.setProgram(rsFinal.getString("CD_CASE_PROGRAM"));
        caseInfoDB.setCaseSensitive(rsFinal.getString("IND_CASE_SENSITIVE"));
        caseInfoDB.setCaseClosed(rsFinal.getTimestamp("DT_CASE_CLOSED"));
        caseInfoDB.setCaseOpened(rsFinal.getTimestamp("DT_CASE_OPENED"));
        caseInfoDB.setCaseName(rsFinal.getString("NM_CASE"));
        caseInfoDB.setCaseStage(rsFinal.getString("CD_STAGE"));
        caseInfoDB.setDeleteCase(rsFinal.getInt("ID_DELETE_CASE"));
        caseInfoDB.setIndCaseLink(rsFinal.getString("IND_CASE_LINK"));
        caseInfoDB.setDateCaseLink(rsFinal.getTimestamp("DT_CASE_LINKED"));
        caseInfoDB.setLinkedCase(rsFinal.getInt("ID_LINKED_CASE"));
        caseInfoDB.setPersonUpdate(rsFinal.getInt("ID_PERSON_UPDATE"));
        caseInfoDB.setPersonName(rsFinal.getString("NM_PERSON_FULL"));
        caseInfoDB.setIdCaseMerge(rsFinal.getInt("ID_CASE_MERGE_TO"));
        // The UTC column will display a flag for a case if that case contains a stage that has an overall disposition
        //   of UTC or MOV. Also it will execute for all the unique Case IDs.
        String cdCpsInvstDtlOvrllDisptn = rsFinal.getString("CD_CPS_INVST_DTL_OVRLL_DISPTN");
        if (CodesTables.CDISPSTN_MOV.equals(cdCpsInvstDtlOvrllDisptn) ||
            CodesTables.CDISPSTN_UTC.equals(cdCpsInvstDtlOvrllDisptn)) {
          caseInfoDB.setUtcCaseID(idCase);
        }
        caseList.add(caseInfoDB);
      }
    } catch (SQLException sqlExp) {
      GrndsTrace.msg(TRACE_TAG, 7, "caseList:" + sqlExp.getMessage());
      throw new RuntimeWrappedException(sqlExp);
    } finally {
      cleanup(rsFinal);
      cleanup(stmtFinal);
      performTrace.exitScope();
    }
    return caseList;

  }

  /**
   * This method will be called when the radio button for a case is selected on the PrincipalCaseHistory page. Also the
   * Principal List section will include the Stage Id, Stage Type and Overall Disposition for the INV stage and all of
   * the principals in the stage. For each principal, the Name, Person ID, Age, DOB, Gender, Role, and Rel/Int will be
   * displayed.  The Principal List section will be sorted by Stage ID descending, and then by ID Person ascending
   * order.
   *
   * @param caseID
   * @return ArrayList
   */
  public List<PrincipalListDB> selectPrincipalList(int caseID, int globalCaseID) {
    PerformanceTrace performTrace = new PerformanceTrace(TRACE_TAG, "selectPrincipalList");
    performTrace.enterScope();
    List<PrincipalListDB> princiList = new ArrayList<PrincipalListDB>();
    Connection connection;
    PreparedStatement stmtPrn = null;
    ResultSet rsPrn = null;
    try {
      List<Object> bindVector = new ArrayList<Object>();
      bindVector.add(caseID);
      connection = super.getConnection();
      stmtPrn = connection.prepareStatement(PRN_SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      stmtPrn = addBindVariablesToStatement(stmtPrn, bindVector);
      rsPrn = stmtPrn.executeQuery();
      while (rsPrn.next()) {
        PrincipalListDB principalDB = new PrincipalListDB();
        principalDB.setPersonID(rsPrn.getInt("ID_PERSON"));
        principalDB.setRelation(rsPrn.getString("CD_STAGE_PERS_REL_INT"));
        principalDB.setRole(rsPrn.getString("CD_STAGE_PERS_ROLE"));
        principalDB.setStageId(rsPrn.getInt("ID_STAGE"));
        principalDB.setStage(rsPrn.getString("CD_STAGE"));
        principalDB.setPersonName(rsPrn.getString("NM_PERSON_FULL"));
        principalDB.setDateOfBirth(rsPrn.getDate("DT_PERSON_BIRTH"));
        principalDB.setGender(rsPrn.getString("CD_PERSON_SEX"));

        // The overall disposition column will display a flag for a case if that case contains a STAGE ID
        //   only for INV that has an overall disposition Indicator.
        if ("INV".equals(rsPrn.getString("CD_STAGE"))) {
          principalDB.setOvrDisposition(rsPrn.getString("CD_CPS_INVST_DTL_OVRLL_DISPTN"));
        }
        princiList.add(principalDB);
      }
    } catch (SQLException sqlExp) {
      GrndsTrace.msg(TRACE_TAG, 7, "selectPrincipalList:" + sqlExp.getMessage());
      throw new RuntimeWrappedException(sqlExp);
    } finally {
      cleanup(rsPrn);
      cleanup(stmtPrn);
      performTrace.exitScope();
    }
    return princiList;
  }

  /**
   * This method will insert Parent Child relationship Checked Linked case information into CASE_LINK Table.
   *
   * @param caseLinkDB
   */
  public void insertCaseInfo(CaseLinkDB caseLinkDB) {
    PerformanceTrace performTrace = new PerformanceTrace(TRACE_TAG, "INSERTCASE_SQL");
    performTrace.enterScope();
    Connection connection;
    PreparedStatement stmtCase = null;
    try {
      //This sqlQUery will perform to insert the Checked Linked Case Info into Case Link table.
      List<Object> bindVector = new ArrayList<Object>();
      bindVector.add(caseLinkDB.getCaseLinkSeqID());
      bindVector.add(caseLinkDB.getMainCaseID());
      bindVector.add(caseLinkDB.getIndCaseLink());
      bindVector.add(caseLinkDB.getLinkCaseID());
      bindVector.add(caseLinkDB.getPersonUpdate());
      connection = super.getConnection();
      stmtCase = connection.prepareStatement(CASE_SQL);
      stmtCase = addBindVariablesToStatement(stmtCase, bindVector);
      stmtCase.executeUpdate();
    } catch (SQLException sqlExp) {
      GrndsTrace.msg(TRACE_TAG, 7, "insertCaseInfo:" + sqlExp.getMessage());
      throw new RuntimeWrappedException(sqlExp);
    } finally {
      cleanup(stmtCase);
      performTrace.exitScope();
    }

  }

  /**
   * This method will insert Child Parent relationship Checked Linked case information into CASE_LINK Table.
   *
   * @param caseLinkDB
   */
  public void insertMainCaseInfo(CaseLinkDB caseLinkDB) {
    PerformanceTrace performTrace = new PerformanceTrace(TRACE_TAG, "INSERTMAINCASE_SQL");
    performTrace.enterScope();
    Connection connection;
    PreparedStatement prepStmnt = null;
    try {
      //This sqlQUery will perform to insert the Checked Linked Case Info into Case Link table.
      List<Object> bindVector = new ArrayList<Object>();
      bindVector.add(caseLinkDB.getCaseLinkSeqID());
      bindVector.add(caseLinkDB.getLinkCaseID());
      bindVector.add(caseLinkDB.getIndCaseLink());
      bindVector.add(caseLinkDB.getMainCaseID());
      bindVector.add(caseLinkDB.getPersonUpdate());
      connection = super.getConnection();
      prepStmnt = connection.prepareStatement(CASE_SQL);
      prepStmnt = addBindVariablesToStatement(prepStmnt, bindVector);
      prepStmnt.executeUpdate();
    } catch (SQLException sqlExp) {
      GrndsTrace.msg(TRACE_TAG, 7, "insertCaseInfo:" + sqlExp.getMessage());
      throw new RuntimeWrappedException(sqlExp);
    } finally {
      cleanup(prepStmnt);
      performTrace.exitScope();
    }

  }

  /*
  * This method will update Parent to Child Information. This method updates the Unchecked Linked Case Information into
  * the Case Link. Users with the Merger Case security attribute will be able to update linking even if the case is
  * closed and not in their chain of command. All other users will only be able to use it if the case is open.
  *
  * @param indCaseLink
  * @param idUpdate
  * @param idLinkedCase
  * @param mainCaseID
  */
  public void updateCaseInfo(String indCaseLink, int idUpdate, int idLinkedCase, int mainCaseID) {
    PerformanceTrace performTrace = new PerformanceTrace(TRACE_TAG, " updateCaseInfo");
    performTrace.enterScope();
    Connection connection;
    PreparedStatement prepStmnt = null;
    try {
      // This sqlQuery will perform the Unchecked Linked Case Info into Case Link
      List<Object> bindVector = new ArrayList<Object>();
      bindVector.add(indCaseLink);
      bindVector.add(idUpdate);
      bindVector.add(idLinkedCase);
      bindVector.add(mainCaseID);
      connection = super.getConnection();
      prepStmnt = connection.prepareStatement(UPDCASE_SQL);
      prepStmnt = addBindVariablesToStatement(prepStmnt, bindVector);
      prepStmnt.executeUpdate();
    } catch (SQLException sqlExp) {
      GrndsTrace.msg(TRACE_TAG, 7, "updateCaseInfo:" + sqlExp.getMessage());
      throw new RuntimeWrappedException(sqlExp);
    } finally {
      cleanup(prepStmnt);
      performTrace.exitScope();
    }

  }

  /**
   * updateMainCaseInfo - added on 05/16/2005
   * <p/>
   * This method will updates the Unchecked Linked Case Information. This will update Child  Parent Relationship
   * record.
   *
   * @param indCaseLink
   * @param idUpdate
   * @param mainCaseID
   * @param idLinkedCase
   */
  public void updateMainCaseInfo(String indCaseLink, int idUpdate, int mainCaseID, int idLinkedCase) {
    PerformanceTrace performTrace = new PerformanceTrace(TRACE_TAG, " updateMainCaseInfo");
    performTrace.enterScope();
    Connection connection;
    PreparedStatement prepStmnt = null;
    try {
      // This sqlQuery will perform the Unchecked Linked Case Info into Case Link
      List<Object> bindVector = new ArrayList<Object>();
      bindVector.add(indCaseLink);
      bindVector.add(idUpdate);
      bindVector.add(mainCaseID);
      bindVector.add(idLinkedCase);
      connection = super.getConnection();
      prepStmnt = connection.prepareStatement(UPDCASE_SQL);
      prepStmnt = addBindVariablesToStatement(prepStmnt, bindVector);
      prepStmnt.executeUpdate();
    } catch (SQLException sqlExp) {
      GrndsTrace.msg(TRACE_TAG, 7, "updateCaseInfo:" + sqlExp.getMessage());
      throw new RuntimeWrappedException(sqlExp);
    } finally {
      cleanup(prepStmnt);
      performTrace.exitScope();
    }
  }
}