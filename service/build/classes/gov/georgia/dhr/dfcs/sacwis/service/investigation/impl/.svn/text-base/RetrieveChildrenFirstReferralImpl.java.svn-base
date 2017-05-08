/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ChildrenFirstReferralDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ChildrenFirstReferral;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RetrieveChildrenFirstReferral;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildrenFirstReferralRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildrenFirstReferralRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;

import java.util.Date;

 /**
 * 
 * This class provides a service that retrieves the Children 1st Referral data.
 *
 * @author ashwini.rege
 * 
 * Change History:
 *  Date        User              Description
 *  --------    ----------------  ----------------------------------------------------------------
 *  02/08/2010   arege            STGAP00015749: Added code for the new field Release on File.
 */
public class RetrieveChildrenFirstReferralImpl extends BaseServiceImpl implements RetrieveChildrenFirstReferral {

  private ChildrenFirstReferralDAO childrenFirstReferralDAO = null;

  private EventDAO eventDAO = null;
  
  private PersonDAO personDAO = null;

  public void setChildrenFirstReferralDAO(ChildrenFirstReferralDAO childrenFirstReferralDAO) {
    this.childrenFirstReferralDAO = childrenFirstReferralDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public ChildrenFirstReferralRetrieveSO retrieveChildrenFirstReferral(
                                                                       ChildrenFirstReferralRetrieveSI childrenFirstReferralRetrieveSI)
                                                                                                                                       throws ServiceException {
    ChildrenFirstReferralRetrieveSO childrenFirstReferralRetrieveSO = new ChildrenFirstReferralRetrieveSO();
    int idEvent = childrenFirstReferralRetrieveSI.getUlIdEvent();
    // If the event Already exists
    if (idEvent != 0) {
      Event event = eventDAO.findEventByIdEvent(idEvent);
      if (event == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      ROWCCMN45DO rowccmn45do = new ROWCCMN45DO();
      rowccmn45do.setSzCdEventType(event.getCdEventType());
      rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
      rowccmn45do.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
      rowccmn45do.setUlIdStage(event.getStage() != null ? event.getStage().getIdStage() : 0);
      rowccmn45do.setUlIdPerson(event.getPerson() != null ? event.getPerson().getIdPerson() : 0);
      rowccmn45do.setSzTxtEventDescr(event.getTxtEventDescr());
      rowccmn45do.setSzCdTask(event.getCdTask());
      rowccmn45do.setSzCdEventStatus(event.getCdEventStatus());
      rowccmn45do.setTsLastUpdate(event.getDtLastUpdate());
      childrenFirstReferralRetrieveSO.setRowccmn45do(rowccmn45do);
      
      // Checking to see if form exists to see on the docExists tag on the jsp
      
      String tableName = "SCREENING_REF_NARR";
      Date lastUpdate = commonDAO.findDtLastUpdate(tableName, idEvent);
      if (DateHelper.isNull(lastUpdate)) {
        childrenFirstReferralRetrieveSO.setBIndBLOBExistsInDatabase(ArchitectureConstants.FALSE);
      } else {
        childrenFirstReferralRetrieveSO.setBIndBLOBExistsInDatabase(ArchitectureConstants.TRUE);
      }
      
      

      // Get the Children First Referral record for that event.
      ChildrenFirstReferral childrenFstRefRec = childrenFirstReferralDAO.findChildrenFirstReferralByIdEvent(idEvent);

      if (childrenFstRefRec.getDtGeneration() != null) {
        childrenFirstReferralRetrieveSO.setDtDtGeneration(childrenFstRefRec.getDtGeneration());
      }
      childrenFirstReferralRetrieveSO.setDtDtReferralSent(childrenFstRefRec.getDtReferralSent());
      childrenFirstReferralRetrieveSO.setIndParentalRelease(childrenFstRefRec.getIndParentalRelease());
      childrenFirstReferralRetrieveSO.setRelOnFile(childrenFstRefRec.getRelOnFile());
      childrenFirstReferralRetrieveSO.setTxtComments(childrenFstRefRec.getTxtComments());
      childrenFirstReferralRetrieveSO.setIdCase(childrenFstRefRec.getCapsCase().getIdCase());
      childrenFirstReferralRetrieveSO.setIdEvent(childrenFstRefRec.getIdEvent());
      childrenFirstReferralRetrieveSO.setIndComplete(childrenFstRefRec.getIndComplete());
      childrenFirstReferralRetrieveSO.setDtDtAcknowledge(childrenFstRefRec.getDtAcknowledge());
      childrenFirstReferralRetrieveSO.setDtLastUpdate(childrenFstRefRec.getDtLastUpdate());
      childrenFirstReferralRetrieveSO.setIdChildReferred(childrenFstRefRec.getIdChildReferred());
      childrenFirstReferralRetrieveSO.setDtPhySummary(childrenFstRefRec.getDtPhySummary());
      childrenFirstReferralRetrieveSO.setIndFurtherAssmt(childrenFstRefRec.getIndFurtherAssmt());
      if (childrenFstRefRec.getDtIfsp() != null) {
        childrenFirstReferralRetrieveSO.setDtIFSP(childrenFstRefRec.getDtIfsp());
      }
      if (childrenFstRefRec.getEventByIdGenerationEvent() != null
          && childrenFstRefRec.getEventByIdGenerationEvent().getIdEvent() != null) {
        childrenFirstReferralRetrieveSO.setIdGenerationEvent(childrenFstRefRec.getEventByIdGenerationEvent()
                                                                              .getIdEvent());
      }
      
      Integer idChild = childrenFstRefRec.getIdChildReferred();
      if(idChild != null) {
        childrenFirstReferralRetrieveSO.setChildName(personDAO.findNmFullByIdPerson(idChild));
      }
    }
    return childrenFirstReferralRetrieveSO;
  }

}

