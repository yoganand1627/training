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
 * Class TodoCaseInfStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TodoCaseInfStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;

    /**
     * Field _ldIdTodo
     */
    private int _ldIdTodo;

    /**
     * keeps track of state for field: _ldIdTodo
     */
    private boolean _has_ldIdTodo;

    /**
     * Field _szCdUnitProgram
     */
    private java.lang.String _szCdUnitProgram;

    /**
     * Field _szCdUnitRegion
     */
    private java.lang.String _szCdUnitRegion;

    /**
     * Field _szNbrUnit
     */
    private java.lang.String _szNbrUnit;

    /**
     * Field _szCdCounty
     */
    private java.lang.String _szCdCounty;


      //----------------/
     //- Constructors -/
    //----------------/

    public TodoCaseInfStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.TodoCaseInfStruct()


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
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

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
     * Returns the value of field 'szCdCounty'.
     * 
     * @return the value of field 'SzCdCounty'.
     */
    public java.lang.String getSzCdCounty()
    {
        return this._szCdCounty;
    } //-- java.lang.String getSzCdCounty() 

    /**
     * Returns the value of field 'szCdTask'.
     * 
     * @return the value of field 'SzCdTask'.
     */
    public java.lang.String getSzCdTask()
    {
        return this._szCdTask;
    } //-- java.lang.String getSzCdTask() 

    /**
     * Returns the value of field 'szCdUnitProgram'.
     * 
     * @return the value of field 'SzCdUnitProgram'.
     */
    public java.lang.String getSzCdUnitProgram()
    {
        return this._szCdUnitProgram;
    } //-- java.lang.String getSzCdUnitProgram() 

    /**
     * Returns the value of field 'szCdUnitRegion'.
     * 
     * @return the value of field 'SzCdUnitRegion'.
     */
    public java.lang.String getSzCdUnitRegion()
    {
        return this._szCdUnitRegion;
    } //-- java.lang.String getSzCdUnitRegion() 

    /**
     * Returns the value of field 'szNbrUnit'.
     * 
     * @return the value of field 'SzNbrUnit'.
     */
    public java.lang.String getSzNbrUnit()
    {
        return this._szNbrUnit;
    } //-- java.lang.String getSzNbrUnit() 

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
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

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
     * Sets the value of field 'szCdCounty'.
     * 
     * @param szCdCounty the value of field 'szCdCounty'.
     */
    public void setSzCdCounty(java.lang.String szCdCounty)
    {
        this._szCdCounty = szCdCounty;
    } //-- void setSzCdCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdTask'.
     * 
     * @param szCdTask the value of field 'szCdTask'.
     */
    public void setSzCdTask(java.lang.String szCdTask)
    {
        this._szCdTask = szCdTask;
    } //-- void setSzCdTask(java.lang.String) 

    /**
     * Sets the value of field 'szCdUnitProgram'.
     * 
     * @param szCdUnitProgram the value of field 'szCdUnitProgram'.
     */
    public void setSzCdUnitProgram(java.lang.String szCdUnitProgram)
    {
        this._szCdUnitProgram = szCdUnitProgram;
    } //-- void setSzCdUnitProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdUnitRegion'.
     * 
     * @param szCdUnitRegion the value of field 'szCdUnitRegion'.
     */
    public void setSzCdUnitRegion(java.lang.String szCdUnitRegion)
    {
        this._szCdUnitRegion = szCdUnitRegion;
    } //-- void setSzCdUnitRegion(java.lang.String) 

    /**
     * Sets the value of field 'szNbrUnit'.
     * 
     * @param szNbrUnit the value of field 'szNbrUnit'.
     */
    public void setSzNbrUnit(java.lang.String szNbrUnit)
    {
        this._szNbrUnit = szNbrUnit;
    } //-- void setSzNbrUnit(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.TodoCaseInfStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.TodoCaseInfStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.TodoCaseInfStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.TodoCaseInfStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.TodoCaseInfStruct unmarshal(java.io.Reader) 

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
