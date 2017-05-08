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
 * Class ApprvStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ApprvStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdApproval
     */
    private int _ulIdApproval;

    /**
     * keeps track of state for field: _ulIdApproval
     */
    private boolean _has_ulIdApproval;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szTxtApprovalTopic
     */
    private java.lang.String _szTxtApprovalTopic;


      //----------------/
     //- Constructors -/
    //----------------/

    public ApprvStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdApproval()
    {
        this._has_ulIdApproval= false;
    } //-- void deleteUlIdApproval() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     * Returns the value of field 'szTxtApprovalTopic'.
     * 
     * @return the value of field 'SzTxtApprovalTopic'.
     */
    public java.lang.String getSzTxtApprovalTopic()
    {
        return this._szTxtApprovalTopic;
    } //-- java.lang.String getSzTxtApprovalTopic() 

    /**
     * Returns the value of field 'ulIdApproval'.
     * 
     * @return the value of field 'UlIdApproval'.
     */
    public int getUlIdApproval()
    {
        return this._ulIdApproval;
    } //-- int getUlIdApproval() 

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
     * Method hasUlIdApproval
     * 
     * 
     * 
     * @return true if at least one UlIdApproval has been added
     */
    public boolean hasUlIdApproval()
    {
        return this._has_ulIdApproval;
    } //-- boolean hasUlIdApproval() 

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
     * Sets the value of field 'szTxtApprovalTopic'.
     * 
     * @param szTxtApprovalTopic the value of field
     * 'szTxtApprovalTopic'.
     */
    public void setSzTxtApprovalTopic(java.lang.String szTxtApprovalTopic)
    {
        this._szTxtApprovalTopic = szTxtApprovalTopic;
    } //-- void setSzTxtApprovalTopic(java.lang.String) 

    /**
     * Sets the value of field 'ulIdApproval'.
     * 
     * @param ulIdApproval the value of field 'ulIdApproval'.
     */
    public void setUlIdApproval(int ulIdApproval)
    {
        this._ulIdApproval = ulIdApproval;
        this._has_ulIdApproval = true;
    } //-- void setUlIdApproval(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ApprvStruct unmarshal(java.io.Reader) 

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
