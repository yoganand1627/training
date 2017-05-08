package gov.georgia.dhr.dfcs.sacwis.service.person;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoDataReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.CaseInfoDB;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.CaseLinkDB;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.PrincipalCaseHistoryDao;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.PrincipalListDB;

/**
 * This PrincipalCaseHistoryBean class execute the methods declared in the PrincipalCaseHistory Remote class. Each
 * method will get connection from JdbcHelper and Passes to PrincipalCaseHistoryDao class also to execute Dao methods.
 * <pre>
 * Change History:
 * Date      User         Description
 * -------  ----------- -----------------------------------------------------------------------------------------------
 * 04/08/05  ANANDV       SIR 23522 - PrincipalCaseHistoryBean for PrincipalCaseHistory Page
 * 05/16/05  ANANDV       SIR 23522 - Added two separate methods to Insert/Update Parent Child Relationship record as
 *                                    well as Child Parent Relations ship records.
 * </pre>
 *
 * @author Vijaya Anand
 */
public class PrincipalCaseHistoryBean extends BaseServiceEjb {

  public static final String TRACE_TAG = "PrincipalCaseHistoryBean";

  /**
   * caseList
   * <p/>
   * This method used to get Case List Information based on the given Case ID.
   *
   * @param caseID
   * @return
   */
  public List<CaseInfoDB> caseList(int caseID) {
    Connection connection = null;
    PrincipalCaseHistoryDao principalDao;
    List<CaseInfoDB> caseList = new ArrayList<CaseInfoDB>();
    try {
      connection = JdbcHelper.getConnection();
      principalDao = new PrincipalCaseHistoryDao(connection);
      //calling PrincipalCaseHistoryDao to get Case List Info.
      caseList = principalDao.caseList(caseID);
    } finally {
      //After finishing all the process it will close the db connection.
      cleanup(connection);
    }
    return caseList;
  }

  /**
   * selectPrincipalList
   * <p/>
   * This method used to get the Principal List info based on the user selected Radio Button on the page.
   *
   * @param caseID
   * @param globalCaseID
   * @return
   * @throws NoDataReturnedException
   */
  public List<PrincipalListDB> selectPrincipalList(int caseID, int globalCaseID) throws NoDataReturnedException {
    Connection connection = null;
    PrincipalCaseHistoryDao historyDao;
    List<PrincipalListDB> prnList = new ArrayList<PrincipalListDB>();
    try {
      connection = JdbcHelper.getConnection();
      historyDao = new PrincipalCaseHistoryDao(connection);
      //calling PrincipalCaseHistoryDao to get Principal List Info.
      prnList = historyDao.selectPrincipalList(caseID, globalCaseID);
    } finally {
      //After finishing all the process it will close the db connection.
      cleanup(connection);
    }
    return prnList;
  }

  /**
   * saveCaseInfo
   * <p/>
   * This method will get all the Checked Case List Info from the page and save it to Case Link table.
   *
   * @param linkList
   */

  public void saveCaseInfo(List<CaseLinkDB> linkList) throws NoDataReturnedException {
    Connection connection = null;
    PrincipalCaseHistoryDao caseDao;
    CaseLinkDB linkDB;
    try {
      connection = JdbcHelper.getConnection();
      caseDao = new PrincipalCaseHistoryDao(connection);
      if (linkList != null) {
        Iterator<CaseLinkDB> linkIter = linkList.iterator();
        while (linkIter.hasNext()) {
          // Using Iterator get one by one Case List info and pass CaseLinkDB to Dao.
          linkDB = linkIter.next();
          // Calling PrincipalCaseHistoryDao to insert Case Link Info
          // Added insertCaseInfo() - will insert Parent Child Relatioship
          // Record into CASE_LINK table.
          caseDao.insertCaseInfo(linkDB);
          //Added insertMainCaseInfo() will insert Child Parent Relationship
          //Record into CASE_LINK table.
          caseDao.insertMainCaseInfo(linkDB);
        }
      }
    } finally {
      //After finishing all the process it will close the db connection.
      cleanup(connection);
    }
  }

  /**
   * This method will get all the Unchecked Case List Info from the page and update into the Case Link table.
   *
   * @param indCaseLink
   * @param idUpdate
   * @param idLinkedCase
   * @param mainCaseID
   * @throws NoDataReturnedException
   */
  public void updateCaseInfo(String indCaseLink, int idUpdate, int idLinkedCase, int mainCaseID)
          throws NoDataReturnedException {
    Connection connection = null;
    PrincipalCaseHistoryDao historyDao;
    try {
      connection = JdbcHelper.getConnection();
      historyDao = new PrincipalCaseHistoryDao(connection);
      // Calling PrincipalCaseHistoryDao to update Case Link Info.
      // updateCaseInfo() will update Parent Child Relationship record.
      historyDao.updateCaseInfo(indCaseLink, idUpdate, idLinkedCase, mainCaseID);
      // Added updateMainCaseInfo() to update Child Parent Relationship record onto CASE_LINK table.
      historyDao.updateMainCaseInfo(indCaseLink, idUpdate, mainCaseID, idLinkedCase);
    } finally {
      //After finishing all the process it will close the db connection.
      cleanup(connection);
    }
  }
}