package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.ContactCbx;

public interface ContactCbxDAO {
  /**
   * Retrieves all CONTACT_CBX entries associated to the given ID_CONTACT_EVENT.
   * 
   * @param idContactEvent
   * @return
   */
  List<ContactCbx> findContactCbx(int idContactEvent);
  
  /**
   * Calls the Hibernate API method Session#saveOrUpdate to insert or update a CONTACT_CBX record
   * based on the persistent state of the ContactCbx object given.
   * 
   * @param contactCbx
   */
  void saveContactCbx(ContactCbx contactCbx);
  
  /**
   * Deletes a single specific CONTACT_CBX record based on the unique combination of ID_CONTACT_EVENT,
   * CD_CBX_CODE_TYPE, and CD_CONTACT_CBX.
   * 
   * @param idContactEvent
   * @param codeType
   * @param cbxCode
   * @return
   */
  int deleteContactCbx(int idContactEvent, String codeType, String cbxCode);
  
  /**
   * Deletes all CONTACT_CBX records associated to the given ID_CONTACT_EVENT.
   * 
   * @param idContactEvent
   * @return
   */
  int deleteContactCbxByIdContactEvent(int idContactEvent);
  
  /**
   * Finds contact checkbox records of a specific type, such as purpose or TCM.
   * 
   * @param idContactEvent
   * @param codeType
   * @return
   */
   public List<String> findContactCbxByIdEventAndCodeType(int idContactEvent, String codeType);
}
