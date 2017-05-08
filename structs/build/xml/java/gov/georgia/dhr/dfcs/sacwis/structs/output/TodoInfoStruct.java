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
 * Class TodoInfoStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TodoInfoStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdTodoType
     */
    private java.lang.String _szCdTodoType;

    /**
     * Field _ldIdTodo
     */
    private int _ldIdTodo;

    /**
     * keeps track of state for field: _ldIdTodo
     */
    private boolean _has_ldIdTodo;

    /**
     * Field _dtDtTodoDue
     */
    private org.exolab.castor.types.Date _dtDtTodoDue;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _dtDtTodoCompleted
     */
    private org.exolab.castor.types.Date _dtDtTodoCompleted;

    /**
     * Field _szTxtTodoDesc
     */
    private java.lang.String _szTxtTodoDesc;

    /**
     * Field _txtTodoLongDesc
     */
    private java.lang.String _txtTodoLongDesc;


      //----------------/
     //- Constructors -/
    //----------------/

    public TodoInfoStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TodoInfoStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLdIdTodo()
    {
        this._has_ldIdTodo= false;
    } //-- void deleteLdIdTodo() 

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     * Returns the value of field 'dtDtTodoCompleted'.
     * 
     * @return the value of field 'DtDtTodoCompleted'.
     */
    public org.exolab.castor.types.Date getDtDtTodoCompleted()
    {
        return this._dtDtTodoCompleted;
    } //-- org.exolab.castor.types.Date getDtDtTodoCompleted() 

    /**
     * Returns the value of field 'dtDtTodoDue'.
     * 
     * @return the value of field 'DtDtTodoDue'.
     */
    public org.exolab.castor.types.Date getDtDtTodoDue()
    {
        return this._dtDtTodoDue;
    } //-- org.exolab.castor.types.Date getDtDtTodoDue() 

    /**
     * Returns the value of field 'ldIdTodo'.
     * 
     * @return the value of field 'LdIdTodo'.
     */
    public int getLdIdTodo()
    {
        return this._ldIdTodo;
    } //-- int getLdIdTodo() 

    /**
     * Returns the value of field 'szCdTodoType'.
     * 
     * @return the value of field 'SzCdTodoType'.
     */
    public java.lang.String getSzCdTodoType()
    {
        return this._szCdTodoType;
    } //-- java.lang.String getSzCdTodoType() 

    /**
     * Returns the value of field 'szTxtTodoDesc'.
     * 
     * @return the value of field 'SzTxtTodoDesc'.
     */
    public java.lang.String getSzTxtTodoDesc()
    {
        return this._szTxtTodoDesc;
    } //-- java.lang.String getSzTxtTodoDesc() 

    /**
     * Returns the value of field 'txtTodoLongDesc'.
     * 
     * @return the value of field 'TxtTodoLongDesc'.
     */
    public java.lang.String getTxtTodoLongDesc()
    {
        return this._txtTodoLongDesc;
    } //-- java.lang.String getTxtTodoLongDesc() 

    /**
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

    /**
     * Returns the value of field 'ulIdEvent'.
     * 
     * @return the value of field 'UlIdEvent'.
     */
    public int getUlIdEvent()
    {
        return this._ulIdEvent;
    } //-- int getUlIdEvent() 

    /**
     * Method hasLdIdTodo
     * 
     * 
     * 
     * @return true if at least one LdIdTodo has been added
     */
    public boolean hasLdIdTodo()
    {
        return this._has_ldIdTodo;
    } //-- boolean hasLdIdTodo() 

    /**
     * Method hasUlIdCase
     * 
     * 
     * 
     * @return true if at least one UlIdCase has been added
     */
    public boolean hasUlIdCase()
    {
        return this._has_ulIdCase;
    } //-- boolean hasUlIdCase() 

    /**
     * Method hasUlIdEvent
     * 
     * 
     * 
     * @return true if at least one UlIdEvent has been added
     */
    public boolean hasUlIdEvent()
    {
        return this._has_ulIdEvent;
    } //-- boolean hasUlIdEvent() 

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
     * Sets the value of field 'dtDtTodoCompleted'.
     * 
     * @param dtDtTodoCompleted the value of field
     * 'dtDtTodoCompleted'.
     */
    public void setDtDtTodoCompleted(org.exolab.castor.types.Date dtDtTodoCompleted)
    {
        this._dtDtTodoCompleted = dtDtTodoCompleted;
    } //-- void setDtDtTodoCompleted(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtTodoDue'.
     * 
     * @param dtDtTodoDue the value of field 'dtDtTodoDue'.
     */
    public void setDtDtTodoDue(org.exolab.castor.types.Date dtDtTodoDue)
    {
        this._dtDtTodoDue = dtDtTodoDue;
    } //-- void setDtDtTodoDue(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ldIdTodo'.
     * 
     * @param ldIdTodo the value of field 'ldIdTodo'.
     */
    public void setLdIdTodo(int ldIdTodo)
    {
        this._ldIdTodo = ldIdTodo;
        this._has_ldIdTodo = true;
    } //-- void setLdIdTodo(int) 

    /**
     * Sets the value of field 'szCdTodoType'.
     * 
     * @param szCdTodoType the value of field 'szCdTodoType'.
     */
    public void setSzCdTodoType(java.lang.String szCdTodoType)
    {
        this._szCdTodoType = szCdTodoType;
    } //-- void setSzCdTodoType(java.lang.String) 

    /**
     * Sets the value of field 'szTxtTodoDesc'.
     * 
     * @param szTxtTodoDesc the value of field 'szTxtTodoDesc'.
     */
    public void setSzTxtTodoDesc(java.lang.String szTxtTodoDesc)
    {
        this._szTxtTodoDesc = szTxtTodoDesc;
    } //-- void setSzTxtTodoDesc(java.lang.String) 

    /**
     * Sets the value of field 'txtTodoLongDesc'.
     * 
     * @param txtTodoLongDesc the value of field 'txtTodoLongDesc'.
     */
    public void setTxtTodoLongDesc(java.lang.String txtTodoLongDesc)
    {
        this._txtTodoLongDesc = txtTodoLongDesc;
    } //-- void setTxtTodoLongDesc(java.lang.String) 

    /**
     * Sets the value of field 'ulIdCase'.
     * 
     * @param ulIdCase the value of field 'ulIdCase'.
     */
    public void setUlIdCase(int ulIdCase)
    {
        this._ulIdCase = ulIdCase;
        this._has_ulIdCase = true;
    } //-- void setUlIdCase(int) 

    /**
     * Sets the value of field 'ulIdEvent'.
     * 
     * @param ulIdEvent the value of field 'ulIdEvent'.
     */
    public void setUlIdEvent(int ulIdEvent)
    {
        this._ulIdEvent = ulIdEvent;
        this._has_ulIdEvent = true;
    } //-- void setUlIdEvent(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.TodoInfoStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.TodoInfoStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.TodoInfoStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.TodoInfoStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TodoInfoStruct unmarshal(java.io.Reader) 

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
