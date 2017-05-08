/**
 * Created on Sep 13, 2006 at 3:16:12 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.ant;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Stack;
import java.util.Vector;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.apache.tools.ant.filters.BaseFilterReader;
import org.apache.tools.ant.filters.ChainableReader;
import org.apache.tools.ant.util.LineTokenizer;

@SuppressWarnings({"AccessOfSystemProperties"})
public class OverridePropertiesFilter extends BaseFilterReader implements ChainableReader {

  public static final String LINE_BREAK = System.getProperty("line.separator");

  private File overridePropertiesFile;

  private Properties overrideProperties = null;
  private InputStreamReader input;
  private LineTokenizer tokenizer = new LineTokenizer();
  private String bufferedLine = null;
  private int lineIndex = 0;

  public OverridePropertiesFilter() {
  }

  public OverridePropertiesFilter(final Reader in) {
    super(in);
  }

  public void setOverrideProperties(File overridePropertiesFile) {
    this.overridePropertiesFile = overridePropertiesFile;
  }

  public int read() throws IOException {
    if (overrideProperties == null) {
      initialize();
    }
    if (bufferedLine != null && lineIndex < bufferedLine.length()) {
      return bufferedLine.charAt(lineIndex++);
    }
    lineIndex = 0;
    bufferedLine = tokenizer.getToken(input);
    if (bufferedLine == null) {
      return -1;
    }
    // Handle muli-line properties.
    // //TODO: Make multi-line keys work.
    while (bufferedLine.endsWith("\\")) {
      String nextLine = tokenizer.getToken(input);
      if (nextLine == null) {
        break;
      }
      bufferedLine += (LINE_BREAK + nextLine);
    }
    bufferedLine += LINE_BREAK;
    // Handle comments and blank lines.
    String trimmedLine = bufferedLine.trim();
    if (trimmedLine.length() == 0 || trimmedLine.startsWith("!") || trimmedLine.startsWith("#")) {
      // Safe because we already have at least a line break.
      return bufferedLine.charAt(lineIndex++);
    }
    // Separate out the key and value.
    String[] pair = bufferedLine.split("(?<!\\\\)(=|!|\\s+)", 2);
    String key = pair[0].trim();
    String value = pair.length > 1 ? pair[1].trim() : "";
    if (overrideProperties.containsKey(key)) {
      String newValue = overrideProperties.getProperty(key);
      getProject().log(key + ": " + value + " -> " + newValue, Project.MSG_VERBOSE);
      value = newValue;
    } else {
      getProject().log(key + ": no change", Project.MSG_VERBOSE);
    }
    // Create a new line using "=" as the delimiter
    bufferedLine = key + "=" + value + LINE_BREAK;
    return bufferedLine.charAt(lineIndex++);
  }

  public Reader chain(Reader rdr) {
    OverridePropertiesFilter newFilter = new OverridePropertiesFilter(rdr);
    newFilter.setOverrideProperties(overridePropertiesFile);
    newFilter.setProject(getProject());
    return newFilter;
  }

  private final void initialize() {
    if (overridePropertiesFile == null) {
      throw new BuildException("Properties file is not set.");
    }
    try {
      // Load the properties file that we will override.
      Properties bufferedProperties = new Properties();
      String bufferedPropertiesString = this.readFully();
      // Use the default encoding.
      InputStream bufferedInputStream = new ByteArrayInputStream(bufferedPropertiesString.getBytes());
      bufferedProperties.load(bufferedInputStream);
      // Reset the input stream so we can use it later.
      bufferedInputStream.reset();
      //noinspection IOResourceOpenedButNotSafelyClosed
      this.input = new InputStreamReader(bufferedInputStream);
      FileInputStream inStream = null;
      try {
        getProject().log("Using overrides from: " + overridePropertiesFile.getAbsolutePath(), Project.MSG_INFO);
        inStream = new FileInputStream(overridePropertiesFile);
        Properties overrideProperties = new Properties();
        overrideProperties.load(inStream);
        // Add the override properties to the buffered properties.
        //noinspection UseOfPropertiesAsHashtable
        bufferedProperties.putAll(overrideProperties);
      } finally {
        if (inStream != null) {
          inStream.close();
        }
      }
      // Start resolving properties
      resolveAllProperties(bufferedProperties);
      // Go through the properties.  Epand as necessary and add to override properties.
      this.overrideProperties = new Properties();
      for (Iterator<Object> it = bufferedProperties.keySet().iterator(); it.hasNext();) {
        String key = (String) it.next();
        String value = getProject().replaceProperties(bufferedProperties.getProperty(key));
        // Add the properties to those actually used for overrides.
        getProject().log("Loaded and resolved: " + key + "=" + value, Project.MSG_VERBOSE);
        this.overrideProperties.setProperty(key, value);
      }
    } catch (IOException e) {
      throw new BuildException("Failed while initializing properties: " + overridePropertiesFile.getAbsolutePath(), e);
    }
  }

  /**
   * Copied from {@link org.apache.tools.ant.taskdefs.Property#resolveAllProperties(java.util.Properties)}.
   *
   * @see org.apache.tools.ant.taskdefs.Property#resolveAllProperties(java.util.Properties)
   */
  private void resolveAllProperties(Properties props) throws BuildException {
    for (Enumeration e = props.keys(); e.hasMoreElements();) {
      String name = (String) e.nextElement();
      Stack referencesSeen = new Stack();
      resolve(props, name, referencesSeen);
    }
  }

  /**
   * Copied from {@link org.apache.tools.ant.taskdefs.Property#resolveAllProperties(java.util.Properties)}.
   *
   * @see org.apache.tools.ant.taskdefs.Property#resolveAllProperties(java.util.Properties)
   */
  @SuppressWarnings({"deprecation", "UseOfObsoleteCollectionType", "unchecked", "UseOfPropertiesAsHashtable"})
  private void resolve(Properties props, String name, Stack referencesSeen) throws BuildException {
    if (referencesSeen.contains(name)) {
      throw new BuildException("Property " + name + " was circularly defined.");
    }

    String value = props.getProperty(name);
    Vector fragments = new Vector();
    Vector propertyRefs = new Vector();
    ProjectHelper.parsePropertyString(value, fragments, propertyRefs);

    if (propertyRefs.size() != 0) {
      referencesSeen.push(name);
      StringBuffer sb = new StringBuffer();
      Enumeration i = fragments.elements();
      Enumeration j = propertyRefs.elements();
      while (i.hasMoreElements()) {
        String fragment = (String) i.nextElement();
        if (fragment == null) {
          String propertyName = (String) j.nextElement();
          fragment = getProject().getProperty(propertyName);
          if (fragment == null) {
            if (props.containsKey(propertyName)) {
              resolve(props, propertyName, referencesSeen);
              fragment = props.getProperty(propertyName);
            } else {
              fragment = "${" + propertyName + "}";
            }
          }
        }
        sb.append(fragment);
      }
      value = sb.toString();
      props.put(name, value);
      referencesSeen.pop();
    }
  }
}
