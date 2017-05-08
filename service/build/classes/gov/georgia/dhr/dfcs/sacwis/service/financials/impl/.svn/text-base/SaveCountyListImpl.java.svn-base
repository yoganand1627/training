package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.ContractCounty;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveCountyList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON14SO;

public class SaveCountyListImpl extends BaseServiceImpl implements SaveCountyList {

  private ComplexCapsResourceDAO complexCapsResourceDAO = null;
  private ContractCountyDAO contractCountyDAO = null;

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setComplexCapsResourceDAO(ComplexCapsResourceDAO complexCapsResourceDAO) {
    this.complexCapsResourceDAO = complexCapsResourceDAO;
  }

  public CCON14SO saveCountyList(CCON14SI ccon14si) throws ServiceException {
    CCON14SO ccon14so = new CCON14SO();
    // clsc11d
    List<Map> listMap = findCountyResource(ccon14si);
    if (listMap == null || listMap.isEmpty()) {
      throw new ServiceException(Messages.MSG_CON_NO_COUNTY);
    }
    for (Enumeration rowccon14sigEnum = ccon14si.getROWCCON14SIG_ARRAY().enumerateROWCCON14SIG();
         rowccon14sigEnum.hasMoreElements();) {
      ROWCCON14SIG rowccon14sig = (ROWCCON14SIG) rowccon14sigEnum.nextElement();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(rowccon14sig.getSzCdScrDataAction())) {
        for (Iterator<Map> it = listMap.iterator(); it.hasNext();) {
          Map map = it.next();
          String cdRsrcSvcCnty = (String) map.get("cdRsrcSvcCnty");
          Integer idCncnty = (Integer) map.get("idCncnty");
          if (rowccon14sig.getSzCdCncntyCounty().equals(cdRsrcSvcCnty) && idCncnty != null && idCncnty != 0) {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }
        }
      }
      // caud08d
      saveContractCounty(ccon14si, rowccon14sig);
    }
    return ccon14so;
  }

  private List<Map> findCountyResource(CCON14SI ccon14si) {
    String cdRsrcSvcService = ccon14si.getSzCdRsrcSvcService();
    Date dtCncntyEffective = DateHelper.toJavaDate(ccon14si.getDtDtCncntyEffective());
    Date dtCncntyEnd = DateHelper.toJavaDate(ccon14si.getDtDtCncntyEnd());
    int idContract = ccon14si.getUlIdContract();
    int idResource = ccon14si.getUlIdResource();
    int nbrCncntyLineItem = ccon14si.getUlNbrCncntyLineItem();
    int nbrCncntyPeriod = ccon14si.getUlNbrCncntyPeriod();
    int nbrCncntyVersion = ccon14si.getUlNbrCncntyVersion();
    // Calling clsc11d.pc
    return complexCapsResourceDAO.findCountyResource(idContract, cdRsrcSvcService, nbrCncntyPeriod, nbrCncntyVersion,
                                                     nbrCncntyLineItem, idResource, dtCncntyEffective, dtCncntyEnd);
  }

  private void saveContractCounty(CCON14SI ccon14si, ROWCCON14SIG rowccon14sig) throws ServiceException {
    String cReqFuncCd = rowccon14sig.getSzCdScrDataAction();
    ContractCounty contractCounty = null; //new ContractCounty();
    //contractCounty.setIdCncnty(rowccon14sig.getUlIdCncnty());
    //contractCounty.setDtLastUpdate(rowccon14sig.getTsLastUpdate());
    boolean add = ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd);
    if (add || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      if(add) {
        contractCounty = new ContractCounty();
      } else {
        contractCounty = getPersistentObject(ContractCounty.class, rowccon14sig.getUlIdCncnty());
      }
      contractCounty.setCdCncntyCounty(rowccon14sig.getSzCdCncntyCounty());
      contractCounty.setCdCncntyService(ccon14si.getSzCdRsrcSvcService());
      contractCounty.setDtCncntyEffective(DateHelper.toJavaDate(ccon14si.getDtDtCncntyEffective()));
      contractCounty.setDtCncntyEnd(DateHelper.toJavaDate(ccon14si.getDtDtCncntyEnd()));
      CapsResource capsResource = getPersistentObject(CapsResource.class, ccon14si.getUlIdResource());
      //capsResource.setIdResource(ccon14si.getUlIdResource());
      contractCounty.setCapsResource(capsResource);
      Contract contract = getPersistentObject(Contract.class, ccon14si.getUlIdContract());
      //contract.setIdContract(ccon14si.getUlIdContract());
      contractCounty.setContract(contract);
      contractCounty.setNbrCncntyLineItem(ccon14si.getUlNbrCncntyLineItem());
      contractCounty.setNbrCncntyPeriod(ccon14si.getUlNbrCncntyPeriod());
      contractCounty.setNbrCncntyVersion(ccon14si.getUlNbrCncntyVersion());
      Person person = getPersistentObject(Person.class, ccon14si.getUlIdCntrctWkr());
      //person.setIdPerson(ccon14si.getUlIdCntrctWkr());
      contractCounty.setPerson(person);
      // Calling caud08d
      contractCountyDAO.saveContractCounty(contractCounty);
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // Calling caud08d
      contractCounty = getPersistentObject(ContractCounty.class, rowccon14sig.getUlIdCncnty());
      contractCountyDAO.deleteContractCounty(contractCounty);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
  }
}
