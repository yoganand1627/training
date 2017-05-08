package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FacilityInvstDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingFacilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LicensingInvstDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingFacility;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveChangeCaseName;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN85SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN85SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStagePersRole_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdStageProgram_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzNmPersonFull_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdNmPerson_ARRAY;

public class RetrieveChangeCaseNameImpl extends BaseServiceImpl implements RetrieveChangeCaseName {

  private FacilityInvstDtlDAO facilityInvstDtlDAO = null;
  private LicensingInvstDtlDAO licensingInvstDtlDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private AllegationHistoryDAO allegationHistoryDAO = null;
  private StageLinkDAO stageLinkDAO = null;
  private IncomingFacilityDAO incomingFacilityDAO = null;
  private StageDAO stageDAO = null;
  private CapsCaseDAO capsCaseDAO = null;
  public static final int NM_PERSON_FULL_LEN = 26;
  public static final int CASE_NM_ET_AL_LEN = 6;
  public static final String CASE_NM_ET_AL = " et al";

  public void setFacilityInvstDtlDAO(FacilityInvstDtlDAO facilityInvstDtlDAO) {
    this.facilityInvstDtlDAO = facilityInvstDtlDAO;
  }

  public void setLicensingInvstDtlDAO(LicensingInvstDtlDAO licensingInvstDtlDAO) {
    this.licensingInvstDtlDAO = licensingInvstDtlDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setAllegationHistoryDAO(AllegationHistoryDAO allegationHistoryDAO) {
    this.allegationHistoryDAO = allegationHistoryDAO;
  }

  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public void setIncomingFacilityDAO(IncomingFacilityDAO incomingFacilityDAO) {
    this.incomingFacilityDAO = incomingFacilityDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public CCMN85SO findAllPrinciplesAndFacility(CCMN85SI ccmn85si) throws ServiceException {
    CCMN85SO ccmn85so = new CCMN85SO();
    int idStage = ccmn85si.getUlIdStage();
    String cdStage = ccmn85si.getSzCdStage();
    boolean licensingClassification = false;

    // Retrieving the facility name associated with case
    String facilName = facilityInvstDtlDAO.findNmFacilInvstFacilityFromFacilityInvstDtlByIdStage(idStage);
    ccmn85so.setSzNmFacilInvstFacility(facilName != null ? facilName : "");

    //Retrieves the Licensing facility name associated with case.
    String licensingFacilName = licensingInvstDtlDAO.findLicensingInvstDtlByIdStage(idStage);
    ccmn85so.setSzNmFacilInvstFacility(licensingFacilName != null ? licensingFacilName : "");

    // Retrieves all principals (up to 200) associated with the most recent stage of the case. 
    // Also returns CD STAGE PROGRAM which identifies whether the person is APS, CPS, etc. 
    // and CD STAGE PERS ROLE which is evaluated to see if the principal is also the victim.
    List<Map> principalsList = stagePersonLinkDAO.findNamesFromStageAndStagePersonLinkAndPersonByIdStage(idStage);
    if (principalsList != null) {
      SzNmPersonFull_ARRAY szNmPersonFull_Array = new SzNmPersonFull_ARRAY();
      SzCdStageProgram_ARRAY szCdStageProgram_Array = new SzCdStageProgram_ARRAY();
      SzCdStagePersRole_ARRAY szCdStagePersRole_Array = new SzCdStagePersRole_ARRAY();
      UlIdNmPerson_ARRAY ulIdNmPerson_Array = new UlIdNmPerson_ARRAY();
      int i = 0;
      for (Iterator<Map> it = principalsList.iterator(); it.hasNext();) {
        Map map = it.next();
        szNmPersonFull_Array.addSzNmPersonFull((String) map.get("nmPersonFull"));
        szCdStageProgram_Array.addSzCdStageProgram((String) map.get("cdStageProgram"));
        szCdStagePersRole_Array.addSzCdStagePersRole((String) map.get("cdStagePersRole"));
        ulIdNmPerson_Array.addUlIdNmPerson((Integer) map.get("idPerson"));
        i++;
      }
      ulIdNmPerson_Array.setUlRowQty(i);
      szNmPersonFull_Array.setUlRowQty(i);
      szCdStageProgram_Array.setUlRowQty(i);
      szCdStagePersRole_Array.setUlRowQty(i);

      ccmn85so.setSzNmPersonFull_ARRAY(szNmPersonFull_Array);
      ccmn85so.setSzCdStageProgram_ARRAY(szCdStageProgram_Array);
      ccmn85so.setSzCdStagePersRole_ARRAY(szCdStagePersRole_Array);
      ccmn85so.setUlIdNmPerson_ARRAY(ulIdNmPerson_Array);
      // Populating the  number of rows
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setUlRowQty(principalsList.size());
      ccmn85so.setArchOutputStruct(archOutputStruct);
    }
    // If the case program is AFC, query the AllegationHistorytable for all persons that were 
    // victims at any time during the history of the case.  The person(s) retrieved may or may 
    // not be a current victim on the current list of allegations, but they were a victim at 
    // some point in the case.The names for these victims will have "et al" appended to them, 
    // and they will be passed back to the window to be used as potential case names. The first 
    // time that it is copied to the window, the name will appear as the normal nmPersonFull. The 
    // second time, it will appear with "et al" appended to the name.
    // (The query that retrieves all principals for the case also determines the case
    // program and stores it with each principal that it returns.)
    // Put in check to ensure we are not attempting to retrieve from an empty array - aodutayo
    if (ccmn85so.getSzCdStageProgram_ARRAY() != null && ccmn85so.getSzCdStageProgram_ARRAY().getUlRowQty() > 0 && CodesTables.CCLASS_AFC.equals(ccmn85so.getSzCdStageProgram_ARRAY().getSzCdStageProgram(0))) {
      List<String> victimsList = allegationHistoryDAO.findAllegationHistoryNmPersonFull(idStage);
      if (victimsList != null) {
        int rowsInVictimsList = victimsList.size();
        if (rowsInVictimsList > 1) {
          SzNmPersonFull_ARRAY szNmPersonFull_Array = new SzNmPersonFull_ARRAY();
          for (Iterator<String> it = victimsList.iterator(); it.hasNext();) {
            String szTempCaseName = appendEtAlToName(it.next());
            szNmPersonFull_Array.addSzNmPersonFull(szTempCaseName);
          }
          ccmn85so.setSzNmPersonFull_ARRAY(szNmPersonFull_Array);
          // Add the number of victims retrieved from the query to the total number of rows 
          // passed back to the window.
          ccmn85so.getArchOutputStruct().setUlRowQty(ccmn85so.getArchOutputStruct().getUlRowQty() + rowsInVictimsList);
        }
      }
    }
    //Retrieves priorIdStage if the current case is an LCC, LRC, RCL or CCL Licensing case.                              
    for (Enumeration cdStageProgramEnum = ccmn85so.getSzCdStageProgram_ARRAY().enumerateSzCdStageProgram();
         cdStageProgramEnum.hasMoreElements();) {
      String cdStageProgramRole = (String) cdStageProgramEnum.nextElement();
      if (CodesTables.CCLASS_LRC.equals(cdStageProgramRole) ||
          CodesTables.CCLASS_LCC.equals(cdStageProgramRole)) {
        // DAM CCMNB5D which returns the latest prior stage ID for a particular STAGE ID.
        Integer idPriorStage = stageLinkDAO.findStageLinkMostRecentlyClosedPreviousIdStage(idStage);
        if (idPriorStage == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        } else {
          ccmn85so.setUlIdPriorStage(idPriorStage != null ? idPriorStage : 0);
        }
        licensingClassification = true;
        break;
      }
    }
    // If an LRC,LCC,RCL or CCL licensing classification was found then retrieve the Facility name 
    //corresponding to the previously retrieved prior stage.
    if (licensingClassification) {
      // If no prior stage found then use current one 
      if (0 == ccmn85so.getUlIdPriorStage()) {
        ccmn85so.setUlIdPriorStage(idStage);
      }
      // Get Facility name for prior stage
      IncomingFacility incomingFacility = incomingFacilityDAO.findIncomingFacilityByIdStage(
              ccmn85so.getUlIdPriorStage());
      if (incomingFacility == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      } else {
        ccmn85so.setNmIncmgFacilName(incomingFacility.getNmIncmgFacilName());
      }
    }
    
    // Retrieve the Name from the Database, rather than simply getting it from the InitData.
    // STGAP00010363 - Include PFC when checking for child specific stages
    if (CodesTables.CSTAGES_SUB.equals(cdStage) || CodesTables.CSTAGES_PFC.equals(cdStage) ||
        CodesTables.CSTAGES_PAL.equals(cdStage) || CodesTables.CSTAGES_ADO.equals(cdStage) || 
        CodesTables.CSTAGES_PAD.equals(cdStage)) {
      // Retrieving a full row from the STAGE table based on the given idStaget
      Stage stage = stageDAO.findStageByIdStage(idStage);
      if (stage != null) {
        ccmn85so.setNmPersonHistFull(stage.getNmStage());
      } else {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    } else {
      // Obtain Case Name if the Stage is not Subcare  
      CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(ccmn85si.getUlIdCase());
      if (capsCase != null) {
        ccmn85so.setNmPersonHistFull(capsCase.getNmCase());
      } else {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
    return ccmn85so;
  }

  private String appendEtAlToName(String szNameToAppend) {
    String szTempString = new String();
    if (szNameToAppend != null) {
      // If the length of name is less than 20 chars, there is room to add the suffix.
      if (szNameToAppend.length() < NM_PERSON_FULL_LEN - CASE_NM_ET_AL_LEN) {
        szTempString = szNameToAppend + CASE_NM_ET_AL;
      }
      // If there is not enough room, truncate the case name to 19 characters
      // (including the comma). Then append the "et al".
      else {
        szTempString = szNameToAppend.substring(0, NM_PERSON_FULL_LEN - CASE_NM_ET_AL_LEN);
        szTempString += CASE_NM_ET_AL;
      }
    }
    return szTempString;
  }
}
