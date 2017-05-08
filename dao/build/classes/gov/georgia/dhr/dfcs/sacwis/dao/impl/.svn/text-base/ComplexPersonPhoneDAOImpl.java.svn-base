package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;

public class ComplexPersonPhoneDAOImpl extends BaseDAOImpl implements ComplexPersonPhoneDAO {
  PersonPhoneDAO personPhoneDAO;

  CommonDAO commonDAO;

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setCommonDAO(CommonDAO commonDAO) {
    this.commonDAO = commonDAO;
  }

  public int insertPersonPhone(Date personPhoneEnd, int idPerson, String cdPhoneType, String cdNbrPhone,
                               String cdNbrPhoneExtension, String indPersonPhonePrimary, String indPersonPhoneInvalid,
                               String cdTxtPhoneComments, int idPhone, Date tsLastUpdate) {
    int idPersonPhone = commonDAO.getNextval("SEQ_PERSON_PHONE");
    if (DateHelper.isNull(personPhoneEnd) || DateHelper.MAX_JAVA_DATE.equals(personPhoneEnd)) {
      
      
      
      personPhoneDAO.insertPersonPhonePermanent(idPerson, idPersonPhone, cdPhoneType, cdNbrPhone, cdNbrPhoneExtension,
                                                indPersonPhonePrimary, indPersonPhoneInvalid, cdTxtPhoneComments);
    } else {
      personPhoneDAO.insertPersonPhoneNoEndDate(idPerson, idPersonPhone, cdPhoneType, cdNbrPhone, cdNbrPhoneExtension,
                                                indPersonPhonePrimary, indPersonPhoneInvalid, cdTxtPhoneComments);
    }
    return idPerson;
  }

  public int updatePersonPhone(Date personPhoneEnd, int idPerson, String cdPhoneType, String cdNbrPhone,
                               String cdNbrPhoneExtension, String indPersonPhonePrimary, String indPersonPhoneInvalid,
                               String cdTxtPhoneComments, int idPhone, Date tsLastUpdate) {
    Date dtEndDate = null;
    if (personPhoneEnd != null) {
      dtEndDate = personPhoneDAO.findPersonPhoneDtPersonPhoneEnd(idPhone);
    }
    //if ((personPhoneEnd != null) && (dtEndDate != null)) {
       if ((personPhoneEnd != null) && !(DateHelper.MAX_JAVA_DATE.equals(personPhoneEnd)) &&
           (dtEndDate == null || DateHelper.MAX_JAVA_DATE.equals(dtEndDate))) {
         return personPhoneDAO.updatePersonPhoneByDtPersonPhoneEnd(cdPhoneType, cdNbrPhone, cdNbrPhoneExtension,
                                                                indPersonPhonePrimary, indPersonPhoneInvalid,
                                                                cdTxtPhoneComments, idPhone, tsLastUpdate);
    } else {
      return personPhoneDAO.updatePersonPhone(cdPhoneType, cdNbrPhone, cdNbrPhoneExtension, indPersonPhonePrimary,
                                              indPersonPhoneInvalid, cdTxtPhoneComments, idPhone, tsLastUpdate);
    }
  }
}
