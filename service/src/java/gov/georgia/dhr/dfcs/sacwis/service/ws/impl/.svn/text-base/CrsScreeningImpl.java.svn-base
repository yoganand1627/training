/**
 * Created on Mar 29, 2007 by Kapil Aggarwal, SACWIS Project
 */
package gov.georgia.dhr.dfcs.sacwis.service.ws.impl;

import gov.ga.gta.eiss.shines.crs.crsscreening.ShinesScreeningResponse;
import gov.ga.gta.eiss.shines.crs.crsscreening.ShinesScreeningResponseList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.ws.CrsScreening;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsScreeningSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CrsScreeningSO;
import gov.georgia.dhr.dfcs.sacwis.ws.crsscreening.SHINES_CRS_Svcs_processCRSScreeningPortType;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import processcrsscreening.svcs.crs.shines.ProcessCRSScreening;

public class CrsScreeningImpl extends BaseServiceImpl implements CrsScreening {

  public static final String SHINES_USER = "SHINEUSR";

  private SHINES_CRS_Svcs_processCRSScreeningPortType crsScreeningWS;

  private EmployeeDAO employeeDAO;

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setCrsScreeningWS(SHINES_CRS_Svcs_processCRSScreeningPortType crsScreeningWS) {
    this.crsScreeningWS = crsScreeningWS;
  }

  /**
   */
  @SuppressWarnings("unchecked")
  public CrsScreeningSO performCrsScreening(CrsScreeningSI crsScreeningSI) {
    ProcessCRSScreening processCRSScreening = new ProcessCRSScreening();

    String racf = employeeDAO
                             .findEmployeeRacfIdWithLoginId((crsScreeningSI.getLnIdInitiator() != null) ? Integer
                                                                                                                 .parseInt(crsScreeningSI
                                                                                                                                         .getLnIdInitiator())
                                                                                                       : 0);
    processCRSScreening.setUserID((racf != null && racf.length() > 0) ? racf : SHINES_USER);

    // null values must be converted to empty strings for GTA
    processCRSScreening
                       .setAfricanAmerican((crsScreeningSI.getSzBlnAfAmerican() == null) ? ""
                                                                                        : crsScreeningSI
                                                                                                        .getSzBlnAfAmerican());
    processCRSScreening
                       .setAmericanIndian((crsScreeningSI.getSzBlnNtvAmerican() == null) ? ""
                                                                                        : crsScreeningSI
                                                                                                        .getSzBlnNtvAmerican());
    processCRSScreening.setAsian((crsScreeningSI.getSzBlnAsian() == null) ? "" : crsScreeningSI.getSzBlnAsian());
    processCRSScreening.setClientdateOfBirth((crsScreeningSI.getUlDob() == null) ? "" : crsScreeningSI.getUlDob());
    processCRSScreening.setClientFirstName((crsScreeningSI.getSzFName() == null) ? "" : crsScreeningSI.getSzFName()
                                                                                                      .toUpperCase());
    processCRSScreening.setClientLastName((crsScreeningSI.getSzLName() == null) ? "" : crsScreeningSI.getSzLName()
                                                                                                     .toUpperCase());
    processCRSScreening.setClientMiddleName((crsScreeningSI.getSzMName() == null) ? "" : crsScreeningSI.getSzMName()
                                                                                                       .toUpperCase());

    processCRSScreening.setClientSex((crsScreeningSI.getSzSexCode() == null) ? "" : crsScreeningSI.getSzSexCode());
    processCRSScreening.setClientSSN((crsScreeningSI.getUlSsn() == null) ? ""
                                                                     : crsScreeningSI.getUlSsn());
    processCRSScreening.setClientSuffix((crsScreeningSI.getSzSuffix() == null) ? "" : crsScreeningSI.getSzSuffix());
    processCRSScreening.setEthnicity((crsScreeningSI.getSzEthnCode() == null) ? "" : crsScreeningSI.getSzEthnCode());
    processCRSScreening
                       .setPacificislander((crsScreeningSI.getSzBlnPcfcislander() == null) ? ""
                                                                                          : crsScreeningSI
                                                                                                          .getSzBlnPcfcislander());
    processCRSScreening.setWhite((crsScreeningSI.getSzBlnWhite() == null) ? "" : crsScreeningSI.getSzBlnWhite());

    // dead values but need to be empty strings for GTA
    processCRSScreening.setResultsreturnedfromCRS("");
    processCRSScreening.setReturnCode("");
    processCRSScreening.setMainframeRACFID("");
    processCRSScreening.setClientID("");

    ShinesScreeningResponse shinesScreeningResponse = crsScreeningWS.shines_CRSScreening(processCRSScreening);
    // need to return an empty list
    CrsScreeningSO crsScreeningSO = new CrsScreeningSO();
    crsScreeningSO.setReturnItems(new ArrayList<CrsScreeningSO.ReturnItem>());
    crsScreeningSO.setReturnCode(new Integer(CrsScreeningSO.SUCCESSFULL_SCREENING));
    if (shinesScreeningResponse != null) {
      List<ShinesScreeningResponseList> responseList = shinesScreeningResponse.getShinesScreeningResponseList();
      if (responseList != null && responseList.size() > 0) {
        // peek at the first one to get the return code and decide if to keep walking through the list
        ShinesScreeningResponseList firstItem = responseList.get(0);
        Integer returnCode = (firstItem.getInCrsReturnValue() != null) ? new Integer(firstItem.getInCrsReturnValue())
                                                                                    : new Integer(0);
        
        //if there are no row to return from the query CRS will return 100 so just return an empty list
        if(returnCode.intValue() == 100) {
          return crsScreeningSO;
        }
        
        crsScreeningSO.setReturnCode(returnCode);

        // if successfull return code walk the list
        if (returnCode.intValue() == CrsScreeningSO.SUCCESSFULL_SCREENING) {

          List<CrsScreeningSO.ReturnItem> returnItems = new ArrayList<CrsScreeningSO.ReturnItem>();
          for (Iterator<ShinesScreeningResponseList> it = responseList.iterator(); it.hasNext();) {
            ShinesScreeningResponseList responseItem = it.next();
            CrsScreeningSO.ReturnItem outItem = new CrsScreeningSO.ReturnItem();
            outItem
                   .setLnCrsReturnValue((responseItem.getInCrsReturnValue() != null) ? Integer
                                                                                              .parseInt(responseItem
                                                                                                                    .getInCrsReturnValue())
                                                                                    : 0);
            outItem
                   .setLnIrnClientId((responseItem.getInIrnClientId() != null) ? Integer
                                                                                        .parseInt(responseItem
                                                                                                              .getInIrnClientId())
                                                                              : 0);

            // if zero can not use so just pass by
            if (outItem.getLnIrnClientId() == 0) {
              continue;
            }

            outItem.setSzBlnAfAmerican(responseItem.getSzBInAfAmerican());
            outItem.setSzBlnAsian(responseItem.getSzBInAsian());
            outItem.setSzBlnNtvAmerican(responseItem.getSzBInNtvAmerican());
            outItem.setSzBlnPcfcislander(responseItem.getSzBInPcfcislander());
            outItem.setSzBlnWhite(responseItem.getSzBInWhite());
            outItem.setSzEthnCode(responseItem.getSzEthnCode());
            outItem.setSzFName(responseItem.getSzFName());
            outItem.setSzLName(responseItem.getSzLName());
            outItem.setSzMName(responseItem.getSzMName());
            outItem.setSzMoreRowsExist(responseItem.getUNoRows());
            outItem.setSzRaceCode(responseItem.getSzRaceCode());
            outItem.setSzRacfid(responseItem.getSzRacfid());
            outItem.setSzSexCode(responseItem.getSzSexCode());
            outItem.setSzSuffix(responseItem.getSzSuffix());
            outItem.setUlDob(responseItem.getUDob());
            outItem.setUlSsn((responseItem.getUSsn() != null) ? Integer.parseInt(responseItem.getUSsn()) : 0);
            outItem
                   .setUlSsnErrInd((responseItem.getUlSsnErrInd() != null) ? Integer
                                                                                    .parseInt(responseItem
                                                                                                          .getUlSsnErrInd())
                                                                          : 0);
            returnItems.add(outItem);
          }
          crsScreeningSO.setReturnItems(returnItems);
        }
      }
    }
    return crsScreeningSO;
  }
}
