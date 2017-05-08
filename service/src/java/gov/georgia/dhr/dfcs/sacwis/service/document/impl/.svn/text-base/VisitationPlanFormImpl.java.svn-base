package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.VisitationTypeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.VisitationType;
import gov.georgia.dhr.dfcs.sacwis.service.document.VisitationPlanForm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.VISITATIONPLANFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.VISITATIONPLANFORMSO;
import java.util.Iterator;
import java.util.List;

public class VisitationPlanFormImpl extends BaseDocumentServiceImpl implements VisitationPlanForm {

  private StagePersonLinkDAO stagePersonLinkDAO;

  private PersonDAO personDAO;

  private EventDAO eventDAO;

  private VisitationTypeDAO visitationTypeDAO;

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setVisitationTypeDAO(VisitationTypeDAO visitationTypeDAO) {
    this.visitationTypeDAO = visitationTypeDAO;
  }

  public VISITATIONPLANFORMSO retrieveVisitationPlanForm(VISITATIONPLANFORMSI visitationPlanFormSI) {

    VISITATIONPLANFORMSO visitationPlanFormSO = new VISITATIONPLANFORMSO();
    int idEvent = visitationPlanFormSI.getUlIdEvent();

    Event event = eventDAO.findEventByIdEvent(idEvent);
    int idStage = event.getStage().getIdStage();
    int idCase = event.getCapsCase().getIdCase();

    PreFillData preFillData = new PreFillData();
    retrieveVisitationData(preFillData, idStage, idCase, idEvent);

    visitationPlanFormSO.setPreFillData(preFillData);
    return visitationPlanFormSO;
  }

  private void retrieveVisitationData(PreFillData preFillData, int idStage, int idCase, int idEvent) {

    int idPrimaryChild = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, CodesTables.CROLES_PC);

    if (idPrimaryChild != 0) {
      Person primaryChild = personDAO.findPersonByIdPerson(idPrimaryChild);
      String childFullName = getFullName(primaryChild);
      preFillData.addBookmark(createBookmark(CHILD_NAME, childFullName));
      populateVisitationType(preFillData, idEvent);

    }
  }

  private void populateVisitationType(PreFillData preFillData, int idEvent) {
    List<VisitationType> visitationListCbxs = visitationTypeDAO.findVisitationTypeByEvent(idEvent);
    if (visitationListCbxs != null && !visitationListCbxs.isEmpty()) {
      for (Iterator<VisitationType> it = visitationListCbxs.iterator(); it.hasNext();) {
        VisitationType vt = it.next();
        if (CodesTables.CVSTNTYP_NR.equals(vt.getCdVisitationType()) && vt.getEvent().getIdEvent().equals(idEvent)) {
          preFillData.addBookmark(createBookmark(VIS_NONRELATIV, CAPX));
        }
        if (CodesTables.CVSTNTYP_OR.equals(vt.getCdVisitationType()) && vt.getEvent().getIdEvent().equals(idEvent)) {
          preFillData.addBookmark(createBookmark(VIS_OTHERELATIV, CAPX));
        } 
        if (CodesTables.CVSTNTYP_PR.equals(vt.getCdVisitationType()) && vt.getEvent().getIdEvent().equals(idEvent)) {
          preFillData.addBookmark(createBookmark(VIS_PARENT, CAPX));
        } 
        if (CodesTables.CVSTNTYP_SB.equals(vt.getCdVisitationType()) && vt.getEvent().getIdEvent().equals(idEvent)) {
          preFillData.addBookmark(createBookmark(VIS_SIBLING, CAPX));
        } 
      }
    }
  }

  private String getFullName(Person person) {
    StringBuffer fullName = new StringBuffer();
    if (person != null) {
      fullName.append(person.getNmPersonLast());
      if (person.getNmPersonFirst() != null) {
        fullName.append(", " + person.getNmPersonFirst());
      }
      if (person.getNmPersonMiddle() != null) {
        fullName.append(" " + person.getNmPersonMiddle());
      }
      if (person.getCdPersonSuffix() != null) {
        fullName.append(" " + person.getCdPersonSuffix());
      }
    }
    return fullName.toString();
  }

}
