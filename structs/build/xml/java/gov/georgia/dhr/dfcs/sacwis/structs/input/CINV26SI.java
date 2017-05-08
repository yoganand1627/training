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
 * Class CINV26SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV26SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archInputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct _archInputStruct;

    /**
     * Field _bSysIndGeneric
     */
    private java.lang.String _bSysIndGeneric;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _szNmPersonFull_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY _szNmPersonFull_ARRAY;

    /**
     * Field _bSysIndUpdateFullName
     */
    private java.lang.String _bSysIndUpdateFullName;

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulIdPersonId
     */
    private int _ulIdPersonId;

    /**
     * keeps track of state for field: _ulIdPersonId
     */
    private boolean _has_ulIdPersonId;

    /**
     * Field _ROWCINV26SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY _ROWCINV26SIG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV26SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI()


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
    public void deleteUlIdPersonId()
    {
        this._has_ulIdPersonId= false;
    } //-- void deleteUlIdPersonId() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'archInputStruct'.
     * 
     * @return the value of field 'ArchInputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct()
    {
        return this._archInputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct() 

    /**
     * Returns the value of field 'bSysIndGeneric'.
     * 
     * @return the value of field 'BSysIndGeneric'.
     */
    public java.lang.String getBSysIndGeneric()
    {
        return this._bSysIndGeneric;
    } //-- java.lang.String getBSysIndGeneric() 

    /**
     * Returns the value of field 'bSysIndUpdateFullName'.
     * 
     * @return the value of field 'BSysIndUpdateFullName'.
     */
    public java.lang.String getBSysIndUpdateFullName()
    {
        return this._bSysIndUpdateFullName;
    } //-- java.lang.String getBSysIndUpdateFullName() 

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
     * Returns the value of field 'ROWCINV26SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCINV26SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY getROWCINV26SIG00_ARRAY()
    {
        return this._ROWCINV26SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY getROWCINV26SIG00_ARRAY() 

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
     * Returns the value of field 'szNmPersonFull_ARRAY'.
     * 
     * @return the value of field 'SzNmPersonFull_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY getSzNmPersonFull_ARRAY()
    {
        return this._szNmPersonFull_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY getSzNmPersonFull_ARRAY() 

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
     * Returns the value of field 'ulIdPersonId'.
     * 
     * @return the value of field 'UlIdPersonId'.
     */
    public int getUlIdPersonId()
    {
        return this._ulIdPersonId;
    } //-- int getUlIdPersonId() 

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
     * Method hasUlIdPersonId
     * 
     * 
     * 
     * @return true if at least one UlIdPersonId has been added
     */
    public boolean hasUlIdPersonId()
    {
        return this._has_ulIdPersonId;
    } //-- boolean hasUlIdPersonId() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'bSysIndGeneric'.
     * 
     * @param bSysIndGeneric the value of field 'bSysIndGeneric'.
     */
    public void setBSysIndGeneric(java.lang.String bSysIndGeneric)
    {
        this._bSysIndGeneric = bSysIndGeneric;
    } //-- void setBSysIndGeneric(java.lang.String) 

    /**
     * Sets the value of field 'bSysIndUpdateFullName'.
     * 
     * @param bSysIndUpdateFullName the value of field
     * 'bSysIndUpdateFullName'.
     */
    public void setBSysIndUpdateFullName(java.lang.String bSysIndUpdateFullName)
    {
        this._bSysIndUpdateFullName = bSysIndUpdateFullName;
    } //-- void setBSysIndUpdateFullName(java.lang.String) 

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
     * Sets the value of field 'ROWCINV26SIG00_ARRAY'.
     * 
     * @param ROWCINV26SIG00_ARRAY the value of field
     * 'ROWCINV26SIG00_ARRAY'.
     */
    public void setROWCINV26SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY ROWCINV26SIG00_ARRAY)
    {
        this._ROWCINV26SIG00_ARRAY = ROWCINV26SIG00_ARRAY;
    } //-- void setROWCINV26SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY) 

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
     * Sets the value of field 'szNmPersonFull_ARRAY'.
     * 
     * @param szNmPersonFull_ARRAY the value of field
     * 'szNmPersonFull_ARRAY'.
     */
    public void setSzNmPersonFull_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY szNmPersonFull_ARRAY)
    {
        this._szNmPersonFull_ARRAY = szNmPersonFull_ARRAY;
    } //-- void setSzNmPersonFull_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY) 

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
     * Sets the value of field 'ulIdPersonId'.
     * 
     * @param ulIdPersonId the value of field 'ulIdPersonId'.
     */
    public void setUlIdPersonId(int ulIdPersonId)
    {
        this._ulIdPersonId = ulIdPersonId;
        this._has_ulIdPersonId = true;
    } //-- void setUlIdPersonId(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI unmarshal(java.io.Reader) 

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
