package gov.georgia.dhr.dfcs.sacwis.dao;

public interface LegalStatusAuditDAO {
	/**
	 * This method should only be used to update an deleted legal status event because id event is unique in that case
	 * @param idPerson
	 * @param idEvent
	 */
	int updateLegalStatusAuditWithPersonModifiedByByIdEvent(int idPerson, int idEvent);

}
