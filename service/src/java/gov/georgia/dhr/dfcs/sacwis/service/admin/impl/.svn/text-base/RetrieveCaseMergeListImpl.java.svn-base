package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCaseMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveCaseMergeList;
import gov.georgia.dhr.dfcs.sacwis.service.admin.UnitAccess;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00_ARRAY;
/**
 * 
 * 
 *  *
 * <pre>
 *               Change History:
 *                Date        User      Description
 *                ----------  --------  --------------------------------------------------
 *                11/21/2008  arege     STGAP00005850 Case Merge/Split Section From Status 
 *                                      not displayed on Case Summary Page.
 *                                      Set Status to Closed if DtCaseClosed is not null else 
 *                                      set Status to Open.
 *    
 *                                      
 *                                 
 * 
 * 
 */

public class RetrieveCaseMergeListImpl extends BaseServiceImpl implements RetrieveCaseMergeList {

  private CapsCaseDAO capsCaseDAO = null;
  private ComplexCaseMergeDAO complexCaseMergeDAO = null;
  private PersonDAO personDAO = null;
  private UnitAccess unitAccess = null;
  private static final String CASE_STATUS_OPEN = "Open";
  private static final String CASE_STATUS_CLOSED = "Closed";
  
  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setComplexCaseMergeDAO(ComplexCaseMergeDAO complexCaseMergeDAO) {
    this.complexCaseMergeDAO = complexCaseMergeDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setUnitAccess(UnitAccess unitAccess) {
    this.unitAccess = unitAccess;
  }

  public CCFC39SO findCaseMergeList(CCFC39SI ccfc39si) throws ServiceException {
    CCFC39SO ccfc39so = new CCFC39SO();
    ccfc39so.setDtDtTodaysDate(DateHelper.toCastorDate(new Date()));

    int idCase = ccfc39si.getUlIdCase();
    ArchInputStruct archInputStruct = ccfc39si.getArchInputStruct();
    String cReqFuncCd = archInputStruct.getCReqFuncCd();
    if (ServiceConstants.REQ_FUNC_CD_SEARCH.equals(cReqFuncCd)) {
      // ccmnd9d
      CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);
      if (capsCase == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      ccfc39so.setSzCdCaseProgram(capsCase.getCdCaseProgram());
      Date dtCaseClosed = capsCase.getDtCaseClosed();
      if (dtCaseClosed != null) {
        ccfc39so.setCScrIndToCaseCld(ArchitectureConstants.Y);
      } else {
        ccfc39so.setCScrIndToCaseCld(ArchitectureConstants.N);
      }
    }

    // Retrieve the case merge information.
    ccfc39so.setROWCCFC39SOG00_ARRAY(retrieveCaseMergeInformation(idCase));

    // Determine if the caller has merge access.
    ccfc39so.setCSysIndMergeAccess(determineMergeAccess(idCase, ccfc39si.getUlIdPerson(),
                                                        ccfc39si.getCSysIndMergeAccess(),
                                                        ccfc39so.getCScrIndToCaseCld(), cReqFuncCd,
                                                        archInputStruct.getUsPageNbr(),
                                                        archInputStruct.getUlPageSizeNbr()));
    return ccfc39so;
  }

  private String determineMergeAccess(int idCase, int idPerson, String sysIndMergeAccess, String scrIndToCaseCld,
                                      String cReqFuncCd, int pageNbr, int pageSize) {
    // See if any of the people assocaited with the case have merge access.
    // clsc64d -- Ignores SQL_NOT_FOUND
    List<Map> personMap = personDAO.findPersonByIdCase(idCase, pageNbr, pageSize);
    if (!ArchitectureConstants.Y.equals(sysIndMergeAccess) && ServiceConstants.REQ_FUNC_CD_SEARCH.equals(cReqFuncCd)
        && ArchitectureConstants.N.equals(scrIndToCaseCld)) {
      // Copy Yes to the IndMergeAccess if one of the idperson from dam output matches with the service idperson
      for (Iterator<Map> it = personMap.iterator(); it.hasNext();) {
        Map map = it.next();
        if (idPerson == (Integer) map.get("idPerson")) {
          return ArchitectureConstants.Y;
        }
      }
    }
    //Used to read:
    // If we still have not found merge accesc, call the Unit Access function for each primary worker returned above,
    //   to determine if the logged in user is in the unit hierarchy of a primaryworker in the given case.
    //Now:
    // If we still have not found merge accesc, call the Unit Access function for theunit of each primary worker
    //   returned above to determine if the logged in user is in the unit hierarchy of a primaryworker in the given
    //   case. Loop through once so we have a unique list of units, which will be much smaller than the list of workers.
    Set<Integer> idUnitSet = new LinkedHashSet<Integer>(0);
    for (Iterator<Map> it = personMap.iterator(); it.hasNext();) {
      Map map = it.next();
      idUnitSet.add((Integer) map.get("idUnit"));
    }
    // Iterate over the unique set of units.
    for (Iterator<Integer> it = idUnitSet.iterator(); it.hasNext();) {
      Integer idUnit = it.next();
      CCMN04UI ccmn04ui = new CCMN04UI();
      ccmn04ui.setUlIdUnit(idUnit);
      UlIdPerson_ARRAY_CCMN04UI ulIdPerson_array_ccmn04ui = new UlIdPerson_ARRAY_CCMN04UI();
      ulIdPerson_array_ccmn04ui.setUlIdPerson(new int[] {idPerson});
      ccmn04ui.setUlIdPerson_ARRAY_CCMN04UI(ulIdPerson_array_ccmn04ui);
      CCMN04UO ccmn04uo = unitAccess.checkForPersonWithUnitAccess(ccmn04ui);
      if (StringHelper.isTrue(ccmn04uo.getBSysIndGeneric())) {
        return ArchitectureConstants.Y;
      }
    }
    return ArchitectureConstants.N;
  }

  private ROWCCFC39SOG00_ARRAY retrieveCaseMergeInformation(int idCase) {
    // cmsc38d -- Ignores SQL_NOT_FOUND
    List<Map> caseMergeMap = complexCaseMergeDAO.findCaseMerge(idCase);
    ROWCCFC39SOG00_ARRAY rowccfc39sog00_array = new ROWCCFC39SOG00_ARRAY();
    if (caseMergeMap != null && !caseMergeMap.isEmpty()) {
      rowccfc39sog00_array = processComplexCaseMergeMap(caseMergeMap);
    } else {
      // If nothing is returned by cmsc38d
      // cmsc50d -- Ignores SQL_NOT_FOUND
      List<Map> caseMergeFromMap = complexCaseMergeDAO.findCaseMergeFrom(idCase);
      if (caseMergeFromMap != null && !caseMergeFromMap.isEmpty()) {
        rowccfc39sog00_array = processComplexCaseMergeMap(caseMergeFromMap);
      }
    }
    return rowccfc39sog00_array;
  }

  private ROWCCFC39SOG00_ARRAY processComplexCaseMergeMap(List<Map> complexCaseMergeMap) {
    // If any of idCaseMergeFrom, idCaseMergeTo indCaseMergeInv, or dtCase Merge are not the same as the previous
    // record returned, then include them. Otherwise, skip them. We always include the first row by defaulting
    // includeRow to true.
    ROWCCFC39SOG00_ARRAY rowCcfc39SoG00Array = new ROWCCFC39SOG00_ARRAY();
    Map prevCaseMergeMap = null;
    for (Iterator<Map> it = complexCaseMergeMap.iterator(); it.hasNext();) {
      Map caseMergeMap = it.next();
      Integer idCaseMergeFrom = (Integer) caseMergeMap.get("idCaseMergeFrom");
      Integer idCaseMergeTo = (Integer) caseMergeMap.get("idCaseMergeTo");
      String indCaseMergInv = (String) (caseMergeMap.get("indCaseMergeInv") != null ? 
                                        caseMergeMap.get("indCaseMergeInv") : "");
      Date dtCaseMerge = (Date) caseMergeMap.get("dtCaseMerge");
      boolean includeRow = true;

      if (prevCaseMergeMap != null) {
        Integer prevIdCaseMergeFrom = (Integer) prevCaseMergeMap.get("idCaseMergeFrom");
        Integer prevIdCaseMergeTo = (Integer) prevCaseMergeMap.get("idCaseMergeTo");
        String prevIndCaseMergInv = (String) (prevCaseMergeMap.get("indCaseMergeInv") != null ?
                                              prevCaseMergeMap.get("indCaseMergeInv") : "");
        Date prevDtCaseMerge = (Date) prevCaseMergeMap.get("dtCaseMerge");
        if (prevIdCaseMergeFrom.equals(idCaseMergeFrom) &&
            prevIdCaseMergeTo.equals(idCaseMergeTo) &&
            prevIndCaseMergInv.equals(indCaseMergInv) &&
            prevDtCaseMerge.equals(dtCaseMerge)) {
          includeRow = false;
        }
      }
      if (includeRow) {
        ROWCCFC39SOG00 rowCcfc39SoG00 = new ROWCCFC39SOG00();
        rowCcfc39SoG00.setCIndCaseMergePending((String) caseMergeMap.get("indCaseMergePend"));        
        rowCcfc39SoG00.setUlIdCaseMerge(caseMergeMap.get("idCaseMerge") != null ?
                                        (Integer) caseMergeMap.get("idCaseMerge") : 0);
        rowCcfc39SoG00.setSzScrNmCaseMrgTo((String) caseMergeMap.get("nmCaseMrgTo"));
        rowCcfc39SoG00.setUlIdCaseMergeTo(idCaseMergeTo != null ? idCaseMergeTo : 0);
        //Per STGAP00005850 Case Merge/Split Section From Status not displayed on Case Summary Page.
        // set Status to Closed if DtCaseClosed is not null else set Status to Open.
        if (idCaseMergeTo!=null){
          CapsCase capsCase = getPersistentObject(CapsCase.class, idCaseMergeTo);
          Date caseMergeToDateClosed = capsCase.getDtCaseClosed();
          if (caseMergeToDateClosed != null){
           rowCcfc39SoG00.setSzCaseMrgToStatus(CASE_STATUS_CLOSED);            
          }else{
            rowCcfc39SoG00.setSzCaseMrgToStatus(CASE_STATUS_OPEN);
          }       
        }
        rowCcfc39SoG00.setSzScrNmCaseMrgFrom((String) caseMergeMap.get("nmCaseMrgFrom"));
        rowCcfc39SoG00.setUlIdCaseMergeFrom(idCaseMergeFrom != null ? idCaseMergeFrom : 0);
        //Per STGAP00005850 Case Merge/Split Section From Status not displayed on Case Summary Page.
        // set Status to Closed if DtCaseClosed is not null else set Status to Open.
        if (idCaseMergeFrom!=null){
          CapsCase capsCase = getPersistentObject(CapsCase.class, idCaseMergeFrom);
          Date caseMergeFromDateClosed = capsCase.getDtCaseClosed();
          if (caseMergeFromDateClosed != null){
           rowCcfc39SoG00.setSzCaseMrgFromStatus(CASE_STATUS_CLOSED);            
          }else{
            rowCcfc39SoG00.setSzCaseMrgFromStatus(CASE_STATUS_OPEN);
          }       
        }
        rowCcfc39SoG00.setDtDtCaseMerge(DateHelper.toCastorDate(dtCaseMerge));
        rowCcfc39SoG00.setSzScrMergeWorker((String) caseMergeMap.get("scrNmMergeWorker"));
        Integer idCaseMergPersMgr = (Integer) caseMergeMap.get("idCaseMergePersMgr");
        rowCcfc39SoG00.setUlIdCaseMergePersMrg(idCaseMergPersMgr != null ? idCaseMergPersMgr : 0);
        rowCcfc39SoG00.setDtCaseMergeSplit(DateHelper.toCastorDate((Date) caseMergeMap.get("dtCaseMergeSplit")));
        rowCcfc39SoG00.setSzScrNmSplitWorker((String) caseMergeMap.get("scrNmSplitWorker"));
        Integer idCaseMergePersSplit = (Integer) caseMergeMap.get("idCaseMergePersSplit");
        rowCcfc39SoG00.setUlIdCaseMergePersSplit(idCaseMergePersSplit != null ? idCaseMergePersSplit : 0);
        rowCcfc39SoG00.setCIndCaseMergeInv(indCaseMergInv);
        rowCcfc39SoG00.setTsLastUpdate((Date) caseMergeMap.get("dtLastUpdate"));
        rowCcfc39SoG00Array.addROWCCFC39SOG00(rowCcfc39SoG00);
      }
      prevCaseMergeMap = caseMergeMap;
    }
    return rowCcfc39SoG00Array;
  }
}
