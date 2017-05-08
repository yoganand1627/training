package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCaseMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;

public class ComplexCaseMergeDAOImpl extends BaseDAOImpl implements ComplexCaseMergeDAO {
  private CaseMergeDAO caseMergeDAO = null;
  private CapsCaseDAO capsCaseDAO = null;
  private PersonDAO personDAO = null;

  public void setCaseMergeDAO(CaseMergeDAO caseMergeDAO) {
    this.caseMergeDAO = caseMergeDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  /**
   * Add additional results to the complex query. The new results is a list of map object including: <ul> <li>Each value
   * from the Object[] returned by the method used to find the case merge data.</li> <li>nmCaseMergeTo object for this
   * idCaseMergeTo</li> <li>nmCaseMergeFrom object for this idCaseMergeFrom</li> <li>scrNmMergeWorker object for this
   * idCaseMergePersMgr</li> <li>scrNmSplitWorker object for this  idCaseMergePersSplit</li> </ul>
   *
   * @param inList
   * @return List<Map>
   */
  private List<Map> addComplex(List<Object[]> inList) {
    List<Map> listNew = new LinkedList<Map>();
    for (Iterator<Object[]> it = inList.iterator(); it.hasNext();) {
      Object[] obj = it.next();
      Integer idCaseMerge = (Integer) obj[0]; // idCaseMerge is 1st returned scalar object
      Integer idCaseMergeFrom = (Integer) obj[1]; // idCaseMergeFrom is 2nd returned scalar object
      Integer idCaseMergeTo = (Integer) obj[2]; // idCaseMergeTo is 3rd returned scalar object
      Date dtCaseMerge = (Date) obj[3]; // dtCaseMerge is 4th returned scalar object
      Date dtCaseMergeSplit = (Date) obj[4]; // dtCaseMergeSplit is 5th returned scalar object
      Integer idCaseMergePersMgr = (Integer) obj[5]; // idCaseMergePersMgr is 6th returned scalar object
      Integer idCaseMergePersSplit = (Integer) obj[6]; // idCaseMergePersSplit is 7th returned scalar object
      String indCaseMergeInv = (String) obj[7]; // idCaseMergePersSplit is 8th returned scalar object
      String indCaseMergePend = (String) obj[8]; // idCaseMergePersPend is 9th returned scalar object
      Date dtLastUpdate = (Date) obj[9]; // dtCaseMergeSplit is 10th returned scalar object

      Map<String, Object> results = new HashMap<String, Object>();
      results.put("idCaseMerge", idCaseMerge);
      results.put("idCaseMergeFrom", idCaseMergeFrom);
      results.put("idCaseMergeTo", idCaseMergeTo);
      results.put("dtCaseMerge", dtCaseMerge);
      results.put("dtCaseMergeSplit", dtCaseMergeSplit);
      results.put("idCaseMergePersMgr", idCaseMergePersMgr);
      results.put("idCaseMergePersSplit", idCaseMergePersSplit);
      results.put("indCaseMergeInv", indCaseMergeInv);
      results.put("indCaseMergePend", indCaseMergePend);
      results.put("nmCaseMrgTo", idCaseMergeTo != null ? capsCaseDAO.findNmCaseByIdCaseMergeTo(idCaseMergeTo) : "");
      results.put("nmCaseMrgFrom", idCaseMergeFrom != null ? capsCaseDAO.findNmCaseByIdCaseMergeFrom(idCaseMergeFrom) : "");
      results.put("scrNmMergeWorker", idCaseMergePersMgr != null ? personDAO.findNmFullByIdPerson(idCaseMergePersMgr) : "");//nameFull
      results.put("dtLastUpdate", dtLastUpdate);
      results.put("scrNmSplitWorker", idCaseMergePersSplit != null ? personDAO.findNmFullByIdPerson(idCaseMergePersSplit) : "");
      
      listNew.add(results);
    }
    return listNew;
  }

  public List<Map> findCaseMerge(int idCaseMerge) {
    List<Object[]> caseMergeList = caseMergeDAO.findCaseMerge(idCaseMerge);
    List<Map> mapResult = null;
    if (caseMergeList != null) {
      mapResult = addComplex(caseMergeList);
    }
    return mapResult;
  }

  public List<Map> findCaseMergeFrom(int idCaseMerge) {
    List<Object[]> caseMergeList = caseMergeDAO.findCaseMergeFrom(idCaseMerge);
    List<Map> mapResult = null;
    if (caseMergeList != null) {
      mapResult = addComplex(caseMergeList);
    }
    return mapResult;
  }
}
