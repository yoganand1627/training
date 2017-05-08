package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 **  07/17/2008  charden           STGAP00006557 - created new method to save person phone detail  
 *                                 info to csupParentOutbound when add is being done
 *                                 
 */

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveCsupParentDemographicInfo;
import gov.georgia.dhr.dfcs.sacwis.service.person.SavePhoneListDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveCsupParentDemographicInfoSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN31SO;

import gov.georgia.dhr.dfcs.sacwis.service.common.InterfaceServiceConstants;

public class SavePhoneListDetailImpl extends BaseServiceImpl implements SavePhoneListDetail {

  private ComplexPersonPhoneDAO complexPersonPhoneDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;
  
  private EligibilityDAO eligibilityDAO = null;
  
  private PersonIdDAO personIdDAO = null;
  
  private SaveCsupParentDemographicInfo saveCsupParentDemographicInfo = null;

  public void setComplexPersonPhoneDAO(ComplexPersonPhoneDAO complexPersonPhoneDAO) {
    this.complexPersonPhoneDAO = complexPersonPhoneDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }
  
  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }
  
 
  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }
  
  public void setSaveCsupParentDemographicInfo(SaveCsupParentDemographicInfo saveCsupParentDemographicInfo) {
    this.saveCsupParentDemographicInfo = saveCsupParentDemographicInfo;
  }
  
  public CCMN31SO savePhoneListDetail(CCMN31SI ccmn31si) throws ServiceException {
    if (ccmn31si.getUlIdStage() != 0) {
      CCMN06UI ccmn06ui = new CCMN06UI();
      ccmn06ui.setArchInputStruct(new ArchInputStruct());
      ccmn06ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      ccmn06ui.setUlIdStage(ccmn31si.getUlIdStage());
      ccmn06ui.setSzCdTask(ccmn31si.getSzCdTask());
      // CheckStageEventStatus;
      // this throws an exception that will halt processing with a message if it fails; success is no output.
      checkStageEventStatus.status(ccmn06ui);
    }
    savePersonPhone(ccmn31si);
    // The output message is always empty.
    return new CCMN31SO();
  }

  private void savePersonPhone(CCMN31SI ccmn31si) throws ServiceException {
    // CCMN95D keeps track of the timestamps on the Start and End dates. The primary phones in the input message are
    //   sorted in reverse-modified order (i.e., the most recent primary phone added or modified will be at beginning
    //   of the input message). To ensure that the phones receive the timestamps in the proper order, we need to
    //   process the list in reverse order.  We use a list iterator to do this cleanly.
    ROWCCMN31SI_ARRAY rowccmn31si_array = ccmn31si.getROWCCMN31SI_ARRAY();
    for (int i = rowccmn31si_array.getROWCCMN31SICount() - 1; i >= 0; i--) {
      ROWCCMN31SI rowccmn31si = rowccmn31si_array.getROWCCMN31SI(i);
      String reqFuncCd = rowccmn31si.getSzCdScrDataAction();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
        // ccmn95d
        if (0 == complexPersonPhoneDAO.insertPersonPhone(DateHelper.toJavaDate(rowccmn31si.getDtDtPersonPhoneEnd()),
                                                         ccmn31si.getUlIdPerson(), rowccmn31si.getSzCdPhoneType(),
                                                         rowccmn31si.getLNbrPhone(),
                                                         rowccmn31si.getLNbrPhoneExtension(),
                                                         rowccmn31si.getBIndPersonPhonePrimary(),
                                                         rowccmn31si.getBIndPersonPhoneInvalid(),
                                                         rowccmn31si.getSzTxtPhoneComments(),
                                                         rowccmn31si.getUlIdPhone(), rowccmn31si.getTsLastUpdate())) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }

      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {
        // ccmn95d
        if (0 == complexPersonPhoneDAO.updatePersonPhone(DateHelper.toJavaDate(rowccmn31si.getDtDtPersonPhoneEnd()),
                                                         ccmn31si.getUlIdPerson(), rowccmn31si.getSzCdPhoneType(),
                                                         rowccmn31si.getLNbrPhone(),
                                                         rowccmn31si.getLNbrPhoneExtension(),
                                                         rowccmn31si.getBIndPersonPhonePrimary(),
                                                         rowccmn31si.getBIndPersonPhoneInvalid(),
                                                         rowccmn31si.getSzTxtPhoneComments(),
                                                         rowccmn31si.getUlIdPhone(), rowccmn31si.getTsLastUpdate())) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        } 
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {
        // There is no delete logic in ccmn95d, so nothing is done here.
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    // STGAP00006557 - called new method to save phone list detail info to CsupParentOutbound table when info is added
    // or updated from the phone list detail page
    saveCsupParentD(ccmn31si);
  }
  

  // STGAP00006557 - created new method to save phone info to csupParentOutbound
  private void saveCsupParentD(CCMN31SI ccmn31si) {
    // Add code for CSUPParent Update info
    ROWCCMN31SI rowccmn31si = ccmn31si.getROWCCMN31SI_ARRAY().getROWCCMN31SI(0);
    String reqFuncCd = ccmn31si.getROWCCMN31SI_ARRAY().getROWCCMN31SI(0).getSzCdScrDataAction();
    SaveCsupParentDemographicInfoSI saveCsupParentPhoneRowSI = new SaveCsupParentDemographicInfoSI();
    Object[] parentInfo = personIdDAO.findDistinctParentByStagePersRelId(ccmn31si.getUlIdPerson());
    if (null != parentInfo && ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
      saveCsupParentPhoneRowSI.setIdPersonId(ccmn31si.getUlIdPerson());
      saveCsupParentPhoneRowSI.setNbrNoncustPhone(null != rowccmn31si.getLNbrPhone() ? rowccmn31si.getLNbrPhone() : "");
      if (null != rowccmn31si.getTsLastUpdate()) {
        saveCsupParentPhoneRowSI.setDtCsupparRequested(rowccmn31si.getTsLastUpdate());
      }
      saveCsupParentDemographicInfo.saveCsupParentDemographicInfo(saveCsupParentPhoneRowSI, InterfaceServiceConstants.SAVE_PERSON_PHONE_DETAIL, reqFuncCd);
    }
  }
}
