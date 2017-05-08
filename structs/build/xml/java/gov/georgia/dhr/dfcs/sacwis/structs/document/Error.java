/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.document;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Error.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Error implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _errorCode
     */
    private java.lang.String _errorCode;

    /**
     * Field _displayMessage
     */
    private java.lang.String _displayMessage;


      //----------------/
     //- Constructors -/
    //----------------/

    public Error() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Error()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'displayMessage'.
     * 
     * @return the value of field 'DisplayMessage'.
     */
    public java.lang.String getDisplayMessage()
    {
        return this._displayMessage;
    } //-- java.lang.String getDisplayMessage() 

    /**
     * Returns the value of field 'errorCode'.
     * 
     * @return the value of field 'ErrorCode'.
     */
    public java.lang.String getErrorCode()
    {
        return this._errorCode;
    } //-- java.lang.String getErrorCode() 

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
     * Sets the value of field 'displayMessage'.
     * 
     * @param displayMessage the value of field 'displayMessage'.
     */
    public void setDisplayMessage(java.lang.String displayMessage)
    {
        this._displayMessage = displayMessage;
    } //-- void setDisplayMessage(java.lang.String) 

    /**
     * Sets the value of field 'errorCode'.
     * 
     * @param errorCode the value of field 'errorCode'.
     */
    public void setErrorCode(java.lang.String errorCode)
    {
        this._errorCode = errorCode;
    } //-- void setErrorCode(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.document.Error
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.document.Error unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.Error) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.document.Error.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Error unmarshal(java.io.Reader) 

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
