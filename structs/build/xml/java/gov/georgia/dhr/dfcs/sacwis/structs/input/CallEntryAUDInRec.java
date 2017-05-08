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
 * Class CallEntryAUDInRec.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CallEntryAUDInRec extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdEmployee
     */
    private int _ulIdEmployee;

    /**
     * keeps track of state for field: _ulIdEmployee
     */
    private boolean _has_ulIdEmployee;

    /**
     * Field _unitStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.UnitStruct _unitStruct;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _callEntrySvcStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntrySvcStruct _callEntrySvcStruct;

    /**
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;

    /**
     * Field _cSysIndEventToCreate
     */
    private java.lang.String _cSysIndEventToCreate;

    /**
     * Field _szCdStageCurrPriority
     */
    private java.lang.String _szCdStageCurrPriority;


      //----------------/
     //- Constructors -/
    //----------------/

    public CallEntryAUDInRec() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryAUDInRec()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEmployee()
    {
        this._has_ulIdEmployee= false;
    } //-- void deleteUlIdEmployee() 

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
     * Returns the value of field 'cSysIndEventToCreate'.
     * 
     * @return the value of field 'CSysIndEventToCreate'.
     */
    public java.lang.String getCSysIndEventToCreate()
    {
        return this._cSysIndEventToCreate;
    } //-- java.lang.String getCSysIndEventToCreate() 

    /**
     * Returns the value of field 'callEntrySvcStruct'.
     * 
     * @return the value of field 'CallEntrySvcStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntrySvcStruct getCallEntrySvcStruct()
    {
        return this._callEntrySvcStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntrySvcStruct getCallEntrySvcStruct() 

    /**
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00() 

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
     * Returns the value of field 'szCdStageCurrPriority'.
     * 
     * @return the value of field 'SzCdStageCurrPriority'.
     */
    public java.lang.String getSzCdStageCurrPriority()
    {
        return this._szCdStageCurrPriority;
    } //-- java.lang.String getSzCdStageCurrPriority() 

    /**
     * Returns the value of field 'ulIdEmployee'.
     * 
     * @return the value of field 'UlIdEmployee'.
     */
    public int getUlIdEmployee()
    {
        return this._ulIdEmployee;
    } //-- int getUlIdEmployee() 

    /**
     * Returns the value of field 'unitStruct'.
     * 
     * @return the value of field 'UnitStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.UnitStruct getUnitStruct()
    {
        return this._unitStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UnitStruct getUnitStruct() 

    /**
     * Method hasUlIdEmployee
     * 
     * 
     * 
     * @return true if at least one UlIdEmployee has been added
     */
    public boolean hasUlIdEmployee()
    {
        return this._has_ulIdEmployee;
    } //-- boolean hasUlIdEmployee() 

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
     * Sets the value of field 'cSysIndEventToCreate'.
     * 
     * @param cSysIndEventToCreate the value of field
     * 'cSysIndEventToCreate'.
     */
    public void setCSysIndEventToCreate(java.lang.String cSysIndEventToCreate)
    {
        this._cSysIndEventToCreate = cSysIndEventToCreate;
    } //-- void setCSysIndEventToCreate(java.lang.String) 

    /**
     * Sets the value of field 'callEntrySvcStruct'.
     * 
     * @param callEntrySvcStruct the value of field
     * 'callEntrySvcStruct'.
     */
    public void setCallEntrySvcStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntrySvcStruct callEntrySvcStruct)
    {
        this._callEntrySvcStruct = callEntrySvcStruct;
    } //-- void setCallEntrySvcStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntrySvcStruct) 

    /**
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00) 

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
     * Sets the value of field 'szCdStageCurrPriority'.
     * 
     * @param szCdStageCurrPriority the value of field
     * 'szCdStageCurrPriority'.
     */
    public void setSzCdStageCurrPriority(java.lang.String szCdStageCurrPriority)
    {
        this._szCdStageCurrPriority = szCdStageCurrPriority;
    } //-- void setSzCdStageCurrPriority(java.lang.String) 

    /**
     * Sets the value of field 'ulIdEmployee'.
     * 
     * @param ulIdEmployee the value of field 'ulIdEmployee'.
     */
    public void setUlIdEmployee(int ulIdEmployee)
    {
        this._ulIdEmployee = ulIdEmployee;
        this._has_ulIdEmployee = true;
    } //-- void setUlIdEmployee(int) 

    /**
     * Sets the value of field 'unitStruct'.
     * 
     * @param unitStruct the value of field 'unitStruct'.
     */
    public void setUnitStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.UnitStruct unitStruct)
    {
        this._unitStruct = unitStruct;
    } //-- void setUnitStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.UnitStruct) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryAUDInRec
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryAUDInRec unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryAUDInRec) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryAUDInRec.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryAUDInRec unmarshal(java.io.Reader) 

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
