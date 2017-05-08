/**
 * Accenture modified code originally found in the Java Petstore Application
 *
 * $Id: ScreenFlowXmlDAO.java,v 1.9.4.6 2001/03/15 00:40:05 brydon Exp $
 * Copyright 2001 Sun Microsystems, Inc. All rights reserved.
 *
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.decorator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/** This class reads in the screendefinitions.xml values and translates them into Java collection objects */
public class ScreenDefinitionsXmlDao {

  public static final String URL = "url";
  //BEE - if we change screen defs to use templateDefault, change this static def.
  //     public static final String TEMPLATE_DEFAULT  = "templateDefault";
  public static final String TEMPLATE_DEFAULT = "template";
  public static final String SCREEN_DEFINITION = "screen-definition";
  public static final String LANGUAGE = "language";

  public static final String KEY = "key";
  public static final String VALUE = "value";
  public static final String DIRECT = "direct";
  public static final String SCREEN = "screen";
  public static final String SCREEN_NAME = "screen-name";
  public static final String PARAMETER = "parameter";

  private static final String TRACE_TAG = "ScreenDefinitionsXmlDao";

  /**
   * Given an xml file's location, read in the xml document and return a dom element.
   *
   * @param context  the context of the current request
   * @param filePath the path of the xml file
   * @return a dom element representing the xml data
   * @throws Exception if an error occurs while parsing the xml
   */
  public static Element loadDocument(GrndsExchangeContext context, String filePath)
          throws DecoratorException, FileNotFoundException {
    GrndsTrace.enterScope(ScreenDefinitionsXmlDao.TRACE_TAG + ".loadDocument()");
    InputStream inStream = null;
    Element root = null;
    try {
      inStream = context.getServletContext().getResourceAsStream(filePath);
      //BEE - if getResourceAsStream didn't work, try opening it through FILE I/O directly
      if (inStream == null) {
        GrndsTrace.msg(ScreenDefinitionsXmlDao.TRACE_TAG, 5,
                       "*** Non Fatal error: " + filePath +
                       " not located as a resource so will try opening directly as a file");
        inStream = new FileInputStream(new File(filePath));
      }
      try {
        InputSource xmlInp = new InputSource(inStream);

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = docBuilderFactory.newDocumentBuilder();
        Document doc = parser.parse(xmlInp);
        root = doc.getDocumentElement();
        root.normalize();
        GrndsTrace.exitScope(root);
      } catch (SAXParseException err) {
        throw new DecoratorException("ScreenFlowXmlDAO ** Parsing error" + ", line " +
                                     err.getLineNumber() + ", uri " + err.getSystemId() +
                                     ", message " + err.getMessage(), err, DecoratorException.WARNING_PRIORITY);
      } catch (ParserConfigurationException e) {
        throw new DecoratorException("ScreenFlowXmlDAO ** Parsing configuration error", e,
                                     DecoratorException.WARNING_PRIORITY);
      } catch (SAXException e) {
        throw new DecoratorException("ScreenFlowXmlDAO ** SAX Exception", e, DecoratorException.WARNING_PRIORITY);
      } catch (IOException e) {
        throw new DecoratorException("ScreenFlowXmlDAO ** IO Exception", e, DecoratorException.WARNING_PRIORITY);
      }
    } finally {
      try {
        if (inStream != null) {
          inStream.close();
        }
      } catch (IOException e) {
        // Ignore this.
      }
    }
    return root;
  }

  /**
   * This method uses the loadDocument method to read in the xml file and then translates them into a HashMap by passing
   * the DOM element into the getScreens() method.
   *
   * @param location to the xml file
   * @param context
   * @return map of the screen definitions
   * @throws DecoratorException    if an error occurs while parsing the xml or translating them into screens
   * @throws FileNotFoundException if an error occurs while parsing the xml or translating them into screens
   */
  public static synchronized Map loadScreenDefinitions(GrndsExchangeContext context, String location)
          throws DecoratorException, FileNotFoundException {
    GrndsTrace.enterScope(ScreenDefinitionsXmlDao.TRACE_TAG + ".loadScreenDefinitions()");
    Element root = loadDocument(context, location);
    Map screens = getScreens(root);
    GrndsTrace.exitScope(screens);
    return screens;
  }

  /** Method takes a DOM root and translates it into a HashMap of screen definitions */
  public static Map getScreenDefinitions(Element root) {
    GrndsTrace.enterScope(ScreenDefinitionsXmlDao.TRACE_TAG + ".getScreenDefinitions()");
    Map<String, String> screensDefs = new HashMap<String, String>();
    NodeList list = root.getElementsByTagName(SCREEN_DEFINITION);
    for (int loop = 0; loop < list.getLength(); loop++) {
      Node node = list.item(loop);
      if (node != null) {
        String language = null;
        String url = null;
        if (node instanceof Element) {
          language = ((Element) node).getAttribute(LANGUAGE);
          url = ((Element) node).getAttribute(URL);
        }
        if ((language != null) && (url != null) && !screensDefs.containsKey(language)) {
          screensDefs.put(language, url);
        } else {
          GrndsTrace.msg(ScreenDefinitionsXmlDao.TRACE_TAG, 5,
                         "Non Fatal errror: ScreenDefinitions for language " + language +
                         " defined more than once in screen definitions file");
        }
      }
    }
    GrndsTrace.exitScope();
    return screensDefs;
  }

  /**
   * Method takes a DOM element and reads in both the template value and the screens and puts them into the returned
   * HashMap
   */
  public static Map<String, Screen> getScreens(Element root) {
    GrndsTrace.enterScope(ScreenDefinitionsXmlDao.TRACE_TAG + ".getScreens()");
    Map<String, Screen> screens = new HashMap<String, Screen>();
    // get the template
    String templateName = getTagValue(root, TEMPLATE_DEFAULT);
    // get screens
    NodeList list = root.getElementsByTagName(SCREEN);
    for (int loop = 0; loop < list.getLength(); loop++) {
      Node node = list.item(loop);
      if (node != null) {
        String screenName = getSubTagValue(node, SCREEN_NAME);
        Map<String, Parameter> parameters = getParameters(node);
        Screen screen = new Screen(screenName, parameters);
        //check for special template
        Parameter screenTemplate = screen.getParameter("template");
        if (screenTemplate != null) {
          screen.setTemplate(screenTemplate.getValue());
        } else {
          screen.setTemplate(templateName);
        }

        if (!screens.containsKey(screenName)) {
          screens.put(screenName, screen);
        } else {
          GrndsTrace.msg(ScreenDefinitionsXmlDao.TRACE_TAG, 5, "*** Non Fatal errror: Screen " + screenName +
                                                               " defined more than once in screen definitions file");
        }
      }
    }
    GrndsTrace.exitScope();
    return screens;
  }

  static String getTagValue(Element root, String tagName) {
    GrndsTrace.enterScope(ScreenDefinitionsXmlDao.TRACE_TAG + ".getTagValue()");
    String returnString = "";
    NodeList list = root.getElementsByTagName(tagName);
    for (int loop = 0; loop < list.getLength(); loop++) {
      Node node = list.item(loop);
      if (node != null) {
        Node child = node.getFirstChild();
        if ((child != null) && child.getNodeValue() != null) {
          return child.getNodeValue();
        }
      }
    }
    GrndsTrace.exitScope(returnString);
    return returnString;
  }

  static Map<String, Parameter> getParameters(Node node) {
    Map<String, Parameter> params = new HashMap<String, Parameter>();
    if (node != null) {
      NodeList children = node.getChildNodes();
      for (int innerLoop = 0; innerLoop < children.getLength(); innerLoop++) {
        Node child = children.item(innerLoop);
        if ((child != null) && (child.getNodeName() != null) &&
            child.getNodeName().equals(PARAMETER)) {
          if (child instanceof Element) {
            Element childElement = ((Element) child);
            String key = childElement.getAttribute(KEY);
            String value = childElement.getAttribute(VALUE);
            String directString = childElement.getAttribute(DIRECT);
            boolean direct = false;
            if ((directString != null) && "true".equals(directString)) {
              direct = true;
            }
            if (!params.containsKey(key)) {
              params.put(key, new Parameter(key, value, direct));
            } else {
              GrndsTrace.msg(ScreenDefinitionsXmlDao.TRACE_TAG, 5,
                             "*** Non Fatal errror: Parameter " + key +
                             " is defined more than once");
            }
          }
        }
      } // end inner loop
    }
    return params;
  }

  static String getSubTagValue(Node node, String subTagName) {
    String returnString = "";
    if (node != null) {
      NodeList children = node.getChildNodes();
      for (int innerLoop = 0; innerLoop < children.getLength(); innerLoop++) {
        Node child = children.item(innerLoop);
        if ((child != null) && (child.getNodeName() != null) &&
            child.getNodeName().equals(subTagName)) {
          Node grandChild = child.getFirstChild();
          if (grandChild.getNodeValue() != null) {
            return grandChild.getNodeValue();
          }
        }
      } // end inner loop
    }
    return returnString;
  }
}










