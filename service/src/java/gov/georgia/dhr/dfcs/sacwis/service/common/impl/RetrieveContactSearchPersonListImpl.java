package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveContactSearchPersonList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01_ARRAY;

public class RetrieveContactSearchPersonListImpl extends BaseServiceImpl implements RetrieveContactSearchPersonList {

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CSYS03SO retrievePersonList(CSYS03SI csys03si) {
    CSYS03SO csys03so = new CSYS03SO();
    int pageNbr = 1;
    int pageSize = 50;
    // Get all principals and collaterals for the given stage that aren't of type STAFF
    List<StagePersonLink> stagePersonLink =
            stagePersonLinkDAO.findStagePersonLinkAndPersonByidStageAndCdStagePersType(csys03si.getUlIdStage(),
                                                                                       CodesTables.CPRSNALL_STF,
                                                                                       pageNbr,
                                                                                       pageSize);

    if (stagePersonLink != null && !stagePersonLink.isEmpty()) {
      ROWCSYS03SOG01_ARRAY rowcys03sog01_array = new ROWCSYS03SOG01_ARRAY();
      for (Iterator<StagePersonLink> it = stagePersonLink.iterator(); it.hasNext();) {
        StagePersonLink stagePersonLinkInfo = it.next();
        ROWCSYS03SOG01 rowcsys03sog01 = new ROWCSYS03SOG01();
        if (0 != stagePersonLinkInfo.getIdStagePersonLink()) {
          rowcsys03sog01.setSzNmPersonFull(stagePersonLinkInfo.getPerson().getNmPersonFull());
          rowcsys03sog01.setSzCdStagePersRole(stagePersonLinkInfo.getCdStagePersRole());
          rowcsys03sog01.setSzCdStagePersRelInt(stagePersonLinkInfo.getCdStagePersRelInt());
          rowcsys03sog01.setSzCdStagePersType(stagePersonLinkInfo.getCdStagePersType());
          rowcsys03sog01.setUlIdPerson(stagePersonLinkInfo.getPerson().getIdPerson());
          rowcys03sog01_array.addROWCSYS03SOG01(rowcsys03sog01);
        }
      }
      csys03so.setROWCSYS03SOG01_ARRAY(rowcys03sog01_array);
    }
    return csys03so;
  }
}
