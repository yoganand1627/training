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
 * Class ROWCARC14SOG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCARC14SOG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmSecurityClass
     */
    private java.lang.String _szNmSecurityClass;

    /**
     * Field _cIndRestrict
     */
    private java.lang.String _cIndRestrict;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCARC14SOG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'cIndRestrict'.
     * 
     * @return the value of field 'CIndRestrict'.
     */
    public java.lang.String getCIndRestrict()
    {
        return this._cIndRestrict;
    } //-- java.lang.String getCIndRestrict() 

    /**
     * Returns the value of field 'szNmSecurityClass'.
     * 
     * @return the value of field 'SzNmSecurityClass'.
     */
    public java.lang.String getSzNmSecurityClass()
    {
        return this._szNmSecurityClass;
    } //-- java.lang.String getSzNmSecurityClass() 

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
     * Sets the value of field 'cIndRestrict'.
     * 
     * @param cIndRestrict the value of field 'cIndRestrict'.
     */
    public void setCIndRestrict(java.lang.String cIndRestrict)
    {
        this._cIndRestrict = cIndRestrict;
    } //-- void setCIndRestrict(java.lang.String) 

    /**
     * Sets the value of field 'szNmSecurityClass'.
     * 
     * @param szNmSecurityClass the value of field
     * 'szNmSecurityClass'.
     */
    public void setSzNmSecurityClass(java.lang.String szNmSecurityClass)
    {
        this._szNmSecurityClass = szNmSecurityClass;
    } //-- void setSzNmSecurityClass(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01 unmarshal(java.io.Reader) 

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
