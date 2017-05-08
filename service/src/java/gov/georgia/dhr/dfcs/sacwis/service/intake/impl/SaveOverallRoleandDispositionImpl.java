package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FacilityInvstDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LicensingInvstDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.SaveOverallRoleandDisposition;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV45SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV45SO;
/**
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  09/04/08  VVO       STGAP00009662 - fixed NPE: iterate listVictimPerps instead of listNewVictimPerps   
 *                      in the nested for loop in step 3 of method calcVictimPerpRole()
 *  09/11/08  VVO       STGAP00009865 - fixed next() and previous() being improperly called in the same loop causing infinite loop.
 *                      replaced previous() with temporary object to hold previous data.
 * </pre>
 */
public class SaveOverallRoleandDispositionImpl extends BaseServiceImpl implements SaveOverallRoleandDisposition {

  private AllegationDAO allegationDAO = null;

  private CpsInvstDetailDAO cpsInvstDetailDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private static final String MAP_CD_STAGE_PERS_ROLE = "cdStagePersRole";

  private static final String MAP_ID_PERSON = "idPerson";

  private static final String MAP_DT_LAST_UPDATE = "dtLastUpdate";

  private static final String MAP_ID_VICTIM = "idVictim";

  private static final String MAP_ID_PERP = "idPerp";

  private static final String MAP_CD_ALLEG_DISP_VICTIM = "cdAllegDispVictim";

  private static final String MAP_CD_ALLEG_DISP_PERP = "cdAllegDispPerp";

  /*
   * 
   * private static final char SW_CASE_MERGED_IN_ERROR = 'Z'; private static final char SW_REASON_TO_BELIEVE = 'B';
   * private static final char SW_UNABLE_TO_DETRMN_DISP = 'D'; private static final char SW_FAMILY_MOVED = 'V'; private
   * static final char SW_UNABLE_TO_COMPLETE = 'C'; private static final char SW_RULED_OUT = 'O'; private static final
   * char SW_ADMIN_CLOSURE = 'M';
   */
  private static final char SW_SUBSTANTIATED = 'B';

  private static final char SW_UNSUBSTANTIATED = 'S';

  private static final char SW_UNABLE_TO_DETRMN_DISP = 'D';

  // offsets into Object[] returned by AllegationDAO.findAllegationByIdVictimAndIdAllegPerp
  private static final int OFFSET_idVictim = 0;

  private static final int OFFSET_idPerp = 1;

  private static final int OFFSET_cdAllegDispVictim = 2;

  private static final int OFFSET_cdAllegDispPerp = 3;

  // missing from CodesTables.CROLEALL
  public static final String ALLEGED_VICTIM = "AV";

  private static final Map<String, String> CPS_PERP_ROLES_MAP = Collections
                                                                           .unmodifiableMap(new HashMap<String, String>() {
                                                                             {
                                                                               // NEW MAPPING
                                                                               put(CodesTables.CDISPSTN_SUB,
                                                                                   CodesTables.CROLEALL_AP); // SUBSTANTIATED
                                                                               // ->
                                                                               // ALLEGED_PERP
                                                                               put(CodesTables.CDISPSTN_UNS,
                                                                                   CodesTables.CROLEALL_NO); // UNSUBSTANTIATED
                                                                               // ->
                                                                               // NO_ROLE
                                                                               put(CodesTables.CDISPSTN_UTD,
                                                                                   CodesTables.CROLEALL_UD); // UNABLE_TO_DETRMN_DISP
                                                                               // ->
                                                                               // UNABLE_TO_DETRMN_ROLE
                                                                             }
                                                                           });

  private static final Map<String, String> CPS_ROLES_MAP = Collections.unmodifiableMap(new HashMap<String, String>() {
    {
      // new Mapping
      put(CodesTables.CDISPSTN_SUB, CodesTables.CROLEALL_DV); // SUBSTANTIATED -> DESIGNATED_VICTIM
      put(CodesTables.CDISPSTN_UNS, CodesTables.CROLEALL_NO); // UNSUBSTANTIATED -> NO_ROLE
      put(CodesTables.CDISPSTN_UTD, CodesTables.CROLEALL_UD); // UNABLE_TO_DETRMN_DISP -> UNABLE_TO_DETRMN_ROLE
    }
  });

  // Search for these roles in this order in the input set; return same except for UM which returns UC
  // DESIGNATED_BOTH
  // DESIGNATED_PERP
  // DESIGNATED_VICTIM
  // VICTIM_PERP
  // VICTIM
  // CLIENT
  // ALLEGED_PERP
  // ALLEGED_VICTIM
  // UNABLE_TO_DETRMN_ROLE
  // UNKNOWN_OR_MOVED ===> UNKNOWN_OR_UTC
  // UNKNOWN_OR_UTC
  // UNKNOWN
  // NO_ROLE

  private static String[] OVERALL_ROLES_LIST = { CodesTables.CROLEALL_DB, CodesTables.CROLEALL_DP,
                                                CodesTables.CROLEALL_DV, CodesTables.CROLEALL_VP,
                                                CodesTables.CROLEALL_VC, CodesTables.CROLEALL_CL,
                                                CodesTables.CROLEALL_AP, ALLEGED_VICTIM, CodesTables.CROLEALL_UD,
                                                CodesTables.CROLEALL_UM, CodesTables.CROLEALL_UC,
                                                CodesTables.CROLEALL_UK, CodesTables.CROLEALL_NO };

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  /**
   * This is cinv45s
   * 
   * @param cinv45si
   * @return A populated {@link CINV45SO} object.
   * @throws ServiceException
   */
  public CINV45SO saveRoleDisp(CINV45SI cinv45si) throws ServiceException {
    CINV45SO cinv45so = new CINV45SO();
    int idStage = cinv45si.getUlIdStage();
    if (cinv45si.getLdIdTodo() != 0) {
      idStage = cinv45si.getLdIdTodo();
    }
    String reqFuncCd = cinv45si.getArchInputStruct().getCReqFuncCd();
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cinv45si.getSzCdTask());
    ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
    ccmn06ui_archInputStruct.setCReqFuncCd(reqFuncCd);
    ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);

    // checkStageEventStatus will throw a ServiceException with Messages.MSG_SYS_EVENT_STS_MSMTCH
    // if the stage is closed or other issue is found
    checkStageEventStatus.status(ccmn06ui);

    // verify associated records present for each stage name
    idStage = cinv45si.getUlIdStage();
    String cdStageProgram = cinv45si.getSzCdStageProgram();
    verifyStages(idStage, cdStageProgram);

    // Retrieve overall roles' timestamps.
    // cinvb1d
    List<Map<String, Object>> listPrsnRoleData = stagePersonLinkDAO
                                                                   .findStagePersonLinkByIdStageAndCdStagePersType(
                                                                                                                   idStage,
                                                                                                                   CodesTables.CPRSNTYP_PRN);
    if (listPrsnRoleData == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // Retrieve list of unique dispositions for the given ID_STAGE.
    // cinva7d
    List<String> listVictimOnlyDisp = allegationDAO.findAllegDispositionfromIdStage(idStage);
    if (listVictimOnlyDisp == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // Find the overall disposition.
    String overallDisp = calcOverallDisposition(cdStageProgram, new HashSet<String>(listVictimOnlyDisp));

    // Note: Update is set manually in saveOverallDisp(), so DAMs will be guaranteed to use that path.

    // Update overall disposition in appropriate table based on program type
    saveOverallDisp(cdStageProgram, idStage, overallDisp);
    // If overall disposition has changed, clear the reason closed in the Stage table for this stage
    if (StringHelper.isValid(overallDisp) && !overallDisp.equals(cinv45si.getSzCdOverallDisp())) {
      // cauda5d
      stageDAO.updateStageSetCdStageReasonClosed(idStage);
    }
    // Retrieve and Calculate Victim Roles
    // cinvb7d map -> idPerson, cdAllegDisposition. Find allegation that has only victim, no maltreator
    List<Map<String, Object>> listVictimOnly = allegationDAO.findIdPersonByVictimIdByIdStage(idStage);
    if (listVictimOnly != null && !listVictimOnly.isEmpty()) {
      // Note: CalcVictimOnlyRole will add CdStagePersRole to each Map in the listVictimOnly collection
      String overallPerpRole = calOverallVictimRole(overallDisp);
      calcVictimOnlyRole(cdStageProgram, listVictimOnly, overallPerpRole);
      // calcVictimOnlyRole(cdStageProgram, listVictimOnly);
    }

    // Selects all victims and their allegations' dispositions for a stage of service.
    // This is a List Query.
    // (map has idPerson, cdAllegDisposition)
    // cinva0d
    List<Map<String, Object>> listVictims = allegationDAO.findAllegationIdVictim(idStage);
    if (listVictims != null && !listVictims.isEmpty()) {
      String overallPerpRole = calOverallVictimRole(overallDisp);
      calcVictimRole(cdStageProgram, listVictims, overallPerpRole);
      // calcVictimRole(cdStageProgram, listVictims);
    }

    // Retrieve and Calculate Perp Roles
    // cinva5d
    List<Map<String, Object>> listPerps = allegationDAO.findAllegationIdPerp(idStage);
    if (listPerps != null && !listPerps.isEmpty()) {
      String overallPerpRole = calOverallPerpRole(overallDisp);
      calcPerpRole(cdStageProgram, listPerps, overallPerpRole);
      // calcPerpRole(cdStageProgram, listPerps);
    }

    // Retrieve and Calculate Victim/Perp Roles
    // CallCINVA9D
    List<Map<String, Object>> listVictimPerps = findAllegationByIdVictimAndIdAllegedPerp(idStage);
    if (listVictimPerps != null) {
      listVictimPerps = calcVictimPerpRole(cdStageProgram, listVictimPerps);
    }

    ArrayList<PersonRoleData> listOverallRoleData = new ArrayList<PersonRoleData>();
    calcOverallRoles(listPrsnRoleData, listVictimOnly, listVictims, listPerps, listVictimPerps, listOverallRoleData);

    // Update STAGE_PERSON_LINK with Overall Roles.
    for (Iterator<PersonRoleData> it = listOverallRoleData.iterator(); it.hasNext();) {
      PersonRoleData prd = it.next();

      // CallCINVA6D
      stagePersonLinkDAO.updateStagePersonLinkCdStagePersRole(prd.getCdPersRole(), prd.getIdPerson(), idStage,
                                                              prd.getDtLastUpdate());
    }

    return cinv45so;
  }

  private void verifyStages(int idStage, String cdStageProgram) throws ServiceException {
    if (CodesTables.CSRPGTYP_CPS.equals(cdStageProgram)) {
      // cinv95d
      CpsInvstDetail cid = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage);
      if (cid == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }

  }

  private String calOverallPerpRole(String overallDisposition) {
    String finalRole = CodesTables.CROLEALL_NO;
    if (overallDisposition.equals(CodesTables.CDISPSTN_SUB)) {
      finalRole = CodesTables.CROLEALL_AP;
    } else if (overallDisposition.equals(CodesTables.CDISPSTN_UTD)) {
      finalRole = CodesTables.CROLEALL_UD;
    }
    return finalRole;
  }

  private String calOverallVictimRole(String overallDisposition) {
    String finalRole = CodesTables.CROLEALL_NO;
    if (overallDisposition.equals(CodesTables.CDISPSTN_SUB)) {
      finalRole = CodesTables.CROLEALL_DV;
    } else if (overallDisposition.equals(CodesTables.CDISPSTN_UTD)) {
      finalRole = CodesTables.CROLEALL_UD;
    }
    return finalRole;
  }

  private String calcOverallDisposition(String cdStageProgram, Set<String> victimOnlyDispSet) throws ServiceException {
    // New Georgia Logic
    // Overall Dispositions are calculated based on a hierarchy of
    // dispositions by program.
    // Example:
    // Program is CPS. The dispositions for the allegations in this stage
    // are {SUB, UNS, UTD}. Highest hierarchy is SUB, second is UTD, last is UNS
    // If any allegation is substantiated, the overall allegation is substantiated
    // If none are substantiated, then if any are Unable to determine, the overall is unable to determine
    // If all are unsubstantiated, then the overall is unsubstantiated
    //
    // CPS - One or more allegations is:
    //
    // SUB Substantiated
    // UTD Unable To Determine
    // UNS Unsubstantiated

    if (CodesTables.CSRPGTYP_CPS.equals(cdStageProgram)) {
      // CDISPSTN_SUB == SUBSTANTIATED
      if (victimOnlyDispSet.contains(CodesTables.CDISPSTN_SUB)) {
        return CodesTables.CDISPSTN_SUB;
      }
      // CDISPSTN_UTD == UNABLE_TO_DETRMN_DISP
      if (victimOnlyDispSet.contains(CodesTables.CDISPSTN_UTD)) {
        return CodesTables.CDISPSTN_UTD;
      }
      // ALL ARE UNSUBSTANTIATED
      return CodesTables.CDISPSTN_UNS;
    }

    // It is not an error if we reach here.
    return null;
  }

  private void saveOverallDisp(String cdStageProgram, int idStage, String overallDisp) throws ServiceException {
    // Update the appropriate Investigation Detail conclusion table with the overall disposition, based on Program.
    // CPS
    if (CodesTables.CSRPGTYP_CPS.equals(cdStageProgram)) {
      // Retrieve full row from CPS_INVST_DETAIL.
      // cinv95d
      CpsInvstDetail cid = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage);
      if (cid == null) { // this should never happen as it was already checked in verifyStages()
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      // Since only one property is being updated, It is simpler to just set that one field
      // and save the object using the shorthand save.
      // cinva8d
      cid.setCdCpsInvstDtlOvrllDisptn(overallDisp);
      cpsInvstDetailDAO.saveCpsInvstDetail(cid);
    }
  }

  private List<Map<String, Object>> findAllegationByIdVictimAndIdAllegedPerp(int idStage) {
    // this method just converts from a List<Object[]> to a List<Map>
    List<Map<String, Object>> list = null;
    List<Object[]> listObj = allegationDAO.findAllegationByIdVictimAndIdAllegedPerp(idStage);
    if (listObj != null) {
      list = new ArrayList<Map<String, Object>>(listObj.size());
      for (Iterator<Object[]> it = listObj.iterator(); it.hasNext();) {
        Object[] objs = it.next();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(MAP_ID_VICTIM, (Integer) objs[OFFSET_idVictim]);
        map.put(MAP_ID_PERP, (Integer) objs[OFFSET_idPerp]);
        map.put(MAP_CD_ALLEG_DISP_VICTIM, (String) objs[OFFSET_cdAllegDispVictim]);
        map.put(MAP_CD_ALLEG_DISP_PERP, (String) objs[OFFSET_cdAllegDispPerp]);
        list.add(map);
      }
    }
    return list;
  }

  private void calcVictimOnlyRole(String cdStageProgram, List<Map<String, Object>> listVictimOnly)
                                                                                                  throws ServiceException {
    // Calculate victim's overall role based on Program, Disposition, and the fact that the person was named as a
    // victim in an allegation that did not have a perpetrator.
    // map -> idPerson, cdAllegDisposition
    if (CodesTables.CSRPGTYP_CPS.equals(cdStageProgram)) {
      for (Iterator<Map<String, Object>> it = listVictimOnly.iterator(); it.hasNext();) {
        Map<String, Object> map = it.next();
        String cdAllegDisp = (String) map.get("cdAllegDisposition");
        String cdPersRole = CPS_ROLES_MAP.get(cdAllegDisp);
        if (cdPersRole == null) {
          throw new ServiceException(Messages.ARC_ERR_INTERNAL_ERROR);
        }
        map.put(MAP_CD_STAGE_PERS_ROLE, cdPersRole);
      }
    }
  }

  private void calcVictimOnlyRole(String cdStageProgram, List<Map<String, Object>> listVictimOnly,
                                  String overallPerpRole) throws ServiceException {
    // Calculate victim's overall role based on Program, Disposition, and the fact that the person was named as a
    // victim in an allegation that did not have a perpetrator.
    // map -> idPerson, cdAllegDisposition
    if (CodesTables.CSRPGTYP_CPS.equals(cdStageProgram)) {
      for (Iterator<Map<String, Object>> it = listVictimOnly.iterator(); it.hasNext();) {
        Map<String, Object> map = it.next();
        if (overallPerpRole == null) {
          throw new ServiceException(Messages.ARC_ERR_INTERNAL_ERROR);
        }
        map.put(MAP_CD_STAGE_PERS_ROLE, overallPerpRole);
      }
    }
  }

  /**
   * Calculate victim's overall role based on Program, Disposition, and the fact that the person was named as a victim.
   * 
   * @param cdStageProgram
   * @param listVictims
   * @throws ServiceException
   */
  private void calcVictimRole(String cdStageProgram, List<Map<String, Object>> listVictims) throws ServiceException {
    // (map has idPerson, cdAllegDisposition)
    if (CodesTables.CSRPGTYP_CPS.equals(cdStageProgram)) {
      for (Iterator<Map<String, Object>> it = listVictims.iterator(); it.hasNext();) {
        Map<String, Object> map = it.next();
        String cdAllegDisp = (String) map.get("cdAllegDisposition");
        String cdPersRole = CPS_ROLES_MAP.get(cdAllegDisp);
        if (cdPersRole == null) {
          throw new ServiceException(Messages.ARC_ERR_INTERNAL_ERROR);
        }
        map.put(MAP_CD_STAGE_PERS_ROLE, cdPersRole);
      }
    }
  }

  private void calcVictimRole(String cdStageProgram, List<Map<String, Object>> listVictims, String overallPerpRole)
                                                                                                                   throws ServiceException {
    // (map has idPerson, cdAllegDisposition)
    if (CodesTables.CSRPGTYP_CPS.equals(cdStageProgram)) {
      for (Iterator<Map<String, Object>> it = listVictims.iterator(); it.hasNext();) {
        Map<String, Object> map = it.next();
        if (overallPerpRole == null) {
          throw new ServiceException(Messages.ARC_ERR_INTERNAL_ERROR);
        }
        map.put(MAP_CD_STAGE_PERS_ROLE, overallPerpRole);
      }
    }
  }

  /**
   * Calculate alleged perpetrator role based on Program, Disposition, and the fact that the person was named as an
   * alleged perpetrator in an allegation.
   * 
   * @param cdStageProgram
   * @param listPerps
   * @throws ServiceException
   */
  private void calcPerpRole(String cdStageProgram, List<Map<String, Object>> listPerps) throws ServiceException {
    // (map has idPerson, cdAllegDisposition)
    if (CodesTables.CSRPGTYP_CPS.equals(cdStageProgram)) {
      for (Iterator<Map<String, Object>> it = listPerps.iterator(); it.hasNext();) {
        Map<String, Object> map = it.next();
        String cdAllegDisp = (String) map.get("cdAllegDisposition");
        String cdPersRole = CPS_PERP_ROLES_MAP.get(cdAllegDisp);
        if (cdPersRole == null) {
          throw new ServiceException(Messages.ARC_ERR_INTERNAL_ERROR);
        }
        map.put(MAP_CD_STAGE_PERS_ROLE, cdPersRole);
      }
    }
  }

  private void calcPerpRole(String cdStageProgram, List<Map<String, Object>> listPerps, String overallPerpRole)
                                                                                                               throws ServiceException {
    // (map has idPerson, cdAllegDisposition)
    if (CodesTables.CSRPGTYP_CPS.equals(cdStageProgram)) {
      for (Iterator<Map<String, Object>> it = listPerps.iterator(); it.hasNext();) {
        Map<String, Object> map = it.next();
        if (overallPerpRole == null) {
          throw new ServiceException(Messages.ARC_ERR_INTERNAL_ERROR);
        }
        map.put(MAP_CD_STAGE_PERS_ROLE, overallPerpRole);
      }
    }
  }

  /**
   * Calculate role based on Program, Disposition, and the fact that the person was named as both a victim and an
   * alleged perpetrator in one or more allegations.
   * 
   * @param cdStageProgram
   * @param listVictimPerps
   * @throws ServiceException
   */
  private List<Map<String, Object>> calcVictimPerpRole(String cdStageProgram, List<Map<String, Object>> listVictimPerps)
                                                                                                                        throws ServiceException {

    // CPS, CCL, and RCL
    //
    // Disposition Heirarchy:
    // SUBSTANTIATED "SUB"
    // UNABLE_TO_DETRMN_DISP "UTD"
    // UNSUBSTANTIATED "UNSUB"
    //
    // For these three programs, when a person is designated a victim
    // in one allegation and a perpertrator in another allegation within
    // the same stage, we need to take the following steps to determine
    // what their corresponding role should be:
    //
    // 1. Create a new structure (listNewVictimPerps).
    //
    // 2. Loop thru the output from AllegationDAO.findAllegationByIdVictimAndIdAllegedPerp (listVictimPerps),
    // * Copy the first record's idVictim and
    // cdAllegDispVictim from the dam output record
    // (listVictimPerps) to the new structure (listNewVictimPerps).
    // * Starting with the second record in listVictimPerps,
    // if (the idVictim of the current record
    // != the idVictim of the previous record)
    // then copy the current record's idVictim and
    // cdAllegDispVictim from the dam output record
    // (listVictimPerps) to the new structure (listNewVictimPerps).
    // else (the idVictim of the current record
    // == the idVictim of the previous record)
    // then switch on the cdAllegDispVictim from listVictimPerps
    // output record: replace the cdAllegDispVictim
    // in the new structure if the VICTIM_DISP in listVictimPerps
    // record is higher than the VICTIM_DISP in the new structure:
    // (see the Disposition Heirarchy above). This will store the
    // highest Victim disposition in the new structure for each person.
    //
    // 3. Two for loops: Outer for Loop goes thru the new structure
    // Inner for Loop goes thru the input structure listVictimPerps
    // if (the idVictim of the new structure
    // == the idPerp of the listVictimPerps input)
    // then if (the cdAllegDispPerp in the new structure
    // has not been filled yet (it equals NULL_STRING)
    // then copy the cdAllegDispVictim of the dam output
    // record to the cdAllegDispPerp of the new structure.
    // else
    // switch on the cdAllegDispPerp from the dam
    // output record: replace the cdAllegDispPerp
    // in the new structure if the PERP_DISP in the dam output
    // record is higher than the PERP_DISP in the new structure:
    // (see the Disposition Heirarchy above). This will store the
    // highest Perp disposition in the new structure for each person.
    //
    // Now the pNewVictimPerpData structure contains a idPerson, that
    // person's 'highest' Victim disposition, and 'highest' Perp disposition.
    // We can now determine what the corresponding role should be, based on
    // the following matrix:
    //
    // Highest Highest Corresponding
    // Victim Disposition Perp Disposition Role
    // SUB..................SUB.................DB
    // UTD..................UTD.................UD
    // UNSUB................UNSUB...............NO
    // --------------------------------------------------------
    // SUB..................UTD.................DV
    // SUB..................UNSUB...............DV
    // --------------------------------------------------------
    // UTD..................SUB.................DP
    // UTD..................UNSUB...............UD
    // --------------------------------------------------------
    // MOV..................SUB.................DP
    // MOV..................UTD.................UD
    // --------------------------------------------------------
    // UNSUB................SUB.................DP
    // UNSUB................UTD.................UD

    if (CodesTables.CSRPGTYP_CPS.equals(cdStageProgram) || CodesTables.CSRPGTYP_CCL.equals(cdStageProgram)
        || CodesTables.CSRPGTYP_RCL.equals(cdStageProgram)) {
      List<Map<String, Object>> listNewVictimPerps = new ArrayList<Map<String, Object>>(listVictimPerps.size());
      boolean bFirstTime = true;
      int k = 0;
      Map<String, Object> mapPrev = new HashMap<String, Object>(); // STGAP00009865
      for (ListIterator<Map<String, Object>> lit = listVictimPerps.listIterator(); lit.hasNext();) {
        Map<String, Object> map = lit.next();
        if (bFirstTime) {
          bFirstTime = false;
          Map<String, Object> mapNew = new HashMap<String, Object>();
          mapNew.put(MAP_CD_ALLEG_DISP_VICTIM, map.get(MAP_CD_ALLEG_DISP_VICTIM));
          mapNew.put(MAP_ID_VICTIM, map.get(MAP_ID_VICTIM));
          listNewVictimPerps.add(mapNew);
        } else {
          // 2nd or later time thru loop
          int idVictimCur = (Integer) map.get(MAP_ID_VICTIM);
          int idVictimPrev = (Integer) mapPrev.get(MAP_ID_VICTIM);

          if (idVictimCur != idVictimPrev) {
            k++;
            Map<String, Object> mapk = new HashMap<String, Object>();
            mapk.put(MAP_CD_ALLEG_DISP_VICTIM, map.get(MAP_CD_ALLEG_DISP_VICTIM));
            mapk.put(MAP_ID_VICTIM, map.get(MAP_ID_VICTIM));
            listNewVictimPerps.add(mapk);
          } else { // idVictimCur == idVictimPrev
            Map<String, Object> mapk = listNewVictimPerps.get(k);
            String cdAllegDispVictim_cur = (String) map.get(MAP_CD_ALLEG_DISP_VICTIM);
            String cdAllegDispVictim_k = (String) mapk.get(MAP_CD_ALLEG_DISP_VICTIM);

            switch (cdAllegDispVictim_cur.charAt(2)) {

            case SW_SUBSTANTIATED:
              mapk.put(MAP_CD_ALLEG_DISP_VICTIM, cdAllegDispVictim_cur);
              break;

            case SW_UNABLE_TO_DETRMN_DISP:
              if (!CodesTables.CDISPSTN_SUB.equals(cdAllegDispVictim_k)) {
                mapk.put(MAP_CD_ALLEG_DISP_VICTIM, cdAllegDispVictim_cur);
              }
              break;

            case SW_UNSUBSTANTIATED:
              if (!CodesTables.CDISPSTN_SUB.equals(cdAllegDispVictim_k)
                  && !CodesTables.CDISPSTN_UTD.equals(cdAllegDispVictim_k)) {
                mapk.put(MAP_CD_ALLEG_DISP_VICTIM, cdAllegDispVictim_cur);
              }
              break;
            } // end switch
          } // end inner else
        } // end outer else 
        mapPrev = map; // STGAP00009865
      } // end for loop

      // 3. Loop over new and old lists
      // STGAP00009662 - iterate listVictimPerps instead of listNewVictimPerps in inner for loop it2
      for (Iterator<Map<String, Object>> it = listNewVictimPerps.iterator(); it.hasNext();) {
        Map<String, Object> mapOuterNew = it.next();
        for (Iterator<Map<String, Object>> it2 = listVictimPerps.iterator(); it2.hasNext();) {
          Map<String, Object> mapInner = it2.next();

          int idVictimNew = (Integer) mapOuterNew.get(MAP_ID_VICTIM);
          int idPerpOld = (Integer) mapInner.get(MAP_ID_VICTIM);
          String cdAllegDispPerp_New = (String) mapOuterNew.get(MAP_CD_ALLEG_DISP_PERP);
          String cdAllegDispPerp = (String) mapInner.get(MAP_CD_ALLEG_DISP_PERP);

          if (idVictimNew == idPerpOld) {
            if (cdAllegDispPerp_New == null) {
              mapOuterNew.put(MAP_CD_ALLEG_DISP_PERP, cdAllegDispPerp);
            } else {
              switch (cdAllegDispPerp.charAt(2)) {
              case SW_SUBSTANTIATED:
                mapOuterNew.put(MAP_CD_ALLEG_DISP_PERP, cdAllegDispPerp);
                break;

              case SW_UNABLE_TO_DETRMN_DISP:
                if (!CodesTables.CDISPSTN_SUB.equals(cdAllegDispPerp_New)) {
                  mapOuterNew.put(MAP_CD_ALLEG_DISP_PERP, cdAllegDispPerp);
                }
                break;

              case SW_UNSUBSTANTIATED:
                if (!CodesTables.CDISPSTN_SUB.equals(cdAllegDispPerp_New)
                    && !CodesTables.CDISPSTN_UTD.equals(cdAllegDispPerp_New)) {
                  mapOuterNew.put(MAP_CD_ALLEG_DISP_PERP, cdAllegDispPerp);
                }
                break;

              } // End switch
            } // end if (cdAllegDispPerp_New == null)
          } // end if (idVictimNew == idPerpOld)
        } // end inner for loop
      } // end outer for loop

      for (Iterator<Map<String, Object>> it = listNewVictimPerps.iterator(); it.hasNext();) {
        Map<String, Object> mapNew = it.next();

        String cdAllegDispVictim = (String) mapNew.get(MAP_CD_ALLEG_DISP_VICTIM);
        String cdAllegDispPerp = (String) mapNew.get(MAP_CD_ALLEG_DISP_PERP);

        if (cdAllegDispVictim.equals(cdAllegDispPerp)) {
          switch (cdAllegDispPerp.charAt(2)) {
          case SW_SUBSTANTIATED: // -> DESIGNATED_BOTH
            mapNew.put(MAP_CD_STAGE_PERS_ROLE, CodesTables.CROLEALL_DB);
            break;

          case SW_UNABLE_TO_DETRMN_DISP: // -> UNABLE_TO_DETRMN_ROLE
            mapNew.put(MAP_CD_STAGE_PERS_ROLE, CodesTables.CROLEALL_UD);
            break;

          case SW_UNSUBSTANTIATED: // -> NO_ROLE
            mapNew.put(MAP_CD_STAGE_PERS_ROLE, CodesTables.CROLEALL_NO);
            break;
          }
        } else if (CodesTables.CDISPSTN_SUB.equals(cdAllegDispVictim)) { // Reason To Believe
          switch (cdAllegDispPerp.charAt(2)) {
          //case SW_SUBSTANTIATED: // -> DESIGNATED_PERP
          //  mapNew.put(MAP_CD_STAGE_PERS_ROLE, CodesTables.CROLEALL_AP);
          //  break;

          //case SW_UNSUBSTANTIATED:
          //  mapNew.put(MAP_CD_STAGE_PERS_ROLE, CodesTables.CROLEALL_UD);
          //  break;
          case SW_UNABLE_TO_DETRMN_DISP: // HTV 9/12/08 - Corrected based off of rule matrix at the beginning of method
              mapNew.put(MAP_CD_STAGE_PERS_ROLE, CodesTables.CROLEALL_DV);
              break;

          case SW_UNSUBSTANTIATED:
              mapNew.put(MAP_CD_STAGE_PERS_ROLE, CodesTables.CROLEALL_DV);
              break;
          }
        } else if (CodesTables.CDISPSTN_UTD.equals(cdAllegDispVictim)) { // UNABLE_TO_DETRMN_DISP
          switch (cdAllegDispPerp.charAt(2)) {
          case SW_SUBSTANTIATED: // -> DESIGNATED_PERP
            mapNew.put(MAP_CD_STAGE_PERS_ROLE, CodesTables.CROLEALL_AP);
            break;

          case SW_UNSUBSTANTIATED:
            mapNew.put(MAP_CD_STAGE_PERS_ROLE, CodesTables.CROLEALL_UD);
            break;
          }
        } else if (CodesTables.CDISPSTN_UNS.equals(cdAllegDispVictim)) { // RULED_OUT

          switch (cdAllegDispPerp.charAt(2)) {

          case SW_SUBSTANTIATED: // -> DESIGNATED_PERP
            mapNew.put(MAP_CD_STAGE_PERS_ROLE, CodesTables.CROLEALL_AP);
            break;

          case SW_UNABLE_TO_DETRMN_DISP: // -> UNABLE_TO_DETRMN_ROLE
            mapNew.put(MAP_CD_STAGE_PERS_ROLE, CodesTables.CROLEALL_UD);
            break;
          }
        }
      }
      return listNewVictimPerps;
    } else {
      return listVictimPerps;
    }
  }

  /*
   * Function Name: CalcOverallRoles * * Description: Calculate Overall Role based on Program and * results from
   * CalcVictimRole(), CalcPerpRole(), * and CalcVictimPerpRole() and CalcVictimOnlyRole().
   */
  private void calcOverallRoles(List<Map<String, Object>> listPrsnRoleData, List<Map<String, Object>> listVictimOnly,
                                List<Map<String, Object>> listVictim, List<Map<String, Object>> listPerp,
                                List<Map<String, Object>> listVictimPerp, List<PersonRoleData> listOverallRoleData)
                                                                                                                   throws ServiceException {
    int totalRows = listVictimOnly.size() + listVictim.size() + listPerp.size() + listVictimPerp.size();
    /*
     * * Check that at least one person is assigned an allegation in this * stage.
     */
    if (totalRows == 0) {
      throw new ServiceException(Messages.ARC_ERR_INTERNAL_ERROR);
    }

    ArrayList<PersonRoleData> listPrd = new ArrayList<PersonRoleData>(totalRows);

    for (Iterator<Map<String, Object>> it = listVictimOnly.iterator(); it.hasNext();) {
      Map<String, Object> map = it.next();
      int idPerson = (Integer) map.get(MAP_ID_PERSON);
      String cdPersRole = (String) map.get(MAP_CD_STAGE_PERS_ROLE);
      PersonRoleData prd = new PersonRoleData(idPerson, cdPersRole);
      listPrd.add(prd);
    }

    for (Iterator<Map<String, Object>> it = listVictim.iterator(); it.hasNext();) {
      Map<String, Object> map = it.next();
      int idPerson = (Integer) map.get(MAP_ID_PERSON);
      String cdPersRole = (String) map.get(MAP_CD_STAGE_PERS_ROLE);
      PersonRoleData prd = new PersonRoleData(idPerson, cdPersRole);
      listPrd.add(prd);
    }

    for (Iterator<Map<String, Object>> it = listPerp.iterator(); it.hasNext();) {
      Map<String, Object> map = it.next();
      int idPerson = (Integer) map.get(MAP_ID_PERSON);
      String cdPersRole = (String) map.get(MAP_CD_STAGE_PERS_ROLE);
      PersonRoleData prd = new PersonRoleData(idPerson, cdPersRole);
      listPrd.add(prd);
    }

    for (Iterator<Map<String, Object>> it = listVictimPerp.iterator(); it.hasNext();) {
      Map<String, Object> map = it.next();
      int idPerson = (Integer) map.get(MAP_ID_VICTIM);
      String cdPersRole = (String) map.get(MAP_CD_STAGE_PERS_ROLE);
      PersonRoleData prd = new PersonRoleData(idPerson, cdPersRole);
      listPrd.add(prd);
    }

    // sort the list of persons and roles by idPerson
    Collections.sort(listPrd);

    // get the first current person / role
    PersonRoleData currentPrd = listPrd.get(0);
    Set<String> setRoles = new HashSet<String>();
    String cdOverallRole2;
    for (Iterator<PersonRoleData> it = listPrd.iterator(); it.hasNext();) {
      PersonRoleData prd = it.next();
      if (prd.getIdPerson() == currentPrd.getIdPerson()) {
        /* Store his/her roles in temporary place holder. */
        setRoles.add(prd.getCdPersRole());
      } else {
        // add the data for the old person
        // listOverallRoleData.add(currentPrd);
        // setRoles.clear();

        // New Person - Calculate Overall Role for Current Person
        /* Determine Current Person's Overall Role */
        // setRoles.add(prd.getCdPersRole());
        // cdOverallRole2 = calcCurrentPersonRole(setRoles);
        // PersonRoleData prdnew = new PersonRoleData(prd.getIdPerson(), cdOverallRole2);
        cdOverallRole2 = calcCurrentPersonRole(setRoles);
        PersonRoleData prdnew = new PersonRoleData(currentPrd.getIdPerson(), cdOverallRole2);
        // look up the timestamp
        for (Iterator<Map<String, Object>> it2 = listPrsnRoleData.iterator(); it2.hasNext();) {
          Map<String, Object> map = it2.next();
          int idPerson = (Integer) map.get(MAP_ID_PERSON);
          // if (idPerson == prd.getIdPerson()) {
          if (idPerson == currentPrd.getIdPerson()) {
            prdnew.setDtLastUpdate((Date) map.get(MAP_DT_LAST_UPDATE));
            break;
          }
        }
        // add the data for the old person
        listOverallRoleData.add(prdnew);
        setRoles.clear();
        setRoles.add(prd.getCdPersRole());
      }
      // Set the current PersonRoleData to this PersonRoleData
      currentPrd = prd;
    }
    // Determine Last Person's Overall Role
    cdOverallRole2 = calcCurrentPersonRole(setRoles);
    PersonRoleData lastPrd = new PersonRoleData(currentPrd.getIdPerson(), cdOverallRole2);
    // prd.setCdPersRole(cdOverallRole2);
    // look up the timestamp
    for (Iterator<Map<String, Object>> it2 = listPrsnRoleData.iterator(); it2.hasNext();) {
      Map<String, Object> map = it2.next();
      int idPerson = (Integer) map.get(MAP_ID_PERSON);
      if (idPerson == lastPrd.getIdPerson()) {
        lastPrd.setDtLastUpdate((Date) map.get(MAP_DT_LAST_UPDATE));
        break;
      }
    }
    listOverallRoleData.add(lastPrd);
  }

  private String calcCurrentPersonRole(Set<String> setRoles) throws ServiceException {
    String overallRole = null;
    // loop over overallRolesList to see if it matches any role in the incoming hashset
    for (int i = 0; i < OVERALL_ROLES_LIST.length; i++) {
      if (setRoles.contains(OVERALL_ROLES_LIST[i])) {
        overallRole = OVERALL_ROLES_LIST[i];
        break;
      }
    }
    if (overallRole == null) {
      throw new ServiceException(Messages.ARC_ERR_INTERNAL_ERROR);
    }
    // if Unknown or moved, use Unknown or UTC instead
    if (CodesTables.CROLEALL_UM.equals(overallRole)) {
      overallRole = CodesTables.CROLEALL_UC;
    }
    return overallRole;
  }
}

// private class to allow sorting an ArrayList by idPerson
// Also more efficient than Maps

class PersonRoleData implements Comparable<PersonRoleData> {
  final int idPerson;

  final String cdPersRole;

  Date dtLastUpdate = null;

  public PersonRoleData(int idPerson, String cdRole) {
    this.idPerson = idPerson;
    cdPersRole = cdRole;
  }

  public int getIdPerson() {
    return idPerson;
  }

  public String getCdPersRole() {
    return cdPersRole;
  }

  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  public int compareTo(PersonRoleData personRoleData) {
    if (personRoleData.getIdPerson() < this.idPerson) {
      return -1;
    } else if (personRoleData.getIdPerson() == this.idPerson) {
      return 0;
    } else {
      return 1;
    }
  }

}
