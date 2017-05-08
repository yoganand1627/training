/**
 * Created on Mar 25, 2006 at 3:15:12 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCategory;

public interface PersonCategoryDAO {
  public final String CD_EMPLOYEE = "EMP";
  public final String CD_FORMER_EMPLOYEE = "FEM";

  /**
   * Retrieves a list of rows from PersonCategory table for the given idPerson.
   *
   * @param idPerson
   * @return List of PersonCategory objects
   */
  PaginatedHibernateList<PersonCategory> findPersonCategoryByIdPerson(int idPerson, int pageNbr, int pageSize);

  /**
   * Return a count of PersonCategory rows for a given idPerson and cdPersonCategory
   *
   * @param idPerson
   * @param cdPersonCategory
   * @return Integer
   */
  long countPersonCategoryByIdPersonAndCdPersonCategory(int idPerson, String cdPersonCategory);

  /**
   * Counts the total number of records in the PersonCategory table that matches and idPerson and a cdPersonCategory.
   *
   * @param idPerson
   * @param cdPersonCategory
   * @return Integer of the total number of rows
   */
  long countPersonCategoryIdPersonCategory(int idPerson, String cdPersonCategory);

  /**
   * Counts the total number of records that result in joining the PersonCategory and PersonMergeView tables on idPerson
   * and IdPersonOutput respectively that matches and idPerson and a cdPersonCategory. </p> <p>This will be used to
   * return a flag indicating that the ID_PERSON passed in is an employee who has never been associated with a stage as
   * a principal.</p>
   *
   * @param idPerson
   * @return Integer of the total number of rows
   */

  long countPersonCategByCdPersonCategPersonMergeViewInputAndOutputIdPerson(int idPerson);
  
  List<Integer> findcountPersonCategByCdPersonCategPersonMergeViewInputAndOutputIdPersonByPersonList(Collection<Integer> idPersons);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.PersonCategory} object to the database.
   *
   * @param personCategory A populated {@link gov.georgia.dhr.dfcs.sacwis.db.PersonCategory} object.
   */
  void savePersonCategory(PersonCategory personCategory);

  /**
   * Updates table PersonCategory, field cdPersonCategory given idPerson and cdPersonCategory<p/>
   *
   * @param idPerson
   * @param cdCategoryCategory
   * @param cdPersonCategory2
   */
  int updateCdPersonCategoryByIdPersonAndCdPersonCategory(int idPerson, String cdCategoryCategory,
                                                          String cdPersonCategory2);

  /**
   * Deletes rows from PersonCategory based on idPerson.
   *
   * @param idPerson
   * @return Integer
   */
  int deletePersonCategory(int idPerson);

  /**
   * Deletes rows from PersonCategory based on idPerson and cdPersonCategory.
   *
   * @param idPerson
   * @param cdPersonCategory
   */
  int deletePersonCategory(int idPerson, String cdPersonCategory);
}
