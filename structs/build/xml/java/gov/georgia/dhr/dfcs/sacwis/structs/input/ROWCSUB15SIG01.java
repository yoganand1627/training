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
 * Class ROWCSUB15SIG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSUB15SIG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdRemovalReason
     */
    private java.lang.String _szCdRemovalReason;

    /**
     * Field _ulIdPersHmRemoval
     */
    private int _ulIdPersHmRemoval;

    /**
     * keeps track of state for field: _ulIdPersHmRemoval
     */
    private boolean _has_ulIdPersHmRemoval;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdSysDataActionOutcome
     */
    private java.lang.String _szCdSysDataActionOutcome;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSUB15SIG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     */
    public void deleteUlIdPersHmRemoval()
    {
        this._has_ulIdPersHmRemoval= false;
    } //-- void deleteUlIdPersHmRemoval() 

    /**
     * Returns the value of field 'szCdRemovalReason'.
     * 
     * @return the value of field 'SzCdRemovalReason'.
     */
    public java.lang.String getSzCdRemovalReason()
    {
        return this._szCdRemovalReason;
    } //-- java.lang.String getSzCdRemovalReason() 

    /**
     * Returns the value of field 'szCdSysDataActionOutcome'.
     * 
     * @return the value of field 'SzCdSysDataActionOutcome'.
     */
    public java.lang.String getSzCdSysDataActionOutcome()
    {
        return this._szCdSysDataActionOutcome;
    } //-- java.lang.String getSzCdSysDataActionOutcome() 

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
     * Returns the value of field 'ulIdEvent'.
     * 
     * @return the value of field 'UlIdEvent'.
     */
    public int getUlIdEvent()
    {
        return this._ulIdEvent;
    } //-- int getUlIdEvent() 

    /**
     * Returns the value of field 'ulIdPersHmRemoval'.
     * 
     * @return the value of field 'UlIdPersHmRemoval'.
     */
    public int getUlIdPersHmRemoval()
    {
        return this._ulIdPersHmRemoval;
    } //-- int getUlIdPersHmRemoval() 

    /**
     * Method hasUlIdEvent
     * 
     * 
     * 
     * @return true if at least one UlIdEvent has been added
     */
    public boolean hasUlIdEvent()
    {
        return this._has_ulIdEvent;
    } //-- boolean hasUlIdEvent() 

    /**
     * Method hasUlIdPersHmRemoval
     * 
     * 
     * 
     * @return true if at least one UlIdPersHmRemoval has been added
     */
    public boolean hasUlIdPersHmRemoval()
    {
        return this._has_ulIdPersHmRemoval;
    } //-- boolean hasUlIdPersHmRemoval() 

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
     * Sets the value of field 'szCdRemovalReason'.
     * 
     * @param szCdRemovalReason the value of field
     * 'szCdRemovalReason'.
     */
    public void setSzCdRemovalReason(java.lang.String szCdRemovalReason)
    {
        this._szCdRemovalReason = szCdRemovalReason;
    } //-- void setSzCdRemovalReason(java.lang.String) 

    /**
     * Sets the value of field 'szCdSysDataActionOutcome'.
     * 
     * @param szCdSysDataActionOutcome the value of field
     * 'szCdSysDataActionOutcome'.
     */
    public void setSzCdSysDataActionOutcome(java.lang.String szCdSysDataActionOutcome)
    {
        this._szCdSysDataActionOutcome = szCdSysDataActionOutcome;
    } //-- void setSzCdSysDataActionOutcome(java.lang.String) 

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
     * Sets the value of field 'ulIdEvent'.
     * 
     * @param ulIdEvent the value of field 'ulIdEvent'.
     */
    public void setUlIdEvent(int ulIdEvent)
    {
        this._ulIdEvent = ulIdEvent;
        this._has_ulIdEvent = true;
    } //-- void setUlIdEvent(int) 

    /**
     * Sets the value of field 'ulIdPersHmRemoval'.
     * 
     * @param ulIdPersHmRemoval the value of field
     * 'ulIdPersHmRemoval'.
     */
    public void setUlIdPersHmRemoval(int ulIdPersHmRemoval)
    {
        this._ulIdPersHmRemoval = ulIdPersHmRemoval;
        this._has_ulIdPersHmRemoval = true;
    } //-- void setUlIdPersHmRemoval(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01 unmarshal(java.io.Reader) 

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
