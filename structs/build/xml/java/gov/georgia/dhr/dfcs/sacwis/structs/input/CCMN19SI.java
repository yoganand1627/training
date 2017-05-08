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
 * Class CCMN19SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN19SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _toDoAUDStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ToDoAUDStruct _toDoAUDStruct;

    /**
     * Field _eventStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.EventStruct _eventStruct;

    /**
     * Field _apprvEventStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvEventStruct _apprvEventStruct;

    /**
     * Field _approversStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversStruct _approversStruct;

    /**
     * Field _apprvStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvStruct _apprvStruct;

    /**
     * Field _eventIdStruct_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.EventIdStruct_ARRAY _eventIdStruct_ARRAY;

    /**
     * Field _szCdTodoType
     */
    private java.lang.String _szCdTodoType;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _cSysIndTaskNew
     */
    private java.lang.String _cSysIndTaskNew;

    /**
     * Field _szCdEventType
     */
    private java.lang.String _szCdEventType;

    /**
     * Field _szTxtEventDescr
     */
    private java.lang.String _szTxtEventDescr;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN19SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'approversStruct'.
     * 
     * @return the value of field 'ApproversStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversStruct getApproversStruct()
    {
        return this._approversStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversStruct getApproversStruct() 

    /**
     * Returns the value of field 'apprvEventStruct'.
     * 
     * @return the value of field 'ApprvEventStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvEventStruct getApprvEventStruct()
    {
        return this._apprvEventStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvEventStruct getApprvEventStruct() 

    /**
     * Returns the value of field 'apprvStruct'.
     * 
     * @return the value of field 'ApprvStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvStruct getApprvStruct()
    {
        return this._apprvStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvStruct getApprvStruct() 

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
     * Returns the value of field 'cSysIndTaskNew'.
     * 
     * @return the value of field 'CSysIndTaskNew'.
     */
    public java.lang.String getCSysIndTaskNew()
    {
        return this._cSysIndTaskNew;
    } //-- java.lang.String getCSysIndTaskNew() 

    /**
     * Returns the value of field 'eventIdStruct_ARRAY'.
     * 
     * @return the value of field 'EventIdStruct_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.EventIdStruct_ARRAY getEventIdStruct_ARRAY()
    {
        return this._eventIdStruct_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.EventIdStruct_ARRAY getEventIdStruct_ARRAY() 

    /**
     * Returns the value of field 'eventStruct'.
     * 
     * @return the value of field 'EventStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.EventStruct getEventStruct()
    {
        return this._eventStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.EventStruct getEventStruct() 

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
     * Returns the value of field 'szCdScrDataAction'.
     * 
     * @return the value of field 'SzCdScrDataAction'.
     */
    public java.lang.String getSzCdScrDataAction()
    {
        return this._szCdScrDataAction;
    } //-- java.lang.String getSzCdScrDataAction() 

    /**
     * Returns the value of field 'szCdTodoType'.
     * 
     * @return the value of field 'SzCdTodoType'.
     */
    public java.lang.String getSzCdTodoType()
    {
        return this._szCdTodoType;
    } //-- java.lang.String getSzCdTodoType() 

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
     * Returns the value of field 'toDoAUDStruct'.
     * 
     * @return the value of field 'ToDoAUDStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ToDoAUDStruct getToDoAUDStruct()
    {
        return this._toDoAUDStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ToDoAUDStruct getToDoAUDStruct() 

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
     * Sets the value of field 'approversStruct'.
     * 
     * @param approversStruct the value of field 'approversStruct'.
     */
    public void setApproversStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversStruct approversStruct)
    {
        this._approversStruct = approversStruct;
    } //-- void setApproversStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversStruct) 

    /**
     * Sets the value of field 'apprvEventStruct'.
     * 
     * @param apprvEventStruct the value of field 'apprvEventStruct'
     */
    public void setApprvEventStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvEventStruct apprvEventStruct)
    {
        this._apprvEventStruct = apprvEventStruct;
    } //-- void setApprvEventStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvEventStruct) 

    /**
     * Sets the value of field 'apprvStruct'.
     * 
     * @param apprvStruct the value of field 'apprvStruct'.
     */
    public void setApprvStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvStruct apprvStruct)
    {
        this._apprvStruct = apprvStruct;
    } //-- void setApprvStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvStruct) 

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
     * Sets the value of field 'cSysIndTaskNew'.
     * 
     * @param cSysIndTaskNew the value of field 'cSysIndTaskNew'.
     */
    public void setCSysIndTaskNew(java.lang.String cSysIndTaskNew)
    {
        this._cSysIndTaskNew = cSysIndTaskNew;
    } //-- void setCSysIndTaskNew(java.lang.String) 

    /**
     * Sets the value of field 'eventIdStruct_ARRAY'.
     * 
     * @param eventIdStruct_ARRAY the value of field
     * 'eventIdStruct_ARRAY'.
     */
    public void setEventIdStruct_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.EventIdStruct_ARRAY eventIdStruct_ARRAY)
    {
        this._eventIdStruct_ARRAY = eventIdStruct_ARRAY;
    } //-- void setEventIdStruct_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.EventIdStruct_ARRAY) 

    /**
     * Sets the value of field 'eventStruct'.
     * 
     * @param eventStruct the value of field 'eventStruct'.
     */
    public void setEventStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.EventStruct eventStruct)
    {
        this._eventStruct = eventStruct;
    } //-- void setEventStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.EventStruct) 

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
     * Sets the value of field 'szCdTodoType'.
     * 
     * @param szCdTodoType the value of field 'szCdTodoType'.
     */
    public void setSzCdTodoType(java.lang.String szCdTodoType)
    {
        this._szCdTodoType = szCdTodoType;
    } //-- void setSzCdTodoType(java.lang.String) 

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
     * Sets the value of field 'toDoAUDStruct'.
     * 
     * @param toDoAUDStruct the value of field 'toDoAUDStruct'.
     */
    public void setToDoAUDStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ToDoAUDStruct toDoAUDStruct)
    {
        this._toDoAUDStruct = toDoAUDStruct;
    } //-- void setToDoAUDStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ToDoAUDStruct) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19SI unmarshal(java.io.Reader) 

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
