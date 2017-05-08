package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.HomeApplicantInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantInfo;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.SQLQuery;


/**
 * This is the DAO class used to define sqls to save and retrieve the Home Applicant Information for an F/A Home
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  02/15/09    vdevarak  STGAP00012476: Made necessary code changes to save the new date field 'Date Applied'
 *                         added to the inquiry section on the Home Info page.                 
 *  
 * </pre>
 */
public class HomeApplicantInfoDAOImpl extends BaseDAOImpl implements HomeApplicantInfoDAO {

  public HomeApplicantInfo findHomeApplicantInfoByIdResource(int idResource) {
    Query query = getSession().createQuery(" from HomeApplicantInfo h " +
                                           "where h.capsResource.idResource = :idResource");
    query.setInteger("idResource", idResource);

    return (HomeApplicantInfo) firstResult(query);
  }

  //STGAP00012476: Changed the signature of the insert method to include the new field dtApplied to the insert statement
  public int insertIntoHomeApplicantInfo(int idHomeApplicant, int idResource, Date dtInquiry, Date dtApplied,
                                         String cdInquiryRcvd, String cdInfoPacket, Date dtInfoSent,
                                         int inqReqNbrChldrn, String txtChildInt, String txtInqryComm) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO HOME_APPLICANT_INFO " +
                                                 "           (ID_HOME_APPLICANT, " +
                                                 "            ID_RESOURCE, " +
                                                 "            DT_INQUIRY, " +
                                                 "            DT_APPLIED, " +
                                                 "            CD_INQUIRY_RCVD, " +
                                                 "            CD_INFO_PACKET, " +
                                                 "            DT_INFO_SENT, " +
                                                 "            INQ_REQ_NBR_CHLDRN, " +
                                                 "            TXT_CHILD_INT, " +
                                                 "            TXT_INQRY_COMM) " +
                                                 "     VALUES(:idHomeApplicant, " +
                                                 "            :idResource, " +
                                                 "            :dtInquiry, " +
                                                 "            :dtApplied, " +
                                                 "            :cdInquiryRcvd, " +
                                                 "            :cdInfoPacket, " +
                                                 "            :dtInfoSent, " +
                                                 "            :inqReqNbrChldrn, " +
                                                 "            :txtChildInt, " +
                                                 "            :txtInqryComm)");

    query.setInteger("idHomeApplicant", idHomeApplicant);
    query.setInteger("idResource", idResource);
    query.setDate("dtInquiry", dtInquiry);
    query.setDate("dtApplied", dtApplied);
    query.setString("cdInquiryRcvd", cdInquiryRcvd);
    query.setString("cdInfoPacket", cdInfoPacket);
    query.setDate("dtInfoSent", dtInfoSent);
    query.setInteger("inqReqNbrChldrn", inqReqNbrChldrn);
    query.setString("txtChildInt", txtChildInt);
    query.setString("txtInqryComm", txtInqryComm);

    return query.executeUpdate();
  }

  public void saveHomeApplicantInfo(HomeApplicantInfo homeApplicantInfo) {
    getSession().saveOrUpdate(homeApplicantInfo);
  }

}
