package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.YrppLink;
/*
 * Change History:
 * Date        User              Description
 * --------    ----------------  --------------------------------------------------
 * 08/20/10    hnguyen           MR-067: DAO interface creation
*/

public interface YrppLinkDAO {
  /**
   * This selects a unique row from the YRPP_LINK table based on the primary key<p/>
   *
   * @param idYrppLink
   * @return
   */
  YrppLink findYrppLinkByIdYrppLink(int idYrppLink);

  /**
   * This selects a list of rows from the YRPP_LINK table <p/>
   *
   * @param idUser
   * @return
   */
  List<YrppLink> findYrppLinkByIdUser(int idUser);

  /**
   * This selects a unique row from the YRPP_LINK table <p/>
   *
   * @param idYouthReportDtl
   * @return
   */
  YrppLink findYrppLinkByIdYouthReportDtl(int idYouthReportDtl);

  /**
   * Retrieves a list of records based on the idPerson <p/>
   *
   * @param idPerson
   * @return
   */
  List<YrppLink> findYrppLinkByIdPerson(int idPerson);

  /**
   * Retrieves a record from a child who has a Poral User account created <p/>
   *
   * @param idPerson
   * @param reportingYear
   * @param indNytdGreetEmailSent
   * @return
   */
  YrppLink findYrppLinkWithPortalUserAccount(int idPerson, int reportingYear, String indNytdGreetEmailSent);

  /**
   * This updates indNytdGreetEmailSent column based on the primary key<p/>
   *
   * @param idYrppLink
   * @param indNytdGreetEmailSent
   * @return
   */
  int updateYrppLinkIndNytdGreetEmailSent(int idYrppLink, String indNytdGreetEmailSent);

  /**
   * This updates indNytdSurveyComplete column based on the primary key<p/>
   *
   * @param idYrppLink
   * @param indNytdSurveyComplete
   * @return
   */
  int updateYrppLinkIndNytdSurveyComplete(int idYrppLink, String indNytdSurveyComplete);

  /**
   * Saves a new YRPP_LINK record
   *
   * @param yrppLink
   */
  void saveYrppLink(YrppLink yrppLink);

}
