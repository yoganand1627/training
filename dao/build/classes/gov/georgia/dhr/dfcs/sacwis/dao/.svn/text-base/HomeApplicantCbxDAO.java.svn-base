package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantCbx;

import java.util.List;

public interface HomeApplicantCbxDAO {

  /**
   * This selects a row from HomeApplicantCbx table given the Home Applicant ID. <p/>
   *
   * @param idHomeApplicant
   * @param cbxType
   * @return HomeApplicantCbx by idResource
   */
  List<HomeApplicantCbx> findHomeApplicantCbxByIdHomeApplicantCbxType(int idHomeApplicant, String cbxType );

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantCbx} object to the database.
   *
   * @param homeApplicantCbx A populated {@link gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantCbx} object.
   */
  void saveHomeApplicantCbx(HomeApplicantCbx homeApplicantCbx);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.HomeApplicantCbx} object.
   *
   * @param homeApplicantCbx
   */
  void deleteHomeApplicantCbx(HomeApplicantCbx homeApplicantCbx);
  
  /**
   * Deletes all HomeApplicantCbx records that match the given criteria.  (If more than one record
   * matches the criteria, they are duplicate entries anyway.)
   * 
   * @param idHomeApplicant
   * @param cbxType
   * @param cbx
   * @return
   */
  int deleteHomeApplicantCbx(int idHomeApplicant, String cbxType, String cbx);
}
