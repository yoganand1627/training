package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.LegalActionCrtLang;

import java.util.List;

public interface LegalActionCrtLangDAO {
  /**
   * Calls Hibernate method saveOrUpdate for the given {@link gov.georgia.dhr.dfcs.sacwis.db.LegalActionCrtLang} object.
   * 
   * @param lacl
   */
  void saveCourtLanguage(LegalActionCrtLang lacl);
  
  /**
   * Calls Hibernate method Session.delete for the given {@link gov.georgia.dhr.dfcs.sacwis.db.LegalActionCrtLang} object.
   * 
   * @param lacl
   */
  void deleteCourtLanguage(LegalActionCrtLang lacl);
  
  /**
   * Deletes all entries in LegalActionCrtLang for the given idLegalActEvent-cdCrtLang combination.
   * 
   * @param idLegalActEvent
   * @param cdCrtLang
   * @return
   */
  int deleteCourtLanguage(int idLegalActEvent, String cdCrtLang);
  
  /**
   * Retrieves a list of all LegalActionCrtLang entries for the given idLegalActEvent (key to LegalAction).
   * 
   * @param idLegalActEvent
   * @return
   */
  List<LegalActionCrtLang> findLegalActionCrtLangList(int idLegalActEvent);
}
