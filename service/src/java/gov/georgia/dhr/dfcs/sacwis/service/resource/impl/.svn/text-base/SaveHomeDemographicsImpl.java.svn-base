package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.HomeEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.HomeRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourcePhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SituationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.VendorOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.ContractCounty;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.HomeEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.HomeEthnicityId;
import gov.georgia.dhr.dfcs.sacwis.db.HomeRace;
import gov.georgia.dhr.dfcs.sacwis.db.HomeRaceId;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.db.ResourcePhone;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceService;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveVendorOutbound;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.SaveHomeDemographics;
import gov.georgia.dhr.dfcs.sacwis.service.resource.UpdateFAResource;
//import gov.georgia.dhr.dfcs.sacwis.service.resource.impl.SaveResourceDetailImpl.TempServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.InvalidateApprovalSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG03;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG04;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG05;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG06;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.VendorOutboundSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 **  01/19/2009  pcoogan           STGAP00011971- MR-027, add logic to send vendor update 
 *                                 transaction if there is an active contract for an active
 *                                 home, even if no VID currently exists     
 *                                 
 *   06/25/2009  hjbaptiste        STGAP00013543 If the Home Name changes, update the Stage and 
 *                                 Case Name to the updated name   
 *   11/22/2010  arege             SMS#79227: Added method to add rows to Resource_Services table and Contract_County 
 *                                 table when Resource County is Updated, this will make sure the user does not get the 
 *                                 error message while Save and Submit of the Placement Info page.          
 *   01/25/2011  arege             SMS#79227 Compare with cd Resource Service  while adding Resource Services                                        
 *   03/18/2011  hnguyen           SMS#97850: MR-075 Added logic to allow save in approval mode without invalidating
 *                                 current pending event.
 *   03/25/2011  hnguyen           SMS#97850: MR-075 Removed logic that set resource status on save or submit, 
 *                                 this should only be set on approval based on home current status and hold placment cbx.
 *   04/11/2011  hnguyen           SMS#105126: MR-075 Updated logic to invalidate pending event if CM/Supervisor modifies page in Modify mode
 *                                 while event still pending approval.
 *   09/12/2011 charden            STGAP00017058 - adding code to update vendor ID's for resource 
 *                                
 **/

public class SaveHomeDemographicsImpl extends BaseServiceImpl implements SaveHomeDemographics {
  public static final String PHONE_TYPE = "01";
  public static final String FAX_TYPE = "03";
  public static final String FAX2_TYPE = "08";
  
  int idRsrcAddress = 0; 
 
  //-- temporary message
  private static final String MSG_VID_REQ = "The Resource Details can not be updated until Vendor ID is assigned by SMILE";

  private CapsCaseDAO capsCaseDAO = null;

  private CapsResourceDAO capsResourceDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private ComplexCapsResourceDAO complexCapsResourceDAO = null;

  private ComplexStageDAO complexStageDAO = null;

  private ComplexStagePersonLinkDAO complexStagePersonLinkDAO = null;
  
  private ContractCountyDAO contractCountyDAO = null;

  private HomeEthnicityDAO homeEthnicityDAO = null;

  private HomeRaceDAO homeRaceDAO = null;
  
  private InvalidateApproval invalidateApproval = null;
  
  private InvoiceDAO invoiceDAO = null;
  
  private VendorOutboundDAO vendorOutboundDAO = null;

  private PostEvent postEvent = null;

  private ResourceAddressDAO resourceAddressDAO = null;
  
  private ResourceServiceDAO resourceServiceDAO = null;

  private ResourcePhoneDAO resourcePhoneDAO = null;

  private SituationDAO situationDAO = null;
  
  private TodoDAO todoDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private SaveVendorOutbound saveVendorOutbound = null;

  private TodoCommonFunction todoCommonFunction = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  private UpdateFAResource updateFAResource = null;
  
  //STGAP00011971 Add ContractPeriodDAO for call to determine active contract
  private ContractPeriodDAO contractPeriodDAO = null;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setComplexCapsResourceDAO(ComplexCapsResourceDAO complexCapsResourceDAO) {
    this.complexCapsResourceDAO = complexCapsResourceDAO;
  }

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setComplexStagePersonLinkDAO(ComplexStagePersonLinkDAO complexStagePersonLinkDAO) {
    this.complexStagePersonLinkDAO = complexStagePersonLinkDAO;
  }

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setHomeEthnicityDAO(HomeEthnicityDAO homeEthnicityDAO) {
    this.homeEthnicityDAO = homeEthnicityDAO;
  }
  public void setHomeRaceDAO(HomeRaceDAO homeRaceDAO) {
	this.homeRaceDAO = homeRaceDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
    this.invoiceDAO = invoiceDAO;
  }
  
  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }
  
  public void setResourceServiceDAO(ResourceServiceDAO resourceServiceDAO) {
    this.resourceServiceDAO = resourceServiceDAO;
  }

  public void setResourcePhoneDAO(ResourcePhoneDAO resourcePhoneDAO) {
    this.resourcePhoneDAO = resourcePhoneDAO;
  }

  public void setSituationDAO(SituationDAO situationDAO) {
    this.situationDAO = situationDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setSaveVendorOutbound(SaveVendorOutbound saveVendorOutbound) {
    this.saveVendorOutbound = saveVendorOutbound;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setUpdateFAResource(UpdateFAResource updateFAResource) {
    this.updateFAResource = updateFAResource;
  }
  
  public void setVendorOutboundDAO(VendorOutboundDAO vendorOutboundDAO) {
    this.vendorOutboundDAO = vendorOutboundDAO;
  }
  
  public void setContractPeriodDAO(ContractPeriodDAO contractPeriodDAO) {
    this.contractPeriodDAO = contractPeriodDAO;
  }

  public CFAD08SO saveHomeDemographics(CFAD08SI cfad08si) throws ServiceException {
    
    int idResource = cfad08si.getUlIdResource();
  
     

    CFAD08SO cfad08so = new CFAD08SO();
    if (!ServiceConstants.REQ_FUNC_CD_ADD.equals(cfad08si.getArchInputStruct().getCReqFuncCd())) {
      cfad08si.setCSysIndRsrcCharChgNoSvc(ArchitectureConstants.N);
    }
    ROWCFAD08SIG06 rowcfad08sig06 = cfad08si.getROWCFAD08SIG06();
    int idStage = rowcfad08sig06.getUlIdStage();
    cfad08so.setUlIdStage(idStage);
    Person contractWorker = new Person();
    contractWorker.setIdPerson(cfad08si.getUlIdCntrctWkr());
    // Check Stage/Event Status Common Function
    if (idStage != 0) {
      CCMN06UI ccmn06ui = new CCMN06UI();
      ccmn06ui.setArchInputStruct(new ArchInputStruct());
      ccmn06ui.getArchInputStruct().setCReqFuncCd(cfad08si.getArchInputStruct().getCReqFuncCd());
      ccmn06ui.setUlIdStage(idStage);
      ccmn06ui.setSzCdTask(rowcfad08sig06.getSzCdTask());
      // CheckStageEventStatus;
      // this throws an exception that will halt processing with a message if it fails; success is no output.
      checkStageEventStatus.status(ccmn06ui);
    }
    // Retrieve Id Unit in order to populate on Stage
    // CSES73D
    UnitEmpLink unitEmpLink = unitEmpLinkDAO.findUnitEmpLink(rowcfad08sig06.getUlIdPerson(), UNIT_MEMBER_IN_ASSIGNED);
    if (unitEmpLink == null) {
      throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
    }
    int tempIdUnit = unitEmpLink.getUnit().getIdUnit();
    // Create a New Home
    SzCdEventStatus_ARRAY szCdEventStatus_array = cfad08si.getSzCdEventStatus_ARRAY();
    String cdCaseProgram = CodesTables.CSRPGTYP_CPS;
    ROWCFAD08SIG04 rowcfad08sig04 = cfad08si.getROWCFAD08SIG04();
    ArchInputStruct archInputStruct = cfad08si.getArchInputStruct();
    String reqFuncCd = archInputStruct.getCReqFuncCd();
    Date sysDtGenericSysdate = DateHelper.toJavaDate(cfad08si.getDtSysDtGenericSysdate());
    String tempCdEventStatus = szCdEventStatus_array.getSzCdEventStatus(0);
    // check to ensure an empty string or character is not being passed
    // if it is make appropriate corrections
    String cdEventStatus = null;
    if (tempCdEventStatus != null && !tempCdEventStatus.equals("") && tempCdEventStatus.length() > 0) {
      Character cdEventStatus_char = tempCdEventStatus.charAt(0);
      cdEventStatus = cdEventStatus_char.toString();
    }
    int idCase = 0;
    if (cdEventStatus == null) {
      // CREATE A CASE
      CapsCase capsCase = new CapsCase();
      capsCase.setCdCaseProgram(cdCaseProgram);
      capsCase.setCdCaseCounty(cfad08si.getSzCdRsrcCnty());
      capsCase.setCdCaseRegion(rowcfad08sig04.getSzCdRshsRegion());
      capsCase.setDtCaseOpened(sysDtGenericSysdate);
      capsCase.setDtCaseClosed(null);
      capsCase.setNmCase(rowcfad08sig04.getSzNmRshsResource());
      idCase = 0;
      // Only INSERT is supported. Anything else will fail
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
        // get the value of idCase using nextVal
        idCase = commonDAO.getNextval("SEQ_CAPS_CASE");
        capsCaseDAO.insertCapsCaseCdProgramCdCountyCdRegionDtOpenedDtClosed(idCase, capsCase.getNmCase(),
                                                                            capsCase.getCdCaseProgram(),
                                                                            capsCase.getCdCaseCounty(),
                                                                            capsCase.getCdCaseRegion(),
                                                                            capsCase.getDtCaseOpened(),
                                                                            capsCase.getDtCaseClosed());

        // need to ensure that object is in correct state
        capsCase = getPersistentObject(CapsCase.class, idCase);
        
        
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {
        capsCaseDAO.saveCapsCase(capsCase);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {
        capsCaseDAO.deleteCapsCase(capsCase);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      // CREATE A SITUATION - CINT13D
      int idSituation = 0;
      // Only INSERT is supported. Anything else will fail
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
        // return the idSituation
        idSituation = commonDAO.getNextval("SEQ_SITUATION");
        // insert situation
        int numRowsUpdated =
                situationDAO.insertSituationUsingIdCaseDtSituationOpenedDtSituationClosed(idSituation, idCase,
                                                                                          sysDtGenericSysdate, null);
        if (numRowsUpdated == 0)
          throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);

      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      // CREATE STAGE - CINT12D
      int tempIdStage = 0;
      // Only INSERT is supported. Anything else will fail or will not process
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
        // null is being used for String type values that were not populated by the service
        tempIdStage = complexStageDAO.insertStage(0, CodesTables.CSTGTYPE_REG, idCase, null, null,
                                                  null, null, null, null, null, null, cfad08si.getSzCdRsrcCnty(),
                                                  rowcfad08sig04.getSzNmRshsResource(),
                                                  rowcfad08sig04.getSzCdRshsRegion(), sysDtGenericSysdate, idSituation,
                                                  CodesTables.CSRPGTYP_CPS, CodesTables.CSTAGES_FAD, null, tempIdUnit,
                                                  null, null);
        cfad08so.setUlIdStage(tempIdStage);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {
        // null is being used for String type values that were not populated by the service
        // 0 is being used for int type values that were not populated by the service
        complexStageDAO.updateStageAndIncomingDetail(CodesTables.CSTGTYPE_REG, idCase, null, null,
                                                     null, null, null, null, null, null, cfad08si.getSzCdRsrcCnty(),
                                                     rowcfad08sig04.getSzNmRshsResource(),
                                                     rowcfad08sig04.getSzCdRshsRegion(), sysDtGenericSysdate,
                                                     idSituation, CodesTables.CSRPGTYP_CPS, CodesTables.CSTAGES_FAD,
                                                     null, tempIdUnit, 0);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {
        stageDAO.deleteStage(ZERO);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      // SEND TO DO TO PRIMARY WORKER FOR INQUIRY - CSUB40U
      if (ArchitectureConstants.N.equals(rowcfad08sig04.getCIndRshsNonDFCSHome())) {
        CSUB40UI csub40ui = new CSUB40UI();
        CSUB40UIG00 csub40uig00 = new CSUB40UIG00(); // csub40ui.getCSUB40UIG00();
        csub40uig00.setSzSysCdTodoCf(DEMOGRAPHICS_TODO_UPDATE_STATUS);
        csub40uig00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(sysDtGenericSysdate));
        csub40uig00.setUlSysIdTodoCfStage(cfad08so.getUlIdStage());
        csub40uig00.setUlSysIdTodoCfPersAssgn(rowcfad08sig06.getUlIdPerson());
        csub40uig00.setUlSysIdTodoCfPersWkr(rowcfad08sig06.getUlIdPerson());
        csub40uig00.setUlSysIdTodoCfPersCrea(rowcfad08sig06.getUlIdPerson());
        csub40uig00.setSzSysTxtTodoCfDesc(DEMOG_LITERAL_1 + rowcfad08sig04.getSzNmRshsResource() + DEMOG_LITERAL_2);
        csub40uig00.setSzSysTxtTodoCfLongDesc(DEMOG_LONG_LITERAL);
        csub40ui.setCSUB40UIG00(csub40uig00);
        // CSUB40U
        todoCommonFunction.audTodo(csub40ui);
      }
    } else if (cdEventStatus != null && (ArchitectureConstants.Y.equals(cfad08si.getCSysRsrcCntyChg()) ||
                    ArchitectureConstants.Y.equals(cfad08si.getCSysIndRsrcNameChg()))) {
      if (ArchitectureConstants.Y.equals(cfad08si.getCSysRsrcCntyChg())) {
        // cause stage and case tables to be updated if the County Change indicator is true.
        // Retrieve IdCase from Caps Case
        // csec02d
        Stage stage = stageDAO.findStageAndCapsCase(idStage);
        if (stage == null) {
          throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
        }
        int idTemporaryCase = stage.getCapsCase().getIdCase();
        // Update the Region and County on the Case Table
        // caudc0d
        int nbrRowsUpdated = capsCaseDAO
                                        .updateCapsCaseCdStageRegioncCStageCntyByIdCase(
                                                                                        idTemporaryCase,
                                                                                        rowcfad08sig04
                                                                                                      .getSzCdRshsRegion(),
                                                                                        cfad08si.getSzCdRsrcCnty());
        if (nbrRowsUpdated == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
        // Update the Region and County on the Stage Table
        // caudb9d
        nbrRowsUpdated = stageDAO.updateStageCdStageRegioncCStageCntyByIdStage(idStage,
                                                                               rowcfad08sig04.getSzCdRshsRegion(),
                                                                               cfad08si.getSzCdRsrcCnty());
        if (nbrRowsUpdated == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }          
      } 
      // If the Home Name changes, update the Stage and Case Name to the updated name
      if (ArchitectureConstants.Y.equals(cfad08si.getCSysIndRsrcNameChg())) {
        // cause stage and case tables to be updated if the Resource Name Change indicator is true.
        // Retrieve IdCase from Caps Case
        // csec02d
        Stage stage = stageDAO.findStageAndCapsCase(idStage);
        if (stage == null) {
          throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
        }
        int idTemporaryCase = stage.getCapsCase().getIdCase();
        // Update the Case name on the Case Table
        int nbrRowsUpdated = capsCaseDAO.updateCapsCaseNmCase(idTemporaryCase, rowcfad08sig04.getSzNmRshsResource());
        if (nbrRowsUpdated == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
        // Update the Stage name on the Stage Table
        nbrRowsUpdated = stageDAO.updateStageNmStage(rowcfad08sig04.getSzNmRshsResource(), idStage);
        if (nbrRowsUpdated == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      }
    } 
    
    CCMN01UI ccmn01ui = new CCMN01UI();
    ccmn01ui.setArchInputStruct(archInputStruct);
    
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
     
    rowccmn01uig00.setSzCdTask(rowcfad08sig06.getSzCdTask());

    rowccmn01uig00.setSzCdEventType(rowcfad08sig06.getSzCdEventType());
    rowccmn01uig00.setSzTxtEventDescr(rowcfad08sig06.getSzTxtEventDescr());
    if (idStage == 0) {
      rowccmn01uig00.setUlIdStage(cfad08so.getUlIdStage());
    } else {
      rowccmn01uig00.setUlIdStage(idStage);
    }
      
    rowccmn01uig00.setUlIdPerson(rowcfad08sig06.getUlIdPerson());
    rowccmn01uig00.setSzCdEventStatus(rowcfad08sig06.getSzCdEventStatus());
    rowccmn01uig00.setDtDtEventOccurred(rowcfad08sig06.getDtDtEventOccurred());
    // set rowccmn01uig00 into ccmn01ui
    ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      // Retrieve all principals for the INV stage.
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    CCMN01UO ccmn01uo = new CCMN01UO();
    // ccmn01u
    ccmn01uo = postEvent.postEvent(ccmn01ui);
    TsLastUpdate_ARRAY tsLastUpdate_array = new TsLastUpdate_ARRAY();
    if (cfad08so.getTsLastUpdate_ARRAY() != null){
      tsLastUpdate_array = cfad08so.getTsLastUpdate_ARRAY();
    }
    
    if(!cfad08si.isIsApprovalMode() 
    	|| ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)){
      cfad08so.setUlIdEvent(ccmn01uo.getUlIdEvent());
      tsLastUpdate_array.addTsLastUpdate(TS_EVENT, ccmn01uo.getTsLastUpdate());
      
      // MR-075 Not an ADD then it's an update in modify page mode
      // invalidate current pending event.
      if(!ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)
                      && tempCdEventStatus != null
                      && CodesTables.CEVTSTAT_PEND.equals(tempCdEventStatus)){

        CapsResource capsResource = getPersistentObject(CapsResource.class, cfad08si.getUlIdResource());
        Event faHomeEvent = capsResource.getEvent();

        // Invalidate approval event
        ArchInputStruct ccmn05ui_archInputStruct = new ArchInputStruct();
        ccmn05ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
        ccmn05ui_archInputStruct.setUlSysNbrReserved1(archInputStruct.getUlSysNbrReserved1());

        CCMN05UI ccmn05ui = new CCMN05UI();
        ccmn05ui.setArchInputStruct(ccmn05ui_archInputStruct);
        ccmn05ui.setUlIdEvent(faHomeEvent.getIdEvent());
        invalidateApproval.invalidateApproval(ccmn05ui);

        // set event status to COMP
        CCMN01UI ccmn01ui_current = new CCMN01UI();
        ROWCCMN01UIG00 rowccmn01uig00_current = new ROWCCMN01UIG00();

        ccmn01ui_current.setArchInputStruct(ccmn05ui_archInputStruct);
        
        rowccmn01uig00_current.setUlIdEvent(faHomeEvent.getIdEvent());
        rowccmn01uig00_current.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
        rowccmn01uig00_current.setDtDtEventOccurred(DateHelper.toCastorDate(faHomeEvent.getDtEventOccurred()));
        rowccmn01uig00_current.setSzCdEventType(faHomeEvent.getCdEventType());
        rowccmn01uig00_current.setUlIdStage(faHomeEvent.getStage().getIdStage());
        rowccmn01uig00_current.setUlIdPerson(faHomeEvent.getPerson().getIdPerson());
        rowccmn01uig00_current.setSzCdTask(faHomeEvent.getCdTask());
        rowccmn01uig00_current.setSzTxtEventDescr(faHomeEvent.getTxtEventDescr());
        rowccmn01uig00_current.setTsLastUpdate(faHomeEvent.getDtLastUpdate());
        ccmn01ui_current.setROWCCMN01UIG00(rowccmn01uig00_current);
        postEvent.postEvent(ccmn01ui_current);
      }
    }else{
      // In approval mode, we will keep the current fa home event
      CapsResource capsResource = getPersistentObject(CapsResource.class, cfad08si.getUlIdResource());
      Event faHomeEvent = capsResource.getEvent();
      cfad08so.setUlIdEvent(faHomeEvent.getIdEvent());
      tsLastUpdate_array.addTsLastUpdate(TS_EVENT, faHomeEvent.getDtLastUpdate());
    }
    // set this into cfad08so
    cfad08so.setTsLastUpdate_ARRAY(tsLastUpdate_array);
    
    // Assign to Worker
    if (cdEventStatus == null) {
      // ccmnd3d
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
        // null is being used for String type values that were not populated by the service
        Date lastUpdated = complexStagePersonLinkDAO.addStageToWorker(cfad08so.getUlIdStage(),
                                                                      rowcfad08sig06.getUlIdPerson(),
                                                                      CodesTables.CROLEALL_PR,
                                                                      CodesTables.CPRSNALL_STF, null, null,
                                                                      sysDtGenericSysdate, null, null, null,
                                                                      "1", null);
        if (lastUpdated == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {
        stagePersonLinkDAO.deleteStagePersonLinkByIdStageCdStagePersRole(cfad08so.getUlIdStage());
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)){
      Integer idSupervisor = unitEmpLinkDAO.findUnitSupervisorByIdPerson(rowcfad08sig06.getUlIdPerson());
      if (idSupervisor == null){
        idSupervisor = rowcfad08sig06.getUlIdPerson();
      }
      reassignAvailableCaseManager(cfad08so.getUlIdEvent(), idCase, cfad08so.getUlIdStage(), rowcfad08sig06.getUlIdPerson(),new Date(),
                                   cfad08si.getROWCFAD08SIG04().getSzNmRshsResource(), idSupervisor);
      followUpTenDays(cfad08so.getUlIdEvent(), idCase, cfad08so.getUlIdStage(), rowcfad08sig06.getUlIdPerson(),new Date()
                      ,cfad08si.getROWCFAD08SIG04().getSzNmRshsResource(), rowcfad08sig06.getUlIdPerson());
    }
    // Create/Update CAPS Resource
    if (cdEventStatus == null) {
      String cdRsrcCategory = rowcfad08sig04.getSzCdRshsCategory();
      String cdRsrcEthnicity = rowcfad08sig04.getSzCdRshsEthnicity();
      String cdRsrcFacilType = null;
      if (ArchitectureConstants.Y.equals(rowcfad08sig04.getCIndRshsNonDFCSHome())) {
        cdRsrcFacilType = CodesTables.CFACTYP4_71;
      } else {
        cdRsrcFacilType = CodesTables.CFACTYP4_70;
      }
      String cdRsrcLanguage = rowcfad08sig04.getSzCdRshsLanguage();
      String cdRsrcMaritalStatus = rowcfad08sig04.getSzCdRshsMaritalStatus();
      String cdRsrcFaHomeStatus = rowcfad08sig04.getSzCdRshsFaHomeStatus();
      String cdRsrcRespite = rowcfad08sig04.getSzCdRshsRespite();
      String cdRsrcType = CodesTables.CRSCTYPE_06;
      String indRsrcNonDFCSHome = rowcfad08sig04.getCIndRshsNonDFCSHome();
      // Original value in input object is double, but casting to int to satisfy DAO
      int nbrRsrcAnnualIncome = (int) rowcfad08sig04.getDNbrRshsAnnualIncome();
      String cdRsrcRegion = rowcfad08sig04.getSzCdRshsRegion();
      String cdCertifyEntity = rowcfad08sig04.getSzTxtNdfcsCertEntity();
      String cdRsrcMaintainer = rowcfad08sig04.getSzCdRshsRegion();
      String cdRsrcReligion = rowcfad08sig04.getSzCdRshsReligion();
      Date dtRsrcMarriage = DateHelper.toJavaDate(rowcfad08sig04.getDtDtRshsMarriage());
      int idRsrcFaHomeEvent = cfad08so.getUlIdEvent();
      int idRsrcFaHomeStage = cfad08so.getUlIdStage();
      String indRsrcCareProv = rowcfad08sig04.getCIndRshsCareProv();
      ROWCFAD08SIG05 rowcfad08sig05 = cfad08si.getROWCFAD08SIG05();
      String indRsrcEmergPlace = rowcfad08sig05.getCIndRsrcEmergPlace();
      String indRsrcTransport = rowcfad08sig05.getCIndRsrcTransport();
      String indRsrcCurrHomeStudy = rowcfad08sig04.getCIndCurrHomeStudyExists();
      // adding new fields for SHINES
      String indPrevFamStdyRqstd = rowcfad08sig04.getCIndPrevFamilyStudyReq();
      String cdSchDist = rowcfad08sig04.getSzCdSchoolDistrict();
      String cdElem = rowcfad08sig04.getSzCdElementary();
      String cdMiddle = rowcfad08sig04.getSzCdMiddle();
      String cdHigh = rowcfad08sig04.getSzCdHigh();
      String cdExchangeStat = rowcfad08sig04.getSzCdAdExchangeStatus();
      String nmLegal = rowcfad08sig04.getSzNmLegal();
      String indWaiver = rowcfad08sig04.getCIndWaiver();
      // For adding a home, write a history record
      String indRsrcWriteHist = ArchitectureConstants.Y;
      String indSpecificChild = rowcfad08sig05.getCIndSpecificChild();
      int nbrRsrcIntFeAgeMax = rowcfad08sig05.getUNbrRsrcIntFeAgeMax();
      int nbrRsrcIntFeAgeMin = rowcfad08sig05.getUNbrRsrcIntFeAgeMin();
      int nbrRsrcIntMaAgeMax = rowcfad08sig05.getUNbrRsrcIntMaAgeMax();
      int nbrRsrcIntMaAgeMin = rowcfad08sig05.getUNbrRsrcIntMaAgeMin();
      String nmRsrcResource = rowcfad08sig04.getSzNmRshsResource();
      String nmRsrcLastUpdate = archInputStruct.getSzUserId();
      String txtRsrcComments = rowcfad08sig05.getSzTxtRsrcComments();
      String txtHmPrgInterest = rowcfad08sig05.getTxtHmPrgInterest();
      boolean indRsrcPrsChg = false;
      if (ArchitectureConstants.Y.equals(cfad08si.getCSysIndRsrcPrsChg())) {
        indRsrcPrsChg = true;
      }
      // caud55d
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
        // null is being used for String type values that were not populated by the service
        // 0 is being used for int type values that were not populated by the service
        idResource = complexCapsResourceDAO.insertCapsResourceForPrsAndNonPrsHome(null, null, null, null, null,
                                                                                      null, null, null, null,
                                                                                      cdRsrcType, null,
                                                                                      cdRsrcMaintainer, null, null,
                                                                                      cdRsrcFacilType, null, null,
                                                                                      null, null, cdRsrcCategory,
                                                                                      cdRsrcEthnicity, cdRsrcLanguage,
                                                                                      cdRsrcMaritalStatus, null,
                                                                                      cdRsrcRegion, cdRsrcReligion,
                                                                                      cdRsrcRespite,
                                                                                      cdRsrcFaHomeStatus, null, null,
                                                                                      null, null, null, null, null,
                                                                                      dtRsrcMarriage,
                                                                                      null, null, idRsrcFaHomeStage,
                                                                                      idRsrcFaHomeEvent,
                                                                                      indRsrcWriteHist,
                                                                                      indRsrcCareProv,
                                                                                      indRsrcEmergPlace, null,
                                                                                      indRsrcTransport,
                                                                                      indRsrcCurrHomeStudy,
                                                                                      indRsrcNonDFCSHome,
                                                                                      cdCertifyEntity,
                                                                                      nmRsrcLastUpdate, nmRsrcResource,
                                                                                      null, null, null, 0, 0, null, 0,
                                                                                      indSpecificChild,
                                                                                      nbrRsrcIntFeAgeMax,
                                                                                      nbrRsrcIntFeAgeMin,
                                                                                      nbrRsrcIntMaAgeMax,
                                                                                      nbrRsrcIntMaAgeMin,
                                                                                      nbrRsrcAnnualIncome, 0, 0, 0, 0,
                                                                                      0, null, txtRsrcComments,
                                                                                      indPrevFamStdyRqstd, cdSchDist,
                                                                                      cdElem, cdMiddle, cdHigh,
                                                                                      cdExchangeStat, indWaiver, nmLegal, txtHmPrgInterest,
                                                                                      ServiceConstants.FND_YES);
        if (idResource == 0) {
          throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
        } else {
          cfad08so.setUlIdResource(idResource);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {
        // null is being used for String type values that were not populated by the service
        // 0 is being used for int type values that were not populated by the service
        int nbrRowsUpdated = complexCapsResourceDAO.updateCapsResourceForPrsAndNonPrsHome(indRsrcPrsChg, 0, null, null,
                                                                                          null, null, null, null, null,
                                                                                          null, null, cdRsrcType, null,
                                                                                          cdRsrcMaintainer, null, null,
                                                                                          cdRsrcFacilType, null, null,
                                                                                          null, null, null,
                                                                                          cdRsrcCategory,
                                                                                          cdRsrcEthnicity,
                                                                                          cdRsrcLanguage,
                                                                                          cdRsrcMaritalStatus, null,
                                                                                          cdRsrcRegion, cdRsrcReligion,
                                                                                          cdRsrcRespite,
                                                                                          cdRsrcFaHomeStatus, null,
                                                                                          null, null, null, null, null,
                                                                                          null,
                                                                                          dtRsrcMarriage, null, null,
                                                                                          idRsrcFaHomeStage,
                                                                                          idRsrcFaHomeEvent,
                                                                                          indRsrcWriteHist,
                                                                                          indRsrcCareProv,
                                                                                          indRsrcEmergPlace, null,
                                                                                          indRsrcTransport,
                                                                                          indRsrcCurrHomeStudy,
                                                                                          indRsrcNonDFCSHome,
                                                                                          cdCertifyEntity,
                                                                                          nmRsrcLastUpdate,
                                                                                          nmRsrcResource, null, null,
                                                                                          null, 0, 0, null, 0,
                                                                                          indSpecificChild,
                                                                                          nbrRsrcIntFeAgeMax,
                                                                                          nbrRsrcIntFeAgeMin,
                                                                                          nbrRsrcIntMaAgeMax,
                                                                                          nbrRsrcIntMaAgeMin,
                                                                                          nbrRsrcAnnualIncome, 0, 0, 0,
                                                                                          0, 0, null, txtRsrcComments,
                                                                                          null, indPrevFamStdyRqstd,
                                                                                          cdSchDist, cdElem, cdMiddle,
                                                                                          cdHigh, cdExchangeStat,
                                                                                          indWaiver, nmLegal, txtHmPrgInterest);
        if (nbrRowsUpdated == 0) {
          throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {
        CapsResource capsResource = new CapsResource();
        capsResourceDAO.deleteCapsResource(capsResource);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    } else {
    // STGAP00013543 Set the resource Name since the HOme Name can now be changed.  
      String nmRsrcResource = rowcfad08sig04.getSzNmRshsResource();
      String cdRsrcEthnicity = rowcfad08sig04.getSzCdRshsEthnicity();
      String cdRsrcLanguage = rowcfad08sig04.getSzCdRshsLanguage();
      String cdRsrcReligion = rowcfad08sig04.getSzCdRshsReligion();
      String cdRsrcMaritalStatus = rowcfad08sig04.getSzCdRshsMaritalStatus();
      String cdRsrcFaHomeStatus = rowcfad08sig04.getSzCdRshsFaHomeStatus();
      String cdRsrcRespite = rowcfad08sig04.getSzCdRshsRespite();
      Date dtRsrcMarriage = DateHelper.toJavaDate(rowcfad08sig04.getDtDtRshsMarriage());
      int idRsrcFaHomeEvent = cfad08so.getUlIdEvent();
      idResource = cfad08si.getUlIdResource();
      // set resource id into output object
      cfad08so.setUlIdResource(idResource);
      String indRsrcCareProv = rowcfad08sig04.getCIndRshsCareProv();
      ROWCFAD08SIG05 rowcfad08sig05 = cfad08si.getROWCFAD08SIG05();
      String indRsrcEmergPlace = rowcfad08sig05.getCIndRsrcEmergPlace();
      String indRsrcNonDfcs = rowcfad08sig04.getCIndRshsNonDFCSHome();
      String cdCertifyEntity = rowcfad08sig04.getSzTxtNdfcsCertEntity();
      // adding new fields for SHINES
      String cdPrevHomeStudy = rowcfad08sig04.getCIndPrevFamilyStudyReq();
      String cdSchoolDistrict = rowcfad08sig04.getSzCdSchoolDistrict();
      String cdElementary = rowcfad08sig04.getSzCdElementary();
      String cdMiddle = rowcfad08sig04.getSzCdMiddle();
      String cdHigh = rowcfad08sig04.getSzCdHigh();
      String cdAdExchangeStat = rowcfad08sig04.getSzCdAdExchangeStatus();
      String indWaiverExists = rowcfad08sig04.getCIndWaiver();
      String nmLegal = rowcfad08sig04.getSzNmLegal();
      String cdRsrcFacilType = null;
      if (ArchitectureConstants.Y.equals(rowcfad08sig04.getCIndRshsNonDFCSHome())) {
        cdRsrcFacilType = CodesTables.CFACTYP4_71;
      } else {
        cdRsrcFacilType = CodesTables.CFACTYP4_70;
      }
      // Original value in input object is double, but casting to int to satisfy DAO
      int nbrRsrcAnnualIncome = (int) rowcfad08sig04.getDNbrRshsAnnualIncome();
      String indRsrcTransport = rowcfad08sig05.getCIndRsrcTransport();
      String indCurrHmStdyExsts = rowcfad08sig04.getCIndCurrHomeStudyExists();
      // For adding a home, write a history record
      // changed to No instead of Yes
      String indRsrcWriteHist = ArchitectureConstants.N;
      String indSpecificChild = rowcfad08sig05.getCIndSpecificChild();
      int nbrRsrcIntFeAgeMax = rowcfad08sig05.getUNbrRsrcIntFeAgeMax();
      int nbrRsrcIntFeAgeMin = rowcfad08sig05.getUNbrRsrcIntFeAgeMin();
      int nbrRsrcIntMaAgeMax = rowcfad08sig05.getUNbrRsrcIntMaAgeMax();
      int nbrRsrcIntMaAgeMin = rowcfad08sig05.getUNbrRsrcIntMaAgeMin();
      int nbrRsrcFMAgeMax = rowcfad08sig05.getUNbrRsrcFMAgeMax();
      int nbrRsrcFMAgeMin = rowcfad08sig05.getUNbrRsrcFMAgeMin();
      int nbrRsrcMlAgeMax = rowcfad08sig05.getUNbrRsrcMlAgeMax();
      int nbrRsrcMlAgeMin = rowcfad08sig05.getUNbrRsrcMlAgeMin();
      String txtRsrcComments = rowcfad08sig05.getSzTxtRsrcComments();
      String txtHmPrgInterest = rowcfad08sig05.getTxtHmPrgInterest();
      boolean indRsrcPrsChg = false;
      if (ArchitectureConstants.Y.equals(cfad08si.getCSysIndRsrcPrsChg())) {
        indRsrcPrsChg = true;
      }
      // Also copy in the Resource Region and
      // Resource Maintainer as they need to be updated as well.
      String newCounty = cfad08si.getSzCdRsrcCnty();
      String cdRsrcRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, newCounty);
      String cdRsrcMaintainer = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, newCounty);
      Date dtLastUpdate = rowcfad08sig04.getTsLastUpdate();
      // caud58d
      if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {
        int nbrRowsUpdated = complexCapsResourceDAO.updateCapsResource(nmRsrcResource, indRsrcPrsChg, cdRsrcEthnicity, cdRsrcLanguage,
                                                                       cdRsrcMaritalStatus, cdRsrcReligion,
                                                                       cdRsrcRespite, cdRsrcFacilType, dtRsrcMarriage,
                                                                       idRsrcFaHomeEvent, indRsrcCareProv,
                                                                       indRsrcEmergPlace, indCurrHmStdyExsts,
                                                                       indRsrcNonDfcs, cdCertifyEntity,
                                                                       cdRsrcFaHomeStatus, cdRsrcMaintainer,
                                                                       cdRsrcRegion, indRsrcTransport,
                                                                       indRsrcWriteHist, nbrRsrcAnnualIncome,
                                                                       indSpecificChild, nbrRsrcFMAgeMin,
                                                                       nbrRsrcFMAgeMax, nbrRsrcIntFeAgeMax,
                                                                       nbrRsrcIntFeAgeMin, nbrRsrcIntMaAgeMin,
                                                                       nbrRsrcIntMaAgeMax, nbrRsrcMlAgeMin,
                                                                       nbrRsrcMlAgeMax, txtRsrcComments, null,
                                                                       idResource, dtLastUpdate, cdPrevHomeStudy,
                                                                       cdSchoolDistrict, cdElementary, cdMiddle,
                                                                       cdHigh, cdAdExchangeStat, indWaiverExists, nmLegal, txtHmPrgInterest);
        
        
        //STGAP00011971 Perform Vendor Outbound if no resource or phone updates
        if (nbrRowsUpdated !=0)
        {
           
          //STGAP00011971 added call to determine if there is an active contract
          int intNumberContracts = 0;
          List<ContractPeriod> contractPeriodList = new ArrayList<ContractPeriod>(); 
          contractPeriodList = contractPeriodDAO.findListOfContractPeriodByIdResource(idResource); 
          intNumberContracts = contractPeriodList != null ? contractPeriodList.size() : 0;
          
          //Active resource with active contract
          boolean bActiveContract = ((ACTIVE_HOME.equals(cdRsrcFaHomeStatus)||ACTIVE_TEMP_HOME.equals(cdRsrcFaHomeStatus)||
                          ACTIVE_HOME_30_DAY.equals(cdRsrcFaHomeStatus) || ACTIVE_SPECIAL_HOME_30_DAY.equals(cdRsrcFaHomeStatus) ||
                          ACTIVE_SPECIAL_HOME.equals(cdRsrcFaHomeStatus)) && (intNumberContracts >0));
          
        //Determine whether there is a current sent transaction without reply
          int iOpenRsrcSentToSml = 0;
          iOpenRsrcSentToSml = vendorOutboundDAO.isCurrentRsrcSntToSmile(idResource) != null ? vendorOutboundDAO.isCurrentRsrcSntToSmile(idResource) : 0;
          
          String vendorID = resourceAddressDAO.findResourceAddressVID(idResource);          
          int vendorLength = 0;
          if(vendorID == null)
            vendorLength = 0;
          else
            vendorLength = vendorID.length();
          
          //STGAP00011971 - Send Vendor Outbound if no registration row exists for empty VID, or for name update
          if ((indRsrcPrsChg && bActiveContract)||(bActiveContract && (vendorLength==0) && (iOpenRsrcSentToSml==0))){
          
            VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
            vendorOutboundSI.setRsrcNameFlag(true);
            vendorOutboundSI.setIdResource(idResource);            
            vendorOutboundSI.setNmResource(nmLegal);
            vendorOutboundSI.setDtRsrcUpdated(new Date());
            int idRsrcAddress = resourceAddressDAO.findIdResourceAddressByAddressTypeOnly(idResource);
            vendorOutboundSI.setIdRsrcAddr(idRsrcAddress);
            vendorOutboundSI.setUserId(cfad08si.getUlIdCntrctWkr() != 0 ? cfad08si.getUlIdCntrctWkr() : 0);
            saveVendorOutbound.saveNewVendor(vendorOutboundSI);  
          }
        }
        
        
        if (nbrRowsUpdated == 0) {
          throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
        }
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    // load capsresource into state
    CapsResource capsResource = getPersistentObject(CapsResource.class, cfad08so.getUlIdResource());
    // Add / Update / Delete Resource Address
    // Update address in 3 seperate ways.
    // First perform all deletes, then perform all updates, then all adds.
    // This is due to the trigger from RESOURCE_ADDRESS to CAPS_RESOURCE.
    // Previously, changing (UPDATE) a Primary Address to Business and also
    // adding a new Primary Address (ADD) was causing the trigger to set
    // CAPS_RESOURCE Address values to NULL. By performing all Updates and
    // Deletes first, we can alleviate the problem.
    ROWCFAD08SIG01_ARRAY rowcfad08sig01_array = cfad08si.getROWCFAD08SIG01_ARRAY();
    if (rowcfad08sig01_array != null && rowcfad08sig01_array.getROWCFAD08SIG01Count() > 0) {
      for (int i = 0; i < rowcfad08sig01_array.getROWCFAD08SIG01Count(); i++) {
        ROWCFAD08SIG01 rowcfad08sig01 = rowcfad08sig01_array.getROWCFAD08SIG01(i);
        if (rowcfad08sig01 != null
            && ServiceConstants.REQ_FUNC_CD_DELETE.equals(rowcfad08sig01.getSzCdSysDataActionOutcome())) {
          // load into state and delete
         
          ResourceAddress resourceAddress = getPersistentObject(ResourceAddress.class,
                                                                rowcfad08sig01.getUlIdRsrcAddress());

          resourceAddressDAO.deleteResourceAddress(resourceAddress);
        }
      }

      for (int i = 0; i < rowcfad08sig01_array.getROWCFAD08SIG01Count(); i++) {
        ROWCFAD08SIG01 rowcfad08sig01 = rowcfad08sig01_array.getROWCFAD08SIG01(i);
        if (rowcfad08sig01 != null
            && ServiceConstants.REQ_FUNC_CD_ADD.equals(rowcfad08sig01.getSzCdSysDataActionOutcome())) {
          ResourceAddress resourceAddress = new ResourceAddress();
          resourceAddress.setIdRsrcAddress(0);
          resourceAddress.setCapsResource(capsResource);
          resourceAddress.setAddrRsrcAddrAttn(rowcfad08sig01.getSzAddrRsrcAddrAttn());
          resourceAddress.setAddrRsrcAddrCity(rowcfad08sig01.getSzAddrRsrcAddrCity());
          resourceAddress.setAddrRsrcAddrStLn1(rowcfad08sig01.getSzAddrRsrcAddrStLn1());
          resourceAddress.setAddrRsrcAddrStLn2(rowcfad08sig01.getSzAddrRsrcAddrStLn2());
          resourceAddress.setAddrRsrcAddrZip(rowcfad08sig01.getSzAddrRsrcAddrZip());
          resourceAddress.setCdRsrcAddrCounty(rowcfad08sig01.getSzCdFacilityCounty());
          resourceAddress.setCdRsrcAddrState(rowcfad08sig01.getSzCdFacilityState());
          resourceAddress.setCdRsrcAddrType(rowcfad08sig01.getSzCdRsrcAddrType());
          resourceAddress.setNbrRsrcAddrVid(rowcfad08sig01.getSzNbrRsrcAddrVid());
          resourceAddress.setTxtRsrcAddrComments(rowcfad08sig01.getSzTxtRsrcAddrComments());
          resourceAddress.setDtLastUpdate(rowcfad08sig01.getTsLastUpdate());
          resourceAddress.setIdRsrcAddress(rowcfad08sig01.getUlIdRsrcAddress());
          resourceAddress.setNbrRsrcAddrLat(rowcfad08sig01.getNbrRsrcAddrLat());
          resourceAddress.setNbrRsrcAddrLong(rowcfad08sig01.getNbrRsrcAddrLong());
          resourceAddressDAO.saveResourceAddress(resourceAddress);

          if (resourceAddress.getIdRsrcAddress() == ZERO) {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }
        } else if (rowcfad08sig01 != null
                   && ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rowcfad08sig01.getSzCdSysDataActionOutcome())) {
          ResourceAddress resourceAddress = getPersistentObject(ResourceAddress.class,
                                                                rowcfad08sig01.getUlIdRsrcAddress());
          resourceAddress.setCapsResource(capsResource);
          resourceAddress.setAddrRsrcAddrAttn(rowcfad08sig01.getSzAddrRsrcAddrAttn());
          resourceAddress.setAddrRsrcAddrCity(rowcfad08sig01.getSzAddrRsrcAddrCity());
          resourceAddress.setAddrRsrcAddrStLn1(rowcfad08sig01.getSzAddrRsrcAddrStLn1());
          resourceAddress.setAddrRsrcAddrStLn2(rowcfad08sig01.getSzAddrRsrcAddrStLn2());
          resourceAddress.setAddrRsrcAddrZip(rowcfad08sig01.getSzAddrRsrcAddrZip());
          resourceAddress.setCdRsrcAddrCounty(rowcfad08sig01.getSzCdFacilityCounty());
          resourceAddress.setCdRsrcAddrState(rowcfad08sig01.getSzCdFacilityState());
          resourceAddress.setCdRsrcAddrType(rowcfad08sig01.getSzCdRsrcAddrType());
          resourceAddress.setNbrRsrcAddrVid(rowcfad08sig01.getSzNbrRsrcAddrVid());
          resourceAddress.setTxtRsrcAddrComments(rowcfad08sig01.getSzTxtRsrcAddrComments());
          resourceAddress.setDtLastUpdate(rowcfad08sig01.getTsLastUpdate());
          resourceAddress.setIdRsrcAddress(rowcfad08sig01.getUlIdRsrcAddress());
          resourceAddress.setNbrRsrcAddrLat(rowcfad08sig01.getNbrRsrcAddrLat());
          resourceAddress.setNbrRsrcAddrLong(rowcfad08sig01.getNbrRsrcAddrLong());
          
          // STGAP00017058 - if the vendorID has been changed, update the resource address and invoice records for resource
          if (resourceAddress.getNbrRsrcAddrVid() != null && ServiceConstants.FND_YES.equals(cfad08si.getBIndReview())){
            List<ResourceAddress> resourceAddressList = resourceAddressDAO.findResourceAddressByIdResource(resourceAddress.getCapsResource().getIdResource());
            for(ResourceAddress resourceAddr : resourceAddressList){
              resourceAddr.setNbrRsrcAddrVid(rowcfad08sig01.getSzNbrRsrcAddrVid());
              resourceAddressDAO.saveResourceAddress(resourceAddr);
              invoiceDAO.updateInvoiceNbrInvoVid(resourceAddr.getNbrRsrcAddrVid(), resourceAddr.getIdRsrcAddress());
            }
          }

          /*
           * code added by Srinivas when home address is modified if the address is primary type and home does not have
           * vendor ID, the information need to send to VendorOutbound table after checking whether home is approved or
           * not . If Vendor is existing then we need to send the information to VendorOutbound table, Incase of
           * VendorID is available we don't need to check for event status
           */

          String vendorID = rowcfad08sig01.getSzNbrRsrcAddrVid();
          String addrType = rowcfad08sig01.getSzCdRsrcAddrType();

          if (vendorID.length() > 0 && addrType.equalsIgnoreCase("01")) {

            VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
            vendorOutboundSI
                            .setAddrRsrcStLn1(rowcfad08sig01.getSzAddrRsrcAddrStLn1() != null ? rowcfad08sig01
                                                                                                              .getSzAddrRsrcAddrStLn1()
                                                                                             : "");
            vendorOutboundSI
                            .setAddrRsrcStLn2(rowcfad08sig01.getSzAddrRsrcAddrStLn2() != null ? rowcfad08sig01
                                                                                                              .getSzAddrRsrcAddrStLn2()
                                                                                             : "");
            vendorOutboundSI
                            .setAddrRsrcCity(rowcfad08sig01.getSzAddrRsrcAddrCity() != null ? rowcfad08sig01
                                                                                                            .getSzAddrRsrcAddrCity()
                                                                                           : "");
            vendorOutboundSI
                            .setAddrRsrcZip(rowcfad08sig01.getSzAddrRsrcAddrZip() != null ? rowcfad08sig01
                                                                                                          .getSzAddrRsrcAddrZip()
                                                                                         : "");
            vendorOutboundSI
                            .setCdRsrcState(rowcfad08sig01.getSzCdFacilityState() != null ? rowcfad08sig01
                                                                                                          .getSzCdFacilityState()
                                                                                         : "");
            vendorOutboundSI
                            .setAddrRsrcZip(rowcfad08sig01.getSzAddrRsrcAddrZip() != null ? rowcfad08sig01
                                                                                                          .getSzAddrRsrcAddrZip()
                                                                                         : "");
            vendorOutboundSI
                            .setIdRsrcAddr(rowcfad08sig01.getUlIdRsrcAddress() != 0 ? rowcfad08sig01
                                                                                                    .getUlIdRsrcAddress()
                                                                                   : 0);
            vendorOutboundSI.setIdResource(cfad08so.getUlIdResource() != 0 ? cfad08so.getUlIdResource() : 0);
            vendorOutboundSI.setUserId(cfad08si.getUlIdCntrctWkr() != 0 ? cfad08si.getUlIdCntrctWkr() : 0);
            vendorOutboundSI.setDtRsrcUpdated(new Date());
            vendorOutboundSI.setAddressFlag(true);
            saveVendorOutbound.saveNewVendor(vendorOutboundSI);

          } else {

            int uIdStage = cfad08so.getUlIdStage();
            if (uIdStage != 0) {
              CapsResource resource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(uIdStage);
              if (resource != null) {

                String eventStatus = resource.getCdRsrcFaHomeStatus();
                
                //STGAP00011971 - Only perform Vendor Outbound if an update and active contract
                
                int intNumberContracts = 0;
                List<ContractPeriod> contractPeriodList = new ArrayList<ContractPeriod>(); 
                contractPeriodList = contractPeriodDAO.findListOfContractPeriodByIdResource(idResource); 
                intNumberContracts = contractPeriodList != null ? contractPeriodList.size() : 0;
                
                boolean bActiveContract = ((ACTIVE_HOME.equals(eventStatus)||ACTIVE_TEMP_HOME.equals(eventStatus)||
                                ACTIVE_HOME_30_DAY.equals(eventStatus) || ACTIVE_SPECIAL_HOME_30_DAY.equals(eventStatus) ||
                                ACTIVE_SPECIAL_HOME.equals(eventStatus)) && (intNumberContracts >0));
                
                if (bActiveContract&&ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rowcfad08sig01.getSzCdSysDataActionOutcome())) {

                  VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
                  vendorOutboundSI.setAddrRsrcStLn1(rowcfad08sig01.getSzAddrRsrcAddrStLn1() != null ? rowcfad08sig01.getSzAddrRsrcAddrStLn1(): "");
                  vendorOutboundSI.setAddrRsrcStLn2(rowcfad08sig01.getSzAddrRsrcAddrStLn2() != null ? rowcfad08sig01.getSzAddrRsrcAddrStLn2(): "");
                  vendorOutboundSI.setAddrRsrcCity(rowcfad08sig01.getSzAddrRsrcAddrCity() != null ? rowcfad08sig01.getSzAddrRsrcAddrCity(): "");
                  vendorOutboundSI.setAddrRsrcZip(rowcfad08sig01.getSzAddrRsrcAddrZip() != null ? rowcfad08sig01.getSzAddrRsrcAddrZip(): "");
                  vendorOutboundSI.setCdRsrcState(rowcfad08sig01.getSzCdFacilityState() != null ? rowcfad08sig01.getSzCdFacilityState(): "");
                  vendorOutboundSI.setAddrRsrcZip(rowcfad08sig01.getSzAddrRsrcAddrZip() != null ? rowcfad08sig01.getSzAddrRsrcAddrZip(): "");
                  vendorOutboundSI.setIdRsrcAddr(rowcfad08sig01.getUlIdRsrcAddress() != 0 ? rowcfad08sig01.getUlIdRsrcAddress(): 0);
                  vendorOutboundSI.setIdResource(cfad08so.getUlIdResource() != 0 ? cfad08so.getUlIdResource() : 0);
                  vendorOutboundSI.setUserId(cfad08si.getUlIdCntrctWkr() != 0 ? cfad08si.getUlIdCntrctWkr() : 0);
                  vendorOutboundSI.setDtRsrcUpdated(new Date());
                  vendorOutboundSI.setAddressFlag(true);
                  saveVendorOutbound.saveNewVendor(vendorOutboundSI);
                }

              }
            }
          }
          resourceAddressDAO.saveResourceAddress(resourceAddress);
          
          // SMS79227
          // After the resource address is modified, check the updated county and see if there are services
          // for this resource in the new county.
          // Add resource_services and contract_county
          String cdNewCounty = rowcfad08sig01.getSzCdFacilityCounty();
          if(!cdNewCounty.equals(capsResource.getCdRsrcCnty())){
          addResourceServices(idResource, cdNewCounty);
          }
          
          List<Object[]> contractServicesList = contractCountyDAO.findContractServices(idResource, cdNewCounty);
          if (contractServicesList != null && !contractServicesList.isEmpty()) {
            for (Iterator<Object[]> it = contractServicesList.iterator(); it.hasNext();) {
              Object[] contractServicesListItem = it.next();
              BigDecimal bigIdContract = (BigDecimal) contractServicesListItem[1];
              int idContract = bigIdContract.intValue();
              Date dtCnverEff = (Date) contractServicesListItem[2];
              Date dtCnverEnd = (Date) contractServicesListItem[3];
              BigDecimal nbrCnsvcPeriod = (BigDecimal) contractServicesListItem[4];
              BigDecimal nbrCnsvcVersion = (BigDecimal) contractServicesListItem[5];
              BigDecimal nbrCnsvcLineItem = (BigDecimal) contractServicesListItem[6];
              String cdCnsvcService = (String) contractServicesListItem[8];
              ContractCounty addContractCounty = new ContractCounty();
              Contract contract = getPersistentObject(Contract.class, idContract);
              addContractCounty.setContract(contract);
              addContractCounty.setNbrCncntyPeriod(nbrCnsvcPeriod.intValue());
              addContractCounty.setNbrCncntyVersion(nbrCnsvcVersion.intValue());
              addContractCounty.setNbrCncntyLineItem(nbrCnsvcLineItem.intValue());
              addContractCounty.setCdCncntyCounty(cdNewCounty);
              addContractCounty.setPerson(contract.getPersonByIdCntrctWkr());
              addContractCounty.setCapsResource(capsResource);
              addContractCounty.setCdCncntyService(cdCnsvcService);
              addContractCounty.setDtCncntyEffective(dtCnverEff);
              addContractCounty.setDtCncntyEnd(dtCnverEnd);
              contractCountyDAO.saveContractCounty(addContractCounty);
            }// End For
          }// End if
          
          // When a change is made to the vendor ID, InvoiceDAO
          // will be able to update all the invoices that are still
          // pending for the vendor with the correct vendor id.
          if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rowcfad08sig01.getSzCdSysDataActionOutcome())
              && resourceAddress.getNbrRsrcAddrVid() != null) {
            invoiceDAO.updateInvoiceNbrInvoVid(resourceAddress.getNbrRsrcAddrVid(), resourceAddress.getIdRsrcAddress());
          }
        }
      }
    }
    // Add / Update / Delete Resource Phone
    ROWCFAD08SIG00_ARRAY rowcfad08sig00_array = cfad08si.getROWCFAD08SIG00_ARRAY();
    
   
    
    if (rowcfad08sig00_array != null && rowcfad08sig00_array.getROWCFAD08SIG00Count() > 0) {
      for (int i = 0; i < rowcfad08sig00_array.getROWCFAD08SIG00Count(); i++) {
        ROWCFAD08SIG00 rowcfad08sig01 = rowcfad08sig00_array.getROWCFAD08SIG00(i);
        if (rowcfad08sig01 != null) {
          if (ServiceConstants.REQ_FUNC_CD_ADD.equals(rowcfad08sig01.getSzCdSysDataActionOutcome())) {
            ResourcePhone resourcePhone = new ResourcePhone();
            resourcePhone.setIdRsrcPhone(0);
            resourcePhone.setCapsResource(capsResource);
            resourcePhone.setCdRsrcPhoneType(rowcfad08sig01.getSzCdFacilPhoneType());
            resourcePhone.setNbrRsrcPhone(rowcfad08sig01.getLNbrFacilPhoneNumber());
            resourcePhone.setNbrRsrcPhoneExt(rowcfad08sig01.getLNbrFacilPhoneExtension());
            resourcePhone.setTxtRsrcPhoneComments(rowcfad08sig01.getSzTxtRsrcPhoneComments());
            resourcePhoneDAO.saveResourcePhone(resourcePhone);
            
            
            /**
             * Following code comes into effect when the user is trying to create a new fax or phone
             * if the resource is already referred to SMILE and Vendor ID is not yet assigned by SMILE
             * The error message will be displayed on screen.
             */
           // int rsrcSntToSml = 0;
           int rsrcSntToSml = vendorOutboundDAO.isRsrcSntToSmile(idResource) != null ? vendorOutboundDAO.isRsrcSntToSmile(idResource) : 0;
            if(rsrcSntToSml != 0){
         
             
              String vendorID = resourceAddressDAO.findResourceAddressVID(idResource);
              if(vendorID == null){
                //throw new TempServiceException();
            	  throw new ServiceException(Messages.MSG_VNDR_PEND);
              }
               else{
                 
                 int idRsrcAddressLc = 0;
                 idRsrcAddressLc = resourceAddressDAO.findIdResourceAddressByAddress(idResource) != null ? resourceAddressDAO.findIdResourceAddressByAddress(idResource) : 0;
          
            if ( FAX_TYPE.equals(resourcePhone.getCdRsrcPhoneType()) || (FAX2_TYPE.equals(resourcePhone.getCdRsrcPhoneType())
                            && (idRsrcAddressLc != 0)))
                       {

                      VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
                         vendorOutboundSI.setNbrRsrcFax((String) rowcfad08sig01.getLNbrFacilPhoneNumber());
                         vendorOutboundSI.setNbrRsrcFaxExt((String) rowcfad08sig01.getLNbrFacilPhoneExtension());
                         vendorOutboundSI.setIdRsrcAddr(idRsrcAddressLc != 0 ? idRsrcAddressLc : 0);
                         vendorOutboundSI.setIdResource(idResource != 0 ? idResource : 0);
                         vendorOutboundSI.setUserId(cfad08si.getUlIdCntrctWkr() != 0 ? cfad08si.getUlIdCntrctWkr() : 0);
                         vendorOutboundSI.setDtRsrcUpdated(new Date());
                         vendorOutboundSI.setFaxFlag(true);                   
                         saveVendorOutbound.saveNewVendor(vendorOutboundSI);
                            
                       }
               }
            } 
            if (ZERO == resourcePhone.getIdRsrcPhone()) {
              throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
            }
          
          }
          
          else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rowcfad08sig01.getSzCdSysDataActionOutcome())) {
            ResourcePhone resourcePhone = getPersistentObject(ResourcePhone.class, rowcfad08sig01.getUlIdRsrcPhone());
            resourcePhone.setCapsResource(capsResource);
            resourcePhone.setCdRsrcPhoneType(rowcfad08sig01.getSzCdFacilPhoneType());
            resourcePhone.setNbrRsrcPhone(rowcfad08sig01.getLNbrFacilPhoneNumber());
            resourcePhone.setNbrRsrcPhoneExt(rowcfad08sig01.getLNbrFacilPhoneExtension());
            resourcePhone.setTxtRsrcPhoneComments(rowcfad08sig01.getSzTxtRsrcPhoneComments());
            resourcePhone.setDtLastUpdate(rowcfad08sig01.getTsLastUpdate());
            resourcePhone.setIdRsrcPhone(rowcfad08sig01.getUlIdRsrcPhone());
            resourcePhoneDAO.saveResourcePhone(resourcePhone);

            /*
             * code added by srinivas when phone information is modified if the phone is primary type the information
             * need to send to VendorOutbound table after checking whether the home or resource associated with this
             * phone has vendor id or not . If Vendor is existing then we need to send the information to VendorOutbound
             * table indicating it is modification. If Vendor is not available then the Home event status associated
             * with this resource need to be checked.
             */

            idResource = cfad08so.getUlIdResource();
            int idRsrcAddr = 0;
            idRsrcAddr = resourceAddressDAO.findIdResourceAddressByAddressTypeOnly(idResource) != null ? resourceAddressDAO.findIdResourceAddressByAddressTypeOnly(idResource) : 0;
            String vendorID = resourceAddressDAO.findResourceAddressVID(idResource  );
            String PhoneType = rowcfad08sig01.getSzCdFacilPhoneType();
            int uIdStage = cfad08so.getUlIdStage();
            int vendorIdLength = 0;
            if (vendorID == null)
              vendorIdLength = 0;

            if (vendorIdLength != 0 && (PhoneType.equalsIgnoreCase("01"))) {
              VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
              vendorOutboundSI.setNbrRsrcPhn((String) rowcfad08sig01.getLNbrFacilPhoneNumber());
              vendorOutboundSI.setNbrRsrcPhoneExt((String) rowcfad08sig01.getLNbrFacilPhoneExtension());
              vendorOutboundSI.setIdRsrcAddr(idRsrcAddr != 0 ? idRsrcAddr : 0);
              vendorOutboundSI.setIdResource(idResource != 0 ? idResource : 0);
              vendorOutboundSI.setUserId(cfad08si.getUlIdCntrctWkr() != 0 ? cfad08si.getUlIdCntrctWkr() : 0);
              vendorOutboundSI.setDtRsrcUpdated(new Date());
              vendorOutboundSI.setPhoneFlag(true);
              saveVendorOutbound.saveNewVendor(vendorOutboundSI);
            }
            if (vendorIdLength != 0 && (PhoneType.equalsIgnoreCase("03"))) {
              VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
              int idRsrcAddrLc = 0;
              idRsrcAddrLc = resourceAddressDAO.findIdResourceAddressByAddress(idResource) != null ? resourceAddressDAO.findIdResourceAddressByAddress(idResource) : 0;
            
              vendorOutboundSI.setNbrRsrcFax((String) rowcfad08sig01.getLNbrFacilPhoneNumber());
              vendorOutboundSI.setNbrRsrcFaxExt((String) rowcfad08sig01.getLNbrFacilPhoneExtension());

              vendorOutboundSI.setIdRsrcAddr(idRsrcAddrLc != 0 ? idRsrcAddrLc : 0);
              vendorOutboundSI.setIdResource(idResource != 0 ? idResource : 0);
              vendorOutboundSI.setUserId(cfad08si.getUlIdCntrctWkr() != 0 ? cfad08si.getUlIdCntrctWkr() : 0);
              vendorOutboundSI.setDtRsrcUpdated(new Date());
              vendorOutboundSI.setFaxFlag(true);
              saveVendorOutbound.saveNewVendor(vendorOutboundSI);

            }
            if (vendorIdLength != 0 && (PhoneType.equalsIgnoreCase("08"))) {
              VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
              int idRsrcAddrLc2 = 0;
              idRsrcAddrLc2 = resourceAddressDAO.findIdResourceAddressByAddress(idResource) != null ? resourceAddressDAO.findIdResourceAddressByAddress(idResource) : 0;
              // vendorOutboundSI.setNbrRsrcPhn(rowcfad08sig00.getLNbrFacilPhoneNumber() != null ?
              // rowcfad08sig00.getLNbrFacilPhoneNumber() : "");
              // vendorOutboundSI.getNbrRsrcPhoneExt(rowcfad08sig00.getLNbrFacilPhoneExtension() != null ?
              // rowcfad08sig00.getLNbrFacilPhoneExtension() : "");
              vendorOutboundSI.setNbrRsrcFax((String) rowcfad08sig01.getLNbrFacilPhoneNumber());
              vendorOutboundSI.setNbrRsrcFaxExt((String) rowcfad08sig01.getLNbrFacilPhoneExtension());

              vendorOutboundSI.setIdRsrcAddr(idRsrcAddrLc2 != 0 ? idRsrcAddrLc2 : 0);
              vendorOutboundSI.setIdResource(idResource != 0 ? idResource : 0);
              vendorOutboundSI.setUserId(cfad08si.getUlIdCntrctWkr() != 0 ? cfad08si.getUlIdCntrctWkr() : 0);
              vendorOutboundSI.setDtRsrcUpdated(new Date());
              vendorOutboundSI.setFaxFlag(true);
              saveVendorOutbound.saveNewVendor(vendorOutboundSI);

            }

            if (vendorIdLength == 0 && PhoneType.equalsIgnoreCase("01")) {
              if (uIdStage != 0) {
                CapsResource resource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(uIdStage);
                if (resource != null) {

                  String eventStatus = resource.getCdRsrcFaHomeStatus();
                  
                  int intNumberContracts = 0;
                  List<ContractPeriod> contractPeriodList = new ArrayList<ContractPeriod>(); 
                  contractPeriodList = contractPeriodDAO.findListOfContractPeriodByIdResource(idResource); 
                  intNumberContracts = contractPeriodList != null ? contractPeriodList.size() : 0;
                  
                  boolean bActiveContract = ((ACTIVE_HOME.equals(eventStatus)||ACTIVE_TEMP_HOME.equals(eventStatus)||
                                  ACTIVE_HOME_30_DAY.equals(eventStatus) || ACTIVE_SPECIAL_HOME_30_DAY.equals(eventStatus) ||
                                  ACTIVE_SPECIAL_HOME.equals(eventStatus)) && (intNumberContracts >0));
                  
                  if (bActiveContract) {
                    VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
                    vendorOutboundSI.setNbrRsrcPhn((String) rowcfad08sig01.getLNbrFacilPhoneNumber());
                    vendorOutboundSI.setNbrRsrcPhoneExt((String) rowcfad08sig01.getLNbrFacilPhoneExtension());
                    vendorOutboundSI.setIdRsrcAddr(idRsrcAddr != 0 ? idRsrcAddr : 0);
                    vendorOutboundSI.setIdResource(idResource != 0 ? idResource : 0);
                    vendorOutboundSI.setIdRsrcAddr(idRsrcAddr != 0 ? idRsrcAddr : 0);
                    vendorOutboundSI.setIdResource(idResource != 0 ? idResource : 0);
                    vendorOutboundSI.setUserId(cfad08si.getUlIdCntrctWkr() != 0 ? cfad08si.getUlIdCntrctWkr() : 0);
                    vendorOutboundSI.setDtRsrcUpdated(new Date());
                    vendorOutboundSI.setPhoneFlag(true);
                    saveVendorOutbound.saveNewVendor(vendorOutboundSI);
                  }
                }
              }
            }
            if (vendorIdLength == 0 && PhoneType.equalsIgnoreCase("03") || PhoneType.equalsIgnoreCase("08")) {
              if (uIdStage != 0) {
                CapsResource resource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(uIdStage);
                if (resource != null) {

                  String eventStatus = resource.getCdRsrcFaHomeStatus();
                  
                  int intNumberContracts = 0;
                  List<ContractPeriod> contractPeriodList = new ArrayList<ContractPeriod>(); 
                  contractPeriodList = contractPeriodDAO.findListOfContractPeriodByIdResource(idResource); 
                  intNumberContracts = contractPeriodList != null ? contractPeriodList.size() : 0;
                  
                  boolean bActiveContract = ((ACTIVE_HOME.equals(eventStatus)||ACTIVE_TEMP_HOME.equals(eventStatus)||
                                  ACTIVE_HOME_30_DAY.equals(eventStatus) || ACTIVE_SPECIAL_HOME_30_DAY.equals(eventStatus) ||
                                  ACTIVE_SPECIAL_HOME.equals(eventStatus)) && (intNumberContracts >0));
                  
                  if (bActiveContract) {
                    VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
                    vendorOutboundSI.setNbrRsrcFax((String) rowcfad08sig01.getLNbrFacilPhoneNumber());
                    vendorOutboundSI.setNbrRsrcFaxExt((String) rowcfad08sig01.getLNbrFacilPhoneExtension());
                    vendorOutboundSI.setIdRsrcAddr(idRsrcAddr != 0 ? idRsrcAddr : 0);
                    vendorOutboundSI.setIdResource(idResource != 0 ? idResource : 0);
                    vendorOutboundSI.setIdRsrcAddr(idRsrcAddr != 0 ? idRsrcAddr : 0);
                    vendorOutboundSI.setIdResource(idResource != 0 ? idResource : 0);
                    vendorOutboundSI.setUserId(cfad08si.getUlIdCntrctWkr() != 0 ? cfad08si.getUlIdCntrctWkr() : 0);
                    vendorOutboundSI.setDtRsrcUpdated(new Date());
                    vendorOutboundSI.setFaxFlag(true);
                    saveVendorOutbound.saveNewVendor(vendorOutboundSI);
                  }
                }
              }
            }
          } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(rowcfad08sig01.getSzCdSysDataActionOutcome())) {
            ResourcePhone resourcePhone = getPersistentObject(ResourcePhone.class, rowcfad08sig01.getUlIdRsrcPhone());
            resourcePhoneDAO.deleteResourcePhone(resourcePhone);
           
          } else {
            throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
          }
        }
      }
    }

    // Add / Update / Delete F/A Home Interest Ethnicities
    ROWCFAD08SIG03_ARRAY rowcfad08sig03_array = cfad08si.getROWCFAD08SIG03_ARRAY();
    if (rowcfad08sig03_array != null && rowcfad08sig03_array.getROWCFAD08SIG03Count() > 0) {
      for (int i = 0; i < rowcfad08sig03_array.getROWCFAD08SIG03Count(); i++) {
        ROWCFAD08SIG03 rowcfad08sig03 = rowcfad08sig03_array.getROWCFAD08SIG03(i);
        if (rowcfad08sig03 != null) {
          if (ServiceConstants.REQ_FUNC_CD_ADD.equals(rowcfad08sig03.getSzCdSysDataActionOutcome())
              || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rowcfad08sig03.getSzCdSysDataActionOutcome())) {
         	  HomeEthnicity homeEthnicity = new HomeEthnicity();
        	  HomeEthnicityId homeEthnicityId = new HomeEthnicityId();
        	  homeEthnicityId.setIdResource(cfad08so.getUlIdResource());
        	  homeEthnicityId.setCdEthnicity(rowcfad08sig03.getSzCdFaHomeIntEthnicity());
        	  homeEthnicity.setId(homeEthnicityId);
            	homeEthnicityDAO.saveHomeEthnicity(homeEthnicity);
           } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(rowcfad08sig03.getSzCdSysDataActionOutcome())) {
          	  HomeEthnicity homeEthnicity = new HomeEthnicity();
        	  HomeEthnicityId homeEthnicityId = new HomeEthnicityId();
        	  homeEthnicityId.setIdResource(cfad08so.getUlIdResource());
        	  homeEthnicityId.setCdEthnicity(rowcfad08sig03.getSzCdFaHomeIntEthnicity());
        	  homeEthnicity.setId(homeEthnicityId);
              homeEthnicityDAO.deleteHomeEthnicity(homeEthnicityId);
          } else {
            throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
          }
        }
      }
    }
    // }

    // Add / Update / Delete F/A Home Interest Races
    HomeRaceSI_ARRAY home_race_array = cfad08si.getHomeRaceSI_ARRAY();
    if (home_race_array != null && home_race_array.getHomeRaceSICount() > 0) {
      for (int i = 0; i < home_race_array.getHomeRaceSICount(); i++) {
        HomeRaceSI home_race = home_race_array.getHomeRaceSI(i);
        if (home_race != null) {
          if (ServiceConstants.REQ_FUNC_CD_ADD.equals(home_race.getSzCdSysDataActionOutcome())
              || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(home_race.getSzCdSysDataActionOutcome())) {
        	  HomeRace homeRace = new HomeRace();
        	  HomeRaceId homeRaceId = new HomeRaceId();
        	  homeRaceId.setIdResource(cfad08so.getUlIdResource());
        	  homeRaceId.setCdRace(home_race.getSzCdFaHomeIntRace());
        	  homeRace.setId(homeRaceId);
        	  homeRace.setDtLastUpdate(home_race.getTsLastUpdate());
        	  homeRaceDAO.saveHomeRace(homeRace);
           } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(home_race.getSzCdSysDataActionOutcome())) {
         	  HomeRace homeRace = new HomeRace();
        	  HomeRaceId homeRaceId = new HomeRaceId();
        	  homeRaceId.setIdResource(cfad08so.getUlIdResource());
        	  homeRaceId.setCdRace(home_race.getSzCdFaHomeIntRace());
        	  homeRace.setId(homeRaceId);
        	  homeRaceDAO.deleteHomeRace(homeRaceId);
          } else {
            throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
          }
        }
      }
    }
    // }

    // Characteristics & Resource Service Processing
    ROWCFAD08SIG05 rowcfad08sig05 = cfad08si.getROWCFAD08SIG05();
    CFAD01UI cfad01ui = new CFAD01UI();
    cfad01ui.setArchInputStruct(new ArchInputStruct());
    cfad01ui.getArchInputStruct().setCReqFuncCd(cfad08si.getArchInputStruct().getCReqFuncCd());
    cfad01ui.setCSysIndRsrcCharChgNoSvc(cfad08si.getCSysIndRsrcCharChgNoSvc());
    cfad01ui.setCSysIndRsrcCharChg(cfad08si.getCSysIndRsrcCharChg());
    cfad01ui.setBSysIndAddressChange(cfad08si.getCSysIndRsrcCharChg());
    cfad01ui.setCSysIndCategoryChange(cfad08si.getCSysIndCategoryChange());
    cfad01ui.setCSysIndFosterTypeChange(cfad08si.getCSysIndFosterTypeChange());
    cfad01ui.setSzCdRshsFaHomeStatus(cfad08si.getROWCFAD08SIG04().getSzCdRshsFaHomeStatus());
    // Pass indicator of PRS change into the common function. If it
    // has changed then a Resource Service needs to be modified.
    cfad01ui.setCSysIndRsrcPrsChg(cfad08si.getCSysIndRsrcPrsChg());
    cfad01ui.setUlIdResource(cfad08so.getUlIdResource());
    if (rowcfad08sig05 != null) {// check to ensure this is not null to avoid null pointer exc.
      cfad01ui.setUNbrRsrcMlAgeMax(rowcfad08sig05.getUNbrRsrcMlAgeMax());
      cfad01ui.setUNbrRsrcMlAgeMin(rowcfad08sig05.getUNbrRsrcMlAgeMin());
      cfad01ui.setUNbrRsrcFMAgeMax(rowcfad08sig05.getUNbrRsrcFMAgeMax());
      cfad01ui.setUNbrRsrcFMAgeMin(rowcfad08sig05.getUNbrRsrcFMAgeMin());
    }

    if (rowcfad08sig01_array != null && rowcfad08sig01_array.getROWCFAD08SIG01Count() > 0) {
      for (int i = 0; i < rowcfad08sig01_array.getROWCFAD08SIG01Count(); i++) {
        ROWCFAD08SIG01 rowcfad08sig01 = rowcfad08sig01_array.getROWCFAD08SIG01(i);
        if (CodesTables.CRSCADDR_01.equals(rowcfad08sig01.getSzCdRsrcAddrType())
            && rowcfad08sig01.getSzCdSysDataActionOutcome() != null) {
          cfad01ui.setBSysIndAddressChange(ArchitectureConstants.Y);
        }
      }
    }
    ROWCFAD08SIG02_ARRAY rowcfad08sig02_array = cfad08si.getROWCFAD08SIG02_ARRAY();
    CFAD01UIG00_ARRAY cfad01uig00_array = cfad01ui.getCFAD01UIG00_ARRAY();
    if (cfad01uig00_array == null)
      cfad01uig00_array = new CFAD01UIG00_ARRAY();

    if (rowcfad08sig02_array != null && rowcfad08sig02_array.getROWCFAD08SIG02Count() > 0) {
      for (int i = 0; i < rowcfad08sig02_array.getROWCFAD08SIG02Count(); i++) {
        ROWCFAD08SIG02 rowcfad08sig02 = rowcfad08sig02_array.getROWCFAD08SIG02(i);
        CFAD01UIG00 cfad01uig00 = new CFAD01UIG00();
        cfad01uig00.setSzCdRsrcCharChrctr(rowcfad08sig02.getSzCdRsrcCharChrctr());
        cfad01uig00.setDtDtRsrcCharDateAdded(rowcfad08sig02.getDtDtRsrcCharDateAdded());
        cfad01uig00_array.addCFAD01UIG00(i, cfad01uig00);
      }
    }
    // set into parent struct
    cfad01ui.setCFAD01UIG00_ARRAY(cfad01uig00_array);
    if (StringHelper.EMPTY_STRING.equals(cfad08si.getBSysIndAgeChange())) {
      cfad01ui.setBSysIndAgeChange(ArchitectureConstants.N);
    } else {
      cfad01ui.setBSysIndAgeChange(cfad08si.getBSysIndAgeChange());
    }
    
    // Call cfad01u common function
    updateFAResource.updateFAResource(cfad01ui);
    return cfad08so;
  }
  private int reassignAvailableCaseManager(int idEvent, int idCase, int idStage, int idUser, Date currDate,
                                              String nmStage, int persAssigned) {
    Todo todo = new Todo();
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    String cdTask = "";
    Date dateCreated = new Date();
    Date todoDueDate = currDate;
    String todoDesc = "New F/A Home inquiry received should be reassigned to a case manager.";
    todo.setEvent(getPersistentObject(Event.class, idEvent));
    todo.setTxtTodoDesc(todoDesc);
    todo.setCdTodoTask(cdTask);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoDue(todoDueDate);
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, persAssigned));
    todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
    todo.setDtTodoCreated(dateCreated);
    todo.setCapsCase(capsCase);
    todo.setStage(getPersistentObject(Stage.class, idStage));
    todoDAO.saveTodo(todo);
    return todo.getIdTodo();
  }
  private int followUpTenDays(int idEvent, int idCase, int idStage, int idUser, Date currDate,
                                              String nmStage, int persAssigned) {
    Todo todo = new Todo();
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    String cdTask = "";
    Date dateCreated = new Date();
    Date todoDueDate = currDate;
    String todoDesc = "Follow up with " + nmStage + " inquiry within 10 days";
    todo.setEvent(getPersistentObject(Event.class, idEvent));
    todo.setTxtTodoDesc(todoDesc);
    todo.setCdTodoTask(cdTask);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoDue(todoDueDate);
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, persAssigned));
    todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
    todo.setDtTodoCreated(dateCreated);
    todo.setCapsCase(capsCase);
    todo.setStage(getPersistentObject(Stage.class, idStage));
    todoDAO.saveTodo(todo);
    return todo.getIdTodo();
  }
  
  private static class TempServiceException extends ServiceException {
    @Override
    public int getErrorCode() {
      return Integer.MAX_VALUE;
    }
    
    @Override
    public String getErrorMessage() {
      return MSG_VID_REQ;
    }
  }
  
  private void addResourceServices(int idResource, String cdNewCounty) throws ServiceException {
    List<String> existingResourceServicesInNewCounty = resourceServiceDAO.findResourceServiceByCdCounty(idResource,
                                                                                                        cdNewCounty);
    CapsResource capsResource = getPersistentObject(CapsResource.class, idResource);
    String cdRsrcCategory = capsResource.getCdRsrcCategory();

    Set<String> serviceCategorySet = new HashSet<String>();
    if (FA_CATG_FOST_ADOPT_LEG_RISK.equals(cdRsrcCategory) || FA_CATG_ADOPT.equals(cdRsrcCategory)
        || FA_CATG_REL_ADOPT.equals(cdRsrcCategory)) {
      serviceCategorySet.add(CD_ADOPT_SERVICES);
    }

    if (FA_CATG_FOST_ADOPT_LEG_RISK.equals(cdRsrcCategory) || FA_CATG_FOST.equals(cdRsrcCategory)
        || FA_CATG_REL_FOST.equals(cdRsrcCategory) || FA_CATG_ICPC.equals(cdRsrcCategory)) {
      serviceCategorySet.add(CD_FOSTER_SERVICES);
    }

    Iterator serviceCategoryIterator = serviceCategorySet.iterator();
    while (serviceCategoryIterator.hasNext()) {
      String serviceCatagory = (String) serviceCategoryIterator.next();
      // and then Add then add the entire package. It may seem inefficient but it is perhaps
      // the most optimal solution that handles all the possibilities.
      List<CodeAttributes> codeAttributesList;
      try {
        codeAttributesList = Lookup.getCategoryCollection(serviceCatagory);
        // Scan for codes for the specified category of service codes
        for (Iterator<CodeAttributes> it = codeAttributesList.iterator(); it.hasNext();) {
          CodeAttributes codeAttributes = it.next();
          // the category is the 1st 3 characters of the service code
          String svcCategory = codeAttributes.getDecode().substring(0, 3);
          //SMS#79227 Compare with cd Resource Service
          String cdResSvc = codeAttributes.getDecode();
          // Add resource service if it does not exist.
          if (!existingResourceServicesInNewCounty.contains(cdResSvc)) {
            ResourceService resourceService = new ResourceService();
            resourceService.setIndRsrcSvcShowRow(ArchitectureConstants.Y);
            resourceService.setCdRsrcSvcCnty(cdNewCounty);
            resourceService.setCdRsrcSvcServiceType("F");
            String cdRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdNewCounty);
            resourceService.setCdRsrcSvcRegion(cdRegion);
            resourceService.setCdRsrcSvcCategRsrc(svcCategory);
            resourceService.setCapsResource(capsResource);
            resourceService.setIndRsrcSvcCntyPartial(ArchitectureConstants.N);
            resourceService.setIndRsrcSvcIncomeBsed(ArchitectureConstants.N);
            resourceService.setCdRsrcSvcService(codeAttributes.getDecode());
            resourceService.setCdRsrcSvcState(capsResource.getCdRsrcState());
            resourceServiceDAO.saveResourceService(resourceService);
          }
        }
        if (codeAttributesList.isEmpty()) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } catch (LookupException e) {
        throw new ServiceException(Messages.SQL_NOT_FOUND, e);
      }
    }// end of while has more service codes
    return;
  } // end of private method

  
  private static final String ACTIVE_HOME = CodesTables.CFAHMSTA_AFA;
  private static final String ACTIVE_TEMP_HOME = CodesTables.CFAHMSTA_ATA;
  private static final String ACTIVE_SPECIAL_HOME = CodesTables.CFAHMSTA_ASA;
  private static final String ACTIVE_HOME_30_DAY = CodesTables.CFAHMSTA_FLG;
  private static final String ACTIVE_SPECIAL_HOME_30_DAY = CodesTables.CFAHMSTA_FSG;
  static final String FA_CATG_ADOPT = CodesTables.CFACATEG_A;
  static final String FA_CATG_REL_ADOPT = CodesTables.CFACATEG_D;
  static final String FA_CATG_FOST_ADOPT_LEG_RISK = CodesTables.CFACATEG_L;
  static final String FA_CATG_FOST = CodesTables.CFACATEG_F;
  static final String FA_CATG_REL_FOST = CodesTables.CFACATEG_O;
  static final String FA_CATG_ICPC = CodesTables.CFACATEG_I;
  
  //foster/adoption service code type/category
  static final String CD_FOSTER_SERVICES = CodesTables.CFOSSVCD;
  static final String CD_ADOPT_SERVICES = CodesTables.CADOSVCD;
  
}
