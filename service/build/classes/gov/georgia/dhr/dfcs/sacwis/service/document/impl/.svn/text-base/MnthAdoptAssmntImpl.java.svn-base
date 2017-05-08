/**
 * Created on Jan 07, 2006 at 10:55:33 AM by Selima Rollins  
 */
package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonLocDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.PersonLoc;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.document.MnthAdoptAssmnt;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MnthAdoptAssmntImpl extends BaseDocumentServiceImpl implements MnthAdoptAssmnt {

  private PlacementDAO placementDAO;

  private EventDAO eventDAO;

  private CapsResourceDAO capsResourceDAO;

  private PersonLocDAO personLocDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPersonLocDAO(PersonLocDAO personLocDAO) {
    this.personLocDAO = personLocDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public CFAD05SO retrieveMnthAdoptAssmnt(CFAD05SI cfad05si) {
    CFAD05SO cfad05so = new CFAD05SO();
    int idStage = cfad05si.getUlIdStage();
    int idEvent = cfad05si.getUlIdEvent();
    Event event = eventDAO.findEventByIdEvent(idEvent);
    CapsCase capsCase = event.getCapsCase();
    int idCase = capsCase.getIdCase();
    CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage);
    int idResource = capsResource.getIdResource();
    PreFillData preFillData = getMnthAdoptHeadings(idCase, idResource, capsResource);
    getHomeMembers(idStage, preFillData);
    getChildrenCurrInPlacement(idResource, idStage, preFillData);
    cfad05so.setPreFillData(preFillData);
    return cfad05so;
  }

  // Displays the form header and indiviual bookmark fields
  private PreFillData getMnthAdoptHeadings(int idCase, int idResource, CapsResource capsResource) {
    PreFillData preFillData = new PreFillData();

    preFillData.addBookmark(createBookmark("HOME_NAME", capsResource.getNmResource()));
    preFillData.addBookmark(createBookmark("FACILITY_ID", idResource));
    preFillData.addBookmark(createBookmark("CASE_ID", idCase));
    preFillData.addBookmark(createBookmark("STREET_LN1", capsResource.getAddrRsrcStLn1()));
    preFillData.addBookmark(createBookmark("STREET_LN2", capsResource.getAddrRsrcStLn2()));
    preFillData.addBookmark(createBookmark("CITY", capsResource.getAddrRsrcCity()));
    preFillData.addBookmark(createBookmark("COUNTY", Lookup.simpleDecodeSafe("CCOUNT", capsResource.getCdRsrcCnty())));
    preFillData.addBookmark(createBookmark("STATE", capsResource.getCdRsrcState()));
    preFillData.addBookmark(createBookmark("ZIP", capsResource.getAddrRsrcZip()));

    return preFillData;
  }

  // STGAP00002390: This function is used to not only get the people associated with the case but they must also be a member of the HouseHold
  private void getHomeMembers(int idStage, PreFillData preFillData) {
    FormDataGroup group = null;

    List<StagePersonLink> stagePersonLinks = stagePersonLinkDAO.findHouseMembersLinkedToStage(idStage);
    if (stagePersonLinks != null && !stagePersonLinks.isEmpty()) {
      for (Iterator<StagePersonLink> it = stagePersonLinks.iterator(); it.hasNext();) {
        StagePersonLink stagePersonLink = it.next();
        group = createFormDataGroup(TMPLAT_HOME_MEMBS, CFA17O00);
        group.addBookmark(createBookmark(HOME_MEMBS_NAME_FULL, stagePersonLink.getPerson().getNmPersonFull()));
        preFillData.addFormDataGroup(group);
      } // end for loop
    } // end if mapList != null
  } // end getHomeMembers()

  // A list of all the children currently in placement.
  private void getChildrenCurrInPlacement(int IdResource, int idStage, PreFillData preFillData) {
    String aLoc = null;
    Date dtLocStart = null;

    List<Map> childrenPlacedList = placementDAO
                                               .findPersonsByIdPlcmtChildByCapsResourceByIdRsrcFacil(
                                                                                                     DateHelper
                                                                                                               .toJavaDate(DateHelper
                                                                                                                                     .getTodayCastorDate()),
                                                                                                     IdResource,
                                                                                                     CodesTables.CPLCMTAC_A);
    if (childrenPlacedList != null && !childrenPlacedList.isEmpty()) {
      for (Iterator<Map> it = childrenPlacedList.iterator(); it.hasNext();) {
        Map childMap = it.next();
        String personId = childMap.get("personByIdPlcmtChild").toString();
        int idPerson = Integer.valueOf(personId).intValue();
        PersonLoc personLoc = personLocDAO.findPersonLocByIdPerson(idPerson, CodesTables.CPLOCELG_ALOC);
        if (personLoc != null) {
          aLoc = personLoc.getCdPlocChild();
          dtLocStart = personLoc.getDtPlocStart();
        }
        preFillData.addFormDataGroup(getChildPlcmtGroup(childMap, aLoc, dtLocStart));
      }// end of for loop
    }// end of if statement
  } // end of getChildrenCurrInPlacement function

  // Displays the bookmarks for the data gathered in getChildrenCurrInPlacement()
  private FormDataGroup getChildPlcmtGroup(Map childMap, String aLoc, Date dtLocStart) {
    FormDataGroup group = createFormDataGroup(TMPLAT_CHILD_CURR_PLCMT, CFA17O00);
    group.addBookmark(createBookmark(CHILD_FIRST, (String) childMap.get("personFirstName")));
    group.addBookmark(createBookmark(CHILD_MIDDLE, (String) childMap.get("personMiddleName")));
    group.addBookmark(createBookmark(CHILD_LAST, (String) childMap.get("personLastName")));
    group.addBookmark(createBookmark(CHILD_SUFFIX, (String) childMap.get("personSuffix")));
    group.addBookmark(createBookmark(DOB, FormattingHelper.formatDate((Date) childMap.get("personDtOfBirth"))));
    group
         .addBookmark(createBookmark(LIV_ARRANGEMENTS, Lookup.simpleDecodeSafe("CPLLAFRM",
                                                                               (String) childMap.get("cdPlcmtLivArr"))));
    group.addBookmark(createBookmark(PLCMT_DT_CHILD, FormattingHelper.formatDate((Date) childMap.get("dtPlcmtStart"))));

    if (aLoc == null) {
      group.addBookmark(createBookmark(AUTH_LOC, "N/A"));
    } else {
      group.addBookmark(createBookmark(AUTH_LOC, Lookup.simpleDecodeSafe("CATHPLOC", aLoc)));
    }
    group.addBookmark(createBookmark(DT_PLOC_START, FormattingHelper.formatDate(dtLocStart)));

    return group;
  } // end getChildPlcmtGroup()
}// end of service
