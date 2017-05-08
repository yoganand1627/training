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
 * Class PersListAudOutRec.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PersListAudOutRec extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _lSysNbrUniqueLBKey
     */
    private int _lSysNbrUniqueLBKey;

    /**
     * keeps track of state for field: _lSysNbrUniqueLBKey
     */
    private boolean _has_lSysNbrUniqueLBKey;

    /**
     * Field _ldIdAddress_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.LdIdAddress_ARRAY _ldIdAddress_ARRAY;

    /**
     * Field _ulIdAddrPersonLink_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdAddrPersonLink_ARRAY _ulIdAddrPersonLink_ARRAY;

    /**
     * Field _ulIdPersonId_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonId_ARRAY _ulIdPersonId_ARRAY;

    /**
     * Field _ulIdPhone_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPhone_ARRAY _ulIdPhone_ARRAY;

    /**
     * Field _ulIdName_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdName_ARRAY _ulIdName_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public PersListAudOutRec() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PersListAudOutRec()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLSysNbrUniqueLBKey()
    {
        this._has_lSysNbrUniqueLBKey= false;
    } //-- void deleteLSysNbrUniqueLBKey() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

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
     * Returns the value of field 'lSysNbrUniqueLBKey'.
     * 
     * @return the value of field 'LSysNbrUniqueLBKey'.
     */
    public int getLSysNbrUniqueLBKey()
    {
        return this._lSysNbrUniqueLBKey;
    } //-- int getLSysNbrUniqueLBKey() 

    /**
     * Returns the value of field 'ldIdAddress_ARRAY'.
     * 
     * @return the value of field 'LdIdAddress_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.LdIdAddress_ARRAY getLdIdAddress_ARRAY()
    {
        return this._ldIdAddress_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.LdIdAddress_ARRAY getLdIdAddress_ARRAY() 

    /**
     * Returns the value of field 'ulIdAddrPersonLink_ARRAY'.
     * 
     * @return the value of field 'UlIdAddrPersonLink_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdAddrPersonLink_ARRAY getUlIdAddrPersonLink_ARRAY()
    {
        return this._ulIdAddrPersonLink_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdAddrPersonLink_ARRAY getUlIdAddrPersonLink_ARRAY() 

    /**
     * Returns the value of field 'ulIdName_ARRAY'.
     * 
     * @return the value of field 'UlIdName_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdName_ARRAY getUlIdName_ARRAY()
    {
        return this._ulIdName_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdName_ARRAY getUlIdName_ARRAY() 

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
     * Returns the value of field 'ulIdPersonId_ARRAY'.
     * 
     * @return the value of field 'UlIdPersonId_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonId_ARRAY getUlIdPersonId_ARRAY()
    {
        return this._ulIdPersonId_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonId_ARRAY getUlIdPersonId_ARRAY() 

    /**
     * Returns the value of field 'ulIdPhone_ARRAY'.
     * 
     * @return the value of field 'UlIdPhone_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPhone_ARRAY getUlIdPhone_ARRAY()
    {
        return this._ulIdPhone_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPhone_ARRAY getUlIdPhone_ARRAY() 

    /**
     * Method hasLSysNbrUniqueLBKey
     * 
     * 
     * 
     * @return true if at least one LSysNbrUniqueLBKey has been adde
     */
    public boolean hasLSysNbrUniqueLBKey()
    {
        return this._has_lSysNbrUniqueLBKey;
    } //-- boolean hasLSysNbrUniqueLBKey() 

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
     * Sets the value of field 'lSysNbrUniqueLBKey'.
     * 
     * @param lSysNbrUniqueLBKey the value of field
     * 'lSysNbrUniqueLBKey'.
     */
    public void setLSysNbrUniqueLBKey(int lSysNbrUniqueLBKey)
    {
        this._lSysNbrUniqueLBKey = lSysNbrUniqueLBKey;
        this._has_lSysNbrUniqueLBKey = true;
    } //-- void setLSysNbrUniqueLBKey(int) 

    /**
     * Sets the value of field 'ldIdAddress_ARRAY'.
     * 
     * @param ldIdAddress_ARRAY the value of field
     * 'ldIdAddress_ARRAY'.
     */
    public void setLdIdAddress_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.LdIdAddress_ARRAY ldIdAddress_ARRAY)
    {
        this._ldIdAddress_ARRAY = ldIdAddress_ARRAY;
    } //-- void setLdIdAddress_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.LdIdAddress_ARRAY) 

    /**
     * Sets the value of field 'ulIdAddrPersonLink_ARRAY'.
     * 
     * @param ulIdAddrPersonLink_ARRAY the value of field
     * 'ulIdAddrPersonLink_ARRAY'.
     */
    public void setUlIdAddrPersonLink_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdAddrPersonLink_ARRAY ulIdAddrPersonLink_ARRAY)
    {
        this._ulIdAddrPersonLink_ARRAY = ulIdAddrPersonLink_ARRAY;
    } //-- void setUlIdAddrPersonLink_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdAddrPersonLink_ARRAY) 

    /**
     * Sets the value of field 'ulIdName_ARRAY'.
     * 
     * @param ulIdName_ARRAY the value of field 'ulIdName_ARRAY'.
     */
    public void setUlIdName_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdName_ARRAY ulIdName_ARRAY)
    {
        this._ulIdName_ARRAY = ulIdName_ARRAY;
    } //-- void setUlIdName_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdName_ARRAY) 

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
     * Sets the value of field 'ulIdPersonId_ARRAY'.
     * 
     * @param ulIdPersonId_ARRAY the value of field
     * 'ulIdPersonId_ARRAY'.
     */
    public void setUlIdPersonId_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonId_ARRAY ulIdPersonId_ARRAY)
    {
        this._ulIdPersonId_ARRAY = ulIdPersonId_ARRAY;
    } //-- void setUlIdPersonId_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonId_ARRAY) 

    /**
     * Sets the value of field 'ulIdPhone_ARRAY'.
     * 
     * @param ulIdPhone_ARRAY the value of field 'ulIdPhone_ARRAY'.
     */
    public void setUlIdPhone_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPhone_ARRAY ulIdPhone_ARRAY)
    {
        this._ulIdPhone_ARRAY = ulIdPhone_ARRAY;
    } //-- void setUlIdPhone_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPhone_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.PersListAudOutRec
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.PersListAudOutRec unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PersListAudOutRec) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.PersListAudOutRec.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PersListAudOutRec unmarshal(java.io.Reader) 

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
