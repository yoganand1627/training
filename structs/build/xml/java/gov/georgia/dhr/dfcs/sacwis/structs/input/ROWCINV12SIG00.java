/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.input;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class ROWCINV12SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV12SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdEaQuestion
     */
    private java.lang.String _szCdEaQuestion;

    /**
     * Field _ulIdEmergencyAssist
     */
    private int _ulIdEmergencyAssist;

    /**
     * keeps track of state for field: _ulIdEmergencyAssist
     */
    private boolean _has_ulIdEmergencyAssist;

    /**
     * Field _bIndEaResponse
     */
    private java.lang.String _bIndEaResponse;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV12SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEmergencyAssist()
    {
        this._has_ulIdEmergencyAssist= false;
    } //-- void deleteUlIdEmergencyAssist() 

    /**
     * Returns the value of field 'bIndEaResponse'.
     * 
     * @return the value of field 'BIndEaResponse'.
     */
    public java.lang.String getBIndEaResponse()
    {
        return this._bIndEaResponse;
    } //-- java.lang.String getBIndEaResponse() 

    /**
     * Returns the value of field 'szCdEaQuestion'.
     * 
     * @return the value of field 'SzCdEaQuestion'.
     */
    public java.lang.String getSzCdEaQuestion()
    {
        return this._szCdEaQuestion;
    } //-- java.lang.String getSzCdEaQuestion() 

    /**
     * Returns the value of field 'szCdScrDataAction'.
     * 
     * @return the value of field 'SzCdScrDataAction'.
     */
    public java.lang.String getSzCdScrDataAction()
    {
        return this._szCdScrDataAction;
    } //-- java.lang.String getSzCdScrDataAction() 

    /**
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

    /**
     * Returns the value of field 'ulIdEmergencyAssist'.
     * 
     * @return the value of field 'UlIdEmergencyAssist'.
     */
    public int getUlIdEmergencyAssist()
    {
        return this._ulIdEmergencyAssist;
    } //-- int getUlIdEmergencyAssist() 

    /**
     * Method hasUlIdEmergencyAssist
     * 
     * 
     * 
     * @return true if at least one UlIdEmergencyAssist has been
     * added
     */
    public boolean hasUlIdEmergencyAssist()
    {
        return this._has_ulIdEmergencyAssist;
    } //-- boolean hasUlIdEmergencyAssist() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'bIndEaResponse'.
     * 
     * @param bIndEaResponse the value of field 'bIndEaResponse'.
     */
    public void setBIndEaResponse(java.lang.String bIndEaResponse)
    {
        this._bIndEaResponse = bIndEaResponse;
    } //-- void setBIndEaResponse(java.lang.String) 

    /**
     * Sets the value of field 'szCdEaQuestion'.
     * 
     * @param szCdEaQuestion the value of field 'szCdEaQuestion'.
     */
    public void setSzCdEaQuestion(java.lang.String szCdEaQuestion)
    {
        this._szCdEaQuestion = szCdEaQuestion;
    } //-- void setSzCdEaQuestion(java.lang.String) 

    /**
     * Sets the value of field 'szCdScrDataAction'.
     * 
     * @param szCdScrDataAction the value of field
     * 'szCdScrDataAction'.
     */
    public void setSzCdScrDataAction(java.lang.String szCdScrDataAction)
    {
        this._szCdScrDataAction = szCdScrDataAction;
    } //-- void setSzCdScrDataAction(java.lang.String) 

    /**
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'ulIdEmergencyAssist'.
     * 
     * @param ulIdEmergencyAssist the value of field
     * 'ulIdEmergencyAssist'.
     */
    public void setUlIdEmergencyAssist(int ulIdEmergencyAssist)
    {
        this._ulIdEmergencyAssist = ulIdEmergencyAssist;
        this._has_ulIdEmergencyAssist = true;
    } //-- void setUlIdEmergencyAssist(int) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG00 unmarshal(java.io.Reader) 

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
