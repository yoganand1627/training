package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingFacilityDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.SaveIncomingFacilityDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FacDetailEntStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FacilityDetailInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacilityDetailOutRec;

public class SaveIncomingFacilityDetailImpl extends BaseServiceImpl implements SaveIncomingFacilityDetail {

  private IncomingFacilityDAO incomingFacilityDAO = null;

  public void setIncomingFacilityDAO(IncomingFacilityDAO incomingFacilityDAO) {
    this.incomingFacilityDAO = incomingFacilityDAO;

  }

  public FacilityDetailOutRec saveIncomingFacilityDetail(FacilityDetailInRec facilDetail) throws ServiceException {

    ArchInputStruct input = facilDetail.getArchInputStruct();

    String reqFuncCd = input.getCReqFuncCd();

    FacilityDetailOutRec facilityDetailOutRec = new FacilityDetailOutRec();

    FacDetailEntStruct facDetailEntStruct = facilDetail.getFacDetailEntStruct();
    String indIncmgOnGrnds = facDetailEntStruct.getBIndIncmgOnGrnds();
    String cdNmIncmgFacilName = facDetailEntStruct.getNmIncmgFacilName();
    String cdNmIncmgFacilSuprtdant = facDetailEntStruct.getSzNmIncmgFacilSuprtdant();
    String cdIncFacilOperBy = facDetailEntStruct.getSzCdIncFacilOperBy();
    String cdNmIncmgFacilAffiliated = facDetailEntStruct.getSzNmIncmgFacilAffiliated();
    String indIncmgFacilSearch = facDetailEntStruct.getBIndIncmgFacilSearch();
    String indIncmgFacilAbSupvd = facDetailEntStruct.getBIndIncmgFacilAbSupvd();
    String cdIncmgFacilType = facDetailEntStruct.getSzCdIncmgFacilType();
    String cdAddrIncmgFacilStLn1 = facDetailEntStruct.getSzAddrIncmgFacilStLn1();
    String cdAddrIncmgFacilStLn2 = facDetailEntStruct.getSzAddrIncmgFacilStLn2();
    String cdIncmgFacilCnty = facDetailEntStruct.getSzCdIncmgFacilCnty();
    String cdIncmgFacilState = facDetailEntStruct.getSzCdIncmgFacilState();
    String cdNbrIncmgFacilPhone = facDetailEntStruct.getSzNbrIncmgFacilPhone();
    String cdAddrIncmgFacilZip = facDetailEntStruct.getSzAddrIncmgFacilZip();
    String cdAddrIncmgFacilCity = facDetailEntStruct.getSzAddrIncmgFacilCity();
    String cdNmUnitWard = facDetailEntStruct.getSzNmUnitWard();
    int idStage = facDetailEntStruct.getUlIdStage();
    String cdTxtFacilCmnts = facDetailEntStruct.getSzTxtFacilCmnts();
    String cdNbrIncmgFacilPhoneExt = facDetailEntStruct.getSzNbrIncmgFacilPhoneExt();
    int idResource = facDetailEntStruct.getUlIdResource();

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {

      if (idResource != 0) {
        incomingFacilityDAO.insertIncomingFacility_With_ResourceId(indIncmgOnGrnds, cdNmIncmgFacilName,
                                                                   cdNmIncmgFacilSuprtdant, cdIncFacilOperBy,
                                                                   cdNmIncmgFacilAffiliated, indIncmgFacilSearch,
                                                                   indIncmgFacilAbSupvd, cdIncmgFacilType,
                                                                   cdAddrIncmgFacilStLn1, cdAddrIncmgFacilStLn2,
                                                                   cdIncmgFacilState, cdIncmgFacilCnty,
                                                                   cdAddrIncmgFacilCity, cdAddrIncmgFacilZip,
                                                                   cdNbrIncmgFacilPhone, cdNbrIncmgFacilPhoneExt,
                                                                   cdNmUnitWard, cdTxtFacilCmnts, idStage, idResource);
      } else {

        incomingFacilityDAO.insertIncomingFacility_Without_ResourceId(indIncmgOnGrnds, cdNmIncmgFacilName,
                                                                      cdNmIncmgFacilSuprtdant, cdIncFacilOperBy,
                                                                      cdNmIncmgFacilAffiliated, indIncmgFacilSearch,
                                                                      indIncmgFacilAbSupvd, cdIncmgFacilType,
                                                                      cdAddrIncmgFacilStLn1, cdAddrIncmgFacilStLn2,
                                                                      cdIncmgFacilState, cdIncmgFacilCnty,
                                                                      cdAddrIncmgFacilCity, cdAddrIncmgFacilZip,
                                                                      cdNbrIncmgFacilPhone, cdNbrIncmgFacilPhoneExt,
                                                                      cdNmUnitWard, cdTxtFacilCmnts, idStage);
      }

    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {

      if (idStage != 0) {
        if (idResource != 0) {
          incomingFacilityDAO.updateIncomingFacilityDetail_With_ResourceId(indIncmgOnGrnds, cdNmIncmgFacilName,
                                                                           cdNmIncmgFacilSuprtdant, cdIncFacilOperBy,
                                                                           cdNmIncmgFacilAffiliated,
                                                                           indIncmgFacilSearch, indIncmgFacilAbSupvd,
                                                                           cdIncmgFacilType, cdAddrIncmgFacilStLn1,
                                                                           cdAddrIncmgFacilStLn2, cdIncmgFacilState,
                                                                           cdIncmgFacilCnty, cdAddrIncmgFacilCity,
                                                                           cdAddrIncmgFacilZip, cdNbrIncmgFacilPhone,
                                                                           cdNbrIncmgFacilPhoneExt, cdNmUnitWard,
                                                                           cdTxtFacilCmnts, idStage, idResource);
        } else {
          incomingFacilityDAO.updateIncomingFacilityDetail_Without_ResourceId(indIncmgOnGrnds, cdNmIncmgFacilName,
                                                                              cdNmIncmgFacilSuprtdant,
                                                                              cdIncFacilOperBy,
                                                                              cdNmIncmgFacilAffiliated,
                                                                              indIncmgFacilSearch,
                                                                              indIncmgFacilAbSupvd, cdIncmgFacilType,
                                                                              cdAddrIncmgFacilStLn1,
                                                                              cdAddrIncmgFacilStLn2, cdIncmgFacilState,
                                                                              cdIncmgFacilCnty, cdAddrIncmgFacilCity,
                                                                              cdAddrIncmgFacilZip,
                                                                              cdNbrIncmgFacilPhone,
                                                                              cdNbrIncmgFacilPhoneExt, cdNmUnitWard,
                                                                              cdTxtFacilCmnts, idStage);

        }
      }
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd))

    {

    }

    facilityDetailOutRec.setUlIdStage(idStage);
    return facilityDetailOutRec;
  }
}
