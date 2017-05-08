package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.DocumentTemplateDAO;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveDocumentTemplate;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DocumentTemplateSI;

public class RetrieveDocumentTemplateImpl extends BaseServiceImpl implements RetrieveDocumentTemplate {

  private DocumentTemplateDAO documentTemplateDAO = null;

  public Integer retrieveDocumentTemplate(DocumentTemplateSI documentTemplateSI) {
    return documentTemplateDAO.retrieveDocumentTemplate(documentTemplateSI.getDocument(),
                                                        documentTemplateSI.getMajor(), documentTemplateSI.getMinor(),
                                                        documentTemplateSI.getRevision());

  }

  public void setDocumentTemplateDAO(DocumentTemplateDAO documentTemplateDAO) {
    this.documentTemplateDAO = documentTemplateDAO;
  }
}
