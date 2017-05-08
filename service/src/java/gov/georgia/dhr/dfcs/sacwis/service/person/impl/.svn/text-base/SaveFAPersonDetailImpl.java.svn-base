package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FAPersonDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FAPersonDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveFAPersonDetail;

import java.util.*;

/**
 * This service saves all information for the FA person detail window
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
 *  02/24/2011 hanguyen      SMS#97850: MR-075 Removed date fields not need saving. 
*/

public class SaveFAPersonDetailImpl extends BaseServiceImpl implements SaveFAPersonDetail {
  private PersonDtlDAO personDtlDAO = null;

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  public FAPersonDetailSaveSO saveFAPersonDetail(FAPersonDetailSaveSI faPersonDetailSaveSI) throws ServiceException {

    //Get person Id & other field values from input object

    int idPerson = faPersonDetailSaveSI.getIdPerson();
    String medExmFromReq = faPersonDetailSaveSI.getAnnualMedFormRequired();
    Date dtLastUpdate = faPersonDetailSaveSI.getDtLastUpdate();

    FAPersonDetailSaveSO faPersonDetailSaveSO = new FAPersonDetailSaveSO();

    faPersonDetailSaveSO.setAnnualMedFormRequired(medExmFromReq);
    faPersonDetailSaveSO.setIdPerson(idPerson);

    //  create personDtl object and populate the values.
    PersonDtl personDtl = null;
    Person person = null;
    
    person = getPersistentObject(Person.class, idPerson);
    if(person == null) {
      person = new Person();
      person.setIdPerson(idPerson);
    }
    
    personDtl = personDtlDAO.findServiceAuthByIdPerson(idPerson);
    
    if (personDtl == null) {
      personDtl = new PersonDtl();
      
    }
    personDtl.setPerson(person);
    personDtl.setIndAnnualMed(medExmFromReq);
    personDtl.setDtLastUpdate(dtLastUpdate);

    personDtlDAO.savePersonDtl(personDtl);

    return faPersonDetailSaveSO;

  }
}
