package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Date;
import java.util.Iterator;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicOnCallDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveOnCallList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO_ARRAY;

public class RetrieveOnCallListImpl extends BaseServiceImpl implements RetrieveOnCallList {

  private DynamicOnCallDAO dynamicOnCallDAO = null;

  public void setDynamicOnCallDAO(DynamicOnCallDAO dynamicOnCallDAO) {
    this.dynamicOnCallDAO = dynamicOnCallDAO;
  }

  public CCMN06SO findOnCallList(CCMN06SI ccmn06si) throws ServiceException {
    CCMN06SO ccmn06so = new CCMN06SO();
    // Get System Date and Time for return to Client, since the Date should not be retrieved on the client side.
    ccmn06so.setDtWCDDtSystemDate(DateHelper.getTodayCastorDate());
    // Skip retreival service if code is ADD. This is because the window will pass add when ONLY date is desired and
    // skipping the retrieve DAO is desired.
    if (!ServiceConstants.REQ_FUNC_CD_ADD.equals(ccmn06si.getArchInputStruct().getCReqFuncCd())) {
      ArchInputStruct archInputStruct = ccmn06si.getArchInputStruct();
      // ccmn16d
      ROWCCMN16DI rowccmn16di = ccmn06si.getROWCCMN16DI();
      String[] szCdOnCallCounties;
      szCdOnCallCounties = rowccmn16di.getSzCdOnCallCounty_ARRAY_CCMN06SI().getSzCdOnCallCounty();

      Date dtOnCallStartSearch = null;
      org.exolab.castor.types.Date startDate = rowccmn16di.getDtDtOnCallStart();
      if (startDate != null) {
        dtOnCallStartSearch = DateHelper.toJavaDateSafe(startDate, rowccmn16di.getTmOnCallStart());
      }
      Date dtOnCallEndSearch = null;
      org.exolab.castor.types.Date endDate = rowccmn16di.getDtDtOnCallEnd();
      if (endDate != null) {
        dtOnCallEndSearch = DateHelper.toJavaDateSafe(endDate, rowccmn16di.getTmOnCallEnd());
      }
      PaginatedHibernateList<Object[]> onCallDetailsList = dynamicOnCallDAO.findOnCallwDate(szCdOnCallCounties,
                                                                                       rowccmn16di.getSzCdOnCallProgram(),
                                                                                       rowccmn16di.getSzCdOnCallType(),
                                                                                       dtOnCallStartSearch,
                                                                                       dtOnCallEndSearch,
                                                                                       new Date(),
                                                                                       archInputStruct.getUsPageNbr(),
                                                                                       archInputStruct.getUlPageSizeNbr());
      if (onCallDetailsList == null || onCallDetailsList.isEmpty()) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }

      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd(onCallDetailsList.getBMoreDataInd());
      ROWCCMN16DO_ARRAY rowccmn16do_array = new ROWCCMN16DO_ARRAY();
      int i = 1;
      for (Iterator<Object[]> it = onCallDetailsList.iterator(); it.hasNext();) {
        Object[] onCallObjRow = it.next();
        ROWCCMN16DO rowccmn16do = new ROWCCMN16DO();
        String cdRegion = (String) onCallObjRow[0];
        String cdOnCallProgram = (String) onCallObjRow[1];
        String cdOnCallType = (String) onCallObjRow[2];
        Date dtOnCallStart = (Date) onCallObjRow[3];
        Date dtOnCallEnd = (Date) onCallObjRow[4];
        Integer idOnCall = (Integer) onCallObjRow[5];
        String indOnCallFilled = (String) onCallObjRow[6];
        Date tsLastUpdate = (Date) onCallObjRow[7];
        Integer countOfCounty = (Integer) onCallObjRow[8];
        rowccmn16do.setSzCdRegion(cdRegion);
        rowccmn16do.setSzCdOnCallProgram(cdOnCallProgram);
        rowccmn16do.setSzCdOnCallType(cdOnCallType);
        rowccmn16do.setDtDtOnCallStart(DateHelper.toCastorDate(dtOnCallStart));
        rowccmn16do.setTmOnCallStart(FormattingHelper.formatTime(dtOnCallStart));
        rowccmn16do.setDtDtOnCallEnd(DateHelper.toCastorDate(dtOnCallEnd));
        rowccmn16do.setTmOnCallEnd(FormattingHelper.formatTime(dtOnCallEnd));
        rowccmn16do.setUlIdOnCall(idOnCall != null ? idOnCall : 0);
        rowccmn16do.setBIndOnCallFilled(indOnCallFilled);
        rowccmn16do.setTsLastUpdate(tsLastUpdate);
        rowccmn16do.setUlCountOfCounty(countOfCounty != null ? countOfCounty : 0);
        rowccmn16do_array.addROWCCMN16DO(rowccmn16do);
        rowccmn16do_array.setUlRowQty(i++);
      }
      ccmn06so.setROWCCMN16DO_ARRAY(rowccmn16do_array);
      ccmn06so.setArchOutputStruct(archOutputStruct);
    }
    return ccmn06so;
  }

}
