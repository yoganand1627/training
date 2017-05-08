package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TCMClaimDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Contact;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.db.TcmClaim;
import gov.georgia.dhr.dfcs.sacwis.service.financials.ValidateTCMClaim;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TCMClaimValidateSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TCMClaimValidateSO;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * <pre>
 * Change History:
 * Date      User         Description
 * --------  -----------  ----------------------------------------------
 * 03/26/09  Van Vo      MR-026 STGAP00013024: add Non Re-billable and Resubmitted to invalid claim list: non re-billable can   
 *                       be resubmitted so is treated as Denied and Rejected claims; Re-submission will create a new claim
 *                       so the row with Resubmitted status should not be counted as valid claim in the month to avoid double 
 *                       count and preventing resubmission multiple times. 
 * 07/28/09  arege       STGAP00014858 Modified code so that TCM contact with TCMclaim in NBL status
 *                       can be modified for 7 days.
 * 06/04/10  hanguyen    SMS# 49922: Reset time to midnight when setting billing month dates to resolve issue with getting
 *                       duplicate TCM Claims in the same billing month error message when there is not.                
 *                    
 *                      
 * </pre>
 *
 */
public class ValidateTCMClaimImpl extends BaseServiceImpl implements ValidateTCMClaim {
  private static final String CRS = CodesTables.CNUMTYPE_CRS_IDNUMBER; //"CRS ID#"
  private static final String MEMBER = CodesTables.CNUMTYPE_MEDICAIDMHN_NUMBER; //"Medicaid/MHN #"
  
  @SuppressWarnings("serial")
  private static final Set<String> INVALID_TCM_STATUS = new HashSet<String>() {
    {
      add(CodesTables.CTCMSTAT_DND); // Denied
      add(CodesTables.CTCMSTAT_REJ); // Rejected
      add(CodesTables.CTCMSTAT_VOD); // Void
      // MR-026 STGAP00013024 
      add(CodesTables.CTCMSTAT_NRB); // Non Re-billable 
      add(CodesTables.CTCMSTAT_RSU); // Resubmitted: when a TCM claim row has this status, another new claim row has already created
                                     // for this same TCM claim so this one should not be counted as an valid claim; otherwise it is double count
    }
  };
  
  private PersonIdDAO personIdDAO;
  private TCMClaimDAO tcmClaimDAO;

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public void setTcmClaimDAO(TCMClaimDAO tcmClaimDAO) {
    this.tcmClaimDAO = tcmClaimDAO;
  }

  @SuppressWarnings("serial")
  public TCMClaimValidateSO validateTCMClaim(TCMClaimValidateSI tcmClaimValidateSI) {
    TCMClaimValidateSO so = new TCMClaimValidateSO();
    
    int idPerson = tcmClaimValidateSI.getIdPerson();
    Date dtService = tcmClaimValidateSI.getDtService();
    
    //-- this next code block is specifically for resubmitted TCM claims
    int idEvent = tcmClaimValidateSI.getIdEvent();
    boolean resubmit = idEvent > 0;
    if(resubmit) {
      Contact contact = getPersistentObject(Contact.class, idEvent);
      so.setDtService(contact.getDtContactOccurred());
      so.setIdPerson(contact.getPersonByIdContactTcmClient().getIdPerson());
      so.setIdStaff(contact.getPerson().getIdPerson());
      so.setIdStage(contact.getStage().getIdStage());
      
      idPerson = so.getIdPerson();
      dtService = so.getDtService();
    }
    
    //-- 1. validate that there is no entry (eligible = YES && medSvcs = YES) for idPerson (client)
    //-- in the same billing month as entered
    Calendar cal = Calendar.getInstance();
    if(!DateHelper.isNull(dtService)) {
      cal.setTime(dtService);
    }
    // Reset time to midnight
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    
    cal.set(Calendar.DAY_OF_MONTH, 1);
    Date from = cal.getTime();
    cal.add(Calendar.MONTH, 1);
    Date to = cal.getTime();
    
    List<TcmClaim> existingClaims = tcmClaimDAO.findTcmClaim(idPerson, from, to);
    if (!ServiceConstants.REQ_FUNC_CD_UPDATE.equals(tcmClaimValidateSI.getCdReqFuncCd())) {
      if (existingClaims != null && !existingClaims.isEmpty()) {
        // -- TCM claim for person already exists in current billing month; if status is valid, throw exception
        for (TcmClaim tcmClaim : existingClaims) {
          String status = tcmClaim.getCdStatus();
          if (status != null && !INVALID_TCM_STATUS.contains(status)) {
            if (resubmit) {
              throw new ServiceException(Messages.MSG_SVC_TCM_EXISTS_RSU);
            }
            throw new ServiceException(Messages.MSG_SVC_TCM_EXISTS);
          }
        }
      }
    }
    
    //-- 2. validate that client has DOB (PERSON table) and a Medicaid or Member number (?)
    Person client = getPersistentObject(Person.class, idPerson);
    if(DateHelper.isNull(client.getDtPersonBirth())) {
      //-- no DOB
      if(resubmit) {
        throw new ServiceException(Messages.MSG_SVC_TCM_DOB_RSU);
      }
      throw new ServiceException(Messages.MSG_SVC_TCM_DOB);
    }
    
    List<PersonId> ids = personIdDAO.findPersonIdByType(idPerson, MEMBER, CRS);
    if(ids == null || ids.isEmpty()) {
      //-- no Member or CRS (Medicaid) #
      if(resubmit) {
        throw new ServiceException(Messages.MSG_SVC_TCM_ID_RSU);
      }
      throw new ServiceException(Messages.MSG_SVC_TCM_ID);
    }
    
    String number = null;
    for(PersonId id : ids) {
      if(MEMBER.equals(id.getCdPersonIdType())) {
        number = id.getNbrPersonIdNumber();
        break;
      } else {
        //-- number type is CRS, append 'P'
        number = id.getNbrPersonIdNumber() + "P";
      }
    }
    so.setNbrMedicaid(number);
    
    return so;
  }

}