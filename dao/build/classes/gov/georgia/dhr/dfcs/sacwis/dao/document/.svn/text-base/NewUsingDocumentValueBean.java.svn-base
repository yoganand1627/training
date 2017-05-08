package gov.georgia.dhr.dfcs.sacwis.dao.document;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class NewUsingDocumentValueBean extends BaseValueBean {
  private byte[] documentData = null;
  private Integer templateId;

  public void setDocumentData(byte[] documentData) {
    this.documentData = documentData;
  }

  public void setDocumentData(InputStream documentData) throws IOException {
    BufferedInputStream buffInputStream = new BufferedInputStream(documentData);
    ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();

    byte[] b = new byte[2048];

    for (int n = buffInputStream.read(b); n > 0; n = buffInputStream.read(b)) {
      byteOutputStream.write(b, 0, n);
    }

    this.documentData = byteOutputStream.toByteArray();
  }

  public byte[] getDocumentData() {
    return this.documentData;
  }

  public void setTemplateId(Integer templateId) {
    this.templateId = templateId;
  }

  public Integer getTemplateId() {
    return this.templateId;
  }

}