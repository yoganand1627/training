package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexIncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;

public class ComplexIncomingDetailDAOImpl extends BaseDAOImpl implements ComplexIncomingDetailDAO {
  public static final String ARC_SSA_INCMG_DETAIL_CALLER = "IC";
  public static final String ARC_SSA_INCMG_DETAIL_INREG = "IR";
  private CommonDAO commonDAO = null;
  private IncomingDetailDAO incomingDetailDAO = null;

  public void setCommonDAO(CommonDAO commonDAO) {
    this.commonDAO = commonDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void updateIncomingDetail(IncomingDetail incomingDetail) {
    //if this is an insert, the stage id needs to be retrieved first
    if (incomingDetail.getIdStage() == null) {
      int idStage = commonDAO.getNextval("SEQ_STAGE");
      incomingDetail.setStage((Stage) getSession().load(Stage.class, idStage));
    }
    incomingDetailDAO.saveIncomingDetail(incomingDetail);
  }
}
