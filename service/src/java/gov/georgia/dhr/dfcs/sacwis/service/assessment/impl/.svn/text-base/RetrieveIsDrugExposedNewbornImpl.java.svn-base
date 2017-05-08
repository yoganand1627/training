package gov.georgia.dhr.dfcs.sacwis.service.assessment.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.IncmgDetermFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.RetrieveIsDrugExposedNewborn;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class RetrieveIsDrugExposedNewbornImpl extends BaseServiceImpl implements RetrieveIsDrugExposedNewborn {

  private IncmgDetermFactorsDAO incmgDetermFactorsDAO = null;

  private StageLinkDAO stageLinkDAO = null;

  public static final String NPID = "NPID";

  public static final String DETERM_TYPE = "N";

  public void setIncmgDetermFactorsDAO(IncmgDetermFactorsDAO incmg) {
    this.incmgDetermFactorsDAO = incmg;
  }

  public void setStageLinkDAO(StageLinkDAO stgLink) {
    this.stageLinkDAO = stgLink;
  }

  public boolean isDrugExposedNewborn(int idStage) {
		boolean result = false;
		Integer temp = stageLinkDAO.findPreviousIdStagebyIdStage(idStage);

		if (temp != null) {
			int prevIdStage = temp.intValue();
			List<Map> listidf = incmgDetermFactorsDAO
					.findIncmgDetermFactorsByIdStage(prevIdStage);
			if (listidf != null && !listidf.isEmpty()) {
				for (Iterator<Map> it = listidf.iterator(); it.hasNext();) {
					Map m = it.next();
					String determ = (String) m.get(("cdIncmgDeterm"));
					String type = (String) m.get("cdIncmgDetermType");
					if (determ != null && type != null
							&& DETERM_TYPE.equals(type) && NPID.equals(determ)) {
						result = true;
						break;
					}
				}
			}
			return result;
		}
		return result;
	}
    
}
