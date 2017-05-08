package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RetrieveIncomingDetail;

public class RetrieveIncomingDetailImpl extends BaseServiceImpl implements RetrieveIncomingDetail {

	private IncomingDetailDAO incomingDetailDAO = null;

	public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
		this.incomingDetailDAO = incomingDetailDAO;
	}
		
	public Integer retrieveIncomingDetail(Integer idStage) throws ServiceException {
		IncomingDetail intake = incomingDetailDAO.findIncomingDetailFromAnyIdStage((idStage != null) ? idStage : 0);		
		return (intake != null) ? intake.getIdStage() : new Integer(0);
	}

}
