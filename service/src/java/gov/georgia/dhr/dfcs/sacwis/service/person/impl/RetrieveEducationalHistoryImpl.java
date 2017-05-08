package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicCapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EducationalHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EducationalHistory;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveEducationalHistory;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00_ARRAY;

public class RetrieveEducationalHistoryImpl extends BaseServiceImpl implements RetrieveEducationalHistory {

  public static final String IN_STATE = "I";

  private EducationalHistoryDAO educationalHistoryDAO = null;

  private DynamicCapsResourceDAO dynamicCapsResourceDAO = null;

  public void setEducationalHistoryDAO(EducationalHistoryDAO educationalHistoryDAO) {
    this.educationalHistoryDAO = educationalHistoryDAO;
  }

  public void setDynamicCapsResourceDAO(DynamicCapsResourceDAO dynamicCapsResourceDAO) {
    this.dynamicCapsResourceDAO = dynamicCapsResourceDAO;
  }

  public CCFC17SO retrieveEducationalHistory(CCFC17SI ccfc17si) throws ServiceException {
    CCFC17SO ccfc17so = new CCFC17SO();
    Calendar cal = Calendar.getInstance();
    ccfc17so.setDtWCDDtSystemDate(DateHelper.toCastorDate(cal.getTime()));
    // clsc49d
    List<EducationalHistory> educationalHistoryInfo = educationalHistoryDAO
                                                                           .findEducationalHistoryByIdPerson(ccfc17si
                                                                                                                     .getUlIdPerson());

    ROWCCFC17SOG00_ARRAY rowccfc17sog00_array = new ROWCCFC17SOG00_ARRAY();

    for (Iterator<EducationalHistory> it1 = educationalHistoryInfo.iterator(); it1.hasNext();) {
      EducationalHistory educationalHistory = it1.next();
      ROWCCFC17SOG00 rowccfc17sog00 = new ROWCCFC17SOG00();
      rowccfc17sog00.setSzNmEdhistSchDist(educationalHistory.getNmEdhistSchDist());
      rowccfc17sog00.setSzNmEdhistSchool(educationalHistory.getNmEdhistSchool());
      rowccfc17sog00.setSzCdEdhistNeeds1(educationalHistory.getCdEdhistNeeds1());
      rowccfc17sog00.setSzCdEdhistNeeds2(educationalHistory.getCdEdhistNeeds2());
      rowccfc17sog00.setSzCdEdhistNeeds3(educationalHistory.getCdEdhistNeeds3());
      rowccfc17sog00.setSzCdEdhistNeeds4(educationalHistory.getCdEdhistNeeds4());
      rowccfc17sog00.setSzCdEdhistNeeds5(educationalHistory.getCdEdhistNeeds5());
      rowccfc17sog00.setSzCdEdhistNeeds6(educationalHistory.getCdEdhistNeeds6());
      rowccfc17sog00.setSzCdEdhistNeeds7(educationalHistory.getCdEdhistNeeds7());
      rowccfc17sog00.setSzCdEdhistNeeds8(educationalHistory.getCdEdhistNeeds8());
      rowccfc17sog00.setSzEdHistComments(educationalHistory.getTxtEdhistCmnts());
      rowccfc17sog00.setSzCdEdhistType(educationalHistory.getCdEdhistType());
      rowccfc17sog00.setSzIndEdhistLicense(educationalHistory.getIndEdhistLicense());
      rowccfc17sog00.setSzCdEdhistEnrollGrade(educationalHistory.getCdEdhistEnrollGrade());
      rowccfc17sog00.setSzCdEdhistWithdrawnGrade(educationalHistory.getCdEdhistWithdrawnGrade());
      rowccfc17sog00.setSzAddrEdhistCity(educationalHistory.getAddrEdhistCity());
      rowccfc17sog00.setSzAddrEdhistCnty(educationalHistory.getAddrEdhistCnty());
      rowccfc17sog00.setSzAddrEdhistState(educationalHistory.getAddrEdhistState());
      rowccfc17sog00.setSzAddrEdhistStreetLn1(educationalHistory.getAddrEdhistStreetLn1());
      rowccfc17sog00.setSzAddrEdhistStreetLn2(educationalHistory.getAddrEdhistStreetLn2());
      rowccfc17sog00.setSzAddrEdhistZip(educationalHistory.getAddrEdhistZip());
      rowccfc17sog00.setSzNbrEdhistPhone(educationalHistory.getNbrEdhistPhone());
      rowccfc17sog00.setSzNbrEdhistPhoneExt(educationalHistory.getNbrEdhistPhoneExt());
      rowccfc17sog00.setSzTxtEdhistAddrCmnt(educationalHistory.getTxtEdhistAddrCmnt());
      rowccfc17sog00.setTsLastUpdate(educationalHistory.getDtLastUpdate());
      rowccfc17sog00.setDtDtEdhistEnrollDate(DateHelper.toCastorDate(educationalHistory.getDtEdhistEnrollDate()));
      rowccfc17sog00.setDtDtEdhistWithdrawnDate(DateHelper.toCastorDate(educationalHistory.getDtEdhistWithdrawnDate()));
      rowccfc17sog00.setCIndEdhistTeaSchool(educationalHistory.getIndEdhistTeaSchool());
      rowccfc17sog00.setUlIdEdhist(educationalHistory.getIdEdhist() != null ? educationalHistory.getIdEdhist() : 0);
      rowccfc17sog00
                    .setUlIdResource(educationalHistory.getCapsResource() != null ? educationalHistory
                                                                                                      .getCapsResource()
                                                                                                      .getIdResource()
                                                                                 : 0);

      // New Fields R2

      rowccfc17sog00.setSzCdEdhistNeeds9(educationalHistory.getCdEdhistNeeds9());
      rowccfc17sog00.setSzCdEdhistNeeds10(educationalHistory.getCdEdhistNeeds10());
      rowccfc17sog00.setRbSchoolRecs(educationalHistory.getIndSchRec());
      rowccfc17sog00.setRbRecsToBCounty(educationalHistory.getIndRecBoard());
      rowccfc17sog00.setRbSchoolChange(educationalHistory.getIndSchChg());
      rowccfc17sog00.setSzTxtBehaveDisc(educationalHistory.getTxtDscplComm());
      rowccfc17sog00.setRbSpecialEdNeeds(educationalHistory.getIndSpcEduNeed());
      rowccfc17sog00.setRbSpecialEdSvc(educationalHistory.getIndPrevEduNeed());
      rowccfc17sog00.setSzTxtSpecialEdCmnts(educationalHistory.getTxtSpcEdu());
      rowccfc17sog00.setSzDtStSupTeamRef(educationalHistory.getDtSstRef());
      rowccfc17sog00.setSzDtRbEdDate(educationalHistory.getDtEduPlan());
      rowccfc17sog00.setTxtSurrogateParent(educationalHistory.getNmSurrPrnt());
      rowccfc17sog00.setRbIndFosterParent(educationalHistory.getIndFstrPrnt());
      rowccfc17sog00.setRbLegalParent(educationalHistory.getIndLegalPrnt());
      rowccfc17sog00.setSzTxtSstIepCmnts(educationalHistory.getTxtSst());
      rowccfc17sog00.setRbChildServices(educationalHistory.getIndEis());
      rowccfc17sog00.setRbPrevChildSvc(educationalHistory.getIndPrevEis());
      rowccfc17sog00.setSzTxtChildSvcComments(educationalHistory.getTxtEis());
      rowccfc17sog00.setRbCIndEdhistLevel(educationalHistory.getIndCurrGradeLevel());
      rowccfc17sog00.setSzCEdhistCurrentGradeLevel(educationalHistory.getCdCurrGrade());
      rowccfc17sog00.setSzCEdhistAttendance(educationalHistory.getCdAttendance());
      //STGAP00009116: fields moved from form to page
      rowccfc17sog00.setSzTxtSchoolChangeCmnts(educationalHistory.getTxtSchCngCmnt());
      rowccfc17sog00.setSzTxtSchoolRecordsCmnts(educationalHistory.getTxtSchRecOnFileCmnt());

      // Retrieve Resource Address for In State/ TEA Certified Schools
      if (IN_STATE.equals(rowccfc17sog00.getCIndEdhistTeaSchool())) {
        int idResource = rowccfc17sog00.getUlIdResource();
        // cres03d -- Uses only idResource
        List<Map> dynamicResourceMap = dynamicCapsResourceDAO.findResources(null, // cdRsrcType,
                                                                            null, // cdRsrcSvcProgram,
                                                                            null, // nmResource,
                                                                            null, // nmRsrcNmInd,
                                                                            idResource, null, // cdRsrcSvcCategRsrc,
                                                                            null, // cdRsrcFacilType,
                                                                            null, // cdRsrcSvcState,
                                                                            null, // cdRsrcSvcRegion,
                                                                            null, // nmCity,
                                                                            null, // cdRsrcSvcCnty,
                                                                            null, // addrRsrcAddrZip,
                                                                            null, // indRsrcTransport,
                                                                            null, // indRsrcInactive,
                                                                            0, // scrYrRsrcCharMin,
                                                                            null, // cdRsrcCharSex,
                                                                            0, // nbrRsrcFacilAcclaim,
                                                                            null, // scrCdRsrcSort,
                                                                            null, // cdRsrcCharChrctr,
                                                                            null, // cdFloc,
                                                                            null, // cdRsrcSvcService,
                                                                            null, // scrCdRsrcSvcContract,
                                                                            null, // scrIndRsrcLocation,
                                                                            null, // dtSvcAuthEff,
                                                                            null); // cdMhmrCompCode);
        if (dynamicResourceMap != null && !dynamicResourceMap.isEmpty()) {
          Map dynamicResource = dynamicResourceMap.get(0);
          rowccfc17sog00.setSzAddrEdhistCnty((String) dynamicResource.get("addrRsrcCnty"));
          rowccfc17sog00.setSzAddrEdhistCity((String) dynamicResource.get("addrRsrcCity"));
          rowccfc17sog00.setSzAddrEdhistState((String) dynamicResource.get("cdRsrcState"));
          rowccfc17sog00.setSzAddrEdhistStreetLn1((String) dynamicResource.get("addrRsrcStLn1"));
          rowccfc17sog00.setSzAddrEdhistStreetLn2((String) dynamicResource.get("addrRsrcStLn2"));
          rowccfc17sog00.setSzAddrEdhistZip((String) dynamicResource.get("addrRsrcZip"));
          rowccfc17sog00.setSzNbrEdhistPhone((String) dynamicResource.get("nbrRsrcPhn"));
          rowccfc17sog00.setSzNbrEdhistPhoneExt((String) dynamicResource.get("nbrRsrcPhoneExt"));
        }
      }
      rowccfc17sog00_array.addROWCCFC17SOG00(rowccfc17sog00);
    }
    ccfc17so.setROWCCFC17SOG00_ARRAY(rowccfc17sog00_array);
    return ccfc17so;
  }

}
