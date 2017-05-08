package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveRaceAndEthnicity;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN95SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN95SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN95SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN95SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN95SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN95SOG01_ARRAY;
/**
 * Retrieve Race & Ethnicity for a person
 * 
 * <PRE>
 * 
 * Date        Updated by                Description
 * ---------   ------------              -------------------------------------
 * swroberts   10/1/2008                 STGAP00010369: Updated service to set the Row Qty
 *                                       correctly.  It was previously being ignored.  This was a necessary
 *                                       change for the Non-Incident AFCARS Info page.
 * </PRE>
 */
public class RetrieveRaceAndEthnicityImpl extends BaseServiceImpl implements RetrieveRaceAndEthnicity {

  PersonRaceDAO personRaceDAO = null;
  PersonEthnicityDAO personEthnicityDAO = null;

  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public CCMN95SO findPersonRaceAndPersonEthnicity(CCMN95SI ccmn95si) throws ServiceException {
    CCMN95SO ccmn95so = new CCMN95SO();
    //Calling DAO   CLSS79D
    ROWCCMN95SOG00_ARRAY rowccmn95sogoo_array = new ROWCCMN95SOG00_ARRAY();
    List<PersonRace> listPersonRace = personRaceDAO.findPersonRaceByIdPerson(ccmn95si.getUlIdPerson());
    if (listPersonRace != null) {
      for (Iterator<PersonRace> it = listPersonRace.iterator(); it.hasNext();) {
        ROWCCMN95SOG00 rowccmn95sogoo = new ROWCCMN95SOG00();
        PersonRace personRace = it.next();
        rowccmn95sogoo.setSzCdPersonRace(personRace.getCdRace());
        rowccmn95sogoo_array.addROWCCMN95SOG00(rowccmn95sogoo);
        //STGAP00010369 - Set row qty
        rowccmn95sogoo_array.setUlRowQty(rowccmn95sogoo_array.getUlRowQty() + 1);
      }
    }
    ccmn95so.setROWCCMN95SOG00_ARRAY(rowccmn95sogoo_array);
    // Calling DAO CLSS80D
    ROWCCMN95SOG01_ARRAY rowccmn95sogo1_array = new ROWCCMN95SOG01_ARRAY();
    List<PersonEthnicity> listPersonEthnicity =
            personEthnicityDAO.findPersonEthnicityByIdPerson(ccmn95si.getUlIdPerson());
    if (listPersonEthnicity != null) {
      for (Iterator<PersonEthnicity> it = listPersonEthnicity.iterator(); it.hasNext();) {
        ROWCCMN95SOG01 rowccmn95sogo1 = new ROWCCMN95SOG01();
        PersonEthnicity personEthnicity = it.next();
        rowccmn95sogo1.setSzCdPersonEthnicity(personEthnicity.getCdEthnicity());
        rowccmn95sogo1_array.addROWCCMN95SOG01(rowccmn95sogo1);
        //STGAP00010369 - Set row qty
        rowccmn95sogo1_array.setUlRowQty(rowccmn95sogo1_array.getUlRowQty() + 1);
      }
    }
    ccmn95so.setROWCCMN95SOG01_ARRAY(rowccmn95sogo1_array);
    return ccmn95so;
  }
}
