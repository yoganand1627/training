package gov.georgia.dhr.dfcs.sacwis.dao.person;

import gov.georgia.dhr.dfcs.sacwis.core.utility.CastorArrayHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;

import java.beans.IntrospectionException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: RaceEthnicityBean</p> <p>Description: Holds race and ethnicity data in a standard format, so that it can be
 * accessed from the RaceEthnicitySub.jsp. Typically, the user of this class will get data back from an SO object, copy
 * it into this object, then put the object in the request, for the RaceEthnicitySub.jsp to retreive. Then when the HTML
 * form containing the RaceEthnicitySub.jsp is submitted, this bean gets that data out of the request and collects it
 * into an object. Then the user of the bean copies data out of this bean into an SI object for saving. For more
 * information on how to use this bean see the RaceEthnicitySub Cookbook in the Cookbooks documentation.</p>
 * <p>Copyright: Copyright (c) 2002</p> <p>Company: Accenture</p>
 * <p/>
 * <pre>
 * Change History:
 * Date      User         Description
 * --------  -----------  ----------------------------------------------
 * 09/09/03  CASDORJM     SIR 19738 - Added logic such that the getRaceEthnicityGroup( request ) method would return
 *                        "UT" if the Unable to Determine radio button was selected.  Also modified the static constant
 *                        GROUP_UNABLE_TO_DETERMINE to reference CINDETHN_UT instead of CETHIC_UN.
 * 02/02/04  CORLEYAN     SIR 22588 - GROUP_UNABLE_TO_DETERMINE should reference CETHIC_UN since this is the Ethnic
 *                        Group we are placing the person in based on selections and has nothing to do with what the
 *                        CINDETHN codes table has in it.
 * 05/06/04  CORLEYAN     SIR 22869 Add new groups for the Race/Eth section to account for the Ethnicity of UTD
 * </pre>
 *
 * @author Dann Webster
 * @version 1.0
 */
public class RaceEthnicityBean implements Serializable {

  /** The name of the property that holds race data in SO and SI objects. Value = szCdPersonRace. */
  public static final String RACE_FIELD_NAME = "szCdPersonRace";

  /**
   * Name of the Person Ethnicity field in the castor objects and service SI and SO structures. This constant is used
   * for introspection. Value = szCdPersonEthnicity.
   */
  public static final String ETHNICITY_FIELD_NAME = "szCdPersonEthnicity";

  // clarification of group indicators codes table codes

  // clarification of race codes table codes

  // clarification of ethnicity indicators codes table codes

  private Races races = null;
  private String ethnicity = null;
  private String oldEthnicity = null;

  /** Null Constructor */
  public RaceEthnicityBean() {
  }

  /**
   * @param raceData      a Castor class that holds race data; has the szCdPersonRace field.
   * @param ethnicityData a Castor class that holds ethnicity data; has the szCdPersonEthnicity field.
   * @throws IntrospectionException
   */
  public RaceEthnicityBean(XmlValueBean raceData, XmlValueBean ethnicityData)
          throws IntrospectionException {
    setRaces(raceData);
    setEthnicity(ethnicityData);
  }

  /**
   * Gets the ethnicity data that was or will be stored in the ETHNICITY_RB_NAME radio button.
   *
   * @return value from the CINDETHN table ( one of the constants beginning ETHNICITY )
   */
  public String getEthnicity() {
    return this.ethnicity;
  }

  /**
   * Gets the ethnicity data before the radio button was checked. Once the bean has been populated from the request,
   * this field will correspond to the value in the OLD_ETHNICITY_NAME hidden field.
   *
   * @return value from the CINDETHN table ( one of the constants beginning ETHNICITY )
   */
  public String getOldEthnicity() {
    return this.oldEthnicity;
  }

  /**
   * Gets a RaceEthnicityBean.Races object, which is a list of the races
   *
   * @return a list of the races associated with this bean
   */
  public RaceEthnicityBean.Races getRaces() {
    return this.races;
  }

  /** @param races  */
  public void setRaces(Races races) {
    this.races = races;
  }

  /**
   * @param raceData
   * @throws IntrospectionException
   */
  public void setRaces(XmlValueBean raceData) throws IntrospectionException {
    this.races = new Races(raceData);
  }

  /**
   * @param ethnicityData
   * @throws IntrospectionException
   */
  public void setEthnicity(XmlValueBean ethnicityData) throws IntrospectionException {
    List ethnicityValues;
    if (ethnicityData != null) {
      ethnicityValues = CastorArrayHelper.getStringVector(
              ethnicityData,
              RaceEthnicityBean.ETHNICITY_FIELD_NAME
      );
    } else {
      ethnicityValues = new ArrayList();
    }

    // if there is something in the person ethnicity list, get that out
    // and stick it in personEthnicity.
    String personEthnicity = StringHelper.EMPTY_STRING;
    Iterator personEthIterator = ethnicityValues.iterator();
    if (personEthIterator.hasNext()) {
      personEthnicity = (String) personEthIterator.next();
    }
    this.ethnicity = personEthnicity;
  }

  /** @param ethnicity  */
  public void setEthnicity(String ethnicity) {
    this.ethnicity = ethnicity;
  }

  /** @param oldEthnicity  */
  public void setOldEthnicity(String oldEthnicity) {
    this.oldEthnicity = oldEthnicity;
  }

  public static class Races extends HashMap<String, String> implements Serializable {

    /**
     * This must be transient, or serialization will fail if we are in the middle of an iteration.
     */
    transient Iterator iterator;

    public Races() {
    }

    public Races(Map<String, String> map) {
      super(map);
    }

    public Races(XmlValueBean raceData)
            throws IntrospectionException {
      List races = CastorArrayHelper.getStringVector(raceData, RACE_FIELD_NAME);
      for (Iterator i = races.iterator(); i.hasNext();) {
        String option = (String) i.next();
        this.put(option, "");
      }
    }

    public List<String> getStringVector() {
      return new ArrayList<String>(super.keySet());
    }

    public String put(String value, String actionCode) {
      return super.put(value, actionCode);
    }

    public boolean hasNext() {
      if (iterator == null) {
        iterator = super.entrySet().iterator();
      }
      return iterator.hasNext();
    }

    public Race next() {
      Map.Entry me;
      if (iterator == null) {
        iterator = super.entrySet().iterator();
      }
      me = (Map.Entry) iterator.next();
      return new Race((String) me.getKey(), (String) me.getValue());
    }
  }

  public static class Race implements Serializable {
    String value;
    String actionCode;

    public Race() {
    }

    public Race(String value, String actionCode) {
      setValue(value);
      setActionCode(actionCode);
    }

    public void setActionCode(String actionCode) {
      this.actionCode = actionCode;
    }

    public void setValue(String value) {
      this.value = value;
    }

    public String getActionCode() {
      return actionCode;
    }

    public String getValue() {
      return value;
    }
  }

}