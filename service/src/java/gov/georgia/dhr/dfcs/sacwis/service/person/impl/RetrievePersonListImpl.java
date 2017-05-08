package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCategory;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrievePersonList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEventBLOB_ARRAY;

/*Change History:
Date             User              Description
--------         ----------------  --------------------------------------------------
01/22/2009       hnguyen           STGAP00010818: Update findStagePersonLinkAndAllegationHistory
                                   method to set archOutputStruct.bMoreDataInd to 
                                   stagePersonLinkList.bMoreDataInd for Person List pagination to
                                   work.
12/04/2008       arege             STGAP0010668: Set SzTxtOtherRelationshipsCmnts in the 
                                   rowcinv01sog00 object  so that the Special Rel Column 
                                   is populated on the Person List Page.
10/30/2008      mxpatel            STGAP00009628:  Added code to handle cases which has 
                                   person/s with no names.      
11/25/09        arege              SMS#37361 Show Non-Incident AFCARS Information tab only if 
                                   the child is an non-incident child                              
*/


public class RetrievePersonListImpl extends BaseServiceImpl implements RetrievePersonList {

  private AllegationHistoryDAO allegationHistoryDAO = null;

  private DynamicEventDAO dynamicEventDAO = null;

  private EventDAO eventDAO = null;

  private PersonCategoryDAO personCategoryDAO = null;

  private PersonMergeDAO personMergeDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private StageLinkDAO stageLinkDAO = null;

  public void setAllegationHistoryDAO(AllegationHistoryDAO allegationHistoryDAO) {
    this.allegationHistoryDAO = allegationHistoryDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPersonCategoryDAO(PersonCategoryDAO personCategoryDAO) {
    this.personCategoryDAO = personCategoryDAO;
  }

  public void setPersonMergeDAO(PersonMergeDAO personMergeDAO) {
    this.personMergeDAO = personMergeDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public CINV01SO retrievePersonList(CINV01SI cinv01si) throws ServiceException {
    CINV01SO cinv01so = new CINV01SO();
    ArchInputStruct archInputStruct = cinv01si.getArchInputStruct();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();
    // check to see if the Case indicator is true. If so Call the DAM
    // to retrieve everyone from the case. If not Call the DAM to
    // Retrieve everyone from the Stage
    if (StringHelper.isTrue(cinv01si.getBSysIndCase())) {
      // CallCINV58D
      findUnstaffedStagePersonLink(cinv01si.getUlIdCase(), cinv01so, pageNbr, pageSize);
    } else {
      // CallCINV34D
      findStagePersonLinkAndAllegationHistory(cinv01si.getUlIdStage(), cinv01si.getSzCdStageProgram(),
                                              cinv01si.getSzSysCdWinMode(), cinv01so, archInputStruct.getUsPageNbr(),
                                              archInputStruct.getUlPageSizeNbr());
      findEvents(cinv01si.getUlIdStage(), cinv01so);
    }
    findEventByIdStageAndCdEventType(cinv01si.getUlIdStage(), cinv01so);
    
    //SMS#37361 Check if the case is a non incident
    boolean isNonIncident = checkIfNonIncident(cinv01si.getUlIdStage());
    cinv01so.setBIndNonIncident(isNonIncident);   
      
    return cinv01so;
  }

  private void findEventByIdStageAndCdEventType(int idStage, CINV01SO cinv01so) {
    String cdEventType = CodesTables.CEVNTTYP_NOT;
    BIndBLOBExistsInDatabase_ARRAY bIndBLOBExistsInDatabase_array = new BIndBLOBExistsInDatabase_ARRAY();
    bIndBLOBExistsInDatabase_array.addBIndBLOBExistsInDatabase(TDMHMR_BLOB_STRUCT_INDEX, ArchitectureConstants.N);
    bIndBLOBExistsInDatabase_array.addBIndBLOBExistsInDatabase(MHMR_BLOB_STRUCT_INDEX, ArchitectureConstants.N);
    List<Event> eventList = eventDAO.findEventByIdStageAndCdEventType(idStage, cdEventType);

    if (eventList != null && !eventList.isEmpty()) {
      UlIdEventBLOB_ARRAY idEvent_array = new UlIdEventBLOB_ARRAY();
      for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
        Event event = it.next();
        String txtEventDescr = event.getTxtEventDescr();
        if (FLR_EVENT_DESC_INIT_TDMHMR.equals(txtEventDescr)
            && !(bIndBLOBExistsInDatabase_array.getBIndBLOBExistsInDatabase(TDMHMR_BLOB_STRUCT_INDEX) != null)) {
          idEvent_array.setUlIdEventBLOB(TDMHMR_BLOB_STRUCT_INDEX, event.getIdEvent());
          bIndBLOBExistsInDatabase_array.addBIndBLOBExistsInDatabase(TDMHMR_BLOB_STRUCT_INDEX, ArchitectureConstants.Y);
        } else if (FLR_EVENT_DESC_INIT_MHMR.equals(txtEventDescr)
                   && !(bIndBLOBExistsInDatabase_array.getBIndBLOBExistsInDatabase(MHMR_BLOB_STRUCT_INDEX) != null)) {
          idEvent_array.setUlIdEventBLOB(MHMR_BLOB_STRUCT_INDEX, event.getIdEvent());
          bIndBLOBExistsInDatabase_array.addBIndBLOBExistsInDatabase(MHMR_BLOB_STRUCT_INDEX, ArchitectureConstants.Y);
        }
      }
      cinv01so.setUlIdEventBLOB_ARRAY(idEvent_array);
    }
    cinv01so.setBIndBLOBExistsInDatabase_ARRAY(bIndBLOBExistsInDatabase_array);
  }

  private void findEvents(int idStage, CINV01SO cinv01so) throws ServiceException {
    String cdEventType = CodesTables.CEVNTTYP_ASM;
    String[] cdEventTypes = new String[1];
    cdEventTypes[0] = cdEventType;
    List<Object[]> objectArrayList = dynamicEventDAO.findEvents(false, 0, idStage, 0, 0, 0, cdEventTypes, null, null,
                                                                null, null, null);
    cinv01so.setUlIdEvent(0);
    if (objectArrayList != null && !objectArrayList.isEmpty()) {
      for (Iterator<Object[]> it = objectArrayList.iterator(); it.hasNext();) {
        Object[] objectArray = it.next();
        String txtEventDescr = (String) objectArray[10];
        String cdTask = (String) objectArray[11];
        String cdEventStatus = (String) objectArray[0];
        int idEvent = (Integer) objectArray[6];
        if (!IRA.equals(txtEventDescr)) {
          if (RISK_ASSMNT_TASK.equals(cdTask)
              && (CodesTables.CEVTSTAT_PEND.endsWith(cdEventStatus) || (CodesTables.CEVTSTAT_COMP.equals(
                  cdEventStatus)))) {
            cinv01so.setUlIdEvent(idEvent);
            cinv01so.setSzCdEventStatus(cdEventStatus);
          }
        }
      }
    }
  }

  private void findStagePersonLinkAndAllegationHistory(int idStage, String cdStageProgram, String sysCdWinMode,
                                                       CINV01SO cinv01so, int pageNbr, int pageSize) {
    // CallCINV34D
    List<StagePersonLink> principalList;
    List<StagePersonLink> collateralList;
    List<StagePersonLink> consolidatedList;
    List<StagePersonLink> tempSwap;
    List<StagePersonLink> badRoleTypeList;
    List<StagePersonLink> reporterList;
    List<StagePersonLink> primaryChildList;
    //
    // Loop thru both the MergeTo Person and MergeFrom Person
    // struct. If same Person is found in both the cases
    // which has a Person role of Primary Child and belongs
    // to the same stage Than set the Duplicate flag to TRUE.

    // The final listing cannot have any duplicates, so the following
    // code makes sure that every IdPerson is unique in the list.

    principalList = new ArrayList<StagePersonLink>();
    collateralList = new ArrayList<StagePersonLink>();
    consolidatedList = new ArrayList<StagePersonLink>();

    // Loop through Reporter Array first and add Reporters
    // to Output Message first, so they will appear first in the listbox.

    tempSwap = new ArrayList<StagePersonLink>();

    badRoleTypeList = new ArrayList<StagePersonLink>();

    // Loop through Primary Child Array to place the primary child
    // after the reporter in the listbox.

    reporterList = new ArrayList<StagePersonLink>();

    primaryChildList = new ArrayList<StagePersonLink>();
    String cdStagePersType = CodesTables.CPRSNALL_STF;
    // int pageNbr = 0;
    // int pageSize = 0;

    PaginatedHibernateList<StagePersonLink> stagePersonLinkList = stagePersonLinkDAO
            .findStagePersonLinkAndPersonByidStageAndCdStagePersType(
                    idStage,
                    cdStagePersType,
                    pageNbr,
                    pageSize);
    if (stagePersonLinkList != null && !stagePersonLinkList.isEmpty()) {

      // Read consolidatedList up to current number of rows
      for (Iterator<StagePersonLink> it = stagePersonLinkList.iterator(); it.hasNext();) {
        StagePersonLink stagePersonLink = it.next();
        Person person = stagePersonLink.getPerson();
        // TODO - add suffix back in
        // String nmPersonFull = person.getNmPersonFull() + " " + person.getCdPersonSuffix();
        // nmPersonFull = nmPersonFull.trim();
        // person.setNmPersonFull(nmPersonFull);
      }
    }

    // int q = 0;
    // int z = 0;
    // int c = 0;
    // int d = 0;
    for (Iterator<StagePersonLink> it = stagePersonLinkList.iterator(); it.hasNext();) {
      StagePersonLink stagePersonLink = it.next();
      String cdStagePersRole = stagePersonLink.getCdStagePersRole();
      if (ArchitectureConstants.Y.equals(stagePersonLink.getIndStagePersReporter())) {
        reporterList.add(stagePersonLink);
      } else if (CodesTables.CROLES_PC.equals(cdStagePersRole)) {
        primaryChildList.add(stagePersonLink);
      } else if (CodesTables.CPRSNTYP_PRN.equals(stagePersonLink.getCdStagePersType())) {
        // int p = 0;
        if ((CodesTables.CROLES_VC.equals(cdStagePersRole)) || (CodesTables.CROLES_VP.equals(cdStagePersRole))
            || (CodesTables.CROLES_AP.equals(cdStagePersRole)) || (CodesTables.CROLES_NO.equals(cdStagePersRole))
            || (CodesTables.CROLES_UD.equals(cdStagePersRole)) || (CodesTables.CROLES_UM.equals(cdStagePersRole))
            || (CodesTables.CROLES_UC.equals(cdStagePersRole)) || (CodesTables.CROLES_UK.equals(cdStagePersRole))
            || (CodesTables.CROLEALL_SP.equals(cdStagePersRole)) || (CodesTables.CROLEALL_DB.equals(cdStagePersRole))
            || (CodesTables.CROLEALL_DV.equals(cdStagePersRole)) || (CodesTables.CROLEALL_DP.equals(cdStagePersRole))) {
          principalList.add(stagePersonLink);
        } else {
          badRoleTypeList.add(stagePersonLink);
        }
      } else if ((CodesTables.CROLES_NO.equals(cdStagePersRole))
                 && (CodesTables.CPRSNTYP_COL.equals(stagePersonLink.getCdStagePersType()))) {
        collateralList.add(stagePersonLink);
      } else {
        badRoleTypeList.add(stagePersonLink);
      }
    }
    int i = 0;
    int j;
    while (i < reporterList.size()) {

      j = reporterList.size() - 1;

      while (j > i) {
        Date date1 = reporterList.get(j - 1).getPerson().getDtPersonBirth();
        Date date2 = reporterList.get(j).getPerson().getDtPersonBirth();
        if (DateHelper.isBefore(date1, date2)) {
          tempSwap.add(reporterList.get(j));
          reporterList.set(j, reporterList.get(j - 1));
          reporterList.set(j - 1, tempSwap.get(0));
          tempSwap.remove(0);
        }

        j--;
      }
      i++;
    }
    i = 0;
    while (i < principalList.size()) {
      j = principalList.size() - 1;

      while (j > i) {
        // Added check for sensitive cases, if the indicator is true, // Set the flag to TRUE, do NOT send the row back
        // to the
        // client.Added a second counter (d) to keep track of the row that
        // we are on in the DAM output message.

        // ERR #1459: The MSG_CMN_SENSITIVE_EVENTS message will only be sent
        // back if the case is sensitve AND the users does not have permission
        // to view sensitive cases.
        Date date1 = principalList.get(j - 1).getPerson().getDtPersonBirth();
        Date date2 = principalList.get(j).getPerson().getDtPersonBirth();
        if (DateHelper.isBefore(date1, date2)) {
          tempSwap.add(principalList.get(j));
          principalList.set(j, principalList.get(j - 1));
          principalList.set(j - 1, tempSwap.get(0));
          tempSwap.remove(0);
        }
        j--;
      }
      i++;
    }
    i = 0;
    while (i < collateralList.size()) {
      j = collateralList.size() - 1;

      while (j > i) {
        //mxpatel commented this IF statement out for defect #9628
      /*  if ((collateralList.get(j).getPerson().getNmPersonFull() != null)
            && (0 > collateralList.get(j).getPerson().getNmPersonFull().compareTo(
                collateralList.get(j - 1).getPerson()
                        .getNmPersonFull()))) {*/
        
        //mxpatel added this IF statement for defect #9628
        if (0 > StringHelper.getNonNullString(collateralList.get(j).getPerson().getNmPersonFull())
                            .compareTo(StringHelper.getNonNullString(collateralList.get(j - 1).getPerson()
                                                                                   .getNmPersonFull()))) {
          tempSwap.add(collateralList.get(j));
          collateralList.set(j, collateralList.get(j - 1));
          collateralList.set(j - 1, tempSwap.get(0));
          tempSwap.remove(0);
        }
        j--;
      }
      i++;
    }

    int n = 0;
    // Read consolidatedList up to current number of rows
    // checking for duplicates
    n = assignToconsolidatedListStagePersonLinkValue(reporterList, consolidatedList, n);
    n = assignToconsolidatedListStagePersonLinkValue(primaryChildList, consolidatedList, n);
    n = assignToconsolidatedListStagePersonLinkValue(principalList, consolidatedList, n);
    n = assignToconsolidatedListStagePersonLinkValue(collateralList, consolidatedList, n);
    n = assignToconsolidatedListStagePersonLinkValue(badRoleTypeList, consolidatedList, n);

    cinv01so.setDtWCDDtSystemDate(DateHelper.getTodayCastorDate());
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    int rowQty = 0;
    archOutputStruct.setUlRowQty(rowQty);
    if ((CodesTables.CPGRMS_AFC.equals(cdStageProgram)) && ALLEGED_PERPS_ONLY.equals(sysCdWinMode)) {
      List<Integer> personByIdAllegedPerpetratorList = allegationHistoryDAO
              .findAllegationHistoryIdAllegedPerpetrator(idStage);
      if (personByIdAllegedPerpetratorList != null && !personByIdAllegedPerpetratorList.isEmpty()) {
        ROWCINV01SOG00_ARRAY rowcinv01sog00_array = new ROWCINV01SOG00_ARRAY();
        for (Iterator<Integer> it = personByIdAllegedPerpetratorList.iterator(); it.hasNext();) {
          ROWCINV01SOG00 rowcinv01sog00 = new ROWCINV01SOG00();
          for (Iterator<StagePersonLink> consolidate_it = consolidatedList.iterator(); consolidate_it.hasNext();) {
            StagePersonLink consolidate = consolidate_it.next();
            Person person = consolidate.getPerson();
            int idPerson = person.getIdPerson();
            if (0 != idPerson) {
              if (idPerson == it.next()) {
                rowcinv01sog00.setCWcdIndMerge(countPersonMerge(idPerson));
                findPersonCategory(rowcinv01sog00, idPerson, pageNbr, pageSize);
                rowcinv01sog00.setSzNmPersonFull(person.getNmPersonFull());
                rowcinv01sog00.setSzCdStagePersRelInt(consolidate.getCdStagePersRelInt());
                //STGAP0010668 Set SzTxtOtherRelationshipsCmnts so that the Special Rel
                // Column is populated on the Person List Page.
                rowcinv01sog00.setSzTxtOtherRelationshipsCmnts(person.getTxtPersonOtherRelationships());
                rowcinv01sog00.setSzCdIncmgPersTitle(person.getCdPersonTitle());
                rowcinv01sog00.setDtDtPersonBirth(DateHelper.toCastorDate(person.getDtPersonBirth()));
                rowcinv01sog00.setBIndPersonDobApprox(person.getIndPersonDobApprox());
                if (!DateHelper.isNull(person.getDtPersonBirth())) {
                  // Populate Output Message if event list requested
                  if (DateHelper.isNull(person.getDtPersonDeath())) {
                    rowcinv01sog00
                            .setLNbrPersonAge(DateHelper
                                    .getAge(
                                    person.getDtPersonBirth(),
                                    DateHelper
                                            .toJavaDate(cinv01so
                                            .getDtWCDDtSystemDate())));
                  } else {
                    rowcinv01sog00.setLNbrPersonAge(DateHelper.getAge(person.getDtPersonBirth(),
                                                                      person.getDtPersonDeath()));
                  }
                } else {
                  rowcinv01sog00.setLNbrPersonAge(0);
                }
                rowcinv01sog00.setBIndStagePersReporter(consolidate.getIndStagePersReporter());
                rowcinv01sog00.setSzCdStagePersRole(consolidate.getCdStagePersRole());
                rowcinv01sog00.setSzCdStagePersRelInt(consolidate.getCdStagePersRelInt());
                //STGAP0010668 Set SzTxtOtherRelationshipsCmnts so that the Special Rel
                // Column is populated on the Person List Page.
                rowcinv01sog00.setSzTxtOtherRelationshipsCmnts(person.getTxtPersonOtherRelationships());
                rowcinv01sog00.setCCdPersonSex(person.getCdPersonSex());
                rowcinv01sog00.setSzCdStagePersType(consolidate.getCdStagePersType());
                rowcinv01sog00.setSzCdStagePersSearchInd(consolidate.getCdStagePersSearchInd());
                rowcinv01sog00.setUlIdPerson(person.getIdPerson() != null ? person.getIdPerson() : 0);
                rowcinv01sog00
                        .setUlIdStagePerson(consolidate.getIdStagePersonLink() != null ? consolidate
                                .getIdStagePersonLink()
                                            : 0);
                // Service Authorization events should not
                // be returned to the client

                // 
                // Added Events with Event Status of NEW to
                // the "if" statement which adds rows to the structure
                // for events that need to be submitted for approval.
                // If the Event has a status of NEW, it will not be
                // included in the structure and will thus not be updated
                // to a status of PENDing.
                // If the event is an approval
                // event, do not change the event status to PENDing.
                // 
                if ((PERSON_CHAR_ONE.equals(person.getCdPersonChar()) || (PERSON_CHAR_TWO
                        .equals(person
                        .getCdPersonChar())))) {
                  rowcinv01sog00.setBCdPersonChar(ArchitectureConstants.Y);
                } else {

                  rowcinv01sog00.setBCdPersonChar(ArchitectureConstants.N);
                }
                rowcinv01sog00.setSzCdPersonEthnicGroup(person.getCdPersonEthnicGroup());
                rowcinv01sog00.setTsLastUpdate(consolidate.getDtLastUpdate());
                rowcinv01sog00_array.addROWCINV01SOG00(rowcinv01sog00);
                rowQty++;
                break;
              }
            }
          }
        }
        cinv01so.setROWCINV01SOG00_ARRAY(rowcinv01sog00_array);
        archOutputStruct.setUlRowQty(rowQty);
        cinv01so.setArchOutputStruct(archOutputStruct);
      }
    } else {// not AFC and ALLEGED_PERPS_ONLY
      ROWCINV01SOG00_ARRAY rowcinv01sog00_array = new ROWCINV01SOG00_ARRAY();
      for (Iterator<StagePersonLink> consolidate_it = consolidatedList.iterator(); consolidate_it.hasNext();) {
        StagePersonLink consolidate = consolidate_it.next();
        Person person = consolidate.getPerson();
        int idPerson = person.getIdPerson();
        if (0 != idPerson) {
          ROWCINV01SOG00 rowcinv01sog00 = new ROWCINV01SOG00();
          rowcinv01sog00.setCWcdIndMerge(countPersonMerge(idPerson));
          findPersonCategory(rowcinv01sog00, idPerson, pageNbr, pageSize);
          rowcinv01sog00.setSzNmPersonFull(person.getNmPersonFull());
          rowcinv01sog00.setSzCdStagePersRelInt(consolidate.getCdStagePersRelInt());
          //STGAP0010668 Set SzTxtOtherRelationshipsCmnts so that the Special Rel
          // Column is populated on the Person List Page.
          rowcinv01sog00.setSzTxtOtherRelationshipsCmnts(person.getTxtPersonOtherRelationships());
          rowcinv01sog00.setDtDtPersonBirth(DateHelper.toCastorDate(person.getDtPersonBirth()));
          rowcinv01sog00.setBIndPersonDobApprox(person.getIndPersonDobApprox());
          rowcinv01sog00.setSzCdIncmgPersTitle(person.getCdPersonTitle());
          if (!DateHelper.isNull(person.getDtPersonBirth())) {
            if (DateHelper.isNull(person.getDtPersonDeath())) {
              rowcinv01sog00
                      .setLNbrPersonAge(DateHelper.getAge(person.getDtPersonBirth(),
                                                          DateHelper.toJavaDate(cinv01so.getDtWCDDtSystemDate())));
            } else {
              rowcinv01sog00.setLNbrPersonAge(DateHelper.getAge(person.getDtPersonBirth(), person.getDtPersonDeath()));
            }
          } else {
            rowcinv01sog00.setLNbrPersonAge(0);
          }
          rowcinv01sog00.setBIndStagePersReporter(consolidate.getIndStagePersReporter());
          rowcinv01sog00.setSzCdStagePersRole(consolidate.getCdStagePersRole());
          rowcinv01sog00.setSzCdStagePersRelInt(consolidate.getCdStagePersRelInt());
          //STGAP0010668 Set SzTxtOtherRelationshipsCmnts so that the Special Rel
          // Column is populated on the Person List Page.
          rowcinv01sog00.setSzTxtOtherRelationshipsCmnts(person.getTxtPersonOtherRelationships());
          rowcinv01sog00.setCCdPersonSex(person.getCdPersonSex());
          rowcinv01sog00.setSzCdStagePersType(consolidate.getCdStagePersType());
          rowcinv01sog00.setSzCdStagePersSearchInd(consolidate.getCdStagePersSearchInd());
          rowcinv01sog00.setUlIdPerson(person.getIdPerson() != null ? person.getIdPerson() : 0);
          rowcinv01sog00
                  .setUlIdStagePerson(consolidate.getIdStagePersonLink() != null ? consolidate
                          .getIdStagePersonLink()
                                      : 0);
          if ((PERSON_CHAR_ONE.equals(person.getCdPersonChar())) || (PERSON_CHAR_TWO.equals(
                  person.getCdPersonChar()))) {
            rowcinv01sog00.setBCdPersonChar(ArchitectureConstants.Y);
          } else {
            rowcinv01sog00.setBCdPersonChar(ArchitectureConstants.N);
          }
          rowcinv01sog00.setSzCdPersonEthnicGroup(person.getCdPersonEthnicGroup());
          rowcinv01sog00.setTsLastUpdate(consolidate.getDtLastUpdate());
          rowcinv01sog00_array.addROWCINV01SOG00(rowcinv01sog00);
          rowQty++;
        } else {
          break;
        }
      }
      cinv01so.setROWCINV01SOG00_ARRAY(rowcinv01sog00_array);
      archOutputStruct.setUlRowQty(rowQty);

      // STGAP00010818: Update findStagePersonLinkAndAllegationHistory
      // method to set archOutputStruct.bMoreDataInd to 
      // stagePersonLinkList.bMoreDataInd for Person List pagination to
      // work.
      archOutputStruct.setBMoreDataInd(stagePersonLinkList.getBMoreDataInd());
      cinv01so.setArchOutputStruct(archOutputStruct);
    }
  }

  private int assignToconsolidatedListStagePersonLinkValue(List<StagePersonLink> arrayToRead,
                                                           List<StagePersonLink> consolidatedList, int n) {

    int localStageIdPerson;
    boolean bDup;

    for (int c = 0; c < arrayToRead.size(); c++) {
      localStageIdPerson = arrayToRead.get(c).getPerson().getIdPerson();
      if (0 == localStageIdPerson) {
        c = arrayToRead.size();
        break;
      } else {
        bDup = false;
        for (int j = 0; j < n; j++) {
          if (consolidatedList.size() != 0) {
            if (consolidatedList.get(j).getPerson().getIdPerson() == localStageIdPerson) {
              bDup = true;
            }
          }
        }
        if ((!bDup)) { // && (n < arrayToRead.size())
          consolidatedList.add(arrayToRead.get(c));
          n++;
        }
      }
    }
    return n;
  }

  private int assignToconsolidatedListMapValue(List<Map> arrayToRead, List<Map> consolidatedList, int n) {
    boolean bDup;
    int localStage;
    for (int q = 0; q < arrayToRead.size(); q++) {
      // Initialize local variable and then assigned the Array variable
      localStage = (Integer) arrayToRead.get(q).get("idPerson");
      if (0 == localStage) {
        q = arrayToRead.size();
        break;
      } else {
        bDup = false;
        // Read ConsolidatedArray up to current number of rows checking for duplicates */
        for (int j = 0; j < n ; j++) {
          if (consolidatedList.size() != 0) {
            if ((Integer) consolidatedList.get(j).get("idPerson") == localStage) {
              bDup = true;
            }
          }
        }
        if (!bDup) {
          consolidatedList.add(arrayToRead.get(q));
          n++;
        }
      }
    }
    return n;
  }

  @SuppressWarnings({"unchecked"})
  private void findUnstaffedStagePersonLink(int idCase, CINV01SO cinv01so, int pageNbr, int pageSize) {
    List<Map> reporterList;
    List<Map> primaryChildList;
    List<Map> principalList;
    List<Map> collateralList;
    List<Map> consolidatedList;
    List<Map> tempSwap;
    List<Map> badRoleTypeList;

    // The counter "k" will serve as an array index for the
    // output array that will be passed back to the window.
    // It will start with the first available array member.

    // The final listing cannot have any duplicates, so the following code
    // makes sure that every IdPerson is unique in the list.
    principalList = new ArrayList<Map>();
    collateralList = new ArrayList<Map>();
    consolidatedList = new ArrayList<Map>();
    tempSwap = new ArrayList<Map>();
    badRoleTypeList = new ArrayList<Map>();
    reporterList = new ArrayList<Map>();
    primaryChildList = new ArrayList<Map>();

    // Loop through Reporter Array first and add Reporters to Output
    // Message first, so they will appear first in the listbox.
    List<Map> mapList = stagePersonLinkDAO
            .findUnstaffedStagePersonLinkByIdCaseAndCdStagePersType(
                    idCase,
                    CodesTables.CPRSNALL_STF);
    if (mapList != null && !mapList.isEmpty()) {

      // Read consolidatedList up to current number of rows
      // checking for duplicates
      for (Iterator<Map> it = mapList.iterator(); it.hasNext();) {
        Map map = it.next();
        String nmPersonFull = (String) map.get("nmPersonFull");
        String cdPersonSuffix = (String) map.get("cdPersonSuffix");
        // map.put("nmPersonFull", nmPersonFull + " " + cdPersonSuffix);
        // TODO - add suffix back in
        map.put("nmPersonFull", nmPersonFull);
      }
    }

    if (mapList != null && !mapList.isEmpty()) {
      int p = 0;
      int c = 0;
      int z = 0;
      int q = 0;
      int d = 0;
      for (Iterator<Map> it = mapList.iterator(); it.hasNext();) {
        Map map = it.next();
        String indStagePersReporter = (String) map.get("indStagePersReporter");
        String cdStagePerRole = (String) map.get("cdStagePersRole");
        String cdStagePersType = (String) map.get("cdStagePersType");

        if (ArchitectureConstants.Y.equals(indStagePersReporter)) {
          reporterList.add(q, map);
          q++;
        }

        // The Primary Child should always appear after the
        // Reporter in the Person List. Therefore, sort out Primary Child
        // here and place after the reporter. Added an else if statement
        // to sort out PRIMARY_CHILD.
        else if (CodesTables.CROLES_PC.equals(cdStagePerRole)) {
          primaryChildList.add(d, map);
          d++;
        }
        // The person is a principal
        else if (CodesTables.CPRSNTYP_PRN.equals(cdStagePersType)) {
          if ((CodesTables.CROLES_VC.equals(cdStagePerRole)) || (CodesTables.CROLES_VP.equals(cdStagePerRole))
              || (CodesTables.CROLES_AP.equals(cdStagePerRole)) || (CodesTables.CROLES_NO.equals(cdStagePerRole))
              || (CodesTables.CROLES_UD.equals(cdStagePerRole)) || (CodesTables.CROLES_UM.equals(cdStagePerRole))
              || (CodesTables.CROLES_UC.equals(cdStagePerRole)) || (CodesTables.CROLES_UK.equals(cdStagePerRole))
              || (CodesTables.CROLEALL_SP.equals(cdStagePerRole)) || (CodesTables.CROLEALL_DB.equals(cdStagePerRole))
              || (CodesTables.CROLEALL_DV.equals(cdStagePerRole)) || (CodesTables.CROLEALL_DP.equals(cdStagePerRole))) {
            principalList.add(p, map);
            p++;
          } else {
            badRoleTypeList.add(z, map);
            z++;
          }
        } else if ((CodesTables.CROLES_NO.equals(cdStagePerRole)) && (CodesTables.CPRSNTYP_COL.equals(
                cdStagePersType))) {
          collateralList.add(c, map);
          c++;
        } else {
          badRoleTypeList.add(z, map);
          z++;
        }
      }
      int i = 0;
      int j = 0;
      while (i < reporterList.size()) {
        j = reporterList.size() - 1;

        while (j > i) {
          Date date1 = (Date) (reporterList.get(j - 1).get("dtPersonBirth"));
          Date date2 = (Date) (reporterList.get(j).get("dtPersonBirth"));
          if (DateHelper.isBefore(date1, date2)) {
            tempSwap.add(reporterList.get(j));
            reporterList.set(j, reporterList.get(j - 1));
            reporterList.set(j - 1, tempSwap.get(0));
            tempSwap.remove(0);
          }
          j--;
        }
        i++;
      }
      i = 0;
      while (i < principalList.size()) {
        j = principalList.size() - 1;

        while (j > i) {
          Date date1 = (Date) (principalList.get(j - 1).get("dtPersonBirth"));
          Date date2 = (Date) (principalList.get(j).get("dtPersonBirth"));
          if (DateHelper.isBefore(date1, date2)) {
            tempSwap.add(0, principalList.get(j));
            principalList.set(j, principalList.get(j - 1));
            principalList.set(j - 1, tempSwap.get(0));
            tempSwap.remove(0);
          }
          j--;
        }
        i++;
      }
      i = 0;
      while (i < collateralList.size()) {
        j = collateralList.size() - 1;
      
        while (j > i) {

            if ((collateralList.get(j).get("nmPersonFull") != null)
            && (0 > ((String) collateralList.get(j).get("nmPersonFull"))
                .compareTo((String) collateralList
                        .get(j - 1)
                        .get(
                                "nmPersonFull")))) {
          tempSwap.add(0, collateralList.get(j));
          collateralList.set(j, collateralList.get(j - 1));
          collateralList.set(j - 1, tempSwap.get(0));
          tempSwap.remove(0);
        }
        j--;
      }
      i++;
      }
    }
     
    // Loop thru both the MergeTo Person and MergeFrom Person
    // struct. If same Person is found in both the cases
    // which has a Person role of Primary Child and belongs
    // to the same stage Than set the Duplicate flag to TRUE.
    int n = 0;
    // Loop through ReporterArray
    n = assignToconsolidatedListMapValue(reporterList, consolidatedList, n);
    // Loop through PrimaryChildArray
    n = assignToconsolidatedListMapValue(primaryChildList, consolidatedList, n);
    // Loop through PrincipalArray
    n = assignToconsolidatedListMapValue(principalList, consolidatedList, n);
    // Loop through CollateralArray
    n = assignToconsolidatedListMapValue(collateralList, consolidatedList, n);
    // Loop through BadDataArray
    n = assignToconsolidatedListMapValue(badRoleTypeList, consolidatedList, n);

    // Get system date and copy into output message

    cinv01so.setDtWCDDtSystemDate(DateHelper.getTodayCastorDate());
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    int rowQty = 0;
    archOutputStruct.setUlRowQty(rowQty);

    ROWCINV01SOG00_ARRAY rowcinv01sog00_array = new ROWCINV01SOG00_ARRAY();
    // for (i = 0; i < consolidatedList.size(); i++) {
    for (Iterator<Map> it = consolidatedList.iterator(); it.hasNext();) {
      // If the Contract Id is passed, return
      // MSG_CODE_NOT_FOUND with a severity of FND_SEVERITY_OK
      // since this means that the Id contract passed
      // does not exist on the CONTRACT table
      Map consolidated = it.next();
      int idPerson = (Integer) consolidated.get("idPerson");
      if (0 != idPerson) {
        // For each row returned from the DAO call CLSC49D to check
        // for Person Merge data, if the DAM returns a count >0
        // Merge Indicator flag to true else set the Merge Indicator flag to
        // false.

        ROWCINV01SOG00 rowcinv01sog00 = new ROWCINV01SOG00();
        // CallCMSC49D
        rowcinv01sog00.setCWcdIndMerge(countPersonMerge(idPerson));
        // CallCINV29D
        findPersonCategory(rowcinv01sog00, idPerson, pageNbr, pageSize);
        rowcinv01sog00.setSzNmPersonFull((String) consolidated.get("nmPersonFull"));
        rowcinv01sog00.setSzCdStagePersRelInt((String) consolidated.get("cdStagePersRelInt"));
        rowcinv01sog00.setDtDtPersonBirth(DateHelper.toCastorDate((Date) consolidated.get("dtPersonBirth")));
        rowcinv01sog00.setBIndPersonDobApprox((String) consolidated.get("indPersonDobApprox"));
        if (!DateHelper.isNull((Date) consolidated.get("dtPersonBirth"))) {
          if (DateHelper.isNull((Date) consolidated.get("dtPersonDeath"))) {
            rowcinv01sog00.setLNbrPersonAge(DateHelper.getAge((Date) consolidated.get("dtPersonBirth"),
                                                              DateHelper.toJavaDate(cinv01so.getDtWCDDtSystemDate())));
          } else {
            rowcinv01sog00.setLNbrPersonAge(DateHelper.getAge((Date) consolidated.get("dtPersonBirth"),
                                                              (Date) consolidated.get("dtPersonDeath")));
          }
        } else {
          rowcinv01sog00.setLNbrPersonAge(0);
        }
        rowcinv01sog00.setBIndStagePersReporter((String) consolidated.get("indStagePersReporter"));
        rowcinv01sog00.setSzCdStagePersRole((String) consolidated.get("cdStagePersRole"));
        rowcinv01sog00.setSzCdStagePersRelInt((String) consolidated.get("cdStagePersRelInt"));
        rowcinv01sog00.setCCdPersonSex((String) consolidated.get("cdPersonSex"));
        rowcinv01sog00.setSzCdStagePersType((String) consolidated.get("cdStagePersType"));
        rowcinv01sog00.setSzCdStagePersSearchInd((String) consolidated.get("cdStagePersSearchInd"));
        //STGAP0010668 Set SzTxtOtherRelationshipsCmnts so that the Special Rel
        // Column is populated on the Person List Page.
        rowcinv01sog00.setSzTxtOtherRelationshipsCmnts((String)consolidated.get("szTxtOtherRelationshipsCmnts"));
        rowcinv01sog00
                .setUlIdPerson((Integer) consolidated.get("idPerson") != null ? (Integer) consolidated
                        .get("idPerson")
                               : 0);
        rowcinv01sog00_array.addROWCINV01SOG00(rowcinv01sog00);
        rowQty++;
      } else {
        break;
      }
    }
    cinv01so.setROWCINV01SOG00_ARRAY(rowcinv01sog00_array);
    archOutputStruct.setUlRowQty(rowQty);

    archOutputStruct.setBMoreDataInd(cinv01so.getBMoreDataInd());
    cinv01so.setArchOutputStruct(archOutputStruct);
  }

  private String countPersonMerge(int idPerson) {
    String result;
    long count = personMergeDAO.countPersonMergeForwardOrClosedByIdPerson(idPerson);
    if (count > 0) {
      result = ArchitectureConstants.Y;
    } else {
      result = ArchitectureConstants.N;
    }
    return result;

  }

  private void findPersonCategory(ROWCINV01SOG00 rowcinv01sog00, int idPerson, int pageNbr, int pageSize) {
    PaginatedHibernateList<PersonCategory> personCategoryList = personCategoryDAO.findPersonCategoryByIdPerson(idPerson,
                                                                                                               pageNbr,
                                                                                                               pageSize);
    if (personCategoryList != null && !personCategoryList.isEmpty()) {
      for (Iterator<PersonCategory> it = personCategoryList.iterator(); it.hasNext();) {
        PersonCategory personCategory = it.next();
        String cdCategoryCategory = personCategory.getCdPersonCategory();
        if (CodesTables.CPSNDTCT_EMP.equals(cdCategoryCategory)) {
          rowcinv01sog00.setBIndActiveStatus(ArchitectureConstants.Y);
       }
      }
    } else {
      rowcinv01sog00.setBIndActiveStatus(ArchitectureConstants.N);
    }
  }
  
  private boolean checkIfNonIncident(int idStage) {
    boolean nonIncident = true;
    List<String> cdStages = new ArrayList<String>();
    cdStages.add(CodesTables.CSTAGES_ADO);
    cdStages.add(CodesTables.CSTAGES_FCC);
    Integer result = stageLinkDAO.findStageLinkByIdStageAndCdStage(idStage, cdStages);
    if (result != null) {
      nonIncident = false;
    }
    return nonIncident;
  }

}
