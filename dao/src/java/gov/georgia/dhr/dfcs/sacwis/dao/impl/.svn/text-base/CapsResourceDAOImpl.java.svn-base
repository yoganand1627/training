package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserVendorLink;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

/** Change History:
  **  Date        User              Description
  **  --------    ----------------  -------------------------------------------------------------------
  **  03/27/2008  Corey Harden      STGAP00006457: changed HQL statement in                                          
  *                                 updateCapsResource(int nbrRsrcOpenSlots, int idResource) to set 
  *                                 openSlots column equal to nbrRsrcOpenSlots
  *                                 
  *   04/10/2008  Corey Harden      STGAP00005794: created method CapsResource findCapsResourceByIdResc()
  *   
  *   04/14/2008  Courtney Wells    STGAP00007365: added created method updateCapsResource(int idResource, String cdRsrcClosureRsn, String cdRsrcInvolClosure, 
  *                                  String cdRsrcRecmndReopen, String txtClosureComm, String nmLegal) to save home closure section
  *   01/02/2009  Abraham Williams  STGAP00010681: Added Resource Facility Type (cdRsrcFacilType) to the
  *                                 findCapsResourceByIdResource method (query).
  *   03/01/2011  Hai Nguyen        SMS#97850: MR-075 Added method findCapsResourceByIdResourceHhMemberPerson(int IdPerson).
  *   03/25/2011  Hai Nguyen        SMS#97850: MR-075 Updated methods to remove resource status updates and added new field for hold placements.
  *   03/31/2011  Hai Nguyen        SMS#103682 & 103683: MR-075 Updated findCapsResourceByIdResourceHhMemberPerson to also include the F/A parent(s).
  *   06/10/2011  hjbaptiste        SMS#109631: CAPTA 4.3: Special Investigation - Added updateCapsResourceIndHoldPlacements()
  *   06/09/2011  Corey Harden      SMS#109631 Added method findCapsResourceByIdStage(int idStage)
  *                           
  **/
  
public class CapsResourceDAOImpl extends BaseDAOImpl implements CapsResourceDAO {
    public CapsResource findCapsResourceByIdStage(int idStage) {
      Query query = getSession().createQuery(" from CapsResource c " +
                                             "where c.stage.idStage = :idStage");

      query.setInteger("idStage", idStage);
      return (CapsResource) firstResult(query);
    }
    
  @SuppressWarnings({"unchecked"})
  public List<Map> findCapsResourceByIdResource(int idResource) {
    Query query = getSession().createQuery("select new map(r1.idResource as parentIdResource, " +
                                           "               r1.nmResource as parentNmResource, " +
                                           "               r1.cdRsrcFacilType as parentCdRsrcFacilType, " +
                                           "               r2.idResource as childIdResource, " +
                                           "               r2.nmResource as childNmResource, " +
                                           "               r2.cdRsrcFacilType as childCdRsrcFacilType, " +
                                           "               r2.cdRsrcMaritalStatus as childCdRsrcMaritalStatus) " +
                                           "  from RsrcLink rl " +
                                           "  join rl.capsResourceByIdRsrcLinkParent r1 " +
                                           "  join rl.capsResourceByIdRsrcLinkChild r2 " +
                                           " where rl.capsResourceByIdRsrcLinkChild.idResource = :idResource");
    query.setInteger("idResource", idResource);
    return (List<Map>) query.list();
  }
  @SuppressWarnings({"unchecked"}) 
  public PaginatedHibernateList<Map> findPortalCapsResourceByIdAgency(int idRrscAgency, String cdSortBy, int pageNbr,int pageSize) {
	    Query query = getSession().createQuery("select new map(r1.nmResource as nmResource," +
	                                           "               r1.idResource as idResource," +
	                                           "               r1.cdRsrcStatus as childCdRsrcStatus," +
	                                           "               r1.cdRsrcFacilType as childCdRsrcFacilType, " +
	                                           "               r1.cdRsrcType as childCdRsrcType," +
	                                           "               r1.addrRsrcStLn1 as childaddrRsrcStLn1," +
	                                           "               r1.addrRsrcCity as childaddrRsrcCity," +
	                                           "               r1.cdRsrcCnty as childCdRsrcCnty," +
	                                           "               r1.nbrRsrcPhn as childNbrRsrcPhn," +
	                                           "               r1.nbrRsrcPhoneExt as childNbrRsrcPhoneExt) "+ 
	                                           "               from RsrcLink rl " +
	                                           "               join rl.capsResourceByIdRsrcLinkChild r1" +
	                                           "               join rl.capsResourceByIdRsrcLinkParent r2" +
	                                           "               where rl.capsResourceByIdRsrcLinkParent.idResource = :idRrscAgency" +
	                                           "               order by :cdSortBy desc");
	    query.setInteger("idRrscAgency", idRrscAgency);
	    query.setString("cdSortBy", cdSortBy);
	    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }
  
    @SuppressWarnings({"unchecked"}) 
  public PaginatedHibernateList<Map> findPortalCapsResourceByIdResource(List<Integer> idRrscFacilList, String cdSortBy,
		                                                                     int pageNbr,int pageSize) {
	    Query query = getSession().createQuery("select new map(c.idResource as idResource," +
	    		                           "               c.nmResource as nmResource," +
	                                           "               c.cdRsrcStatus as childCdRsrcStatus," +
	                                           "               c.cdRsrcFacilType as childCdRsrcFacilType," +
	                                           "               c.cdRsrcType as childCdRsrcType," +
	                                           "               c.addrRsrcStLn1 as childaddrRsrcStLn1," +
	                                           "               c.addrRsrcCity as childaddrRsrcCity," +
	                                           "               c.cdRsrcCnty as childCdRsrcCnty," +
	                                           "               c.nbrRsrcPhn as childNbrRsrcPhn," +
	                                           "               c.nbrRsrcPhoneExt as childNbrRsrcPhoneExt)" + 
	                                           "               from CapsResource c" +
	                                           "               where c.idResource IN (:idRrscFacilList)"  +
	                                           "               order by :cdSortBy desc");
	    query.setParameterList("idRrscFacilList", idRrscFacilList);
	    query.setString("cdSortBy", cdSortBy);
	    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
}	 
    public CapsResource findResourceByIdRsrcFaHomeStage(int idStage) {
    Query query = getSession().createQuery(" from CapsResource c " +
                                           " where c.stage.idStage = :idStage");

    // "where c.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (CapsResource) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<CapsResource> findCapsResourceAddressess(int idResource) {
    Query query = getSession().createQuery(" from CapsResource c " +
                                           " left join fetch c.resourceAddresses r " +
                                           " where c.idResource = :idResource " +
                                           " order by r.nbrRsrcAddrVid");

    query.setInteger("idResource", idResource);
    return (List<CapsResource>) query.list();
  }
  @SuppressWarnings({"unchecked"})
  public CapsResource findCapsResourceByIdResourceOnly(int idResource) {
    Query query = getSession().createQuery(" from CapsResource " +
                                           " where idResource = :idResource");

    query.setInteger("idResource", idResource);
    return (CapsResource) firstResult(query);
  }
  @SuppressWarnings({"unchecked"})
  public Map findCapsResourceIDandNameByIdEventIdStageandIdCase(int idEvent, int idStage, int idCase) {
    
    Query query = getSession().createQuery( "select new map( cr.idResource as  idResource, "  +
                                            " cr.nmResource as nmResource, " + 
                                            " cr.nmRsrcContact as nmRsrcContact) " + 
                                            "  from CapsResource cr join cr.event e" + 
                                            " where cr.stage.idStage = :idStage " +
                                            " and cr.capsCase.idCase = :idCase " +
                                            " and e.idEvent = :idEvent" );
    
    query.setInteger("idEvent", idEvent);
    query.setInteger("idStage", idStage);
    query.setInteger("idCase", idCase);
    return (Map) firstResult(query); 
  }

  @SuppressWarnings({"unchecked"})
  public Map findRsrcCertAndNonprsByIdResource(int idResource) {
    Query query = getSession().createQuery("select new map(c.dtRsrcCert as dtRsrcCert, " +
                                           "               c.indRsrcNonDfcs as indRsrcNonDfcs) " +
                                           "  from CapsResource c " +
                                           " where c.idResource = :idResource ");

    query.setInteger("idResource", idResource);
    return (Map) firstResult(query);
  }

  public Date findDtRsrcCertByIdRsrcFaHomeStage(int idStage) {
    Query query = getSession().createQuery("select cr.dtRsrcCert " +
                                           "  from CapsResource cr " +
                                           " where cr.stage.idStage = :idStage");

    query.setInteger("idStage", idStage);
    return (Date) firstResult(query);
  }

  public int updateCapsResourceByCdRsrcFaHomeStatus(String cdRsrcFaHomeStatus, String cdRsrcStatus, int idEvent,
                                                    String indRsrcWriteHist, Date dtApprvDet, int idStage,
                                                    String indHoldPlacements) {
    Query query = getSession().createQuery("update CapsResource cr " +
                                           "   set cr.cdRsrcFaHomeStatus = :cdRsrcFaHomeStatus, " +
                                           "       cr.cdRsrcStatus = :cdRsrcStatus, " +
                                           "       cr.event.idEvent = :idEvent, " +
                                           "       cr.indRsrcWriteHist = :indRsrcWriteHist, " +
                                           "       cr.dtRsrcCert = :dtApprvDet, " +
                                           "       cr.indHoldPlacements = :indHoldPlacements " +
                                           " where cr.stage.idStage = :idStage");
    query.setString("cdRsrcFaHomeStatus", cdRsrcFaHomeStatus);
    query.setString("cdRsrcStatus", cdRsrcStatus);
    query.setInteger("idEvent", idEvent);
    query.setString("indRsrcWriteHist", indRsrcWriteHist);
    query.setTimestamp("dtApprvDet", dtApprvDet);
    query.setInteger("idStage", idStage);
    query.setString("indHoldPlacements", indHoldPlacements);
    return query.executeUpdate();
  }

  public int updateCapsResourceByDtRsrcDate(String cdRsrcFaHomeStatus, String cdRsrcStatus, int idEvent,
                                            String indRsrcWriteHist, Date dtRsrcDate, int idStage,
                                            String indHoldPlacements) {
    Query query = getSession().createQuery("update CapsResource cr " +
                                           "   set cr.cdRsrcFaHomeStatus = :cdRsrcFaHomeStatus, " +
                                           "       cr.cdRsrcStatus = :cdRsrcStatus, " +
                                           "       cr.event.idEvent = :idEvent, " +
                                           "       cr.indRsrcWriteHist = :indRsrcWriteHist, " +
                                           "       cr.dtRsrcCert = :dtRsrcDate, " +
                                           "       cr.indHoldPlacements = :indHoldPlacements " +
                                           " where cr.stage.idStage = :idStage");
    query.setString("cdRsrcFaHomeStatus", cdRsrcFaHomeStatus);
    query.setString("cdRsrcStatus", cdRsrcStatus);
    query.setInteger("idEvent", idEvent);
    query.setString("indRsrcWriteHist", indRsrcWriteHist);
    query.setTimestamp("dtRsrcDate", dtRsrcDate);
    query.setInteger("idStage", idStage);
    query.setString("indHoldPlacements", indHoldPlacements);
    return query.executeUpdate();
  }

  public int updateCapsResourceByDtRsrcClose(String cdRsrcFaHomeStatus, String cdRsrcStatus, int idEvent,
                                             String indRsrcWriteHist, Date dtApprvDet, int idStage,
                                             String indHoldPlacements) {
    Query query = getSession().createQuery(" update CapsResource cr " +
                                           "    set cr.cdRsrcFaHomeStatus = :cdRsrcFaHomeStatus, " +
                                           "        cr.cdRsrcStatus = :cdRsrcStatus, " +
                                           "        cr.event.idEvent = :idEvent, " +
                                           "        cr.indRsrcWriteHist = :indRsrcWriteHist, " +
                                           "        cr.dtRsrcClose = :dtApprvDet, " +
                                           "        cr.indHoldPlacements = :indHoldPlacements " +
                                           "  where cr.stage.idStage = :idStage");

    query.setString("cdRsrcFaHomeStatus", cdRsrcFaHomeStatus);
    query.setString("cdRsrcStatus", cdRsrcStatus);
    query.setInteger("idEvent", idEvent);
    query.setString("indRsrcWriteHist", indRsrcWriteHist);
    query.setTimestamp("dtApprvDet", dtApprvDet);
    query.setInteger("idStage", idStage);
    query.setString("indHoldPlacements", indHoldPlacements);
    return query.executeUpdate();
  }

  public int updateCapsResourceSetNmResource(String nmResource, String nmRsrcLastUpdate, int idStage) {
    Query query = getSession().createQuery(" update CapsResource cr " +
                                           "    set cr.nmResource = :nmResource, " +
                                           "        cr.nmRsrcLastUpdate = :nmRsrcLastUpdate " +
                                           "  where cr.stage.idStage = :idStage");
    query.setString("nmResource", nmResource);
    query.setString("nmRsrcLastUpdate", nmRsrcLastUpdate);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateCapsResource(int idResource, String cdRsrcFaHomeStatus, String cdRsrcStatus, Date lastUpdate) {
    Query query = getSession().createQuery("update CapsResource cr " +
                                           "   set cr.cdRsrcFaHomeStatus = :cdRsrcFaHomeStatus, " +
                                           "       cr.cdRsrcStatus = :cdRsrcStatus " +
                                           " where cr.dtLastUpdate = :lastUpdate " +
                                           "   and cr.idResource = :idResource ");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcFaHomeStatus", cdRsrcFaHomeStatus);
    query.setString("cdRsrcStatus", cdRsrcStatus);
    query.setTimestamp("lastUpdate", lastUpdate);
    return query.executeUpdate();
  }

  public int updateCapsResource(int idResource, String addrRsrcStLn1, String addrRsrcStLn2, String addrRsrcCity,
                                String cdRsrcState, String addrRsrcZip, String addrRsrcAttn, String cdRsrcCnty,
                                String cdRsrcInvolClosure, String cdRsrcClosureRsn, String cdRsrcType,
                                String cdRsrcCampusType, String cdRsrcMaintainer, String cdRsrcSchDist,
                                String cdRsrcOwnership, String cdRsrcFacilType, String cdRsrcHub, String cdRsrcCertBy,
                                String cdRsrcOperBy, String cdRsrcSetting, String cdRsrcPayment, String cdRsrcCategory,
                                String cdRsrcEthnicity, String cdRsrcLanguage, String cdRsrcMaritalStatus,
                                String cdRsrcRecmndReopen, String cdRsrcRegion, String cdRsrcReligion,
                                String cdRsrcRespite, String cdRsrcFaHomeStatus, String cdRsrcFaHomeType1,
                                String cdRsrcFaHomeType2, String cdRsrcFaHomeType3, String cdRsrcFaHomeType4,
                                String cdRsrcFaHomeType5, String cdRsrcFaHomeType6,
                                Date dtRsrcMarriage, Date dtRsrcClose, Date dtRsrcCert, int idStage, int idEvent,
                                String indRsrcWriteHist, String indRsrcCareProv, String indRsrcEmergPlace,
                                String indRsrcInactive, String indRsrcTransport, String indCurrHmStdyExsts,
                                String indRsrcNonDfcs, String ndfcsCertEntity, String nmRsrcLastUpdate,
                                String nmResource, String nmRsrcContact, String nbrRsrcPhn, String nbrRsrcPhoneExt,
                                int nbrRsrcFacilCapacity, int nbrRsrcFacilAcclaim, String nbrRsrcVid,
                                int nbrRsrcCampusNbr, String indSpecificChild, int nbrRsrcIntFeAgeMax,
                                int nbrRsrcIntFeAgeMin, int nbrRsrcIntMaAgeMax, int nbrRsrcIntMaAgeMin,
                                int nbrRsrcAnnualIncome, int nbrRsrcFmAgeMax, int nbrRsrcFmAgeMin, int nbrRsrcMaAgeMax,
                                int nbrRsrcMaAgeMin, int nbrRsrcOpenSlots, String txtRsrcAddrCmnts,
                                String txtRsrcComments, Date lastUpdate, String indPrevFamStdyRqstd, String cdSchDist,
                                String cdElem, String cdMiddle, String cdHigh, String cdExchangeStat,
                                String indWaiver, String nmLegal, String txtHmPrgInterest) {
    Query query = getSession().createQuery("update CapsResource cr " +
                                           "   set cr.idResource = :idResource, " +
                                           "       cr.addrRsrcStLn1 = :addrRsrcStLn1, " +
                                           "       cr.addrRsrcStLn2 = :addrRsrcStLn2, " +
                                           "       cr.addrRsrcCity = :addrRsrcCity, " +
                                           "       cr.cdRsrcState = :cdRsrcState, " +
                                           "       cr.addrRsrcZip = :addrRsrcZip, " +
                                           "       cr.addrRsrcAttn = :addrRsrcAttn, " +
                                           "       cr.cdRsrcCnty = :cdRsrcCnty, " +
                                           "       cr.cdRsrcInvolClosure = :cdRsrcInvolClosure, " +
                                           "       cr.cdRsrcClosureRsn = :cdRsrcClosureRsn, " +
                                           "       cr.cdRsrcType = :cdRsrcType, " +
                                           "       cr.cdRsrcCampusType = :cdRsrcCampusType, " +
                                           "       cr.cdRsrcMaintainer = :cdRsrcMaintainer, " +
                                           "       cr.cdRsrcSchDist = :cdRsrcSchDist, " +
                                           "       cr.cdRsrcOwnership = :cdRsrcOwnership, " +
                                           "       cr.cdRsrcFacilType = :cdRsrcFacilType, " +
                                           "       cr.cdRsrcHub = :cdRsrcHub, " +
                                           "       cr.cdRsrcCertBy = :cdRsrcCertBy, " +
                                           "       cr.cdRsrcOperBy = :cdRsrcOperBy, " +
                                           "       cr.cdRsrcSetting = :cdRsrcSetting, " +
                                           "       cr.cdRsrcPayment = :cdRsrcPayment, " +
                                           "       cr.cdRsrcCategory = :cdRsrcCategory, " +
                                           "       cr.cdRsrcEthnicity = :cdRsrcEthnicity, " +
                                           "       cr.cdRsrcLanguage = :cdRsrcLanguage, " +
                                           "       cr.cdRsrcMaritalStatus = :cdRsrcMaritalStatus, " +
                                           "       cr.cdRsrcRecmndReopen = :cdRsrcRecmndReopen, " +
                                           "       cr.cdRsrcRegion = :cdRsrcRegion, " +
                                           "       cr.cdRsrcReligion = :cdRsrcReligion, " +
                                           "       cr.cdRsrcRespite = :cdRsrcRespite, " +
                                           "       cr.cdRsrcFaHomeStatus = :cdRsrcFaHomeStatus, " +
                                           "       cr.cdRsrcFaHomeType1 = :cdRsrcFaHomeType1, " +
                                           "       cr.cdRsrcFaHomeType2 = :cdRsrcFaHomeType2, " +
                                           "       cr.cdRsrcFaHomeType3 = :cdRsrcFaHomeType3, " +
                                           "       cr.cdRsrcFaHomeType4 = :cdRsrcFaHomeType4, " +
                                           "       cr.cdRsrcFaHomeType5 = :cdRsrcFaHomeType5, " +
                                           "       cr.cdRsrcFaHomeType6 = :cdRsrcFaHomeType6, " +
                                           "       cr.dtRsrcMarriage = :dtRsrcMarriage, " +
                                           "       cr.dtRsrcClose = :dtRsrcClose, " +
                                           "       cr.dtRsrcCert = :dtRsrcCert, " +
                                           "       cr.stage.idStage = :idStage, " +
                                           "       cr.event.idEvent = :idEvent, " +
                                           "       cr.indRsrcWriteHist = :indRsrcWriteHist, " +
                                           "       cr.indRsrcCareProv = :indRsrcCareProv, " +
                                           "       cr.indRsrcEmergPlace = :indRsrcEmergPlace, " +
                                           "       cr.indRsrcInactive = :indRsrcInactive, " +
                                           "       cr.indRsrcTransport = :indRsrcTransport, " +
                                           "       cr.indCurrHmStdyExsts = :indCurrHmStdyExsts, " +
                                           "       cr.indRsrcNonDfcs = :indRsrcNonDfcs, " +
                                           "       cr.ndfcsCertEntity = :ndfcsCertEntity, " +
                                           "       cr.nmRsrcLastUpdate = :nmRsrcLastUpdate, " +
                                           "       cr.nmResource = :nmResource, " +
                                           "       cr.nmRsrcContact = :nmRsrcContact, " +
                                           "       cr.nbrRsrcPhn = :nbrRsrcPhn, " +
                                           "       cr.nbrRsrcPhoneExt = :nbrRsrcPhoneExt, " +
                                           "       cr.nbrRsrcFacilCapacity = :nbrRsrcFacilCapacity, " +
                                           "       cr.nbrRsrcFacilAcclaim = :nbrRsrcFacilAcclaim, " +
                                           "       cr.nbrRsrcVid = :nbrRsrcVid, " +
                                           "       cr.nbrRsrcCampusNbr = :nbrRsrcCampusNbr, " +
                                           "       cr.indSpecificChild = :indSpecificChild, " +
                                           "       cr.nbrRsrcIntFeAgeMax = :nbrRsrcIntFeAgeMax, " +
                                           "       cr.nbrRsrcIntFeAgeMin = :nbrRsrcIntFeAgeMin, " +
                                           "       cr.nbrRsrcIntMaAgeMax = :nbrRsrcIntMaAgeMax, " +
                                           "       cr.nbrRsrcIntMaAgeMin = :nbrRsrcIntMaAgeMin, " +
                                           "       cr.nbrRsrcAnnualIncome = :nbrRsrcAnnualIncome, " +
                                           "       cr.nbrRsrcFmAgeMax = :nbrRsrcFmAgeMax, " +
                                           "       cr.nbrRsrcFmAgeMin = :nbrRsrcFmAgeMin, " +
                                           "       cr.nbrRsrcMaAgeMax = :nbrRsrcMaAgeMax, " +
                                           "       cr.nbrRsrcMaAgeMin = :nbrRsrcMaAgeMin, " +
                                           "       cr.nbrRsrcOpenSlots = :nbrRsrcOpenSlots, " +
                                           "       cr.txtRsrcAddrCmnts = :txtRsrcAddrCmnts, " +
                                           "       cr.txtRsrcComments = :txtRsrcComments, " +
                                           "       cr.indPrevFamStdyRqstd = :indPrevFamStdyRqstd, " +
                                           "       cr.cdSchDist = :cdSchDist, " +
                                           "       cr.cdElem = :cdElem, " +
                                           "       cr.cdMiddle = :cdMiddle, " +
                                           "       cr.cdHigh = :cdHigh, " +
                                           "       cr.cdExchangeStat = :cdExchangeStat, " +
                                           "       cr.indWaiver = :indWaiver, " +
                                           "       cr.nmLegal = :nmLegal, " +
                                           "       cr.txtHmPrgInterest = :txtHmPrgInterest " +
                                           " where cr.dtLastUpdate = :lastUpdate " +
                                           "   and cr.idResource = :idResource ");
    query.setInteger("idResource", idResource);
    query.setString("addrRsrcStLn1", addrRsrcStLn1);
    query.setString("addrRsrcStLn2", addrRsrcStLn2);
    query.setString("addrRsrcCity", addrRsrcCity);
    query.setString("cdRsrcState", cdRsrcState);
    query.setString("addrRsrcZip", addrRsrcZip);
    query.setString("addrRsrcAttn", addrRsrcAttn);
    query.setString("cdRsrcCnty", cdRsrcCnty);
    query.setString("cdRsrcInvolClosure", cdRsrcInvolClosure);
    query.setString("cdRsrcClosureRsn", cdRsrcClosureRsn);
    query.setString("cdRsrcType", cdRsrcType);
    query.setString("cdRsrcCampusType", cdRsrcCampusType);
    query.setString("cdRsrcMaintainer", cdRsrcMaintainer);
    query.setString("cdRsrcSchDist", cdRsrcSchDist);
    query.setString("cdRsrcOwnership", cdRsrcOwnership);
    query.setString("cdRsrcFacilType", cdRsrcFacilType);
    query.setString("cdRsrcHub", cdRsrcHub);
    query.setString("cdRsrcCertBy", cdRsrcCertBy);
    query.setString("cdRsrcOperBy", cdRsrcOperBy);
    query.setString("cdRsrcSetting", cdRsrcSetting);
    query.setString("cdRsrcPayment", cdRsrcPayment);
    query.setString("cdRsrcCategory", cdRsrcCategory);
    query.setString("cdRsrcEthnicity", cdRsrcEthnicity);
    query.setString("cdRsrcLanguage", cdRsrcLanguage);
    query.setString("cdRsrcMaritalStatus", cdRsrcMaritalStatus);
    query.setString("cdRsrcRecmndReopen", cdRsrcRecmndReopen);
    query.setString("cdRsrcRegion", cdRsrcRegion);
    query.setString("cdRsrcReligion", cdRsrcReligion);
    query.setString("cdRsrcRespite", cdRsrcRespite);
    query.setString("cdRsrcFaHomeStatus", cdRsrcFaHomeStatus);
    query.setString("cdRsrcFaHomeType1", cdRsrcFaHomeType1);
    query.setString("cdRsrcFaHomeType2", cdRsrcFaHomeType2);
    query.setString("cdRsrcFaHomeType3", cdRsrcFaHomeType3);
    query.setString("cdRsrcFaHomeType4", cdRsrcFaHomeType4);
    query.setString("cdRsrcFaHomeType5", cdRsrcFaHomeType5);
    query.setString("cdRsrcFaHomeType6", cdRsrcFaHomeType6);
    query.setTimestamp("dtRsrcMarriage", dtRsrcMarriage);
    query.setTimestamp("dtRsrcClose", dtRsrcClose);
    query.setTimestamp("dtRsrcCert", dtRsrcCert);
    query.setInteger("idStage", idStage);
    query.setInteger("idEvent", idEvent);
    query.setString("indRsrcWriteHist", indRsrcWriteHist);
    query.setString("indRsrcCareProv", indRsrcCareProv);
    query.setString("indRsrcEmergPlace", indRsrcEmergPlace);
    query.setString("indRsrcInactive", indRsrcInactive);
    query.setString("indRsrcTransport", indRsrcTransport);
    query.setString("indCurrHmStdyExsts", indCurrHmStdyExsts);
    query.setString("indRsrcNonDfcs", indRsrcNonDfcs);
    query.setString("ndfcsCertEntity", ndfcsCertEntity);
    query.setString("nmRsrcLastUpdate", nmRsrcLastUpdate);
    query.setString("nmResource", nmResource);
    query.setString("nmRsrcContact", nmRsrcContact);
    query.setString("nbrRsrcPhn", nbrRsrcPhn);
    query.setString("nbrRsrcPhoneExt", nbrRsrcPhoneExt);
    query.setInteger("nbrRsrcFacilCapacity", nbrRsrcFacilCapacity);
    query.setInteger("nbrRsrcFacilAcclaim", nbrRsrcFacilAcclaim);
    query.setString("nbrRsrcVid", nbrRsrcVid);
    query.setInteger("nbrRsrcCampusNbr", nbrRsrcCampusNbr);
    query.setString("indSpecificChild", indSpecificChild);
    query.setInteger("nbrRsrcIntFeAgeMax", nbrRsrcIntFeAgeMax);
    query.setInteger("nbrRsrcIntFeAgeMin", nbrRsrcIntFeAgeMin);
    query.setInteger("nbrRsrcIntMaAgeMax", nbrRsrcIntMaAgeMax);
    query.setInteger("nbrRsrcIntMaAgeMin", nbrRsrcIntMaAgeMin);
    query.setInteger("nbrRsrcAnnualIncome", nbrRsrcAnnualIncome);
    query.setInteger("nbrRsrcFmAgeMax", nbrRsrcFmAgeMax);
    query.setInteger("nbrRsrcFmAgeMin", nbrRsrcFmAgeMin);
    query.setInteger("nbrRsrcMaAgeMax", nbrRsrcMaAgeMax);
    query.setInteger("nbrRsrcMaAgeMin", nbrRsrcMaAgeMin);
    query.setInteger("nbrRsrcOpenSlots", nbrRsrcOpenSlots);
    query.setString("txtRsrcAddrCmnts", txtRsrcAddrCmnts);
    query.setString("txtRsrcComments", txtRsrcComments);
    query.setTimestamp("lastUpdate", lastUpdate);
    query.setString("indPrevFamStdyRqstd", indPrevFamStdyRqstd);
    query.setString("cdSchDist", cdSchDist);
    query.setString("cdElem", cdElem);
    query.setString("cdMiddle", cdMiddle);
    query.setString("cdHigh", cdHigh);
    query.setString("cdExchangeStat", cdExchangeStat);
    query.setString("indWaiver", indWaiver);
    query.setString("nmLegal", nmLegal);
    query.setString("txtHmPrgInterest", txtHmPrgInterest);
    return query.executeUpdate();
  }

  public int insertCapsResource(String addrRsrcStLn1, String addrRsrcStLn2, String addrRsrcCity, String cdRsrcState,
                                String addrRsrcZip, String addrRsrcAttn, String cdRsrcCnty, String cdRsrcInvolClosure,
                                String cdRsrcClosureRsn, String cdRsrcType, String cdRsrcCampusType,
                                String cdRsrcMaintainer, String cdRsrcSchDist, String cdRsrcOwnership,
                                String cdRsrcFacilType, String cdRsrcHub, String cdRsrcCertBy, String cdRsrcOperBy,
                                String cdRsrcPayment, String cdRsrcCategory, String cdRsrcEthnicity,
                                String cdRsrcLanguage, String cdRsrcMaritalStatus, String cdRsrcRecmndReopen,
                                String cdRsrcRegion, String cdRsrcReligion, String cdRsrcRespite,
                                String cdRsrcFaHomeStatus, String cdRsrcFaHomeType1, String cdRsrcFaHomeType2,
                                String cdRsrcFaHomeType3, String cdRsrcFaHomeType4, String cdRsrcFaHomeType5,
                                String cdRsrcFaHomeType6, Date dtRsrcMarriage, Date dtRsrcClose,
                                Date dtRsrcCert, int idStage, int idEvent, String indRsrcWriteHist,
                                String indRsrcCareProv, String indRsrcEmergPlace, String indRsrcInactive,
                                String indRsrcTransport, String indCurrHmStdyExsts, String indRsrcNonDfcs,
                                String ndfcsCertEntity, String nmRsrcLastUpdate, String nmResource,
                                String nmRsrcContact, String nbrRsrcPhn, String nbrRsrcPhoneExt,
                                int nbrRsrcFacilCapacity, int nbrRsrcFacilAcclaim, String nbrRsrcVid,
                                int nbrRsrcCampusNbr, String indSpecificChild, int nbrRsrcIntFeAgeMax,
                                int nbrRsrcIntFeAgeMin, int nbrRsrcIntMaAgeMax, int nbrRsrcIntMaAgeMin,
                                int nbrRsrcAnnualIncome, int nbrRsrcFMAgeMax, int nbrRsrcFMAgeMin, int nbrRsrcMlAgeMax,
                                int nbrRsrcMlAgeMin, int nbrRsrcOpenSlots, String txtRsrcAddrCmnts,
                                String txtRsrcComments, int idResource, String indPrevFamStdyRqstd, String cdSchDist,
                                String cdElem, String cdMiddle, String cdHigh, String cdExchangeStat,
                                String indWaiver, String nmLegal, String txtHmPrgInterest, String indHoldPlacements) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO CAPS_RESOURCE " +
                                                 "           (ID_RESOURCE, " +
                                                 "            ADDR_RSRC_ST_LN_1, " +
                                                 "            ADDR_RSRC_ST_LN_2, " +
                                                 "            ADDR_RSRC_CITY, " +
                                                 "            CD_RSRC_STATE, " +
                                                 "            ADDR_RSRC_ZIP, " +
                                                 "            ADDR_RSRC_ATTN, " +
                                                 "            CD_RSRC_CNTY, " +
                                                 "            CD_RSRC_INVOL_CLOSURE, " +
                                                 "            CD_RSRC_CLOSURE_RSN, " +
                                                 "            CD_RSRC_TYPE, " +
                                                 "            CD_RSRC_CAMPUS_TYPE, " +
                                                 "            CD_RSRC_MAINTAINER, " +
                                                 "            CD_RSRC_SCH_DIST, " +
                                                 "            CD_RSRC_OWNERSHIP, " +
                                                 "            CD_RSRC_FACIL_TYPE, " +
                                                 "            CD_RSRC_HUB, " +
                                                 "            CD_RSRC_CERT_BY, " +
                                                 "            CD_RSRC_OPER_BY, " +
                                                 "            CD_RSRC_PAYMENT, " +
                                                 "            CD_RSRC_CATEGORY, " +
                                                 "            CD_RSRC_ETHNICITY, " +
                                                 "            CD_RSRC_LANGUAGE, " +
                                                 "            CD_RSRC_MARITAL_STATUS, " +
                                                 "            CD_RSRC_RECMND_REOPEN, " +
                                                 "            CD_RSRC_REGION, " +
                                                 "            CD_RSRC_RELIGION, " +
                                                 "            CD_RSRC_RESPITE, " +
                                                 "            CD_RSRC_FA_HOME_STATUS, " +
                                                 "            CD_RSRC_FA_HOME_TYPE_1, " +
                                                 "            CD_RSRC_FA_HOME_TYPE_2, " +
                                                 "            CD_RSRC_FA_HOME_TYPE_3, " +
                                                 "            CD_RSRC_FA_HOME_TYPE_4, " +
                                                 "            CD_RSRC_FA_HOME_TYPE_5, " +
                                                 "            CD_RSRC_FA_HOME_TYPE_6, " +
                                                 "            DT_RSRC_MARRIAGE, " +
                                                 "            DT_RSRC_CLOSE, " +
                                                 "            DT_RSRC_CERT, " +
                                                 "            ID_RSRC_FA_HOME_STAGE, " +
                                                 "            ID_RSRC_FA_HOME_EVENT, " +
                                                 "            IND_RSRC_WRITE_HIST, " +
                                                 "            IND_RSRC_CARE_PROV, " +
                                                 "            IND_RSRC_EMERG_PLACE, " +
                                                 "            IND_RSRC_INACTIVE, " +
                                                 "            IND_RSRC_TRANSPORT, " +
                                                 "            IND_CURR_HM_STDY_EXSTS, " +
                                                 "            IND_RSRC_NONDFCS, " +
                                                 "            NDFCS_CERT_ENTITY, " +
                                                 "            NM_RSRC_LAST_UPDATE, " +
                                                 "            NM_RESOURCE, " +
                                                 "            NM_RSRC_CONTACT, " +
                                                 "            NBR_RSRC_PHN, " +
                                                 "            NBR_RSRC_PHONE_EXT, " +
                                                 "            NBR_RSRC_FACIL_CAPACITY, " +
                                                 "            NBR_RSRC_FACIL_ACCLAIM, " +
                                                 "            NBR_RSRC_VID, " +
                                                 "            NBR_RSRC_CAMPUS_NBR, " +
                                                 "            IND_SPECIFIC_CHILD, " +
                                                 "            NBR_RSRC_INT_FE_AGE_MAX, " +
                                                 "            NBR_RSRC_INT_FE_AGE_MIN, " +
                                                 "            NBR_RSRC_INT_MA_AGE_MAX, " +
                                                 "            NBR_RSRC_INT_MA_AGE_MIN, " +
                                                 "            NBR_RSRC_ANNUAL_INCOME, " +
                                                 "            NBR_RSRC_FM_AGE_MAX, " +
                                                 "            NBR_RSRC_FM_AGE_MIN, " +
                                                 "            NBR_RSRC_MA_AGE_MAX, " +
                                                 "            NBR_RSRC_MA_AGE_MIN, " +
                                                 "            NBR_RSRC_OPEN_SLOTS, " +
                                                 "            TXT_RSRC_ADDR_CMNTS, " +
                                                 "            TXT_RSRC_COMMENTS, " +
                                                 "            IND_PREV_FAM_STDY_RQSTD, " +
                                                 "            CD_SCH_DIST, " +
                                                 "            CD_ELEM, " +
                                                 "            CD_MIDDLE, " +
                                                 "            CD_HIGH, " +
                                                 "            CD_EXCHANGE_STAT, " +
                                                 "            NM_LEGAL, " +
                                                 "            IND_WAIVER, " +
                                                 "            TXT_HM_PRG_INTEREST," +
                                                 "            IND_HOLD_PLACEMENTS) " +
                                                 "     VALUES(:idResource, " +
                                                 "            :addrRsrcStLn1, " +
                                                 "            :addrRsrcStLn2, " +
                                                 "            :addrRsrcCity, " +
                                                 "            :cdRsrcState, " +
                                                 "            :addrRsrcZip, " +
                                                 "            :addrRsrcAttn, " +
                                                 "            :cdRsrcCnty, " +
                                                 "            :cdRsrcInvolClosure, " +
                                                 "            :cdRsrcClosureRsn, " +
                                                 "            :cdRsrcType, " +
                                                 "            :cdRsrcCampusType, " +
                                                 "            :cdRsrcMaintainer, " +
                                                 "            :cdRsrcSchDist, " +
                                                 "            :cdRsrcOwnership, " +
                                                 "            :cdRsrcFacilType, " +
                                                 "            :cdRsrcHub, " +
                                                 "            :cdRsrcCertBy, " +
                                                 "            :cdRsrcOperBy, " +
                                                 "            :cdRsrcPayment, " +
                                                 "            :cdRsrcCategory, " +
                                                 "            :cdRsrcEthnicity, " +
                                                 "            :cdRsrcLanguage, " +
                                                 "            :cdRsrcMaritalStatus, " +
                                                 "            :cdRsrcRecmndReopen, " +
                                                 "            :cdRsrcRegion, " +
                                                 "            :cdRsrcReligion, " +
                                                 "            :cdRsrcRespite, " +
                                                 "            :cdRsrcFaHomeStatus, " +
                                                 "            :cdRsrcFaHomeType1, " +
                                                 "            :cdRsrcFaHomeType2, " +
                                                 "            :cdRsrcFaHomeType3, " +
                                                 "            :cdRsrcFaHomeType4, " +
                                                 "            :cdRsrcFaHomeType5, " +
                                                 "            :cdRsrcFaHomeType6, " +
                                                 "            :dtRsrcMarriage, " +
                                                 "            :dtRsrcClose, " +
                                                 "            :dtRsrcCert, " +
                                                 "            :idStage, " +
                                                 "            :idEvent, " +
                                                 "            :indRsrcWriteHist, " +
                                                 "            :indRsrcCareProv, " +
                                                 "            :indRsrcEmergPlace, " +
                                                 "            :indRsrcInactive, " +
                                                 "            :indRsrcTransport, " +
                                                 "            :indCurrHmStdyExsts, " +
                                                 "            :indRsrcNonDfcs, " +
                                                 "            :ndfcsCertEntity, " +
                                                 "            :nmRsrcLastUpdate, " +
                                                 "            :nmResource, " +
                                                 "            :nmRsrcContact, " +
                                                 "            :nbrRsrcPhn, " +
                                                 "            :nbrRsrcPhoneExt, " +
                                                 "            :nbrRsrcFacilCapacity, " +
                                                 "            :nbrRsrcFacilAcclaim, " +
                                                 "            :nbrRsrcVid, " +
                                                 "            :nbrRsrcCampusNbr, " +
                                                 "            :indSpecificChild, " +
                                                 "            :nbrRsrcIntFeAgeMax, " +
                                                 "            :nbrRsrcIntFeAgeMin, " +
                                                 "            :nbrRsrcIntMaAgeMax, " +
                                                 "            :nbrRsrcIntMaAgeMin, " +
                                                 "            :nbrRsrcAnnualIncome, " +
                                                 "            :nbrRsrcFMAgeMax, " +
                                                 "            :nbrRsrcFMAgeMin, " +
                                                 "            :nbrRsrcMlAgeMax, " +
                                                 "            :nbrRsrcMlAgeMin, " +
                                                 "            :nbrRsrcOpenSlots, " +
                                                 "            :txtRsrcAddrCmnts, " +
                                                 "            :txtRsrcComments, " +
                                                 "            :indPrevFamStdyRqstd, " +
                                                 "            :cdSchDist, " +
                                                 "            :cdElem, " +
                                                 "            :cdMiddle, " +
                                                 "            :cdHigh, " +
                                                 "            :cdExchangeStat, " +
                                                 "            :nmLegal, " +
                                                 "            :indWaiver, " +
                                                 "            :txtHmPrgInterest," +
                                                 "            :indHoldPlacements) ");

    query.setString("addrRsrcStLn1", addrRsrcStLn1);
    query.setString("addrRsrcStLn2", addrRsrcStLn2);
    query.setString("addrRsrcCity", addrRsrcCity);
    query.setString("cdRsrcState", cdRsrcState);
    query.setString("addrRsrcZip", addrRsrcZip);
    query.setString("addrRsrcAttn", addrRsrcAttn);
    query.setString("cdRsrcCnty", cdRsrcCnty);
    query.setString("cdRsrcInvolClosure", cdRsrcInvolClosure);
    query.setString("cdRsrcClosureRsn", cdRsrcClosureRsn);
    query.setString("cdRsrcType", cdRsrcType);
    query.setString("cdRsrcCampusType", cdRsrcCampusType);
    query.setString("cdRsrcMaintainer", cdRsrcMaintainer);
    query.setString("cdRsrcSchDist", cdRsrcSchDist);
    query.setString("cdRsrcOwnership", cdRsrcOwnership);
    query.setString("cdRsrcFacilType", cdRsrcFacilType);
    query.setString("cdRsrcHub", cdRsrcHub);
    query.setString("cdRsrcCertBy", cdRsrcCertBy);
    query.setString("cdRsrcOperBy", cdRsrcOperBy);
    query.setString("cdRsrcPayment", cdRsrcPayment);
    query.setString("cdRsrcCategory", cdRsrcCategory);
    query.setString("cdRsrcEthnicity", cdRsrcEthnicity);
    query.setString("cdRsrcLanguage", cdRsrcLanguage);
    query.setString("cdRsrcMaritalStatus", cdRsrcMaritalStatus);
    query.setString("cdRsrcRecmndReopen", cdRsrcRecmndReopen);
    query.setString("cdRsrcRegion", cdRsrcRegion);
    query.setString("cdRsrcReligion", cdRsrcReligion);
    query.setString("cdRsrcRespite", cdRsrcRespite);
    query.setString("cdRsrcFaHomeStatus", cdRsrcFaHomeStatus);
    query.setString("cdRsrcFaHomeType1", cdRsrcFaHomeType1);
    query.setString("cdRsrcFaHomeType2", cdRsrcFaHomeType2);
    query.setString("cdRsrcFaHomeType3", cdRsrcFaHomeType3);
    query.setString("cdRsrcFaHomeType4", cdRsrcFaHomeType4);
    query.setString("cdRsrcFaHomeType5", cdRsrcFaHomeType5);
    query.setString("cdRsrcFaHomeType6", cdRsrcFaHomeType6);
    query.setTimestamp("dtRsrcMarriage", dtRsrcMarriage);
    query.setTimestamp("dtRsrcClose", dtRsrcClose);
    query.setTimestamp("dtRsrcCert", dtRsrcCert);
    query.setInteger("idStage", idStage);
    query.setInteger("idEvent", idEvent);
    query.setString("indRsrcWriteHist", indRsrcWriteHist);
    query.setString("indRsrcCareProv", indRsrcCareProv);
    query.setString("indRsrcEmergPlace", indRsrcEmergPlace);
    query.setString("indRsrcInactive", indRsrcInactive);
    query.setString("indRsrcTransport", indRsrcTransport);
    query.setString("indCurrHmStdyExsts", indCurrHmStdyExsts);
    query.setString("indRsrcNonDfcs", indRsrcNonDfcs);
    query.setString("ndfcsCertEntity", ndfcsCertEntity);
    query.setString("nmRsrcLastUpdate", nmRsrcLastUpdate);
    query.setString("nmResource", nmResource);
    query.setString("nmRsrcContact", nmRsrcContact);
    query.setString("nbrRsrcPhn", nbrRsrcPhn);
    query.setString("nbrRsrcPhoneExt", nbrRsrcPhoneExt);
    query.setInteger("nbrRsrcFacilCapacity", nbrRsrcFacilCapacity);
    query.setInteger("nbrRsrcFacilAcclaim", nbrRsrcFacilAcclaim);
    query.setString("nbrRsrcVid", nbrRsrcVid);
    query.setInteger("nbrRsrcCampusNbr", nbrRsrcCampusNbr);
    query.setString("indSpecificChild", indSpecificChild);
    query.setInteger("nbrRsrcIntFeAgeMax", nbrRsrcIntFeAgeMax);
    query.setInteger("nbrRsrcIntFeAgeMin", nbrRsrcIntFeAgeMin);
    query.setInteger("nbrRsrcIntMaAgeMax", nbrRsrcIntMaAgeMax);
    query.setInteger("nbrRsrcIntMaAgeMin", nbrRsrcIntMaAgeMin);
    query.setInteger("nbrRsrcAnnualIncome", nbrRsrcAnnualIncome);
    query.setInteger("nbrRsrcFMAgeMax", nbrRsrcFMAgeMax);
    query.setInteger("nbrRsrcFMAgeMin", nbrRsrcFMAgeMin);
    query.setInteger("nbrRsrcMlAgeMax", nbrRsrcMlAgeMax);
    query.setInteger("nbrRsrcMlAgeMin", nbrRsrcMlAgeMin);
    query.setInteger("nbrRsrcOpenSlots", nbrRsrcOpenSlots);
    query.setString("txtRsrcAddrCmnts", txtRsrcAddrCmnts);
    query.setString("txtRsrcComments", txtRsrcComments);
    query.setInteger("idResource", idResource);
    query.setString("indPrevFamStdyRqstd", indPrevFamStdyRqstd);
    query.setString("cdSchDist", cdSchDist);
    query.setString("cdElem", cdElem);
    query.setString("cdMiddle", cdMiddle);
    query.setString("cdHigh", cdHigh);
    query.setString("cdExchangeStat", cdExchangeStat);
    query.setString("nmLegal", nmLegal);
    query.setString("indWaiver", indWaiver);
    query.setString("txtHmPrgInterest", txtHmPrgInterest);
    query.setString("indHoldPlacements", indHoldPlacements);
    return query.executeUpdate();
  }

  public int updateCapsResource(String nmResource, String nmRsrcContact, String cdRsrcFacilType,
                                int nbrRsrcFacilAcclaim, String cdRsrcType, String cdRsrcCampusType,
                                int nbrSchCampusNbr, String cdMhmrCompCode, String cdRsrcCertBy, String cdRsrcOperBy,
                                String cdRsrcSetting, String cdRsrcPayment, int nbrRsrcFacilCapacity,
                                String cdRsrcMaintainer, String cdRsrcOwnership, String cdRsrcStatus,
                                String nmRsrcLastUpdate, String indRsrcTransport, String txtRsrcComments,
                                String cdRsrcHub, String nmLegal, int idResource, Date tsLastUpdate,
                                String nmRsrcContactTitle, String nbrRsrcNtnlProvider, String cdAddrRsrcEmail,
                                String cdAddrRsrcWebsite, String cdSchoolType, String cdPaymentDelivery,
                                String cdSchoolDistrict) {
    Query query = getSession().createQuery(" update CapsResource " +
                                           "    set nmResource = :nmResource, " +
                                           "        nmRsrcContact = :nmRsrcContact, " +
                                           "        cdRsrcFacilType = :cdRsrcFacilType, " +
                                           "        nbrRsrcFacilAcclaim = :nbrRsrcFacilAcclaim, " +
                                           "        cdRsrcType = :cdRsrcType, " +
                                           "        cdRsrcCampusType = :cdRsrcCampusType, " +
                                           "        nbrRsrcCampusNbr = :nbrSchCampusNbr, " +
                                           "        cdRsrcMhmrCompCode = :cdMhmrCompCode, " +
                                           "        cdRsrcCertBy = :cdRsrcCertBy, " +
                                           "        cdRsrcOperBy = :cdRsrcOperBy, " +
                                           "        cdRsrcSetting = :cdRsrcSetting, " +
                                           "        cdRsrcPayment = :cdRsrcPayment, " +
                                           "        nbrRsrcFacilCapacity = :nbrRsrcFacilCapacity, " +
                                           "        cdRsrcMaintainer = :cdRsrcMaintainer, " +
                                           "        cdRsrcOwnership = :cdRsrcOwnership, " +
                                           "        cdRsrcStatus = :cdRsrcStatus, " +
                                           "        nmRsrcLastUpdate = :nmRsrcLastUpdate, " +
                                           "        indRsrcTransport = :indRsrcTransport, " +
                                           "        txtRsrcComments = :txtRsrcComments, " +
                                           "        cdRsrcHub = :cdRsrcHub, " +
                                           "        nmLegal = :nmLegal, " +
                                           "        nmRsrcContactTitle = :nmRsrcContactTitle, " +
                                           "        nbrRsrcNtnlProvider = :nbrRsrcNtnlProvider, " +
                                           "        addrRsrcEmail = :cdAddrRsrcEmail, " +
                                           "        addrRsrcWebsite = :cdAddrRsrcWebsite, " +
                                           "        cdSchoolType = :cdSchoolType, " +
                                           "        cdPaymentDelivery = :cdPaymentDelivery, " +
                                           "        cdSchDist = :cdSchoolDistrict " +
                                           "  where idResource = :idResource " +
                                           "    and dtLastUpdate = :tsLastUpdate");

    query.setString("nmResource", nmResource);
    query.setString("nmRsrcContact", nmRsrcContact);
    query.setString("cdRsrcFacilType", cdRsrcFacilType);
    query.setInteger("nbrRsrcFacilAcclaim", nbrRsrcFacilAcclaim);
    query.setString("cdRsrcType", cdRsrcType);
    query.setString("cdRsrcCampusType", cdRsrcCampusType);
    query.setInteger("nbrSchCampusNbr", nbrSchCampusNbr);
    query.setString("cdMhmrCompCode", cdMhmrCompCode);
    query.setString("cdRsrcCertBy", cdRsrcCertBy);
    query.setString("cdRsrcOperBy", cdRsrcOperBy);
    query.setString("cdRsrcSetting", cdRsrcSetting);
    query.setString("cdRsrcPayment", cdRsrcPayment);
    query.setInteger("nbrRsrcFacilCapacity", nbrRsrcFacilCapacity);
    query.setString("cdRsrcMaintainer", cdRsrcMaintainer);
    query.setString("cdRsrcOwnership", cdRsrcOwnership);
    query.setString("cdRsrcStatus", cdRsrcStatus);
    query.setString("nmRsrcLastUpdate", nmRsrcLastUpdate);
    query.setString("indRsrcTransport", indRsrcTransport);
    query.setString("txtRsrcComments", txtRsrcComments);
    query.setString("cdRsrcHub", cdRsrcHub);
    query.setString("nmLegal", nmLegal);
    query.setInteger("idResource", idResource);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    query.setString("nmRsrcContactTitle", nmRsrcContactTitle);
    query.setString("nbrRsrcNtnlProvider", nbrRsrcNtnlProvider);
    query.setString("cdAddrRsrcEmail", cdAddrRsrcEmail);
    query.setString("cdAddrRsrcWebsite", cdAddrRsrcWebsite);
    query.setString("cdSchoolType", cdSchoolType);
    query.setString("cdPaymentDelivery", cdPaymentDelivery);
    query.setString("cdSchoolDistrict", cdSchoolDistrict);
    return (query.executeUpdate());
  }

  public int insertCapsResource(int idResources, String nmResource, String nmRsrcContact, String cdRsrcFacilType,
                                int nbrRsrcFacilAcclaim, String cdRsrcType, String cdRsrcCampusType,
                                int nbrSchCampusNbr, String cdMhmrCompCode, String cdRsrcCertBy, String cdRsrcOperBy,
                                String cdRsrcSetting, String cdRsrcPayment, int nbrRsrcFacilCapacity,
                                String cdRsrcMaintainer, String cdRsrcOwnership, String cdRsrcStatus,
                                String indRsrcTransport, String txtRsrcComments, String cdRsrcHub, String nmLegal,
                                String nmRsrcLastUpdate, String nmRsrcContactTitle, String nbrRsrcNtnlProvider,
                                String cdAddrRsrcEmail, String cdAddrRsrcWebsite, String cdSchoolType,
                                String cdPaymentDelivery, String cdSchoolDistrict)

  {
    SQLQuery query = getSession().createSQLQuery(
            " insert into CAPS_RESOURCE (ID_RESOURCE,NM_RESOURCE,NM_RSRC_CONTACT,CD_RSRC_FACIL_TYPE,NBR_RSRC_FACIL_ACCLAIM,CD_RSRC_TYPE,CD_RSRC_CAMPUS_TYPE,NBR_RSRC_CAMPUS_NBR,CD_RSRC_MHMR_COMP_CODE,CD_RSRC_CERT_BY,CD_RSRC_OPER_BY,CD_RSRC_SETTING,CD_RSRC_PAYMENT,NBR_RSRC_FACIL_CAPACITY,CD_RSRC_MAINTAINER,CD_RSRC_OWNERSHIP,CD_RSRC_STATUS,NM_RSRC_LAST_UPDATE,IND_RSRC_TRANSPORT,TXT_RSRC_COMMENTS,CD_RSRC_HUB,NM_LEGAL,NM_RSRC_CONTACT_TITLE, NBR_RSRC_NTNL_PROVIDER, ADDR_RSRC_EMAIL,ADDR_RSRC_WEBSITE,CD_SCHOOL_TYPE,CD_PAYMENT_DELIVERY,CD_SCH_DIST)" +
            "      values(:idResources, " +
            "             :nmResource, " +
            "             :nmRsrcContact, " +
            "             :cdRsrcFacilType, " +
            "             :nbrRsrcFacilAcclaim, " +
            "             :cdRsrcType, " +
            "             :cdRsrcCampusType, " +
            "             :nbrSchCampusNbr, " +
            "             :cdMhmrCompCode, " +
            "             :cdRsrcCertBy, " +
            "             :cdRsrcOperBy, " +
            "             :cdRsrcSetting, " +
            "             :cdRsrcPayment, " +
            "             :nbrRsrcFacilCapacity, " +
            "             :cdRsrcMaintainer, " +
            "             :cdRsrcOwnership, " +
            "             :cdRsrcStatus, " +
            "             :nmRsrcLastUpdate, " +
            "             :indRsrcTransport, " +
            "             :txtRsrcComments, " +
            "             :cdRsrcHub, " +
            "             :nmLegal," +
            "             :nmRsrcContactTitle, " +
            "             :nbrRsrcNtnlProvider, " +
            "             :cdAddrRsrcEmail, " +
            "             :cdAddrRsrcWebsite, " +
            "             :cdSchoolType, " +
            "             :cdPaymentDelivery, " +
            "             :cdSchoolDistrict)");

    query.setInteger("idResources", idResources);
    query.setString("nmResource", nmResource);
    query.setString("nmRsrcContact", nmRsrcContact);
    query.setString("cdRsrcFacilType", cdRsrcFacilType);
    query.setInteger("nbrRsrcFacilAcclaim", nbrRsrcFacilAcclaim);
    query.setString("cdRsrcType", cdRsrcType);
    query.setString("cdRsrcCampusType", cdRsrcCampusType);
    query.setInteger("nbrSchCampusNbr", nbrSchCampusNbr);
    query.setString("cdMhmrCompCode", cdMhmrCompCode);
    query.setString("cdRsrcCertBy", cdRsrcCertBy);
    query.setString("cdRsrcOperBy", cdRsrcOperBy);
    query.setString("cdRsrcSetting", cdRsrcSetting);
    query.setString("cdRsrcPayment", cdRsrcPayment);
    query.setInteger("nbrRsrcFacilCapacity", nbrRsrcFacilCapacity);
    query.setString("cdRsrcMaintainer", cdRsrcMaintainer);
    query.setString("cdRsrcOwnership", cdRsrcOwnership);
    query.setString("cdRsrcStatus", cdRsrcStatus);
    query.setString("nmRsrcLastUpdate", nmRsrcLastUpdate);
    query.setString("indRsrcTransport", indRsrcTransport);
    query.setString("txtRsrcComments", txtRsrcComments);
    query.setString("cdRsrcHub", cdRsrcHub);
    query.setString("nmLegal", nmLegal);
    query.setString("nmRsrcContactTitle", nmRsrcContactTitle);
    query.setString("nbrRsrcNtnlProvider", nbrRsrcNtnlProvider);
    query.setString("cdAddrRsrcEmail", cdAddrRsrcEmail);
    query.setString("cdAddrRsrcWebsite", cdAddrRsrcWebsite);
    query.setString("cdSchoolType", cdSchoolType);
    query.setString("cdPaymentDelivery", cdPaymentDelivery);
    query.setString("cdSchoolDistrict", cdSchoolDistrict);
    return query.executeUpdate();
  }

  public int updateCapsResource(String cdRsrcCertBy, String txtSpecCert, String cdRsrcOperBy, String cdRsrcSetting,
                                String cdRsrcPayment, Date dtRsrcCert, Date dtRsrcClose, int nbrRsrcFacilCapacity,
                                String indAfterHours, String nmRsrcLastUpdate, int idResource, Date tsLastUpdate) {
    Query query = getSession().createQuery(" update CapsResource " +
                                           "    set cdRsrcCertBy = :cdRsrcCertBy, " +
                                           "        txtSpecCert = :txtSpecCert, " +
                                           "        cdRsrcOperBy = :cdRsrcOperBy, " +
                                           "        cdRsrcSetting = :cdRsrcSetting, " +
                                           "        cdRsrcPayment = :cdRsrcPayment, " +
                                           "        dtRsrcCert = :dtRsrcCert, " +
                                           "        dtRsrcClose = :dtRsrcClose, " +
                                           "        nbrRsrcFacilCapacity = :nbrRsrcFacilCapacity, " +
                                           "        indAfterHours = :indAfterHours, " +
                                           "        nmRsrcLastUpdate = :nmRsrcLastUpdate " +
                                           "  where :idResource = idResource " +
                                           "    and :tsLastUpdate = dtLastUpdate");

    query.setString("cdRsrcCertBy", cdRsrcCertBy);
    query.setString("txtSpecCert", txtSpecCert);
    query.setString("cdRsrcOperBy", cdRsrcOperBy);
    query.setString("cdRsrcSetting", cdRsrcSetting);
    query.setString("cdRsrcPayment", cdRsrcPayment);
    query.setTimestamp("dtRsrcCert", dtRsrcCert);
    query.setTimestamp("dtRsrcClose", dtRsrcClose);
    query.setInteger("nbrRsrcFacilCapacity", nbrRsrcFacilCapacity);
    query.setString("indAfterHours", indAfterHours);
    query.setString("nmRsrcLastUpdate", nmRsrcLastUpdate);
    query.setInteger("idResource", idResource);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    return query.executeUpdate();
  }

  public int updateCapsResource(int nbrRsrcOpenSlots, int idResource) {
    Query query = getSession().createQuery("update CapsResource cr " +
                                           "   set cr.nbrRsrcOpenSlots = nvl(cr.nbrRsrcOpenSlots, 0) + :nbrRsrcOpenSlots " +
                                           " where cr.idResource = :idResource");
    query.setInteger("nbrRsrcOpenSlots", nbrRsrcOpenSlots);
    query.setInteger("idResource", idResource);
    return query.executeUpdate();
  }
  
  public int updateCapsResourceIndHoldPlacements(int idResource, String indHoldPlacements) {
    Query query = getSession().createQuery("update CapsResource cr " +
                                           "   set cr.indHoldPlacements = :indHoldPlacements " +
                                           " where cr.idResource = :idResource");
    query.setInteger("idResource", idResource);
    query.setString("indHoldPlacements", indHoldPlacements);
    return query.executeUpdate();
  }

  public int updateCapsResource(int idResource, String cdRsrcClosureRsn, String cdRsrcInvolClosure, 
                                String cdRsrcRecmndReopen, String txtClosureComm, String nmLegal) {
        Query query = getSession().createQuery("update CapsResource cr " +
                                           "   set cr.cdRsrcClosureRsn = :cdRsrcClosureRsn, " +
                                           "       cr.cdRsrcInvolClosure  = :cdRsrcInvolClosure, " +
                                           "       cr.cdRsrcRecmndReopen  = :cdRsrcRecmndReopen, " +
                                           "       cr.txtClosureComm  = :txtClosureComm, " +
                                           "       cr.nmLegal  = :nmLegal " +
                                           " where cr.idResource  = :idResource ");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcClosureRsn", cdRsrcClosureRsn);
    query.setString("cdRsrcInvolClosure", cdRsrcInvolClosure);
    query.setString("cdRsrcRecmndReopen", cdRsrcRecmndReopen);
    query.setString("txtClosureComm", txtClosureComm);
    query.setString("nmLegal", nmLegal);
    return query.executeUpdate();
    
  }
  
  public int updateCapsResource(int idResource, String cdRsrcFaHomeStatus, String cdRsrcClosureRsn,
                                String cdRsrcInvolClosure, String cdRsrcRecmndReopen, String szTxtStatusRsnComments,
                                int idEvent, String indRsrcWriteHist, Date dtRsrcCert,
                                Date dtRsrcClose, Date lastUpdate, String indHoldPlacements) {
    Query query = getSession().createQuery("update CapsResource cr " +
                                           "   set cr.idResource = :idResource, " +
                                           "       cr.cdRsrcFaHomeStatus  = :cdRsrcFaHomeStatus, " +
                                           "       cr.cdRsrcClosureRsn = :cdRsrcClosureRsn, " +
                                           "       cr.cdRsrcInvolClosure  = :cdRsrcInvolClosure, " +
                                           "       cr.cdRsrcRecmndReopen  = :cdRsrcRecmndReopen, " +
                                           "       cr.txtClosureComm  = :txtClosureComm, " +
                                           "       cr.event.idEvent = :idEvent, " +
                                           "       cr.indRsrcWriteHist = :indRsrcWriteHist, " +
                                           "       cr.dtRsrcCert = :dtRsrcCert, " +
                                           "       cr.dtRsrcClose = :dtRsrcClose, " +
                                           "       cr.indHoldPlacements = :indHoldPlacements " +
                                           " where cr.idResource  = :idResource " +
                                           "   and cr.dtLastUpdate = :lastUpdate ");

    query.setInteger("idResource", idResource);
    query.setString("cdRsrcFaHomeStatus", cdRsrcFaHomeStatus);
    query.setString("cdRsrcClosureRsn", cdRsrcClosureRsn);
    query.setString("cdRsrcInvolClosure", cdRsrcInvolClosure);
    query.setString("cdRsrcRecmndReopen", cdRsrcRecmndReopen);
    query.setString("txtClosureComm", szTxtStatusRsnComments);
    query.setInteger("idEvent", idEvent);
    query.setString("indRsrcWriteHist", indRsrcWriteHist);
    query.setTimestamp("dtRsrcCert", dtRsrcCert);
    query.setTimestamp("dtRsrcClose", dtRsrcClose);
    query.setTimestamp("lastUpdate", lastUpdate);
    query.setString("indHoldPlacements", indHoldPlacements);
    return query.executeUpdate();
  }

  public int updateCapsResource(String cdRsrcMaritalStatus, int idResource) {
    Query query = getSession().createQuery("update CapsResource cr " +
                                           "   set cr.cdRsrcMaritalStatus = :cdRsrcMaritalStatus " +
                                           " where cr.idResource = :idResource ");

    query.setInteger("idResource", idResource);
    query.setString("cdRsrcMaritalStatus", cdRsrcMaritalStatus);
    return query.executeUpdate();
  }
  
  public int updateResourceByIndContractedDtLastUpdate(String indRsrcContracted, Date dtLastUpdate, int idResource) {
    Query query = getSession().createQuery(" update CapsResource cr " +
                                           "    set cr.indRsrcContracted = :indRsrcContracted " +
                                           "  where cr.idResource = :idResource " +
                                           "  and cr.dtLastUpdate = :dtLastUpdate ");
    query.setInteger("idResource", idResource);
    query.setString("indRsrcContracted", indRsrcContracted);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public void saveOrUpdateCapsResource(CapsResource capsResource) {
    getSession().saveOrUpdate(capsResource);
  }

  public void deleteCapsResource(CapsResource capsResource) {
    getSession().delete(capsResource);
  }

  public CapsResource findCapsResourceByIdResc(int idResource) {
    Query query = getSession().createQuery(" from CapsResource c " +
                                           "where c.idResource = :idResource");

    query.setInteger("idResource", idResource);
    return (CapsResource) firstResult(query);
  }
  
  public String findNmByIdResourceOnly(int idAgencyResource) {
    Query query = getSession().createQuery("select cr.nmResource " +
                                           "  from CapsResource cr " +
                                           " where cr.idResource = :idResource");

    query.setInteger("idResource", idAgencyResource);
    return (String) firstResult(query);
  }
  public CapsResource findCapsResourceByIdCase(int idCase){
    Query query = getSession().createQuery(" from CapsResource c " +
                                           " where c.capsCase.idCase = :idCase");

    query.setInteger("idCase", idCase);
    return (CapsResource) firstResult(query);    
  }
  
  public Integer findIdFadStageByIdResource(int idResource){
    Query query = getSession().createQuery("select cr.stage.idStage " +
                                           "  from CapsResource cr " +
                                           " where cr.idResource = :idResource");

    query.setInteger("idResource", idResource);
    return (Integer) firstResult(query);
  }
  
  public Integer findIdResourceByNmResource(String strNameResource) {
    Query query = getSession().createQuery("select cr.idResource " +
                                           "  from CapsResource cr " +
                                           " where cr.nmResource = :strNameResource");

    query.setString("strNameResource", strNameResource);
    return (Integer) firstResult(query);
  }
  
  /**
   * SMS#97850: MR-075
   * Retrieve CapsResource where idPerson is one of the resource household members
   * or Foster/Adoptive parent(s)in the open FAD stage sorted by dt_lic_end month then day.
   * @param idPerson
   * @return CapsResource
   */
  public CapsResource findCapsResourceByIdResourceHhMemberPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           " select r "
                                                           + " from CapsResource r,"
                                                           + "      StagePersonLink spl "
                                                           + " where spl.person.idPerson = :idPerson "
                                                           + " and (spl.person.personDtl.indPersonRsrcHshdMember = 'Y' "
                                                           + "             or spl.cdStagePersRelInt in ('FA', 'PT', 'FP', 'AF'))"
                                                           + " and spl.stage.cdStage = 'FAD' "
                                                           + " and spl.stage.dtStageClose is null "
                                                           + " and spl.stage.idStage = r.stage.idStage "
                                                           + " and r.dtLicEnd is not null "
                                                           + " order by TO_CHAR(r.dtLicEnd, 'MM'), TO_CHAR(r.dtLicEnd, 'DD') ");

    query.setInteger("idPerson", idPerson);
    return (CapsResource) firstResult(query);
  }

}
