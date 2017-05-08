package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;

public interface ComplexAdoptionSubsidyDAO {
  /**
   * Insert a row into AdoptionSubsidy table after validation
   *
   * @param adptSubPerson
   * @param dtAdptSubEffective
   * @param dtAdptSubEnd
   * @param adoptionSubsidy
   * @param cdAdptAudDeterm
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   */
  void insertWithoutDateOverlap(int adptSubPerson, Date dtAdptSubEffective, Date dtAdptSubEnd,
                                AdoptionSubsidy adoptionSubsidy, String cdAdptAudDeterm) throws ServiceException;

  /**
   * Update a row in AdoptionSubsidy after validation
   *
   * @param adptSubPerson
   * @param idAdptSub
   * @param dtAdptSubEnd
   * @param dtAdptSubEffective
   * @param tsLastUpdate
   * @param cdAdptAudDeterm
   * @param adoptionSubsidy
   */
  void updateWithoutDateOverlap(int adptSubPerson, int idAdptSub, Date dtAdptSubEnd, Date dtAdptSubEffective,
                                Date tsLastUpdate, String cdAdptAudDeterm, AdoptionSubsidy adoptionSubsidy)
          throws ServiceException;
}
