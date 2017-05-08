package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Collection;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCategory;

import org.hibernate.Query;

/**
 * This is the conversation class used to maintain persons in the system. <p/> October 8, 2002 Anna N. Grimshaw <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User        Description
 *   --------  ----------  --------------------------------------------------------
 *   01/22/09  alwilliams  STGAP00010288: Updated deletePersonCategory(int idPerson) 
 *                         to exclude EMP and FEM records instead of 'emp' and 'fem'
 *                         records.
 *
 * </pre>
 */
public class PersonCategoryDAOImpl extends BaseDAOImpl implements PersonCategoryDAO {

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<PersonCategory> findPersonCategoryByIdPerson(int idPerson, int pageNbr, int pageSize) {
    Query query = getSession().createQuery("  from PersonCategory p " +
                                           " where p.person.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    return (PaginatedHibernateList<PersonCategory>) paginatedList(pageNbr, pageSize, query);
  }
  
  public long countPersonCategoryByIdPersonAndCdPersonCategory(int idPerson, String cdPersonCategory) {
    Query query = getSession().createQuery("select count(*) " +
                                           "  from PersonCategory " +
                                           " where person.idPerson = :idPerson " +
                                           "   and cdPersonCategory = :cdPersonCategory");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPersonCategory", cdPersonCategory);
    return (Long) query.uniqueResult();
  }

  public long countPersonCategoryIdPersonCategory(int idPerson, String cdPersonCategory) {
    Query query = getSession().createQuery("select count(p.idPersonCategory) " +
                                           "  from PersonCategory p " +
                                           " where p.person.idPerson = :idPerson " +
                                           "   and p.cdPersonCategory = :cdPersonCategory");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPersonCategory", cdPersonCategory);
    return (Long) query.uniqueResult();
  }

  public long countPersonCategByCdPersonCategPersonMergeViewInputAndOutputIdPerson(int idPerson) {
    Query query = getSession().createQuery("select count(p.person.idPerson) " +
                                           "  from PersonCategory p, " +
                                           "       PersonMergeView v " +
                                           " where v.id.idPersonInput = :idPerson " +
                                           "   and p.person.idPerson = v.id.idPersonOutput " +
                                           "   and (p.cdPersonCategory = :cdCategoryCategory1 " +
                                           "        or p.cdPersonCategory = :cdCategoryCategory2)");
    query.setInteger("idPerson", idPerson);
    query.setString("cdCategoryCategory1", CD_EMPLOYEE);
    query.setString("cdCategoryCategory2", CD_FORMER_EMPLOYEE);
    return (Long) query.uniqueResult();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Integer> findcountPersonCategByCdPersonCategPersonMergeViewInputAndOutputIdPersonByPersonList(Collection<Integer> idPersons) {
    Query query = getSession().createQuery(" SELECT p.idPerson FROM Person p " +
                " WHERE p.idPerson IN (:idPersons) AND " +
                " 0 < (select count(*) " +
                                           "  from PersonCategory pc, " +
                                           "       PersonMergeView v " +
                                           " where v.id.idPersonInput = p.idPerson " +
                                           "   and pc.person.idPerson = v.id.idPersonOutput " +
                                           "   and (pc.cdPersonCategory = :cdCategoryCategory1 " +
                                           "        or pc.cdPersonCategory = :cdCategoryCategory2))");
    query.setParameterList("idPersons", idPersons);
    query.setString("cdCategoryCategory1", CD_EMPLOYEE);
    query.setString("cdCategoryCategory2", CD_FORMER_EMPLOYEE);
    return (List<Integer>) query.list();
  }

  public void savePersonCategory(PersonCategory personCategory) {
    getSession().saveOrUpdate(personCategory);
  }

  public int updateCdPersonCategoryByIdPersonAndCdPersonCategory(int idPerson, String cdCategoryCategory,
                                                                 String cdPersonCategory2) {
    Query query = getSession().createQuery("update PersonCategory " +
                                           "   set cdPersonCategory = :cdPersonCategory2 " +
                                           " where person.idPerson = :idPerson " +
                                           "   and (cdPersonCategory = :cdCategoryCategory " +
                                           "        or cdPersonCategory = :cdPersonCategory2)");

    query.setInteger("idPerson", idPerson);
    query.setString("cdCategoryCategory", cdCategoryCategory);
    query.setString("cdPersonCategory2", cdPersonCategory2);
    return query.executeUpdate();
  }

  public int deletePersonCategory(int idPerson) {
    // STGAP00010288 - use 'FEM'and 'EMP' instead of 'fem' and 'emp'
    Query query = getSession().createQuery("delete PersonCategory " +
                                           " where person.idPerson = :idPerson " +
                                           "   and cdPersonCategory <> 'FEM'" +
                                           "   and cdPersonCategory <> 'EMP'");
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  public int deletePersonCategory(int idPerson, String cdPersonCategory) {
    Query query = getSession().createQuery("delete PersonCategory p " +
                                           " where p.person.idPerson = :idPerson " +
                                           "   and p.cdPersonCategory = :cdPersonCategory ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPersonCategory", cdPersonCategory);
    return query.executeUpdate();
  }
}
