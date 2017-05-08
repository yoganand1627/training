package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.IncmgDetermFactorsDAO;
import java.util.List;
import java.util.Map;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;


/**
 * This is the DAO class is used for the INCMG_DETERM_FACTORS table
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------    --------  --------------------------------------------------
 *  01/05/2009  arege     STGAP00009957 - Added findExtraIncmgDetermFactorsByIdStage()
 *                        to find if there exists determination factors with no 
 *                        corresponding allegations and deleteExtraIncmgDetermFactorsByIdDetermFactors
 *                        to delete the determination factors for given list of id_determination.
 *                      
 * </pre>
 */

public class IncmgDetermFactorsDAOImpl extends BaseDAOImpl implements IncmgDetermFactorsDAO {
  @SuppressWarnings({"unchecked"})
  public List<Map> findIncmgDetermFactorsByIdStage(int idStage) {

    Query query = getSession().createQuery("select new map(p.cdIncmgDeterm as cdIncmgDeterm, " +
                                           "               p.txtDetFacCmnts as txtDetFacCmnts, " +
                                           "               p.cdIncmgDetermType as cdIncmgDetermType) " +
                                           "  from IncmgDetermFactors p " +
                                           " where p.stage.idStage = :idStage ");
    query.setInteger("idStage", idStage);

    return (List<Map>) query.list();
  }
  
  //Added Per STGAP00009957
  @SuppressWarnings({"unchecked"})
  public List<Integer> findExtraIncmgDetermFactorsByIdStage(int idStage) {

    SQLQuery query = getSession().createSQLQuery("SELECT idf.ID_DETERMINATION "+
                                           "FROM INCMG_DETERM_FACTORS idf, STAGE s "+
                                           "WHERE idf.ID_INCMG_DETERM_STAGE = s.ID_STAGE "+
                                           "AND s.DT_STAGE_CLOSE IS NULL               "  +
                                           "AND idf.CD_INCMG_DETERM_TYPE NOT IN( "+
                                                 "  SELECT SUBSTR(CD_INTAKE_ALLEG_TYPE,0,1)" +
                                                  " FROM INTAKE_ALLEGATION                 " +
                                                   " WHERE ID_ALLEGATION_STAGE = idf.ID_INCMG_DETERM_STAGE )"+
                                                   " AND idf.ID_INCMG_DETERM_STAGE = :idStage");
    
    query.setInteger("idStage", idStage);
    query.addScalar("ID_DETERMINATION", Hibernate.INTEGER);
    return (List<Integer>) query.list();
  }
  
  //Added Per STGAP00009957
  @SuppressWarnings({"unchecked"})
  public int deleteExtraIncmgDetermFactorsByIdDetermFactors(List<Integer> determFactorsList){
    Query query = getSession().createQuery("DELETE FROM IncmgDetermFactors i "+
                                           "WHERE i.idDetermination IN  (  " +
                                           " :determFactorsList)" );
    
    query.setParameterList("determFactorsList", determFactorsList) ;
    return  query.executeUpdate();
  }

  public int insertIncmgDetermFactors(String incmgDeterm, String cdIncmgDetermType, int idStage, String txtDetFacCmnts) {
    SQLQuery query = getSession().createSQLQuery(
            "insert into INCMG_DETERM_FACTORS (CD_INCMG_DETERM,CD_INCMG_DETERM_TYPE,ID_DETERMINATION,ID_INCMG_DETERM_STAGE, TXT_DET_FAC_CMNTS )" +
            "      values(:incmgDeterm," +
            "             :cdIncmgDetermType," +
            "             SEQ_INCMG_DETERM_FACTORS.NEXTVAL," +
            "             :idStage, " +
            "             :txtDetFacCmnts)");
    query.setString("incmgDeterm", incmgDeterm);
    query.setString("txtDetFacCmnts", txtDetFacCmnts);
    query.setString("cdIncmgDetermType", cdIncmgDetermType);
    query.setInteger("idStage", idStage);

    return (query.executeUpdate());

  }

  public int deleteIncmgDetermFactors(int idStage) {
    Query query = getSession().createQuery("delete from IncmgDetermFactors i " +
                                           "       where i.stage.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }
}
