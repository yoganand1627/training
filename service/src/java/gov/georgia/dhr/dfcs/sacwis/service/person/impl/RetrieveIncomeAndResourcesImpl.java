package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomeAndResourcesDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveIncomeAndResources;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC29SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC29SOG00_ARRAY;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This is the DAO class is used for the STAGE table
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  08/18/10  wjcochran SMS #50005 - Added null checks to prevent null pointer exceptions
 *                      when performing date calculations.
 * </pre>
 */
public class RetrieveIncomeAndResourcesImpl extends BaseServiceImpl implements RetrieveIncomeAndResources {

  private IncomeAndResourcesDAO incomeAndResourcesDAO = null;

  public void setIncomeAndResourcesDAO(IncomeAndResourcesDAO incomeAndResourcesDAO) {
    this.incomeAndResourcesDAO = incomeAndResourcesDAO;
  }

  public CCFC29SO retrieveIncomeAndResources(CCFC29SI ccfc29si) throws ServiceException {
    CCFC29SO ccfc29so = new CCFC29SO();
    Double amtIncRsrc = 0.0; // holds monthly amount
    java.util.GregorianCalendar tempCal = new java.util.GregorianCalendar();
    tempCal.setTime(new Date());
    int firstDayOfMonth = tempCal.getActualMinimum(java.util.GregorianCalendar.DATE);
    tempCal.set(java.util.GregorianCalendar.DATE, firstDayOfMonth);
    Date currentMonthStartDate = tempCal.getTime();
    Date currentMonthEndDate = DateHelper.getLastDayOfTheMonth(new Date());
    // clss58d
    List<Map> incomeResourceNameList = incomeAndResourcesDAO.findIncomeAndResourcesAndNmFull(ccfc29si.getUlIdPerson());
    if (incomeResourceNameList != null && !incomeResourceNameList.isEmpty()) {
      ROWCCFC29SOG00_ARRAY rowccfc29sog00_array = new ROWCCFC29SOG00_ARRAY();
      for (Iterator<Map> it = incomeResourceNameList.iterator(); it.hasNext();) {
        Map row = it.next();
        ROWCCFC29SOG00 rowccfc29sog00 = new ROWCCFC29SOG00();
        rowccfc29sog00.setSzCdIncRsrcIncome((String) row.get("cdIncRsrcIncome"));
        rowccfc29sog00.setSzCdIncRsrcType((String) row.get("cdIncRsrcType"));
        rowccfc29sog00.setDtDtIncRsrcFrom(DateHelper.toCastorDate((Date) row.get("dtIncRsrcFrom")));
        rowccfc29sog00.setDtDtIncRsrcTo(DateHelper.toCastorDate((Date) row.get("dtIncRsrcTo")));
        rowccfc29sog00.setUlIdPerson((Integer) row.get("idPerson") != null ? (Integer) row.get("idPerson") : 0);
        rowccfc29sog00.setUlIdIncRsrcWorker((Integer) row.get("idIncRsrcWorker") != null ? (Integer) row.get(
                "idIncRsrcWorker") : 0);
        rowccfc29sog00.setUlIdIncRsrc((Integer) row.get("idIncRsrc") != null ? (Integer) row.get("idIncRsrc") : 0);
        rowccfc29sog00.setCIndIncRsrcNotAccess((String) row.get("indIncRsrcNotAccess"));
        rowccfc29sog00.setSzNmPersonFull((String) row.get("nmPersonFull"));
        rowccfc29sog00.setSzSdsIncRrcsSource((String) row.get("sdsIncRsrcSource"));
        rowccfc29sog00.setSzSdsIncRsrcVerfMethod((String) row.get("sdsIncRsrcVerfMethod"));
        rowccfc29sog00.setTsLastUpdate((Date) row.get("dtLastUpdate"));
        rowccfc29sog00.setSzTxtIncRsrcDesc((String) row.get("txtIncRsrcDesc"));

        String freq = (String) row.get("cdIncRsrcFreqType");
        String cdIncRsrcIncome = (String) row.get("cdIncRsrcIncome");
        Double monthlyIncRsrc =  row.get("amtIncRsrc") != null ? (Double)row.get("amtIncRsrc") : new Double(0) ;
        // SIR 2109 - Do not include resources in monthly total income
        Double freqFactor = 0.0;
        rowccfc29sog00.setSzCdIncRsrcFreqType(freq);
        rowccfc29sog00.setLAmtIncRsrc(monthlyIncRsrc);
        if (freq != null && "INC".equals(cdIncRsrcIncome)) {
          if ("ANN".equals(freq)) {
            freqFactor = 1.0 / 12.0;
          } else if ("BWK".equals(freq)) {
            freqFactor = 26.0 / 12.0;
          } else if ("MON".equals(freq)) {
            freqFactor = 1.0; 
          } else if ("OTM".equals(freq)) {
            freqFactor = 0.0;
          } else if ("QRT".equals(freq)) {
            freqFactor = 4.0 / 12.0;
          } else if ("SMN".equals(freq)) {
            freqFactor = 24.0 / 12.0;
          } else if ("WEK".equals(freq)) {
            freqFactor = 52.0 / 12.0;
          }
        } 
        monthlyIncRsrc = monthlyIncRsrc * freqFactor;
        Date dtIncRsrcFrom = DateHelper.toJavaDateSafe(FormattingHelper.formatDate(DateHelper.toJavaDate(rowccfc29sog00.getDtDtIncRsrcFrom())));
        Date dtIncRsrcTo = DateHelper.toJavaDateSafe(FormattingHelper.formatDate(DateHelper.toJavaDate(rowccfc29sog00.getDtDtIncRsrcTo())));
        currentMonthStartDate = DateHelper.toJavaDateSafe(FormattingHelper.formatDate(currentMonthStartDate));
        currentMonthEndDate = DateHelper.toJavaDateSafe(FormattingHelper.formatDate(currentMonthEndDate));
        int startDateLTCurrentMonthEndDate = -1;
        int endDateGTCurrentMonthStartDate = 1;
        // SMS #50005 - null checks added
        if (dtIncRsrcFrom != null && currentMonthEndDate != null) {
          startDateLTCurrentMonthEndDate = dtIncRsrcFrom.compareTo(currentMonthEndDate);
        }
        if(dtIncRsrcTo != null && currentMonthStartDate != null){
          endDateGTCurrentMonthStartDate = dtIncRsrcTo.compareTo(currentMonthStartDate);
        }
        if((startDateLTCurrentMonthEndDate <= 0 && endDateGTCurrentMonthStartDate >= 0)){
          amtIncRsrc = amtIncRsrc + monthlyIncRsrc;
        }

        rowccfc29sog00.setSzTxtIncRsrcSrcPhoneNum((String) row.get("txtIncRsrcSrcPhoneNum"));
        rowccfc29sog00.setSzTxtIncRsrcSrcPhoneExt((String) row.get("txtIncRsrcSrcPhoneExt"));
        rowccfc29sog00.setSzTxtIncRsrcSrcAddrStLn1((String) row.get("txtIncRsrcSrcAddrStLn1"));
        rowccfc29sog00.setSzTxtIncRsrcSrcAddrStLn2((String) row.get("txtIncRsrcSrcAddrStLn2"));
        rowccfc29sog00.setSzTxtIncRsrcSrcAddrCity((String) row.get("txtIncRsrcSrcAddrCity"));
        rowccfc29sog00.setSzTxtIncRsrcSrcAddrState((String) row.get("txtIncRsrcSrcAddrState"));
        rowccfc29sog00.setSzTxtIncRsrcSrcAddrZip((String) row.get("txtIncRsrcSrcAddrZip"));
        rowccfc29sog00.setSzCdIncRsrcSrcAddrCounty((String) row.get("txtIncRsrcSrcAddrCounty"));
        rowccfc29sog00.setSzTxtIncRsrcSrcAddrCmnts((String) row.get("txtIncRsrcSrcAddrCmnts"));
        rowccfc29sog00.setDtDtIncRsrcModified(DateHelper.toCastorDate((Date) row.get("dtIncRsrcModified")));

        rowccfc29sog00_array.addROWCCFC29SOG00(rowccfc29sog00);//dtIncRsrcModified
      }
      ccfc29so.setROWCCFC29SOG00_ARRAY(rowccfc29sog00_array);
      // cmsc35
      /*Double amtIncRsrc = incomeAndResourcesDAO.findAmtIncRsrcFromIncomeAndResourcesByIdPerson(
              ccfc29si.getUlIdPerson());
      if (amtIncRsrc == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }*/

      ccfc29so.setLAmtIncRsrc(amtIncRsrc);
    }
    return ccfc29so;
  }
}
