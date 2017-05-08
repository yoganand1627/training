package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingFacilityDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingFacility;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveIncomingFacilityDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FacilRtrvInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacilRtrvOutRec;

/**
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  05/24/10  bgehlot   SMS#51977 MR-066 Changes
 *  06/30/10  hnguyen   SMS#59535 MR-066 Removed exception thrown and 
 *                      return null if no Incoming Facility found
 *                         
 *                      
 * </pre>
 */

public class RetrieveIncomingFacilityDetailImpl extends BaseServiceImpl implements RetrieveIncomingFacilityDetail {

  private IncomingFacilityDAO incomingFacilityDAO = null;

  public void setIncomingFacilityDAO(IncomingFacilityDAO incomingFacilityDAO) {
    this.incomingFacilityDAO = incomingFacilityDAO;

  }

  public FacilRtrvOutRec retrieveIncomingFacilityDetail(FacilRtrvInRec facilRtrvInRec) throws ServiceException {
    FacilRtrvOutRec facilRtrvOutRec = new FacilRtrvOutRec();

    IncomingFacility incomingFacility = incomingFacilityDAO
                                                           .findIncomingFacilityByIdStage(facilRtrvInRec
                                                                                                        .getFacilRtrvStruc()
                                                                                                        .getUlIdStage());

    if (incomingFacility == null) {
      return null;
//      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    FacDetailEntStruct facDetailEntStruct = new FacDetailEntStruct();

    CapsResource capsResource = incomingFacility.getCapsResource();
    if (capsResource != null) {
      facDetailEntStruct.setUlIdResource(capsResource.getIdResource());
      facDetailEntStruct.setSzCdRsrcType(capsResource.getCdRsrcType());
      //SMS#51977 05/24/10  bgehlot   SMS#51977 MR-066 Changes
      if(capsResource.getStage() != null){
        facDetailEntStruct.setUlIdHomeStage(capsResource.getStage().getIdStage());
      }
    }
    facDetailEntStruct.setSzAddrIncmgFacilCity(incomingFacility.getAddrIncmgFacilCity());
    facDetailEntStruct.setSzCdIncFacilOperBy(incomingFacility.getCdIncmgFacilOperBy());
    facDetailEntStruct.setBIndIncmgFacilAbSupvd(incomingFacility.getIndIncmgFacilAbSupvd());
    facDetailEntStruct.setBIndIncmgFacilSearch(incomingFacility.getIndIncmgFacilSearch());
    facDetailEntStruct.setSzAddrIncmgFacilStLn1(incomingFacility.getAddrIncmgFacilStLn1());
    facDetailEntStruct.setSzAddrIncmgFacilStLn2(incomingFacility.getAddrIncmgFacilStLn2());
    facDetailEntStruct.setSzAddrIncmgFacilZip(incomingFacility.getAddrIncmgFacilZip());
    facDetailEntStruct.setSzCdIncmgFacilCnty(incomingFacility.getCdIncmgFacilCnty());
    facDetailEntStruct.setSzCdIncmgFacilState(incomingFacility.getCdIncmgFacilState());
    facDetailEntStruct.setSzCdIncmgFacilType(incomingFacility.getCdIncmgFacilType());
    facDetailEntStruct.setSzNbrIncmgFacilPhone(incomingFacility.getNbrIncmgFacilPhone());
    facDetailEntStruct.setSzNbrIncmgFacilPhoneExt(incomingFacility.getNbrIncmgFacilPhoneExt());
    facDetailEntStruct.setSzNmUnitWard(incomingFacility.getNmIncmgFacilUnitWard());
    facDetailEntStruct.setSzNmIncmgFacilAffiliated(incomingFacility.getNmIncmgFacilAffiliated());
    facDetailEntStruct.setNmIncmgFacilName(incomingFacility.getNmIncmgFacilName());
    facDetailEntStruct.setBIndIncmgOnGrnds(incomingFacility.getIndIncmgFacilOffGrnds());
    facDetailEntStruct.setSzTxtFacilCmnts(incomingFacility.getTxtIncomingFacilCmnts());
    facDetailEntStruct.setSzNmIncmgFacilSuprtdant(incomingFacility.getNmIncmgFacilSuprtdant());
    facilRtrvOutRec.setFacDetailEntStruct(facDetailEntStruct);

    return facilRtrvOutRec;
  }

}
