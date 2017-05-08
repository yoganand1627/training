package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrievePhoneListDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN46SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN46SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN46SOG00_ARRAY;

public class RetrievePhoneListDetailImpl extends BaseServiceImpl implements RetrievePhoneListDetail {

  private int PHONE_LIST_SIZE = 50;
  PersonPhoneDAO personPhoneDAO = null;

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public CCMN46SO retrievePhoneListDetail(CCMN46SI ccmn46si) throws ServiceException {
    CCMN46SO ccmn46so = new CCMN46SO();

    List<PersonPhone> personPhoneList = null;
    String bSysIndIntake = ccmn46si.getBSysIndIntake();
    if (ArchitectureConstants.Y.equals(bSysIndIntake)) {
      personPhoneList = personPhoneDAO.findPersonPhoneByIdPersonDtPersonPhone(
              ccmn46si.getUlIdPerson(), ccmn46si.getTsSysTsQuery());
    } else {
      personPhoneList = personPhoneDAO.findPersonPhoneByIdPerson(ccmn46si.getUlIdPerson());
    }
    if (personPhoneList == null) {
      throw new ServiceException(Messages.MSG_ERR_ON_RETURN);
    }

    int cnt = personPhoneList.size();
    ArchOutputStruct archOut = new ArchOutputStruct();
    archOut.setUlRowQty(cnt);

    if (cnt > PHONE_LIST_SIZE) {
      archOut.setBMoreDataInd(ArchitectureConstants.Y);
    } else {
      archOut.setBMoreDataInd(ArchitectureConstants.N);
    }

    ccmn46so.setArchOutputStruct(archOut);
    ROWCCMN46SOG00_ARRAY rowccmn46sogoo_array = new ROWCCMN46SOG00_ARRAY();

    for (Iterator<PersonPhone> it = personPhoneList.iterator(); it.hasNext();) {
      PersonPhone personPhone = it.next();
      ROWCCMN46SOG00 rowccmn46sogoo = new ROWCCMN46SOG00();
      rowccmn46sogoo.setSzCdPhoneType(personPhone.getCdPersonPhoneType());
      rowccmn46sogoo.setLNbrPhone(personPhone.getNbrPersonPhone());
      
      if(personPhone.getNbrPersonPhoneExtension() == null){
        rowccmn46sogoo.setLNbrPhoneExtension(StringHelper.EMPTY_STRING);
      }else{
        rowccmn46sogoo.setLNbrPhoneExtension(personPhone.getNbrPersonPhoneExtension());
      }
      
      rowccmn46sogoo.setDtDtPersonPhoneStart(DateHelper.toCastorDate(personPhone.getDtPersonPhoneStart()));
      rowccmn46sogoo.setDtDtPersonPhoneEnd(DateHelper.toCastorDate(personPhone.getDtPersonPhoneEnd()));
      rowccmn46sogoo.setBIndPersonPhonePrimary(personPhone.getIndPersonPhonePrimary());
      rowccmn46sogoo.setBIndPersonPhoneInvalid(personPhone.getIndPersonPhoneInvalid());
      
      if(personPhone.getTxtPersonPhoneComments() == null){
        rowccmn46sogoo.setSzTxtPhoneComments(StringHelper.EMPTY_STRING);
      }else{
        rowccmn46sogoo.setSzTxtPhoneComments(personPhone.getTxtPersonPhoneComments());
      }
      
      
      rowccmn46sogoo.setUlIdPhone(personPhone.getIdPersonPhone() != null ? personPhone.getIdPersonPhone() : 0);
      rowccmn46sogoo.setTsLastUpdate(personPhone.getDtLastUpdate());
      rowccmn46sogoo_array.addROWCCMN46SOG00(rowccmn46sogoo);
//    used the array length instead of U1RowQty(). need to fix the UlRowQty error--Haritha.
      rowccmn46sogoo_array.setUlRowQty(rowccmn46sogoo_array.getUlRowQty() + 1);

    }
    ccmn46so.setROWCCMN46SOG00_ARRAY(rowccmn46sogoo_array);

    return ccmn46so;

  }

}
