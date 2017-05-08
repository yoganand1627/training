package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantInfo;
import java.util.Date;

/**
 *  Created on Dec 22, 2006 at 4:50:45 PM by Ade Odutayo
 *
 */
public interface HomeApplicantInfoDAO {
  
  /**
   * @param IdResource
   * @return
   */
  HomeApplicantInfo findHomeApplicantInfoByIdResource( int IdResource );

  /**
   * @param idHomeApplicant
   * @param idResource
   * @param dtInquiry
   * @param dtApplied
   * @param cdInquiryRcvd
   * @param cdInfoPacket
   * @param dtInfoSent
   * @param txtChildInt
   * @param txtInqryComm
   * @return
   */
  int insertIntoHomeApplicantInfo( int idHomeApplicant, int idResource, Date dtInquiry, Date dtApplied, String cdInquiryRcvd,
                                   String cdInfoPacket, Date dtInfoSent,int inqReqNbrChldrn,
                                   String txtChildInt, String txtInqryComm);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantInfo} object to the database.
   *
   * @param homeApplicantInfo A populated {@link gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantInfo} object.
   */
  void saveHomeApplicantInfo(HomeApplicantInfo homeApplicantInfo);

}
