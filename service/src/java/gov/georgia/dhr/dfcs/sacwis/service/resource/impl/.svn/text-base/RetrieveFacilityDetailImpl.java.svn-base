package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FacilityLocDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PgmLcnsreTypsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecSvcsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.FacilityLoc;
import gov.georgia.dhr.dfcs.sacwis.db.PgmLcnsreTyps;
import gov.georgia.dhr.dfcs.sacwis.db.SpecSvcs;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveFacilityDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SelectedLicensureTypesArray;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class RetrieveFacilityDetailImpl extends BaseServiceImpl implements RetrieveFacilityDetail {

  private CapsResourceDAO capsResourceDAO = null;

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

  public CRES09SO retrieveFacilityDetail(CRES09SI cres09si) throws ServiceException {

    CRES09SO cres09so = new CRES09SO();

    int idResource = cres09si.getUlIdResource();
    cres09so = findCapsResource(idResource, cres09so);

    ROWCRES06DO_ARRAY rowcres06do_array = findSpecSvcs(idResource);
    cres09so.setROWCRES06DO_ARRAY(rowcres06do_array);

    ROWCRES07DO_ARRAY rowcres07do_array = findFacilityLoc(idResource);
    cres09so.setROWCRES07DO_ARRAY(rowcres07do_array);

    ROWCRES07DO rowcres07do = null;
    if (rowcres07do_array != null) {
      Enumeration tempEnum = rowcres07do_array.enumerateROWCRES07DO();
      if (tempEnum.hasMoreElements()) {
        rowcres07do = rowcres07do_array.getROWCRES07DO(0);
      }
    }
    
      List<PgmLcnsreTyps> selectedProgramLicensureTypesList = pgmLcnsreTypsDAO.findPgmLcnsreTypsByIdResource(idResource);
      if (selectedProgramLicensureTypesList != null && !selectedProgramLicensureTypesList.isEmpty()) {
        SelectedLicensureTypesArray selectedLicensureTypesArray = new SelectedLicensureTypesArray();
        if (selectedProgramLicensureTypesList != null) {
          for (Iterator<PgmLcnsreTyps> it = selectedProgramLicensureTypesList.iterator(); it.hasNext();) {
            PgmLcnsreTyps pgmLcnsreTyps = it.next();
            selectedLicensureTypesArray.addSzPrgmLicensureType(pgmLcnsreTyps.getCdPgmType());
          }
        }
        cres09so.setSelectedLicensureTypesArray(selectedLicensureTypesArray);
      }
    return cres09so;
  }

  private CRES09SO findCapsResource(int idResource, CRES09SO cres09so) throws ServiceException {
    // CallCRES05D
    CapsResource capsResourceInfo = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
    // cres05d
    if (capsResourceInfo == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    cres09so.setSzCdRsrcCertBy(capsResourceInfo.getCdRsrcCertBy());
    cres09so.setTxtSpecCert(capsResourceInfo.getTxtSpecCert());
    cres09so.setSzCdRsrcOperBy(capsResourceInfo.getCdRsrcOperBy());
    cres09so.setSzCdRsrcSetting(capsResourceInfo.getCdRsrcSetting());
    cres09so.setSzCdRsrcPayment(capsResourceInfo.getCdRsrcPayment());
    cres09so.setDtDtRsrcCert(DateHelper.toCastorDate(capsResourceInfo.getDtRsrcCert()));
    cres09so.setDtDtRsrcClose(DateHelper.toCastorDate(capsResourceInfo.getDtRsrcClose()));
    cres09so
            .setUNbrRsrcFacilCapacity(capsResourceInfo.getNbrRsrcFacilCapacity() != null ? capsResourceInfo
                    .getNbrRsrcFacilCapacity()
                                      : 0);
    if(capsResourceInfo.getIndAfterHours() == null || capsResourceInfo.getIndAfterHours().trim().equals(""))
    {
      cres09so.setBIndAvailableAfterHrs("N");
    }
    else
    {
      cres09so.setBIndAvailableAfterHrs(capsResourceInfo.getIndAfterHours());
    }
    
    cres09so.setTsLastUpdate(capsResourceInfo.getDtLastUpdate());

    return cres09so;
  }

  private ROWCRES06DO_ARRAY findSpecSvcs(int idResource) throws ServiceException {
    // CallCRES06D
    List<SpecSvcs> specSvcsInfo = specSvcsDAO.findSpecSvcsByIdResource(idResource);
    // cres06d
    ROWCRES06DO_ARRAY rowcres06do_array = new ROWCRES06DO_ARRAY();
    if (specSvcsInfo != null) {
      for (Iterator<SpecSvcs> it = specSvcsInfo.iterator(); it.hasNext();) {
        SpecSvcs specSvcs = it.next();
        ROWCRES06DO rowcres06do = new ROWCRES06DO();

        rowcres06do.setUlIdSpecSvcRsrc(specSvcs.getCapsResource().getIdResource() != null ? specSvcs.getCapsResource()
                .getIdResource() : 0);
        rowcres06do.setSzCdSpecSvcs(specSvcs.getCdSpecSvcs());
        rowcres06do.setTsLastUpdate(specSvcs.getDtLastUpdate());
        rowcres06do.setUlIdSpecSvc(specSvcs.getIdSpecSvc() != null ? specSvcs.getIdSpecSvc() : 0);
        rowcres06do_array.addROWCRES06DO(rowcres06do);
      }
    }

    return rowcres06do_array;
  }

  private ROWCRES07DO_ARRAY findFacilityLoc(int idResource) throws ServiceException {
    // CallCRES07D
    List<FacilityLoc> facilityLocInfo = facilityLocDAO.findFacilityLocByIdResource(idResource);
    // cres07d
    ROWCRES07DO_ARRAY rowcres07do_array = new ROWCRES07DO_ARRAY();
    if (facilityLocInfo != null || !(facilityLocInfo.isEmpty())) {
      for (Iterator<FacilityLoc> it = facilityLocInfo.iterator(); it.hasNext();) {
        FacilityLoc facilityLoc = it.next();
        ROWCRES07DO rowcres07do = new ROWCRES07DO();

        rowcres07do.setUlIdFloc(facilityLoc.getIdFloc() != null ? facilityLoc.getIdFloc() : 0);
        rowcres07do.setCCdFlocStatus1(facilityLoc.getCdFlocStatus1());
        rowcres07do.setCCdFlocStatus2(facilityLoc.getCdFlocStatus2());
        rowcres07do.setCCdFlocStatus3(facilityLoc.getCdFlocStatus3());
        rowcres07do.setCCdFlocStatus4(facilityLoc.getCdFlocStatus4());
        rowcres07do.setCCdFlocStatus5(facilityLoc.getCdFlocStatus5());
        rowcres07do.setCCdFlocStatus6(facilityLoc.getCdFlocStatus6());
        rowcres07do.setCCdFlocStatus7(facilityLoc.getCdFlocStatus7());
        rowcres07do.setCCdFlocStatus8(facilityLoc.getCdFlocStatus8());
        rowcres07do.setCCdFlocStatus9(facilityLoc.getCdFlocStatus9());
        rowcres07do.setCCdFlocStatus10(facilityLoc.getCdFlocStatus10());
        rowcres07do.setCCdFlocStatus11(facilityLoc.getCdFlocStatus11());
        rowcres07do.setCCdFlocStatus12(facilityLoc.getCdFlocStatus12());
        rowcres07do.setCCdFlocStatus13(facilityLoc.getCdFlocStatus13());
        rowcres07do.setCCdFlocStatus14(facilityLoc.getCdFlocStatus14());
        rowcres07do.setCCdFlocStatus15(facilityLoc.getCdFlocStatus15());
        rowcres07do.setDtDtFlocEffect(DateHelper.toCastorDate(facilityLoc.getDtFlocEffect()));
        rowcres07do.setDtDtFlocEnd(DateHelper.toCastorDate(facilityLoc.getDtFlocEnd()));
        rowcres07do
                .setSNbrFlocLevelsOfCare(facilityLoc.getNbrFlocLevelsOfCare() != null ? facilityLoc
                        .getNbrFlocLevelsOfCare()
                                         : 0);
        rowcres07do.setTsLastUpdate(facilityLoc.getDtLastUpdate());
        rowcres07do_array.addROWCRES07DO(rowcres07do);
      }
    }
    return rowcres07do_array;
  }
}
