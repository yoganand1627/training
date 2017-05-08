package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonLocDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.PersonLoc;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveLevelofCare;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzTxtPlcmtRec_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY;

public class RetrieveLevelofCareImpl extends BaseServiceImpl implements RetrieveLevelofCare {

  private static final int EVENT = 0;
  private static final int LOC = 1;

  private EventDAO eventDAO = null;
  private PersonLocDAO personLocDAO = null;

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPersonLocDAO(PersonLocDAO personLocDAO) {
    this.personLocDAO = personLocDAO;
  }

  public CSUB16SO findEventAndPersonLocInformation(CSUB16SI csub16si) throws ServiceException {
    CSUB16SO csub16so = new CSUB16SO();
    // ccmn45d
    Event event = eventDAO.findEventByIdEvent(csub16si.getUlIdEvent());
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    csub16so.setSzCdEventStatus(event.getCdEventStatus());
    csub16so.setUlIdEventPerson(event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0);
    TsLastUpdate_ARRAY tsLastUpdate_array = new TsLastUpdate_ARRAY();
    tsLastUpdate_array.addTsLastUpdate(EVENT, event.getDtLastUpdate());
    csub16so.setTsLastUpdate_ARRAY(tsLastUpdate_array);
    // If the eventisn't new, look for information about level of care.
    if (!CodesTables.CEVTSTAT_NEW.equals(csub16so.getSzCdEventStatus())) {
      // Calling DAO (cses15d) to retrieve the row on the Level of Care table
      // with the passed in IdEvent
      Object[] personLocInfo = personLocDAO.findPersonLoc(csub16si.getUlIdEvent());
      if (personLocInfo == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      PersonLoc personLoc = (PersonLoc) personLocInfo[0];
      String nmPersonFull = (String) personLocInfo[1];
      tsLastUpdate_array.addTsLastUpdate(LOC, personLoc.getDtLastUpdate());
      csub16so.setSzCdPlocChild(personLoc.getCdPlocChild());
      csub16so.setSzCdPlocType(personLoc.getCdPlocType());
      csub16so.setUlIdPerson(personLoc.getPersonByIdPerson().getIdPerson() != null ?
                             personLoc.getPersonByIdPerson().getIdPerson() : 0);
      csub16so.setDtDtPlocEnd(DateHelper.toCastorDate(personLoc.getDtPlocEnd()));
      csub16so.setDtDtPlocStart(DateHelper.toCastorDate(personLoc.getDtPlocStart()));
      csub16so.setSzTxtComments(personLoc.getTxtComments());
      csub16so.setDtDtSubTpr(DateHelper.toCastorDate(personLoc.getDtSubTpr()));
      csub16so.setDtDtRevCmplt(DateHelper.toCastorDate(personLoc.getDtRevCmplt()));
      csub16so.setSzNmTprCons(personLoc.getNmTprCons());
      csub16so.setDtDtRevCondct(DateHelper.toCastorDate(personLoc.getDtRevCondct()));
      csub16so.setSzCdLvlChg(personLoc.getCdLvlChg());
      csub16so.setSzCdPlcmtSetting(personLoc.getCdPlcmtSetting());
      csub16so.setSzCdRevType(personLoc.getCdRevType());
      CSUB16SOG00 csub16sog00 = new CSUB16SOG00();
      SzTxtPlcmtRec_ARRAY szTxtPlcmtRec_array = new SzTxtPlcmtRec_ARRAY();
      szTxtPlcmtRec_array.addSzTxtPlcmtRec(personLoc.getTxtPlcmtRec1());
      szTxtPlcmtRec_array.addSzTxtPlcmtRec(personLoc.getTxtPlcmtRec2());
      szTxtPlcmtRec_array.addSzTxtPlcmtRec(personLoc.getTxtPlcmtRec3());
      szTxtPlcmtRec_array.addSzTxtPlcmtRec(personLoc.getTxtPlcmtRec4());
      szTxtPlcmtRec_array.addSzTxtPlcmtRec(personLoc.getTxtPlcmtRec5());
      szTxtPlcmtRec_array.addSzTxtPlcmtRec(personLoc.getTxtPlcmtRec6());
      csub16sog00.setSzTxtPlcmtRec_ARRAY(szTxtPlcmtRec_array);
      csub16so.setCSUB16SOG00(csub16sog00);
      csub16so.setSzNmPersUpdt(nmPersonFull);
    }
    return csub16so;
  }
}
