package gov.georgia.dhr.dfcs.sacwis.service.fad.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NonComplianceCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NonComplianceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NonComplianceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.NonCompliance;
import gov.georgia.dhr.dfcs.sacwis.db.NonComplianceCbx;
import gov.georgia.dhr.dfcs.sacwis.db.NonComplianceChild;
import gov.georgia.dhr.dfcs.sacwis.service.fad.RetrieveNonCompliance;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NcCbx;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NcEvent;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NonComplianceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NcPerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonComplianceSO;

public class RetrieveNonComplianceImpl extends BaseServiceImpl implements RetrieveNonCompliance {
  private CapsResourceDAO capsResourceDAO = null;

  private NonComplianceCbxDAO nonComplianceCbxDAO = null;

  private NonComplianceChildDAO nonComplianceChildDAO = null;

  private NonComplianceDAO nonComplianceDAO = null;

  private static final String DFCS_FA_HOME = "DFCS F/A Home";

  private static final String NON_DFCS_FA_HOME = "Non DFCS F/A Home";

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setNonComplianceCbxDAO(NonComplianceCbxDAO nonComplianceCbxDAO) {
    this.nonComplianceCbxDAO = nonComplianceCbxDAO;
  }

  public void setNonComplianceChildDAO(NonComplianceChildDAO nonComplianceChildDAO) {
    this.nonComplianceChildDAO = nonComplianceChildDAO;
  }

  public void setNonComplianceDAO(NonComplianceDAO nonComplianceDAO) {
    this.nonComplianceDAO = nonComplianceDAO;
  }

  public NonComplianceSO retrieveNonCompliance(NonComplianceSI input) {
    NonComplianceSO nonComplianceSO = new NonComplianceSO();
    NonCompliance nonCompliance = nonComplianceDAO.findNonComplianceByIdEventIdCase(input.getIdEvent(),
                                                                                    input.getIdCase());
    // Compile NonComplianceSO object by retrieving from NonCompliance, NonComplianceCbx and
    // NonComplianceChild tables.
    // Get NonCompliance data
    int idNonCompliance = nonCompliance.getIdNonCompliance();
    nonComplianceSO.setIdNonCompliance(nonCompliance.getIdNonCompliance());
    nonComplianceSO.setDtLastUpdate(nonCompliance.getDtLastUpdate());
    nonComplianceSO.setIdEvent(nonCompliance.getEvent().getIdEvent());
    nonComplianceSO.setIdCase(nonCompliance.getCapsCase().getIdCase());
    nonComplianceSO.setCdNonCompliance(nonCompliance.getCdNonCompliance());
    nonComplianceSO.setIndDocCompleted(nonCompliance.getIndDocCompleted());
    nonComplianceSO.setDtTracking(nonCompliance.getDtTracking());
    nonComplianceSO.setTxtComments(nonCompliance.getTxtComments());
    nonComplianceSO.setCdCounty(nonCompliance.getCdCounty());
    nonComplianceSO.setDtOfViolation(nonCompliance.getDtOfViolation());
    nonComplianceSO.setDtEffectFrom(nonCompliance.getDtEffectFrom());
    nonComplianceSO.setDtEffectTo(nonCompliance.getDtEffectTo());
    nonComplianceSO.setDtStOffCon(nonCompliance.getDtStOffConcurrence());
    nonComplianceSO.setIndStOffCon(nonCompliance.getIndStOffConcurrence());
    nonComplianceSO.setDtCpaCon(nonCompliance.getDtCpaConcurrence());
    nonComplianceSO.setIndCpaCon(nonCompliance.getIndCpaConcurrence());
    NcEvent ncEvent = new NcEvent();
    ncEvent.setEventId(nonCompliance.getEvent().getIdEvent());
    ncEvent.setDateLastUpdate(nonCompliance.getEvent().getDtLastUpdate());
    ncEvent.setStageId(nonCompliance.getEvent().getStage().getIdStage());
    ncEvent.setEventTypeCode(nonCompliance.getEvent().getCdEventType());
    ncEvent.setCaseId(nonCompliance.getEvent().getCapsCase().getIdCase());
    ncEvent.setPersonId(nonCompliance.getEvent().getPerson().getIdPerson());
    ncEvent.setEventTaskCode(nonCompliance.getEvent().getCdTask());
    ncEvent.setEventDescription(nonCompliance.getEvent().getTxtEventDescr());
    ncEvent.setDateEventOccurred(nonCompliance.getEvent().getDtEventOccurred());
    ncEvent.setEventStatusCode(nonCompliance.getEvent().getCdEventStatus());
    nonComplianceSO.setNcEvent(ncEvent);
    String sysTxtTableName = Lookup.simpleDecodeSafe(CodesTables.CEVNTTBL, nonCompliance.getCdNonCompliance());
    // Load the Home Type value from the Caps Resource table for the given Case ID
    if (nonCompliance.getEvent() != null) {
      CapsResource capsResource = capsResourceDAO.findCapsResourceByIdCase(nonCompliance.getEvent().getCapsCase()
                                                                                        .getIdCase());
      if (capsResource.getIndRsrcNonDfcs() != null && capsResource.getIndRsrcNonDfcs().equals("Y")) {
        nonComplianceSO.setHomeType(NON_DFCS_FA_HOME);
      } else {
        nonComplianceSO.setHomeType(DFCS_FA_HOME);
      }
    } else {
      // Setting as DFCS F/A Home
      nonComplianceSO.setHomeType(DFCS_FA_HOME);
    }
    Date narrativeDate = commonDAO.findDtLastUpdate(sysTxtTableName, input.getIdEvent());

    if (!DateHelper.isNull(narrativeDate)) {
      nonComplianceSO.setDtFormLastDate(narrativeDate);
    } else {
      // Stubbing to test whether the approval portion works or not.
      nonComplianceSO.setDtFormLastDate(null);
    }

    // Get PolicyViolation Check boxes from NonComplianceCbx table.
    List<NonComplianceCbx> nonComplianceCbxes = nonComplianceCbxDAO
                                                                   .findNonCompliancecheckboxbyIdNonComplianceandCbxCodeType(
                                                                                                                             idNonCompliance,
                                                                                                                             CodesTables.CPOLVIOL);
    List<NcCbx> nonCompCbxes = new ArrayList<NcCbx>();
    Iterator<NonComplianceCbx> itrNonCompCbxes = nonComplianceCbxes.iterator();
    while (itrNonCompCbxes.hasNext()) {
      NonComplianceCbx nonComplianceCbx = (NonComplianceCbx) itrNonCompCbxes.next();
      NcCbx ncCbx = new NcCbx();
      ncCbx.setCdNonComplianceCbx(nonComplianceCbx.getCdNonComplianceCbx());
      ncCbx.setDtLastUpdate(nonComplianceCbx.getDtLastUpdate());
      ncCbx.setCdNonComplianceCbxType(nonComplianceCbx.getCdNonComplianceCbxType());
      ncCbx.setIdNonCompliance(nonComplianceCbx.getNonCompliance().getIdNonCompliance());
      ncCbx.setIdNonComplianceCbx(nonComplianceCbx.getIdNonComplianceCbx());
      nonCompCbxes.add(ncCbx);
    }
    nonComplianceSO.setNcCbx(nonCompCbxes);

    // Get NonComplianceChild data
    List<NonComplianceChild> nonCompChildren = nonComplianceChildDAO
                                                                    .findNonComplianceChildbyIdNonCompliance(idNonCompliance);
    List<NcPerson> nonCompChildrenOP = new ArrayList<NcPerson>();
    Iterator<NonComplianceChild> itrNonCompChildren = nonCompChildren.iterator();
    while (itrNonCompChildren.hasNext()) {
      NonComplianceChild nonComplianceChild = itrNonCompChildren.next();
      NcPerson ncPerson = new NcPerson();
      ncPerson.setIdPerson(nonComplianceChild.getId().getIdPerson());
      ncPerson.setIndAdoptiveProcess(nonComplianceChild.getIndAdoptiveProcess());
      ncPerson.setIndHomeViolation(nonComplianceChild.getIndHomeViolation());
      ncPerson.setDtLastUpdate(nonComplianceChild.getDtLastUpdate());
      nonCompChildrenOP.add(ncPerson);
    }
    nonComplianceSO.setChildrenInHome(nonCompChildrenOP);
    return nonComplianceSO;
  }

}
