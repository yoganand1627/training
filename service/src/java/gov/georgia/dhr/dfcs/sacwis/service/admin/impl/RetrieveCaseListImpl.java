package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicCapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CaseMerge;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveCaseList;
import gov.georgia.dhr.dfcs.sacwis.service.admin.UnitAccess;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CodeCounty_ARRAY_CCMN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN20SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO_ARRAY;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/*Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 **  03/19/2008  Corey Harden      Created codeCounty_ARRAY_CCMN20SI and List codeCountyList to be 
 *                                 passed to DAO as a paramter
 *   02/05/2010  Joel Cochran      SMS #43758 - Added variable strIndUseStageCode to send to the
 *                                 DAO to indicate usage of a different order by clause when sorting
 *                                 by stage. (Order by the code 'PAD', 'SUB', etc.) rather than 'Post
 *                                 Adoption', 'Foster Care Children', etc.)
 *
 *
*/

public class RetrieveCaseListImpl extends BaseServiceImpl implements RetrieveCaseList {

  private final String CASE_NM_ET_AL = " et al";
  private final int NM_CASE_MAX_LENGTH = 19;

  private DynamicCapsCaseDAO dynamicCapsCaseDAO = null;

  private CaseMergeDAO caseMergeDAO = null;

  private CpsInvstDetailDAO cpsInvstDetailDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private UnitAccess unitAccess = null;

  public void setUnitAccess(UnitAccess unitAccess) {
    this.unitAccess = unitAccess;
  }

  public void setDynamicCapsCaseDAO(DynamicCapsCaseDAO dynamicCapsCaseDAO) {
    this.dynamicCapsCaseDAO = dynamicCapsCaseDAO;
  }

  public void setCaseMergeDAO(CaseMergeDAO caseMergeDAO) {
    this.caseMergeDAO = caseMergeDAO;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  // static CCMN20SI pInputMsg252 = null;
  public CCMN20SO findCaseListInformation(CCMN20SI ccmn20si) throws ServiceException {
    CCMN20SO ccmn20so = new CCMN20SO();
    String cScrIndStageMerged = new String();
    int idCase = ccmn20si.getUlIdCase();
    int idCaseManager = ccmn20si.getUlIdCaseManager();
    ArchInputStruct archInputStruct = ccmn20si.getArchInputStruct();
    CodeCounty_ARRAY_CCMN20SI codeCounty_ARRAY_CCMN20SI = ccmn20si.getCodeCounty_ARRAY_CCMN20SI();
    String strIndUseStageCode = ccmn20si.getIndUseStageCode(); // Added for SMS #43758
    List codeCountyList;
    if (codeCounty_ARRAY_CCMN20SI == null){
      codeCountyList = new ArrayList();
    } else {
      codeCountyList = codeCounty_ARRAY_CCMN20SI.getSzCdCaseCountyAsReference();
    }

    // Check to see if id-case is blank. If not, then determine if the id-case was closed in a case merge.
    if (0 != idCase) {
      // Calling StagePersonLinkDAO (CMSC56D) that will determine if the case id entered in the
      // search window is a case id closed in a case merge. This allows the rest of the service
      // to search on the correct case merged info.
      Integer idCaseDistinct = stagePersonLinkDAO.findDistinctIdCaseFromStagePersonLinkByIdCase(idCase);
      // If the query was successful, then copy the id_case into the input message.
      // If no rows were found, it is ok, because the case id entered was not a closed case
      if (idCaseDistinct != null && idCaseDistinct > 0) {
        //ccmn20si.setUlIdCase(idCaseDistinct != null ? idCaseDistinct : 0);
        idCase = idCaseDistinct;
      }
    }
    // Calling DynamicCapsCaseDAO, CCMN13D. This DAO retrieves all the cases
    // rc = CallCCMN13D(ccmn20si, ccmn20so, pServiceStatus);
    String nmCase = ccmn20si.getSzNmCase();
    String cdCaseProgram = ccmn20si.getSzCdCaseProgram();
    String nmCaseManager = ccmn20si.getSzNmCaseManager();
    String nmCaseAppend = null;
    // If szNmCase has a case name stored in it and the
    // program is AFC or unspecified,append "et al" to the case name.
    if (StringHelper.isValid(nmCase)
        && (StringHelper.isValid(cdCaseProgram)
            || CodesTables.CPGRMS_AFC.equals(cdCaseProgram))) {
      // Place the "et al" at the end of the case name if there is enough room to do so.
      // The case name must be 19 characters or less (including the comma) for there to be enough room.
      if (nmCase.trim().length() <= NM_CASE_MAX_LENGTH) {
        nmCaseAppend = nmCase + CASE_NM_ET_AL;
      } else {
        // If there is not enough room, truncate the case name to 19 characters
        // (including the comma). Then append the "et al".
        nmCaseAppend = nmCase.substring(0, NM_CASE_MAX_LENGTH) + CASE_NM_ET_AL;
      }
    }
    // ccmn13d
    List<Map> listCases = dynamicCapsCaseDAO.findCases(ccmn20si.getUlIdPerson_ARRAY_CCMN20SI().getUlIdPerson(0),
                                                       idCase, nmCase, CodesTables.CROLEALL_PR,
                                                       CodesTables.CROLEALL_HP, nmCaseAppend,
                                                       ccmn20si.getSzCdCaseProgram(), ccmn20si.getSzCdCaseRegion(),
                                                       ccmn20si.getSzCdCaseCounty(), ccmn20si.getSzAddrMailCodeCity(),
                                                       idCaseManager, nmCaseManager, ccmn20si.getSzCdStage(),
                                                       ccmn20si.getSzNbrUnit(),
                                                       FormattingHelper.formatDate(ccmn20si.getDtDtLastUpdate()),
                                                       ccmn20si.getSelRbOpenClose(),
                                                       ccmn20si.getSzCdCpsInvstDtlOvrllDisptn(),
                                                       Integer.parseInt(ccmn20si.getBWcdCdSortBy()),
                                                       ccmn20si.getSzSortDir(), archInputStruct.getUsPageNbr(),
                                                       archInputStruct.getUlPageSizeNbr(), codeCountyList, strIndUseStageCode);
    if (listCases.isEmpty() || listCases == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    ROWCCMN13DO_ARRAY rowccmn13do_array = new ROWCCMN13DO_ARRAY();
    //settung value of moreDataInd in ccmn20so
    ccmn20so.setMoreDataAvailable((Boolean) listCases.remove(0).get("bMoreDataInd"));
    int i = 0;
    for (Iterator<Map> mapIt = listCases.iterator(); mapIt.hasNext();) {
      Map mapCase = mapIt.next();
      ROWCCMN13DO rowccmn13do = new ROWCCMN13DO();
      Integer idCase_ccmn13do = (Integer) mapCase.get("idCase");
      rowccmn13do.setUlIdCase(idCase_ccmn13do != null ? idCase_ccmn13do : 0);
      rowccmn13do.setUlIdPerson((Integer) mapCase.get("idPerson") != null ? (Integer) mapCase.get("idPerson") : 0);
      rowccmn13do.setBIndCaseSensitive((String) mapCase.get("indCaseSensitive"));
      rowccmn13do.setUlIdSituation((Integer) mapCase.get("idSituation") != null ? (Integer) mapCase.get("idSituation") :
                                   0);
      rowccmn13do.setDtDtCaseClosed(DateHelper.toCastorDate((Date) mapCase.get("dtCaseClosed")));
      rowccmn13do.setDtDtCaseOpenClose(DateHelper.toCastorDate((Date) mapCase.get("dtCaseOpenClose")));
      rowccmn13do.setSzCdCaseProgram((String) mapCase.get("cdCaseProgram"));
      rowccmn13do.setSzNmCase((String) mapCase.get("nmCase"));
      rowccmn13do.setSzScrWorkerPrim((String) mapCase.get("scrWorkerPrim"));
      rowccmn13do.setSzCdStage((String) mapCase.get("cdStage"));
      rowccmn13do.setSzCdCaseCounty((String) mapCase.get("cdCaseCounty"));
      rowccmn13do.setDtDtCaseOpened(DateHelper.toCastorDate((Date) mapCase.get("dtCaseOpened")));
      rowccmn13do.setSzCdCaseRegion((String) mapCase.get("cdCaseRegion"));
      Integer idUnit = (Integer) mapCase.get("idUnit");
      // if there is not an IdUnit on the stage table for this particular case,
      // then set ...bScrIndEmpStageAssign = INDICATOR_NO;
      if (idUnit != null) {
        // Populate service input message with ID PERSON for the user,
        // ID PERSON for the user's designees,
        // The input message contains an array of 7 ID PERSONs
        // ID PERSON[0] = id for person passed in from pinit for search.
        // ID PERSON[1] = id for user
        // ID PERSON[2] - ID PERSON[6] = id for designees 1 - 5
        // Check the unit hierarchy for this case
        UlIdPerson_ARRAY_CCMN20SI ulIdPerson_array_ccmn20si = ccmn20si.getUlIdPerson_ARRAY_CCMN20SI();
        UlIdPerson_ARRAY_CCMN04UI ulIdPerson_array_ccmn04ui = new UlIdPerson_ARRAY_CCMN04UI();
        // Preparing to call UnitAccess
        CCMN04UI ccmn04ui = new CCMN04UI();
        boolean oneTimeExecute = true;
        for (Enumeration ulIdPersonEnum = ulIdPerson_array_ccmn20si.enumerateUlIdPerson();
             ulIdPersonEnum.hasMoreElements();) {
          // skipping the first element, so as to start from index 1
          if (oneTimeExecute) {
            ulIdPersonEnum.nextElement();
          }
          Integer idPerson_ccmn20si = (Integer) ulIdPersonEnum.nextElement();
          if (0 != idPerson_ccmn20si) {
            Integer idPerson = idPerson_ccmn20si;
            ulIdPerson_array_ccmn04ui.addUlIdPerson(idPerson);
          }
          oneTimeExecute = false;
        }
        ccmn04ui.setUlIdPerson_ARRAY_CCMN04UI(ulIdPerson_array_ccmn04ui);
        ccmn04ui.setUlIdUnit(idUnit != null ? idUnit : 0);
        // Calling UnitAccess
        CCMN04UO ccmn04uo = unitAccess.checkForPersonWithUnitAccess(ccmn04ui);
        if (ccmn04uo == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        if (ArchitectureConstants.Y.equals(ccmn04uo.getBSysIndGeneric())) {
          rowccmn13do.setBScrIndEmpStageAssign(ArchitectureConstants.Y);
        } else {
          rowccmn13do.setBScrIndEmpStageAssign(ArchitectureConstants.N);
        }
      } // end if (idUnit != null)
      else {
        rowccmn13do.setBScrIndEmpStageAssign(ArchitectureConstants.N);
      }
      // Make sure that ID_CASE_MERGE_TO column exists and the specific case is located on the CASE_MERGE
      // Retrieve all rows from the the CASE_MERGE table where the ID_CASE exists in
      // the ID_CASE_MERGE_TO column.
      // Calling CaseMergeDAO, CLSC68D to retreive the ID_CASE for the given stage
      List<CaseMerge> listCaseMerge = caseMergeDAO.findByIdCaseMergeTo(idCase_ccmn13do);
      if (listCaseMerge != null || !listCaseMerge.isEmpty()) {
        for (Iterator<CaseMerge> caseMergeIt = listCaseMerge.iterator(); caseMergeIt.hasNext() &&
                                                                         !ArchitectureConstants.Y.equals(
                                                                                 cScrIndStageMerged);) {
          CaseMerge caseMerge = caseMergeIt.next();
          if (ArchitectureConstants.N.equals(caseMerge.getIndCaseMergePending())
              && caseMerge.getDtCaseMergeSplit() == null) {
            cScrIndStageMerged = ArchitectureConstants.Y;
            rowccmn13do.setCScrIndStageMerged(cScrIndStageMerged);
          }
        }
      } else {
        cScrIndStageMerged = ArchitectureConstants.Y;
        rowccmn13do.setCScrIndStageMerged(cScrIndStageMerged);
      }
      i++;
      rowccmn13do_array.addROWCCMN13DO(rowccmn13do);
    } // end for loop ... dynamicCapsCaseDAO List
    rowccmn13do_array.setUlRowQty(i);
    // Populating output structure with retrieved row information
    ccmn20so.setROWCCMN13DO_ARRAY(rowccmn13do_array);
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    archOutputStruct.setUlRowQty(rowccmn13do_array.getUlRowQty());
    ccmn20so.setArchOutputStruct(archOutputStruct);// End if listCases .... DynamicCapsCaseDAO ends
    // Calling CpsInvstDetailDAO CLSCB7D
    // This will search for Overall Dispositions of UTC or MOV in the cases.
    List<Integer> idCaseList = callCpsInvstDetailDAO(ccmn20so);
    if (idCaseList != null && !idCaseList.isEmpty()) {
      ROWCCMN13DO_ARRAY rowccmn13do_array_forOutput = new ROWCCMN13DO_ARRAY();
      for (Enumeration rowccmn13doEnum = rowccmn13do_array.enumerateROWCCMN13DO(); rowccmn13doEnum.hasMoreElements();) {
        ROWCCMN13DO rowccmn13do = (ROWCCMN13DO) rowccmn13doEnum.nextElement();
        for (Iterator<Integer> itIdCase = idCaseList.iterator(); itIdCase.hasNext();) {
          Integer idCaseDistinct = itIdCase.next();
          rowccmn13do.setCScrIndCaseUTC(ArchitectureConstants.N);
          if ((rowccmn13do.getUlIdCase() == idCaseDistinct)
              && !(rowccmn13do.getCScrIndCaseUTC().equals(ArchitectureConstants.Y))) {
            rowccmn13do.setCScrIndCaseUTC(ArchitectureConstants.Y);
            break;
          }
        }
        rowccmn13do_array_forOutput.addROWCCMN13DO(rowccmn13do);
      }
      ccmn20so.setROWCCMN13DO_ARRAY(rowccmn13do_array_forOutput);
    }
    return ccmn20so;
  }

  private List<Integer> callCpsInvstDetailDAO(CCMN20SO ccmn20so) {
    ROWCCMN13DO_ARRAY rowccmn13do_array = ccmn20so.getROWCCMN13DO_ARRAY();
    int[] idCaseArray = new int[50];
    // Initialize array to hold 0
    for (int i = 0; i < idCaseArray.length; i++) {
      idCaseArray[i] = 0;
    }
    int index = 0;
    for (Enumeration rowccmn13doEnum = rowccmn13do_array.enumerateROWCCMN13DO(); rowccmn13doEnum.hasMoreElements();
         index++) {
      ROWCCMN13DO rowccmn13do = (ROWCCMN13DO) rowccmn13doEnum.nextElement();
      idCaseArray[index] = rowccmn13do.getUlIdCase();
    }
    // clscb7d
    List<Integer> idCaseList = cpsInvstDetailDAO.findCpsInvstDetailIdCase(idCaseArray[0], idCaseArray[1],
                                                                          idCaseArray[2], idCaseArray[3],
                                                                          idCaseArray[4], idCaseArray[5],
                                                                          idCaseArray[6], idCaseArray[7],
                                                                          idCaseArray[8], idCaseArray[9],
                                                                          idCaseArray[10], idCaseArray[11],
                                                                          idCaseArray[12], idCaseArray[13],
                                                                          idCaseArray[14], idCaseArray[15],
                                                                          idCaseArray[16], idCaseArray[17],
                                                                          idCaseArray[18], idCaseArray[19],
                                                                          idCaseArray[20], idCaseArray[21],
                                                                          idCaseArray[22], idCaseArray[23],
                                                                          idCaseArray[24], idCaseArray[25],
                                                                          idCaseArray[26], idCaseArray[27],
                                                                          idCaseArray[28], idCaseArray[29],
                                                                          idCaseArray[30], idCaseArray[31],
                                                                          idCaseArray[32], idCaseArray[33],
                                                                          idCaseArray[34], idCaseArray[35],
                                                                          idCaseArray[36], idCaseArray[37],
                                                                          idCaseArray[38], idCaseArray[39],
                                                                          idCaseArray[40], idCaseArray[41],
                                                                          idCaseArray[42], idCaseArray[43],
                                                                          idCaseArray[44], idCaseArray[45],
                                                                          idCaseArray[46], idCaseArray[47],
                                                                          idCaseArray[48], idCaseArray[49]);
    return idCaseList;
  }
}
