package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrievePersonIdentifiers;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonIdInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT19SO;

public class RetrievePersonIdentifiersImpl extends BaseServiceImpl implements RetrievePersonIdentifiers {

  private PersonIdDAO personIdDAO = null;

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public CINT19SO findPersonIdentifiers(CINT19SI cint19si) {
    CINT19SO cint19so = new CINT19SO();
    cint19so.setDtWCDDtSystemDate(DateHelper.getTodayCastorDate());

    PersonIdInStruct personIdInStruct = cint19si.getPersonIdInStruct();
    int idPerson = personIdInStruct.getUlIdPerson();
    List<PersonId> personIdList;
    if (ArchitectureConstants.Y.equals(personIdInStruct.getBSysIndIntake())) {
      // cint17d
      personIdList = personIdDAO.findPersonIdByIdPersonAndSysTsQueryInIntakeStage(idPerson,
                                                                                  personIdInStruct.getTsSysTsQuery());
    } else {
      // cint17d
      personIdList = personIdDAO.findPersonIdByIdPersonAndSysTsQueryInInvestigationStage(idPerson);
    }

    CINT14WLB_ARRAY cint14WlbArray = new CINT14WLB_ARRAY();
    if (personIdList != null && !personIdList.isEmpty()) {
      Iterator<PersonId> itPersonList = personIdList.iterator();
      while (itPersonList.hasNext()) {
        PersonId personId = itPersonList.next();
        CINT14WLB cint4WLb = new CINT14WLB();
        cint4WLb.setSzCdPersonIdType(personId.getCdPersonIdType());
        cint4WLb.setSzCdScrDataAction(null);
        cint4WLb.setBIndPersonIDInvalid(personId.getIndPersonIdInvalid());
        cint4WLb.setSzDescPersonID(personId.getDescPersonId());
        cint4WLb.setDtPersonIDStart(DateHelper.toCastorDate(personId.getDtPersonIdStart()));
        Date endDate = personId.getDtPersonIdEnd();
        if (endDate == null || endDate.equals(DateHelper.MAX_JAVA_DATE)) {
          cint4WLb.setDtPersonIDEnd(null);
        } else {
          cint4WLb.setDtPersonIDEnd(DateHelper.toCastorDate(endDate));
        }
        cint4WLb.setSzNbrPersonIdNumber(personId.getNbrPersonIdNumber());
        cint4WLb.setUlIdPersonId(personId.getIdPersonId() != null ? personId.getIdPersonId() : 0);
        cint4WLb.setUlIdPerson(personId.getPerson().getIdPerson() != null ? personId.getPerson().getIdPerson() : 0);
        cint4WLb.setTsSysTsLastUpdate2(personId.getDtLastUpdate());
        cint4WLb.setBIndValidateByInterface(personId.getIndValidateByInterface());
        cint14WlbArray.addCINT14WLB(cint4WLb);
      }
    }
    cint19so.setCINT14WLB_ARRAY(cint14WlbArray);
    return cint19so;
  }

}
