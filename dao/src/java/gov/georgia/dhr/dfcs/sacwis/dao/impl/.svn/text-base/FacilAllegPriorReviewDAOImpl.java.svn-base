package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FacilAllegPriorReviewDAO;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class FacilAllegPriorReviewDAOImpl extends BaseDAOImpl implements FacilAllegPriorReviewDAO {
  public int insertFacilAllegPriorReview(int idAllegation,
                                         int idReviewStage,
                                         int idReviewVictim,
                                         int idReviewAllegedPerp,
                                         String cdReviewAllegType,
                                         String cdReviewAllegDisp,
                                         String cdReviewAllegDispSupr,
                                         String cdReviewAllegClss,
                                         String cdReviewAllegClssSupr) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO FACIL_ALLEG_PRIOR_REVIEW " +
                                                 "     (ID_ALLEGATION, " +
                                                 "      ID_REVIEW_STAGE, " +
                                                 "      ID_REVIEW_VICTIM, " +
                                                 "      ID_REVIEW_ALLEGED_PERP, " +
                                                 "      CD_REVIEW_ALLEG_TYPE, " +
                                                 "      CD_REVIEW_ALLEG_DISP, " +
                                                 "      CD_REVIEW_ALLEG_DISP_SUPR, " +
                                                 "      CD_REVIEW_ALLEG_CLSS, " +
                                                 "      CD_REVIEW_ALLEG_CLSS_SUPR) " +
                                                 " VALUES ( " +
                                                 "     :idAllegation, " +
                                                 "     :idReviewStage, " +
                                                 "     :iIdReviewVictim, " +
                                                 "     :idReviewAllegedPerp, " +
                                                 "     :cdReviewAllegType, " +
                                                 "     :cdReviewAllegDisp, " +
                                                 "     :cdReviewAllegDispSupr, " +
                                                 "     :cdReviewAllegClss, " +
                                                 "     :cdReviewAllegClssSupr)");
    query.setInteger("idAllegation", idAllegation);
    query.setInteger("idReviewStage", idReviewStage);
    query.setInteger("iIdReviewVictim", idReviewVictim);
    query.setInteger("idReviewAllegedPerp", idReviewAllegedPerp);
    query.setString("cdReviewAllegType", cdReviewAllegType);
    query.setString("cdReviewAllegDisp", cdReviewAllegDisp);
    query.setString("cdReviewAllegDispSupr", cdReviewAllegDispSupr);
    query.setString("cdReviewAllegClss", cdReviewAllegClss);
    query.setString("cdReviewAllegClssSupr", cdReviewAllegClssSupr);

    return query.executeUpdate();
  }

  public int deleteFacilAllegPriorReviewByIdStage(int idStage) {
    Query query = getSession().createQuery(" delete from FacilAllegPriorReview" +
                                           "       where stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }
}
