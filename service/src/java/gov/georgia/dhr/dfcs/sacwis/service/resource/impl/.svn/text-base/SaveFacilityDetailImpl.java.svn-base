package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FacilityLocDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PgmLcnsreTypsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecSvcsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.PgmLcnsreTyps;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.SaveFacilityDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SelectedLicensureTypesArrayIn;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES10SO;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class SaveFacilityDetailImpl extends BaseServiceImpl implements SaveFacilityDetail {

  private CapsResourceDAO capsResourceDAO = null;
  @SuppressWarnings("unused")
  private SpecSvcsDAO specSvcsDAO = null;
  private FacilityLocDAO facilityLocDAO = null;
  private PgmLcnsreTypsDAO pgmLcnsreTypsDAO = null;

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setSpecSvcsDAO(SpecSvcsDAO specSvcsDAO) {
    this.specSvcsDAO = specSvcsDAO;
  }

  public void setFacilityLocDAO(FacilityLocDAO facilityLocDAO) {
    this.facilityLocDAO = facilityLocDAO;
  }

  public void setPgmLcnsreTypsDAO(PgmLcnsreTypsDAO pgmLcnsreTypsDAO) {
    this.pgmLcnsreTypsDAO = pgmLcnsreTypsDAO;
  }

  public CRES10SO saveFacilityDetail(CRES10SI cres10si) throws ServiceException {

    CRES10SO cres10so = new CRES10SO();
    //update the resource table
    updateCapsResource(cres10si);
    //update facility level of care information
    updateFacilityLoc(cres10si);

    //  Now update the ProgramLicensureTypes.
    List<String> selLicensureTypesList = new ArrayList<String>();
    SelectedLicensureTypesArrayIn selectedLicensureTypesArray = cres10si.getSelectedLicensureTypesArrayIn();
    if (selectedLicensureTypesArray != null) {
      for (Iterator it = selectedLicensureTypesArray.iterateSzPrgmLicensureType(); it.hasNext();) {
        String pgmLcnsreType = (String) it.next();
        selLicensureTypesList.add(pgmLcnsreType);
      }
    }

    // first delete all the rows for the floc id.
    //if(cres10si.getCRES10SIG01_ARRAY() != null && cres10si.getCRES10SIG01_ARRAY().getCRES10SIG01Count() > 0){
      //CRES10SIG01 cres10sig01 = cres10si.getCRES10SIG01_ARRAY().getCRES10SIG01(0);
    //delete licensure types. This handles scenarios in which the licensure types were unchecked
    //on the placement provider page
    pgmLcnsreTypsDAO.deletePgmLcnsreTypsByIdResource(cres10si.getUlIdResource());
    if(!selLicensureTypesList.isEmpty()){      
      CapsResource capsResource = getPersistentObject(CapsResource.class, cres10si.getUlIdResource());
      Iterator iter = selLicensureTypesList.iterator();
      while (iter.hasNext()) {
        String programLicensureType = (String) iter.next();
        PgmLcnsreTyps pgmLcnsreTyps = new PgmLcnsreTyps();
        pgmLcnsreTyps.setCdPgmType(programLicensureType);        
        pgmLcnsreTyps.setCapsResource(capsResource);
        pgmLcnsreTypsDAO.savePgmLcnsreTyps(pgmLcnsreTyps);
      }
    }

    return cres10so;
  }

  //static int CallCRES17D(CRES10SI pxInputMsg821, CRES10SO pOutputMsg768, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
  private void updateCapsResource(CRES10SI cres10si) throws ServiceException {

//  rc = cres17dAUDdam(sqlca, pCRES17DInputRec, pCRES17DOutputRec);
    int numRows = capsResourceDAO.updateCapsResource(cres10si.getSzCdRsrcCertBy(),
                                                     cres10si.getTxtSpecCert(),
                                                     cres10si.getSzCdRsrcOperBy(),
                                                     cres10si.getSzCdRsrcSetting(),
                                                     cres10si.getSzCdRsrcPayment(),
                                                     DateHelper.toJavaDate(cres10si.getDtDtRsrcCert()),
                                                     DateHelper.toJavaDate(cres10si.getDtDtRsrcClose()),
                                                     cres10si.getUNbrRsrcFacilCapacity(),
                                                     cres10si.getBIndAvailableAfterHrs(),
                                                     cres10si.getSzNmRsrcLastUpdate(),
                                                     cres10si.getUlIdResource(),
                                                     cres10si.getTsLastUpdate());
    if (numRows == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
  }

  //static int CallCRES18D(CRES10SI pInputMsg822, CRES10SO pOutputMsg769, Arcxmlerrors.TUX_DECL_STATUSPARMS) {      
//  private void updateSpecSvcs(CRES10SI cres10si) throws ServiceException {
//
//    SpecSvcs specSvcs = new SpecSvcs();
//    CapsResource capsResource = new CapsResource();
//
//    for (Enumeration rowcres10sig00Enum = cres10si.getCRES10SIG00_ARRAY().enumerateCRES10SIG00();
//         rowcres10sig00Enum.hasMoreElements();) {
//      CRES10SIG00 rowcres10sig00 = (CRES10SIG00) rowcres10sig00Enum.nextElement();
//      String reqFuncCd = rowcres10sig00.getSzCdScrDataAction();
//      int idSpecSvc = rowcres10sig00.getUlIdSpecSvc();
//      int idSpecSvcRsrc = rowcres10sig00.getUlIdSpecSvcRsrc();
//      String cdSpecSvcs = rowcres10sig00.getSzCdSpecSvcs();
//      Date dtLastUpdate = rowcres10sig00.getTsLastUpdate();
//
//      capsResource.setIdResource(idSpecSvcRsrc);
//      specSvcs.setCapsResource(capsResource);
//      specSvcs.setIdSpecSvc(idSpecSvc);
//      specSvcs.setCdSpecSvcs(cdSpecSvcs);
//      specSvcs.setDtLastUpdate(dtLastUpdate);
//
////    rc = cres18dAUDdam(sqlca, pCRES18DInputRec, pCRES18DOutputRec);
//      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
//        if (0 == specSvcsDAO.insertSpecSvc(idSpecSvcRsrc, cdSpecSvcs)) {
//
//          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
//        }
//      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {
//
//        specSvcsDAO.deleteSpecSvcs(specSvcs);
//      } else {
//        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
//      }
//    }
//  }

  //static int CallCRES19D(CRES10SI pInputMsg823, CRES10SO pOutputMsg770) { // , Arcxmlerrors.TUX_DECL_STATUSPARMS) {

  private void updateFacilityLoc(CRES10SI cres10si) throws ServiceException {

    for (Enumeration rowcres10sig01Enum = cres10si.getCRES10SIG01_ARRAY().enumerateCRES10SIG01();
         rowcres10sig01Enum.hasMoreElements();) {
      CRES10SIG01 rowcres10sig01 = (CRES10SIG01) rowcres10sig01Enum.nextElement();
      String reqFuncCd = rowcres10sig01.getSzCdScrDataAction();
//    rc = cres19dAUDdam(sqlca, pCRES19DInputRec, pCRES19DOutputRec);

      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
        if (0 == facilityLocDAO.insertFacilityLoc(rowcres10sig01.getUlIdResource(),
                                                  DateHelper.toJavaDate(rowcres10sig01.getDtDtFlocEffect()),
                                                  DateHelper.toJavaDate(rowcres10sig01.getDtDtFlocEnd()),
                                                  rowcres10sig01.getSNbrFlocLevelsOfCare(),
                                                  rowcres10sig01.getCCdFlocStatus1(),
                                                  rowcres10sig01.getCCdFlocStatus2(),
                                                  rowcres10sig01.getCCdFlocStatus3(),
                                                  rowcres10sig01.getCCdFlocStatus4(),
                                                  rowcres10sig01.getCCdFlocStatus5(),
                                                  rowcres10sig01.getCCdFlocStatus6(),
                                                  rowcres10sig01.getCCdFlocStatus7(),
                                                  rowcres10sig01.getCCdFlocStatus8(),
                                                  rowcres10sig01.getCCdFlocStatus9(),
                                                  rowcres10sig01.getCCdFlocStatus10(),
                                                  rowcres10sig01.getCCdFlocStatus11(),
                                                  rowcres10sig01.getCCdFlocStatus12(),
                                                  rowcres10sig01.getCCdFlocStatus13(),
                                                  rowcres10sig01.getCCdFlocStatus14(),
                                                  rowcres10sig01.getCCdFlocStatus15())) {

          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {
        if (0 == facilityLocDAO.updateFacilityLoc(DateHelper.toJavaDate(rowcres10sig01.getDtDtFlocEnd()),
                                                  rowcres10sig01.getCCdFlocStatus1(),
                                                  rowcres10sig01.getCCdFlocStatus2(),
                                                  rowcres10sig01.getCCdFlocStatus3(),
                                                  rowcres10sig01.getCCdFlocStatus4(),
                                                  rowcres10sig01.getCCdFlocStatus5(),
                                                  rowcres10sig01.getCCdFlocStatus6(),
                                                  rowcres10sig01.getCCdFlocStatus7(),
                                                  rowcres10sig01.getCCdFlocStatus8(),
                                                  rowcres10sig01.getCCdFlocStatus9(),
                                                  rowcres10sig01.getCCdFlocStatus10(),
                                                  rowcres10sig01.getCCdFlocStatus11(),
                                                  rowcres10sig01.getCCdFlocStatus12(),
                                                  rowcres10sig01.getCCdFlocStatus13(),
                                                  rowcres10sig01.getCCdFlocStatus14(),
                                                  rowcres10sig01.getCCdFlocStatus15(),
                                                  rowcres10sig01.getUlIdFloc(),
                                                  rowcres10sig01.getTsLastUpdate())) {

          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
  }

}
