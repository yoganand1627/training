package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.HomeApplicantCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.HomeApplicantInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantCbx;
import gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantInfo;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.SaveHomeApplicant;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HomeApplicantSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HomeApplicantSaveSO;

import java.util.Date;

/**
 * This is the Service class used to save the Home Applicant Information for an F/A Home
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *                 Ade    Initial Development
 *  02/15/09    vdevarak  STGAP00012476: Made necessary code changes to save the new date field 'Date Applied'
 *                         added to the inquiry section on the Home Info page.                 
 *  
 * </pre>
 */
public class SaveHomeApplicantImpl extends BaseServiceImpl implements SaveHomeApplicant {

  private HomeApplicantCbxDAO homeApplicantCbxDAO = null;
  private HomeApplicantInfoDAO homeApplicantInfoDAO = null;
 
  public void setHomeApplicantCbxDAO(HomeApplicantCbxDAO homeApplicantCbxDAO) {
    this.homeApplicantCbxDAO = homeApplicantCbxDAO;
  }
  
  public void setHomeApplicantInfoDAO(HomeApplicantInfoDAO homeApplicantInfoDAO) {
    this.homeApplicantInfoDAO = homeApplicantInfoDAO;
  }

  /* (non-Javadoc)
   * @see gov.georgia.dhr.dfcs.sacwis.service.resource.SaveHomeApplicant#saveHomeApplicantInfo(gov.georgia.dhr.dfcs.sacwis.structs.input.HomeApplicantSaveSI)
   */
  public HomeApplicantSaveSO saveHomeApplicantInfo(HomeApplicantSaveSI homeApplicantSaveSI) throws ServiceException{
    /*
     * check if function code is new data implying an add
     * otherwise it is a modify.
     */
    HomeApplicantSaveSO homeApplicantSaveSO = new HomeApplicantSaveSO();
    //HomeApplicantInfo homeApplicantInfo = new HomeApplicantInfo() ;

    //populate inquiry information section
    //call save inquiry information, save sources of inquiry
    //and save information covered
    if( homeApplicantSaveSI.getArchInputStruct().getCReqFuncCd().equalsIgnoreCase( ADD )){
      int idHomeApplicant = 0;
      int idResource =  homeApplicantSaveSI.getIdResource();
      Date dtInquiry = homeApplicantSaveSI.getInquiryDate();
      Date dtApplied= homeApplicantSaveSI.getDateApplied();
      Date dtInfoSent = homeApplicantSaveSI.getInfPacktSent();
      String cdInquiryRcvd = homeApplicantSaveSI.getInquiryRecvdBy();
      String cdInfoPacket = homeApplicantSaveSI.getInfoPacktRequested();
      int inqReqNbrChldrn = homeApplicantSaveSI.getIRequestedNbrOfChildren();
      String txtChildInt =  homeApplicantSaveSI.getChildSpecInterest();
      String txtInqryComm =  homeApplicantSaveSI.getInquiryComments();
      
      //get next sequence id 
      idHomeApplicant = commonDAO.getNextval("SEQ_HOME_APPLICANT");
      //|| idHomeApplicant == 0
      //STGAP00012476: Changed the signature of the insert method to include the new field dtApplied to the insert statement
      int nbrRowsUpdated = homeApplicantInfoDAO.insertIntoHomeApplicantInfo(idHomeApplicant, idResource, dtInquiry, dtApplied, cdInquiryRcvd,
                                                   cdInfoPacket, dtInfoSent, inqReqNbrChldrn, txtChildInt, 
                                                   txtInqryComm );
      
      if( nbrRowsUpdated == 0  )
        throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
      
      homeApplicantSaveSO.setIdHomeApplicant( idHomeApplicant );
      homeApplicantSaveSO.setIdResource( idResource );
      //update the array
      updateHomeApplicantCbx( homeApplicantSaveSI, idHomeApplicant );
    }
    else if( homeApplicantSaveSI.getArchInputStruct().getCReqFuncCd().equalsIgnoreCase( MODIFY )){
      HomeApplicantInfo homeApplicantInfo = commonDAO.getPersistentObject(HomeApplicantInfo.class, homeApplicantSaveSI.getIdHomeApplicant() );
      homeApplicantInfo.setDtInquiry( homeApplicantSaveSI.getInquiryDate() );
      //STGAP00012476: Set the new field date applied into the save object
      homeApplicantInfo.setDtApplied( homeApplicantSaveSI.getDateApplied() );
      homeApplicantInfo.setDtInfoSent( homeApplicantSaveSI.getInfPacktSent() );
      homeApplicantInfo.setCdInquiryRcvd( homeApplicantSaveSI.getInquiryRecvdBy() );
      homeApplicantInfo.setCdInfoPacket( homeApplicantSaveSI.getInfoPacktRequested() );
      homeApplicantInfo.setInqReqNbrChldrn( homeApplicantSaveSI.getIRequestedNbrOfChildren() );
      homeApplicantInfo.setTxtChildInt( homeApplicantSaveSI.getChildSpecInterest() );
      homeApplicantInfo.setTxtInqryComm( homeApplicantSaveSI.getInquiryComments() );
      //orientation preservice sub-module
      //orientation subsection
      homeApplicantInfo.setDtOrient1( homeApplicantSaveSI.getDtOrientation1() );
      homeApplicantInfo.setCdOrient1Stat( homeApplicantSaveSI.getStrOrientationStatus1() );
      homeApplicantInfo.setDtOrient2( homeApplicantSaveSI.getDtOrientation2() );
      homeApplicantInfo.setCdOrient2Stat( homeApplicantSaveSI.getStrOrientationStatus2() );
      homeApplicantInfo.setDtOrient3( homeApplicantSaveSI.getDtOrientation3() );
      homeApplicantInfo.setCdOrient3Stat( homeApplicantSaveSI.getStrOrientationStatus3() );
      //preservice training subsection
      homeApplicantInfo.setDtInvite1( homeApplicantSaveSI.getDtInvitation1() );
      homeApplicantInfo.setCdInvite1Stat( homeApplicantSaveSI.getStrInvitationStatus1() );
      homeApplicantInfo.setTxtInvite1Loc( homeApplicantSaveSI.getStrLocation1() );
      homeApplicantInfo.setDtInvite2( homeApplicantSaveSI.getDtInvitation2() );
      homeApplicantInfo.setCdInvite2Stat( homeApplicantSaveSI.getStrInvitationStatus2() );
      homeApplicantInfo.setTxtInvite2Loc( homeApplicantSaveSI.getStrLocation2() );
      homeApplicantInfo.setDtInvite3( homeApplicantSaveSI.getDtInvitation3() );
      homeApplicantInfo.setCdInvite3Stat( homeApplicantSaveSI.getStrInvitationStatus3() );
      homeApplicantInfo.setTxtInvite3Loc( homeApplicantSaveSI.getStrLocation3() );
      homeApplicantInfo.setTxtTrnComm( homeApplicantSaveSI.getOrientationComments() );
      //save home applicant info
      homeApplicantInfoDAO.saveHomeApplicantInfo( homeApplicantInfo );
      
      int nbrUpdatedRows = 0;
      HomeApplicantInfo homeApplicantInfo2 = commonDAO.getPersistentObject(HomeApplicantInfo.class, homeApplicantSaveSI.getIdHomeApplicant() );
      if(    homeApplicantInfo.getDtInquiry() == homeApplicantInfo2.getDtInquiry()
          //STGAP00012476: Added condition to check the new field date applied 
          && homeApplicantInfo.getDtApplied() == homeApplicantInfo2.getDtApplied()
          && homeApplicantInfo.getDtLastUpdate() == homeApplicantInfo2.getDtLastUpdate()
          && homeApplicantInfo.getDtInfoSent() == homeApplicantInfo2.getDtInfoSent()
          && homeApplicantInfo.getCdInquiryRcvd() == homeApplicantInfo2.getCdInquiryRcvd()
          && homeApplicantInfo.getCdInfoPacket() == homeApplicantInfo2.getCdInfoPacket()
          && homeApplicantInfo.getInqReqNbrChldrn() == homeApplicantInfo2.getInqReqNbrChldrn()
          && homeApplicantInfo.getTxtChildInt() == homeApplicantInfo2.getTxtChildInt()
          && homeApplicantInfo.getTxtInqryComm() == homeApplicantInfo2.getTxtInqryComm()
          && homeApplicantInfo.getDtOrient1() == homeApplicantInfo2.getDtOrient1()
          && homeApplicantInfo.getCdOrient1Stat() == homeApplicantInfo2.getCdOrient1Stat()
          && homeApplicantInfo.getDtOrient2() == homeApplicantInfo2.getDtOrient2()
          && homeApplicantInfo.getCdOrient2Stat() == homeApplicantInfo2.getCdOrient2Stat()
          && homeApplicantInfo.getDtOrient3() == homeApplicantInfo2.getDtOrient3()
          && homeApplicantInfo.getCdOrient3Stat() == homeApplicantInfo2.getCdOrient3Stat()
          && homeApplicantInfo.getDtInvite1() == homeApplicantInfo2.getDtInvite1()
          && homeApplicantInfo.getCdInvite1Stat() == homeApplicantInfo2.getCdInvite1Stat()
          && homeApplicantInfo.getTxtInvite1Loc() == homeApplicantInfo2.getTxtInvite1Loc()
          && homeApplicantInfo.getDtInvite2() == homeApplicantInfo2.getDtInvite2()
          && homeApplicantInfo.getCdInvite2Stat() == homeApplicantInfo2.getCdInvite2Stat()
          && homeApplicantInfo.getTxtInvite2Loc() == homeApplicantInfo2.getTxtInvite2Loc()
          && homeApplicantInfo.getDtInvite3() == homeApplicantInfo2.getDtInvite3()
          && homeApplicantInfo.getTxtInvite3Loc() == homeApplicantInfo2.getTxtInvite3Loc()
          && homeApplicantInfo.getTxtTrnComm() == homeApplicantInfo2.getTxtTrnComm()
          && homeApplicantInfo.getCapsResource().getIdResource() == homeApplicantInfo2.getCapsResource().getIdResource() )
        nbrUpdatedRows++;
      
      if( nbrUpdatedRows == 0  )
        throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
      
      homeApplicantSaveSO.setIdHomeApplicant( homeApplicantInfo.getIdHomeApplicant() );
      homeApplicantSaveSO.setIdResource( homeApplicantInfo.getCapsResource().getIdResource() );
      //update the array
      updateHomeApplicantCbx( homeApplicantSaveSI, homeApplicantInfo.getIdHomeApplicant()  );
    }
    
    return homeApplicantSaveSO;
  }
  
    
  /**
   * saves the source of inquiry subsection. 
   */
  private void updateHomeApplicantCbx( HomeApplicantSaveSI homeApplicantSaveSI, int idHomeApplicant ){
    HomeApplicantInfo homeApplicantInfo = getPersistentObject(HomeApplicantInfo.class, idHomeApplicant);

    // Add / Update / Delete F/A Home Interest Programs Of Interest
    processCbxArray(homeApplicantSaveSI.getArrayProgramsOfInterest(), idHomeApplicant, homeApplicantInfo);
    
    // Add / Update / Delete Sources Of Inquiry section
    processCbxArray(homeApplicantSaveSI.getArraySourceOfInquiry(), idHomeApplicant, homeApplicantInfo);

    // Add / Update / Delete Information covered subsection
    processCbxArray(homeApplicantSaveSI.getArrayInformationCovered(), idHomeApplicant, homeApplicantInfo);
  }
  
  private void processCbxArray(ROWCFAD08SIG07_ARRAY array, int idHomeApplicant, HomeApplicantInfo info) {
    if(array != null && array.getROWCFAD08SIG07Count() > 0) {
      for (int i = 0; i < array.getROWCFAD08SIG07Count(); i++) {
        ROWCFAD08SIG07 rowcfad08sig07 = array.getROWCFAD08SIG07(i);
        String cbxType = rowcfad08sig07.getSzCdHmApplcntCbxType();
        String cbx = rowcfad08sig07.getSzCdHmApplcntCbx();
        
        String cdReqFunc = rowcfad08sig07.getSzCdSysDataActionOutcome();
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdReqFunc)) {
          HomeApplicantCbx homeApplicantCbx = new HomeApplicantCbx();
          homeApplicantCbx.setIdHomeApplicantCbx(0); //-- not necessary, but for clarity
          homeApplicantCbx.setHomeApplicantInfo(info);
          homeApplicantCbx.setCdHomeApplicantCbx(cbx);
          homeApplicantCbx.setCdHomeAplcntCbxType(cbxType);
          homeApplicantCbxDAO.saveHomeApplicantCbx( homeApplicantCbx );
        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdReqFunc)) {
          homeApplicantCbxDAO.deleteHomeApplicantCbx(idHomeApplicant, cbxType, cbx);
        } else if(ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdReqFunc)) {
          //-- no reason to update; do nothing
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
      }
    }
  }
}