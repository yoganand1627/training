package gov.georgia.dhr.dfcs.sacwis.web.core.validation;

// SIR# 17068
// DWW: 05/08/2003
// Unlike in normal schemas, where the enumeration lists
// possible correct values, the enumeration is this
// implementation is a list of EXCLUDED/disallowed values.
// Any value that shows up in this list should be rejected.
// this required all references to the 'allowedValues' property
// to be changed to be called 'disallowedValues'

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.validation.Constraint;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.grnds.facility.log.GrndsTrace;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.apache.oro.text.regex.MalformedPatternException;

/**
 * Parses an XML Schema into a HashMap of constraints. Based on code examples by Brett McLaughlin.
 *
 * @author Nick Sharples
 */
public class SchemaParser {

  private static final String SCHEMA_NAMESPACE_URI = "http://www.w3.org/2001/XMLSchema";
  private static DocumentBuilderFactory DOC_FACTORY = DocumentBuilderFactory.newInstance();
  private static final String TRACE_TAG = "SchemaParser";

  private final URL schemaURL;
  private final Map<String, Constraint> constriaints = new HashMap<String, Constraint>();

  /** Default Constructor */
  public SchemaParser(URL source) {
    this.schemaURL = source;
  }

  /**
   * Get the constraint objects that were configured by the XML Schema.
   *
   * @return HashMap containing Constraint objects indexed by Constraint name.
   */
  public Map getConstraints() {
    return this.constriaints;
  }

  /**
   * Get a Constraint object given the constraint name
   *
   * @param constraintName the name of the Cosntraint
   * @return Constraint the Constaraint object
   */
  public Constraint getConstraint(String constraintName) {
    return this.constriaints.get(constraintName);
  }

  /** Use the information in an XML Schema file to create and configure a set of named Constraints. */
  public void parseSchema() throws IOException, MalformedPatternException {
    Reader in = null;
    try {
      URLConnection conn = this.schemaURL.openConnection();
      in = new InputStreamReader(conn.getInputStream());

      DOC_FACTORY.setNamespaceAware(true);
      DocumentBuilder b = DOC_FACTORY.newDocumentBuilder();
      Document doc = b.parse(new org.xml.sax.InputSource(in));
      in.close();

      GrndsTrace.msg(TRACE_TAG, 3, "schema url = " + schemaURL);
      GrndsTrace.msg(TRACE_TAG, 3, "factory namespace aware =  " + DOC_FACTORY.isNamespaceAware());
      GrndsTrace.msg(TRACE_TAG, 3, "builder namespace aware =  " + b.isNamespaceAware());

      NodeList typeList = doc.getElementsByTagNameNS(SCHEMA_NAMESPACE_URI, "attribute");

      GrndsTrace.msg(TRACE_TAG, 3, "number of nodes = " + typeList.getLength());
      for (int typeNdx = 0; typeNdx < typeList.getLength(); typeNdx++) {
        this.handleAttribute((Element) typeList.item(typeNdx));
      }
    } catch (SAXException e) {
      throw new RuntimeWrappedException(e);
    } catch (ParserConfigurationException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      if (in != null) {
        in.close();
      }
    }
  }

  /** Set the proper Constraint object attribute given an XML Schema attribute element. */
  void handleAttribute(Element attribute) throws IOException, MalformedPatternException {
    // Get the name of the constraint
    String name = attribute.getAttributes().getNamedItem("name").getNodeValue();
    GrndsTrace.msg(TRACE_TAG, 3, "attribute name = " + name);

    if (name == null) {
      throw new IOException("All schema attributes must have names");
    }

    Constraint constraint = new Constraint(name);

    // Get any description that might be supplied in order
    // to be used as an error string
    NodeList docList = attribute.getElementsByTagNameNS(SCHEMA_NAMESPACE_URI, "appinfo");
    if (docList.getLength() > 0) {
      StringBuffer docBuff = new StringBuffer();
      for (int ndx = 0; ndx < docList.getLength(); ndx++) {
        String s = docList.item(ndx).getFirstChild().getNodeValue();
        docBuff.append(s);
        if (ndx < docList.getLength() - 1) {
          docBuff.append(ArchitectureConstants.LINE_BREAK);
        }
      }
      constraint.setDescription(docBuff.toString());
    }

    // Get the type name for the attribute (may be null)
    String schemaType = attribute.getAttribute("type");
    if (schemaType != null) {
      constraint.setDataType(DataConverter.getJavaType(schemaType));
    }

    // Add the constraint reference to the constraints collection
    constriaints.put(name, constraint);

    // Get the simple type
    NodeList simpleTypeList = attribute.getElementsByTagNameNS(SCHEMA_NAMESPACE_URI, "simpleType");
    if (simpleTypeList.getLength() == 0) {
      return;
    }

    // Get the restriction
    NodeList restrictList = ((Element) simpleTypeList.item(0)).getElementsByTagNameNS(SCHEMA_NAMESPACE_URI,
                                                                                      "restriction");
    if (restrictList.getLength() == 0) {
      throw new IOException("No restriction specified for " + schemaType);
    }
    Element restrictElem = (Element) restrictList.item(0);

    // Get the base type for the constraint
    schemaType = restrictElem.getAttribute("base");
    constraint.setDataType(DataConverter.getJavaType(schemaType));

    // Get any pattern restriction
    NodeList patternList = restrictElem.getElementsByTagNameNS(SCHEMA_NAMESPACE_URI, "pattern");
    if (patternList.getLength() > 0) {
      Element patternElem = (Element) patternList.item(0);
      String value = patternElem.getAttribute("value");
      constraint.setPattern(value);

      // Compile and cache the pattern
      ValidationPatternMatcher matcher = ValidationPatternMatcher.getInstance(this.schemaURL);
      matcher.addPattern(value);
    }

    // Get any allowed or disallowed values
    NodeList allowedValues = restrictElem.getElementsByTagNameNS(SCHEMA_NAMESPACE_URI, "enumeration");
    for (int ndx = 0; ndx < allowedValues.getLength(); ndx++) {
      Element allowedValueElem = (Element) allowedValues.item(ndx);
      String value = allowedValueElem.getAttribute("value");
      if (value != null) {
        // 05/09/2003: DWW SIR 17068
        // if the value in the enumeration begins with a !, then it is a disallowed
        // value, otherwise, it is an allowed value
        if (value.charAt(0) == '!') {
          value = value.substring(1);
          constraint.addDisallowedValue(value);
        } else {
          constraint.addAllowedValue(value);
        }
      }
    }

    // Get any min/max length
    NodeList lengthList = restrictElem.getElementsByTagNameNS(SCHEMA_NAMESPACE_URI, "minLength");
    if (lengthList.getLength() > 0) {
      Element lengthElem = (Element) lengthList.item(0);
      String value = lengthElem.getAttribute("value");
      Double d = new Double(value);
      constraint.setMinLength(d);
    }
    lengthList = restrictElem.getElementsByTagNameNS(SCHEMA_NAMESPACE_URI, "maxLength");
    if (lengthList.getLength() > 0) {
      Element lengthElem = (Element) lengthList.item(0);
      String value = lengthElem.getAttribute("value");
      Double d = new Double(value);
      constraint.setMaxLength(d);
    }

    // Get any boudry restrictions
    // Get min inclusive
    NodeList boundryList = restrictElem.getElementsByTagNameNS(SCHEMA_NAMESPACE_URI, "minInclusive");
    if (boundryList.getLength() > 0) {
      Element boundryElem = (Element) boundryList.item(0);
      String value = boundryElem.getAttribute("value");
      Double d = new Double(value);
      constraint.setMinInclusive(d);
    }

    // Get max inclusive
    boundryList = restrictElem.getElementsByTagNameNS(SCHEMA_NAMESPACE_URI, "maxInclusive");
    if (boundryList.getLength() > 0) {
      Element boundryElem = (Element) boundryList.item(0);
      String value = boundryElem.getAttribute("value");
      Double d = new Double(value);
      constraint.setMaxInclusive(d);
    }

    // Get min exclusive
    boundryList = restrictElem.getElementsByTagNameNS(SCHEMA_NAMESPACE_URI, "minExclusive");
    if (boundryList.getLength() > 0) {
      Element boundryElem = (Element) boundryList.item(0);
      String value = boundryElem.getAttribute("value");
      Double d = new Double(value);
      constraint.setMinExclusive(d);
    }

    // Get max exclusive
    boundryList = restrictElem.getElementsByTagNameNS(SCHEMA_NAMESPACE_URI, "maxExclusive");
    if (boundryList.getLength() > 0) {
      Element boundryElem = (Element) boundryList.item(0);
      String value = boundryElem.getAttribute("value");
      Double d = new Double(value);
      constraint.setMaxExclusive(d);
    }
  }
}











