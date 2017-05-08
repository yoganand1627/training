package gov.georgia.dhr.dfcs.sacwis.core.xml;

import java.io.StringReader;
import java.io.StringWriter;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

public abstract class XmlValueBean extends BaseValueBean {
  private boolean moreDataAvailable = false;

  public boolean isMoreDataAvailable() {
    return moreDataAvailable;
  }

  public void setMoreDataAvailable(boolean bMoreDataInd) {
    this.moreDataAvailable = bMoreDataInd;
  }

  /**
   * Convenience method for populating arch output struct.
   *
   * @return
   */
  public String getBMoreDataInd() {
    return moreDataAvailable ? ArchitectureConstants.Y : ArchitectureConstants.N;
  }

  public static XmlValueBean toXmlValueBean(String xml, Class beanClass) {
    try {
      StringReader reader = new StringReader(xml);
      return (XmlValueBean) Unmarshaller.unmarshal(beanClass, reader);
    }
    catch (Throwable e) {
      throw new RuntimeWrappedException(e);
    }
  }

  public String toString() {
    return toString(true);
  }

  public String toString(boolean printXmlHeader) {
    try {
      StringWriter writer = new StringWriter();
      Marshaller marshaller = new Marshaller(writer);
      marshaller.setEncoding(ArchitectureConstants.CHARACTER_ENCODING);
      marshaller.setMarshalAsDocument(printXmlHeader);
      marshaller.marshal(this);
      return writer.toString();
    }
    catch (Exception e) {
      throw new RuntimeWrappedException(e);
    }
  }

  public XmlValueBean toXmlValueBean(String xml) throws MarshalException, ValidationException {
    //!!! Do we really need this method to explicitly declare these exceptions?
    StringReader reader = new StringReader(xml);
    return (XmlValueBean) Unmarshaller.unmarshal(this.getClass(), reader);
  }
}





