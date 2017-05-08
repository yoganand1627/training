package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicaidCoaInboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.MedicaidCoaInbound;

public class MedicaidCoaInboundDAOImpl extends BaseDAOImpl implements MedicaidCoaInboundDAO{

  public int saveMedicaidCoaInbound(MedicaidCoaInbound medicaidCoaInbound) {
    getSession().saveOrUpdate(medicaidCoaInbound);
    return medicaidCoaInbound.getIdMedicaidCoaInbound();
  }
}

