package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 **  07/17/2008  charden           STGAP00006557 - created new method to save person income and resources  
 *                                 info to csupParentOutbound when add is being done
 *   12/15/2008  mxpatel           STGAP00008327: wrote an IF statement to allow for saving of income and 
 *                                 resources when a case does not exist for the person. 
 *                                 (Accessing the person detail page by searching for a person, 
 *                                 and NOT through the person list of a case.) 
 *                                 
 */

import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CsupParentOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeAndResourcesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.IncomeAndResources;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveCsupParentDemographicInfo;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveIncomeAndResources;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC30SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC30SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveCsupParentDemographicInfoSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC30SO;

import gov.georgia.dhr.dfcs.sacwis.service.common.InterfaceServiceConstants;

public class SaveIncomeAndResourcesImpl extends BaseServiceImpl implements SaveIncomeAndResources {

private EligibilityDAO eligibilityDAO = null;
  
  private SaveCsupParentDemographicInfo saveCsupParentDemographicInfo = null;
  
  private IncomeAndResourcesDAO incomeAndResourcesDAO = null;
  
  private PersonIdDAO personIdDAO = null;
  
  private TodoDAO todoDAO = null;

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }
  
  public void setSaveCsupParentDemographicInfo(SaveCsupParentDemographicInfo saveCsupParentDemographicInfo) {
    this.saveCsupParentDemographicInfo = saveCsupParentDemographicInfo;
  }
  
  public void setIncomeAndResourcesDAO(IncomeAndResourcesDAO incomeAndResourcesDAO) {
    this.incomeAndResourcesDAO = incomeAndResourcesDAO;
  }
  
  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }
  
  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public CCFC30SO saveIncomeAndResources(CCFC30SI ccfc30si) throws ServiceException {
    CCFC30SO ccfc30so = new CCFC30SO();
    Todo todo = new Todo();
    String todoDesc = "";
    ROWCCFC30SIG00_ARRAY rowccfc30sig00_array = ccfc30si.getROWCCFC30SIG00_ARRAY();
    /*
     * COMMENTED OUT BY JER on 4/8/2008. Now we are allowing overlapping income of same type.
    for (Enumeration rowccfc30sig00_enum = rowccfc30sig00_array.enumerateROWCCFC30SIG00();
         rowccfc30sig00_enum.hasMoreElements();) {
      ROWCCFC30SIG00 rowccfc30sig00 = (ROWCCFC30SIG00) rowccfc30sig00_enum.nextElement();
      if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(rowccfc30sig00.getSzCdScrDataAction())) {
        List<Integer> idIncRsrcList = incomeAndResourcesDAO.findIdIncRsrcFromIncomeAndResources(
                rowccfc30sig00.getSzCdIncRsrcType(),
                rowccfc30sig00.getUlIdIncRsrc(),
                DateHelper.toJavaDate(rowccfc30sig00.getDtDtIncRsrcTo()),
                DateHelper.toJavaDate(rowccfc30sig00.getDtDtIncRsrcFrom()),
                rowccfc30sig00.getUlIdPerson(),
                rowccfc30sig00.getSzCdIncRsrcIncome());
        if (idIncRsrcList != null && !idIncRsrcList.isEmpty()) {
          //if (idIncRsrcList != null && !idIncRsrcList.isEmpty() && idIncRsrcList.size() > 1) {
          throw new ServiceException(Messages.MSG_CFC_SAME_TYPE_INC);
        }
      }
    }
    */
    for (Enumeration rowccfc30sig00_enum = rowccfc30sig00_array.enumerateROWCCFC30SIG00();
         rowccfc30sig00_enum.hasMoreElements();) {
      ROWCCFC30SIG00 rowccfc30sig00 = (ROWCCFC30SIG00) rowccfc30sig00_enum.nextElement();
      String szCdScrDataAction = rowccfc30sig00.getSzCdScrDataAction();
      String cdTask = rowccfc30sig00.getSzCdTask();
      int idStage = rowccfc30sig00.getUlIdStage();
      int idPerson = rowccfc30sig00.getUlIdPerson();
      int UlIdCase = rowccfc30sig00.getUlIdCase();
      int UlIdWorker = rowccfc30sig00.getUlIdIncRsrcWorker();
      String nmPerson = rowccfc30sig00.getSzNmPersonFull();
      IncomeAndResources incomeAndResources = new IncomeAndResources();
      incomeAndResources.setIdIncRsrc(rowccfc30sig00.getUlIdIncRsrc());
      incomeAndResources.setDtLastUpdate(rowccfc30sig00.getTsLastUpdate());
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdScrDataAction) ||
          ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdScrDataAction)) {
        incomeAndResources.setCdIncRsrcFreqType(rowccfc30sig00.getSzCdIncRsrcFreqType());
        incomeAndResources.setAmtIncRsrc(rowccfc30sig00.getLAmtIncRsrc());
        incomeAndResources.setCdIncRsrcIncome(rowccfc30sig00.getSzCdIncRsrcIncome());
        incomeAndResources.setCdIncRsrcType(rowccfc30sig00.getSzCdIncRsrcType());
        incomeAndResources.setDtIncRsrcFrom(DateHelper.toJavaDate(rowccfc30sig00.getDtDtIncRsrcFrom()));
        incomeAndResources.setDtIncRsrcTo(DateHelper.toJavaDate(rowccfc30sig00.getDtDtIncRsrcTo()));
        Person personByIdPerson = getPersistentObject(Person.class, rowccfc30sig00.getUlIdPerson());
        incomeAndResources.setPersonByIdPerson(personByIdPerson);
        Person personByIdIncRsrcWroker = getPersistentObject(Person.class, rowccfc30sig00.getUlIdIncRsrcWorker());
        incomeAndResources.setPersonByIdIncRsrcWorker(personByIdIncRsrcWroker);
        incomeAndResources.setIndIncRsrcNotAccess(rowccfc30sig00.getCIndIncRsrcNotAccess());
        incomeAndResources.setSdsIncRsrcSource(rowccfc30sig00.getSzSdsIncRrcsSource());
        incomeAndResources.setSdsIncRsrcVerfMethod(rowccfc30sig00.getSzSdsIncRsrcVerfMethod());
        incomeAndResources.setTxtIncRsrcDesc(rowccfc30sig00.getSzTxtIncRsrcDesc());
        incomeAndResources.setTxtIncRsrcSrcPhoneNum(rowccfc30sig00.getSzTxtIncRsrcSrcPhoneNum());
        incomeAndResources.setTxtIncRsrcSrcPhoneExt(rowccfc30sig00.getSzTxtIncRsrcSrcPhoneExt());
        incomeAndResources.setTxtIncRsrcSrcAddrStLn1(rowccfc30sig00.getSzTxtIncRsrcSrcAddrStLn1());
        incomeAndResources.setTxtIncRsrcSrcAddrStLn2(rowccfc30sig00.getSzTxtIncRsrcSrcAddrStLn2());
        incomeAndResources.setTxtIncRsrcSrcAddrCity(rowccfc30sig00.getSzTxtIncRsrcSrcAddrCity());
        incomeAndResources.setTxtIncRsrcSrcAddrState(rowccfc30sig00.getSzTxtIncRsrcSrcAddrState());
        incomeAndResources.setTxtIncRsrcSrcAddrZip(rowccfc30sig00.getSzTxtIncRsrcSrcAddrZip());
        incomeAndResources.setCdIncRsrcSrcAddrCounty(rowccfc30sig00.getSzCdIncRsrcSrcAddrCounty());
        incomeAndResources.setTxtIncRsrcSrcAddrCmnts(rowccfc30sig00.getSzTxtIncRsrcSrcAddrCmnts());
        incomeAndResources.setDtIncRsrcModified(DateHelper.toJavaDate(rowccfc30sig00.getDtDtIncRsrcModified()));

        // mxpatel added thish IF statement for defect #8327
        if (rowccfc30sig00.getUlIdCase() > 0) {
          CapsCase capsCase;
          capsCase = getPersistentObject(CapsCase.class, UlIdCase);
          todo.setCapsCase(capsCase);
          todo.setStage(getPersistentObject(Stage.class, idStage));
        }
        Date dateCreated = new Date();
        todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, UlIdWorker));
        todoDesc = "A change has been made to " + nmPerson + " Income and Resources";
        todo.setTxtTodoDesc(todoDesc);
          todo.setCdTodoTask(cdTask);
          todo.setCdTodoType(CodesTables.CTODOTYP_A);
          todo.setDtTodoDue(dateCreated);
          todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, UlIdWorker));
          todo.setDtTodoCreated(dateCreated);
          todoDAO.saveTodo(todo);
        incomeAndResourcesDAO.saveIncomeAndResources(incomeAndResources);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(szCdScrDataAction)) {
        incomeAndResourcesDAO.deleteIncomeAndResources(incomeAndResources);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    String szCdScrDataAction2 = rowccfc30sig00_array.getROWCCFC30SIG00(0).getSzCdScrDataAction();
    if((ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdScrDataAction2) || ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdScrDataAction2)) 
                    && (InterfaceServiceConstants.INC_RSRC_DESC_GRS.equals(rowccfc30sig00_array.getROWCCFC30SIG00(0).getSzCdIncRsrcType()) 
                                    || InterfaceServiceConstants.INC_RSRC_TYPE_SSI.equals(rowccfc30sig00_array.getROWCCFC30SIG00(0).getSzCdIncRsrcType())))
    {
      // Add code for CSUPParent Update info
      SaveCsupParentDemographicInfoSI saveCsupParentIncomeAndResourcesRowSI = new SaveCsupParentDemographicInfoSI();
      
      int idPerson2 = rowccfc30sig00_array.getROWCCFC30SIG00(0).getUlIdPerson(); 
      String cdIncRsrcType = rowccfc30sig00_array.getROWCCFC30SIG00(0).getSzCdIncRsrcType();
      String txtIncRsrcDesc = rowccfc30sig00_array.getROWCCFC30SIG00(0).getSzTxtIncRsrcDesc();
      Object[] parentInfo = personIdDAO.findDistinctParentByStagePersRelId(idPerson2);
      String txtIncRsrcSrcAddrStLn1 = rowccfc30sig00_array.getROWCCFC30SIG00(0).getSzTxtIncRsrcSrcAddrStLn1();
      String txtIncRsrcSrcAddrStLn2 = rowccfc30sig00_array.getROWCCFC30SIG00(0).getSzTxtIncRsrcSrcAddrStLn2();
      String txtIncRsrcSrcAddrCity = rowccfc30sig00_array.getROWCCFC30SIG00(0).getSzTxtIncRsrcSrcAddrCity();
      String txtIncRsrcSrcAddrState = rowccfc30sig00_array.getROWCCFC30SIG00(0).getSzTxtIncRsrcSrcAddrState();
      String txtIncRsrcSrcAddrZip = rowccfc30sig00_array.getROWCCFC30SIG00(0).getSzTxtIncRsrcSrcAddrZip();
      
      if(null != parentInfo && (ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdScrDataAction2) || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdScrDataAction2)))
      {
        saveCsupParentIncomeAndResourcesRowSI.setIdPersonId(idPerson2);
        if(null != DateHelper.toJavaDate(rowccfc30sig00_array.getROWCCFC30SIG00(0).getDtDtIncRsrcTo()))
        {
          saveCsupParentIncomeAndResourcesRowSI.setDtRsrcTo(DateHelper.toJavaDate(rowccfc30sig00_array.getROWCCFC30SIG00(0).getDtDtIncRsrcTo()));
        }
        saveCsupParentIncomeAndResourcesRowSI.setIndIncRsrcType(cdIncRsrcType != null ? cdIncRsrcType : "");
        saveCsupParentIncomeAndResourcesRowSI.setTxtIncRsrcDesc(txtIncRsrcDesc != null ? txtIncRsrcDesc : "");
        saveCsupParentIncomeAndResourcesRowSI.setTxtIncRsrcSrcAddrStLn1(txtIncRsrcSrcAddrStLn1 != null ? txtIncRsrcSrcAddrStLn1 : "");
        saveCsupParentIncomeAndResourcesRowSI.setTxtIncRsrcSrcAddrStLn2(txtIncRsrcSrcAddrStLn2 != null ? txtIncRsrcSrcAddrStLn2 : "");
        saveCsupParentIncomeAndResourcesRowSI.setTxtIncRsrcSrcAddrCity(txtIncRsrcSrcAddrCity != null ? txtIncRsrcSrcAddrCity : "");
        saveCsupParentIncomeAndResourcesRowSI.setTxtIncRsrcSrcAddrState(txtIncRsrcSrcAddrState != null ? txtIncRsrcSrcAddrState : "");
        saveCsupParentIncomeAndResourcesRowSI.setTxtIncRsrcSrcAddrZip(txtIncRsrcSrcAddrZip != null ? txtIncRsrcSrcAddrZip : "");
        if (rowccfc30sig00_array.getROWCCFC30SIG00(0).getTsLastUpdate() != null)
        {
          saveCsupParentIncomeAndResourcesRowSI.setDtCsupparRequested(rowccfc30sig00_array.getROWCCFC30SIG00(0).getTsLastUpdate());
        }
        saveCsupParentDemographicInfo.saveCsupParentDemographicInfo(saveCsupParentIncomeAndResourcesRowSI, InterfaceServiceConstants.SAVE_PERSON_INCOME_AND_RESOURCES_DETAIL, szCdScrDataAction2);
      }
    }
    /*for (Enumeration rowccfc30sig00_enum = rowccfc30sig00_array.enumerateROWCCFC30SIG00(); rowccfc30sig00_enum.hasMoreElements();) {
      ROWCCFC30SIG00 rowccfc30sig00 = (ROWCCFC30SIG00) rowccfc30sig00_enum.nextElement();
      if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(rowccfc30sig00.getSzCdScrDataAction())) {
        List<Integer> idIncRsrcList = incomeAndResourcesDAO.findIdIncRsrcFromIncomeAndResources(
                rowccfc30sig00.getSzCdIncRsrcType(),
                rowccfc30sig00.getUlIdIncRsrc(),
                DateHelper.toJavaDate(rowccfc30sig00.getDtDtIncRsrcTo()),
                DateHelper.toJavaDate(rowccfc30sig00.getDtDtIncRsrcFrom()),
                rowccfc30sig00.getUlIdPerson(),
                rowccfc30sig00.getSzCdIncRsrcIncome());
        //if (idIncRsrcList != null && !idIncRsrcList.isEmpty()) {
        if (idIncRsrcList != null && !idIncRsrcList.isEmpty() && idIncRsrcList.size() > 1) {
          throw new ServiceException(Messages.MSG_CFC_SAME_TYPE_INC);
        }
      }
    }*/
    return ccfc30so;
  }
  
  
  
}
