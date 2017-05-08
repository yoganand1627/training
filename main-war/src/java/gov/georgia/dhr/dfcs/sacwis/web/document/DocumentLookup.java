package gov.georgia.dhr.dfcs.sacwis.web.document;

import java.util.Map;

public class DocumentLookup {

  static Map<String, String> documentsMetaData = null;

  static void setMetaData(Map<String, String> documentsMetaData) {
    DocumentLookup.documentsMetaData = documentsMetaData;
  }

  public static String lookup(String docType) {
    return documentsMetaData.get(docType);
  }

  public static Map<String, String> getDocumentsMetaData() {
    return documentsMetaData;
  }
}