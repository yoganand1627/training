package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PptParticipantDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PptParticipant;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrievePPTParticipant;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB27SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB27SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB27SOG00_ARRAY;

import java.util.Iterator;
import java.util.List;

public class RetrievePPTParticipantImpl extends BaseServiceImpl implements RetrievePPTParticipant {

  private PptParticipantDAO pptParticipantDAO = null;

  public void setPptParticipantDAO(PptParticipantDAO pptParticipantDAO) {
    this.pptParticipantDAO = pptParticipantDAO;
  }

  public CSUB27SO retrievePPTParticipant(CSUB27SI csub27si) {

    CSUB27SO csub27so = new CSUB27SO();
    // clss26d
    List<PptParticipant> pptParticipantList = pptParticipantDAO.findPptParticipantByIdEvent(csub27si.getUlIdPptEvent());
    ROWCSUB27SOG00_ARRAY rowscub27sog00_array = new ROWCSUB27SOG00_ARRAY();
    ArchOutputStruct aoStruct = new ArchOutputStruct();
    if (pptParticipantList != null && !(pptParticipantList.isEmpty())) {
      for (Iterator<PptParticipant> it = pptParticipantList.iterator(); it.hasNext();) {
        PptParticipant pptParticipant = it.next();
        ROWCSUB27SOG00 rowscub27sog00 = new ROWCSUB27SOG00();
        
        rowscub27sog00.setSzCdPptPartType(pptParticipant.getCdPptPartType());
        if (!(CodesTables.CPARTYPE_OTH.equals(rowscub27sog00.getSzCdPptPartType()))){
          rowscub27sog00.setUlIdPerson(pptParticipant.getPerson().getIdPerson() != null ?
                                     pptParticipant.getPerson().getIdPerson() : 0);
        }
        rowscub27sog00.setUlIdPptPart(pptParticipant.getIdPptPart() != null ? pptParticipant.getIdPptPart() : 0);
        rowscub27sog00.setSzNmPptPartFull(pptParticipant.getNmPptPartFull());
        rowscub27sog00.setSzSdsPptPartRelationship(pptParticipant.getSdsPptPartRelationship());
        rowscub27sog00.setSzCdPptNotifType(pptParticipant.getCdPptNotifType());
        rowscub27sog00.setDtDtPptPartDateNotif(DateHelper.toCastorDate(pptParticipant.getDtPptPartDateNotif()));
        rowscub27sog00.setDtDtPptDate(DateHelper.toCastorDate(pptParticipant.getDtPptPart()));
        rowscub27sog00.setTsLastUpdate(pptParticipant.getDtLastUpdate());
        rowscub27sog00.setIndAccptdChnges(pptParticipant.getIndAccptdChanges());
        rowscub27sog00.setIndReqAh(pptParticipant.getIndReqAh());
        rowscub27sog00.setIndSignedWvrAh(pptParticipant.getIndSignedWvrAh());
        rowscub27sog00.setTxtAgency(pptParticipant.getNmPptPartAgency());
        rowscub27sog00.setTxtTitle(pptParticipant.getCdPptPartTitle());
        rowscub27sog00_array.addROWCSUB27SOG00(rowscub27sog00);
      }
      rowscub27sog00_array.setUlRowQty(pptParticipantList.size());
      if (pptParticipantList.size() > 0) {
        aoStruct.setBMoreDataInd(ArchitectureConstants.N);
        aoStruct.setUlRowQty(rowscub27sog00_array.getUlRowQty());
      }
    }
    csub27so.setROWCSUB27SOG00_ARRAY(rowscub27sog00_array);
    csub27so.setArchOutputStruct(aoStruct);
    return csub27so;
  }

}
