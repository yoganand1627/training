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
 * Class CreatedStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CreatedStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdTodoPersCreator
     */
    private int _ulIdTodoPersCreator;

    /**
     * keeps track of state for field: _ulIdTodoPersCreator
     */
    private boolean _has_ulIdTodoPersCreator;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _dtDtTodoCreated
     */
    private org.exolab.castor.types.Date _dtDtTodoCreated;

    /**
     * Field _tmTmTodoCreated
     */
    private java.lang.String _tmTmTodoCreated;


      //----------------/
     //- Constructors -/
    //----------------/

    public CreatedStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CreatedStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdTodoPersCreator()
    {
        this._has_ulIdTodoPersCreator= false;
    } //-- void deleteUlIdTodoPersCreator() 

    /**
     * Returns the value of field 'dtDtTodoCreated'.
     * 
     * @return the value of field 'DtDtTodoCreated'.
     */
    public org.exolab.castor.types.Date getDtDtTodoCreated()
    {
        return this._dtDtTodoCreated;
    } //-- org.exolab.castor.types.Date getDtDtTodoCreated() 

    /**
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

    /**
     * Returns the value of field 'tmTmTodoCreated'.
     * 
     * @return the value of field 'TmTmTodoCreated'.
     */
    public java.lang.String getTmTmTodoCreated()
    {
        return this._tmTmTodoCreated;
    } //-- java.lang.String getTmTmTodoCreated() 

    /**
     * Returns the value of field 'ulIdTodoPersCreator'.
     * 
     * @return the value of field 'UlIdTodoPersCreator'.
     */
    public int getUlIdTodoPersCreator()
    {
        return this._ulIdTodoPersCreator;
    } //-- int getUlIdTodoPersCreator() 

    /**
     * Method hasUlIdTodoPersCreator
     * 
     * 
     * 
     * @return true if at least one UlIdTodoPersCreator has been
     * added
     */
    public boolean hasUlIdTodoPersCreator()
    {
        return this._has_ulIdTodoPersCreator;
    } //-- boolean hasUlIdTodoPersCreator() 

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
     * Sets the value of field 'dtDtTodoCreated'.
     * 
     * @param dtDtTodoCreated the value of field 'dtDtTodoCreated'.
     */
    public void setDtDtTodoCreated(org.exolab.castor.types.Date dtDtTodoCreated)
    {
        this._dtDtTodoCreated = dtDtTodoCreated;
    } //-- void setDtDtTodoCreated(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'tmTmTodoCreated'.
     * 
     * @param tmTmTodoCreated the value of field 'tmTmTodoCreated'.
     */
    public void setTmTmTodoCreated(java.lang.String tmTmTodoCreated)
    {
        this._tmTmTodoCreated = tmTmTodoCreated;
    } //-- void setTmTmTodoCreated(java.lang.String) 

    /**
     * Sets the value of field 'ulIdTodoPersCreator'.
     * 
     * @param ulIdTodoPersCreator the value of field
     * 'ulIdTodoPersCreator'.
     */
    public void setUlIdTodoPersCreator(int ulIdTodoPersCreator)
    {
        this._ulIdTodoPersCreator = ulIdTodoPersCreator;
        this._has_ulIdTodoPersCreator = true;
    } //-- void setUlIdTodoPersCreator(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CreatedStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CreatedStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CreatedStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CreatedStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CreatedStruct unmarshal(java.io.Reader) 

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
