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
 * Class PLAUDKeys.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PLAUDKeys extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _usSysNbrUshortAddrKey_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortAddrKey_ARRAY _usSysNbrUshortAddrKey_ARRAY;

    /**
     * Field _usSysNbrUshortPhoneKey_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortPhoneKey_ARRAY _usSysNbrUshortPhoneKey_ARRAY;

    /**
     * Field _usSysNbrUshortNameKey_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortNameKey_ARRAY _usSysNbrUshortNameKey_ARRAY;

    /**
     * Field _usSysNbrUshortIdKey_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortIdKey_ARRAY _usSysNbrUshortIdKey_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public PLAUDKeys() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PLAUDKeys()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'usSysNbrUshortAddrKey_ARRAY'.
     * 
     * @return the value of field 'UsSysNbrUshortAddrKey_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortAddrKey_ARRAY getUsSysNbrUshortAddrKey_ARRAY()
    {
        return this._usSysNbrUshortAddrKey_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortAddrKey_ARRAY getUsSysNbrUshortAddrKey_ARRAY() 

    /**
     * Returns the value of field 'usSysNbrUshortIdKey_ARRAY'.
     * 
     * @return the value of field 'UsSysNbrUshortIdKey_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortIdKey_ARRAY getUsSysNbrUshortIdKey_ARRAY()
    {
        return this._usSysNbrUshortIdKey_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortIdKey_ARRAY getUsSysNbrUshortIdKey_ARRAY() 

    /**
     * Returns the value of field 'usSysNbrUshortNameKey_ARRAY'.
     * 
     * @return the value of field 'UsSysNbrUshortNameKey_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortNameKey_ARRAY getUsSysNbrUshortNameKey_ARRAY()
    {
        return this._usSysNbrUshortNameKey_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortNameKey_ARRAY getUsSysNbrUshortNameKey_ARRAY() 

    /**
     * Returns the value of field 'usSysNbrUshortPhoneKey_ARRAY'.
     * 
     * @return the value of field 'UsSysNbrUshortPhoneKey_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortPhoneKey_ARRAY getUsSysNbrUshortPhoneKey_ARRAY()
    {
        return this._usSysNbrUshortPhoneKey_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortPhoneKey_ARRAY getUsSysNbrUshortPhoneKey_ARRAY() 

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
     * Sets the value of field 'usSysNbrUshortAddrKey_ARRAY'.
     * 
     * @param usSysNbrUshortAddrKey_ARRAY the value of field
     * 'usSysNbrUshortAddrKey_ARRAY'.
     */
    public void setUsSysNbrUshortAddrKey_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortAddrKey_ARRAY usSysNbrUshortAddrKey_ARRAY)
    {
        this._usSysNbrUshortAddrKey_ARRAY = usSysNbrUshortAddrKey_ARRAY;
    } //-- void setUsSysNbrUshortAddrKey_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortAddrKey_ARRAY) 

    /**
     * Sets the value of field 'usSysNbrUshortIdKey_ARRAY'.
     * 
     * @param usSysNbrUshortIdKey_ARRAY the value of field
     * 'usSysNbrUshortIdKey_ARRAY'.
     */
    public void setUsSysNbrUshortIdKey_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortIdKey_ARRAY usSysNbrUshortIdKey_ARRAY)
    {
        this._usSysNbrUshortIdKey_ARRAY = usSysNbrUshortIdKey_ARRAY;
    } //-- void setUsSysNbrUshortIdKey_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortIdKey_ARRAY) 

    /**
     * Sets the value of field 'usSysNbrUshortNameKey_ARRAY'.
     * 
     * @param usSysNbrUshortNameKey_ARRAY the value of field
     * 'usSysNbrUshortNameKey_ARRAY'.
     */
    public void setUsSysNbrUshortNameKey_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortNameKey_ARRAY usSysNbrUshortNameKey_ARRAY)
    {
        this._usSysNbrUshortNameKey_ARRAY = usSysNbrUshortNameKey_ARRAY;
    } //-- void setUsSysNbrUshortNameKey_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortNameKey_ARRAY) 

    /**
     * Sets the value of field 'usSysNbrUshortPhoneKey_ARRAY'.
     * 
     * @param usSysNbrUshortPhoneKey_ARRAY the value of field
     * 'usSysNbrUshortPhoneKey_ARRAY'.
     */
    public void setUsSysNbrUshortPhoneKey_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortPhoneKey_ARRAY usSysNbrUshortPhoneKey_ARRAY)
    {
        this._usSysNbrUshortPhoneKey_ARRAY = usSysNbrUshortPhoneKey_ARRAY;
    } //-- void setUsSysNbrUshortPhoneKey_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrUshortPhoneKey_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.PLAUDKeys
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.PLAUDKeys unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PLAUDKeys) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.PLAUDKeys.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PLAUDKeys unmarshal(java.io.Reader) 

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
