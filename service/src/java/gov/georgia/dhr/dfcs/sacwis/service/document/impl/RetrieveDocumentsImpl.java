package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.ContactNarrativeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContactNarrative;
import gov.georgia.dhr.dfcs.sacwis.service.document.RetrieveDocuments;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.document.GetDocumentsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.document.GetDocumentsSO;

public class RetrieveDocumentsImpl extends BaseServiceImpl implements RetrieveDocuments {

  private static final String CONTACT_NARRATIVES = "contactnarr";

  private ContactNarrativeDAO contactNarrativeDAO;

  public void setContactNarrativeDAO(ContactNarrativeDAO contactNarrativeDAO) {
    this.contactNarrativeDAO = contactNarrativeDAO;
  }

  public GetDocumentsSO retrieveDocuments(GetDocumentsSI getDocumentsSI) {
    GetDocumentsSO getDocumentsSO = new GetDocumentsSO();
    List<Map> contactNarrativeList = new ArrayList<Map>();
    List<Integer> idEventContactNarrativeList = new ArrayList<Integer>();
    List<String> documentTypes = getDocumentsSI.getDocTypes();
    for (String documentType : documentTypes) {
      if (CONTACT_NARRATIVES.equals(documentType)) {
        contactNarrativeList = getContactNarratives();
//        idEventContactNarrativeList = getIdEventsContactNarratives();
      }
    }
    getDocumentsSO.setContactNarratives(contactNarrativeList);
//    getDocumentsSO.setIdEventContactNarratives(idEventContactNarrativeList);

    return getDocumentsSO;
  }

  private List<Map> getContactNarratives() {
    return contactNarrativeDAO.findAllContactNarratives();
  }
  
  private List<Integer> getIdEventsContactNarratives() {
    return contactNarrativeDAO.findAllIdEventsForContactNarratives();
  }
}
