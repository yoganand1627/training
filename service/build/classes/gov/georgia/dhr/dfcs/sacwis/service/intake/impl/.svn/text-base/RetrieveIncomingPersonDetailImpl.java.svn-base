package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingPersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingAddress;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingName;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingPerson;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingPersonId;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingPhone;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveIncomingPersonDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY;

public class RetrieveIncomingPersonDetailImpl extends BaseServiceImpl implements RetrieveIncomingPersonDetail {

  private IncomingAddressDAO incomingAddressDAO = null;
  private IncomingNameDAO incomingNameDAO = null;
  private IncomingPersonDAO incomingPersonDAO = null;
  private IncomingPersonIdDAO incomingPersonIdDAO = null;
  private IncomingPhoneDAO incomingPhoneDAO = null;

  public void setIncomingAddressDAO(IncomingAddressDAO incomingAddressDAO) {
    this.incomingAddressDAO = incomingAddressDAO;
  }

  public void setIncomingNameDAO(IncomingNameDAO incomingNameDAO) {
    this.incomingNameDAO = incomingNameDAO;
  }

  public void setIncomingPersonDAO(IncomingPersonDAO incomingPersonDAO) {
    this.incomingPersonDAO = incomingPersonDAO;
  }

  public void setIncomingPersonIdDAO(IncomingPersonIdDAO incomingPersonIdDAO) {
    this.incomingPersonIdDAO = incomingPersonIdDAO;
  }

  public void setIncomingPhoneDAO(IncomingPhoneDAO incomingPhoneDAO) {
    this.incomingPhoneDAO = incomingPhoneDAO;
  }

  public CINT34SO retrieveIncomingPersonDetail(CINT34SI cint34si) throws ServiceException {
    CINT34SO cint34so = new CINT34SO();
    // cint51d
    cint34so.setROWCINT51DO(findIncomingPerson(cint34si.getUlIdPerson(), cint34si.getUlIdStage()));

    // We need the idIncmgPerson that was retrieved by tha call above.
    int idIncmgPerson = cint34so.getROWCINT51DO().getUlIdIncmgPerson();

    // cint48d
    cint34so.setROWCINT48DO_ARRAY(findIncomingAddresses(idIncmgPerson));

    // cint49d
    cint34so.setROWCINT49DO_ARRAY(findIncomingNames(idIncmgPerson));

    // cint50d
    cint34so.setROWCINT50DO_ARRAY(findIncomingPersonIds(idIncmgPerson));

    // cint52d
    cint34so.setROWCINT52DO_ARRAY(findIncomingPhones(idIncmgPerson));
    return cint34so;
  }

  private ROWCINT51DO findIncomingPerson(int idPerson, int idStage) throws ServiceException {
    // cint51d
    IncomingPerson incp = incomingPersonDAO.findIncomingPersonByIdPersonAndIdStage(idPerson, idStage);

    if (incp == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    ROWCINT51DO rowcint51do = new ROWCINT51DO();
    Integer persAge = incp.getNbrIncmgPersAge();

    rowcint51do.setUlIdPerson(incp.getPerson().getIdPerson() != null ? incp.getPerson().getIdPerson() : 0);
    rowcint51do.setUlIdStage(incp.getStage().getIdStage() != null ? incp.getStage().getIdStage() : 0);
    rowcint51do.setUlIdIncmgPerson(incp.getIdIncmgPerson() != null ? incp.getIdIncmgPerson() : 0);
    rowcint51do.setUsNbrIncmgPersAge(persAge != null ? persAge : 0);
    rowcint51do.setCIndPersonDobApprox(incp.getIndIncmgPersDobApprox());

    rowcint51do.setDtDtIncmgPersDeath(DateHelper.toCastorDate(incp.getDtIncmgPersDeath()));
    rowcint51do.setDtDtIncmgPersBirth(DateHelper.toCastorDate(incp.getDtIncmgPersBirth()));
    rowcint51do.setSzCdIncmgPersDeath(incp.getCdIncmgPersDeath());
    rowcint51do.setSzCdIncmgPersMaritlStat(incp.getCdIncmgPersMaritlStat());
    rowcint51do.setSzCdIncmgPersLanguage(incp.getCdIncmgPersLanguage());

    rowcint51do.setSzCdIncmgPersSex(incp.getCdIncmgPersSex());
    rowcint51do.setSzNmIncmgPersFull(incp.getNmIncmgPersFull());
    rowcint51do.setSzCdIncmgPersEthnic(incp.getCdIncmgPersEthnic());
    return rowcint51do;
  }

  private ROWCINT48DO_ARRAY findIncomingAddresses(int idIncmgPerson) {
    // cint48d
    List<IncomingAddress> listincadd =
            incomingAddressDAO.findIncomingAddressByIdIncmgPersonAndOrderByDtIncmgAddrEnd(idIncmgPerson);
    ROWCINT48DO_ARRAY rowcint48do_array = new ROWCINT48DO_ARRAY();
    if (listincadd == null) {
      // SQL_NOT_FOUND is not an error; just return an empty structure.
      return rowcint48do_array;
    }
    for (Iterator<IncomingAddress> it = listincadd.iterator(); it.hasNext();) {
      IncomingAddress incadd = it.next();
      ROWCINT48DO row = new ROWCINT48DO();
      row.setCIndIncmgAddrInvalid(incadd.getIndIncmgAddrInvalid());
      row.setCIndIncmgAddrPrimary(incadd.getIndIncmgAddrPrimary());
      row.setDtDtIncmgAddrEnd(DateHelper.toCastorDate(incadd.getDtIncmgAddrEnd()));
      row.setDtDtIncmgAddrStart(DateHelper.toCastorDate(incadd.getDtIncmgAddrStart()));
      row.setSzAddrIncmgAddrAttn(incadd.getAddrIncmgAddrAttn());
      row.setSzAddrIncmgAddrCity(incadd.getAddrIncmgAddrCity());
      row.setSzAddrIncmgAddrStLn1(incadd.getAddrIncmgAddrStLn1());
      row.setSzAddrIncmgAddrStLn2(incadd.getAddrIncmgAddrStLn2());
      row.setSzAddrIncmgAddrZip(incadd.getAddrIncmgAddrZip());
      row.setSzCdIncmgAddrCounty(incadd.getCdIncmgAddrCounty());
      row.setSzCdIncmgAddrState(incadd.getCdIncmgAddrState());
      row.setSzCdIncmgAddrType(incadd.getCdIncmgAddrType());
      row.setSzTxtIncmgAddrComments(incadd.getTxtIncmgAddrComments());
      row.setUlIdIncmgPerson(incadd.getIncomingPerson().getIdIncmgPerson() != null ?
                             incadd.getIncomingPerson().getIdIncmgPerson() : 0);
      row.setUlIdIncomingAddress(incadd.getIdIncomingAddress() != null ? incadd.getIdIncomingAddress() : 0);
      rowcint48do_array.addROWCINT48DO(row);
    }
    return rowcint48do_array;
  }

  private ROWCINT49DO_ARRAY findIncomingNames(int idIncmgPerson) {
    // cint49d
    List<IncomingName> listincnm =
            incomingNameDAO.findIncomingNameByIdIncmgPersonAndOrderByDtIncmgNameEnd(idIncmgPerson);
    ROWCINT49DO_ARRAY rowcint49do_array = new ROWCINT49DO_ARRAY();
    if (listincnm == null) {
      // SQL_NOT_FOUND is not an error; just return an empty structure.
      return rowcint49do_array;
    }
    for (Iterator<IncomingName> it = listincnm.iterator(); it.hasNext();) {
      IncomingName incnm = it.next();
      ROWCINT49DO row = new ROWCINT49DO();
      row.setCIndIncmgNameInvalid(incnm.getIndIncmgNameInvalid());
      row.setCIndIncmgNamePrimary(incnm.getIndIncmgNamePrimary());
      row.setDtDtIncmgNameEnd(DateHelper.toCastorDate(incnm.getDtIncmgNameEnd()));
      row.setDtDtIncmgNameStart(DateHelper.toCastorDate(incnm.getDtIncmgNameStart()));
      row.setSzCdIncmgNameSuffix(incnm.getCdIncmgNameSuffix());
      row.setSzNmIncmgNameFirst(incnm.getNmIncmgNameFirst());
      row.setSzNmIncmgNameLast(incnm.getNmIncmgNameLast());
      row.setSzNmIncmgNameMiddle(incnm.getNmIncmgNameMiddle());
      row.setUlIdIncmgPerson(
              incnm.getIncomingPerson().getIdIncmgPerson() != null ? incnm.getIncomingPerson().getIdIncmgPerson() : 0);
      row.setUlIdIncomingName(incnm.getIdIncomingName() != null ? incnm.getIdIncomingName() : 0);
      rowcint49do_array.addROWCINT49DO(row);
    }
    return rowcint49do_array;
  }

  private ROWCINT50DO_ARRAY findIncomingPersonIds(int idIncmgPerson) {
    // cint50d
    List<IncomingPersonId> listinc = incomingPersonIdDAO.findIncomingPersonIdByIdIncmgPerson(idIncmgPerson);
    ROWCINT50DO_ARRAY rowcint50do_array = new ROWCINT50DO_ARRAY();
    if (listinc == null) {
      // SQL_NOT_FOUND is not an error; just return an empty structure.
      return rowcint50do_array;
    }
    for (Iterator<IncomingPersonId> it = listinc.iterator(); it.hasNext();) {
      IncomingPersonId inc = it.next();
      ROWCINT50DO row = new ROWCINT50DO();
      row.setCIndIncmgPersonIDInv(inc.getIndIncmgPersonIdInv());
      row.setDtDtIncmgPersIdStart(DateHelper.toCastorDate(inc.getDtIncmgPersIdStart()));
      row.setSzCdIncmgPersIdType(inc.getCdIncmgPersIdType());
      row.setSzDescIncmgPersonID(inc.getDescIncmgPersonId());
      row.setSzNbrIncmgPersIdNumber(inc.getNbrIncmgPersIdNumber());
      row.setUlIdIncmgPerson(
              inc.getIncomingPerson().getIdIncmgPerson() != null ? inc.getIncomingPerson().getIdIncmgPerson() : 0);
      row.setUlIdIncmgPersonId(inc.getIdIncomingPersonId() != null ? inc.getIdIncomingPersonId() : 0);
      rowcint50do_array.addROWCINT50DO(row);
    }
    return rowcint50do_array;
  }

  // CallCINT52D
  private ROWCINT52DO_ARRAY findIncomingPhones(int idIncmgPerson) {
    // cint52d
    List<IncomingPhone> listinc =
            incomingPhoneDAO.findIncomingPhoneByIdIncmgPersonAndOrderByDtIncmgPhoneEnd(idIncmgPerson);
    ROWCINT52DO_ARRAY row_array = new ROWCINT52DO_ARRAY();
    if (listinc == null) {
      // SQL_NOT_FOUND is not an error; just return an empty structure.
      return row_array;
    }
    for (Iterator<IncomingPhone> it = listinc.iterator(); it.hasNext();) {
      IncomingPhone inc = it.next();
      ROWCINT52DO row = new ROWCINT52DO();
      row.setCIndIncmgPhoneInvalid(inc.getIndIncmgPhoneInvalid());
      row.setCIndIncmgPhonePrimary(inc.getIndIncmgPhonePrimary());
      row.setDtDtIncmgPhoneEnd(DateHelper.toCastorDate(inc.getDtIncmgPhoneEnd()));
      row.setDtDtIncmgPhoneStart(DateHelper.toCastorDate(inc.getDtIncmgPhoneStart()));
      row.setSzCdIncmgPhoneType(inc.getCdIncmgPhoneType());
      row.setSzNbrIncmgPhone(inc.getNbrIncmgPhone());
      row.setSzNbrIncmgPhoneExtension(inc.getNbrIncmgPhoneExtension());
      row.setSzTxtIncmgPhoneComments(inc.getTxtIncmgPhoneComments());
      row.setUlIdIncmgPerson(
              inc.getIncomingPerson().getIdIncmgPerson() != null ? inc.getIncomingPerson().getIdIncmgPerson() : 0);
      row.setUlIdIncomingPhone(inc.getIdIncomingPhone() != null ? inc.getIdIncomingPhone() : 0);
      row_array.addROWCINT52DO(row);
    }
    return row_array;
  }
}
