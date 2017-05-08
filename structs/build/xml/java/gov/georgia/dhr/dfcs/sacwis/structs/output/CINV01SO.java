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
 * Class CINV01SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV01SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archOutputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct _archOutputStruct;

    /**
     * Field _ROWCINV01SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00_ARRAY _ROWCINV01SOG00_ARRAY;

    /**
     * Field _bIndBLOBExistsInDatabase_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY _bIndBLOBExistsInDatabase_ARRAY;

    /**
     * Field _ulIdEventBLOB_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEventBLOB_ARRAY _ulIdEventBLOB_ARRAY;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;

    /**
     * Field _bIndNonIncident
     */
    private boolean _bIndNonIncident;

    /**
     * keeps track of state for field: _bIndNonIncident
     */
    private boolean _has_bIndNonIncident;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV01SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV01SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBIndNonIncident()
    {
        this._has_bIndNonIncident= false;
    } //-- void deleteBIndNonIncident() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

    /**
     * Returns the value of field 'bIndBLOBExistsInDatabase_ARRAY'.
     * 
     * @return the value of field 'BIndBLOBExistsInDatabase_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY getBIndBLOBExistsInDatabase_ARRAY()
    {
        return this._bIndBLOBExistsInDatabase_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY getBIndBLOBExistsInDatabase_ARRAY() 

    /**
     * Returns the value of field 'bIndNonIncident'.
     * 
     * @return the value of field 'BIndNonIncident'.
     */
    public boolean getBIndNonIncident()
    {
        return this._bIndNonIncident;
    } //-- boolean getBIndNonIncident() 

    /**
     * Returns the value of field 'dtWCDDtSystemDate'.
     * 
     * @return the value of field 'DtWCDDtSystemDate'.
     */
    public org.exolab.castor.types.Date getDtWCDDtSystemDate()
    {
        return this._dtWCDDtSystemDate;
    } //-- org.exolab.castor.types.Date getDtWCDDtSystemDate() 

    /**
     * Returns the value of field 'ROWCINV01SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCINV01SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00_ARRAY getROWCINV01SOG00_ARRAY()
    {
        return this._ROWCINV01SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00_ARRAY getROWCINV01SOG00_ARRAY() 

    /**
     * Returns the value of field 'szCdEventStatus'.
     * 
     * @return the value of field 'SzCdEventStatus'.
     */
    public java.lang.String getSzCdEventStatus()
    {
        return this._szCdEventStatus;
    } //-- java.lang.String getSzCdEventStatus() 

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
     * Returns the value of field 'ulIdEventBLOB_ARRAY'.
     * 
     * @return the value of field 'UlIdEventBLOB_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEventBLOB_ARRAY getUlIdEventBLOB_ARRAY()
    {
        return this._ulIdEventBLOB_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEventBLOB_ARRAY getUlIdEventBLOB_ARRAY() 

    /**
     * Method hasBIndNonIncident
     * 
     * 
     * 
     * @return true if at least one BIndNonIncident has been added
     */
    public boolean hasBIndNonIncident()
    {
        return this._has_bIndNonIncident;
    } //-- boolean hasBIndNonIncident() 

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
     * Returns the value of field 'bIndNonIncident'.
     * 
     * @return the value of field 'BIndNonIncident'.
     */
    public boolean isBIndNonIncident()
    {
        return this._bIndNonIncident;
    } //-- boolean isBIndNonIncident() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'bIndBLOBExistsInDatabase_ARRAY'.
     * 
     * @param bIndBLOBExistsInDatabase_ARRAY the value of field
     * 'bIndBLOBExistsInDatabase_ARRAY'.
     */
    public void setBIndBLOBExistsInDatabase_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY bIndBLOBExistsInDatabase_ARRAY)
    {
        this._bIndBLOBExistsInDatabase_ARRAY = bIndBLOBExistsInDatabase_ARRAY;
    } //-- void setBIndBLOBExistsInDatabase_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY) 

    /**
     * Sets the value of field 'bIndNonIncident'.
     * 
     * @param bIndNonIncident the value of field 'bIndNonIncident'.
     */
    public void setBIndNonIncident(boolean bIndNonIncident)
    {
        this._bIndNonIncident = bIndNonIncident;
        this._has_bIndNonIncident = true;
    } //-- void setBIndNonIncident(boolean) 

    /**
     * Sets the value of field 'dtWCDDtSystemDate'.
     * 
     * @param dtWCDDtSystemDate the value of field
     * 'dtWCDDtSystemDate'.
     */
    public void setDtWCDDtSystemDate(org.exolab.castor.types.Date dtWCDDtSystemDate)
    {
        this._dtWCDDtSystemDate = dtWCDDtSystemDate;
    } //-- void setDtWCDDtSystemDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCINV01SOG00_ARRAY'.
     * 
     * @param ROWCINV01SOG00_ARRAY the value of field
     * 'ROWCINV01SOG00_ARRAY'.
     */
    public void setROWCINV01SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00_ARRAY ROWCINV01SOG00_ARRAY)
    {
        this._ROWCINV01SOG00_ARRAY = ROWCINV01SOG00_ARRAY;
    } //-- void setROWCINV01SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00_ARRAY) 

    /**
     * Sets the value of field 'szCdEventStatus'.
     * 
     * @param szCdEventStatus the value of field 'szCdEventStatus'.
     */
    public void setSzCdEventStatus(java.lang.String szCdEventStatus)
    {
        this._szCdEventStatus = szCdEventStatus;
    } //-- void setSzCdEventStatus(java.lang.String) 

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
     * Sets the value of field 'ulIdEventBLOB_ARRAY'.
     * 
     * @param ulIdEventBLOB_ARRAY the value of field
     * 'ulIdEventBLOB_ARRAY'.
     */
    public void setUlIdEventBLOB_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEventBLOB_ARRAY ulIdEventBLOB_ARRAY)
    {
        this._ulIdEventBLOB_ARRAY = ulIdEventBLOB_ARRAY;
    } //-- void setUlIdEventBLOB_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEventBLOB_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV01SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV01SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV01SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV01SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV01SO unmarshal(java.io.Reader) 

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
