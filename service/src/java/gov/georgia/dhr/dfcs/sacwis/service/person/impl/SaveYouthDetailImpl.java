/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.YouthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.YouthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveYouthDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthDetailSaveSO;

/**
 * @author hong.van.t.vo
 * 
 */
public class SaveYouthDetailImpl extends BaseServiceImpl implements SaveYouthDetail {
  private YouthDetailDAO youthDetailDAO = null;

  public void setYouthDetailDAO(YouthDetailDAO youthDetailDAO) {
    this.youthDetailDAO = youthDetailDAO;
  }

  public YouthDetailSaveSO saveYouthDetail(YouthDetailSaveSI youthDetailSaveSI) {
    YouthDetailSaveSO youthDetailSaveSO = new YouthDetailSaveSO();
    YouthDetail youthDetailDB = populateYouthDetail(youthDetailSaveSI);
    youthDetailDAO.saveYouthDetail(youthDetailDB);
    youthDetailSaveSO.setIdPerson(youthDetailDB.getIdPerson());
    return youthDetailSaveSO;
  }

  private YouthDetail populateYouthDetail(YouthDetailSaveSI youthDetailSaveSI) {
    YouthDetail youthDetailDB = new YouthDetail();
    int idPerson = youthDetailSaveSI.getIdPerson();
    Person person = (Person) getPersistentObject(Person.class, idPerson);
    youthDetailDB.setPerson(person);// youthDetailToSave.setCReqFunc(ServiceConstants.REQ_FUNC_CD_ADD);
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(youthDetailSaveSI.getCReqFunc())) {
      youthDetailDB.setIdPerson(idPerson);
    }
    youthDetailDB.setCdParStat(youthDetailSaveSI.getCdParentalStatus());
    youthDetailDB.setDtEmncDisc(youthDetailSaveSI.getDtEmancipationDiscussionDate());
    youthDetailDB.setTxtEmncDisc(youthDetailSaveSI.getTxtEmancipationDiscussionCmnt());
    youthDetailDB.setIndLifeSkills(youthDetailSaveSI.getIndLifeSkillsTrainingRecvd());
    youthDetailDB.setTxtLifeSkills(youthDetailSaveSI.getTxtIndLifeSkillsTrainingRecvd());
    youthDetailDB.setIndEmpSvc(youthDetailSaveSI.getIndEmploymentServiceRecvd());
    youthDetailDB.setTxtEmpSvc(youthDetailSaveSI.getTxtIndEmploymntServiceRecvd());
    youthDetailDB.setIndHealthSvc(youthDetailSaveSI.getIndHealthServiceRecvd());
    youthDetailDB.setTxtHlthSvc(youthDetailSaveSI.getTxtIndHealthServiceRecvd());
    //
    youthDetailDB.setNmSch(youthDetailSaveSI.getTxtHiSchoolName());
    youthDetailDB.setDtSchGrad(youthDetailSaveSI.getDtExpectdHiSchoolGradtn());
    youthDetailDB.setCdAcadTrack(youthDetailSaveSI.getCdAcademicTrack());
    if (StringHelper.isValid(youthDetailSaveSI.getTxtCreditsRequired())) {
      youthDetailDB.setNbrSchCreditReqd(Integer.parseInt(youthDetailSaveSI.getTxtCreditsRequired()));
    }
    if (StringHelper.isValid(youthDetailSaveSI.getTxtCreditsEarned())) {
      youthDetailDB.setNbrSchCreditEarned(Integer.parseInt(youthDetailSaveSI.getTxtCreditsEarned()));
    }
    if (StringHelper.isValid(youthDetailSaveSI.getTxtHsCurrentGPA())) {
      youthDetailDB.setNbrSchCurrGpa(Double.parseDouble(youthDetailSaveSI.getTxtHsCurrentGPA()));
    }
    if (StringHelper.isValid(youthDetailSaveSI.getTxtHsCumulativeGPA())) {
      youthDetailDB.setNbrSchCumGpa(Double.parseDouble(youthDetailSaveSI.getTxtHsCumulativeGPA()));
    }
    youthDetailDB.setIndSchGrad(youthDetailSaveSI.getIndHsGraduate());
    youthDetailDB.setTxtSchCmnts(youthDetailSaveSI.getTxtIndHsGradteCmnt());
    //
    youthDetailDB.setNmGedProg(youthDetailSaveSI.getTxtGEDProgramName());
    youthDetailDB.setIndGedProg(youthDetailSaveSI.getIndInGEDProgram());
    youthDetailDB.setAddrGedAddr1(youthDetailSaveSI.getTxtGEDProgAddressLine1());
    youthDetailDB.setAddrGedAddr2(youthDetailSaveSI.getTxtGEDProgAddressLine2());
    youthDetailDB.setAddrGedAddrCity(youthDetailSaveSI.getTxtGEDProgCity());
    youthDetailDB.setAddrGedAddrState(youthDetailSaveSI.getCdGEDProgState());
    youthDetailDB.setAddrGedAddrZip(youthDetailSaveSI.getTxtGEDProgZipCode());
    youthDetailDB.setNbrGedPhone(youthDetailSaveSI.getTxtGEDProgPhoneNum());
    youthDetailDB.setNbrGedFax(youthDetailSaveSI.getTxtGEDProgFaxNum());
    youthDetailDB.setDtGedExpProgComp(youthDetailSaveSI.getDtExpectdGEDProgramComp());
    youthDetailDB.setDtGedProgComp(youthDetailSaveSI.getDtActualGEDProgramComp());
    //
    youthDetailDB.setNmInst(youthDetailSaveSI.getTxtPostInstitutionName());
    youthDetailDB.setCdEduGoal(youthDetailSaveSI.getCdPostEduGoal());
    youthDetailDB.setCdClassif(youthDetailSaveSI.getCdPostClassification());
    youthDetailDB.setTxtAreaStudy(youthDetailSaveSI.getTxtPostAreaofStudy());
    if (StringHelper.isValid(youthDetailSaveSI.getTxtPostReqdCreditsforGradtn())) {
      youthDetailDB.setNbrPostReqCred(Integer.parseInt(youthDetailSaveSI.getTxtPostReqdCreditsforGradtn()));
    }
    if (StringHelper.isValid(youthDetailSaveSI.getTxtPostEarndCreditsforGradtn())) {
      youthDetailDB.setNbrPostReqEar(Integer.parseInt(youthDetailSaveSI.getTxtPostEarndCreditsforGradtn()));
    }
    if (StringHelper.isValid(youthDetailSaveSI.getTxtPostCurrentGPA())) {
      youthDetailDB.setNbrPostCurrGpa(Double.parseDouble(youthDetailSaveSI.getTxtPostCurrentGPA()));
    }
    if (StringHelper.isValid(youthDetailSaveSI.getTxtPostCumulativeGPA())) {
      youthDetailDB.setNbrPostCummGpa(Double.parseDouble(youthDetailSaveSI.getTxtPostCumulativeGPA()));
    }
    youthDetailDB.setDtPostExpGrad(youthDetailSaveSI.getDtPostExpectdGradtn());
    youthDetailDB.setDtPostGrad(youthDetailSaveSI.getDtPostActualGradtn());
    // Retrieve timestamp for use when update detail record
    youthDetailDB.setDtLastUpdate(youthDetailSaveSI.getDtLastUpdate());

    return youthDetailDB;
  }
}
