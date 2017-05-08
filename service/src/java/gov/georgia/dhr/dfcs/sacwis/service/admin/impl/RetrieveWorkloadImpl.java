package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicWorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TempStagePersLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.TempStagePersLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveWorkload;
import gov.georgia.dhr.dfcs.sacwis.service.admin.UnitAccess;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY;

/**
 * 
 * Change History: Date       User          Description
 *                 ---------- ------------- -----------------------------------------------
 *                 05/07/2010 hanguyen      SMS#37187: Updated retrieveTemporaryAssignments 
 *                                          method to call tempStagePersLink.getIdTempStage()
 *                 02/23/2011 hanguyen      SMS#97850: MR-075 Retrieve home current FAD IVE 
 *                                          Reimbursability status and FA Home status. 
 *                 03/26/2011 hanguyen      SMS#97850: MR-075 Update for SO element name change.
*/

public class RetrieveWorkloadImpl extends BaseServiceImpl implements RetrieveWorkload {

  private static final String CRASH_RECOVERY_STAGE = "NO ASSIGN";

  private DynamicWorkloadDAO dynamicWorkloadDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private TempStagePersLinkDAO tempStagePersLinkDAO = null;
  private UnitAccess unitAccess = null;

  public void setDynamicWorkloadDAO(DynamicWorkloadDAO dynamicWorkloadDAO) {
    this.dynamicWorkloadDAO = dynamicWorkloadDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setTempStagePersLinkDAO(TempStagePersLinkDAO tempStagePersLinkDAO) {
    this.tempStagePersLinkDAO = tempStagePersLinkDAO;
  }

  public void setUnitAccess(UnitAccess unitAccess) {
    this.unitAccess = unitAccess;
  }

  public CCMN14SO findWorkloadInformation(CCMN14SI ccmn14si) throws ServiceException {
    CCMN14SO ccmn14so = new CCMN14SO();
    ArchInputStruct archInputStruct = ccmn14si.getArchInputStruct();
    String cReqFuncCd = archInputStruct.getCReqFuncCd();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();
    //Count variable for the total number of stages for the particular person
    int workloadTotalCount;
    int workloadStageINVCount;
    int workloadStageADOCount;
    int workloadStageONGCount;
    int workloadStageFCFCount;
    int workloadStageFCCCount;
    int rowccmn37DOCount = 0;
    ROWCCMN52DI_ARRAY rowccmn52di_array = ccmn14si.getROWCCMN52DI_ARRAY();
    int idPerson = ccmn14si.getUlIdPerson();
    if (rowccmn52di_array != null && rowccmn52di_array.getROWCCMN52DICount() > 0 &&
        0 != rowccmn52di_array.getROWCCMN52DI(0).getUlIdStage()) {
      // If there are any IdStage's in the Input Message then StagePersonLinkDAO needs to be called
      // to update the IND_STAGE_PERS_EMP_NEW fields for those IdStage's passed.
      // Preparing to call StagePersonLinkDAO
      // Updates the IND STAGE PERS EMP NEW field in the STAGE PERSON LINK table for a certain person
      // and a certain STAGE (for all ID_STAGEs sent to this service)
      for (Enumeration rowccmn52diEnum = rowccmn52di_array.enumerateROWCCMN52DI(); rowccmn52diEnum.hasMoreElements();) {
        ROWCCMN52DI rowccmn52di = (ROWCCMN52DI) rowccmn52diEnum.nextElement();
        // Calling StagePersonLinkDAO, CCMN52D
        stagePersonLinkDAO.updateStagePersonLinkIndStagePersEmpNew(rowccmn52di.getUlIdStage(), idPerson);
        // If the row was not found because another user had modified it (i.e. different timestamp
        // or deleted row) the dao should continue since the next daos executed are the retrieval
        // to popluate/refresh the listbox and bring back the correct timestamps and rows.
      }
    }
    // Create output struct for pagination information.
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    // Call this retrieve DAO only if we are coming in to an non-filtered workload.
    ROWCCMN37DO_ARRAY rowccmn37do_array_tempAssign = null;
    if (!FILTER_BY_INV_30.equals(cReqFuncCd) && !FILTER_BY_SVC_60.equals(cReqFuncCd)) {
      // Retrieves rows (if any) from the Temp_stage_pers_link table.
      rowccmn37do_array_tempAssign = retrieveTemporaryAssignments(idPerson, pageNbr, pageSize);
      ccmn14so.setROWCCMN37DO_ARRAY(rowccmn37do_array_tempAssign);
      // Set pagination flag.
      archOutputStruct.setBMoreDataInd(rowccmn37do_array_tempAssign.getBMoreDataInd());
      // Update pagination parameters to account for the fact that we already pulled some data down.
      rowccmn37DOCount = rowccmn37do_array_tempAssign.getROWCCMN37DOCount();
      if (rowccmn37DOCount > 0) {
        pageSize -= rowccmn37DOCount;
        pageNbr = 1;
      }
    }
    // Call following dao as long as Temp Assignments hasn't used up all of the available rows in output message;
    //   we check pageSize, as it has been updated if the temp assignments returned data.
    if (pageSize > 0) {
      // Retrieve all the Assignments for a certain person.
      ROWCCMN37DO_ARRAY rowccmn37do_array = retrieveWorkload(idPerson, cReqFuncCd, ccmn14si.getBWcdCdSortBy(), pageNbr,
                                                             pageSize);
      // Set the pagination flag.
      archOutputStruct.setBMoreDataInd(rowccmn37do_array.getBMoreDataInd());
      if (rowccmn37do_array_tempAssign != null) {
        // We need to combine the results.
        Enumeration rowccmn37do_enum = rowccmn37do_array.enumerateROWCCMN37DO();
        while (rowccmn37do_enum.hasMoreElements()) {
          rowccmn37do_array_tempAssign.addROWCCMN37DO((ROWCCMN37DO) rowccmn37do_enum.nextElement());
        }
        // Replace rowccmn37do with the appended one
        rowccmn37do_array = rowccmn37do_array_tempAssign;
      }
      ccmn14so.setROWCCMN37DO_ARRAY(rowccmn37do_array);
    }
    // Call Common Function to find out if user is a supervisor or not.
    // Only call this the first time the service is invoked.
    if (!ArchitectureConstants.Y.equals(ccmn14si.getBSysIndSupervisor())
        && !ArchitectureConstants.N.equals(ccmn14si.getBSysIndSupervisor())) {
      // Preparing to call UnitAccess. Common Function returns figures out if user is a supervisor
      CCMN04UI ccmn04ui = new CCMN04UI();
      UlIdPerson_ARRAY_CCMN04UI ulIdPerson_array_ccmn04ui = new UlIdPerson_ARRAY_CCMN04UI();
      ulIdPerson_array_ccmn04ui.addUlIdPerson(idPerson);
      ccmn04ui.setUlIdPerson_ARRAY_CCMN04UI(ulIdPerson_array_ccmn04ui);
      ccmn04ui.setSzCdUnitProgram(ccmn14si.getSzCdUnitProgram());
      ccmn04ui.setSzCdUnitRegion(ccmn14si.getSzCdUnitRegion());
      ccmn04ui.setSzCdUnitCounty(ccmn14si.getSzCdUnitCounty());
      ccmn04ui.setSzNbrUnit(ccmn14si.getSzNbrUnit());
      // Calling UnitAccess
      CCMN04UO ccmn04uo = unitAccess.checkForPersonWithUnitAccess(ccmn04ui);
      if (StringHelper.isTrue(ccmn04uo.getBSysIndGeneric())) {
        ccmn14so.setBSysIndSupervisor(ArchitectureConstants.Y);
      } else {
        ccmn14so.setBSysIndSupervisor(ArchitectureConstants.N);
      }
    }
    //  Set the overPolicyLimit Indicator to true if the total stages assigned to a Case Manager is more than 17
    workloadTotalCount = Integer.parseInt(dynamicWorkloadDAO.countWorkload(idPerson));
    if ((workloadTotalCount + rowccmn37DOCount) > 17) {
      ccmn14so.setBIndOverPolicyLimit(true);
    }
    //  Set the overPolicyLimit Indicator to true if the total Investigation stages assigned to a Case Manager 
    //is more than 12
    workloadStageINVCount = Integer.parseInt(dynamicWorkloadDAO.countWorkloadStages(idPerson, "INV"));
    if (workloadStageINVCount > 12) {
      ccmn14so.setBIndOverPolicyLimit(true);
    }
    //  Set the overPolicyLimit Indicator to true if the total Adoption stages assigned to a Case Manager 
    //is more than 16
    workloadStageADOCount = Integer.parseInt(dynamicWorkloadDAO.countWorkloadStages(idPerson, "ADO"));
    if (workloadStageADOCount > 16) {
      ccmn14so.setBIndOverPolicyLimit(true);
    }
    //  Set the overPolicyLimit Indicator to true if the total Ongoing stages assigned to a Case Manager 
    //is more than 17
    workloadStageONGCount = Integer.parseInt(dynamicWorkloadDAO.countWorkloadStages(idPerson, "ONG"));
    if (workloadStageONGCount > 17) {
      ccmn14so.setBIndOverPolicyLimit(true);
    }
    //  Set the overPolicyLimit Indicator to true if the total Foster Care stages assigned to a Case Manager 
    //is more than 15
    workloadStageFCFCount = Integer.parseInt(dynamicWorkloadDAO.countWorkloadStages(idPerson, "FCF"));
    workloadStageFCCCount = Integer.parseInt(dynamicWorkloadDAO.countWorkloadStages(idPerson, "FCC"));
    if ((workloadStageFCFCount + workloadStageFCCCount) > 15) {
      ccmn14so.setBIndOverPolicyLimit(true);
    }
    //  Set the overPolicyLimit Indicator to true if the Specialized Social Services Case Manager 
    // is more than 12. Specialized is assigned when a child is in custody 18 months or longer
    workloadStageFCFCount = Integer.parseInt(dynamicWorkloadDAO.countSpecializedWorkerStages(idPerson, "FCF"));
    workloadStageFCCCount = Integer.parseInt(dynamicWorkloadDAO.countSpecializedWorkerStages(idPerson, "FCC"));
    if ((workloadStageFCFCount + workloadStageFCCCount) > 12) {
      ccmn14so.setBIndOverPolicyLimit(true);
    }
    ccmn14so.setUlWorkloadCount(workloadTotalCount + rowccmn37DOCount);
    ccmn14so.setArchOutputStruct(archOutputStruct);
    return ccmn14so;
  }

  private ROWCCMN37DO_ARRAY retrieveTemporaryAssignments(int idPerson, int pageNbr, int pageSize) {
    // ccmnf8d
    PaginatedHibernateList<TempStagePersLink> listTempStagePersLink =
            tempStagePersLinkDAO.findTempStagePersLinkByIdTempStagePerson(idPerson, pageNbr, pageSize);
    ROWCCMN37DO_ARRAY rowccmn37do_array = new ROWCCMN37DO_ARRAY();
    if (listTempStagePersLink != null && !listTempStagePersLink.isEmpty()) {
      rowccmn37do_array.setMoreDataAvailable(listTempStagePersLink.isMoreDataAvailable());
      for (Iterator<TempStagePersLink> it = listTempStagePersLink.iterator(); it.hasNext();) {
        TempStagePersLink tempStagePersLink = it.next();
        ROWCCMN37DO rowccmn37do = new ROWCCMN37DO();
        rowccmn37do.setSzCdStagePersRole(tempStagePersLink.getCdTempStagePersRole());
        rowccmn37do.setSzCdStage(tempStagePersLink.getCdTempStage());
        // Copy in macro to Row to let window know this stage came from the TempStagePersLink table
        rowccmn37do.setSzNmCase(CRASH_RECOVERY_STAGE);
        rowccmn37do.setUlIdStage(
                tempStagePersLink.getIdTempStage() != null ? tempStagePersLink.getIdTempStage() : 0);
        rowccmn37do.setTsLastUpdate(tempStagePersLink.getDtLastUpdate());
        rowccmn37do_array.addROWCCMN37DO(rowccmn37do);
      }
    }
    return rowccmn37do_array;
  }

  private ROWCCMN37DO_ARRAY retrieveWorkload(int idPerson, String cReqFuncCd, String cdSortBy, int pageNbr,
                                             int pageSize) {
    // Calling DynamicWorkloadDAO, CCMN37D (using cReqFuncCd to pass in the filterBy parameter)
    // ccmn37d
    PaginatedHibernateList<Object[]> listWorkloadObjects =
            dynamicWorkloadDAO.findWorkload(idPerson, cReqFuncCd, cdSortBy, pageNbr, pageSize);
    // The retrieved row/column values are appended to the existing ROWCCMN37DO_ARRAY object
    // that is contained within the ccmn14so output object
    if (listWorkloadObjects == null || listWorkloadObjects.isEmpty()) {
      // A No Rows Found message is only returned if neither this dao nor the previous dao,
      // TempStagePersLinkDAO, (retrieval from TempStagePersLink table) returned any* rows.
      throw new ServiceException(Messages.MSG_CMN_EMPTY_WORKLOAD);
    }
    ROWCCMN37DO_ARRAY rowccmn37do_array = new ROWCCMN37DO_ARRAY();
    rowccmn37do_array.setMoreDataAvailable(listWorkloadObjects.isMoreDataAvailable());
    for (Iterator<Object[]> objectArrayIt = listWorkloadObjects.iterator(); objectArrayIt.hasNext();) {
      Object[] workloadRow = objectArrayIt.next();
      ROWCCMN37DO rowccmn37do = new ROWCCMN37DO();
      rowccmn37do.setBIndCaseSensitive((String) workloadRow[15]);
      rowccmn37do.setSzCdStagePersRole((String) workloadRow[9]);
      rowccmn37do.setSzNmStage((String) workloadRow[2]);
      rowccmn37do.setSzCdStageCnty((String) workloadRow[3]);
      rowccmn37do.setSzCdStage((String) workloadRow[4]);
      rowccmn37do.setSzCdStageType((String) workloadRow[5]);
      rowccmn37do.setDtDtStagePersLink(DateHelper.toCastorDate((Date) workloadRow[11]));
      rowccmn37do.setDtDtStageStart(DateHelper.toCastorDate((Date) workloadRow[0]));
      rowccmn37do.setSzCdStageProgram((String) workloadRow[6]);
      rowccmn37do.setSzCdStageRegion((String) workloadRow[7]);
      rowccmn37do.setSzNbrUnit((String) workloadRow[17]);
      rowccmn37do.setBIndStagePersEmpNew((String) workloadRow[13]);
      rowccmn37do.setSzCdRiskLvl((String) workloadRow[20]);
      rowccmn37do.setSzCdStageCurrPriority((String) workloadRow[21]);
      BigDecimal idCaseBigDecimal = (BigDecimal) workloadRow[14];
      BigDecimal idStageBigDecimal = (BigDecimal) workloadRow[1];
      BigDecimal nbrErrorsBigDecimal = (BigDecimal) workloadRow[23];
      BigDecimal nbrWarningsBigDecimal = (BigDecimal) workloadRow[24];
      rowccmn37do.setSzCdRsrcFaHomeStatus((String) workloadRow[25]);
      rowccmn37do.setBIndHomeIveReimbursable((String) workloadRow[26]);
      
      int idCase = 0;
      if (idCaseBigDecimal != null) {
        idCase = idCaseBigDecimal.intValue();
      }

      int idStage = 0;
      if (idStageBigDecimal != null) {
        idStage = idStageBigDecimal.intValue();
      }
      
      int nbrErrors = 0;
      if (nbrErrorsBigDecimal != null) {
        nbrErrors = nbrErrorsBigDecimal.intValue();
      }

      int nbrWarnings = 0;
      if (nbrWarningsBigDecimal != null) {
        nbrWarnings = nbrWarningsBigDecimal.intValue();
      }
      rowccmn37do.setUlIdCase(idCase);
      rowccmn37do.setUlIdStage(idStage);

      rowccmn37do.setSzNmCase((String) workloadRow[16]);
      rowccmn37do.setSzCdStageReasonClosed((String) workloadRow[8]);
      rowccmn37do.setSzCdMobileStatus((String) workloadRow[10]);
      rowccmn37do.setTsLastUpdate((Date) workloadRow[12]);
      // MHMR Enhancement for AFC Investigation "Waiting for Superintendent Comments". User will now be
      // able to sort by "Superintendent Notified" indicator.
      rowccmn37do.setCIndWkldSuperintNotif((String) workloadRow[18]);
      rowccmn37do.setSzCdRecidivism((String) workloadRow[19]);
      //Adding Errors and Warnings Number to the Output object
      rowccmn37do.setNbrErrors(nbrErrors);
      rowccmn37do.setNbrWarnings(nbrWarnings);      
      rowccmn37do_array.addROWCCMN37DO(rowccmn37do);
    }
    return rowccmn37do_array;
  }

}
