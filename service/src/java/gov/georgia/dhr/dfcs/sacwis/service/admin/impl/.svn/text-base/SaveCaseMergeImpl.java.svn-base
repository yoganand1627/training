package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCaseMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CaseMerge;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveCaseMerge;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC41SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC41SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC41SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC41SO;

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  08/04/2008  arege     STGAP00007353 If the user decides to Save the Merge by clicking on Merge button,
 *                        See if there are any pending approval on events and invalidate the pending approvals.
 *  10/08/2008  arege     STGAP000010425 : "For eligibility event types(FCA, FCR, FCD) or an Initial Medicaid event type(IMA) 
 *                        we do not need to call the InvalidateApproval class but just update the status of those events to PROC
 *                        and delete the corresponding To-Dos.
 *                      
 * </pre>
 */

public class SaveCaseMergeImpl extends BaseServiceImpl implements SaveCaseMerge {

  private CaseMergeDAO caseMergeDAO = null;

  private ComplexCaseMergeDAO complexCaseMergeDAO = null;
  
  private EventDAO eventDAO = null;
  
  private ApprovalEventLinkDAO approvalEventLinkDAO = null;

  private TodoDAO todoDAO = null;
  
  private InvalidateApproval invalidateApproval = null;
  
 

  public void setCaseMergeDAO(CaseMergeDAO caseMergeDAO) {
    this.caseMergeDAO = caseMergeDAO;
  }

  public void setComplexCaseMergeDAO(ComplexCaseMergeDAO complexCaseMergeDAO) {
    this.complexCaseMergeDAO = complexCaseMergeDAO;
  }
  
  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }
  
  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public CCFC41SO saveCaseMerge(CCFC41SI ccfc41si) throws ServiceException {
    CCFC41SO ccfc41so = new CCFC41SO();
    ROWCCFC41SIG00_ARRAY rowccfc41sig00_array = ccfc41si.getROWCCFC41SIG00_ARRAY();
    Enumeration rowccfc41sig00_enum = rowccfc41sig00_array.enumerateROWCCFC41SIG00();
    while (rowccfc41sig00_enum.hasMoreElements()) {
      ROWCCFC41SIG00 rowccfc41sig00 = (ROWCCFC41SIG00) rowccfc41sig00_enum.nextElement();
      String szCdScrDataAction = rowccfc41sig00.getSzCdScrDataAction();
      Date dtLastUpdate = rowccfc41sig00.getTsLastUpdate();

     // STGAP00007353 If the user decides to Save the Merge by clicking on Merge button, See if there are
      // any pending approval on events and invalidate the pending approvals.
      //STGAP000010425 Find Pending events for both the cases i.e. CaseTo and CaseFrom 
     
      if (MERGE.equals(szCdScrDataAction)) {
        int idCaseMergeTo = rowccfc41sig00.getUlIdCaseMergeTo();
        int idCaseMergeFrom = rowccfc41sig00.getUlIdCaseMergeFrom();
        List<Integer> eventIdList = eventDAO
                                            .findEventIdByIdCaseToByIdCaseFromByCdEventStatus(idCaseMergeTo,
                                                                                              idCaseMergeFrom,
                                                                                              CodesTables.CEVTSTAT_PEND);

        // For each eventId call invalidate approval
        if (eventIdList != null && eventIdList.size() > 0) {
          for (int i = 0; i < eventIdList.size(); i++) {
            int pendEventId = eventIdList.get(i).intValue();
            CCMN05UI ccmn05ui = new CCMN05UI();
            ccmn05ui.setArchInputStruct(new ArchInputStruct());
            String cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
            ccmn05ui.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
            ccmn05ui.getArchInputStruct().setUlSysNbrReserved1(ArchitectureConstants.N);
            ccmn05ui.setUlIdEvent(pendEventId);
            
            String eventType = eventDAO.findCdEventTypeByIdEvent(pendEventId);

            // STGAP000010425 :We need to check to see if the event is any of the Eligibility event types(FCA, FCR, FCD)
            // or an Initial Medicaid event type(IMA) and if it is, we do not need to call the InvalidateApproval class
            // but just update the status of those events to PROC.

            if (!(CodesTables.CEVNTTYP_FCA.equals(eventType) || CodesTables.CEVNTTYP_FCR.equals(eventType)
                  || CodesTables.CEVNTTYP_FCD.equals(eventType) || CodesTables.CEVNTTYP_IMA.equals(eventType))) {
              invalidateApproval.invalidateApproval(ccmn05ui);
              int rowsUpdated = eventDAO.updateEventByIdEvent(pendEventId, CodesTables.CEVTSTAT_PROC);
              if (0 == rowsUpdated) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }

              // This should be done in the invalidate approval but if it is not, its getting done here.
              List<Integer> approvalEventLink = approvalEventLinkDAO.findIdApprovalEventLinksByIdEvent(pendEventId);
              if (approvalEventLink != null || !approvalEventLink.isEmpty()) {
                approvalEventLinkDAO.deleteApprovalEventLinkByIdEvent(pendEventId);
              }

            } else {
              // For FCA,FCR,FCD,IMA event types are not associated with approvals
              // so don't need to call invalidate approval for them, need to
              // update event status to 'PROC' and delete the associated Todo(s) so that it/they
              // no longer show up on any To-Do List page
              int rowsUpdated = eventDAO.updateEventByIdEvent(pendEventId, CodesTables.CEVTSTAT_PROC);
              if (0 == rowsUpdated) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }
              // For FCA,FCR,FCD,IMA event types we need to delete the associated Todo(s) so that it/they
              // no longer show up on any To-Do List page
              long noOfTodos = todoDAO.countIdToDoFromToDoByIdToEvent(pendEventId);
              if (noOfTodos != 0) {
                todoDAO.deleteTodoByIdTodoEvent(pendEventId);
              }
            }

          }
        }
      }

      // caud94d
      String cReqFuncCd;
      if (MERGE.equals(szCdScrDataAction) || SPLIT.equals(szCdScrDataAction)) {
        cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
      } else { // should be a else if here
        cReqFuncCd = ServiceConstants.REQ_FUNC_CD_DELETE;
      }

      String indCaseMergePending;
      if (MERGE.equals(szCdScrDataAction) || VOID_MERGE.equals(szCdScrDataAction)) {
        indCaseMergePending = MERGE;
      } else {
        indCaseMergePending = SPLIT;
      }

      int idCaseMerge = rowccfc41sig00.getUlIdCaseMerge();
      if (MERGE.equals(szCdScrDataAction) || SPLIT.equals(szCdScrDataAction)) {
        CaseMerge caseMerge = new CaseMerge();
        caseMerge.setDtCaseMerge(DateHelper.toJavaDate(rowccfc41sig00.getDtDtCaseMerge()));
        caseMerge.setIdCaseMerge(rowccfc41sig00.getUlIdCaseMerge());
        CapsCase capsCaseByIdCaseMergeFrom = (CapsCase) getPersistentObject(CapsCase.class,
                                                                            rowccfc41sig00.getUlIdCaseMergeFrom());
        caseMerge.setCapsCaseByIdCaseMergeFrom(capsCaseByIdCaseMergeFrom);
        if (MERGE.equals(szCdScrDataAction)) {
          Person personByIdCaseMergePersMrg = (Person) getPersistentObject(Person.class,
                                                                           rowccfc41sig00.getUlIdCaseMergePersMrg());
          caseMerge.setPersonByIdCaseMergePersMrg(personByIdCaseMergePersMrg);
        }
        if (SPLIT.equals(szCdScrDataAction)) {
          Person personByIdCaseMergePersSplit = (Person) getPersistentObject(Person.class,
                                                                             rowccfc41sig00.getUlIdCaseMergePersSplit());
          caseMerge.setPersonByIdCaseMergePersSplit(personByIdCaseMergePersSplit);
        }
        CapsCase capsCaseByIdCaseMergeTo = (CapsCase) getPersistentObject(CapsCase.class,
                                                                          rowccfc41sig00.getUlIdCaseMergeTo());
        caseMerge.setCapsCaseByIdCaseMergeTo(capsCaseByIdCaseMergeTo);
        caseMerge.setIndCaseMergeInvalid(rowccfc41sig00.getCIndCaseMergeInv());
        caseMerge.setDtLastUpdate(dtLastUpdate);
        caseMerge.setIndCaseMergePending(indCaseMergePending);
        caseMerge.setDtCaseMergeSplit(DateHelper.toJavaDate(rowccfc41sig00.getDtCaseMergeSplit()));
        // caud94d
        caseMergeDAO.saveCaseMerge(caseMerge);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
        // caud94d
        if (0 == caseMergeDAO.deleteCaseMergeSafe(idCaseMerge, dtLastUpdate)) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      // Retrieval dam called to check if the inserted Merge is not a circular loop.
      // Exp: ID TO = 1 ID FROM = 2
      // ID TO = 2 ID FROM = 1
      if (MERGE.equals(szCdScrDataAction)) {
        // cmsc38d
        complexCaseMergeDAO.findCaseMerge(rowccfc41sig00.getUlIdCaseMergeTo());
        // Todo: We need to determine how to trap what used to be 'Messages.MSG_CFC_CONNECT_BY_LOOP'
        // CONNECT_BY_LOOP was defined locally = -1436
        // case CONNECT_BY_LOOP:
        // pServiceStatus.explan_code = Messages.MSG_CFC_CONNECT_BY_LOOP;
      }
    }
    return ccfc41so;
  }
}
