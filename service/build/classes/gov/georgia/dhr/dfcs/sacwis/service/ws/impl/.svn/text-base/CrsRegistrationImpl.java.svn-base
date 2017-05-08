/**
 * Created on Mar 29, 2007 by Kapil Aggarwal, SACWIS Project
 */
package gov.georgia.dhr.dfcs.sacwis.service.ws.impl;

import gov.ga.gta.eiss.shines.crs.crsregistration.ShinesRegistrationResponse;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.CrsRegistration;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsRegistrationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CrsRegistrationSO;
import gov.georgia.dhr.dfcs.sacwis.ws.crsregistration.SHINES_CRS_Svcs_processCRSRegistrationPortType;

import processcrsregistration.svcs.crs.shines.ProcessCRSRegistration;

/**
 * 
 * 
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  3/25/09    cwells        STGAP00012545 - Leaving the SSN number as a string so the leading 0's are not 
 *                           lost by converting it to an Integer.     
 *                           
 *                           
 * </pre>
 */
public class CrsRegistrationImpl extends BaseServiceImpl implements CrsRegistration {

  public static final String SHINES_USER = "SHINEUSR";

  private SHINES_CRS_Svcs_processCRSRegistrationPortType crsRegistrationWS = null;

  private EmployeeDAO employeeDAO;

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setCrsRegistrationWS(SHINES_CRS_Svcs_processCRSRegistrationPortType crsRegistrationWS) {
    this.crsRegistrationWS = crsRegistrationWS;
  }

  /*
   * (non-Javadoc)
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.service.ws.CrsRegistration#performCrsRegistration(gov.georgia.dhr.dfcs.sacwis.structs.input.CrsRegistrationSI)
   */
  public CrsRegistrationSO performCrsRegistration(CrsRegistrationSI crsRegistrationSI) {
    ProcessCRSRegistration processCRSRegistration = new ProcessCRSRegistration();
    String racf = employeeDAO.findEmployeeRacfIdWithLoginId((crsRegistrationSI.getLnIdInitiator() != null) ? Integer.parseInt(crsRegistrationSI.getLnIdInitiator()) : 0);              
    processCRSRegistration.setUserID((racf != null && racf.length() > 0) ? racf : SHINES_USER);

    //All values must be non-null, these fields are not used in the requset so just make them empty strings 
    processCRSRegistration.setAliasAfricanAmerican("");
    processCRSRegistration.setAliasAsian("");
    processCRSRegistration.setAliasEthnicityCode("");
    processCRSRegistration.setAliasPacificIslander("");
    processCRSRegistration.setAliasNativeAmerican("");
    processCRSRegistration.setAliasRaceCd("");
    processCRSRegistration.setAliasSexCd("");
    processCRSRegistration.setAliasSsnNum0("");
    processCRSRegistration.setAliasSsnNum1("");
    processCRSRegistration.setAliasSsnNum2("");
    processCRSRegistration.setAliasSsnNum3("");
    processCRSRegistration.setAliasSsnNum4("");
    processCRSRegistration.setAliasSufName("");
    processCRSRegistration.setAliasWhite("");
    processCRSRegistration.setClientIdentifier("");

    // city code is really county code for GTA
    processCRSRegistration
                          .setClintCityCd((crsRegistrationSI.getUlCountyCode() == 0) ? ""
                                                                                    : Integer
                                                                                             .toString(crsRegistrationSI
                                                                                                                        .getUlCountyCode()));

    processCRSRegistration
                          .setAliasFirstName((crsRegistrationSI.getSzAlias1FName() == null) ? ""
                                                                                           : crsRegistrationSI
                                                                                                              .getSzAlias1FName().toUpperCase());
    processCRSRegistration
                          .setAliasLastName((crsRegistrationSI.getSzAlias1LName() == null) ? ""
                                                                                          : crsRegistrationSI
                                                                                                             .getSzAlias1LName().toUpperCase());
    processCRSRegistration
                          .setAliasMidName((crsRegistrationSI.getSzAlias1MName() == null) ? ""
                                                                                         : crsRegistrationSI
                                                                                                            .getSzAlias1MName().toUpperCase());

    processCRSRegistration.setClintDobDt((crsRegistrationSI.getUlDob() == null) ? "" : crsRegistrationSI.getUlDob());
    processCRSRegistration
                          .setClintDobVerCd((crsRegistrationSI.getSzDobVrfcnCode() == null) ? ""
                                                                                           : crsRegistrationSI
                                                                                                              .getSzDobVrfcnCode());

    processCRSRegistration
                          .setBenifitMonth((crsRegistrationSI.getLnBenefitMonth() == 0) ? ""
                                                                                       : Integer
                                                                                                .toString(crsRegistrationSI
                                                                                                                           .getLnBenefitMonth()));
    processCRSRegistration
                          .setBirthcityName((crsRegistrationSI.getSzBirthStateCd() == null) ? ""
                                                                                           : crsRegistrationSI
                                                                                                              .getSzBirthStateCd());
    processCRSRegistration
                          .setBirthStateCode((crsRegistrationSI.getSzBirthStateCd() == null) ? ""
                                                                                            : crsRegistrationSI
                                                                                                               .getSzBirthStateCd());
    processCRSRegistration
                          .setClientAfricanAmerican((crsRegistrationSI.getSzBlnAfAmerican() == null) ? ""
                                                                                                    : crsRegistrationSI
                                                                                                                       .getSzBlnAfAmerican());
    processCRSRegistration
                          .setClientAsian((crsRegistrationSI.getSzBlnAsian() == null) ? ""
                                                                                     : crsRegistrationSI
                                                                                                        .getSzBlnAsian());
    processCRSRegistration
                          .setClientEthnicityCode((crsRegistrationSI.getSzEthnCode() == null) ? ""
                                                                                             : crsRegistrationSI
                                                                                                                .getSzEthnCode());

    processCRSRegistration.setClientFirstName((crsRegistrationSI.getSzFName() == null) ? ""
                                                                                      : crsRegistrationSI.getSzFName().toUpperCase());
    processCRSRegistration.setClientLastName((crsRegistrationSI.getSzLName() == null) ? ""
                                                                                     : crsRegistrationSI.getSzLName().toUpperCase());
    processCRSRegistration.setClientMidName((crsRegistrationSI.getSzMName() == null) ? ""
                                                                                    : crsRegistrationSI.getSzMName().toUpperCase());
    processCRSRegistration
                          .setClientPacificIslander((crsRegistrationSI.getSzBlnPcfcislander() == null) ? ""
                                                                                                      : crsRegistrationSI
                                                                                                                         .getSzBlnPcfcislander());
    processCRSRegistration.setClientSexCd((crsRegistrationSI.getSzSexCode() == null) ? ""
                                                                                    : crsRegistrationSI.getSzSexCode());
    processCRSRegistration
                          .setClientSsnNum((crsRegistrationSI.getSzSsn() == null) ? ""
                                                                              : crsRegistrationSI.getSzSsn());

    processCRSRegistration
                          .setClientWhite((crsRegistrationSI.getSzBlnWhite() == null) ? ""
                                                                                     : crsRegistrationSI
                                                                                                        .getSzBlnWhite());

    processCRSRegistration
                          .setClintNativeAmerican((crsRegistrationSI.getSzBlnNtvAmerican() == null) ? ""
                                                                                                   : crsRegistrationSI
                                                                                                                      .getSzBlnNtvAmerican());
    processCRSRegistration
                          .setClientRaceCd((crsRegistrationSI.getSzRaceCode() == null) ? ""
                                                                                      : crsRegistrationSI
                                                                                                         .getSzRaceCode());
    processCRSRegistration.setClientSufName((crsRegistrationSI.getSzSuffix() == null) ? ""
                                                                                     : crsRegistrationSI.getSzSuffix());
    processCRSRegistration
                          .setCycleDate((crsRegistrationSI.getSzSysCycleDate() == null) ? ""
                                                                                       : crsRegistrationSI
                                                                                                          .getSzSysCycleDate());
    processCRSRegistration
                          .setMaritalStatus((crsRegistrationSI.getSzMaritalStatus() == null) ? ""
                                                                                            : crsRegistrationSI
                                                                                                               .getSzMaritalStatus());
    processCRSRegistration
                          .setPrimaryLanguage((crsRegistrationSI.getSzPrimLanguage() == null) ? ""
                                                                                             : crsRegistrationSI
                                                                                                                .getSzPrimLanguage());
    processCRSRegistration
                          .setReturnValue((crsRegistrationSI.getLnCrsReturnValue() == 0) ? ""
                                                                                        : Integer
                                                                                                 .toString(crsRegistrationSI
                                                                                                                            .getLnCrsReturnValue()));
    ShinesRegistrationResponse response = crsRegistrationWS.shines_CRSRegistration(processCRSRegistration);
    CrsRegistrationSO so = null;
    if (response != null) {
      so = new CrsRegistrationSO();
      so.setLnCrsReturnValue((response.getCrsReturnValue() != null && (response.getCrsReturnValue().trim()).length() > 0) ? Integer
                                                                                                                            .parseInt(response
                                                                                                                                      .getCrsReturnValue())
                                                                                                          : 0);
      so
        .setLnBenefitMonth((response.getInBenefitMonth() != null && (response.getInBenefitMonth().trim()).length() > 0) ? Integer
                                                                                                                                 .parseInt(response
                                                                                                                                                   .getInBenefitMonth())
                                                                                                                       : 0);
      so
        .setLnCrsReturnValue((response.getCrsReturnValue() != null && (response.getCrsReturnValue().trim()).length() > 0) ? Integer
                                                                                                                                   .parseInt(response
                                                                                                                                                     .getCrsReturnValue())
                                                                                                                         : 0);

      so.setSzAlias1FName(response.getSzAlias1FName() != null ? response.getSzAlias1FName().trim(): "");      
      so.setSzAlias1LName(response.getSzAlias1Lname() != null ? response.getSzAlias1Lname().trim(): "");
      so.setSzAlias1MName(response.getSzAlias1MName() != null ? response.getSzAlias1MName().trim(): "");
      so.setSzAlias1Suffix(response.getSzAlias1Suffix() != null ? response.getSzAlias1Suffix().trim(): "");
      so.setSzAlias2FName(response.getSzAlias2FName() != null ? response.getSzAlias2FName().trim(): "");
      so.setSzAlias2LName(response.getSzAlias2LName() != null ? response.getSzAlias2LName().trim(): "");
      so.setSzAlias2MName(response.getSzAlias2MName() != null ? response.getSzAlias2MName().trim(): "");
      so.setSzAlias2Suffix(response.getSzAlias2Suffix() != null ? response.getSzAlias2Suffix().trim(): "");
      so.setSzAlias3FName(response.getSzAlias3FName() != null ? response.getSzAlias3FName().trim(): "");
      so.setSzAlias3LName(response.getSzAlias3LName() != null ? response.getSzAlias3LName().trim(): "");
      so.setSzAlias3MName(response.getSzAlias3MName() != null ? response.getSzAlias3MName().trim(): "");
      so.setSzAlias3Suffix(response.getSzAlias3Suffix() != null ? response.getSzAlias3Suffix().trim(): "");
      so.setSzBirthCityNm(response.getSzBirthCityNm() != null ? response.getSzBirthCityNm().trim(): "");
      so.setSzBirthStateCd(response.getSzBirthStateCd() != null ? response.getSzBirthStateCd().trim(): "");
      so.setSzBlnAfamerican(response.getSzBlnAfamerican() != null ? response.getSzBlnAfamerican().trim(): "");
      so.setSzBlnAsian(response.getSzBlnAsian() != null ? response.getSzBlnAsian().trim(): "");
      so.setSzBlnNtvAmerican(response.getSzBlnNtvAmerican() != null ? response.getSzBlnNtvAmerican().trim(): "");
      so.setSzBlnPcfcislander(response.getSzBlnPcfcislander() != null ? response.getSzBlnPcfcislander().trim(): "");
      so.setSzBlnWhite(response.getSzBlnWhite() != null ? response.getSzBlnWhite().trim(): "");
      so.setSzDobVrfcnCode(response.getSzDobVrfcnCode() != null ? response.getSzDobVrfcnCode().trim(): "");
      so.setSzEthnCode(response.getSzEthnCode() != null ? response.getSzEthnCode().trim(): "");
      so.setSzFName(response.getSzFName() != null ? response.getSzFName().trim(): "");
      so.setSzLName(response.getSzLName() != null ? response.getSzLName().trim(): "");
      so.setSzMaritalStatus(response.getSzmaritalStatus() != null ? response.getSzmaritalStatus().trim(): "");
      so.setSzMName(response.getSzMName() != null ? response.getSzMName().trim(): "");
      so.setSzPrimLanguage(response.getSzPrimLanguage() != null ? response.getSzPrimLanguage().trim(): "");
      so.setSzRaceCode(response.getSzRaceCode() != null ? response.getSzRaceCode().trim(): "");
      so.setSzRacfid(response.getSzRacfid() != null ? response.getSzRacfid().trim(): "");
      so.setSzSexCode(response.getSzSexCode() != null ? response.getSzSexCode().trim(): "");
      so.setSzSsnVrfcnCode(response.getSzSsnVrfcnCode() != null ? response.getSzSsnVrfcnCode().trim(): "");
      so.setSzSuffix(response.getSzSuffix() != null ? response.getSzSuffix().trim(): "");
      so.setSzSysCycleDate(response.getSzSysCycleDate() != null ? response.getSzSysCycleDate().trim(): "");
      
      so
        .setUlAlt1Ssn((response.getUlAlt1Ssn() != null && (response.getUlAlt1Ssn().trim()).length() > 0) ? Integer
                                                                                                                  .parseInt(response
                                                                                                                                    .getUlAlt1Ssn())
                                                                                                        : 0);
      so
        .setUlAlt2Ssn((response.getUlAlt2Ssn() != null && (response.getUlAlt2Ssn().trim()).length() > 0) ? Integer
                                                                                                                  .parseInt(response
                                                                                                                                    .getUlAlt2Ssn())
                                                                                                        : 0);
      so
        .setUlAlt3Ssn((response.getUlAlt3Ssn() != null && (response.getUlAlt3Ssn().trim()).length() > 0) ? Integer
                                                                                                                  .parseInt(response
                                                                                                                                    .getUlAlt3Ssn())
                                                                                                        : 0);
      so
        .setUlAlt4Ssn((response.getUlAlt4Ssn() != null && (response.getUlAlt4Ssn().trim()).length() > 0) ? Integer
                                                                                                                  .parseInt(response
                                                                                                                                    .getUlAlt4Ssn())
                                                                                                        : 0);
      so
        .setUlAlt5Ssn((response.getUlAlt5Ssn() != null && (response.getUlAlt5Ssn().trim()).length() > 0) ? Integer
                                                                                                                  .parseInt(response
                                                                                                                                    .getUlAlt5Ssn())
                                                                                                        : 0);
      so
        .setUlCountyCode((response.getUlCountyCode() != null && (response.getUlCountyCode().trim()).length() > 0) ? Integer
                                                                                                                           .parseInt(response
                                                                                                                                             .getUlCountyCode())
                                                                                                                 : 0);
      so.setUlDob(response.getUDob());
      so
        .setUlSsn((response.getUlSsn() != null && (response.getUlSsn().trim()).length() > 0) ? Integer
                                                                                                      .parseInt(response
                                                                                                                        .getUlSsn())
                                                                                            : 0);
      int clientId = (response.getClientId() != null && (response.getClientId().trim()).length() > 0) ? Integer
                                                                                                      .parseInt(response
                                                                                                                .getClientId())
                                                                                    : 0;                                                                                       
      so.setLnIrnClientId(clientId);
    }
    return so;
  }
}
