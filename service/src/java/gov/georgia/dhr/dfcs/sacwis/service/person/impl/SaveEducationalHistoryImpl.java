package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.Date;
import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EducationalHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EducationalHistory;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveEducationalHistory;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC18SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC18SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC18SO;

public class SaveEducationalHistoryImpl extends BaseServiceImpl implements SaveEducationalHistory {

  private EducationalHistoryDAO educationalHistoryDAO = null;

  public void setEducationalHistoryDAO(EducationalHistoryDAO educationalHistoryDAO) {
    this.educationalHistoryDAO = educationalHistoryDAO;
  }

  public CCFC18SO audEducationalHistory(CCFC18SI ccfc18si) throws ServiceException {
    CCFC18SO ccfc18so = new CCFC18SO();
    int idPerson = ccfc18si.getUlIdPerson();
    ROWCCFC18SIG00_ARRAY rowccfc18sig00_array = ccfc18si.getROWCCFC18SIG00_ARRAY();
    Enumeration rowccfc18sig00_enum = rowccfc18sig00_array.enumerateROWCCFC18SIG00();
    // While more rows are left to process and no exceptions are thrown,
    // continue loop.
    while (rowccfc18sig00_enum.hasMoreElements()) {
      ROWCCFC18SIG00 rowccfc18sig00 = (ROWCCFC18SIG00) rowccfc18sig00_enum.nextElement();
      int idEdHist = rowccfc18sig00.getUlIdEdhist();
      Date dtLastUpdate = rowccfc18sig00.getTsLastUpdate();
      // Add, update, or delete rows from the Educational History table.
      String cdScrDataAction = rowccfc18sig00.getSzCdScrDataAction();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction)
          || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
        EducationalHistory educationalHistory = new EducationalHistory();
        educationalHistory.setIdEdhist(idEdHist);
        educationalHistory.setDtLastUpdate(dtLastUpdate);
        educationalHistory.setDtEdhistEnrollDate(DateHelper.toJavaDate(rowccfc18sig00.getDtDtEdhistEnrollDate()));
        educationalHistory.setDtEdhistWithdrawnDate(DateHelper.toJavaDate(rowccfc18sig00.getDtDtEdhistWithdrawnDate()));
        educationalHistory.setIndEdhistTeaSchool(rowccfc18sig00.getCIndEdhistTeaSchool());
        // if (!(IN_STATE.equals(rowccfc18sig00.getCIndEdhistTeaSchool()))) {
        educationalHistory.setAddrEdhistCity(rowccfc18sig00.getSzAddrEdhistCity());
        educationalHistory.setAddrEdhistCnty(rowccfc18sig00.getSzAddrEdhistCnty());
        educationalHistory.setAddrEdhistState(rowccfc18sig00.getSzAddrEdhistState());
        educationalHistory.setAddrEdhistStreetLn1(rowccfc18sig00.getSzAddrEdhistStreetLn1());
        educationalHistory.setAddrEdhistStreetLn2(rowccfc18sig00.getSzAddrEdhistStreetLn2());
        educationalHistory.setAddrEdhistZip(rowccfc18sig00.getSzAddrEdhistZip());
        educationalHistory.setNbrEdhistPhone(rowccfc18sig00.getSzNbrEdhistPhone());
        educationalHistory.setNbrEdhistPhoneExt(rowccfc18sig00.getSzNbrEdhistPhoneExt());
        // }
        educationalHistory.setTxtEdhistAddrCmnt(rowccfc18sig00.getSzTxtEdhistAddrCmnt());
        educationalHistory.setCdEdhistEnrollGrade(rowccfc18sig00.getSzCdEdhistEnrollGrade());
        educationalHistory.setCdEdhistWithdrawnGrade(rowccfc18sig00.getSzCdEdhistWithdrawnGrade());
        educationalHistory.setCdEdhistNeeds1(rowccfc18sig00.getSzCdEdhistNeeds1());
        educationalHistory.setCdEdhistNeeds2(rowccfc18sig00.getSzCdEdhistNeeds2());
        educationalHistory.setCdEdhistNeeds3(rowccfc18sig00.getSzCdEdhistNeeds3());
        educationalHistory.setCdEdhistNeeds4(rowccfc18sig00.getSzCdEdhistNeeds4());
        educationalHistory.setCdEdhistNeeds5(rowccfc18sig00.getSzCdEdhistNeeds5());
        educationalHistory.setCdEdhistNeeds6(rowccfc18sig00.getSzCdEdhistNeeds6());
        educationalHistory.setCdEdhistNeeds7(rowccfc18sig00.getSzCdEdhistNeeds7());
        educationalHistory.setCdEdhistNeeds8(rowccfc18sig00.getSzCdEdhistNeeds8());
        educationalHistory.setNmEdhistSchool(rowccfc18sig00.getSzNmEdhistSchool());
        educationalHistory.setTxtEdhistCmnts(rowccfc18sig00.getSzEdHistComments());
        educationalHistory.setCdEdhistType(rowccfc18sig00.getSzCdEdhistType());
        educationalHistory.setIndEdhistLicense(rowccfc18sig00.getSzIndEdhistLicense());
        educationalHistory.setNmEdhistSchDist(rowccfc18sig00.getSzNmEdhistSchDist());
        // New Fields R2
        educationalHistory.setCdEdhistNeeds9(rowccfc18sig00.getSzCdEdhistNeeds9());
        educationalHistory.setCdEdhistNeeds10(rowccfc18sig00.getSzCdEdhistNeeds10());
        educationalHistory.setIndSchRec(rowccfc18sig00.getRbSchoolRecs());
        educationalHistory.setIndRecBoard(rowccfc18sig00.getRbRecsToBCounty());
        educationalHistory.setIndSchChg(rowccfc18sig00.getRbSchoolChange());
        educationalHistory.setTxtDscplComm(rowccfc18sig00.getSzTxtBehaveDisc());
        educationalHistory.setIndSpcEduNeed(rowccfc18sig00.getRbSpecialEdNeeds());
        educationalHistory.setIndPrevEduNeed(rowccfc18sig00.getRbSpecialEdSvc());
        educationalHistory.setTxtSpcEdu(rowccfc18sig00.getSzTxtSpecialEdCmnts());
        educationalHistory.setDtSstRef(rowccfc18sig00.getSzDtStSupTeamRef());
        educationalHistory.setDtEduPlan(rowccfc18sig00.getSzDtRbEdDate());
        educationalHistory.setNmSurrPrnt(rowccfc18sig00.getTxtSurrogateParent());
        educationalHistory.setIndFstrPrnt(rowccfc18sig00.getRbIndFosterParent());
        educationalHistory.setIndLegalPrnt(rowccfc18sig00.getRbLegalParent());
        educationalHistory.setTxtSst(rowccfc18sig00.getSzTxtSstIepCmnts());
        educationalHistory.setIndEis(rowccfc18sig00.getRbChildServices());
        educationalHistory.setIndPrevEis(rowccfc18sig00.getRbPrevChildSvc());
        educationalHistory.setTxtEis(rowccfc18sig00.getSzTxtChildSvcComments());
        educationalHistory.setIndCurrGradeLevel(rowccfc18sig00.getRbCIndEdhistLevel());
        educationalHistory.setCdCurrGrade(rowccfc18sig00.getSzCEdhistCurrentGradeLevel());
        educationalHistory.setCdAttendance(rowccfc18sig00.getSzCEdhistAttendance());
        //STGAP00009116: fields moved from form to page
        educationalHistory.setTxtSchCngCmnt(rowccfc18sig00.getSzTxtSchoolChangeCmnts());
        educationalHistory.setTxtSchRecOnFileCmnt(rowccfc18sig00.getSzTxtSchoolRecordsCmnts());

        int idResource = rowccfc18sig00.getUlIdResource();
        if (idResource != 0) {
          CapsResource capsResource = (CapsResource) getPersistentObject(CapsResource.class, idResource);
          educationalHistory.setCapsResource(capsResource);
        }
        Person person = (Person) getPersistentObject(Person.class, idPerson);
        educationalHistory.setPerson(person);
        // caud78d
        educationalHistoryDAO.saveEducationalHistory(educationalHistory);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdScrDataAction)) {
        // caud78d
        // if (0 == educationalHistoryDAO.deleteEducationalHistory(idEdHist, dtLastUpdate)) {
        // throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        // }
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    return ccfc18so;
  }
}
