/**
 * This service saves UAS program and entitlement code to the Maintenance table. It also inserts entry to appropriate codes tables 
 * that are used in various financial pages and payment processing batches. Every update to an existing entry is saved to an 
 * audit table. 
 */
package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CodesTablesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCodesTablesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEquivalencyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EquivalencyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.ComplexSvcAuthUasEntCodeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.ComplexUASEntCodeMtntAuditDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.ComplexUASEntCodeMtntDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.SvcAuthUasEntCodeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.UASEntCodeMtntDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.UASPrgCodeMtntAuditDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.UASProgramCodeMtntDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CodesTablesId;
import gov.georgia.dhr.dfcs.sacwis.db.Equivalency;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthUasEntCode;
import gov.georgia.dhr.dfcs.sacwis.db.UasEntCodeMtnt;
import gov.georgia.dhr.dfcs.sacwis.db.UasEntCodeMtntAudit;
import gov.georgia.dhr.dfcs.sacwis.db.UasPrgCodeMtntAudit;
import gov.georgia.dhr.dfcs.sacwis.db.UasProgramCodeMtnt;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveUASProgramCodeMtnt;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UASProgramCodeMtntSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASEntitlementCodeDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeMtntSaveSO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hong-van.t.vo
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  09/02/11  htvo      STGAP00017019: ECEM 5.0: UAS Program Code Maintenance - new page development
 *  10/20/11  htvo      STGAP00017324: fixed invalid date format
 *                      STGAP00017322: validate line item limit amount to against case budget amount only there is 
 *                      case budget limit.
 *  11/02/11  htvo      STGAP00017561: removed insert to codes tables when adding header to fix duplicate entry 
 *                      between app and trigger  
 *  11/14/11  htvo      STGAP00017672: validate all headers against existing pool at once and set error flag;
 *                      bypass validation if flag overridden.
 *  02/21/12  htvo      STGAP00017924: enhanced to insert to audit table on Add so that accidental changes can 
 *                      be fully reverted.                                                      
 * </pre>
 */
public class SaveUASProgramCodeMtntImpl extends BaseServiceImpl implements SaveUASProgramCodeMtnt {

  private CodesTablesDAO codesTablesDAO = null;
  
  private ComplexCodesTablesDAO complexCodesTablesDAO = null;

  private ComplexEquivalencyDAO complexEquivalencyDAO = null;
  
  private ComplexSvcAuthUasEntCodeDAO complexSvcAuthUasEntCodeDAO = null;
  
  private ComplexUASEntCodeMtntDAO complexUASEntCodeMtntDAO = null;

  private ComplexUASEntCodeMtntAuditDAO complexUASEntCodeMtntAuditDAO = null;
  
  private EquivalencyDAO equivalencyDAO = null;
  
  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;
  
  private SvcAuthUasEntCodeDAO svcAuthUasEntCodeDAO = null;

  private UASEntCodeMtntDAO uasEntCodeMtntDAO = null;

  private UASProgramCodeMtntDAO uasProgramCodeMtntDAO = null;

  private UASPrgCodeMtntAuditDAO uasPrgCodeMtntAuditDAO = null;

  public void setCodesTablesDAO(CodesTablesDAO codesTablesDAO) {
    this.codesTablesDAO = codesTablesDAO;
  }

  public void setComplexCodesTablesDAO(ComplexCodesTablesDAO complexCodesTablesDAO) {
    this.complexCodesTablesDAO = complexCodesTablesDAO;
  }

  public void setComplexEquivalencyDAO(ComplexEquivalencyDAO complexEquivalencyDAO) {
    this.complexEquivalencyDAO = complexEquivalencyDAO;
  }
  
  public void setComplexSvcAuthUasEntCodeDAO(ComplexSvcAuthUasEntCodeDAO complexSvcAuthUasEntCodeDAO) {
    this.complexSvcAuthUasEntCodeDAO = complexSvcAuthUasEntCodeDAO;
  }

  public void setUasProgramCodeMtntDAO(UASProgramCodeMtntDAO uasProgramCodeMtntDAO) {
    this.uasProgramCodeMtntDAO = uasProgramCodeMtntDAO;
  }

  public void setUasPrgCodeMtntAuditDAO(UASPrgCodeMtntAuditDAO uasPrgCodeMtntAuditDAO) {
    this.uasPrgCodeMtntAuditDAO = uasPrgCodeMtntAuditDAO;
  }

  public void setComplexUASEntCodeMtntDAO(ComplexUASEntCodeMtntDAO complexUASEntCodeMtntDAO) {
    this.complexUASEntCodeMtntDAO = complexUASEntCodeMtntDAO;
  }

  public void setComplexUASEntCodeMtntAuditDAO(ComplexUASEntCodeMtntAuditDAO complexUASEntCodeMtntAuditDAO) {
    this.complexUASEntCodeMtntAuditDAO = complexUASEntCodeMtntAuditDAO;
  }

  public void setEquivalencyDAO(EquivalencyDAO equivalencyDAO) {
    this.equivalencyDAO = equivalencyDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }
  
  public void setSvcAuthUasEntCodeDAO(SvcAuthUasEntCodeDAO svcAuthUasEntCodeDAO) {
    this.svcAuthUasEntCodeDAO = svcAuthUasEntCodeDAO;
  }

  public void setUasEntCodeMtntDAO(UASEntCodeMtntDAO uasEntCodeMtntDAO) {
    this.uasEntCodeMtntDAO = uasEntCodeMtntDAO;
  }
  
  private final static String UPDATE = "UPDATE";

  private final static String ADD_UAS = "ADD_UAS";

  private final static String ADD_ENT = "ADD_ENT";
  
  private final static String UAS_PROG_CODE_TYPE = CodesTables.CPRGCODE;
  
  private final static String UAS_SVC_CODE_TYPE = CodesTables.CSVCCODE;
    
  //this value group (8) should be in sync with the Conversation
  public final static String CCI = "CCI";

  public final static String CPA = "CPA";

  public final static String PSSF = "PSSF";
  
  private static final String FC_ADD_ON = "FC_ADD_ON";
  
  private static final String SVC_AUTH = "SVC_AUTH";
  
  private static final String MILEAGE = "MILEAGE";
  
  private static final String REL = "REL_CARE";
  
  private static final String CBL = "CASE_BUDGET_LIMIT";
  
  private static final String LIL = "LINE_ITEM_LIMIT";
  
  private static final String HEADER = "ENT_HEADER";

  // List of codes tables code type for the following subprograms and service amount limit: 
  // CCI, CPA, Foster care Invoice Add on, Mileage, Relative Care, Case Budget Limit, and Line Item Limit 
  private static final List<String> SUB_PROGRAM_CODE_TYPE_LIST = Arrays.asList(new String[]{CodesTables.CCCISVCD,
                                                                                            CodesTables.CCCIUTRT,
                                                                                            CodesTables.CCCIPTYP,
                                                                                            CodesTables.CCCIUTYP,
                                                                                            CodesTables.CCPASVCD,
                                                                                            CodesTables.CCPAUTRT,
                                                                                            CodesTables.CCPAPTYP,
                                                                                            CodesTables.CCPAUTYP,
                                                                                            CodesTables.CRELCODE,
                                                                                            CodesTables.CMILEAGE,
                                                                                            CodesTables.CSBGTLMT,
                                                                                            CodesTables.CADDONLI,
                                                                                            CodesTables.CSAMTLMT,
                                                                                            CodesTables.CPRGCOD1,
                                                                                            CodesTables.CENTCODE
                                                                                            });
  
  private static final Map<String, String> SUB_PROGRAM_CODE_TYPE_LOOKUP = new HashMap<String,String>()
  {
    {put(FC_ADD_ON,CodesTables.CADDONLI);
     put(HEADER,CodesTables.CENTCODE);
     put(MILEAGE,CodesTables.CMILEAGE);
     put(REL,CodesTables.CRELCODE);
     put(SVC_AUTH,CodesTables.CPRGCOD1);
     put(CBL,CodesTables.CSBGTLMT);
     put(LIL,CodesTables.CSAMTLMT);
    };
  };
                  


  /*
   * (non-Javadoc)
   * 
   * @see
   * gov.georgia.dhr.dfcs.sacwis.service.financials.SaveUASProgramCodeMtnt#saveUASProgramCodeMtnt(gov.georgia.dhr.dfcs
   * .sacwis.structs.input.UASProgramCodeMtntSaveSI)
   */
  public UASProgramCodeMtntSaveSO saveUASProgramCodeMtnt(UASProgramCodeMtntSaveSI uasProgramCodeMtntSaveSI)
                                                                                                           throws ServiceException {
    UASProgramCodeMtntSaveSO uasProgramCodeMtntSaveSO = new UASProgramCodeMtntSaveSO();
    String pageState = uasProgramCodeMtntSaveSI.getPageState();
    // STGAP00017672
    uasProgramCodeMtntSaveSO.setNoError(true);
    uasProgramCodeMtntSaveSO.setIndHeaderReuse(uasProgramCodeMtntSaveSI.getIndHeaderReuse());
    boolean isNoError = validateSaveSI(uasProgramCodeMtntSaveSI, uasProgramCodeMtntSaveSO);
    if (!isNoError) {
      List<Map<String,Object>> headerInDBList = uasProgramCodeMtntSaveSO.getHeaderInDBList();
      if (headerInDBList != null && headerInDBList.size() > 0) {
        // header re-use detected
        uasProgramCodeMtntSaveSO.setIndHeaderReuse(ArchitectureConstants.Y);
        return uasProgramCodeMtntSaveSO;
      }
    }
    
    UasProgramCodeMtnt uasProgramCodeMtnt = populateUASProgramCodeMtnt(uasProgramCodeMtntSaveSI);
    int idUasPrgCode = 0; //uasProgramCodeMtntDAO.saveUasProgramCodeMtnt(uasProgramCodeMtnt);
    if (ADD_UAS.equals(pageState)) {
      // New program code, set returning id to SI to use in ENT insert
      // Set returning id back to DB object as precaution for any later use
      idUasPrgCode = uasProgramCodeMtntDAO.saveUasProgramCodeMtnt(uasProgramCodeMtnt);
      uasProgramCodeMtntSaveSI.getPrgCodeDetail().setIdUasPrgCode(idUasPrgCode);
      uasProgramCodeMtnt.setIdUasProgramCodeMtnt(idUasPrgCode);
    }
    // Save ENT - ENT can be updated in any mode
    // If it is ADD_UAS mode, be sure that new prog code is added and the returning id is set back to SI
    List<UasEntCodeMtnt> entCodeMtntList = populateUASEntCodeMtnt(uasProgramCodeMtntSaveSI);
    // insert or delete to SA header table, checking is done inside the method to see should there be 
    // any action, or the type of action needed
    // Insert or update to Equiv. Update entCodeMtntList if new PSSF entered; need to be done before save ENT
    entCodeMtntList = audEquivalency(entCodeMtntList, uasProgramCodeMtnt);
    List<Integer> idEntList = null;
    if (entCodeMtntList != null && entCodeMtntList.size() > 0) {
      idEntList = complexUASEntCodeMtntDAO.saveUasEntCodeMtntList(entCodeMtntList);
    }
    // Save successful, set ENT list to the prog code record to be used in inserting/updating relevant tables
    //uasProgramCodeMtnt.setUasEntCodeMtnts(entCodeMtntList); this line causes save failed. stale object
    // bc the prog record was saved, modified it in mem causing error, must re-retrieve to update its dt last update

    // Updatte audit table, if applicable
    insertAuditTables(pageState, uasProgramCodeMtnt, entCodeMtntList);
    // Update service code to CCI/CPA, mileage, relative care, all modes
    updateSvcCodesTables(uasProgramCodeMtntSaveSI);
    // Moved saving program last b/c there is trigger that changes the code of all others 
    // when program code changes. That causes code subprogams updates fails.
    if (!ADD_UAS.equals(pageState)) { 
      idUasPrgCode = uasProgramCodeMtntDAO.saveUasProgramCodeMtnt(uasProgramCodeMtnt);
    }
    uasProgramCodeMtntSaveSO.setIdUasPrgCode(idUasPrgCode);
    return uasProgramCodeMtntSaveSO;
  }
  
  private void updateSvcCodesTables(UASProgramCodeMtntSaveSI uasProgramCodeMtntSaveSI) {
    // Requires program code and ENT code data so if any of those don't exists, get out.
    if (uasProgramCodeMtntSaveSI == null || uasProgramCodeMtntSaveSI.getPrgCodeDetail() == null) {
      return;
    }
    UASProgramCodeDetail uasProgramCodeDetail = uasProgramCodeMtntSaveSI.getPrgCodeDetail();
    List<UASEntitlementCodeDetail> entRowListToSave = uasProgramCodeDetail.getEntCodeList();
    // Map of action and data list to update per the action
    List<Map<String, List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables>>> audSubProgToSaveMap = new ArrayList<Map<String, List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables>>>();
    
    List<Map<String, List<SvcAuthUasEntCode>>> saHeaderToSaveActionMap = new ArrayList<Map<String, List<SvcAuthUasEntCode>>>();
    Map<String, List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables>> auSubProgMap = new HashMap<String, List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables>>();
    Map<String, List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables>> dSubProgMap = new HashMap<String, List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables>>();
    Map<String, List<SvcAuthUasEntCode>> auSaHeaderMap = new HashMap<String, List<SvcAuthUasEntCode>>();
    Map<String, List<SvcAuthUasEntCode>> dSaHeaderMap = new HashMap<String, List<SvcAuthUasEntCode>>();
    List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> codesTablesAddList = new ArrayList<gov.georgia.dhr.dfcs.sacwis.db.CodesTables>(); 
    List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> codesTablesDeleteList = new ArrayList<gov.georgia.dhr.dfcs.sacwis.db.CodesTables>(); 
    List<SvcAuthUasEntCode> saTableAddList = new ArrayList<SvcAuthUasEntCode>();
    List<SvcAuthUasEntCode> saTableDeleteList = new ArrayList<SvcAuthUasEntCode>();
    
    auSubProgMap.put(ServiceConstants.REQ_FUNC_CD_ADD, codesTablesAddList);
    dSubProgMap.put(ServiceConstants.REQ_FUNC_CD_DELETE, codesTablesDeleteList);
    audSubProgToSaveMap.add(auSubProgMap);
    audSubProgToSaveMap.add(dSubProgMap);
    
    auSaHeaderMap.put(ServiceConstants.REQ_FUNC_CD_ADD, saTableAddList);
    dSaHeaderMap.put(ServiceConstants.REQ_FUNC_CD_DELETE, saTableDeleteList);
    // set SA header action maps to SA to save list (hashmap)
    saHeaderToSaveActionMap.add(auSaHeaderMap);
    saHeaderToSaveActionMap.add(dSaHeaderMap);
    
    for (UASEntitlementCodeDetail entRow : entRowListToSave) {
      audSubProgramForEntRow(uasProgramCodeDetail,entRow, audSubProgToSaveMap, saHeaderToSaveActionMap);
     }
    // Execute the action on the data list
    List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> addList = null;
    List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> deleteList = null;
    // Retrieve all current subprogram codes tables - 
    List<CodesTablesId> codesTablesIdList = codesTablesDAO.findCodesIdsByCodeType(SUB_PROGRAM_CODE_TYPE_LIST);
    for (Map<String, List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables>> actionMap : audSubProgToSaveMap) {
      // Remove from the action list those codes tables entries already exists. This is to prevent integrity
      // constraint violation if data is entered in the backend to the codes tables and bypass the maintenance
      // table. Also to remove duplicate add due to subprogram dependency logic (SA+Header)
      if (actionMap.containsKey(ServiceConstants.REQ_FUNC_CD_ADD)) {
        addList = actionMap.get(ServiceConstants.REQ_FUNC_CD_ADD);
        //complexCodesTablesDAO.saveCodesTablesList(populateCodesTablesToSaveList(addList));
        complexCodesTablesDAO.saveCodesTablesList(removeExistingCodesTables(addList, codesTablesIdList));
      } else if (actionMap.containsKey(ServiceConstants.REQ_FUNC_CD_DELETE)) {
        deleteList = actionMap.get(ServiceConstants.REQ_FUNC_CD_DELETE);
        complexCodesTablesDAO.deleteCodesTablesList(deleteList); 
        //complexCodesTablesDAO.updateCodesTablesList(deleteList);
      } 
    }
    //
    List<String> cdSvcAuthHeaderList = svcAuthUasEntCodeDAO.findSvcAuthHeaderCodes();
    List<SvcAuthUasEntCode> saAddList = null;
    List<SvcAuthUasEntCode> saDeleteList = null;
    for (Map<String, List<SvcAuthUasEntCode>> saActionMap : saHeaderToSaveActionMap) {
      if (saActionMap.containsKey(ServiceConstants.REQ_FUNC_CD_ADD)) {
        saAddList = saActionMap.get(ServiceConstants.REQ_FUNC_CD_ADD);
        complexSvcAuthUasEntCodeDAO.saveSvcAuthUasEntCodeList(removeExistingSaHeaderRows(saAddList, cdSvcAuthHeaderList));
      } else if (saActionMap.containsKey(ServiceConstants.REQ_FUNC_CD_DELETE)) {
        saDeleteList = saActionMap.get(ServiceConstants.REQ_FUNC_CD_DELETE);
        complexSvcAuthUasEntCodeDAO.deleteSvcAuthUasEntCodeList(saDeleteList);
      }
    }
  }
  /**
   * This processes one sub program for insert or delete for a service row. Update is handled by DB triggers.
   * @param action
   * @param cdProgType
   * @param entRow
   * @param audSubProgToSaveMap
   */
  private void audSubProgramForEntRow(UASProgramCodeDetail uasProgramCodeDetail, 
                                      UASEntitlementCodeDetail entRow, 
                                      List<Map<String, List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables>>> audSubProgToSaveMap,
                                      List<Map<String, List<SvcAuthUasEntCode>>> saHeaderToSaveActionMap) {
    gov.georgia.dhr.dfcs.sacwis.db.CodesTables codesTables = new gov.georgia.dhr.dfcs.sacwis.db.CodesTables();
    Map<String, List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables>> auSubProgMap = audSubProgToSaveMap.get(0);
    Map<String, List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables>> dSubProgMap = audSubProgToSaveMap.get(1);
    Map<String, List<SvcAuthUasEntCode>> auSaHeaderMap = saHeaderToSaveActionMap.get(0);
    Map<String, List<SvcAuthUasEntCode>> dSaHeaderMap = saHeaderToSaveActionMap.get(1);
    List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> codesTablesAddList = auSubProgMap.get(ServiceConstants.REQ_FUNC_CD_ADD);
    List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> codesTablesDeleteList = dSubProgMap.get(ServiceConstants.REQ_FUNC_CD_DELETE);
    List<SvcAuthUasEntCode> saAddList = auSaHeaderMap.get(ServiceConstants.REQ_FUNC_CD_ADD);
    List<SvcAuthUasEntCode> saDeleteList = dSaHeaderMap.get(ServiceConstants.REQ_FUNC_CD_DELETE);
    String txtSvcCode = entRow.getCdSvcCode();
    String txtSvcDesc = entRow.getTxtEntDesc();
    double amtCBL = entRow.getAmtCBL();
    double amtLIL = entRow.getAmtLIL();
    // contains the subprogram name and the update action (A,U,D, "") calculated from the Conversation
    Map<String, String> subProgramActionMap = entRow.getCdFuncProgs();
    Set<String> subProgList = subProgramActionMap.keySet();
    String saAction = subProgramActionMap.get(SVC_AUTH);

    for (String cdSubProg : subProgList) {
      String action = subProgramActionMap.get(cdSubProg);
      // All A indicator, only insert to related codes tables if it is actual service code (not a header)
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(action)) {
        if (CCI.equals(cdSubProg) || CPA.equals(cdSubProg)) {
          audCciCpa(cdSubProg, entRow, codesTablesAddList);
        } else if (MILEAGE.equals(cdSubProg) || REL.equals(cdSubProg) || 
                        FC_ADD_ON.equals(cdSubProg) ) {
          codesTables = populateCodesTablesDB(SUB_PROGRAM_CODE_TYPE_LOOKUP.get(cdSubProg), txtSvcCode, txtSvcDesc, null);
          codesTablesAddList.add(codesTables);
        } else if (CBL.equals(cdSubProg))  {
          codesTables = populateCodesTablesDB(SUB_PROGRAM_CODE_TYPE_LOOKUP.get(cdSubProg), txtSvcCode, String.valueOf(amtCBL), null);
          codesTablesAddList.add(codesTables);
        } else if (LIL.equals(cdSubProg))  {
          codesTables = populateCodesTablesDB(SUB_PROGRAM_CODE_TYPE_LOOKUP.get(cdSubProg), txtSvcCode, String.valueOf(amtLIL), null);
          codesTablesAddList.add(codesTables);
        }
      }
      // If subprogram mapping indicates delete action
      else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(action)) {
        if (CCI.equals(cdSubProg) || CPA.equals(cdSubProg)) {
          audCciCpa(cdSubProg, entRow, codesTablesDeleteList);
        } 
        // delete Codes Tables for SA (CPRGCOD1, CENTCODE) handled by TUBR triggers
        else if (MILEAGE.equals(cdSubProg) || REL.equals(cdSubProg) || FC_ADD_ON.equals(cdSubProg)) {
          codesTables = populateCodesTablesDB(SUB_PROGRAM_CODE_TYPE_LOOKUP.get(cdSubProg), txtSvcCode, txtSvcDesc, null);
          codesTablesDeleteList.add(codesTables);
        } else if (CBL.equals(cdSubProg))  {
          codesTables = populateCodesTablesDB(SUB_PROGRAM_CODE_TYPE_LOOKUP.get(cdSubProg), txtSvcCode, String.valueOf(amtCBL), null);
          codesTablesDeleteList.add(codesTables);
        } else if (LIL.equals(cdSubProg))  {
          codesTables = populateCodesTablesDB(SUB_PROGRAM_CODE_TYPE_LOOKUP.get(cdSubProg), txtSvcCode, String.valueOf(amtLIL), null);
          codesTablesDeleteList.add(codesTables);
        } 
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(action)) {
        // not done in app, because if code and decode are modified at the same time, updating the original record is not straightforward
        // meanwhile, DB trigger is better.
      }
    } // done for loop
    // THis is outside of the loop 
    // If the SA header subprogram is changed, additional table is updated: SA header table
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(saAction)) {
      SvcAuthUasEntCode saHeader = new SvcAuthUasEntCode();
      saHeader.setCdEnt(entRow.getCdEntCode());
      saHeader.setCdUas(uasProgramCodeDetail.getCdProgramCode());
      saHeader.setIdSvcAuthUasEntCode(0);
      saAddList.add(saHeader);
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(saAction)) {
      SvcAuthUasEntCode saHeader = new SvcAuthUasEntCode();
      saHeader.setCdEnt(entRow.getCdEntCode());
      saHeader.setCdUas(uasProgramCodeDetail.getCdProgramCode());
      saDeleteList.add(saHeader);
    }
  }
  
  /** 
   * This method inserts, update or deletes from the CCI or CPA codes tables when user selects or unselects the CCi or CPA option.
   * Called by audSubProgram();
   * @param codeType
   * @param entRow
   * @param audList
   */
  private void audCciCpa(String codeType, UASEntitlementCodeDetail entRow, List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> audList) {
    String txtSvcCode = entRow.getCdSvcCode();
    gov.georgia.dhr.dfcs.sacwis.db.CodesTables codesTables = new gov.georgia.dhr.dfcs.sacwis.db.CodesTables();
    if (CCI.equals(codeType)) {
      codesTables = populateCodesTablesDB(CodesTables.CCCISVCD, txtSvcCode, txtSvcCode, null); // decode is the same with code for this code table
      audList.add(codesTables);
      codesTables = populateCodesTablesDB(CodesTables.CCCIUTYP, txtSvcCode, entRow.getCdUnitType(), null); 
      audList.add(codesTables);
      codesTables = populateCodesTablesDB(CodesTables.CCCIPTYP, txtSvcCode, entRow.getCdPymtType(), null); 
      audList.add(codesTables);
      codesTables = populateCodesTablesDB(CodesTables.CCCIUTRT, txtSvcCode, String.valueOf(entRow.getAmtRate()), null); 
      audList.add(codesTables);
    }
    if (CPA.equals(codeType)) {
      codesTables = populateCodesTablesDB(CodesTables.CCPASVCD, txtSvcCode, txtSvcCode, null); // decode is the same with code for this code table
      audList.add(codesTables);
      codesTables = populateCodesTablesDB(CodesTables.CCPAUTYP, txtSvcCode, entRow.getCdUnitType(), null); 
      audList.add(codesTables);
      codesTables = populateCodesTablesDB(CodesTables.CCPAPTYP, txtSvcCode, entRow.getCdPymtType(), null); 
      audList.add(codesTables);
      codesTables = populateCodesTablesDB(CodesTables.CCPAUTRT, txtSvcCode, String.valueOf(entRow.getAmtRate()), null); 
      audList.add(codesTables);
    }
  }
  /**
   * This method populates a Codes Tables DB row for save.
   * @param codeType
   * @param code
   * @param decode
   * @param dtEnd
   * @return
   */
  private gov.georgia.dhr.dfcs.sacwis.db.CodesTables populateCodesTablesDB(String codeType, String code, String decode, Date dtEnd) {
    CodesTablesId id = new CodesTablesId();
    gov.georgia.dhr.dfcs.sacwis.db.CodesTables ct = new gov.georgia.dhr.dfcs.sacwis.db.CodesTables();
    id.setCodeType(codeType);
    id.setCode(code);
    ct.setId(id);
    ct.setDecode(decode); 
    ct.setDtEnd(dtEnd);
    return ct;
  }
  
    /**
   * This method inserts all service codes to the Equivalency table. Different values inserted depend on whether it is PSSF.
   * @param entCodeMtntList
   * @param uasProgramCodeMtnt
   * @return
   */
  private List<UasEntCodeMtnt>  audEquivalency(List<UasEntCodeMtnt> entCodeMtntList, UasProgramCodeMtnt uasProgramCodeMtnt) {
    String cdUas = uasProgramCodeMtnt.getCdUas();
    String cdEquivObjCert = StringHelper.EMPTY_STRING;
    String cdEquivObjPure = StringHelper.EMPTY_STRING;
    Double nbrEquivObjCert = 0.00;
    Double nbrEquivObjPure = 0.00;
    boolean isPSSF = StringHelper.isTrue(uasProgramCodeMtnt.getIndPssf());
    Map<Integer, Integer> entEquivIdMap = new HashMap<Integer, Integer>();
    List<Equivalency> equivToSaveList = new ArrayList<Equivalency>();
    // Applying Patrick's insert script logic
    if (isPSSF) {
      cdEquivObjCert = cdUas + "r";
      cdEquivObjPure = cdUas + "00";
      nbrEquivObjCert = -0.25;
      nbrEquivObjPure = 0.25;
    }
    // Save all Equivalency rows first
    for (UasEntCodeMtnt uasEntCodeMtnt : entCodeMtntList) {
      String cdSvcCode = uasEntCodeMtnt.getCdSvcCode();
      Equivalency eq ;
      if (uasEntCodeMtnt.getEquivalency() != null) {
        eq = uasEntCodeMtnt.getEquivalency();
      } else {
        eq = new Equivalency();
        eq.setIdEquiv(0);
      }
      eq.setCdEquivFundingStream(uasEntCodeMtnt.getCdEntCode());
      eq.setCdEquivObjAlw(cdSvcCode);
      eq.setCdEquivObjCert(cdEquivObjCert);
      eq.setCdEquivObjPure(cdEquivObjPure);
      eq.setCdEquivPac(cdUas);
      eq.setCdEquivStage("ALL");
      eq.setCdEquivStageType("ALL");
      eq.setCdEquivSvcDtlService(cdSvcCode);
      eq.setDtEquivEndDate(DateHelper.MAX_JAVA_DATE);
      eq.setDtEquivStartDate(uasEntCodeMtnt.getDtEffective());
      eq.setNbrEquivObjAlw(1.00);
      eq.setNbrEquivObjCert(nbrEquivObjCert);
      eq.setNbrEquivObjPure(nbrEquivObjPure);
      equivToSaveList.add(eq);
    }
    HashMap<String,Integer> eqIdCdSvcList = complexEquivalencyDAO.saveEquivalencyList(equivToSaveList);
    // If equivalency saves successful, retrieve the mapping svc code and idequiv
    if (eqIdCdSvcList != null) {
      // Set id equiv on each uas ent mtnt row for save ent row next
      for (UasEntCodeMtnt uasEntCodeMtnt : entCodeMtntList) {
        // Add mode (new program) or existing program prior to this page development
        if (uasEntCodeMtnt.getEquivalency() == null) {
          int idEquiv = eqIdCdSvcList.get(uasEntCodeMtnt.getCdSvcCode());
          Equivalency eq = (Equivalency)getPersistentObject(Equivalency.class, idEquiv);
          uasEntCodeMtnt.setEquivalency(eq);
        }
      }
    }
    return entCodeMtntList;
  }

  /**
   * This method inserts the new prog code and ENT rows to the audit table. 
   * @param pageState
   * @param uasProgramCodeMtnt
   * @param entCodeMtntList
   */
  private void insertAuditTables(String pageState, UasProgramCodeMtnt uasProgramCodeMtnt, List<UasEntCodeMtnt> entCodeMtntList ) {
    // only add to audit table when existing program code row is being updated. - OBSOLETE
    if (UPDATE.equals(pageState) || ADD_UAS.equals(pageState) || ADD_ENT.equals(pageState)) {// INSERT TO AUDIT FOR ALL STATES
      UasPrgCodeMtntAudit audit = populateProgramCodeAudit(pageState, uasProgramCodeMtnt);
      uasPrgCodeMtntAuditDAO.saveUasPrgCodeMtntAudit(audit);
      List<UasEntCodeMtntAudit> entAuditList = populateEntCodeAudit(pageState, audit.getIdUasPrgCodeMtntAudit(),
                                                                    entCodeMtntList);
      complexUASEntCodeMtntAuditDAO.saveUasEntCodeMtntAuditList(entAuditList);
    }
  }

  /**
   * This method populates the ENT audit row for save.
   * @param pageState
   * @param idUasPrgCodeMtntAudit
   * @param entList
   * @return
   */
  private List<UasEntCodeMtntAudit> populateEntCodeAudit(String pageState, int idUasPrgCodeMtntAudit,
                                                         List<UasEntCodeMtnt> entList) {
    String cdAction = "";
    List<UasEntCodeMtntAudit> entAuditList = new ArrayList<UasEntCodeMtntAudit>();
    // Currently only update is recorded - OBSOLETE
    if (UPDATE.equals(pageState)) {
      cdAction = ServiceConstants.REQ_FUNC_CD_UPDATE;
    } else if (ADD_UAS.equals(pageState) || ADD_ENT.equals(pageState)){ // INSERT TO AUDIT ENT AS ADD WHEN ADDING NEW PRG TOO
      cdAction = ServiceConstants.REQ_FUNC_CD_ADD;
    }
    //    if (UPDATE.equals(pageState)) {
      for (UasEntCodeMtnt uasEntCodeMtnt : entList) {
        UasEntCodeMtntAudit entAudit = new UasEntCodeMtntAudit();
        entAudit.setAmtCaseBudgetLimit(uasEntCodeMtnt.getAmtCaseBudgetLimit());
        entAudit.setAmtLineItemLimit(uasEntCodeMtnt.getAmtLineItemLimit());
        entAudit.setAmtUnitRate(uasEntCodeMtnt.getAmtUnitRate());
        entAudit.setCdAlpha(uasEntCodeMtnt.getCdAlpha());
        entAudit.setCdEntCode(uasEntCodeMtnt.getCdEntCode());
        entAudit.setCdPaymentType(uasEntCodeMtnt.getCdPaymentType());
        entAudit.setCdUnitType(uasEntCodeMtnt.getCdUnitType());
        entAudit.setCdUpdateAction(cdAction);
        entAudit.setDtEffective(uasEntCodeMtnt.getDtEffective());
        entAudit.setIdUasEntCodeMtnt(uasEntCodeMtnt.getIdUasEntCodeMtnt());
        entAudit.setIdUasEntCodeMtntAudit(0);
        entAudit.setIndEntHeader(uasEntCodeMtnt.getIndEntHeader());
        entAudit.setIndMileage(uasEntCodeMtnt.getIndMileage());
        entAudit.setTxtEntDesc(uasEntCodeMtnt.getTxtEntDesc());
        entAudit.setUasPrgCodeMtntAudit((UasPrgCodeMtntAudit)getPersistentObject(UasPrgCodeMtntAudit.class,idUasPrgCodeMtntAudit));
        entAuditList.add(entAudit);
      }
//    }
    return entAuditList;
  }

  /**
   * This method populates the ENT audit row for save. Called by insertAuditTables().
   * @param pageState
   * @param uasProgramCodeMtnt
   * @return
   */
  private UasPrgCodeMtntAudit populateProgramCodeAudit(String pageState, UasProgramCodeMtnt uasProgramCodeMtnt) {
    UasPrgCodeMtntAudit audit = new UasPrgCodeMtntAudit();
    String cdAction = "";
    if (UPDATE.equals(pageState) || ADD_ENT.equals(pageState)) { // INSERT TO PRG AUDIT AS UPDATE WHEN EDD_ENT TOO
      cdAction = ServiceConstants.REQ_FUNC_CD_UPDATE;
    } else if (ADD_UAS.equals(pageState)) {
      cdAction = ServiceConstants.REQ_FUNC_CD_ADD;
    }

    // Currently only update is recorded
/*    if (UPDATE.equals(pageState)) {
      cdAction = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }
*/    if (uasProgramCodeMtnt != null && StringHelper.isValid(cdAction)) {
      audit.setCdProgramType(uasProgramCodeMtnt.getCdProgramType());
      audit.setCdUas(uasProgramCodeMtnt.getCdUas());
      audit.setCdUpdateAction(cdAction);
      audit.setDtEffective(uasProgramCodeMtnt.getDtEffective());
      audit.setIdUasPrgCodeMtntAudit(0);
      audit.setIdUasProgramCodeMtnt(uasProgramCodeMtnt.getIdUasProgramCodeMtnt());
      audit.setIndCci(uasProgramCodeMtnt.getIndCci());
      audit.setIndCpa(uasProgramCodeMtnt.getIndCpa());
      audit.setIndInvAddon(uasProgramCodeMtnt.getIndInvAddon());
      audit.setIndPssf(uasProgramCodeMtnt.getIndPssf());
      audit.setIndServAuth(uasProgramCodeMtnt.getIndServAuth());
      //audit.setPersonUpdate(uasProgramCodeMtnt.getPersonLastUpdate());
      audit.setPersonUpdate((Person)getPersistentObject(Person.class, uasProgramCodeMtnt.getPersonLastUpdate().getIdPerson()));
      audit.setTxtProgramDesc(uasProgramCodeMtnt.getTxtProgramDesc());
    }
    return audit;
  }
  /**
   * This method validates the following:
   * 1. Duplicate program and entitlement code inserts on save.
   * 2. The line item limit is within the case budget limit, if exists.
   * @param uasProgramCodeMtntSaveSI
   * @return
   */
  private boolean validateSaveSI(UASProgramCodeMtntSaveSI uasProgramCodeMtntSaveSI, UASProgramCodeMtntSaveSO uasProgramCodeMtntSaveSO) {
    
    String pageState = uasProgramCodeMtntSaveSI.getPageState();
    UASProgramCodeDetail uasProgramCodeDetail = uasProgramCodeMtntSaveSI.getPrgCodeDetail();
    // should never be null on Save
    if (uasProgramCodeDetail == null) {
      // probably state data is corrupted due to connectivity; 
      // throw this so that user would try to re-enter the page and resolve connectivity issue
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
    int idUas = uasProgramCodeDetail.getIdUasPrgCode();
    String cdUas = uasProgramCodeDetail.getCdProgramCode();    
    List<UASEntitlementCodeDetail> entCodeListToSave = uasProgramCodeMtntSaveSI.getPrgCodeDetail().getEntCodeList();
    // duplicate in prog code mtnt: same prog code but different id
    Integer idUasProgramCodeMtnt = uasProgramCodeMtntDAO.findIdUasProgramCodeMtntByCdUas(cdUas);
    // this is new program mtnt code, look up the global program code codes tables to see if the 
    // attempted save code already in DB
    if (ADD_UAS.equals(pageState) || UPDATE.equals(pageState)) {
      if (idUasProgramCodeMtnt == null) {
        // If user adds a program code that is already in the code tables or
        // modifying one into one already exists
        Map codeTableMap = codesTablesDAO.findCodesTableDetail(UAS_PROG_CODE_TYPE, cdUas);
        if (codeTableMap != null && codeTableMap.get("code").equals(cdUas)) {
          throw new ServiceException(Messages.MSG_EXSTNG_PRG_CD);
        }
      } 
      // if the code exists in the mtmt table but not itself, as user can modify the code
      else if (idUas != idUasProgramCodeMtnt.intValue()) {
        throw new ServiceException(Messages.MSG_EXSTNG_PRG_CD);
      }
    }
    // call validation on ENT code, all modes
    if (entCodeListToSave != null && entCodeListToSave.size() > 0) {
      // STGAP00017672: validate all headers against existing pool at once
      validateEntHeader(entCodeListToSave, uasProgramCodeMtntSaveSO, pageState);
      if (uasProgramCodeMtntSaveSO.isNoError()) {
        validateEnt(entCodeListToSave, idUas, uasProgramCodeMtntSaveSO);
      } 
    }
    return uasProgramCodeMtntSaveSO.isNoError();
  }
  /**
   * This method is called from populateSaveSI to flag headers that already exist in the system.
   * It set error flag and header ent info, which is used in message display, to SaveSO. If the error 
   * is overridden, it will use the existing header description in place of user-entered.
   * @param entCodeListToSave
   * @param uasProgramCodeMtntSaveSO
   */
  private void validateEntHeader(List<UASEntitlementCodeDetail> entCodeListToSave, UASProgramCodeMtntSaveSO uasProgramCodeMtntSaveSO, String pageState) {
    // should never be null/empty at this point
    if (entCodeListToSave == null || entCodeListToSave.size() == 0) {
      // probably state data is corrupted due to connectivity; 
      // throw this so that user would try to re-enter the page and resolve connectivity issue
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
    List<Map<String, Object>> headerInDBList = new ArrayList<Map<String, Object>>();
    for (UASEntitlementCodeDetail entCodeDetail : entCodeListToSave) {
      // STGAP00017672 if this is marked header then also need to check whether the header already defined
      String indEntHeader = entCodeDetail.getIndHeader();
      String cdEntHeader = entCodeDetail.getCdEntCode();
      int idEntCodeDetail = entCodeDetail.getIdEntRow();
      if (ArchitectureConstants.Y.equals(indEntHeader)) { 
        // in update mode, only re-validate header against the existing pool if the code has been modified or header status changed
        if (UPDATE.equals(pageState)) {
          Map entRowDB = uasEntCodeMtntDAO.findEntDetailByIdEnt(idEntCodeDetail);
          String cdEntRowDB = (String) entRowDB.get("cdEntCode");
          String indEntHeaderRowDB = (String) entRowDB.get("indEntHeader");
          if (cdEntHeader.equalsIgnoreCase(cdEntRowDB) && indEntHeader.equals(indEntHeaderRowDB)) {
            continue;
          }
        }
        Map centcodeCodes = null;
        String headerDBDesc = null;
        // frequency is low, only 10 new ent rows, 6 users, so ok for now, as this is a design change at last minute.
        centcodeCodes = codesTablesDAO.findCodesTableDetailByCodeTypeCodeIgnoreCase(SUB_PROGRAM_CODE_TYPE_LOOKUP.get(HEADER), cdEntHeader);
        if (centcodeCodes != null) {
          headerDBDesc = (String)centcodeCodes.get("decode");
        }
        // Header already defined
        if (StringHelper.isValid(headerDBDesc)) {
          // user confirmed using existing header
          if (ArchitectureConstants.Y.equals(uasProgramCodeMtntSaveSO.getIndHeaderReuse())) {
            // use the existing header desc
            entCodeDetail.setTxtEntDesc(headerDBDesc);
          } else {
            uasProgramCodeMtntSaveSO.setNoError(false);
            List<String> cdProgramList = uasEntCodeMtntDAO.findCdUasByCdEntCodeHeader(cdEntHeader);
            if (cdProgramList == null || cdProgramList.size() == 0) {
              cdProgramList = svcAuthUasEntCodeDAO.findCdUasByCdEnt(cdEntHeader);
            }
            Map<String, Object> headerInfo = new HashMap<String, Object>();
            headerInfo.put("headerEntCode", cdEntHeader);
            headerInfo.put("headerDesc", headerDBDesc);
            headerInfo.put("headerProgs", cdProgramList);
            headerInDBList.add(headerInfo) ;            
          }
        }
      }
    }
    uasProgramCodeMtntSaveSO.setHeaderInDBList(headerInDBList);
  }
  
  /**
   * Called by validateSaveSI(). This method validate duplicate entitlement code 
   * and line item limit exceeding case budget limit. 
   * @param entCodeListToSave
   * @param idUas
   */
  private void validateEnt(List<UASEntitlementCodeDetail> entCodeListToSave, int idUas, UASProgramCodeMtntSaveSO uasProgramCodeMtntSaveSO) {
    // should never be null/empty at this point
    if (entCodeListToSave == null || entCodeListToSave.size() == 0) {
      // probably state data is corrupted due to connectivity; 
      // throw this so that user would try to re-enter the page and resolve connectivity issue
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
    List<String> svcCodeUpperList = codesTablesDAO.findCodesUpperCaseList(UAS_SVC_CODE_TYPE);
    // This DAO also uppers the values returned
    List<Map<String, Object>> svcCodeMtntUpperList = uasEntCodeMtntDAO.findCdSvcCodeByIdProgram(idUas);
    
    Map<String, Integer> svcCodeMtntUpperHash = toHashMap(svcCodeMtntUpperList, "svcCode", "idEnt");
    
    for (UASEntitlementCodeDetail entCodeDetail : entCodeListToSave) {
      int idEntCodeDetail = entCodeDetail.getIdEntRow();
      // ENT code is NOT considered case sensitive by app so upper input to compare with DB
      // The DB value returned was also uppered.
      String svcCode = entCodeDetail.getCdSvcCode();
      List<UASEntitlementCodeDetail> entReqList = findEntCodeDetailBySvcCodeIgnoreCase(entCodeListToSave, svcCode);
      // To not counting itself, if more than one row found, it is duplicate
      if (entReqList != null && entReqList.size() > 1) {
        throw new ServiceException(Messages.MSG_EXSTNG_ENT_CD);
      }
      // find duplicates in the ent mtnt DB list: same svc code but different id
      if (svcCodeMtntUpperHash.containsKey(svcCode.toUpperCase()) ) {
        if (svcCodeMtntUpperHash.get(svcCode.toUpperCase()) !=  idEntCodeDetail) {
          throw new ServiceException(Messages.MSG_EXSTNG_ENT_CD);
        }
      } 
      // the code is new to the mtnt tables so only if it is a new svc code then allowed.
      // one occurrence means duplicate because the page currently is not designed to make existing code into maintainable code
      else if (svcCodeUpperList.contains(svcCode.toUpperCase())) {
        throw new ServiceException(Messages.MSG_EXSTNG_ENT_CD);
      } 
      // STGAP00017672 if this is marked header then also need to check whether the header already defined
/*      String indEntHeader = entCodeDetail.getIndHeader();
      if (ArchitectureConstants.Y.equals(indEntHeader)) {         
        String headerDBDesc = Lookup.simpleDecodeSafe(SUB_PROGRAM_CODE_TYPE_LOOKUP.get(HEADER), entCodeDetail.getCdEntCode());
        // Header already defined
        if (StringHelper.isValid(headerDBDesc)) {
          //throw new ServiceException(Messages.MSG_PREVENT_ADD_RECORDS_CHECK);
          // user confirmed using existing header
          if (ArchitectureConstants.Y.equals(uasProgramCodeMtntSaveSO.getIndHeaderReuse())) {
            // use the existing header desc
            entCodeDetail.setTxtEntDesc(headerDBDesc);
          } else {
            uasProgramCodeMtntSaveSO.setNoError(false);
            List<Map<String, String>> headerInDBList = new ArrayList<Map<String, String>>();
            headerInDBList.add(new HashMap<String, String>() {
              {
                put("headerDesc", "header desc");
                put("headerProgs", "header programs");
              }
            });
            uasProgramCodeMtntSaveSO.setHeaderInDBList(headerInDBList);
            return;            
          }
        }
      }
*/      
      // validate case budget and line item limit
      double amtLIL = entCodeDetail.getAmtLIL();
      double amtCBLHeader = 0.00;
      if (amtLIL > 0.00) {
        // the first 3 characters of svc code is the 3 digit uas program code. A header row code consists of 
        // the uas program code and ent code
        String header = entCodeDetail.getCdSvcCode().substring(0, 3) + entCodeDetail.getCdEntCode();
        // Look into the request data to find the header row; if not found, look into DB
        // If we get to this point w/o exception, there should be only one header record on the list.
        List<UASEntitlementCodeDetail> entHeaderList = findEntCodeHeaderBySvcCode(entCodeListToSave, header);
        UASEntitlementCodeDetail entHeader = entHeaderList == null ? null : entHeaderList.get(0);
        if (entHeader != null && ArchitectureConstants.Y.equals(entHeader.getIndHeader())) {
          amtCBLHeader = entHeader.getAmtCBL();
        } else {
          Double headerCBL = uasEntCodeMtntDAO.findCaseBudgetLimitByHeader(header);
          if (headerCBL != null) {
            amtCBLHeader = headerCBL.doubleValue();
          }
        }
        // STGAP00017322: line item limit cannot exceed case budget limit, if exists.
        if (amtCBLHeader > 0.00 && amtCBLHeader < amtLIL) {
          throw new ServiceException(Messages.MSG_BDGT_LIM_EXCDD);
        }
      }
    }
  }
  /**
   * This method populates UASProgramCodeMtnt row for save.
   * @param uasProgramCodeMtntSaveSI
   * @return
   */
  private UasProgramCodeMtnt populateUASProgramCodeMtnt(UASProgramCodeMtntSaveSI uasProgramCodeMtntSaveSI) {
    UasProgramCodeMtnt uasProgramCodeMtnt = new UasProgramCodeMtnt();
    UASProgramCodeDetail uasProgramCodeDetail = null;

    if (uasProgramCodeMtntSaveSI == null || uasProgramCodeMtntSaveSI.getPrgCodeDetail() == null) {
      return null;
    } else {
      uasProgramCodeDetail = uasProgramCodeMtntSaveSI.getPrgCodeDetail();
      if (uasProgramCodeDetail != null) {
        uasProgramCodeMtnt.setIdUasProgramCodeMtnt(uasProgramCodeDetail.getIdUasPrgCode());
        uasProgramCodeMtnt.setCdUas(uasProgramCodeDetail.getCdProgramCode());
        uasProgramCodeMtnt.setCdProgramType(uasProgramCodeDetail.getCdProgramType());
        uasProgramCodeMtnt.setDtEffective(uasProgramCodeDetail.getDtProgramEffective());
        uasProgramCodeMtnt.setPersonLastUpdate((Person) getPersistentObject(Person.class,
                                                                            uasProgramCodeDetail.getIdPersonLastUpdate()));
        uasProgramCodeMtnt.setTxtProgramDesc(uasProgramCodeDetail.getTxtProgramDesc());
        uasProgramCodeMtnt.setIndCci(uasProgramCodeDetail.getIndCCI());
        uasProgramCodeMtnt.setIndCpa(uasProgramCodeDetail.getIndCPA());
        uasProgramCodeMtnt.setIndInvAddon(uasProgramCodeDetail.getIndInvAddOn());
        uasProgramCodeMtnt.setIndServAuth(uasProgramCodeDetail.getIndServiceAuth());
        uasProgramCodeMtnt.setIndPssf(uasProgramCodeDetail.getIndPSSF());
        uasProgramCodeMtnt.setDtLastUpdate(uasProgramCodeDetail.getDtLastUpdatedBy());
      }
    }
    return uasProgramCodeMtnt;
  }

  /**
   * This method populates UASEntCodeMtnt row for save.
   * @param uasProgramCodeMtntSaveSI
   * @return null if invalid call; otherwise list<UasEntCodeMtnt>
   */
  private List<UasEntCodeMtnt> populateUASEntCodeMtnt(UASProgramCodeMtntSaveSI uasProgramCodeMtntSaveSI) {
    List<UasEntCodeMtnt> entCodeMtntListToSave = null;
    if (uasProgramCodeMtntSaveSI == null || uasProgramCodeMtntSaveSI.getPrgCodeDetail() == null
        || uasProgramCodeMtntSaveSI.getPrgCodeDetail().getEntCodeList() == null) {
      return null;
    } else {
      List<UASEntitlementCodeDetail> entCodeList = uasProgramCodeMtntSaveSI.getPrgCodeDetail().getEntCodeList();
      entCodeMtntListToSave = new ArrayList<UasEntCodeMtnt>();
      // id program is the same for every entRow
      int idProgCode = uasProgramCodeMtntSaveSI.getPrgCodeDetail().getIdUasPrgCode();
      for (UASEntitlementCodeDetail entRow : entCodeList) {
        UasEntCodeMtnt uasEntCodeMtnt = new UasEntCodeMtnt();
        uasEntCodeMtnt.setIdUasEntCodeMtnt(entRow.getIdEntRow());
        uasEntCodeMtnt.setUasProgramCodeMtnt((UasProgramCodeMtnt) getPersistentObject(UasProgramCodeMtnt.class,
                                                                                      idProgCode));
        uasEntCodeMtnt.setDtLastUpdate(entRow.getDtLastUpdate());
        uasEntCodeMtnt.setDtEffective(entRow.getDtEntEff());
        uasEntCodeMtnt.setCdAlpha(entRow.getTxtEntAlpha());
        uasEntCodeMtnt.setCdEntCode(entRow.getCdEntCode());
        uasEntCodeMtnt.setTxtEntDesc(entRow.getTxtEntDesc());
        uasEntCodeMtnt.setAmtCaseBudgetLimit(entRow.getAmtCBL());
        uasEntCodeMtnt.setAmtLineItemLimit(entRow.getAmtLIL());
        uasEntCodeMtnt.setAmtUnitRate(entRow.getAmtRate());
        uasEntCodeMtnt.setCdPaymentType(entRow.getCdPymtType());
        uasEntCodeMtnt.setCdUnitType(entRow.getCdUnitType());
        uasEntCodeMtnt.setIndEntHeader(entRow.getIndHeader());
        uasEntCodeMtnt.setIndMileage(entRow.getIndMileage());
        uasEntCodeMtnt.setCdSvcCode(entRow.getCdSvcCode());
        if (entRow.getIdEquiv() > 0) {
          uasEntCodeMtnt.setEquivalency((Equivalency)getPersistentObject(Equivalency.class, entRow.getIdEquiv()));
        }

        entCodeMtntListToSave.add(uasEntCodeMtnt);
      }
    }
    return entCodeMtntListToSave;
  }
  
  /**
   * This is the helper method to convert a row-oriented DB retrieved structure to a column-oriented one 
   * for internal processing. The input list stores 2 columns retrieved from the DB in the format: 
   * {col1, col1Value}
   * {col2, col2Value} 
   * Converted into this format: 
   * {col1Value, col2Value}
   * Example:
   * {"id", 123}
   * {"name", "Smith"}
   * -->
   * {123, Smith}
   * @param mapList
   * @param nmKey
   * @param nmValue
   * @return
   */
  private Map<String, Integer> toHashMap(List<Map<String, Object>> mapList, String nmKey, String nmValue) {
    Map<String, Integer> mapHash = new HashMap<String,Integer>();
    for (Map<String, Object> map : mapList) {
      mapHash.put((String)map.get(nmKey), (Integer)map.get(nmValue));
    }
    return mapHash;

  }
  
  /**
   * Helper method to remove existing record in data list before action executed, to reduce unnecessary processing.
   * @param saList
   * @param headerList
   */
  private List<SvcAuthUasEntCode> removeExistingSaHeaderRows(List<SvcAuthUasEntCode> saList, List<String> headerList) {
    List<SvcAuthUasEntCode> newSaList = new ArrayList<SvcAuthUasEntCode>();
    if (saList == null || headerList == null)
      return newSaList;
    for (SvcAuthUasEntCode sa : saList) {
      String header = sa.getCdUas() + sa.getCdEnt();
      if (!headerList.contains(header)) {
        newSaList.add(sa);
        headerList.add(header); // to avoid adding duplicate when adding new header row and line item row 
      }
    }
    return newSaList;
  }
  /**
   * Helper method to remove existing record in data list before action executed, to reduce unnecessary processing.
   * @param ctList
   * @param idList
   */
  private List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> removeExistingCodesTables(List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> ctList, List<CodesTablesId> idDBList) {
    if (ctList == null || idDBList == null)
      return null; 
    for (Iterator<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> ctItr = ctList.iterator(); ctItr.hasNext();) {
      gov.georgia.dhr.dfcs.sacwis.db.CodesTables ct = ctItr.next();
      for (CodesTablesId idDB : idDBList) {
        // CodesTables.java is not case-sensitive, until we figure something out, consider Aa, aa, aA...duplicate
        if (ct.getId().getCodeType().equalsIgnoreCase(idDB.getCodeType()) &&  ct.getId().getCode().equalsIgnoreCase(idDB.getCode())) {
          ctItr.remove();
        }
      }
    }
    return ctList;
  }
  //  - if existing ct not found: insert; found in DB with enddate them remove end date; else do nothing 
  private List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> populateCodesTablesToSaveList(List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> ctList) {
    if (ctList == null || ctList.size() == 0)
      return null; 
    List<CodesTablesId> ctIdList = new ArrayList<CodesTablesId>();
    for (gov.georgia.dhr.dfcs.sacwis.db.CodesTables ctToSave : ctList) {
      ctIdList.add(ctToSave.getId());
    }
    List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> ctDBList = complexCodesTablesDAO.findCodesTablesByIdList(ctIdList);
    List<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> ctListNew = new ArrayList<gov.georgia.dhr.dfcs.sacwis.db.CodesTables>();
    
    //for (Iterator<gov.georgia.dhr.dfcs.sacwis.db.CodesTables> ctDBItr = ctDBList.iterator(); ctDBItr.hasNext();) {
      //gov.georgia.dhr.dfcs.sacwis.db.CodesTables ctDB = ctDBItr.next();
    for (gov.georgia.dhr.dfcs.sacwis.db.CodesTables ctDB: ctDBList) {
      for (gov.georgia.dhr.dfcs.sacwis.db.CodesTables ct: ctList) {
        // CodesTables.java is not case-sensitive, until we figure something out, consider Aa, aa, aA...duplicate
        if (ct.getId().getCodeType().equalsIgnoreCase(ctDB.getId().getCodeType()) &&  ct.getId().getCode().equalsIgnoreCase(ctDB.getId().getCode())) {
          // re-active the code for this subprogram
          if (!DateHelper.isNull(ctDB.getDtEnd())) {
            ctDB.setDtEnd(null);
          }
        } else {
          ctListNew.add(ct);
        }
      }
    }
    if (ctListNew.size() > 0) {
      ctDBList.addAll(ctListNew);
    }
    return ctDBList;
  }
  /**
   * Helper method to find code detail row from request by service code string. This method is used
   * to validate duplicate entitlement code and line item exceeding case budget amount. Duplicates are 
   * not case sensitive.
   * @param entList
   * @param svcCode
   * @return null if svcCode is not found in the list.
   */
  private List<UASEntitlementCodeDetail> findEntCodeDetailBySvcCodeIgnoreCase(List<UASEntitlementCodeDetail> entList, String svcCode) {
    if (entList == null || entList.size() == 0 || svcCode == null)
      return null;
    List<UASEntitlementCodeDetail> dupList = new ArrayList<UASEntitlementCodeDetail>();
    for (UASEntitlementCodeDetail ent : entList) {
      if (svcCode.equalsIgnoreCase(ent.getCdSvcCode())) {
        UASEntitlementCodeDetail dupEnt = new UASEntitlementCodeDetail();
        dupEnt.setAmtCBL(ent.getAmtCBL());
        dupEnt.setCdSvcCode(ent.getCdSvcCode());
        dupEnt.setIdEntRow(ent.getIdEntRow());
        dupList.add(dupEnt);
      }
    }
    if (dupList.size() == 0) 
      return null;
    return dupList;
  }
  /**
   * Helper method to find code header row from request by header service code string. This method is used
   * to validate duplicate entilement code and line item exceeding case budget amount. Duplicates are 
   * not case sensitive.
   * @param entList
   * @param svcCode
   * @return null if svcCode is not found in the list.
   */
  private List<UASEntitlementCodeDetail> findEntCodeHeaderBySvcCode(List<UASEntitlementCodeDetail> entList, String headerSvcCode) {
    if (entList == null || entList.size() == 0 || headerSvcCode == null)
      return null;
    List<UASEntitlementCodeDetail> dupList = new ArrayList<UASEntitlementCodeDetail>();
    for (UASEntitlementCodeDetail ent : entList) {
      if (ArchitectureConstants.Y.equals(ent.getIndHeader())) {
        // a header consist of 3-digit program code, plus 1-2 character ENT code, and indicated (checked) as header
        String entHeader = ent.getCdSvcCode().substring(0, 3) + ent.getCdEntCode();
        if (headerSvcCode.equalsIgnoreCase(entHeader)) {
          dupList.add(ent);
        }
      }
    }
    if (dupList.size() == 0) 
      return null;
    return dupList;
  }
  
  private String containsIgnoreCase(Collection<String> codeList, String code) {
    if (codeList == null || codeList.size() == 0 || code == null)
      return null;
    for (String aCode : codeList) {
      if (aCode.equalsIgnoreCase(code)) {
        return aCode;
      }
    }
    return StringHelper.EMPTY_STRING;
  }

}
