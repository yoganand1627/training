package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.FceReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceReview;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveFceReview;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class RetrieveFceReviewImpl extends BaseServiceImpl implements RetrieveFceReview {
  
  private FceReviewDAO fceReviewDAO = null;
  
  public void setFceReviewDAO(FceReviewDAO fceReviewDAO) {
    this.fceReviewDAO = fceReviewDAO;
  }
  
  public FceReviewDB retrieveFceReview(long idFceReview) {
    FceReview fceReview = fceReviewDAO.findFceReviewByIdFceReview(idFceReview);
    if (fceReview == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFceReviewDB(fceReview);
  }
}
