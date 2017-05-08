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
 * Class ContactCbxDisplay.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ContactCbxDisplay extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdCbxCodeType
     */
    private java.lang.String _szCdCbxCodeType;

    /**
     * Field _szCdContactCbx
     */
    private java.lang.String _szCdContactCbx;


      //----------------/
     //- Constructors -/
    //----------------/

    public ContactCbxDisplay() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'szCdCbxCodeType'.
     * 
     * @return the value of field 'SzCdCbxCodeType'.
     */
    public java.lang.String getSzCdCbxCodeType()
    {
        return this._szCdCbxCodeType;
    } //-- java.lang.String getSzCdCbxCodeType() 

    /**
     * Returns the value of field 'szCdContactCbx'.
     * 
     * @return the value of field 'SzCdContactCbx'.
     */
    public java.lang.String getSzCdContactCbx()
    {
        return this._szCdContactCbx;
    } //-- java.lang.String getSzCdContactCbx() 

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
     * Sets the value of field 'szCdCbxCodeType'.
     * 
     * @param szCdCbxCodeType the value of field 'szCdCbxCodeType'.
     */
    public void setSzCdCbxCodeType(java.lang.String szCdCbxCodeType)
    {
        this._szCdCbxCodeType = szCdCbxCodeType;
    } //-- void setSzCdCbxCodeType(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactCbx'.
     * 
     * @param szCdContactCbx the value of field 'szCdContactCbx'.
     */
    public void setSzCdContactCbx(java.lang.String szCdContactCbx)
    {
        this._szCdContactCbx = szCdContactCbx;
    } //-- void setSzCdContactCbx(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay unmarshal(java.io.Reader) 

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
