package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaretakerDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCaretaker;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Caretaker;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY;

public class CaretakerImpl extends BaseServiceImpl implements Caretaker {

  private CapsCaretakerDAO capsCaretakerDAO = null;
  private CapsResourceDAO capsResourceDAO = null;

  public void setCapsCaretakerDAO(CapsCaretakerDAO capsCaretakerDAO) {
    this.capsCaretakerDAO = capsCaretakerDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public CRES18SO caretaker(CRES18SI cres18si) throws ServiceException {
    CRES18SO cres18so = new CRES18SO();
    //Must Initialize the OutputStruct using new before setting Data in Line number 86.
    cres18so.setArchOutputStruct(new ArchOutputStruct());
    cres18so.setDtSysDtGenericSysdate(DateHelper.getTodayCastorDate());
    String cReqFuncCd = cres18si.getArchInputStruct().getCReqFuncCd();

    if ("C".equals(cReqFuncCd)) {

      // cres55d
      List<Map> capsCaretakerList = capsCaretakerDAO.findCapsCaretakerByIdResource(cres18si.getUlIdResource());

      if (capsCaretakerList == null || capsCaretakerList.isEmpty()) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }

      ROWCRES55DO_ARRAY rowcres55do_array = new ROWCRES55DO_ARRAY();
      for (Iterator<Map> it = capsCaretakerList.iterator(); it.hasNext();) {
        ROWCRES55DO rowcres55do = new ROWCRES55DO();
        Map capsCaretakerMap = it.next();
        rowcres55do.setIdCaretaker((Integer) capsCaretakerMap.get("idCaretaker") != null ?
                                   (Integer) capsCaretakerMap.get("idCaretaker") : 0);
        rowcres55do.setSzNmCaretkrFname((String) capsCaretakerMap.get("nmCaretkrFname"));
        rowcres55do.setSzNmCaretkrLname((String) capsCaretakerMap.get("nmCaretkrLname"));
        rowcres55do.setSzNmCaretkrMname((String) capsCaretakerMap.get("nmCaretkrMname"));
        rowcres55do.setCdCaretkrEthnic((String) capsCaretakerMap.get("cdCaretkrEthnic"));
        rowcres55do.setCdCaretkrRace((String) capsCaretakerMap.get("cdCaretkrRace"));
        rowcres55do.setCdCaretkrSex((String) capsCaretakerMap.get("cdCaretkrSex"));
        rowcres55do.setDtCaretkrBirth(DateHelper.toCastorDate((Date) capsCaretakerMap.get("dtCaretkrBirth")));
        rowcres55do.setNbrCaretkr((String) capsCaretakerMap.get("nbrCaretkr"));
        rowcres55do.setCd_Home_Marital_Status((String) capsCaretakerMap.get("cdRsrcMaritalStatus"));
        rowcres55do_array.addROWCRES55DO(rowcres55do);
      }
      cres18so.setROWCRES55DO_ARRAY(rowcres55do_array);

    } else if ("S".equals(cReqFuncCd)) {
      // cres57d
      List<Map> capsResourceList = capsResourceDAO.findCapsResourceByIdResource(cres18si.getUlIdResource());
      if (capsResourceList == null) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }

      for (Iterator<Map> it = capsResourceList.iterator(); it.hasNext();) {
        Map capsResourceMap = it.next();
        // AMIT-WARNING:Field is not matching with DAO.
        cres18so.setUlIdResource((Integer) capsResourceMap.get("parentIdResource") != null ?
                                 (Integer) capsResourceMap.get("parentIdResource") : 0);
        cres18so.setUlHmResourceId((Integer) capsResourceMap.get("childIdResource") != null ?
                                   (Integer) capsResourceMap.get("childIdResource") : 0);
        cres18so.setSzCpaName((String) capsResourceMap.get("parentNmResource"));
        cres18so.setSzNmResource((String) capsResourceMap.get("childNmResource"));
        cres18so.setCd_Home_Marital_Status((String) capsResourceMap.get("childCdRsrcMaritalStatus"));
        cres18so.getArchOutputStruct().setUlRowQty(capsResourceList.size());
      }
    } else if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD) ||
               cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE) ||
               cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_DELETE)) {

      // Analyze error code
      if ("1".equals(cres18si.getCIndCaretakerUpd())) {
        if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_DELETE)) {
          // cres58d doesn't handle delete
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
        // cres58d
        if (0 == capsResourceDAO.updateCapsResource(cres18si.getCd_Home_Marital_Status(), cres18si.getUlIdResource())) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      }
      if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
        CapsCaretaker capsCareTaker = new CapsCaretaker();
        CapsResource capsResource = new CapsResource();
        capsResource.setIdResource(cres18si.getUlIdResource());
        capsCareTaker.setCapsResource(capsResource);
        capsCareTaker.setNmCaretkrFname(cres18si.getSzNmCaretkrFname());
        capsCareTaker.setNmCaretkrLname(cres18si.getSzNmCaretkrLname());
        capsCareTaker.setNmCaretkrMname(cres18si.getSzNmCaretkrMname());
        capsCareTaker.setCdCaretkrEthnic(cres18si.getCdCaretkrEthnic());
        capsCareTaker.setCdCaretkrRace(cres18si.getCdCaretkrRace());
        capsCareTaker.setCdCaretkrSex(cres18si.getCdCaretkrSex());
        capsCareTaker.setDtCaretkrBirth(DateHelper.toJavaDate(cres18si.getDtCaretkrBirth()));
        // cres56d
        capsCaretakerDAO.saveCapsCaretaker(capsCareTaker);
      } else if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE)) {
        // cres56d
        if (0 == capsCaretakerDAO.updateCapsCaretaker(cres18si.getIdCaretaker(), cres18si.getSzNmCaretkrFname(),
                                                      cres18si.getSzNmCaretkrMname(), cres18si.getSzNmCaretkrLname(),
                                                      cres18si.getCdCaretkrSex(),
                                                      DateHelper.toJavaDate(cres18si.getDtCaretkrBirth()),
                                                      cres18si.getCdCaretkrEthnic(), cres18si.getCdCaretkrRace())) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } else if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_DELETE)) {
        // cres56d
        if (0 == capsCaretakerDAO.deleteCapsCaretaker(cres18si.getIdCaretaker())) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    return cres18so;
  }
}
