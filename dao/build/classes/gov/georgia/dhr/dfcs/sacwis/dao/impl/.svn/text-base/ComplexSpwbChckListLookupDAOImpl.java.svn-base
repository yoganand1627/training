package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexSpwbChckListLookupDAO;

public class ComplexSpwbChckListLookupDAOImpl extends BaseDAOImpl implements ComplexSpwbChckListLookupDAO {

  @SuppressWarnings( { "unchecked" })
  public List<Map> findCheckListQuestions(List<Integer> childrenAges, String cdMainCategory,String cdSubCategory, String cdAudience ) {
    
    StringBuffer hql = new StringBuffer(
                                        "select new map ( chk.cdChckList as cdChckList, chk.cdMainCategory as cdMainCategory, "
                                                        + "chk.cdAudience as cdAudience, chk.txtChckList as txtChckList, "
                                                        + "agl.nbrMonthMin as  nbrMonthMin, agl.nbrMonthMax as nbrMonthMax) "
                                                        + "from SpwbChckListLookup chk,SpwbAgeGroupLookup agl "
                                                        + " where chk.cdChckList = agl.spwbChckListLookup.cdChckList "
                                                        + " and chk.cdMainCategory = :cdMainCategory "
                                                        + " and chk.cdAudience = :cdAudience ");

    // Include the Sub Category if needed
    if (cdSubCategory != null) {
      hql.append(" and chk.cdSubCategory = :cdSubCategory ");
    }

    // Format all the AND/OR conditions for various age ranges that will be passed into the HQL
    if (childrenAges != null) {
      for (int x = 0; x < childrenAges.size(); x++) {
        if (x == 0) {
          hql.append(" and  (");
        } else {
          hql.append(" or ");
        }
        
        hql.append("(agl.nbrMonthMin<= :ageMin" + String.valueOf(x) + " and agl.nbrMonthMax > :ageMax"
                   + String.valueOf(x) + " )");
      }
      // Add final parenthesis if children array was passed in
      if (childrenAges.size() > 0) {
        hql.append(")");
      }
      
    }
    hql.append(" order by chk.cdChckList ");
    
    Query query = getSession().createQuery(hql.toString());
    
    // Set the bind variables
    query.setString("cdMainCategory", cdMainCategory);
    query.setString("cdAudience", cdAudience);
    if (cdSubCategory != null) {
      query.setString("cdSubCategory", cdSubCategory);
    }
    for (int x = 0; x < childrenAges.size(); x++) {
      query.setInteger("ageMin" + String.valueOf(x), childrenAges.get(x));
      query.setInteger("ageMax" + String.valueOf(x), childrenAges.get(x));
    }
    return (List<Map>) query.list();

  }

}
