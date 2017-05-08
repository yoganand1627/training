package gov.georgia.dhr.dfcs.sacwis.service.assessment.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.RetrievePrincipals;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV36SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV36SOG01_ARRAY;

/**
 * <pre>
 *  Change History:
 *  Date        User           Description
 *  --------    --------       -------------------------------------------------------------------------------------
 *  02/10/2010  wjcochran      SMS #44832 - Added new service retrieveAllPrincipalsWithNullInPKHshld
 *  10/11/2011  arege          STGAP00007729: If the person is marked as Caretaker on the person list then insert the row into Caretaker list even if the person is under 18
 *  
 * </pre>
 */
public class RetrievePrincipalsImpl extends BaseServiceImpl implements RetrievePrincipals {

  private static final String PRINCIPAL = CodesTables.CPRSNALL_PRN;

  private static final String FOSTER_ADOPTIVE_HOME = CodesTables.CPSNDTCT_FAH;

  private static final String ACTIVE = "A";

  private static final String NO_AP_FAH_FOUND = ArchitectureConstants.N;

  private static final String AP_FAH_FOUND = ArchitectureConstants.Y;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private PersonDAO personDAO = null;

  private AllegationDAO allegationDAO = null;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public CINV36SO retrievePrincipals(CINV36SI cinv36si) throws ServiceException {
    CINV36SO cinv36so = new CINV36SO();

    int idStage = cinv36si.getUlIdStage();
    int numIdPerson = 0;
    // replace CallCINV80D
    ROWCINV36SOG01_ARRAY idPersonArrayList = findIdPersonByIdStageAndCdStagePersType(idStage);
    if (idPersonArrayList.getUlRowQty() > 0) {
      cinv36so.setROWCINV36SOG01_ARRAY(idPersonArrayList);

    } else {
    }
   
    numIdPerson = cinv36so.getROWCINV36SOG01_ARRAY() != null ? cinv36so.getROWCINV36SOG01_ARRAY().getUlRowQty() : 0;
    // replace CallCSES87D
   
    /* int numIdPerson = cinv36so.getLSysNbrRow_ARRAY().getLSysNbrRow(0);
   int i356 = 0;
   for (i356 = 0; i356 < numIdPerson; i356++) {
     int idPerson = cinv36so.getROWCINV36SOG01_ARRAY().getROWCINV36SOG01(i356).getUlIdPerson();
     // cses87d
     long countAllegations = allegationDAO.countAllegationsByPersonStatusCategoryStage(idPerson, ACTIVE,
                                                                                       FOSTER_ADOPTIVE_HOME, idStage);
     if (countAllegations == 0) {
       cinv36so.setBSysIndNoDataFound(NO_AP_FAH_FOUND);
     } else {
       // subcare stage exists, need to alert user so stop search
       cinv36so.setBSysIndNoDataFound(AP_FAH_FOUND);
       i356 = numIdPerson;
     }
   } */

    for (int i352 = 0; i352 < numIdPerson; i352++) {
    // replace CallCINV81D
      // re-declare idPerson serves only purpose to make it easier to see
      // what value idPerson currently holds
      int idPerson = cinv36so.getROWCINV36SOG01_ARRAY().getROWCINV36SOG01(i352).getUlIdPerson();
      StagePersonLink spl  = stagePersonLinkDAO.findStagePersonLinkByIdPersonAndIdStage(idPerson, idStage);
      String szCdStagePersRelInt = "";      
      if(spl != null){
      szCdStagePersRelInt = spl.getCdStagePersRelInt();
      }
      // cinv81d
      Person person = personDAO.findPersonByIdPerson(idPerson);
      if (person == null || person.equals(null)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      // subsequent update to ROWCINV36SOG01_ARRAY
      cinv36so.getROWCINV36SOG01_ARRAY().getROWCINV36SOG01(i352).setSzNmPersonFull(person.getNmPersonFull());
      cinv36so.getROWCINV36SOG01_ARRAY().getROWCINV36SOG01(i352)
              .setDtDtPersonBirth(DateHelper.toCastorDate(person.getDtPersonBirth()));
      cinv36so.getROWCINV36SOG01_ARRAY().getROWCINV36SOG01(i352).setSzCdStagePersRelInt(szCdStagePersRelInt);
    }

    return cinv36so;
  }

  @SuppressWarnings("unchecked")
  public List<Map> retrieveAllPrincipals(int idStage, String type) throws ServiceException {
    List<Map> allPrincipals = new ArrayList<Map>();
    allPrincipals = stagePersonLinkDAO.findAllPrincipalsForStage(PRINCIPAL, idStage);
    return allPrincipals;
  }
  
  @SuppressWarnings("unchecked")
  public List<Map> retrieveAllPrincipalsWithNullInPKHshld(int idStage, String type) {
    List<Map> allPrincipals = new ArrayList<Map>();
    allPrincipals = stagePersonLinkDAO.findAllPrincipalsForStageInPKHshldNull(PRINCIPAL, idStage);
    return allPrincipals;
  }
  
  /*
   * @return: rowcinv36sog01_array containing idPerson value, if no data found
   * UlRowQty = 0
   */
  private ROWCINV36SOG01_ARRAY findIdPersonByIdStageAndCdStagePersType(int idStage) {
    ROWCINV36SOG01_ARRAY rowcinv36sog01_array = new ROWCINV36SOG01_ARRAY();
    // cinv80d
    List<Integer> idPersonList = stagePersonLinkDAO
            .findMbrPkHshldIdPersonFromStagePersonLinkByIdStageAndCdStagePersType(idStage,
                                                                        PRINCIPAL);
    if (idPersonList == null || idPersonList.isEmpty()) {
      rowcinv36sog01_array.setUlRowQty(0);
    } else {
      int count = 0;
      for (Iterator<Integer> it = idPersonList.iterator(); it.hasNext();) {
        ROWCINV36SOG01 rowcinv36sog01 = new ROWCINV36SOG01();
        rowcinv36sog01.setUlIdPerson(it.next());
        rowcinv36sog01_array.addROWCINV36SOG01(rowcinv36sog01);
        count++;
      }
      rowcinv36sog01_array.setUlRowQty(count);
    }
    return rowcinv36sog01_array;
  }

}
