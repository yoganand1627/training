/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.output;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class ROWCSUB45SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSUB45SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdEvent_ARRAY_CSUB45S
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEvent_ARRAY_CSUB45S _ulIdEvent_ARRAY_CSUB45S;

    /**
     * Field _ulIdEventPerson
     */
    private int _ulIdEventPerson;

    /**
     * keeps track of state for field: _ulIdEventPerson
     */
    private boolean _has_ulIdEventPerson;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;

    /**
     * Field _szCdEventStatus_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdEventStatus_ARRAY _szCdEventStatus_ARRAY;

    /**
     * Field _szCdEventType
     */
    private java.lang.String _szCdEventType;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _dtDtEventOccurred
     */
    private org.exolab.castor.types.Date _dtDtEventOccurred;

    /**
     * Field _szTxtEventDescr
     */
    private java.lang.String _szTxtEventDescr;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSUB45SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEventPerson()
    {
        this._has_ulIdEventPerson= false;
    } //-- void deleteUlIdEventPerson() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'dtDtEventOccurred'.
     * 
     * @return the value of field 'DtDtEventOccurred'.
     */
    public org.exolab.castor.types.Date getDtDtEventOccurred()
    {
        return this._dtDtEventOccurred;
    } //-- org.exolab.castor.types.Date getDtDtEventOccurred() 

    /**
     * Returns the value of field 'szCdEventStatus_ARRAY'.
     * 
     * @return the value of field 'SzCdEventStatus_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdEventStatus_ARRAY getSzCdEventStatus_ARRAY()
    {
        return this._szCdEventStatus_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdEventStatus_ARRAY getSzCdEventStatus_ARRAY() 

    /**
     * Returns the value of field 'szCdEventType'.
     * 
     * @return the value of field 'SzCdEventType'.
     */
    public java.lang.String getSzCdEventType()
    {
        return this._szCdEventType;
    } //-- java.lang.String getSzCdEventType() 

    /**
     * Returns the value of field 'szCdTask'.
     * 
     * @return the value of field 'SzCdTask'.
     */
    public java.lang.String getSzCdTask()
    {
        return this._szCdTask;
    } //-- java.lang.String getSzCdTask() 

    /**
     * Returns the value of field 'szTxtEventDescr'.
     * 
     * @return the value of field 'SzTxtEventDescr'.
     */
    public java.lang.String getSzTxtEventDescr()
    {
        return this._szTxtEventDescr;
    } //-- java.lang.String getSzTxtEventDescr() 

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
     * Returns the value of field 'ulIdEventPerson'.
     * 
     * @return the value of field 'UlIdEventPerson'.
     */
    public int getUlIdEventPerson()
    {
        return this._ulIdEventPerson;
    } //-- int getUlIdEventPerson() 

    /**
     * Returns the value of field 'ulIdEvent_ARRAY_CSUB45S'.
     * 
     * @return the value of field 'UlIdEvent_ARRAY_CSUB45S'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEvent_ARRAY_CSUB45S getUlIdEvent_ARRAY_CSUB45S()
    {
        return this._ulIdEvent_ARRAY_CSUB45S;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEvent_ARRAY_CSUB45S getUlIdEvent_ARRAY_CSUB45S() 

    /**
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

    /**
     * Method hasUlIdEventPerson
     * 
     * 
     * 
     * @return true if at least one UlIdEventPerson has been added
     */
    public boolean hasUlIdEventPerson()
    {
        return this._has_ulIdEventPerson;
    } //-- boolean hasUlIdEventPerson() 

    /**
     * Method hasUlIdStage
     * 
     * 
     * 
     * @return true if at least one UlIdStage has been added
     */
    public boolean hasUlIdStage()
    {
        return this._has_ulIdStage;
    } //-- boolean hasUlIdStage() 

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
     * Sets the value of field 'dtDtEventOccurred'.
     * 
     * @param dtDtEventOccurred the value of field
     * 'dtDtEventOccurred'.
     */
    public void setDtDtEventOccurred(org.exolab.castor.types.Date dtDtEventOccurred)
    {
        this._dtDtEventOccurred = dtDtEventOccurred;
    } //-- void setDtDtEventOccurred(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdEventStatus_ARRAY'.
     * 
     * @param szCdEventStatus_ARRAY the value of field
     * 'szCdEventStatus_ARRAY'.
     */
    public void setSzCdEventStatus_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdEventStatus_ARRAY szCdEventStatus_ARRAY)
    {
        this._szCdEventStatus_ARRAY = szCdEventStatus_ARRAY;
    } //-- void setSzCdEventStatus_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdEventStatus_ARRAY) 

    /**
     * Sets the value of field 'szCdEventType'.
     * 
     * @param szCdEventType the value of field 'szCdEventType'.
     */
    public void setSzCdEventType(java.lang.String szCdEventType)
    {
        this._szCdEventType = szCdEventType;
    } //-- void setSzCdEventType(java.lang.String) 

    /**
     * Sets the value of field 'szCdTask'.
     * 
     * @param szCdTask the value of field 'szCdTask'.
     */
    public void setSzCdTask(java.lang.String szCdTask)
    {
        this._szCdTask = szCdTask;
    } //-- void setSzCdTask(java.lang.String) 

    /**
     * Sets the value of field 'szTxtEventDescr'.
     * 
     * @param szTxtEventDescr the value of field 'szTxtEventDescr'.
     */
    public void setSzTxtEventDescr(java.lang.String szTxtEventDescr)
    {
        this._szTxtEventDescr = szTxtEventDescr;
    } //-- void setSzTxtEventDescr(java.lang.String) 

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
     * Sets the value of field 'ulIdEventPerson'.
     * 
     * @param ulIdEventPerson the value of field 'ulIdEventPerson'.
     */
    public void setUlIdEventPerson(int ulIdEventPerson)
    {
        this._ulIdEventPerson = ulIdEventPerson;
        this._has_ulIdEventPerson = true;
    } //-- void setUlIdEventPerson(int) 

    /**
     * Sets the value of field 'ulIdEvent_ARRAY_CSUB45S'.
     * 
     * @param ulIdEvent_ARRAY_CSUB45S the value of field
     * 'ulIdEvent_ARRAY_CSUB45S'.
     */
    public void setUlIdEvent_ARRAY_CSUB45S(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEvent_ARRAY_CSUB45S ulIdEvent_ARRAY_CSUB45S)
    {
        this._ulIdEvent_ARRAY_CSUB45S = ulIdEvent_ARRAY_CSUB45S;
    } //-- void setUlIdEvent_ARRAY_CSUB45S(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEvent_ARRAY_CSUB45S) 

    /**
     * Sets the value of field 'ulIdStage'.
     * 
     * @param ulIdStage the value of field 'ulIdStage'.
     */
    public void setUlIdStage(int ulIdStage)
    {
        this._ulIdStage = ulIdStage;
        this._has_ulIdStage = true;
    } //-- void setUlIdStage(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG00 unmarshal(java.io.Reader) 

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
