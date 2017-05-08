/**
 * Created on Mar 25, 2006 at 3:03:33 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.Pal;

public interface PalDAO {
  /**
   * Retrieves a row from Pal table for a given Stage ID
   * <p/>
   *
   * @param idStage
   * @return Pal
   */
  Pal findPal(int idStage);

  /**
   * Partial update of Pal table using the supplied parameters(column values).
   *
   * @param idStage
   * @param lastUpdate
   * @param cdPalCloseLivArr
   * @param dtPalPostasmtDate
   * @param dtPalPreasmtDate
   * @param indPalIlNoIlsAssmt
   * @param indPalIlNoPoasmtScre
   * @param indPalIlNoPrasmtScre
   * @param nbrPalPostasmtScore
   * @param nbrPalPreasmtScore
   * @param txtPalIlNoIlsRsn
   */
  int updatePal(int idStage, Date lastUpdate, String cdPalCloseLivArr, Date dtPalPostasmtDate,
                Date dtPalPreasmtDate, String indPalIlNoIlsAssmt, String indPalIlNoPoasmtScre,
                String indPalIlNoPrasmtScre, int nbrPalPostasmtScore, int nbrPalPreasmtScore,
                String txtPalIlNoIlsRsn);

  /**
   * Partial insert of Pal table using the supplied parameters(column values). (Note that the insert is done using
   * straight SQL)
   *
   * @param idStage
   * @param lastUpdate
   * @param cdPalCloseLivArr
   * @param dtPalPostasmtDate
   * @param dtPalPreasmtDate
   * @param indPalIlNoIlsAssmt
   * @param indPalIlNoPoasmtScre
   * @param indPalIlNoPrasmtScre
   * @param nbrPalPostasmtScore
   * @param nbrPalPreasmtScore
   * @param txtPalIlNoIlsRsn
   */
  int insertPal(int idStage, Date lastUpdate, String cdPalCloseLivArr, Date dtPalPostasmtDate,
                Date dtPalPreasmtDate, String indPalIlNoIlsAssmt, String indPalIlNoPoasmtScre,
                String indPalIlNoPrasmtScre, int nbrPalPostasmtScore, int nbrPalPreasmtScore,
                String txtPalIlNoIlsRsn);

  /**
   * Partial update of Pal table using the supplied parameters(column values).
   *
   * @param idStage
   * @param cdPalCloseLivArr
   */
  int updatePal(int idStage, String cdPalCloseLivArr);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.Pal} object.
   *
   * @param pal
   */
  void deletePal(Pal pal);
}
