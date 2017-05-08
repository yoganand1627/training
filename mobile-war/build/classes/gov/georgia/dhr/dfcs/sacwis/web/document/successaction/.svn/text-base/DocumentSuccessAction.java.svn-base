package gov.georgia.dhr.dfcs.sacwis.web.document.successaction;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.service.ServiceHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.GenericStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT33SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT33SO;

/**
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  09/28/05  WADESA    SIR 23965 - Added ServiceHelper.
 * </pre>
 */

public abstract class DocumentSuccessAction {

  public DocumentSuccessAction() {
  }

  public abstract void execute(HttpServletRequest request)
          throws Exception;

  public void createContact(ROWCINT33SIG01 rowcint33sig01, ROWCCMN01UIG00 rowccmn01uig00, GenericStruct genericstruct)
          throws Exception {

    CINT33SI cint33si = new CINT33SI();

    //Set up the Arch input struct
    ArchInputStruct archinputstruct = new ArchInputStruct();
    archinputstruct.setUsPageNbr(ServiceConstants.INITIAL_PAGE);
    archinputstruct.setUlPageSizeNbr(NUM_OF_ROWS);
    archinputstruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);

    cint33si.setArchInputStruct(archinputstruct);
    cint33si.setROWCINT33SIG01(rowcint33sig01);
    cint33si.setROWCCMN01UIG00(rowccmn01uig00);
    cint33si.setGenericStruct(genericstruct);

    // SIR 23965 - Changed the WTCHelper to ServiceHelper.
    CINT33SO cint33so = (CINT33SO) ServiceHelper.callService("CINT33S", cint33si, CINT33SO.class);

  }

  public final int NUM_OF_ROWS = 50;
  public final String DOC_TYPE_REQUEST_ATTRIBUTE = "docType";
}