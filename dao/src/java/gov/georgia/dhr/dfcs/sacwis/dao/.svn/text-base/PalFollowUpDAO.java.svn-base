/**
 * Created on Mar 25, 2006 at 3:03:17 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.PalFollowUp;

public interface PalFollowUpDAO {
  /**
   * Retrieves a row from PalFollowUp table for the given Stage ID
   *
   * @param idStage
   * @return PalFollowUp
   */
  PalFollowUp findPalFollowUpByIdStage(int idStage);

  /**
   * Partial update of PalFollowUp table using the supplied parameters(column values).
   *
   * @param dtPalFollupDate
   * @param cdPalFollupEducStat
   * @param cdPalFollupEmployed
   * @param cdPalFollupHighestEdu
   * @param cdPalFollupLivArr
   * @param cdPalFollupMarital
   * @param cdPalFollupReunified
   * @param indPalFollupNoPubAst
   * @param indPalFollupNotLocate
   * @param nbrPalFollupNumChldrn
   * @param lastUpdate
   * @param idStage
   */
  int updatePalFollowUp(Date dtPalFollupDate, String cdPalFollupEducStat, String cdPalFollupEmployed,
                        String cdPalFollupHighestEdu, String cdPalFollupLivArr, String cdPalFollupMarital,
                        String cdPalFollupReunified, String indPalFollupNoPubAst, String indPalFollupNotLocate,
                        int nbrPalFollupNumChldrn, Date lastUpdate, int idStage);

  /**
   * Partial insert of PalFollowUp table using the supplied parameters(column values). (Note that the insert is done
   * using straight SQL)
   *
   * @param idStage
   * @param lastUpdate
   * @param dtPalFollupDate
   * @param cdPalFollupEducStat
   * @param cdPalFollupEmployed
   * @param cdPalFollupHighestEdu
   * @param cdPalFollupLivArr
   * @param cdPalFollupMarital
   * @param cdPalFollupReunified
   * @param indPalFollupNoPubAst
   * @param indPalFollupNotLocate
   * @param nbrPalFollupNumChldrn
   */
  int insertPalFollowUp(int idStage, Date lastUpdate, Date dtPalFollupDate, String cdPalFollupEducStat,
                        String cdPalFollupEmployed, String cdPalFollupHighestEdu, String cdPalFollupLivArr,
                        String cdPalFollupMarital, String cdPalFollupReunified, String indPalFollupNoPubAst,
                        String indPalFollupNotLocate, int nbrPalFollupNumChldrn);

  /**
   * Deletes rows from PAL_FOLLOW_UP based on ID_PAL_FOLLOUP_STAGE
   *
   * @param tsLastUpdate
   * @param idStage
   * @return
   */
  int deletePalFollowUp(Date tsLastUpdate, int idStage);
}
