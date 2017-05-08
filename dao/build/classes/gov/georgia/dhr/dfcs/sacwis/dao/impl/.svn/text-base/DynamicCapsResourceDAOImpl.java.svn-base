/**
 * Created on May 23, 2006 at 11:25:05 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicCapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.ContractCountyView;
import gov.georgia.dhr.dfcs.sacwis.db.FacilityLoc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.type.Type;

public class DynamicCapsResourceDAOImpl extends DynamicBaseDAOImpl implements DynamicCapsResourceDAO {
  private static final String TYPE_LAW_ENFORCE = CodesTables.CRSCTYPE_02;
  private static final String TYPE_MHMR_FACILITY = CodesTables.CRSCTYPE_05;
  private static final String TYPE_OTHER_FACILITY = CodesTables.CRSCTYPE_06;
  private static final String FLOC_01 = CodesTables.CPLCMTIN_010;
  private static final String FLOC_02 = CodesTables.CPLCMTIN_020;
  private static final String FLOC_03 = CodesTables.CPLCMTIN_030;
  private static final String FLOC_04 = CodesTables.CPLCMTIN_040;
  private static final String FLOC_05 = CodesTables.CPLCMTIN_050;
  private static final String FLOC_06 = CodesTables.CPLCMTIN_060;
  private static final String FLOC_S6 = CodesTables.CPLCMTIN_070;
  private static final String FLOC_E1 = CodesTables.CPLCMTIN_080;
  private static final String FLOC_E2 = CodesTables.CPLCMTIN_090;
  private static final String FLOC_E3 = CodesTables.CPLCMTIN_100;
  private static final String FLOC_3N = CodesTables.CPLCMTIN_110;
  private static final String FLOC_3T = CodesTables.CPLCMTIN_120;
  private static final String SVC_CONTRACT_CONTRACTED = CodesTables.CCNTSTAT_1;
  private static final String SVC_CONTRACT_NON_CONTRACTED = CodesTables.CCNTSTAT_2;
  private static final String SVC_CONTRACT_EITHER = CodesTables.CCNTSTAT_3;
  private static final String SEX_FEMALE = CodesTables.CRSRCSEX_F;
  private static final String SEX_MALE = CodesTables.CRSRCSEX_M;
  private static final String SEX_BOTH = CodesTables.CRSRCSEX_B;
  private static final int MONTHS = 12;

  @SuppressWarnings({"unchecked"})
  public List<Map> findResources(String cdRsrcType, String cdRsrcSvcProgram, String nmResource, String nmRsrcNmInd,
                                 int idResource, String cdRsrcSvcCategRsrc, String cdRsrcFacilType,
                                 String cdRsrcSvcState, String cdRsrcSvcRegion, String nmCity, String cdRsrcSvcCnty,
                                 String addrRsrcAddrZip, String indRsrcTransport, String indRsrcInactive,
                                 int scrYrRsrcCharMin, String cdRsrcCharSex, int nbrRsrcFacilAcclaim,
                                 String scrCdRsrcSort, String cdRsrcCharChrctr, String cdFloc, String cdRsrcSvcService,
                                 String scrCdRsrcSvcContract, String scrIndRsrcLocation, Date dtSvcAuthEff,
                                 String cdMhmrCompCode) {
    // NOTE: The logic in the DAO can and probably should be simplified, but time prevents it from being done now.
    
    /*-- appears no args are required
    if(allNullArgs(Arrays.asList(idResource, nbrRsrcFacilAcclaim, indRsrcInactive))) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    //*/

    // Calculate the number of months in the database.
    int scrMnRsrcCharMin = scrYrRsrcCharMin * MONTHS;

    // Precompute useful validity values
    boolean validCdRsrcSvcCnty = StringHelper.isValid(cdRsrcSvcCnty);
    boolean validCdRsrcSvcContract = StringHelper.isValid(scrCdRsrcSvcContract);
    boolean joinToContractCountyView = validCdRsrcSvcCnty && validCdRsrcSvcContract;

    Criteria criteria = getSession().createCriteria(CapsResource.class, "cr");
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("cr.nmResource"), "nmResource");
    projectionList.add(Projections.property("cr.addrRsrcStLn1"), "addrRsrcStLn1");
    projectionList.add(Projections.property("cr.addrRsrcStLn2"), "addrRsrcStLn2");
    projectionList.add(Projections.property("cr.addrRsrcCity"), "addrRsrcCity");
    projectionList.add(Projections.property("cr.nbrRsrcPhn"), "nbrRsrcPhn");
    projectionList.add(Projections.property("cr.cdRsrcType"), "cdRsrcType");
    boolean validIdResource = idResource != 0;
    if (TYPE_MHMR_FACILITY.equals(cdRsrcType) || TYPE_OTHER_FACILITY.equals(cdRsrcType) || validIdResource) {
      projectionList.add(Projections.property("cr.cdRsrcFacilType"), "cdRsrcFacilType");
    }
    projectionList.add(Projections.property("cr.cdRsrcCnty"));
    if (TYPE_MHMR_FACILITY.equals(cdRsrcType) || TYPE_OTHER_FACILITY.equals(cdRsrcType) || validIdResource) {
      projectionList.add(Projections.property("cr.cdRsrcMhmrCompCode"), "cdRsrcMhmrCompCode");
    }
    if (TYPE_OTHER_FACILITY.equals(cdRsrcType) || validIdResource) {
      projectionList.add(Projections.property("cr.nbrRsrcFacilAcclaim"), "nbrRsrcFacilAcclaim");
    }
    projectionList.add(Projections.property("cr.idResource"), "idResource");
    projectionList.add(Projections.property("cr.nmRsrcContact"), "nmRsrcContact");
    projectionList.add(Projections.property("cr.cdRsrcSchDist"), "cdRsrcSchDist");
    projectionList.add(Projections.property("cr.cdRsrcStatus"), "cdRsrcStatus");
    projectionList.add(Projections.property("cr.cdRsrcMaintainer"), "cdRsrcMaintainer");
    projectionList.add(Projections.property("cr.addrRsrcZip"), "addrRsrcZip");
    projectionList.add(Projections.property("cr.nbrRsrcPhoneExt"), "nbrRsrcPhoneExt");
    projectionList.add(Projections.property("cr.cdRsrcState"), "cdRsrcState");
    projectionList.add(Projections.property("cr.addrRsrcAttn"), "addrRsrcAttn");
    projectionList.add(Projections.property("cr.cdRsrcOperBy"), "cdRsrcOperBy");
    criteria.setProjection(Projections.distinct(projectionList));
    // Put the results into a map
    criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    // Uses only one of the unique keys, idResource and nbrrsrcFacilAcclaim, if specified.
    if (validIdResource) {
      criteria.add(Restrictions.eq("cr.idResource", idResource));
    } else if (nbrRsrcFacilAcclaim != 0) {
      criteria.add(Restrictions.eq("cr.nbrRsrcFacilAcclaim", nbrRsrcFacilAcclaim));
    } else {
      // Precompute useful validity variables:
      boolean nullDtSvcAuthEff = DateHelper.isNull(dtSvcAuthEff);
      boolean validCdRsrcSvcCategRsrc = StringHelper.isValid(cdRsrcSvcCategRsrc);
      boolean validCdRsrcSvcService = StringHelper.isValid(cdRsrcSvcService);
      boolean validCdRsrcSvcProgram = StringHelper.isValid(cdRsrcSvcProgram);
      boolean validCdRsrcSvcState = StringHelper.isValid(cdRsrcSvcState);
      boolean validCdRsrcSvcRegion = StringHelper.isValid(cdRsrcSvcRegion);
      boolean validAddrRsrcAddrZip = StringHelper.isValid(addrRsrcAddrZip);
      boolean validCdRsrcCharSex = StringHelper.isValid(cdRsrcCharSex);
      boolean validCdRsrcCharChrctr = StringHelper.isValid(cdRsrcCharChrctr);
      boolean validScrYrRsrcCharMinMonths = scrMnRsrcCharMin != 0;
      boolean contractedScrCdRsrcSvcContract = SVC_CONTRACT_CONTRACTED.equals(scrCdRsrcSvcContract);
      boolean nonContractedSrcCdRsrcSvcContract = SVC_CONTRACT_NON_CONTRACTED.equals(scrCdRsrcSvcContract);
      boolean eitherCdRsrcSvcContract = SVC_CONTRACT_EITHER.equals(scrCdRsrcSvcContract);

      // This criteria object is used for a sql-restriction below.
      // Since the user has not entered a unique key we must search on all the entered criteria.
      // Use Contract County instead of Contract_County_View for Service Auth Searches.
      Criteria ccCriteria = null;
      if (!nullDtSvcAuthEff && joinToContractCountyView) {
        ccCriteria = criteria.createAlias("cr.contractCounties", "cc",
                                          contractedScrCdRsrcSvcContract ? Criteria.INNER_JOIN : Criteria.LEFT_JOIN);
      } else if (joinToContractCountyView) {
        ccCriteria = criteria.createAlias("cr.contractCountyViews", "cc",
                                          contractedScrCdRsrcSvcContract ? Criteria.INNER_JOIN : Criteria.LEFT_JOIN);
      }
      Criteria rcCriteria = null;
      if (validScrYrRsrcCharMinMonths || validCdRsrcCharSex || validCdRsrcCharChrctr) {
        rcCriteria = criteria.createCriteria("cr.resourceChrctrs", "rc", Criteria.INNER_JOIN);
      } else if (validCdRsrcSvcCategRsrc || validCdRsrcSvcService || validCdRsrcSvcProgram ||
                 (ArchitectureConstants.N.equals(cdRsrcSvcProgram) &&
                  (validCdRsrcSvcState || validCdRsrcSvcRegion || validCdRsrcSvcCnty || validAddrRsrcAddrZip))) {
        if (nullDtSvcAuthEff && (validCdRsrcSvcCategRsrc || validCdRsrcSvcService || validCdRsrcSvcProgram ||
                                 validCdRsrcSvcState || validCdRsrcSvcRegion || validCdRsrcSvcCnty)) {
          criteria.createAlias("cr.resourceServices", "rs", Criteria.INNER_JOIN);
        }
      }
      if (TYPE_MHMR_FACILITY.equals(cdRsrcType)) {
        criteria.createAlias("cr.facilityLocs", "fl", Criteria.INNER_JOIN);
      }
      if (TYPE_LAW_ENFORCE.equals(cdRsrcType) && ArchitectureConstants.N.equals(scrIndRsrcLocation) &&
          !validAddrRsrcAddrZip) {
        criteria.createAlias("cr.lawEnforcZips", "lez", Criteria.INNER_JOIN);
      }
      if (StringHelper.isValid(cdMhmrCompCode)) {
        criteria.add(Restrictions.eq("cr.cdRsrcMhmrCompCode", cdMhmrCompCode));
      }
      if (StringHelper.isValid(cdRsrcType)) {
        criteria.add(Restrictions.eq("cr.cdRsrcType", cdRsrcType));
      }
      if (StringHelper.isValid(nmResource)) {
        // Only use the nmResource if we have 3 or more characters
        if (nmResource.length() > 2) {
          // Append a % sign to do the like comparison.
          criteria.add(Restrictions.like("cr.nmResource", nmResource + "%"));
        }
        // In the C, the 3rd character of the string [2] was set to NULL; should we chop this to 2 characters???
        criteria.add(Restrictions.eq("cr.nmRsrcNameIndex", nmRsrcNmInd));
      }
      if (ArchitectureConstants.Y.equals(indRsrcTransport)) {
        criteria.add(Restrictions.eq("cr.indRsrcTransport", indRsrcTransport));
      }
      if (ArchitectureConstants.Y.equals(indRsrcInactive)) {
        criteria.add(Restrictions.eq("cr.indRsrcInactive", CodesTables.CRSCSTAT_02));
      } else {
        criteria.add(Restrictions.eq("cr.indRsrcInactive", CodesTables.CRSCSTAT_01));
      }
      // If any of the characteristic data is entered skip all references to RESOURCE_SERVICE
      //   since RESOURCE_CHRCTR is denormalized.
      // Only use resource service if not coming from service auth.
      if (!validScrYrRsrcCharMinMonths && !validCdRsrcCharSex && !validCdRsrcCharChrctr && nullDtSvcAuthEff) {
        if (validCdRsrcSvcCategRsrc) {
          criteria.add(Restrictions.eq("cr.cdRsrcSvcCategRsrc", cdRsrcSvcCategRsrc));
        }
        if (validCdRsrcSvcService) {
          criteria.add(Restrictions.eq("cr.cdRsrcSvcService", cdRsrcSvcService));
        }
        if (validCdRsrcSvcProgram) {
          criteria.add(Restrictions.eq("cr.cdRsrcSvcProgram", cdRsrcSvcProgram));
        }
      }
      if (contractedScrCdRsrcSvcContract) {
        if (joinToContractCountyView) {
          criteria.add(Restrictions.eq("cc.cdCncntyService", cdRsrcSvcService));
          criteria.add(Restrictions.eq("cc.cdCnctyCounty", cdRsrcSvcCnty));
          if (!nullDtSvcAuthEff) {
            criteria.add(Restrictions.le("cc.dtCnctyEffective", dtSvcAuthEff));
            criteria.add(Restrictions.ge("cc.dtCnctyEnd", dtSvcAuthEff));
          } else {
            // Note that we must use the CC criteria as {alias} points to the root of the criteria.
            String betweenSql = "TRUNC(SYSDATE) BETWEEN {alias}.DT_CNCTY_EFFECTIVE AND {alias}.DT_CNCTY_END";
            ccCriteria.add(Restrictions.sqlRestriction(betweenSql));
          }
        }
      } else if (nonContractedSrcCdRsrcSvcContract) {
        DetachedCriteria ccvCriteria = DetachedCriteria.forClass(ContractCountyView.class, "cc2");
        ccvCriteria.setProjection(Projections.sqlProjection("1", new String[0], new Type[0]));
        ccvCriteria.add(Restrictions.eqProperty("cc2.capsResource", "cr.idResource"));
        ccvCriteria.add(Restrictions.eq("cc2.cdCncntyService", cdRsrcSvcService));
        ccvCriteria.add(Restrictions.eq("cc2.cdCncntyCounty", cdRsrcSvcCnty));
        String betweenSql =
                "TRUNC(SYSDATE) BETWEEN NVL({alias}.DT_CNCTY_EFFECTIVE, '12/31/1000') AND {alias}.DT_CNCTY_END";
        ccvCriteria.add(Restrictions.sqlRestriction(betweenSql));
        criteria.add(Subqueries.notExists(ccvCriteria));
      } else if (!validCdRsrcSvcContract || eitherCdRsrcSvcContract) {
        if (joinToContractCountyView) {
          criteria.add(Restrictions.or(Restrictions.eq("cc.cdCncntyService", cdRsrcSvcService),
                                       Restrictions.isNull("cc.cdCncntyService")));
          criteria.add(Restrictions.or(Restrictions.eq("cc.cdCncntyCounty", cdRsrcSvcCnty),
                                       Restrictions.isNull("cc.cdCncntyCounty")));
        }
      }
      if (ArchitectureConstants.N.equals(scrIndRsrcLocation) && !validScrYrRsrcCharMinMonths &&
          !validCdRsrcCharSex && !validCdRsrcCharChrctr) {
        if (validCdRsrcSvcState) {
          criteria.add(Restrictions.eq("rs.cdRsrcSvcState", cdRsrcSvcState));
        }
        if (validCdRsrcSvcState) {
          criteria.add(Restrictions.eq("rs.cdRsrcSvcRegion", cdRsrcSvcRegion));
        }
        if (validCdRsrcSvcState) {
          criteria.add(Restrictions.eq("rs.cdRsrcSvcCnty", cdRsrcSvcCnty));
        }
        if (TYPE_LAW_ENFORCE.equals(cdRsrcType) && validAddrRsrcAddrZip) {
          criteria.add(Restrictions.eq("lez.nbrLawEnforcZip", addrRsrcAddrZip));
        }
      }
      if (ArchitectureConstants.Y.equals(scrIndRsrcLocation)) {
        if (validCdRsrcSvcState) {
          criteria.add(Restrictions.eq("cr.cdRsrcState", cdRsrcSvcState));
        }
        if (validCdRsrcSvcRegion) {
          criteria.add(Restrictions.eq("cr.cdRsrcRegion", cdRsrcSvcRegion));
        }
        if (StringHelper.isValid(nmCity)) {
          criteria.add(Restrictions.sqlRestriction("UPPER({alias}.ADDR_RSRC_CITY) LIKE ?", nmCity, Hibernate.STRING));
        }
        if (validCdRsrcSvcCnty) {
          criteria.add(Restrictions.eq("cr.cdRsrcCnty", cdRsrcSvcCnty));
        }
        if (StringHelper.isValid(cdRsrcType) && validAddrRsrcAddrZip) {
          // See if we have more than 5 digits in the zip; if not use like.
          if (addrRsrcAddrZip.length() > 5) {
            criteria.add(Restrictions.eq("cr.addrRsrcZip", addrRsrcAddrZip));
          } else {
            criteria.add(Restrictions.like("cr.addrRsrcZip", addrRsrcAddrZip + "%"));
          }
        }
      }
      if (validScrYrRsrcCharMinMonths) {
        if (!validCdRsrcCharSex || SEX_MALE.equals(cdRsrcCharSex) || SEX_BOTH.equals(cdRsrcCharSex)) {
          String betweenSql = "? BETWEEN {alias}.NBR_RSRC_CHAR_MIN_M_AGE AND {alias}.NBR_RSRC_CHAR_MAX_M_AGE";
          rcCriteria.add(Restrictions.sqlRestriction(betweenSql));
        }
        if (!validCdRsrcCharSex || SEX_FEMALE.equals(cdRsrcCharSex) || SEX_BOTH.equals(cdRsrcCharSex)) {
          String betweenSql = "? BETWEEN {alias}.NBR_RSRC_CHAR_MIN_F_AGE AND {alias}.NBR_RSRC_CHAR_MAX_F_AGE";
          rcCriteria.add(Restrictions.sqlRestriction(betweenSql));
        }
        if (SEX_BOTH.equals(cdRsrcCharSex)) {
          criteria.add(Restrictions.eq("rc.cdRsrcCharSex", cdRsrcCharSex));
        }
      } else {
        // Age has not been entered
        if (SEX_MALE.equals(cdRsrcCharSex)) {
          criteria.add(Restrictions.in("rc.cdRsrcCharSex", new String[] {"B", "M"}));
        }
        if (SEX_FEMALE.equals(cdRsrcCharSex)) {
          criteria.add(Restrictions.in("rc.cdRsrcCharSex", new String[] {"B", "F"}));
        }
        if (SEX_BOTH.equals(cdRsrcCharSex)) {
          criteria.add(Restrictions.eq("rc.cdRsrcCharSex", cdRsrcCharSex));
        }
      }
      if (validCdRsrcCharChrctr) {
        criteria.add(Restrictions.eq("rc.cdRsrcCharChrctr", cdRsrcCharChrctr));
      }
      if (validScrYrRsrcCharMinMonths || validCdRsrcCharSex ||
          validCdRsrcCharChrctr) {
        if (validCdRsrcSvcProgram) {
          criteria.add(Restrictions.eq("rc.cdRsrcCharProgram", cdRsrcSvcProgram));
        }
        if (validCdRsrcSvcCategRsrc) {
          criteria.add(Restrictions.eq("rc.cdRsrcCharCategRsrc", cdRsrcSvcCategRsrc));
        }
        if (validCdRsrcSvcService) {
          criteria.add(Restrictions.eq("rc.cdRsrcCharService", cdRsrcSvcService));
        }
        if (validCdRsrcSvcState) {
          criteria.add(Restrictions.eq("rc.cdRsrcCharState", cdRsrcSvcState));
        }
        if (validCdRsrcSvcRegion) {
          criteria.add(Restrictions.eq("rc.cdRsrcCharRegion", cdRsrcSvcRegion));
        }
        if (validCdRsrcSvcCnty) {
          criteria.add(Restrictions.eq("rc.cdRsrcCharCnty", cdRsrcSvcCnty));
        }
      }
      if (StringHelper.isValid(cdRsrcFacilType)) {
        criteria.add(Restrictions.eq("cr.cdRsrcFacilType", cdRsrcFacilType));
      }
      if (StringHelper.isValid(cdFloc)) {
        if (FLOC_01.equals(cdFloc)) {
          criteria.add(Restrictions.eq("fl.cdFlocStatus1", CodesTables.CFLOCSTA_A));
        }
        if (FLOC_02.equals(cdFloc)) {
          criteria.add(Restrictions.eq("fl.cdFlocStatus2", CodesTables.CFLOCSTA_A));
        }
        if (FLOC_03.equals(cdFloc)) {
          criteria.add(Restrictions.eq("fl.cdFlocStatus3", CodesTables.CFLOCSTA_A));
        }
        if (FLOC_04.equals(cdFloc)) {
          criteria.add(Restrictions.eq("fl.cdFlocStatus4", CodesTables.CFLOCSTA_A));
        }
        if (FLOC_05.equals(cdFloc)) {
          criteria.add(Restrictions.eq("fl.cdFlocStatus5", CodesTables.CFLOCSTA_A));
        }
        if (FLOC_06.equals(cdFloc)) {
          criteria.add(Restrictions.eq("fl.cdFlocStatus6", CodesTables.CFLOCSTA_A));
        }
        if (FLOC_S6.equals(cdFloc)) {
          criteria.add(Restrictions.eq("fl.cdFlocStatus7", CodesTables.CFLOCSTA_A));
        }
        if (FLOC_E1.equals(cdFloc)) {
          criteria.add(Restrictions.eq("fl.cdFlocStatus8", CodesTables.CFLOCSTA_A));
        }
        if (FLOC_E2.equals(cdFloc)) {
          criteria.add(Restrictions.eq("fl.cdFlocStatus9", CodesTables.CFLOCSTA_A));
        }
        if (FLOC_E3.equals(cdFloc)) {
          criteria.add(Restrictions.eq("fl.cdFlocStatus10", CodesTables.CFLOCSTA_A));
        }
        if (FLOC_3N.equals(cdFloc)) {
          criteria.add(Restrictions.eq("fl.cdFlocStatus11", CodesTables.CFLOCSTA_A));
        }
        if (FLOC_3T.equals(cdFloc)) {
          criteria.add(Restrictions.eq("fl.cdFlocStatus12", CodesTables.CFLOCSTA_A));
        }
        DetachedCriteria flCriteria = DetachedCriteria.forClass(FacilityLoc.class, "fl2");
        flCriteria.setProjection(Projections.max("fl2.dtFlocEffect"));
        flCriteria.add(Restrictions.eqProperty("fl2.capsResource", "cr.idResource"));
        criteria.add(Property.forName("fl.dtFlocEffect").eq(flCriteria));
      }
      if (SORT_BY_RESOURCE_NAME.equals(scrCdRsrcSort)) {
        criteria.addOrder(Order.asc("cr.nmResoruce"));
      } else if (SORT_BY_TYPE.equals(scrCdRsrcSort)) {
        criteria.addOrder(Order.asc("cr.cdRsrcType"));
      } else if (SORT_BY_COUNTY.equals(scrCdRsrcSort)) {
        criteria.addOrder(Order.asc("cr.cdRsrcCnty"));
      }
    }
    return (List<Map>) criteria.list();
  }
}
