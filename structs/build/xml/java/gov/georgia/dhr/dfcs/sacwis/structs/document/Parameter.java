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
 * Class Parameter.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Parameter implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
     */
    private java.lang.String _content = "";

    /**
     * Field _type
     */
    private java.lang.String _type;

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _setMethod
     */
    private java.lang.String _setMethod;

    /**
     * Field _requestName
     */
    private java.lang.String _requestName;

    /**
     * Field _format
     */
    private java.lang.String _format;

    /**
     * Field _state
     */
    private boolean _state;

    /**
     * keeps track of state for field: _state
     */
    private boolean _has_state;


      //----------------/
     //- Constructors -/
    //----------------/

    public Parameter() 
     {
        super();
        setContent("");
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteState()
    {
        this._has_state= false;
    } //-- void deleteState() 

    /**
     * Returns the value of field 'content'. The field 'content'
     * has the following description: internal content storage
     * 
     * @return the value of field 'Content'.
     */
    public java.lang.String getContent()
    {
        return this._content;
    } //-- java.lang.String getContent() 

    /**
     * Returns the value of field 'format'.
     * 
     * @return the value of field 'Format'.
     */
    public java.lang.String getFormat()
    {
        return this._format;
    } //-- java.lang.String getFormat() 

    /**
     * Returns the value of field 'name'.
     * 
     * @return the value of field 'Name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field 'requestName'.
     * 
     * @return the value of field 'RequestName'.
     */
    public java.lang.String getRequestName()
    {
        return this._requestName;
    } //-- java.lang.String getRequestName() 

    /**
     * Returns the value of field 'setMethod'.
     * 
     * @return the value of field 'SetMethod'.
     */
    public java.lang.String getSetMethod()
    {
        return this._setMethod;
    } //-- java.lang.String getSetMethod() 

    /**
     * Returns the value of field 'state'.
     * 
     * @return the value of field 'State'.
     */
    public boolean getState()
    {
        return this._state;
    } //-- boolean getState() 

    /**
     * Returns the value of field 'type'.
     * 
     * @return the value of field 'Type'.
     */
    public java.lang.String getType()
    {
        return this._type;
    } //-- java.lang.String getType() 

    /**
     * Method hasState
     * 
     * 
     * 
     * @return true if at least one State has been added
     */
    public boolean hasState()
    {
        return this._has_state;
    } //-- boolean hasState() 

    /**
     * Returns the value of field 'state'.
     * 
     * @return the value of field 'State'.
     */
    public boolean isState()
    {
        return this._state;
    } //-- boolean isState() 

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
     * Sets the value of field 'content'. The field 'content' has
     * the following description: internal content storage
     * 
     * @param content the value of field 'content'.
     */
    public void setContent(java.lang.String content)
    {
        this._content = content;
    } //-- void setContent(java.lang.String) 

    /**
     * Sets the value of field 'format'.
     * 
     * @param format the value of field 'format'.
     */
    public void setFormat(java.lang.String format)
    {
        this._format = format;
    } //-- void setFormat(java.lang.String) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'requestName'.
     * 
     * @param requestName the value of field 'requestName'.
     */
    public void setRequestName(java.lang.String requestName)
    {
        this._requestName = requestName;
    } //-- void setRequestName(java.lang.String) 

    /**
     * Sets the value of field 'setMethod'.
     * 
     * @param setMethod the value of field 'setMethod'.
     */
    public void setSetMethod(java.lang.String setMethod)
    {
        this._setMethod = setMethod;
    } //-- void setSetMethod(java.lang.String) 

    /**
     * Sets the value of field 'state'.
     * 
     * @param state the value of field 'state'.
     */
    public void setState(boolean state)
    {
        this._state = state;
        this._has_state = true;
    } //-- void setState(boolean) 

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(java.lang.String type)
    {
        this._type = type;
    } //-- void setType(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter unmarshal(java.io.Reader) 

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
