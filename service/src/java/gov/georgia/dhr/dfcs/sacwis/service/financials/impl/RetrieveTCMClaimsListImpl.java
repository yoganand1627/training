package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.DynamicTCMClaimDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.TcmClaim;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveTCMClaimsList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TCMClaimsSearchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TCMClaimsSearchSO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RetrieveTCMClaimsListImpl extends BaseServiceImpl implements RetrieveTCMClaimsList {

  private DynamicTCMClaimDAO dynamicTCMClaimDAO = null;

  public void setDynamicTCMClaimDAO(DynamicTCMClaimDAO dynamicTCMClaimDAO) {
    this.dynamicTCMClaimDAO = dynamicTCMClaimDAO;
  }

  public List<TCMClaimsSearchSO> retrieveTCMClaimsList(TCMClaimsSearchSI input) {
    List<TCMClaimsSearchSO> result = new ArrayList<TCMClaimsSearchSO>();
    
    //-- create start and end dates based on year and month given; must have year to use month
    Date dtStart = null;
    Date dtEnd = null;
    
    int year = input.getUlYear();
    if(year > 0) {
      Calendar cal = Calendar.getInstance();
      cal.set(Calendar.YEAR, year);
      cal.set(Calendar.DATE, 1);
      int month = input.getMonth();
      if(month > 0) {
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
      } else {
        cal.set(Calendar.MONTH, 0);
      }
      dtStart = cal.getTime();
      
      if(month > 0) {
    	cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    	cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
      } else {
        cal.add(Calendar.YEAR, 1);
      }
      dtEnd = cal.getTime();
    }
    
    // Create the date string with the month and year from user input on the jsp
    // the day will be set to "01" (first day of the month)
    //String stringStartDate = (input.getMonth() + "/01/" + input.getUlYear());
    // Service date to use for search
    //Date dtStart = DateHelper.toJavaDateSafe(stringStartDate);
    // we set the end date to the first of the next month by adding 1 to the month. Hibernate will return service date
    // >= dtStart and < dtEnd
    //Date dtEnd = DateHelper.addToDate(dtStart, 0, 1, 0);

    List<TcmClaim> tcmClaimsList = dynamicTCMClaimDAO.findTCMClaims(input.getUlIdStaff(), input.getIdClient(),
                                                                    dtStart, dtEnd, input.getSzCdStatus(), 
                                                                    input.getSzCdCounty(), input.getSzUnit());
    Iterator<TcmClaim> iterator = tcmClaimsList.iterator();

    while (iterator.hasNext()) {
      TcmClaim tcmClaim = iterator.next();
      TCMClaimsSearchSO searchSO = new TCMClaimsSearchSO();
      
      //-- these require null checks since all TCM_CLAIM columns are nullable
      Person personByIdStaff = tcmClaim.getPersonByIdStaff();
      searchSO.setUlIdStaff(personByIdStaff != null ? personByIdStaff.getIdPerson() : 0);
      Stage stage = tcmClaim.getStage();
      searchSO.setUlIdStage(stage != null ? stage.getIdStage() : 0);
      Person personByIdPerson = tcmClaim.getPersonByIdPerson();
      searchSO.setUlIdPerson(personByIdPerson != null ? personByIdPerson.getIdPerson() : 0);
      Event event = tcmClaim.getEvent();
      searchSO.setUlIdEvent(event != null ? event.getIdEvent() : 0);
      
      searchSO.setDtServiceDate(tcmClaim.getDtService());
      searchSO.setDtStatusDate(tcmClaim.getDtStatus());
      searchSO.setSzCdDenialReason(tcmClaim.getCdDenial());
      searchSO.setSzCdStatus(tcmClaim.getCdStatus());
      searchSO.setSzNbrMedicaid(tcmClaim.getNbrMedicaid());
      searchSO.setSzNmClient(tcmClaim.getNmClient());
      searchSO.setTsDtLastUpdate(tcmClaim.getDtLastUpdate());
      searchSO.setUlTCNNumber(tcmClaim.getNbrTcn());
      searchSO.setUlIdTcmClaim(tcmClaim.getIdTcmClaim());
      
      result.add(searchSO);
    }
    return result;
  }
}
