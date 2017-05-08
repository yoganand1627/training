package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ProfessionalAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.db.ProfessionalAssmt;
import gov.georgia.dhr.dfcs.sacwis.service.common.SyncFaPersonDetailHealthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

/**
 * @author Hai Nguyen
 * 
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------
 *   02/24/2011   hnguyen                  Initial Creation
 *   02/24/2011   hnguyen                  SMS#97850: MR-075 Added initial business logic for doing the sync.
 *   03/27/2011   hnguyen                  SMS#97850: MR-075 Updated business logic for doing the sync.
 *   03/28/2011   hnguyen                  SMS#97850: MR-075 Populated previous medical check date 
 *                                         regardless if annual medical checkbox is selected.
 *   04/01/2011   hnguyen                  SMS#103958: MR-075 Populated previous medical check date with latest
 *                                         Physical Exam completed with no due date if annual medical check is
 *                                         not selected. If selected then previous medical is the latest Physical
 *                                         Exam or Health Statement completed and due date calculated 1 year 
 *                                         from previous medical.
 *   04/27/2011   hnguyen                  SMS#103958: MR-075 Populated last medical check date with latest
 *                                         Physical Exam or Health Statement regardless if annual medical
 *                                         checkbox is selected.
 *   
 * </pre>
 * 
 */

public class SyncFaPersonDetailHealthDetailImpl extends BaseServiceImpl implements SyncFaPersonDetailHealthDetail {
  private CapsResourceDAO capsResourceDAO = null;

  private PersonDtlDAO personDtlDAO = null;
  
  private ProfessionalAssmtDAO professionalAssmtDAO = null;

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  public void setProfessionalAssmtDAO(ProfessionalAssmtDAO professionalAssmtDAO) {
    this.professionalAssmtDAO = professionalAssmtDAO;
  }
  
  public void syncFaPersonDetailHealthDetail(int idPerson) {
    PersonDtl personDtl = getPersistentObject(PersonDtl.class, idPerson);
    ProfessionalAssmt healthDtl = null;
    Date dtLastMed = null;
    Date dtMedDue = null;
    
    if (personDtl == null || idPerson == 0){
      // this should never happen, but just in case
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
  
    // Sync health detail    
    // depending on FA Person Detail Annual Medical Examination Form Required checkbox
    // get last Health Statement or Physical Exam if checkbox was selected.
    // Set to only latest Physical if checkbox is not checked.
    List<String> cdProfAssmtApptRsns = new ArrayList<String>();
    cdProfAssmtApptRsns.add(CodesTables.CARSAPPT_HST);
    cdProfAssmtApptRsns.add(CodesTables.CARSAPPT_PYL);
    
    healthDtl = professionalAssmtDAO.findProfessionalAssmtByIdPersonByCdProfAssmtApptRsns(idPerson, cdProfAssmtApptRsns);
    
    if( healthDtl != null ){
      dtLastMed = healthDtl.getDtProfAssmtAppt();
      // Only calculate due date if annual medical checkbox is selected
      if( StringHelper.toBooleanSafe(personDtl.getIndAnnualMed()) && dtLastMed != null ){
        // next health statement or physical exam is due 1 year from last.
        dtMedDue = DateHelper.addToDate(healthDtl.getDtProfAssmtAppt(), 1, 0, 0);
      }
    }

    // month and day value is to be retrieved from home information page Approval End Date field.
    if( dtMedDue != null ){
      CapsResource capsResource = null;
      // get person stage person link to get the stage id.
      capsResource = capsResourceDAO.findCapsResourceByIdResourceHhMemberPerson(idPerson);
      if(capsResource != null){
        Calendar calMedDue = Calendar.getInstance();
        Calendar calDtLicEnd = Calendar.getInstance();
        
        calMedDue.setTime(dtMedDue);
        calDtLicEnd.setTime(capsResource.getDtLicEnd());
        
        //  set month and day due from earliest month/day from FAD(s) Approval End date
        calMedDue.set(Calendar.MONTH, calDtLicEnd.get(Calendar.MONTH));
        calMedDue.set(Calendar.DAY_OF_MONTH, calDtLicEnd.get(Calendar.DAY_OF_MONTH));
        
        // reference new Date
        dtMedDue = calMedDue.getTime();
      }else{
        // No Approval End from Home Information then set due date to null.
        dtMedDue = null;
      }
    }
    
    personDtl.setDtLastMed(dtLastMed);
    personDtl.setDtMedDue(dtMedDue);
    
    personDtlDAO.savePersonDtl(personDtl);
  }
   
}