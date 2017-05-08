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
 * Class CARC18SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CARC18SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulRowQty
     */
    private int _ulRowQty;

    /**
     * keeps track of state for field: _ulRowQty
     */
    private boolean _has_ulRowQty;

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
     * Field _szIdEmployeeLogon
     */
    private java.lang.String _szIdEmployeeLogon;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ROWCARC18SIG00_ARRAY_CARC18SI
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC18SI _ROWCARC18SIG00_ARRAY_CARC18SI;

    /**
     * Field _ROWCARC18SIG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG01_ARRAY _ROWCARC18SIG01_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CARC18SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CARC18SI()


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
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

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
     * Returns the value of field 'ROWCARC18SIG00_ARRAY_CARC18SI'.
     * 
     * @return the value of field 'ROWCARC18SIG00_ARRAY_CARC18SI'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC18SI getROWCARC18SIG00_ARRAY_CARC18SI()
    {
        return this._ROWCARC18SIG00_ARRAY_CARC18SI;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC18SI getROWCARC18SIG00_ARRAY_CARC18SI() 

    /**
     * Returns the value of field 'ROWCARC18SIG01_ARRAY'.
     * 
     * @return the value of field 'ROWCARC18SIG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG01_ARRAY getROWCARC18SIG01_ARRAY()
    {
        return this._ROWCARC18SIG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG01_ARRAY getROWCARC18SIG01_ARRAY() 

    /**
     * Returns the value of field 'szIdEmployeeLogon'.
     * 
     * @return the value of field 'SzIdEmployeeLogon'.
     */
    public java.lang.String getSzIdEmployeeLogon()
    {
        return this._szIdEmployeeLogon;
    } //-- java.lang.String getSzIdEmployeeLogon() 

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
     * Returns the value of field 'ulRowQty'.
     * 
     * @return the value of field 'UlRowQty'.
     */
    public int getUlRowQty()
    {
        return this._ulRowQty;
    } //-- int getUlRowQty() 

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
     * Method hasUlRowQty
     * 
     * 
     * 
     * @return true if at least one UlRowQty has been added
     */
    public boolean hasUlRowQty()
    {
        return this._has_ulRowQty;
    } //-- boolean hasUlRowQty() 

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
     * Sets the value of field 'ROWCARC18SIG00_ARRAY_CARC18SI'.
     * 
     * @param ROWCARC18SIG00_ARRAY_CARC18SI the value of field
     * 'ROWCARC18SIG00_ARRAY_CARC18SI'.
     */
    public void setROWCARC18SIG00_ARRAY_CARC18SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC18SI ROWCARC18SIG00_ARRAY_CARC18SI)
    {
        this._ROWCARC18SIG00_ARRAY_CARC18SI = ROWCARC18SIG00_ARRAY_CARC18SI;
    } //-- void setROWCARC18SIG00_ARRAY_CARC18SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG00_ARRAY_CARC18SI) 

    /**
     * Sets the value of field 'ROWCARC18SIG01_ARRAY'.
     * 
     * @param ROWCARC18SIG01_ARRAY the value of field
     * 'ROWCARC18SIG01_ARRAY'.
     */
    public void setROWCARC18SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG01_ARRAY ROWCARC18SIG01_ARRAY)
    {
        this._ROWCARC18SIG01_ARRAY = ROWCARC18SIG01_ARRAY;
    } //-- void setROWCARC18SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC18SIG01_ARRAY) 

    /**
     * Sets the value of field 'szIdEmployeeLogon'.
     * 
     * @param szIdEmployeeLogon the value of field
     * 'szIdEmployeeLogon'.
     */
    public void setSzIdEmployeeLogon(java.lang.String szIdEmployeeLogon)
    {
        this._szIdEmployeeLogon = szIdEmployeeLogon;
    } //-- void setSzIdEmployeeLogon(java.lang.String) 

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
     * Sets the value of field 'ulRowQty'.
     * 
     * @param ulRowQty the value of field 'ulRowQty'.
     */
    public void setUlRowQty(int ulRowQty)
    {
        this._ulRowQty = ulRowQty;
        this._has_ulRowQty = true;
    } //-- void setUlRowQty(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CARC18SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CARC18SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CARC18SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CARC18SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CARC18SI unmarshal(java.io.Reader) 

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
