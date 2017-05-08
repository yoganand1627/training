package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.UCMDataObject;
import gov.georgia.dhr.dfcs.sacwis.core.utility.UCMHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ExtDocumentationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExtDocPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.ContactPrivConverCbx;
import gov.georgia.dhr.dfcs.sacwis.db.ExtDocumentation;
import gov.georgia.dhr.dfcs.sacwis.db.ExtDocPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.common.SaveExternalDocumentation;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExternalDocumentationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELEXTDOCPERCHECK_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV22SO;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.grnds.facility.config.GrndsConfiguration;

import oracle.stellent.ridc.model.DataBinder;

/**
 * This class is used to perform the Save Service for External Documentation Detail page.
 * 
 * Change History: 
 * Date         User            Description
 * --------     ----------    ------------------------------------
 * 12/07/2011   vcollooru       STGAP00017712: Imaging integration into SHINES.
 * 02/14/2012   vcollooru       STGAP00017827: MR-085 Modified to persist ICPC checkbox status.
 * 
 */
public class SaveExternalDocumentationImpl extends BaseServiceImpl implements SaveExternalDocumentation {

  private CheckStageEventStatus checkStageEventStatus = null;
  private ExtDocumentationDAO extDocumentationDAO = null;
  private ExtDocPersonLinkDAO extDocPersonLinkDAO = null;
  private PersonDAO personDAO = null;
  
  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }
  public void setExtDocPersonLinkDAO(ExtDocPersonLinkDAO extDocPersonLinkDAO) {
	    this.extDocPersonLinkDAO = extDocPersonLinkDAO;
	  }
  public void setExtDocumentationDAO(ExtDocumentationDAO extDocumentationDAO) {
    this.extDocumentationDAO = extDocumentationDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
	this.personDAO = personDAO;
  }
public CINV22SO saveExternalDocumentation(CINV22SI cinv22si, boolean isUploadFile, ExternalDocumentationSI extDocSI) throws ServiceException {
    int idStage = cinv22si.getUlIdStage();
    if (idStage != 0) {
      CCMN06UI ccmn06ui = new CCMN06UI();
      ccmn06ui.setArchInputStruct(new ArchInputStruct());
      ccmn06ui.getArchInputStruct().setCReqFuncCd(cinv22si.getArchInputStruct().getCReqFuncCd());
      ccmn06ui.setUlIdStage(cinv22si.getUlIdStage());
      ccmn06ui.setSzCdTask(cinv22si.getSzCdTask());
      // CheckStageEventStatus;
      // this throws an exception that will halt processing with a message if it fails; success is no output.
      checkStageEventStatus.status(ccmn06ui);
    }
    editExtDocumentation(cinv22si, extDocSI);
    // There is never any ouput.
    return new CINV22SO();
  }

  private void editExtDocumentation(CINV22SI cinv22si, ExternalDocumentationSI extDocSI) {
    ROWCINV22SIG_ARRAY rowCinv22SigArray = cinv22si.getROWCINV22SIG_ARRAY();
 
    
    for (Enumeration rowCinv22Sig_enum = rowCinv22SigArray.enumerateROWCINV22SIG();
         rowCinv22Sig_enum.hasMoreElements();) {
      ROWCINV22SIG rowCinv22Sig = (ROWCINV22SIG) rowCinv22Sig_enum.nextElement();
      
      ROWCINV22SIG1_ARRAY rowPerChkArray = cinv22si.getROWCINV22SIG1_ARRAY();
      List<Integer> addList = new ArrayList<Integer>();
      if (rowPerChkArray.getUlRowQty() > 0 && rowPerChkArray != null) {
    	  for (int j = 0; j < rowPerChkArray.getUlRowQty(); j++) {
          ROWCINV22SIG1 rowCinv22s1g1 = rowPerChkArray.getROWCINV22SIG1(j);
    	  Integer idPerson = rowCinv22s1g1.getUlIdPerson();
          addList.add(idPerson);
    	  
      }
     }
      ROWDELEXTDOCPERCHECK_ARRAY rowPerDelArray = cinv22si.getROWDELEXTDOCPERCHECK_ARRAY();
      List<Integer> delList = new ArrayList<Integer>();  
      if (rowPerDelArray.getUlRowQty() > 0 && rowPerDelArray != null) {
    	  for (int j = 0; j < rowPerDelArray.getUlRowQty(); j++) {
    	  ROWDELETEEXTDOCPERSONCHECK rowPerDel =rowPerDelArray.getROWDELETEEXTDOCPERSONCHECK(j);
    	  Integer idPerson = rowPerDel.getUlIdPerson();
    	  delList.add(idPerson);
        }
      }  
      ExtDocumentation extDocumentation = new ExtDocumentation();
      //ExtDocPersonLink extDocPersonLink = new ExtDocPersonLink();

      CapsCase capsCase = getPersistentObject(CapsCase.class, rowCinv22Sig.getUlIdCase());
      extDocumentation.setCapsCase(capsCase);
      
      int idExtDoc = 0;

      //STGAP00017712: Set the new UCM ID to previous UCM ID if new document is not uploaded during the edit mode.
	  String ucmDId = StringUtils.trimToEmpty(rowCinv22Sig.getSzTxtUcmDId());
	  extDocumentation.setIdExtDocumentation(rowCinv22Sig.getUlIdExtSitInfo());
      extDocumentation.setCdExtDocType(rowCinv22Sig.getSzCdExtDocType());
      extDocumentation.setCdDocClass(rowCinv22Sig.getSzCdDocClass());
      extDocumentation.setDtExtDocObtained(DateHelper.toJavaDate(rowCinv22Sig.getDtDtExtDocObtained()));
      extDocumentation.setTxtExtDocLocation(rowCinv22Sig.getSzTxtExtDocLocation());
      extDocumentation.setTxtExtDocDetails(rowCinv22Sig.getSzTxtExtDocDetails());
      extDocumentation.setDtLastUpdate(rowCinv22Sig.getTsLastUpdate());
      extDocumentation.setCdExtDocSort(rowCinv22Sig.getSzCdExtDocSort());
      extDocumentation.setDtExtDocUploaded(DateHelper.toJavaDate(rowCinv22Sig.getDtExtDocUploaded()));
      extDocumentation.setDtExtDocAdded(DateHelper.toJavaDate(rowCinv22Sig.getDtExtDocAdded()));
      extDocumentation.setIndExtDocSigned(rowCinv22Sig.getBIndExtDocSigned());
      extDocumentation.setIndNaChecked(rowCinv22Sig.getBIndNaChecked());
      // STGAP00017712: documentExists is to verify if a file exists 
      // and is set to true if either ucmDId or blob exist.
      boolean documentExists = StringUtils.isNotBlank(ucmDId) || (extDocSI.getFileData() != null && extDocSI.getFileData().length > 0);
      extDocumentation.setTxtFileName(documentExists ? rowCinv22Sig.getSzTxtFileName() : null);
      extDocumentation.setTxtFormatType(documentExists ? rowCinv22Sig.getSzTxtFormatType() : null);
      extDocumentation.setBlExtDoc((StringUtils.isBlank(ucmDId) && extDocSI.getFileData() != null && extDocSI.getFileData().length > 0) ? (extDocSI.getFileData()) : (null));
      extDocumentation.setUcmDId(ucmDId);
      extDocumentation.setIsUcmFile(StringUtils.isNotBlank(ucmDId)? "Y" : "N");
      extDocumentation.setIndICPCDoc(rowCinv22Sig.getBIndICPCDoc());
      String cReqFuncCd = rowCinv22Sig.getSzCdScrDataAction();
      // cinv25dAUDdam
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        idExtDoc = extDocumentationDAO.saveNewExtDocumentation(extDocumentation);
        } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        extDocumentationDAO.saveExtDocumentation(extDocumentation);
        idExtDoc = extDocumentation.getIdExtDocumentation();
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
    	//Deleting Child records  
    	extDocPersonLinkDAO.deleteExtDocPersonLinkByIdExtDocumentation(rowCinv22Sig.getUlIdExtSitInfo());
    	//Deleting Parent record
        extDocumentationDAO.deleteExtDocumentation(extDocumentation);
      }
      
      if (!addList.isEmpty() && addList != null && 
    		  (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) && 
    		  !ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
    	  
          for (Iterator<Integer> it = addList.iterator(); it.hasNext();) {
        	  Integer idPersonCheck = it.next().intValue();
              Person person = personDAO.findPersonByIdPerson(idPersonCheck);
              ExtDocPersonLink extDocPersonLink = new ExtDocPersonLink();
              extDocPersonLink.setPersonByIdPerson(person);
              ExtDocumentation extDoc = extDocumentationDAO.findExtDocByIdExtDoc(idExtDoc);
              extDocPersonLink.setExtDocumentation(extDoc);
              extDocPersonLinkDAO.saveOrUpdateExtDocPersonLinkByPerson(extDocPersonLink);
            
          }
        }
      if (!delList.isEmpty() && delList != null && 
    		  (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) && 
    		  !ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
    	  extDocPersonLinkDAO.deleteExtDocPersonLinkByIdExtDocumentation(rowCinv22Sig.getUlIdExtSitInfo());
              if (!addList.isEmpty() && addList != null){
            	  for (Iterator<Integer> it = addList.iterator(); it.hasNext();) {
                	  Integer idPersonCheck = it.next().intValue();
                      Person person = personDAO.findPersonByIdPerson(idPersonCheck);
                      ExtDocPersonLink extDocPersonLink = new ExtDocPersonLink();
                      extDocPersonLink.setPersonByIdPerson(person);
                      ExtDocumentation extDoc = extDocumentationDAO.findExtDocByIdExtDoc(idExtDoc);
                      extDocPersonLink.setExtDocumentation(extDoc);
                      extDocPersonLinkDAO.saveOrUpdateExtDocPersonLinkByPerson(extDocPersonLink);
                    
                  }
            
          }
        }else
        	if (delList.isEmpty() && 
          		  (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) && 
          		  !ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
          	  extDocPersonLinkDAO.deleteExtDocPersonLinkByIdExtDocumentation(rowCinv22Sig.getUlIdExtSitInfo());
                    if (!addList.isEmpty() && addList != null){
                  	  for (Iterator<Integer> it = addList.iterator(); it.hasNext();) {
                      	  Integer idPersonCheck = it.next().intValue();
                            Person person = personDAO.findPersonByIdPerson(idPersonCheck);
                            ExtDocPersonLink extDocPersonLink = new ExtDocPersonLink();
                            extDocPersonLink.setPersonByIdPerson(person);
                            ExtDocumentation extDoc = extDocumentationDAO.findExtDocByIdExtDoc(idExtDoc);
                            extDocPersonLink.setExtDocumentation(extDoc);
                            extDocPersonLinkDAO.saveOrUpdateExtDocPersonLinkByPerson(extDocPersonLink);
                          
                        }
                  
                }
              }
      }
  }

  public String uploadDocumentToUCM(UCMDataObject ucmData) {
    String ucmDId = null;
    UCMHelper ucmHelper = new UCMHelper();
    DataBinder binder = ucmHelper.getBinder();
    if (ucmData != null && ucmData.getPrimaryFile() != null) {
      // Generate a transactionID for this transaction
      int transactionNextVal = commonDAO.getNextval("SEQ_SHINES_UCM_TX");
      String shinesUCMTxID = "SED" + String.format("%07d", transactionNextVal);
      ucmData.setTransactionID(shinesUCMTxID);

      ucmDId = ucmHelper.upload(binder, ucmData);
    }
    return ucmDId;
  }
}
