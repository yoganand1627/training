package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FAPersonDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FAPersonDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveFAPersonDetail;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import java.util.*;

/**
 * This service retrieves all information for the FA person detail window
 *
 * @param FAPersonDetailRetrieveSI
 * @return A populated {@link FAPersonDetailRetrieveSO} object.
 * @author lata.p.lokhande
 * 
 */
/**
 * 
 * Change History:
 *  Date       User          Description
 *  ---------- ------------- -----------------------------------------------
 *  02/24/2011 hanguyen      Added Change History.
 *  02/24/2011 hanguyen      SMS#97850: MR-075 Added new fields to retrieve. 
*/

public class RetrieveFAPersonDetailImpl extends BaseServiceImpl implements RetrieveFAPersonDetail {
  private PersonDtlDAO personDtlDAO = null;
  
  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }
  
  public FAPersonDetailRetrieveSO retrieveFAPersonDetail(FAPersonDetailRetrieveSI faPersonDetailRetrieveSI)throws ServiceException {
    //Get person Id from input object
        
    int idPerson = faPersonDetailRetrieveSI.getIdPerson();
    String indAnnualMed = null;
    Date dtMedDue = null;
    Date dtCrimRec = null;
    Date dtLastUpdate = null;
    Date dtLastMedRecCheck = null;
    Date dtLastGcicRecCheck = null;
    Date dtGcicRecCheckDue = null;
    Date dtLastNcicRecCheck = null;
    Date dtNcicRecCheckDue = null;
    
    PersonDtl personDtl = personDtlDAO.findServiceAuthByIdPerson(idPerson);
      
    if(personDtl != null) {
      indAnnualMed = personDtl.getIndAnnualMed();
      dtMedDue = personDtl.getDtMedDue();
      dtCrimRec = personDtl.getDtCrimRec();
      dtLastUpdate = personDtl.getDtLastUpdate();
      dtLastMedRecCheck = personDtl.getDtLastMed();
      dtLastGcicRecCheck = personDtl.getDtLastGcicRc();
      dtGcicRecCheckDue = personDtl.getDtGcicRcDue();
      dtLastNcicRecCheck = personDtl.getDtLastNcicRc();
      dtNcicRecCheckDue = personDtl.getDtNcicRcDue();
      
    }
 
    //Create and populate output object.
    FAPersonDetailRetrieveSO faPersonDetailRetrieveSO = new FAPersonDetailRetrieveSO();
    
    faPersonDetailRetrieveSO.setIdPerson(idPerson);
    faPersonDetailRetrieveSO.setAnnualMedFormRequired(indAnnualMed);
    faPersonDetailRetrieveSO.setMedCheckDueDt(dtMedDue);
    faPersonDetailRetrieveSO.setCriminalRecCheckDueDt(dtCrimRec);
    faPersonDetailRetrieveSO.setDtLastUpdate(dtLastUpdate);
    faPersonDetailRetrieveSO.setDtLastMedRecCheck(dtLastMedRecCheck);
    faPersonDetailRetrieveSO.setDtLastGcicRecCheck(dtLastGcicRecCheck);
    faPersonDetailRetrieveSO.setDtGcicRecCheckDue(dtGcicRecCheckDue);
    faPersonDetailRetrieveSO.setDtLastNcicRecCheck(dtLastNcicRecCheck);
    faPersonDetailRetrieveSO.setDtNcicRecCheckDue(dtNcicRecCheckDue);
    
    return faPersonDetailRetrieveSO;
    
  }
    
 
}