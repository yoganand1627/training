package gov.georgia.dhr.dfcs.sacwis.service.adoexchange.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterHomeConvDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterHomeConvPerLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FosterHomeConv;
import gov.georgia.dhr.dfcs.sacwis.db.FosterHomeConvPerLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.RetrieveFosterHomeConversion;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterHomeConversionChildBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterHomeConversionSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterHomeConversionSO;

public class RetrieveFosterHomeConversionImpl extends BaseServiceImpl implements RetrieveFosterHomeConversion {

public FosterHomeConversionSO retrieveFosterHomeConversion (FosterHomeConversionSI fosterHomeConversionSI) {

  FosterHomeConversionSO fosterHomeConvSO = new FosterHomeConversionSO();
  
  populateFosterHomeConversionInfo(fosterHomeConversionSI, fosterHomeConvSO);
  populateFosterHomeConvPerLinkInfo(fosterHomeConversionSI, fosterHomeConvSO);
  populateHasNarrative(fosterHomeConversionSI, fosterHomeConvSO);
  
  return fosterHomeConvSO;
}

public Boolean hasAprvFosterHomeConversion(Integer idResource){
  FosterHomeConv fhcv = fosterHomeConvDAO.findFosterHomeConvByIdResource(idResource);
  return (fhcv != null ? new Boolean(true) : new Boolean(false));
}

public Boolean hasAprvFosterHomeConversionForCase(Integer idCase){
  CapsResource capsResource = capsResourceDAO.findCapsResourceByIdCase(idCase);
  Integer idResource = (capsResource != null ) ? capsResource.getIdResource() : new Integer(0);
  FosterHomeConv fhcv = fosterHomeConvDAO.findFosterHomeConvByIdResource(idResource);
  return (fhcv != null ? new Boolean(true) : new Boolean(false));
}

private void populateFosterHomeConversionInfo(FosterHomeConversionSI fosterHomeConversionSI,
                                              FosterHomeConversionSO fosterHomeConversionSO) {
  int idEvent = fosterHomeConversionSI.getUlIdEvent();
  
  FosterHomeConv fosterHomeConv = fosterHomeConvDAO.findFosterHomeConvDetailsByIdEvent(idEvent);
  
  if (fosterHomeConv != null) {
    String cdConvAppStatus = fosterHomeConv.getCdConvAppStatus();
    String cdEventStatus = "";
    Date dtLastUpdate = null;
    
    fosterHomeConversionSO.setCdClosureReason(fosterHomeConv.getCdClosureReason());
    fosterHomeConversionSO.setCdConvAppStatus(cdConvAppStatus);
    fosterHomeConversionSO.setDtApplied(fosterHomeConv.getDtApplied());
    fosterHomeConversionSO.setDtApproved(fosterHomeConv.getDtApproval());
    fosterHomeConversionSO.setDtClosed(fosterHomeConv.getDtClosure());
    fosterHomeConversionSO.setDtInquired(fosterHomeConv.getDtInquiry());

    CapsResource adoAgency = fosterHomeConv.getCapsResourceByIdAdoAgency();
    if (adoAgency != null) {
      fosterHomeConversionSO.setIdAdoAgency(adoAgency.getIdResource());
      fosterHomeConversionSO.setNmResource(adoAgency.getNmResource());
    } else {
      fosterHomeConversionSO.setIdAdoAgency(0);
      fosterHomeConversionSO.setNmResource("");
    }
    
    Event convEvent = eventDAO.findEventByIdEvent(idEvent);
    if (convEvent != null) {
      if (convEvent.getDtLastUpdate() != null) {
        dtLastUpdate = convEvent.getDtLastUpdate();
        cdEventStatus = convEvent.getCdEventStatus();
      }
    }

    fosterHomeConversionSO.setDtEventLastUpdate(dtLastUpdate);
    fosterHomeConversionSO.setCdEventStatus(cdEventStatus);

  }
}

private void populateFosterHomeConvPerLinkInfo(FosterHomeConversionSI fosterHomeConversionSI,
                                               FosterHomeConversionSO fosterHomeConversionSO) {
  int idEvent = fosterHomeConversionSI.getUlIdEvent();

  List<FosterHomeConvPerLink> fosterHomeConvPerLinks = fosterHomeConvPerLinkDAO.findFosterHomeConvPerLinksByIdEvent(idEvent);

  List<FosterHomeConversionChildBean> childList = new ArrayList<FosterHomeConversionChildBean>();
  for (FosterHomeConvPerLink l : fosterHomeConvPerLinks) {
    int idChild = l.getIdPerson();
    Person p = personDAO.findPersonByIdPerson(idChild);
    if (p != null) {
      FosterHomeConversionChildBean childBean = new FosterHomeConversionChildBean();
      // STGAP00012022 - Make sure current age is always displayed
      // by calculating age based on birthdate, if available
      // Otherwise, use the age stored in the database
      Date childBirthDate = p.getDtPersonBirth();
      int childAge = p.getNbrPersonAge() == null ? 0 : p.getNbrPersonAge();
      if (childBirthDate != null) {
        childAge = DateHelper.getAge(childBirthDate);
      }
      childBean.setChildAge(childAge);
      childBean.setChildGender(decodeGender(p.getCdPersonSex()));
      childBean.setChildName(p.getNmPersonFull());
      childBean.setIdChild(idChild);
      childBean.setIdFosterHomeConvPerLink(l.getIdFosterHomeConvPerLink());
      childList.add(childBean);
    }
  }
  fosterHomeConversionSO.setChildrenToBeAdopted(childList);
}

private void populateHasNarrative(FosterHomeConversionSI fosterHomeConversionSI,
                                  FosterHomeConversionSO fosterHomeConversionSO) {
  int idEvent = fosterHomeConversionSI.getUlIdEvent();
  Date narrativeDate = null;
  if (idEvent > 0 ) {
    narrativeDate = commonDAO.findDtLastUpdate("FH_CONV_NARRATIVE", idEvent); // TODO replace this once DBCR is complete
  }
  
  if (narrativeDate == null) {
    fosterHomeConversionSO.setHasNarrative(false);    
  } else {
    fosterHomeConversionSO.setHasNarrative(true);
  }
}

private String decodeGender(String gender) {

  String genderDecode = "";
  if ("M".equals(gender)) {
    genderDecode = "Male";
  } else if ("F".equals(gender)) {
    genderDecode = "Female";
  } else {
    genderDecode = "Unknown";
  }

  return genderDecode;
}

public CommonDAO getCommonDAO() {
  return commonDAO;
}

public void setCommonDAO(CommonDAO commonDAO) {
  this.commonDAO = commonDAO;
}

public EventDAO getEventDAO() {
  return eventDAO;
}

public void setEventDAO(EventDAO eventDAO) {
  this.eventDAO = eventDAO;
}

public FosterHomeConvDAO getFosterHomeConvDAO() {
  return fosterHomeConvDAO;
}

public void setFosterHomeConvDAO(FosterHomeConvDAO fosterHomeConvDAO) {
  this.fosterHomeConvDAO = fosterHomeConvDAO;
}

public FosterHomeConvPerLinkDAO getFosterHomeConvPerLinkDAO() {
  return fosterHomeConvPerLinkDAO;
}

public void setFosterHomeConvPerLinkDAO(FosterHomeConvPerLinkDAO fosterHomeConvPerLinkDAO) {
  this.fosterHomeConvPerLinkDAO = fosterHomeConvPerLinkDAO;
}

public PersonDAO getPersonDAO() {
  return personDAO;
}

public void setPersonDAO(PersonDAO personDAO) {
  this.personDAO = personDAO;
}

public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
  this.capsResourceDAO = capsResourceDAO;
}

private CommonDAO commonDAO;

private EventDAO eventDAO;

private FosterHomeConvDAO fosterHomeConvDAO;

private FosterHomeConvPerLinkDAO fosterHomeConvPerLinkDAO;

private PersonDAO personDAO;

private CapsResourceDAO capsResourceDAO = null;

}
