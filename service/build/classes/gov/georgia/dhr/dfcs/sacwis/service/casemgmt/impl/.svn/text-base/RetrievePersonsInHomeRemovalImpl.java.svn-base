package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonHomeRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonHomeRemoval;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrievePersonsInHomeRemoval;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB48SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB48SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB48SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB48SOG00_ARRAY;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RetrievePersonsInHomeRemovalImpl extends BaseServiceImpl implements RetrievePersonsInHomeRemoval {

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private PersonHomeRemovalDAO personHomeRemovalDAO = null;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPersonHomeRemovalDAO(PersonHomeRemovalDAO personHomeRemovalDAO) {
    this.personHomeRemovalDAO = personHomeRemovalDAO;
  }

  public CSUB48SO retrievePersonsInHomeRemoval(CSUB48SI csub48si) throws ServiceException {

    CSUB48SO csub48so = new CSUB48SO();

    // rc = clsc10dQUERYdam(sqlca, pCLSC10DInputRec, pCLSC10DOutputRec);
    List<Map> stagePersonLinkInfo = stagePersonLinkDAO.findStagePersonLink(csub48si.getUlIdStage(),
                                                                           CodesTables.CPRSNTYP_PRN,
                                                                           DateHelper.MAX_JAVA_DATE);
    if (stagePersonLinkInfo == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }

    ROWCSUB48SOG00_ARRAY rowcsub48sog00_array = new ROWCSUB48SOG00_ARRAY();
    int size = stagePersonLinkInfo.size();
    rowcsub48sog00_array.setUlRowQty(size);
    for (Iterator<Map> it = stagePersonLinkInfo.iterator(); it.hasNext();) {
      Map stagePersonLinkMap = it.next();
      ROWCSUB48SOG00 rowcsub48sog00 = new ROWCSUB48SOG00();
      rowcsub48sog00.setTsLastUpdate((Date) stagePersonLinkMap.get("dtLastUpdate"));
      rowcsub48sog00
                    .setUlIdPerson((Integer) stagePersonLinkMap.get("idPerson") != null ? (Integer) stagePersonLinkMap
                                                                                                                      .get("idPerson")
                                                                                       : 0);
      rowcsub48sog00.setSzNmPersonFull((String) stagePersonLinkMap.get("nmPersonFull"));
      rowcsub48sog00.setSzCdPersonRelationship((String) stagePersonLinkMap.get("cdStagePersRelInt"));
      rowcsub48sog00.setDtDtPersonBirth(DateHelper.toCastorDate((Date) stagePersonLinkMap.get("dtPersonBirth")));
      rowcsub48sog00.setCCdPersonSex((String) stagePersonLinkMap.get("cdPersonSex"));
      rowcsub48sog00_array.addROWCSUB48SOG00(rowcsub48sog00);

    }

    // rc = clss08dQUERYdam(sqlca, pCLSS08DInputRec, pCLSS08DOutputRec);
    List<PersonHomeRemoval> personHomeRemovalInfo = personHomeRemovalDAO
                                                                        .findPersonHomeRemovalByIdEvent(csub48si
                                                                                                                .getUlIdEvent());

 

    boolean bMatchFound = false;
    if(personHomeRemovalInfo != null){
    for (int j = 0; j <= rowcsub48sog00_array.getUlRowQty() - 1;) {
      for (Iterator<Map> it1 = stagePersonLinkInfo.iterator(); it1.hasNext();) {
        Map stagePersonLinkMap = it1.next();
        for (Iterator<PersonHomeRemoval> it2 = personHomeRemovalInfo.iterator(); it2.hasNext() && !bMatchFound;) {

          PersonHomeRemoval personHomeRemoval2 = it2.next();
          int i = (Integer) stagePersonLinkMap.get("idPerson");
          if (personHomeRemoval2.getPerson().getIdPerson() == i) {
            ROWCSUB48SOG00 rowcsub48sog00 = rowcsub48sog00_array.getROWCSUB48SOG00(j);
            rowcsub48sog00.setCScrIndRefChildMatch("Y");
            rowcsub48sog00.setTsLastUpdate(personHomeRemoval2.getDtLastUpdate());
           // Change the flag
            bMatchFound = true;
          }// end if
        } // end for
        j++;
        bMatchFound = false;
      }// end for
    } // end for array
  } //end if
    csub48so.setROWCSUB48SOG00_ARRAY(rowcsub48sog00_array);

    return csub48so;
  }

}
