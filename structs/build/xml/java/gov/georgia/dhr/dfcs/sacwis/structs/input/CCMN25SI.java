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
 * Class CCMN25SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN25SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdEmployee
     */
    private int _ulIdEmployee;

    /**
     * keeps track of state for field: _ulIdEmployee
     */
    private boolean _has_ulIdEmployee;

    /**
     * Field _bSysIndGeneric
     */
    private java.lang.String _bSysIndGeneric;

    /**
     * Field _szCdStageRegion
     */
    private java.lang.String _szCdStageRegion;

    /**
     * Field _szCdStageReasonClosed
     */
    private java.lang.String _szCdStageReasonClosed;

    /**
     * Field _assignSaveGroup_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup_ARRAY _assignSaveGroup_ARRAY;

    /**
     * Field _indMesProgramAssistant
     */
    private boolean _indMesProgramAssistant;

    /**
     * keeps track of state for field: _indMesProgramAssistant
     */
    private boolean _has_indMesProgramAssistant;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN25SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN25SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteIndMesProgramAssistant()
    {
        this._has_indMesProgramAssistant= false;
    } //-- void deleteIndMesProgramAssistant() 

    /**
     */
    public void deleteUlIdEmployee()
    {
        this._has_ulIdEmployee= false;
    } //-- void deleteUlIdEmployee() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

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
     * Returns the value of field 'assignSaveGroup_ARRAY'.
     * 
     * @return the value of field 'AssignSaveGroup_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup_ARRAY getAssignSaveGroup_ARRAY()
    {
        return this._assignSaveGroup_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup_ARRAY getAssignSaveGroup_ARRAY() 

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
     * Returns the value of field 'indMesProgramAssistant'.
     * 
     * @return the value of field 'IndMesProgramAssistant'.
     */
    public boolean getIndMesProgramAssistant()
    {
        return this._indMesProgramAssistant;
    } //-- boolean getIndMesProgramAssistant() 

    /**
     * Returns the value of field 'szCdStageReasonClosed'.
     * 
     * @return the value of field 'SzCdStageReasonClosed'.
     */
    public java.lang.String getSzCdStageReasonClosed()
    {
        return this._szCdStageReasonClosed;
    } //-- java.lang.String getSzCdStageReasonClosed() 

    /**
     * Returns the value of field 'szCdStageRegion'.
     * 
     * @return the value of field 'SzCdStageRegion'.
     */
    public java.lang.String getSzCdStageRegion()
    {
        return this._szCdStageRegion;
    } //-- java.lang.String getSzCdStageRegion() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Method hasIndMesProgramAssistant
     * 
     * 
     * 
     * @return true if at least one IndMesProgramAssistant has been
     * added
     */
    public boolean hasIndMesProgramAssistant()
    {
        return this._has_indMesProgramAssistant;
    } //-- boolean hasIndMesProgramAssistant() 

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
     * Method hasUlIdPerson
     * 
     * 
     * 
     * @return true if at least one UlIdPerson has been added
     */
    public boolean hasUlIdPerson()
    {
        return this._has_ulIdPerson;
    } //-- boolean hasUlIdPerson() 

    /**
     * Returns the value of field 'indMesProgramAssistant'.
     * 
     * @return the value of field 'IndMesProgramAssistant'.
     */
    public boolean isIndMesProgramAssistant()
    {
        return this._indMesProgramAssistant;
    } //-- boolean isIndMesProgramAssistant() 

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
     * Sets the value of field 'assignSaveGroup_ARRAY'.
     * 
     * @param assignSaveGroup_ARRAY the value of field
     * 'assignSaveGroup_ARRAY'.
     */
    public void setAssignSaveGroup_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup_ARRAY assignSaveGroup_ARRAY)
    {
        this._assignSaveGroup_ARRAY = assignSaveGroup_ARRAY;
    } //-- void setAssignSaveGroup_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup_ARRAY) 

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
     * Sets the value of field 'indMesProgramAssistant'.
     * 
     * @param indMesProgramAssistant the value of field
     * 'indMesProgramAssistant'.
     */
    public void setIndMesProgramAssistant(boolean indMesProgramAssistant)
    {
        this._indMesProgramAssistant = indMesProgramAssistant;
        this._has_indMesProgramAssistant = true;
    } //-- void setIndMesProgramAssistant(boolean) 

    /**
     * Sets the value of field 'szCdStageReasonClosed'.
     * 
     * @param szCdStageReasonClosed the value of field
     * 'szCdStageReasonClosed'.
     */
    public void setSzCdStageReasonClosed(java.lang.String szCdStageReasonClosed)
    {
        this._szCdStageReasonClosed = szCdStageReasonClosed;
    } //-- void setSzCdStageReasonClosed(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageRegion'.
     * 
     * @param szCdStageRegion the value of field 'szCdStageRegion'.
     */
    public void setSzCdStageRegion(java.lang.String szCdStageRegion)
    {
        this._szCdStageRegion = szCdStageRegion;
    } //-- void setSzCdStageRegion(java.lang.String) 

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
     * Sets the value of field 'ulIdPerson'.
     * 
     * @param ulIdPerson the value of field 'ulIdPerson'.
     */
    public void setUlIdPerson(int ulIdPerson)
    {
        this._ulIdPerson = ulIdPerson;
        this._has_ulIdPerson = true;
    } //-- void setUlIdPerson(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN25SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN25SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN25SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN25SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN25SI unmarshal(java.io.Reader) 

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
