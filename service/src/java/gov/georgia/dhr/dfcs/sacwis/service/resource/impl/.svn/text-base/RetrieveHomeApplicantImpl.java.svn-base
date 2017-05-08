package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;


import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.HomeApplicantCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.HomeApplicantInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantCbx;
import gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantInfo;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveHomeApplicant;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HomeApplicantRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HomeApplicantRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY;


/**
 * This is the Service class used to save the Home Applicant Information for an F/A Home
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  02/15/09    vdevarak  STGAP00012476: Made necessary code changes to retrieve the new date field 'Date Applied'
 *                        added to the inquiry section on the Home Info page.                 
 *  
 * </pre>
 */

public class RetrieveHomeApplicantImpl extends BaseServiceImpl implements RetrieveHomeApplicant {

  private HomeApplicantCbxDAO homeApplicantCbxDAO = null;
  private HomeApplicantInfoDAO homeApplicantInfoDAO = null;
 
  public void setHomeApplicantCbxDAO(HomeApplicantCbxDAO homeApplicantCbxDAO) {
    this.homeApplicantCbxDAO = homeApplicantCbxDAO;
  }
  
  public void setHomeApplicantInfoDAO(HomeApplicantInfoDAO homeApplicantInfoDAO) {
    this.homeApplicantInfoDAO = homeApplicantInfoDAO;
  }
  
  
  public HomeApplicantRetrieveSO retrieveHomeApplicantInfo(HomeApplicantRetrieveSI homeApplicantRetrieveSI) throws ServiceException {
    ArchInputStruct archInputStruct = homeApplicantRetrieveSI.getArchInputStruct();
    int idResource = homeApplicantRetrieveSI.getIdResource();
    HomeApplicantRetrieveSO homeApplicantRetrieveSO = null;
    if (RETRIEVE_RESOURCE.equals(archInputStruct.getCReqFuncCd())) {
      homeApplicantRetrieveSO = retrieveForModifiction(idResource);
    } else if (RETRIEVE_HISTORY.equals(archInputStruct.getCReqFuncCd())) {
      homeApplicantRetrieveSO = retrieveForInquire(idResource);
    } else {
      homeApplicantRetrieveSO = new HomeApplicantRetrieveSO();
    }
    return homeApplicantRetrieveSO;
  }

  private HomeApplicantRetrieveSO retrieveForModifiction( int idResource ){
    HomeApplicantRetrieveSO homeApplicantRetrieveSO = new HomeApplicantRetrieveSO();
    
    HomeApplicantInfo homeApplicantInfo = homeApplicantInfoDAO.findHomeApplicantInfoByIdResource( idResource );
    if( homeApplicantInfo == null )
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    //setting values
    homeApplicantRetrieveSO.setIdHomeApplicant( homeApplicantInfo.getIdHomeApplicant());
    homeApplicantRetrieveSO.setIdResource( homeApplicantInfo.getCapsResource().getIdResource() );
    homeApplicantRetrieveSO.setInquiryDate( homeApplicantInfo.getDtInquiry() );
    //STGAP00012476: Set the new field date applied into the retrieve object
    homeApplicantRetrieveSO.setDtApplied(homeApplicantInfo.getDtApplied());
    homeApplicantRetrieveSO.setInqRecvdBy( homeApplicantInfo.getCdInquiryRcvd() );
    homeApplicantRetrieveSO.setInfoPacktRequested( homeApplicantInfo.getCdInfoPacket() );
    homeApplicantRetrieveSO.setInfPacktSent( homeApplicantInfo.getDtInfoSent() );
    homeApplicantRetrieveSO.setIRequestedNbrOfChildren( homeApplicantInfo.getInqReqNbrChldrn() );
    homeApplicantRetrieveSO.setChildSpecInterest( homeApplicantInfo.getTxtChildInt() );
    homeApplicantRetrieveSO.setInquiryComments( homeApplicantInfo.getTxtInqryComm() );
    homeApplicantRetrieveSO.setDtOrientation1( homeApplicantInfo.getDtOrient1() );
    homeApplicantRetrieveSO.setStrOrientationStatus1( homeApplicantInfo.getCdOrient1Stat() );
    homeApplicantRetrieveSO.setDtOrientation2( homeApplicantInfo.getDtOrient2() );
    homeApplicantRetrieveSO.setStrOrientationStatus2( homeApplicantInfo.getCdOrient2Stat() );
    homeApplicantRetrieveSO.setDtOrientation3( homeApplicantInfo.getDtOrient3() );
    homeApplicantRetrieveSO.setStrOrientationStatus3( homeApplicantInfo.getCdOrient3Stat() );
    homeApplicantRetrieveSO.setDtInvitation1( homeApplicantInfo.getDtInvite1() );
    homeApplicantRetrieveSO.setStrInvitationStatus1( homeApplicantInfo.getCdInvite1Stat() );
    homeApplicantRetrieveSO.setStrLocation1( homeApplicantInfo.getTxtInvite1Loc() );
    homeApplicantRetrieveSO.setDtInvitation2( homeApplicantInfo.getDtInvite2() );
    homeApplicantRetrieveSO.setStrInvitationStatus2( homeApplicantInfo.getCdInvite2Stat() );
    homeApplicantRetrieveSO.setStrLocation2( homeApplicantInfo.getTxtInvite2Loc());
    homeApplicantRetrieveSO.setDtInvitation3( homeApplicantInfo.getDtInvite3() );
    homeApplicantRetrieveSO.setStrInvitationStatus3( homeApplicantInfo.getCdInvite3Stat() );
    homeApplicantRetrieveSO.setStrLocation3( homeApplicantInfo.getTxtInvite3Loc() );
    homeApplicantRetrieveSO.setOrientationComments( homeApplicantInfo.getTxtTrnComm() );

    //get programs of interest
    homeApplicantRetrieveSO.setArrayProgramsOfInterest(retrieveHomeApplicantCbxType( homeApplicantInfo.getIdHomeApplicant(),
                                                                                     PRGMSOFINTTYPE) );    
    //get srcs of inquiry
    homeApplicantRetrieveSO.setArraySourceOfInquiry(retrieveHomeApplicantCbxType( homeApplicantInfo.getIdHomeApplicant(),
                                                                                  SRCOFINQTYPE) );
    
    //get information covered
    homeApplicantRetrieveSO.setArrayInformationCovered(retrieveHomeApplicantCbxType( homeApplicantInfo.getIdHomeApplicant(),
                                                                                  INFCVRDTYPE) );
    return homeApplicantRetrieveSO;
  }
  
  
  
  private HomeApplicantRetrieveSO retrieveForInquire( int idResource ){
  
    return null;
  }
  
  private ROWCFAD07SOG07_ARRAY retrieveHomeApplicantCbxType( int idHomeApplicant, String type ){
    ROWCFAD07SOG07_ARRAY rowcfad07sog07_array = new ROWCFAD07SOG07_ARRAY();
    List<HomeApplicantCbx> homeApp = homeApplicantCbxDAO.findHomeApplicantCbxByIdHomeApplicantCbxType( idHomeApplicant, type );
    if( homeApp == null )
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    Iterator<HomeApplicantCbx> homeAppIter = homeApp.iterator();
    while( homeAppIter.hasNext() ){
      ROWCFAD07SOG07 rowcfad07sog07 = new ROWCFAD07SOG07();
      HomeApplicantCbx homeApplicantCbx = homeAppIter.next();
      rowcfad07sog07.setSzCdHmApplcntCbx( homeApplicantCbx.getCdHomeApplicantCbx() );
      rowcfad07sog07.setSzCdHmApplcntCbxType( homeApplicantCbx.getCdHomeAplcntCbxType() );
      rowcfad07sog07_array.addROWCFAD07SOG07( rowcfad07sog07 );
    }    
    return rowcfad07sog07_array;
  }
}
