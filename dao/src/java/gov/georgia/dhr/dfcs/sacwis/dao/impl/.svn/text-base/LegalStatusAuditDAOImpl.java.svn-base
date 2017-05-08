package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusAuditDAO;

import org.hibernate.Query;

public class LegalStatusAuditDAOImpl extends BaseDAOImpl implements LegalStatusAuditDAO {

	public int updateLegalStatusAuditWithPersonModifiedByByIdEvent(
			int idPerson, int idEvent) {
		Query query = getSession().createQuery("update LegalStatusAudit lsa "
						+ " set lsa.idPersonModifiedBy = :idPerson "
						+ " where lsa.idLegalStatEvent = :idEvent "
						+ " and lsa.cdUserAction = 'D' ");
		query.setInteger("idPerson", idPerson);
		query.setInteger("idEvent", idEvent);
		return query.executeUpdate();

	}

}
