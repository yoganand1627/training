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
 * Class MUpdIDInStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MUpdIDInStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdAddrPersonLink
     */
    private int _ulIdAddrPersonLink;

    /**
     * keeps track of state for field: _ulIdAddrPersonLink
     */
    private boolean _has_ulIdAddrPersonLink;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ldIdAddress
     */
    private int _ldIdAddress;

    /**
     * keeps track of state for field: _ldIdAddress
     */
    private boolean _has_ldIdAddress;

    /**
     * Field _ulIdPhone
     */
    private int _ulIdPhone;

    /**
     * keeps track of state for field: _ulIdPhone
     */
    private boolean _has_ulIdPhone;

    /**
     * Field _ulIdName
     */
    private int _ulIdName;

    /**
     * keeps track of state for field: _ulIdName
     */
    private boolean _has_ulIdName;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulSysNbrUlongKey
     */
    private int _ulSysNbrUlongKey;

    /**
     * keeps track of state for field: _ulSysNbrUlongKey
     */
    private boolean _has_ulSysNbrUlongKey;


      //----------------/
     //- Constructors -/
    //----------------/

    public MUpdIDInStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLdIdAddress()
    {
        this._has_ldIdAddress= false;
    } //-- void deleteLdIdAddress() 

    /**
     */
    public void deleteUlIdAddrPersonLink()
    {
        this._has_ulIdAddrPersonLink= false;
    } //-- void deleteUlIdAddrPersonLink() 

    /**
     */
    public void deleteUlIdName()
    {
        this._has_ulIdName= false;
    } //-- void deleteUlIdName() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdPhone()
    {
        this._has_ulIdPhone= false;
    } //-- void deleteUlIdPhone() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlSysNbrUlongKey()
    {
        this._has_ulSysNbrUlongKey= false;
    } //-- void deleteUlSysNbrUlongKey() 

    /**
     * Returns the value of field 'ldIdAddress'.
     * 
     * @return the value of field 'LdIdAddress'.
     */
    public int getLdIdAddress()
    {
        return this._ldIdAddress;
    } //-- int getLdIdAddress() 

    /**
     * Returns the value of field 'ulIdAddrPersonLink'.
     * 
     * @return the value of field 'UlIdAddrPersonLink'.
     */
    public int getUlIdAddrPersonLink()
    {
        return this._ulIdAddrPersonLink;
    } //-- int getUlIdAddrPersonLink() 

    /**
     * Returns the value of field 'ulIdName'.
     * 
     * @return the value of field 'UlIdName'.
     */
    public int getUlIdName()
    {
        return this._ulIdName;
    } //-- int getUlIdName() 

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
     * Returns the value of field 'ulIdPhone'.
     * 
     * @return the value of field 'UlIdPhone'.
     */
    public int getUlIdPhone()
    {
        return this._ulIdPhone;
    } //-- int getUlIdPhone() 

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
     * Returns the value of field 'ulSysNbrUlongKey'.
     * 
     * @return the value of field 'UlSysNbrUlongKey'.
     */
    public int getUlSysNbrUlongKey()
    {
        return this._ulSysNbrUlongKey;
    } //-- int getUlSysNbrUlongKey() 

    /**
     * Method hasLdIdAddress
     * 
     * 
     * 
     * @return true if at least one LdIdAddress has been added
     */
    public boolean hasLdIdAddress()
    {
        return this._has_ldIdAddress;
    } //-- boolean hasLdIdAddress() 

    /**
     * Method hasUlIdAddrPersonLink
     * 
     * 
     * 
     * @return true if at least one UlIdAddrPersonLink has been adde
     */
    public boolean hasUlIdAddrPersonLink()
    {
        return this._has_ulIdAddrPersonLink;
    } //-- boolean hasUlIdAddrPersonLink() 

    /**
     * Method hasUlIdName
     * 
     * 
     * 
     * @return true if at least one UlIdName has been added
     */
    public boolean hasUlIdName()
    {
        return this._has_ulIdName;
    } //-- boolean hasUlIdName() 

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
     * Method hasUlIdPhone
     * 
     * 
     * 
     * @return true if at least one UlIdPhone has been added
     */
    public boolean hasUlIdPhone()
    {
        return this._has_ulIdPhone;
    } //-- boolean hasUlIdPhone() 

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
     * Method hasUlSysNbrUlongKey
     * 
     * 
     * 
     * @return true if at least one UlSysNbrUlongKey has been added
     */
    public boolean hasUlSysNbrUlongKey()
    {
        return this._has_ulSysNbrUlongKey;
    } //-- boolean hasUlSysNbrUlongKey() 

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
     * Sets the value of field 'ldIdAddress'.
     * 
     * @param ldIdAddress the value of field 'ldIdAddress'.
     */
    public void setLdIdAddress(int ldIdAddress)
    {
        this._ldIdAddress = ldIdAddress;
        this._has_ldIdAddress = true;
    } //-- void setLdIdAddress(int) 

    /**
     * Sets the value of field 'ulIdAddrPersonLink'.
     * 
     * @param ulIdAddrPersonLink the value of field
     * 'ulIdAddrPersonLink'.
     */
    public void setUlIdAddrPersonLink(int ulIdAddrPersonLink)
    {
        this._ulIdAddrPersonLink = ulIdAddrPersonLink;
        this._has_ulIdAddrPersonLink = true;
    } //-- void setUlIdAddrPersonLink(int) 

    /**
     * Sets the value of field 'ulIdName'.
     * 
     * @param ulIdName the value of field 'ulIdName'.
     */
    public void setUlIdName(int ulIdName)
    {
        this._ulIdName = ulIdName;
        this._has_ulIdName = true;
    } //-- void setUlIdName(int) 

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
     * Sets the value of field 'ulIdPhone'.
     * 
     * @param ulIdPhone the value of field 'ulIdPhone'.
     */
    public void setUlIdPhone(int ulIdPhone)
    {
        this._ulIdPhone = ulIdPhone;
        this._has_ulIdPhone = true;
    } //-- void setUlIdPhone(int) 

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
     * Sets the value of field 'ulSysNbrUlongKey'.
     * 
     * @param ulSysNbrUlongKey the value of field 'ulSysNbrUlongKey'
     */
    public void setUlSysNbrUlongKey(int ulSysNbrUlongKey)
    {
        this._ulSysNbrUlongKey = ulSysNbrUlongKey;
        this._has_ulSysNbrUlongKey = true;
    } //-- void setUlSysNbrUlongKey(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct unmarshal(java.io.Reader) 

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
